package com.tn.tranpay;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private String f41579a;

    /* renamed from: b, reason: collision with root package name */
    private String f41580b;

    /* renamed from: c, reason: collision with root package name */
    private String f41581c;

    /* renamed from: d, reason: collision with root package name */
    private String f41582d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f41583e;

    public c() {
        this(null, null, null, null, false, 31, null);
    }

    public c(String str, String str2, String str3, String str4, boolean z10) {
        this.f41579a = str;
        this.f41580b = str2;
        this.f41581c = str3;
        this.f41582d = str4;
        this.f41583e = z10;
    }

    public /* synthetic */ c(String str, String str2, String str3, String str4, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) == 0 ? str4 : null, (i11 & 16) != 0 ? false : z10);
    }
}
