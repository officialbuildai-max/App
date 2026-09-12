package com.google.firebase.sessions;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f32677a;

    /* renamed from: b, reason: collision with root package name */
    private final String f32678b;

    /* renamed from: c, reason: collision with root package name */
    private final String f32679c;

    /* renamed from: d, reason: collision with root package name */
    private final String f32680d;

    /* renamed from: e, reason: collision with root package name */
    private final p f32681e;

    /* renamed from: f, reason: collision with root package name */
    private final List f32682f;

    public a(String packageName, String versionName, String appBuildVersion, String deviceManufacturer, p currentProcessDetails, List appProcessDetails) {
        Intrinsics.h(packageName, "packageName");
        Intrinsics.h(versionName, "versionName");
        Intrinsics.h(appBuildVersion, "appBuildVersion");
        Intrinsics.h(deviceManufacturer, "deviceManufacturer");
        Intrinsics.h(currentProcessDetails, "currentProcessDetails");
        Intrinsics.h(appProcessDetails, "appProcessDetails");
        this.f32677a = packageName;
        this.f32678b = versionName;
        this.f32679c = appBuildVersion;
        this.f32680d = deviceManufacturer;
        this.f32681e = currentProcessDetails;
        this.f32682f = appProcessDetails;
    }

    public final String a() {
        return this.f32679c;
    }

    public final List b() {
        return this.f32682f;
    }

    public final p c() {
        return this.f32681e;
    }

    public final String d() {
        return this.f32680d;
    }

    public final String e() {
        return this.f32677a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.f32677a, aVar.f32677a) && Intrinsics.c(this.f32678b, aVar.f32678b) && Intrinsics.c(this.f32679c, aVar.f32679c) && Intrinsics.c(this.f32680d, aVar.f32680d) && Intrinsics.c(this.f32681e, aVar.f32681e) && Intrinsics.c(this.f32682f, aVar.f32682f);
    }

    public final String f() {
        return this.f32678b;
    }

    public int hashCode() {
        return (((((((((this.f32677a.hashCode() * 31) + this.f32678b.hashCode()) * 31) + this.f32679c.hashCode()) * 31) + this.f32680d.hashCode()) * 31) + this.f32681e.hashCode()) * 31) + this.f32682f.hashCode();
    }

    public String toString() {
        return "AndroidApplicationInfo(packageName=" + this.f32677a + ", versionName=" + this.f32678b + ", appBuildVersion=" + this.f32679c + ", deviceManufacturer=" + this.f32680d + ", currentProcessDetails=" + this.f32681e + ", appProcessDetails=" + this.f32682f + ')';
    }
}
