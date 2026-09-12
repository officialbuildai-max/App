package my;

/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private boolean f70161a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f70162b;

    public e(boolean z10, boolean z11) {
        this.f70161a = z10;
        this.f70162b = z11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f70161a == eVar.f70161a && this.f70162b == eVar.f70162b;
    }

    public int hashCode() {
        return (androidx.compose.foundation.e.a(this.f70161a) * 31) + androidx.compose.foundation.e.a(this.f70162b);
    }

    public String toString() {
        return "PostEventPlayRecord(isRefresh=" + this.f70161a + ", isOutsideVideo=" + this.f70162b + ")";
    }
}
