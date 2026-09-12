package androidx.compose.ui.input.pointer;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class a implements s {

    /* renamed from: b, reason: collision with root package name */
    private final int f5048b;

    public a(int i11) {
        this.f5048b = i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.c(a.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.f(obj, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.AndroidPointerIconType");
        return this.f5048b == ((a) obj).f5048b;
    }

    public int hashCode() {
        return this.f5048b;
    }

    public String toString() {
        return "AndroidPointerIcon(type=" + this.f5048b + ')';
    }
}
