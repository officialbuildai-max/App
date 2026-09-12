package com.google.android.exoplayer2.video.spherical;

import android.opengl.Matrix;
import com.google.android.exoplayer2.util.k0;

/* loaded from: classes3.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f27993a = new float[16];

    /* renamed from: b, reason: collision with root package name */
    private final float[] f27994b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    private final k0 f27995c = new k0();

    /* renamed from: d, reason: collision with root package name */
    private boolean f27996d;

    public static void a(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float f11 = fArr2[10];
        float f12 = fArr2[8];
        float sqrt = (float) Math.sqrt((f11 * f11) + (f12 * f12));
        float f13 = fArr2[10];
        fArr[0] = f13 / sqrt;
        float f14 = fArr2[8];
        fArr[2] = f14 / sqrt;
        fArr[8] = (-f14) / sqrt;
        fArr[10] = f13 / sqrt;
    }

    private static void b(float[] fArr, float[] fArr2) {
        float f11 = fArr2[0];
        float f12 = -fArr2[1];
        float f13 = -fArr2[2];
        float length = Matrix.length(f11, f12, f13);
        if (length != 0.0f) {
            Matrix.setRotateM(fArr, 0, (float) Math.toDegrees(length), f11 / length, f12 / length, f13 / length);
        } else {
            Matrix.setIdentityM(fArr, 0);
        }
    }

    public boolean c(float[] fArr, long j11) {
        float[] fArr2 = (float[]) this.f27995c.j(j11);
        if (fArr2 == null) {
            return false;
        }
        b(this.f27994b, fArr2);
        if (!this.f27996d) {
            a(this.f27993a, this.f27994b);
            this.f27996d = true;
        }
        Matrix.multiplyMM(fArr, 0, this.f27993a, 0, this.f27994b, 0);
        return true;
    }

    public void d() {
        this.f27995c.c();
        this.f27996d = false;
    }

    public void e(long j11, float[] fArr) {
        this.f27995c.a(j11, fArr);
    }
}
