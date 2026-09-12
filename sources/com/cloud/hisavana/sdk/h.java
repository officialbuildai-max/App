package com.cloud.hisavana.sdk;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private int f22561a;

    /* renamed from: b, reason: collision with root package name */
    private String f22562b;

    /* renamed from: c, reason: collision with root package name */
    private long f22563c;

    /* renamed from: d, reason: collision with root package name */
    private String f22564d;

    public h(int i11, String pkg, long j11, String ad_creative_id) {
        Intrinsics.h(pkg, "pkg");
        Intrinsics.h(ad_creative_id, "ad_creative_id");
        this.f22561a = i11;
        this.f22562b = pkg;
        this.f22563c = j11;
        this.f22564d = ad_creative_id;
    }

    public /* synthetic */ h(int i11, String str, long j11, String str2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11, str, (i12 & 4) != 0 ? 0L : j11, str2);
    }

    public final String a() {
        return this.f22564d;
    }

    public final long b() {
        return this.f22563c;
    }

    public final String c() {
        return this.f22562b;
    }

    public final int d() {
        return this.f22561a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f22561a == hVar.f22561a && Intrinsics.c(this.f22562b, hVar.f22562b) && this.f22563c == hVar.f22563c && Intrinsics.c(this.f22564d, hVar.f22564d);
    }

    public int hashCode() {
        return (((((this.f22561a * 31) + this.f22562b.hashCode()) * 31) + androidx.collection.s.a(this.f22563c)) * 31) + this.f22564d.hashCode();
    }

    public String toString() {
        return "AttrImpressionEntity(_id=" + this.f22561a + ", pkg=" + this.f22562b + ", imp_ts=" + this.f22563c + ", ad_creative_id=" + this.f22564d + ')';
    }
}
