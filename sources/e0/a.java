package e0;

import androidx.collection.s;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private long f61586a;

    /* renamed from: b, reason: collision with root package name */
    private float f61587b;

    public a(long j11, float f11) {
        this.f61586a = j11;
        this.f61587b = f11;
    }

    public final float a() {
        return this.f61587b;
    }

    public final long b() {
        return this.f61586a;
    }

    public final void c(float f11) {
        this.f61587b = f11;
    }

    public final void d(long j11) {
        this.f61586a = j11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f61586a == aVar.f61586a && Float.compare(this.f61587b, aVar.f61587b) == 0;
    }

    public int hashCode() {
        return (s.a(this.f61586a) * 31) + Float.floatToIntBits(this.f61587b);
    }

    public String toString() {
        return "DataPointAtTime(time=" + this.f61586a + ", dataPoint=" + this.f61587b + ')';
    }
}
