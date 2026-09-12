package f0;

import androidx.collection.s;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final float f62245a;

    /* renamed from: b, reason: collision with root package name */
    private final float f62246b;

    /* renamed from: c, reason: collision with root package name */
    private final long f62247c;

    /* renamed from: d, reason: collision with root package name */
    private final int f62248d;

    public b(float f11, float f12, long j11, int i11) {
        this.f62245a = f11;
        this.f62246b = f12;
        this.f62247c = j11;
        this.f62248d = i11;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (bVar.f62245a == this.f62245a && bVar.f62246b == this.f62246b && bVar.f62247c == this.f62247c && bVar.f62248d == this.f62248d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f62245a) * 31) + Float.floatToIntBits(this.f62246b)) * 31) + s.a(this.f62247c)) * 31) + this.f62248d;
    }

    public String toString() {
        return "RotaryScrollEvent(verticalScrollPixels=" + this.f62245a + ",horizontalScrollPixels=" + this.f62246b + ",uptimeMillis=" + this.f62247c + ",deviceId=" + this.f62248d + ')';
    }
}
