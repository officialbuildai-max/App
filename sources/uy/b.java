package uy;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f77073a;

    public b(String postId) {
        Intrinsics.h(postId, "postId");
        this.f77073a = postId;
    }

    public final String a() {
        return this.f77073a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && Intrinsics.c(this.f77073a, ((b) obj).f77073a);
    }

    public int hashCode() {
        return this.f77073a.hashCode();
    }

    public String toString() {
        return "DeletePostEvent(postId=" + this.f77073a + ")";
    }
}
