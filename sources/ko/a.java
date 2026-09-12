package ko;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.transsion.player.mediasession.MediaBrowserCompatHelper;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a implements com.transsion.player.orplayer.f {

    /* renamed from: b, reason: collision with root package name */
    private long f67036b;

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList f67035a = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final int f67037c = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;

    private final String b() {
        String simpleName = a.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final String c(long j11) {
        SimpleDateFormat simpleDateFormat = j11 >= 3600000 ? new SimpleDateFormat("H:mm:ss") : new SimpleDateFormat("mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        String format = simpleDateFormat.format(Long.valueOf(j11));
        Intrinsics.g(format, "format(...)");
        return format;
    }

    public final void a(com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        if (this.f67035a.contains(listener)) {
            return;
        }
        this.f67035a.add(listener);
    }

    @Override // com.transsion.player.orplayer.f
    public void canNonSubscriberPlay(boolean z10, int i11, int i12, mo.d dashVideoTracksGroup) {
        Intrinsics.h(dashVideoTracksGroup, "dashVideoTracksGroup");
        f.a.a(this, z10, i11, i12, dashVideoTracksGroup);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).canNonSubscriberPlay(z10, i11, i12, dashVideoTracksGroup);
        }
    }

    public final void d(com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        this.f67035a.remove(listener);
    }

    @Override // com.transsion.player.orplayer.f
    public void initPlayer() {
        f.a.b(this);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).initPlayer();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onAliyunDecodeErrorChangeSoftwareDecoder(ao.e eVar) {
        f.a.c(this, eVar);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onAliyunDecodeErrorChangeSoftwareDecoder(eVar);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onBufferedPosition(long j11, ao.e eVar) {
        f.a.d(this, j11, eVar);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onBufferedPosition(j11, eVar);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onCompletion(ao.e eVar) {
        f.a.e(this, eVar);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onCompletion(eVar);
        }
        com.transsion.player.mediasession.i.f48462a.a(b() + " --> onCompletion() --> 刷新通知栏");
        MediaBrowserCompatHelper.f48435h.a().r(eVar != null ? eVar.i() : null);
    }

    @Override // com.transsion.player.orplayer.f
    public void onFocusChange(boolean z10) {
        f.a.g(this, z10);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onFocusChange(z10);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onIsPlayingChanged(boolean z10) {
        f.a.h(this, z10);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onIsPlayingChanged(z10);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingBegin(ao.e eVar) {
        f.a.i(this, eVar);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onLoadingBegin(eVar);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingEnd(ao.e eVar) {
        f.a.k(this, eVar);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onLoadingEnd(eVar);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingProgress(int i11, float f11, ao.e eVar) {
        f.a.m(this, i11, f11, eVar);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onLoadingProgress(i11, f11, eVar);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoopingStart() {
        f.a.o(this);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onLoopingStart();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onMediaItemTransition(String str) {
        f.a.p(this, str);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onMediaItemTransition(str);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayError(PlayError errorInfo, ao.e eVar) {
        Intrinsics.h(errorInfo, "errorInfo");
        f.a.q(this, errorInfo, eVar);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onPlayError(errorInfo, eVar);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerRelease(ao.e eVar) {
        f.a.t(this, eVar);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onPlayerRelease(eVar);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerReset() {
        f.a.v(this);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onPlayerReset();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onPrepare(ao.e eVar) {
        f.a.w(this, eVar);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onPrepare(eVar);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onProgress(long j11, ao.e eVar) {
        MediaItem i11;
        MediaItem i12;
        f.a.y(this, j11, eVar);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onProgress(j11, eVar);
        }
        if (System.currentTimeMillis() - this.f67036b > this.f67037c) {
            this.f67036b = System.currentTimeMillis();
            if (eVar != null && (i12 = eVar.i()) != null) {
                com.transsion.player.orplayer.g h11 = l0.f67091a.h();
                i12.setDuration(h11 != null ? Long.valueOf(h11.getDuration()) : null);
            }
            if (eVar != null && (i11 = eVar.i()) != null) {
                i11.setPosition(Long.valueOf(j11));
            }
            MediaBrowserCompatHelper.f48435h.a().t(eVar != null ? eVar.i() : null);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onRenderFirstFrame() {
        f.a.A(this);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onRenderFirstFrame();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onSetDataSource() {
        f.a.B(this);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onSetDataSource();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksAudioBitrateChange(int i11) {
        f.a.C(this, i11);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onTracksAudioBitrateChange(i11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksChange(mo.c tracks) {
        Intrinsics.h(tracks, "tracks");
        f.a.D(this, tracks);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onTracksChange(tracks);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksVideoBitrateChange(int i11) {
        f.a.E(this, i11);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onTracksVideoBitrateChange(i11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoPause(ao.e eVar) {
        MediaItem i11;
        MediaItem i12;
        MediaItem i13;
        MediaItem i14;
        Long position;
        f.a.F(this, eVar);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onVideoPause(eVar);
        }
        com.transsion.player.mediasession.i.f48462a.a(b() + " --> onVideoPause() --> 刷新通知栏 --> position = " + c((eVar == null || (i14 = eVar.i()) == null || (position = i14.getPosition()) == null) ? 0L : position.longValue()) + " --> position = " + ((eVar == null || (i13 = eVar.i()) == null) ? null : i13.getPosition()));
        if (eVar != null && (i12 = eVar.i()) != null) {
            com.transsion.player.orplayer.g h11 = l0.f67091a.h();
            i12.setDuration(h11 != null ? Long.valueOf(h11.getDuration()) : null);
        }
        if (eVar != null && (i11 = eVar.i()) != null) {
            com.transsion.player.orplayer.g h12 = l0.f67091a.h();
            i11.setPosition(h12 != null ? Long.valueOf(h12.getCurrentPosition()) : null);
        }
        MediaBrowserCompatHelper.f48435h.a().r(eVar != null ? eVar.i() : null);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoSizeChanged(int i11, int i12) {
        f.a.H(this, i11, i12);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onVideoSizeChanged(i11, i12);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoStart(ao.e eVar) {
        MediaItem i11;
        MediaItem i12;
        MediaItem i13;
        MediaItem i14;
        Long position;
        f.a.I(this, eVar);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onVideoStart(eVar);
        }
        com.transsion.player.mediasession.i.f48462a.a(b() + " --> onVideoStart() --> 刷新通知栏 --> position = " + c((eVar == null || (i14 = eVar.i()) == null || (position = i14.getPosition()) == null) ? 0L : position.longValue()) + " --> position = " + ((eVar == null || (i13 = eVar.i()) == null) ? null : i13.getPosition()));
        if (eVar != null && (i12 = eVar.i()) != null) {
            com.transsion.player.orplayer.g h11 = l0.f67091a.h();
            i12.setDuration(h11 != null ? Long.valueOf(h11.getDuration()) : null);
        }
        if (eVar != null && (i11 = eVar.i()) != null) {
            com.transsion.player.orplayer.g h12 = l0.f67091a.h();
            i11.setPosition(h12 != null ? Long.valueOf(h12.getCurrentPosition()) : null);
        }
        MediaBrowserCompatHelper.f48435h.a().t(eVar != null ? eVar.i() : null);
    }

    @Override // com.transsion.player.orplayer.f
    public void setOnSeekCompleteListener() {
        Long position;
        ao.e currentMediaSource;
        f.a.K(this);
        Iterator it = this.f67035a.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).setOnSeekCompleteListener();
        }
        l0 l0Var = l0.f67091a;
        com.transsion.player.orplayer.g h11 = l0Var.h();
        MediaItem i11 = (h11 == null || (currentMediaSource = h11.currentMediaSource()) == null) ? null : currentMediaSource.i();
        if (i11 != null) {
            com.transsion.player.orplayer.g h12 = l0Var.h();
            i11.setDuration(h12 != null ? Long.valueOf(h12.getDuration()) : null);
        }
        if (i11 != null) {
            com.transsion.player.orplayer.g h13 = l0Var.h();
            i11.setPosition(h13 != null ? Long.valueOf(h13.getCurrentPosition()) : null);
        }
        com.transsion.player.mediasession.i.f48462a.a(b() + " --> setOnSeekCompleteListener() --> 刷新通知栏 --> position = " + c((i11 == null || (position = i11.getPosition()) == null) ? 0L : position.longValue()) + " --> position = " + (i11 != null ? i11.getPosition() : null));
        MediaBrowserCompatHelper.f48435h.a().t(i11);
    }
}
