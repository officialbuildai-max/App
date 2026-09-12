package com.google.android.exoplayer2;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.AudioBecomingNoisyManager;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.f3;
import com.google.android.exoplayer2.h2;
import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o2;
import com.google.android.exoplayer2.s2;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.android.exoplayer2.z0;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;
import t9.t;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class z0 extends g implements ExoPlayer {
    private final f A;
    private final f3 B;
    private final q3 C;
    private final r3 D;
    private final long E;
    private int F;
    private boolean G;
    private int H;
    private int I;
    private boolean J;
    private int K;
    private c3 L;
    private t9.t M;
    private boolean N;
    private o2.b O;
    private a2 P;
    private a2 Q;
    private o1 R;
    private o1 S;
    private AudioTrack T;
    private Object U;
    private Surface V;
    private SurfaceHolder W;
    private SphericalGLSurfaceView X;
    private boolean Y;
    private TextureView Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f28073a0;

    /* renamed from: b, reason: collision with root package name */
    final la.r f28074b;

    /* renamed from: b0, reason: collision with root package name */
    private int f28075b0;

    /* renamed from: c, reason: collision with root package name */
    final o2.b f28076c;

    /* renamed from: c0, reason: collision with root package name */
    private int f28077c0;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.h f28078d;

    /* renamed from: d0, reason: collision with root package name */
    private int f28079d0;

    /* renamed from: e, reason: collision with root package name */
    private final Context f28080e;

    /* renamed from: e0, reason: collision with root package name */
    private com.google.android.exoplayer2.decoder.e f28081e0;

    /* renamed from: f, reason: collision with root package name */
    private final o2 f28082f;

    /* renamed from: f0, reason: collision with root package name */
    private com.google.android.exoplayer2.decoder.e f28083f0;

    /* renamed from: g, reason: collision with root package name */
    private final x2[] f28084g;

    /* renamed from: g0, reason: collision with root package name */
    private int f28085g0;

    /* renamed from: h, reason: collision with root package name */
    private final la.q f28086h;

    /* renamed from: h0, reason: collision with root package name */
    private com.google.android.exoplayer2.audio.e f28087h0;

    /* renamed from: i, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.o f28088i;

    /* renamed from: i0, reason: collision with root package name */
    private float f28089i0;

    /* renamed from: j, reason: collision with root package name */
    private final l1.f f28090j;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f28091j0;

    /* renamed from: k, reason: collision with root package name */
    private final l1 f28092k;

    /* renamed from: k0, reason: collision with root package name */
    private ba.f f28093k0;

    /* renamed from: l, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.r f28094l;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f28095l0;

    /* renamed from: m, reason: collision with root package name */
    private final CopyOnWriteArraySet f28096m;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f28097m0;

    /* renamed from: n, reason: collision with root package name */
    private final k3.b f28098n;

    /* renamed from: n0, reason: collision with root package name */
    private PriorityTaskManager f28099n0;

    /* renamed from: o, reason: collision with root package name */
    private final List f28100o;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f28101o0;

    /* renamed from: p, reason: collision with root package name */
    private final boolean f28102p;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f28103p0;

    /* renamed from: q, reason: collision with root package name */
    private final o.a f28104q;

    /* renamed from: q0, reason: collision with root package name */
    private r f28105q0;

    /* renamed from: r, reason: collision with root package name */
    private final e9.a f28106r;

    /* renamed from: r0, reason: collision with root package name */
    private com.google.android.exoplayer2.video.y f28107r0;

    /* renamed from: s, reason: collision with root package name */
    private final Looper f28108s;

    /* renamed from: s0, reason: collision with root package name */
    private a2 f28109s0;

    /* renamed from: t, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.e f28110t;

    /* renamed from: t0, reason: collision with root package name */
    private l2 f28111t0;

    /* renamed from: u, reason: collision with root package name */
    private final long f28112u;

    /* renamed from: u0, reason: collision with root package name */
    private int f28113u0;

    /* renamed from: v, reason: collision with root package name */
    private final long f28114v;

    /* renamed from: v0, reason: collision with root package name */
    private int f28115v0;

    /* renamed from: w, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.e f28116w;

    /* renamed from: w0, reason: collision with root package name */
    private long f28117w0;

    /* renamed from: x, reason: collision with root package name */
    private final c f28118x;

    /* renamed from: y, reason: collision with root package name */
    private final d f28119y;

    /* renamed from: z, reason: collision with root package name */
    private final AudioBecomingNoisyManager f28120z;

    /* loaded from: classes3.dex */
    private static final class b {
        public static e9.u1 a(Context context, z0 z0Var, boolean z10) {
            LogSessionId logSessionId;
            e9.s1 B0 = e9.s1.B0(context);
            if (B0 == null) {
                com.google.android.exoplayer2.util.s.i("ExoPlayerImpl", "MediaMetricsService unavailable.");
                logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
                return new e9.u1(logSessionId);
            }
            if (z10) {
                z0Var.O0(B0);
            }
            return new e9.u1(B0.I0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class c implements com.google.android.exoplayer2.video.w, com.google.android.exoplayer2.audio.r, ba.o, com.google.android.exoplayer2.metadata.e, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.b, f.b, AudioBecomingNoisyManager.a, f3.b, ExoPlayer.a {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void J(o2.d dVar) {
            dVar.onMediaMetadataChanged(z0.this.P);
        }

        @Override // com.google.android.exoplayer2.audio.r
        public void a(Exception exc) {
            z0.this.f28106r.a(exc);
        }

        @Override // com.google.android.exoplayer2.video.w
        public void b(String str) {
            z0.this.f28106r.b(str);
        }

        @Override // com.google.android.exoplayer2.audio.r
        public void c(String str) {
            z0.this.f28106r.c(str);
        }

        @Override // com.google.android.exoplayer2.audio.r
        public void d(long j11) {
            z0.this.f28106r.d(j11);
        }

        @Override // com.google.android.exoplayer2.video.w
        public void e(Exception exc) {
            z0.this.f28106r.e(exc);
        }

        @Override // com.google.android.exoplayer2.video.w
        public void f(Object obj, long j11) {
            z0.this.f28106r.f(obj, j11);
            if (z0.this.U == obj) {
                z0.this.f28094l.l(26, new r.a() { // from class: com.google.android.exoplayer2.g1
                    @Override // com.google.android.exoplayer2.util.r.a
                    public final void invoke(Object obj2) {
                        ((o2.d) obj2).onRenderedFirstFrame();
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.audio.r
        public void g(Exception exc) {
            z0.this.f28106r.g(exc);
        }

        @Override // com.google.android.exoplayer2.audio.r
        public void h(int i11, long j11, long j12) {
            z0.this.f28106r.h(i11, j11, j12);
        }

        @Override // com.google.android.exoplayer2.video.w
        public void i(long j11, int i11) {
            z0.this.f28106r.i(j11, i11);
        }

        @Override // com.google.android.exoplayer2.audio.r
        public void j(com.google.android.exoplayer2.decoder.e eVar) {
            z0.this.f28083f0 = eVar;
            z0.this.f28106r.j(eVar);
        }

        @Override // com.google.android.exoplayer2.video.w
        public void k(o1 o1Var, com.google.android.exoplayer2.decoder.g gVar) {
            z0.this.R = o1Var;
            z0.this.f28106r.k(o1Var, gVar);
        }

        @Override // com.google.android.exoplayer2.f3.b
        public void l(int i11) {
            final r T0 = z0.T0(z0.this.B);
            if (T0.equals(z0.this.f28105q0)) {
                return;
            }
            z0.this.f28105q0 = T0;
            z0.this.f28094l.l(29, new r.a() { // from class: com.google.android.exoplayer2.f1
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((o2.d) obj).onDeviceInfoChanged(r.this);
                }
            });
        }

        @Override // com.google.android.exoplayer2.AudioBecomingNoisyManager.a
        public void m() {
            z0.this.b2(false, -1, 3);
        }

        @Override // com.google.android.exoplayer2.video.w
        public void n(com.google.android.exoplayer2.decoder.e eVar) {
            z0.this.f28106r.n(eVar);
            z0.this.R = null;
            z0.this.f28081e0 = null;
        }

        @Override // com.google.android.exoplayer2.audio.r
        public void o(com.google.android.exoplayer2.decoder.e eVar) {
            z0.this.f28106r.o(eVar);
            z0.this.S = null;
            z0.this.f28083f0 = null;
        }

        @Override // com.google.android.exoplayer2.audio.r
        public void onAudioDecoderInitialized(String str, long j11, long j12) {
            z0.this.f28106r.onAudioDecoderInitialized(str, j11, j12);
        }

        @Override // ba.o
        public void onCues(final ba.f fVar) {
            z0.this.f28093k0 = fVar;
            z0.this.f28094l.l(27, new r.a() { // from class: com.google.android.exoplayer2.b1
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((o2.d) obj).onCues(ba.f.this);
                }
            });
        }

        @Override // ba.o
        public void onCues(final List list) {
            z0.this.f28094l.l(27, new r.a() { // from class: com.google.android.exoplayer2.a1
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((o2.d) obj).onCues(list);
                }
            });
        }

        @Override // com.google.android.exoplayer2.video.w
        public void onDroppedFrames(int i11, long j11) {
            z0.this.f28106r.onDroppedFrames(i11, j11);
        }

        @Override // com.google.android.exoplayer2.metadata.e
        public void onMetadata(final Metadata metadata) {
            z0 z0Var = z0.this;
            z0Var.f28109s0 = z0Var.f28109s0.b().I(metadata).F();
            a2 R0 = z0.this.R0();
            if (!R0.equals(z0.this.P)) {
                z0.this.P = R0;
                z0.this.f28094l.i(14, new r.a() { // from class: com.google.android.exoplayer2.c1
                    @Override // com.google.android.exoplayer2.util.r.a
                    public final void invoke(Object obj) {
                        z0.c.this.J((o2.d) obj);
                    }
                });
            }
            z0.this.f28094l.i(28, new r.a() { // from class: com.google.android.exoplayer2.d1
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((o2.d) obj).onMetadata(Metadata.this);
                }
            });
            z0.this.f28094l.f();
        }

        @Override // com.google.android.exoplayer2.audio.r
        public void onSkipSilenceEnabledChanged(final boolean z10) {
            if (z0.this.f28091j0 == z10) {
                return;
            }
            z0.this.f28091j0 = z10;
            z0.this.f28094l.l(23, new r.a() { // from class: com.google.android.exoplayer2.i1
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((o2.d) obj).onSkipSilenceEnabledChanged(z10);
                }
            });
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
            z0.this.V1(surfaceTexture);
            z0.this.K1(i11, i12);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            z0.this.W1(null);
            z0.this.K1(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
            z0.this.K1(i11, i12);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // com.google.android.exoplayer2.video.w
        public void onVideoDecoderInitialized(String str, long j11, long j12) {
            z0.this.f28106r.onVideoDecoderInitialized(str, j11, j12);
        }

        @Override // com.google.android.exoplayer2.video.w
        public void onVideoSizeChanged(final com.google.android.exoplayer2.video.y yVar) {
            z0.this.f28107r0 = yVar;
            z0.this.f28094l.l(25, new r.a() { // from class: com.google.android.exoplayer2.h1
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((o2.d) obj).onVideoSizeChanged(com.google.android.exoplayer2.video.y.this);
                }
            });
        }

        @Override // com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView.b
        public void p(Surface surface) {
            z0.this.W1(null);
        }

        @Override // com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView.b
        public void q(Surface surface) {
            z0.this.W1(surface);
        }

        @Override // com.google.android.exoplayer2.f3.b
        public void r(final int i11, final boolean z10) {
            z0.this.f28094l.l(30, new r.a() { // from class: com.google.android.exoplayer2.e1
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((o2.d) obj).onDeviceVolumeChanged(i11, z10);
                }
            });
        }

        @Override // com.google.android.exoplayer2.f.b
        public void s(float f11) {
            z0.this.Q1();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
            z0.this.K1(i12, i13);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (z0.this.Y) {
                z0.this.W1(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (z0.this.Y) {
                z0.this.W1(null);
            }
            z0.this.K1(0, 0);
        }

        @Override // com.google.android.exoplayer2.audio.r
        public void t(o1 o1Var, com.google.android.exoplayer2.decoder.g gVar) {
            z0.this.S = o1Var;
            z0.this.f28106r.t(o1Var, gVar);
        }

        @Override // com.google.android.exoplayer2.f.b
        public void u(int i11) {
            boolean playWhenReady = z0.this.getPlayWhenReady();
            z0.this.b2(playWhenReady, i11, z0.c1(playWhenReady, i11));
        }

        @Override // com.google.android.exoplayer2.video.w
        public void v(com.google.android.exoplayer2.decoder.e eVar) {
            z0.this.f28081e0 = eVar;
            z0.this.f28106r.v(eVar);
        }

        @Override // com.google.android.exoplayer2.video.w
        public /* synthetic */ void w(o1 o1Var) {
            com.google.android.exoplayer2.video.l.a(this, o1Var);
        }

        @Override // com.google.android.exoplayer2.ExoPlayer.a
        public void x(boolean z10) {
            z0.this.e2();
        }

        @Override // com.google.android.exoplayer2.audio.r
        public /* synthetic */ void y(o1 o1Var) {
            com.google.android.exoplayer2.audio.g.a(this, o1Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class d implements com.google.android.exoplayer2.video.i, ma.a, s2.b {

        /* renamed from: a, reason: collision with root package name */
        private com.google.android.exoplayer2.video.i f28122a;

        /* renamed from: b, reason: collision with root package name */
        private ma.a f28123b;

        /* renamed from: c, reason: collision with root package name */
        private com.google.android.exoplayer2.video.i f28124c;

        /* renamed from: d, reason: collision with root package name */
        private ma.a f28125d;

        private d() {
        }

        @Override // ma.a
        public void a(long j11, float[] fArr) {
            ma.a aVar = this.f28125d;
            if (aVar != null) {
                aVar.a(j11, fArr);
            }
            ma.a aVar2 = this.f28123b;
            if (aVar2 != null) {
                aVar2.a(j11, fArr);
            }
        }

        @Override // ma.a
        public void b() {
            ma.a aVar = this.f28125d;
            if (aVar != null) {
                aVar.b();
            }
            ma.a aVar2 = this.f28123b;
            if (aVar2 != null) {
                aVar2.b();
            }
        }

        @Override // com.google.android.exoplayer2.video.i
        public void f(long j11, long j12, o1 o1Var, MediaFormat mediaFormat) {
            com.google.android.exoplayer2.video.i iVar = this.f28124c;
            if (iVar != null) {
                iVar.f(j11, j12, o1Var, mediaFormat);
            }
            com.google.android.exoplayer2.video.i iVar2 = this.f28122a;
            if (iVar2 != null) {
                iVar2.f(j11, j12, o1Var, mediaFormat);
            }
        }

        @Override // com.google.android.exoplayer2.s2.b
        public void handleMessage(int i11, Object obj) {
            if (i11 == 7) {
                this.f28122a = (com.google.android.exoplayer2.video.i) obj;
                return;
            }
            if (i11 == 8) {
                this.f28123b = (ma.a) obj;
                return;
            }
            if (i11 != 10000) {
                return;
            }
            SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
            if (sphericalGLSurfaceView == null) {
                this.f28124c = null;
                this.f28125d = null;
            } else {
                this.f28124c = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                this.f28125d = sphericalGLSurfaceView.getCameraMotionListener();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class e implements f2 {

        /* renamed from: a, reason: collision with root package name */
        private final Object f28126a;

        /* renamed from: b, reason: collision with root package name */
        private k3 f28127b;

        public e(Object obj, k3 k3Var) {
            this.f28126a = obj;
            this.f28127b = k3Var;
        }

        @Override // com.google.android.exoplayer2.f2
        public Object a() {
            return this.f28126a;
        }

        @Override // com.google.android.exoplayer2.f2
        public k3 b() {
            return this.f28127b;
        }
    }

    static {
        m1.a("goog.exo.exoplayer");
    }

    public z0(ExoPlayer.b bVar, o2 o2Var) {
        com.google.android.exoplayer2.util.h hVar = new com.google.android.exoplayer2.util.h();
        this.f28078d = hVar;
        try {
            com.google.android.exoplayer2.util.s.f("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.18.1] [" + com.google.android.exoplayer2.util.p0.f27684e + "]");
            Context applicationContext = bVar.f24498a.getApplicationContext();
            this.f28080e = applicationContext;
            e9.a aVar = (e9.a) bVar.f24506i.apply(bVar.f24499b);
            this.f28106r = aVar;
            this.f28099n0 = bVar.f24508k;
            this.f28087h0 = bVar.f24509l;
            this.f28073a0 = bVar.f24514q;
            this.f28075b0 = bVar.f24515r;
            this.f28091j0 = bVar.f24513p;
            this.E = bVar.f24522y;
            c cVar = new c();
            this.f28118x = cVar;
            d dVar = new d();
            this.f28119y = dVar;
            Handler handler = new Handler(bVar.f24507j);
            x2[] a11 = ((b3) bVar.f24501d.get()).a(handler, cVar, cVar, cVar, cVar);
            this.f28084g = a11;
            com.google.android.exoplayer2.util.a.g(a11.length > 0);
            la.q qVar = (la.q) bVar.f24503f.get();
            this.f28086h = qVar;
            this.f28104q = (o.a) bVar.f24502e.get();
            com.google.android.exoplayer2.upstream.e eVar = (com.google.android.exoplayer2.upstream.e) bVar.f24505h.get();
            this.f28110t = eVar;
            this.f28102p = bVar.f24516s;
            this.L = bVar.f24517t;
            this.f28112u = bVar.f24518u;
            this.f28114v = bVar.f24519v;
            this.N = bVar.f24523z;
            Looper looper = bVar.f24507j;
            this.f28108s = looper;
            com.google.android.exoplayer2.util.e eVar2 = bVar.f24499b;
            this.f28116w = eVar2;
            o2 o2Var2 = o2Var == null ? this : o2Var;
            this.f28082f = o2Var2;
            this.f28094l = new com.google.android.exoplayer2.util.r(looper, eVar2, new r.b() { // from class: com.google.android.exoplayer2.j0
                @Override // com.google.android.exoplayer2.util.r.b
                public final void a(Object obj, com.google.android.exoplayer2.util.m mVar) {
                    z0.this.l1((o2.d) obj, mVar);
                }
            });
            this.f28096m = new CopyOnWriteArraySet();
            this.f28100o = new ArrayList();
            this.M = new t.a(0);
            la.r rVar = new la.r(new a3[a11.length], new com.google.android.exoplayer2.trackselection.h[a11.length], p3.f25653b, null);
            this.f28074b = rVar;
            this.f28098n = new k3.b();
            o2.b e11 = new o2.b.a().c(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 22, 23, 24, 25, 26, 27, 28).d(29, qVar.e()).e();
            this.f28076c = e11;
            this.O = new o2.b.a().b(e11).a(4).a(10).e();
            this.f28088i = eVar2.createHandler(looper, null);
            l1.f fVar = new l1.f() { // from class: com.google.android.exoplayer2.k0
                @Override // com.google.android.exoplayer2.l1.f
                public final void a(l1.e eVar3) {
                    z0.this.n1(eVar3);
                }
            };
            this.f28090j = fVar;
            this.f28111t0 = l2.j(rVar);
            aVar.q(o2Var2, looper);
            int i11 = com.google.android.exoplayer2.util.p0.f27680a;
            l1 l1Var = new l1(a11, qVar, rVar, (t1) bVar.f24504g.get(), eVar, this.F, this.G, aVar, this.L, bVar.f24520w, bVar.f24521x, this.N, looper, eVar2, fVar, i11 < 31 ? new e9.u1() : b.a(applicationContext, this, bVar.A));
            this.f28092k = l1Var;
            this.f28089i0 = 1.0f;
            this.F = 0;
            a2 a2Var = a2.G;
            this.P = a2Var;
            this.Q = a2Var;
            this.f28109s0 = a2Var;
            this.f28113u0 = -1;
            if (i11 < 21) {
                this.f28085g0 = i1(0);
            } else {
                this.f28085g0 = com.google.android.exoplayer2.util.p0.F(applicationContext);
            }
            this.f28093k0 = ba.f.f16367b;
            this.f28095l0 = true;
            C(aVar);
            eVar.f(new Handler(looper), aVar);
            P0(cVar);
            long j11 = bVar.f24500c;
            if (j11 > 0) {
                l1Var.s(j11);
            }
            AudioBecomingNoisyManager audioBecomingNoisyManager = new AudioBecomingNoisyManager(bVar.f24498a, handler, cVar);
            this.f28120z = audioBecomingNoisyManager;
            audioBecomingNoisyManager.b(bVar.f24512o);
            f fVar2 = new f(bVar.f24498a, handler, cVar);
            this.A = fVar2;
            fVar2.m(bVar.f24510m ? this.f28087h0 : null);
            f3 f3Var = new f3(bVar.f24498a, handler, cVar);
            this.B = f3Var;
            f3Var.h(com.google.android.exoplayer2.util.p0.g0(this.f28087h0.f24692c));
            q3 q3Var = new q3(bVar.f24498a);
            this.C = q3Var;
            q3Var.a(bVar.f24511n != 0);
            r3 r3Var = new r3(bVar.f24498a);
            this.D = r3Var;
            r3Var.a(bVar.f24511n == 2);
            this.f28105q0 = T0(f3Var);
            this.f28107r0 = com.google.android.exoplayer2.video.y.f28061e;
            qVar.i(this.f28087h0);
            P1(1, 10, Integer.valueOf(this.f28085g0));
            P1(2, 10, Integer.valueOf(this.f28085g0));
            P1(1, 3, this.f28087h0);
            P1(2, 4, Integer.valueOf(this.f28073a0));
            P1(2, 5, Integer.valueOf(this.f28075b0));
            P1(1, 9, Boolean.valueOf(this.f28091j0));
            P1(2, 7, dVar);
            P1(6, 8, dVar);
            hVar.f();
        } catch (Throwable th2) {
            this.f28078d.f();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B1(l2 l2Var, o2.d dVar) {
        dVar.onLoadingChanged(l2Var.f25303g);
        dVar.onIsLoadingChanged(l2Var.f25303g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C1(l2 l2Var, o2.d dVar) {
        dVar.onPlayerStateChanged(l2Var.f25308l, l2Var.f25301e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D1(l2 l2Var, o2.d dVar) {
        dVar.onPlaybackStateChanged(l2Var.f25301e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E1(l2 l2Var, int i11, o2.d dVar) {
        dVar.onPlayWhenReadyChanged(l2Var.f25308l, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F1(l2 l2Var, o2.d dVar) {
        dVar.onPlaybackSuppressionReasonChanged(l2Var.f25309m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G1(l2 l2Var, o2.d dVar) {
        dVar.onIsPlayingChanged(j1(l2Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H1(l2 l2Var, o2.d dVar) {
        dVar.onPlaybackParametersChanged(l2Var.f25310n);
    }

    private l2 I1(l2 l2Var, k3 k3Var, Pair pair) {
        com.google.android.exoplayer2.util.a.a(k3Var.u() || pair != null);
        k3 k3Var2 = l2Var.f25297a;
        l2 i11 = l2Var.i(k3Var);
        if (k3Var.u()) {
            o.b k11 = l2.k();
            long B0 = com.google.android.exoplayer2.util.p0.B0(this.f28117w0);
            l2 b11 = i11.c(k11, B0, B0, B0, 0L, t9.x.f76286d, this.f28074b, ImmutableList.of()).b(k11);
            b11.f25312p = b11.f25314r;
            return b11;
        }
        Object obj = i11.f25298b.f76237a;
        boolean equals = obj.equals(((Pair) com.google.android.exoplayer2.util.p0.j(pair)).first);
        o.b bVar = !equals ? new o.b(pair.first) : i11.f25298b;
        long longValue = ((Long) pair.second).longValue();
        long B02 = com.google.android.exoplayer2.util.p0.B0(getContentPosition());
        if (!k3Var2.u()) {
            B02 -= k3Var2.l(obj, this.f28098n).q();
        }
        if (!equals || longValue < B02) {
            com.google.android.exoplayer2.util.a.g(!bVar.b());
            l2 b12 = i11.c(bVar, longValue, longValue, longValue, 0L, !equals ? t9.x.f76286d : i11.f25304h, !equals ? this.f28074b : i11.f25305i, !equals ? ImmutableList.of() : i11.f25306j).b(bVar);
            b12.f25312p = longValue;
            return b12;
        }
        if (longValue == B02) {
            int f11 = k3Var.f(i11.f25307k.f76237a);
            if (f11 == -1 || k3Var.j(f11, this.f28098n).f25210c != k3Var.l(bVar.f76237a, this.f28098n).f25210c) {
                k3Var.l(bVar.f76237a, this.f28098n);
                long e11 = bVar.b() ? this.f28098n.e(bVar.f76238b, bVar.f76239c) : this.f28098n.f25211d;
                i11 = i11.c(bVar, i11.f25314r, i11.f25314r, i11.f25300d, e11 - i11.f25314r, i11.f25304h, i11.f25305i, i11.f25306j).b(bVar);
                i11.f25312p = e11;
            }
        } else {
            com.google.android.exoplayer2.util.a.g(!bVar.b());
            long max = Math.max(0L, i11.f25313q - (longValue - B02));
            long j11 = i11.f25312p;
            if (i11.f25307k.equals(i11.f25298b)) {
                j11 = longValue + max;
            }
            i11 = i11.c(bVar, longValue, longValue, longValue, max, i11.f25304h, i11.f25305i, i11.f25306j);
            i11.f25312p = j11;
        }
        return i11;
    }

    private Pair J1(k3 k3Var, int i11, long j11) {
        if (k3Var.u()) {
            this.f28113u0 = i11;
            if (j11 == C.TIME_UNSET) {
                j11 = 0;
            }
            this.f28117w0 = j11;
            this.f28115v0 = 0;
            return null;
        }
        if (i11 == -1 || i11 >= k3Var.t()) {
            i11 = k3Var.e(this.G);
            j11 = k3Var.r(i11, this.f25148a).e();
        }
        return k3Var.n(this.f25148a, this.f28098n, i11, com.google.android.exoplayer2.util.p0.B0(j11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K1(final int i11, final int i12) {
        if (i11 == this.f28077c0 && i12 == this.f28079d0) {
            return;
        }
        this.f28077c0 = i11;
        this.f28079d0 = i12;
        this.f28094l.l(24, new r.a() { // from class: com.google.android.exoplayer2.n0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((o2.d) obj).onSurfaceSizeChanged(i11, i12);
            }
        });
    }

    private long L1(k3 k3Var, o.b bVar, long j11) {
        k3Var.l(bVar.f76237a, this.f28098n);
        return j11 + this.f28098n.q();
    }

    private l2 M1(int i11, int i12) {
        com.google.android.exoplayer2.util.a.a(i11 >= 0 && i12 >= i11 && i12 <= this.f28100o.size());
        int t11 = t();
        k3 currentTimeline = getCurrentTimeline();
        int size = this.f28100o.size();
        this.H++;
        N1(i11, i12);
        k3 U0 = U0();
        l2 I1 = I1(this.f28111t0, U0, b1(currentTimeline, U0));
        int i13 = I1.f25301e;
        if (i13 != 1 && i13 != 4 && i11 < i12 && i12 == size && t11 >= I1.f25297a.t()) {
            I1 = I1.g(4);
        }
        this.f28092k.l0(i11, i12, this.M);
        return I1;
    }

    private void N1(int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            this.f28100o.remove(i13);
        }
        this.M = this.M.a(i11, i12);
    }

    private void O1() {
        if (this.X != null) {
            W0(this.f28119y).n(10000).m(null).l();
            this.X.removeVideoSurfaceListener(this.f28118x);
            this.X = null;
        }
        TextureView textureView = this.Z;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f28118x) {
                com.google.android.exoplayer2.util.s.i("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.Z.setSurfaceTextureListener(null);
            }
            this.Z = null;
        }
        SurfaceHolder surfaceHolder = this.W;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f28118x);
            this.W = null;
        }
    }

    private void P1(int i11, int i12, Object obj) {
        for (x2 x2Var : this.f28084g) {
            if (x2Var.getTrackType() == i11) {
                W0(x2Var).n(i12).m(obj).l();
            }
        }
    }

    private List Q0(int i11, List list) {
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            h2.c cVar = new h2.c((com.google.android.exoplayer2.source.o) list.get(i12), this.f28102p);
            arrayList.add(cVar);
            this.f28100o.add(i12 + i11, new e(cVar.f25187b, cVar.f25186a.P()));
        }
        this.M = this.M.cloneAndInsert(i11, arrayList.size());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q1() {
        P1(1, 2, Float.valueOf(this.f28089i0 * this.A.g()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a2 R0() {
        k3 currentTimeline = getCurrentTimeline();
        if (currentTimeline.u()) {
            return this.f28109s0;
        }
        return this.f28109s0.b().H(currentTimeline.r(t(), this.f25148a).f25225c.f27766e).F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static r T0(f3 f3Var) {
        return new r(0, f3Var.d(), f3Var.c());
    }

    private void T1(List list, int i11, long j11, boolean z10) {
        int i12;
        long j12;
        int a12 = a1();
        long currentPosition = getCurrentPosition();
        this.H++;
        if (!this.f28100o.isEmpty()) {
            N1(0, this.f28100o.size());
        }
        List Q0 = Q0(0, list);
        k3 U0 = U0();
        if (!U0.u() && i11 >= U0.t()) {
            throw new IllegalSeekPositionException(U0, i11, j11);
        }
        if (z10) {
            int e11 = U0.e(this.G);
            j12 = C.TIME_UNSET;
            i12 = e11;
        } else if (i11 == -1) {
            i12 = a12;
            j12 = currentPosition;
        } else {
            i12 = i11;
            j12 = j11;
        }
        l2 I1 = I1(this.f28111t0, U0, J1(U0, i12, j12));
        int i13 = I1.f25301e;
        if (i12 != -1 && i13 != 1) {
            i13 = (U0.u() || i12 >= U0.t()) ? 4 : 2;
        }
        l2 g11 = I1.g(i13);
        this.f28092k.K0(Q0, i12, com.google.android.exoplayer2.util.p0.B0(j12), this.M);
        c2(g11, 0, 1, false, (this.f28111t0.f25298b.f76237a.equals(g11.f25298b.f76237a) || this.f28111t0.f25297a.u()) ? false : true, 4, Z0(g11), -1);
    }

    private k3 U0() {
        return new t2(this.f28100o, this.M);
    }

    private void U1(SurfaceHolder surfaceHolder) {
        this.Y = false;
        this.W = surfaceHolder;
        surfaceHolder.addCallback(this.f28118x);
        Surface surface = this.W.getSurface();
        if (surface == null || !surface.isValid()) {
            K1(0, 0);
        } else {
            Rect surfaceFrame = this.W.getSurfaceFrame();
            K1(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    private List V0(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            arrayList.add(this.f28104q.a((v1) list.get(i11)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V1(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        W1(surface);
        this.V = surface;
    }

    private s2 W0(s2.b bVar) {
        int a12 = a1();
        l1 l1Var = this.f28092k;
        k3 k3Var = this.f28111t0.f25297a;
        if (a12 == -1) {
            a12 = 0;
        }
        return new s2(l1Var, bVar, k3Var, a12, this.f28116w, l1Var.z());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W1(Object obj) {
        boolean z10;
        ArrayList arrayList = new ArrayList();
        x2[] x2VarArr = this.f28084g;
        int length = x2VarArr.length;
        int i11 = 0;
        while (true) {
            z10 = true;
            if (i11 >= length) {
                break;
            }
            x2 x2Var = x2VarArr[i11];
            if (x2Var.getTrackType() == 2) {
                arrayList.add(W0(x2Var).n(1).m(obj).l());
            }
            i11++;
        }
        Object obj2 = this.U;
        if (obj2 == null || obj2 == obj) {
            z10 = false;
        } else {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((s2) it.next()).a(this.E);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
            }
            z10 = false;
            Object obj3 = this.U;
            Surface surface = this.V;
            if (obj3 == surface) {
                surface.release();
                this.V = null;
            }
        }
        this.U = obj;
        if (z10) {
            Z1(false, ExoPlaybackException.createForUnexpected(new ExoTimeoutException(3), 1003));
        }
    }

    private Pair X0(l2 l2Var, l2 l2Var2, boolean z10, int i11, boolean z11) {
        k3 k3Var = l2Var2.f25297a;
        k3 k3Var2 = l2Var.f25297a;
        if (k3Var2.u() && k3Var.u()) {
            return new Pair(Boolean.FALSE, -1);
        }
        int i12 = 3;
        if (k3Var2.u() != k3Var.u()) {
            return new Pair(Boolean.TRUE, 3);
        }
        if (k3Var.r(k3Var.l(l2Var2.f25298b.f76237a, this.f28098n).f25210c, this.f25148a).f25223a.equals(k3Var2.r(k3Var2.l(l2Var.f25298b.f76237a, this.f28098n).f25210c, this.f25148a).f25223a)) {
            return (z10 && i11 == 0 && l2Var2.f25298b.f76240d < l2Var.f25298b.f76240d) ? new Pair(Boolean.TRUE, 0) : new Pair(Boolean.FALSE, -1);
        }
        if (z10 && i11 == 0) {
            i12 = 1;
        } else if (z10 && i11 == 1) {
            i12 = 2;
        } else if (!z11) {
            throw new IllegalStateException();
        }
        return new Pair(Boolean.TRUE, Integer.valueOf(i12));
    }

    private long Z0(l2 l2Var) {
        return l2Var.f25297a.u() ? com.google.android.exoplayer2.util.p0.B0(this.f28117w0) : l2Var.f25298b.b() ? l2Var.f25314r : L1(l2Var.f25297a, l2Var.f25298b, l2Var.f25314r);
    }

    private void Z1(boolean z10, ExoPlaybackException exoPlaybackException) {
        l2 b11;
        if (z10) {
            b11 = M1(0, this.f28100o.size()).e(null);
        } else {
            l2 l2Var = this.f28111t0;
            b11 = l2Var.b(l2Var.f25298b);
            b11.f25312p = b11.f25314r;
            b11.f25313q = 0L;
        }
        l2 g11 = b11.g(1);
        if (exoPlaybackException != null) {
            g11 = g11.e(exoPlaybackException);
        }
        l2 l2Var2 = g11;
        this.H++;
        this.f28092k.e1();
        c2(l2Var2, 0, 1, false, l2Var2.f25297a.u() && !this.f28111t0.f25297a.u(), 4, Z0(l2Var2), -1);
    }

    private int a1() {
        if (this.f28111t0.f25297a.u()) {
            return this.f28113u0;
        }
        l2 l2Var = this.f28111t0;
        return l2Var.f25297a.l(l2Var.f25298b.f76237a, this.f28098n).f25210c;
    }

    private void a2() {
        o2.b bVar = this.O;
        o2.b H = com.google.android.exoplayer2.util.p0.H(this.f28082f, this.f28076c);
        this.O = H;
        if (H.equals(bVar)) {
            return;
        }
        this.f28094l.i(13, new r.a() { // from class: com.google.android.exoplayer2.q0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                z0.this.t1((o2.d) obj);
            }
        });
    }

    private Pair b1(k3 k3Var, k3 k3Var2) {
        long contentPosition = getContentPosition();
        if (k3Var.u() || k3Var2.u()) {
            boolean z10 = !k3Var.u() && k3Var2.u();
            int a12 = z10 ? -1 : a1();
            if (z10) {
                contentPosition = -9223372036854775807L;
            }
            return J1(k3Var2, a12, contentPosition);
        }
        Pair n11 = k3Var.n(this.f25148a, this.f28098n, t(), com.google.android.exoplayer2.util.p0.B0(contentPosition));
        Object obj = ((Pair) com.google.android.exoplayer2.util.p0.j(n11)).first;
        if (k3Var2.f(obj) != -1) {
            return n11;
        }
        Object w02 = l1.w0(this.f25148a, this.f28098n, this.F, this.G, obj, k3Var, k3Var2);
        if (w02 == null) {
            return J1(k3Var2, -1, C.TIME_UNSET);
        }
        k3Var2.l(w02, this.f28098n);
        int i11 = this.f28098n.f25210c;
        return J1(k3Var2, i11, k3Var2.r(i11, this.f25148a).e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b2(boolean z10, int i11, int i12) {
        int i13 = 0;
        boolean z11 = z10 && i11 != -1;
        if (z11 && i11 != 1) {
            i13 = 1;
        }
        l2 l2Var = this.f28111t0;
        if (l2Var.f25308l == z11 && l2Var.f25309m == i13) {
            return;
        }
        this.H++;
        l2 d11 = l2Var.d(z11, i13);
        this.f28092k.N0(z11, i13);
        c2(d11, 0, i12, false, false, 5, C.TIME_UNSET, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c1(boolean z10, int i11) {
        return (!z10 || i11 == 1) ? 1 : 2;
    }

    private void c2(final l2 l2Var, final int i11, final int i12, boolean z10, boolean z11, final int i13, long j11, int i14) {
        l2 l2Var2 = this.f28111t0;
        this.f28111t0 = l2Var;
        Pair X0 = X0(l2Var, l2Var2, z11, i13, !l2Var2.f25297a.equals(l2Var.f25297a));
        boolean booleanValue = ((Boolean) X0.first).booleanValue();
        final int intValue = ((Integer) X0.second).intValue();
        a2 a2Var = this.P;
        if (booleanValue) {
            r3 = l2Var.f25297a.u() ? null : l2Var.f25297a.r(l2Var.f25297a.l(l2Var.f25298b.f76237a, this.f28098n).f25210c, this.f25148a).f25225c;
            this.f28109s0 = a2.G;
        }
        if (booleanValue || !l2Var2.f25306j.equals(l2Var.f25306j)) {
            this.f28109s0 = this.f28109s0.b().J(l2Var.f25306j).F();
            a2Var = R0();
        }
        boolean equals = a2Var.equals(this.P);
        this.P = a2Var;
        boolean z12 = l2Var2.f25308l != l2Var.f25308l;
        boolean z13 = l2Var2.f25301e != l2Var.f25301e;
        if (z13 || z12) {
            e2();
        }
        boolean z14 = l2Var2.f25303g;
        boolean z15 = l2Var.f25303g;
        boolean z16 = z14 != z15;
        if (z16) {
            d2(z15);
        }
        if (!l2Var2.f25297a.equals(l2Var.f25297a)) {
            this.f28094l.i(0, new r.a() { // from class: com.google.android.exoplayer2.s0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    z0.u1(l2.this, i11, (o2.d) obj);
                }
            });
        }
        if (z11) {
            final o2.e f12 = f1(i13, l2Var2, i14);
            final o2.e e12 = e1(j11);
            this.f28094l.i(11, new r.a() { // from class: com.google.android.exoplayer2.y0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    z0.v1(i13, f12, e12, (o2.d) obj);
                }
            });
        }
        if (booleanValue) {
            this.f28094l.i(1, new r.a() { // from class: com.google.android.exoplayer2.b0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((o2.d) obj).onMediaItemTransition(v1.this, intValue);
                }
            });
        }
        if (l2Var2.f25302f != l2Var.f25302f) {
            this.f28094l.i(10, new r.a() { // from class: com.google.android.exoplayer2.c0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    z0.x1(l2.this, (o2.d) obj);
                }
            });
            if (l2Var.f25302f != null) {
                this.f28094l.i(10, new r.a() { // from class: com.google.android.exoplayer2.d0
                    @Override // com.google.android.exoplayer2.util.r.a
                    public final void invoke(Object obj) {
                        z0.y1(l2.this, (o2.d) obj);
                    }
                });
            }
        }
        la.r rVar = l2Var2.f25305i;
        la.r rVar2 = l2Var.f25305i;
        if (rVar != rVar2) {
            this.f28086h.f(rVar2.f68927e);
            this.f28094l.i(2, new r.a() { // from class: com.google.android.exoplayer2.e0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    z0.z1(l2.this, (o2.d) obj);
                }
            });
        }
        if (!equals) {
            final a2 a2Var2 = this.P;
            this.f28094l.i(14, new r.a() { // from class: com.google.android.exoplayer2.f0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((o2.d) obj).onMediaMetadataChanged(a2.this);
                }
            });
        }
        if (z16) {
            this.f28094l.i(3, new r.a() { // from class: com.google.android.exoplayer2.g0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    z0.B1(l2.this, (o2.d) obj);
                }
            });
        }
        if (z13 || z12) {
            this.f28094l.i(-1, new r.a() { // from class: com.google.android.exoplayer2.h0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    z0.C1(l2.this, (o2.d) obj);
                }
            });
        }
        if (z13) {
            this.f28094l.i(4, new r.a() { // from class: com.google.android.exoplayer2.i0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    z0.D1(l2.this, (o2.d) obj);
                }
            });
        }
        if (z12) {
            this.f28094l.i(5, new r.a() { // from class: com.google.android.exoplayer2.t0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    z0.E1(l2.this, i12, (o2.d) obj);
                }
            });
        }
        if (l2Var2.f25309m != l2Var.f25309m) {
            this.f28094l.i(6, new r.a() { // from class: com.google.android.exoplayer2.u0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    z0.F1(l2.this, (o2.d) obj);
                }
            });
        }
        if (j1(l2Var2) != j1(l2Var)) {
            this.f28094l.i(7, new r.a() { // from class: com.google.android.exoplayer2.v0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    z0.G1(l2.this, (o2.d) obj);
                }
            });
        }
        if (!l2Var2.f25310n.equals(l2Var.f25310n)) {
            this.f28094l.i(12, new r.a() { // from class: com.google.android.exoplayer2.w0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    z0.H1(l2.this, (o2.d) obj);
                }
            });
        }
        if (z10) {
            this.f28094l.i(-1, new r.a() { // from class: com.google.android.exoplayer2.x0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((o2.d) obj).onSeekProcessed();
                }
            });
        }
        a2();
        this.f28094l.f();
        if (l2Var2.f25311o != l2Var.f25311o) {
            Iterator it = this.f28096m.iterator();
            while (it.hasNext()) {
                ((ExoPlayer.a) it.next()).x(l2Var.f25311o);
            }
        }
    }

    private void d2(boolean z10) {
        PriorityTaskManager priorityTaskManager = this.f28099n0;
        if (priorityTaskManager != null) {
            if (z10 && !this.f28101o0) {
                priorityTaskManager.a(0);
                this.f28101o0 = true;
            } else {
                if (z10 || !this.f28101o0) {
                    return;
                }
                priorityTaskManager.d(0);
                this.f28101o0 = false;
            }
        }
    }

    private o2.e e1(long j11) {
        v1 v1Var;
        Object obj;
        int i11;
        Object obj2;
        int t11 = t();
        if (this.f28111t0.f25297a.u()) {
            v1Var = null;
            obj = null;
            i11 = -1;
            obj2 = null;
        } else {
            l2 l2Var = this.f28111t0;
            Object obj3 = l2Var.f25298b.f76237a;
            l2Var.f25297a.l(obj3, this.f28098n);
            i11 = this.f28111t0.f25297a.f(obj3);
            obj = obj3;
            obj2 = this.f28111t0.f25297a.r(t11, this.f25148a).f25223a;
            v1Var = this.f25148a.f25225c;
        }
        long e12 = com.google.android.exoplayer2.util.p0.e1(j11);
        long e13 = this.f28111t0.f25298b.b() ? com.google.android.exoplayer2.util.p0.e1(g1(this.f28111t0)) : e12;
        o.b bVar = this.f28111t0.f25298b;
        return new o2.e(obj2, t11, v1Var, obj, i11, e12, e13, bVar.f76238b, bVar.f76239c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e2() {
        int playbackState = getPlaybackState();
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                this.C.b(getPlayWhenReady() && !Y0());
                this.D.b(getPlayWhenReady());
                return;
            } else if (playbackState != 4) {
                throw new IllegalStateException();
            }
        }
        this.C.b(false);
        this.D.b(false);
    }

    private o2.e f1(int i11, l2 l2Var, int i12) {
        int i13;
        Object obj;
        v1 v1Var;
        Object obj2;
        int i14;
        long j11;
        long g12;
        k3.b bVar = new k3.b();
        if (l2Var.f25297a.u()) {
            i13 = i12;
            obj = null;
            v1Var = null;
            obj2 = null;
            i14 = -1;
        } else {
            Object obj3 = l2Var.f25298b.f76237a;
            l2Var.f25297a.l(obj3, bVar);
            int i15 = bVar.f25210c;
            int f11 = l2Var.f25297a.f(obj3);
            Object obj4 = l2Var.f25297a.r(i15, this.f25148a).f25223a;
            v1Var = this.f25148a.f25225c;
            obj2 = obj3;
            i14 = f11;
            obj = obj4;
            i13 = i15;
        }
        if (i11 == 0) {
            if (l2Var.f25298b.b()) {
                o.b bVar2 = l2Var.f25298b;
                j11 = bVar.e(bVar2.f76238b, bVar2.f76239c);
                g12 = g1(l2Var);
            } else {
                j11 = l2Var.f25298b.f76241e != -1 ? g1(this.f28111t0) : bVar.f25212e + bVar.f25211d;
                g12 = j11;
            }
        } else if (l2Var.f25298b.b()) {
            j11 = l2Var.f25314r;
            g12 = g1(l2Var);
        } else {
            j11 = bVar.f25212e + l2Var.f25314r;
            g12 = j11;
        }
        long e12 = com.google.android.exoplayer2.util.p0.e1(j11);
        long e13 = com.google.android.exoplayer2.util.p0.e1(g12);
        o.b bVar3 = l2Var.f25298b;
        return new o2.e(obj, i13, v1Var, obj2, i14, e12, e13, bVar3.f76238b, bVar3.f76239c);
    }

    private void f2() {
        this.f28078d.c();
        if (Thread.currentThread() != k().getThread()) {
            String C = com.google.android.exoplayer2.util.p0.C("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), k().getThread().getName());
            if (this.f28095l0) {
                throw new IllegalStateException(C);
            }
            com.google.android.exoplayer2.util.s.j("ExoPlayerImpl", C, this.f28097m0 ? null : new IllegalStateException());
            this.f28097m0 = true;
        }
    }

    private static long g1(l2 l2Var) {
        k3.d dVar = new k3.d();
        k3.b bVar = new k3.b();
        l2Var.f25297a.l(l2Var.f25298b.f76237a, bVar);
        return l2Var.f25299c == C.TIME_UNSET ? l2Var.f25297a.r(bVar.f25210c, dVar).f() : bVar.q() + l2Var.f25299c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public void m1(l1.e eVar) {
        long j11;
        boolean z10;
        long j12;
        int i11 = this.H - eVar.f25282c;
        this.H = i11;
        boolean z11 = true;
        if (eVar.f25283d) {
            this.I = eVar.f25284e;
            this.J = true;
        }
        if (eVar.f25285f) {
            this.K = eVar.f25286g;
        }
        if (i11 == 0) {
            k3 k3Var = eVar.f25281b.f25297a;
            if (!this.f28111t0.f25297a.u() && k3Var.u()) {
                this.f28113u0 = -1;
                this.f28117w0 = 0L;
                this.f28115v0 = 0;
            }
            if (!k3Var.u()) {
                List K = ((t2) k3Var).K();
                com.google.android.exoplayer2.util.a.g(K.size() == this.f28100o.size());
                for (int i12 = 0; i12 < K.size(); i12++) {
                    ((e) this.f28100o.get(i12)).f28127b = (k3) K.get(i12);
                }
            }
            if (this.J) {
                if (eVar.f25281b.f25298b.equals(this.f28111t0.f25298b) && eVar.f25281b.f25300d == this.f28111t0.f25314r) {
                    z11 = false;
                }
                if (z11) {
                    if (k3Var.u() || eVar.f25281b.f25298b.b()) {
                        j12 = eVar.f25281b.f25300d;
                    } else {
                        l2 l2Var = eVar.f25281b;
                        j12 = L1(k3Var, l2Var.f25298b, l2Var.f25300d);
                    }
                    j11 = j12;
                } else {
                    j11 = -9223372036854775807L;
                }
                z10 = z11;
            } else {
                j11 = -9223372036854775807L;
                z10 = false;
            }
            this.J = false;
            c2(eVar.f25281b, 1, this.K, false, z10, this.I, j11, -1);
        }
    }

    private int i1(int i11) {
        AudioTrack audioTrack = this.T;
        if (audioTrack != null && audioTrack.getAudioSessionId() != i11) {
            this.T.release();
            this.T = null;
        }
        if (this.T == null) {
            this.T = new AudioTrack(3, 4000, 4, 2, 2, 0, i11);
        }
        return this.T.getAudioSessionId();
    }

    private static boolean j1(l2 l2Var) {
        return l2Var.f25301e == 3 && l2Var.f25308l && l2Var.f25309m == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l1(o2.d dVar, com.google.android.exoplayer2.util.m mVar) {
        dVar.onEvents(this.f28082f, new o2.c(mVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n1(final l1.e eVar) {
        this.f28088i.post(new Runnable() { // from class: com.google.android.exoplayer2.p0
            @Override // java.lang.Runnable
            public final void run() {
                z0.this.m1(eVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o1(o2.d dVar) {
        dVar.onPlayerError(ExoPlaybackException.createForUnexpected(new ExoTimeoutException(1), 1003));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t1(o2.d dVar) {
        dVar.onAvailableCommandsChanged(this.O);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u1(l2 l2Var, int i11, o2.d dVar) {
        dVar.onTimelineChanged(l2Var.f25297a, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v1(int i11, o2.e eVar, o2.e eVar2, o2.d dVar) {
        dVar.onPositionDiscontinuity(i11);
        dVar.onPositionDiscontinuity(eVar, eVar2, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x1(l2 l2Var, o2.d dVar) {
        dVar.onPlayerErrorChanged(l2Var.f25302f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y1(l2 l2Var, o2.d dVar) {
        dVar.onPlayerError(l2Var.f25302f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z1(l2 l2Var, o2.d dVar) {
        dVar.onTracksChanged(l2Var.f25305i.f68926d);
    }

    @Override // com.google.android.exoplayer2.o2
    public void A(o2.d dVar) {
        com.google.android.exoplayer2.util.a.e(dVar);
        this.f28094l.k(dVar);
    }

    @Override // com.google.android.exoplayer2.o2
    public void C(o2.d dVar) {
        com.google.android.exoplayer2.util.a.e(dVar);
        this.f28094l.c(dVar);
    }

    @Override // com.google.android.exoplayer2.o2
    public void D(final TrackSelectionParameters trackSelectionParameters) {
        f2();
        if (!this.f28086h.e() || trackSelectionParameters.equals(this.f28086h.b())) {
            return;
        }
        this.f28086h.j(trackSelectionParameters);
        this.f28094l.l(19, new r.a() { // from class: com.google.android.exoplayer2.o0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((o2.d) obj).onTrackSelectionParametersChanged(TrackSelectionParameters.this);
            }
        });
    }

    public void O0(e9.c cVar) {
        com.google.android.exoplayer2.util.a.e(cVar);
        this.f28106r.C(cVar);
    }

    public void P0(ExoPlayer.a aVar) {
        this.f28096m.add(aVar);
    }

    public void R1(List list) {
        f2();
        S1(list, true);
    }

    public void S0(SurfaceHolder surfaceHolder) {
        f2();
        if (surfaceHolder == null || surfaceHolder != this.W) {
            return;
        }
        clearVideoSurface();
    }

    public void S1(List list, boolean z10) {
        f2();
        T1(list, -1, C.TIME_UNSET, z10);
    }

    public void X1(SurfaceHolder surfaceHolder) {
        f2();
        if (surfaceHolder == null) {
            clearVideoSurface();
            return;
        }
        O1();
        this.Y = true;
        this.W = surfaceHolder;
        surfaceHolder.addCallback(this.f28118x);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            W1(null);
            K1(0, 0);
        } else {
            W1(surface);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            K1(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    public boolean Y0() {
        f2();
        return this.f28111t0.f25311o;
    }

    public void Y1(boolean z10) {
        f2();
        this.A.p(getPlayWhenReady(), 1);
        Z1(z10, null);
        this.f28093k0 = ba.f.f16367b;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void a(com.google.android.exoplayer2.source.o oVar) {
        f2();
        R1(Collections.singletonList(oVar));
    }

    @Override // com.google.android.exoplayer2.o2
    public void b(n2 n2Var) {
        f2();
        if (n2Var == null) {
            n2Var = n2.f25527d;
        }
        if (this.f28111t0.f25310n.equals(n2Var)) {
            return;
        }
        l2 f11 = this.f28111t0.f(n2Var);
        this.H++;
        this.f28092k.P0(n2Var);
        c2(f11, 0, 1, false, false, 5, C.TIME_UNSET, -1);
    }

    @Override // com.google.android.exoplayer2.o2
    public void clearVideoSurface() {
        f2();
        O1();
        W1(null);
        K1(0, 0);
    }

    @Override // com.google.android.exoplayer2.o2
    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        f2();
        S0(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.google.android.exoplayer2.o2
    public void clearVideoTextureView(TextureView textureView) {
        f2();
        if (textureView == null || textureView != this.Z) {
            return;
        }
        clearVideoSurface();
    }

    @Override // com.google.android.exoplayer2.o2
    public long d() {
        f2();
        return com.google.android.exoplayer2.util.p0.e1(this.f28111t0.f25313q);
    }

    @Override // com.google.android.exoplayer2.o2
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public ExoPlaybackException c() {
        f2();
        return this.f28111t0.f25302f;
    }

    @Override // com.google.android.exoplayer2.o2
    public void e(List list, boolean z10) {
        f2();
        S1(V0(list), z10);
    }

    @Override // com.google.android.exoplayer2.o2
    public long getContentPosition() {
        f2();
        if (!isPlayingAd()) {
            return getCurrentPosition();
        }
        l2 l2Var = this.f28111t0;
        l2Var.f25297a.l(l2Var.f25298b.f76237a, this.f28098n);
        l2 l2Var2 = this.f28111t0;
        return l2Var2.f25299c == C.TIME_UNSET ? l2Var2.f25297a.r(t(), this.f25148a).e() : this.f28098n.p() + com.google.android.exoplayer2.util.p0.e1(this.f28111t0.f25299c);
    }

    @Override // com.google.android.exoplayer2.o2
    public int getCurrentAdGroupIndex() {
        f2();
        if (isPlayingAd()) {
            return this.f28111t0.f25298b.f76238b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.o2
    public int getCurrentAdIndexInAdGroup() {
        f2();
        if (isPlayingAd()) {
            return this.f28111t0.f25298b.f76239c;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.o2
    public int getCurrentPeriodIndex() {
        f2();
        if (this.f28111t0.f25297a.u()) {
            return this.f28115v0;
        }
        l2 l2Var = this.f28111t0;
        return l2Var.f25297a.f(l2Var.f25298b.f76237a);
    }

    @Override // com.google.android.exoplayer2.o2
    public long getCurrentPosition() {
        f2();
        return com.google.android.exoplayer2.util.p0.e1(Z0(this.f28111t0));
    }

    @Override // com.google.android.exoplayer2.o2
    public k3 getCurrentTimeline() {
        f2();
        return this.f28111t0.f25297a;
    }

    @Override // com.google.android.exoplayer2.o2
    public p3 getCurrentTracks() {
        f2();
        return this.f28111t0.f25305i.f68926d;
    }

    @Override // com.google.android.exoplayer2.o2
    public long getDuration() {
        f2();
        if (!isPlayingAd()) {
            return E();
        }
        l2 l2Var = this.f28111t0;
        o.b bVar = l2Var.f25298b;
        l2Var.f25297a.l(bVar.f76237a, this.f28098n);
        return com.google.android.exoplayer2.util.p0.e1(this.f28098n.e(bVar.f76238b, bVar.f76239c));
    }

    @Override // com.google.android.exoplayer2.o2
    public boolean getPlayWhenReady() {
        f2();
        return this.f28111t0.f25308l;
    }

    @Override // com.google.android.exoplayer2.o2
    public n2 getPlaybackParameters() {
        f2();
        return this.f28111t0.f25310n;
    }

    @Override // com.google.android.exoplayer2.o2
    public int getPlaybackState() {
        f2();
        return this.f28111t0.f25301e;
    }

    @Override // com.google.android.exoplayer2.o2
    public int getRepeatMode() {
        f2();
        return this.F;
    }

    @Override // com.google.android.exoplayer2.o2
    public boolean getShuffleModeEnabled() {
        f2();
        return this.G;
    }

    @Override // com.google.android.exoplayer2.o2
    public float getVolume() {
        f2();
        return this.f28089i0;
    }

    @Override // com.google.android.exoplayer2.o2
    public boolean isPlayingAd() {
        f2();
        return this.f28111t0.f25298b.b();
    }

    @Override // com.google.android.exoplayer2.o2
    public int j() {
        f2();
        return this.f28111t0.f25309m;
    }

    @Override // com.google.android.exoplayer2.o2
    public Looper k() {
        return this.f28108s;
    }

    @Override // com.google.android.exoplayer2.o2
    public TrackSelectionParameters l() {
        f2();
        return this.f28086h.b();
    }

    @Override // com.google.android.exoplayer2.o2
    public o2.b n() {
        f2();
        return this.O;
    }

    @Override // com.google.android.exoplayer2.o2
    public long o() {
        f2();
        return 3000L;
    }

    @Override // com.google.android.exoplayer2.o2
    public com.google.android.exoplayer2.video.y p() {
        f2();
        return this.f28107r0;
    }

    @Override // com.google.android.exoplayer2.o2
    public void prepare() {
        f2();
        boolean playWhenReady = getPlayWhenReady();
        int p11 = this.A.p(playWhenReady, 2);
        b2(playWhenReady, p11, c1(playWhenReady, p11));
        l2 l2Var = this.f28111t0;
        if (l2Var.f25301e != 1) {
            return;
        }
        l2 e11 = l2Var.e(null);
        l2 g11 = e11.g(e11.f25297a.u() ? 4 : 2);
        this.H++;
        this.f28092k.g0();
        c2(g11, 1, 1, false, false, 5, C.TIME_UNSET, -1);
    }

    @Override // com.google.android.exoplayer2.o2
    public long r() {
        f2();
        return this.f28114v;
    }

    @Override // com.google.android.exoplayer2.o2
    public void release() {
        AudioTrack audioTrack;
        com.google.android.exoplayer2.util.s.f("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.18.1] [" + com.google.android.exoplayer2.util.p0.f27684e + "] [" + m1.b() + "]");
        f2();
        if (com.google.android.exoplayer2.util.p0.f27680a < 21 && (audioTrack = this.T) != null) {
            audioTrack.release();
            this.T = null;
        }
        this.f28120z.b(false);
        this.B.g();
        this.C.b(false);
        this.D.b(false);
        this.A.i();
        if (!this.f28092k.i0()) {
            this.f28094l.l(10, new r.a() { // from class: com.google.android.exoplayer2.l0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    z0.o1((o2.d) obj);
                }
            });
        }
        this.f28094l.j();
        this.f28088i.removeCallbacksAndMessages(null);
        this.f28110t.d(this.f28106r);
        l2 g11 = this.f28111t0.g(1);
        this.f28111t0 = g11;
        l2 b11 = g11.b(g11.f25298b);
        this.f28111t0 = b11;
        b11.f25312p = b11.f25314r;
        this.f28111t0.f25313q = 0L;
        this.f28106r.release();
        this.f28086h.g();
        O1();
        Surface surface = this.V;
        if (surface != null) {
            surface.release();
            this.V = null;
        }
        if (this.f28101o0) {
            ((PriorityTaskManager) com.google.android.exoplayer2.util.a.e(this.f28099n0)).d(0);
            this.f28101o0 = false;
        }
        this.f28093k0 = ba.f.f16367b;
        this.f28103p0 = true;
    }

    @Override // com.google.android.exoplayer2.o2
    public void seekTo(int i11, long j11) {
        f2();
        this.f28106r.m();
        k3 k3Var = this.f28111t0.f25297a;
        if (i11 < 0 || (!k3Var.u() && i11 >= k3Var.t())) {
            throw new IllegalSeekPositionException(k3Var, i11, j11);
        }
        this.H++;
        if (isPlayingAd()) {
            com.google.android.exoplayer2.util.s.i("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            l1.e eVar = new l1.e(this.f28111t0);
            eVar.b(1);
            this.f28090j.a(eVar);
            return;
        }
        int i12 = getPlaybackState() != 1 ? 2 : 1;
        int t11 = t();
        l2 I1 = I1(this.f28111t0.g(i12), k3Var, J1(k3Var, i11, j11));
        this.f28092k.y0(k3Var, i11, com.google.android.exoplayer2.util.p0.B0(j11));
        c2(I1, 0, 1, true, true, 1, Z0(I1), t11);
    }

    @Override // com.google.android.exoplayer2.o2
    public void setPlayWhenReady(boolean z10) {
        f2();
        int p11 = this.A.p(z10, getPlaybackState());
        b2(z10, p11, c1(z10, p11));
    }

    @Override // com.google.android.exoplayer2.o2
    public void setRepeatMode(final int i11) {
        f2();
        if (this.F != i11) {
            this.F = i11;
            this.f28092k.R0(i11);
            this.f28094l.i(8, new r.a() { // from class: com.google.android.exoplayer2.m0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((o2.d) obj).onRepeatModeChanged(i11);
                }
            });
            a2();
            this.f28094l.f();
        }
    }

    @Override // com.google.android.exoplayer2.o2
    public void setShuffleModeEnabled(final boolean z10) {
        f2();
        if (this.G != z10) {
            this.G = z10;
            this.f28092k.U0(z10);
            this.f28094l.i(9, new r.a() { // from class: com.google.android.exoplayer2.a0
                @Override // com.google.android.exoplayer2.util.r.a
                public final void invoke(Object obj) {
                    ((o2.d) obj).onShuffleModeEnabledChanged(z10);
                }
            });
            a2();
            this.f28094l.f();
        }
    }

    @Override // com.google.android.exoplayer2.o2
    public void setVideoSurfaceView(SurfaceView surfaceView) {
        f2();
        if (surfaceView instanceof com.google.android.exoplayer2.video.h) {
            O1();
            W1(surfaceView);
            U1(surfaceView.getHolder());
        } else {
            if (!(surfaceView instanceof SphericalGLSurfaceView)) {
                X1(surfaceView == null ? null : surfaceView.getHolder());
                return;
            }
            O1();
            this.X = (SphericalGLSurfaceView) surfaceView;
            W0(this.f28119y).n(10000).m(this.X).l();
            this.X.addVideoSurfaceListener(this.f28118x);
            W1(this.X.getVideoSurface());
            U1(surfaceView.getHolder());
        }
    }

    @Override // com.google.android.exoplayer2.o2
    public void setVideoTextureView(TextureView textureView) {
        f2();
        if (textureView == null) {
            clearVideoSurface();
            return;
        }
        O1();
        this.Z = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            com.google.android.exoplayer2.util.s.i("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.f28118x);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            W1(null);
            K1(0, 0);
        } else {
            V1(surfaceTexture);
            K1(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // com.google.android.exoplayer2.o2
    public void setVolume(float f11) {
        f2();
        final float p11 = com.google.android.exoplayer2.util.p0.p(f11, 0.0f, 1.0f);
        if (this.f28089i0 == p11) {
            return;
        }
        this.f28089i0 = p11;
        Q1();
        this.f28094l.l(22, new r.a() { // from class: com.google.android.exoplayer2.r0
            @Override // com.google.android.exoplayer2.util.r.a
            public final void invoke(Object obj) {
                ((o2.d) obj).onVolumeChanged(p11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.o2
    public void stop() {
        f2();
        Y1(false);
    }

    @Override // com.google.android.exoplayer2.o2
    public int t() {
        f2();
        int a12 = a1();
        if (a12 == -1) {
            return 0;
        }
        return a12;
    }

    @Override // com.google.android.exoplayer2.o2
    public long u() {
        f2();
        if (this.f28111t0.f25297a.u()) {
            return this.f28117w0;
        }
        l2 l2Var = this.f28111t0;
        if (l2Var.f25307k.f76240d != l2Var.f25298b.f76240d) {
            return l2Var.f25297a.r(t(), this.f25148a).g();
        }
        long j11 = l2Var.f25312p;
        if (this.f28111t0.f25307k.b()) {
            l2 l2Var2 = this.f28111t0;
            k3.b l11 = l2Var2.f25297a.l(l2Var2.f25307k.f76237a, this.f28098n);
            long i11 = l11.i(this.f28111t0.f25307k.f76238b);
            j11 = i11 == Long.MIN_VALUE ? l11.f25211d : i11;
        }
        l2 l2Var3 = this.f28111t0;
        return com.google.android.exoplayer2.util.p0.e1(L1(l2Var3.f25297a, l2Var3.f25307k, j11));
    }

    @Override // com.google.android.exoplayer2.o2
    public a2 x() {
        f2();
        return this.P;
    }

    @Override // com.google.android.exoplayer2.o2
    public long y() {
        f2();
        return this.f28112u;
    }
}
