package o1;

import android.view.animation.Interpolator;

/* loaded from: classes2.dex */
abstract class d implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f70768a;

    /* renamed from: b, reason: collision with root package name */
    private final float f70769b;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(float[] fArr) {
        this.f70768a = fArr;
        this.f70769b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f11) {
        if (f11 >= 1.0f) {
            return 1.0f;
        }
        if (f11 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f70768a;
        int min = Math.min((int) ((fArr.length - 1) * f11), fArr.length - 2);
        float f12 = this.f70769b;
        float f13 = (f11 - (min * f12)) / f12;
        float[] fArr2 = this.f70768a;
        float f14 = fArr2[min];
        return f14 + (f13 * (fArr2[min + 1] - f14));
    }
}
