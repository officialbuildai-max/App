package com.google.common.collect;

import com.google.common.collect.l3;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class AbstractMapBasedMultiset<E> extends d implements Serializable {
    private static final long serialVersionUID = 0;
    transient o3 backingMap;
    transient long size;

    /* loaded from: classes4.dex */
    class a extends c {
        a() {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultiset.c
        Object b(int i11) {
            return AbstractMapBasedMultiset.this.backingMap.i(i11);
        }
    }

    /* loaded from: classes4.dex */
    class b extends c {
        b() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultiset.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public l3.a b(int i11) {
            return AbstractMapBasedMultiset.this.backingMap.g(i11);
        }
    }

    /* loaded from: classes4.dex */
    abstract class c implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        int f30362a;

        /* renamed from: b, reason: collision with root package name */
        int f30363b = -1;

        /* renamed from: c, reason: collision with root package name */
        int f30364c;

        c() {
            this.f30362a = AbstractMapBasedMultiset.this.backingMap.e();
            this.f30364c = AbstractMapBasedMultiset.this.backingMap.f30889d;
        }

        private void a() {
            if (AbstractMapBasedMultiset.this.backingMap.f30889d != this.f30364c) {
                throw new ConcurrentModificationException();
            }
        }

        abstract Object b(int i11);

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f30362a >= 0;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object b11 = b(this.f30362a);
            int i11 = this.f30362a;
            this.f30363b = i11;
            this.f30362a = AbstractMapBasedMultiset.this.backingMap.s(i11);
            return b11;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            e2.e(this.f30363b != -1);
            AbstractMapBasedMultiset.this.size -= r0.backingMap.x(this.f30363b);
            this.f30362a = AbstractMapBasedMultiset.this.backingMap.t(this.f30362a, this.f30363b);
            this.f30363b = -1;
            this.f30364c = AbstractMapBasedMultiset.this.backingMap.f30889d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractMapBasedMultiset(int i11) {
        this.backingMap = newBackingMap(i11);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int h11 = w3.h(objectInputStream);
        this.backingMap = newBackingMap(3);
        w3.g(this, objectInputStream, h11);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        w3.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.l3
    public final int add(E e11, int i11) {
        if (i11 == 0) {
            return count(e11);
        }
        com.google.common.base.m.f(i11 > 0, "occurrences cannot be negative: %s", i11);
        int m11 = this.backingMap.m(e11);
        if (m11 == -1) {
            this.backingMap.u(e11, i11);
            this.size += i11;
            return 0;
        }
        int k11 = this.backingMap.k(m11);
        long j11 = i11;
        long j12 = k11 + j11;
        com.google.common.base.m.h(j12 <= 2147483647L, "too many occurrences: %s", j12);
        this.backingMap.B(m11, (int) j12);
        this.size += j11;
        return k11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addTo(l3 l3Var) {
        com.google.common.base.m.o(l3Var);
        int e11 = this.backingMap.e();
        while (e11 >= 0) {
            l3Var.add(this.backingMap.i(e11), this.backingMap.k(e11));
            e11 = this.backingMap.s(e11);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backingMap.a();
        this.size = 0L;
    }

    @Override // com.google.common.collect.l3
    public final int count(Object obj) {
        return this.backingMap.f(obj);
    }

    @Override // com.google.common.collect.d
    final int distinctElements() {
        return this.backingMap.C();
    }

    @Override // com.google.common.collect.d
    final Iterator<E> elementIterator() {
        return new a();
    }

    @Override // com.google.common.collect.d
    final Iterator<l3.a> entryIterator() {
        return new b();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        return Multisets.i(this);
    }

    abstract o3 newBackingMap(int i11);

    @Override // com.google.common.collect.d, com.google.common.collect.l3
    public final int remove(Object obj, int i11) {
        if (i11 == 0) {
            return count(obj);
        }
        com.google.common.base.m.f(i11 > 0, "occurrences cannot be negative: %s", i11);
        int m11 = this.backingMap.m(obj);
        if (m11 == -1) {
            return 0;
        }
        int k11 = this.backingMap.k(m11);
        if (k11 > i11) {
            this.backingMap.B(m11, k11 - i11);
        } else {
            this.backingMap.x(m11);
            i11 = k11;
        }
        this.size -= i11;
        return k11;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.l3
    public final int setCount(E e11, int i11) {
        e2.b(i11, "count");
        o3 o3Var = this.backingMap;
        int v11 = i11 == 0 ? o3Var.v(e11) : o3Var.u(e11, i11);
        this.size += i11 - v11;
        return v11;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.l3
    public final boolean setCount(E e11, int i11, int i12) {
        e2.b(i11, "oldCount");
        e2.b(i12, "newCount");
        int m11 = this.backingMap.m(e11);
        if (m11 == -1) {
            if (i11 != 0) {
                return false;
            }
            if (i12 > 0) {
                this.backingMap.u(e11, i12);
                this.size += i12;
            }
            return true;
        }
        if (this.backingMap.k(m11) != i11) {
            return false;
        }
        if (i12 == 0) {
            this.backingMap.x(m11);
            this.size -= i11;
        } else {
            this.backingMap.B(m11, i12);
            this.size += i12 - i11;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.l3
    public final int size() {
        return Ints.n(this.size);
    }
}
