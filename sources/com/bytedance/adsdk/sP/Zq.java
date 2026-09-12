package com.bytedance.adsdk.sP;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes2.dex */
abstract class Zq<K, V> {
    Zq<K, V>.sP sP;

    /* loaded from: classes2.dex */
    final class Sj<T> implements Iterator<T> {
        boolean EjP = false;
        final int Sj;
        int TKC;
        int sP;

        Sj(int i11) {
            this.Sj = i11;
            this.sP = Zq.this.Sj();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.TKC < this.sP;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t11 = (T) Zq.this.Sj(this.TKC, this.Sj);
            this.TKC++;
            this.EjP = true;
            return t11;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.EjP) {
                throw new IllegalStateException();
            }
            int i11 = this.TKC - 1;
            this.TKC = i11;
            this.sP--;
            this.EjP = false;
            Zq.this.Sj(i11);
        }
    }

    /* loaded from: classes2.dex */
    final class sP implements Set<K> {
        sP() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k11) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            Zq.this.TKC();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return Zq.this.Sj(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return Zq.Sj(Zq.this.sP(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return Zq.Sj(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i11 = 0;
            for (int Sj = Zq.this.Sj() - 1; Sj >= 0; Sj--) {
                Object Sj2 = Zq.this.Sj(Sj, 0);
                i11 += Sj2 == null ? 0 : Sj2.hashCode();
            }
            return i11;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return Zq.this.Sj() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new Sj(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int Sj = Zq.this.Sj(obj);
            if (Sj < 0) {
                return false;
            }
            Zq.this.Sj(Sj);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return Zq.sP(Zq.this.sP(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return Zq.TKC(Zq.this.sP(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return Zq.this.Sj();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return Zq.this.sP(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) Zq.this.Sj(tArr, 0);
        }
    }

    public static <K, V> boolean Sj(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean Sj(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean TKC(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public static <K, V> boolean sP(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public Set<K> EjP() {
        if (this.sP == null) {
            this.sP = new sP();
        }
        return this.sP;
    }

    protected abstract int Sj();

    protected abstract int Sj(Object obj);

    protected abstract Object Sj(int i11, int i12);

    protected abstract void Sj(int i11);

    public <T> T[] Sj(T[] tArr, int i11) {
        int Sj2 = Sj();
        if (tArr.length < Sj2) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), Sj2));
        }
        for (int i12 = 0; i12 < Sj2; i12++) {
            tArr[i12] = Sj(i12, i11);
        }
        if (tArr.length > Sj2) {
            tArr[Sj2] = null;
        }
        return tArr;
    }

    protected abstract void TKC();

    protected abstract Map<K, V> sP();

    public Object[] sP(int i11) {
        int Sj2 = Sj();
        Object[] objArr = new Object[Sj2];
        for (int i12 = 0; i12 < Sj2; i12++) {
            objArr[i12] = Sj(i12, i11);
        }
        return objArr;
    }
}
