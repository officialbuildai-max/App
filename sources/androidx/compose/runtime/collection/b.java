package androidx.compose.runtime.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* loaded from: classes.dex */
public final class b implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final int f3755d = 8;

    /* renamed from: a, reason: collision with root package name */
    private Object[] f3756a;

    /* renamed from: b, reason: collision with root package name */
    private List f3757b;

    /* renamed from: c, reason: collision with root package name */
    private int f3758c;

    /* loaded from: classes.dex */
    private static final class a implements List, KMutableList {

        /* renamed from: a, reason: collision with root package name */
        private final b f3759a;

        public a(b bVar) {
            this.f3759a = bVar;
        }

        public int a() {
            return this.f3759a.n();
        }

        @Override // java.util.List
        public void add(int i11, Object obj) {
            this.f3759a.a(i11, obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(Object obj) {
            return this.f3759a.b(obj);
        }

        @Override // java.util.List
        public boolean addAll(int i11, Collection collection) {
            return this.f3759a.d(i11, collection);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection collection) {
            return this.f3759a.f(collection);
        }

        public Object c(int i11) {
            androidx.compose.runtime.collection.c.c(this, i11);
            return this.f3759a.v(i11);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.f3759a.h();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            return this.f3759a.i(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection collection) {
            return this.f3759a.j(collection);
        }

        @Override // java.util.List
        public Object get(int i11) {
            androidx.compose.runtime.collection.c.c(this, i11);
            return this.f3759a.m()[i11];
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return this.f3759a.o(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.f3759a.p();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new c(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return this.f3759a.s(obj);
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            return new c(this, 0);
        }

        @Override // java.util.List
        public ListIterator listIterator(int i11) {
            return new c(this, i11);
        }

        @Override // java.util.List
        public final /* bridge */ Object remove(int i11) {
            return c(i11);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            return this.f3759a.t(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection collection) {
            return this.f3759a.u(collection);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection collection) {
            return this.f3759a.x(collection);
        }

        @Override // java.util.List
        public Object set(int i11, Object obj) {
            androidx.compose.runtime.collection.c.c(this, i11);
            return this.f3759a.y(i11, obj);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return a();
        }

        @Override // java.util.List
        public List subList(int i11, int i12) {
            androidx.compose.runtime.collection.c.d(this, i11, i12);
            return new C0040b(this, i11, i12);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.a(this);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return CollectionToArray.b(this, objArr);
        }
    }

    /* renamed from: androidx.compose.runtime.collection.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class C0040b implements List, KMutableList {

        /* renamed from: a, reason: collision with root package name */
        private final List f3760a;

        /* renamed from: b, reason: collision with root package name */
        private final int f3761b;

        /* renamed from: c, reason: collision with root package name */
        private int f3762c;

        public C0040b(List list, int i11, int i12) {
            this.f3760a = list;
            this.f3761b = i11;
            this.f3762c = i12;
        }

        public int a() {
            return this.f3762c - this.f3761b;
        }

        @Override // java.util.List
        public void add(int i11, Object obj) {
            this.f3760a.add(i11 + this.f3761b, obj);
            this.f3762c++;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(Object obj) {
            List list = this.f3760a;
            int i11 = this.f3762c;
            this.f3762c = i11 + 1;
            list.add(i11, obj);
            return true;
        }

        @Override // java.util.List
        public boolean addAll(int i11, Collection collection) {
            this.f3760a.addAll(i11 + this.f3761b, collection);
            this.f3762c += collection.size();
            return collection.size() > 0;
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection collection) {
            this.f3760a.addAll(this.f3762c, collection);
            this.f3762c += collection.size();
            return collection.size() > 0;
        }

        public Object c(int i11) {
            androidx.compose.runtime.collection.c.c(this, i11);
            this.f3762c--;
            return this.f3760a.remove(i11 + this.f3761b);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int i11 = this.f3762c - 1;
            int i12 = this.f3761b;
            if (i12 <= i11) {
                while (true) {
                    this.f3760a.remove(i11);
                    if (i11 == i12) {
                        break;
                    } else {
                        i11--;
                    }
                }
            }
            this.f3762c = this.f3761b;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            int i11 = this.f3762c;
            for (int i12 = this.f3761b; i12 < i11; i12++) {
                if (Intrinsics.c(this.f3760a.get(i12), obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public Object get(int i11) {
            androidx.compose.runtime.collection.c.c(this, i11);
            return this.f3760a.get(i11 + this.f3761b);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int i11 = this.f3762c;
            for (int i12 = this.f3761b; i12 < i11; i12++) {
                if (Intrinsics.c(this.f3760a.get(i12), obj)) {
                    return i12 - this.f3761b;
                }
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.f3762c == this.f3761b;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new c(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int i11 = this.f3762c - 1;
            int i12 = this.f3761b;
            if (i12 > i11) {
                return -1;
            }
            while (!Intrinsics.c(this.f3760a.get(i11), obj)) {
                if (i11 == i12) {
                    return -1;
                }
                i11--;
            }
            return i11 - this.f3761b;
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            return new c(this, 0);
        }

        @Override // java.util.List
        public ListIterator listIterator(int i11) {
            return new c(this, i11);
        }

        @Override // java.util.List
        public final /* bridge */ Object remove(int i11) {
            return c(i11);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            int i11 = this.f3762c;
            for (int i12 = this.f3761b; i12 < i11; i12++) {
                if (Intrinsics.c(this.f3760a.get(i12), obj)) {
                    this.f3760a.remove(i12);
                    this.f3762c--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection collection) {
            int i11 = this.f3762c;
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            return i11 != this.f3762c;
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection collection) {
            int i11 = this.f3762c;
            int i12 = i11 - 1;
            int i13 = this.f3761b;
            if (i13 <= i12) {
                while (true) {
                    if (!collection.contains(this.f3760a.get(i12))) {
                        this.f3760a.remove(i12);
                        this.f3762c--;
                    }
                    if (i12 == i13) {
                        break;
                    }
                    i12--;
                }
            }
            return i11 != this.f3762c;
        }

        @Override // java.util.List
        public Object set(int i11, Object obj) {
            androidx.compose.runtime.collection.c.c(this, i11);
            return this.f3760a.set(i11 + this.f3761b, obj);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return a();
        }

        @Override // java.util.List
        public List subList(int i11, int i12) {
            androidx.compose.runtime.collection.c.d(this, i11, i12);
            return new C0040b(this, i11, i12);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.a(this);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return CollectionToArray.b(this, objArr);
        }
    }

    /* loaded from: classes.dex */
    private static final class c implements ListIterator, KMutableListIterator {

        /* renamed from: a, reason: collision with root package name */
        private final List f3763a;

        /* renamed from: b, reason: collision with root package name */
        private int f3764b;

        public c(List list, int i11) {
            this.f3763a = list;
            this.f3764b = i11;
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            this.f3763a.add(this.f3764b, obj);
            this.f3764b++;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f3764b < this.f3763a.size();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f3764b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            List list = this.f3763a;
            int i11 = this.f3764b;
            this.f3764b = i11 + 1;
            return list.get(i11);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f3764b;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            int i11 = this.f3764b - 1;
            this.f3764b = i11;
            return this.f3763a.get(i11);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f3764b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i11 = this.f3764b - 1;
            this.f3764b = i11;
            this.f3763a.remove(i11);
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            this.f3763a.set(this.f3764b, obj);
        }
    }

    public b(Object[] objArr, int i11) {
        this.f3756a = objArr;
        this.f3758c = i11;
    }

    public final void A(Comparator comparator) {
        ArraysKt.H(this.f3756a, comparator, 0, this.f3758c);
    }

    public final void a(int i11, Object obj) {
        k(this.f3758c + 1);
        Object[] objArr = this.f3756a;
        int i12 = this.f3758c;
        if (i11 != i12) {
            ArraysKt.n(objArr, objArr, i11 + 1, i11, i12);
        }
        objArr[i11] = obj;
        this.f3758c++;
    }

    public final boolean b(Object obj) {
        k(this.f3758c + 1);
        Object[] objArr = this.f3756a;
        int i11 = this.f3758c;
        objArr[i11] = obj;
        this.f3758c = i11 + 1;
        return true;
    }

    public final boolean c(int i11, b bVar) {
        if (bVar.p()) {
            return false;
        }
        k(this.f3758c + bVar.f3758c);
        Object[] objArr = this.f3756a;
        int i12 = this.f3758c;
        if (i11 != i12) {
            ArraysKt.n(objArr, objArr, bVar.f3758c + i11, i11, i12);
        }
        ArraysKt.n(bVar.f3756a, objArr, i11, 0, bVar.f3758c);
        this.f3758c += bVar.f3758c;
        return true;
    }

    public final boolean d(int i11, Collection collection) {
        int i12 = 0;
        if (collection.isEmpty()) {
            return false;
        }
        k(this.f3758c + collection.size());
        Object[] objArr = this.f3756a;
        if (i11 != this.f3758c) {
            ArraysKt.n(objArr, objArr, collection.size() + i11, i11, this.f3758c);
        }
        for (Object obj : collection) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt.u();
            }
            objArr[i12 + i11] = obj;
            i12 = i13;
        }
        this.f3758c += collection.size();
        return true;
    }

    public final boolean e(int i11, List list) {
        if (list.isEmpty()) {
            return false;
        }
        k(this.f3758c + list.size());
        Object[] objArr = this.f3756a;
        if (i11 != this.f3758c) {
            ArraysKt.n(objArr, objArr, list.size() + i11, i11, this.f3758c);
        }
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            objArr[i11 + i12] = list.get(i12);
        }
        this.f3758c += list.size();
        return true;
    }

    public final boolean f(Collection collection) {
        return d(this.f3758c, collection);
    }

    public final List g() {
        List list = this.f3757b;
        if (list != null) {
            return list;
        }
        a aVar = new a(this);
        this.f3757b = aVar;
        return aVar;
    }

    public final void h() {
        Object[] objArr = this.f3756a;
        int n11 = n();
        while (true) {
            n11--;
            if (-1 >= n11) {
                this.f3758c = 0;
                return;
            }
            objArr[n11] = null;
        }
    }

    public final boolean i(Object obj) {
        int n11 = n() - 1;
        if (n11 >= 0) {
            for (int i11 = 0; !Intrinsics.c(m()[i11], obj); i11++) {
                if (i11 != n11) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean j(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!i(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void k(int i11) {
        Object[] objArr = this.f3756a;
        if (objArr.length < i11) {
            Object[] copyOf = Arrays.copyOf(objArr, Math.max(i11, objArr.length * 2));
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f3756a = copyOf;
        }
    }

    public final Object l() {
        if (p()) {
            throw new NoSuchElementException("MutableVector is empty.");
        }
        return m()[0];
    }

    public final Object[] m() {
        return this.f3756a;
    }

    public final int n() {
        return this.f3758c;
    }

    public final int o(Object obj) {
        int i11 = this.f3758c;
        if (i11 <= 0) {
            return -1;
        }
        Object[] objArr = this.f3756a;
        int i12 = 0;
        while (!Intrinsics.c(obj, objArr[i12])) {
            i12++;
            if (i12 >= i11) {
                return -1;
            }
        }
        return i12;
    }

    public final boolean p() {
        return this.f3758c == 0;
    }

    public final boolean q() {
        return this.f3758c != 0;
    }

    public final Object r() {
        if (p()) {
            throw new NoSuchElementException("MutableVector is empty.");
        }
        return m()[n() - 1];
    }

    public final int s(Object obj) {
        int i11 = this.f3758c;
        if (i11 <= 0) {
            return -1;
        }
        int i12 = i11 - 1;
        Object[] objArr = this.f3756a;
        while (!Intrinsics.c(obj, objArr[i12])) {
            i12--;
            if (i12 < 0) {
                return -1;
            }
        }
        return i12;
    }

    public final boolean t(Object obj) {
        int o11 = o(obj);
        if (o11 < 0) {
            return false;
        }
        v(o11);
        return true;
    }

    public final boolean u(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int i11 = this.f3758c;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            t(it.next());
        }
        return i11 != this.f3758c;
    }

    public final Object v(int i11) {
        Object[] objArr = this.f3756a;
        Object obj = objArr[i11];
        if (i11 != n() - 1) {
            ArraysKt.n(objArr, objArr, i11, i11 + 1, this.f3758c);
        }
        int i12 = this.f3758c - 1;
        this.f3758c = i12;
        objArr[i12] = null;
        return obj;
    }

    public final void w(int i11, int i12) {
        if (i12 > i11) {
            int i13 = this.f3758c;
            if (i12 < i13) {
                Object[] objArr = this.f3756a;
                ArraysKt.n(objArr, objArr, i11, i12, i13);
            }
            int i14 = this.f3758c - (i12 - i11);
            int n11 = n() - 1;
            if (i14 <= n11) {
                int i15 = i14;
                while (true) {
                    this.f3756a[i15] = null;
                    if (i15 == n11) {
                        break;
                    } else {
                        i15++;
                    }
                }
            }
            this.f3758c = i14;
        }
    }

    public final boolean x(Collection collection) {
        int i11 = this.f3758c;
        for (int n11 = n() - 1; -1 < n11; n11--) {
            if (!collection.contains(m()[n11])) {
                v(n11);
            }
        }
        return i11 != this.f3758c;
    }

    public final Object y(int i11, Object obj) {
        Object[] objArr = this.f3756a;
        Object obj2 = objArr[i11];
        objArr[i11] = obj;
        return obj2;
    }

    public final void z(int i11) {
        this.f3758c = i11;
    }
}
