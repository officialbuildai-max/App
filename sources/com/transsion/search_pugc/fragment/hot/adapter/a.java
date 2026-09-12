package com.transsion.search_pugc.fragment.hot.adapter;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f52411a;

    /* renamed from: b, reason: collision with root package name */
    private final String f52412b;

    public a(int i11, String strVal) {
        Intrinsics.h(strVal, "strVal");
        this.f52411a = i11;
        this.f52412b = strVal;
    }

    public final String a() {
        return this.f52412b;
    }

    public final int b() {
        return this.f52411a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f52411a == aVar.f52411a && Intrinsics.c(this.f52412b, aVar.f52412b);
    }

    public int hashCode() {
        return (this.f52411a * 31) + this.f52412b.hashCode();
    }

    public String toString() {
        return "HistoryVal(type=" + this.f52411a + ", strVal=" + this.f52412b + ")";
    }
}
