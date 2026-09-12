package androidx.compose.ui.layout;

/* loaded from: classes.dex */
public final class g implements e {

    /* renamed from: b, reason: collision with root package name */
    private final float f5261b;

    public g(float f11) {
        this.f5261b = f11;
    }

    @Override // androidx.compose.ui.layout.e
    public long a(long j11, long j12) {
        float f11 = this.f5261b;
        return m0.a(f11, f11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && Float.compare(this.f5261b, ((g) obj).f5261b) == 0;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f5261b);
    }

    public String toString() {
        return "FixedScale(value=" + this.f5261b + ')';
    }
}
