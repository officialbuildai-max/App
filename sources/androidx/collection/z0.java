package androidx.collection;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class z0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f2442a = new Object();

    public static final Object c(y0 y0Var, int i11) {
        Object obj;
        Intrinsics.h(y0Var, "<this>");
        int a11 = n.a.a(y0Var.f2439b, y0Var.f2441d, i11);
        if (a11 < 0 || (obj = y0Var.f2440c[a11]) == f2442a) {
            return null;
        }
        return obj;
    }

    public static final Object d(y0 y0Var, int i11, Object obj) {
        Object obj2;
        Intrinsics.h(y0Var, "<this>");
        int a11 = n.a.a(y0Var.f2439b, y0Var.f2441d, i11);
        return (a11 < 0 || (obj2 = y0Var.f2440c[a11]) == f2442a) ? obj : obj2;
    }

    public static final void e(y0 y0Var, int i11) {
        Intrinsics.h(y0Var, "<this>");
        int a11 = n.a.a(y0Var.f2439b, y0Var.f2441d, i11);
        if (a11 >= 0) {
            Object[] objArr = y0Var.f2440c;
            Object obj = objArr[a11];
            Object obj2 = f2442a;
            if (obj != obj2) {
                objArr[a11] = obj2;
                y0Var.f2438a = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(y0 y0Var) {
        int i11 = y0Var.f2441d;
        int[] iArr = y0Var.f2439b;
        Object[] objArr = y0Var.f2440c;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            Object obj = objArr[i13];
            if (obj != f2442a) {
                if (i13 != i12) {
                    iArr[i12] = iArr[i13];
                    objArr[i12] = obj;
                    objArr[i13] = null;
                }
                i12++;
            }
        }
        y0Var.f2438a = false;
        y0Var.f2441d = i12;
    }
}
