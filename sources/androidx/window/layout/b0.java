package androidx.window.layout;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.window.core.b f15417a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b0(Rect bounds) {
        this(new androidx.window.core.b(bounds));
        Intrinsics.h(bounds, "bounds");
    }

    public b0(androidx.window.core.b _bounds) {
        Intrinsics.h(_bounds, "_bounds");
        this.f15417a = _bounds;
    }

    public final Rect a() {
        return this.f15417a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.c(b0.class, obj.getClass())) {
            return false;
        }
        return Intrinsics.c(this.f15417a, ((b0) obj).f15417a);
    }

    public int hashCode() {
        return this.f15417a.hashCode();
    }

    public String toString() {
        return "WindowMetrics { bounds: " + a() + " }";
    }
}
