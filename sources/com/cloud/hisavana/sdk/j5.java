package com.cloud.hisavana.sdk;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class j5 {

    /* renamed from: a, reason: collision with root package name */
    private int f22640a;

    /* renamed from: b, reason: collision with root package name */
    private int f22641b;

    /* renamed from: c, reason: collision with root package name */
    private String f22642c;

    /* renamed from: d, reason: collision with root package name */
    private String f22643d;

    /* renamed from: e, reason: collision with root package name */
    private String f22644e;

    /* renamed from: f, reason: collision with root package name */
    private long f22645f;

    /* renamed from: g, reason: collision with root package name */
    private String f22646g;

    public j5(int i11, int i12, String pkg, String dl_type, String codeSeatId, long j11, String ad_creative_id) {
        Intrinsics.h(pkg, "pkg");
        Intrinsics.h(dl_type, "dl_type");
        Intrinsics.h(codeSeatId, "codeSeatId");
        Intrinsics.h(ad_creative_id, "ad_creative_id");
        this.f22640a = i11;
        this.f22641b = i12;
        this.f22642c = pkg;
        this.f22643d = dl_type;
        this.f22644e = codeSeatId;
        this.f22645f = j11;
        this.f22646g = ad_creative_id;
    }

    public /* synthetic */ j5(int i11, int i12, String str, String str2, String str3, long j11, String str4, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0 : i11, (i13 & 2) != 0 ? 0 : i12, str, str2, str3, (i13 & 32) != 0 ? 0L : j11, str4);
    }

    public final int a() {
        return this.f22641b;
    }

    public final String b() {
        return this.f22646g;
    }

    public final long c() {
        return this.f22645f;
    }

    public final String d() {
        return this.f22644e;
    }

    public final String e() {
        return this.f22643d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j5)) {
            return false;
        }
        j5 j5Var = (j5) obj;
        return this.f22640a == j5Var.f22640a && this.f22641b == j5Var.f22641b && Intrinsics.c(this.f22642c, j5Var.f22642c) && Intrinsics.c(this.f22643d, j5Var.f22643d) && Intrinsics.c(this.f22644e, j5Var.f22644e) && this.f22645f == j5Var.f22645f && Intrinsics.c(this.f22646g, j5Var.f22646g);
    }

    public final String f() {
        return this.f22642c;
    }

    public final int g() {
        return this.f22640a;
    }

    public int hashCode() {
        return (((((((((((this.f22640a * 31) + this.f22641b) * 31) + this.f22642c.hashCode()) * 31) + this.f22643d.hashCode()) * 31) + this.f22644e.hashCode()) * 31) + androidx.collection.s.a(this.f22645f)) * 31) + this.f22646g.hashCode();
    }

    public String toString() {
        return "AttrClickEntity(_id=" + this.f22640a + ", ac_type=" + this.f22641b + ", pkg=" + this.f22642c + ", dl_type=" + this.f22643d + ", codeSeatId=" + this.f22644e + ", click_ts=" + this.f22645f + ", ad_creative_id=" + this.f22646g + ')';
    }
}
