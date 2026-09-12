package com.google.firebase.sessions;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f32691a;

    /* renamed from: b, reason: collision with root package name */
    private final String f32692b;

    /* renamed from: c, reason: collision with root package name */
    private final String f32693c;

    /* renamed from: d, reason: collision with root package name */
    private final String f32694d;

    /* renamed from: e, reason: collision with root package name */
    private final LogEnvironment f32695e;

    /* renamed from: f, reason: collision with root package name */
    private final a f32696f;

    public b(String appId, String deviceModel, String sessionSdkVersion, String osVersion, LogEnvironment logEnvironment, a androidAppInfo) {
        Intrinsics.h(appId, "appId");
        Intrinsics.h(deviceModel, "deviceModel");
        Intrinsics.h(sessionSdkVersion, "sessionSdkVersion");
        Intrinsics.h(osVersion, "osVersion");
        Intrinsics.h(logEnvironment, "logEnvironment");
        Intrinsics.h(androidAppInfo, "androidAppInfo");
        this.f32691a = appId;
        this.f32692b = deviceModel;
        this.f32693c = sessionSdkVersion;
        this.f32694d = osVersion;
        this.f32695e = logEnvironment;
        this.f32696f = androidAppInfo;
    }

    public final a a() {
        return this.f32696f;
    }

    public final String b() {
        return this.f32691a;
    }

    public final String c() {
        return this.f32692b;
    }

    public final LogEnvironment d() {
        return this.f32695e;
    }

    public final String e() {
        return this.f32694d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.f32691a, bVar.f32691a) && Intrinsics.c(this.f32692b, bVar.f32692b) && Intrinsics.c(this.f32693c, bVar.f32693c) && Intrinsics.c(this.f32694d, bVar.f32694d) && this.f32695e == bVar.f32695e && Intrinsics.c(this.f32696f, bVar.f32696f);
    }

    public final String f() {
        return this.f32693c;
    }

    public int hashCode() {
        return (((((((((this.f32691a.hashCode() * 31) + this.f32692b.hashCode()) * 31) + this.f32693c.hashCode()) * 31) + this.f32694d.hashCode()) * 31) + this.f32695e.hashCode()) * 31) + this.f32696f.hashCode();
    }

    public String toString() {
        return "ApplicationInfo(appId=" + this.f32691a + ", deviceModel=" + this.f32692b + ", sessionSdkVersion=" + this.f32693c + ", osVersion=" + this.f32694d + ", logEnvironment=" + this.f32695e + ", androidAppInfo=" + this.f32696f + ')';
    }
}
