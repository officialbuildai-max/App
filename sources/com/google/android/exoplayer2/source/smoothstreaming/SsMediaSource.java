package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.drm.j;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.drm.x;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.a;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.v;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.v1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import t9.d;
import t9.e;
import t9.h;
import t9.i;

/* loaded from: classes3.dex */
public final class SsMediaSource extends com.google.android.exoplayer2.source.a implements Loader.b {
    private Handler A;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f26580h;

    /* renamed from: i, reason: collision with root package name */
    private final Uri f26581i;

    /* renamed from: j, reason: collision with root package name */
    private final v1.h f26582j;

    /* renamed from: k, reason: collision with root package name */
    private final v1 f26583k;

    /* renamed from: l, reason: collision with root package name */
    private final k.a f26584l;

    /* renamed from: m, reason: collision with root package name */
    private final b.a f26585m;

    /* renamed from: n, reason: collision with root package name */
    private final d f26586n;

    /* renamed from: o, reason: collision with root package name */
    private final u f26587o;

    /* renamed from: p, reason: collision with root package name */
    private final z f26588p;

    /* renamed from: q, reason: collision with root package name */
    private final long f26589q;

    /* renamed from: r, reason: collision with root package name */
    private final p.a f26590r;

    /* renamed from: s, reason: collision with root package name */
    private final b0.a f26591s;

    /* renamed from: t, reason: collision with root package name */
    private final ArrayList f26592t;

    /* renamed from: u, reason: collision with root package name */
    private k f26593u;

    /* renamed from: v, reason: collision with root package name */
    private Loader f26594v;

    /* renamed from: w, reason: collision with root package name */
    private a0 f26595w;

    /* renamed from: x, reason: collision with root package name */
    private k0 f26596x;

    /* renamed from: y, reason: collision with root package name */
    private long f26597y;

    /* renamed from: z, reason: collision with root package name */
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a f26598z;

    /* loaded from: classes3.dex */
    public static final class Factory implements o.a {

        /* renamed from: a, reason: collision with root package name */
        private final b.a f26599a;

        /* renamed from: b, reason: collision with root package name */
        private final k.a f26600b;

        /* renamed from: c, reason: collision with root package name */
        private d f26601c;

        /* renamed from: d, reason: collision with root package name */
        private x f26602d;

        /* renamed from: e, reason: collision with root package name */
        private z f26603e;

        /* renamed from: f, reason: collision with root package name */
        private long f26604f;

        /* renamed from: g, reason: collision with root package name */
        private b0.a f26605g;

        public Factory(b.a aVar, k.a aVar2) {
            this.f26599a = (b.a) com.google.android.exoplayer2.util.a.e(aVar);
            this.f26600b = aVar2;
            this.f26602d = new j();
            this.f26603e = new v();
            this.f26604f = 30000L;
            this.f26601c = new e();
        }

        public Factory(k.a aVar) {
            this(new a.C0377a(aVar), aVar);
        }

        @Override // com.google.android.exoplayer2.source.o.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public SsMediaSource a(v1 v1Var) {
            com.google.android.exoplayer2.util.a.e(v1Var.f27763b);
            b0.a aVar = this.f26605g;
            if (aVar == null) {
                aVar = new SsManifestParser();
            }
            List list = v1Var.f27763b.f27829d;
            return new SsMediaSource(v1Var, null, this.f26600b, !list.isEmpty() ? new com.google.android.exoplayer2.offline.d(aVar, list) : aVar, this.f26599a, this.f26601c, this.f26602d.a(v1Var), this.f26603e, this.f26604f);
        }

        @Override // com.google.android.exoplayer2.source.o.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Factory b(x xVar) {
            if (xVar == null) {
                xVar = new j();
            }
            this.f26602d = xVar;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.o.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Factory c(z zVar) {
            if (zVar == null) {
                zVar = new v();
            }
            this.f26603e = zVar;
            return this;
        }
    }

    static {
        m1.a("goog.exo.smoothstreaming");
    }

    private SsMediaSource(v1 v1Var, com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, k.a aVar2, b0.a aVar3, b.a aVar4, d dVar, u uVar, z zVar, long j11) {
        com.google.android.exoplayer2.util.a.g(aVar == null || !aVar.f26666d);
        this.f26583k = v1Var;
        v1.h hVar = (v1.h) com.google.android.exoplayer2.util.a.e(v1Var.f27763b);
        this.f26582j = hVar;
        this.f26598z = aVar;
        this.f26581i = hVar.f27826a.equals(Uri.EMPTY) ? null : p0.B(hVar.f27826a);
        this.f26584l = aVar2;
        this.f26591s = aVar3;
        this.f26585m = aVar4;
        this.f26586n = dVar;
        this.f26587o = uVar;
        this.f26588p = zVar;
        this.f26589q = j11;
        this.f26590r = v(null);
        this.f26580h = aVar != null;
        this.f26592t = new ArrayList();
    }

    private void I() {
        t9.u uVar;
        for (int i11 = 0; i11 < this.f26592t.size(); i11++) {
            ((c) this.f26592t.get(i11)).l(this.f26598z);
        }
        long j11 = Long.MIN_VALUE;
        long j12 = Long.MAX_VALUE;
        for (a.b bVar : this.f26598z.f26668f) {
            if (bVar.f26684k > 0) {
                j12 = Math.min(j12, bVar.e(0));
                j11 = Math.max(j11, bVar.e(bVar.f26684k - 1) + bVar.c(bVar.f26684k - 1));
            }
        }
        if (j12 == Long.MAX_VALUE) {
            long j13 = this.f26598z.f26666d ? -9223372036854775807L : 0L;
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar = this.f26598z;
            boolean z10 = aVar.f26666d;
            uVar = new t9.u(j13, 0L, 0L, 0L, true, z10, z10, aVar, this.f26583k);
        } else {
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar2 = this.f26598z;
            if (aVar2.f26666d) {
                long j14 = aVar2.f26670h;
                if (j14 != C.TIME_UNSET && j14 > 0) {
                    j12 = Math.max(j12, j11 - j14);
                }
                long j15 = j12;
                long j16 = j11 - j15;
                long B0 = j16 - p0.B0(this.f26589q);
                if (B0 < 5000000) {
                    B0 = Math.min(5000000L, j16 / 2);
                }
                uVar = new t9.u(C.TIME_UNSET, j16, j15, B0, true, true, true, this.f26598z, this.f26583k);
            } else {
                long j17 = aVar2.f26669g;
                long j18 = j17 != C.TIME_UNSET ? j17 : j11 - j12;
                uVar = new t9.u(j12 + j18, j18, j12, 0L, true, false, false, this.f26598z, this.f26583k);
            }
        }
        C(uVar);
    }

    private void J() {
        if (this.f26598z.f26666d) {
            this.A.postDelayed(new Runnable() { // from class: aa.a
                @Override // java.lang.Runnable
                public final void run() {
                    SsMediaSource.this.K();
                }
            }, Math.max(0L, (this.f26597y + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (this.f26594v.h()) {
            return;
        }
        b0 b0Var = new b0(this.f26593u, this.f26581i, 4, this.f26591s);
        this.f26590r.z(new h(b0Var.f27325a, b0Var.f27326b, this.f26594v.m(b0Var, this, this.f26588p.a(b0Var.f27327c))), b0Var.f27327c);
    }

    @Override // com.google.android.exoplayer2.source.a
    protected void B(k0 k0Var) {
        this.f26596x = k0Var;
        this.f26587o.prepare();
        this.f26587o.b(Looper.myLooper(), z());
        if (this.f26580h) {
            this.f26595w = new a0.a();
            I();
            return;
        }
        this.f26593u = this.f26584l.createDataSource();
        Loader loader = new Loader("SsMediaSource");
        this.f26594v = loader;
        this.f26595w = loader;
        this.A = p0.w();
        K();
    }

    @Override // com.google.android.exoplayer2.source.a
    protected void D() {
        this.f26598z = this.f26580h ? this.f26598z : null;
        this.f26593u = null;
        this.f26597y = 0L;
        Loader loader = this.f26594v;
        if (loader != null) {
            loader.k();
            this.f26594v = null;
        }
        Handler handler = this.A;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.A = null;
        }
        this.f26587o.release();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void j(b0 b0Var, long j11, long j12, boolean z10) {
        h hVar = new h(b0Var.f27325a, b0Var.f27326b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
        this.f26588p.b(b0Var.f27325a);
        this.f26590r.q(hVar, b0Var.f27327c);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void l(b0 b0Var, long j11, long j12) {
        h hVar = new h(b0Var.f27325a, b0Var.f27326b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
        this.f26588p.b(b0Var.f27325a);
        this.f26590r.t(hVar, b0Var.f27327c);
        this.f26598z = (com.google.android.exoplayer2.source.smoothstreaming.manifest.a) b0Var.c();
        this.f26597y = j11 - j12;
        I();
        J();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public Loader.c n(b0 b0Var, long j11, long j12, IOException iOException, int i11) {
        h hVar = new h(b0Var.f27325a, b0Var.f27326b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
        long c11 = this.f26588p.c(new z.c(hVar, new i(b0Var.f27327c), iOException, i11));
        Loader.c g11 = c11 == C.TIME_UNSET ? Loader.f27301g : Loader.g(false, c11);
        boolean c12 = g11.c();
        this.f26590r.x(hVar, b0Var.f27327c, iOException, !c12);
        if (!c12) {
            this.f26588p.b(b0Var.f27325a);
        }
        return g11;
    }

    @Override // com.google.android.exoplayer2.source.o
    public v1 a() {
        return this.f26583k;
    }

    @Override // com.google.android.exoplayer2.source.o
    public n d(o.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        p.a v11 = v(bVar);
        c cVar = new c(this.f26598z, this.f26585m, this.f26596x, this.f26586n, this.f26587o, t(bVar), this.f26588p, v11, this.f26595w, bVar2);
        this.f26592t.add(cVar);
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.o
    public void k(n nVar) {
        ((c) nVar).k();
        this.f26592t.remove(nVar);
    }

    @Override // com.google.android.exoplayer2.source.o
    public void maybeThrowSourceInfoRefreshError() {
        this.f26595w.maybeThrowError();
    }
}
