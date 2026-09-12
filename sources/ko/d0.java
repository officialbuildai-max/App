package ko;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import com.transsion.player.orplayer.g;
import com.transsion.player.p007enum.ScaleMode;
import java.lang.Thread;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class d0 implements com.transsion.player.orplayer.g, com.transsion.player.orplayer.f {

    /* renamed from: m, reason: collision with root package name */
    public static final a f67047m = new a(null);

    /* renamed from: n, reason: collision with root package name */
    private static final Thread.UncaughtExceptionHandler f67048n = new Thread.UncaughtExceptionHandler() { // from class: ko.b
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread thread, Throwable th2) {
            d0.O(thread, th2);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final HandlerThread f67049a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f67050b;

    /* renamed from: c, reason: collision with root package name */
    private com.transsion.player.orplayer.g f67051c;

    /* renamed from: d, reason: collision with root package name */
    private volatile long f67052d;

    /* renamed from: e, reason: collision with root package name */
    private volatile com.transsion.player.orplayer.f f67053e;

    /* renamed from: f, reason: collision with root package name */
    private Boolean f67054f;

    /* renamed from: g, reason: collision with root package name */
    private com.transsion.player.orplayer.e f67055g;

    /* renamed from: h, reason: collision with root package name */
    private CopyOnWriteArrayList f67056h;

    /* renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f67057i;

    /* renamed from: j, reason: collision with root package name */
    private volatile ao.e f67058j;

    /* renamed from: k, reason: collision with root package name */
    private long f67059k;

    /* renamed from: l, reason: collision with root package name */
    private final AtomicBoolean f67060l;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d0 a() {
            return new d0(null);
        }
    }

    private d0() {
        this.f67054f = Boolean.FALSE;
        this.f67056h = new CopyOnWriteArrayList();
        this.f67057i = new AtomicBoolean(false);
        l0 l0Var = l0.f67091a;
        if (l0Var.m()) {
            HandlerThread handlerThread = new HandlerThread("TnPlayerThread", Build.VERSION.SDK_INT >= 28 ? -10 : -16);
            handlerThread.start();
            handlerThread.setUncaughtExceptionHandler(f67048n);
            this.f67050b = new Handler(handlerThread.getLooper());
            this.f67049a = handlerThread;
        } else {
            this.f67049a = null;
            this.f67050b = new Handler(Looper.getMainLooper());
        }
        int j11 = l0Var.j();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TnplayerManager Aliyunplayer maxBufferingTime:");
        sb2.append(j11);
        Integer valueOf = Integer.valueOf(j11);
        Integer num = valueOf.intValue() > 0 ? valueOf : null;
        final int intValue = num != null ? num.intValue() : DefaultLoadControl.DEFAULT_MAX_BUFFER_MS;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("TnplayerManager Aliyunplayer maxBufferingTime final:");
        sb3.append(intValue);
        V(new Function0() { // from class: ko.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit E;
                E = d0.E(d0.this, intValue);
                return E;
            }
        });
        this.f67060l = new AtomicBoolean(true);
    }

    public /* synthetic */ d0(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(d0 d0Var, int i11) {
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        com.transsion.player.orplayer.g a12 = new g.a(a11).b(new bo.d(null, false, 0, i11, 0, 0, 0, 0, 0L, 0, 0, false, false, false, false, false, null, 126967, null)).a();
        a12.setLooping(false);
        a12.setAutoPlay(false);
        a12.setPlayerListener(d0Var);
        d0Var.f67051c = a12;
        d0Var.N("init player:" + a12);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(d0 d0Var, com.transsion.player.orplayer.f fVar) {
        d0Var.f67056h.add(fVar);
        d0Var.N("addPlayerListener:" + fVar);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(d0 d0Var, mo.d dVar, int i11) {
        com.transsion.player.orplayer.g M = d0Var.M();
        if (M != null) {
            M.changeTrackSelection(dVar, i11);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(d0 d0Var) {
        com.transsion.player.orplayer.g M = d0Var.M();
        if (M != null) {
            M.clearScreen();
        }
        d0Var.N("clearScreen  mediaSource:" + d0Var.f67058j);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(d0 d0Var) {
        com.transsion.player.orplayer.g M = d0Var.M();
        if (M != null) {
            M.clearSurfaceOnly();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(d0 d0Var, CountDownLatch countDownLatch) {
        try {
            com.transsion.player.orplayer.g M = d0Var.M();
            if (M != null) {
                M.clearSurfaceOnly();
            }
        } finally {
            countDownLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(d0 d0Var, boolean z10) {
        com.transsion.player.orplayer.g M = d0Var.M();
        if (M != null) {
            M.enableHardwareDecoder(z10);
        }
        return Unit.f67184a;
    }

    private final com.transsion.player.orplayer.g M() {
        return this.f67051c;
    }

    private final void N(String str) {
        oo.e eVar = oo.e.f71197a;
        int hashCode = hashCode();
        com.transsion.player.orplayer.g gVar = this.f67051c;
        eVar.a("TnPlayer", "this@" + hashCode + "  player@" + (gVar != null ? gVar.hashCode() : 0) + "  " + str, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(Thread thread, Throwable th2) {
        oo.e.f71197a.c("TnPlayer", "uncaughtException:" + th2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(d0 d0Var) {
        com.transsion.player.orplayer.g M = d0Var.M();
        if (M != null) {
            M.pause();
        }
        d0Var.N("pause:" + d0Var.f67058j);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(d0 d0Var) {
        com.transsion.player.orplayer.g M = d0Var.M();
        if (M != null) {
            M.play();
        }
        d0Var.N("play:" + d0Var.f67058j);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(d0 d0Var) {
        com.transsion.player.orplayer.g M = d0Var.M();
        if (M != null) {
            M.prepare();
        }
        d0Var.N("prepare:" + d0Var.f67058j);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(d0 d0Var) {
        d0Var.f67059k = 0L;
        d0Var.f67060l.set(true);
        com.transsion.player.orplayer.g gVar = d0Var.f67051c;
        boolean z10 = l0.f67091a.o() && m0.f67107a.a(d0Var);
        if (z10) {
            d0Var.f67051c = null;
        }
        if (gVar != null) {
            gVar.clearSurfaceOnly();
        }
        if (gVar != null) {
            gVar.stop();
        }
        if (!z10) {
            if (gVar != null) {
                try {
                    gVar.reset();
                } catch (Throwable th2) {
                    d0Var.f67057i.set(false);
                    throw th2;
                }
            }
            if (gVar != null) {
                gVar.clearScreen();
            }
            d0Var.f67053e = null;
            d0Var.N("reset for reuse:" + d0Var.f67058j);
            d0Var.f67057i.set(false);
            return Unit.f67184a;
        }
        if (gVar != null) {
            gVar.release();
        }
        d0Var.f67053e = null;
        d0Var.f67050b.removeCallbacksAndMessages(null);
        HandlerThread handlerThread = d0Var.f67049a;
        if (handlerThread != null) {
            handlerThread.setUncaughtExceptionHandler(null);
        }
        HandlerThread handlerThread2 = d0Var.f67049a;
        if (handlerThread2 != null) {
            handlerThread2.quitSafely();
        }
        d0Var.N("release:" + d0Var.f67058j);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(d0 d0Var, com.transsion.player.orplayer.f fVar) {
        d0Var.f67056h.remove(fVar);
        d0Var.N("removePlayerListener:" + fVar);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(d0 d0Var) {
        d0Var.N("reset:" + d0Var.f67058j);
        d0Var.f67059k = 0L;
        d0Var.f67060l.set(true);
        com.transsion.player.orplayer.g M = d0Var.M();
        if (M != null) {
            M.clearScreen();
        }
        com.transsion.player.orplayer.g M2 = d0Var.M();
        if (M2 != null) {
            M2.reset();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Function0 function0) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(d0 d0Var, long j11) {
        com.transsion.player.orplayer.g M = d0Var.M();
        if (M != null) {
            M.seekTo(j11);
        }
        d0Var.N(" seekTo:" + j11 + "  mediaSource:" + d0Var.f67058j);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(d0 d0Var, boolean z10) {
        com.transsion.player.orplayer.g M = d0Var.M();
        if (M != null) {
            M.setAutoPlay(z10);
        }
        d0Var.N("setAutoPlay:" + z10 + "  mediaSource:" + d0Var.f67058j);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(d0 d0Var, ao.e eVar) {
        d0Var.f67058j = eVar;
        d0Var.f67052d = 0L;
        d0Var.f67059k = 0L;
        d0Var.f67060l.set(true);
        com.transsion.player.orplayer.g M = d0Var.M();
        if (M != null) {
            M.setDataSource(eVar);
        }
        d0Var.N("setDataSource:" + eVar);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(d0 d0Var, boolean z10) {
        com.transsion.player.orplayer.g M = d0Var.M();
        if (M != null) {
            M.setLooping(z10);
        }
        d0Var.N("setLooping:" + z10 + "  mediaSource:" + d0Var.f67058j);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(d0 d0Var, boolean z10) {
        com.transsion.player.orplayer.g M = d0Var.M();
        if (M != null) {
            M.setMute(z10);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(d0 d0Var, bo.d dVar) {
        com.transsion.player.orplayer.g M = d0Var.M();
        if (M != null) {
            M.setPlayerConfig(dVar);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(d0 d0Var, com.transsion.player.orplayer.f fVar) {
        d0Var.f67053e = fVar;
        d0Var.N("setPlayerListener:" + fVar);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(d0 d0Var, ScaleMode scaleMode) {
        com.transsion.player.orplayer.g M = d0Var.M();
        if (M != null) {
            M.setScaleMode(scaleMode);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(d0 d0Var, float f11) {
        com.transsion.player.orplayer.g M = d0Var.M();
        if (M != null) {
            M.setSpeed(f11);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(d0 d0Var, SurfaceView surfaceView) {
        com.transsion.player.orplayer.g M = d0Var.M();
        if (M != null) {
            M.setSurfaceView(surfaceView);
        }
        d0Var.N("setSurfaceView:" + surfaceView);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(d0 d0Var, TextureView textureView) {
        com.transsion.player.orplayer.g M = d0Var.M();
        if (M != null) {
            M.setTextureView(textureView);
        }
        d0Var.N("setTextureView:" + textureView);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(d0 d0Var, float f11) {
        com.transsion.player.orplayer.g M = d0Var.M();
        if (M != null) {
            M.setVolume(f11);
        }
        d0Var.N("setVolume:" + f11 + "  mediaSource:" + d0Var.f67058j);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(d0 d0Var) {
        com.transsion.player.orplayer.g M = d0Var.M();
        if (M != null) {
            M.stop();
        }
        d0Var.N("stop:" + d0Var.f67058j);
        return Unit.f67184a;
    }

    public final void J() {
        if (Intrinsics.c(Thread.currentThread(), this.f67050b.getLooper().getThread())) {
            com.transsion.player.orplayer.g M = M();
            if (M != null) {
                M.clearSurfaceOnly();
                return;
            }
            return;
        }
        HandlerThread handlerThread = this.f67049a;
        if (handlerThread == null || handlerThread.isAlive()) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            if (!this.f67050b.post(new Runnable() { // from class: ko.e
                @Override // java.lang.Runnable
                public final void run() {
                    d0.K(d0.this, countDownLatch);
                }
            })) {
                oo.e.f71197a.c("TnPlayer", "clearSurfaceSynchronously post failed", true);
                return;
            }
            try {
                if (countDownLatch.await(500L, TimeUnit.MILLISECONDS)) {
                    return;
                }
                oo.e.f71197a.c("TnPlayer", "clearSurfaceSynchronously timeout", true);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                oo.e.f71197a.c("TnPlayer", "clearSurfaceSynchronously interrupted", true);
            }
        }
    }

    public final void V(final Function0 action) {
        Intrinsics.h(action, "action");
        if (Intrinsics.c(Thread.currentThread(), this.f67050b.getLooper().getThread())) {
            action.invoke();
            return;
        }
        HandlerThread handlerThread = this.f67049a;
        if (handlerThread == null || handlerThread.isAlive()) {
            this.f67050b.post(new Runnable() { // from class: ko.l
                @Override // java.lang.Runnable
                public final void run() {
                    d0.W(Function0.this);
                }
            });
        } else {
            N("runOnPlayerThread handlerThread.isAlive:false");
        }
    }

    public final void Z(com.transsion.player.orplayer.e listener) {
        Intrinsics.h(listener, "listener");
        this.f67055g = listener;
        com.transsion.player.orplayer.g gVar = this.f67051c;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TnAliPlayer setBandwidthRedundancyListener :");
        sb2.append(gVar);
        com.transsion.player.orplayer.g gVar2 = this.f67051c;
        if (gVar2 instanceof com.transsion.player.orplayer.w) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ORPlayerImpl setBandwidthRedundancyListener :");
            sb3.append(gVar2);
            this.f67054f = Boolean.TRUE;
            com.transsion.player.orplayer.g gVar3 = this.f67051c;
            Intrinsics.f(gVar3, "null cannot be cast to non-null type com.transsion.player.orplayer.ORPlayerImpl");
            ((com.transsion.player.orplayer.w) gVar3).f0(this.f67055g);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public boolean addDataSource(ao.e mediaSource) {
        Intrinsics.h(mediaSource, "mediaSource");
        setDataSource(mediaSource);
        return true;
    }

    @Override // com.transsion.player.orplayer.g
    public void addPlayerListener(final com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        if (this.f67056h.contains(listener)) {
            return;
        }
        V(new Function0() { // from class: ko.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit F;
                F = d0.F(d0.this, listener);
                return F;
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void canNonSubscriberPlay(boolean z10, int i11, int i12, mo.d dVar) {
        f.a.a(this, z10, i11, i12, dVar);
    }

    @Override // com.transsion.player.orplayer.g
    public void changeTrackSelection(final mo.d mediaTrackGroup, final int i11) {
        Intrinsics.h(mediaTrackGroup, "mediaTrackGroup");
        V(new Function0() { // from class: ko.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit G;
                G = d0.G(d0.this, mediaTrackGroup, i11);
                return G;
            }
        });
    }

    @Override // com.transsion.player.orplayer.g
    public void clearScreen() {
        V(new Function0() { // from class: ko.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit H;
                H = d0.H(d0.this);
                return H;
            }
        });
    }

    @Override // com.transsion.player.orplayer.g
    public void clearSurfaceOnly() {
        V(new Function0() { // from class: ko.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit I;
                I = d0.I(d0.this);
                return I;
            }
        });
    }

    @Override // com.transsion.player.orplayer.g
    public ao.e currentMediaSource() {
        return g.b.f(this);
    }

    @Override // com.transsion.player.orplayer.g
    public void enableHardwareDecoder(final boolean z10) {
        V(new Function0() { // from class: ko.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit L;
                L = d0.L(d0.this, z10);
                return L;
            }
        });
    }

    @Override // com.transsion.player.orplayer.g
    public Pair getBitrate() {
        Pair bitrate;
        com.transsion.player.orplayer.g M = M();
        return (M == null || (bitrate = M.getBitrate()) == null) ? new Pair(0, 0) : bitrate;
    }

    @Override // com.transsion.player.orplayer.g
    public long getCurrentPosition() {
        com.transsion.player.orplayer.g M = M();
        if (M != null) {
            return M.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.g
    public mo.c getCurrentTracks() {
        com.transsion.player.orplayer.g M = M();
        if (M != null) {
            return M.getCurrentTracks();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.g
    public mo.b getCurrentVideoFormat() {
        com.transsion.player.orplayer.g M = M();
        if (M != null) {
            return M.getCurrentVideoFormat();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.g
    public Object getDownloadBitrate() {
        com.transsion.player.orplayer.g M = M();
        if (M != null) {
            return M.getDownloadBitrate();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.g
    public long getDuration() {
        return this.f67052d;
    }

    @Override // com.transsion.player.orplayer.g
    public int getVideoHeight() {
        com.transsion.player.orplayer.g M = M();
        return M != null ? M.getVideoHeight() : g.b.k(this);
    }

    @Override // com.transsion.player.orplayer.g
    public int getVideoWidth() {
        com.transsion.player.orplayer.g M = M();
        return M != null ? M.getVideoWidth() : g.b.l(this);
    }

    @Override // com.transsion.player.orplayer.g
    public Float getVolume() {
        com.transsion.player.orplayer.g M = M();
        if (M != null) {
            return M.getVolume();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public void initPlayer() {
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.initPlayer();
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).initPlayer();
        }
        N("initPlayer  mediaSource:" + this.f67058j);
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isComplete() {
        com.transsion.player.orplayer.g M = M();
        if (M != null) {
            return M.isComplete();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isLoading() {
        com.transsion.player.orplayer.g M = M();
        return M != null ? M.isLoading() : g.b.m(this);
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isMute() {
        com.transsion.player.orplayer.g M = M();
        if (M != null) {
            return M.isMute();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isPlaying() {
        com.transsion.player.orplayer.g M = M();
        if (M != null) {
            return M.isPlaying();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isPrepared() {
        com.transsion.player.orplayer.g M = M();
        return M != null ? M.isPrepared() : g.b.n(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void onAliyunDecodeErrorChangeSoftwareDecoder(ao.e eVar) {
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.onAliyunDecodeErrorChangeSoftwareDecoder(eVar);
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onAliyunDecodeErrorChangeSoftwareDecoder(eVar);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onBufferedPosition(long j11, ao.e eVar) {
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.onBufferedPosition(j11, eVar);
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onBufferedPosition(j11, eVar);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onCompletion(ao.e eVar) {
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.onCompletion(eVar);
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onCompletion(eVar);
        }
        N("onCompletion  mediaSource:" + eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onFocusChange(boolean z10) {
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.onFocusChange(z10);
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onFocusChange(z10);
        }
        N("onFocusChange mediaSource:" + this.f67058j);
    }

    @Override // com.transsion.player.orplayer.f
    public void onIsPlayingChanged(boolean z10) {
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.onIsPlayingChanged(z10);
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onIsPlayingChanged(z10);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingBegin(ao.e eVar) {
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.onLoadingBegin(eVar);
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onLoadingBegin(eVar);
        }
        N("onLoadingBegin  mediaSource:" + eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingEnd(ao.e eVar) {
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.onLoadingEnd(eVar);
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onLoadingEnd(eVar);
        }
        N("onLoadingEnd mediaSource:" + eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingProgress(int i11, float f11, ao.e eVar) {
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.onLoadingProgress(i11, f11, eVar);
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onLoadingProgress(i11, f11, eVar);
        }
        N("onLoadingProgress percent:" + i11 + " netSpeed:" + f11 + " mediaSource:" + eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoopingStart() {
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.onLoopingStart();
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onLoopingStart();
        }
        N("onLoopingStart  mediaSource:" + this.f67058j);
    }

    @Override // com.transsion.player.orplayer.f
    public void onMediaItemTransition(String str) {
        f.a.p(this, str);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayError(PlayError errorInfo, ao.e eVar) {
        Intrinsics.h(errorInfo, "errorInfo");
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.onPlayError(errorInfo, eVar);
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onPlayError(errorInfo, eVar);
        }
        this.f67060l.set(true);
        N("onPlayError  errorInfo:" + errorInfo + " mediaSource:" + eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerRelease(ao.e eVar) {
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.onPlayerRelease(eVar);
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onPlayerRelease(eVar);
        }
        N("onPlayerRelease  mediaSource:" + eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerReset() {
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.onPlayerReset();
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onPlayerReset();
        }
        N("onPlayerReset mediaSource:" + this.f67058j);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPrepare(ao.e eVar) {
        com.transsion.player.orplayer.g M = M();
        this.f67052d = M != null ? M.getDuration() : 0L;
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.onPrepare(eVar);
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onPrepare(eVar);
        }
        N("onPrepare  mediaSource:" + eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onProgress(long j11, ao.e eVar) {
        if (this.f67060l.get()) {
            com.transsion.player.orplayer.f fVar = this.f67053e;
            if (fVar != null) {
                fVar.onProgress(j11, eVar);
            }
            Iterator it = this.f67056h.iterator();
            while (it.hasNext()) {
                ((com.transsion.player.orplayer.f) it.next()).onProgress(j11, eVar);
            }
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onRenderFirstFrame() {
        N("onRenderFirstFrame  mediaSource:" + this.f67058j);
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.onRenderFirstFrame();
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onRenderFirstFrame();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onSetDataSource() {
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.onSetDataSource();
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onSetDataSource();
        }
        N("onSetDataSource  mediaSource:" + this.f67058j);
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksAudioBitrateChange(int i11) {
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.onTracksAudioBitrateChange(i11);
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onTracksAudioBitrateChange(i11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksChange(mo.c cVar) {
        f.a.D(this, cVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksVideoBitrateChange(int i11) {
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.onTracksVideoBitrateChange(i11);
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onTracksVideoBitrateChange(i11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoPause(ao.e eVar) {
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.onVideoPause(eVar);
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onVideoPause(eVar);
        }
        N("onVideoPause  mediaSource:" + eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoSizeChanged(int i11, int i12) {
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.onVideoSizeChanged(i11, i12);
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onVideoSizeChanged(i11, i12);
        }
        N("onVideoSizeChanged width:" + i11 + " height:" + i12 + " mediaSource:" + this.f67058j);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoStart(ao.e eVar) {
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.onVideoStart(eVar);
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onVideoStart(eVar);
        }
        N("onVideoStart  mediaSource:" + eVar);
    }

    @Override // com.transsion.player.orplayer.g
    public void pause() {
        V(new Function0() { // from class: ko.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit P;
                P = d0.P(d0.this);
                return P;
            }
        });
    }

    @Override // com.transsion.player.orplayer.g
    public void play() {
        V(new Function0() { // from class: ko.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit Q;
                Q = d0.Q(d0.this);
                return Q;
            }
        });
    }

    @Override // com.transsion.player.orplayer.g
    public void prepare() {
        V(new Function0() { // from class: ko.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit R;
                R = d0.R(d0.this);
                return R;
            }
        });
    }

    @Override // com.transsion.player.orplayer.g
    public void release() {
        if (this.f67057i.compareAndSet(false, true)) {
            this.f67052d = 0L;
            V(new Function0() { // from class: ko.a0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit S;
                    S = d0.S(d0.this);
                    return S;
                }
            });
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void release(String str) {
        g.b.o(this, str);
    }

    @Override // com.transsion.player.orplayer.g
    public boolean removeDataSource(ao.e eVar) {
        return g.b.p(this, eVar);
    }

    @Override // com.transsion.player.orplayer.g
    public void removePlayerListener(final com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        V(new Function0() { // from class: ko.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit T;
                T = d0.T(d0.this, listener);
                return T;
            }
        });
    }

    @Override // com.transsion.player.orplayer.g
    public boolean requestForce() {
        return g.b.r(this);
    }

    @Override // com.transsion.player.orplayer.g
    public void reset() {
        V(new Function0() { // from class: ko.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit U;
                U = d0.U(d0.this);
                return U;
            }
        });
    }

    @Override // com.transsion.player.orplayer.g
    public void seekTo(final long j11) {
        if (this.f67060l.compareAndSet(true, false)) {
            V(new Function0() { // from class: ko.b0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit X;
                    X = d0.X(d0.this, j11);
                    return X;
                }
            });
            this.f67059k = 0L;
            return;
        }
        this.f67059k = j11;
        N("seekTo:" + j11 + "  waiting.... mediaSource:" + this.f67058j);
    }

    @Override // com.transsion.player.orplayer.g
    public void seekTo(String str, long j11) {
        g.b.s(this, str, j11);
    }

    @Override // com.transsion.player.orplayer.g
    public void setAutoPlay(final boolean z10) {
        V(new Function0() { // from class: ko.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit Y;
                Y = d0.Y(d0.this, z10);
                return Y;
            }
        });
    }

    @Override // com.transsion.player.orplayer.g
    public void setDataSource(final ao.e mediaSource) {
        Intrinsics.h(mediaSource, "mediaSource");
        V(new Function0() { // from class: ko.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit a02;
                a02 = d0.a0(d0.this, mediaSource);
                return a02;
            }
        });
    }

    @Override // com.transsion.player.orplayer.g
    public void setLooping(final boolean z10) {
        V(new Function0() { // from class: ko.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit b02;
                b02 = d0.b0(d0.this, z10);
                return b02;
            }
        });
    }

    @Override // com.transsion.player.orplayer.g
    public void setMute(final boolean z10) {
        V(new Function0() { // from class: ko.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit c02;
                c02 = d0.c0(d0.this, z10);
                return c02;
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void setOnSeekCompleteListener() {
        f.a.K(this);
        this.f67060l.set(true);
        com.transsion.player.orplayer.f fVar = this.f67053e;
        if (fVar != null) {
            fVar.setOnSeekCompleteListener();
        }
        Iterator it = this.f67056h.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).setOnSeekCompleteListener();
        }
        N("setOnSeekCompleteListener nextSeekTo:" + this.f67059k + " mediaSource:" + this.f67058j);
        long j11 = this.f67059k;
        if (j11 > 0) {
            seekTo(j11);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setPlayerConfig(final bo.d vodConfig) {
        Intrinsics.h(vodConfig, "vodConfig");
        V(new Function0() { // from class: ko.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit d02;
                d02 = d0.d0(d0.this, vodConfig);
                return d02;
            }
        });
    }

    @Override // com.transsion.player.orplayer.g
    public void setPlayerListener(final com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        V(new Function0() { // from class: ko.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit e02;
                e02 = d0.e0(d0.this, listener);
                return e02;
            }
        });
    }

    @Override // com.transsion.player.orplayer.g
    public void setScaleMode(final ScaleMode scaleMode) {
        Intrinsics.h(scaleMode, "scaleMode");
        V(new Function0() { // from class: ko.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit f02;
                f02 = d0.f0(d0.this, scaleMode);
                return f02;
            }
        });
    }

    @Override // com.transsion.player.orplayer.g
    public void setSpeed(final float f11) {
        V(new Function0() { // from class: ko.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit g02;
                g02 = d0.g0(d0.this, f11);
                return g02;
            }
        });
    }

    @Override // com.transsion.player.orplayer.g
    public void setSurfaceView(final SurfaceView surfaceView) {
        V(new Function0() { // from class: ko.c0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit h02;
                h02 = d0.h0(d0.this, surfaceView);
                return h02;
            }
        });
    }

    @Override // com.transsion.player.orplayer.g
    public void setTextureView(final TextureView textureView) {
        V(new Function0() { // from class: ko.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit i02;
                i02 = d0.i0(d0.this, textureView);
                return i02;
            }
        });
    }

    @Override // com.transsion.player.orplayer.g
    public void setVipResolution(boolean z10, int i11) {
    }

    @Override // com.transsion.player.orplayer.g
    public void setVolume(final float f11) {
        V(new Function0() { // from class: ko.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit j02;
                j02 = d0.j0(d0.this, f11);
                return j02;
            }
        });
    }

    @Override // com.transsion.player.orplayer.g
    public void stop() {
        V(new Function0() { // from class: ko.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit k02;
                k02 = d0.k0(d0.this);
                return k02;
            }
        });
    }
}
