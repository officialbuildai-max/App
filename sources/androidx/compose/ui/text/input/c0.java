package androidx.compose.ui.text.input;

/* loaded from: classes.dex */
public final class c0 implements m {

    /* renamed from: a, reason: collision with root package name */
    private final int f6300a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6301b;

    public c0(int i11, int i12) {
        this.f6300a = i11;
        this.f6301b = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.f6300a == c0Var.f6300a && this.f6301b == c0Var.f6301b;
    }

    public int hashCode() {
        return (this.f6300a * 31) + this.f6301b;
    }

    public String toString() {
        return "SetSelectionCommand(start=" + this.f6300a + ", end=" + this.f6301b + ')';
    }
}
