package oa;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* loaded from: classes4.dex */
public class g implements TypeEvaluator {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f71051a = new float[9];

    /* renamed from: b, reason: collision with root package name */
    private final float[] f71052b = new float[9];

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f71053c = new Matrix();

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix evaluate(float f11, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f71051a);
        matrix2.getValues(this.f71052b);
        for (int i11 = 0; i11 < 9; i11++) {
            float[] fArr = this.f71052b;
            float f12 = fArr[i11];
            float f13 = this.f71051a[i11];
            fArr[i11] = f13 + ((f12 - f13) * f11);
        }
        this.f71053c.setValues(this.f71052b);
        return this.f71053c;
    }
}
