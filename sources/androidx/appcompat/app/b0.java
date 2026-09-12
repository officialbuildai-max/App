package androidx.appcompat.app;

/* loaded from: classes.dex */
class b0 {

    /* renamed from: d, reason: collision with root package name */
    private static b0 f1188d;

    /* renamed from: a, reason: collision with root package name */
    public long f1189a;

    /* renamed from: b, reason: collision with root package name */
    public long f1190b;

    /* renamed from: c, reason: collision with root package name */
    public int f1191c;

    b0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b0 b() {
        if (f1188d == null) {
            f1188d = new b0();
        }
        return f1188d;
    }

    public void a(long j11, double d11, double d12) {
        double d13 = (0.01720197f * (((float) (j11 - 946728000000L)) / 8.64E7f)) + 6.24006f;
        double sin = (Math.sin(d13) * 0.03341960161924362d) + d13 + (Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double round = ((float) Math.round((r3 - 9.0E-4f) - r7)) + 9.0E-4f + ((-d12) / 360.0d) + (Math.sin(d13) * 0.0053d) + (Math.sin(2.0d * sin) * (-0.0069d));
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d14 = 0.01745329238474369d * d11;
        double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d14) * Math.sin(asin))) / (Math.cos(d14) * Math.cos(asin));
        if (sin2 >= 1.0d) {
            this.f1191c = 1;
            this.f1189a = -1L;
            this.f1190b = -1L;
        } else {
            if (sin2 <= -1.0d) {
                this.f1191c = 0;
                this.f1189a = -1L;
                this.f1190b = -1L;
                return;
            }
            double acos = (float) (Math.acos(sin2) / 6.283185307179586d);
            this.f1189a = Math.round((round + acos) * 8.64E7d) + 946728000000L;
            long round2 = Math.round((round - acos) * 8.64E7d) + 946728000000L;
            this.f1190b = round2;
            if (round2 >= j11 || this.f1189a <= j11) {
                this.f1191c = 1;
            } else {
                this.f1191c = 0;
            }
        }
    }
}
