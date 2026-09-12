package com.google.firebase.sessions;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    private final EventType f32787a;

    /* renamed from: b, reason: collision with root package name */
    private final x f32788b;

    /* renamed from: c, reason: collision with root package name */
    private final b f32789c;

    public u(EventType eventType, x sessionData, b applicationInfo) {
        Intrinsics.h(eventType, "eventType");
        Intrinsics.h(sessionData, "sessionData");
        Intrinsics.h(applicationInfo, "applicationInfo");
        this.f32787a = eventType;
        this.f32788b = sessionData;
        this.f32789c = applicationInfo;
    }

    public final b a() {
        return this.f32789c;
    }

    public final EventType b() {
        return this.f32787a;
    }

    public final x c() {
        return this.f32788b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f32787a == uVar.f32787a && Intrinsics.c(this.f32788b, uVar.f32788b) && Intrinsics.c(this.f32789c, uVar.f32789c);
    }

    public int hashCode() {
        return (((this.f32787a.hashCode() * 31) + this.f32788b.hashCode()) * 31) + this.f32789c.hashCode();
    }

    public String toString() {
        return "SessionEvent(eventType=" + this.f32787a + ", sessionData=" + this.f32788b + ", applicationInfo=" + this.f32789c + ')';
    }
}
