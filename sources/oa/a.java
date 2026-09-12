package oa;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f71041a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f71042b = new o1.b();

    /* renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f71043c = new o1.a();

    /* renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f71044d = new o1.c();

    /* renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f71045e = new DecelerateInterpolator();

    public static float a(float f11, float f12, float f13) {
        return f11 + (f13 * (f12 - f11));
    }

    public static float b(float f11, float f12, float f13, float f14, float f15) {
        return f15 <= f13 ? f11 : f15 >= f14 ? f12 : a(f11, f12, (f15 - f13) / (f14 - f13));
    }

    public static int c(int i11, int i12, float f11) {
        return i11 + Math.round(f11 * (i12 - i11));
    }
}
