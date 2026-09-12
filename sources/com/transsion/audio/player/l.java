package com.transsion.audio.player;

import android.content.Context;
import android.view.SurfaceView;
import android.view.TextureView;
import com.aliyun.player.AliPlayer;
import com.aliyun.player.AliPlayerFactory;
import com.aliyun.player.IPlayer;
import com.aliyun.player.bean.ErrorCode;
import com.aliyun.player.bean.ErrorInfo;
import com.aliyun.player.bean.InfoBean;
import com.aliyun.player.bean.InfoCode;
import com.aliyun.player.nativeclass.CacheConfig;
import com.aliyun.player.nativeclass.TrackInfo;
import com.aliyun.player.source.UrlSource;
import com.blankj.utilcode.util.Utils;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import com.transsion.player.orplayer.g;
import com.transsion.player.p007enum.ScaleMode;
import java.io.File;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes5.dex */
public final class l implements com.transsion.player.orplayer.g {

    /* renamed from: a, reason: collision with root package name */
    private final String f42975a = "OrAudioPlayer";

    /* renamed from: b, reason: collision with root package name */
    private AliPlayer f42976b;

    /* renamed from: c, reason: collision with root package name */
    private com.transsion.player.orplayer.c f42977c;

    /* renamed from: d, reason: collision with root package name */
    private com.transsion.player.orplayer.f f42978d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f42979e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f42980f;

    /* loaded from: classes5.dex */
    public static final class a implements com.transsion.player.orplayer.d {
        a() {
        }

        @Override // com.transsion.player.orplayer.d
        public boolean isMute() {
            AliPlayer aliPlayer = l.this.f42976b;
            if (aliPlayer != null) {
                return aliPlayer.isMute();
            }
            return false;
        }

        @Override // com.transsion.player.orplayer.d
        public void pause() {
            AliPlayer aliPlayer = l.this.f42976b;
            if (aliPlayer != null) {
                aliPlayer.pause();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void play() {
            AliPlayer aliPlayer = l.this.f42976b;
            if (aliPlayer != null) {
                aliPlayer.start();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void setVolume(float f11) {
            AliPlayer aliPlayer = l.this.f42976b;
            if (aliPlayer != null) {
                aliPlayer.setVolume(f11);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements IPlayer.OnLoadingStatusListener {
        b() {
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingBegin() {
            a.C0856a.f(lg.a.f68962a, l.this.f42975a, "onLoadingBegin--->", false, 4, null);
            com.transsion.player.orplayer.f fVar = l.this.f42978d;
            if (fVar != null) {
                f.a.j(fVar, null, 1, null);
            }
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingEnd() {
            a.C0856a.f(lg.a.f68962a, l.this.f42975a, "onLoadingEnd----->", false, 4, null);
            com.transsion.player.orplayer.f fVar = l.this.f42978d;
            if (fVar != null) {
                f.a.l(fVar, null, 1, null);
            }
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingProgress(int i11, float f11) {
            a.C0856a.f(lg.a.f68962a, l.this.f42975a, "onLoadingProgress percent:" + i11 + ",netSpeed:" + f11, false, 4, null);
            com.transsion.player.orplayer.f fVar = l.this.f42978d;
            if (fVar != null) {
                f.a.n(fVar, i11, f11, null, 4, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements IPlayer.OnTrackChangedListener {
        c() {
        }

        @Override // com.aliyun.player.IPlayer.OnTrackChangedListener
        public void onChangedFail(TrackInfo trackInfo, ErrorInfo errorInfo) {
        }

        @Override // com.aliyun.player.IPlayer.OnTrackChangedListener
        public void onChangedSuccess(TrackInfo trackInfo) {
        }
    }

    public l(Context context) {
        o(context);
    }

    private final void A() {
        if (bo.b.f16721a.c()) {
            CacheConfig cacheConfig = new CacheConfig();
            cacheConfig.mEnable = true;
            cacheConfig.mMaxDurationS = 1200L;
            File externalCacheDir = Utils.a().getExternalCacheDir();
            String absolutePath = externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null;
            cacheConfig.mDir = absolutePath + File.separator + "video_cache";
            cacheConfig.mMaxSizeMB = 50;
            AliPlayer aliPlayer = this.f42976b;
            if (aliPlayer != null) {
                aliPlayer.setCacheConfig(cacheConfig);
            }
        }
    }

    private final void o(Context context) {
        if (this.f42976b == null) {
            AliPlayer createAliPlayer = AliPlayerFactory.createAliPlayer(context);
            createAliPlayer.setTraceId(ih.b.f65364a.h());
            this.f42976b = createAliPlayer;
            p();
            A();
            r();
        }
    }

    private final void p() {
        this.f42977c = new com.transsion.player.orplayer.c(new a(), new Function1() { // from class: com.transsion.audio.player.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit q11;
                q11 = l.q(l.this, ((Boolean) obj).booleanValue());
                return q11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(l lVar, boolean z10) {
        com.transsion.player.orplayer.f fVar = lVar.f42978d;
        if (fVar != null) {
            fVar.onFocusChange(z10);
        }
        return Unit.f67184a;
    }

    private final void r() {
        AliPlayer aliPlayer = this.f42976b;
        if (aliPlayer != null) {
            aliPlayer.setOnCompletionListener(new IPlayer.OnCompletionListener() { // from class: com.transsion.audio.player.d
                @Override // com.aliyun.player.IPlayer.OnCompletionListener
                public final void onCompletion() {
                    l.s();
                }
            });
        }
        AliPlayer aliPlayer2 = this.f42976b;
        if (aliPlayer2 != null) {
            aliPlayer2.setOnErrorListener(new IPlayer.OnErrorListener() { // from class: com.transsion.audio.player.e
                @Override // com.aliyun.player.IPlayer.OnErrorListener
                public final void onError(ErrorInfo errorInfo) {
                    l.t(l.this, errorInfo);
                }
            });
        }
        AliPlayer aliPlayer3 = this.f42976b;
        if (aliPlayer3 != null) {
            aliPlayer3.setOnPreparedListener(new IPlayer.OnPreparedListener() { // from class: com.transsion.audio.player.f
                @Override // com.aliyun.player.IPlayer.OnPreparedListener
                public final void onPrepared() {
                    l.u(l.this);
                }
            });
        }
        AliPlayer aliPlayer4 = this.f42976b;
        if (aliPlayer4 != null) {
            aliPlayer4.setOnVideoSizeChangedListener(new IPlayer.OnVideoSizeChangedListener() { // from class: com.transsion.audio.player.g
                @Override // com.aliyun.player.IPlayer.OnVideoSizeChangedListener
                public final void onVideoSizeChanged(int i11, int i12) {
                    l.v(l.this, i11, i12);
                }
            });
        }
        AliPlayer aliPlayer5 = this.f42976b;
        if (aliPlayer5 != null) {
            aliPlayer5.setOnRenderingStartListener(new IPlayer.OnRenderingStartListener() { // from class: com.transsion.audio.player.h
                @Override // com.aliyun.player.IPlayer.OnRenderingStartListener
                public final void onRenderingStart() {
                    l.w(l.this);
                }
            });
        }
        AliPlayer aliPlayer6 = this.f42976b;
        if (aliPlayer6 != null) {
            aliPlayer6.setOnInfoListener(new IPlayer.OnInfoListener() { // from class: com.transsion.audio.player.i
                @Override // com.aliyun.player.IPlayer.OnInfoListener
                public final void onInfo(InfoBean infoBean) {
                    l.x(l.this, infoBean);
                }
            });
        }
        AliPlayer aliPlayer7 = this.f42976b;
        if (aliPlayer7 != null) {
            aliPlayer7.setOnLoadingStatusListener(new b());
        }
        AliPlayer aliPlayer8 = this.f42976b;
        if (aliPlayer8 != null) {
            aliPlayer8.setOnSeekCompleteListener(new IPlayer.OnSeekCompleteListener() { // from class: com.transsion.audio.player.j
                @Override // com.aliyun.player.IPlayer.OnSeekCompleteListener
                public final void onSeekComplete() {
                    l.y();
                }
            });
        }
        AliPlayer aliPlayer9 = this.f42976b;
        if (aliPlayer9 != null) {
            aliPlayer9.setOnTrackChangedListener(new c());
        }
        AliPlayer aliPlayer10 = this.f42976b;
        if (aliPlayer10 != null) {
            aliPlayer10.setOnStateChangedListener(new IPlayer.OnStateChangedListener() { // from class: com.transsion.audio.player.k
                @Override // com.aliyun.player.IPlayer.OnStateChangedListener
                public final void onStateChanged(int i11) {
                    l.z(l.this, i11);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(l lVar, ErrorInfo errorInfo) {
        a.C0856a.f(lg.a.f68962a, lVar.f42975a, "onError code:" + errorInfo.getCode() + ",msg:" + errorInfo.getMsg(), false, 4, null);
        PlayError playError = new PlayError(Integer.valueOf(errorInfo.getCode().getValue()), errorInfo.getMsg());
        com.transsion.player.orplayer.f fVar = lVar.f42978d;
        if (fVar != null) {
            f.a.r(fVar, playError, null, 2, null);
        }
        if (errorInfo.getCode() == ErrorCode.ERROR_DECODE_AUDIO) {
            lVar.prepare();
            lVar.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(l lVar) {
        com.transsion.player.orplayer.f fVar = lVar.f42978d;
        if (fVar != null) {
            f.a.x(fVar, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(l lVar, int i11, int i12) {
        com.transsion.player.orplayer.f fVar = lVar.f42978d;
        if (fVar != null) {
            fVar.onVideoSizeChanged(i11, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(l lVar) {
        com.transsion.player.orplayer.f fVar = lVar.f42978d;
        if (fVar != null) {
            fVar.onRenderFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(l lVar, InfoBean infoBean) {
        if (infoBean.getCode() == InfoCode.CurrentPosition) {
            long extraValue = infoBean.getExtraValue();
            com.transsion.player.orplayer.f fVar = lVar.f42978d;
            if (fVar != null) {
                f.a.z(fVar, extraValue, null, 2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(l lVar, int i11) {
        com.transsion.player.orplayer.f fVar;
        a.C0856a.f(lg.a.f68962a, lVar.f42975a, "setOnStateChangedListener status:" + i11, false, 4, null);
        boolean z10 = i11 == 3;
        lVar.f42979e = z10;
        com.transsion.player.orplayer.f fVar2 = lVar.f42978d;
        if (fVar2 != null) {
            fVar2.onIsPlayingChanged(z10);
        }
        lVar.f42980f = i11 == 6;
        com.transsion.player.orplayer.c cVar = lVar.f42977c;
        if (cVar != null) {
            cVar.f(lVar.f42979e);
        }
        if (i11 == 3) {
            com.transsion.player.orplayer.f fVar3 = lVar.f42978d;
            if (fVar3 != null) {
                f.a.J(fVar3, null, 1, null);
                return;
            }
            return;
        }
        if (i11 == 4 || i11 == 5) {
            com.transsion.player.orplayer.f fVar4 = lVar.f42978d;
            if (fVar4 != null) {
                f.a.G(fVar4, null, 1, null);
                return;
            }
            return;
        }
        if (i11 == 6 && (fVar = lVar.f42978d) != null) {
            f.a.f(fVar, null, 1, null);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public boolean addDataSource(ao.e eVar) {
        return g.b.a(this, eVar);
    }

    @Override // com.transsion.player.orplayer.g
    public void addPlayerListener(com.transsion.player.orplayer.f fVar) {
        g.b.b(this, fVar);
    }

    @Override // com.transsion.player.orplayer.g
    public void changeTrackSelection(mo.d dVar, int i11) {
        g.b.c(this, dVar, i11);
    }

    @Override // com.transsion.player.orplayer.g
    public void clearScreen() {
        g.b.d(this);
    }

    @Override // com.transsion.player.orplayer.g
    public void clearSurfaceOnly() {
        g.b.e(this);
    }

    @Override // com.transsion.player.orplayer.g
    public ao.e currentMediaSource() {
        return g.b.f(this);
    }

    @Override // com.transsion.player.orplayer.g
    public void enableHardwareDecoder(boolean z10) {
        AliPlayer aliPlayer = this.f42976b;
        if (aliPlayer != null) {
            aliPlayer.enableHardwareDecoder(z10);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public Pair getBitrate() {
        return new Pair(0, 0);
    }

    @Override // com.transsion.player.orplayer.g
    public long getCurrentPosition() {
        return g.b.g(this);
    }

    @Override // com.transsion.player.orplayer.g
    public mo.c getCurrentTracks() {
        return g.b.h(this);
    }

    @Override // com.transsion.player.orplayer.g
    public mo.b getCurrentVideoFormat() {
        return g.b.i(this);
    }

    @Override // com.transsion.player.orplayer.g
    public Object getDownloadBitrate() {
        return g.b.j(this);
    }

    @Override // com.transsion.player.orplayer.g
    public long getDuration() {
        AliPlayer aliPlayer = this.f42976b;
        if (aliPlayer != null) {
            return aliPlayer.getDuration();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.g
    public int getVideoHeight() {
        return g.b.k(this);
    }

    @Override // com.transsion.player.orplayer.g
    public int getVideoWidth() {
        return g.b.l(this);
    }

    @Override // com.transsion.player.orplayer.g
    public Float getVolume() {
        AliPlayer aliPlayer = this.f42976b;
        if (aliPlayer != null) {
            return Float.valueOf(aliPlayer.getVolume());
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isComplete() {
        return this.f42980f;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isLoading() {
        return g.b.m(this);
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isMute() {
        AliPlayer aliPlayer = this.f42976b;
        if (aliPlayer != null) {
            return aliPlayer.isMute();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isPlaying() {
        return this.f42979e;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isPrepared() {
        return g.b.n(this);
    }

    @Override // com.transsion.player.orplayer.g
    public void pause() {
        AliPlayer aliPlayer = this.f42976b;
        if (aliPlayer != null) {
            aliPlayer.pause();
        }
        com.transsion.player.orplayer.c cVar = this.f42977c;
        if (cVar != null) {
            cVar.g(true);
        }
        com.transsion.player.orplayer.c cVar2 = this.f42977c;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void play() {
        com.transsion.player.orplayer.c cVar;
        com.transsion.player.orplayer.f fVar = this.f42978d;
        if (fVar != null) {
            fVar.initPlayer();
        }
        AliPlayer aliPlayer = this.f42976b;
        if (aliPlayer != null) {
            aliPlayer.start();
        }
        com.transsion.player.orplayer.c cVar2 = this.f42977c;
        if (cVar2 != null) {
            cVar2.g(false);
        }
        if (isMute() || (cVar = this.f42977c) == null) {
            return;
        }
        cVar.e();
    }

    @Override // com.transsion.player.orplayer.g
    public void prepare() {
        AliPlayer aliPlayer = this.f42976b;
        if (aliPlayer != null) {
            aliPlayer.prepare();
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void release() {
        com.transsion.player.orplayer.f fVar = this.f42978d;
        if (fVar != null) {
            f.a.u(fVar, null, 1, null);
        }
        AliPlayer aliPlayer = this.f42976b;
        if (aliPlayer != null) {
            aliPlayer.release();
        }
        this.f42976b = null;
        com.transsion.player.orplayer.c cVar = this.f42977c;
        if (cVar != null) {
            cVar.b();
        }
        this.f42977c = null;
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
    public void removePlayerListener(com.transsion.player.orplayer.f fVar) {
        g.b.q(this, fVar);
    }

    @Override // com.transsion.player.orplayer.g
    public boolean requestForce() {
        return g.b.r(this);
    }

    @Override // com.transsion.player.orplayer.g
    public void reset() {
        com.transsion.player.orplayer.f fVar = this.f42978d;
        if (fVar != null) {
            fVar.onPlayerReset();
        }
        AliPlayer aliPlayer = this.f42976b;
        if (aliPlayer != null) {
            aliPlayer.reset();
        }
        com.transsion.player.orplayer.c cVar = this.f42977c;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void seekTo(long j11) {
        AliPlayer aliPlayer = this.f42976b;
        if (aliPlayer != null) {
            aliPlayer.setMaxAccurateSeekDelta(150000);
        }
        AliPlayer aliPlayer2 = this.f42976b;
        if (aliPlayer2 != null) {
            aliPlayer2.seekTo(j11, IPlayer.SeekMode.Accurate);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void seekTo(String str, long j11) {
        g.b.s(this, str, j11);
    }

    @Override // com.transsion.player.orplayer.g
    public void setAutoPlay(boolean z10) {
        AliPlayer aliPlayer = this.f42976b;
        if (aliPlayer != null) {
            aliPlayer.setAutoPlay(z10);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setDataSource(ao.e mediaSource) {
        Intrinsics.h(mediaSource, "mediaSource");
        UrlSource urlSource = new UrlSource();
        urlSource.setUri(mediaSource.k());
        AliPlayer aliPlayer = this.f42976b;
        if (aliPlayer != null) {
            aliPlayer.setDataSource(urlSource);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setLooping(boolean z10) {
        AliPlayer aliPlayer = this.f42976b;
        if (aliPlayer != null) {
            aliPlayer.setLoop(z10);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setMute(boolean z10) {
        g.b.v(this, z10);
    }

    @Override // com.transsion.player.orplayer.g
    public void setPlayerConfig(bo.d dVar) {
        g.b.w(this, dVar);
    }

    @Override // com.transsion.player.orplayer.g
    public void setPlayerListener(com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        this.f42978d = listener;
    }

    @Override // com.transsion.player.orplayer.g
    public void setScaleMode(ScaleMode scaleMode) {
        g.b.x(this, scaleMode);
    }

    @Override // com.transsion.player.orplayer.g
    public void setSpeed(float f11) {
        AliPlayer aliPlayer = this.f42976b;
        if (aliPlayer != null) {
            aliPlayer.setSpeed(f11);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setSurfaceView(SurfaceView surfaceView) {
    }

    @Override // com.transsion.player.orplayer.g
    public void setTextureView(TextureView textureView) {
    }

    @Override // com.transsion.player.orplayer.g
    public void setVipResolution(boolean z10, int i11) {
    }

    @Override // com.transsion.player.orplayer.g
    public void setVolume(float f11) {
        AliPlayer aliPlayer = this.f42976b;
        if (aliPlayer != null) {
            aliPlayer.setVolume(f11);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void stop() {
        com.transsion.player.orplayer.c cVar;
        AliPlayer aliPlayer = this.f42976b;
        if (aliPlayer != null) {
            aliPlayer.stop();
        }
        com.transsion.player.orplayer.c cVar2 = this.f42977c;
        if (cVar2 != null) {
            cVar2.g(true);
        }
        if (isMute() || (cVar = this.f42977c) == null) {
            return;
        }
        cVar.b();
    }
}
