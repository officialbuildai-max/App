package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.v1;
import com.google.common.collect.ImmutableList;

/* loaded from: classes3.dex */
public final class d0 extends com.google.android.exoplayer2.source.a {

    /* renamed from: h, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.n f25813h;

    /* renamed from: i, reason: collision with root package name */
    private final k.a f25814i;

    /* renamed from: j, reason: collision with root package name */
    private final o1 f25815j;

    /* renamed from: k, reason: collision with root package name */
    private final long f25816k;

    /* renamed from: l, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.z f25817l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f25818m;

    /* renamed from: n, reason: collision with root package name */
    private final k3 f25819n;

    /* renamed from: o, reason: collision with root package name */
    private final v1 f25820o;

    /* renamed from: p, reason: collision with root package name */
    private k0 f25821p;

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final k.a f25822a;

        /* renamed from: b, reason: collision with root package name */
        private com.google.android.exoplayer2.upstream.z f25823b = new com.google.android.exoplayer2.upstream.v();

        /* renamed from: c, reason: collision with root package name */
        private boolean f25824c = true;

        /* renamed from: d, reason: collision with root package name */
        private Object f25825d;

        /* renamed from: e, reason: collision with root package name */
        private String f25826e;

        public b(k.a aVar) {
            this.f25822a = (k.a) com.google.android.exoplayer2.util.a.e(aVar);
        }

        public d0 a(v1.l lVar, long j11) {
            return new d0(this.f25826e, lVar, this.f25822a, j11, this.f25823b, this.f25824c, this.f25825d);
        }

        public b b(com.google.android.exoplayer2.upstream.z zVar) {
            if (zVar == null) {
                zVar = new com.google.android.exoplayer2.upstream.v();
            }
            this.f25823b = zVar;
            return this;
        }
    }

    private d0(String str, v1.l lVar, k.a aVar, long j11, com.google.android.exoplayer2.upstream.z zVar, boolean z10, Object obj) {
        this.f25814i = aVar;
        this.f25816k = j11;
        this.f25817l = zVar;
        this.f25818m = z10;
        v1 a11 = new v1.c().i(Uri.EMPTY).d(lVar.f27842a.toString()).g(ImmutableList.of(lVar)).h(obj).a();
        this.f25820o = a11;
        o1.b U = new o1.b().e0((String) com.google.common.base.h.a(lVar.f27843b, "text/x-unknown")).V(lVar.f27844c).g0(lVar.f27845d).c0(lVar.f27846e).U(lVar.f27847f);
        String str2 = lVar.f27848g;
        this.f25815j = U.S(str2 == null ? str : str2).E();
        this.f25813h = new n.b().i(lVar.f27842a).b(1).a();
        this.f25819n = new t9.u(j11, true, false, false, null, a11);
    }

    @Override // com.google.android.exoplayer2.source.a
    protected void B(k0 k0Var) {
        this.f25821p = k0Var;
        C(this.f25819n);
    }

    @Override // com.google.android.exoplayer2.source.a
    protected void D() {
    }

    @Override // com.google.android.exoplayer2.source.o
    public v1 a() {
        return this.f25820o;
    }

    @Override // com.google.android.exoplayer2.source.o
    public n d(o.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        return new c0(this.f25813h, this.f25814i, this.f25821p, this.f25815j, this.f25816k, this.f25817l, v(bVar), this.f25818m);
    }

    @Override // com.google.android.exoplayer2.source.o
    public void k(n nVar) {
        ((c0) nVar).h();
    }

    @Override // com.google.android.exoplayer2.source.o
    public void maybeThrowSourceInfoRefreshError() {
    }
}
