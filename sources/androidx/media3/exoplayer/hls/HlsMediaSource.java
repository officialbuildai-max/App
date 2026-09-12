package androidx.media3.exoplayer.hls;

import android.os.Looper;
import androidx.media3.common.t;
import androidx.media3.common.util.a1;
import androidx.media3.datasource.a;
import androidx.media3.exoplayer.drm.w;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.hls.playlist.c;
import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.source.s;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import i3.s;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class HlsMediaSource extends androidx.media3.exoplayer.source.a implements HlsPlaylistTracker.c {

    /* renamed from: h, reason: collision with root package name */
    private final g f11743h;

    /* renamed from: i, reason: collision with root package name */
    private final f f11744i;

    /* renamed from: j, reason: collision with root package name */
    private final g2.e f11745j;

    /* renamed from: k, reason: collision with root package name */
    private final androidx.media3.exoplayer.drm.t f11746k;

    /* renamed from: l, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.m f11747l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f11748m;

    /* renamed from: n, reason: collision with root package name */
    private final int f11749n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f11750o;

    /* renamed from: p, reason: collision with root package name */
    private final HlsPlaylistTracker f11751p;

    /* renamed from: q, reason: collision with root package name */
    private final long f11752q;

    /* renamed from: r, reason: collision with root package name */
    private final long f11753r;

    /* renamed from: s, reason: collision with root package name */
    private t.g f11754s;

    /* renamed from: t, reason: collision with root package name */
    private w1.n f11755t;

    /* renamed from: u, reason: collision with root package name */
    private androidx.media3.common.t f11756u;

    /* loaded from: classes2.dex */
    public static final class Factory implements r.a {

        /* renamed from: a, reason: collision with root package name */
        private final f f11757a;

        /* renamed from: b, reason: collision with root package name */
        private g f11758b;

        /* renamed from: c, reason: collision with root package name */
        private s.a f11759c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f11760d;

        /* renamed from: e, reason: collision with root package name */
        private int f11761e;

        /* renamed from: f, reason: collision with root package name */
        private c2.e f11762f;

        /* renamed from: g, reason: collision with root package name */
        private HlsPlaylistTracker.a f11763g;

        /* renamed from: h, reason: collision with root package name */
        private g2.e f11764h;

        /* renamed from: i, reason: collision with root package name */
        private w f11765i;

        /* renamed from: j, reason: collision with root package name */
        private androidx.media3.exoplayer.upstream.m f11766j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f11767k;

        /* renamed from: l, reason: collision with root package name */
        private int f11768l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f11769m;

        /* renamed from: n, reason: collision with root package name */
        private long f11770n;

        /* renamed from: o, reason: collision with root package name */
        private long f11771o;

        public Factory(a.InterfaceC0099a interfaceC0099a) {
            this(new c(interfaceC0099a));
        }

        public Factory(f fVar) {
            this.f11757a = (f) androidx.media3.common.util.a.e(fVar);
            this.f11765i = new androidx.media3.exoplayer.drm.j();
            this.f11762f = new c2.a();
            this.f11763g = androidx.media3.exoplayer.hls.playlist.a.f11922p;
            this.f11766j = new androidx.media3.exoplayer.upstream.k();
            this.f11764h = new g2.f();
            this.f11768l = 1;
            this.f11770n = C.TIME_UNSET;
            this.f11767k = true;
            c(true);
        }

        @Override // androidx.media3.exoplayer.source.r.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public HlsMediaSource d(androidx.media3.common.t tVar) {
            androidx.media3.common.util.a.e(tVar.f10293b);
            if (this.f11758b == null) {
                this.f11758b = new d();
            }
            s.a aVar = this.f11759c;
            if (aVar != null) {
                this.f11758b.a(aVar);
            }
            this.f11758b.c(this.f11760d);
            this.f11758b.b(this.f11761e);
            g gVar = this.f11758b;
            c2.e eVar = this.f11762f;
            List list = tVar.f10293b.f10388d;
            c2.e cVar = !list.isEmpty() ? new c2.c(eVar, list) : eVar;
            f fVar = this.f11757a;
            g2.e eVar2 = this.f11764h;
            androidx.media3.exoplayer.drm.t a11 = this.f11765i.a(tVar);
            androidx.media3.exoplayer.upstream.m mVar = this.f11766j;
            return new HlsMediaSource(tVar, fVar, gVar, eVar2, null, a11, mVar, this.f11763g.a(this.f11757a, mVar, cVar, null), this.f11770n, this.f11767k, this.f11768l, this.f11769m, this.f11771o);
        }

        @Override // androidx.media3.exoplayer.source.r.a
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Factory c(boolean z10) {
            this.f11760d = z10;
            return this;
        }

        @Override // androidx.media3.exoplayer.source.r.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Factory b(int i11) {
            this.f11761e = i11;
            return this;
        }

        @Override // androidx.media3.exoplayer.source.r.a
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Factory e(w wVar) {
            this.f11765i = (w) androidx.media3.common.util.a.f(wVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // androidx.media3.exoplayer.source.r.a
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Factory f(androidx.media3.exoplayer.upstream.m mVar) {
            this.f11766j = (androidx.media3.exoplayer.upstream.m) androidx.media3.common.util.a.f(mVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // androidx.media3.exoplayer.source.r.a
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public Factory a(s.a aVar) {
            this.f11759c = aVar;
            return this;
        }
    }

    static {
        androidx.media3.common.u.a("media3.exoplayer.hls");
    }

    private HlsMediaSource(androidx.media3.common.t tVar, f fVar, g gVar, g2.e eVar, androidx.media3.exoplayer.upstream.f fVar2, androidx.media3.exoplayer.drm.t tVar2, androidx.media3.exoplayer.upstream.m mVar, HlsPlaylistTracker hlsPlaylistTracker, long j11, boolean z10, int i11, boolean z11, long j12) {
        this.f11756u = tVar;
        this.f11754s = tVar.f10295d;
        this.f11744i = fVar;
        this.f11743h = gVar;
        this.f11745j = eVar;
        this.f11746k = tVar2;
        this.f11747l = mVar;
        this.f11751p = hlsPlaylistTracker;
        this.f11752q = j11;
        this.f11748m = z10;
        this.f11749n = i11;
        this.f11750o = z11;
        this.f11753r = j12;
    }

    private g2.w C(androidx.media3.exoplayer.hls.playlist.c cVar, long j11, long j12, h hVar) {
        long b11 = cVar.f11957h - this.f11751p.b();
        long j13 = cVar.f11964o ? b11 + cVar.f11970u : -9223372036854775807L;
        long G = G(cVar);
        long j14 = this.f11754s.f10367a;
        J(cVar, a1.q(j14 != C.TIME_UNSET ? a1.R0(j14) : I(cVar, G), G, cVar.f11970u + G));
        return new g2.w(j11, j12, C.TIME_UNSET, j13, cVar.f11970u, b11, H(cVar, G), true, !cVar.f11964o, cVar.f11953d == 2 && cVar.f11955f, hVar, a(), this.f11754s);
    }

    private g2.w D(androidx.media3.exoplayer.hls.playlist.c cVar, long j11, long j12, h hVar) {
        long j13;
        if (cVar.f11954e == C.TIME_UNSET || cVar.f11967r.isEmpty()) {
            j13 = 0;
        } else {
            if (!cVar.f11956g) {
                long j14 = cVar.f11954e;
                if (j14 != cVar.f11970u) {
                    j13 = F(cVar.f11967r, j14).f12002e;
                }
            }
            j13 = cVar.f11954e;
        }
        long j15 = j13;
        long j16 = cVar.f11970u;
        return new g2.w(j11, j12, C.TIME_UNSET, j16, j16, 0L, j15, true, false, true, hVar, a(), null);
    }

    private static c.d E(List list, long j11) {
        c.d dVar = null;
        for (int i11 = 0; i11 < list.size(); i11++) {
            c.d dVar2 = (c.d) list.get(i11);
            long j12 = dVar2.f12002e;
            if (j12 > j11 || !dVar2.f11991l) {
                if (j12 > j11) {
                    break;
                }
            } else {
                dVar = dVar2;
            }
        }
        return dVar;
    }

    private static c.f F(List list, long j11) {
        return (c.f) list.get(a1.f(list, Long.valueOf(j11), true, true));
    }

    private long G(androidx.media3.exoplayer.hls.playlist.c cVar) {
        if (cVar.f11965p) {
            return a1.R0(a1.h0(this.f11752q)) - cVar.d();
        }
        return 0L;
    }

    private long H(androidx.media3.exoplayer.hls.playlist.c cVar, long j11) {
        long j12 = cVar.f11954e;
        if (j12 == C.TIME_UNSET) {
            j12 = (cVar.f11970u + j11) - a1.R0(this.f11754s.f10367a);
        }
        if (cVar.f11956g) {
            return j12;
        }
        c.d E = E(cVar.f11968s, j12);
        if (E != null) {
            return E.f12002e;
        }
        if (cVar.f11967r.isEmpty()) {
            return 0L;
        }
        c.f F = F(cVar.f11967r, j12);
        c.d E2 = E(F.f11997m, j12);
        return E2 != null ? E2.f12002e : F.f12002e;
    }

    private static long I(androidx.media3.exoplayer.hls.playlist.c cVar, long j11) {
        long j12;
        c.h hVar = cVar.f11971v;
        long j13 = cVar.f11954e;
        if (j13 != C.TIME_UNSET) {
            j12 = cVar.f11970u - j13;
        } else {
            long j14 = hVar.f12012d;
            if (j14 == C.TIME_UNSET || cVar.f11963n == C.TIME_UNSET) {
                long j15 = hVar.f12011c;
                j12 = j15 != C.TIME_UNSET ? j15 : cVar.f11962m * 3;
            } else {
                j12 = j14;
            }
        }
        return j12 + j11;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void J(androidx.media3.exoplayer.hls.playlist.c r5, long r6) {
        /*
            r4 = this;
            androidx.media3.common.t r0 = r4.a()
            androidx.media3.common.t$g r0 = r0.f10295d
            float r1 = r0.f10370d
            r2 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L2a
            float r0 = r0.f10371e
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L2a
            androidx.media3.exoplayer.hls.playlist.c$h r5 = r5.f11971v
            long r0 = r5.f12011c
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L2a
            long r0 = r5.f12012d
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 != 0) goto L2a
            r5 = 1
            goto L2b
        L2a:
            r5 = 0
        L2b:
            androidx.media3.common.t$g$a r0 = new androidx.media3.common.t$g$a
            r0.<init>()
            long r6 = androidx.media3.common.util.a1.y1(r6)
            androidx.media3.common.t$g$a r6 = r0.k(r6)
            r7 = 1065353216(0x3f800000, float:1.0)
            if (r5 == 0) goto L3e
            r0 = r7
            goto L42
        L3e:
            androidx.media3.common.t$g r0 = r4.f11754s
            float r0 = r0.f10370d
        L42:
            androidx.media3.common.t$g$a r6 = r6.j(r0)
            if (r5 == 0) goto L49
            goto L4d
        L49:
            androidx.media3.common.t$g r5 = r4.f11754s
            float r7 = r5.f10371e
        L4d:
            androidx.media3.common.t$g$a r5 = r6.h(r7)
            androidx.media3.common.t$g r5 = r5.f()
            r4.f11754s = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.HlsMediaSource.J(androidx.media3.exoplayer.hls.playlist.c, long):void");
    }

    @Override // androidx.media3.exoplayer.source.a
    protected void B() {
        this.f11751p.stop();
        this.f11746k.release();
    }

    @Override // androidx.media3.exoplayer.source.r
    public synchronized androidx.media3.common.t a() {
        return this.f11756u;
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker.c
    public void f(androidx.media3.exoplayer.hls.playlist.c cVar) {
        long y12 = cVar.f11965p ? a1.y1(cVar.f11957h) : -9223372036854775807L;
        int i11 = cVar.f11953d;
        long j11 = (i11 == 2 || i11 == 1) ? y12 : -9223372036854775807L;
        h hVar = new h((androidx.media3.exoplayer.hls.playlist.d) androidx.media3.common.util.a.e(this.f11751p.c()), cVar);
        A(this.f11751p.f() ? C(cVar, j11, y12, hVar) : D(cVar, j11, y12, hVar));
    }

    @Override // androidx.media3.exoplayer.source.r
    public androidx.media3.exoplayer.source.q g(r.b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11) {
        s.a u11 = u(bVar);
        return new l(this.f11743h, this.f11751p, this.f11744i, this.f11755t, null, this.f11746k, s(bVar), this.f11747l, u11, bVar2, this.f11745j, this.f11748m, this.f11749n, this.f11750o, x(), this.f11753r);
    }

    @Override // androidx.media3.exoplayer.source.r
    public void j(androidx.media3.exoplayer.source.q qVar) {
        ((l) qVar).u();
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.r
    public synchronized void l(androidx.media3.common.t tVar) {
        this.f11756u = tVar;
    }

    @Override // androidx.media3.exoplayer.source.r
    public void maybeThrowSourceInfoRefreshError() {
        this.f11751p.h();
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.r
    public boolean q(androidx.media3.common.t tVar) {
        androidx.media3.common.t a11 = a();
        t.h hVar = (t.h) androidx.media3.common.util.a.e(a11.f10293b);
        t.h hVar2 = tVar.f10293b;
        return hVar2 != null && hVar2.f10385a.equals(hVar.f10385a) && hVar2.f10388d.equals(hVar.f10388d) && Objects.equals(hVar2.f10387c, hVar.f10387c) && a11.f10295d.equals(tVar.f10295d);
    }

    @Override // androidx.media3.exoplayer.source.a
    protected void z(w1.n nVar) {
        this.f11755t = nVar;
        this.f11746k.c((Looper) androidx.media3.common.util.a.e(Looper.myLooper()), x());
        this.f11746k.prepare();
        this.f11751p.j(((t.h) androidx.media3.common.util.a.e(a().f10293b)).f10385a, u(null), this);
    }
}
