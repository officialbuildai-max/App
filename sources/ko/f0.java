package ko;

import android.app.Application;
import android.view.SurfaceView;
import android.view.TextureView;
import com.blankj.utilcode.util.Utils;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.g;
import com.transsion.player.p007enum.ScaleMode;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class f0 implements com.transsion.player.orplayer.g {

    /* renamed from: r, reason: collision with root package name */
    public static final a f67064r = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private volatile com.transsion.player.orplayer.g f67065a;

    /* renamed from: b, reason: collision with root package name */
    private volatile ao.e f67066b;

    /* renamed from: c, reason: collision with root package name */
    private SurfaceView f67067c;

    /* renamed from: d, reason: collision with root package name */
    private TextureView f67068d;

    /* renamed from: e, reason: collision with root package name */
    private com.transsion.player.orplayer.f f67069e;

    /* renamed from: g, reason: collision with root package name */
    private Float f67071g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f67072h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f67073i;

    /* renamed from: j, reason: collision with root package name */
    private bo.d f67074j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f67075k;

    /* renamed from: o, reason: collision with root package name */
    private boolean f67079o;

    /* renamed from: p, reason: collision with root package name */
    private long f67080p;

    /* renamed from: f, reason: collision with root package name */
    private CopyOnWriteArrayList f67070f = new CopyOnWriteArrayList();

    /* renamed from: l, reason: collision with root package name */
    private boolean f67076l = true;

    /* renamed from: m, reason: collision with root package name */
    private float f67077m = 1.0f;

    /* renamed from: n, reason: collision with root package name */
    private ScaleMode f67078n = ScaleMode.SCALE_ASPECT_FIT;

    /* renamed from: q, reason: collision with root package name */
    private final ko.a f67081q = new ko.a();

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void c() {
        ao.e eVar = this.f67066b;
        if (eVar != null) {
            g();
            int j11 = l0.f67091a.j();
            androidx.media3.common.util.u.b("VideoConfig", "Tnplayer new player playerBufferingTime:" + j11);
            if (!i(eVar)) {
                if (this.f67065a instanceof d0) {
                    return;
                }
                d();
                com.transsion.player.orplayer.g gVar = this.f67065a;
                if (gVar != null) {
                    gVar.release();
                }
                m0 m0Var = m0.f67107a;
                Application a11 = Utils.a();
                Intrinsics.g(a11, "getApp(...)");
                d0 b11 = m0Var.b(a11);
                f(b11);
                this.f67065a = b11;
                return;
            }
            if (this.f67065a instanceof co.h) {
                return;
            }
            d();
            com.transsion.player.orplayer.g gVar2 = this.f67065a;
            if (gVar2 != null) {
                gVar2.release();
            }
            co.m mVar = new co.m(314572800L, Integer.valueOf(j11));
            if (j11 > 0) {
                m0 m0Var2 = m0.f67107a;
                Application a12 = Utils.a();
                Intrinsics.g(a12, "getApp(...)");
                co.h d11 = m0Var2.d(a12, mVar);
                f(d11);
                this.f67065a = d11;
                return;
            }
            m0 m0Var3 = m0.f67107a;
            Application a13 = Utils.a();
            Intrinsics.g(a13, "getApp(...)");
            co.h c11 = m0Var3.c(a13);
            f(c11);
            this.f67065a = c11;
        }
    }

    private final void d() {
        com.transsion.player.orplayer.g gVar = this.f67065a;
        d0 d0Var = gVar instanceof d0 ? (d0) gVar : null;
        if (d0Var != null) {
            d0Var.J();
        }
    }

    private final int e() {
        return l0.f67091a.r();
    }

    private final void f(com.transsion.player.orplayer.g gVar) {
        if (gVar == null) {
            return;
        }
        gVar.setMute(this.f67075k);
        bo.d dVar = this.f67074j;
        if (dVar != null) {
            gVar.setPlayerConfig(dVar);
        }
        Float f11 = this.f67071g;
        if (f11 != null) {
            gVar.setVolume(f11.floatValue());
        }
        gVar.setLooping(this.f67073i);
        gVar.setAutoPlay(this.f67072h);
        gVar.setSpeed(this.f67077m);
        gVar.enableHardwareDecoder(this.f67076l);
        SurfaceView surfaceView = this.f67067c;
        if (surfaceView != null) {
            gVar.setSurfaceView(surfaceView);
        }
        TextureView textureView = this.f67068d;
        if (textureView != null) {
            gVar.setTextureView(textureView);
        }
        com.transsion.player.orplayer.f fVar = this.f67069e;
        if (fVar != null) {
            gVar.setPlayerListener(fVar);
        }
        for (com.transsion.player.orplayer.f fVar2 : this.f67070f) {
            Intrinsics.e(fVar2);
            gVar.addPlayerListener(fVar2);
        }
        gVar.setScaleMode(this.f67078n);
    }

    private final void g() {
        this.f67079o = false;
        this.f67080p = 0L;
    }

    private final boolean i(ao.e eVar) {
        return e() == 1 || eVar.n() || eVar.c();
    }

    @Override // com.transsion.player.orplayer.g
    public boolean addDataSource(ao.e eVar) {
        return g.b.a(this, eVar);
    }

    @Override // com.transsion.player.orplayer.g
    public void addPlayerListener(com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        this.f67081q.a(listener);
    }

    @Override // com.transsion.player.orplayer.g
    public void changeTrackSelection(mo.d mediaTrackGroup, int i11) {
        Intrinsics.h(mediaTrackGroup, "mediaTrackGroup");
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.changeTrackSelection(mediaTrackGroup, i11);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void clearScreen() {
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.clearScreen();
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void clearSurfaceOnly() {
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.clearSurfaceOnly();
        }
        this.f67067c = null;
        this.f67068d = null;
    }

    @Override // com.transsion.player.orplayer.g
    public ao.e currentMediaSource() {
        return this.f67066b;
    }

    @Override // com.transsion.player.orplayer.g
    public void enableHardwareDecoder(boolean z10) {
        this.f67076l = z10;
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.enableHardwareDecoder(z10);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public Pair getBitrate() {
        Pair bitrate;
        com.transsion.player.orplayer.g gVar = this.f67065a;
        return (gVar == null || (bitrate = gVar.getBitrate()) == null) ? new Pair(0, 0) : bitrate;
    }

    @Override // com.transsion.player.orplayer.g
    public long getCurrentPosition() {
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            return gVar.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.g
    public mo.c getCurrentTracks() {
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            return gVar.getCurrentTracks();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.g
    public mo.b getCurrentVideoFormat() {
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            return gVar.getCurrentVideoFormat();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.g
    public Object getDownloadBitrate() {
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            return gVar.getDownloadBitrate();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.g
    public long getDuration() {
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            return gVar.getDuration();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.g
    public int getVideoHeight() {
        com.transsion.player.orplayer.g gVar = this.f67065a;
        return gVar != null ? gVar.getVideoHeight() : g.b.k(this);
    }

    @Override // com.transsion.player.orplayer.g
    public int getVideoWidth() {
        com.transsion.player.orplayer.g gVar = this.f67065a;
        return gVar != null ? gVar.getVideoWidth() : g.b.l(this);
    }

    @Override // com.transsion.player.orplayer.g
    public Float getVolume() {
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            return gVar.getVolume();
        }
        return null;
    }

    public final void h(com.transsion.player.orplayer.e listener) {
        Intrinsics.h(listener, "listener");
        androidx.media3.common.util.u.b("onBandwidthRedundancy", "Tnplayer init onBandwidthRedundancyRate");
        androidx.media3.common.util.u.b("onBandwidthRedundancy", "mOrPlayer setBandwidthRedundancyListener :" + this.f67065a);
        if (this.f67065a instanceof d0) {
            androidx.media3.common.util.u.b("onBandwidthRedundancy", "Tnplayer init TnAliPlayer");
            com.transsion.player.orplayer.g gVar = this.f67065a;
            Intrinsics.f(gVar, "null cannot be cast to non-null type com.transsion.player.orplayer.global.TnAliPlayer");
            ((d0) gVar).Z(listener);
        }
        if (this.f67065a instanceof co.h) {
            androidx.media3.common.util.u.b("onBandwidthRedundancy", "Tnplayer init ORExoPlayer");
            com.transsion.player.orplayer.g gVar2 = this.f67065a;
            Intrinsics.f(gVar2, "null cannot be cast to non-null type com.transsion.player.exo.ORExoPlayer");
            ((co.h) gVar2).l0(listener);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isComplete() {
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            return gVar.isComplete();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isLoading() {
        com.transsion.player.orplayer.g gVar = this.f67065a;
        return gVar != null ? gVar.isLoading() : g.b.m(this);
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isMute() {
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            return gVar.isMute();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isPlaying() {
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            return gVar.isPlaying();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isPrepared() {
        com.transsion.player.orplayer.g gVar = this.f67065a;
        return gVar != null ? gVar.isPrepared() : g.b.n(this);
    }

    @Override // com.transsion.player.orplayer.g
    public void pause() {
        l0.f67091a.u(this, this.f67066b);
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.pause();
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void play() {
        l0 l0Var = l0.f67091a;
        l0Var.z(this, MediaItem.MUSIC_FLOAT_STATE_PLAY);
        l0Var.v(this, this.f67066b);
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.play();
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void prepare() {
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.prepare();
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void release() {
        g();
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.release();
        }
        this.f67065a = null;
        this.f67069e = null;
        this.f67067c = null;
        this.f67068d = null;
        l0.f67091a.x(this);
    }

    @Override // com.transsion.player.orplayer.g
    public void release(String str) {
        release();
    }

    @Override // com.transsion.player.orplayer.g
    public boolean removeDataSource(ao.e eVar) {
        return g.b.p(this, eVar);
    }

    @Override // com.transsion.player.orplayer.g
    public void removePlayerListener(com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        this.f67081q.d(listener);
    }

    @Override // com.transsion.player.orplayer.g
    public boolean requestForce() {
        return g.b.r(this);
    }

    @Override // com.transsion.player.orplayer.g
    public void reset() {
        g();
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.reset();
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void seekTo(long j11) {
        MediaItem i11;
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.seekTo(j11);
        }
        ao.e eVar = this.f67066b;
        if (eVar != null && (i11 = eVar.i()) != null) {
            i11.setPosition(Long.valueOf(j11));
        }
        l0.f67091a.B(this, this.f67066b);
    }

    @Override // com.transsion.player.orplayer.g
    public void seekTo(String uuid, long j11) {
        Intrinsics.h(uuid, "uuid");
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.seekTo(uuid, j11);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setAutoPlay(boolean z10) {
        this.f67072h = z10;
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.setAutoPlay(z10);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setDataSource(ao.e mediaSource) {
        Intrinsics.h(mediaSource, "mediaSource");
        l0.f67091a.z(this, "setDataSource");
        this.f67066b = mediaSource;
        c();
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.addPlayerListener(this.f67081q);
        }
        com.transsion.player.orplayer.g gVar2 = this.f67065a;
        if (gVar2 != null) {
            gVar2.setDataSource(mediaSource);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setLooping(boolean z10) {
        this.f67073i = z10;
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.setLooping(z10);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setMute(boolean z10) {
        this.f67075k = z10;
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.setMute(z10);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setPlayerConfig(bo.d vodConfig) {
        Intrinsics.h(vodConfig, "vodConfig");
        this.f67074j = vodConfig;
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.setPlayerConfig(vodConfig);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setPlayerListener(com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        this.f67069e = listener;
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.setPlayerListener(listener);
        }
        androidx.media3.common.util.u.b("onBandwidthRedundancy", "mOrPlayer setPlayerListener :" + this.f67065a);
    }

    @Override // com.transsion.player.orplayer.g
    public void setScaleMode(ScaleMode scaleMode) {
        Intrinsics.h(scaleMode, "scaleMode");
        this.f67078n = scaleMode;
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.setScaleMode(scaleMode);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setSpeed(float f11) {
        this.f67077m = f11;
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.setSpeed(f11);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setSurfaceView(SurfaceView surfaceView) {
        this.f67068d = null;
        this.f67067c = surfaceView;
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.setSurfaceView(surfaceView);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setTextureView(TextureView textureView) {
        this.f67067c = null;
        this.f67068d = textureView;
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.setTextureView(textureView);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setVipResolution(boolean z10, int i11) {
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.setVipResolution(z10, i11);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setVolume(float f11) {
        this.f67071g = Float.valueOf(f11);
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.setVolume(f11);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void stop() {
        g();
        com.transsion.player.orplayer.g gVar = this.f67065a;
        if (gVar != null) {
            gVar.stop();
        }
    }
}
