package com.mbridge.msdk.thrid.okhttp.internal.http2;

import okhttp3.internal.http2.Header;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final com.mbridge.msdk.thrid.okio.f f38107d = com.mbridge.msdk.thrid.okio.f.c(":");

    /* renamed from: e, reason: collision with root package name */
    public static final com.mbridge.msdk.thrid.okio.f f38108e = com.mbridge.msdk.thrid.okio.f.c(Header.RESPONSE_STATUS_UTF8);

    /* renamed from: f, reason: collision with root package name */
    public static final com.mbridge.msdk.thrid.okio.f f38109f = com.mbridge.msdk.thrid.okio.f.c(Header.TARGET_METHOD_UTF8);

    /* renamed from: g, reason: collision with root package name */
    public static final com.mbridge.msdk.thrid.okio.f f38110g = com.mbridge.msdk.thrid.okio.f.c(Header.TARGET_PATH_UTF8);

    /* renamed from: h, reason: collision with root package name */
    public static final com.mbridge.msdk.thrid.okio.f f38111h = com.mbridge.msdk.thrid.okio.f.c(Header.TARGET_SCHEME_UTF8);

    /* renamed from: i, reason: collision with root package name */
    public static final com.mbridge.msdk.thrid.okio.f f38112i = com.mbridge.msdk.thrid.okio.f.c(Header.TARGET_AUTHORITY_UTF8);

    /* renamed from: a, reason: collision with root package name */
    public final com.mbridge.msdk.thrid.okio.f f38113a;

    /* renamed from: b, reason: collision with root package name */
    public final com.mbridge.msdk.thrid.okio.f f38114b;

    /* renamed from: c, reason: collision with root package name */
    final int f38115c;

    /* loaded from: classes5.dex */
    interface a {
    }

    public c(com.mbridge.msdk.thrid.okio.f fVar, com.mbridge.msdk.thrid.okio.f fVar2) {
        this.f38113a = fVar;
        this.f38114b = fVar2;
        this.f38115c = fVar.e() + 32 + fVar2.e();
    }

    public c(com.mbridge.msdk.thrid.okio.f fVar, String str) {
        this(fVar, com.mbridge.msdk.thrid.okio.f.c(str));
    }

    public c(String str, String str2) {
        this(com.mbridge.msdk.thrid.okio.f.c(str), com.mbridge.msdk.thrid.okio.f.c(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f38113a.equals(cVar.f38113a) && this.f38114b.equals(cVar.f38114b);
    }

    public int hashCode() {
        return ((this.f38113a.hashCode() + 527) * 31) + this.f38114b.hashCode();
    }

    public String toString() {
        return com.mbridge.msdk.thrid.okhttp.internal.c.a("%s: %s", this.f38113a.h(), this.f38114b.h());
    }
}
