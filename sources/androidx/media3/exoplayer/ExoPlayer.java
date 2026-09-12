package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.l;
import androidx.media3.exoplayer.source.r;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes2.dex */
public interface ExoPlayer extends androidx.media3.common.a0 {

    /* loaded from: classes2.dex */
    public interface a {
        void w(boolean z10);

        void x(boolean z10);
    }

    /* loaded from: classes2.dex */
    public static final class b {
        long A;
        long B;
        boolean C;
        boolean D;
        s3 E;
        boolean F;
        boolean G;
        String H;
        boolean I;
        m4 J;

        /* renamed from: a, reason: collision with root package name */
        final Context f11041a;

        /* renamed from: b, reason: collision with root package name */
        androidx.media3.common.util.i f11042b;

        /* renamed from: c, reason: collision with root package name */
        long f11043c;

        /* renamed from: d, reason: collision with root package name */
        com.google.common.base.q f11044d;

        /* renamed from: e, reason: collision with root package name */
        com.google.common.base.q f11045e;

        /* renamed from: f, reason: collision with root package name */
        com.google.common.base.q f11046f;

        /* renamed from: g, reason: collision with root package name */
        com.google.common.base.q f11047g;

        /* renamed from: h, reason: collision with root package name */
        com.google.common.base.q f11048h;

        /* renamed from: i, reason: collision with root package name */
        com.google.common.base.f f11049i;

        /* renamed from: j, reason: collision with root package name */
        Looper f11050j;

        /* renamed from: k, reason: collision with root package name */
        int f11051k;

        /* renamed from: l, reason: collision with root package name */
        PriorityTaskManager f11052l;

        /* renamed from: m, reason: collision with root package name */
        androidx.media3.common.c f11053m;

        /* renamed from: n, reason: collision with root package name */
        boolean f11054n;

        /* renamed from: o, reason: collision with root package name */
        int f11055o;

        /* renamed from: p, reason: collision with root package name */
        boolean f11056p;

        /* renamed from: q, reason: collision with root package name */
        boolean f11057q;

        /* renamed from: r, reason: collision with root package name */
        boolean f11058r;

        /* renamed from: s, reason: collision with root package name */
        int f11059s;

        /* renamed from: t, reason: collision with root package name */
        int f11060t;

        /* renamed from: u, reason: collision with root package name */
        boolean f11061u;

        /* renamed from: v, reason: collision with root package name */
        c4 f11062v;

        /* renamed from: w, reason: collision with root package name */
        long f11063w;

        /* renamed from: x, reason: collision with root package name */
        long f11064x;

        /* renamed from: y, reason: collision with root package name */
        long f11065y;

        /* renamed from: z, reason: collision with root package name */
        t2 f11066z;

        public b(final Context context) {
            this(context, new com.google.common.base.q() { // from class: androidx.media3.exoplayer.s0
                @Override // com.google.common.base.q
                public final Object get() {
                    b4 i11;
                    i11 = ExoPlayer.b.i(context);
                    return i11;
                }
            }, new com.google.common.base.q() { // from class: androidx.media3.exoplayer.t0
                @Override // com.google.common.base.q
                public final Object get() {
                    r.a j11;
                    j11 = ExoPlayer.b.j(context);
                    return j11;
                }
            });
        }

        private b(final Context context, com.google.common.base.q qVar, com.google.common.base.q qVar2) {
            this(context, qVar, qVar2, new com.google.common.base.q() { // from class: androidx.media3.exoplayer.v0
                @Override // com.google.common.base.q
                public final Object get() {
                    j2.e0 k11;
                    k11 = ExoPlayer.b.k(context);
                    return k11;
                }
            }, new com.google.common.base.q() { // from class: androidx.media3.exoplayer.w0
                @Override // com.google.common.base.q
                public final Object get() {
                    return new m();
                }
            }, new com.google.common.base.q() { // from class: androidx.media3.exoplayer.x0
                @Override // com.google.common.base.q
                public final Object get() {
                    androidx.media3.exoplayer.upstream.e m11;
                    m11 = androidx.media3.exoplayer.upstream.j.m(context);
                    return m11;
                }
            }, new com.google.common.base.f() { // from class: androidx.media3.exoplayer.y0
                @Override // com.google.common.base.f
                public final Object apply(Object obj) {
                    return new y1.s1((androidx.media3.common.util.i) obj);
                }
            });
        }

        private b(Context context, com.google.common.base.q qVar, com.google.common.base.q qVar2, com.google.common.base.q qVar3, com.google.common.base.q qVar4, com.google.common.base.q qVar5, com.google.common.base.f fVar) {
            this.f11041a = (Context) androidx.media3.common.util.a.e(context);
            this.f11044d = qVar;
            this.f11045e = qVar2;
            this.f11046f = qVar3;
            this.f11047g = qVar4;
            this.f11048h = qVar5;
            this.f11049i = fVar;
            this.f11050j = androidx.media3.common.util.a1.X();
            this.f11053m = androidx.media3.common.c.f9989g;
            this.f11055o = 0;
            this.f11059s = 1;
            this.f11060t = 0;
            this.f11061u = true;
            this.f11062v = c4.f11428g;
            this.f11063w = 5000L;
            this.f11064x = MBInterstitialActivity.WEB_LOAD_TIME;
            this.f11065y = 3000L;
            this.f11066z = new l.b().a();
            this.f11042b = androidx.media3.common.util.i.f10469a;
            this.A = 500L;
            this.B = 2000L;
            this.D = true;
            this.H = "";
            this.f11051k = -1000;
            this.J = new p();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ b4 i(Context context) {
            return new o(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ r.a j(Context context) {
            return new androidx.media3.exoplayer.source.i(context, new l2.m());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ j2.e0 k(Context context) {
            return new j2.n(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ u2 m(u2 u2Var) {
            return u2Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ r.a n(r.a aVar) {
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ b4 o(b4 b4Var) {
            return b4Var;
        }

        public ExoPlayer h() {
            androidx.media3.common.util.a.g(!this.F);
            this.F = true;
            return new b2(this, null);
        }

        public b p(final u2 u2Var) {
            androidx.media3.common.util.a.g(!this.F);
            androidx.media3.common.util.a.e(u2Var);
            this.f11047g = new com.google.common.base.q() { // from class: androidx.media3.exoplayer.q0
                @Override // com.google.common.base.q
                public final Object get() {
                    u2 m11;
                    m11 = ExoPlayer.b.m(u2.this);
                    return m11;
                }
            };
            return this;
        }

        public b q(final r.a aVar) {
            androidx.media3.common.util.a.g(!this.F);
            androidx.media3.common.util.a.e(aVar);
            this.f11045e = new com.google.common.base.q() { // from class: androidx.media3.exoplayer.r0
                @Override // com.google.common.base.q
                public final Object get() {
                    r.a n11;
                    n11 = ExoPlayer.b.n(r.a.this);
                    return n11;
                }
            };
            return this;
        }

        public b r(final b4 b4Var) {
            androidx.media3.common.util.a.g(!this.F);
            androidx.media3.common.util.a.e(b4Var);
            this.f11044d = new com.google.common.base.q() { // from class: androidx.media3.exoplayer.u0
                @Override // com.google.common.base.q
                public final Object get() {
                    b4 o11;
                    o11 = ExoPlayer.b.o(b4.this);
                    return o11;
                }
            };
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: b, reason: collision with root package name */
        public static final c f11067b = new c(C.TIME_UNSET);

        /* renamed from: a, reason: collision with root package name */
        public final long f11068a;

        public c(long j11) {
            this.f11068a = j11;
        }
    }

    void D(y1.c cVar);

    androidx.media3.common.r I();

    void P(int i11, androidx.media3.common.t tVar);

    androidx.media3.common.r R();

    void T(int i11, androidx.media3.exoplayer.source.r rVar);

    void U(androidx.media3.exoplayer.source.r rVar);

    void X(androidx.media3.exoplayer.source.r rVar);

    @Override // androidx.media3.common.a0
    ExoPlaybackException c();

    void release();

    void setImageOutput(@Nullable ImageOutput imageOutput);
}
