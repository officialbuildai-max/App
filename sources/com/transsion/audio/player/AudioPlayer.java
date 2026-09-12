package com.transsion.audio.player;

import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.audio.viewmodel.HistoryListManager;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes5.dex */
public final class AudioPlayer {

    /* renamed from: i, reason: collision with root package name */
    public static final a f42943i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    private static final Lazy f42944j = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.audio.player.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            AudioPlayer x10;
            x10 = AudioPlayer.x();
            return x10;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private com.transsion.player.orplayer.g f42946b;

    /* renamed from: c, reason: collision with root package name */
    private com.transsion.audio.player.a f42947c;

    /* renamed from: d, reason: collision with root package name */
    private long f42948d;

    /* renamed from: e, reason: collision with root package name */
    private AudioBean f42949e;

    /* renamed from: f, reason: collision with root package name */
    private AudioBean f42950f;

    /* renamed from: a, reason: collision with root package name */
    private long f42945a = 1;

    /* renamed from: g, reason: collision with root package name */
    private List f42951g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private String f42952h = "";

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AudioPlayer a() {
            return (AudioPlayer) AudioPlayer.f42944j.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(boolean z10) {
        for (com.transsion.player.orplayer.f fVar : this.f42951g) {
            if (fVar != null) {
                fVar.onIsPlayingChanged(z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(ao.e eVar) {
        for (com.transsion.player.orplayer.f fVar : this.f42951g) {
            if (fVar != null) {
                fVar.onLoadingBegin(eVar);
            }
        }
        com.transsion.audio.player.a aVar = this.f42947c;
        if (aVar != null) {
            aVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(ao.e eVar) {
        for (com.transsion.player.orplayer.f fVar : this.f42951g) {
            if (fVar != null) {
                fVar.onLoadingEnd(eVar);
            }
        }
        com.transsion.audio.player.a aVar = this.f42947c;
        if (aVar != null) {
            aVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(int i11, float f11, ao.e eVar) {
        for (com.transsion.player.orplayer.f fVar : this.f42951g) {
            if (fVar != null) {
                fVar.onLoadingProgress(i11, f11, eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(ao.e eVar) {
        AudioBean audioBean = this.f42949e;
        if (audioBean == null || audioBean.getStatus() != 6) {
            com.transsion.audio.view.d.k().q(4);
            n(4);
            for (com.transsion.player.orplayer.f fVar : this.f42951g) {
                if (fVar != null) {
                    fVar.onVideoPause(eVar);
                }
            }
            com.transsion.audio.player.a aVar = this.f42947c;
            if (aVar != null) {
                aVar.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(ao.e eVar) {
        com.transsion.audio.view.d.k().q(3);
        n(3);
        for (com.transsion.player.orplayer.f fVar : this.f42951g) {
            if (fVar != null) {
                fVar.onVideoStart(eVar);
            }
        }
        com.transsion.audio.player.a aVar = this.f42947c;
        if (aVar != null) {
            aVar.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(PlayError playError, ao.e eVar) {
        n(7);
        for (com.transsion.player.orplayer.f fVar : this.f42951g) {
            if (fVar != null) {
                fVar.onPlayError(playError, eVar);
            }
        }
        com.transsion.audio.player.a aVar = this.f42947c;
        if (aVar != null) {
            aVar.e(playError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(ao.e eVar) {
        n(0);
        com.transsion.audio.view.d.k().q(0);
        for (com.transsion.player.orplayer.f fVar : this.f42951g) {
            if (fVar != null) {
                fVar.onPlayerRelease(eVar);
            }
        }
        com.transsion.audio.player.a aVar = this.f42947c;
        if (aVar != null) {
            aVar.b();
        }
        this.f42947c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(long j11, ao.e eVar) {
        com.transsion.audio.view.d.k().p(Long.valueOf(j11), Long.valueOf(this.f42945a));
        AudioBean audioBean = this.f42949e;
        if (audioBean != null) {
            audioBean.setReadProcess(Long.valueOf(j11));
        }
        if (System.currentTimeMillis() - this.f42948d > 1000) {
            for (com.transsion.player.orplayer.f fVar : this.f42951g) {
                if (fVar != null) {
                    fVar.onProgress(j11, eVar);
                }
            }
            AudioBean audioBean2 = this.f42949e;
            if (audioBean2 != null) {
                HistoryListManager.f43015e.b().w(audioBean2);
            }
            this.f42948d = System.currentTimeMillis();
            String str = this.f42952h;
            AudioBean audioBean3 = this.f42949e;
            if (!TextUtils.equals(str, audioBean3 != null ? audioBean3.getAudioUrl() : null)) {
                AudioBean audioBean4 = this.f42949e;
                this.f42952h = audioBean4 != null ? audioBean4.getAudioUrl() : null;
            }
        }
        com.transsion.audio.player.a aVar = this.f42947c;
        if (aVar != null) {
            aVar.f(j11);
        }
    }

    private final void n(int i11) {
        AudioBean audioBean = this.f42949e;
        int status = audioBean != null ? audioBean.getStatus() : 1;
        switch (i11) {
            case 2:
            case 3:
                status = 3;
                break;
            case 4:
            case 5:
                status = 4;
                break;
            case 6:
                status = 6;
                break;
            case 7:
                status = 7;
                break;
        }
        AudioBean audioBean2 = this.f42949e;
        if (audioBean2 == null || audioBean2.getStatus() != 6 || status < 4) {
            AudioBean audioBean3 = this.f42949e;
            if (audioBean3 != null) {
                audioBean3.setStatus(status);
            }
            AudioBean audioBean4 = this.f42949e;
            if (audioBean4 != null) {
                HistoryListManager.f43015e.b().k(audioBean4);
            }
            a.C0856a c0856a = lg.a.f68962a;
            AudioBean audioBean5 = this.f42949e;
            Integer valueOf = audioBean5 != null ? Integer.valueOf(audioBean5.getStatus()) : null;
            AudioBean audioBean6 = this.f42949e;
            a.C0856a.f(c0856a, "audio_log", "onStateChanged " + valueOf + " ..title.. " + (audioBean6 != null ? audioBean6.getTitle() : null), false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(ao.e eVar) {
        n(6);
        com.transsion.audio.view.d.k().q(6);
        for (com.transsion.player.orplayer.f fVar : this.f42951g) {
            if (fVar != null) {
                fVar.onCompletion(eVar);
            }
        }
        com.transsion.audio.player.a aVar = this.f42947c;
        if (aVar != null) {
            aVar.b();
        }
        this.f42947c = null;
    }

    private final void w() {
        l lVar = new l(Utils.a());
        this.f42946b = lVar;
        lVar.setPlayerListener(new com.transsion.player.orplayer.f() { // from class: com.transsion.audio.player.AudioPlayer$initPlayer$1
            @Override // com.transsion.player.orplayer.f
            public void canNonSubscriberPlay(boolean z10, int i11, int i12, mo.d dVar) {
                f.a.a(this, z10, i11, i12, dVar);
            }

            @Override // com.transsion.player.orplayer.f
            public void initPlayer() {
                f.a.b(this);
                a.C0856a.f(lg.a.f68962a, "audio_log", "AudioPlayer --> initPlayer --> initPlayer ...", false, 4, null);
            }

            @Override // com.transsion.player.orplayer.f
            public void onAliyunDecodeErrorChangeSoftwareDecoder(ao.e eVar) {
                f.a.c(this, eVar);
            }

            @Override // com.transsion.player.orplayer.f
            public void onBufferedPosition(long j11, ao.e eVar) {
                f.a.d(this, j11, eVar);
            }

            @Override // com.transsion.player.orplayer.f
            public void onCompletion(ao.e eVar) {
                f.a.e(this, eVar);
                AudioPlayer.this.o(eVar);
            }

            @Override // com.transsion.player.orplayer.f
            public void onFocusChange(boolean z10) {
                f.a.g(this, z10);
            }

            @Override // com.transsion.player.orplayer.f
            public void onIsPlayingChanged(boolean z10) {
                AudioPlayer.this.A(z10);
            }

            @Override // com.transsion.player.orplayer.f
            public void onLoadingBegin(ao.e eVar) {
                f.a.i(this, eVar);
                AudioPlayer.this.B(eVar);
            }

            @Override // com.transsion.player.orplayer.f
            public void onLoadingEnd(ao.e eVar) {
                f.a.k(this, eVar);
                AudioPlayer.this.C(eVar);
            }

            @Override // com.transsion.player.orplayer.f
            public void onLoadingProgress(int i11, float f11, ao.e eVar) {
                f.a.m(this, i11, f11, eVar);
                AudioPlayer.this.D(i11, f11, eVar);
            }

            @Override // com.transsion.player.orplayer.f
            public void onLoopingStart() {
                f.a.o(this);
            }

            @Override // com.transsion.player.orplayer.f
            public void onMediaItemTransition(String str) {
                f.a.p(this, str);
            }

            @Override // com.transsion.player.orplayer.f
            public void onPlayError(PlayError errorInfo, ao.e eVar) {
                Intrinsics.h(errorInfo, "errorInfo");
                f.a.q(this, errorInfo, eVar);
                AudioPlayer.this.H(errorInfo, eVar);
            }

            @Override // com.transsion.player.orplayer.f
            public void onPlayerRelease(ao.e eVar) {
                f.a.t(this, eVar);
                AudioPlayer.this.I(eVar);
            }

            @Override // com.transsion.player.orplayer.f
            public void onPlayerReset() {
                f.a.v(this);
            }

            @Override // com.transsion.player.orplayer.f
            public void onPrepare(ao.e eVar) {
                f.a.w(this, eVar);
                a.C0856a.f(lg.a.f68962a, "audio_log", "AudioPlayer --> initPlayer -->onPrepare ...", false, 4, null);
                AudioPlayer audioPlayer = AudioPlayer.this;
                com.transsion.player.orplayer.g v11 = audioPlayer.v();
                audioPlayer.Q(v11 != null ? v11.getDuration() : 1L);
                AudioBean u11 = AudioPlayer.this.u();
                if (u11 != null) {
                    u11.setDuration(Long.valueOf(AudioPlayer.this.s()));
                }
                AudioPlayer audioPlayer2 = AudioPlayer.this;
                audioPlayer2.R(audioPlayer2.u());
                if (AudioPlayer.this.t() == null) {
                    com.transsion.player.orplayer.g v12 = AudioPlayer.this.v();
                    if (v12 != null) {
                        v12.play();
                        return;
                    }
                    return;
                }
                kotlinx.coroutines.k.d(o0.a(y0.a()), null, null, new AudioPlayer$initPlayer$1$onPrepare$1(AudioPlayer.this, null), 3, null);
                com.transsion.player.orplayer.g v13 = AudioPlayer.this.v();
                if (v13 != null) {
                    v13.play();
                }
            }

            @Override // com.transsion.player.orplayer.f
            public void onProgress(long j11, ao.e eVar) {
                f.a.y(this, j11, eVar);
                AudioPlayer.this.M(j11, eVar);
            }

            @Override // com.transsion.player.orplayer.f
            public void onRenderFirstFrame() {
                f.a.A(this);
                a r11 = AudioPlayer.this.r();
                if (r11 != null) {
                    r11.g();
                }
            }

            @Override // com.transsion.player.orplayer.f
            public void onSetDataSource() {
                f.a.B(this);
            }

            @Override // com.transsion.player.orplayer.f
            public void onTracksAudioBitrateChange(int i11) {
                f.a.C(this, i11);
            }

            @Override // com.transsion.player.orplayer.f
            public void onTracksChange(mo.c cVar) {
                f.a.D(this, cVar);
            }

            @Override // com.transsion.player.orplayer.f
            public void onTracksVideoBitrateChange(int i11) {
                f.a.E(this, i11);
            }

            @Override // com.transsion.player.orplayer.f
            public void onVideoPause(ao.e eVar) {
                f.a.F(this, eVar);
                AudioPlayer.this.E(eVar);
                a.C0856a.f(lg.a.f68962a, "player", "AudioPlayer --> initPlayer --> onStateChanged 4 ...", false, 4, null);
            }

            @Override // com.transsion.player.orplayer.f
            public void onVideoSizeChanged(int i11, int i12) {
                f.a.H(this, i11, i12);
                a.C0856a.f(lg.a.f68962a, "audio_log", "AudioPlayer --> initPlayer --> onVideoSizeChanged ...", false, 4, null);
            }

            @Override // com.transsion.player.orplayer.f
            public void onVideoStart(ao.e eVar) {
                f.a.I(this, eVar);
                AudioPlayer.this.F(eVar);
                a.C0856a.f(lg.a.f68962a, "player", "onStateChanged 3 ...", false, 4, null);
            }

            @Override // com.transsion.player.orplayer.f
            public void setOnSeekCompleteListener() {
                f.a.K(this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AudioPlayer x() {
        return new AudioPlayer();
    }

    public final void G() {
        com.transsion.player.orplayer.g gVar = this.f42946b;
        if (gVar != null) {
            gVar.pause();
        }
    }

    public final boolean J() {
        com.transsion.player.orplayer.g gVar = this.f42946b;
        if (gVar != null) {
            return gVar.isPlaying();
        }
        return false;
    }

    public final void K() {
        com.transsion.player.orplayer.g gVar = this.f42946b;
        if (gVar != null) {
            gVar.prepare();
        }
    }

    public final void L(AudioBean audio) {
        Intrinsics.h(audio, "audio");
        if (this.f42946b == null) {
            w();
        }
        a.C0856a.f(lg.a.f68962a, "audio_log", "AudioPlayer --> prepare --> " + audio, false, 4, null);
        this.f42950f = audio;
        com.transsion.audio.player.a aVar = this.f42947c;
        if (aVar != null) {
            if (aVar != null) {
                aVar.b();
            }
            this.f42947c = null;
        }
        this.f42947c = new com.transsion.audio.player.a(audio);
        String url = audio.getUrl();
        if (url != null) {
            com.transsion.player.orplayer.g gVar = this.f42946b;
            if (gVar != null) {
                gVar.stop();
            }
            com.transsion.player.orplayer.g gVar2 = this.f42946b;
            if (gVar2 != null) {
                gVar2.setDataSource(new ao.e(url, url, 0, null, null, 28, null));
            }
            com.transsion.player.orplayer.g gVar3 = this.f42946b;
            if (gVar3 != null) {
                gVar3.prepare();
            }
        }
        for (com.transsion.player.orplayer.f fVar : this.f42951g) {
            if (fVar != null) {
                fVar.onPrepare(new ao.e(audio.getAudioUrl(), audio.getAudioUrl(), 0, null, null, 28, null));
            }
        }
    }

    public final void N() {
        com.transsion.player.orplayer.g gVar = this.f42946b;
        if (gVar != null) {
            gVar.release();
        }
        this.f42946b = null;
        this.f42949e = null;
        com.transsion.audio.player.a aVar = this.f42947c;
        if (aVar != null) {
            aVar.b();
        }
        this.f42947c = null;
    }

    public final void O(com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        this.f42951g.remove(listener);
    }

    public final void P(long j11) {
        com.transsion.player.orplayer.g gVar = this.f42946b;
        if (gVar != null) {
            gVar.seekTo(j11);
        }
    }

    public final void Q(long j11) {
        this.f42945a = j11;
    }

    public final void R(AudioBean audioBean) {
        this.f42949e = audioBean;
    }

    public final void S() {
        com.transsion.player.orplayer.g gVar = this.f42946b;
        if (gVar != null) {
            gVar.play();
        }
    }

    public final void T() {
        com.transsion.player.orplayer.g gVar = this.f42946b;
        if (gVar != null) {
            gVar.stop();
        }
    }

    public final void m(com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        this.f42951g.add(listener);
    }

    public final boolean p() {
        return this.f42946b == null;
    }

    public final void q() {
        com.transsion.player.orplayer.g gVar = this.f42946b;
        if (gVar != null) {
            gVar.stop();
        }
        N();
    }

    public final com.transsion.audio.player.a r() {
        return this.f42947c;
    }

    public final long s() {
        return this.f42945a;
    }

    public final AudioBean t() {
        return this.f42949e;
    }

    public final AudioBean u() {
        return this.f42950f;
    }

    public final com.transsion.player.orplayer.g v() {
        return this.f42946b;
    }

    public final boolean y(AudioBean audio) {
        Intrinsics.h(audio, "audio");
        String audioUrl = audio.getAudioUrl();
        AudioBean audioBean = this.f42949e;
        return TextUtils.equals(audioUrl, audioBean != null ? audioBean.getAudioUrl() : null);
    }

    public final boolean z(String audioUrl) {
        Intrinsics.h(audioUrl, "audioUrl");
        AudioBean audioBean = this.f42949e;
        return TextUtils.equals(audioUrl, audioBean != null ? audioBean.getAudioUrl() : null);
    }
}
