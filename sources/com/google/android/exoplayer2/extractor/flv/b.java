package com.google.android.exoplayer2.extractor.flv;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.flv.b;
import com.google.android.exoplayer2.util.d0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.a0;
import g9.b0;
import g9.l;
import g9.m;
import g9.n;
import g9.q;
import g9.r;
import java.util.Map;

/* loaded from: classes3.dex */
public final class b implements l {

    /* renamed from: q, reason: collision with root package name */
    public static final r f25100q = new r() { // from class: k9.a
        @Override // g9.r
        public /* synthetic */ l[] c(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // g9.r
        public final l[] createExtractors() {
            l[] g11;
            g11 = b.g();
            return g11;
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private n f25106f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f25108h;

    /* renamed from: i, reason: collision with root package name */
    private long f25109i;

    /* renamed from: j, reason: collision with root package name */
    private int f25110j;

    /* renamed from: k, reason: collision with root package name */
    private int f25111k;

    /* renamed from: l, reason: collision with root package name */
    private int f25112l;

    /* renamed from: m, reason: collision with root package name */
    private long f25113m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f25114n;

    /* renamed from: o, reason: collision with root package name */
    private a f25115o;

    /* renamed from: p, reason: collision with root package name */
    private d f25116p;

    /* renamed from: a, reason: collision with root package name */
    private final d0 f25101a = new d0(4);

    /* renamed from: b, reason: collision with root package name */
    private final d0 f25102b = new d0(9);

    /* renamed from: c, reason: collision with root package name */
    private final d0 f25103c = new d0(11);

    /* renamed from: d, reason: collision with root package name */
    private final d0 f25104d = new d0();

    /* renamed from: e, reason: collision with root package name */
    private final c f25105e = new c();

    /* renamed from: g, reason: collision with root package name */
    private int f25107g = 1;

    private void e() {
        if (this.f25114n) {
            return;
        }
        this.f25106f.d(new b0.b(C.TIME_UNSET));
        this.f25114n = true;
    }

    private long f() {
        if (this.f25108h) {
            return this.f25109i + this.f25113m;
        }
        if (this.f25105e.d() == C.TIME_UNSET) {
            return 0L;
        }
        return this.f25113m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] g() {
        return new l[]{new b()};
    }

    private d0 h(m mVar) {
        if (this.f25112l > this.f25104d.b()) {
            d0 d0Var = this.f25104d;
            d0Var.N(new byte[Math.max(d0Var.b() * 2, this.f25112l)], 0);
        } else {
            this.f25104d.P(0);
        }
        this.f25104d.O(this.f25112l);
        mVar.readFully(this.f25104d.d(), 0, this.f25112l);
        return this.f25104d;
    }

    private boolean i(m mVar) {
        if (!mVar.readFully(this.f25102b.d(), 0, 9, true)) {
            return false;
        }
        this.f25102b.P(0);
        this.f25102b.Q(4);
        int D = this.f25102b.D();
        boolean z10 = (D & 4) != 0;
        boolean z11 = (D & 1) != 0;
        if (z10 && this.f25115o == null) {
            this.f25115o = new a(this.f25106f.track(8, 1));
        }
        if (z11 && this.f25116p == null) {
            this.f25116p = new d(this.f25106f.track(9, 2));
        }
        this.f25106f.endTracks();
        this.f25110j = this.f25102b.n() - 5;
        this.f25107g = 2;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean j(g9.m r10) {
        /*
            r9 = this;
            long r0 = r9.f()
            int r2 = r9.f25111k
            r3 = 8
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 1
            if (r2 != r3) goto L23
            com.google.android.exoplayer2.extractor.flv.a r3 = r9.f25115o
            if (r3 == 0) goto L23
            r9.e()
            com.google.android.exoplayer2.extractor.flv.a r2 = r9.f25115o
            com.google.android.exoplayer2.util.d0 r10 = r9.h(r10)
            boolean r10 = r2.a(r10, r0)
        L21:
            r0 = r6
            goto L75
        L23:
            r3 = 9
            if (r2 != r3) goto L39
            com.google.android.exoplayer2.extractor.flv.d r3 = r9.f25116p
            if (r3 == 0) goto L39
            r9.e()
            com.google.android.exoplayer2.extractor.flv.d r2 = r9.f25116p
            com.google.android.exoplayer2.util.d0 r10 = r9.h(r10)
            boolean r10 = r2.a(r10, r0)
            goto L21
        L39:
            r3 = 18
            if (r2 != r3) goto L6e
            boolean r2 = r9.f25114n
            if (r2 != 0) goto L6e
            com.google.android.exoplayer2.extractor.flv.c r2 = r9.f25105e
            com.google.android.exoplayer2.util.d0 r10 = r9.h(r10)
            boolean r10 = r2.a(r10, r0)
            com.google.android.exoplayer2.extractor.flv.c r0 = r9.f25105e
            long r0 = r0.d()
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L21
            g9.n r2 = r9.f25106f
            g9.z r3 = new g9.z
            com.google.android.exoplayer2.extractor.flv.c r7 = r9.f25105e
            long[] r7 = r7.e()
            com.google.android.exoplayer2.extractor.flv.c r8 = r9.f25105e
            long[] r8 = r8.f()
            r3.<init>(r7, r8, r0)
            r2.d(r3)
            r9.f25114n = r6
            goto L21
        L6e:
            int r0 = r9.f25112l
            r10.skipFully(r0)
            r10 = 0
            r0 = r10
        L75:
            boolean r1 = r9.f25108h
            if (r1 != 0) goto L8f
            if (r10 == 0) goto L8f
            r9.f25108h = r6
            com.google.android.exoplayer2.extractor.flv.c r10 = r9.f25105e
            long r1 = r10.d()
            int r10 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r10 != 0) goto L8b
            long r1 = r9.f25113m
            long r1 = -r1
            goto L8d
        L8b:
            r1 = 0
        L8d:
            r9.f25109i = r1
        L8f:
            r10 = 4
            r9.f25110j = r10
            r10 = 2
            r9.f25107g = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.flv.b.j(g9.m):boolean");
    }

    private boolean k(m mVar) {
        if (!mVar.readFully(this.f25103c.d(), 0, 11, true)) {
            return false;
        }
        this.f25103c.P(0);
        this.f25111k = this.f25103c.D();
        this.f25112l = this.f25103c.G();
        this.f25113m = this.f25103c.G();
        this.f25113m = ((this.f25103c.D() << 24) | this.f25113m) * 1000;
        this.f25103c.Q(3);
        this.f25107g = 4;
        return true;
    }

    private void l(m mVar) {
        mVar.skipFully(this.f25110j);
        this.f25110j = 0;
        this.f25107g = 3;
    }

    @Override // g9.l
    public void b(n nVar) {
        this.f25106f = nVar;
    }

    @Override // g9.l
    public int c(m mVar, a0 a0Var) {
        com.google.android.exoplayer2.util.a.i(this.f25106f);
        while (true) {
            int i11 = this.f25107g;
            if (i11 != 1) {
                if (i11 == 2) {
                    l(mVar);
                } else if (i11 != 3) {
                    if (i11 != 4) {
                        throw new IllegalStateException();
                    }
                    if (j(mVar)) {
                        return 0;
                    }
                } else if (!k(mVar)) {
                    return -1;
                }
            } else if (!i(mVar)) {
                return -1;
            }
        }
    }

    @Override // g9.l
    public boolean d(m mVar) {
        mVar.peekFully(this.f25101a.d(), 0, 3);
        this.f25101a.P(0);
        if (this.f25101a.G() != 4607062) {
            return false;
        }
        mVar.peekFully(this.f25101a.d(), 0, 2);
        this.f25101a.P(0);
        if ((this.f25101a.J() & 250) != 0) {
            return false;
        }
        mVar.peekFully(this.f25101a.d(), 0, 4);
        this.f25101a.P(0);
        int n11 = this.f25101a.n();
        mVar.resetPeekPosition();
        mVar.advancePeekPosition(n11);
        mVar.peekFully(this.f25101a.d(), 0, 4);
        this.f25101a.P(0);
        return this.f25101a.n() == 0;
    }

    @Override // g9.l
    public void release() {
    }

    @Override // g9.l
    public void seek(long j11, long j12) {
        if (j11 == 0) {
            this.f25107g = 1;
            this.f25108h = false;
        } else {
            this.f25107g = 3;
        }
        this.f25110j = 0;
    }
}
