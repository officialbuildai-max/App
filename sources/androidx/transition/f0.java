package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes2.dex */
abstract class f0 extends c0 {

    /* renamed from: d, reason: collision with root package name */
    private static boolean f15116d = true;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f15117e = true;

    /* loaded from: classes2.dex */
    static class a {
        static void a(View view, Matrix matrix) {
            view.setAnimationMatrix(matrix);
        }

        static void b(View view, Matrix matrix) {
            view.transformMatrixToGlobal(matrix);
        }

        static void c(View view, Matrix matrix) {
            view.transformMatrixToLocal(matrix);
        }
    }

    @Override // androidx.transition.c0
    public void g(View view, Matrix matrix) {
        if (f15116d) {
            try {
                a.b(view, matrix);
            } catch (NoSuchMethodError unused) {
                f15116d = false;
            }
        }
    }

    @Override // androidx.transition.c0
    public void h(View view, Matrix matrix) {
        if (f15117e) {
            try {
                a.c(view, matrix);
            } catch (NoSuchMethodError unused) {
                f15117e = false;
            }
        }
    }
}
