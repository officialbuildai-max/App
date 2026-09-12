package com.google.firebase.sessions;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private final String f32783a;

    /* renamed from: b, reason: collision with root package name */
    private final String f32784b;

    /* renamed from: c, reason: collision with root package name */
    private final int f32785c;

    /* renamed from: d, reason: collision with root package name */
    private final long f32786d;

    public t(String sessionId, String firstSessionId, int i11, long j11) {
        Intrinsics.h(sessionId, "sessionId");
        Intrinsics.h(firstSessionId, "firstSessionId");
        this.f32783a = sessionId;
        this.f32784b = firstSessionId;
        this.f32785c = i11;
        this.f32786d = j11;
    }

    public final String a() {
        return this.f32784b;
    }

    public final String b() {
        return this.f32783a;
    }

    public final int c() {
        return this.f32785c;
    }

    public final long d() {
        return this.f32786d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return Intrinsics.c(this.f32783a, tVar.f32783a) && Intrinsics.c(this.f32784b, tVar.f32784b) && this.f32785c == tVar.f32785c && this.f32786d == tVar.f32786d;
    }

    public int hashCode() {
        return (((((this.f32783a.hashCode() * 31) + this.f32784b.hashCode()) * 31) + this.f32785c) * 31) + androidx.collection.s.a(this.f32786d);
    }

    public String toString() {
        return "SessionDetails(sessionId=" + this.f32783a + ", firstSessionId=" + this.f32784b + ", sessionIndex=" + this.f32785c + ", sessionStartTimestampUs=" + this.f32786d + ')';
    }
}
