package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class l1 {

    /* renamed from: a, reason: collision with root package name */
    private final String f3878a;

    public l1(String str) {
        this.f3878a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l1) && Intrinsics.c(this.f3878a, ((l1) obj).f3878a);
    }

    public int hashCode() {
        return this.f3878a.hashCode();
    }

    public String toString() {
        return "OpaqueKey(key=" + this.f3878a + ')';
    }
}
