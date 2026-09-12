package lo;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.a0;
import androidx.media3.common.e0;
import androidx.media3.common.h0;
import androidx.media3.common.i0;
import androidx.media3.common.m;
import androidx.media3.common.m0;
import androidx.media3.common.r;
import androidx.media3.common.t;
import androidx.media3.common.v;
import androidx.media3.common.x;
import androidx.media3.common.y;
import androidx.media3.common.z;
import androidx.media3.datasource.a;
import androidx.media3.datasource.b;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.drm.w;
import androidx.media3.exoplayer.hls.HlsMediaSource;
import androidx.media3.exoplayer.m;
import androidx.media3.exoplayer.source.i;
import androidx.media3.exoplayer.source.r;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.player.exo.ORExoDecoderType;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import com.transsion.player.p007enum.PlayMimeType;
import com.transsion.player.p007enum.ScaleMode;
import com.transsion.player.shorttv.preload.g;
import com.transsion.player.ui.render.RenderScaleMode;
import com.transsion.player.ui.render.SurfaceRenderView;
import com.transsion.player.ui.render.TextureRenderView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lo.f;
import y1.c;

/* loaded from: classes6.dex */
public final class e implements f {

    /* renamed from: a, reason: collision with root package name */
    private final com.transsion.player.shorttv.preload.c f69114a;

    /* renamed from: b, reason: collision with root package name */
    private final String f69115b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f69116c;

    /* renamed from: d, reason: collision with root package name */
    private ExoPlayer f69117d;

    /* renamed from: e, reason: collision with root package name */
    private ao.e f69118e;

    /* renamed from: f, reason: collision with root package name */
    private SurfaceRenderView f69119f;

    /* renamed from: g, reason: collision with root package name */
    private TextureRenderView f69120g;

    /* renamed from: h, reason: collision with root package name */
    private Float f69121h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f69122i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f69123j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f69124k;

    /* renamed from: l, reason: collision with root package name */
    private float f69125l;

    /* renamed from: m, reason: collision with root package name */
    private ScaleMode f69126m;

    /* renamed from: n, reason: collision with root package name */
    private int f69127n;

    /* renamed from: o, reason: collision with root package name */
    private int f69128o;

    /* renamed from: p, reason: collision with root package name */
    private String f69129p;

    /* renamed from: q, reason: collision with root package name */
    private ORExoDecoderType f69130q;

    /* renamed from: r, reason: collision with root package name */
    private com.transsion.player.orplayer.c f69131r;

    /* renamed from: s, reason: collision with root package name */
    private final a0.d f69132s;

    /* renamed from: t, reason: collision with root package name */
    private CopyOnWriteArrayList f69133t;

    /* renamed from: u, reason: collision with root package name */
    private final Handler f69134u;

    /* renamed from: v, reason: collision with root package name */
    private final Runnable f69135v;

    /* renamed from: w, reason: collision with root package name */
    private final Lazy f69136w;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f69137a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f69138b;

        static {
            int[] iArr = new int[ScaleMode.values().length];
            try {
                iArr[ScaleMode.SCALE_TO_FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScaleMode.SCALE_ASPECT_FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScaleMode.SCALE_ASPECT_FILL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f69137a = iArr;
            int[] iArr2 = new int[PlayMimeType.values().length];
            try {
                iArr2[PlayMimeType.DASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[PlayMimeType.HLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            f69138b = iArr2;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends androidx.media3.exoplayer.util.a {
        b(String str) {
            super(str);
        }

        @Override // androidx.media3.exoplayer.util.a, y1.c
        public void R(c.a eventTime, String decoderName, long j11, long j12) {
            Intrinsics.h(eventTime, "eventTime");
            Intrinsics.h(decoderName, "decoderName");
            super.R(eventTime, decoderName, j11, j12);
            oo.e.f71197a.h(e.this.f69115b, "onExoAudioDecoderInitialize, decoderName:" + decoderName, true);
        }

        @Override // androidx.media3.exoplayer.util.a, y1.c
        public void q(c.a eventTime, String decoderName, long j11, long j12) {
            Intrinsics.h(eventTime, "eventTime");
            Intrinsics.h(decoderName, "decoderName");
            super.q(eventTime, decoderName, j11, j12);
            oo.e.f71197a.h(e.this.f69115b, "onExoVideoDecoderInitialize, decoderName:" + decoderName, true);
        }

        @Override // androidx.media3.exoplayer.util.a, y1.c
        public void y(c.a eventTime, i0 tracks) {
            Intrinsics.h(eventTime, "eventTime");
            Intrinsics.h(tracks, "tracks");
            super.y(eventTime, tracks);
            e.this.C(eventTime, tracks);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements a0.d {

        /* renamed from: a, reason: collision with root package name */
        private int f69140a = 1;

        c() {
        }

        @Override // androidx.media3.common.a0.d
        public void onAudioSessionIdChanged(int i11) {
        }

        @Override // androidx.media3.common.a0.d
        public void onAvailableCommandsChanged(a0.b availableCommands) {
            Intrinsics.h(availableCommands, "availableCommands");
        }

        @Override // androidx.media3.common.a0.d
        public void onCues(List cues) {
            Intrinsics.h(cues, "cues");
        }

        @Override // androidx.media3.common.a0.d
        public void onCues(u1.b cueGroup) {
            Intrinsics.h(cueGroup, "cueGroup");
        }

        @Override // androidx.media3.common.a0.d
        public void onDeviceInfoChanged(m deviceInfo) {
            Intrinsics.h(deviceInfo, "deviceInfo");
        }

        @Override // androidx.media3.common.a0.d
        public void onDeviceVolumeChanged(int i11, boolean z10) {
        }

        @Override // androidx.media3.common.a0.d
        public void onEvents(a0 player, a0.c events) {
            Intrinsics.h(player, "player");
            Intrinsics.h(events, "events");
        }

        @Override // androidx.media3.common.a0.d
        public void onIsLoadingChanged(boolean z10) {
        }

        @Override // androidx.media3.common.a0.d
        public void onIsPlayingChanged(boolean z10) {
            com.transsion.player.orplayer.c cVar = e.this.f69131r;
            if (cVar != null) {
                cVar.f(z10);
            }
            if (z10) {
                for (com.transsion.player.orplayer.f fVar : e.this.f69133t) {
                    if (fVar != null) {
                        f.a.J(fVar, null, 1, null);
                    }
                }
                e.this.f69134u.post(e.this.f69135v);
            } else {
                ExoPlayer exoPlayer = e.this.f69117d;
                if (exoPlayer == null || !exoPlayer.getPlayWhenReady()) {
                    for (com.transsion.player.orplayer.f fVar2 : e.this.f69133t) {
                        if (fVar2 != null) {
                            f.a.G(fVar2, null, 1, null);
                        }
                    }
                }
                e.this.f69134u.removeCallbacks(e.this.f69135v);
            }
            oo.e.d(oo.e.f71197a, e.this.f69115b, "onIsPlayingChanged:" + z10, false, 4, null);
        }

        @Override // androidx.media3.common.a0.d
        public void onLoadingChanged(boolean z10) {
        }

        @Override // androidx.media3.common.a0.d
        public void onMediaItemTransition(t tVar, int i11) {
            t.h hVar;
            oo.e.d(oo.e.f71197a, e.this.f69115b, "onMediaItemTransition  reason:" + i11 + " ", false, 4, null);
            if (i11 == 0 || i11 == 1) {
                for (com.transsion.player.orplayer.f fVar : e.this.f69133t) {
                    if (fVar != null) {
                        fVar.onMediaItemTransition((tVar == null || (hVar = tVar.f10293b) == null) ? null : hVar.f10389e);
                    }
                }
            }
        }

        @Override // androidx.media3.common.a0.d
        public void onMediaMetadataChanged(v mediaMetadata) {
            Intrinsics.h(mediaMetadata, "mediaMetadata");
        }

        @Override // androidx.media3.common.a0.d
        public void onMetadata(x metadata) {
            Intrinsics.h(metadata, "metadata");
        }

        @Override // androidx.media3.common.a0.d
        public void onPlayWhenReadyChanged(boolean z10, int i11) {
        }

        @Override // androidx.media3.common.a0.d
        public void onPlaybackParametersChanged(z playbackParameters) {
            Intrinsics.h(playbackParameters, "playbackParameters");
        }

        @Override // androidx.media3.common.a0.d
        public void onPlaybackStateChanged(int i11) {
            oo.e eVar = oo.e.f71197a;
            oo.e.d(eVar, e.this.f69115b, "onPlaybackStateChanged  playbackState:" + i11 + " ", false, 4, null);
            if (i11 == 2) {
                oo.e.d(eVar, e.this.f69115b, "onPlaybackStateChanged STATE_BUFFERING", false, 4, null);
                for (com.transsion.player.orplayer.f fVar : e.this.f69133t) {
                    if (fVar != null) {
                        f.a.j(fVar, null, 1, null);
                    }
                }
            } else if (i11 == 3) {
                e.this.D();
                for (com.transsion.player.orplayer.f fVar2 : e.this.f69133t) {
                    if (fVar2 != null) {
                        f.a.x(fVar2, null, 1, null);
                    }
                }
                if (this.f69140a == 2) {
                    for (com.transsion.player.orplayer.f fVar3 : e.this.f69133t) {
                        if (fVar3 != null) {
                            f.a.l(fVar3, null, 1, null);
                        }
                    }
                }
            } else if (i11 == 4) {
                for (com.transsion.player.orplayer.f fVar4 : e.this.f69133t) {
                    if (fVar4 != null) {
                        f.a.f(fVar4, null, 1, null);
                    }
                }
            }
            this.f69140a = i11;
        }

        @Override // androidx.media3.common.a0.d
        public void onPlaybackSuppressionReasonChanged(int i11) {
        }

        @Override // androidx.media3.common.a0.d
        public void onPlayerError(PlaybackException error) {
            Intrinsics.h(error, "error");
            oo.e.d(oo.e.f71197a, e.this.f69115b, "onPlayerError:" + error, false, 4, null);
            for (com.transsion.player.orplayer.f fVar : e.this.f69133t) {
                if (fVar != null) {
                    f.a.r(fVar, new PlayError(Integer.valueOf(error.errorCode), error.getMessage()), null, 2, null);
                }
            }
        }

        @Override // androidx.media3.common.a0.d
        public void onPlayerErrorChanged(PlaybackException playbackException) {
        }

        @Override // androidx.media3.common.a0.d
        public void onPlayerStateChanged(boolean z10, int i11) {
        }

        @Override // androidx.media3.common.a0.d
        public void onPositionDiscontinuity(int i11) {
        }

        @Override // androidx.media3.common.a0.d
        public void onPositionDiscontinuity(a0.e oldPosition, a0.e newPosition, int i11) {
            Intrinsics.h(oldPosition, "oldPosition");
            Intrinsics.h(newPosition, "newPosition");
            int i12 = newPosition.f9889c;
            long j11 = newPosition.f9893g;
            oo.e.b(oo.e.f71197a, e.this.f69115b, "onPositionDiscontinuity: currentWindowIndex=" + i12 + ", currentPositionMs=" + j11 + ", reason=" + i11, false, 4, null);
            if (i11 == 1 || i11 == 2) {
                for (com.transsion.player.orplayer.f fVar : e.this.f69133t) {
                    if (fVar != null) {
                        fVar.setOnSeekCompleteListener();
                    }
                }
            }
            for (com.transsion.player.orplayer.f fVar2 : e.this.f69133t) {
                if (fVar2 != null) {
                    f.a.z(fVar2, j11, null, 2, null);
                }
            }
            g w11 = e.this.w();
            if (w11 != null) {
                w11.h(i12);
            }
        }

        @Override // androidx.media3.common.a0.d
        public void onRenderedFirstFrame() {
            oo.e.d(oo.e.f71197a, e.this.f69115b, "onRenderedFirstFrame:", false, 4, null);
            for (com.transsion.player.orplayer.f fVar : e.this.f69133t) {
                if (fVar != null) {
                    fVar.onRenderFirstFrame();
                }
            }
        }

        @Override // androidx.media3.common.a0.d
        public void onRepeatModeChanged(int i11) {
        }

        @Override // androidx.media3.common.a0.d
        public void onShuffleModeEnabledChanged(boolean z10) {
        }

        @Override // androidx.media3.common.a0.d
        public void onSkipSilenceEnabledChanged(boolean z10) {
        }

        @Override // androidx.media3.common.a0.d
        public void onSurfaceSizeChanged(int i11, int i12) {
        }

        @Override // androidx.media3.common.a0.d
        public void onTimelineChanged(e0 timeline, int i11) {
            Intrinsics.h(timeline, "timeline");
        }

        @Override // androidx.media3.common.a0.d
        public void onTrackSelectionParametersChanged(h0 parameters) {
            Intrinsics.h(parameters, "parameters");
        }

        @Override // androidx.media3.common.a0.d
        public void onTracksChanged(i0 tracks) {
            Intrinsics.h(tracks, "tracks");
        }

        @Override // androidx.media3.common.a0.d
        public void onVideoSizeChanged(m0 videoSize) {
            Intrinsics.h(videoSize, "videoSize");
            SurfaceRenderView surfaceRenderView = e.this.f69119f;
            if (surfaceRenderView != null) {
                surfaceRenderView.setVideoRotation(videoSize.f10199c);
            }
            TextureRenderView textureRenderView = e.this.f69120g;
            if (textureRenderView != null) {
                textureRenderView.setVideoRotation(videoSize.f10199c);
            }
            SurfaceRenderView surfaceRenderView2 = e.this.f69119f;
            if (surfaceRenderView2 != null) {
                surfaceRenderView2.setVideoSize(videoSize.f10197a, videoSize.f10198b);
            }
            TextureRenderView textureRenderView2 = e.this.f69120g;
            if (textureRenderView2 != null) {
                textureRenderView2.setVideoSize(videoSize.f10197a, videoSize.f10198b);
            }
            for (com.transsion.player.orplayer.f fVar : e.this.f69133t) {
                if (fVar != null) {
                    fVar.onVideoSizeChanged(videoSize.f10197a, videoSize.f10198b);
                }
            }
            oo.e.d(oo.e.f71197a, e.this.f69115b, "onVideoSizeChanged width:" + videoSize.f10197a + "  height:" + videoSize.f10198b, false, 4, null);
        }

        @Override // androidx.media3.common.a0.d
        public void onVolumeChanged(float f11) {
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements com.transsion.player.orplayer.d {
        d() {
        }

        @Override // com.transsion.player.orplayer.d
        public boolean isMute() {
            ExoPlayer exoPlayer = e.this.f69117d;
            if (exoPlayer != null) {
                return exoPlayer.W();
            }
            return false;
        }

        @Override // com.transsion.player.orplayer.d
        public void pause() {
            ExoPlayer exoPlayer = e.this.f69117d;
            if (exoPlayer != null) {
                exoPlayer.pause();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void play() {
            ExoPlayer exoPlayer = e.this.f69117d;
            if (exoPlayer != null) {
                exoPlayer.play();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void setVolume(float f11) {
            ExoPlayer exoPlayer = e.this.f69117d;
            if (exoPlayer != null) {
                exoPlayer.setVolume(f11);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public e(com.transsion.player.shorttv.preload.c config) {
        Intrinsics.h(config, "config");
        this.f69114a = config;
        this.f69115b = "ShortTv-ORExoPlayer";
        this.f69116c = new HashMap();
        this.f69125l = 1.0f;
        this.f69126m = ScaleMode.SCALE_TO_FILL;
        ORExoDecoderType oRExoDecoderType = ORExoDecoderType.HARDWARE;
        this.f69130q = oRExoDecoderType;
        this.f69132s = new c();
        this.f69133t = new CopyOnWriteArrayList();
        x();
        v(oRExoDecoderType);
        Looper myLooper = Looper.myLooper();
        Intrinsics.e(myLooper);
        this.f69134u = new Handler(myLooper);
        this.f69135v = new Runnable() { // from class: lo.b
            @Override // java.lang.Runnable
            public final void run() {
                e.E(e.this);
            }
        };
        this.f69136w = LazyKt.b(new Function0() { // from class: lo.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                g F;
                F = e.F(e.this);
                return F;
            }
        });
    }

    public /* synthetic */ e(com.transsion.player.shorttv.preload.c cVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? com.transsion.player.shorttv.preload.d.a() : cVar);
    }

    private final boolean A(ao.e eVar) {
        PlayMimeType j11 = eVar.j();
        PlayMimeType playMimeType = PlayMimeType.DASH;
        if (j11 != playMimeType) {
            PlayMimeType j12 = eVar.j();
            PlayMimeType playMimeType2 = PlayMimeType.HLS;
            if (j12 != playMimeType2) {
                if (StringsKt.c0(eVar.k(), ".mpd", false, 2, null)) {
                    eVar.u(playMimeType);
                    return true;
                }
                if (!StringsKt.c0(eVar.k(), ".m3u8", false, 2, null)) {
                    return false;
                }
                eVar.u(playMimeType2);
                return true;
            }
        }
        return true;
    }

    private final void B() {
        this.f69134u.removeCallbacks(this.f69135v);
        this.f69134u.postDelayed(this.f69135v, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void C(c.a aVar, i0 i0Var) {
        int size = i0Var.a().size();
        for (int i11 = 0; i11 < size; i11++) {
            E e11 = i0Var.a().get(i11);
            Intrinsics.g(e11, "get(...)");
            i0.a aVar2 = (i0.a) e11;
            int i12 = aVar2.f10173a;
            for (int i13 = 0; i13 < i12; i13++) {
                r b11 = aVar2.b(i13);
                Intrinsics.g(b11, "getTrackFormat(...)");
                if (y.t(b11.f10243o)) {
                    this.f69127n = b11.f10238j;
                } else if (y.o(b11.f10243o)) {
                    this.f69128o = b11.f10238j;
                }
                oo.e eVar = oo.e.f71197a;
                oo.e.i(eVar, this.f69115b, "onTracksChanged  MimeType:" + b11.f10243o, false, 4, null);
                String str = b11.f10243o;
                if (str != null && StringsKt.c0(str, "video", false, 2, null)) {
                    String str2 = b11.f10243o;
                    this.f69129p = str2;
                    oo.e.f(eVar, this.f69115b, "--------onTracksChanged  curVideoMimeType:" + str2, false, 4, null);
                }
            }
        }
        if (!Intrinsics.c(this.f69129p, "video/av01") || Build.VERSION.SDK_INT > 29) {
            return;
        }
        oo.e.f71197a.c(this.f69115b, "exo av1，强制切换到软解， MimeType:" + this.f69129p, true);
        ao.e u11 = u();
        if (u11 != null) {
            setDataSource(u11);
            prepare();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void D() {
        i0 currentTracks;
        ExoPlayer exoPlayer;
        r R;
        r I;
        ExoPlayer exoPlayer2 = this.f69117d;
        if (exoPlayer2 == null || (currentTracks = exoPlayer2.getCurrentTracks()) == null) {
            return;
        }
        int size = currentTracks.a().size();
        for (int i11 = 0; i11 < size; i11++) {
            E e11 = currentTracks.a().get(i11);
            Intrinsics.g(e11, "get(...)");
            i0.a aVar = (i0.a) e11;
            int i12 = aVar.f10173a;
            for (int i13 = 0; i13 < i12; i13++) {
                r b11 = aVar.b(i13);
                Intrinsics.g(b11, "getTrackFormat(...)");
                if (y.t(b11.f10243o)) {
                    ExoPlayer exoPlayer3 = this.f69117d;
                    if (exoPlayer3 != null && (I = exoPlayer3.I()) != null) {
                        int i14 = I.f10238j;
                        int i15 = b11.f10238j;
                        if (i14 == i15) {
                            this.f69127n = i15;
                            oo.e.b(oo.e.f71197a, this.f69115b, "--onPrepare2GetBitrate  MimeType:" + b11.f10243o + "，videoBitrate：" + i15, false, 4, null);
                            Iterator it = this.f69133t.iterator();
                            while (it.hasNext()) {
                                ((com.transsion.player.orplayer.f) it.next()).onTracksVideoBitrateChange(this.f69127n);
                            }
                        }
                    }
                } else if (y.o(b11.f10243o) && (exoPlayer = this.f69117d) != null && (R = exoPlayer.R()) != null) {
                    int i16 = R.f10238j;
                    int i17 = b11.f10238j;
                    if (i16 == i17) {
                        this.f69128o = i17;
                        oo.e.b(oo.e.f71197a, this.f69115b, "--onPrepare2GetBitrate  MimeType:" + b11.f10243o + "，audioBitrate：" + i17, false, 4, null);
                        Iterator it2 = this.f69133t.iterator();
                        while (it2.hasNext()) {
                            ((com.transsion.player.orplayer.f) it2.next()).onTracksAudioBitrateChange(this.f69128o);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(e eVar) {
        ExoPlayer exoPlayer = eVar.f69117d;
        if (exoPlayer == null || !exoPlayer.isPlaying()) {
            return;
        }
        for (com.transsion.player.orplayer.f fVar : eVar.f69133t) {
            ExoPlayer exoPlayer2 = eVar.f69117d;
            if (exoPlayer2 != null) {
                fVar.onProgress(exoPlayer2.getCurrentPosition(), eVar.currentMediaSource());
            }
        }
        eVar.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g F(e eVar) {
        if (!eVar.f69114a.a()) {
            return null;
        }
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return new g(a11);
    }

    private final t r(ao.e eVar) {
        String h11 = eVar.h();
        if (h11 == null) {
            h11 = eVar.k();
        }
        t.c h12 = new t.c().j(h11).d(String.valueOf(eVar.l())).b(eVar.g()).h(eVar.e());
        Intrinsics.g(h12, "setTag(...)");
        if (A(eVar)) {
            int i11 = a.f69138b[eVar.j().ordinal()];
            String str = i11 != 1 ? i11 != 2 ? null : MimeTypes.APPLICATION_M3U8 : MimeTypes.APPLICATION_MPD;
            if (str != null) {
                h12.e(str);
            }
        }
        t a11 = h12.a();
        Intrinsics.g(a11, "build(...)");
        return a11;
    }

    private final androidx.media3.exoplayer.source.r s(ao.e eVar) {
        r.a factory;
        if (!A(eVar)) {
            return null;
        }
        Application a11 = Utils.a();
        String h11 = eVar.h();
        if (h11 == null) {
            h11 = eVar.k();
        }
        t a12 = new t.c().j(h11).d(String.valueOf(eVar.l())).b(eVar.g()).h(eVar.e()).a();
        Intrinsics.g(a12, "build(...)");
        a.InterfaceC0099a a13 = StringsKt.W(h11, "http", false, 2, null) ? co.d.f17629a.a(eVar.f(), eVar.d()) : new b.a(a11);
        int i11 = a.f69138b[eVar.j().ordinal()];
        if (i11 == 1) {
            factory = new DashMediaSource.Factory(a13);
        } else {
            if (i11 != 2) {
                return null;
            }
            factory = new HlsMediaSource.Factory(a13);
        }
        factory.e(new w() { // from class: lo.a
            @Override // androidx.media3.exoplayer.drm.w
            public final androidx.media3.exoplayer.drm.t a(t tVar) {
                androidx.media3.exoplayer.drm.t t11;
                t11 = e.t(tVar);
                return t11;
            }
        });
        return factory.d(a12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.media3.exoplayer.drm.t t(t it) {
        Intrinsics.h(it, "it");
        return androidx.media3.exoplayer.drm.t.f11694a;
    }

    private final ao.e u() {
        ao.e eVar = this.f69118e;
        reset();
        release();
        ORExoDecoderType oRExoDecoderType = Intrinsics.c(this.f69129p, "video/av01") ? ORExoDecoderType.AV1 : ORExoDecoderType.FFMPEG;
        this.f69130q = oRExoDecoderType;
        oo.e.f71197a.a(this.f69115b, "重新创建播放器切换编码, DecoderType:" + oRExoDecoderType + ",MimeTyp:" + this.f69129p, true);
        v(this.f69130q);
        z();
        return eVar;
    }

    private final void v(ORExoDecoderType oRExoDecoderType) {
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        androidx.media3.exoplayer.m a12 = new m.b().b(5000, 20000, 500, 1000).d(-1).c(true).a();
        Intrinsics.g(a12, "build(...)");
        ExoPlayer h11 = new ExoPlayer.b(a11).q(new i(a11).q(co.a.d(a11))).r(co.a.b(a11, oRExoDecoderType)).p(a12).h();
        h11.setPlayWhenReady(false);
        h11.M(this.f69132s);
        h11.D(new b(this.f69115b));
        this.f69117d = h11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g w() {
        return (g) this.f69136w.getValue();
    }

    private final void x() {
        this.f69131r = new com.transsion.player.orplayer.c(new d(), new Function1() { // from class: lo.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit y10;
                y10 = e.y(e.this, ((Boolean) obj).booleanValue());
                return y10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(e eVar, boolean z10) {
        Iterator it = eVar.f69133t.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onFocusChange(z10);
        }
        return Unit.f67184a;
    }

    private final void z() {
        setMute(this.f69124k);
        Float f11 = this.f69121h;
        if (f11 != null) {
            setVolume(f11.floatValue());
        }
        setLooping(this.f69123j);
        setAutoPlay(this.f69122i);
        setSpeed(this.f69125l);
        SurfaceRenderView surfaceRenderView = this.f69119f;
        if (surfaceRenderView != null) {
            setSurfaceView(surfaceRenderView);
        }
        TextureRenderView textureRenderView = this.f69120g;
        if (textureRenderView != null) {
            setTextureView(textureRenderView);
        }
        setScaleMode(this.f69126m);
    }

    @Override // lo.f
    public Map a() {
        return this.f69116c;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean addDataSource(ao.e mediaSource) {
        ExoPlayer exoPlayer;
        ExoPlayer exoPlayer2;
        t.h hVar;
        String str;
        Integer v11;
        Intrinsics.h(mediaSource, "mediaSource");
        this.f69118e = mediaSource;
        ExoPlayer exoPlayer3 = this.f69117d;
        int F = exoPlayer3 != null ? exoPlayer3.F() : 0;
        int i11 = -1;
        for (int i12 = 0; i12 < F; i12++) {
            ExoPlayer exoPlayer4 = this.f69117d;
            Object obj = null;
            t O = exoPlayer4 != null ? exoPlayer4.O(i12) : null;
            int intValue = (O == null || (str = O.f10292a) == null || (v11 = StringsKt.v(str)) == null) ? 0 : v11.intValue();
            if (O != null && (hVar = O.f10293b) != null) {
                obj = hVar.f10392h;
            }
            if (Intrinsics.c(obj, mediaSource.e())) {
                oo.e.d(oo.e.f71197a, this.f69115b, "addDataSource 已经在列表里 index:" + i12 + " vid:" + mediaSource.e(), false, 4, null);
                return false;
            }
            if (i11 < 0 && intValue > mediaSource.l()) {
                i11 = i12;
            }
        }
        if (i11 >= 0) {
            g w11 = w();
            if (w11 != null) {
                w11.f(i11, mediaSource);
            }
            if (A(mediaSource)) {
                androidx.media3.exoplayer.source.r s11 = s(mediaSource);
                if (s11 != null && (exoPlayer2 = this.f69117d) != null) {
                    exoPlayer2.T(i11, s11);
                }
            } else {
                ExoPlayer exoPlayer5 = this.f69117d;
                if (exoPlayer5 != null) {
                    exoPlayer5.N(i11, r(mediaSource));
                }
            }
            oo.e.d(oo.e.f71197a, this.f69115b, "addDataSource  index:" + i11 + " key:" + mediaSource.e(), false, 4, null);
        } else {
            oo.e.d(oo.e.f71197a, this.f69115b, "addDataSource  index:" + F + " key:" + mediaSource.e(), false, 4, null);
            if (A(mediaSource)) {
                androidx.media3.exoplayer.source.r s12 = s(mediaSource);
                if (s12 != null && (exoPlayer = this.f69117d) != null) {
                    exoPlayer.X(s12);
                }
            } else {
                ExoPlayer exoPlayer6 = this.f69117d;
                if (exoPlayer6 != null) {
                    exoPlayer6.J(r(mediaSource));
                }
            }
        }
        g w12 = w();
        if (w12 != null) {
            w12.g(mediaSource);
        }
        Map map = this.f69116c;
        String e11 = mediaSource.e();
        if (e11 == null) {
            e11 = "";
        }
        map.put(e11, mediaSource);
        return true;
    }

    @Override // com.transsion.player.orplayer.g
    public void addPlayerListener(com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        f.a.a(this, listener);
        oo.e.f(oo.e.f71197a, this.f69115b, "addPlayerListener", false, 4, null);
        if (this.f69133t.contains(listener)) {
            return;
        }
        this.f69133t.add(listener);
    }

    @Override // lo.f
    public boolean b(ao.e mediaSource) {
        t.h hVar;
        Intrinsics.h(mediaSource, "mediaSource");
        ExoPlayer exoPlayer = this.f69117d;
        int F = exoPlayer != null ? exoPlayer.F() : 0;
        for (int i11 = 0; i11 < F; i11++) {
            ExoPlayer exoPlayer2 = this.f69117d;
            Object obj = null;
            t O = exoPlayer2 != null ? exoPlayer2.O(i11) : null;
            if (O != null && (hVar = O.f10293b) != null) {
                obj = hVar.f10392h;
            }
            if (Intrinsics.c(obj, mediaSource.e())) {
                oo.e.d(oo.e.f71197a, this.f69115b, "updateDataSource 在列表里更新数据 index:" + i11 + " key:" + mediaSource.e(), false, 4, null);
                if (A(mediaSource)) {
                    androidx.media3.exoplayer.source.r s11 = s(mediaSource);
                    if (s11 == null) {
                        return false;
                    }
                    ExoPlayer exoPlayer3 = this.f69117d;
                    if (exoPlayer3 != null) {
                        exoPlayer3.E(i11);
                    }
                    ExoPlayer exoPlayer4 = this.f69117d;
                    if (exoPlayer4 != null) {
                        exoPlayer4.T(i11, s11);
                    }
                } else {
                    ExoPlayer exoPlayer5 = this.f69117d;
                    if (exoPlayer5 != null) {
                        exoPlayer5.P(i11, r(mediaSource));
                    }
                }
                ExoPlayer exoPlayer6 = this.f69117d;
                if (exoPlayer6 != null) {
                    exoPlayer6.prepare();
                }
                Map map = this.f69116c;
                String e11 = mediaSource.e();
                if (e11 == null) {
                    e11 = "";
                }
                map.put(e11, mediaSource);
                return true;
            }
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.g
    public void changeTrackSelection(mo.d dVar, int i11) {
        f.a.b(this, dVar, i11);
    }

    @Override // com.transsion.player.orplayer.g
    public void clearScreen() {
        f.a.c(this);
    }

    @Override // com.transsion.player.orplayer.g
    public void clearSurfaceOnly() {
        ExoPlayer exoPlayer = this.f69117d;
        if (exoPlayer != null) {
            exoPlayer.setVideoSurfaceView(null);
        }
        ExoPlayer exoPlayer2 = this.f69117d;
        if (exoPlayer2 != null) {
            exoPlayer2.setVideoTextureView(null);
        }
        this.f69119f = null;
        this.f69120g = null;
    }

    @Override // com.transsion.player.orplayer.g
    public ao.e currentMediaSource() {
        String str;
        t.h hVar;
        Object obj;
        ExoPlayer exoPlayer = this.f69117d;
        if (exoPlayer != null) {
            t O = exoPlayer.O(exoPlayer != null ? exoPlayer.t() : 0);
            if (O != null && (hVar = O.f10293b) != null && (obj = hVar.f10392h) != null) {
                str = obj.toString();
                return (ao.e) this.f69116c.get(str);
            }
        }
        str = null;
        return (ao.e) this.f69116c.get(str);
    }

    @Override // com.transsion.player.orplayer.g
    public void enableHardwareDecoder(boolean z10) {
        if (!z10 && this.f69130q == ORExoDecoderType.HARDWARE) {
            u();
            return;
        }
        if (z10) {
            ORExoDecoderType oRExoDecoderType = this.f69130q;
            ORExoDecoderType oRExoDecoderType2 = ORExoDecoderType.HARDWARE;
            if (oRExoDecoderType != oRExoDecoderType2) {
                oo.e.f71197a.a(this.f69115b, "软解切换到硬解，重新创建设置", true);
                this.f69130q = oRExoDecoderType2;
                v(oRExoDecoderType2);
                z();
            }
        }
    }

    @Override // com.transsion.player.orplayer.g
    public Pair getBitrate() {
        return new Pair(Integer.valueOf(this.f69127n), Integer.valueOf(this.f69128o));
    }

    @Override // com.transsion.player.orplayer.g
    public long getCurrentPosition() {
        ExoPlayer exoPlayer = this.f69117d;
        if (exoPlayer != null) {
            return exoPlayer.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.g
    public mo.c getCurrentTracks() {
        return f.a.d(this);
    }

    @Override // com.transsion.player.orplayer.g
    public mo.b getCurrentVideoFormat() {
        return f.a.e(this);
    }

    @Override // com.transsion.player.orplayer.g
    public Object getDownloadBitrate() {
        return f.a.f(this);
    }

    @Override // com.transsion.player.orplayer.g
    public long getDuration() {
        ExoPlayer exoPlayer = this.f69117d;
        if (exoPlayer != null) {
            return exoPlayer.getDuration();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.g
    public int getVideoHeight() {
        return f.a.g(this);
    }

    @Override // com.transsion.player.orplayer.g
    public int getVideoWidth() {
        return f.a.h(this);
    }

    @Override // com.transsion.player.orplayer.g
    public Float getVolume() {
        ExoPlayer exoPlayer = this.f69117d;
        if (exoPlayer != null) {
            return Float.valueOf(exoPlayer.getVolume());
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isComplete() {
        ExoPlayer exoPlayer = this.f69117d;
        return exoPlayer != null && exoPlayer.getPlaybackState() == 4;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isLoading() {
        return f.a.i(this);
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isMute() {
        ExoPlayer exoPlayer = this.f69117d;
        if (exoPlayer != null) {
            return exoPlayer.W();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isPlaying() {
        ExoPlayer exoPlayer = this.f69117d;
        if (exoPlayer != null) {
            return exoPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isPrepared() {
        ExoPlayer exoPlayer = this.f69117d;
        return exoPlayer != null && exoPlayer.getPlaybackState() == 3;
    }

    @Override // com.transsion.player.orplayer.g
    public void pause() {
        com.transsion.player.orplayer.c cVar = this.f69131r;
        if (cVar != null) {
            cVar.g(true);
        }
        oo.e.d(oo.e.f71197a, this.f69115b, "pause", false, 4, null);
        ExoPlayer exoPlayer = this.f69117d;
        if (exoPlayer != null) {
            exoPlayer.pause();
        }
        com.transsion.player.orplayer.c cVar2 = this.f69131r;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void play() {
        ExoPlayer exoPlayer;
        oo.e.d(oo.e.f71197a, this.f69115b, MediaItem.MUSIC_FLOAT_STATE_PLAY, false, 4, null);
        ExoPlayer exoPlayer2 = this.f69117d;
        if ((exoPlayer2 != null ? exoPlayer2.c() : null) != null && (exoPlayer = this.f69117d) != null) {
            exoPlayer.prepare();
        }
        ExoPlayer exoPlayer3 = this.f69117d;
        if (exoPlayer3 != null) {
            exoPlayer3.play();
        }
        com.transsion.player.orplayer.c cVar = this.f69131r;
        if (cVar != null) {
            cVar.g(false);
        }
        com.transsion.player.orplayer.c cVar2 = this.f69131r;
        if (cVar2 != null) {
            cVar2.e();
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void prepare() {
        oo.e.d(oo.e.f71197a, this.f69115b, "prepare", false, 4, null);
        ExoPlayer exoPlayer = this.f69117d;
        if (exoPlayer != null) {
            exoPlayer.prepare();
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void release() {
        oo.e.d(oo.e.f71197a, this.f69115b, "release", false, 4, null);
        ExoPlayer exoPlayer = this.f69117d;
        if (exoPlayer != null) {
            exoPlayer.release();
        }
        for (com.transsion.player.orplayer.f fVar : this.f69133t) {
            if (fVar != null) {
                f.a.u(fVar, null, 1, null);
            }
        }
        this.f69133t.clear();
        g w11 = w();
        if (w11 != null) {
            w11.p();
        }
        this.f69118e = null;
        com.transsion.player.orplayer.c cVar = this.f69131r;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void release(String str) {
        f.a.j(this, str);
    }

    @Override // com.transsion.player.orplayer.g
    public boolean removeDataSource(ao.e mediaSource) {
        t.h hVar;
        Intrinsics.h(mediaSource, "mediaSource");
        ExoPlayer exoPlayer = this.f69117d;
        int F = exoPlayer != null ? exoPlayer.F() : 0;
        int i11 = 0;
        while (true) {
            if (i11 >= F) {
                i11 = -1;
                break;
            }
            ExoPlayer exoPlayer2 = this.f69117d;
            Object obj = null;
            t O = exoPlayer2 != null ? exoPlayer2.O(i11) : null;
            if (O != null && (hVar = O.f10293b) != null) {
                obj = hVar.f10392h;
            }
            if (Intrinsics.c(obj, mediaSource.e())) {
                oo.e.d(oo.e.f71197a, this.f69115b, "removeDataSource 在列表里 index:" + i11 + " key:" + mediaSource.e(), false, 4, null);
                break;
            }
            i11++;
        }
        if (i11 < 0) {
            return false;
        }
        g w11 = w();
        if (w11 != null) {
            String e11 = mediaSource.e();
            if (e11 == null) {
                e11 = "";
            }
            w11.q(e11);
        }
        ExoPlayer exoPlayer3 = this.f69117d;
        if (exoPlayer3 != null) {
            exoPlayer3.E(i11);
        }
        Map map = this.f69116c;
        String e12 = mediaSource.e();
        map.remove(e12 != null ? e12 : "");
        return true;
    }

    @Override // com.transsion.player.orplayer.g
    public void removePlayerListener(com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        f.a.k(this, listener);
        oo.e.f(oo.e.f71197a, this.f69115b, "removePlayerListener", false, 4, null);
        this.f69133t.remove(listener);
    }

    @Override // com.transsion.player.orplayer.g
    public boolean requestForce() {
        return f.a.l(this);
    }

    @Override // com.transsion.player.orplayer.g
    public void reset() {
        oo.e.d(oo.e.f71197a, this.f69115b, "reset    ", false, 4, null);
        ExoPlayer exoPlayer = this.f69117d;
        if (exoPlayer != null) {
            exoPlayer.stop();
        }
        for (com.transsion.player.orplayer.f fVar : this.f69133t) {
            if (fVar != null) {
                fVar.onPlayerReset();
            }
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void seekTo(long j11) {
        ExoPlayer exoPlayer;
        oo.e.d(oo.e.f71197a, this.f69115b, "seekTo    mills:" + j11, false, 4, null);
        ExoPlayer exoPlayer2 = this.f69117d;
        if ((exoPlayer2 != null ? exoPlayer2.c() : null) != null && (exoPlayer = this.f69117d) != null) {
            exoPlayer.prepare();
        }
        ExoPlayer exoPlayer3 = this.f69117d;
        if (exoPlayer3 != null) {
            exoPlayer3.seekTo(j11);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void seekTo(String uuid, long j11) {
        ExoPlayer exoPlayer;
        t O;
        t.h hVar;
        Intrinsics.h(uuid, "uuid");
        f.a.m(this, uuid, j11);
        ExoPlayer exoPlayer2 = this.f69117d;
        int F = exoPlayer2 != null ? exoPlayer2.F() : 0;
        for (int i11 = 0; i11 < F; i11++) {
            ExoPlayer exoPlayer3 = this.f69117d;
            if (Intrinsics.c((exoPlayer3 == null || (O = exoPlayer3.O(i11)) == null || (hVar = O.f10293b) == null) ? null : hVar.f10392h, uuid)) {
                ExoPlayer exoPlayer4 = this.f69117d;
                if ((exoPlayer4 != null ? exoPlayer4.c() : null) != null) {
                    prepare();
                }
                ExoPlayer exoPlayer5 = this.f69117d;
                if (exoPlayer5 == null || exoPlayer5.t() != i11) {
                    oo.e.d(oo.e.f71197a, this.f69115b, "seekTo  index:" + i11 + " uuid:" + uuid, false, 4, null);
                    ExoPlayer exoPlayer6 = this.f69117d;
                    if (exoPlayer6 != null) {
                        exoPlayer6.seekTo(i11, j11);
                    }
                } else {
                    if (isComplete() && (exoPlayer = this.f69117d) != null) {
                        exoPlayer.seekTo(j11);
                    }
                    oo.e.d(oo.e.f71197a, this.f69115b, "seekTo   uuid:" + uuid + " mills:" + j11 + "  是当前视频直接播放", false, 4, null);
                }
                play();
                return;
            }
        }
        oo.e.d(oo.e.f71197a, this.f69115b, "seekTo   uuid:" + uuid + " mills:" + j11 + "  没有找到", false, 4, null);
        pause();
    }

    @Override // com.transsion.player.orplayer.g
    public void setAutoPlay(boolean z10) {
        this.f69122i = z10;
        ExoPlayer exoPlayer = this.f69117d;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(z10);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setDataSource(ao.e mediaSource) {
        ExoPlayer exoPlayer;
        Intrinsics.h(mediaSource, "mediaSource");
        this.f69118e = mediaSource;
        if (A(mediaSource)) {
            androidx.media3.exoplayer.source.r s11 = s(mediaSource);
            if (s11 != null && (exoPlayer = this.f69117d) != null) {
                exoPlayer.U(s11);
            }
        } else {
            ExoPlayer exoPlayer2 = this.f69117d;
            if (exoPlayer2 != null) {
                exoPlayer2.H(r(mediaSource));
            }
        }
        for (com.transsion.player.orplayer.f fVar : this.f69133t) {
            if (fVar != null) {
                fVar.onSetDataSource();
            }
        }
        oo.e.d(oo.e.f71197a, this.f69115b, "setDataSource", false, 4, null);
    }

    @Override // com.transsion.player.orplayer.g
    public void setLooping(boolean z10) {
        this.f69123j = z10;
        ExoPlayer exoPlayer = this.f69117d;
        if (exoPlayer != null) {
            exoPlayer.setRepeatMode(z10 ? 1 : 0);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setMute(boolean z10) {
        this.f69124k = z10;
        ExoPlayer exoPlayer = this.f69117d;
        if (exoPlayer != null) {
            exoPlayer.A(z10, 1);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setPlayerConfig(bo.d dVar) {
        f.a.n(this, dVar);
    }

    @Override // com.transsion.player.orplayer.g
    public void setPlayerListener(com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        addPlayerListener(listener);
    }

    @Override // com.transsion.player.orplayer.g
    public void setScaleMode(ScaleMode scaleMode) {
        RenderScaleMode renderScaleMode;
        Intrinsics.h(scaleMode, "scaleMode");
        f.a.o(this, scaleMode);
        this.f69126m = scaleMode;
        int i11 = a.f69137a[scaleMode.ordinal()];
        if (i11 == 1) {
            renderScaleMode = RenderScaleMode.SCREEN_SCALE_MATCH_PARENT;
        } else if (i11 == 2) {
            renderScaleMode = RenderScaleMode.SCREEN_SCALE_DEFAULT;
        } else {
            if (i11 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            renderScaleMode = RenderScaleMode.SCREEN_SCALE_CENTER_CROP;
        }
        TextureRenderView textureRenderView = this.f69120g;
        if (textureRenderView != null) {
            textureRenderView.setScaleType(renderScaleMode);
        }
        SurfaceRenderView surfaceRenderView = this.f69119f;
        if (surfaceRenderView != null) {
            surfaceRenderView.setScaleType(renderScaleMode);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setSpeed(float f11) {
        this.f69125l = f11;
        ExoPlayer exoPlayer = this.f69117d;
        if (exoPlayer != null) {
            exoPlayer.a(f11);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setSurfaceView(SurfaceView surfaceView) {
        this.f69119f = surfaceView instanceof SurfaceRenderView ? (SurfaceRenderView) surfaceView : null;
        ExoPlayer exoPlayer = this.f69117d;
        if (exoPlayer != null) {
            exoPlayer.setVideoSurfaceView(surfaceView);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setTextureView(TextureView textureView) {
        this.f69120g = textureView instanceof TextureRenderView ? (TextureRenderView) textureView : null;
        ExoPlayer exoPlayer = this.f69117d;
        if (exoPlayer != null) {
            exoPlayer.setVideoTextureView(textureView);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setVipResolution(boolean z10, int i11) {
    }

    @Override // com.transsion.player.orplayer.g
    public void setVolume(float f11) {
        this.f69121h = Float.valueOf(f11);
        ExoPlayer exoPlayer = this.f69117d;
        if (exoPlayer != null) {
            exoPlayer.setVolume(f11);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void stop() {
        com.transsion.player.orplayer.c cVar = this.f69131r;
        if (cVar != null) {
            cVar.g(true);
        }
        oo.e.d(oo.e.f71197a, this.f69115b, "stop    ", false, 4, null);
        ExoPlayer exoPlayer = this.f69117d;
        if (exoPlayer != null) {
            exoPlayer.stop();
        }
        com.transsion.player.orplayer.c cVar2 = this.f69131r;
        if (cVar2 != null) {
            cVar2.b();
        }
    }
}
