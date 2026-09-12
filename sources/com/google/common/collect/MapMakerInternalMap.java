package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.collect.MapMakerInternalMap.h;
import com.google.common.primitives.Ints;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class MapMakerInternalMap<K, V, E extends h, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final u UNSET_WEAK_VALUE_REFERENCE = new a();
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient i entryHelper;
    transient Set<Map.Entry<K, V>> entrySet;
    final Equivalence keyEquivalence;
    transient Set<K> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment<K, V, E, S>[] segments;
    transient Collection<V> values;

    /* loaded from: classes4.dex */
    static abstract class AbstractSerializationProxy<K, V> extends l2 implements Serializable {
        private static final long serialVersionUID = 3;
        final int concurrencyLevel;
        transient ConcurrentMap<K, V> delegate;
        final Equivalence keyEquivalence;
        final Strength keyStrength;
        final Equivalence valueEquivalence;
        final Strength valueStrength;

        AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence equivalence, Equivalence equivalence2, int i11, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.concurrencyLevel = i11;
            this.delegate = concurrentMap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.n2, com.google.common.collect.q2
        /* renamed from: delegate */
        public ConcurrentMap<K, V> l() {
            return this.delegate;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void readEntries(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject == null) {
                    return;
                }
                this.delegate.put(readObject, objectInputStream.readObject());
            }
        }

        MapMaker readMapMaker(ObjectInputStream objectInputStream) throws IOException {
            return new MapMaker().g(objectInputStream.readInt()).j(this.keyStrength).k(this.valueStrength).h(this.keyEquivalence).a(this.concurrencyLevel);
        }

        void writeMapTo(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.delegate.size());
            for (Map.Entry<K, V> entry : this.delegate.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }
    }

    /* loaded from: classes4.dex */
    static final class CleanupMapTask implements Runnable {
        final WeakReference<MapMakerInternalMap<?, ?, ?, ?>> mapReference;

        public CleanupMapTask(MapMakerInternalMap<?, ?, ?, ?> mapMakerInternalMap) {
            this.mapReference = new WeakReference<>(mapMakerInternalMap);
        }

        @Override // java.lang.Runnable
        public void run() {
            MapMakerInternalMap<?, ?, ?, ?> mapMakerInternalMap = this.mapReference.get();
            if (mapMakerInternalMap == null) {
                throw new CancellationException();
            }
            for (Segment<?, ?, ?, ?> segment : mapMakerInternalMap.segments) {
                segment.runCleanup();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static abstract class Segment<K, V, E extends h, S extends Segment<K, V, E, S>> extends ReentrantLock {
        volatile int count;
        final MapMakerInternalMap<K, V, E, S> map;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        volatile AtomicReferenceArray<E> table;
        int threshold;

        Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i11) {
            this.map = mapMakerInternalMap;
            initTable(newEntryArray(i11));
        }

        static <K, V, E extends h> boolean isCollected(E e11) {
            return e11.getValue() == null;
        }

        abstract E castForTesting(h hVar);

        void clear() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    for (int i11 = 0; i11 < atomicReferenceArray.length(); i11++) {
                        atomicReferenceArray.set(i11, null);
                    }
                    maybeClearReferenceQueues();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                    unlock();
                } catch (Throwable th2) {
                    unlock();
                    throw th2;
                }
            }
        }

        <T> void clearReferenceQueue(ReferenceQueue<T> referenceQueue) {
            do {
            } while (referenceQueue.poll() != null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean clearValueForTesting(K k11, int i11, u uVar) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.k()) {
                    Object key = hVar2.getKey();
                    if (hVar2.b() == i11 && key != null && this.map.keyEquivalence.equivalent(k11, key)) {
                        if (((t) hVar2).a() != uVar) {
                            return false;
                        }
                        atomicReferenceArray.set(length, removeFromChain(hVar, hVar2));
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        boolean containsKey(Object obj, int i11) {
            try {
                boolean z10 = false;
                if (this.count == 0) {
                    return false;
                }
                E liveEntry = getLiveEntry(obj, i11);
                if (liveEntry != null) {
                    if (liveEntry.getValue() != null) {
                        z10 = true;
                    }
                }
                return z10;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i11 = 0; i11 < length; i11++) {
                        for (E e11 = atomicReferenceArray.get(i11); e11 != null; e11 = e11.k()) {
                            Object liveValue = getLiveValue(e11);
                            if (liveValue != null && this.map.valueEquivalence().equivalent(obj, liveValue)) {
                                postReadCleanup();
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        E copyEntry(E e11, E e12) {
            return (E) this.map.entryHelper.b(self(), e11, e12);
        }

        E copyForTesting(h hVar, h hVar2) {
            return (E) this.map.entryHelper.b(self(), castForTesting(hVar), castForTesting(hVar2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drainKeyReferenceQueue(ReferenceQueue<K> referenceQueue) {
            int i11 = 0;
            do {
                Reference<? extends K> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimKey((h) poll);
                i11++;
            } while (i11 != 16);
        }

        void drainValueReferenceQueue(ReferenceQueue<V> referenceQueue) {
            int i11 = 0;
            do {
                Reference<? extends V> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimValue((u) poll);
                i11++;
            } while (i11 != 16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void expand() {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i11 = this.count;
            SpscArrayQueue spscArrayQueue = (AtomicReferenceArray<E>) newEntryArray(length << 1);
            this.threshold = (spscArrayQueue.length() * 3) / 4;
            int length2 = spscArrayQueue.length() - 1;
            for (int i12 = 0; i12 < length; i12++) {
                E e11 = atomicReferenceArray.get(i12);
                if (e11 != null) {
                    h k11 = e11.k();
                    int b11 = e11.b() & length2;
                    if (k11 == null) {
                        spscArrayQueue.set(b11, e11);
                    } else {
                        h hVar = e11;
                        while (k11 != null) {
                            int b12 = k11.b() & length2;
                            if (b12 != b11) {
                                hVar = k11;
                                b11 = b12;
                            }
                            k11 = k11.k();
                        }
                        spscArrayQueue.set(b11, hVar);
                        while (e11 != hVar) {
                            int b13 = e11.b() & length2;
                            h copyEntry = copyEntry(e11, (h) spscArrayQueue.get(b13));
                            if (copyEntry != null) {
                                spscArrayQueue.set(b13, copyEntry);
                            } else {
                                i11--;
                            }
                            e11 = e11.k();
                        }
                    }
                }
            }
            this.table = spscArrayQueue;
            this.count = i11;
        }

        V get(Object obj, int i11) {
            try {
                E liveEntry = getLiveEntry(obj, i11);
                if (liveEntry == null) {
                    postReadCleanup();
                    return null;
                }
                V v11 = (V) liveEntry.getValue();
                if (v11 == null) {
                    tryDrainReferenceQueues();
                }
                return v11;
            } finally {
                postReadCleanup();
            }
        }

        E getEntry(Object obj, int i11) {
            if (this.count == 0) {
                return null;
            }
            for (E first = getFirst(i11); first != null; first = (E) first.k()) {
                if (first.b() == i11) {
                    Object key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        E getFirst(int i11) {
            return this.table.get(i11 & (r0.length() - 1));
        }

        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        E getLiveEntry(Object obj, int i11) {
            return getEntry(obj, i11);
        }

        V getLiveValue(E e11) {
            if (e11.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v11 = (V) e11.getValue();
            if (v11 != null) {
                return v11;
            }
            tryDrainReferenceQueues();
            return null;
        }

        V getLiveValueForTesting(h hVar) {
            return getLiveValue(castForTesting(hVar));
        }

        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        u getWeakValueReferenceForTesting(h hVar) {
            throw new AssertionError();
        }

        void initTable(AtomicReferenceArray<E> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            this.table = atomicReferenceArray;
        }

        void maybeClearReferenceQueues() {
        }

        void maybeDrainReferenceQueues() {
        }

        AtomicReferenceArray<E> newEntryArray(int i11) {
            return new AtomicReferenceArray<>(i11);
        }

        E newEntryForTesting(K k11, int i11, h hVar) {
            return (E) this.map.entryHelper.e(self(), k11, i11, castForTesting(hVar));
        }

        u newWeakValueReferenceForTesting(h hVar, V v11) {
            throw new AssertionError();
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & MapMakerInternalMap.DRAIN_THRESHOLD) == 0) {
                runCleanup();
            }
        }

        void preWriteCleanup() {
            runLockedCleanup();
        }

        /* JADX WARN: Multi-variable type inference failed */
        V put(K k11, int i11, V v11, boolean z10) {
            lock();
            try {
                preWriteCleanup();
                int i12 = this.count + 1;
                if (i12 > this.threshold) {
                    expand();
                    i12 = this.count + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.k()) {
                    Object key = hVar2.getKey();
                    if (hVar2.b() == i11 && key != null && this.map.keyEquivalence.equivalent(k11, key)) {
                        V v12 = (V) hVar2.getValue();
                        if (v12 == null) {
                            this.modCount++;
                            setValue(hVar2, v11);
                            this.count = this.count;
                            unlock();
                            return null;
                        }
                        if (z10) {
                            unlock();
                            return v12;
                        }
                        this.modCount++;
                        setValue(hVar2, v11);
                        unlock();
                        return v12;
                    }
                }
                this.modCount++;
                h e11 = this.map.entryHelper.e(self(), k11, i11, hVar);
                setValue(e11, v11);
                atomicReferenceArray.set(length, e11);
                this.count = i12;
                unlock();
                return null;
            } catch (Throwable th2) {
                unlock();
                throw th2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean reclaimKey(E e11, int i11) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = i11 & (atomicReferenceArray.length() - 1);
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.k()) {
                    if (hVar2 == e11) {
                        this.modCount++;
                        h removeFromChain = removeFromChain(hVar, hVar2);
                        int i12 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i12;
                        return true;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean reclaimValue(K k11, int i11, u uVar) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.k()) {
                    Object key = hVar2.getKey();
                    if (hVar2.b() == i11 && key != null && this.map.keyEquivalence.equivalent(k11, key)) {
                        if (((t) hVar2).a() != uVar) {
                            return false;
                        }
                        this.modCount++;
                        h removeFromChain = removeFromChain(hVar, hVar2);
                        int i12 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i12;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        V remove(Object obj, int i11) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.k()) {
                    Object key = hVar2.getKey();
                    if (hVar2.b() == i11 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        V v11 = (V) hVar2.getValue();
                        if (v11 == null && !isCollected(hVar2)) {
                            return null;
                        }
                        this.modCount++;
                        h removeFromChain = removeFromChain(hVar, hVar2);
                        int i12 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i12;
                        return v11;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        
            if (r8.map.valueEquivalence().equivalent(r11, r4.getValue()) == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
        
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        
            r8.modCount++;
            r9 = removeFromChain(r3, r4);
            r10 = r8.count - 1;
            r0.set(r1, r9);
            r8.count = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
        
            if (isCollected(r4) == false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
        
            return false;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        boolean remove(java.lang.Object r9, int r10, java.lang.Object r11) {
            /*
                r8 = this;
                r8.lock()
                r8.preWriteCleanup()     // Catch: java.lang.Throwable -> L5c
                java.util.concurrent.atomic.AtomicReferenceArray<E extends com.google.common.collect.MapMakerInternalMap$h> r0 = r8.table     // Catch: java.lang.Throwable -> L5c
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L5c
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r10
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L5c
                com.google.common.collect.MapMakerInternalMap$h r3 = (com.google.common.collect.MapMakerInternalMap.h) r3     // Catch: java.lang.Throwable -> L5c
                r4 = r3
            L16:
                r5 = 0
                if (r4 == 0) goto L67
                java.lang.Object r6 = r4.getKey()     // Catch: java.lang.Throwable -> L5c
                int r7 = r4.b()     // Catch: java.lang.Throwable -> L5c
                if (r7 != r10) goto L62
                if (r6 == 0) goto L62
                com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$h, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r7 = r8.map     // Catch: java.lang.Throwable -> L5c
                com.google.common.base.Equivalence r7 = r7.keyEquivalence     // Catch: java.lang.Throwable -> L5c
                boolean r6 = r7.equivalent(r9, r6)     // Catch: java.lang.Throwable -> L5c
                if (r6 == 0) goto L62
                java.lang.Object r9 = r4.getValue()     // Catch: java.lang.Throwable -> L5c
                com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$h, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r10 = r8.map     // Catch: java.lang.Throwable -> L5c
                com.google.common.base.Equivalence r10 = r10.valueEquivalence()     // Catch: java.lang.Throwable -> L5c
                boolean r9 = r10.equivalent(r11, r9)     // Catch: java.lang.Throwable -> L5c
                if (r9 == 0) goto L41
                r5 = r2
                goto L47
            L41:
                boolean r9 = isCollected(r4)     // Catch: java.lang.Throwable -> L5c
                if (r9 == 0) goto L5e
            L47:
                int r9 = r8.modCount     // Catch: java.lang.Throwable -> L5c
                int r9 = r9 + r2
                r8.modCount = r9     // Catch: java.lang.Throwable -> L5c
                com.google.common.collect.MapMakerInternalMap$h r9 = r8.removeFromChain(r3, r4)     // Catch: java.lang.Throwable -> L5c
                int r10 = r8.count     // Catch: java.lang.Throwable -> L5c
                int r10 = r10 - r2
                r0.set(r1, r9)     // Catch: java.lang.Throwable -> L5c
                r8.count = r10     // Catch: java.lang.Throwable -> L5c
                r8.unlock()
                return r5
            L5c:
                r9 = move-exception
                goto L6b
            L5e:
                r8.unlock()
                return r5
            L62:
                com.google.common.collect.MapMakerInternalMap$h r4 = r4.k()     // Catch: java.lang.Throwable -> L5c
                goto L16
            L67:
                r8.unlock()
                return r5
            L6b:
                r8.unlock()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.remove(java.lang.Object, int, java.lang.Object):boolean");
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean removeEntryForTesting(E e11) {
            int b11 = e11.b();
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = b11 & (atomicReferenceArray.length() - 1);
            h hVar = (h) atomicReferenceArray.get(length);
            for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.k()) {
                if (hVar2 == e11) {
                    this.modCount++;
                    h removeFromChain = removeFromChain(hVar, hVar2);
                    int i11 = this.count - 1;
                    atomicReferenceArray.set(length, removeFromChain);
                    this.count = i11;
                    return true;
                }
            }
            return false;
        }

        E removeFromChain(E e11, E e12) {
            int i11 = this.count;
            E e13 = (E) e12.k();
            while (e11 != e12) {
                E copyEntry = copyEntry(e11, e13);
                if (copyEntry != null) {
                    e13 = copyEntry;
                } else {
                    i11--;
                }
                e11 = (E) e11.k();
            }
            this.count = i11;
            return e13;
        }

        E removeFromChainForTesting(h hVar, h hVar2) {
            return removeFromChain(castForTesting(hVar), castForTesting(hVar2));
        }

        boolean removeTableEntryForTesting(h hVar) {
            return removeEntryForTesting(castForTesting(hVar));
        }

        /* JADX WARN: Multi-variable type inference failed */
        V replace(K k11, int i11, V v11) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.k()) {
                    Object key = hVar2.getKey();
                    if (hVar2.b() == i11 && key != null && this.map.keyEquivalence.equivalent(k11, key)) {
                        V v12 = (V) hVar2.getValue();
                        if (v12 != null) {
                            this.modCount++;
                            setValue(hVar2, v11);
                            return v12;
                        }
                        if (isCollected(hVar2)) {
                            this.modCount++;
                            h removeFromChain = removeFromChain(hVar, hVar2);
                            int i12 = this.count - 1;
                            atomicReferenceArray.set(length, removeFromChain);
                            this.count = i12;
                        }
                        return null;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean replace(K k11, int i11, V v11, V v12) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.k()) {
                    Object key = hVar2.getKey();
                    if (hVar2.b() == i11 && key != null && this.map.keyEquivalence.equivalent(k11, key)) {
                        Object value = hVar2.getValue();
                        if (value != null) {
                            if (!this.map.valueEquivalence().equivalent(v11, value)) {
                                return false;
                            }
                            this.modCount++;
                            setValue(hVar2, v12);
                            return true;
                        }
                        if (isCollected(hVar2)) {
                            this.modCount++;
                            h removeFromChain = removeFromChain(hVar, hVar2);
                            int i12 = this.count - 1;
                            atomicReferenceArray.set(length, removeFromChain);
                            this.count = i12;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        void runCleanup() {
            runLockedCleanup();
        }

        void runLockedCleanup() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        abstract S self();

        void setTableEntryForTesting(int i11, h hVar) {
            this.table.set(i11, castForTesting(hVar));
        }

        void setValue(E e11, V v11) {
            this.map.entryHelper.d(self(), e11, v11);
        }

        void setValueForTesting(h hVar, V v11) {
            this.map.entryHelper.d(self(), castForTesting(hVar), v11);
        }

        void setWeakValueReferenceForTesting(h hVar, u uVar) {
            throw new AssertionError();
        }

        void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    private static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        SerializationProxy(Strength strength, Strength strength2, Equivalence equivalence, Equivalence equivalence2, int i11, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, i11, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).i();
            readEntries(objectInputStream);
        }

        private Object readResolve() {
            return this.delegate;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public enum Strength {
        STRONG { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            Equivalence defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        WEAK { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            Equivalence defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        /* synthetic */ Strength(a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Equivalence defaultEquivalence();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, l, StrongKeyDummyValueSegment<K>> {
        StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, l, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i11) {
            super(mapMakerInternalMap, i11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public l castForTesting(h hVar) {
            return (l) hVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyDummyValueSegment<K> self() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, m, StrongKeyStrongValueSegment<K, V>> {
        StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, m, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i11) {
            super(mapMakerInternalMap, i11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public m castForTesting(h hVar) {
            return (m) hVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyStrongValueSegment<K, V> self() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, n, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> queueForValues;

        StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, n, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i11) {
            super(mapMakerInternalMap, i11);
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public n castForTesting(h hVar) {
            return (n) hVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public u getWeakValueReferenceForTesting(h hVar) {
            return castForTesting(hVar).a();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public u newWeakValueReferenceForTesting(h hVar, V v11) {
            return new v(this.queueForValues, v11, castForTesting(hVar));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(h hVar, u uVar) {
            n castForTesting = castForTesting(hVar);
            u uVar2 = castForTesting.f30620c;
            castForTesting.f30620c = uVar;
            uVar2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, q, WeakKeyDummyValueSegment<K>> {
        private final ReferenceQueue<K> queueForKeys;

        WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, q, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i11) {
            super(mapMakerInternalMap, i11);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public q castForTesting(h hVar) {
            return (q) hVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyDummyValueSegment<K> self() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, r, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;

        WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, r, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i11) {
            super(mapMakerInternalMap, i11);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public r castForTesting(h hVar) {
            return (r) hVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyStrongValueSegment<K, V> self() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, s, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;

        WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, s, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i11) {
            super(mapMakerInternalMap, i11);
            this.queueForKeys = new ReferenceQueue<>();
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public s castForTesting(h hVar) {
            return (s) hVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public u getWeakValueReferenceForTesting(h hVar) {
            return castForTesting(hVar).a();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public u newWeakValueReferenceForTesting(h hVar, V v11) {
            return new v(this.queueForValues, v11, castForTesting(hVar));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(h hVar, u uVar) {
            s castForTesting = castForTesting(hVar);
            u uVar2 = castForTesting.f30630b;
            castForTesting.f30630b = uVar;
            uVar2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements u {
        a() {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public /* bridge */ /* synthetic */ h a() {
            d();
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public /* bridge */ /* synthetic */ u b(ReferenceQueue referenceQueue, h hVar) {
            android.support.v4.media.session.c.a(hVar);
            return c(referenceQueue, null);
        }

        public u c(ReferenceQueue referenceQueue, d dVar) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public void clear() {
        }

        public d d() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public Object get() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static abstract class b implements h {

        /* renamed from: a, reason: collision with root package name */
        final Object f30600a;

        /* renamed from: b, reason: collision with root package name */
        final int f30601b;

        b(Object obj, int i11) {
            this.f30600a = obj;
            this.f30601b = i11;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final int b() {
            return this.f30601b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final Object getKey() {
            return this.f30600a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public h k() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static abstract class c extends WeakReference implements h {

        /* renamed from: a, reason: collision with root package name */
        final int f30602a;

        c(ReferenceQueue referenceQueue, Object obj, int i11) {
            super(obj, referenceQueue);
            this.f30602a = i11;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final int b() {
            return this.f30602a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final Object getKey() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public h k() {
            return null;
        }
    }

    /* loaded from: classes4.dex */
    static final class d implements h {
    }

    /* loaded from: classes4.dex */
    final class e extends g {
        e() {
            super();
        }

        @Override // java.util.Iterator
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            return c();
        }
    }

    /* loaded from: classes4.dex */
    final class f extends AbstractSet {
        f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = MapMakerInternalMap.this.get(key)) != null && MapMakerInternalMap.this.valueEquivalence().equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new e();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && MapMakerInternalMap.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public abstract class g implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        int f30605a;

        /* renamed from: b, reason: collision with root package name */
        int f30606b = -1;

        /* renamed from: c, reason: collision with root package name */
        Segment f30607c;

        /* renamed from: d, reason: collision with root package name */
        AtomicReferenceArray f30608d;

        /* renamed from: e, reason: collision with root package name */
        h f30609e;

        /* renamed from: f, reason: collision with root package name */
        w f30610f;

        /* renamed from: g, reason: collision with root package name */
        w f30611g;

        g() {
            this.f30605a = MapMakerInternalMap.this.segments.length - 1;
            a();
        }

        final void a() {
            this.f30610f = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i11 = this.f30605a;
                if (i11 < 0) {
                    return;
                }
                Segment<K, V, E, S>[] segmentArr = MapMakerInternalMap.this.segments;
                this.f30605a = i11 - 1;
                Segment<K, V, E, S> segment = segmentArr[i11];
                this.f30607c = segment;
                if (segment.count != 0) {
                    this.f30608d = this.f30607c.table;
                    this.f30606b = r0.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        boolean b(h hVar) {
            try {
                Object key = hVar.getKey();
                Object liveValue = MapMakerInternalMap.this.getLiveValue(hVar);
                if (liveValue == null) {
                    this.f30607c.postReadCleanup();
                    return false;
                }
                this.f30610f = new w(key, liveValue);
                this.f30607c.postReadCleanup();
                return true;
            } catch (Throwable th2) {
                this.f30607c.postReadCleanup();
                throw th2;
            }
        }

        w c() {
            w wVar = this.f30610f;
            if (wVar == null) {
                throw new NoSuchElementException();
            }
            this.f30611g = wVar;
            a();
            return this.f30611g;
        }

        boolean d() {
            h hVar = this.f30609e;
            if (hVar == null) {
                return false;
            }
            while (true) {
                this.f30609e = hVar.k();
                h hVar2 = this.f30609e;
                if (hVar2 == null) {
                    return false;
                }
                if (b(hVar2)) {
                    return true;
                }
                hVar = this.f30609e;
            }
        }

        boolean e() {
            while (true) {
                int i11 = this.f30606b;
                if (i11 < 0) {
                    return false;
                }
                AtomicReferenceArray atomicReferenceArray = this.f30608d;
                this.f30606b = i11 - 1;
                h hVar = (h) atomicReferenceArray.get(i11);
                this.f30609e = hVar;
                if (hVar != null && (b(hVar) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30610f != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            e2.e(this.f30611g != null);
            MapMakerInternalMap.this.remove(this.f30611g.getKey());
            this.f30611g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface h {
        int b();

        Object getKey();

        Object getValue();

        h k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface i {
        Segment a(MapMakerInternalMap mapMakerInternalMap, int i11);

        h b(Segment segment, h hVar, h hVar2);

        Strength c();

        void d(Segment segment, h hVar, Object obj);

        h e(Segment segment, Object obj, int i11, h hVar);

        Strength f();
    }

    /* loaded from: classes4.dex */
    final class j extends g {
        j() {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return c().getKey();
        }
    }

    /* loaded from: classes4.dex */
    final class k extends AbstractSet {
        k() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new j();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class l extends b implements h {

        /* loaded from: classes4.dex */
        static final class a implements i {

            /* renamed from: a, reason: collision with root package name */
            private static final a f30615a = new a();

            a() {
            }

            static a h() {
                return f30615a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength c() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength f() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public l b(StrongKeyDummyValueSegment strongKeyDummyValueSegment, l lVar, l lVar2) {
                return e(strongKeyDummyValueSegment, lVar.f30600a, lVar.f30601b, lVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public l e(StrongKeyDummyValueSegment strongKeyDummyValueSegment, Object obj, int i11, l lVar) {
                return lVar == null ? new l(obj, i11, null) : new b(obj, i11, lVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public StrongKeyDummyValueSegment a(MapMakerInternalMap mapMakerInternalMap, int i11) {
                return new StrongKeyDummyValueSegment(mapMakerInternalMap, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void d(StrongKeyDummyValueSegment strongKeyDummyValueSegment, l lVar, MapMaker.Dummy dummy) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes4.dex */
        public static final class b extends l {

            /* renamed from: c, reason: collision with root package name */
            private final l f30616c;

            b(Object obj, int i11, l lVar) {
                super(obj, i11, null);
                this.f30616c = lVar;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.b, com.google.common.collect.MapMakerInternalMap.h
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public l k() {
                return this.f30616c;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.l, com.google.common.collect.MapMakerInternalMap.h
            public /* bridge */ /* synthetic */ Object getValue() {
                return super.getValue();
            }
        }

        private l(Object obj, int i11) {
            super(obj, i11);
        }

        /* synthetic */ l(Object obj, int i11, a aVar) {
            this(obj, i11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class m extends b implements h {

        /* renamed from: c, reason: collision with root package name */
        private volatile Object f30617c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class a implements i {

            /* renamed from: a, reason: collision with root package name */
            private static final a f30618a = new a();

            a() {
            }

            static a h() {
                return f30618a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength c() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength f() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public m b(StrongKeyStrongValueSegment strongKeyStrongValueSegment, m mVar, m mVar2) {
                m e11 = e(strongKeyStrongValueSegment, mVar.f30600a, mVar.f30601b, mVar2);
                e11.f30617c = mVar.f30617c;
                return e11;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public m e(StrongKeyStrongValueSegment strongKeyStrongValueSegment, Object obj, int i11, m mVar) {
                return mVar == null ? new m(obj, i11, null) : new b(obj, i11, mVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public StrongKeyStrongValueSegment a(MapMakerInternalMap mapMakerInternalMap, int i11) {
                return new StrongKeyStrongValueSegment(mapMakerInternalMap, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void d(StrongKeyStrongValueSegment strongKeyStrongValueSegment, m mVar, Object obj) {
                mVar.f30617c = obj;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes4.dex */
        public static final class b extends m {

            /* renamed from: d, reason: collision with root package name */
            private final m f30619d;

            b(Object obj, int i11, m mVar) {
                super(obj, i11, null);
                this.f30619d = mVar;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.b, com.google.common.collect.MapMakerInternalMap.h
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public m k() {
                return this.f30619d;
            }
        }

        private m(Object obj, int i11) {
            super(obj, i11);
            this.f30617c = null;
        }

        /* synthetic */ m(Object obj, int i11, a aVar) {
            this(obj, i11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final Object getValue() {
            return this.f30617c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class n extends b implements t {

        /* renamed from: c, reason: collision with root package name */
        private volatile u f30620c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class a implements i {

            /* renamed from: a, reason: collision with root package name */
            private static final a f30621a = new a();

            a() {
            }

            static a h() {
                return f30621a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength c() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength f() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public n b(StrongKeyWeakValueSegment strongKeyWeakValueSegment, n nVar, n nVar2) {
                if (Segment.isCollected(nVar)) {
                    return null;
                }
                n e11 = e(strongKeyWeakValueSegment, nVar.f30600a, nVar.f30601b, nVar2);
                e11.f30620c = nVar.f30620c.b(strongKeyWeakValueSegment.queueForValues, e11);
                return e11;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public n e(StrongKeyWeakValueSegment strongKeyWeakValueSegment, Object obj, int i11, n nVar) {
                return nVar == null ? new n(obj, i11, null) : new b(obj, i11, nVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public StrongKeyWeakValueSegment a(MapMakerInternalMap mapMakerInternalMap, int i11) {
                return new StrongKeyWeakValueSegment(mapMakerInternalMap, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void d(StrongKeyWeakValueSegment strongKeyWeakValueSegment, n nVar, Object obj) {
                u uVar = nVar.f30620c;
                nVar.f30620c = new v(strongKeyWeakValueSegment.queueForValues, obj, nVar);
                uVar.clear();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes4.dex */
        public static final class b extends n {

            /* renamed from: d, reason: collision with root package name */
            private final n f30622d;

            b(Object obj, int i11, n nVar) {
                super(obj, i11, null);
                this.f30622d = nVar;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.b, com.google.common.collect.MapMakerInternalMap.h
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public n k() {
                return this.f30622d;
            }
        }

        private n(Object obj, int i11) {
            super(obj, i11);
            this.f30620c = MapMakerInternalMap.unsetWeakValueReference();
        }

        /* synthetic */ n(Object obj, int i11, a aVar) {
            this(obj, i11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t
        public final u a() {
            return this.f30620c;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final Object getValue() {
            return this.f30620c.get();
        }
    }

    /* loaded from: classes4.dex */
    final class o extends g {
        o() {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return c().getValue();
        }
    }

    /* loaded from: classes4.dex */
    final class p extends AbstractCollection {
        p() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new o();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class q extends c implements h {

        /* loaded from: classes4.dex */
        static final class a implements i {

            /* renamed from: a, reason: collision with root package name */
            private static final a f30625a = new a();

            a() {
            }

            static a h() {
                return f30625a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength c() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength f() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public q b(WeakKeyDummyValueSegment weakKeyDummyValueSegment, q qVar, q qVar2) {
                Object key = qVar.getKey();
                if (key == null) {
                    return null;
                }
                return e(weakKeyDummyValueSegment, key, qVar.f30602a, qVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public q e(WeakKeyDummyValueSegment weakKeyDummyValueSegment, Object obj, int i11, q qVar) {
                return qVar == null ? new q(weakKeyDummyValueSegment.queueForKeys, obj, i11, null) : new b(weakKeyDummyValueSegment.queueForKeys, obj, i11, qVar, null);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public WeakKeyDummyValueSegment a(MapMakerInternalMap mapMakerInternalMap, int i11) {
                return new WeakKeyDummyValueSegment(mapMakerInternalMap, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void d(WeakKeyDummyValueSegment weakKeyDummyValueSegment, q qVar, MapMaker.Dummy dummy) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes4.dex */
        public static final class b extends q {

            /* renamed from: b, reason: collision with root package name */
            private final q f30626b;

            private b(ReferenceQueue referenceQueue, Object obj, int i11, q qVar) {
                super(referenceQueue, obj, i11, null);
                this.f30626b = qVar;
            }

            /* synthetic */ b(ReferenceQueue referenceQueue, Object obj, int i11, q qVar, a aVar) {
                this(referenceQueue, obj, i11, qVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.c, com.google.common.collect.MapMakerInternalMap.h
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public q k() {
                return this.f30626b;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.q, com.google.common.collect.MapMakerInternalMap.h
            public /* bridge */ /* synthetic */ Object getValue() {
                return super.getValue();
            }
        }

        private q(ReferenceQueue referenceQueue, Object obj, int i11) {
            super(referenceQueue, obj, i11);
        }

        /* synthetic */ q(ReferenceQueue referenceQueue, Object obj, int i11, a aVar) {
            this(referenceQueue, obj, i11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class r extends c implements h {

        /* renamed from: b, reason: collision with root package name */
        private volatile Object f30627b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class a implements i {

            /* renamed from: a, reason: collision with root package name */
            private static final a f30628a = new a();

            a() {
            }

            static a h() {
                return f30628a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength c() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength f() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public r b(WeakKeyStrongValueSegment weakKeyStrongValueSegment, r rVar, r rVar2) {
                Object key = rVar.getKey();
                if (key == null) {
                    return null;
                }
                r e11 = e(weakKeyStrongValueSegment, key, rVar.f30602a, rVar2);
                e11.f30627b = rVar.f30627b;
                return e11;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public r e(WeakKeyStrongValueSegment weakKeyStrongValueSegment, Object obj, int i11, r rVar) {
                return rVar == null ? new r(weakKeyStrongValueSegment.queueForKeys, obj, i11, null) : new b(weakKeyStrongValueSegment.queueForKeys, obj, i11, rVar, null);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public WeakKeyStrongValueSegment a(MapMakerInternalMap mapMakerInternalMap, int i11) {
                return new WeakKeyStrongValueSegment(mapMakerInternalMap, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void d(WeakKeyStrongValueSegment weakKeyStrongValueSegment, r rVar, Object obj) {
                rVar.f30627b = obj;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes4.dex */
        public static final class b extends r {

            /* renamed from: c, reason: collision with root package name */
            private final r f30629c;

            private b(ReferenceQueue referenceQueue, Object obj, int i11, r rVar) {
                super(referenceQueue, obj, i11, null);
                this.f30629c = rVar;
            }

            /* synthetic */ b(ReferenceQueue referenceQueue, Object obj, int i11, r rVar, a aVar) {
                this(referenceQueue, obj, i11, rVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.c, com.google.common.collect.MapMakerInternalMap.h
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public r k() {
                return this.f30629c;
            }
        }

        private r(ReferenceQueue referenceQueue, Object obj, int i11) {
            super(referenceQueue, obj, i11);
            this.f30627b = null;
        }

        /* synthetic */ r(ReferenceQueue referenceQueue, Object obj, int i11, a aVar) {
            this(referenceQueue, obj, i11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final Object getValue() {
            return this.f30627b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class s extends c implements t {

        /* renamed from: b, reason: collision with root package name */
        private volatile u f30630b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class a implements i {

            /* renamed from: a, reason: collision with root package name */
            private static final a f30631a = new a();

            a() {
            }

            static a h() {
                return f30631a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength c() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength f() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public s b(WeakKeyWeakValueSegment weakKeyWeakValueSegment, s sVar, s sVar2) {
                Object key = sVar.getKey();
                if (key == null || Segment.isCollected(sVar)) {
                    return null;
                }
                s e11 = e(weakKeyWeakValueSegment, key, sVar.f30602a, sVar2);
                e11.f30630b = sVar.f30630b.b(weakKeyWeakValueSegment.queueForValues, e11);
                return e11;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public s e(WeakKeyWeakValueSegment weakKeyWeakValueSegment, Object obj, int i11, s sVar) {
                return sVar == null ? new s(weakKeyWeakValueSegment.queueForKeys, obj, i11) : new b(weakKeyWeakValueSegment.queueForKeys, obj, i11, sVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public WeakKeyWeakValueSegment a(MapMakerInternalMap mapMakerInternalMap, int i11) {
                return new WeakKeyWeakValueSegment(mapMakerInternalMap, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void d(WeakKeyWeakValueSegment weakKeyWeakValueSegment, s sVar, Object obj) {
                u uVar = sVar.f30630b;
                sVar.f30630b = new v(weakKeyWeakValueSegment.queueForValues, obj, sVar);
                uVar.clear();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes4.dex */
        public static final class b extends s {

            /* renamed from: c, reason: collision with root package name */
            private final s f30632c;

            b(ReferenceQueue referenceQueue, Object obj, int i11, s sVar) {
                super(referenceQueue, obj, i11);
                this.f30632c = sVar;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.c, com.google.common.collect.MapMakerInternalMap.h
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public s k() {
                return this.f30632c;
            }
        }

        s(ReferenceQueue referenceQueue, Object obj, int i11) {
            super(referenceQueue, obj, i11);
            this.f30630b = MapMakerInternalMap.unsetWeakValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.t
        public final u a() {
            return this.f30630b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public final Object getValue() {
            return this.f30630b.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface t extends h {
        u a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface u {
        h a();

        u b(ReferenceQueue referenceQueue, h hVar);

        void clear();

        Object get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class v extends WeakReference implements u {

        /* renamed from: a, reason: collision with root package name */
        final h f30633a;

        v(ReferenceQueue referenceQueue, Object obj, h hVar) {
            super(obj, referenceQueue);
            this.f30633a = hVar;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public h a() {
            return this.f30633a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public u b(ReferenceQueue referenceQueue, h hVar) {
            return new v(referenceQueue, get(), hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public final class w extends com.google.common.collect.b {

        /* renamed from: a, reason: collision with root package name */
        final Object f30634a;

        /* renamed from: b, reason: collision with root package name */
        Object f30635b;

        w(Object obj, Object obj2) {
            this.f30634a = obj;
            this.f30635b = obj2;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f30634a.equals(entry.getKey()) && this.f30635b.equals(entry.getValue());
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object getKey() {
            return this.f30634a;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object getValue() {
            return this.f30635b;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public int hashCode() {
            return this.f30634a.hashCode() ^ this.f30635b.hashCode();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object setValue(Object obj) {
            Object put = MapMakerInternalMap.this.put(this.f30634a, obj);
            this.f30635b = obj;
            return put;
        }
    }

    private MapMakerInternalMap(MapMaker mapMaker, i iVar) {
        this.concurrencyLevel = Math.min(mapMaker.b(), 65536);
        this.keyEquivalence = mapMaker.d();
        this.entryHelper = iVar;
        int min = Math.min(mapMaker.c(), 1073741824);
        int i11 = 0;
        int i12 = 1;
        int i13 = 0;
        int i14 = 1;
        while (i14 < this.concurrencyLevel) {
            i13++;
            i14 <<= 1;
        }
        this.segmentShift = 32 - i13;
        this.segmentMask = i14 - 1;
        this.segments = newSegmentArray(i14);
        int i15 = min / i14;
        while (i12 < (i14 * i15 < min ? i15 + 1 : i15)) {
            i12 <<= 1;
        }
        while (true) {
            Segment<K, V, E, S>[] segmentArr = this.segments;
            if (i11 >= segmentArr.length) {
                return;
            }
            segmentArr[i11] = createSegment(i12);
            i11++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> MapMakerInternalMap<K, V, ? extends h, ?> create(MapMaker mapMaker) {
        Strength e11 = mapMaker.e();
        Strength strength = Strength.STRONG;
        if (e11 == strength && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, m.a.h());
        }
        if (mapMaker.e() == strength && mapMaker.f() == Strength.WEAK) {
            return new MapMakerInternalMap<>(mapMaker, n.a.h());
        }
        Strength e12 = mapMaker.e();
        Strength strength2 = Strength.WEAK;
        if (e12 == strength2 && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, r.a.h());
        }
        if (mapMaker.e() == strength2 && mapMaker.f() == strength2) {
            return new MapMakerInternalMap<>(mapMaker, s.a.h());
        }
        throw new AssertionError();
    }

    static <K> MapMakerInternalMap<K, MapMaker.Dummy, ? extends h, ?> createWithDummyValues(MapMaker mapMaker) {
        Strength e11 = mapMaker.e();
        Strength strength = Strength.STRONG;
        if (e11 == strength && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, l.a.h());
        }
        Strength e12 = mapMaker.e();
        Strength strength2 = Strength.WEAK;
        if (e12 == strength2 && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, q.a.h());
        }
        if (mapMaker.f() == strength2) {
            throw new IllegalArgumentException("Map cannot have both weak and dummy values");
        }
        throw new AssertionError();
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializationProxy");
    }

    static int rehash(int i11) {
        int i12 = i11 + ((i11 << 15) ^ (-12931));
        int i13 = i12 ^ (i12 >>> 10);
        int i14 = i13 + (i13 << 3);
        int i15 = i14 ^ (i14 >>> 6);
        int i16 = i15 + (i15 << 2) + (i15 << 14);
        return i16 ^ (i16 >>> 16);
    }

    static <K, V, E extends h> u unsetWeakValueReference() {
        return UNSET_WEAK_VALUE_REFERENCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V, E, S> segment : this.segments) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).containsKey(obj, hash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.google.common.collect.MapMakerInternalMap$Segment] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.google.common.collect.MapMakerInternalMap$Segment<K, V, E extends com.google.common.collect.MapMakerInternalMap$h, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>>[]] */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        boolean z10 = false;
        if (obj == null) {
            return false;
        }
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j11 = -1;
        int i11 = 0;
        while (i11 < 3) {
            int length = segmentArr.length;
            long j12 = 0;
            for (?? r102 = z10; r102 < length; r102++) {
                ?? r11 = segmentArr[r102];
                int i12 = r11.count;
                AtomicReferenceArray<E> atomicReferenceArray = r11.table;
                for (?? r13 = z10; r13 < atomicReferenceArray.length(); r13++) {
                    for (E e11 = atomicReferenceArray.get(r13); e11 != null; e11 = e11.k()) {
                        Object liveValue = r11.getLiveValue(e11);
                        if (liveValue != null && valueEquivalence().equivalent(obj, liveValue)) {
                            return true;
                        }
                    }
                }
                j12 += r11.modCount;
                z10 = false;
            }
            if (j12 == j11) {
                return false;
            }
            i11++;
            j11 = j12;
            z10 = false;
        }
        return z10;
    }

    E copyEntry(E e11, E e12) {
        return segmentFor(e11.b()).copyEntry(e11, e12);
    }

    Segment<K, V, E, S> createSegment(int i11) {
        return this.entryHelper.a(this, i11);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        f fVar = new f();
        this.entrySet = fVar;
        return fVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).get(obj, hash);
    }

    E getEntry(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).getEntry(obj, hash);
    }

    V getLiveValue(E e11) {
        if (e11.getKey() == null) {
            return null;
        }
        return (V) e11.getValue();
    }

    int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j11 = 0;
        for (int i11 = 0; i11 < segmentArr.length; i11++) {
            if (segmentArr[i11].count != 0) {
                return false;
            }
            j11 += segmentArr[i11].modCount;
        }
        if (j11 == 0) {
            return true;
        }
        for (int i12 = 0; i12 < segmentArr.length; i12++) {
            if (segmentArr[i12].count != 0) {
                return false;
            }
            j11 -= segmentArr[i12].modCount;
        }
        return j11 == 0;
    }

    boolean isLiveForTesting(h hVar) {
        return segmentFor(hVar.b()).getLiveValueForTesting(hVar) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        k kVar = new k();
        this.keySet = kVar;
        return kVar;
    }

    Strength keyStrength() {
        return this.entryHelper.f();
    }

    final Segment<K, V, E, S>[] newSegmentArray(int i11) {
        return new Segment[i11];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k11, V v11) {
        com.google.common.base.m.o(k11);
        com.google.common.base.m.o(v11);
        int hash = hash(k11);
        return segmentFor(hash).put(k11, hash, v11, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k11, V v11) {
        com.google.common.base.m.o(k11);
        com.google.common.base.m.o(v11);
        int hash = hash(k11);
        return segmentFor(hash).put(k11, hash, v11, true);
    }

    void reclaimKey(E e11) {
        int b11 = e11.b();
        segmentFor(b11).reclaimKey(e11, b11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void reclaimValue(u uVar) {
        h a11 = uVar.a();
        int b11 = a11.b();
        segmentFor(b11).reclaimValue(a11.getKey(), b11, uVar);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k11, V v11) {
        com.google.common.base.m.o(k11);
        com.google.common.base.m.o(v11);
        int hash = hash(k11);
        return segmentFor(hash).replace(k11, hash, v11);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k11, V v11, V v12) {
        com.google.common.base.m.o(k11);
        com.google.common.base.m.o(v12);
        if (v11 == null) {
            return false;
        }
        int hash = hash(k11);
        return segmentFor(hash).replace(k11, hash, v11, v12);
    }

    Segment<K, V, E, S> segmentFor(int i11) {
        return this.segments[(i11 >>> this.segmentShift) & this.segmentMask];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j11 = 0;
        for (int i11 = 0; i11 < this.segments.length; i11++) {
            j11 += r0[i11].count;
        }
        return Ints.n(j11);
    }

    Equivalence valueEquivalence() {
        return this.entryHelper.c().defaultEquivalence();
    }

    Strength valueStrength() {
        return this.entryHelper.c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        p pVar = new p();
        this.values = pVar;
        return pVar;
    }

    Object writeReplace() {
        return new SerializationProxy(this.entryHelper.f(), this.entryHelper.c(), this.keyEquivalence, this.entryHelper.c().defaultEquivalence(), this.concurrencyLevel, this);
    }
}
