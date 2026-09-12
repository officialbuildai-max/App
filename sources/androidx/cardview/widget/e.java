package androidx.cardview.widget;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
abstract class e extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private static final double f2313a = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(float f11, float f12, boolean z10) {
        return z10 ? (float) (f11 + ((1.0d - f2313a) * f12)) : f11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(float f11, float f12, boolean z10) {
        return z10 ? (float) ((f11 * 1.5f) + ((1.0d - f2313a) * f12)) : f11 * 1.5f;
    }
}
