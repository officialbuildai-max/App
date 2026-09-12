package androidx.media3.common;

import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.common.p;
import androidx.media3.common.util.a1;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public interface a0 {

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        public static final b f9874b = new a().e();

        /* renamed from: c, reason: collision with root package name */
        private static final String f9875c = a1.C0(0);

        /* renamed from: a, reason: collision with root package name */
        private final p f9876a;

        /* loaded from: classes2.dex */
        public static final class a {

            /* renamed from: b, reason: collision with root package name */
            private static final int[] f9877b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 31, 20, 21, 22, 23, 24, 25, 33, 26, 34, 35, 27, 28, 29, 30, 32};

            /* renamed from: a, reason: collision with root package name */
            private final p.b f9878a = new p.b();

            public a a(int i11) {
                this.f9878a.a(i11);
                return this;
            }

            public a b(b bVar) {
                this.f9878a.b(bVar.f9876a);
                return this;
            }

            public a c(int... iArr) {
                this.f9878a.c(iArr);
                return this;
            }

            public a d(int i11, boolean z10) {
                this.f9878a.d(i11, z10);
                return this;
            }

            public b e() {
                return new b(this.f9878a.e());
            }
        }

        private b(p pVar) {
            this.f9876a = pVar;
        }

        public boolean b(int i11) {
            return this.f9876a.a(i11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f9876a.equals(((b) obj).f9876a);
            }
            return false;
        }

        public int hashCode() {
            return this.f9876a.hashCode();
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final p f9879a;

        public c(p pVar) {
            this.f9879a = pVar;
        }

        public boolean a(int i11) {
            return this.f9879a.a(i11);
        }

        public boolean b(int... iArr) {
            return this.f9879a.b(iArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                return this.f9879a.equals(((c) obj).f9879a);
            }
            return false;
        }

        public int hashCode() {
            return this.f9879a.hashCode();
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void onAudioSessionIdChanged(int i11);

        void onAvailableCommandsChanged(b bVar);

        void onCues(List list);

        void onCues(u1.b bVar);

        void onDeviceInfoChanged(m mVar);

        void onDeviceVolumeChanged(int i11, boolean z10);

        void onEvents(a0 a0Var, c cVar);

        void onIsLoadingChanged(boolean z10);

        void onIsPlayingChanged(boolean z10);

        void onLoadingChanged(boolean z10);

        void onMediaItemTransition(t tVar, int i11);

        void onMediaMetadataChanged(v vVar);

        void onMetadata(x xVar);

        void onPlayWhenReadyChanged(boolean z10, int i11);

        void onPlaybackParametersChanged(z zVar);

        void onPlaybackStateChanged(int i11);

        void onPlaybackSuppressionReasonChanged(int i11);

        void onPlayerError(PlaybackException playbackException);

        void onPlayerErrorChanged(PlaybackException playbackException);

        void onPlayerStateChanged(boolean z10, int i11);

        void onPositionDiscontinuity(int i11);

        void onPositionDiscontinuity(e eVar, e eVar2, int i11);

        void onRenderedFirstFrame();

        void onRepeatModeChanged(int i11);

        void onShuffleModeEnabledChanged(boolean z10);

        void onSkipSilenceEnabledChanged(boolean z10);

        void onSurfaceSizeChanged(int i11, int i12);

        void onTimelineChanged(e0 e0Var, int i11);

        void onTrackSelectionParametersChanged(h0 h0Var);

        void onTracksChanged(i0 i0Var);

        void onVideoSizeChanged(m0 m0Var);

        void onVolumeChanged(float f11);
    }

    /* loaded from: classes2.dex */
    public static final class e {

        /* renamed from: k, reason: collision with root package name */
        static final String f9880k = a1.C0(0);

        /* renamed from: l, reason: collision with root package name */
        private static final String f9881l = a1.C0(1);

        /* renamed from: m, reason: collision with root package name */
        static final String f9882m = a1.C0(2);

        /* renamed from: n, reason: collision with root package name */
        static final String f9883n = a1.C0(3);

        /* renamed from: o, reason: collision with root package name */
        static final String f9884o = a1.C0(4);

        /* renamed from: p, reason: collision with root package name */
        private static final String f9885p = a1.C0(5);

        /* renamed from: q, reason: collision with root package name */
        private static final String f9886q = a1.C0(6);

        /* renamed from: a, reason: collision with root package name */
        public final Object f9887a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9888b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9889c;

        /* renamed from: d, reason: collision with root package name */
        public final t f9890d;

        /* renamed from: e, reason: collision with root package name */
        public final Object f9891e;

        /* renamed from: f, reason: collision with root package name */
        public final int f9892f;

        /* renamed from: g, reason: collision with root package name */
        public final long f9893g;

        /* renamed from: h, reason: collision with root package name */
        public final long f9894h;

        /* renamed from: i, reason: collision with root package name */
        public final int f9895i;

        /* renamed from: j, reason: collision with root package name */
        public final int f9896j;

        public e(Object obj, int i11, t tVar, Object obj2, int i12, long j11, long j12, int i13, int i14) {
            this.f9887a = obj;
            this.f9888b = i11;
            this.f9889c = i11;
            this.f9890d = tVar;
            this.f9891e = obj2;
            this.f9892f = i12;
            this.f9893g = j11;
            this.f9894h = j12;
            this.f9895i = i13;
            this.f9896j = i14;
        }

        public boolean a(e eVar) {
            return this.f9889c == eVar.f9889c && this.f9892f == eVar.f9892f && this.f9893g == eVar.f9893g && this.f9894h == eVar.f9894h && this.f9895i == eVar.f9895i && this.f9896j == eVar.f9896j && Objects.equals(this.f9890d, eVar.f9890d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return a(eVar) && Objects.equals(this.f9887a, eVar.f9887a) && Objects.equals(this.f9891e, eVar.f9891e);
        }

        public int hashCode() {
            return Objects.hash(this.f9887a, Integer.valueOf(this.f9889c), this.f9890d, this.f9891e, Integer.valueOf(this.f9892f), Long.valueOf(this.f9893g), Long.valueOf(this.f9894h), Integer.valueOf(this.f9895i), Integer.valueOf(this.f9896j));
        }
    }

    void A(boolean z10, int i11);

    void B();

    void C(int i11, int i12, List list);

    void E(int i11);

    int F();

    void G(int i11, int i12);

    void H(t tVar);

    void J(t tVar);

    u1.b K();

    void L(d dVar);

    void M(d dVar);

    void N(int i11, t tVar);

    t O(int i11);

    long Q();

    void S(int i11, List list);

    void V(h0 h0Var);

    boolean W();

    void a(float f11);

    void b(z zVar);

    PlaybackException c();

    void clearVideoSurface();

    void clearVideoSurfaceView(SurfaceView surfaceView);

    void clearVideoTextureView(TextureView textureView);

    long d();

    void e(List list, boolean z10);

    void f();

    boolean g();

    long getBufferedPosition();

    long getContentPosition();

    int getCurrentAdGroupIndex();

    int getCurrentAdIndexInAdGroup();

    int getCurrentPeriodIndex();

    long getCurrentPosition();

    e0 getCurrentTimeline();

    i0 getCurrentTracks();

    long getDuration();

    boolean getPlayWhenReady();

    z getPlaybackParameters();

    int getPlaybackState();

    int getRepeatMode();

    boolean getShuffleModeEnabled();

    float getVolume();

    boolean h(int i11);

    boolean i();

    boolean isPlaying();

    boolean isPlayingAd();

    int j();

    Looper k();

    h0 l();

    void m();

    b n();

    long o();

    m0 p();

    void pause();

    void play();

    void prepare();

    boolean q();

    long r();

    boolean s();

    void seekTo(int i11, long j11);

    void seekTo(long j11);

    void seekToDefaultPosition();

    void setPlayWhenReady(boolean z10);

    void setRepeatMode(int i11);

    void setShuffleModeEnabled(boolean z10);

    void setVideoSurfaceView(SurfaceView surfaceView);

    void setVideoTextureView(TextureView textureView);

    void setVolume(float f11);

    void stop();

    int t();

    long u();

    void v();

    void w();

    v x();

    long y();

    boolean z();
}
