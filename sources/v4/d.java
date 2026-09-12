package v4;

/* loaded from: classes2.dex */
public class d {
    private static float a(float f11) {
        return f11 <= 0.04045f ? f11 / 12.92f : (float) Math.pow((f11 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    private static float b(float f11) {
        return f11 <= 0.0031308f ? f11 * 12.92f : (float) ((Math.pow(f11, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int c(float f11, int i11, int i12) {
        if (i11 == i12 || f11 <= 0.0f) {
            return i11;
        }
        if (f11 >= 1.0f) {
            return i12;
        }
        float f12 = ((i11 >> 24) & 255) / 255.0f;
        float a11 = a(((i11 >> 16) & 255) / 255.0f);
        float a12 = a(((i11 >> 8) & 255) / 255.0f);
        float a13 = a((i11 & 255) / 255.0f);
        float a14 = a(((i12 >> 16) & 255) / 255.0f);
        float f13 = f12 + (((((i12 >> 24) & 255) / 255.0f) - f12) * f11);
        float a15 = a12 + ((a(((i12 >> 8) & 255) / 255.0f) - a12) * f11);
        float a16 = a13 + (f11 * (a((i12 & 255) / 255.0f) - a13));
        return (Math.round(b(a11 + ((a14 - a11) * f11)) * 255.0f) << 16) | (Math.round(f13 * 255.0f) << 24) | (Math.round(b(a15) * 255.0f) << 8) | Math.round(b(a16) * 255.0f);
    }
}
