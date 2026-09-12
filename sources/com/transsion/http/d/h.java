package com.transsion.http.d;

import com.transsion.wrapperad.view.secondfloor.CustomSwipeRefreshLayout;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f45985a = new h("GET", 0, "GET");

    /* renamed from: b, reason: collision with root package name */
    public static final h f45986b = new h("POST", 1, "POST");

    /* renamed from: c, reason: collision with root package name */
    public static final h f45987c = new h("PUT", 2, "PUT");

    /* renamed from: d, reason: collision with root package name */
    public static final h f45988d = new h("PATCH", 3, "PATCH");

    /* renamed from: e, reason: collision with root package name */
    public static final h f45989e = new h("HEAD", 4, "HEAD");

    /* renamed from: f, reason: collision with root package name */
    public static final h f45990f = new h(CustomSwipeRefreshLayout.MOVE, 5, CustomSwipeRefreshLayout.MOVE);

    /* renamed from: g, reason: collision with root package name */
    public static final h f45991g = new h("COPY", 6, "COPY");

    /* renamed from: h, reason: collision with root package name */
    public static final h f45992h = new h("DELETE", 7, "DELETE");

    /* renamed from: i, reason: collision with root package name */
    public static final h f45993i = new h("OPTIONS", 8, "OPTIONS");

    /* renamed from: j, reason: collision with root package name */
    public static final h f45994j = new h("TRACE", 9, "TRACE");

    /* renamed from: k, reason: collision with root package name */
    public static final h f45995k = new h("CONNECT", 10, "CONNECT");

    /* renamed from: l, reason: collision with root package name */
    private final String f45996l;

    private h(String str, int i11, String str2) {
        this.f45996l = str2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f45996l;
    }
}
