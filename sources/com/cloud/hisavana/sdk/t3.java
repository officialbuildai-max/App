package com.cloud.hisavana.sdk;

import android.content.Context;
import android.net.Uri;
import com.cloud.hisavana.net.utils.StorageUtils;
import com.cloud.hisavana.sdk.C1016p;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.widget.video.MediaTextureView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o2;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;
import com.google.android.exoplayer2.upstream.cache.a;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.r;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.File;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class t3 implements m4 {

    /* renamed from: p, reason: collision with root package name */
    private static volatile k.a f23038p;

    /* renamed from: a, reason: collision with root package name */
    private final String f23040a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f23041b;

    /* renamed from: c, reason: collision with root package name */
    private ExoPlayer f23042c;

    /* renamed from: d, reason: collision with root package name */
    private q4 f23043d;

    /* renamed from: e, reason: collision with root package name */
    private AdsDTO f23044e;

    /* renamed from: f, reason: collision with root package name */
    private String f23045f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f23046g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f23047h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f23048i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f23049j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f23050k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f23051l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f23052m;

    /* renamed from: n, reason: collision with root package name */
    private MediaTextureView f23053n;

    /* renamed from: o, reason: collision with root package name */
    public static final a f23037o = new a(null);

    /* renamed from: q, reason: collision with root package name */
    private static final Object f23039q = new Object();

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final k.a a(Context context) {
            k.a aVar;
            k.a aVar2 = t3.f23038p;
            if (aVar2 != null) {
                return aVar2;
            }
            synchronized (t3.f23039q) {
                aVar = t3.f23038p;
                if (aVar == null) {
                    try {
                        File d11 = StorageUtils.d(context, true);
                        Intrinsics.g(d11, "getExoCacheDirectory(...)");
                        aVar = new a.c().h(new SimpleCache(d11, new com.google.android.exoplayer2.upstream.cache.q(104857600L), new f9.b(context))).i(new r.a(context));
                        t3.f23038p = aVar;
                        Intrinsics.e(aVar);
                    } catch (Throwable th2) {
                        e4.b().w("ExoPlayerImpl", "disk cache init failed, fallback to no-cache: " + th2.getMessage());
                        aVar = new r.a(context);
                        t3.f23038p = aVar;
                    }
                }
            }
            return aVar;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements o2.d {
        b() {
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onAvailableCommandsChanged(o2.b bVar) {
            com.google.android.exoplayer2.q2.c(this, bVar);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onCues(ba.f fVar) {
            com.google.android.exoplayer2.q2.d(this, fVar);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onCues(List list) {
            com.google.android.exoplayer2.q2.e(this, list);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onDeviceInfoChanged(com.google.android.exoplayer2.r rVar) {
            com.google.android.exoplayer2.q2.f(this, rVar);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onDeviceVolumeChanged(int i11, boolean z10) {
            com.google.android.exoplayer2.q2.g(this, i11, z10);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onEvents(com.google.android.exoplayer2.o2 o2Var, o2.c cVar) {
            com.google.android.exoplayer2.q2.h(this, o2Var, cVar);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onIsLoadingChanged(boolean z10) {
            com.google.android.exoplayer2.q2.i(this, z10);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public void onIsPlayingChanged(boolean z10) {
            e4.b().d(t3.this.f23040a, "onIsPlayingChanged isPlaying=" + z10);
            if (z10 && !t3.this.f23051l) {
                t3.this.f23051l = true;
                q4 q4Var = t3.this.f23043d;
                if (q4Var != null) {
                    q4Var.b();
                }
            }
            q4 q4Var2 = t3.this.f23043d;
            if (q4Var2 != null) {
                q4Var2.onIsPlayingChanged(z10);
            }
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onLoadingChanged(boolean z10) {
            com.google.android.exoplayer2.q2.k(this, z10);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onMediaItemTransition(com.google.android.exoplayer2.v1 v1Var, int i11) {
            com.google.android.exoplayer2.q2.m(this, v1Var, i11);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onMediaMetadataChanged(com.google.android.exoplayer2.a2 a2Var) {
            com.google.android.exoplayer2.q2.n(this, a2Var);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onMetadata(Metadata metadata) {
            com.google.android.exoplayer2.q2.o(this, metadata);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onPlayWhenReadyChanged(boolean z10, int i11) {
            com.google.android.exoplayer2.q2.p(this, z10, i11);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onPlaybackParametersChanged(com.google.android.exoplayer2.n2 n2Var) {
            com.google.android.exoplayer2.q2.q(this, n2Var);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public void onPlaybackStateChanged(int i11) {
            if (i11 == 2) {
                e4.b().d(t3.this.f23040a, "STATE_BUFFERING");
                return;
            }
            if (i11 == 3) {
                e4.b().d(t3.this.f23040a, "STATE_READY");
                q4 q4Var = t3.this.f23043d;
                if (q4Var != null) {
                    q4Var.e();
                }
                t3.this.p();
                return;
            }
            if (i11 != 4) {
                return;
            }
            e4.b().d(t3.this.f23040a, "STATE_ENDED");
            ExoPlayer exoPlayer = t3.this.f23042c;
            if (exoPlayer == null) {
                return;
            }
            q4 q4Var2 = t3.this.f23043d;
            if (q4Var2 != null) {
                q4Var2.c(exoPlayer.getDuration(), exoPlayer.getDuration(), 100);
            }
            q4 q4Var3 = t3.this.f23043d;
            if (q4Var3 != null) {
                q4Var3.onComplete();
            }
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i11) {
            com.google.android.exoplayer2.q2.s(this, i11);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public void onPlayerError(PlaybackException error) {
            Intrinsics.h(error, "error");
            e4.b().w(t3.this.f23040a, "errorCode=" + error.errorCode + " msg=" + error.getMessage());
            C1016p f11 = t3.this.f(error);
            q4 q4Var = t3.this.f23043d;
            if (q4Var != null) {
                q4Var.a(f11);
            }
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
            com.google.android.exoplayer2.q2.u(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onPlayerStateChanged(boolean z10, int i11) {
            com.google.android.exoplayer2.q2.v(this, z10, i11);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onPositionDiscontinuity(int i11) {
            com.google.android.exoplayer2.q2.x(this, i11);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onPositionDiscontinuity(o2.e eVar, o2.e eVar2, int i11) {
            com.google.android.exoplayer2.q2.y(this, eVar, eVar2, i11);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onRenderedFirstFrame() {
            com.google.android.exoplayer2.q2.z(this);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onRepeatModeChanged(int i11) {
            com.google.android.exoplayer2.q2.A(this, i11);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onSeekProcessed() {
            com.google.android.exoplayer2.q2.D(this);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z10) {
            com.google.android.exoplayer2.q2.E(this, z10);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z10) {
            com.google.android.exoplayer2.q2.F(this, z10);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onSurfaceSizeChanged(int i11, int i12) {
            com.google.android.exoplayer2.q2.G(this, i11, i12);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onTimelineChanged(com.google.android.exoplayer2.k3 k3Var, int i11) {
            com.google.android.exoplayer2.q2.H(this, k3Var, i11);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
            com.google.android.exoplayer2.q2.I(this, trackSelectionParameters);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public /* synthetic */ void onTracksChanged(com.google.android.exoplayer2.p3 p3Var) {
            com.google.android.exoplayer2.q2.J(this, p3Var);
        }

        @Override // com.google.android.exoplayer2.o2.d
        public void onVideoSizeChanged(com.google.android.exoplayer2.video.y videoSize) {
            Intrinsics.h(videoSize, "videoSize");
            t3.this.p();
        }

        @Override // com.google.android.exoplayer2.o2.d
        public void onVolumeChanged(float f11) {
            q4 q4Var = t3.this.f23043d;
            if (q4Var != null) {
                q4Var.onVolumeChanged(f11);
            }
        }
    }

    public t3(Context context) {
        Intrinsics.h(context, "context");
        this.f23040a = "ExoPlayerImpl";
        Context applicationContext = context.getApplicationContext();
        Intrinsics.g(applicationContext, "getApplicationContext(...)");
        this.f23041b = applicationContext;
        this.f23048i = true;
        this.f23049j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C1016p f(PlaybackException playbackException) {
        int i11 = playbackException.errorCode;
        Pair pair = (i11 < 2000 || i11 > 2008) ? (i11 < 4001 || i11 > 4003) ? (i11 < 6001 || i11 > 6006) ? new Pair(C1016p.b.f22904e, Integer.valueOf(TaErrorCode.CODE_SHOW_VIDEO_PLAYER_UNKNOWN_ERROR)) : new Pair(C1016p.b.f22902c, Integer.valueOf(TaErrorCode.CODE_SHOW_VIDEO_PLAYER_DRM_ERROR)) : new Pair(C1016p.b.f22901b, Integer.valueOf(TaErrorCode.CODE_SHOW_VIDEO_PLAYER_DECODE_ERROR)) : new Pair(C1016p.b.f22900a, Integer.valueOf(TaErrorCode.CODE_SHOW_VIDEO_PLAYER_IO_ERROR));
        C1016p.b bVar = (C1016p.b) pair.component1();
        int intValue = ((Number) pair.component2()).intValue();
        String message = playbackException.getMessage();
        if (message == null) {
            message = "unknown playback error";
        }
        return new C1016p(intValue, message, bVar, playbackException);
    }

    private final void o() {
        ExoPlayer exoPlayer = this.f23042c;
        if (exoPlayer != null) {
            exoPlayer.release();
        }
        this.f23042c = null;
        this.f23051l = false;
        try {
            ExoPlayer f11 = new ExoPlayer.b(this.f23041b).l(new com.google.android.exoplayer2.p(this.f23041b).j(true)).f();
            Intrinsics.g(f11, "build(...)");
            MediaTextureView mediaTextureView = this.f23053n;
            if (mediaTextureView != null) {
                f11.setVideoTextureView(mediaTextureView);
            }
            f11.C(new b());
            this.f23042c = f11;
            String str = this.f23045f;
            if (str == null) {
                e4.b().e(this.f23040a, "videoPath is null, skip initPlayer");
                return;
            }
            com.google.android.exoplayer2.v1 d11 = com.google.android.exoplayer2.v1.d(Uri.parse(str));
            Intrinsics.g(d11, "fromUri(...)");
            if (this.f23047h) {
                com.google.android.exoplayer2.source.x a11 = new x.b(f23037o.a(this.f23041b)).a(d11);
                Intrinsics.g(a11, "createMediaSource(...)");
                f11.a(a11);
            } else {
                f11.B(d11);
            }
            f11.setPlayWhenReady(this.f23048i);
            if (this.f23046g) {
                f11.setVolume(0.0f);
            }
            f11.prepare();
        } catch (Throwable th2) {
            e4.b().e(this.f23040a, "initPlayer failed: " + th2.getMessage());
            this.f23042c = null;
            q4 q4Var = this.f23043d;
            if (q4Var != null) {
                String message = th2.getMessage();
                if (message == null) {
                    message = "player init failed";
                }
                q4Var.a(new C1016p(TaErrorCode.CODE_SHOW_VIDEO_PLAYER_UNKNOWN_ERROR, message, C1016p.b.f22904e, th2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        ExoPlayer exoPlayer;
        if (this.f23052m || (exoPlayer = this.f23042c) == null) {
            return;
        }
        com.google.android.exoplayer2.video.y p11 = exoPlayer.p();
        Intrinsics.g(p11, "getVideoSize(...)");
        int i11 = p11.f28063a;
        int i12 = p11.f28064b;
        if (i11 > 0 && i12 > 0) {
            AdsDTO adsDTO = this.f23044e;
            if (adsDTO != null) {
                adsDTO.setMaterialWith(i11);
            }
            AdsDTO adsDTO2 = this.f23044e;
            if (adsDTO2 != null) {
                adsDTO2.setMaterialHeight(i12);
            }
        }
        q4 q4Var = this.f23043d;
        if (q4Var != null) {
            q4Var.onVideoSizeChanged(i11, i12);
        }
    }

    @Override // com.cloud.hisavana.sdk.m4
    public void a() {
        ExoPlayer exoPlayer = this.f23042c;
        if (exoPlayer == null) {
            return;
        }
        if (exoPlayer.getVolume() == 0.0f) {
            exoPlayer.setVolume(1.0f);
            this.f23046g = false;
            q4 q4Var = this.f23043d;
            if (q4Var != null) {
                q4Var.onVolumeChanged(1.0f);
                return;
            }
            return;
        }
        exoPlayer.setVolume(0.0f);
        this.f23046g = true;
        q4 q4Var2 = this.f23043d;
        if (q4Var2 != null) {
            q4Var2.onVolumeChanged(0.0f);
        }
    }

    @Override // com.cloud.hisavana.sdk.m4
    public void a(MediaTextureView mediaTextureView) {
        this.f23053n = mediaTextureView;
        ExoPlayer exoPlayer = this.f23042c;
        if (exoPlayer != null) {
            exoPlayer.setVideoTextureView(mediaTextureView);
        }
    }

    @Override // com.cloud.hisavana.sdk.m4
    public void a(boolean z10) {
        this.f23050k = z10;
    }

    @Override // com.cloud.hisavana.sdk.m4
    public void b() {
        ExoPlayer exoPlayer = this.f23042c;
        if (exoPlayer != null) {
            exoPlayer.pause();
        }
    }

    @Override // com.cloud.hisavana.sdk.m4
    public void b(AdsDTO adsDTO, String path, boolean z10, boolean z11) {
        Intrinsics.h(path, "path");
        e4.b().d(this.f23040a, "setMediaData path=" + path + " enableDiskCache=" + z11);
        this.f23044e = adsDTO;
        this.f23045f = path;
        this.f23046g = z10;
        this.f23047h = z11;
        this.f23051l = false;
        this.f23052m = false;
        if (adsDTO != null && adsDTO.getMaterialWith() > 0 && adsDTO.getMaterialHeight() > 0) {
            this.f23052m = true;
        }
        o();
    }

    @Override // com.cloud.hisavana.sdk.m4
    public void c() {
        ExoPlayer exoPlayer = this.f23042c;
        if (exoPlayer == null) {
            return;
        }
        if (exoPlayer.getPlaybackState() == 1) {
            exoPlayer.prepare();
        } else {
            exoPlayer.seekTo(exoPlayer.t(), C.TIME_UNSET);
        }
        exoPlayer.play();
    }

    @Override // com.cloud.hisavana.sdk.m4
    public void c(q4 q4Var) {
        this.f23043d = q4Var;
    }

    @Override // com.cloud.hisavana.sdk.m4
    public void d() {
        ExoPlayer exoPlayer = this.f23042c;
        if (exoPlayer == null) {
            return;
        }
        int playbackState = exoPlayer.getPlaybackState();
        if (playbackState == 1 || playbackState == 4 || !exoPlayer.getPlayWhenReady()) {
            q4 q4Var = this.f23043d;
            if (q4Var != null) {
                q4Var.d(true);
            }
            e();
            return;
        }
        q4 q4Var2 = this.f23043d;
        if (q4Var2 != null) {
            q4Var2.d(false);
        }
        b();
    }

    @Override // com.cloud.hisavana.sdk.m4
    public void e() {
        ExoPlayer exoPlayer = this.f23042c;
        if (exoPlayer == null) {
            return;
        }
        int playbackState = exoPlayer.getPlaybackState();
        if (playbackState == 1) {
            exoPlayer.prepare();
        } else if (playbackState == 4) {
            exoPlayer.seekTo(exoPlayer.t(), C.TIME_UNSET);
        }
        exoPlayer.play();
    }

    @Override // com.cloud.hisavana.sdk.m4
    public long getCurrentPosition() {
        ExoPlayer exoPlayer = this.f23042c;
        if (exoPlayer != null) {
            return exoPlayer.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.cloud.hisavana.sdk.m4
    public long getDuration() {
        ExoPlayer exoPlayer = this.f23042c;
        if (exoPlayer != null) {
            return exoPlayer.getDuration();
        }
        return 0L;
    }

    @Override // com.cloud.hisavana.sdk.m4
    public boolean getPlayWhenReady() {
        return this.f23048i;
    }

    @Override // com.cloud.hisavana.sdk.m4
    public boolean isPlaying() {
        ExoPlayer exoPlayer = this.f23042c;
        if (exoPlayer != null) {
            return exoPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.cloud.hisavana.sdk.m4
    public void pause() {
        ExoPlayer exoPlayer = this.f23042c;
        if (exoPlayer != null) {
            exoPlayer.pause();
        }
    }

    @Override // com.cloud.hisavana.sdk.m4
    public void play() {
        ExoPlayer exoPlayer = this.f23042c;
        if (exoPlayer != null) {
            exoPlayer.play();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cloud.hisavana.sdk.m4
    public void release() {
        e4.b().d(this.f23040a, "release player=" + System.identityHashCode(this.f23042c));
        try {
            ExoPlayer exoPlayer = this.f23042c;
            if (exoPlayer != null) {
                if (exoPlayer.isPlaying()) {
                    exoPlayer.pause();
                }
                exoPlayer.stop();
                exoPlayer.release();
                exoPlayer.clearVideoSurface();
            }
        } catch (Throwable th2) {
            try {
                e4.b().w(this.f23040a, "release error (ignored): " + th2.getMessage());
            } finally {
                this.f23042c = null;
                this.f23043d = null;
            }
        }
    }

    @Override // com.cloud.hisavana.sdk.m4
    public void seekTo(long j11) {
        ExoPlayer exoPlayer = this.f23042c;
        if (exoPlayer != null) {
            exoPlayer.seekTo(j11);
        }
    }

    @Override // com.cloud.hisavana.sdk.m4
    public void setPlayWhenReady(boolean z10) {
        this.f23048i = z10;
        ExoPlayer exoPlayer = this.f23042c;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(z10);
        }
    }
}
