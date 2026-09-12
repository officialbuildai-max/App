package com.transsion.search.fragment.hot.adapter;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f52122a;

    /* renamed from: b, reason: collision with root package name */
    private final String f52123b;

    public a(int i11, String strVal) {
        Intrinsics.h(strVal, "strVal");
        this.f52122a = i11;
        this.f52123b = strVal;
    }

    public final String a() {
        return this.f52123b;
    }

    public final int b() {
        return this.f52122a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f52122a == aVar.f52122a && Intrinsics.c(this.f52123b, aVar.f52123b);
    }

    public int hashCode() {
        return (this.f52122a * 31) + this.f52123b.hashCode();
    }

    public String toString() {
        return "HistoryVal(type=" + this.f52122a + ", strVal=" + this.f52123b + ")";
    }
}
