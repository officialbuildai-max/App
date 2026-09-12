package androidx.compose.ui.text.input;

/* loaded from: classes.dex */
public final class l implements m {

    /* renamed from: a, reason: collision with root package name */
    private final int f6313a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6314b;

    public l(int i11, int i12) {
        this.f6313a = i11;
        this.f6314b = i12;
        if (i11 < 0 || i12 < 0) {
            throw new IllegalArgumentException(("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i11 + " and " + i12 + " respectively.").toString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f6313a == lVar.f6313a && this.f6314b == lVar.f6314b;
    }

    public int hashCode() {
        return (this.f6313a * 31) + this.f6314b;
    }

    public String toString() {
        return "DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=" + this.f6313a + ", lengthAfterCursor=" + this.f6314b + ')';
    }
}
