package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.o;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes3.dex */
final class b2 {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.n f24858a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f24859b;

    /* renamed from: c, reason: collision with root package name */
    public final t9.s[] f24860c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f24861d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f24862e;

    /* renamed from: f, reason: collision with root package name */
    public c2 f24863f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f24864g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean[] f24865h;

    /* renamed from: i, reason: collision with root package name */
    private final z2[] f24866i;

    /* renamed from: j, reason: collision with root package name */
    private final la.q f24867j;

    /* renamed from: k, reason: collision with root package name */
    private final h2 f24868k;

    /* renamed from: l, reason: collision with root package name */
    private b2 f24869l;

    /* renamed from: m, reason: collision with root package name */
    private t9.x f24870m;

    /* renamed from: n, reason: collision with root package name */
    private la.r f24871n;

    /* renamed from: o, reason: collision with root package name */
    private long f24872o;

    public b2(z2[] z2VarArr, long j11, la.q qVar, com.google.android.exoplayer2.upstream.b bVar, h2 h2Var, c2 c2Var, la.r rVar) {
        this.f24866i = z2VarArr;
        this.f24872o = j11;
        this.f24867j = qVar;
        this.f24868k = h2Var;
        o.b bVar2 = c2Var.f24875a;
        this.f24859b = bVar2.f76237a;
        this.f24863f = c2Var;
        this.f24870m = t9.x.f76286d;
        this.f24871n = rVar;
        this.f24860c = new t9.s[z2VarArr.length];
        this.f24865h = new boolean[z2VarArr.length];
        this.f24858a = e(bVar2, h2Var, bVar, c2Var.f24876b, c2Var.f24878d);
    }

    private void c(t9.s[] sVarArr) {
        int i11 = 0;
        while (true) {
            z2[] z2VarArr = this.f24866i;
            if (i11 >= z2VarArr.length) {
                return;
            }
            if (z2VarArr[i11].getTrackType() == -2 && this.f24871n.c(i11)) {
                sVarArr[i11] = new t9.g();
            }
            i11++;
        }
    }

    private static com.google.android.exoplayer2.source.n e(o.b bVar, h2 h2Var, com.google.android.exoplayer2.upstream.b bVar2, long j11, long j12) {
        com.google.android.exoplayer2.source.n h11 = h2Var.h(bVar, bVar2, j11);
        return j12 != C.TIME_UNSET ? new com.google.android.exoplayer2.source.b(h11, true, 0L, j12) : h11;
    }

    private void f() {
        if (!r()) {
            return;
        }
        int i11 = 0;
        while (true) {
            la.r rVar = this.f24871n;
            if (i11 >= rVar.f68923a) {
                return;
            }
            boolean c11 = rVar.c(i11);
            com.google.android.exoplayer2.trackselection.h hVar = this.f24871n.f68925c[i11];
            if (c11 && hVar != null) {
                hVar.disable();
            }
            i11++;
        }
    }

    private void g(t9.s[] sVarArr) {
        int i11 = 0;
        while (true) {
            z2[] z2VarArr = this.f24866i;
            if (i11 >= z2VarArr.length) {
                return;
            }
            if (z2VarArr[i11].getTrackType() == -2) {
                sVarArr[i11] = null;
            }
            i11++;
        }
    }

    private void h() {
        if (!r()) {
            return;
        }
        int i11 = 0;
        while (true) {
            la.r rVar = this.f24871n;
            if (i11 >= rVar.f68923a) {
                return;
            }
            boolean c11 = rVar.c(i11);
            com.google.android.exoplayer2.trackselection.h hVar = this.f24871n.f68925c[i11];
            if (c11 && hVar != null) {
                hVar.enable();
            }
            i11++;
        }
    }

    private boolean r() {
        return this.f24869l == null;
    }

    private static void u(h2 h2Var, com.google.android.exoplayer2.source.n nVar) {
        try {
            if (nVar instanceof com.google.android.exoplayer2.source.b) {
                h2Var.y(((com.google.android.exoplayer2.source.b) nVar).f25770a);
            } else {
                h2Var.y(nVar);
            }
        } catch (RuntimeException e11) {
            com.google.android.exoplayer2.util.s.d("MediaPeriodHolder", "Period release failed.", e11);
        }
    }

    public void A() {
        com.google.android.exoplayer2.source.n nVar = this.f24858a;
        if (nVar instanceof com.google.android.exoplayer2.source.b) {
            long j11 = this.f24863f.f24878d;
            if (j11 == C.TIME_UNSET) {
                j11 = Long.MIN_VALUE;
            }
            ((com.google.android.exoplayer2.source.b) nVar).l(0L, j11);
        }
    }

    public long a(la.r rVar, long j11, boolean z10) {
        return b(rVar, j11, z10, new boolean[this.f24866i.length]);
    }

    public long b(la.r rVar, long j11, boolean z10, boolean[] zArr) {
        int i11 = 0;
        while (true) {
            boolean z11 = true;
            if (i11 >= rVar.f68923a) {
                break;
            }
            boolean[] zArr2 = this.f24865h;
            if (z10 || !rVar.b(this.f24871n, i11)) {
                z11 = false;
            }
            zArr2[i11] = z11;
            i11++;
        }
        g(this.f24860c);
        f();
        this.f24871n = rVar;
        h();
        long b11 = this.f24858a.b(rVar.f68925c, this.f24865h, this.f24860c, zArr, j11);
        c(this.f24860c);
        this.f24862e = false;
        int i12 = 0;
        while (true) {
            t9.s[] sVarArr = this.f24860c;
            if (i12 >= sVarArr.length) {
                return b11;
            }
            if (sVarArr[i12] != null) {
                com.google.android.exoplayer2.util.a.g(rVar.c(i12));
                if (this.f24866i[i12].getTrackType() != -2) {
                    this.f24862e = true;
                }
            } else {
                com.google.android.exoplayer2.util.a.g(rVar.f68925c[i12] == null);
            }
            i12++;
        }
    }

    public void d(long j11) {
        com.google.android.exoplayer2.util.a.g(r());
        this.f24858a.continueLoading(y(j11));
    }

    public long i() {
        if (!this.f24861d) {
            return this.f24863f.f24876b;
        }
        long bufferedPositionUs = this.f24862e ? this.f24858a.getBufferedPositionUs() : Long.MIN_VALUE;
        return bufferedPositionUs == Long.MIN_VALUE ? this.f24863f.f24879e : bufferedPositionUs;
    }

    public b2 j() {
        return this.f24869l;
    }

    public long k() {
        if (this.f24861d) {
            return this.f24858a.getNextLoadPositionUs();
        }
        return 0L;
    }

    public long l() {
        return this.f24872o;
    }

    public long m() {
        return this.f24863f.f24876b + this.f24872o;
    }

    public t9.x n() {
        return this.f24870m;
    }

    public la.r o() {
        return this.f24871n;
    }

    public void p(float f11, k3 k3Var) {
        this.f24861d = true;
        this.f24870m = this.f24858a.getTrackGroups();
        la.r v11 = v(f11, k3Var);
        c2 c2Var = this.f24863f;
        long j11 = c2Var.f24876b;
        long j12 = c2Var.f24879e;
        if (j12 != C.TIME_UNSET && j11 >= j12) {
            j11 = Math.max(0L, j12 - 1);
        }
        long a11 = a(v11, j11, false);
        long j13 = this.f24872o;
        c2 c2Var2 = this.f24863f;
        this.f24872o = j13 + (c2Var2.f24876b - a11);
        this.f24863f = c2Var2.b(a11);
    }

    public boolean q() {
        return this.f24861d && (!this.f24862e || this.f24858a.getBufferedPositionUs() == Long.MIN_VALUE);
    }

    public void s(long j11) {
        com.google.android.exoplayer2.util.a.g(r());
        if (this.f24861d) {
            this.f24858a.reevaluateBuffer(y(j11));
        }
    }

    public void t() {
        f();
        u(this.f24868k, this.f24858a);
    }

    public la.r v(float f11, k3 k3Var) {
        la.r h11 = this.f24867j.h(this.f24866i, n(), this.f24863f.f24875a, k3Var);
        for (com.google.android.exoplayer2.trackselection.h hVar : h11.f68925c) {
            if (hVar != null) {
                hVar.onPlaybackSpeed(f11);
            }
        }
        return h11;
    }

    public void w(b2 b2Var) {
        if (b2Var == this.f24869l) {
            return;
        }
        f();
        this.f24869l = b2Var;
        h();
    }

    public void x(long j11) {
        this.f24872o = j11;
    }

    public long y(long j11) {
        return j11 - l();
    }

    public long z(long j11) {
        return j11 + l();
    }
}
