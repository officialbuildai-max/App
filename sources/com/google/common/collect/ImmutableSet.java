package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.stream.Collector;

/* loaded from: classes.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    static final int MAX_TABLE_SIZE = 1073741824;
    private static final long serialVersionUID = 912559;
    private transient ImmutableList<E> asList;

    /* loaded from: classes4.dex */
    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends ImmutableCollection.a {

        /* renamed from: d, reason: collision with root package name */
        Object[] f30513d;

        /* renamed from: e, reason: collision with root package name */
        private int f30514e;

        public a() {
            super(4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i11, boolean z10) {
            super(i11);
            if (z10) {
                this.f30513d = new Object[ImmutableSet.chooseTableSize(i11)];
            }
        }

        private void n(Object obj) {
            Objects.requireNonNull(this.f30513d);
            int length = this.f30513d.length - 1;
            int hashCode = obj.hashCode();
            int c11 = v2.c(hashCode);
            while (true) {
                int i11 = c11 & length;
                Object[] objArr = this.f30513d;
                Object obj2 = objArr[i11];
                if (obj2 == null) {
                    objArr[i11] = obj;
                    this.f30514e += hashCode;
                    super.g(obj);
                    return;
                } else if (obj2.equals(obj)) {
                    return;
                } else {
                    c11 = i11 + 1;
                }
            }
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public a a(Object obj) {
            com.google.common.base.m.o(obj);
            if (this.f30513d != null && ImmutableSet.chooseTableSize(this.f30463b) <= this.f30513d.length) {
                n(obj);
                return this;
            }
            this.f30513d = null;
            super.g(obj);
            return this;
        }

        public a k(Object... objArr) {
            if (this.f30513d != null) {
                for (Object obj : objArr) {
                    a(obj);
                }
            } else {
                super.b(objArr);
            }
            return this;
        }

        public a l(Iterable iterable) {
            com.google.common.base.m.o(iterable);
            if (this.f30513d != null) {
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            } else {
                super.c(iterable);
            }
            return this;
        }

        public a m(Iterator it) {
            com.google.common.base.m.o(it);
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public ImmutableSet e() {
            ImmutableSet construct;
            int i11 = this.f30463b;
            if (i11 == 0) {
                return ImmutableSet.of();
            }
            if (i11 == 1) {
                Object obj = this.f30462a[0];
                Objects.requireNonNull(obj);
                return ImmutableSet.of(obj);
            }
            if (this.f30513d == null || ImmutableSet.chooseTableSize(i11) != this.f30513d.length) {
                construct = ImmutableSet.construct(this.f30463b, this.f30462a);
                this.f30463b = construct.size();
            } else {
                Object[] copyOf = ImmutableSet.shouldTrim(this.f30463b, this.f30462a.length) ? Arrays.copyOf(this.f30462a, this.f30463b) : this.f30462a;
                construct = new RegularImmutableSet(copyOf, this.f30514e, this.f30513d, r5.length - 1, this.f30463b);
            }
            this.f30464c = true;
            this.f30513d = null;
            return construct;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a p(a aVar) {
            if (this.f30513d != null) {
                for (int i11 = 0; i11 < aVar.f30463b; i11++) {
                    Object obj = aVar.f30462a[i11];
                    Objects.requireNonNull(obj);
                    a(obj);
                }
            } else {
                h(aVar.f30462a, aVar.f30463b);
            }
            return this;
        }
    }

    public static <E> a builder() {
        return new a();
    }

    public static <E> a builderWithExpectedSize(int i11) {
        e2.b(i11, "expectedSize");
        return new a(i11, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int chooseTableSize(int i11) {
        int max = Math.max(i11, 2);
        if (max >= CUTOFF) {
            com.google.common.base.m.e(max < 1073741824, "collection too large");
            return 1073741824;
        }
        int highestOneBit = Integer.highestOneBit(max - 1) << 1;
        while (highestOneBit * DESIRED_LOAD_FACTOR < max) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ImmutableSet<E> construct(int i11, Object... objArr) {
        if (i11 == 0) {
            return of();
        }
        if (i11 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return of(obj);
        }
        int chooseTableSize = chooseTableSize(i11);
        Object[] objArr2 = new Object[chooseTableSize];
        int i12 = chooseTableSize - 1;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < i11; i15++) {
            Object a11 = n3.a(objArr[i15], i15);
            int hashCode = a11.hashCode();
            int c11 = v2.c(hashCode);
            while (true) {
                int i16 = c11 & i12;
                Object obj2 = objArr2[i16];
                if (obj2 == null) {
                    objArr[i14] = a11;
                    objArr2[i16] = a11;
                    i13 += hashCode;
                    i14++;
                    break;
                }
                if (obj2.equals(a11)) {
                    break;
                }
                c11++;
            }
        }
        Arrays.fill(objArr, i14, i11, (Object) null);
        if (i14 == 1) {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return new SingletonImmutableSet(obj3);
        }
        if (chooseTableSize(i14) < chooseTableSize / 2) {
            return construct(i14, objArr);
        }
        if (shouldTrim(i14, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i14);
        }
        return new RegularImmutableSet(objArr, i13, objArr2, i12, i14);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? copyOf((Collection) iterable) : copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        return !it.hasNext() ? of((Object) next) : new a().a(next).m(it).e();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        return length != 0 ? length != 1 ? construct(eArr.length, (Object[]) eArr.clone()) : of((Object) eArr[0]) : of();
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    public static <E> ImmutableSet<E> of(E e11) {
        return new SingletonImmutableSet(e11);
    }

    public static <E> ImmutableSet<E> of(E e11, E e12) {
        return construct(2, e11, e12);
    }

    public static <E> ImmutableSet<E> of(E e11, E e12, E e13) {
        return construct(3, e11, e12, e13);
    }

    public static <E> ImmutableSet<E> of(E e11, E e12, E e13, E e14) {
        return construct(4, e11, e12, e13, e14);
    }

    public static <E> ImmutableSet<E> of(E e11, E e12, E e13, E e14, E e15) {
        return construct(5, e11, e12, e13, e14, e15);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e11, E e12, E e13, E e14, E e15, E e16, E... eArr) {
        com.google.common.base.m.e(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e11;
        objArr[1] = e12;
        objArr[2] = e13;
        objArr[3] = e14;
        objArr[4] = e15;
        objArr[5] = e16;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return construct(length, objArr);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldTrim(int i11, int i12) {
        return i11 < (i12 >> 1) + (i12 >> 2);
    }

    public static <E> Collector<E, ?, ImmutableSet<E>> toImmutableSet() {
        return d2.V();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> createAsList = createAsList();
        this.asList = createAsList;
        return createAsList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.d(this);
    }

    boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract r4 iterator();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }
}
