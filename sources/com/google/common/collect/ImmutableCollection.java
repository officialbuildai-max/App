package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;

/* loaded from: classes.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    static final int SPLITERATOR_CHARACTERISTICS = 1296;
    private static final long serialVersionUID = 912559;

    /* loaded from: classes4.dex */
    static abstract class a extends b {

        /* renamed from: a, reason: collision with root package name */
        Object[] f30462a;

        /* renamed from: b, reason: collision with root package name */
        int f30463b;

        /* renamed from: c, reason: collision with root package name */
        boolean f30464c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i11) {
            e2.b(i11, "initialCapacity");
            this.f30462a = new Object[i11];
            this.f30463b = 0;
        }

        private void i(int i11) {
            Object[] objArr = this.f30462a;
            int f11 = b.f(objArr.length, this.f30463b + i11);
            if (f11 > objArr.length || this.f30464c) {
                this.f30462a = Arrays.copyOf(this.f30462a, f11);
                this.f30464c = false;
            }
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        public b b(Object... objArr) {
            h(objArr, objArr.length);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        public b c(Iterable iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                i(collection.size());
                if (collection instanceof ImmutableCollection) {
                    this.f30463b = ((ImmutableCollection) collection).copyIntoArray(this.f30462a, this.f30463b);
                    return this;
                }
            }
            super.c(iterable);
            return this;
        }

        public a g(Object obj) {
            com.google.common.base.m.o(obj);
            i(1);
            Object[] objArr = this.f30462a;
            int i11 = this.f30463b;
            this.f30463b = i11 + 1;
            objArr[i11] = obj;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void h(Object[] objArr, int i11) {
            n3.c(objArr, i11);
            i(i11);
            System.arraycopy(objArr, 0, this.f30462a, this.f30463b, i11);
            this.f30463b += i11;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static int f(int i11, int i12) {
            if (i12 < 0) {
                throw new IllegalArgumentException("cannot store more than MAX_VALUE elements");
            }
            if (i12 <= i11) {
                return i11;
            }
            int i13 = i11 + (i11 >> 1) + 1;
            if (i13 < i12) {
                i13 = Integer.highestOneBit(i12 - 1) << 1;
            }
            if (i13 < 0) {
                return Integer.MAX_VALUE;
            }
            return i13;
        }

        public abstract b a(Object obj);

        public b b(Object... objArr) {
            for (Object obj : objArr) {
                a(obj);
            }
            return this;
        }

        public b c(Iterable iterable) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public b d(Iterator it) {
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public abstract ImmutableCollection e();
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        return isEmpty() ? ImmutableList.of() : ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public int copyIntoArray(Object[] objArr, int i11) {
        r4 it = iterator();
        while (it.hasNext()) {
            objArr[i11] = it.next();
            i11++;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object[] internalArray() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract r4 iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        Spliterator<E> spliterator;
        spliterator = Spliterators.spliterator(this, SPLITERATOR_CHARACTERISTICS);
        return spliterator;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(EMPTY_ARRAY);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        com.google.common.base.m.o(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] internalArray = internalArray();
            if (internalArray != null) {
                return (T[]) r3.a(internalArray, internalArrayStart(), internalArrayEnd(), tArr);
            }
            tArr = (T[]) n3.e(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }
}
