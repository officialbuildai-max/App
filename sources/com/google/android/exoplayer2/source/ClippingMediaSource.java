package com.google.android.exoplayer2.source;

import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.v1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class ClippingMediaSource extends c {

    /* renamed from: k, reason: collision with root package name */
    private final o f25696k;

    /* renamed from: l, reason: collision with root package name */
    private final long f25697l;

    /* renamed from: m, reason: collision with root package name */
    private final long f25698m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f25699n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f25700o;

    /* renamed from: p, reason: collision with root package name */
    private final boolean f25701p;

    /* renamed from: q, reason: collision with root package name */
    private final ArrayList f25702q;

    /* renamed from: r, reason: collision with root package name */
    private final k3.d f25703r;

    /* renamed from: s, reason: collision with root package name */
    private a f25704s;

    /* renamed from: t, reason: collision with root package name */
    private IllegalClippingException f25705t;

    /* renamed from: u, reason: collision with root package name */
    private long f25706u;

    /* renamed from: v, reason: collision with root package name */
    private long f25707v;

    /* loaded from: classes3.dex */
    public static final class IllegalClippingException extends IOException {
        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 1;
        public static final int REASON_START_EXCEEDS_END = 2;
        public final int reason;

        public IllegalClippingException(int i11) {
            super("Illegal clipping: " + getReasonDescription(i11));
            this.reason = i11;
        }

        private static String getReasonDescription(int i11) {
            return i11 != 0 ? i11 != 1 ? i11 != 2 ? TmcConstants.ROUTE_UNKNOWN : "start exceeds end" : "not seekable to start" : "invalid period count";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a extends j {

        /* renamed from: d, reason: collision with root package name */
        private final long f25708d;

        /* renamed from: e, reason: collision with root package name */
        private final long f25709e;

        /* renamed from: f, reason: collision with root package name */
        private final long f25710f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f25711g;

        public a(k3 k3Var, long j11, long j12) {
            super(k3Var);
            boolean z10 = false;
            if (k3Var.m() != 1) {
                throw new IllegalClippingException(0);
            }
            k3.d r11 = k3Var.r(0, new k3.d());
            long max = Math.max(0L, j11);
            if (!r11.f25234l && max != 0 && !r11.f25230h) {
                throw new IllegalClippingException(1);
            }
            long max2 = j12 == Long.MIN_VALUE ? r11.f25236n : Math.max(0L, j12);
            long j13 = r11.f25236n;
            if (j13 != C.TIME_UNSET) {
                max2 = max2 > j13 ? j13 : max2;
                if (max > max2) {
                    throw new IllegalClippingException(2);
                }
            }
            this.f25708d = max;
            this.f25709e = max2;
            this.f25710f = max2 == C.TIME_UNSET ? -9223372036854775807L : max2 - max;
            if (r11.f25231i && (max2 == C.TIME_UNSET || (j13 != C.TIME_UNSET && max2 == j13))) {
                z10 = true;
            }
            this.f25711g = z10;
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.k3
        public k3.b k(int i11, k3.b bVar, boolean z10) {
            this.f26267c.k(0, bVar, z10);
            long q11 = bVar.q() - this.f25708d;
            long j11 = this.f25710f;
            return bVar.v(bVar.f25208a, bVar.f25209b, 0, j11 == C.TIME_UNSET ? -9223372036854775807L : j11 - q11, q11);
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.k3
        public k3.d s(int i11, k3.d dVar, long j11) {
            this.f26267c.s(0, dVar, 0L);
            long j12 = dVar.f25239q;
            long j13 = this.f25708d;
            dVar.f25239q = j12 + j13;
            dVar.f25236n = this.f25710f;
            dVar.f25231i = this.f25711g;
            long j14 = dVar.f25235m;
            if (j14 != C.TIME_UNSET) {
                long max = Math.max(j14, j13);
                dVar.f25235m = max;
                long j15 = this.f25709e;
                if (j15 != C.TIME_UNSET) {
                    max = Math.min(max, j15);
                }
                dVar.f25235m = max - this.f25708d;
            }
            long e12 = p0.e1(this.f25708d);
            long j16 = dVar.f25227e;
            if (j16 != C.TIME_UNSET) {
                dVar.f25227e = j16 + e12;
            }
            long j17 = dVar.f25228f;
            if (j17 != C.TIME_UNSET) {
                dVar.f25228f = j17 + e12;
            }
            return dVar;
        }
    }

    public ClippingMediaSource(o oVar, long j11, long j12, boolean z10, boolean z11, boolean z12) {
        com.google.android.exoplayer2.util.a.a(j11 >= 0);
        this.f25696k = (o) com.google.android.exoplayer2.util.a.e(oVar);
        this.f25697l = j11;
        this.f25698m = j12;
        this.f25699n = z10;
        this.f25700o = z11;
        this.f25701p = z12;
        this.f25702q = new ArrayList();
        this.f25703r = new k3.d();
    }

    private void M(k3 k3Var) {
        long j11;
        long j12;
        k3Var.r(0, this.f25703r);
        long h11 = this.f25703r.h();
        if (this.f25704s == null || this.f25702q.isEmpty() || this.f25700o) {
            long j13 = this.f25697l;
            long j14 = this.f25698m;
            if (this.f25701p) {
                long f11 = this.f25703r.f();
                j13 += f11;
                j14 += f11;
            }
            this.f25706u = h11 + j13;
            this.f25707v = this.f25698m != Long.MIN_VALUE ? h11 + j14 : Long.MIN_VALUE;
            int size = this.f25702q.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((b) this.f25702q.get(i11)).l(this.f25706u, this.f25707v);
            }
            j11 = j13;
            j12 = j14;
        } else {
            long j15 = this.f25706u - h11;
            j12 = this.f25698m != Long.MIN_VALUE ? this.f25707v - h11 : Long.MIN_VALUE;
            j11 = j15;
        }
        try {
            a aVar = new a(k3Var, j11, j12);
            this.f25704s = aVar;
            C(aVar);
        } catch (IllegalClippingException e11) {
            this.f25705t = e11;
            for (int i12 = 0; i12 < this.f25702q.size(); i12++) {
                ((b) this.f25702q.get(i12)).j(this.f25705t);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void B(k0 k0Var) {
        super.B(k0Var);
        K(null, this.f25696k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void D() {
        super.D();
        this.f25705t = null;
        this.f25704s = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.c
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void I(Void r12, o oVar, k3 k3Var) {
        if (this.f25705t != null) {
            return;
        }
        M(k3Var);
    }

    @Override // com.google.android.exoplayer2.source.o
    public v1 a() {
        return this.f25696k.a();
    }

    @Override // com.google.android.exoplayer2.source.o
    public n d(o.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        b bVar3 = new b(this.f25696k.d(bVar, bVar2, j11), this.f25699n, this.f25706u, this.f25707v);
        this.f25702q.add(bVar3);
        return bVar3;
    }

    @Override // com.google.android.exoplayer2.source.o
    public void k(n nVar) {
        com.google.android.exoplayer2.util.a.g(this.f25702q.remove(nVar));
        this.f25696k.k(((b) nVar).f25770a);
        if (!this.f25702q.isEmpty() || this.f25700o) {
            return;
        }
        M(((a) com.google.android.exoplayer2.util.a.e(this.f25704s)).f26267c);
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.o
    public void maybeThrowSourceInfoRefreshError() {
        IllegalClippingException illegalClippingException = this.f25705t;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }
}
