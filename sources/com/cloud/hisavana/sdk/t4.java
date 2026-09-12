package com.cloud.hisavana.sdk;

import com.cloud.tmc.kernel.utils.UrlUtils;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class t4 {

    /* renamed from: a, reason: collision with root package name */
    b f23055a;

    /* renamed from: b, reason: collision with root package name */
    c f23056b;

    /* renamed from: c, reason: collision with root package name */
    e f23057c;

    /* loaded from: classes3.dex */
    final class a implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        final int f23058a;

        /* renamed from: b, reason: collision with root package name */
        int f23059b;

        /* renamed from: c, reason: collision with root package name */
        int f23060c;

        /* renamed from: d, reason: collision with root package name */
        boolean f23061d = false;

        a(int i11) {
            this.f23058a = i11;
            this.f23059b = t4.this.n();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f23060c < this.f23059b;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object b11 = t4.this.b(this.f23060c, this.f23058a);
            this.f23060c++;
            this.f23061d = true;
            return b11;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f23061d) {
                throw new IllegalStateException();
            }
            int i11 = this.f23060c - 1;
            this.f23060c = i11;
            this.f23059b--;
            this.f23061d = false;
            t4.this.e(i11);
        }
    }

    /* loaded from: classes3.dex */
    final class b implements Set {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            int n11 = t4.this.n();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                t4.this.f(entry.getKey(), entry.getValue());
            }
            return n11 != t4.this.n();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            t4.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int a11 = t4.this.a(entry.getKey());
            if (a11 < 0) {
                return false;
            }
            return Objects.equals(t4.this.b(a11, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return t4.h(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i11 = 0;
            for (int n11 = t4.this.n() - 1; n11 >= 0; n11--) {
                Object b11 = t4.this.b(n11, 0);
                Object b12 = t4.this.b(n11, 1);
                i11 += (b11 == null ? 0 : b11.hashCode()) ^ (b12 == null ? 0 : b12.hashCode());
            }
            return i11;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return t4.this.n() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return t4.this.n();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes3.dex */
    final class c implements Set {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            t4.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return t4.this.a(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            return t4.g(t4.this.k(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return t4.h(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i11 = 0;
            for (int n11 = t4.this.n() - 1; n11 >= 0; n11--) {
                Object b11 = t4.this.b(n11, 0);
                i11 += b11 == null ? 0 : b11.hashCode();
            }
            return i11;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return t4.this.n() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int a11 = t4.this.a(obj);
            if (a11 < 0) {
                return false;
            }
            t4.this.e(a11);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            return t4.l(t4.this.k(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            return t4.o(t4.this.k(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return t4.this.n();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return t4.this.m(0);
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return t4.this.i(objArr, 0);
        }
    }

    /* loaded from: classes3.dex */
    final class d implements Iterator, Map.Entry {

        /* renamed from: a, reason: collision with root package name */
        int f23065a;

        /* renamed from: c, reason: collision with root package name */
        boolean f23067c = false;

        /* renamed from: b, reason: collision with root package name */
        int f23066b = -1;

        d() {
            this.f23065a = t4.this.n() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f23066b++;
            this.f23067c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f23067c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return Objects.equals(entry.getKey(), t4.this.b(this.f23066b, 0)) && Objects.equals(entry.getValue(), t4.this.b(this.f23066b, 1));
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            if (this.f23067c) {
                return t4.this.b(this.f23066b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            if (this.f23067c) {
                return t4.this.b(this.f23066b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f23066b < this.f23065a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f23067c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object b11 = t4.this.b(this.f23066b, 0);
            Object b12 = t4.this.b(this.f23066b, 1);
            return (b11 == null ? 0 : b11.hashCode()) ^ (b12 != null ? b12.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f23067c) {
                throw new IllegalStateException();
            }
            t4.this.e(this.f23066b);
            this.f23066b--;
            this.f23065a--;
            this.f23067c = false;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (this.f23067c) {
                return t4.this.c(this.f23066b, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + UrlUtils.EQUAL_MARK + getValue();
        }
    }

    /* loaded from: classes3.dex */
    final class e implements Collection {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            t4.this.d();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return t4.this.j(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return t4.this.n() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int j11 = t4.this.j(obj);
            if (j11 < 0) {
                return false;
            }
            t4.this.e(j11);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection collection) {
            int n11 = t4.this.n();
            int i11 = 0;
            boolean z10 = false;
            while (i11 < n11) {
                if (collection.contains(t4.this.b(i11, 1))) {
                    t4.this.e(i11);
                    i11--;
                    n11--;
                    z10 = true;
                }
                i11++;
            }
            return z10;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection collection) {
            int n11 = t4.this.n();
            int i11 = 0;
            boolean z10 = false;
            while (i11 < n11) {
                if (!collection.contains(t4.this.b(i11, 1))) {
                    t4.this.e(i11);
                    i11--;
                    n11--;
                    z10 = true;
                }
                i11++;
            }
            return z10;
        }

        @Override // java.util.Collection
        public int size() {
            return t4.this.n();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return t4.this.m(1);
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return t4.this.i(objArr, 1);
        }
    }

    public static boolean g(Map map, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(Set set, Object obj) {
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
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static boolean l(Map map, Collection collection) {
        int size = map.size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static boolean o(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract int a(Object obj);

    protected abstract Object b(int i11, int i12);

    protected abstract Object c(int i11, Object obj);

    protected abstract void d();

    protected abstract void e(int i11);

    protected abstract void f(Object obj, Object obj2);

    public Object[] i(Object[] objArr, int i11) {
        int n11 = n();
        if (objArr.length < n11) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), n11);
        }
        for (int i12 = 0; i12 < n11; i12++) {
            objArr[i12] = b(i12, i11);
        }
        if (objArr.length > n11) {
            objArr[n11] = null;
        }
        return objArr;
    }

    protected abstract int j(Object obj);

    protected abstract Map k();

    public Object[] m(int i11) {
        int n11 = n();
        Object[] objArr = new Object[n11];
        for (int i12 = 0; i12 < n11; i12++) {
            objArr[i12] = b(i12, i11);
        }
        return objArr;
    }

    protected abstract int n();

    public Set p() {
        if (this.f23055a == null) {
            this.f23055a = new b();
        }
        return this.f23055a;
    }

    public Set q() {
        if (this.f23056b == null) {
            this.f23056b = new c();
        }
        return this.f23056b;
    }

    public Collection r() {
        if (this.f23057c == null) {
            this.f23057c = new e();
        }
        return this.f23057c;
    }
}
