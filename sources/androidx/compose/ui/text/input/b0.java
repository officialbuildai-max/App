package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class b0 implements m {

    /* renamed from: a, reason: collision with root package name */
    private final AnnotatedString f6298a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6299b;

    public b0(AnnotatedString annotatedString, int i11) {
        this.f6298a = annotatedString;
        this.f6299b = i11;
    }

    public b0(String str, int i11) {
        this(new AnnotatedString(str, null, null, 6, null), i11);
    }

    public final String a() {
        return this.f6298a.i();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return Intrinsics.c(a(), b0Var.a()) && this.f6299b == b0Var.f6299b;
    }

    public int hashCode() {
        return (a().hashCode() * 31) + this.f6299b;
    }

    public String toString() {
        return "SetComposingTextCommand(text='" + a() + "', newCursorPosition=" + this.f6299b + ')';
    }
}
