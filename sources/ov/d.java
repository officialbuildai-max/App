package ov;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final String f72310a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f72311b;

    public d(String userId, boolean z10) {
        Intrinsics.h(userId, "userId");
        this.f72310a = userId;
        this.f72311b = z10;
    }

    public final String a() {
        return this.f72310a;
    }

    public final boolean b() {
        return this.f72311b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.c(this.f72310a, dVar.f72310a) && this.f72311b == dVar.f72311b;
    }

    public int hashCode() {
        return (this.f72310a.hashCode() * 31) + androidx.compose.foundation.e.a(this.f72311b);
    }

    public String toString() {
        return "UGCSubscribeEvent(userId=" + this.f72310a + ", isSubscribed=" + this.f72311b + ")";
    }
}
