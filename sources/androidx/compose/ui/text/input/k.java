package androidx.compose.ui.text.input;

/* loaded from: classes.dex */
public final class k implements m {

    /* renamed from: a, reason: collision with root package name */
    private final int f6311a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6312b;

    public k(int i11, int i12) {
        this.f6311a = i11;
        this.f6312b = i12;
        if (i11 < 0 || i12 < 0) {
            throw new IllegalArgumentException(("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i11 + " and " + i12 + " respectively.").toString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f6311a == kVar.f6311a && this.f6312b == kVar.f6312b;
    }

    public int hashCode() {
        return (this.f6311a * 31) + this.f6312b;
    }

    public String toString() {
        return "DeleteSurroundingTextCommand(lengthBeforeCursor=" + this.f6311a + ", lengthAfterCursor=" + this.f6312b + ')';
    }
}
