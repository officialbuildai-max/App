package com.transsion.postdetail.ui.fragment;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.fragment.app.FragmentActivity;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import com.transsion.postdetail.layer.listener.LayerFlag;
import com.transsion.postdetail.util.LocalVideoAdHelper;
import com.transsion.room.api.IAudioApi;
import com.transsion.subtitle.VideoSubtitleControl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class LocalVideoDetailFragment$playerListener$1 implements com.transsion.player.orplayer.f {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LocalVideoDetailFragment f49592a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalVideoDetailFragment$playerListener$1(LocalVideoDetailFragment localVideoDetailFragment) {
        this.f49592a = localVideoDetailFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(LocalVideoDetailFragment localVideoDetailFragment) {
        com.transsion.player.orplayer.g gVar = localVideoDetailFragment.orPlayer;
        if (gVar != null) {
            gVar.play();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(LocalVideoDetailFragment localVideoDetailFragment) {
        localVideoDetailFragment.j2().h(LayerFlag.PLAYER_FOREGROUND, Boolean.FALSE);
        com.transsion.player.orplayer.g gVar = localVideoDetailFragment.orPlayer;
        if (gVar != null) {
            gVar.play();
        }
        return Unit.f67184a;
    }

    @Override // com.transsion.player.orplayer.f
    public void canNonSubscriberPlay(boolean z10, int i11, int i12, mo.d dVar) {
        f.a.a(this, z10, i11, i12, dVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void initPlayer() {
        f.a.b(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void onAliyunDecodeErrorChangeSoftwareDecoder(ao.e eVar) {
        com.transsion.postdetail.layer.local.c0 c0Var = this.f49592a.localVideoDot;
        if (c0Var != null) {
            c0Var.z(true);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onBufferedPosition(long j11, ao.e eVar) {
        f.a.d(this, j11, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onCompletion(ao.e eVar) {
        com.transsion.postdetail.layer.local.c0 c0Var = this.f49592a.localVideoDot;
        if (c0Var != null) {
            c0Var.i();
        }
        a.C0856a.f(lg.a.f68962a, this.f49592a.TAG, "onCompletion", false, 4, null);
        this.f49592a.e3();
        this.f49592a.localVideoAdHelper.o2();
    }

    @Override // com.transsion.player.orplayer.f
    public void onFocusChange(boolean z10) {
        f.a.g(this, z10);
    }

    @Override // com.transsion.player.orplayer.f
    public void onIsPlayingChanged(boolean z10) {
        a.C0856a.f(lg.a.f68962a, this.f49592a.TAG, "onIsPlayingChanged：" + z10, false, 4, null);
        VideoSubtitleControl videoSubtitleControl = this.f49592a.subtitleControl;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.d0(z10);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingBegin(ao.e eVar) {
        com.transsion.postdetail.layer.local.c0 c0Var = this.f49592a.localVideoDot;
        if (c0Var != null) {
            c0Var.j();
        }
        a.C0856a.f(lg.a.f68962a, this.f49592a.TAG, "onLoadingBegin", false, 4, null);
        this.f49592a.j2().g(LayerFlag.LOADING_BEGIN, Boolean.FALSE);
        if (this.f49592a.isDownloadingPlay) {
            this.f49592a.a2();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingEnd(ao.e eVar) {
        Handler handler;
        com.transsion.postdetail.layer.local.c0 c0Var = this.f49592a.localVideoDot;
        if (c0Var != null) {
            c0Var.k();
        }
        a.C0856a.f(lg.a.f68962a, this.f49592a.TAG, "onLoadingEnd", false, 4, null);
        handler = this.f49592a.getHandler();
        handler.removeCallbacksAndMessages(null);
        this.f49592a.j2().g(LayerFlag.LOADING_END, Boolean.FALSE);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingProgress(int i11, float f11, ao.e eVar) {
        f.a.m(this, i11, f11, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoopingStart() {
        a.C0856a.f(lg.a.f68962a, this.f49592a.TAG, "onLoopingStart", false, 4, null);
        this.f49592a.j2().g(LayerFlag.LOOPING_START, new Object[0]);
    }

    @Override // com.transsion.player.orplayer.f
    public void onMediaItemTransition(String str) {
        f.a.p(this, str);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayError(PlayError errorInfo, ao.e eVar) {
        boolean z10;
        Intrinsics.h(errorInfo, "errorInfo");
        this.f49592a.u3();
        this.f49592a.errorInfo = errorInfo;
        com.transsion.postdetail.layer.local.c0 c0Var = this.f49592a.localVideoDot;
        if (c0Var != null) {
            c0Var.m(errorInfo);
        }
        a.C0856a c0856a = lg.a.f68962a;
        c0856a.i("long_video_play", "onPlayError()  errorCode:" + errorInfo.getErrorCode() + " errorMessage:" + errorInfo.getErrorMessage() + "  playProgress = " + this.f49592a.playProgress + " url:" + (eVar != null ? eVar.k() : null) + " --> 长播放失败了", true);
        this.f49592a.j2().g(LayerFlag.PLAY_ERROR, errorInfo);
        LocalVideoDetailFragment localVideoDetailFragment = this.f49592a;
        Integer errorCode = errorInfo.getErrorCode();
        localVideoDetailFragment.isPlayerNetTimeout = errorCode != null && errorCode.intValue() == 537067524;
        if (this.f49592a.playProgress > 0) {
            LocalVideoDetailFragment localVideoDetailFragment2 = this.f49592a;
            LocalVideoDetailFragment.w3(localVideoDetailFragment2, localVideoDetailFragment2.downloadBean, this.f49592a.playProgress, false, 4, null);
        }
        if (nh.m.f70597a.e()) {
            z10 = this.f49592a.isPlayerNetTimeout;
            if (z10) {
                return;
            }
            c0856a.x("long_video_play", "video error，reload~~ from onPlayError", true);
            LocalVideoDetailFragment.s3(this.f49592a, false, 1, null);
            return;
        }
        a.C0856a.f(c0856a, this.f49592a.TAG, "onPlayError， not net----", false, 4, null);
        DownloadBean downloadBean = this.f49592a.downloadBean;
        if ((downloadBean != null ? downloadBean.getProgress() : 0L) > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            this.f49592a.j2().g(LayerFlag.LOADING_END, new Object[0]);
            this.f49592a.j2().h(LayerFlag.NETWORK_CHANGE, Boolean.FALSE);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerRelease(ao.e eVar) {
        f.a.t(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerReset() {
        a.C0856a.f(lg.a.f68962a, this.f49592a.TAG, "onPlayerReset", false, 4, null);
        this.f49592a.j2().g(LayerFlag.PLAYER_RESET, new Object[0]);
        this.f49592a.localVideoAdHelper.q2();
    }

    @Override // com.transsion.player.orplayer.f
    public void onPrepare(ao.e eVar) {
        this.f49592a.u3();
        this.f49592a.isPlayerNetTimeout = false;
        this.f49592a.isPrepare = true;
        a.C0856a c0856a = lg.a.f68962a;
        String str = this.f49592a.TAG;
        DownloadBean downloadBean = this.f49592a.downloadBean;
        a.C0856a.f(c0856a, str, "onPrepare, epse = " + (downloadBean != null ? Integer.valueOf(downloadBean.getEpse()) : null), false, 4, null);
        if (this.f49592a.downloadBean == null) {
            kotlinx.coroutines.k.d(androidx.view.v.a(this.f49592a), kotlinx.coroutines.y0.b(), null, new LocalVideoDetailFragment$playerListener$1$onPrepare$1(this.f49592a, null), 2, null);
        } else {
            kotlinx.coroutines.k.d(androidx.view.v.a(this.f49592a), kotlinx.coroutines.y0.c(), null, new LocalVideoDetailFragment$playerListener$1$onPrepare$2(this.f49592a, null), 2, null);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onProgress(long j11, ao.e eVar) {
        com.transsion.postdetail.layer.local.c0 c0Var = this.f49592a.localVideoDot;
        if (c0Var != null) {
            c0Var.n(j11);
        }
        this.f49592a.playProgress = j11;
        this.f49592a.j2().g(LayerFlag.PROGRESS, Long.valueOf(j11));
        LocalVideoAdHelper localVideoAdHelper = this.f49592a.localVideoAdHelper;
        final LocalVideoDetailFragment localVideoDetailFragment = this.f49592a;
        localVideoAdHelper.N(j11, new Function0() { // from class: com.transsion.postdetail.ui.fragment.s0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit c11;
                c11 = LocalVideoDetailFragment$playerListener$1.c(LocalVideoDetailFragment.this);
                return c11;
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void onRenderFirstFrame() {
        com.transsion.postdetail.layer.local.c0 c0Var = this.f49592a.localVideoDot;
        if (c0Var != null) {
            c0Var.o();
        }
        a.C0856a.f(lg.a.f68962a, this.f49592a.TAG, "onRenderFirstFrame", false, 4, null);
        this.f49592a.j2().g(LayerFlag.RENDER_FIRST_FRAME, new Object[0]);
        com.transsion.player.orplayer.g gVar = this.f49592a.orPlayer;
        if (gVar != null) {
            gVar.pause();
        }
        LocalVideoAdHelper localVideoAdHelper = this.f49592a.localVideoAdHelper;
        final LocalVideoDetailFragment localVideoDetailFragment = this.f49592a;
        localVideoAdHelper.S1(new Function0() { // from class: com.transsion.postdetail.ui.fragment.t0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit d11;
                d11 = LocalVideoDetailFragment$playerListener$1.d(LocalVideoDetailFragment.this);
                return d11;
            }
        });
    }

    @Override // com.transsion.player.orplayer.f
    public void onSetDataSource() {
        f.a.B(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksAudioBitrateChange(int i11) {
        f.a.C(this, i11);
        com.transsion.postdetail.layer.local.c0 c0Var = this.f49592a.localVideoDot;
        if (c0Var != null) {
            c0Var.u(i11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksChange(mo.c cVar) {
        f.a.D(this, cVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksVideoBitrateChange(int i11) {
        f.a.E(this, i11);
        com.transsion.postdetail.layer.local.c0 c0Var = this.f49592a.localVideoDot;
        if (c0Var != null) {
            c0Var.v(i11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoPause(ao.e eVar) {
        this.f49592a.D3(true);
        com.transsion.postdetail.layer.local.c0 c0Var = this.f49592a.localVideoDot;
        if (c0Var != null) {
            c0Var.w();
        }
        a.C0856a.f(lg.a.f68962a, this.f49592a.TAG, "onVideoPause", false, 4, null);
        FragmentActivity activity = this.f49592a.getActivity();
        if (activity != null) {
            com.transsion.postdetail.util.t.f50233a.b(activity, false);
        }
        this.f49592a.j2().g(LayerFlag.VIDEO_PAUSE, new Object[0]);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoSizeChanged(int i11, int i12) {
        this.f49592a.videoWidth = i11;
        this.f49592a.videoHeight = i12;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, this.f49592a.TAG, "onVideoSizeChanged", false, 4, null);
        a.C0856a.f(c0856a, this.f49592a.TAG, "onVideoSizeChanged width:" + i11 + ",height:" + i12, false, 4, null);
        this.f49592a.j2().g(LayerFlag.VIDEO_SIZE_CHANGED, Integer.valueOf(i11), Integer.valueOf(i12));
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoStart(ao.e eVar) {
        Runnable runnable;
        IAudioApi e22;
        this.f49592a.u3();
        this.f49592a.D3(false);
        com.transsion.postdetail.layer.local.c0 c0Var = this.f49592a.localVideoDot;
        if (c0Var != null) {
            c0Var.x();
        }
        a.C0856a.f(lg.a.f68962a, this.f49592a.TAG, "onVideoStart", false, 4, null);
        Handler handler = this.f49592a.playingDownloadHandler;
        runnable = this.f49592a.notNetRunnable;
        handler.removeCallbacks(runnable);
        this.f49592a.j2().g(LayerFlag.VIDEO_START, new Object[0]);
        this.f49592a.j2().g(LayerFlag.LOADING_END, new Object[0]);
        e22 = this.f49592a.e2();
        if (e22 != null) {
            e22.pause();
        }
        this.f49592a.I3();
        this.f49592a.localVideoAdHelper.s2();
    }

    @Override // com.transsion.player.orplayer.f
    public void setOnSeekCompleteListener() {
        f.a.K(this);
    }
}
