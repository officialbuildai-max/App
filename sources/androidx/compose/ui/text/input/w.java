package androidx.compose.ui.text.input;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class w implements j0 {

    /* renamed from: b, reason: collision with root package name */
    private final char f6355b;

    public w() {
        this((char) 0, 1, null);
    }

    public w(char c11) {
        this.f6355b = c11;
    }

    public /* synthetic */ w(char c11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? (char) 8226 : c11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof w) && this.f6355b == ((w) obj).f6355b;
    }

    public int hashCode() {
        return this.f6355b;
    }
}
