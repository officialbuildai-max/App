package com.google.firebase.sessions;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final String f32740a;

    public i(String str) {
        this.f32740a = str;
    }

    public final String a() {
        return this.f32740a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && Intrinsics.c(this.f32740a, ((i) obj).f32740a);
    }

    public int hashCode() {
        String str = this.f32740a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "FirebaseSessionsData(sessionId=" + this.f32740a + ')';
    }
}
