package com.gyf.immersionbar;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import com.gyf.immersionbar.g;

/* loaded from: classes4.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f33115a;

    /* renamed from: b, reason: collision with root package name */
    private final int f33116b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f33117c;

    /* renamed from: d, reason: collision with root package name */
    private final int f33118d;

    /* renamed from: e, reason: collision with root package name */
    private final int f33119e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f33120f;

    /* renamed from: g, reason: collision with root package name */
    private final float f33121g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Activity activity) {
        this.f33120f = activity.getResources().getConfiguration().orientation == 1;
        this.f33121g = j(activity);
        this.f33115a = c(activity, "status_bar_height");
        this.f33116b = b(activity);
        int e11 = e(activity);
        this.f33118d = e11;
        this.f33119e = h(activity);
        this.f33117c = e11 > 0;
    }

    private int b(Activity activity) {
        View findViewById = activity.getWindow().findViewById(R$id.action_bar_container);
        int measuredHeight = findViewById != null ? findViewById.getMeasuredHeight() : 0;
        if (measuredHeight != 0) {
            return measuredHeight;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
        return TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getResources().getDisplayMetrics());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(Context context, String str) {
        try {
            int identifier = Resources.getSystem().getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                if (dimensionPixelSize2 >= dimensionPixelSize && (Build.VERSION.SDK_INT < 29 || str.equals("status_bar_height"))) {
                    return dimensionPixelSize2;
                }
                float f11 = (dimensionPixelSize * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                return (int) (f11 >= 0.0f ? f11 + 0.5f : f11 - 0.5f);
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    private int e(Context context) {
        if (l((Activity) context)) {
            return f(context);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(Context context) {
        return c(context, context.getResources().getConfiguration().orientation == 1 ? "navigation_bar_height" : "navigation_bar_height_landscape");
    }

    private int h(Context context) {
        if (l((Activity) context)) {
            return c(context, "navigation_bar_width");
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(Context context) {
        return c(context, "navigation_bar_width");
    }

    private float j(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        float f11 = displayMetrics.widthPixels;
        float f12 = displayMetrics.density;
        return Math.min(f11 / f12, displayMetrics.heightPixels / f12);
    }

    private boolean l(Activity activity) {
        g.a a11 = g.a(activity);
        if (!a11.f33173b && a11.f33172a) {
            return false;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i11 = displayMetrics.heightPixels;
        int i12 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i12 - displayMetrics2.widthPixels > 0 || i11 - displayMetrics2.heightPixels > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f33116b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f33118d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f33119e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f33115a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return this.f33117c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return this.f33121g >= 600.0f || this.f33120f;
    }
}
