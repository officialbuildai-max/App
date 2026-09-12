package androidx.media3.exoplayer;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.common.IllegalSeekPositionException;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.a0;
import androidx.media3.common.e0;
import androidx.media3.common.m;
import androidx.media3.common.util.g;
import androidx.media3.common.util.t;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.b2;
import androidx.media3.exoplayer.e;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.k4;
import androidx.media3.exoplayer.m4;
import androidx.media3.exoplayer.q3;
import androidx.media3.exoplayer.r2;
import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.t3;
import androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g2.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b2 extends androidx.media3.common.g implements ExoPlayer {
    private final d A;
    private final androidx.media3.exoplayer.e B;
    private final k4 C;
    private final p4 D;
    private final s4 E;
    private final long F;
    private final m4 G;
    private final androidx.media3.common.util.g H;
    private int I;
    private boolean J;
    private int K;
    private int L;
    private boolean M;
    private c4 N;
    private g2.v O;
    private ExoPlayer.c P;
    private boolean Q;
    private a0.b R;
    private androidx.media3.common.v S;
    private androidx.media3.common.v T;
    private androidx.media3.common.r U;
    private androidx.media3.common.r V;
    private Object W;
    private Surface X;
    private SurfaceHolder Y;
    private SphericalGLSurfaceView Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f11343a0;

    /* renamed from: b, reason: collision with root package name */
    final j2.f0 f11344b;

    /* renamed from: b0, reason: collision with root package name */
    private TextureView f11345b0;

    /* renamed from: c, reason: collision with root package name */
    final a0.b f11346c;

    /* renamed from: c0, reason: collision with root package name */
    private int f11347c0;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.media3.common.util.l f11348d = new androidx.media3.common.util.l();

    /* renamed from: d0, reason: collision with root package name */
    private int f11349d0;

    /* renamed from: e, reason: collision with root package name */
    private final Context f11350e;

    /* renamed from: e0, reason: collision with root package name */
    private androidx.media3.common.util.l0 f11351e0;

    /* renamed from: f, reason: collision with root package name */
    private final androidx.media3.common.a0 f11352f;

    /* renamed from: f0, reason: collision with root package name */
    private j f11353f0;

    /* renamed from: g, reason: collision with root package name */
    private final w3[] f11354g;

    /* renamed from: g0, reason: collision with root package name */
    private j f11355g0;

    /* renamed from: h, reason: collision with root package name */
    private final w3[] f11356h;

    /* renamed from: h0, reason: collision with root package name */
    private androidx.media3.common.c f11357h0;

    /* renamed from: i, reason: collision with root package name */
    private final j2.e0 f11358i;

    /* renamed from: i0, reason: collision with root package name */
    private float f11359i0;

    /* renamed from: j, reason: collision with root package name */
    private final androidx.media3.common.util.p f11360j;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f11361j0;

    /* renamed from: k, reason: collision with root package name */
    private final r2.f f11362k;

    /* renamed from: k0, reason: collision with root package name */
    private u1.b f11363k0;

    /* renamed from: l, reason: collision with root package name */
    private final r2 f11364l;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f11365l0;

    /* renamed from: m, reason: collision with root package name */
    private final androidx.media3.common.util.t f11366m;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f11367m0;

    /* renamed from: n, reason: collision with root package name */
    private final CopyOnWriteArraySet f11368n;

    /* renamed from: n0, reason: collision with root package name */
    private int f11369n0;

    /* renamed from: o, reason: collision with root package name */
    private final e0.b f11370o;

    /* renamed from: o0, reason: collision with root package name */
    private PriorityTaskManager f11371o0;

    /* renamed from: p, reason: collision with root package name */
    private final List f11372p;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f11373p0;

    /* renamed from: q, reason: collision with root package name */
    private final boolean f11374q;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f11375q0;

    /* renamed from: r, reason: collision with root package name */
    private final r.a f11376r;

    /* renamed from: r0, reason: collision with root package name */
    private androidx.media3.common.m f11377r0;

    /* renamed from: s, reason: collision with root package name */
    private final y1.a f11378s;

    /* renamed from: s0, reason: collision with root package name */
    private androidx.media3.common.m0 f11379s0;

    /* renamed from: t, reason: collision with root package name */
    private final Looper f11380t;

    /* renamed from: t0, reason: collision with root package name */
    private androidx.media3.common.v f11381t0;

    /* renamed from: u, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.e f11382u;

    /* renamed from: u0, reason: collision with root package name */
    private r3 f11383u0;

    /* renamed from: v, reason: collision with root package name */
    private final long f11384v;

    /* renamed from: v0, reason: collision with root package name */
    private int f11385v0;

    /* renamed from: w, reason: collision with root package name */
    private final long f11386w;

    /* renamed from: w0, reason: collision with root package name */
    private int f11387w0;

    /* renamed from: x, reason: collision with root package name */
    private final long f11388x;

    /* renamed from: x0, reason: collision with root package name */
    private long f11389x0;

    /* renamed from: y, reason: collision with root package name */
    private final androidx.media3.common.util.i f11390y;

    /* renamed from: z, reason: collision with root package name */
    private final c f11391z;

    /* loaded from: classes2.dex */
    private static final class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(Context context, boolean z10, b2 b2Var, y1.f4 f4Var) {
            y1.b4 E0 = y1.b4.E0(context);
            if (E0 == null) {
                androidx.media3.common.util.u.h("ExoPlayerImpl", "MediaMetricsService unavailable.");
                return;
            }
            if (z10) {
                b2Var.D(E0);
            }
            f4Var.b(E0.L0());
        }

        public static void c(final Context context, final b2 b2Var, final boolean z10, final y1.f4 f4Var) {
            b2Var.B1().createHandler(b2Var.G1(), null).post(new Runnable() { // from class: androidx.media3.exoplayer.c2
                @Override // java.lang.Runnable
                public final void run() {
                    b2.b.b(context, z10, b2Var, f4Var);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class c implements androidx.media3.exoplayer.video.i0, androidx.media3.exoplayer.audio.x, i2.h, e2.b, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.b, e.b, k4.b, ExoPlayer.a {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void I(a0.d dVar) {
            dVar.onMediaMetadataChanged(b2.this.S);
        }

        @Override // androidx.media3.exoplayer.audio.x
        public void a(Exception exc) {
            b2.this.f11378s.a(exc);
        }

        @Override // androidx.media3.exoplayer.video.i0
        public void b(String str) {
            b2.this.f11378s.b(str);
        }

        @Override // androidx.media3.exoplayer.audio.x
        public void c(String str) {
            b2.this.f11378s.c(str);
        }

        @Override // androidx.media3.exoplayer.audio.x
        public void d(long j11) {
            b2.this.f11378s.d(j11);
        }

        @Override // androidx.media3.exoplayer.video.i0
        public void e(Exception exc) {
            b2.this.f11378s.e(exc);
        }

        @Override // androidx.media3.exoplayer.video.i0
        public void f(Object obj, long j11) {
            b2.this.f11378s.f(obj, j11);
            if (b2.this.W == obj) {
                b2.this.f11366m.l(26, new t.a() { // from class: androidx.media3.exoplayer.k2
                    @Override // androidx.media3.common.util.t.a
                    public final void invoke(Object obj2) {
                        ((a0.d) obj2).onRenderedFirstFrame();
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.audio.x
        public void g(Exception exc) {
            b2.this.f11378s.g(exc);
        }

        @Override // androidx.media3.exoplayer.audio.x
        public void h(int i11, long j11, long j12) {
            b2.this.f11378s.h(i11, j11, j12);
        }

        @Override // androidx.media3.exoplayer.video.i0
        public void i(long j11, int i11) {
            b2.this.f11378s.i(j11, i11);
        }

        @Override // androidx.media3.exoplayer.audio.x
        public void j(AudioSink.a aVar) {
            b2.this.f11378s.j(aVar);
        }

        @Override // androidx.media3.exoplayer.audio.x
        public void k(AudioSink.a aVar) {
            b2.this.f11378s.k(aVar);
        }

        @Override // androidx.media3.exoplayer.k4.b
        public void l(int i11) {
            final androidx.media3.common.m w12 = b2.w1(b2.this.C);
            if (w12.equals(b2.this.f11377r0)) {
                return;
            }
            b2.this.f11377r0 = w12;
            b2.this.f11366m.l(29, new t.a() { // from class: androidx.media3.exoplayer.i2
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    ((a0.d) obj).onDeviceInfoChanged(androidx.media3.common.m.this);
                }
            });
        }

        @Override // androidx.media3.exoplayer.e.b
        public void m() {
            b2.this.I2(false, 3);
        }

        @Override // androidx.media3.exoplayer.audio.x
        public void n(j jVar) {
            b2.this.f11355g0 = jVar;
            b2.this.f11378s.n(jVar);
        }

        @Override // androidx.media3.exoplayer.video.i0
        public void o(j jVar) {
            b2.this.f11353f0 = jVar;
            b2.this.f11378s.o(jVar);
        }

        @Override // androidx.media3.exoplayer.audio.x
        public void onAudioDecoderInitialized(String str, long j11, long j12) {
            b2.this.f11378s.onAudioDecoderInitialized(str, j11, j12);
        }

        @Override // i2.h
        public void onCues(final List list) {
            b2.this.f11366m.l(27, new t.a() { // from class: androidx.media3.exoplayer.g2
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    ((a0.d) obj).onCues(list);
                }
            });
        }

        @Override // i2.h
        public void onCues(final u1.b bVar) {
            b2.this.f11363k0 = bVar;
            b2.this.f11366m.l(27, new t.a() { // from class: androidx.media3.exoplayer.d2
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    ((a0.d) obj).onCues(u1.b.this);
                }
            });
        }

        @Override // androidx.media3.exoplayer.video.i0
        public void onDroppedFrames(int i11, long j11) {
            b2.this.f11378s.onDroppedFrames(i11, j11);
        }

        @Override // e2.b
        public void onMetadata(final androidx.media3.common.x xVar) {
            b2 b2Var = b2.this;
            b2Var.f11381t0 = b2Var.f11381t0.a().M(xVar).J();
            androidx.media3.common.v s12 = b2.this.s1();
            if (!s12.equals(b2.this.S)) {
                b2.this.S = s12;
                b2.this.f11366m.i(14, new t.a() { // from class: androidx.media3.exoplayer.e2
                    @Override // androidx.media3.common.util.t.a
                    public final void invoke(Object obj) {
                        b2.c.this.I((a0.d) obj);
                    }
                });
            }
            b2.this.f11366m.i(28, new t.a() { // from class: androidx.media3.exoplayer.f2
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    ((a0.d) obj).onMetadata(androidx.media3.common.x.this);
                }
            });
            b2.this.f11366m.f();
        }

        @Override // androidx.media3.exoplayer.audio.x
        public void onSkipSilenceEnabledChanged(final boolean z10) {
            if (b2.this.f11361j0 == z10) {
                return;
            }
            b2.this.f11361j0 = z10;
            b2.this.f11366m.l(23, new t.a() { // from class: androidx.media3.exoplayer.l2
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    ((a0.d) obj).onSkipSilenceEnabledChanged(z10);
                }
            });
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
            b2.this.C2(surfaceTexture);
            b2.this.p2(i11, i12);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b2.this.D2(null);
            b2.this.p2(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
            b2.this.p2(i11, i12);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // androidx.media3.exoplayer.video.i0
        public void onVideoDecoderInitialized(String str, long j11, long j12) {
            b2.this.f11378s.onVideoDecoderInitialized(str, j11, j12);
        }

        @Override // androidx.media3.exoplayer.video.i0
        public void onVideoSizeChanged(final androidx.media3.common.m0 m0Var) {
            b2.this.f11379s0 = m0Var;
            b2.this.f11366m.l(25, new t.a() { // from class: androidx.media3.exoplayer.h2
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    ((a0.d) obj).onVideoSizeChanged(androidx.media3.common.m0.this);
                }
            });
        }

        @Override // androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView.b
        public void p(Surface surface) {
            b2.this.D2(null);
        }

        @Override // androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView.b
        public void q(Surface surface) {
            b2.this.D2(surface);
        }

        @Override // androidx.media3.exoplayer.k4.b
        public void r(final int i11, final boolean z10) {
            b2.this.f11366m.l(30, new t.a() { // from class: androidx.media3.exoplayer.j2
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    ((a0.d) obj).onDeviceVolumeChanged(i11, z10);
                }
            });
        }

        @Override // androidx.media3.exoplayer.audio.x
        public void s(androidx.media3.common.r rVar, k kVar) {
            b2.this.V = rVar;
            b2.this.f11378s.s(rVar, kVar);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
            b2.this.p2(i12, i13);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (b2.this.f11343a0) {
                b2.this.D2(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (b2.this.f11343a0) {
                b2.this.D2(null);
            }
            b2.this.p2(0, 0);
        }

        @Override // androidx.media3.exoplayer.audio.x
        public void t(j jVar) {
            b2.this.f11378s.t(jVar);
            b2.this.V = null;
            b2.this.f11355g0 = null;
        }

        @Override // androidx.media3.exoplayer.video.i0
        public void u(androidx.media3.common.r rVar, k kVar) {
            b2.this.U = rVar;
            b2.this.f11378s.u(rVar, kVar);
        }

        @Override // androidx.media3.exoplayer.video.i0
        public void v(j jVar) {
            b2.this.f11378s.v(jVar);
            b2.this.U = null;
            b2.this.f11353f0 = null;
        }

        @Override // androidx.media3.exoplayer.ExoPlayer.a
        public /* synthetic */ void w(boolean z10) {
            p0.a(this, z10);
        }

        @Override // androidx.media3.exoplayer.ExoPlayer.a
        public void x(boolean z10) {
            b2.this.L2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class d implements androidx.media3.exoplayer.video.t, k2.a, t3.b {

        /* renamed from: a, reason: collision with root package name */
        private androidx.media3.exoplayer.video.t f11393a;

        /* renamed from: b, reason: collision with root package name */
        private k2.a f11394b;

        /* renamed from: c, reason: collision with root package name */
        private androidx.media3.exoplayer.video.t f11395c;

        /* renamed from: d, reason: collision with root package name */
        private k2.a f11396d;

        private d() {
        }

        @Override // k2.a
        public void a(long j11, float[] fArr) {
            k2.a aVar = this.f11396d;
            if (aVar != null) {
                aVar.a(j11, fArr);
            }
            k2.a aVar2 = this.f11394b;
            if (aVar2 != null) {
                aVar2.a(j11, fArr);
            }
        }

        @Override // k2.a
        public void b() {
            k2.a aVar = this.f11396d;
            if (aVar != null) {
                aVar.b();
            }
            k2.a aVar2 = this.f11394b;
            if (aVar2 != null) {
                aVar2.b();
            }
        }

        @Override // androidx.media3.exoplayer.video.t
        public void f(long j11, long j12, androidx.media3.common.r rVar, MediaFormat mediaFormat) {
            androidx.media3.exoplayer.video.t tVar = this.f11395c;
            if (tVar != null) {
                tVar.f(j11, j12, rVar, mediaFormat);
            }
            androidx.media3.exoplayer.video.t tVar2 = this.f11393a;
            if (tVar2 != null) {
                tVar2.f(j11, j12, rVar, mediaFormat);
            }
        }

        @Override // androidx.media3.exoplayer.t3.b
        public void handleMessage(int i11, Object obj) {
            if (i11 == 7) {
                this.f11393a = (androidx.media3.exoplayer.video.t) obj;
                return;
            }
            if (i11 == 8) {
                this.f11394b = (k2.a) obj;
                return;
            }
            if (i11 != 10000) {
                return;
            }
            SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
            if (sphericalGLSurfaceView == null) {
                this.f11395c = null;
                this.f11396d = null;
            } else {
                this.f11395c = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                this.f11396d = sphericalGLSurfaceView.getCameraMotionListener();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class e implements c3 {

        /* renamed from: a, reason: collision with root package name */
        private final Object f11397a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.media3.exoplayer.source.r f11398b;

        /* renamed from: c, reason: collision with root package name */
        private androidx.media3.common.e0 f11399c;

        public e(Object obj, androidx.media3.exoplayer.source.p pVar) {
            this.f11397a = obj;
            this.f11398b = pVar;
            this.f11399c = pVar.W();
        }

        @Override // androidx.media3.exoplayer.c3
        public Object a() {
            return this.f11397a;
        }

        @Override // androidx.media3.exoplayer.c3
        public androidx.media3.common.e0 b() {
            return this.f11399c;
        }

        public void d(androidx.media3.common.e0 e0Var) {
            this.f11399c = e0Var;
        }
    }

    static {
        androidx.media3.common.u.a("media3.exoplayer");
    }

    public b2(ExoPlayer.b bVar, androidx.media3.common.a0 a0Var) {
        try {
            androidx.media3.common.util.u.f("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.7.1] [" + androidx.media3.common.util.a1.f10436e + "]");
            this.f11350e = bVar.f11041a.getApplicationContext();
            this.f11378s = (y1.a) bVar.f11049i.apply(bVar.f11042b);
            this.f11369n0 = bVar.f11051k;
            this.f11371o0 = bVar.f11052l;
            this.f11357h0 = bVar.f11053m;
            this.f11347c0 = bVar.f11059s;
            this.f11349d0 = bVar.f11060t;
            this.f11361j0 = bVar.f11057q;
            this.F = bVar.B;
            c cVar = new c();
            this.f11391z = cVar;
            this.A = new d();
            Handler handler = new Handler(bVar.f11050j);
            b4 b4Var = (b4) bVar.f11044d.get();
            w3[] a11 = b4Var.a(handler, cVar, cVar, cVar, cVar);
            this.f11354g = a11;
            androidx.media3.common.util.a.g(a11.length > 0);
            this.f11356h = new w3[a11.length];
            int i11 = 0;
            while (true) {
                w3[] w3VarArr = this.f11356h;
                if (i11 >= w3VarArr.length) {
                    break;
                }
                w3 w3Var = this.f11354g[i11];
                c cVar2 = this.f11391z;
                w3VarArr[i11] = b4Var.b(w3Var, handler, cVar2, cVar2, cVar2, cVar2);
                i11++;
            }
            j2.e0 e0Var = (j2.e0) bVar.f11046f.get();
            this.f11358i = e0Var;
            this.f11376r = (r.a) bVar.f11045e.get();
            androidx.media3.exoplayer.upstream.e eVar = (androidx.media3.exoplayer.upstream.e) bVar.f11048h.get();
            this.f11382u = eVar;
            this.f11374q = bVar.f11061u;
            this.N = bVar.f11062v;
            this.f11384v = bVar.f11063w;
            this.f11386w = bVar.f11064x;
            this.f11388x = bVar.f11065y;
            this.Q = bVar.C;
            Looper looper = bVar.f11050j;
            this.f11380t = looper;
            androidx.media3.common.util.i iVar = bVar.f11042b;
            this.f11390y = iVar;
            androidx.media3.common.a0 a0Var2 = a0Var == null ? this : a0Var;
            this.f11352f = a0Var2;
            this.f11366m = new androidx.media3.common.util.t(looper, iVar, new t.b() { // from class: androidx.media3.exoplayer.j1
                @Override // androidx.media3.common.util.t.b
                public final void a(Object obj, androidx.media3.common.p pVar) {
                    b2.this.N1((a0.d) obj, pVar);
                }
            });
            this.f11368n = new CopyOnWriteArraySet();
            this.f11372p = new ArrayList();
            this.O = new v.a(0);
            this.P = ExoPlayer.c.f11067b;
            w3[] w3VarArr2 = this.f11354g;
            j2.f0 f0Var = new j2.f0(new z3[w3VarArr2.length], new j2.z[w3VarArr2.length], androidx.media3.common.i0.f10166b, null);
            this.f11344b = f0Var;
            this.f11370o = new e0.b();
            a0.b e11 = new a0.b.a().c(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32).d(29, e0Var.h()).d(23, bVar.f11058r).d(25, bVar.f11058r).d(33, bVar.f11058r).d(26, bVar.f11058r).d(34, bVar.f11058r).e();
            this.f11346c = e11;
            this.R = new a0.b.a().b(e11).a(4).a(10).e();
            this.f11360j = iVar.createHandler(looper, null);
            r2.f fVar = new r2.f() { // from class: androidx.media3.exoplayer.l1
                @Override // androidx.media3.exoplayer.r2.f
                public final void a(r2.e eVar2) {
                    b2.this.P1(eVar2);
                }
            };
            this.f11362k = fVar;
            this.f11383u0 = r3.k(f0Var);
            this.f11378s.H(a0Var2, looper);
            y1.f4 f4Var = new y1.f4(bVar.H);
            r2 r2Var = new r2(this.f11350e, this.f11354g, this.f11356h, e0Var, f0Var, (u2) bVar.f11047g.get(), eVar, this.I, this.J, this.f11378s, this.N, bVar.f11066z, bVar.A, this.Q, bVar.I, looper, iVar, fVar, f4Var, bVar.E, this.P);
            this.f11364l = r2Var;
            Looper K = r2Var.K();
            this.f11359i0 = 1.0f;
            this.I = 0;
            androidx.media3.common.v vVar = androidx.media3.common.v.I;
            this.S = vVar;
            this.T = vVar;
            this.f11381t0 = vVar;
            this.f11385v0 = -1;
            this.f11363k0 = u1.b.f76715c;
            this.f11365l0 = true;
            M(this.f11378s);
            eVar.d(new Handler(looper), this.f11378s);
            n1(this.f11391z);
            long j11 = bVar.f11043c;
            if (j11 > 0) {
                r2Var.E(j11);
            }
            if (androidx.media3.common.util.a1.f10432a >= 31) {
                b.c(this.f11350e, this, bVar.D, f4Var);
            }
            androidx.media3.common.util.g gVar = new androidx.media3.common.util.g(0, K, looper, iVar, new g.a() { // from class: androidx.media3.exoplayer.m1
                @Override // androidx.media3.common.util.g.a
                public final void a(Object obj, Object obj2) {
                    b2.this.q2(((Integer) obj).intValue(), ((Integer) obj2).intValue());
                }
            });
            this.H = gVar;
            gVar.h(new Runnable() { // from class: androidx.media3.exoplayer.n1
                @Override // java.lang.Runnable
                public final void run() {
                    b2.this.Q1();
                }
            });
            androidx.media3.exoplayer.e eVar2 = new androidx.media3.exoplayer.e(bVar.f11041a, K, bVar.f11050j, this.f11391z, iVar);
            this.B = eVar2;
            eVar2.f(bVar.f11056p);
            if (bVar.G) {
                m4 m4Var = bVar.J;
                this.G = m4Var;
                m4Var.b(new m4.a() { // from class: androidx.media3.exoplayer.o1
                    @Override // androidx.media3.exoplayer.m4.a
                    public final void a(boolean z10) {
                        b2.this.r2(z10);
                    }
                }, this.f11350e, looper, K, iVar);
            } else {
                this.G = null;
            }
            if (bVar.f11058r) {
                this.C = new k4(bVar.f11041a, this.f11391z, this.f11357h0.b(), K, looper, iVar);
            } else {
                this.C = null;
            }
            p4 p4Var = new p4(bVar.f11041a, K, iVar);
            this.D = p4Var;
            p4Var.e(bVar.f11055o != 0);
            s4 s4Var = new s4(bVar.f11041a, K, iVar);
            this.E = s4Var;
            s4Var.e(bVar.f11055o == 2);
            this.f11377r0 = androidx.media3.common.m.f10180e;
            this.f11379s0 = androidx.media3.common.m0.f10193e;
            this.f11351e0 = androidx.media3.common.util.l0.f10489c;
            r2Var.d1(this.f11357h0, bVar.f11054n);
            w2(1, 3, this.f11357h0);
            w2(2, 4, Integer.valueOf(this.f11347c0));
            w2(2, 5, Integer.valueOf(this.f11349d0));
            w2(1, 9, Boolean.valueOf(this.f11361j0));
            w2(2, 7, this.A);
            w2(6, 8, this.A);
            x2(16, Integer.valueOf(this.f11369n0));
            this.f11348d.f();
        } catch (Throwable th2) {
            this.f11348d.f();
            throw th2;
        }
    }

    private Pair A1(r3 r3Var, r3 r3Var2, boolean z10, int i11, boolean z11, boolean z12) {
        androidx.media3.common.e0 e0Var = r3Var2.f12625a;
        androidx.media3.common.e0 e0Var2 = r3Var.f12625a;
        if (e0Var2.q() && e0Var.q()) {
            return new Pair(Boolean.FALSE, -1);
        }
        int i12 = 3;
        if (e0Var2.q() != e0Var.q()) {
            return new Pair(Boolean.TRUE, 3);
        }
        if (e0Var.n(e0Var.h(r3Var2.f12626b.f12965a, this.f11370o).f10018c, this.f10058a).f10033a.equals(e0Var2.n(e0Var2.h(r3Var.f12626b.f12965a, this.f11370o).f10018c, this.f10058a).f10033a)) {
            return (z10 && i11 == 0 && r3Var2.f12626b.f12968d < r3Var.f12626b.f12968d) ? new Pair(Boolean.TRUE, 0) : (z10 && i11 == 1 && z12) ? new Pair(Boolean.TRUE, 2) : new Pair(Boolean.FALSE, -1);
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

    private void A2(List list, int i11, long j11, boolean z10) {
        int i12;
        long j12;
        int E1 = E1(this.f11383u0);
        long currentPosition = getCurrentPosition();
        this.K++;
        if (!this.f11372p.isEmpty()) {
            u2(0, this.f11372p.size());
        }
        List o12 = o1(0, list);
        androidx.media3.common.e0 x12 = x1();
        if (!x12.q() && i11 >= x12.p()) {
            throw new IllegalSeekPositionException(x12, i11, j11);
        }
        if (z10) {
            int a11 = x12.a(this.J);
            j12 = C.TIME_UNSET;
            i12 = a11;
        } else if (i11 == -1) {
            i12 = E1;
            j12 = currentPosition;
        } else {
            i12 = i11;
            j12 = j11;
        }
        r3 n22 = n2(this.f11383u0, x12, o2(x12, i12, j12));
        int i13 = n22.f12629e;
        if (i12 != -1 && i13 != 1) {
            i13 = (x12.q() || i12 >= x12.p()) ? 4 : 2;
        }
        r3 m22 = m2(n22, i13);
        this.f11364l.i1(o12, i12, androidx.media3.common.util.a1.R0(j12), this.O);
        J2(m22, 0, (this.f11383u0.f12626b.f12965a.equals(m22.f12626b.f12965a) || this.f11383u0.f12625a.q()) ? false : true, 4, D1(m22), -1, false);
    }

    private void B2(SurfaceHolder surfaceHolder) {
        this.f11343a0 = false;
        this.Y = surfaceHolder;
        surfaceHolder.addCallback(this.f11391z);
        Surface surface = this.Y.getSurface();
        if (surface == null || !surface.isValid()) {
            p2(0, 0);
        } else {
            Rect surfaceFrame = this.Y.getSurfaceFrame();
            p2(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    private long C1(r3 r3Var) {
        if (!r3Var.f12626b.b()) {
            return androidx.media3.common.util.a1.y1(D1(r3Var));
        }
        r3Var.f12625a.h(r3Var.f12626b.f12965a, this.f11370o);
        return r3Var.f12627c == C.TIME_UNSET ? r3Var.f12625a.n(E1(r3Var), this.f10058a).b() : this.f11370o.n() + androidx.media3.common.util.a1.y1(r3Var.f12627c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C2(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        D2(surface);
        this.X = surface;
    }

    private long D1(r3 r3Var) {
        if (r3Var.f12625a.q()) {
            return androidx.media3.common.util.a1.R0(this.f11389x0);
        }
        long m11 = r3Var.f12640p ? r3Var.m() : r3Var.f12643s;
        return r3Var.f12626b.b() ? m11 : s2(r3Var.f12625a, r3Var.f12626b, m11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D2(Object obj) {
        Object obj2 = this.W;
        boolean z10 = (obj2 == null || obj2 == obj) ? false : true;
        boolean x12 = this.f11364l.x1(obj, z10 ? this.F : C.TIME_UNSET);
        if (z10) {
            Object obj3 = this.W;
            Surface surface = this.X;
            if (obj3 == surface) {
                surface.release();
                this.X = null;
            }
        }
        this.W = obj;
        if (x12) {
            return;
        }
        F2(ExoPlaybackException.createForUnexpected(new ExoTimeoutException(3), 1003));
    }

    private int E1(r3 r3Var) {
        return r3Var.f12625a.q() ? this.f11385v0 : r3Var.f12625a.h(r3Var.f12626b.f12965a, this.f11370o).f10018c;
    }

    private Pair F1(androidx.media3.common.e0 e0Var, androidx.media3.common.e0 e0Var2, int i11, long j11) {
        boolean q11 = e0Var.q();
        long j12 = C.TIME_UNSET;
        if (q11 || e0Var2.q()) {
            boolean z10 = !e0Var.q() && e0Var2.q();
            int i12 = z10 ? -1 : i11;
            if (!z10) {
                j12 = j11;
            }
            return o2(e0Var2, i12, j12);
        }
        Pair j13 = e0Var.j(this.f10058a, this.f11370o, i11, androidx.media3.common.util.a1.R0(j11));
        Object obj = ((Pair) androidx.media3.common.util.a1.i(j13)).first;
        if (e0Var2.b(obj) != -1) {
            return j13;
        }
        int S0 = r2.S0(this.f10058a, this.f11370o, this.I, this.J, obj, e0Var, e0Var2);
        return S0 != -1 ? o2(e0Var2, S0, e0Var2.n(S0, this.f10058a).b()) : o2(e0Var2, -1, C.TIME_UNSET);
    }

    private void F2(ExoPlaybackException exoPlaybackException) {
        r3 r3Var = this.f11383u0;
        r3 c11 = r3Var.c(r3Var.f12626b);
        c11.f12641q = c11.f12643s;
        c11.f12642r = 0L;
        r3 m22 = m2(c11, 1);
        if (exoPlaybackException != null) {
            m22 = m22.f(exoPlaybackException);
        }
        this.K++;
        this.f11364l.H1();
        J2(m22, 0, false, 5, C.TIME_UNSET, -1, false);
    }

    private void G2() {
        a0.b bVar = this.R;
        a0.b O = androidx.media3.common.util.a1.O(this.f11352f, this.f11346c);
        this.R = O;
        if (O.equals(bVar)) {
            return;
        }
        this.f11366m.i(13, new t.a() { // from class: androidx.media3.exoplayer.r1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                b2.this.X1((a0.d) obj);
            }
        });
    }

    private a0.e H1(long j11) {
        androidx.media3.common.t tVar;
        Object obj;
        int i11;
        Object obj2;
        int t11 = t();
        if (this.f11383u0.f12625a.q()) {
            tVar = null;
            obj = null;
            i11 = -1;
            obj2 = null;
        } else {
            r3 r3Var = this.f11383u0;
            Object obj3 = r3Var.f12626b.f12965a;
            r3Var.f12625a.h(obj3, this.f11370o);
            i11 = this.f11383u0.f12625a.b(obj3);
            obj = obj3;
            obj2 = this.f11383u0.f12625a.n(t11, this.f10058a).f10033a;
            tVar = this.f10058a.f10035c;
        }
        long y12 = androidx.media3.common.util.a1.y1(j11);
        long y13 = this.f11383u0.f12626b.b() ? androidx.media3.common.util.a1.y1(J1(this.f11383u0)) : y12;
        r.b bVar = this.f11383u0.f12626b;
        return new a0.e(obj2, t11, tVar, obj, i11, y12, y13, bVar.f12966b, bVar.f12967c);
    }

    private void H2(int i11, int i12, List list) {
        this.K++;
        this.f11364l.M1(i11, i12, list);
        for (int i13 = i11; i13 < i12; i13++) {
            e eVar = (e) this.f11372p.get(i13);
            eVar.d(new g2.x(eVar.b(), (androidx.media3.common.t) list.get(i13 - i11)));
        }
        J2(this.f11383u0.j(x1()), 0, false, 4, C.TIME_UNSET, -1, false);
    }

    private a0.e I1(int i11, r3 r3Var, int i12) {
        int i13;
        Object obj;
        androidx.media3.common.t tVar;
        Object obj2;
        int i14;
        long j11;
        long J1;
        e0.b bVar = new e0.b();
        if (r3Var.f12625a.q()) {
            i13 = i12;
            obj = null;
            tVar = null;
            obj2 = null;
            i14 = -1;
        } else {
            Object obj3 = r3Var.f12626b.f12965a;
            r3Var.f12625a.h(obj3, bVar);
            int i15 = bVar.f10018c;
            int b11 = r3Var.f12625a.b(obj3);
            Object obj4 = r3Var.f12625a.n(i15, this.f10058a).f10033a;
            tVar = this.f10058a.f10035c;
            obj2 = obj3;
            i14 = b11;
            obj = obj4;
            i13 = i15;
        }
        if (i11 == 0) {
            if (r3Var.f12626b.b()) {
                r.b bVar2 = r3Var.f12626b;
                j11 = bVar.b(bVar2.f12966b, bVar2.f12967c);
                J1 = J1(r3Var);
            } else {
                j11 = r3Var.f12626b.f12969e != -1 ? J1(this.f11383u0) : bVar.f10020e + bVar.f10019d;
                J1 = j11;
            }
        } else if (r3Var.f12626b.b()) {
            j11 = r3Var.f12643s;
            J1 = J1(r3Var);
        } else {
            j11 = bVar.f10020e + r3Var.f12643s;
            J1 = j11;
        }
        long y12 = androidx.media3.common.util.a1.y1(j11);
        long y13 = androidx.media3.common.util.a1.y1(J1);
        r.b bVar3 = r3Var.f12626b;
        return new a0.e(obj, i13, tVar, obj2, i14, y12, y13, bVar3.f12966b, bVar3.f12967c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I2(boolean z10, int i11) {
        int v12 = v1(z10);
        r3 r3Var = this.f11383u0;
        if (r3Var.f12636l == z10 && r3Var.f12638n == v12 && r3Var.f12637m == i11) {
            return;
        }
        this.K++;
        if (r3Var.f12640p) {
            r3Var = r3Var.a();
        }
        r3 e11 = r3Var.e(z10, i11, v12);
        this.f11364l.l1(z10, i11, v12);
        J2(e11, 0, false, 5, C.TIME_UNSET, -1, false);
    }

    private static long J1(r3 r3Var) {
        e0.c cVar = new e0.c();
        e0.b bVar = new e0.b();
        r3Var.f12625a.h(r3Var.f12626b.f12965a, bVar);
        return r3Var.f12627c == C.TIME_UNSET ? r3Var.f12625a.n(bVar.f10018c, cVar).c() : bVar.o() + r3Var.f12627c;
    }

    private void J2(final r3 r3Var, final int i11, boolean z10, final int i12, long j11, int i13, boolean z11) {
        r3 r3Var2 = this.f11383u0;
        this.f11383u0 = r3Var;
        boolean equals = r3Var2.f12625a.equals(r3Var.f12625a);
        Pair A1 = A1(r3Var, r3Var2, z10, i12, !equals, z11);
        boolean booleanValue = ((Boolean) A1.first).booleanValue();
        final int intValue = ((Integer) A1.second).intValue();
        if (booleanValue) {
            r2 = r3Var.f12625a.q() ? null : r3Var.f12625a.n(r3Var.f12625a.h(r3Var.f12626b.f12965a, this.f11370o).f10018c, this.f10058a).f10035c;
            this.f11381t0 = androidx.media3.common.v.I;
        }
        if (booleanValue || !r3Var2.f12634j.equals(r3Var.f12634j)) {
            this.f11381t0 = this.f11381t0.a().N(r3Var.f12634j).J();
        }
        androidx.media3.common.v s12 = s1();
        boolean equals2 = s12.equals(this.S);
        this.S = s12;
        boolean z12 = r3Var2.f12636l != r3Var.f12636l;
        boolean z13 = r3Var2.f12629e != r3Var.f12629e;
        if (z13 || z12) {
            L2();
        }
        boolean z14 = r3Var2.f12631g;
        boolean z15 = r3Var.f12631g;
        boolean z16 = z14 != z15;
        if (z16) {
            K2(z15);
        }
        if (!equals) {
            this.f11366m.i(0, new t.a() { // from class: androidx.media3.exoplayer.z0
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    b2.Y1(r3.this, i11, (a0.d) obj);
                }
            });
        }
        if (z10) {
            final a0.e I1 = I1(i12, r3Var2, i13);
            final a0.e H1 = H1(j11);
            this.f11366m.i(11, new t.a() { // from class: androidx.media3.exoplayer.w1
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    b2.Z1(i12, I1, H1, (a0.d) obj);
                }
            });
        }
        if (booleanValue) {
            this.f11366m.i(1, new t.a() { // from class: androidx.media3.exoplayer.x1
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    ((a0.d) obj).onMediaItemTransition(androidx.media3.common.t.this, intValue);
                }
            });
        }
        if (r3Var2.f12630f != r3Var.f12630f) {
            this.f11366m.i(10, new t.a() { // from class: androidx.media3.exoplayer.y1
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    b2.b2(r3.this, (a0.d) obj);
                }
            });
            if (r3Var.f12630f != null) {
                this.f11366m.i(10, new t.a() { // from class: androidx.media3.exoplayer.z1
                    @Override // androidx.media3.common.util.t.a
                    public final void invoke(Object obj) {
                        b2.c2(r3.this, (a0.d) obj);
                    }
                });
            }
        }
        j2.f0 f0Var = r3Var2.f12633i;
        j2.f0 f0Var2 = r3Var.f12633i;
        if (f0Var != f0Var2) {
            this.f11358i.i(f0Var2.f65881e);
            this.f11366m.i(2, new t.a() { // from class: androidx.media3.exoplayer.a2
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    b2.d2(r3.this, (a0.d) obj);
                }
            });
        }
        if (!equals2) {
            final androidx.media3.common.v vVar = this.S;
            this.f11366m.i(14, new t.a() { // from class: androidx.media3.exoplayer.a1
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    ((a0.d) obj).onMediaMetadataChanged(androidx.media3.common.v.this);
                }
            });
        }
        if (z16) {
            this.f11366m.i(3, new t.a() { // from class: androidx.media3.exoplayer.b1
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    b2.f2(r3.this, (a0.d) obj);
                }
            });
        }
        if (z13 || z12) {
            this.f11366m.i(-1, new t.a() { // from class: androidx.media3.exoplayer.c1
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    b2.g2(r3.this, (a0.d) obj);
                }
            });
        }
        if (z13) {
            this.f11366m.i(4, new t.a() { // from class: androidx.media3.exoplayer.d1
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    b2.h2(r3.this, (a0.d) obj);
                }
            });
        }
        if (z12 || r3Var2.f12637m != r3Var.f12637m) {
            this.f11366m.i(5, new t.a() { // from class: androidx.media3.exoplayer.k1
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    b2.i2(r3.this, (a0.d) obj);
                }
            });
        }
        if (r3Var2.f12638n != r3Var.f12638n) {
            this.f11366m.i(6, new t.a() { // from class: androidx.media3.exoplayer.t1
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    b2.j2(r3.this, (a0.d) obj);
                }
            });
        }
        if (r3Var2.n() != r3Var.n()) {
            this.f11366m.i(7, new t.a() { // from class: androidx.media3.exoplayer.u1
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    b2.k2(r3.this, (a0.d) obj);
                }
            });
        }
        if (!r3Var2.f12639o.equals(r3Var.f12639o)) {
            this.f11366m.i(12, new t.a() { // from class: androidx.media3.exoplayer.v1
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    b2.l2(r3.this, (a0.d) obj);
                }
            });
        }
        G2();
        this.f11366m.f();
        if (r3Var2.f12640p != r3Var.f12640p) {
            Iterator it = this.f11368n.iterator();
            while (it.hasNext()) {
                ((ExoPlayer.a) it.next()).x(r3Var.f12640p);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K1, reason: merged with bridge method [inline-methods] */
    public void O1(r2.e eVar) {
        long j11;
        int i11 = this.K - eVar.f12612c;
        this.K = i11;
        boolean z10 = true;
        if (eVar.f12613d) {
            this.L = eVar.f12614e;
            this.M = true;
        }
        if (i11 == 0) {
            androidx.media3.common.e0 e0Var = eVar.f12611b.f12625a;
            if (!this.f11383u0.f12625a.q() && e0Var.q()) {
                this.f11385v0 = -1;
                this.f11389x0 = 0L;
                this.f11387w0 = 0;
            }
            if (!e0Var.q()) {
                List F = ((u3) e0Var).F();
                androidx.media3.common.util.a.g(F.size() == this.f11372p.size());
                for (int i12 = 0; i12 < F.size(); i12++) {
                    ((e) this.f11372p.get(i12)).d((androidx.media3.common.e0) F.get(i12));
                }
            }
            boolean z11 = this.M;
            long j12 = C.TIME_UNSET;
            if (z11) {
                if (eVar.f12611b.f12626b.equals(this.f11383u0.f12626b) && eVar.f12611b.f12628d == this.f11383u0.f12643s) {
                    z10 = false;
                }
                if (z10) {
                    if (e0Var.q() || eVar.f12611b.f12626b.b()) {
                        j11 = eVar.f12611b.f12628d;
                    } else {
                        r3 r3Var = eVar.f12611b;
                        j11 = s2(e0Var, r3Var.f12626b, r3Var.f12628d);
                    }
                    j12 = j11;
                }
            } else {
                z10 = false;
            }
            this.M = false;
            J2(eVar.f12611b, 1, z10, this.L, j12, -1, false);
        }
    }

    private void K2(boolean z10) {
        PriorityTaskManager priorityTaskManager = this.f11371o0;
        if (priorityTaskManager != null) {
            if (z10 && !this.f11373p0) {
                priorityTaskManager.a(this.f11369n0);
                this.f11373p0 = true;
            } else {
                if (z10 || !this.f11373p0) {
                    return;
                }
                priorityTaskManager.d(this.f11369n0);
                this.f11373p0 = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L2() {
        int playbackState = getPlaybackState();
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                this.D.f(getPlayWhenReady() && !L1());
                this.E.f(getPlayWhenReady());
                return;
            } else if (playbackState != 4) {
                throw new IllegalStateException();
            }
        }
        this.D.f(false);
        this.E.f(false);
    }

    private void M2() {
        this.f11348d.c();
        if (Thread.currentThread() != k().getThread()) {
            String G = androidx.media3.common.util.a1.G("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), k().getThread().getName());
            if (this.f11365l0) {
                throw new IllegalStateException(G);
            }
            androidx.media3.common.util.u.i("ExoPlayerImpl", G, this.f11367m0 ? null : new IllegalStateException());
            this.f11367m0 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N1(a0.d dVar, androidx.media3.common.p pVar) {
        dVar.onEvents(this.f11352f, new a0.c(pVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P1(final r2.e eVar) {
        this.f11360j.post(new Runnable() { // from class: androidx.media3.exoplayer.p1
            @Override // java.lang.Runnable
            public final void run() {
                b2.this.O1(eVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q1() {
        this.H.i(Integer.valueOf(androidx.media3.common.util.a1.J(this.f11350e)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S1(a0.d dVar) {
        dVar.onPlayerError(ExoPlaybackException.createForUnexpected(new ExoTimeoutException(1), 1003));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X1(a0.d dVar) {
        dVar.onAvailableCommandsChanged(this.R);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y1(r3 r3Var, int i11, a0.d dVar) {
        dVar.onTimelineChanged(r3Var.f12625a, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z1(int i11, a0.e eVar, a0.e eVar2, a0.d dVar) {
        dVar.onPositionDiscontinuity(i11);
        dVar.onPositionDiscontinuity(eVar, eVar2, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b2(r3 r3Var, a0.d dVar) {
        dVar.onPlayerErrorChanged(r3Var.f12630f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c2(r3 r3Var, a0.d dVar) {
        dVar.onPlayerError(r3Var.f12630f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d2(r3 r3Var, a0.d dVar) {
        dVar.onTracksChanged(r3Var.f12633i.f65880d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f2(r3 r3Var, a0.d dVar) {
        dVar.onLoadingChanged(r3Var.f12631g);
        dVar.onIsLoadingChanged(r3Var.f12631g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g2(r3 r3Var, a0.d dVar) {
        dVar.onPlayerStateChanged(r3Var.f12636l, r3Var.f12629e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h2(r3 r3Var, a0.d dVar) {
        dVar.onPlaybackStateChanged(r3Var.f12629e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i2(r3 r3Var, a0.d dVar) {
        dVar.onPlayWhenReadyChanged(r3Var.f12636l, r3Var.f12637m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j2(r3 r3Var, a0.d dVar) {
        dVar.onPlaybackSuppressionReasonChanged(r3Var.f12638n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k2(r3 r3Var, a0.d dVar) {
        dVar.onIsPlayingChanged(r3Var.n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l2(r3 r3Var, a0.d dVar) {
        dVar.onPlaybackParametersChanged(r3Var.f12639o);
    }

    private static r3 m2(r3 r3Var, int i11) {
        r3 h11 = r3Var.h(i11);
        return (i11 == 1 || i11 == 4) ? h11.b(false) : h11;
    }

    private r3 n2(r3 r3Var, androidx.media3.common.e0 e0Var, Pair pair) {
        androidx.media3.common.util.a.a(e0Var.q() || pair != null);
        androidx.media3.common.e0 e0Var2 = r3Var.f12625a;
        long C1 = C1(r3Var);
        r3 j11 = r3Var.j(e0Var);
        if (e0Var.q()) {
            r.b l11 = r3.l();
            long R0 = androidx.media3.common.util.a1.R0(this.f11389x0);
            r3 c11 = j11.d(l11, R0, R0, R0, 0L, g2.z.f63387d, this.f11344b, ImmutableList.of()).c(l11);
            c11.f12641q = c11.f12643s;
            return c11;
        }
        Object obj = j11.f12626b.f12965a;
        boolean equals = obj.equals(((Pair) androidx.media3.common.util.a1.i(pair)).first);
        r.b bVar = !equals ? new r.b(pair.first) : j11.f12626b;
        long longValue = ((Long) pair.second).longValue();
        long R02 = androidx.media3.common.util.a1.R0(C1);
        if (!e0Var2.q()) {
            R02 -= e0Var2.h(obj, this.f11370o).o();
        }
        if (!equals || longValue < R02) {
            androidx.media3.common.util.a.g(!bVar.b());
            r3 c12 = j11.d(bVar, longValue, longValue, longValue, 0L, !equals ? g2.z.f63387d : j11.f12632h, !equals ? this.f11344b : j11.f12633i, !equals ? ImmutableList.of() : j11.f12634j).c(bVar);
            c12.f12641q = longValue;
            return c12;
        }
        if (longValue == R02) {
            int b11 = e0Var.b(j11.f12635k.f12965a);
            if (b11 == -1 || e0Var.f(b11, this.f11370o).f10018c != e0Var.h(bVar.f12965a, this.f11370o).f10018c) {
                e0Var.h(bVar.f12965a, this.f11370o);
                long b12 = bVar.b() ? this.f11370o.b(bVar.f12966b, bVar.f12967c) : this.f11370o.f10019d;
                j11 = j11.d(bVar, j11.f12643s, j11.f12643s, j11.f12628d, b12 - j11.f12643s, j11.f12632h, j11.f12633i, j11.f12634j).c(bVar);
                j11.f12641q = b12;
            }
        } else {
            androidx.media3.common.util.a.g(!bVar.b());
            long max = Math.max(0L, j11.f12642r - (longValue - R02));
            long j12 = j11.f12641q;
            if (j11.f12635k.equals(j11.f12626b)) {
                j12 = longValue + max;
            }
            j11 = j11.d(bVar, longValue, longValue, longValue, max, j11.f12632h, j11.f12633i, j11.f12634j);
            j11.f12641q = j12;
        }
        return j11;
    }

    private List o1(int i11, List list) {
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            q3.c cVar = new q3.c((androidx.media3.exoplayer.source.r) list.get(i12), this.f11374q);
            arrayList.add(cVar);
            this.f11372p.add(i12 + i11, new e(cVar.f12560b, cVar.f12559a));
        }
        this.O = this.O.cloneAndInsert(i11, arrayList.size());
        return arrayList;
    }

    private Pair o2(androidx.media3.common.e0 e0Var, int i11, long j11) {
        if (e0Var.q()) {
            this.f11385v0 = i11;
            if (j11 == C.TIME_UNSET) {
                j11 = 0;
            }
            this.f11389x0 = j11;
            this.f11387w0 = 0;
            return null;
        }
        if (i11 == -1 || i11 >= e0Var.p()) {
            i11 = e0Var.a(this.J);
            j11 = e0Var.n(i11, this.f10058a).b();
        }
        return e0Var.j(this.f10058a, this.f11370o, i11, androidx.media3.common.util.a1.R0(j11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p2(final int i11, final int i12) {
        if (i11 == this.f11351e0.b() && i12 == this.f11351e0.a()) {
            return;
        }
        this.f11351e0 = new androidx.media3.common.util.l0(i11, i12);
        this.f11366m.l(24, new t.a() { // from class: androidx.media3.exoplayer.f1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((a0.d) obj).onSurfaceSizeChanged(i11, i12);
            }
        });
        w2(2, 14, new androidx.media3.common.util.l0(i11, i12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q2(int i11, final int i12) {
        M2();
        w2(1, 10, Integer.valueOf(i12));
        w2(2, 10, Integer.valueOf(i12));
        this.f11366m.l(21, new t.a() { // from class: androidx.media3.exoplayer.s1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((a0.d) obj).onAudioSessionIdChanged(i12);
            }
        });
    }

    private r3 r1(r3 r3Var, int i11, List list) {
        androidx.media3.common.e0 e0Var = r3Var.f12625a;
        this.K++;
        List o12 = o1(i11, list);
        androidx.media3.common.e0 x12 = x1();
        r3 n22 = n2(r3Var, x12, F1(e0Var, x12, E1(r3Var), C1(r3Var)));
        this.f11364l.p(i11, o12, this.O);
        return n22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r2(boolean z10) {
        if (this.f11375q0) {
            return;
        }
        if (!z10) {
            I2(this.f11383u0.f12636l, 1);
            return;
        }
        r3 r3Var = this.f11383u0;
        if (r3Var.f12638n == 3) {
            I2(r3Var.f12636l, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public androidx.media3.common.v s1() {
        androidx.media3.common.e0 currentTimeline = getCurrentTimeline();
        if (currentTimeline.q()) {
            return this.f11381t0;
        }
        return this.f11381t0.a().L(currentTimeline.n(t(), this.f10058a).f10035c.f10296e).J();
    }

    private long s2(androidx.media3.common.e0 e0Var, r.b bVar, long j11) {
        e0Var.h(bVar.f12965a, this.f11370o);
        return j11 + this.f11370o.o();
    }

    private boolean t1(int i11, int i12, List list) {
        if (i12 - i11 != list.size()) {
            return false;
        }
        for (int i13 = i11; i13 < i12; i13++) {
            if (!((e) this.f11372p.get(i13)).f11398b.q((androidx.media3.common.t) list.get(i13 - i11))) {
                return false;
            }
        }
        return true;
    }

    private r3 t2(r3 r3Var, int i11, int i12) {
        int E1 = E1(r3Var);
        long C1 = C1(r3Var);
        androidx.media3.common.e0 e0Var = r3Var.f12625a;
        int size = this.f11372p.size();
        this.K++;
        u2(i11, i12);
        androidx.media3.common.e0 x12 = x1();
        r3 n22 = n2(r3Var, x12, F1(e0Var, x12, E1, C1));
        int i13 = n22.f12629e;
        if (i13 != 1 && i13 != 4 && i11 < i12 && i12 == size && E1 >= n22.f12625a.p()) {
            n22 = m2(n22, 4);
        }
        this.f11364l.H0(i11, i12, this.O);
        return n22;
    }

    private void u2(int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            this.f11372p.remove(i13);
        }
        this.O = this.O.a(i11, i12);
    }

    private int v1(boolean z10) {
        m4 m4Var = this.G;
        if (m4Var == null || m4Var.a()) {
            return (this.f11383u0.f12638n != 1 || z10) ? 0 : 1;
        }
        return 3;
    }

    private void v2() {
        if (this.Z != null) {
            z1(this.A).m(10000).l(null).k();
            this.Z.removeVideoSurfaceListener(this.f11391z);
            this.Z = null;
        }
        TextureView textureView = this.f11345b0;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f11391z) {
                androidx.media3.common.util.u.h("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f11345b0.setSurfaceTextureListener(null);
            }
            this.f11345b0 = null;
        }
        SurfaceHolder surfaceHolder = this.Y;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f11391z);
            this.Y = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static androidx.media3.common.m w1(k4 k4Var) {
        return new m.b(0).g(k4Var != null ? k4Var.l() : 0).f(k4Var != null ? k4Var.k() : 0).e();
    }

    private void w2(int i11, int i12, Object obj) {
        for (w3 w3Var : this.f11354g) {
            if (i11 == -1 || w3Var.getTrackType() == i11) {
                z1(w3Var).m(i12).l(obj).k();
            }
        }
        for (w3 w3Var2 : this.f11356h) {
            if (w3Var2 != null && (i11 == -1 || w3Var2.getTrackType() == i11)) {
                z1(w3Var2).m(i12).l(obj).k();
            }
        }
    }

    private androidx.media3.common.e0 x1() {
        return new u3(this.f11372p, this.O);
    }

    private void x2(int i11, Object obj) {
        w2(-1, i11, obj);
    }

    private List y1(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            arrayList.add(this.f11376r.d((androidx.media3.common.t) list.get(i11)));
        }
        return arrayList;
    }

    private t3 z1(t3.b bVar) {
        int E1 = E1(this.f11383u0);
        r2 r2Var = this.f11364l;
        androidx.media3.common.e0 e0Var = this.f11383u0.f12625a;
        if (E1 == -1) {
            E1 = 0;
        }
        return new t3(r2Var, bVar, e0Var, E1, this.f11390y, r2Var.K());
    }

    @Override // androidx.media3.common.a0
    public void A(boolean z10, int i11) {
        M2();
        k4 k4Var = this.C;
        if (k4Var != null) {
            k4Var.u(z10, i11);
        }
    }

    public androidx.media3.common.util.i B1() {
        return this.f11390y;
    }

    @Override // androidx.media3.common.a0
    public void C(int i11, int i12, List list) {
        M2();
        androidx.media3.common.util.a.a(i11 >= 0 && i12 >= i11);
        int size = this.f11372p.size();
        if (i11 > size) {
            return;
        }
        int min = Math.min(i12, size);
        if (t1(i11, min, list)) {
            H2(i11, min, list);
            return;
        }
        List y12 = y1(list);
        if (this.f11372p.isEmpty()) {
            z2(y12, this.f11385v0 == -1);
        } else {
            r3 t22 = t2(r1(this.f11383u0, min, y12), i11, min);
            J2(t22, 0, !t22.f12626b.f12965a.equals(this.f11383u0.f12626b.f12965a), 4, D1(t22), -1, false);
        }
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public void D(y1.c cVar) {
        this.f11378s.z((y1.c) androidx.media3.common.util.a.e(cVar));
    }

    public void E2(SurfaceHolder surfaceHolder) {
        M2();
        if (surfaceHolder == null) {
            clearVideoSurface();
            return;
        }
        v2();
        this.f11343a0 = true;
        this.Y = surfaceHolder;
        surfaceHolder.addCallback(this.f11391z);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            D2(null);
            p2(0, 0);
        } else {
            D2(surface);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            p2(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // androidx.media3.common.a0
    public void G(int i11, int i12) {
        M2();
        androidx.media3.common.util.a.a(i11 >= 0 && i12 >= i11);
        int size = this.f11372p.size();
        int min = Math.min(i12, size);
        if (i11 >= size || i11 == min) {
            return;
        }
        r3 t22 = t2(this.f11383u0, i11, min);
        J2(t22, 0, !t22.f12626b.f12965a.equals(this.f11383u0.f12626b.f12965a), 4, D1(t22), -1, false);
    }

    public Looper G1() {
        return this.f11364l.K();
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public androidx.media3.common.r I() {
        M2();
        return this.U;
    }

    @Override // androidx.media3.common.a0
    public u1.b K() {
        M2();
        return this.f11363k0;
    }

    @Override // androidx.media3.common.a0
    public void L(a0.d dVar) {
        M2();
        this.f11366m.k((a0.d) androidx.media3.common.util.a.e(dVar));
    }

    public boolean L1() {
        M2();
        return this.f11383u0.f12640p;
    }

    @Override // androidx.media3.common.a0
    public void M(a0.d dVar) {
        this.f11366m.c((a0.d) androidx.media3.common.util.a.e(dVar));
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public androidx.media3.common.r R() {
        M2();
        return this.V;
    }

    @Override // androidx.media3.common.a0
    public void S(int i11, List list) {
        M2();
        p1(i11, y1(list));
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public void T(int i11, androidx.media3.exoplayer.source.r rVar) {
        M2();
        p1(i11, Collections.singletonList(rVar));
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public void U(androidx.media3.exoplayer.source.r rVar) {
        M2();
        y2(Collections.singletonList(rVar));
    }

    @Override // androidx.media3.common.a0
    public void V(final androidx.media3.common.h0 h0Var) {
        M2();
        if (!this.f11358i.h() || h0Var.equals(this.f11358i.c())) {
            return;
        }
        this.f11358i.m(h0Var);
        this.f11366m.l(19, new t.a() { // from class: androidx.media3.exoplayer.q1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((a0.d) obj).onTrackSelectionParametersChanged(androidx.media3.common.h0.this);
            }
        });
    }

    @Override // androidx.media3.common.a0
    public boolean W() {
        M2();
        k4 k4Var = this.C;
        if (k4Var != null) {
            return k4Var.m();
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public void X(androidx.media3.exoplayer.source.r rVar) {
        M2();
        q1(Collections.singletonList(rVar));
    }

    @Override // androidx.media3.common.a0
    public void b(androidx.media3.common.z zVar) {
        M2();
        if (zVar == null) {
            zVar = androidx.media3.common.z.f10645d;
        }
        if (this.f11383u0.f12639o.equals(zVar)) {
            return;
        }
        r3 g11 = this.f11383u0.g(zVar);
        this.K++;
        this.f11364l.n1(zVar);
        J2(g11, 0, false, 5, C.TIME_UNSET, -1, false);
    }

    @Override // androidx.media3.common.a0
    public ExoPlaybackException c() {
        M2();
        return this.f11383u0.f12630f;
    }

    @Override // androidx.media3.common.a0
    public void clearVideoSurface() {
        M2();
        v2();
        D2(null);
        p2(0, 0);
    }

    @Override // androidx.media3.common.a0
    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        M2();
        u1(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // androidx.media3.common.a0
    public void clearVideoTextureView(TextureView textureView) {
        M2();
        if (textureView == null || textureView != this.f11345b0) {
            return;
        }
        clearVideoSurface();
    }

    @Override // androidx.media3.common.a0
    public long d() {
        M2();
        return androidx.media3.common.util.a1.y1(this.f11383u0.f12642r);
    }

    @Override // androidx.media3.common.a0
    public void e(List list, boolean z10) {
        M2();
        z2(y1(list), z10);
    }

    @Override // androidx.media3.common.g
    protected void e0(int i11, long j11, int i12, boolean z10) {
        M2();
        if (i11 == -1) {
            return;
        }
        androidx.media3.common.util.a.a(i11 >= 0);
        androidx.media3.common.e0 e0Var = this.f11383u0.f12625a;
        if (e0Var.q() || i11 < e0Var.p()) {
            this.f11378s.m();
            this.K++;
            if (isPlayingAd()) {
                androidx.media3.common.util.u.h("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                r2.e eVar = new r2.e(this.f11383u0);
                eVar.b(1);
                this.f11362k.a(eVar);
                return;
            }
            r3 r3Var = this.f11383u0;
            int i13 = r3Var.f12629e;
            if (i13 == 3 || (i13 == 4 && !e0Var.q())) {
                r3Var = m2(this.f11383u0, 2);
            }
            int t11 = t();
            r3 n22 = n2(r3Var, e0Var, o2(e0Var, i11, j11));
            this.f11364l.U0(e0Var, i11, androidx.media3.common.util.a1.R0(j11));
            J2(n22, 0, true, 1, D1(n22), t11, z10);
        }
    }

    @Override // androidx.media3.common.a0
    public long getBufferedPosition() {
        M2();
        if (!isPlayingAd()) {
            return u();
        }
        r3 r3Var = this.f11383u0;
        return r3Var.f12635k.equals(r3Var.f12626b) ? androidx.media3.common.util.a1.y1(this.f11383u0.f12641q) : getDuration();
    }

    @Override // androidx.media3.common.a0
    public long getContentPosition() {
        M2();
        return C1(this.f11383u0);
    }

    @Override // androidx.media3.common.a0
    public int getCurrentAdGroupIndex() {
        M2();
        if (isPlayingAd()) {
            return this.f11383u0.f12626b.f12966b;
        }
        return -1;
    }

    @Override // androidx.media3.common.a0
    public int getCurrentAdIndexInAdGroup() {
        M2();
        if (isPlayingAd()) {
            return this.f11383u0.f12626b.f12967c;
        }
        return -1;
    }

    @Override // androidx.media3.common.a0
    public int getCurrentPeriodIndex() {
        M2();
        if (this.f11383u0.f12625a.q()) {
            return this.f11387w0;
        }
        r3 r3Var = this.f11383u0;
        return r3Var.f12625a.b(r3Var.f12626b.f12965a);
    }

    @Override // androidx.media3.common.a0
    public long getCurrentPosition() {
        M2();
        return androidx.media3.common.util.a1.y1(D1(this.f11383u0));
    }

    @Override // androidx.media3.common.a0
    public androidx.media3.common.e0 getCurrentTimeline() {
        M2();
        return this.f11383u0.f12625a;
    }

    @Override // androidx.media3.common.a0
    public androidx.media3.common.i0 getCurrentTracks() {
        M2();
        return this.f11383u0.f12633i.f65880d;
    }

    @Override // androidx.media3.common.a0
    public long getDuration() {
        M2();
        if (!isPlayingAd()) {
            return Q();
        }
        r3 r3Var = this.f11383u0;
        r.b bVar = r3Var.f12626b;
        r3Var.f12625a.h(bVar.f12965a, this.f11370o);
        return androidx.media3.common.util.a1.y1(this.f11370o.b(bVar.f12966b, bVar.f12967c));
    }

    @Override // androidx.media3.common.a0
    public boolean getPlayWhenReady() {
        M2();
        return this.f11383u0.f12636l;
    }

    @Override // androidx.media3.common.a0
    public androidx.media3.common.z getPlaybackParameters() {
        M2();
        return this.f11383u0.f12639o;
    }

    @Override // androidx.media3.common.a0
    public int getPlaybackState() {
        M2();
        return this.f11383u0.f12629e;
    }

    @Override // androidx.media3.common.a0
    public int getRepeatMode() {
        M2();
        return this.I;
    }

    @Override // androidx.media3.common.a0
    public boolean getShuffleModeEnabled() {
        M2();
        return this.J;
    }

    @Override // androidx.media3.common.a0
    public float getVolume() {
        M2();
        return this.f11359i0;
    }

    @Override // androidx.media3.common.a0
    public boolean isPlayingAd() {
        M2();
        return this.f11383u0.f12626b.b();
    }

    @Override // androidx.media3.common.a0
    public int j() {
        M2();
        return this.f11383u0.f12638n;
    }

    @Override // androidx.media3.common.a0
    public Looper k() {
        return this.f11380t;
    }

    @Override // androidx.media3.common.a0
    public androidx.media3.common.h0 l() {
        M2();
        return this.f11358i.c();
    }

    @Override // androidx.media3.common.a0
    public a0.b n() {
        M2();
        return this.R;
    }

    public void n1(ExoPlayer.a aVar) {
        this.f11368n.add(aVar);
    }

    @Override // androidx.media3.common.a0
    public long o() {
        M2();
        return this.f11388x;
    }

    @Override // androidx.media3.common.a0
    public androidx.media3.common.m0 p() {
        M2();
        return this.f11379s0;
    }

    public void p1(int i11, List list) {
        M2();
        androidx.media3.common.util.a.a(i11 >= 0);
        int min = Math.min(i11, this.f11372p.size());
        if (this.f11372p.isEmpty()) {
            z2(list, this.f11385v0 == -1);
        } else {
            J2(r1(this.f11383u0, min, list), 0, false, 5, C.TIME_UNSET, -1, false);
        }
    }

    @Override // androidx.media3.common.a0
    public void prepare() {
        M2();
        r3 r3Var = this.f11383u0;
        if (r3Var.f12629e != 1) {
            return;
        }
        r3 f11 = r3Var.f(null);
        r3 m22 = m2(f11, f11.f12625a.q() ? 4 : 2);
        this.K++;
        this.f11364l.B0();
        J2(m22, 1, false, 5, C.TIME_UNSET, -1, false);
    }

    public void q1(List list) {
        M2();
        p1(this.f11372p.size(), list);
    }

    @Override // androidx.media3.common.a0
    public long r() {
        M2();
        return this.f11386w;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public void release() {
        androidx.media3.common.util.u.f("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.7.1] [" + androidx.media3.common.util.a1.f10436e + "] [" + androidx.media3.common.u.b() + "]");
        M2();
        this.B.f(false);
        k4 k4Var = this.C;
        if (k4Var != null) {
            k4Var.t();
        }
        this.D.f(false);
        this.E.f(false);
        m4 m4Var = this.G;
        if (m4Var != null) {
            m4Var.disable();
        }
        if (!this.f11364l.D0()) {
            this.f11366m.l(10, new t.a() { // from class: androidx.media3.exoplayer.g1
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    b2.S1((a0.d) obj);
                }
            });
        }
        this.f11366m.j();
        this.f11360j.removeCallbacksAndMessages(null);
        this.f11382u.c(this.f11378s);
        r3 r3Var = this.f11383u0;
        if (r3Var.f12640p) {
            this.f11383u0 = r3Var.a();
        }
        r3 m22 = m2(this.f11383u0, 1);
        this.f11383u0 = m22;
        r3 c11 = m22.c(m22.f12626b);
        this.f11383u0 = c11;
        c11.f12641q = c11.f12643s;
        this.f11383u0.f12642r = 0L;
        this.f11378s.release();
        v2();
        Surface surface = this.X;
        if (surface != null) {
            surface.release();
            this.X = null;
        }
        if (this.f11373p0) {
            ((PriorityTaskManager) androidx.media3.common.util.a.e(this.f11371o0)).d(this.f11369n0);
            this.f11373p0 = false;
        }
        this.f11363k0 = u1.b.f76715c;
        this.f11375q0 = true;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public void setImageOutput(ImageOutput imageOutput) {
        M2();
        w2(4, 15, imageOutput);
    }

    @Override // androidx.media3.common.a0
    public void setPlayWhenReady(boolean z10) {
        M2();
        I2(z10, 1);
    }

    @Override // androidx.media3.common.a0
    public void setRepeatMode(final int i11) {
        M2();
        if (this.I != i11) {
            this.I = i11;
            this.f11364l.q1(i11);
            this.f11366m.i(8, new t.a() { // from class: androidx.media3.exoplayer.h1
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    ((a0.d) obj).onRepeatModeChanged(i11);
                }
            });
            G2();
            this.f11366m.f();
        }
    }

    @Override // androidx.media3.common.a0
    public void setShuffleModeEnabled(final boolean z10) {
        M2();
        if (this.J != z10) {
            this.J = z10;
            this.f11364l.t1(z10);
            this.f11366m.i(9, new t.a() { // from class: androidx.media3.exoplayer.i1
                @Override // androidx.media3.common.util.t.a
                public final void invoke(Object obj) {
                    ((a0.d) obj).onShuffleModeEnabledChanged(z10);
                }
            });
            G2();
            this.f11366m.f();
        }
    }

    @Override // androidx.media3.common.a0
    public void setVideoSurfaceView(SurfaceView surfaceView) {
        M2();
        if (surfaceView instanceof androidx.media3.exoplayer.video.s) {
            v2();
            D2(surfaceView);
            B2(surfaceView.getHolder());
        } else {
            if (!(surfaceView instanceof SphericalGLSurfaceView)) {
                E2(surfaceView == null ? null : surfaceView.getHolder());
                return;
            }
            v2();
            this.Z = (SphericalGLSurfaceView) surfaceView;
            z1(this.A).m(10000).l(this.Z).k();
            this.Z.addVideoSurfaceListener(this.f11391z);
            D2(this.Z.getVideoSurface());
            B2(surfaceView.getHolder());
        }
    }

    @Override // androidx.media3.common.a0
    public void setVideoTextureView(TextureView textureView) {
        M2();
        if (textureView == null) {
            clearVideoSurface();
            return;
        }
        v2();
        this.f11345b0 = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            androidx.media3.common.util.u.h("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.f11391z);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            D2(null);
            p2(0, 0);
        } else {
            C2(surfaceTexture);
            p2(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // androidx.media3.common.a0
    public void setVolume(float f11) {
        M2();
        final float o11 = androidx.media3.common.util.a1.o(f11, 0.0f, 1.0f);
        if (this.f11359i0 == o11) {
            return;
        }
        this.f11359i0 = o11;
        this.f11364l.z1(o11);
        this.f11366m.l(22, new t.a() { // from class: androidx.media3.exoplayer.e1
            @Override // androidx.media3.common.util.t.a
            public final void invoke(Object obj) {
                ((a0.d) obj).onVolumeChanged(o11);
            }
        });
    }

    @Override // androidx.media3.common.a0
    public void stop() {
        M2();
        F2(null);
        this.f11363k0 = new u1.b(ImmutableList.of(), this.f11383u0.f12643s);
    }

    @Override // androidx.media3.common.a0
    public int t() {
        M2();
        int E1 = E1(this.f11383u0);
        if (E1 == -1) {
            return 0;
        }
        return E1;
    }

    @Override // androidx.media3.common.a0
    public long u() {
        M2();
        if (this.f11383u0.f12625a.q()) {
            return this.f11389x0;
        }
        r3 r3Var = this.f11383u0;
        if (r3Var.f12635k.f12968d != r3Var.f12626b.f12968d) {
            return r3Var.f12625a.n(t(), this.f10058a).d();
        }
        long j11 = r3Var.f12641q;
        if (this.f11383u0.f12635k.b()) {
            r3 r3Var2 = this.f11383u0;
            e0.b h11 = r3Var2.f12625a.h(r3Var2.f12635k.f12965a, this.f11370o);
            long f11 = h11.f(this.f11383u0.f12635k.f12966b);
            j11 = f11 == Long.MIN_VALUE ? h11.f10019d : f11;
        }
        r3 r3Var3 = this.f11383u0;
        return androidx.media3.common.util.a1.y1(s2(r3Var3.f12625a, r3Var3.f12635k, j11));
    }

    public void u1(SurfaceHolder surfaceHolder) {
        M2();
        if (surfaceHolder == null || surfaceHolder != this.Y) {
            return;
        }
        clearVideoSurface();
    }

    @Override // androidx.media3.common.a0
    public androidx.media3.common.v x() {
        M2();
        return this.S;
    }

    @Override // androidx.media3.common.a0
    public long y() {
        M2();
        return this.f11384v;
    }

    public void y2(List list) {
        M2();
        z2(list, true);
    }

    public void z2(List list, boolean z10) {
        M2();
        A2(list, -1, C.TIME_UNSET, z10);
    }
}
