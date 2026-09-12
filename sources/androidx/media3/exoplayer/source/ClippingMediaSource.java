package androidx.media3.exoplayer.source;

import androidx.media3.common.e0;
import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.source.r;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class ClippingMediaSource extends l0 {

    /* renamed from: m, reason: collision with root package name */
    private final long f12667m;

    /* renamed from: n, reason: collision with root package name */
    private final long f12668n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f12669o;

    /* renamed from: p, reason: collision with root package name */
    private final boolean f12670p;

    /* renamed from: q, reason: collision with root package name */
    private final boolean f12671q;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f12672r;

    /* renamed from: s, reason: collision with root package name */
    private final ArrayList f12673s;

    /* renamed from: t, reason: collision with root package name */
    private final e0.c f12674t;

    /* renamed from: u, reason: collision with root package name */
    private c f12675u;

    /* renamed from: v, reason: collision with root package name */
    private IllegalClippingException f12676v;

    /* renamed from: w, reason: collision with root package name */
    private long f12677w;

    /* renamed from: x, reason: collision with root package name */
    private long f12678x;

    /* loaded from: classes2.dex */
    public static final class IllegalClippingException extends IOException {
        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 1;
        public static final int REASON_START_EXCEEDS_END = 2;
        public final int reason;

        public IllegalClippingException(int i11) {
            this(i11, C.TIME_UNSET, C.TIME_UNSET);
        }

        public IllegalClippingException(int i11, long j11, long j12) {
            super("Illegal clipping: " + getReasonDescription(i11, j11, j12));
            this.reason = i11;
        }

        private static String getReasonDescription(int i11, long j11, long j12) {
            if (i11 == 0) {
                return "invalid period count";
            }
            if (i11 == 1) {
                return "not seekable to start";
            }
            if (i11 != 2) {
                return TmcConstants.ROUTE_UNKNOWN;
            }
            androidx.media3.common.util.a.g((j11 == C.TIME_UNSET || j12 == C.TIME_UNSET) ? false : true);
            return "start exceeds end. Start time: " + j11 + ", End time: " + j12;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final r f12679a;

        /* renamed from: b, reason: collision with root package name */
        private long f12680b;

        /* renamed from: e, reason: collision with root package name */
        private boolean f12683e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f12684f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f12685g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f12686h;

        /* renamed from: d, reason: collision with root package name */
        private boolean f12682d = true;

        /* renamed from: c, reason: collision with root package name */
        private long f12681c = Long.MIN_VALUE;

        public b(r rVar) {
            this.f12679a = (r) androidx.media3.common.util.a.e(rVar);
        }

        public ClippingMediaSource h() {
            this.f12686h = true;
            return new ClippingMediaSource(this);
        }

        public b i(boolean z10) {
            androidx.media3.common.util.a.g(!this.f12686h);
            this.f12683e = z10;
            return this;
        }

        public b j(boolean z10) {
            androidx.media3.common.util.a.g(!this.f12686h);
            this.f12682d = z10;
            return this;
        }

        public b k(long j11) {
            androidx.media3.common.util.a.g(!this.f12686h);
            this.f12681c = j11;
            return this;
        }

        public b l(boolean z10) {
            androidx.media3.common.util.a.g(!this.f12686h);
            this.f12684f = z10;
            return this;
        }

        public b m(long j11) {
            androidx.media3.common.util.a.a(j11 >= 0);
            androidx.media3.common.util.a.g(!this.f12686h);
            this.f12680b = j11;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c extends m {

        /* renamed from: f, reason: collision with root package name */
        private final long f12687f;

        /* renamed from: g, reason: collision with root package name */
        private final long f12688g;

        /* renamed from: h, reason: collision with root package name */
        private final long f12689h;

        /* renamed from: i, reason: collision with root package name */
        private final boolean f12690i;

        public c(androidx.media3.common.e0 e0Var, long j11, long j12, boolean z10) {
            super(e0Var);
            if (j12 != Long.MIN_VALUE && j12 < j11) {
                throw new IllegalClippingException(2, j11, j12);
            }
            boolean z11 = false;
            if (e0Var.i() != 1) {
                throw new IllegalClippingException(0);
            }
            e0.c n11 = e0Var.n(0, new e0.c());
            long max = Math.max(0L, j11);
            if (!z10 && !n11.f10043k && max != 0 && !n11.f10040h) {
                throw new IllegalClippingException(1);
            }
            long max2 = j12 == Long.MIN_VALUE ? n11.f10045m : Math.max(0L, j12);
            long j13 = n11.f10045m;
            if (j13 != C.TIME_UNSET) {
                max2 = max2 > j13 ? j13 : max2;
                if (max > max2) {
                    max = max2;
                }
            }
            this.f12687f = max;
            this.f12688g = max2;
            this.f12689h = max2 == C.TIME_UNSET ? -9223372036854775807L : max2 - max;
            if (n11.f10041i && (max2 == C.TIME_UNSET || (j13 != C.TIME_UNSET && max2 == j13))) {
                z11 = true;
            }
            this.f12690i = z11;
        }

        @Override // androidx.media3.exoplayer.source.m, androidx.media3.common.e0
        public e0.b g(int i11, e0.b bVar, boolean z10) {
            this.f12938e.g(0, bVar, z10);
            long o11 = bVar.o() - this.f12687f;
            long j11 = this.f12689h;
            return bVar.t(bVar.f10016a, bVar.f10017b, 0, j11 == C.TIME_UNSET ? -9223372036854775807L : j11 - o11, o11);
        }

        @Override // androidx.media3.exoplayer.source.m, androidx.media3.common.e0
        public e0.c o(int i11, e0.c cVar, long j11) {
            this.f12938e.o(0, cVar, 0L);
            long j12 = cVar.f10048p;
            long j13 = this.f12687f;
            cVar.f10048p = j12 + j13;
            cVar.f10045m = this.f12689h;
            cVar.f10041i = this.f12690i;
            long j14 = cVar.f10044l;
            if (j14 != C.TIME_UNSET) {
                long max = Math.max(j14, j13);
                cVar.f10044l = max;
                long j15 = this.f12688g;
                if (j15 != C.TIME_UNSET) {
                    max = Math.min(max, j15);
                }
                cVar.f10044l = max - this.f12687f;
            }
            long y12 = a1.y1(this.f12687f);
            long j16 = cVar.f10037e;
            if (j16 != C.TIME_UNSET) {
                cVar.f10037e = j16 + y12;
            }
            long j17 = cVar.f10038f;
            if (j17 != C.TIME_UNSET) {
                cVar.f10038f = j17 + y12;
            }
            return cVar;
        }
    }

    private ClippingMediaSource(b bVar) {
        super(bVar.f12679a);
        this.f12667m = bVar.f12680b;
        this.f12668n = bVar.f12681c;
        this.f12669o = bVar.f12682d;
        this.f12670p = bVar.f12683e;
        this.f12671q = bVar.f12684f;
        this.f12672r = bVar.f12685g;
        this.f12673s = new ArrayList();
        this.f12674t = new e0.c();
    }

    private void T(androidx.media3.common.e0 e0Var) {
        long j11;
        long j12;
        e0Var.n(0, this.f12674t);
        long e11 = this.f12674t.e();
        if (this.f12675u == null || this.f12673s.isEmpty() || this.f12670p) {
            long j13 = this.f12667m;
            long j14 = this.f12668n;
            if (this.f12671q) {
                long c11 = this.f12674t.c();
                j13 += c11;
                j14 += c11;
            }
            this.f12677w = e11 + j13;
            this.f12678x = this.f12668n != Long.MIN_VALUE ? e11 + j14 : Long.MIN_VALUE;
            int size = this.f12673s.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((androidx.media3.exoplayer.source.b) this.f12673s.get(i11)).n(this.f12677w, this.f12678x);
            }
            j11 = j13;
            j12 = j14;
        } else {
            long j15 = this.f12677w - e11;
            j12 = this.f12668n != Long.MIN_VALUE ? this.f12678x - e11 : Long.MIN_VALUE;
            j11 = j15;
        }
        try {
            c cVar = new c(e0Var, j11, j12, this.f12672r);
            this.f12675u = cVar;
            A(cVar);
        } catch (IllegalClippingException e12) {
            this.f12676v = e12;
            for (int i12 = 0; i12 < this.f12673s.size(); i12++) {
                ((androidx.media3.exoplayer.source.b) this.f12673s.get(i12)).l(this.f12676v);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.c, androidx.media3.exoplayer.source.a
    public void B() {
        super.B();
        this.f12676v = null;
        this.f12675u = null;
    }

    @Override // androidx.media3.exoplayer.source.l0
    protected void P(androidx.media3.common.e0 e0Var) {
        if (this.f12676v != null) {
            return;
        }
        T(e0Var);
    }

    @Override // androidx.media3.exoplayer.source.r
    public q g(r.b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11) {
        androidx.media3.exoplayer.source.b bVar3 = new androidx.media3.exoplayer.source.b(this.f12937k.g(bVar, bVar2, j11), this.f12669o, this.f12677w, this.f12678x);
        this.f12673s.add(bVar3);
        return bVar3;
    }

    @Override // androidx.media3.exoplayer.source.r
    public void j(q qVar) {
        androidx.media3.common.util.a.g(this.f12673s.remove(qVar));
        this.f12937k.j(((androidx.media3.exoplayer.source.b) qVar).f12764a);
        if (!this.f12673s.isEmpty() || this.f12670p) {
            return;
        }
        T(((c) androidx.media3.common.util.a.e(this.f12675u)).f12938e);
    }

    @Override // androidx.media3.exoplayer.source.c, androidx.media3.exoplayer.source.r
    public void maybeThrowSourceInfoRefreshError() {
        IllegalClippingException illegalClippingException = this.f12676v;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.r
    public boolean q(androidx.media3.common.t tVar) {
        return a().f10297f.equals(tVar.f10297f) && this.f12937k.q(tVar);
    }
}
