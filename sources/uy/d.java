package uy;

/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f77077a;

    public d(boolean z10) {
        this.f77077a = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && this.f77077a == ((d) obj).f77077a;
    }

    public int hashCode() {
        return androidx.compose.foundation.e.a(this.f77077a);
    }

    public String toString() {
        return "MainTabEvent(white=" + this.f77077a + ")";
    }
}
