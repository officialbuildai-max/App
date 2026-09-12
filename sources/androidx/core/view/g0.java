package androidx.core.view;

import android.view.MotionEvent;

/* loaded from: classes.dex */
class g0 {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f8462a = new float[20];

    /* renamed from: b, reason: collision with root package name */
    private final long[] f8463b = new long[20];

    /* renamed from: c, reason: collision with root package name */
    private float f8464c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    private int f8465d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f8466e = 0;

    private void b() {
        this.f8465d = 0;
        this.f8464c = 0.0f;
    }

    private float e() {
        long[] jArr;
        long j11;
        int i11 = this.f8465d;
        if (i11 < 2) {
            return 0.0f;
        }
        int i12 = this.f8466e;
        int i13 = ((i12 + 20) - (i11 - 1)) % 20;
        long j12 = this.f8463b[i12];
        while (true) {
            jArr = this.f8463b;
            j11 = jArr[i13];
            if (j12 - j11 <= 100) {
                break;
            }
            this.f8465d--;
            i13 = (i13 + 1) % 20;
        }
        int i14 = this.f8465d;
        if (i14 < 2) {
            return 0.0f;
        }
        if (i14 == 2) {
            int i15 = (i13 + 1) % 20;
            long j13 = jArr[i15];
            if (j11 == j13) {
                return 0.0f;
            }
            return this.f8462a[i15] / ((float) (j13 - j11));
        }
        float f11 = 0.0f;
        int i16 = 0;
        for (int i17 = 0; i17 < this.f8465d - 1; i17++) {
            int i18 = i17 + i13;
            long[] jArr2 = this.f8463b;
            long j14 = jArr2[i18 % 20];
            int i19 = (i18 + 1) % 20;
            if (jArr2[i19] != j14) {
                i16++;
                float f12 = f(f11);
                float f13 = this.f8462a[i19] / ((float) (this.f8463b[i19] - j14));
                f11 += (f13 - f12) * Math.abs(f13);
                if (i16 == 1) {
                    f11 *= 0.5f;
                }
            }
        }
        return f(f11);
    }

    private static float f(float f11) {
        return (f11 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f11) * 2.0f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.f8465d != 0 && eventTime - this.f8463b[this.f8466e] > 40) {
            b();
        }
        int i11 = (this.f8466e + 1) % 20;
        this.f8466e = i11;
        int i12 = this.f8465d;
        if (i12 != 20) {
            this.f8465d = i12 + 1;
        }
        this.f8462a[i11] = motionEvent.getAxisValue(26);
        this.f8463b[this.f8466e] = eventTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i11, float f11) {
        float e11 = e() * i11;
        this.f8464c = e11;
        if (e11 < (-Math.abs(f11))) {
            this.f8464c = -Math.abs(f11);
        } else if (this.f8464c > Math.abs(f11)) {
            this.f8464c = Math.abs(f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d(int i11) {
        if (i11 != 26) {
            return 0.0f;
        }
        return this.f8464c;
    }
}
