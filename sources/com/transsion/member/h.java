package com.transsion.member;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private final String f46613a;

    /* renamed from: b, reason: collision with root package name */
    private final String f46614b;

    /* renamed from: c, reason: collision with root package name */
    private final String f46615c;

    /* renamed from: d, reason: collision with root package name */
    private final i f46616d;

    /* renamed from: e, reason: collision with root package name */
    private final i f46617e;

    public h(String icon, String name, String showQuestion, i basic, i pro) {
        Intrinsics.h(icon, "icon");
        Intrinsics.h(name, "name");
        Intrinsics.h(showQuestion, "showQuestion");
        Intrinsics.h(basic, "basic");
        Intrinsics.h(pro, "pro");
        this.f46613a = icon;
        this.f46614b = name;
        this.f46615c = showQuestion;
        this.f46616d = basic;
        this.f46617e = pro;
    }

    public final i a() {
        return this.f46616d;
    }

    public final String b() {
        return this.f46613a;
    }

    public final String c() {
        return this.f46614b;
    }

    public final i d() {
        return this.f46617e;
    }

    public final String e() {
        return this.f46615c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Intrinsics.c(this.f46613a, hVar.f46613a) && Intrinsics.c(this.f46614b, hVar.f46614b) && Intrinsics.c(this.f46615c, hVar.f46615c) && Intrinsics.c(this.f46616d, hVar.f46616d) && Intrinsics.c(this.f46617e, hVar.f46617e);
    }

    public int hashCode() {
        return (((((((this.f46613a.hashCode() * 31) + this.f46614b.hashCode()) * 31) + this.f46615c.hashCode()) * 31) + this.f46616d.hashCode()) * 31) + this.f46617e.hashCode();
    }

    public String toString() {
        return "MemberFeatureUiModel(icon=" + this.f46613a + ", name=" + this.f46614b + ", showQuestion=" + this.f46615c + ", basic=" + this.f46616d + ", pro=" + this.f46617e + ")";
    }
}
