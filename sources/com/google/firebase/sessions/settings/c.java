package com.google.firebase.sessions.settings;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Boolean f32778a;

    /* renamed from: b, reason: collision with root package name */
    private final Double f32779b;

    /* renamed from: c, reason: collision with root package name */
    private final Integer f32780c;

    /* renamed from: d, reason: collision with root package name */
    private final Integer f32781d;

    /* renamed from: e, reason: collision with root package name */
    private final Long f32782e;

    public c(Boolean bool, Double d11, Integer num, Integer num2, Long l11) {
        this.f32778a = bool;
        this.f32779b = d11;
        this.f32780c = num;
        this.f32781d = num2;
        this.f32782e = l11;
    }

    public final Integer a() {
        return this.f32781d;
    }

    public final Long b() {
        return this.f32782e;
    }

    public final Boolean c() {
        return this.f32778a;
    }

    public final Integer d() {
        return this.f32780c;
    }

    public final Double e() {
        return this.f32779b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.c(this.f32778a, cVar.f32778a) && Intrinsics.c(this.f32779b, cVar.f32779b) && Intrinsics.c(this.f32780c, cVar.f32780c) && Intrinsics.c(this.f32781d, cVar.f32781d) && Intrinsics.c(this.f32782e, cVar.f32782e);
    }

    public int hashCode() {
        Boolean bool = this.f32778a;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Double d11 = this.f32779b;
        int hashCode2 = (hashCode + (d11 == null ? 0 : d11.hashCode())) * 31;
        Integer num = this.f32780c;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f32781d;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l11 = this.f32782e;
        return hashCode4 + (l11 != null ? l11.hashCode() : 0);
    }

    public String toString() {
        return "SessionConfigs(sessionEnabled=" + this.f32778a + ", sessionSamplingRate=" + this.f32779b + ", sessionRestartTimeout=" + this.f32780c + ", cacheDuration=" + this.f32781d + ", cacheUpdatedTime=" + this.f32782e + ')';
    }
}
