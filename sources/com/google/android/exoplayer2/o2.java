package com.google.android.exoplayer2;

import android.os.Bundle;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o2;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.m;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public interface o2 {

    /* loaded from: classes3.dex */
    public static final class b implements k {

        /* renamed from: b, reason: collision with root package name */
        public static final b f25591b = new a().e();

        /* renamed from: c, reason: collision with root package name */
        public static final k.a f25592c = new k.a() { // from class: com.google.android.exoplayer2.p2
            @Override // com.google.android.exoplayer2.k.a
            public final k a(Bundle bundle) {
                o2.b d11;
                d11 = o2.b.d(bundle);
                return d11;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private final com.google.android.exoplayer2.util.m f25593a;

        /* loaded from: classes3.dex */
        public static final class a {

            /* renamed from: b, reason: collision with root package name */
            private static final int[] f25594b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 31, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

            /* renamed from: a, reason: collision with root package name */
            private final m.b f25595a = new m.b();

            public a a(int i11) {
                this.f25595a.a(i11);
                return this;
            }

            public a b(b bVar) {
                this.f25595a.b(bVar.f25593a);
                return this;
            }

            public a c(int... iArr) {
                this.f25595a.c(iArr);
                return this;
            }

            public a d(int i11, boolean z10) {
                this.f25595a.d(i11, z10);
                return this;
            }

            public b e() {
                return new b(this.f25595a.e());
            }
        }

        private b(com.google.android.exoplayer2.util.m mVar) {
            this.f25593a = mVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b d(Bundle bundle) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(e(0));
            if (integerArrayList == null) {
                return f25591b;
            }
            a aVar = new a();
            for (int i11 = 0; i11 < integerArrayList.size(); i11++) {
                aVar.a(integerArrayList.get(i11).intValue());
            }
            return aVar.e();
        }

        private static String e(int i11) {
            return Integer.toString(i11, 36);
        }

        public boolean c(int i11) {
            return this.f25593a.a(i11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f25593a.equals(((b) obj).f25593a);
            }
            return false;
        }

        public int hashCode() {
            return this.f25593a.hashCode();
        }

        @Override // com.google.android.exoplayer2.k
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i11 = 0; i11 < this.f25593a.d(); i11++) {
                arrayList.add(Integer.valueOf(this.f25593a.c(i11)));
            }
            bundle.putIntegerArrayList(e(0), arrayList);
            return bundle;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final com.google.android.exoplayer2.util.m f25596a;

        public c(com.google.android.exoplayer2.util.m mVar) {
            this.f25596a = mVar;
        }

        public boolean a(int i11) {
            return this.f25596a.a(i11);
        }

        public boolean b(int... iArr) {
            return this.f25596a.b(iArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                return this.f25596a.equals(((c) obj).f25596a);
            }
            return false;
        }

        public int hashCode() {
            return this.f25596a.hashCode();
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onAvailableCommandsChanged(b bVar);

        void onCues(ba.f fVar);

        void onCues(List list);

        void onDeviceInfoChanged(r rVar);

        void onDeviceVolumeChanged(int i11, boolean z10);

        void onEvents(o2 o2Var, c cVar);

        void onIsLoadingChanged(boolean z10);

        void onIsPlayingChanged(boolean z10);

        void onLoadingChanged(boolean z10);

        void onMediaItemTransition(v1 v1Var, int i11);

        void onMediaMetadataChanged(a2 a2Var);

        void onMetadata(Metadata metadata);

        void onPlayWhenReadyChanged(boolean z10, int i11);

        void onPlaybackParametersChanged(n2 n2Var);

        void onPlaybackStateChanged(int i11);

        void onPlaybackSuppressionReasonChanged(int i11);

        void onPlayerError(PlaybackException playbackException);

        void onPlayerErrorChanged(PlaybackException playbackException);

        void onPlayerStateChanged(boolean z10, int i11);

        void onPositionDiscontinuity(int i11);

        void onPositionDiscontinuity(e eVar, e eVar2, int i11);

        void onRenderedFirstFrame();

        void onRepeatModeChanged(int i11);

        void onSeekProcessed();

        void onShuffleModeEnabledChanged(boolean z10);

        void onSkipSilenceEnabledChanged(boolean z10);

        void onSurfaceSizeChanged(int i11, int i12);

        void onTimelineChanged(k3 k3Var, int i11);

        void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters);

        void onTracksChanged(p3 p3Var);

        void onVideoSizeChanged(com.google.android.exoplayer2.video.y yVar);

        void onVolumeChanged(float f11);
    }

    /* loaded from: classes3.dex */
    public static final class e implements k {

        /* renamed from: k, reason: collision with root package name */
        public static final k.a f25597k = new k.a() { // from class: com.google.android.exoplayer2.r2
            @Override // com.google.android.exoplayer2.k.a
            public final k a(Bundle bundle) {
                o2.e b11;
                b11 = o2.e.b(bundle);
                return b11;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final Object f25598a;

        /* renamed from: b, reason: collision with root package name */
        public final int f25599b;

        /* renamed from: c, reason: collision with root package name */
        public final int f25600c;

        /* renamed from: d, reason: collision with root package name */
        public final v1 f25601d;

        /* renamed from: e, reason: collision with root package name */
        public final Object f25602e;

        /* renamed from: f, reason: collision with root package name */
        public final int f25603f;

        /* renamed from: g, reason: collision with root package name */
        public final long f25604g;

        /* renamed from: h, reason: collision with root package name */
        public final long f25605h;

        /* renamed from: i, reason: collision with root package name */
        public final int f25606i;

        /* renamed from: j, reason: collision with root package name */
        public final int f25607j;

        public e(Object obj, int i11, v1 v1Var, Object obj2, int i12, long j11, long j12, int i13, int i14) {
            this.f25598a = obj;
            this.f25599b = i11;
            this.f25600c = i11;
            this.f25601d = v1Var;
            this.f25602e = obj2;
            this.f25603f = i12;
            this.f25604g = j11;
            this.f25605h = j12;
            this.f25606i = i13;
            this.f25607j = i14;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static e b(Bundle bundle) {
            int i11 = bundle.getInt(c(0), -1);
            Bundle bundle2 = bundle.getBundle(c(1));
            return new e(null, i11, bundle2 == null ? null : (v1) v1.f27761j.a(bundle2), null, bundle.getInt(c(2), -1), bundle.getLong(c(3), C.TIME_UNSET), bundle.getLong(c(4), C.TIME_UNSET), bundle.getInt(c(5), -1), bundle.getInt(c(6), -1));
        }

        private static String c(int i11) {
            return Integer.toString(i11, 36);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.f25600c == eVar.f25600c && this.f25603f == eVar.f25603f && this.f25604g == eVar.f25604g && this.f25605h == eVar.f25605h && this.f25606i == eVar.f25606i && this.f25607j == eVar.f25607j && com.google.common.base.j.a(this.f25598a, eVar.f25598a) && com.google.common.base.j.a(this.f25602e, eVar.f25602e) && com.google.common.base.j.a(this.f25601d, eVar.f25601d);
        }

        public int hashCode() {
            return com.google.common.base.j.b(this.f25598a, Integer.valueOf(this.f25600c), this.f25601d, this.f25602e, Integer.valueOf(this.f25603f), Long.valueOf(this.f25604g), Long.valueOf(this.f25605h), Integer.valueOf(this.f25606i), Integer.valueOf(this.f25607j));
        }

        @Override // com.google.android.exoplayer2.k
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(c(0), this.f25600c);
            if (this.f25601d != null) {
                bundle.putBundle(c(1), this.f25601d.toBundle());
            }
            bundle.putInt(c(2), this.f25603f);
            bundle.putLong(c(3), this.f25604g);
            bundle.putLong(c(4), this.f25605h);
            bundle.putInt(c(5), this.f25606i);
            bundle.putInt(c(6), this.f25607j);
            return bundle;
        }
    }

    void A(d dVar);

    void B(v1 v1Var);

    void C(d dVar);

    void D(TrackSelectionParameters trackSelectionParameters);

    void b(n2 n2Var);

    PlaybackException c();

    void clearVideoSurface();

    void clearVideoSurfaceView(SurfaceView surfaceView);

    void clearVideoTextureView(TextureView textureView);

    long d();

    void e(List list, boolean z10);

    void f();

    boolean g();

    long getContentPosition();

    int getCurrentAdGroupIndex();

    int getCurrentAdIndexInAdGroup();

    int getCurrentPeriodIndex();

    long getCurrentPosition();

    k3 getCurrentTimeline();

    p3 getCurrentTracks();

    long getDuration();

    boolean getPlayWhenReady();

    n2 getPlaybackParameters();

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

    TrackSelectionParameters l();

    void m();

    b n();

    long o();

    com.google.android.exoplayer2.video.y p();

    void pause();

    void play();

    void prepare();

    boolean q();

    long r();

    void release();

    boolean s();

    void seekTo(int i11, long j11);

    void seekTo(long j11);

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

    a2 x();

    long y();

    boolean z();
}
