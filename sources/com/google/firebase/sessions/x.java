package com.google.firebase.sessions;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private final String f32794a;

    /* renamed from: b, reason: collision with root package name */
    private final String f32795b;

    /* renamed from: c, reason: collision with root package name */
    private final int f32796c;

    /* renamed from: d, reason: collision with root package name */
    private final long f32797d;

    /* renamed from: e, reason: collision with root package name */
    private final d f32798e;

    /* renamed from: f, reason: collision with root package name */
    private final String f32799f;

    /* renamed from: g, reason: collision with root package name */
    private final String f32800g;

    public x(String sessionId, String firstSessionId, int i11, long j11, d dataCollectionStatus, String firebaseInstallationId, String firebaseAuthenticationToken) {
        Intrinsics.h(sessionId, "sessionId");
        Intrinsics.h(firstSessionId, "firstSessionId");
        Intrinsics.h(dataCollectionStatus, "dataCollectionStatus");
        Intrinsics.h(firebaseInstallationId, "firebaseInstallationId");
        Intrinsics.h(firebaseAuthenticationToken, "firebaseAuthenticationToken");
        this.f32794a = sessionId;
        this.f32795b = firstSessionId;
        this.f32796c = i11;
        this.f32797d = j11;
        this.f32798e = dataCollectionStatus;
        this.f32799f = firebaseInstallationId;
        this.f32800g = firebaseAuthenticationToken;
    }

    public final d a() {
        return this.f32798e;
    }

    public final long b() {
        return this.f32797d;
    }

    public final String c() {
        return this.f32800g;
    }

    public final String d() {
        return this.f32799f;
    }

    public final String e() {
        return this.f32795b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return Intrinsics.c(this.f32794a, xVar.f32794a) && Intrinsics.c(this.f32795b, xVar.f32795b) && this.f32796c == xVar.f32796c && this.f32797d == xVar.f32797d && Intrinsics.c(this.f32798e, xVar.f32798e) && Intrinsics.c(this.f32799f, xVar.f32799f) && Intrinsics.c(this.f32800g, xVar.f32800g);
    }

    public final String f() {
        return this.f32794a;
    }

    public final int g() {
        return this.f32796c;
    }

    public int hashCode() {
        return (((((((((((this.f32794a.hashCode() * 31) + this.f32795b.hashCode()) * 31) + this.f32796c) * 31) + androidx.collection.s.a(this.f32797d)) * 31) + this.f32798e.hashCode()) * 31) + this.f32799f.hashCode()) * 31) + this.f32800g.hashCode();
    }

    public String toString() {
        return "SessionInfo(sessionId=" + this.f32794a + ", firstSessionId=" + this.f32795b + ", sessionIndex=" + this.f32796c + ", eventTimestampUs=" + this.f32797d + ", dataCollectionStatus=" + this.f32798e + ", firebaseInstallationId=" + this.f32799f + ", firebaseAuthenticationToken=" + this.f32800g + ')';
    }
}
