package com.tn.tranpay.report;

import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f41721a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f41722b;

    /* renamed from: c, reason: collision with root package name */
    private final HashMap f41723c;

    /* renamed from: d, reason: collision with root package name */
    private String f41724d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f41725e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f41726f;

    /* renamed from: g, reason: collision with root package name */
    private long f41727g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f41728h;

    /* renamed from: i, reason: collision with root package name */
    private String f41729i;

    public c(String pageName, boolean z10) {
        Intrinsics.h(pageName, "pageName");
        this.f41721a = pageName;
        this.f41722b = z10;
        this.f41723c = new HashMap();
        this.f41726f = true;
        this.f41727g = -1L;
    }

    public /* synthetic */ c(String str, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? true : z10);
    }

    public final String a() {
        return this.f41724d;
    }

    public final boolean b() {
        return this.f41722b;
    }

    public final boolean c() {
        return this.f41725e;
    }

    public final boolean d() {
        return this.f41726f;
    }

    public final String e() {
        return this.f41729i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.c(this.f41721a, cVar.f41721a) && this.f41722b == cVar.f41722b;
    }

    public final String f() {
        return this.f41721a;
    }

    public final HashMap g() {
        return this.f41723c;
    }

    public final long h() {
        return this.f41727g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f41721a.hashCode() * 31;
        boolean z10 = this.f41722b;
        int i11 = z10;
        if (z10 != 0) {
            i11 = 1;
        }
        return hashCode + i11;
    }

    public final boolean i() {
        return this.f41728h;
    }

    public final void j(boolean z10) {
        this.f41728h = z10;
    }

    public final void k(long j11) {
        this.f41727g = j11;
    }

    public String toString() {
        return "LogViewConfig(pageName=" + this.f41721a + ", needAddToPageFrom=" + this.f41722b + ")";
    }
}
