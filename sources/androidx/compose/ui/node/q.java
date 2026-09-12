package androidx.compose.ui.node;

import androidx.compose.ui.f;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
public final class q implements List, KMappedMarker {

    /* renamed from: d, reason: collision with root package name */
    private int f5499d;

    /* renamed from: a, reason: collision with root package name */
    private Object[] f5496a = new Object[16];

    /* renamed from: b, reason: collision with root package name */
    private long[] f5497b = new long[16];

    /* renamed from: c, reason: collision with root package name */
    private int f5498c = -1;

    /* renamed from: e, reason: collision with root package name */
    private boolean f5500e = true;

    /* loaded from: classes.dex */
    private final class a implements ListIterator, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        private int f5501a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5502b;

        /* renamed from: c, reason: collision with root package name */
        private final int f5503c;

        public a(int i11, int i12, int i13) {
            this.f5501a = i11;
            this.f5502b = i12;
            this.f5503c = i13;
        }

        public /* synthetic */ a(q qVar, int i11, int i12, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
            this((i14 & 1) != 0 ? 0 : i11, (i14 & 2) != 0 ? 0 : i12, (i14 & 4) != 0 ? qVar.size() : i13);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f.c next() {
            Object[] objArr = q.this.f5496a;
            int i11 = this.f5501a;
            this.f5501a = i11 + 1;
            Object obj = objArr[i11];
            Intrinsics.f(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (f.c) obj;
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public f.c previous() {
            Object[] objArr = q.this.f5496a;
            int i11 = this.f5501a - 1;
            this.f5501a = i11;
            Object obj = objArr[i11];
            Intrinsics.f(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (f.c) obj;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f5501a < this.f5503c;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f5501a > this.f5502b;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f5501a - this.f5502b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return (this.f5501a - this.f5502b) - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* loaded from: classes.dex */
    private final class b implements List, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        private final int f5505a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5506b;

        public b(int i11, int i12) {
            this.f5505a = i11;
            this.f5506b = i12;
        }

        public boolean a(f.c cVar) {
            return indexOf(cVar) != -1;
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ void add(int i11, Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public boolean addAll(int i11, Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public f.c get(int i11) {
            Object obj = q.this.f5496a[i11 + this.f5505a];
            Intrinsics.f(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (f.c) obj;
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof f.c) {
                return a((f.c) obj);
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains((f.c) it.next())) {
                    return false;
                }
            }
            return true;
        }

        public int e() {
            return this.f5506b - this.f5505a;
        }

        public int f(f.c cVar) {
            int i11 = this.f5505a;
            int i12 = this.f5506b;
            if (i11 > i12) {
                return -1;
            }
            while (!Intrinsics.c(q.this.f5496a[i11], cVar)) {
                if (i11 == i12) {
                    return -1;
                }
                i11++;
            }
            return i11 - this.f5505a;
        }

        public int h(f.c cVar) {
            int i11 = this.f5506b;
            int i12 = this.f5505a;
            if (i12 > i11) {
                return -1;
            }
            while (!Intrinsics.c(q.this.f5496a[i11], cVar)) {
                if (i11 == i12) {
                    return -1;
                }
                i11--;
            }
            return i11 - this.f5505a;
        }

        @Override // java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof f.c) {
                return f((f.c) obj);
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            q qVar = q.this;
            int i11 = this.f5505a;
            return new a(i11, i11, this.f5506b);
        }

        @Override // java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof f.c) {
                return h((f.c) obj);
            }
            return -1;
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            q qVar = q.this;
            int i11 = this.f5505a;
            return new a(i11, i11, this.f5506b);
        }

        @Override // java.util.List
        public ListIterator listIterator(int i11) {
            q qVar = q.this;
            int i12 = this.f5505a;
            return new a(i11 + i12, i12, this.f5506b);
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Object remove(int i11) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator unaryOperator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Object set(int i11, Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return e();
        }

        @Override // java.util.List
        public void sort(Comparator comparator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public List subList(int i11, int i12) {
            q qVar = q.this;
            int i13 = this.f5505a;
            return new b(i11 + i13, i13 + i12);
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

    private final void j() {
        int i11 = this.f5498c;
        Object[] objArr = this.f5496a;
        if (i11 >= objArr.length) {
            int length = objArr.length + 16;
            Object[] copyOf = Arrays.copyOf(objArr, length);
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f5496a = copyOf;
            long[] copyOf2 = Arrays.copyOf(this.f5497b, length);
            Intrinsics.g(copyOf2, "copyOf(this, newSize)");
            this.f5497b = copyOf2;
        }
    }

    private final long l() {
        long a11;
        a11 = r.a(Float.POSITIVE_INFINITY, false);
        int i11 = this.f5498c + 1;
        int n11 = CollectionsKt.n(this);
        if (i11 <= n11) {
            while (true) {
                long b11 = l.b(this.f5497b[i11]);
                if (l.a(b11, a11) < 0) {
                    a11 = b11;
                }
                if (l.c(a11) < 0.0f && l.d(a11)) {
                    return a11;
                }
                if (i11 == n11) {
                    break;
                }
                i11++;
            }
        }
        return a11;
    }

    private final void v() {
        int i11 = this.f5498c + 1;
        int n11 = CollectionsKt.n(this);
        if (i11 <= n11) {
            while (true) {
                this.f5496a[i11] = null;
                if (i11 == n11) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        this.f5499d = this.f5498c + 1;
    }

    public final void a() {
        this.f5498c = size() - 1;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i11, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i11, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.f5498c = -1;
        v();
        this.f5500e = true;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof f.c) {
            return h((f.c) obj);
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains((f.c) it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean h(f.c cVar) {
        return indexOf(cVar) != -1;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof f.c) {
            return s((f.c) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new a(this, 0, 0, 0, 7, null);
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof f.c) {
            return u((f.c) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return new a(this, 0, 0, 0, 7, null);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i11) {
        return new a(this, i11, 0, 0, 6, null);
    }

    @Override // java.util.List
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public f.c get(int i11) {
        Object obj = this.f5496a[i11];
        Intrinsics.f(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
        return (f.c) obj;
    }

    public final boolean n() {
        return this.f5500e;
    }

    public int o() {
        return this.f5499d;
    }

    public final boolean p() {
        long l11 = l();
        return l.c(l11) < 0.0f && l.d(l11);
    }

    public final void q(f.c cVar, boolean z10, Function0 function0) {
        r(cVar, -1.0f, z10, function0);
        NodeCoordinator c12 = cVar.c1();
        if (c12 == null || c12.F2()) {
            return;
        }
        this.f5500e = false;
    }

    public final void r(f.c cVar, float f11, boolean z10, Function0 function0) {
        long a11;
        int i11 = this.f5498c;
        this.f5498c = i11 + 1;
        j();
        Object[] objArr = this.f5496a;
        int i12 = this.f5498c;
        objArr[i12] = cVar;
        long[] jArr = this.f5497b;
        a11 = r.a(f11, z10);
        jArr[i12] = a11;
        v();
        function0.invoke();
        this.f5498c = i11;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object remove(int i11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int s(f.c cVar) {
        int n11 = CollectionsKt.n(this);
        if (n11 < 0) {
            return -1;
        }
        int i11 = 0;
        while (!Intrinsics.c(this.f5496a[i11], cVar)) {
            if (i11 == n11) {
                return -1;
            }
            i11++;
        }
        return i11;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object set(int i11, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return o();
    }

    @Override // java.util.List
    public void sort(Comparator comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List subList(int i11, int i12) {
        return new b(i11, i12);
    }

    public final boolean t(float f11, boolean z10) {
        long a11;
        if (this.f5498c == CollectionsKt.n(this)) {
            return true;
        }
        a11 = r.a(f11, z10);
        return l.a(l(), a11) > 0;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return CollectionToArray.b(this, objArr);
    }

    public int u(f.c cVar) {
        for (int n11 = CollectionsKt.n(this); -1 < n11; n11--) {
            if (Intrinsics.c(this.f5496a[n11], cVar)) {
                return n11;
            }
        }
        return -1;
    }

    public final void w(f.c cVar, float f11, boolean z10, Function0 function0) {
        if (this.f5498c == CollectionsKt.n(this)) {
            r(cVar, f11, z10, function0);
            if (this.f5498c + 1 == CollectionsKt.n(this)) {
                v();
                return;
            }
            return;
        }
        long l11 = l();
        int i11 = this.f5498c;
        this.f5498c = CollectionsKt.n(this);
        r(cVar, f11, z10, function0);
        if (this.f5498c + 1 < CollectionsKt.n(this) && l.a(l11, l()) > 0) {
            int i12 = this.f5498c + 1;
            int i13 = i11 + 1;
            Object[] objArr = this.f5496a;
            ArraysKt.n(objArr, objArr, i13, i12, size());
            long[] jArr = this.f5497b;
            ArraysKt.m(jArr, jArr, i13, i12, size());
            this.f5498c = ((size() + i11) - this.f5498c) - 1;
        }
        v();
        this.f5498c = i11;
    }
}
