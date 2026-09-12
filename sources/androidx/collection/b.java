package androidx.collection;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableSet;

/* loaded from: classes.dex */
public final class b implements Collection, Set, KMutableCollection, KMutableSet {

    /* renamed from: a, reason: collision with root package name */
    private int[] f2338a;

    /* renamed from: b, reason: collision with root package name */
    private Object[] f2339b;

    /* renamed from: c, reason: collision with root package name */
    private int f2340c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a extends k {
        public a() {
            super(b.this.h());
        }

        @Override // androidx.collection.k
        protected Object a(int i11) {
            return b.this.o(i11);
        }

        @Override // androidx.collection.k
        protected void c(int i11) {
            b.this.j(i11);
        }
    }

    @JvmOverloads
    public b() {
        this(0, 1, null);
    }

    public b(int i11) {
        this.f2338a = n.a.f70174a;
        this.f2339b = n.a.f70176c;
        if (i11 > 0) {
            d.a(this, i11);
        }
    }

    public /* synthetic */ b(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11);
    }

    public final void a(int i11) {
        int h11 = h();
        if (e().length < i11) {
            int[] e11 = e();
            Object[] c11 = c();
            d.a(this, i11);
            if (h() > 0) {
                ArraysKt.q(e11, e(), 0, 0, h(), 6, null);
                ArraysKt.r(c11, c(), 0, 0, h(), 6, null);
            }
        }
        if (h() != h11) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int i11;
        int c11;
        int h11 = h();
        if (obj == null) {
            c11 = d.d(this);
            i11 = 0;
        } else {
            int hashCode = obj.hashCode();
            i11 = hashCode;
            c11 = d.c(this, obj, hashCode);
        }
        if (c11 >= 0) {
            return false;
        }
        int i12 = ~c11;
        if (h11 >= e().length) {
            int i13 = 8;
            if (h11 >= 8) {
                i13 = (h11 >> 1) + h11;
            } else if (h11 < 4) {
                i13 = 4;
            }
            int[] e11 = e();
            Object[] c12 = c();
            d.a(this, i13);
            if (h11 != h()) {
                throw new ConcurrentModificationException();
            }
            if (!(e().length == 0)) {
                ArraysKt.q(e11, e(), 0, 0, e11.length, 6, null);
                ArraysKt.r(c12, c(), 0, 0, c12.length, 6, null);
            }
        }
        if (i12 < h11) {
            int i14 = i12 + 1;
            ArraysKt.l(e(), e(), i14, i12, h11);
            ArraysKt.n(c(), c(), i14, i12, h11);
        }
        if (h11 != h() || i12 >= e().length) {
            throw new ConcurrentModificationException();
        }
        e()[i12] = i11;
        c()[i12] = obj;
        n(h() + 1);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection elements) {
        Intrinsics.h(elements, "elements");
        a(h() + elements.size());
        Iterator it = elements.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= add(it.next());
        }
        return z10;
    }

    public final Object[] c() {
        return this.f2339b;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (h() != 0) {
            m(n.a.f70174a);
            l(n.a.f70176c);
            n(0);
        }
        if (h() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection elements) {
        Intrinsics.h(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int[] e() {
        return this.f2338a;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Set) && size() == ((Set) obj).size()) {
            try {
                int h11 = h();
                for (int i11 = 0; i11 < h11; i11++) {
                    if (((Set) obj).contains(o(i11))) {
                    }
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public int f() {
        return this.f2340c;
    }

    public final int h() {
        return this.f2340c;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] e11 = e();
        int h11 = h();
        int i11 = 0;
        for (int i12 = 0; i12 < h11; i12++) {
            i11 += e11[i12];
        }
        return i11;
    }

    public final int indexOf(Object obj) {
        return obj == null ? d.d(this) : d.c(this, obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return h() <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new a();
    }

    public final Object j(int i11) {
        int h11 = h();
        Object obj = c()[i11];
        if (h11 <= 1) {
            clear();
        } else {
            int i12 = h11 - 1;
            if (e().length <= 8 || h() >= e().length / 3) {
                if (i11 < i12) {
                    int i13 = i11 + 1;
                    ArraysKt.l(e(), e(), i11, i13, h11);
                    ArraysKt.n(c(), c(), i11, i13, h11);
                }
                c()[i12] = null;
            } else {
                int h12 = h() > 8 ? h() + (h() >> 1) : 8;
                int[] e11 = e();
                Object[] c11 = c();
                d.a(this, h12);
                if (i11 > 0) {
                    ArraysKt.q(e11, e(), 0, 0, i11, 6, null);
                    ArraysKt.r(c11, c(), 0, 0, i11, 6, null);
                }
                if (i11 < i12) {
                    int i14 = i11 + 1;
                    ArraysKt.l(e11, e(), i11, i14, h11);
                    ArraysKt.n(c11, c(), i11, i14, h11);
                }
            }
            if (h11 != h()) {
                throw new ConcurrentModificationException();
            }
            n(i12);
        }
        return obj;
    }

    public final void l(Object[] objArr) {
        Intrinsics.h(objArr, "<set-?>");
        this.f2339b = objArr;
    }

    public final void m(int[] iArr) {
        Intrinsics.h(iArr, "<set-?>");
        this.f2338a = iArr;
    }

    public final void n(int i11) {
        this.f2340c = i11;
    }

    public final Object o(int i11) {
        return c()[i11];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        j(indexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection elements) {
        Intrinsics.h(elements, "elements");
        Iterator it = elements.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= remove(it.next());
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection elements) {
        Intrinsics.h(elements, "elements");
        boolean z10 = false;
        for (int h11 = h() - 1; -1 < h11; h11--) {
            if (!CollectionsKt.b0(elements, c()[h11])) {
                j(h11);
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return f();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return ArraysKt.t(this.f2339b, 0, this.f2340c);
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] array) {
        Intrinsics.h(array, "array");
        Object[] result = c.a(array, this.f2340c);
        ArraysKt.n(this.f2339b, result, 0, 0, this.f2340c);
        Intrinsics.g(result, "result");
        return result;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(h() * 14);
        sb2.append('{');
        int h11 = h();
        for (int i11 = 0; i11 < h11; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            Object o11 = o(i11);
            if (o11 != this) {
                sb2.append(o11);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
