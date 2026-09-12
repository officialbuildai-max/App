package com.transsion.subtitle.helper;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f55018a;

    /* renamed from: b, reason: collision with root package name */
    private final String f55019b;

    /* renamed from: c, reason: collision with root package name */
    private final String f55020c;

    public b(String hostApi, String apiKey, String ua2) {
        Intrinsics.h(hostApi, "hostApi");
        Intrinsics.h(apiKey, "apiKey");
        Intrinsics.h(ua2, "ua");
        this.f55018a = hostApi;
        this.f55019b = apiKey;
        this.f55020c = ua2;
    }

    public final String a() {
        return this.f55019b;
    }

    public final String b() {
        return this.f55018a;
    }

    public final String c() {
        return this.f55020c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.f55018a, bVar.f55018a) && Intrinsics.c(this.f55019b, bVar.f55019b) && Intrinsics.c(this.f55020c, bVar.f55020c);
    }

    public int hashCode() {
        return (((this.f55018a.hashCode() * 31) + this.f55019b.hashCode()) * 31) + this.f55020c.hashCode();
    }

    public String toString() {
        return "OpenSubtitleRequestConfig(hostApi=" + this.f55018a + ", apiKey=" + this.f55019b + ", ua=" + this.f55020c + ")";
    }
}
