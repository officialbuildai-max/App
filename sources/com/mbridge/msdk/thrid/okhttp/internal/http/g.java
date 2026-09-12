package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.mbridge.msdk.thrid.okhttp.n;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.y;
import java.io.IOException;
import java.util.List;

/* loaded from: classes5.dex */
public final class g implements r.a {

    /* renamed from: a, reason: collision with root package name */
    private final List<r> f38046a;

    /* renamed from: b, reason: collision with root package name */
    private final com.mbridge.msdk.thrid.okhttp.internal.connection.g f38047b;

    /* renamed from: c, reason: collision with root package name */
    private final c f38048c;

    /* renamed from: d, reason: collision with root package name */
    private final com.mbridge.msdk.thrid.okhttp.internal.connection.c f38049d;

    /* renamed from: e, reason: collision with root package name */
    private final int f38050e;

    /* renamed from: f, reason: collision with root package name */
    private final w f38051f;

    /* renamed from: g, reason: collision with root package name */
    private final com.mbridge.msdk.thrid.okhttp.d f38052g;

    /* renamed from: h, reason: collision with root package name */
    private final n f38053h;

    /* renamed from: i, reason: collision with root package name */
    private final int f38054i;

    /* renamed from: j, reason: collision with root package name */
    private final int f38055j;

    /* renamed from: k, reason: collision with root package name */
    private final int f38056k;

    /* renamed from: l, reason: collision with root package name */
    private int f38057l;

    public g(List<r> list, com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar, c cVar, com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar2, int i11, w wVar, com.mbridge.msdk.thrid.okhttp.d dVar, n nVar, int i12, int i13, int i14) {
        this.f38046a = list;
        this.f38049d = cVar2;
        this.f38047b = gVar;
        this.f38048c = cVar;
        this.f38050e = i11;
        this.f38051f = wVar;
        this.f38052g = dVar;
        this.f38053h = nVar;
        this.f38054i = i12;
        this.f38055j = i13;
        this.f38056k = i14;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r.a
    public int a() {
        return this.f38054i;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r.a
    public y a(w wVar) throws IOException {
        return a(wVar, this.f38047b, this.f38048c, this.f38049d);
    }

    public y a(w wVar, com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar, c cVar, com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar2) throws IOException {
        if (this.f38050e >= this.f38046a.size()) {
            throw new AssertionError();
        }
        this.f38057l++;
        if (this.f38048c != null && !this.f38049d.a(wVar.g())) {
            throw new IllegalStateException("network interceptor " + this.f38046a.get(this.f38050e - 1) + " must retain the same host and port");
        }
        if (this.f38048c != null && this.f38057l > 1) {
            throw new IllegalStateException("network interceptor " + this.f38046a.get(this.f38050e - 1) + " must call proceed() exactly once");
        }
        g gVar2 = new g(this.f38046a, gVar, cVar, cVar2, this.f38050e + 1, wVar, this.f38052g, this.f38053h, this.f38054i, this.f38055j, this.f38056k);
        r rVar = this.f38046a.get(this.f38050e);
        y a11 = rVar.a(gVar2);
        if (cVar != null && this.f38050e + 1 < this.f38046a.size() && gVar2.f38057l != 1) {
            throw new IllegalStateException("network interceptor " + rVar + " must call proceed() exactly once");
        }
        if (a11 == null) {
            throw new NullPointerException("interceptor " + rVar + " returned null");
        }
        if (a11.d() != null) {
            return a11;
        }
        throw new IllegalStateException("interceptor " + rVar + " returned a response with no body");
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r.a
    public int b() {
        return this.f38055j;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r.a
    public int c() {
        return this.f38056k;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r.a
    public w d() {
        return this.f38051f;
    }

    public com.mbridge.msdk.thrid.okhttp.d e() {
        return this.f38052g;
    }

    public com.mbridge.msdk.thrid.okhttp.g f() {
        return this.f38049d;
    }

    public n g() {
        return this.f38053h;
    }

    public c h() {
        return this.f38048c;
    }

    public com.mbridge.msdk.thrid.okhttp.internal.connection.g i() {
        return this.f38047b;
    }
}
