package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.o1;
import java.util.Arrays;
import java.util.ListIterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class d extends AbstractPersistentList implements t.f {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f3782a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f3783b;

    /* renamed from: c, reason: collision with root package name */
    private final int f3784c;

    /* renamed from: d, reason: collision with root package name */
    private final int f3785d;

    public d(Object[] objArr, Object[] objArr2, int i11, int i12) {
        this.f3782a = objArr;
        this.f3783b = objArr2;
        this.f3784c = i11;
        this.f3785d = i12;
        if (!(size() > 32)) {
            o1.a("Trie-based persistent vector should have at least 33 elements, got " + size());
        }
        w.a.a(size() - j.d(size()) <= RangesKt.i(objArr2.length, 32));
    }

    private final Object[] f(int i11) {
        if (s() <= i11) {
            return this.f3783b;
        }
        Object[] objArr = this.f3782a;
        for (int i12 = this.f3785d; i12 > 0; i12 -= 5) {
            Object[] objArr2 = objArr[j.a(i11, i12)];
            Intrinsics.f(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr = objArr2;
        }
        return objArr;
    }

    private final Object[] j(Object[] objArr, int i11, int i12, Object obj, c cVar) {
        Object[] copyOf;
        int a11 = j.a(i12, i11);
        if (i11 == 0) {
            if (a11 == 0) {
                copyOf = new Object[32];
            } else {
                copyOf = Arrays.copyOf(objArr, 32);
                Intrinsics.g(copyOf, "copyOf(this, newSize)");
            }
            ArraysKt.n(objArr, copyOf, a11 + 1, a11, 31);
            cVar.b(objArr[31]);
            copyOf[a11] = obj;
            return copyOf;
        }
        Object[] copyOf2 = Arrays.copyOf(objArr, 32);
        Intrinsics.g(copyOf2, "copyOf(this, newSize)");
        int i13 = i11 - 5;
        Object obj2 = objArr[a11];
        String str = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>";
        Intrinsics.f(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        copyOf2[a11] = j((Object[]) obj2, i13, i12, obj, cVar);
        int i14 = a11 + 1;
        while (i14 < 32 && copyOf2[i14] != null) {
            Object obj3 = objArr[i14];
            Intrinsics.f(obj3, str);
            Object[] objArr2 = copyOf2;
            objArr2[i14] = j((Object[]) obj3, i13, 0, cVar.a(), cVar);
            i14++;
            copyOf2 = objArr2;
            str = str;
        }
        return copyOf2;
    }

    private final d l(Object[] objArr, int i11, Object obj) {
        int size = size() - s();
        Object[] copyOf = Arrays.copyOf(this.f3783b, 32);
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        if (size < 32) {
            ArraysKt.n(this.f3783b, copyOf, i11 + 1, i11, size);
            copyOf[i11] = obj;
            return new d(objArr, copyOf, size() + 1, this.f3785d);
        }
        Object[] objArr2 = this.f3783b;
        Object obj2 = objArr2[31];
        ArraysKt.n(objArr2, copyOf, i11 + 1, i11, size - 1);
        copyOf[i11] = obj;
        return o(objArr, copyOf, j.c(obj2));
    }

    private final Object[] m(Object[] objArr, int i11, int i12, c cVar) {
        Object[] m11;
        int a11 = j.a(i12, i11);
        if (i11 == 5) {
            cVar.b(objArr[a11]);
            m11 = null;
        } else {
            Object obj = objArr[a11];
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            m11 = m((Object[]) obj, i11 - 5, i12, cVar);
        }
        if (m11 == null && a11 == 0) {
            return null;
        }
        Object[] copyOf = Arrays.copyOf(objArr, 32);
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        copyOf[a11] = m11;
        return copyOf;
    }

    private final t.f n(Object[] objArr, int i11, int i12) {
        if (i12 == 0) {
            if (objArr.length == 33) {
                objArr = Arrays.copyOf(objArr, 32);
                Intrinsics.g(objArr, "copyOf(this, newSize)");
            }
            return new h(objArr);
        }
        c cVar = new c(null);
        Object[] m11 = m(objArr, i12, i11 - 1, cVar);
        Intrinsics.e(m11);
        Object a11 = cVar.a();
        Intrinsics.f(a11, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr2 = (Object[]) a11;
        if (m11[1] != null) {
            return new d(m11, objArr2, i11, i12);
        }
        Object obj = m11[0];
        Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return new d((Object[]) obj, objArr2, i11, i12 - 5);
    }

    private final d o(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int size = size() >> 5;
        int i11 = this.f3785d;
        if (size <= (1 << i11)) {
            return new d(p(objArr, i11, objArr2), objArr3, size() + 1, this.f3785d);
        }
        Object[] c11 = j.c(objArr);
        int i12 = this.f3785d + 5;
        return new d(p(c11, i12, objArr2), objArr3, size() + 1, i12);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0017, code lost:
    
        if (r4 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object[] p(java.lang.Object[] r4, int r5, java.lang.Object[] r6) {
        /*
            r3 = this;
            int r0 = r3.size()
            int r0 = r0 + (-1)
            int r0 = androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.j.a(r0, r5)
            r1 = 32
            if (r4 == 0) goto L19
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r1)
            java.lang.String r2 = "copyOf(this, newSize)"
            kotlin.jvm.internal.Intrinsics.g(r4, r2)
            if (r4 != 0) goto L1b
        L19:
            java.lang.Object[] r4 = new java.lang.Object[r1]
        L1b:
            r1 = 5
            if (r5 != r1) goto L21
            r4[r0] = r6
            goto L2c
        L21:
            r2 = r4[r0]
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            int r5 = r5 - r1
            java.lang.Object[] r5 = r3.p(r2, r5, r6)
            r4[r0] = r5
        L2c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.d.p(java.lang.Object[], int, java.lang.Object[]):java.lang.Object[]");
    }

    private final Object[] q(Object[] objArr, int i11, int i12, c cVar) {
        Object[] copyOf;
        int a11 = j.a(i12, i11);
        if (i11 == 0) {
            if (a11 == 0) {
                copyOf = new Object[32];
            } else {
                copyOf = Arrays.copyOf(objArr, 32);
                Intrinsics.g(copyOf, "copyOf(this, newSize)");
            }
            ArraysKt.n(objArr, copyOf, a11, a11 + 1, 32);
            copyOf[31] = cVar.a();
            cVar.b(objArr[a11]);
            return copyOf;
        }
        int a12 = objArr[31] == null ? j.a(s() - 1, i11) : 31;
        Object[] copyOf2 = Arrays.copyOf(objArr, 32);
        Intrinsics.g(copyOf2, "copyOf(this, newSize)");
        int i13 = i11 - 5;
        int i14 = a11 + 1;
        if (i14 <= a12) {
            while (true) {
                Object obj = copyOf2[a12];
                Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                copyOf2[a12] = q((Object[]) obj, i13, 0, cVar);
                if (a12 == i14) {
                    break;
                }
                a12--;
            }
        }
        Object obj2 = copyOf2[a11];
        Intrinsics.f(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        copyOf2[a11] = q((Object[]) obj2, i13, i12, cVar);
        return copyOf2;
    }

    private final t.f r(Object[] objArr, int i11, int i12, int i13) {
        int size = size() - i11;
        w.a.a(i13 < size);
        if (size == 1) {
            return n(objArr, i11, i12);
        }
        Object[] copyOf = Arrays.copyOf(this.f3783b, 32);
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        int i14 = size - 1;
        if (i13 < i14) {
            ArraysKt.n(this.f3783b, copyOf, i13, i13 + 1, size);
        }
        copyOf[i14] = null;
        return new d(objArr, copyOf, (i11 + size) - 1, i12);
    }

    private final int s() {
        return j.d(size());
    }

    private final Object[] t(Object[] objArr, int i11, int i12, Object obj) {
        int a11 = j.a(i12, i11);
        Object[] copyOf = Arrays.copyOf(objArr, 32);
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        if (i11 == 0) {
            copyOf[a11] = obj;
        } else {
            Object obj2 = copyOf[a11];
            Intrinsics.f(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            copyOf[a11] = t((Object[]) obj2, i11 - 5, i12, obj);
        }
        return copyOf;
    }

    @Override // java.util.List, t.f
    public t.f add(int i11, Object obj) {
        w.d.b(i11, size());
        if (i11 == size()) {
            return add(obj);
        }
        int s11 = s();
        if (i11 >= s11) {
            return l(this.f3782a, i11 - s11, obj);
        }
        c cVar = new c(null);
        return l(j(this.f3782a, this.f3785d, i11, obj, cVar), 0, cVar.a());
    }

    @Override // java.util.Collection, java.util.List, t.f
    public t.f add(Object obj) {
        int size = size() - s();
        if (size >= 32) {
            return o(this.f3782a, this.f3783b, j.c(obj));
        }
        Object[] copyOf = Arrays.copyOf(this.f3783b, 32);
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        copyOf[size] = obj;
        return new d(this.f3782a, copyOf, size() + 1, this.f3785d);
    }

    @Override // t.f
    public t.f d(int i11) {
        w.d.a(i11, size());
        int s11 = s();
        return i11 >= s11 ? r(this.f3782a, s11, this.f3785d, i11 - s11) : r(q(this.f3782a, this.f3785d, i11, new c(this.f3783b[0])), s11, this.f3785d, 0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public Object get(int i11) {
        w.d.a(i11, size());
        return f(i11)[i11 & 31];
    }

    @Override // kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int get_size() {
        return this.f3784c;
    }

    @Override // t.f
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public PersistentVectorBuilder builder() {
        return new PersistentVectorBuilder(this, this.f3782a, this.f3783b, this.f3785d);
    }

    @Override // t.f
    public t.f k(Function1 function1) {
        PersistentVectorBuilder builder = builder();
        builder.F(function1);
        return builder.build();
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator listIterator(int i11) {
        w.d.b(i11, size());
        return new e(this.f3782a, this.f3783b, i11, size(), (this.f3785d / 5) + 1);
    }

    @Override // kotlin.collections.AbstractList, java.util.List, t.f
    public t.f set(int i11, Object obj) {
        w.d.a(i11, size());
        if (s() > i11) {
            return new d(t(this.f3782a, this.f3785d, i11, obj), this.f3783b, size(), this.f3785d);
        }
        Object[] copyOf = Arrays.copyOf(this.f3783b, 32);
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        copyOf[i11 & 31] = obj;
        return new d(this.f3782a, copyOf, size(), this.f3785d);
    }
}
