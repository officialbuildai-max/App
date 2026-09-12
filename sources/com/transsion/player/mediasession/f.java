package com.transsion.player.mediasession;

import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import ko.l0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class f extends MediaSessionCompat.b {

    /* renamed from: i, reason: collision with root package name */
    public static final a f48449i = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private final MediaSessionCompat f48450f;

    /* renamed from: g, reason: collision with root package name */
    private final MediaService f48451g;

    /* renamed from: h, reason: collision with root package name */
    private MediaItem f48452h;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f(MediaSessionCompat mediaSessionCompat, MediaService mediaService) {
        Intrinsics.h(mediaService, "mediaService");
        this.f48450f = mediaSessionCompat;
        this.f48451g = mediaService;
    }

    private final void E(PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat != null) {
            h.f48453a.o(this.f48451g, this.f48452h, Integer.valueOf(playbackStateCompat.getState()), this.f48450f);
        }
    }

    private final String F() {
        String simpleName = f.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final PlaybackStateCompat G(int i11) {
        Long position;
        MediaItem mediaItem = this.f48452h;
        PlaybackStateCompat a11 = new PlaybackStateCompat.d().b(775L).c(i11, (mediaItem == null || (position = mediaItem.getPosition()) == null) ? 0L : position.longValue(), 1.0f).a();
        MediaSessionCompat mediaSessionCompat = this.f48450f;
        if (mediaSessionCompat != null) {
            mediaSessionCompat.i(a11);
        }
        Intrinsics.e(a11);
        return a11;
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.b
    public void A() {
        super.A();
        i.f48462a.a(F() + " --> mediaSessionCallback --> onSkipToPrevious() -- 暂不处理该事件");
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.b
    public void C() {
        super.C();
        i.f48462a.a(F() + " --> mediaSessionCallback --> onStop()");
        G(1);
        com.transsion.player.orplayer.g h11 = l0.f67091a.h();
        if (h11 != null) {
            h11.release();
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.b
    public void e(String str, Bundle bundle) {
        Long duration;
        super.e(str, bundle);
        PlaybackStateCompat playbackStateCompat = null;
        this.f48452h = bundle != null ? (MediaItem) bundle.getParcelable("MediaItem") : null;
        if (Intrinsics.c(str, "transsion_play")) {
            MediaSessionCompat mediaSessionCompat = this.f48450f;
            if (mediaSessionCompat != null) {
                MediaMetadataCompat.b bVar = new MediaMetadataCompat.b();
                MediaItem mediaItem = this.f48452h;
                MediaMetadataCompat.b c11 = bVar.c(MediaMetadataCompat.METADATA_KEY_MEDIA_ID, mediaItem != null ? mediaItem.getMediaId() : null);
                MediaItem mediaItem2 = this.f48452h;
                mediaSessionCompat.h(c11.b(MediaMetadataCompat.METADATA_KEY_DURATION, (mediaItem2 == null || (duration = mediaItem2.getDuration()) == null) ? 0L : duration.longValue()).a());
            }
            playbackStateCompat = G(3);
        } else if (Intrinsics.c(str, "transsion_pause")) {
            playbackStateCompat = G(2);
        }
        E(playbackStateCompat);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.b
    public void h() {
        super.h();
        i.f48462a.a(F() + " --> mediaSessionCallback --> onPause()");
        E(G(2));
        com.transsion.player.orplayer.g h11 = l0.f67091a.h();
        if (h11 != null) {
            h11.pause();
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.b
    public void i() {
        super.i();
        i.f48462a.a(F() + " --> mediaSessionCallback --> onPlay()");
        E(G(3));
        com.transsion.player.orplayer.g h11 = l0.f67091a.h();
        if (h11 != null) {
            h11.play();
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.b
    public void s(long j11) {
        super.s(j11);
        MediaItem mediaItem = this.f48452h;
        if (mediaItem != null) {
            mediaItem.setPosition(Long.valueOf(j11));
        }
        i.f48462a.a(F() + " --> mediaSessionCallback --> onSeekTo() --> mediaItem = " + this.f48452h);
        com.transsion.player.orplayer.g h11 = l0.f67091a.h();
        if (h11 != null) {
            h11.seekTo(j11);
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.b
    public void z() {
        super.z();
        i.f48462a.a(F() + " --> mediaSessionCallback --> onSkipToNext() -- 暂不处理该事件");
    }
}
