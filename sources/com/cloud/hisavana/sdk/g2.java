package com.cloud.hisavana.sdk;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class g2 {

    /* renamed from: a, reason: collision with root package name */
    private final String f22536a;

    /* renamed from: b, reason: collision with root package name */
    private final String f22537b;

    /* renamed from: c, reason: collision with root package name */
    private final int f22538c;

    /* renamed from: d, reason: collision with root package name */
    private final Double f22539d;

    /* renamed from: e, reason: collision with root package name */
    private final int f22540e;

    /* renamed from: f, reason: collision with root package name */
    private final int f22541f;

    /* renamed from: g, reason: collision with root package name */
    private final String f22542g;

    /* renamed from: h, reason: collision with root package name */
    private final String f22543h;

    /* renamed from: i, reason: collision with root package name */
    private final String f22544i;

    /* renamed from: j, reason: collision with root package name */
    private final int f22545j;

    /* renamed from: k, reason: collision with root package name */
    private final String f22546k;

    /* renamed from: l, reason: collision with root package name */
    private final String f22547l;

    /* renamed from: m, reason: collision with root package name */
    private final String f22548m;

    /* renamed from: n, reason: collision with root package name */
    private final String f22549n;

    /* renamed from: o, reason: collision with root package name */
    private final String f22550o;

    /* renamed from: p, reason: collision with root package name */
    private final String f22551p;

    public g2(String ad_creative_id, String codeSeatId, int i11, Double d11, int i12, int i13, String str, String str2, String str3, int i14, String str4, String str5, String str6, String str7, String str8, String str9) {
        Intrinsics.h(ad_creative_id, "ad_creative_id");
        Intrinsics.h(codeSeatId, "codeSeatId");
        this.f22536a = ad_creative_id;
        this.f22537b = codeSeatId;
        this.f22538c = i11;
        this.f22539d = d11;
        this.f22540e = i12;
        this.f22541f = i13;
        this.f22542g = str;
        this.f22543h = str2;
        this.f22544i = str3;
        this.f22545j = i14;
        this.f22546k = str4;
        this.f22547l = str5;
        this.f22548m = str6;
        this.f22549n = str7;
        this.f22550o = str8;
        this.f22551p = str9;
    }

    public final String a() {
        return this.f22551p;
    }

    public final String b() {
        return this.f22536a;
    }

    public final int c() {
        return this.f22540e;
    }

    public final int d() {
        return this.f22538c;
    }

    public final String e() {
        return this.f22537b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g2)) {
            return false;
        }
        g2 g2Var = (g2) obj;
        return Intrinsics.c(this.f22536a, g2Var.f22536a) && Intrinsics.c(this.f22537b, g2Var.f22537b) && this.f22538c == g2Var.f22538c && Intrinsics.c(this.f22539d, g2Var.f22539d) && this.f22540e == g2Var.f22540e && this.f22541f == g2Var.f22541f && Intrinsics.c(this.f22542g, g2Var.f22542g) && Intrinsics.c(this.f22543h, g2Var.f22543h) && Intrinsics.c(this.f22544i, g2Var.f22544i) && this.f22545j == g2Var.f22545j && Intrinsics.c(this.f22546k, g2Var.f22546k) && Intrinsics.c(this.f22547l, g2Var.f22547l) && Intrinsics.c(this.f22548m, g2Var.f22548m) && Intrinsics.c(this.f22549n, g2Var.f22549n) && Intrinsics.c(this.f22550o, g2Var.f22550o) && Intrinsics.c(this.f22551p, g2Var.f22551p);
    }

    public final String f() {
        return this.f22550o;
    }

    public final String g() {
        return this.f22549n;
    }

    public final String h() {
        return this.f22548m;
    }

    public int hashCode() {
        int hashCode = ((((this.f22536a.hashCode() * 31) + this.f22537b.hashCode()) * 31) + this.f22538c) * 31;
        Double d11 = this.f22539d;
        int hashCode2 = (((((hashCode + (d11 == null ? 0 : d11.hashCode())) * 31) + this.f22540e) * 31) + this.f22541f) * 31;
        String str = this.f22542g;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f22543h;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f22544i;
        int hashCode5 = (((hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f22545j) * 31;
        String str4 = this.f22546k;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f22547l;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f22548m;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f22549n;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.f22550o;
        int hashCode10 = (hashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.f22551p;
        return hashCode10 + (str9 != null ? str9.hashCode() : 0);
    }

    public final String i() {
        return this.f22547l;
    }

    public final int j() {
        return this.f22545j;
    }

    public final String k() {
        return this.f22542g;
    }

    public final int l() {
        return this.f22541f;
    }

    public final String m() {
        return this.f22544i;
    }

    public final String n() {
        return this.f22546k;
    }

    public final Double o() {
        return this.f22539d;
    }

    public final String p() {
        return this.f22543h;
    }

    public String toString() {
        return "DefaultAdEntity(ad_creative_id=" + this.f22536a + ", codeSeatId=" + this.f22537b + ", ad_type=" + this.f22538c + ", price=" + this.f22539d + ", ad_request_ver=" + this.f22540e + ", displayed_times=" + this.f22541f + ", displayed_date=" + this.f22542g + ", start_date=" + this.f22543h + ", end_date=" + this.f22544i + ", display_max_times=" + this.f22545j + ", file_path=" + this.f22546k + ", default_country_white=" + this.f22547l + ", default_country_black=" + this.f22548m + ", default_brand_white=" + this.f22549n + ", default_brand_black=" + this.f22550o + ", ad_bean=" + this.f22551p + ')';
    }
}
