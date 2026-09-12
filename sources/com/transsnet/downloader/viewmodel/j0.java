package com.transsnet.downloader.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    private int f60214a;

    /* renamed from: b, reason: collision with root package name */
    private String f60215b;

    /* renamed from: c, reason: collision with root package name */
    private String f60216c;

    /* renamed from: d, reason: collision with root package name */
    private String f60217d;

    /* renamed from: e, reason: collision with root package name */
    private Long f60218e;

    /* renamed from: f, reason: collision with root package name */
    private Long f60219f;

    /* renamed from: g, reason: collision with root package name */
    private Long f60220g;

    /* renamed from: h, reason: collision with root package name */
    private int f60221h;

    /* renamed from: i, reason: collision with root package name */
    private int f60222i;

    public j0(int i11, String str, String str2, String str3, Long l11, Long l12, Long l13, int i12, int i13) {
        this.f60214a = i11;
        this.f60215b = str;
        this.f60216c = str2;
        this.f60217d = str3;
        this.f60218e = l11;
        this.f60219f = l12;
        this.f60220g = l13;
        this.f60221h = i12;
        this.f60222i = i13;
    }

    public final Long a() {
        return this.f60220g;
    }

    public final int b() {
        return this.f60222i;
    }

    public final int c() {
        return this.f60214a;
    }

    public final String d() {
        return this.f60216c;
    }

    public final String e() {
        return this.f60215b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        return this.f60214a == j0Var.f60214a && Intrinsics.c(this.f60215b, j0Var.f60215b) && Intrinsics.c(this.f60216c, j0Var.f60216c) && Intrinsics.c(this.f60217d, j0Var.f60217d) && Intrinsics.c(this.f60218e, j0Var.f60218e) && Intrinsics.c(this.f60219f, j0Var.f60219f) && Intrinsics.c(this.f60220g, j0Var.f60220g) && this.f60221h == j0Var.f60221h && this.f60222i == j0Var.f60222i;
    }

    public final int f() {
        return this.f60221h;
    }

    public int hashCode() {
        int i11 = this.f60214a * 31;
        String str = this.f60215b;
        int hashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f60216c;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f60217d;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l11 = this.f60218e;
        int hashCode4 = (hashCode3 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.f60219f;
        int hashCode5 = (hashCode4 + (l12 == null ? 0 : l12.hashCode())) * 31;
        Long l13 = this.f60220g;
        return ((((hashCode5 + (l13 != null ? l13.hashCode() : 0)) * 31) + this.f60221h) * 31) + this.f60222i;
    }

    public String toString() {
        return "Video(id=" + this.f60214a + ", path=" + this.f60215b + ", name=" + this.f60216c + ", resolution=" + this.f60217d + ", size=" + this.f60218e + ", date=" + this.f60219f + ", duration=" + this.f60220g + ", width=" + this.f60221h + ", height=" + this.f60222i + ")";
    }
}
