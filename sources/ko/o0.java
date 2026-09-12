package ko;

import android.view.SurfaceView;
import android.view.TextureView;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.g;
import com.transsion.player.p007enum.ScaleMode;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class o0 implements com.transsion.player.orplayer.g {

    /* renamed from: o, reason: collision with root package name */
    public static final a f67114o = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private volatile com.transsion.player.orplayer.g f67115a;

    /* renamed from: b, reason: collision with root package name */
    private volatile ao.e f67116b;

    /* renamed from: c, reason: collision with root package name */
    private SurfaceView f67117c;

    /* renamed from: d, reason: collision with root package name */
    private TextureView f67118d;

    /* renamed from: e, reason: collision with root package name */
    private com.transsion.player.orplayer.f f67119e;

    /* renamed from: g, reason: collision with root package name */
    private Float f67121g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f67122h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f67123i;

    /* renamed from: j, reason: collision with root package name */
    private bo.d f67124j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f67125k;

    /* renamed from: f, reason: collision with root package name */
    private CopyOnWriteArrayList f67120f = new CopyOnWriteArrayList();

    /* renamed from: l, reason: collision with root package name */
    private boolean f67126l = true;

    /* renamed from: m, reason: collision with root package name */
    private float f67127m = 1.0f;

    /* renamed from: n, reason: collision with root package name */
    private ScaleMode f67128n = ScaleMode.SCALE_ASPECT_FIT;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(o0 o0Var) {
        com.transsion.player.orplayer.g gVar = o0Var.f67115a;
        if (gVar != null) {
            gVar.stop();
            gVar.reset();
            gVar.enableHardwareDecoder(o0Var.f67126l);
            bo.d dVar = o0Var.f67124j;
            if (dVar != null) {
                gVar.setPlayerConfig(dVar);
            }
            gVar.setMute(o0Var.f67125k);
            Float f11 = o0Var.f67121g;
            if (f11 != null) {
                gVar.setVolume(f11.floatValue());
            }
            gVar.setSpeed(o0Var.f67127m);
            gVar.setLooping(o0Var.f67123i);
            gVar.setAutoPlay(o0Var.f67122h);
            SurfaceView surfaceView = o0Var.f67117c;
            if (surfaceView != null) {
                gVar.setSurfaceView(surfaceView);
            }
            TextureView textureView = o0Var.f67118d;
            if (textureView != null) {
                gVar.setTextureView(textureView);
            }
            com.transsion.player.orplayer.f fVar = o0Var.f67119e;
            if (fVar != null) {
                gVar.setPlayerListener(fVar);
            }
            for (com.transsion.player.orplayer.f fVar2 : o0Var.f67120f) {
                Intrinsics.e(fVar2);
                gVar.addPlayerListener(fVar2);
            }
            gVar.setScaleMode(o0Var.f67128n);
            ao.e eVar = o0Var.f67116b;
            if (eVar != null) {
                gVar.setDataSource(eVar);
            }
        }
        return Unit.f67184a;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean addDataSource(ao.e eVar) {
        return g.b.a(this, eVar);
    }

    @Override // com.transsion.player.orplayer.g
    public void addPlayerListener(com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        if (this.f67120f.contains(listener)) {
            return;
        }
        this.f67120f.add(listener);
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.addPlayerListener(listener);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void changeTrackSelection(mo.d mediaTrackGroup, int i11) {
        Intrinsics.h(mediaTrackGroup, "mediaTrackGroup");
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.changeTrackSelection(mediaTrackGroup, i11);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void clearScreen() {
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.clearScreen();
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void clearSurfaceOnly() {
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.clearSurfaceOnly();
        }
        this.f67117c = null;
        this.f67118d = null;
    }

    @Override // com.transsion.player.orplayer.g
    public ao.e currentMediaSource() {
        return this.f67116b;
    }

    public final void d(boolean z10) {
        com.transsion.player.orplayer.f fVar = this.f67119e;
        if (fVar != null) {
            fVar.onFocusChange(z10);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void enableHardwareDecoder(boolean z10) {
        this.f67126l = z10;
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.enableHardwareDecoder(z10);
        }
    }

    public final void f(com.transsion.player.orplayer.g gVar) {
        this.f67115a = gVar;
    }

    @Override // com.transsion.player.orplayer.g
    public Pair getBitrate() {
        Pair bitrate;
        com.transsion.player.orplayer.g gVar = this.f67115a;
        return (gVar == null || (bitrate = gVar.getBitrate()) == null) ? new Pair(0, 0) : bitrate;
    }

    @Override // com.transsion.player.orplayer.g
    public long getCurrentPosition() {
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            return gVar.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.g
    public mo.c getCurrentTracks() {
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            return gVar.getCurrentTracks();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.g
    public mo.b getCurrentVideoFormat() {
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            return gVar.getCurrentVideoFormat();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.g
    public Object getDownloadBitrate() {
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            return gVar.getDownloadBitrate();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.g
    public long getDuration() {
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            return gVar.getDuration();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.g
    public int getVideoHeight() {
        com.transsion.player.orplayer.g gVar = this.f67115a;
        return gVar != null ? gVar.getVideoHeight() : g.b.k(this);
    }

    @Override // com.transsion.player.orplayer.g
    public int getVideoWidth() {
        com.transsion.player.orplayer.g gVar = this.f67115a;
        return gVar != null ? gVar.getVideoWidth() : g.b.l(this);
    }

    @Override // com.transsion.player.orplayer.g
    public Float getVolume() {
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            return gVar.getVolume();
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isComplete() {
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            return gVar.isComplete();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isLoading() {
        com.transsion.player.orplayer.g gVar = this.f67115a;
        return gVar != null ? gVar.isLoading() : g.b.m(this);
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isMute() {
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            return gVar.isMute();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isPlaying() {
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            return gVar.isPlaying();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isPrepared() {
        com.transsion.player.orplayer.g gVar = this.f67115a;
        return gVar != null ? gVar.isPrepared() : g.b.n(this);
    }

    @Override // com.transsion.player.orplayer.g
    public void pause() {
        l0.f67091a.u(this, this.f67116b);
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.pause();
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void play() {
        l0 l0Var = l0.f67091a;
        l0Var.v(this, this.f67116b);
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            l0Var.z(gVar, MediaItem.MUSIC_FLOAT_STATE_PLAY);
        }
        com.transsion.player.orplayer.g gVar2 = this.f67115a;
        if (gVar2 != null) {
            gVar2.play();
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void prepare() {
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.prepare();
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void release() {
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.release();
        }
        this.f67115a = null;
        this.f67119e = null;
        this.f67117c = null;
        this.f67118d = null;
        l0.f67091a.x(this);
    }

    @Override // com.transsion.player.orplayer.g
    public void release(String str) {
        if (str != null && str.length() != 0) {
            ao.e eVar = this.f67116b;
            if (!Intrinsics.c(eVar != null ? eVar.e() : null, str)) {
                return;
            }
        }
        release();
    }

    @Override // com.transsion.player.orplayer.g
    public boolean removeDataSource(ao.e eVar) {
        return g.b.p(this, eVar);
    }

    @Override // com.transsion.player.orplayer.g
    public void removePlayerListener(com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        this.f67120f.remove(listener);
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.removePlayerListener(listener);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public boolean requestForce() {
        if (this.f67115a != null) {
            return false;
        }
        l0.f67091a.A(this);
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar == null) {
            return true;
        }
        Function0 function0 = new Function0() { // from class: ko.n0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit e11;
                e11 = o0.e(o0.this);
                return e11;
            }
        };
        if (gVar instanceof d0) {
            ((d0) gVar).V(function0);
            return true;
        }
        function0.invoke();
        return true;
    }

    @Override // com.transsion.player.orplayer.g
    public void reset() {
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.reset();
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void seekTo(long j11) {
        MediaItem i11;
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.seekTo(j11);
        }
        ao.e eVar = this.f67116b;
        if (eVar != null && (i11 = eVar.i()) != null) {
            i11.setPosition(Long.valueOf(j11));
        }
        l0.f67091a.B(this, this.f67116b);
    }

    @Override // com.transsion.player.orplayer.g
    public void seekTo(String uuid, long j11) {
        Intrinsics.h(uuid, "uuid");
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.seekTo(uuid, j11);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setAutoPlay(boolean z10) {
        this.f67122h = z10;
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.setAutoPlay(z10);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setDataSource(ao.e mediaSource) {
        com.transsion.player.orplayer.g gVar;
        Intrinsics.h(mediaSource, "mediaSource");
        this.f67116b = mediaSource;
        com.transsion.player.orplayer.g gVar2 = this.f67115a;
        if (gVar2 != null) {
            l0.f67091a.z(gVar2, "setDataSource");
        }
        if (requestForce() || (gVar = this.f67115a) == null) {
            return;
        }
        gVar.setDataSource(mediaSource);
    }

    @Override // com.transsion.player.orplayer.g
    public void setLooping(boolean z10) {
        this.f67123i = z10;
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.setLooping(z10);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setMute(boolean z10) {
        this.f67125k = z10;
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.setMute(z10);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setPlayerConfig(bo.d vodConfig) {
        Intrinsics.h(vodConfig, "vodConfig");
        this.f67124j = vodConfig;
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.setPlayerConfig(vodConfig);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setPlayerListener(com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        this.f67119e = listener;
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.setPlayerListener(listener);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setScaleMode(ScaleMode scaleMode) {
        Intrinsics.h(scaleMode, "scaleMode");
        this.f67128n = scaleMode;
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.setScaleMode(scaleMode);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setSpeed(float f11) {
        this.f67127m = f11;
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.setSpeed(f11);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setSurfaceView(SurfaceView surfaceView) {
        this.f67118d = null;
        this.f67117c = surfaceView;
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.setSurfaceView(surfaceView);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setTextureView(TextureView textureView) {
        this.f67117c = null;
        this.f67118d = textureView;
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.setTextureView(textureView);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setVipResolution(boolean z10, int i11) {
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.setVipResolution(z10, i11);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setVolume(float f11) {
        this.f67121g = Float.valueOf(f11);
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.setVolume(f11);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void stop() {
        com.transsion.player.orplayer.g gVar = this.f67115a;
        if (gVar != null) {
            gVar.stop();
        }
    }
}
