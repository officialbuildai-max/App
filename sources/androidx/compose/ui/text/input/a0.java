package androidx.compose.ui.text.input;

/* loaded from: classes.dex */
public final class a0 implements m {

    /* renamed from: a, reason: collision with root package name */
    private final int f6296a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6297b;

    public a0(int i11, int i12) {
        this.f6296a = i11;
        this.f6297b = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return this.f6296a == a0Var.f6296a && this.f6297b == a0Var.f6297b;
    }

    public int hashCode() {
        return (this.f6296a * 31) + this.f6297b;
    }

    public String toString() {
        return "SetComposingRegionCommand(start=" + this.f6296a + ", end=" + this.f6297b + ')';
    }
}
