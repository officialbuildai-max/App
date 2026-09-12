package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes4.dex */
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements k, Serializable {
    private static final int ABSENT = -1;
    private static final int ENDPOINT = -2;
    private transient Set<Map.Entry<K, V>> entrySet;
    private transient int firstInInsertionOrder;
    private transient int[] hashTableKToV;
    private transient int[] hashTableVToK;
    private transient k inverse;
    private transient Set<K> keySet;
    transient K[] keys;
    private transient int lastInInsertionOrder;
    transient int modCount;
    private transient int[] nextInBucketKToV;
    private transient int[] nextInBucketVToK;
    private transient int[] nextInInsertionOrder;
    private transient int[] prevInInsertionOrder;
    transient int size;
    private transient Set<V> valueSet;
    transient V[] values;

    /* loaded from: classes4.dex */
    static class Inverse<K, V> extends AbstractMap<V, K> implements k, Serializable {

        /* renamed from: a, reason: collision with root package name */
        private transient Set f30445a;
        private final HashBiMap<K, V> forward;

        Inverse(HashBiMap<K, V> hashBiMap) {
            this.forward = hashBiMap;
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            ((HashBiMap) this.forward).inverse = this;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.forward.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.forward.containsValue(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            return this.forward.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> set = this.f30445a;
            if (set != null) {
                return set;
            }
            d dVar = new d(this.forward);
            this.f30445a = dVar;
            return dVar;
        }

        public K forcePut(V v11, K k11) {
            return this.forward.putInverse(v11, k11, true);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K get(Object obj) {
            return this.forward.getInverse(obj);
        }

        @Override // com.google.common.collect.k
        public k inverse() {
            return this.forward;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return this.forward.values();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K put(V v11, K k11) {
            return this.forward.putInverse(v11, k11, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K remove(Object obj) {
            return this.forward.removeInverse(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.forward.size;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> values() {
            return this.forward.keySet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public final class a extends com.google.common.collect.b {

        /* renamed from: a, reason: collision with root package name */
        final Object f30446a;

        /* renamed from: b, reason: collision with root package name */
        int f30447b;

        a(int i11) {
            this.f30446a = m3.a(HashBiMap.this.keys[i11]);
            this.f30447b = i11;
        }

        void a() {
            int i11 = this.f30447b;
            if (i11 != -1) {
                HashBiMap hashBiMap = HashBiMap.this;
                if (i11 <= hashBiMap.size && com.google.common.base.j.a(hashBiMap.keys[i11], this.f30446a)) {
                    return;
                }
            }
            this.f30447b = HashBiMap.this.findEntryByKey(this.f30446a);
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object getKey() {
            return this.f30446a;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object getValue() {
            a();
            int i11 = this.f30447b;
            return i11 == -1 ? m3.b() : m3.a(HashBiMap.this.values[i11]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object setValue(Object obj) {
            a();
            int i11 = this.f30447b;
            if (i11 == -1) {
                HashBiMap.this.put(this.f30446a, obj);
                return m3.b();
            }
            Object a11 = m3.a(HashBiMap.this.values[i11]);
            if (com.google.common.base.j.a(a11, obj)) {
                return obj;
            }
            HashBiMap.this.replaceValueInEntry(this.f30447b, obj, false);
            return a11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b extends com.google.common.collect.b {

        /* renamed from: a, reason: collision with root package name */
        final HashBiMap f30449a;

        /* renamed from: b, reason: collision with root package name */
        final Object f30450b;

        /* renamed from: c, reason: collision with root package name */
        int f30451c;

        b(HashBiMap hashBiMap, int i11) {
            this.f30449a = hashBiMap;
            this.f30450b = m3.a(hashBiMap.values[i11]);
            this.f30451c = i11;
        }

        private void a() {
            int i11 = this.f30451c;
            if (i11 != -1) {
                HashBiMap hashBiMap = this.f30449a;
                if (i11 <= hashBiMap.size && com.google.common.base.j.a(this.f30450b, hashBiMap.values[i11])) {
                    return;
                }
            }
            this.f30451c = this.f30449a.findEntryByValue(this.f30450b);
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object getKey() {
            return this.f30450b;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object getValue() {
            a();
            int i11 = this.f30451c;
            return i11 == -1 ? m3.b() : m3.a(this.f30449a.keys[i11]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.b, java.util.Map.Entry
        public Object setValue(Object obj) {
            a();
            int i11 = this.f30451c;
            if (i11 == -1) {
                this.f30449a.putInverse(this.f30450b, obj, false);
                return m3.b();
            }
            Object a11 = m3.a(this.f30449a.keys[i11]);
            if (com.google.common.base.j.a(a11, obj)) {
                return obj;
            }
            this.f30449a.replaceKeyInEntry(this.f30451c, obj, false);
            return a11;
        }
    }

    /* loaded from: classes4.dex */
    final class c extends g {
        c() {
            super(HashBiMap.this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.HashBiMap.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry a(int i11) {
            return new a(i11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int findEntryByKey = HashBiMap.this.findEntryByKey(key);
            return findEntryByKey != -1 && com.google.common.base.j.a(value, HashBiMap.this.values[findEntryByKey]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int d11 = v2.d(key);
            int findEntryByKey = HashBiMap.this.findEntryByKey(key, d11);
            if (findEntryByKey == -1 || !com.google.common.base.j.a(value, HashBiMap.this.values[findEntryByKey])) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, d11);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    static class d extends g {
        d(HashBiMap hashBiMap) {
            super(hashBiMap);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.HashBiMap.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry a(int i11) {
            return new b(this.f30455a, i11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int findEntryByValue = this.f30455a.findEntryByValue(key);
            return findEntryByValue != -1 && com.google.common.base.j.a(this.f30455a.keys[findEntryByValue], value);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int d11 = v2.d(key);
            int findEntryByValue = this.f30455a.findEntryByValue(key, d11);
            if (findEntryByValue == -1 || !com.google.common.base.j.a(this.f30455a.keys[findEntryByValue], value)) {
                return false;
            }
            this.f30455a.removeEntryValueHashKnown(findEntryByValue, d11);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public final class e extends g {
        e() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.g
        Object a(int i11) {
            return m3.a(HashBiMap.this.keys[i11]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int d11 = v2.d(obj);
            int findEntryByKey = HashBiMap.this.findEntryByKey(obj, d11);
            if (findEntryByKey == -1) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, d11);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public final class f extends g {
        f() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.g
        Object a(int i11) {
            return m3.a(HashBiMap.this.values[i11]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int d11 = v2.d(obj);
            int findEntryByValue = HashBiMap.this.findEntryByValue(obj, d11);
            if (findEntryByValue == -1) {
                return false;
            }
            HashBiMap.this.removeEntryValueHashKnown(findEntryByValue, d11);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static abstract class g extends AbstractSet {

        /* renamed from: a, reason: collision with root package name */
        final HashBiMap f30455a;

        /* loaded from: classes4.dex */
        class a implements Iterator {

            /* renamed from: a, reason: collision with root package name */
            private int f30456a;

            /* renamed from: b, reason: collision with root package name */
            private int f30457b = -1;

            /* renamed from: c, reason: collision with root package name */
            private int f30458c;

            /* renamed from: d, reason: collision with root package name */
            private int f30459d;

            a() {
                this.f30456a = g.this.f30455a.firstInInsertionOrder;
                HashBiMap hashBiMap = g.this.f30455a;
                this.f30458c = hashBiMap.modCount;
                this.f30459d = hashBiMap.size;
            }

            private void a() {
                if (g.this.f30455a.modCount != this.f30458c) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.f30456a != -2 && this.f30459d > 0;
            }

            @Override // java.util.Iterator
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Object a11 = g.this.a(this.f30456a);
                this.f30457b = this.f30456a;
                this.f30456a = g.this.f30455a.nextInInsertionOrder[this.f30456a];
                this.f30459d--;
                return a11;
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                e2.e(this.f30457b != -1);
                g.this.f30455a.removeEntry(this.f30457b);
                int i11 = this.f30456a;
                HashBiMap hashBiMap = g.this.f30455a;
                if (i11 == hashBiMap.size) {
                    this.f30456a = this.f30457b;
                }
                this.f30457b = -1;
                this.f30458c = hashBiMap.modCount;
            }
        }

        g(HashBiMap hashBiMap) {
            this.f30455a = hashBiMap;
        }

        abstract Object a(int i11);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f30455a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f30455a.size;
        }
    }

    private HashBiMap(int i11) {
        init(i11);
    }

    private int bucket(int i11) {
        return i11 & (this.hashTableKToV.length - 1);
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    public static <K, V> HashBiMap<K, V> create(int i11) {
        return new HashBiMap<>(i11);
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }

    private static int[] createFilledWithAbsent(int i11) {
        int[] iArr = new int[i11];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void deleteFromTableKToV(int i11, int i12) {
        com.google.common.base.m.d(i11 != -1);
        int bucket = bucket(i12);
        int[] iArr = this.hashTableKToV;
        int i13 = iArr[bucket];
        if (i13 == i11) {
            int[] iArr2 = this.nextInBucketKToV;
            iArr[bucket] = iArr2[i11];
            iArr2[i11] = -1;
            return;
        }
        int i14 = this.nextInBucketKToV[i13];
        while (true) {
            int i15 = i13;
            i13 = i14;
            if (i13 == -1) {
                throw new AssertionError("Expected to find entry with key " + this.keys[i11]);
            }
            if (i13 == i11) {
                int[] iArr3 = this.nextInBucketKToV;
                iArr3[i15] = iArr3[i11];
                iArr3[i11] = -1;
                return;
            }
            i14 = this.nextInBucketKToV[i13];
        }
    }

    private void deleteFromTableVToK(int i11, int i12) {
        com.google.common.base.m.d(i11 != -1);
        int bucket = bucket(i12);
        int[] iArr = this.hashTableVToK;
        int i13 = iArr[bucket];
        if (i13 == i11) {
            int[] iArr2 = this.nextInBucketVToK;
            iArr[bucket] = iArr2[i11];
            iArr2[i11] = -1;
            return;
        }
        int i14 = this.nextInBucketVToK[i13];
        while (true) {
            int i15 = i13;
            i13 = i14;
            if (i13 == -1) {
                throw new AssertionError("Expected to find entry with value " + this.values[i11]);
            }
            if (i13 == i11) {
                int[] iArr3 = this.nextInBucketVToK;
                iArr3[i15] = iArr3[i11];
                iArr3[i11] = -1;
                return;
            }
            i14 = this.nextInBucketVToK[i13];
        }
    }

    private void ensureCapacity(int i11) {
        int[] iArr = this.nextInBucketKToV;
        if (iArr.length < i11) {
            int f11 = ImmutableCollection.b.f(iArr.length, i11);
            this.keys = (K[]) Arrays.copyOf(this.keys, f11);
            this.values = (V[]) Arrays.copyOf(this.values, f11);
            this.nextInBucketKToV = expandAndFillWithAbsent(this.nextInBucketKToV, f11);
            this.nextInBucketVToK = expandAndFillWithAbsent(this.nextInBucketVToK, f11);
            this.prevInInsertionOrder = expandAndFillWithAbsent(this.prevInInsertionOrder, f11);
            this.nextInInsertionOrder = expandAndFillWithAbsent(this.nextInInsertionOrder, f11);
        }
        if (this.hashTableKToV.length < i11) {
            int a11 = v2.a(i11, 1.0d);
            this.hashTableKToV = createFilledWithAbsent(a11);
            this.hashTableVToK = createFilledWithAbsent(a11);
            for (int i12 = 0; i12 < this.size; i12++) {
                int bucket = bucket(v2.d(this.keys[i12]));
                int[] iArr2 = this.nextInBucketKToV;
                int[] iArr3 = this.hashTableKToV;
                iArr2[i12] = iArr3[bucket];
                iArr3[bucket] = i12;
                int bucket2 = bucket(v2.d(this.values[i12]));
                int[] iArr4 = this.nextInBucketVToK;
                int[] iArr5 = this.hashTableVToK;
                iArr4[i12] = iArr5[bucket2];
                iArr5[bucket2] = i12;
            }
        }
    }

    private static int[] expandAndFillWithAbsent(int[] iArr, int i11) {
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, i11);
        Arrays.fill(copyOf, length, i11, -1);
        return copyOf;
    }

    private void insertIntoTableKToV(int i11, int i12) {
        com.google.common.base.m.d(i11 != -1);
        int bucket = bucket(i12);
        int[] iArr = this.nextInBucketKToV;
        int[] iArr2 = this.hashTableKToV;
        iArr[i11] = iArr2[bucket];
        iArr2[bucket] = i11;
    }

    private void insertIntoTableVToK(int i11, int i12) {
        com.google.common.base.m.d(i11 != -1);
        int bucket = bucket(i12);
        int[] iArr = this.nextInBucketVToK;
        int[] iArr2 = this.hashTableVToK;
        iArr[i11] = iArr2[bucket];
        iArr2[bucket] = i11;
    }

    private void moveEntryToIndex(int i11, int i12) {
        int i13;
        int i14;
        if (i11 == i12) {
            return;
        }
        int i15 = this.prevInInsertionOrder[i11];
        int i16 = this.nextInInsertionOrder[i11];
        setSucceeds(i15, i12);
        setSucceeds(i12, i16);
        K[] kArr = this.keys;
        K k11 = kArr[i11];
        V[] vArr = this.values;
        V v11 = vArr[i11];
        kArr[i12] = k11;
        vArr[i12] = v11;
        int bucket = bucket(v2.d(k11));
        int[] iArr = this.hashTableKToV;
        int i17 = iArr[bucket];
        if (i17 == i11) {
            iArr[bucket] = i12;
        } else {
            int i18 = this.nextInBucketKToV[i17];
            while (true) {
                i13 = i17;
                i17 = i18;
                if (i17 == i11) {
                    break;
                } else {
                    i18 = this.nextInBucketKToV[i17];
                }
            }
            this.nextInBucketKToV[i13] = i12;
        }
        int[] iArr2 = this.nextInBucketKToV;
        iArr2[i12] = iArr2[i11];
        iArr2[i11] = -1;
        int bucket2 = bucket(v2.d(v11));
        int[] iArr3 = this.hashTableVToK;
        int i19 = iArr3[bucket2];
        if (i19 == i11) {
            iArr3[bucket2] = i12;
        } else {
            int i20 = this.nextInBucketVToK[i19];
            while (true) {
                i14 = i19;
                i19 = i20;
                if (i19 == i11) {
                    break;
                } else {
                    i20 = this.nextInBucketVToK[i19];
                }
            }
            this.nextInBucketVToK[i14] = i12;
        }
        int[] iArr4 = this.nextInBucketVToK;
        iArr4[i12] = iArr4[i11];
        iArr4[i11] = -1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int h11 = w3.h(objectInputStream);
        init(16);
        w3.c(this, objectInputStream, h11);
    }

    private void removeEntry(int i11, int i12, int i13) {
        com.google.common.base.m.d(i11 != -1);
        deleteFromTableKToV(i11, i12);
        deleteFromTableVToK(i11, i13);
        setSucceeds(this.prevInInsertionOrder[i11], this.nextInInsertionOrder[i11]);
        moveEntryToIndex(this.size - 1, i11);
        K[] kArr = this.keys;
        int i14 = this.size;
        kArr[i14 - 1] = null;
        this.values[i14 - 1] = null;
        this.size = i14 - 1;
        this.modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceKeyInEntry(int i11, K k11, boolean z10) {
        int i12;
        com.google.common.base.m.d(i11 != -1);
        int d11 = v2.d(k11);
        int findEntryByKey = findEntryByKey(k11, d11);
        int i13 = this.lastInInsertionOrder;
        if (findEntryByKey == -1) {
            i12 = -2;
        } else {
            if (!z10) {
                throw new IllegalArgumentException("Key already present in map: " + k11);
            }
            i13 = this.prevInInsertionOrder[findEntryByKey];
            i12 = this.nextInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, d11);
            if (i11 == this.size) {
                i11 = findEntryByKey;
            }
        }
        if (i13 == i11) {
            i13 = this.prevInInsertionOrder[i11];
        } else if (i13 == this.size) {
            i13 = findEntryByKey;
        }
        if (i12 == i11) {
            findEntryByKey = this.nextInInsertionOrder[i11];
        } else if (i12 != this.size) {
            findEntryByKey = i12;
        }
        setSucceeds(this.prevInInsertionOrder[i11], this.nextInInsertionOrder[i11]);
        deleteFromTableKToV(i11, v2.d(this.keys[i11]));
        this.keys[i11] = k11;
        insertIntoTableKToV(i11, v2.d(k11));
        setSucceeds(i13, i11);
        setSucceeds(i11, findEntryByKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceValueInEntry(int i11, V v11, boolean z10) {
        com.google.common.base.m.d(i11 != -1);
        int d11 = v2.d(v11);
        int findEntryByValue = findEntryByValue(v11, d11);
        if (findEntryByValue != -1) {
            if (!z10) {
                throw new IllegalArgumentException("Value already present in map: " + v11);
            }
            removeEntryValueHashKnown(findEntryByValue, d11);
            if (i11 == this.size) {
                i11 = findEntryByValue;
            }
        }
        deleteFromTableVToK(i11, v2.d(this.values[i11]));
        this.values[i11] = v11;
        insertIntoTableVToK(i11, d11);
    }

    private void setSucceeds(int i11, int i12) {
        if (i11 == -2) {
            this.firstInInsertionOrder = i12;
        } else {
            this.nextInInsertionOrder[i11] = i12;
        }
        if (i12 == -2) {
            this.lastInInsertionOrder = i11;
        } else {
            this.prevInInsertionOrder[i12] = i11;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        w3.i(this, objectOutputStream);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.hashTableKToV, -1);
        Arrays.fill(this.hashTableVToK, -1);
        Arrays.fill(this.nextInBucketKToV, 0, this.size, -1);
        Arrays.fill(this.nextInBucketVToK, 0, this.size, -1);
        Arrays.fill(this.prevInInsertionOrder, 0, this.size, -1);
        Arrays.fill(this.nextInInsertionOrder, 0, this.size, -1);
        this.size = 0;
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findEntryByKey(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return findEntryByValue(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        c cVar = new c();
        this.entrySet = cVar;
        return cVar;
    }

    int findEntry(Object obj, int i11, int[] iArr, int[] iArr2, Object[] objArr) {
        int i12 = iArr[bucket(i11)];
        while (i12 != -1) {
            if (com.google.common.base.j.a(objArr[i12], obj)) {
                return i12;
            }
            i12 = iArr2[i12];
        }
        return -1;
    }

    int findEntryByKey(Object obj) {
        return findEntryByKey(obj, v2.d(obj));
    }

    int findEntryByKey(Object obj, int i11) {
        return findEntry(obj, i11, this.hashTableKToV, this.nextInBucketKToV, this.keys);
    }

    int findEntryByValue(Object obj) {
        return findEntryByValue(obj, v2.d(obj));
    }

    int findEntryByValue(Object obj, int i11) {
        return findEntry(obj, i11, this.hashTableVToK, this.nextInBucketVToK, this.values);
    }

    public V forcePut(K k11, V v11) {
        return put(k11, v11, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        int findEntryByKey = findEntryByKey(obj);
        if (findEntryByKey == -1) {
            return null;
        }
        return this.values[findEntryByKey];
    }

    K getInverse(Object obj) {
        int findEntryByValue = findEntryByValue(obj);
        if (findEntryByValue == -1) {
            return null;
        }
        return this.keys[findEntryByValue];
    }

    void init(int i11) {
        e2.b(i11, "expectedSize");
        int a11 = v2.a(i11, 1.0d);
        this.size = 0;
        this.keys = (K[]) new Object[i11];
        this.values = (V[]) new Object[i11];
        this.hashTableKToV = createFilledWithAbsent(a11);
        this.hashTableVToK = createFilledWithAbsent(a11);
        this.nextInBucketKToV = createFilledWithAbsent(i11);
        this.nextInBucketVToK = createFilledWithAbsent(i11);
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.prevInInsertionOrder = createFilledWithAbsent(i11);
        this.nextInInsertionOrder = createFilledWithAbsent(i11);
    }

    @Override // com.google.common.collect.k
    public k inverse() {
        k kVar = this.inverse;
        if (kVar != null) {
            return kVar;
        }
        Inverse inverse = new Inverse(this);
        this.inverse = inverse;
        return inverse;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.keySet = eVar;
        return eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k11, V v11) {
        return put(k11, v11, false);
    }

    V put(K k11, V v11, boolean z10) {
        int d11 = v2.d(k11);
        int findEntryByKey = findEntryByKey(k11, d11);
        if (findEntryByKey != -1) {
            V v12 = this.values[findEntryByKey];
            if (com.google.common.base.j.a(v12, v11)) {
                return v11;
            }
            replaceValueInEntry(findEntryByKey, v11, z10);
            return v12;
        }
        int d12 = v2.d(v11);
        int findEntryByValue = findEntryByValue(v11, d12);
        if (!z10) {
            com.google.common.base.m.j(findEntryByValue == -1, "Value already present: %s", v11);
        } else if (findEntryByValue != -1) {
            removeEntryValueHashKnown(findEntryByValue, d12);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i11 = this.size;
        kArr[i11] = k11;
        this.values[i11] = v11;
        insertIntoTableKToV(i11, d11);
        insertIntoTableVToK(this.size, d12);
        setSucceeds(this.lastInInsertionOrder, this.size);
        setSucceeds(this.size, -2);
        this.size++;
        this.modCount++;
        return null;
    }

    K putInverse(V v11, K k11, boolean z10) {
        int d11 = v2.d(v11);
        int findEntryByValue = findEntryByValue(v11, d11);
        if (findEntryByValue != -1) {
            K k12 = this.keys[findEntryByValue];
            if (com.google.common.base.j.a(k12, k11)) {
                return k11;
            }
            replaceKeyInEntry(findEntryByValue, k11, z10);
            return k12;
        }
        int i11 = this.lastInInsertionOrder;
        int d12 = v2.d(k11);
        int findEntryByKey = findEntryByKey(k11, d12);
        if (!z10) {
            com.google.common.base.m.j(findEntryByKey == -1, "Key already present: %s", k11);
        } else if (findEntryByKey != -1) {
            i11 = this.prevInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, d12);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i12 = this.size;
        kArr[i12] = k11;
        this.values[i12] = v11;
        insertIntoTableKToV(i12, d12);
        insertIntoTableVToK(this.size, d11);
        int i13 = i11 == -2 ? this.firstInInsertionOrder : this.nextInInsertionOrder[i11];
        setSucceeds(i11, this.size);
        setSucceeds(this.size, i13);
        this.size++;
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        int d11 = v2.d(obj);
        int findEntryByKey = findEntryByKey(obj, d11);
        if (findEntryByKey == -1) {
            return null;
        }
        V v11 = this.values[findEntryByKey];
        removeEntryKeyHashKnown(findEntryByKey, d11);
        return v11;
    }

    void removeEntry(int i11) {
        removeEntryKeyHashKnown(i11, v2.d(this.keys[i11]));
    }

    void removeEntryKeyHashKnown(int i11, int i12) {
        removeEntry(i11, i12, v2.d(this.values[i11]));
    }

    void removeEntryValueHashKnown(int i11, int i12) {
        removeEntry(i11, v2.d(this.keys[i11]), i12);
    }

    K removeInverse(Object obj) {
        int d11 = v2.d(obj);
        int findEntryByValue = findEntryByValue(obj, d11);
        if (findEntryByValue == -1) {
            return null;
        }
        K k11 = this.keys[findEntryByValue];
        removeEntryValueHashKnown(findEntryByValue, d11);
        return k11;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        f fVar = new f();
        this.valueSet = fVar;
        return fVar;
    }
}
