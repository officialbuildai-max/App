package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class a implements m {

    /* renamed from: a, reason: collision with root package name */
    private final AnnotatedString f6294a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6295b;

    public a(AnnotatedString annotatedString, int i11) {
        this.f6294a = annotatedString;
        this.f6295b = i11;
    }

    public a(String str, int i11) {
        this(new AnnotatedString(str, null, null, 6, null), i11);
    }

    public final String a() {
        return this.f6294a.i();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(a(), aVar.a()) && this.f6295b == aVar.f6295b;
    }

    public int hashCode() {
        return (a().hashCode() * 31) + this.f6295b;
    }

    public String toString() {
        return "CommitTextCommand(text='" + a() + "', newCursorPosition=" + this.f6295b + ')';
    }
}
