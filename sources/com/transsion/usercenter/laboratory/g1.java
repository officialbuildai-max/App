package com.transsion.usercenter.laboratory;

import com.transsion.ad.db.mcc.LocalMcc;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class g1 {

    /* renamed from: a, reason: collision with root package name */
    private boolean f56956a;

    /* renamed from: b, reason: collision with root package name */
    private final LocalMcc f56957b;

    public g1(boolean z10, LocalMcc localMcc) {
        Intrinsics.h(localMcc, "localMcc");
        this.f56956a = z10;
        this.f56957b = localMcc;
    }

    public final LocalMcc a() {
        return this.f56957b;
    }

    public final boolean b() {
        return this.f56956a;
    }

    public final void c(boolean z10) {
        this.f56956a = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g1)) {
            return false;
        }
        g1 g1Var = (g1) obj;
        return this.f56956a == g1Var.f56956a && Intrinsics.c(this.f56957b, g1Var.f56957b);
    }

    public int hashCode() {
        return (androidx.compose.foundation.e.a(this.f56956a) * 31) + this.f56957b.hashCode();
    }

    public String toString() {
        return "NationalInformationEntity(isChecked=" + this.f56956a + ", localMcc=" + this.f56957b + ")";
    }
}
