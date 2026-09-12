package androidx.compose.ui.semantics;

import kotlin.Function;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f6027a;

    /* renamed from: b, reason: collision with root package name */
    private final Function f6028b;

    public a(String str, Function function) {
        this.f6027a = str;
        this.f6028b = function;
    }

    public final Function a() {
        return this.f6028b;
    }

    public final String b() {
        return this.f6027a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.f6027a, aVar.f6027a) && Intrinsics.c(this.f6028b, aVar.f6028b);
    }

    public int hashCode() {
        String str = this.f6027a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Function function = this.f6028b;
        return hashCode + (function != null ? function.hashCode() : 0);
    }

    public String toString() {
        return "AccessibilityAction(label=" + this.f6027a + ", action=" + this.f6028b + ')';
    }
}
