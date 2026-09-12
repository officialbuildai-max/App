package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    private static final c0 f15199a;

    /* renamed from: b, reason: collision with root package name */
    static final Property f15200b;

    /* renamed from: c, reason: collision with root package name */
    static final Property f15201c;

    /* loaded from: classes2.dex */
    class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(z.b(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f11) {
            z.e(view, f11.floatValue());
        }
    }

    /* loaded from: classes2.dex */
    class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return view.getClipBounds();
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f15199a = new k0();
        } else {
            f15199a = new j0();
        }
        f15200b = new a(Float.class, "translationAlpha");
        f15201c = new b(Rect.class, "clipBounds");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view) {
        f15199a.a(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(View view) {
        return f15199a.b(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(View view) {
        f15199a.c(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(View view, int i11, int i12, int i13, int i14) {
        f15199a.d(view, i11, i12, i13, i14);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(View view, float f11) {
        f15199a.e(view, f11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(View view, int i11) {
        f15199a.f(view, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(View view, Matrix matrix) {
        f15199a.g(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(View view, Matrix matrix) {
        f15199a.h(view, matrix);
    }
}
