package com.transsion.member;

import com.transsion.member.bean.request.MemberPromoCodeRes;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class y0 {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f46957a;

    /* renamed from: b, reason: collision with root package name */
    private final String f46958b;

    /* renamed from: c, reason: collision with root package name */
    private final String f46959c;

    /* renamed from: d, reason: collision with root package name */
    private final MemberPromoCodeRes f46960d;

    public y0(boolean z10, String str, String str2, MemberPromoCodeRes memberPromoCodeRes) {
        this.f46957a = z10;
        this.f46958b = str;
        this.f46959c = str2;
        this.f46960d = memberPromoCodeRes;
    }

    public final String a() {
        return this.f46958b;
    }

    public final MemberPromoCodeRes b() {
        return this.f46960d;
    }

    public final boolean c() {
        return this.f46957a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y0)) {
            return false;
        }
        y0 y0Var = (y0) obj;
        return this.f46957a == y0Var.f46957a && Intrinsics.c(this.f46958b, y0Var.f46958b) && Intrinsics.c(this.f46959c, y0Var.f46959c) && Intrinsics.c(this.f46960d, y0Var.f46960d);
    }

    public int hashCode() {
        int a11 = androidx.compose.foundation.e.a(this.f46957a) * 31;
        String str = this.f46958b;
        int hashCode = (a11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f46959c;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        MemberPromoCodeRes memberPromoCodeRes = this.f46960d;
        return hashCode2 + (memberPromoCodeRes != null ? memberPromoCodeRes.hashCode() : 0);
    }

    public String toString() {
        return "PromoCodeRes(res=" + this.f46957a + ", code=" + this.f46958b + ", message=" + this.f46959c + ", data=" + this.f46960d + ")";
    }
}
