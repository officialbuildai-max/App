package com.transsion.usercenter.profile.report;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private String f57374a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f57375b;

    public c(String reportName, boolean z10) {
        Intrinsics.h(reportName, "reportName");
        this.f57374a = reportName;
        this.f57375b = z10;
    }

    public final String a() {
        return this.f57374a;
    }

    public final boolean b() {
        return this.f57375b;
    }

    public final void c(boolean z10) {
        this.f57375b = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.c(this.f57374a, cVar.f57374a) && this.f57375b == cVar.f57375b;
    }

    public int hashCode() {
        return (this.f57374a.hashCode() * 31) + androidx.compose.foundation.e.a(this.f57375b);
    }

    public String toString() {
        return "ReportBean(reportName=" + this.f57374a + ", isChecked=" + this.f57375b + ")";
    }
}
