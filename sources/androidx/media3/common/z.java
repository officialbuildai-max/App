package androidx.media3.common;

import androidx.media3.common.util.a1;

/* loaded from: classes2.dex */
public final class z {

    /* renamed from: d, reason: collision with root package name */
    public static final z f10645d = new z(1.0f);

    /* renamed from: e, reason: collision with root package name */
    private static final String f10646e = a1.C0(0);

    /* renamed from: f, reason: collision with root package name */
    private static final String f10647f = a1.C0(1);

    /* renamed from: a, reason: collision with root package name */
    public final float f10648a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10649b;

    /* renamed from: c, reason: collision with root package name */
    private final int f10650c;

    public z(float f11) {
        this(f11, 1.0f);
    }

    public z(float f11, float f12) {
        androidx.media3.common.util.a.a(f11 > 0.0f);
        androidx.media3.common.util.a.a(f12 > 0.0f);
        this.f10648a = f11;
        this.f10649b = f12;
        this.f10650c = Math.round(f11 * 1000.0f);
    }

    public long a(long j11) {
        return j11 * this.f10650c;
    }

    public z b(float f11) {
        return new z(f11, this.f10649b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z.class != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        return this.f10648a == zVar.f10648a && this.f10649b == zVar.f10649b;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.f10648a)) * 31) + Float.floatToRawIntBits(this.f10649b);
    }

    public String toString() {
        return a1.G("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f10648a), Float.valueOf(this.f10649b));
    }
}
