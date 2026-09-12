package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;

/* loaded from: classes3.dex */
public interface ExoPlayer extends o2 {

    /* loaded from: classes3.dex */
    public interface a {
        void x(boolean z10);
    }

    /* loaded from: classes3.dex */
    public static final class b {
        boolean A;
        boolean B;

        /* renamed from: a, reason: collision with root package name */
        final Context f24498a;

        /* renamed from: b, reason: collision with root package name */
        com.google.android.exoplayer2.util.e f24499b;

        /* renamed from: c, reason: collision with root package name */
        long f24500c;

        /* renamed from: d, reason: collision with root package name */
        com.google.common.base.q f24501d;

        /* renamed from: e, reason: collision with root package name */
        com.google.common.base.q f24502e;

        /* renamed from: f, reason: collision with root package name */
        com.google.common.base.q f24503f;

        /* renamed from: g, reason: collision with root package name */
        com.google.common.base.q f24504g;

        /* renamed from: h, reason: collision with root package name */
        com.google.common.base.q f24505h;

        /* renamed from: i, reason: collision with root package name */
        com.google.common.base.f f24506i;

        /* renamed from: j, reason: collision with root package name */
        Looper f24507j;

        /* renamed from: k, reason: collision with root package name */
        PriorityTaskManager f24508k;

        /* renamed from: l, reason: collision with root package name */
        com.google.android.exoplayer2.audio.e f24509l;

        /* renamed from: m, reason: collision with root package name */
        boolean f24510m;

        /* renamed from: n, reason: collision with root package name */
        int f24511n;

        /* renamed from: o, reason: collision with root package name */
        boolean f24512o;

        /* renamed from: p, reason: collision with root package name */
        boolean f24513p;

        /* renamed from: q, reason: collision with root package name */
        int f24514q;

        /* renamed from: r, reason: collision with root package name */
        int f24515r;

        /* renamed from: s, reason: collision with root package name */
        boolean f24516s;

        /* renamed from: t, reason: collision with root package name */
        c3 f24517t;

        /* renamed from: u, reason: collision with root package name */
        long f24518u;

        /* renamed from: v, reason: collision with root package name */
        long f24519v;

        /* renamed from: w, reason: collision with root package name */
        s1 f24520w;

        /* renamed from: x, reason: collision with root package name */
        long f24521x;

        /* renamed from: y, reason: collision with root package name */
        long f24522y;

        /* renamed from: z, reason: collision with root package name */
        boolean f24523z;

        public b(final Context context) {
            this(context, new com.google.common.base.q() { // from class: com.google.android.exoplayer2.t
                @Override // com.google.common.base.q
                public final Object get() {
                    b3 g11;
                    g11 = ExoPlayer.b.g(context);
                    return g11;
                }
            }, new com.google.common.base.q() { // from class: com.google.android.exoplayer2.u
                @Override // com.google.common.base.q
                public final Object get() {
                    o.a h11;
                    h11 = ExoPlayer.b.h(context);
                    return h11;
                }
            });
        }

        private b(final Context context, com.google.common.base.q qVar, com.google.common.base.q qVar2) {
            this(context, qVar, qVar2, new com.google.common.base.q() { // from class: com.google.android.exoplayer2.w
                @Override // com.google.common.base.q
                public final Object get() {
                    la.q i11;
                    i11 = ExoPlayer.b.i(context);
                    return i11;
                }
            }, new com.google.common.base.q() { // from class: com.google.android.exoplayer2.x
                @Override // com.google.common.base.q
                public final Object get() {
                    return new n();
                }
            }, new com.google.common.base.q() { // from class: com.google.android.exoplayer2.y
                @Override // com.google.common.base.q
                public final Object get() {
                    com.google.android.exoplayer2.upstream.e m11;
                    m11 = com.google.android.exoplayer2.upstream.q.m(context);
                    return m11;
                }
            }, new com.google.common.base.f() { // from class: com.google.android.exoplayer2.z
                @Override // com.google.common.base.f
                public final Object apply(Object obj) {
                    return new e9.p1((com.google.android.exoplayer2.util.e) obj);
                }
            });
        }

        private b(Context context, com.google.common.base.q qVar, com.google.common.base.q qVar2, com.google.common.base.q qVar3, com.google.common.base.q qVar4, com.google.common.base.q qVar5, com.google.common.base.f fVar) {
            this.f24498a = context;
            this.f24501d = qVar;
            this.f24502e = qVar2;
            this.f24503f = qVar3;
            this.f24504g = qVar4;
            this.f24505h = qVar5;
            this.f24506i = fVar;
            this.f24507j = com.google.android.exoplayer2.util.p0.Q();
            this.f24509l = com.google.android.exoplayer2.audio.e.f24688g;
            this.f24511n = 0;
            this.f24514q = 1;
            this.f24515r = 0;
            this.f24516s = true;
            this.f24517t = c3.f24888g;
            this.f24518u = 5000L;
            this.f24519v = MBInterstitialActivity.WEB_LOAD_TIME;
            this.f24520w = new m.b().a();
            this.f24499b = com.google.android.exoplayer2.util.e.f27621a;
            this.f24521x = 500L;
            this.f24522y = 2000L;
            this.A = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ b3 g(Context context) {
            return new p(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ o.a h(Context context) {
            return new com.google.android.exoplayer2.source.i(context, new g9.i());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ la.q i(Context context) {
            return new com.google.android.exoplayer2.trackselection.e(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ b3 k(b3 b3Var) {
            return b3Var;
        }

        public ExoPlayer f() {
            com.google.android.exoplayer2.util.a.g(!this.B);
            this.B = true;
            return new z0(this, null);
        }

        public b l(final b3 b3Var) {
            com.google.android.exoplayer2.util.a.g(!this.B);
            this.f24501d = new com.google.common.base.q() { // from class: com.google.android.exoplayer2.v
                @Override // com.google.common.base.q
                public final Object get() {
                    b3 k11;
                    k11 = ExoPlayer.b.k(b3.this);
                    return k11;
                }
            };
            return this;
        }
    }

    void a(com.google.android.exoplayer2.source.o oVar);
}
