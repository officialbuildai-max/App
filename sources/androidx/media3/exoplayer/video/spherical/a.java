package androidx.media3.exoplayer.video.spherical;

import android.opengl.Matrix;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.o0;

/* loaded from: classes2.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f13327a = new float[16];

    /* renamed from: b, reason: collision with root package name */
    private final float[] f13328b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    private final o0 f13329c = new o0();

    /* renamed from: d, reason: collision with root package name */
    private boolean f13330d;

    public static void a(float[] fArr, float[] fArr2) {
        GlUtil.k(fArr);
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
            GlUtil.k(fArr);
        }
    }

    public boolean c(float[] fArr, long j11) {
        float[] fArr2 = (float[]) this.f13329c.j(j11);
        if (fArr2 == null) {
            return false;
        }
        b(this.f13328b, fArr2);
        if (!this.f13330d) {
            a(this.f13327a, this.f13328b);
            this.f13330d = true;
        }
        Matrix.multiplyMM(fArr, 0, this.f13327a, 0, this.f13328b, 0);
        return true;
    }

    public void d() {
        this.f13329c.c();
        this.f13330d = false;
    }

    public void e(long j11, float[] fArr) {
        this.f13329c.a(j11, fArr);
    }
}
