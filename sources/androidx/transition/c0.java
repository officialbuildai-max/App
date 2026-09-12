package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
abstract class c0 {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f15094a = true;

    /* renamed from: b, reason: collision with root package name */
    private static Field f15095b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f15096c;

    /* loaded from: classes2.dex */
    static class a {
        static float a(View view) {
            float transitionAlpha;
            transitionAlpha = view.getTransitionAlpha();
            return transitionAlpha;
        }

        static void b(View view, float f11) {
            view.setTransitionAlpha(f11);
        }
    }

    public void a(View view) {
    }

    public float b(View view) {
        if (f15094a) {
            try {
                return a.a(view);
            } catch (NoSuchMethodError unused) {
                f15094a = false;
            }
        }
        return view.getAlpha();
    }

    public void c(View view) {
    }

    public abstract void d(View view, int i11, int i12, int i13, int i14);

    public void e(View view, float f11) {
        if (f15094a) {
            try {
                a.b(view, f11);
                return;
            } catch (NoSuchMethodError unused) {
                f15094a = false;
            }
        }
        view.setAlpha(f11);
    }

    public void f(View view, int i11) {
        if (!f15096c) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f15095b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f15096c = true;
        }
        Field field = f15095b;
        if (field != null) {
            try {
                f15095b.setInt(view, i11 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public abstract void g(View view, Matrix matrix);

    public abstract void h(View view, Matrix matrix);
}
