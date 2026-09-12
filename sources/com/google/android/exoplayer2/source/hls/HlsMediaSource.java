package com.google.android.exoplayer2.source.hls;

import android.os.Looper;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.drm.x;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.d;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.v;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.v1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.List;

/* loaded from: classes3.dex */
public final class HlsMediaSource extends com.google.android.exoplayer2.source.a implements HlsPlaylistTracker.c {

    /* renamed from: h, reason: collision with root package name */
    private final g f25964h;

    /* renamed from: i, reason: collision with root package name */
    private final v1.h f25965i;

    /* renamed from: j, reason: collision with root package name */
    private final f f25966j;

    /* renamed from: k, reason: collision with root package name */
    private final t9.d f25967k;

    /* renamed from: l, reason: collision with root package name */
    private final u f25968l;

    /* renamed from: m, reason: collision with root package name */
    private final z f25969m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f25970n;

    /* renamed from: o, reason: collision with root package name */
    private final int f25971o;

    /* renamed from: p, reason: collision with root package name */
    private final boolean f25972p;

    /* renamed from: q, reason: collision with root package name */
    private final HlsPlaylistTracker f25973q;

    /* renamed from: r, reason: collision with root package name */
    private final long f25974r;

    /* renamed from: s, reason: collision with root package name */
    private final v1 f25975s;

    /* renamed from: t, reason: collision with root package name */
    private v1.g f25976t;

    /* renamed from: u, reason: collision with root package name */
    private k0 f25977u;

    /* loaded from: classes3.dex */
    public static final class Factory implements o.a {

        /* renamed from: a, reason: collision with root package name */
        private final f f25978a;

        /* renamed from: b, reason: collision with root package name */
        private g f25979b;

        /* renamed from: c, reason: collision with root package name */
        private y9.e f25980c;

        /* renamed from: d, reason: collision with root package name */
        private HlsPlaylistTracker.a f25981d;

        /* renamed from: e, reason: collision with root package name */
        private t9.d f25982e;

        /* renamed from: f, reason: collision with root package name */
        private x f25983f;

        /* renamed from: g, reason: collision with root package name */
        private z f25984g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f25985h;

        /* renamed from: i, reason: collision with root package name */
        private int f25986i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f25987j;

        /* renamed from: k, reason: collision with root package name */
        private long f25988k;

        public Factory(f fVar) {
            this.f25978a = (f) com.google.android.exoplayer2.util.a.e(fVar);
            this.f25983f = new com.google.android.exoplayer2.drm.j();
            this.f25980c = new y9.a();
            this.f25981d = com.google.android.exoplayer2.source.hls.playlist.a.f26147p;
            this.f25979b = g.f26032a;
            this.f25984g = new v();
            this.f25982e = new t9.e();
            this.f25986i = 1;
            this.f25988k = C.TIME_UNSET;
            this.f25985h = true;
        }

        public Factory(k.a aVar) {
            this(new c(aVar));
        }

        @Override // com.google.android.exoplayer2.source.o.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public HlsMediaSource a(v1 v1Var) {
            com.google.android.exoplayer2.util.a.e(v1Var.f27763b);
            y9.e eVar = this.f25980c;
            List list = v1Var.f27763b.f27829d;
            if (!list.isEmpty()) {
                eVar = new y9.c(eVar, list);
            }
            f fVar = this.f25978a;
            g gVar = this.f25979b;
            t9.d dVar = this.f25982e;
            u a11 = this.f25983f.a(v1Var);
            z zVar = this.f25984g;
            return new HlsMediaSource(v1Var, fVar, gVar, dVar, a11, zVar, this.f25981d.a(this.f25978a, zVar, eVar), this.f25988k, this.f25985h, this.f25986i, this.f25987j);
        }

        @Override // com.google.android.exoplayer2.source.o.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Factory b(x xVar) {
            if (xVar == null) {
                xVar = new com.google.android.exoplayer2.drm.j();
            }
            this.f25983f = xVar;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.o.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Factory c(z zVar) {
            if (zVar == null) {
                zVar = new v();
            }
            this.f25984g = zVar;
            return this;
        }
    }

    static {
        m1.a("goog.exo.hls");
    }

    private HlsMediaSource(v1 v1Var, f fVar, g gVar, t9.d dVar, u uVar, z zVar, HlsPlaylistTracker hlsPlaylistTracker, long j11, boolean z10, int i11, boolean z11) {
        this.f25965i = (v1.h) com.google.android.exoplayer2.util.a.e(v1Var.f27763b);
        this.f25975s = v1Var;
        this.f25976t = v1Var.f27765d;
        this.f25966j = fVar;
        this.f25964h = gVar;
        this.f25967k = dVar;
        this.f25968l = uVar;
        this.f25969m = zVar;
        this.f25973q = hlsPlaylistTracker;
        this.f25974r = j11;
        this.f25970n = z10;
        this.f25971o = i11;
        this.f25972p = z11;
    }

    private t9.u E(com.google.android.exoplayer2.source.hls.playlist.d dVar, long j11, long j12, h hVar) {
        long b11 = dVar.f26181h - this.f25973q.b();
        long j13 = dVar.f26188o ? b11 + dVar.f26194u : -9223372036854775807L;
        long I = I(dVar);
        long j14 = this.f25976t.f27816a;
        L(dVar, p0.r(j14 != C.TIME_UNSET ? p0.B0(j14) : K(dVar, I), I, dVar.f26194u + I));
        return new t9.u(j11, j12, C.TIME_UNSET, j13, dVar.f26194u, b11, J(dVar, I), true, !dVar.f26188o, dVar.f26177d == 2 && dVar.f26179f, hVar, this.f25975s, this.f25976t);
    }

    private t9.u F(com.google.android.exoplayer2.source.hls.playlist.d dVar, long j11, long j12, h hVar) {
        long j13;
        if (dVar.f26178e == C.TIME_UNSET || dVar.f26191r.isEmpty()) {
            j13 = 0;
        } else {
            if (!dVar.f26180g) {
                long j14 = dVar.f26178e;
                if (j14 != dVar.f26194u) {
                    j13 = H(dVar.f26191r, j14).f26207e;
                }
            }
            j13 = dVar.f26178e;
        }
        long j15 = j13;
        long j16 = dVar.f26194u;
        return new t9.u(j11, j12, C.TIME_UNSET, j16, j16, 0L, j15, true, false, true, hVar, this.f25975s, null);
    }

    private static d.b G(List list, long j11) {
        d.b bVar = null;
        for (int i11 = 0; i11 < list.size(); i11++) {
            d.b bVar2 = (d.b) list.get(i11);
            long j12 = bVar2.f26207e;
            if (j12 > j11 || !bVar2.f26196l) {
                if (j12 > j11) {
                    break;
                }
            } else {
                bVar = bVar2;
            }
        }
        return bVar;
    }

    private static d.C0374d H(List list, long j11) {
        return (d.C0374d) list.get(p0.g(list, Long.valueOf(j11), true, true));
    }

    private long I(com.google.android.exoplayer2.source.hls.playlist.d dVar) {
        if (dVar.f26189p) {
            return p0.B0(p0.b0(this.f25974r)) - dVar.d();
        }
        return 0L;
    }

    private long J(com.google.android.exoplayer2.source.hls.playlist.d dVar, long j11) {
        long j12 = dVar.f26178e;
        if (j12 == C.TIME_UNSET) {
            j12 = (dVar.f26194u + j11) - p0.B0(this.f25976t.f27816a);
        }
        if (dVar.f26180g) {
            return j12;
        }
        d.b G = G(dVar.f26192s, j12);
        if (G != null) {
            return G.f26207e;
        }
        if (dVar.f26191r.isEmpty()) {
            return 0L;
        }
        d.C0374d H = H(dVar.f26191r, j12);
        d.b G2 = G(H.f26202m, j12);
        return G2 != null ? G2.f26207e : H.f26207e;
    }

    private static long K(com.google.android.exoplayer2.source.hls.playlist.d dVar, long j11) {
        long j12;
        d.f fVar = dVar.f26195v;
        long j13 = dVar.f26178e;
        if (j13 != C.TIME_UNSET) {
            j12 = dVar.f26194u - j13;
        } else {
            long j14 = fVar.f26217d;
            if (j14 == C.TIME_UNSET || dVar.f26187n == C.TIME_UNSET) {
                long j15 = fVar.f26216c;
                j12 = j15 != C.TIME_UNSET ? j15 : dVar.f26186m * 3;
            } else {
                j12 = j14;
            }
        }
        return j12 + j11;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void L(com.google.android.exoplayer2.source.hls.playlist.d r5, long r6) {
        /*
            r4 = this;
            com.google.android.exoplayer2.v1 r0 = r4.f25975s
            com.google.android.exoplayer2.v1$g r0 = r0.f27765d
            float r1 = r0.f27819d
            r2 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L28
            float r0 = r0.f27820e
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L28
            com.google.android.exoplayer2.source.hls.playlist.d$f r5 = r5.f26195v
            long r0 = r5.f26216c
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L28
            long r0 = r5.f26217d
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 != 0) goto L28
            r5 = 1
            goto L29
        L28:
            r5 = 0
        L29:
            com.google.android.exoplayer2.v1$g$a r0 = new com.google.android.exoplayer2.v1$g$a
            r0.<init>()
            long r6 = com.google.android.exoplayer2.util.p0.e1(r6)
            com.google.android.exoplayer2.v1$g$a r6 = r0.k(r6)
            r7 = 1065353216(0x3f800000, float:1.0)
            if (r5 == 0) goto L3c
            r0 = r7
            goto L40
        L3c:
            com.google.android.exoplayer2.v1$g r0 = r4.f25976t
            float r0 = r0.f27819d
        L40:
            com.google.android.exoplayer2.v1$g$a r6 = r6.j(r0)
            if (r5 == 0) goto L47
            goto L4b
        L47:
            com.google.android.exoplayer2.v1$g r5 = r4.f25976t
            float r7 = r5.f27820e
        L4b:
            com.google.android.exoplayer2.v1$g$a r5 = r6.h(r7)
            com.google.android.exoplayer2.v1$g r5 = r5.f()
            r4.f25976t = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsMediaSource.L(com.google.android.exoplayer2.source.hls.playlist.d, long):void");
    }

    @Override // com.google.android.exoplayer2.source.a
    protected void B(k0 k0Var) {
        this.f25977u = k0Var;
        this.f25968l.prepare();
        this.f25968l.b((Looper) com.google.android.exoplayer2.util.a.e(Looper.myLooper()), z());
        this.f25973q.o(this.f25965i.f27826a, v(null), this);
    }

    @Override // com.google.android.exoplayer2.source.a
    protected void D() {
        this.f25973q.stop();
        this.f25968l.release();
    }

    @Override // com.google.android.exoplayer2.source.o
    public v1 a() {
        return this.f25975s;
    }

    @Override // com.google.android.exoplayer2.source.o
    public com.google.android.exoplayer2.source.n d(o.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        p.a v11 = v(bVar);
        return new k(this.f25964h, this.f25973q, this.f25966j, this.f25977u, this.f25968l, t(bVar), this.f25969m, v11, bVar2, this.f25967k, this.f25970n, this.f25971o, this.f25972p, z());
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.c
    public void f(com.google.android.exoplayer2.source.hls.playlist.d dVar) {
        long e12 = dVar.f26189p ? p0.e1(dVar.f26181h) : -9223372036854775807L;
        int i11 = dVar.f26177d;
        long j11 = (i11 == 2 || i11 == 1) ? e12 : -9223372036854775807L;
        h hVar = new h((com.google.android.exoplayer2.source.hls.playlist.e) com.google.android.exoplayer2.util.a.e(this.f25973q.c()), dVar);
        C(this.f25973q.f() ? E(dVar, j11, e12, hVar) : F(dVar, j11, e12, hVar));
    }

    @Override // com.google.android.exoplayer2.source.o
    public void k(com.google.android.exoplayer2.source.n nVar) {
        ((k) nVar).q();
    }

    @Override // com.google.android.exoplayer2.source.o
    public void maybeThrowSourceInfoRefreshError() {
        this.f25973q.h();
    }
}
