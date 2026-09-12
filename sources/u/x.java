package u;

import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class x {
    public static final /* synthetic */ Object[] a(Object[] objArr, int i11, Object obj, Object obj2) {
        return g(objArr, i11, obj, obj2);
    }

    public static final /* synthetic */ Object[] b(Object[] objArr, int i11) {
        return h(objArr, i11);
    }

    public static final /* synthetic */ Object[] c(Object[] objArr, int i11) {
        return i(objArr, i11);
    }

    public static final /* synthetic */ Object[] d(Object[] objArr, int i11, int i12, t tVar) {
        return j(objArr, i11, i12, tVar);
    }

    public static final /* synthetic */ Object[] e(Object[] objArr, int i11, int i12, Object obj, Object obj2) {
        return k(objArr, i11, i12, obj, obj2);
    }

    public static final int f(int i11, int i12) {
        return (i11 >> i12) & 31;
    }

    public static final Object[] g(Object[] objArr, int i11, Object obj, Object obj2) {
        Object[] objArr2 = new Object[objArr.length + 2];
        ArraysKt.r(objArr, objArr2, 0, 0, i11, 6, null);
        ArraysKt.n(objArr, objArr2, i11 + 2, i11, objArr.length);
        objArr2[i11] = obj;
        objArr2[i11 + 1] = obj2;
        return objArr2;
    }

    public static final Object[] h(Object[] objArr, int i11) {
        Object[] objArr2 = new Object[objArr.length - 2];
        ArraysKt.r(objArr, objArr2, 0, 0, i11, 6, null);
        ArraysKt.n(objArr, objArr2, i11, i11 + 2, objArr.length);
        return objArr2;
    }

    public static final Object[] i(Object[] objArr, int i11) {
        Object[] objArr2 = new Object[objArr.length - 1];
        ArraysKt.r(objArr, objArr2, 0, 0, i11, 6, null);
        ArraysKt.n(objArr, objArr2, i11, i11 + 1, objArr.length);
        return objArr2;
    }

    public static final Object[] j(Object[] objArr, int i11, int i12, t tVar) {
        Object[] objArr2 = new Object[objArr.length - 1];
        ArraysKt.r(objArr, objArr2, 0, 0, i11, 6, null);
        ArraysKt.n(objArr, objArr2, i11, i11 + 2, i12);
        objArr2[i12 - 2] = tVar;
        ArraysKt.n(objArr, objArr2, i12 - 1, i12, objArr.length);
        return objArr2;
    }

    public static final Object[] k(Object[] objArr, int i11, int i12, Object obj, Object obj2) {
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length + 1);
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        ArraysKt.n(copyOf, copyOf, i11 + 2, i11 + 1, objArr.length);
        ArraysKt.n(copyOf, copyOf, i12 + 2, i12, i11);
        copyOf[i12] = obj;
        copyOf[i12 + 1] = obj2;
        return copyOf;
    }
}
