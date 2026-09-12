package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3944a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f3945b;

    public p0(Object obj, Object obj2) {
        this.f3944a = obj;
        this.f3945b = obj2;
    }

    private final int a(Object obj) {
        if (obj instanceof Enum) {
            return ((Enum) obj).ordinal();
        }
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        return Intrinsics.c(this.f3944a, p0Var.f3944a) && Intrinsics.c(this.f3945b, p0Var.f3945b);
    }

    public int hashCode() {
        return (a(this.f3944a) * 31) + a(this.f3945b);
    }

    public String toString() {
        return "JoinedKey(left=" + this.f3944a + ", right=" + this.f3945b + ')';
    }
}
