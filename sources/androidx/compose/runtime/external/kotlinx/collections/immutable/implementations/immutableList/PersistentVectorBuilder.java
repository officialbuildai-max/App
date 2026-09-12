package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.o1;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import t.f;

/* loaded from: classes.dex */
public final class PersistentVectorBuilder extends AbstractMutableList implements f.a {

    /* renamed from: a, reason: collision with root package name */
    private t.f f3770a;

    /* renamed from: b, reason: collision with root package name */
    private Object[] f3771b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f3772c;

    /* renamed from: d, reason: collision with root package name */
    private int f3773d;

    /* renamed from: e, reason: collision with root package name */
    private w.e f3774e = new w.e();

    /* renamed from: f, reason: collision with root package name */
    private Object[] f3775f;

    /* renamed from: g, reason: collision with root package name */
    private Object[] f3776g;

    /* renamed from: h, reason: collision with root package name */
    private int f3777h;

    public PersistentVectorBuilder(t.f fVar, Object[] objArr, Object[] objArr2, int i11) {
        this.f3770a = fVar;
        this.f3771b = objArr;
        this.f3772c = objArr2;
        this.f3773d = i11;
        this.f3775f = this.f3771b;
        this.f3776g = this.f3772c;
        this.f3777h = this.f3770a.size();
    }

    private final Object[] A(Object[] objArr, Object[] objArr2, int i11) {
        int a11 = j.a(size() - 1, i11);
        Object[] q11 = q(objArr);
        if (i11 == 5) {
            q11[a11] = objArr2;
        } else {
            q11[a11] = A((Object[]) q11[a11], objArr2, i11 - 5);
        }
        return q11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int B(Function1 function1, Object[] objArr, int i11, int i12, c cVar, List list, List list2) {
        if (o(objArr)) {
            list.add(objArr);
        }
        Object a11 = cVar.a();
        Intrinsics.f(a11, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr2 = (Object[]) a11;
        Object[] objArr3 = objArr2;
        for (int i13 = 0; i13 < i11; i13++) {
            Object obj = objArr[i13];
            if (!((Boolean) function1.invoke(obj)).booleanValue()) {
                if (i12 == 32) {
                    objArr3 = !list.isEmpty() ? (Object[]) list.remove(list.size() - 1) : s();
                    i12 = 0;
                }
                objArr3[i12] = obj;
                i12++;
            }
        }
        cVar.b(objArr3);
        if (objArr2 != cVar.a()) {
            list2.add(objArr2);
        }
        return i12;
    }

    private final int C(Function1 function1, Object[] objArr, int i11, c cVar) {
        Object[] objArr2 = objArr;
        int i12 = i11;
        boolean z10 = false;
        for (int i13 = 0; i13 < i11; i13++) {
            Object obj = objArr[i13];
            if (((Boolean) function1.invoke(obj)).booleanValue()) {
                if (!z10) {
                    objArr2 = q(objArr);
                    z10 = true;
                    i12 = i13;
                }
            } else if (z10) {
                objArr2[i12] = obj;
                i12++;
            }
        }
        cVar.b(objArr2);
        return i12;
    }

    private final boolean D(Function1 function1) {
        Object[] x10;
        int N = N();
        c cVar = new c(null);
        if (this.f3775f == null) {
            return E(function1, N, cVar) != N;
        }
        ListIterator p11 = p(0);
        int i11 = 32;
        while (i11 == 32 && p11.hasNext()) {
            i11 = C(function1, (Object[]) p11.next(), 32, cVar);
        }
        if (i11 == 32) {
            w.a.a(!p11.hasNext());
            int E = E(function1, N, cVar);
            if (E == 0) {
                w(this.f3775f, size(), this.f3773d);
            }
            return E != N;
        }
        int previousIndex = p11.previousIndex() << 5;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i12 = i11;
        while (p11.hasNext()) {
            i12 = B(function1, (Object[]) p11.next(), 32, i12, cVar, arrayList2, arrayList);
            previousIndex = previousIndex;
        }
        int i13 = previousIndex;
        int B = B(function1, this.f3776g, N, i12, cVar, arrayList2, arrayList);
        Object a11 = cVar.a();
        Intrinsics.f(a11, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) a11;
        ArraysKt.w(objArr, null, B, 32);
        if (arrayList.isEmpty()) {
            x10 = this.f3775f;
            Intrinsics.e(x10);
        } else {
            x10 = x(this.f3775f, i13, this.f3773d, arrayList.iterator());
        }
        int size = i13 + (arrayList.size() << 5);
        this.f3775f = I(x10, size);
        this.f3776g = objArr;
        this.f3777h = size + B;
        return true;
    }

    private final int E(Function1 function1, int i11, c cVar) {
        int C = C(function1, this.f3776g, i11, cVar);
        if (C == i11) {
            w.a.a(cVar.a() == this.f3776g);
            return i11;
        }
        Object a11 = cVar.a();
        Intrinsics.f(a11, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) a11;
        ArraysKt.w(objArr, null, C, i11);
        this.f3776g = objArr;
        this.f3777h = size() - (i11 - C);
        return C;
    }

    private final Object[] G(Object[] objArr, int i11, int i12, c cVar) {
        int a11 = j.a(i12, i11);
        if (i11 == 0) {
            Object obj = objArr[a11];
            Object[] n11 = ArraysKt.n(objArr, q(objArr), a11, a11 + 1, 32);
            n11[31] = cVar.a();
            cVar.b(obj);
            return n11;
        }
        int a12 = objArr[31] == null ? j.a(J() - 1, i11) : 31;
        Object[] q11 = q(objArr);
        int i13 = i11 - 5;
        int i14 = a11 + 1;
        if (i14 <= a12) {
            while (true) {
                Object obj2 = q11[a12];
                Intrinsics.f(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                q11[a12] = G((Object[]) obj2, i13, 0, cVar);
                if (a12 == i14) {
                    break;
                }
                a12--;
            }
        }
        Object obj3 = q11[a11];
        Intrinsics.f(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        q11[a11] = G((Object[]) obj3, i13, i12, cVar);
        return q11;
    }

    private final Object H(Object[] objArr, int i11, int i12, int i13) {
        int size = size() - i11;
        w.a.a(i13 < size);
        if (size == 1) {
            Object obj = this.f3776g[0];
            w(objArr, i11, i12);
            return obj;
        }
        Object[] objArr2 = this.f3776g;
        Object obj2 = objArr2[i13];
        Object[] n11 = ArraysKt.n(objArr2, q(objArr2), i13, i13 + 1, size);
        n11[size - 1] = null;
        this.f3775f = objArr;
        this.f3776g = n11;
        this.f3777h = (i11 + size) - 1;
        this.f3773d = i12;
        return obj2;
    }

    private final Object[] I(Object[] objArr, int i11) {
        if (!((i11 & 31) == 0)) {
            o1.a("invalid size");
        }
        if (i11 == 0) {
            this.f3773d = 0;
            return null;
        }
        int i12 = i11 - 1;
        while (true) {
            int i13 = this.f3773d;
            if ((i12 >> i13) != 0) {
                return u(objArr, i12, i13);
            }
            this.f3773d = i13 - 5;
            Object[] objArr2 = objArr[0];
            Intrinsics.f(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr = objArr2;
        }
    }

    private final int J() {
        if (size() <= 32) {
            return 0;
        }
        return j.d(size());
    }

    private final Object[] K(Object[] objArr, int i11, int i12, Object obj, c cVar) {
        int a11 = j.a(i12, i11);
        Object[] q11 = q(objArr);
        if (i11 != 0) {
            Object obj2 = q11[a11];
            Intrinsics.f(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            q11[a11] = K((Object[]) obj2, i11 - 5, i12, obj, cVar);
            return q11;
        }
        if (q11 != objArr) {
            ((AbstractList) this).modCount++;
        }
        cVar.b(q11[a11]);
        q11[a11] = obj;
        return q11;
    }

    private final Object[] L(int i11, int i12, Object[][] objArr, int i13, Object[] objArr2) {
        if (this.f3775f == null) {
            throw new IllegalStateException("root is null");
        }
        ListIterator p11 = p(J() >> 5);
        while (p11.previousIndex() != i11) {
            Object[] objArr3 = (Object[]) p11.previous();
            ArraysKt.n(objArr3, objArr2, 0, 32 - i12, 32);
            objArr2 = r(objArr3, i12);
            i13--;
            objArr[i13] = objArr2;
        }
        return (Object[]) p11.previous();
    }

    private final void M(Collection collection, int i11, Object[] objArr, int i12, Object[][] objArr2, int i13, Object[] objArr3) {
        Object[] s11;
        if (!(i13 >= 1)) {
            o1.a("requires at least one nullBuffer");
        }
        Object[] q11 = q(objArr);
        objArr2[0] = q11;
        int i14 = i11 & 31;
        int size = ((i11 + collection.size()) - 1) & 31;
        int i15 = (i12 - i14) + size;
        if (i15 < 32) {
            ArraysKt.n(q11, objArr3, size + 1, i14, i12);
        } else {
            int i16 = i15 - 31;
            if (i13 == 1) {
                s11 = q11;
            } else {
                s11 = s();
                i13--;
                objArr2[i13] = s11;
            }
            int i17 = i12 - i16;
            ArraysKt.n(q11, objArr3, 0, i17, i12);
            ArraysKt.n(q11, s11, size + 1, i14, i17);
            objArr3 = s11;
        }
        Iterator it = collection.iterator();
        c(q11, i14, it);
        for (int i18 = 1; i18 < i13; i18++) {
            objArr2[i18] = c(s(), 0, it);
        }
        c(objArr3, 0, it);
    }

    private final int N() {
        return O(size());
    }

    private final int O(int i11) {
        return i11 <= 32 ? i11 : i11 - j.d(i11);
    }

    private final Object[] a(int i11) {
        if (J() <= i11) {
            return this.f3776g;
        }
        Object[] objArr = this.f3775f;
        Intrinsics.e(objArr);
        for (int i12 = this.f3773d; i12 > 0; i12 -= 5) {
            Object[] objArr2 = objArr[j.a(i11, i12)];
            Intrinsics.f(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr = objArr2;
        }
        return objArr;
    }

    private final Object[] c(Object[] objArr, int i11, Iterator it) {
        while (i11 < 32 && it.hasNext()) {
            objArr[i11] = it.next();
            i11++;
        }
        return objArr;
    }

    private final void l(Collection collection, int i11, int i12, Object[][] objArr, int i13, Object[] objArr2) {
        if (this.f3775f == null) {
            throw new IllegalStateException("root is null");
        }
        int i14 = i11 >> 5;
        Object[] L = L(i14, i12, objArr, i13, objArr2);
        int J = i13 - (((J() >> 5) - 1) - i14);
        if (J < i13) {
            objArr2 = objArr[J];
            Intrinsics.e(objArr2);
        }
        M(collection, i11, L, 32, objArr, J, objArr2);
    }

    private final Object[] m(Object[] objArr, int i11, int i12, Object obj, c cVar) {
        Object obj2;
        int a11 = j.a(i12, i11);
        if (i11 == 0) {
            cVar.b(objArr[31]);
            Object[] n11 = ArraysKt.n(objArr, q(objArr), a11 + 1, a11, 31);
            n11[a11] = obj;
            return n11;
        }
        Object[] q11 = q(objArr);
        int i13 = i11 - 5;
        Object obj3 = q11[a11];
        Intrinsics.f(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        q11[a11] = m((Object[]) obj3, i13, i12, obj, cVar);
        while (true) {
            a11++;
            if (a11 >= 32 || (obj2 = q11[a11]) == null) {
                break;
            }
            Intrinsics.f(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            q11[a11] = m((Object[]) obj2, i13, 0, cVar.a(), cVar);
        }
        return q11;
    }

    private final void n(Object[] objArr, int i11, Object obj) {
        int N = N();
        Object[] q11 = q(this.f3776g);
        if (N < 32) {
            ArraysKt.n(this.f3776g, q11, i11 + 1, i11, N);
            q11[i11] = obj;
            this.f3775f = objArr;
            this.f3776g = q11;
            this.f3777h = size() + 1;
            return;
        }
        Object[] objArr2 = this.f3776g;
        Object obj2 = objArr2[31];
        ArraysKt.n(objArr2, q11, i11 + 1, i11, 31);
        q11[i11] = obj;
        z(objArr, q11, t(obj2));
    }

    private final boolean o(Object[] objArr) {
        return objArr.length == 33 && objArr[32] == this.f3774e;
    }

    private final ListIterator p(int i11) {
        Object[] objArr = this.f3775f;
        if (objArr == null) {
            throw new IllegalStateException("Invalid root");
        }
        int J = J() >> 5;
        w.d.b(i11, J);
        int i12 = this.f3773d;
        return i12 == 0 ? new g(objArr, i11) : new i(objArr, i11, J, i12 / 5);
    }

    private final Object[] q(Object[] objArr) {
        return objArr == null ? s() : o(objArr) ? objArr : ArraysKt.r(objArr, s(), 0, 0, RangesKt.i(objArr.length, 32), 6, null);
    }

    private final Object[] r(Object[] objArr, int i11) {
        return o(objArr) ? ArraysKt.n(objArr, objArr, i11, 0, 32 - i11) : ArraysKt.n(objArr, s(), i11, 0, 32 - i11);
    }

    private final Object[] s() {
        Object[] objArr = new Object[33];
        objArr[32] = this.f3774e;
        return objArr;
    }

    private final Object[] t(Object obj) {
        Object[] objArr = new Object[33];
        objArr[0] = obj;
        objArr[32] = this.f3774e;
        return objArr;
    }

    private final Object[] u(Object[] objArr, int i11, int i12) {
        if (!(i12 >= 0)) {
            o1.a("shift should be positive");
        }
        if (i12 == 0) {
            return objArr;
        }
        int a11 = j.a(i11, i12);
        Object obj = objArr[a11];
        Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object u11 = u((Object[]) obj, i11, i12 - 5);
        if (a11 < 31) {
            int i13 = a11 + 1;
            if (objArr[i13] != null) {
                if (o(objArr)) {
                    ArraysKt.w(objArr, null, i13, 32);
                }
                objArr = ArraysKt.n(objArr, s(), 0, 0, i13);
            }
        }
        if (u11 == objArr[a11]) {
            return objArr;
        }
        Object[] q11 = q(objArr);
        q11[a11] = u11;
        return q11;
    }

    private final Object[] v(Object[] objArr, int i11, int i12, c cVar) {
        Object[] v11;
        int a11 = j.a(i12 - 1, i11);
        if (i11 == 5) {
            cVar.b(objArr[a11]);
            v11 = null;
        } else {
            Object obj = objArr[a11];
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            v11 = v((Object[]) obj, i11 - 5, i12, cVar);
        }
        if (v11 == null && a11 == 0) {
            return null;
        }
        Object[] q11 = q(objArr);
        q11[a11] = v11;
        return q11;
    }

    private final void w(Object[] objArr, int i11, int i12) {
        if (i12 == 0) {
            this.f3775f = null;
            if (objArr == null) {
                objArr = new Object[0];
            }
            this.f3776g = objArr;
            this.f3777h = i11;
            this.f3773d = i12;
            return;
        }
        c cVar = new c(null);
        Intrinsics.e(objArr);
        Object[] v11 = v(objArr, i12, i11, cVar);
        Intrinsics.e(v11);
        Object a11 = cVar.a();
        Intrinsics.f(a11, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        this.f3776g = (Object[]) a11;
        this.f3777h = i11;
        if (v11[1] == null) {
            this.f3775f = (Object[]) v11[0];
            this.f3773d = i12 - 5;
        } else {
            this.f3775f = v11;
            this.f3773d = i12;
        }
    }

    private final Object[] x(Object[] objArr, int i11, int i12, Iterator it) {
        if (!it.hasNext()) {
            o1.a("invalid buffersIterator");
        }
        if (!(i12 >= 0)) {
            o1.a("negative shift");
        }
        if (i12 == 0) {
            return (Object[]) it.next();
        }
        Object[] q11 = q(objArr);
        int a11 = j.a(i11, i12);
        int i13 = i12 - 5;
        q11[a11] = x((Object[]) q11[a11], i11, i13, it);
        while (true) {
            a11++;
            if (a11 >= 32 || !it.hasNext()) {
                break;
            }
            q11[a11] = x((Object[]) q11[a11], 0, i13, it);
        }
        return q11;
    }

    private final Object[] y(Object[] objArr, int i11, Object[][] objArr2) {
        Iterator a11 = ArrayIteratorKt.a(objArr2);
        int i12 = i11 >> 5;
        int i13 = this.f3773d;
        Object[] x10 = i12 < (1 << i13) ? x(objArr, i11, i13, a11) : q(objArr);
        while (a11.hasNext()) {
            this.f3773d += 5;
            x10 = t(x10);
            int i14 = this.f3773d;
            x(x10, 1 << i14, i14, a11);
        }
        return x10;
    }

    private final void z(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int size = size() >> 5;
        int i11 = this.f3773d;
        if (size > (1 << i11)) {
            this.f3775f = A(t(objArr), objArr2, this.f3773d + 5);
            this.f3776g = objArr3;
            this.f3773d += 5;
            this.f3777h = size() + 1;
            return;
        }
        if (objArr == null) {
            this.f3775f = objArr2;
            this.f3776g = objArr3;
            this.f3777h = size() + 1;
        } else {
            this.f3775f = A(objArr, objArr2, i11);
            this.f3776g = objArr3;
            this.f3777h = size() + 1;
        }
    }

    public final boolean F(Function1 function1) {
        boolean D = D(function1);
        if (D) {
            ((AbstractList) this).modCount++;
        }
        return D;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i11, Object obj) {
        w.d.b(i11, size());
        if (i11 == size()) {
            add(obj);
            return;
        }
        ((AbstractList) this).modCount++;
        int J = J();
        if (i11 >= J) {
            n(this.f3775f, i11 - J, obj);
            return;
        }
        c cVar = new c(null);
        Object[] objArr = this.f3775f;
        Intrinsics.e(objArr);
        n(m(objArr, this.f3773d, i11, obj, cVar), 0, cVar.a());
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        ((AbstractList) this).modCount++;
        int N = N();
        if (N < 32) {
            Object[] q11 = q(this.f3776g);
            q11[N] = obj;
            this.f3776g = q11;
            this.f3777h = size() + 1;
        } else {
            z(this.f3775f, this.f3776g, t(obj));
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i11, Collection collection) {
        Object[] n11;
        w.d.b(i11, size());
        if (i11 == size()) {
            return addAll(collection);
        }
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int i12 = (i11 >> 5) << 5;
        int size = (((size() - i12) + collection.size()) - 1) / 32;
        if (size == 0) {
            w.a.a(i11 >= J());
            int i13 = i11 & 31;
            int size2 = ((i11 + collection.size()) - 1) & 31;
            Object[] objArr = this.f3776g;
            Object[] n12 = ArraysKt.n(objArr, q(objArr), size2 + 1, i13, N());
            c(n12, i13, collection.iterator());
            this.f3776g = n12;
            this.f3777h = size() + collection.size();
            return true;
        }
        Object[][] objArr2 = new Object[size];
        int N = N();
        int O = O(size() + collection.size());
        if (i11 >= J()) {
            n11 = s();
            M(collection, i11, this.f3776g, N, objArr2, size, n11);
        } else if (O > N) {
            int i14 = O - N;
            n11 = r(this.f3776g, i14);
            l(collection, i11, i14, objArr2, size, n11);
        } else {
            int i15 = N - O;
            n11 = ArraysKt.n(this.f3776g, s(), 0, i15, N);
            int i16 = 32 - i15;
            Object[] r11 = r(this.f3776g, i16);
            int i17 = size - 1;
            objArr2[i17] = r11;
            l(collection, i11, i16, objArr2, i17, r11);
        }
        this.f3775f = y(this.f3775f, i12, objArr2);
        this.f3776g = n11;
        this.f3777h = size() + collection.size();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int N = N();
        Iterator it = collection.iterator();
        if (32 - N >= collection.size()) {
            this.f3776g = c(q(this.f3776g), N, it);
            this.f3777h = size() + collection.size();
        } else {
            int size = ((collection.size() + N) - 1) / 32;
            Object[][] objArr = new Object[size];
            objArr[0] = c(q(this.f3776g), N, it);
            for (int i11 = 1; i11 < size; i11++) {
                objArr[i11] = c(s(), 0, it);
            }
            this.f3775f = y(this.f3775f, J(), objArr);
            this.f3776g = c(s(), 0, it);
            this.f3777h = size() + collection.size();
        }
        return true;
    }

    @Override // t.f.a
    public t.f build() {
        t.f dVar;
        if (this.f3775f == this.f3771b && this.f3776g == this.f3772c) {
            dVar = this.f3770a;
        } else {
            this.f3774e = new w.e();
            Object[] objArr = this.f3775f;
            this.f3771b = objArr;
            Object[] objArr2 = this.f3776g;
            this.f3772c = objArr2;
            if (objArr != null) {
                Object[] objArr3 = this.f3775f;
                Intrinsics.e(objArr3);
                dVar = new d(objArr3, this.f3776g, size(), this.f3773d);
            } else if (objArr2.length == 0) {
                dVar = j.b();
            } else {
                Object[] copyOf = Arrays.copyOf(this.f3776g, size());
                Intrinsics.g(copyOf, "copyOf(this, newSize)");
                dVar = new h(copyOf);
            }
        }
        this.f3770a = dVar;
        return dVar;
    }

    public final int e() {
        return ((AbstractList) this).modCount;
    }

    public final Object[] f() {
        return this.f3775f;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i11) {
        w.d.a(i11, size());
        return a(i11)[i11 & 31];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.f3777h;
    }

    public final int h() {
        return this.f3773d;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator();
    }

    public final Object[] j() {
        return this.f3776g;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i11) {
        w.d.b(i11, size());
        return new f(this, i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(final Collection collection) {
        return F(new Function1<Object, Boolean>() { // from class: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder$removeAll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                return Boolean.valueOf(collection.contains(obj));
            }
        });
    }

    @Override // kotlin.collections.AbstractMutableList
    public Object removeAt(int i11) {
        w.d.a(i11, size());
        ((AbstractList) this).modCount++;
        int J = J();
        if (i11 >= J) {
            return H(this.f3775f, J, this.f3773d, i11 - J);
        }
        c cVar = new c(this.f3776g[0]);
        Object[] objArr = this.f3775f;
        Intrinsics.e(objArr);
        H(G(objArr, this.f3773d, i11, cVar), J, this.f3773d, 0);
        return cVar.a();
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i11, Object obj) {
        w.d.a(i11, size());
        if (J() > i11) {
            c cVar = new c(null);
            Object[] objArr = this.f3775f;
            Intrinsics.e(objArr);
            this.f3775f = K(objArr, this.f3773d, i11, obj, cVar);
            return cVar.a();
        }
        Object[] q11 = q(this.f3776g);
        if (q11 != this.f3776g) {
            ((AbstractList) this).modCount++;
        }
        int i12 = i11 & 31;
        Object obj2 = q11[i12];
        q11[i12] = obj;
        this.f3776g = q11;
        return obj2;
    }
}
