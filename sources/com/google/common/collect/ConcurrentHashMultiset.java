package com.google.common.collect;

import com.google.common.collect.d;
import com.google.common.collect.l3;
import com.google.common.collect.w3;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class ConcurrentHashMultiset<E> extends com.google.common.collect.d implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient ConcurrentMap<E, AtomicInteger> countMap;

    /* loaded from: classes4.dex */
    class a extends s2 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f30416a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConcurrentHashMultiset f30417b;

        a(ConcurrentHashMultiset concurrentHashMultiset, Set set) {
            this.f30416a = set;
            this.f30417b = concurrentHashMultiset;
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return obj != null && f2.c(this.f30416a, obj);
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return standardContainsAll(collection);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.k2, com.google.common.collect.q2
        /* renamed from: delegate */
        public Set l() {
            return this.f30416a;
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return obj != null && f2.d(this.f30416a, obj);
        }

        @Override // com.google.common.collect.k2, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            return standardRemoveAll(collection);
        }
    }

    /* loaded from: classes4.dex */
    class b extends AbstractIterator {

        /* renamed from: c, reason: collision with root package name */
        private final Iterator f30418c;

        b() {
            this.f30418c = ConcurrentHashMultiset.this.countMap.entrySet().iterator();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public l3.a a() {
            while (this.f30418c.hasNext()) {
                Map.Entry entry = (Map.Entry) this.f30418c.next();
                int i11 = ((AtomicInteger) entry.getValue()).get();
                if (i11 != 0) {
                    return Multisets.g(entry.getKey(), i11);
                }
            }
            return (l3.a) b();
        }
    }

    /* loaded from: classes4.dex */
    class c extends m2 {

        /* renamed from: a, reason: collision with root package name */
        private l3.a f30420a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterator f30421b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ConcurrentHashMultiset f30422c;

        c(ConcurrentHashMultiset concurrentHashMultiset, Iterator it) {
            this.f30421b = it;
            this.f30422c = concurrentHashMultiset;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.q2
        public Iterator l() {
            return this.f30421b;
        }

        @Override // com.google.common.collect.m2, java.util.Iterator
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public l3.a next() {
            l3.a aVar = (l3.a) super.next();
            this.f30420a = aVar;
            return aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.m.v(this.f30420a != null, "no calls to next() since the last call to remove()");
            this.f30422c.setCount(this.f30420a.getElement(), 0);
            this.f30420a = null;
        }
    }

    /* loaded from: classes4.dex */
    private class d extends d.b {
        private d() {
            super();
        }

        /* synthetic */ d(ConcurrentHashMultiset concurrentHashMultiset, a aVar) {
            this();
        }

        private List c() {
            ArrayList n11 = Lists.n(size());
            Iterators.a(n11, iterator());
            return n11;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.d.b, com.google.common.collect.Multisets.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ConcurrentHashMultiset a() {
            return ConcurrentHashMultiset.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return c().toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray(Object[] objArr) {
            return c().toArray(objArr);
        }
    }

    /* loaded from: classes4.dex */
    private static class e {

        /* renamed from: a, reason: collision with root package name */
        static final w3.b f30424a = w3.a(ConcurrentHashMultiset.class, "countMap");
    }

    ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        com.google.common.base.m.j(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.countMap = concurrentMap;
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset<>(new ConcurrentHashMap());
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> iterable) {
        ConcurrentHashMultiset<E> create = create();
        g3.a(create, iterable);
        return create;
    }

    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        return new ConcurrentHashMultiset<>(concurrentMap);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Object readObject = objectInputStream.readObject();
        Objects.requireNonNull(readObject);
        e.f30424a.b(this, (ConcurrentMap) readObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<E> snapshot() {
        ArrayList n11 = Lists.n(size());
        for (l3.a aVar : entrySet()) {
            Object element = aVar.getElement();
            for (int count = aVar.getCount(); count > 0; count--) {
                n11.add(element);
            }
        }
        return n11;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.countMap);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.l3
    public int add(E e11, int i11) {
        AtomicInteger atomicInteger;
        int i12;
        AtomicInteger atomicInteger2;
        com.google.common.base.m.o(e11);
        if (i11 == 0) {
            return count(e11);
        }
        e2.d(i11, "occurrences");
        do {
            atomicInteger = (AtomicInteger) Maps.v(this.countMap, e11);
            if (atomicInteger == null && (atomicInteger = this.countMap.putIfAbsent(e11, new AtomicInteger(i11))) == null) {
                return 0;
            }
            do {
                i12 = atomicInteger.get();
                if (i12 == 0) {
                    atomicInteger2 = new AtomicInteger(i11);
                    if (this.countMap.putIfAbsent(e11, atomicInteger2) == null) {
                        break;
                    }
                } else {
                    try {
                    } catch (ArithmeticException unused) {
                        throw new IllegalArgumentException("Overflow adding " + i11 + " occurrences to a count of " + i12);
                    }
                }
            } while (!atomicInteger.compareAndSet(i12, com.google.common.math.d.a(i12, i11)));
            return i12;
        } while (!this.countMap.replace(e11, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.countMap.clear();
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.l3
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.l3
    public int count(Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) Maps.v(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @Override // com.google.common.collect.d
    Set<E> createElementSet() {
        return new a(this, this.countMap.keySet());
    }

    @Override // com.google.common.collect.d
    @Deprecated
    public Set<l3.a> createEntrySet() {
        return new d(this, null);
    }

    @Override // com.google.common.collect.d
    int distinctElements() {
        return this.countMap.size();
    }

    @Override // com.google.common.collect.d
    Iterator<E> elementIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.d, com.google.common.collect.l3
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public Iterator<l3.a> entryIterator() {
        return new c(this, new b());
    }

    @Override // com.google.common.collect.d, com.google.common.collect.l3
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return Multisets.i(this);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.l3
    public int remove(Object obj, int i11) {
        int i12;
        int max;
        if (i11 == 0) {
            return count(obj);
        }
        e2.d(i11, "occurrences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.v(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i12 = atomicInteger.get();
            if (i12 == 0) {
                return 0;
            }
            max = Math.max(0, i12 - i11);
        } while (!atomicInteger.compareAndSet(i12, max));
        if (max == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return i12;
    }

    public boolean removeExactly(Object obj, int i11) {
        int i12;
        int i13;
        if (i11 == 0) {
            return true;
        }
        e2.d(i11, "occurrences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.v(this.countMap, obj);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i12 = atomicInteger.get();
            if (i12 < i11) {
                return false;
            }
            i13 = i12 - i11;
        } while (!atomicInteger.compareAndSet(i12, i13));
        if (i13 == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return true;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.l3
    public int setCount(E e11, int i11) {
        AtomicInteger atomicInteger;
        int i12;
        AtomicInteger atomicInteger2;
        com.google.common.base.m.o(e11);
        e2.b(i11, "count");
        do {
            atomicInteger = (AtomicInteger) Maps.v(this.countMap, e11);
            if (atomicInteger == null && (i11 == 0 || (atomicInteger = this.countMap.putIfAbsent(e11, new AtomicInteger(i11))) == null)) {
                return 0;
            }
            do {
                i12 = atomicInteger.get();
                if (i12 == 0) {
                    if (i11 != 0) {
                        atomicInteger2 = new AtomicInteger(i11);
                        if (this.countMap.putIfAbsent(e11, atomicInteger2) == null) {
                            break;
                        }
                    } else {
                        return 0;
                    }
                }
            } while (!atomicInteger.compareAndSet(i12, i11));
            if (i11 == 0) {
                this.countMap.remove(e11, atomicInteger);
            }
            return i12;
        } while (!this.countMap.replace(e11, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.l3
    public boolean setCount(E e11, int i11, int i12) {
        com.google.common.base.m.o(e11);
        e2.b(i11, "oldCount");
        e2.b(i12, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.v(this.countMap, e11);
        if (atomicInteger == null) {
            if (i11 != 0) {
                return false;
            }
            return i12 == 0 || this.countMap.putIfAbsent(e11, new AtomicInteger(i12)) == null;
        }
        int i13 = atomicInteger.get();
        if (i13 == i11) {
            if (i13 == 0) {
                if (i12 == 0) {
                    this.countMap.remove(e11, atomicInteger);
                    return true;
                }
                AtomicInteger atomicInteger2 = new AtomicInteger(i12);
                return this.countMap.putIfAbsent(e11, atomicInteger2) == null || this.countMap.replace(e11, atomicInteger, atomicInteger2);
            }
            if (atomicInteger.compareAndSet(i13, i12)) {
                if (i12 == 0) {
                    this.countMap.remove(e11, atomicInteger);
                }
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.l3
    public int size() {
        long j11 = 0;
        while (this.countMap.values().iterator().hasNext()) {
            j11 += r0.next().get();
        }
        return Ints.n(j11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return snapshot().toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) snapshot().toArray(tArr);
    }
}
