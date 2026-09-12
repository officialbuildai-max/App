package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
public abstract class f0 {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f2091a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    static final int[] f2092b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    static final int[] f2093c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    static final int[] f2094d = {R.attr.state_activated};

    /* renamed from: e, reason: collision with root package name */
    static final int[] f2095e = {R.attr.state_pressed};

    /* renamed from: f, reason: collision with root package name */
    static final int[] f2096f = {R.attr.state_checked};

    /* renamed from: g, reason: collision with root package name */
    static final int[] f2097g = {R.attr.state_selected};

    /* renamed from: h, reason: collision with root package name */
    static final int[] f2098h = {-16842919, -16842908};

    /* renamed from: i, reason: collision with root package name */
    static final int[] f2099i = new int[0];

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f2100j = new int[1];

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R$styleable.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i11) {
        ColorStateList e11 = e(context, i11);
        if (e11 != null && e11.isStateful()) {
            return e11.getColorForState(f2092b, e11.getDefaultColor());
        }
        TypedValue f11 = f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, f11, true);
        return d(context, i11, f11.getFloat());
    }

    public static int c(Context context, int i11) {
        int[] iArr = f2100j;
        iArr[0] = i11;
        j0 u11 = j0.u(context, null, iArr);
        try {
            return u11.b(0, 0);
        } finally {
            u11.x();
        }
    }

    static int d(Context context, int i11, float f11) {
        return z0.b.p(c(context, i11), Math.round(Color.alpha(r0) * f11));
    }

    public static ColorStateList e(Context context, int i11) {
        int[] iArr = f2100j;
        iArr[0] = i11;
        j0 u11 = j0.u(context, null, iArr);
        try {
            return u11.c(0);
        } finally {
            u11.x();
        }
    }

    private static TypedValue f() {
        ThreadLocal threadLocal = f2091a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
