package com.google.android.exoplayer2.source;

import android.os.Looper;
import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.source.w;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.v1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import e9.u1;

/* loaded from: classes3.dex */
public final class x extends com.google.android.exoplayer2.source.a implements w.b {

    /* renamed from: h, reason: collision with root package name */
    private final v1 f26742h;

    /* renamed from: i, reason: collision with root package name */
    private final v1.h f26743i;

    /* renamed from: j, reason: collision with root package name */
    private final k.a f26744j;

    /* renamed from: k, reason: collision with root package name */
    private final r.a f26745k;

    /* renamed from: l, reason: collision with root package name */
    private final com.google.android.exoplayer2.drm.u f26746l;

    /* renamed from: m, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.z f26747m;

    /* renamed from: n, reason: collision with root package name */
    private final int f26748n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f26749o;

    /* renamed from: p, reason: collision with root package name */
    private long f26750p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f26751q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f26752r;

    /* renamed from: s, reason: collision with root package name */
    private k0 f26753s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends j {
        a(x xVar, k3 k3Var) {
            super(k3Var);
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.k3
        public k3.b k(int i11, k3.b bVar, boolean z10) {
            super.k(i11, bVar, z10);
            bVar.f25213f = true;
            return bVar;
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.k3
        public k3.d s(int i11, k3.d dVar, long j11) {
            super.s(i11, dVar, j11);
            dVar.f25234l = true;
            return dVar;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements o.a {

        /* renamed from: a, reason: collision with root package name */
        private final k.a f26754a;

        /* renamed from: b, reason: collision with root package name */
        private r.a f26755b;

        /* renamed from: c, reason: collision with root package name */
        private com.google.android.exoplayer2.drm.x f26756c;

        /* renamed from: d, reason: collision with root package name */
        private com.google.android.exoplayer2.upstream.z f26757d;

        /* renamed from: e, reason: collision with root package name */
        private int f26758e;

        /* renamed from: f, reason: collision with root package name */
        private String f26759f;

        /* renamed from: g, reason: collision with root package name */
        private Object f26760g;

        public b(k.a aVar) {
            this(aVar, new g9.i());
        }

        public b(k.a aVar, r.a aVar2) {
            this(aVar, aVar2, new com.google.android.exoplayer2.drm.j(), new com.google.android.exoplayer2.upstream.v(), 1048576);
        }

        public b(k.a aVar, r.a aVar2, com.google.android.exoplayer2.drm.x xVar, com.google.android.exoplayer2.upstream.z zVar, int i11) {
            this.f26754a = aVar;
            this.f26755b = aVar2;
            this.f26756c = xVar;
            this.f26757d = zVar;
            this.f26758e = i11;
        }

        public b(k.a aVar, final g9.r rVar) {
            this(aVar, new r.a() { // from class: t9.r
                @Override // com.google.android.exoplayer2.source.r.a
                public final com.google.android.exoplayer2.source.r a(u1 u1Var) {
                    com.google.android.exoplayer2.source.r f11;
                    f11 = x.b.f(g9.r.this, u1Var);
                    return f11;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ r f(g9.r rVar, u1 u1Var) {
            return new t9.a(rVar);
        }

        @Override // com.google.android.exoplayer2.source.o.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public x a(v1 v1Var) {
            com.google.android.exoplayer2.util.a.e(v1Var.f27763b);
            v1.h hVar = v1Var.f27763b;
            boolean z10 = false;
            boolean z11 = hVar.f27833h == null && this.f26760g != null;
            if (hVar.f27830e == null && this.f26759f != null) {
                z10 = true;
            }
            if (z11 && z10) {
                v1Var = v1Var.b().h(this.f26760g).b(this.f26759f).a();
            } else if (z11) {
                v1Var = v1Var.b().h(this.f26760g).a();
            } else if (z10) {
                v1Var = v1Var.b().b(this.f26759f).a();
            }
            v1 v1Var2 = v1Var;
            return new x(v1Var2, this.f26754a, this.f26755b, this.f26756c.a(v1Var2), this.f26757d, this.f26758e, null);
        }

        @Override // com.google.android.exoplayer2.source.o.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public b b(com.google.android.exoplayer2.drm.x xVar) {
            this.f26756c = (com.google.android.exoplayer2.drm.x) com.google.android.exoplayer2.util.a.f(xVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // com.google.android.exoplayer2.source.o.a
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public b c(com.google.android.exoplayer2.upstream.z zVar) {
            this.f26757d = (com.google.android.exoplayer2.upstream.z) com.google.android.exoplayer2.util.a.f(zVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }
    }

    private x(v1 v1Var, k.a aVar, r.a aVar2, com.google.android.exoplayer2.drm.u uVar, com.google.android.exoplayer2.upstream.z zVar, int i11) {
        this.f26743i = (v1.h) com.google.android.exoplayer2.util.a.e(v1Var.f27763b);
        this.f26742h = v1Var;
        this.f26744j = aVar;
        this.f26745k = aVar2;
        this.f26746l = uVar;
        this.f26747m = zVar;
        this.f26748n = i11;
        this.f26749o = true;
        this.f26750p = C.TIME_UNSET;
    }

    /* synthetic */ x(v1 v1Var, k.a aVar, r.a aVar2, com.google.android.exoplayer2.drm.u uVar, com.google.android.exoplayer2.upstream.z zVar, int i11, a aVar3) {
        this(v1Var, aVar, aVar2, uVar, zVar, i11);
    }

    private void E() {
        k3 uVar = new t9.u(this.f26750p, this.f26751q, false, this.f26752r, null, this.f26742h);
        if (this.f26749o) {
            uVar = new a(this, uVar);
        }
        C(uVar);
    }

    @Override // com.google.android.exoplayer2.source.a
    protected void B(k0 k0Var) {
        this.f26753s = k0Var;
        this.f26746l.prepare();
        this.f26746l.b((Looper) com.google.android.exoplayer2.util.a.e(Looper.myLooper()), z());
        E();
    }

    @Override // com.google.android.exoplayer2.source.a
    protected void D() {
        this.f26746l.release();
    }

    @Override // com.google.android.exoplayer2.source.o
    public v1 a() {
        return this.f26742h;
    }

    @Override // com.google.android.exoplayer2.source.o
    public n d(o.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        com.google.android.exoplayer2.upstream.k createDataSource = this.f26744j.createDataSource();
        k0 k0Var = this.f26753s;
        if (k0Var != null) {
            createDataSource.e(k0Var);
        }
        return new w(this.f26743i.f27826a, createDataSource, this.f26745k.a(z()), this.f26746l, t(bVar), this.f26747m, v(bVar), this, bVar2, this.f26743i.f27830e, this.f26748n);
    }

    @Override // com.google.android.exoplayer2.source.o
    public void k(n nVar) {
        ((w) nVar).S();
    }

    @Override // com.google.android.exoplayer2.source.o
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // com.google.android.exoplayer2.source.w.b
    public void p(long j11, boolean z10, boolean z11) {
        if (j11 == C.TIME_UNSET) {
            j11 = this.f26750p;
        }
        if (!this.f26749o && this.f26750p == j11 && this.f26751q == z10 && this.f26752r == z11) {
            return;
        }
        this.f26750p = j11;
        this.f26751q = z10;
        this.f26752r = z11;
        this.f26749o = false;
        E();
    }
}
