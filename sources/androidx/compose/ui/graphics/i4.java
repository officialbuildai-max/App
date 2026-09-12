package androidx.compose.ui.graphics;

import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
public final class i4 {

    /* renamed from: b */
    public static final a f4527b = new a(null);

    /* renamed from: a */
    private final float[] f4528a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ i4(float[] fArr) {
        this.f4528a = fArr;
    }

    public static final /* synthetic */ i4 a(float[] fArr) {
        return new i4(fArr);
    }

    public static float[] b(float[] fArr) {
        return fArr;
    }

    public static /* synthetic */ float[] c(float[] fArr, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i11 & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        }
        return b(fArr);
    }

    public static boolean d(float[] fArr, Object obj) {
        return (obj instanceof i4) && Intrinsics.c(fArr, ((i4) obj).r());
    }

    public static int e(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    public static final long f(float[] fArr, long j11) {
        float m11 = y.g.m(j11);
        float n11 = y.g.n(j11);
        float f11 = 1 / (((fArr[3] * m11) + (fArr[7] * n11)) + fArr[15]);
        if (Float.isInfinite(f11) || Float.isNaN(f11)) {
            f11 = 0.0f;
        }
        return y.h.a(((fArr[0] * m11) + (fArr[4] * n11) + fArr[12]) * f11, f11 * ((fArr[1] * m11) + (fArr[5] * n11) + fArr[13]));
    }

    public static final void g(float[] fArr, y.e eVar) {
        long f11 = f(fArr, y.h.a(eVar.b(), eVar.d()));
        long f12 = f(fArr, y.h.a(eVar.b(), eVar.a()));
        long f13 = f(fArr, y.h.a(eVar.c(), eVar.d()));
        long f14 = f(fArr, y.h.a(eVar.c(), eVar.a()));
        eVar.i(Math.min(Math.min(y.g.m(f11), y.g.m(f12)), Math.min(y.g.m(f13), y.g.m(f14))));
        eVar.k(Math.min(Math.min(y.g.n(f11), y.g.n(f12)), Math.min(y.g.n(f13), y.g.n(f14))));
        eVar.j(Math.max(Math.max(y.g.m(f11), y.g.m(f12)), Math.max(y.g.m(f13), y.g.m(f14))));
        eVar.h(Math.max(Math.max(y.g.n(f11), y.g.n(f12)), Math.max(y.g.n(f13), y.g.n(f14))));
    }

    public static final void h(float[] fArr) {
        int i11 = 0;
        while (i11 < 4) {
            int i12 = 0;
            while (i12 < 4) {
                fArr[(i12 * 4) + i11] = i11 == i12 ? 1.0f : 0.0f;
                i12++;
            }
            i11++;
        }
    }

    public static final void i(float[] fArr, float f11) {
        double d11 = (f11 * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d11);
        float sin = (float) Math.sin(d11);
        float f12 = fArr[1];
        float f13 = fArr[2];
        float f14 = fArr[5];
        float f15 = fArr[6];
        float f16 = fArr[9];
        float f17 = fArr[10];
        float f18 = fArr[13];
        float f19 = fArr[14];
        fArr[1] = (f12 * cos) - (f13 * sin);
        fArr[2] = (f12 * sin) + (f13 * cos);
        fArr[5] = (f14 * cos) - (f15 * sin);
        fArr[6] = (f14 * sin) + (f15 * cos);
        fArr[9] = (f16 * cos) - (f17 * sin);
        fArr[10] = (f16 * sin) + (f17 * cos);
        fArr[13] = (f18 * cos) - (f19 * sin);
        fArr[14] = (f18 * sin) + (f19 * cos);
    }

    public static final void j(float[] fArr, float f11) {
        double d11 = (f11 * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d11);
        float sin = (float) Math.sin(d11);
        float f12 = fArr[0];
        float f13 = fArr[2];
        float f14 = fArr[4];
        float f15 = fArr[6];
        float f16 = fArr[8];
        float f17 = fArr[10];
        float f18 = fArr[12];
        float f19 = fArr[14];
        fArr[0] = (f12 * cos) + (f13 * sin);
        fArr[2] = ((-f12) * sin) + (f13 * cos);
        fArr[4] = (f14 * cos) + (f15 * sin);
        fArr[6] = ((-f14) * sin) + (f15 * cos);
        fArr[8] = (f16 * cos) + (f17 * sin);
        fArr[10] = ((-f16) * sin) + (f17 * cos);
        fArr[12] = (f18 * cos) + (f19 * sin);
        fArr[14] = ((-f18) * sin) + (f19 * cos);
    }

    public static final void k(float[] fArr, float f11) {
        double d11 = (f11 * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d11);
        float sin = (float) Math.sin(d11);
        float f12 = fArr[0];
        float f13 = fArr[4];
        float f14 = -sin;
        float f15 = fArr[1];
        float f16 = fArr[5];
        float f17 = fArr[2];
        float f18 = fArr[6];
        float f19 = fArr[3];
        float f20 = fArr[7];
        fArr[0] = (cos * f12) + (sin * f13);
        fArr[1] = (cos * f15) + (sin * f16);
        fArr[2] = (cos * f17) + (sin * f18);
        fArr[3] = (cos * f19) + (sin * f20);
        fArr[4] = (f12 * f14) + (f13 * cos);
        fArr[5] = (f15 * f14) + (f16 * cos);
        fArr[6] = (f17 * f14) + (f18 * cos);
        fArr[7] = (f14 * f19) + (cos * f20);
    }

    public static final void l(float[] fArr, float f11, float f12, float f13) {
        fArr[0] = fArr[0] * f11;
        fArr[1] = fArr[1] * f11;
        fArr[2] = fArr[2] * f11;
        fArr[3] = fArr[3] * f11;
        fArr[4] = fArr[4] * f12;
        fArr[5] = fArr[5] * f12;
        fArr[6] = fArr[6] * f12;
        fArr[7] = fArr[7] * f12;
        fArr[8] = fArr[8] * f13;
        fArr[9] = fArr[9] * f13;
        fArr[10] = fArr[10] * f13;
        fArr[11] = fArr[11] * f13;
    }

    public static /* synthetic */ void m(float[] fArr, float f11, float f12, float f13, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = 1.0f;
        }
        if ((i11 & 2) != 0) {
            f12 = 1.0f;
        }
        if ((i11 & 4) != 0) {
            f13 = 1.0f;
        }
        l(fArr, f11, f12, f13);
    }

    public static final void n(float[] fArr, float[] fArr2) {
        float b11;
        float b12;
        float b13;
        float b14;
        float b15;
        float b16;
        float b17;
        float b18;
        float b19;
        float b20;
        float b21;
        float b22;
        float b23;
        float b24;
        float b25;
        float b26;
        b11 = j4.b(fArr, 0, fArr2, 0);
        b12 = j4.b(fArr, 0, fArr2, 1);
        b13 = j4.b(fArr, 0, fArr2, 2);
        b14 = j4.b(fArr, 0, fArr2, 3);
        b15 = j4.b(fArr, 1, fArr2, 0);
        b16 = j4.b(fArr, 1, fArr2, 1);
        b17 = j4.b(fArr, 1, fArr2, 2);
        b18 = j4.b(fArr, 1, fArr2, 3);
        b19 = j4.b(fArr, 2, fArr2, 0);
        b20 = j4.b(fArr, 2, fArr2, 1);
        b21 = j4.b(fArr, 2, fArr2, 2);
        b22 = j4.b(fArr, 2, fArr2, 3);
        b23 = j4.b(fArr, 3, fArr2, 0);
        b24 = j4.b(fArr, 3, fArr2, 1);
        b25 = j4.b(fArr, 3, fArr2, 2);
        b26 = j4.b(fArr, 3, fArr2, 3);
        fArr[0] = b11;
        fArr[1] = b12;
        fArr[2] = b13;
        fArr[3] = b14;
        fArr[4] = b15;
        fArr[5] = b16;
        fArr[6] = b17;
        fArr[7] = b18;
        fArr[8] = b19;
        fArr[9] = b20;
        fArr[10] = b21;
        fArr[11] = b22;
        fArr[12] = b23;
        fArr[13] = b24;
        fArr[14] = b25;
        fArr[15] = b26;
    }

    public static String o(float[] fArr) {
        return StringsKt.n("\n            |" + fArr[0] + ' ' + fArr[1] + ' ' + fArr[2] + ' ' + fArr[3] + "|\n            |" + fArr[4] + ' ' + fArr[5] + ' ' + fArr[6] + ' ' + fArr[7] + "|\n            |" + fArr[8] + ' ' + fArr[9] + ' ' + fArr[10] + ' ' + fArr[11] + "|\n            |" + fArr[12] + ' ' + fArr[13] + ' ' + fArr[14] + ' ' + fArr[15] + "|\n        ");
    }

    public static final void p(float[] fArr, float f11, float f12, float f13) {
        float f14 = (fArr[0] * f11) + (fArr[4] * f12) + (fArr[8] * f13) + fArr[12];
        float f15 = (fArr[1] * f11) + (fArr[5] * f12) + (fArr[9] * f13) + fArr[13];
        float f16 = (fArr[2] * f11) + (fArr[6] * f12) + (fArr[10] * f13) + fArr[14];
        float f17 = (fArr[3] * f11) + (fArr[7] * f12) + (fArr[11] * f13) + fArr[15];
        fArr[12] = f14;
        fArr[13] = f15;
        fArr[14] = f16;
        fArr[15] = f17;
    }

    public static /* synthetic */ void q(float[] fArr, float f11, float f12, float f13, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = 0.0f;
        }
        if ((i11 & 2) != 0) {
            f12 = 0.0f;
        }
        if ((i11 & 4) != 0) {
            f13 = 0.0f;
        }
        p(fArr, f11, f12, f13);
    }

    public boolean equals(Object obj) {
        return d(this.f4528a, obj);
    }

    public int hashCode() {
        return e(this.f4528a);
    }

    public final /* synthetic */ float[] r() {
        return this.f4528a;
    }

    public String toString() {
        return o(this.f4528a);
    }
}
