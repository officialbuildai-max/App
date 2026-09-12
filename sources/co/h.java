package co;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.collection.s;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.a0;
import androidx.media3.common.e0;
import androidx.media3.common.f0;
import androidx.media3.common.g0;
import androidx.media3.common.h0;
import androidx.media3.common.i0;
import androidx.media3.common.m0;
import androidx.media3.common.r;
import androidx.media3.common.t;
import androidx.media3.common.v;
import androidx.media3.common.x;
import androidx.media3.common.y;
import androidx.media3.common.z;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.a;
import androidx.media3.datasource.b;
import androidx.media3.datasource.rtmp.RtmpDataSource;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.b4;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.drm.w;
import androidx.media3.exoplayer.hls.HlsMediaSource;
import androidx.media3.exoplayer.m;
import androidx.media3.exoplayer.source.b0;
import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.u2;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import com.cloud.tmc.miniutils.constant.PermissionConstants;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.transsion.player.exo.ORExoDecoderType;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import com.transsion.player.orplayer.g;
import com.transsion.player.p007enum.PlayMimeType;
import com.transsion.player.p007enum.ScaleMode;
import com.transsion.player.ui.render.RenderScaleMode;
import com.transsion.player.ui.render.SurfaceRenderView;
import com.transsion.player.ui.render.TextureRenderView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import y1.c;

/* loaded from: classes5.dex */
public final class h implements com.transsion.player.orplayer.g {
    public static final b M = new b(null);
    private long A;
    private final LinkedHashMap B;
    private final List C;
    private long D;
    private long E;
    private final a0.d F;
    private b4 G;
    private CopyOnWriteArrayList H;
    private u2 I;
    private final Handler J;
    private final Runnable K;
    private ScaleMode L;

    /* renamed from: a, reason: collision with root package name */
    private final Context f17634a;

    /* renamed from: b, reason: collision with root package name */
    private final m f17635b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f17636c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f17637d;

    /* renamed from: e, reason: collision with root package name */
    private SurfaceRenderView f17638e;

    /* renamed from: f, reason: collision with root package name */
    private TextureRenderView f17639f;

    /* renamed from: g, reason: collision with root package name */
    private com.transsion.player.orplayer.c f17640g;

    /* renamed from: h, reason: collision with root package name */
    private Double f17641h;

    /* renamed from: i, reason: collision with root package name */
    private ao.e f17642i;

    /* renamed from: j, reason: collision with root package name */
    private Float f17643j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f17644k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f17645l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f17646m;

    /* renamed from: n, reason: collision with root package name */
    private float f17647n;

    /* renamed from: o, reason: collision with root package name */
    private int f17648o;

    /* renamed from: p, reason: collision with root package name */
    private int f17649p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f17650q;

    /* renamed from: r, reason: collision with root package name */
    private com.transsion.player.orplayer.e f17651r;

    /* renamed from: s, reason: collision with root package name */
    private ExoPlayer f17652s;

    /* renamed from: t, reason: collision with root package name */
    private Boolean f17653t;

    /* renamed from: u, reason: collision with root package name */
    private int f17654u;

    /* renamed from: v, reason: collision with root package name */
    private final long f17655v;

    /* renamed from: w, reason: collision with root package name */
    private final long f17656w;

    /* renamed from: x, reason: collision with root package name */
    private String f17657x;

    /* renamed from: y, reason: collision with root package name */
    private ORExoDecoderType f17658y;

    /* renamed from: z, reason: collision with root package name */
    private long f17659z;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final long f17660a;

        /* renamed from: b, reason: collision with root package name */
        private final long f17661b;

        /* renamed from: c, reason: collision with root package name */
        private final long f17662c;

        /* renamed from: d, reason: collision with root package name */
        private final Double f17663d;

        public a(long j11, long j12, long j13, Double d11) {
            this.f17660a = j11;
            this.f17661b = j12;
            this.f17662c = j13;
            this.f17663d = d11;
        }

        public final long a() {
            return this.f17662c;
        }

        public final long b() {
            return this.f17660a;
        }

        public final long c() {
            return this.f17661b;
        }

        public final Double d() {
            return this.f17663d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f17660a == aVar.f17660a && this.f17661b == aVar.f17661b && this.f17662c == aVar.f17662c && Intrinsics.c(this.f17663d, aVar.f17663d);
        }

        public int hashCode() {
            int a11 = ((((s.a(this.f17660a) * 31) + s.a(this.f17661b)) * 31) + s.a(this.f17662c)) * 31;
            Double d11 = this.f17663d;
            return a11 + (d11 == null ? 0 : d11.hashCode());
        }

        public String toString() {
            return "BandwidthStats(downloadBytesAll=" + this.f17660a + ", downloadBytesMediaOnly=" + this.f17661b + ", consumedBytesEstimated=" + this.f17662c + ", redundancyRate=" + this.f17663d + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final String f17664a;

        /* renamed from: b, reason: collision with root package name */
        private final String f17665b;

        /* renamed from: c, reason: collision with root package name */
        private final int f17666c;

        /* renamed from: d, reason: collision with root package name */
        private final int f17667d;

        /* renamed from: e, reason: collision with root package name */
        private final long f17668e;

        /* renamed from: f, reason: collision with root package name */
        private final long f17669f;

        /* renamed from: g, reason: collision with root package name */
        private final long f17670g;

        public c(String key, String uri, int i11, int i12, long j11, long j12, long j13) {
            Intrinsics.h(key, "key");
            Intrinsics.h(uri, "uri");
            this.f17664a = key;
            this.f17665b = uri;
            this.f17666c = i11;
            this.f17667d = i12;
            this.f17668e = j11;
            this.f17669f = j12;
            this.f17670g = j13;
        }

        public final long a() {
            return this.f17668e;
        }

        public final int b() {
            return this.f17666c;
        }

        public final long c() {
            return this.f17670g;
        }

        public final long d() {
            return this.f17669f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Intrinsics.c(this.f17664a, cVar.f17664a) && Intrinsics.c(this.f17665b, cVar.f17665b) && this.f17666c == cVar.f17666c && this.f17667d == cVar.f17667d && this.f17668e == cVar.f17668e && this.f17669f == cVar.f17669f && this.f17670g == cVar.f17670g;
        }

        public int hashCode() {
            return (((((((((((this.f17664a.hashCode() * 31) + this.f17665b.hashCode()) * 31) + this.f17666c) * 31) + this.f17667d) * 31) + s.a(this.f17668e)) * 31) + s.a(this.f17669f)) * 31) + s.a(this.f17670g);
        }

        public String toString() {
            return "SegmentStat(key=" + this.f17664a + ", uri=" + this.f17665b + ", dataType=" + this.f17666c + ", trackType=" + this.f17667d + ", bytesLoaded=" + this.f17668e + ", mediaStartMs=" + this.f17669f + ", mediaEndMs=" + this.f17670g + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final long f17671a;

        /* renamed from: b, reason: collision with root package name */
        private final long f17672b;

        public d(long j11, long j12) {
            this.f17671a = j11;
            this.f17672b = j12;
        }

        public final long a() {
            return this.f17672b;
        }

        public final long b() {
            return this.f17671a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f17671a == dVar.f17671a && this.f17672b == dVar.f17672b;
        }

        public int hashCode() {
            return (s.a(this.f17671a) * 31) + s.a(this.f17672b);
        }

        public String toString() {
            return "WatchRange(startMs=" + this.f17671a + ", endMs=" + this.f17672b + ")";
        }
    }

    /* loaded from: classes5.dex */
    public /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17673a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f17674b;

        static {
            int[] iArr = new int[PlayMimeType.values().length];
            try {
                iArr[PlayMimeType.DASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlayMimeType.HLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f17673a = iArr;
            int[] iArr2 = new int[ScaleMode.values().length];
            try {
                iArr2[ScaleMode.SCALE_TO_FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ScaleMode.SCALE_ASPECT_FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ScaleMode.SCALE_ASPECT_FILL.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f17674b = iArr2;
        }
    }

    /* loaded from: classes5.dex */
    public static final class f extends androidx.media3.exoplayer.util.a {
        f() {
            super("ORExoPlayer");
        }

        @Override // androidx.media3.exoplayer.util.a, y1.c
        public void I(c.a eventTime, g2.i loadEventInfo, g2.j mediaLoadData) {
            Intrinsics.h(eventTime, "eventTime");
            Intrinsics.h(loadEventInfo, "loadEventInfo");
            Intrinsics.h(mediaLoadData, "mediaLoadData");
            super.I(eventTime, loadEventInfo, mediaLoadData);
            Uri uri = loadEventInfo.f63333c;
            String uri2 = uri != null ? uri.toString() : null;
            if (uri2 == null) {
                uri2 = "";
            }
            String V = h.this.V(mediaLoadData.f63338a);
            int i11 = mediaLoadData.f63338a;
            String o02 = h.this.o0(mediaLoadData.f63339b);
            int i12 = mediaLoadData.f63339b;
            long j11 = mediaLoadData.f63343f;
            long j12 = mediaLoadData.f63344g;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("exo-load-start uri=");
            sb2.append(uri2);
            sb2.append(", dataType=");
            sb2.append(V);
            sb2.append("(");
            sb2.append(i11);
            sb2.append("), trackType=");
            sb2.append(o02);
            sb2.append("(");
            sb2.append(i12);
            sb2.append("), mediaRange=[");
            sb2.append(j11);
            sb2.append(",");
            sb2.append(j12);
            sb2.append("]");
        }

        @Override // androidx.media3.exoplayer.util.a, y1.c
        public void R(c.a eventTime, String decoderName, long j11, long j12) {
            Intrinsics.h(eventTime, "eventTime");
            Intrinsics.h(decoderName, "decoderName");
            super.R(eventTime, decoderName, j11, j12);
            oo.e.f71197a.h("ORExoPlayer", "onExoAudioDecoderInitialize, decoderName:" + decoderName, true);
        }

        @Override // androidx.media3.exoplayer.util.a, y1.c
        public void q(c.a eventTime, String decoderName, long j11, long j12) {
            Intrinsics.h(eventTime, "eventTime");
            Intrinsics.h(decoderName, "decoderName");
            super.q(eventTime, decoderName, j11, j12);
            oo.e.f71197a.h("ORExoPlayer", "onExoVideoDecoderInitialize, decoderName:" + decoderName, true);
        }

        @Override // androidx.media3.exoplayer.util.a, y1.c
        public void x0(c.a eventTime, g2.i loadEventInfo, g2.j mediaLoadData) {
            g2.j jVar;
            String str;
            long j11;
            Intrinsics.h(eventTime, "eventTime");
            Intrinsics.h(loadEventInfo, "loadEventInfo");
            Intrinsics.h(mediaLoadData, "mediaLoadData");
            super.x0(eventTime, loadEventInfo, mediaLoadData);
            Uri uri = loadEventInfo.f63333c;
            String uri2 = uri != null ? uri.toString() : null;
            if (uri2 == null) {
                uri2 = "";
            }
            long j12 = loadEventInfo.f63337g;
            h.this.f17659z += j12;
            if (h.this.b0(mediaLoadData.f63338a)) {
                h.this.A += j12;
            }
            if (uri2.length() <= 0 || !h.this.b0(mediaLoadData.f63338a)) {
                jVar = mediaLoadData;
                str = uri2;
                j11 = j12;
            } else {
                h hVar = h.this;
                int i11 = mediaLoadData.f63338a;
                int i12 = mediaLoadData.f63339b;
                long j13 = mediaLoadData.f63343f;
                long j14 = mediaLoadData.f63344g;
                w1.h hVar2 = loadEventInfo.f63332b;
                String Q = hVar.Q(uri2, i11, i12, j13, j14, hVar2.f77640g, hVar2.f77641h);
                c cVar = (c) h.this.B.get(Q);
                if (cVar == null || j12 > cVar.a()) {
                    jVar = mediaLoadData;
                    j11 = j12;
                    str = uri2;
                    h.this.B.put(Q, new c(Q, uri2, jVar.f63338a, jVar.f63339b, j12, jVar.f63343f, jVar.f63344g));
                } else {
                    j11 = j12;
                    str = uri2;
                    jVar = mediaLoadData;
                }
            }
            String V = h.this.V(jVar.f63338a);
            int i13 = jVar.f63338a;
            String o02 = h.this.o0(jVar.f63339b);
            int i14 = jVar.f63339b;
            long j15 = jVar.f63343f;
            long j16 = jVar.f63344g;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("exo-load-complete uri=");
            sb2.append(str);
            sb2.append(", bytes=");
            sb2.append(j11);
            sb2.append(", dataType=");
            sb2.append(V);
            sb2.append("(");
            sb2.append(i13);
            sb2.append("), trackType=");
            sb2.append(o02);
            sb2.append("(");
            sb2.append(i14);
            sb2.append("), mediaRange=[");
            sb2.append(j15);
            sb2.append(",");
            sb2.append(j16);
            sb2.append("]");
        }

        @Override // androidx.media3.exoplayer.util.a, y1.c
        public void y(c.a eventTime, i0 tracks) {
            Intrinsics.h(eventTime, "eventTime");
            Intrinsics.h(tracks, "tracks");
            super.y(eventTime, tracks);
            h.this.h0(eventTime, tracks);
        }
    }

    /* loaded from: classes5.dex */
    public static final class g implements a0.d {

        /* renamed from: a, reason: collision with root package name */
        private int f17676a = 1;

        g() {
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
        public void onDeviceInfoChanged(androidx.media3.common.m deviceInfo) {
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
            com.transsion.player.orplayer.c cVar = h.this.f17640g;
            if (cVar != null) {
                cVar.f(z10);
            }
            for (com.transsion.player.orplayer.f fVar : h.this.H) {
                if (fVar != null) {
                    fVar.onIsPlayingChanged(z10);
                }
            }
            ExoPlayer exoPlayer = h.this.f17652s;
            long currentPosition = exoPlayer != null ? exoPlayer.getCurrentPosition() : 0L;
            h.this.E = currentPosition;
            if (z10) {
                h.this.m0(currentPosition);
                CopyOnWriteArrayList<com.transsion.player.orplayer.f> copyOnWriteArrayList = h.this.H;
                h hVar = h.this;
                for (com.transsion.player.orplayer.f fVar2 : copyOnWriteArrayList) {
                    if (fVar2 != null) {
                        fVar2.onVideoStart(hVar.f17642i);
                    }
                }
                h.this.J.post(h.this.K);
            } else {
                h.this.S(currentPosition);
                ExoPlayer exoPlayer2 = h.this.f17652s;
                if (exoPlayer2 == null || !exoPlayer2.getPlayWhenReady()) {
                    CopyOnWriteArrayList<com.transsion.player.orplayer.f> copyOnWriteArrayList2 = h.this.H;
                    h hVar2 = h.this;
                    for (com.transsion.player.orplayer.f fVar3 : copyOnWriteArrayList2) {
                        if (fVar3 != null) {
                            fVar3.onVideoPause(hVar2.f17642i);
                        }
                    }
                }
                h.this.J.removeCallbacks(h.this.K);
                ExoPlayer exoPlayer3 = h.this.f17652s;
                long duration = exoPlayer3 != null ? exoPlayer3.getDuration() : 0L;
                ExoPlayer exoPlayer4 = h.this.f17652s;
                if (Math.abs(duration - (exoPlayer4 != null ? exoPlayer4.getCurrentPosition() : 0L)) < 2000) {
                    Log.e("ORExoPlayer", "onIsPlayingChanged onCompletion");
                    if (!h.this.f17650q) {
                        h.this.f17650q = true;
                        CopyOnWriteArrayList<com.transsion.player.orplayer.f> copyOnWriteArrayList3 = h.this.H;
                        h hVar3 = h.this;
                        for (com.transsion.player.orplayer.f fVar4 : copyOnWriteArrayList3) {
                            if (fVar4 != null) {
                                fVar4.onCompletion(hVar3.f17642i);
                            }
                        }
                    }
                }
            }
            Log.e("ORExoPlayer", "onIsPlayingChanged:" + z10);
        }

        @Override // androidx.media3.common.a0.d
        public void onLoadingChanged(boolean z10) {
        }

        @Override // androidx.media3.common.a0.d
        public void onMediaItemTransition(t tVar, int i11) {
            t.h hVar;
            Log.e("ORExoPlayer", "onMediaItemTransition  reason:" + i11 + " ");
            if (i11 == 0 || i11 == 1) {
                for (com.transsion.player.orplayer.f fVar : h.this.H) {
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
            Log.e("ORExoPlayer", "onPlaybackStateChanged  playbackState:" + i11 + " ");
            if (i11 == 2) {
                Log.e("ORExoPlayer", "onPlaybackStateChanged STATE_BUFFERING");
                CopyOnWriteArrayList<com.transsion.player.orplayer.f> copyOnWriteArrayList = h.this.H;
                h hVar = h.this;
                for (com.transsion.player.orplayer.f fVar : copyOnWriteArrayList) {
                    if (fVar != null) {
                        fVar.onLoadingBegin(hVar.f17642i);
                    }
                }
            } else if (i11 == 3) {
                if (!h.this.f17636c) {
                    h.this.f17636c = true;
                    h.l(h.this);
                    CopyOnWriteArrayList<com.transsion.player.orplayer.f> copyOnWriteArrayList2 = h.this.H;
                    h hVar2 = h.this;
                    for (com.transsion.player.orplayer.f fVar2 : copyOnWriteArrayList2) {
                        if (fVar2 != null) {
                            fVar2.onPrepare(hVar2.f17642i);
                        }
                    }
                    h.this.i0();
                }
                if (this.f17676a == 2) {
                    for (com.transsion.player.orplayer.f fVar3 : h.this.H) {
                        if (fVar3 != null) {
                            f.a.l(fVar3, null, 1, null);
                        }
                    }
                }
            } else if (i11 == 4 && !h.this.f17650q) {
                h.this.f17650q = true;
                CopyOnWriteArrayList<com.transsion.player.orplayer.f> copyOnWriteArrayList3 = h.this.H;
                h hVar3 = h.this;
                for (com.transsion.player.orplayer.f fVar4 : copyOnWriteArrayList3) {
                    if (fVar4 != null) {
                        fVar4.onCompletion(hVar3.f17642i);
                    }
                }
            }
            this.f17676a = i11;
        }

        @Override // androidx.media3.common.a0.d
        public void onPlaybackSuppressionReasonChanged(int i11) {
        }

        @Override // androidx.media3.common.a0.d
        public void onPlayerError(PlaybackException error) {
            ao.e eVar;
            Throwable cause;
            Intrinsics.h(error, "error");
            h.this.f17636c = false;
            if ((error instanceof ExoPlaybackException) && (cause = error.getCause()) != null) {
                h hVar = h.this;
                if ((cause instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) cause).responseCode == 404) {
                    long duration = hVar.getDuration();
                    long currentPosition = hVar.getCurrentPosition();
                    if (currentPosition > 0 && duration > 0 && (((float) currentPosition) * 1.0f) / ((float) duration) > 0.99f) {
                        if (hVar.f17650q) {
                            return;
                        }
                        hVar.f17650q = true;
                        for (com.transsion.player.orplayer.f fVar : hVar.H) {
                            if (fVar != null) {
                                fVar.onCompletion(hVar.f17642i);
                            }
                        }
                        return;
                    }
                }
            }
            oo.e eVar2 = oo.e.f71197a;
            eVar2.c("ORExoPlayer", "exo onPlayerError，MimeType:" + h.this.f17657x + ", code:" + error.errorCode + ",msg:" + error.getMessage() + ", cause:" + error.getCause(), true);
            if (h.this.f17658y != ORExoDecoderType.HARDWARE || (eVar = h.this.f17642i) == null || eVar.m() || (error.getCause() instanceof HttpDataSource.InvalidResponseCodeException)) {
                PlayError playError = new PlayError(Integer.valueOf(error.errorCode), error.getMessage() + "|" + error.getCause());
                playError.setExoCause(error.getCause());
                h.l(h.this);
                for (com.transsion.player.orplayer.f fVar2 : h.this.H) {
                    if (fVar2 != null) {
                        f.a.r(fVar2, playError, null, 2, null);
                    }
                }
                return;
            }
            eVar2.c("ORExoPlayer", "exo 硬解失败，切换到软解，MimeType:" + h.this.f17657x + ", code:" + error.errorCode + ",msg:" + error.getMessage(), true);
            ao.e R = h.this.R();
            if (R != null) {
                h hVar2 = h.this;
                hVar2.setDataSource(R);
                hVar2.prepare();
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
            h.this.E = j11;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onPositionDiscontinuity: currentWindowIndex=");
            sb2.append(i12);
            sb2.append(", currentPositionMs=");
            sb2.append(j11);
            sb2.append(", reason=");
            sb2.append(i11);
            if (i11 == 1 || i11 == 2) {
                h.this.S(j11);
                ExoPlayer exoPlayer = h.this.f17652s;
                if (exoPlayer != null && exoPlayer.isPlaying()) {
                    h.this.m0(j11);
                }
                for (com.transsion.player.orplayer.f fVar : h.this.H) {
                    if (fVar != null) {
                        fVar.setOnSeekCompleteListener();
                    }
                }
            }
            CopyOnWriteArrayList<com.transsion.player.orplayer.f> copyOnWriteArrayList = h.this.H;
            h hVar = h.this;
            for (com.transsion.player.orplayer.f fVar2 : copyOnWriteArrayList) {
                if (fVar2 != null) {
                    fVar2.onProgress(j11, hVar.f17642i);
                }
            }
        }

        @Override // androidx.media3.common.a0.d
        public void onRenderedFirstFrame() {
            if (h.this.f17637d) {
                return;
            }
            h.this.f17637d = true;
            Log.e("ORExoPlayer", "onRenderedFirstFrame:");
            for (com.transsion.player.orplayer.f fVar : h.this.H) {
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
            int c11;
            Intrinsics.h(tracks, "tracks");
            CopyOnWriteArrayList<com.transsion.player.orplayer.f> copyOnWriteArrayList = h.this.H;
            h hVar = h.this;
            for (com.transsion.player.orplayer.f fVar : copyOnWriteArrayList) {
                if (fVar != null) {
                    fVar.onTracksChange(mo.a.c(tracks));
                }
                mo.c c12 = mo.a.c(tracks);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("changeTrackSelection 所有的分辨率为：");
                sb2.append(c12);
                mo.d dVar = null;
                int i11 = -1;
                boolean z10 = false;
                int i12 = 0;
                for (mo.d dVar2 : c12.a()) {
                    if (dVar2.e() == 2) {
                        mo.b[] b11 = dVar2.b();
                        int length = b11.length;
                        int i13 = 0;
                        int i14 = 0;
                        while (i13 < length) {
                            mo.b bVar = b11[i13];
                            int i15 = i14 + 1;
                            if (!Intrinsics.c(hVar.f17653t, Boolean.FALSE)) {
                                if (bVar.c() >= hVar.f17654u && bVar.c() > i12) {
                                    c11 = bVar.c();
                                    i12 = c11;
                                    i11 = i14;
                                }
                                z10 = true;
                            } else if (bVar.c() < hVar.f17654u) {
                                if (bVar.c() > i12) {
                                    c11 = bVar.c();
                                    i12 = c11;
                                    i11 = i14;
                                }
                                z10 = true;
                            }
                            i13++;
                            i14 = i15;
                        }
                        dVar = dVar2;
                    }
                }
                if (Intrinsics.c(hVar.f17653t, Boolean.FALSE)) {
                    if (z10) {
                        if (dVar != null && fVar != null) {
                            fVar.canNonSubscriberPlay(true, i12, i11, dVar);
                        }
                    } else if (dVar != null && fVar != null) {
                        fVar.canNonSubscriberPlay(false, 0, i11, dVar);
                    }
                } else if (dVar != null && fVar != null) {
                    fVar.canNonSubscriberPlay(true, i12, i11, dVar);
                }
            }
        }

        @Override // androidx.media3.common.a0.d
        public void onVideoSizeChanged(m0 videoSize) {
            Intrinsics.h(videoSize, "videoSize");
            SurfaceRenderView surfaceRenderView = h.this.f17638e;
            if (surfaceRenderView != null) {
                surfaceRenderView.setVideoRotation(videoSize.f10199c);
            }
            TextureRenderView textureRenderView = h.this.f17639f;
            if (textureRenderView != null) {
                textureRenderView.setVideoRotation(videoSize.f10199c);
            }
            SurfaceRenderView surfaceRenderView2 = h.this.f17638e;
            if (surfaceRenderView2 != null) {
                surfaceRenderView2.setVideoSize(videoSize.f10197a, videoSize.f10198b);
            }
            TextureRenderView textureRenderView2 = h.this.f17639f;
            if (textureRenderView2 != null) {
                textureRenderView2.setVideoSize(videoSize.f10197a, videoSize.f10198b);
            }
            for (com.transsion.player.orplayer.f fVar : h.this.H) {
                if (fVar != null) {
                    fVar.onVideoSizeChanged(videoSize.f10197a, videoSize.f10198b);
                }
            }
            Log.e("ORExoPlayer", "onVideoSizeChanged width:" + videoSize.f10197a + "  height:" + videoSize.f10198b);
        }

        @Override // androidx.media3.common.a0.d
        public void onVolumeChanged(float f11) {
        }
    }

    /* renamed from: co.h$h, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0179h implements com.transsion.player.orplayer.d {
        C0179h() {
        }

        @Override // com.transsion.player.orplayer.d
        public boolean isMute() {
            ExoPlayer exoPlayer = h.this.f17652s;
            if (exoPlayer != null) {
                return exoPlayer.W();
            }
            return false;
        }

        @Override // com.transsion.player.orplayer.d
        public void pause() {
            ExoPlayer exoPlayer = h.this.f17652s;
            if (exoPlayer != null) {
                exoPlayer.pause();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void play() {
            ExoPlayer exoPlayer = h.this.f17652s;
            if (exoPlayer != null) {
                exoPlayer.play();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void setVolume(float f11) {
            ExoPlayer exoPlayer = h.this.f17652s;
            if (exoPlayer != null) {
                exoPlayer.setVolume(f11);
            }
        }
    }

    public h(Context context, m config, boolean z10) {
        Intrinsics.h(context, "context");
        Intrinsics.h(config, "config");
        this.f17634a = context;
        this.f17635b = config;
        this.f17647n = 1.0f;
        this.f17653t = Boolean.FALSE;
        this.f17654u = 720;
        this.f17655v = DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT;
        this.f17656w = 500L;
        ORExoDecoderType oRExoDecoderType = ORExoDecoderType.HARDWARE;
        this.f17658y = oRExoDecoderType;
        this.B = new LinkedHashMap();
        this.C = new ArrayList();
        this.D = -1L;
        this.F = new g();
        if (z10) {
            X();
        }
        U(oRExoDecoderType);
        this.H = new CopyOnWriteArrayList();
        Looper myLooper = Looper.myLooper();
        Intrinsics.e(myLooper);
        this.J = new Handler(myLooper);
        this.K = new Runnable() { // from class: co.e
            @Override // java.lang.Runnable
            public final void run() {
                h.n0(h.this);
            }
        };
        this.L = ScaleMode.SCALE_TO_FILL;
    }

    public /* synthetic */ h(Context context, m mVar, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? n.a() : mVar, (i11 & 4) != 0 ? true : z10);
    }

    private final void N(ao.e eVar) {
        a.InterfaceC0099a factory = new RtmpDataSource.Factory();
        oo.e.f71197a.a("ORExoPlayer", "addRtmpDataSource ", true);
        b0 d11 = new b0.b(factory).d(t.b(eVar.k()));
        Intrinsics.g(d11, "createMediaSource(...)");
        ExoPlayer exoPlayer = this.f17652s;
        if (exoPlayer != null) {
            exoPlayer.U(d11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.media3.exoplayer.drm.t P(t tVar) {
        return androidx.media3.exoplayer.drm.t.f11694a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Q(String str, int i11, int i12, long j11, long j12, long j13, long j14) {
        return str + "|" + i11 + "|" + i12 + "|" + j11 + "|" + j12 + "|" + j13 + "|" + j14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ao.e R() {
        ao.e eVar = this.f17642i;
        String str = this.f17657x;
        a0();
        ORExoDecoderType oRExoDecoderType = Intrinsics.c(str, "video/av01") ? ORExoDecoderType.AV1 : ORExoDecoderType.FFMPEG;
        this.f17658y = oRExoDecoderType;
        oo.e.f71197a.a("ORExoPlayer", "重新创建播放器切换编码, DecoderType:" + oRExoDecoderType + ",MimeTyp:" + str, true);
        U(this.f17658y);
        Z();
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(long j11) {
        long j12 = this.D;
        if (j12 < 0) {
            return;
        }
        long g11 = RangesKt.g(j11, j12);
        if (g11 > j12) {
            this.C.add(new d(j12, g11));
        }
        this.D = -1L;
    }

    private final long T(List list) {
        Iterator it;
        h hVar = this;
        Iterator it2 = hVar.B.values().iterator();
        double d11 = 0.0d;
        while (it2.hasNext()) {
            Object next = it2.next();
            Intrinsics.g(next, "next(...)");
            c cVar = (c) next;
            if (!hVar.b0(cVar.b())) {
                hVar = this;
            } else if (cVar.b() == 2) {
                d11 += cVar.a();
            } else {
                long d12 = cVar.d();
                long c11 = cVar.c();
                if (d12 == C.TIME_UNSET || c11 == C.TIME_UNSET || c11 <= d12) {
                    it = it2;
                    d11 += cVar.a();
                } else {
                    double d13 = c11 - d12;
                    Iterator it3 = list.iterator();
                    long j11 = 0;
                    while (it3.hasNext()) {
                        d dVar = (d) it3.next();
                        j11 += j0(d12, c11, dVar.b(), dVar.a());
                        d13 = d13;
                        it2 = it2;
                    }
                    it = it2;
                    d11 += cVar.a() * RangesKt.k(j11 / d13, 0.0d, 1.0d);
                }
                hVar = this;
                it2 = it;
            }
        }
        return (long) d11;
    }

    private final void U(ORExoDecoderType oRExoDecoderType) {
        Integer a11 = this.f17635b.a();
        Intrinsics.e(a11);
        int intValue = a11.intValue() > 0 ? this.f17635b.a().intValue() : 20000;
        oo.e.f71197a.a("ORExoPlayer", "createPlayer, DecoderType:" + oRExoDecoderType, true);
        this.I = new m.b().b(5000, intValue, 500, 1000).d(-1).c(true).a();
        this.G = co.a.b(this.f17634a, oRExoDecoderType);
        ExoPlayer.b q11 = new ExoPlayer.b(this.f17634a).q(new androidx.media3.exoplayer.source.i(this.f17634a).q(co.a.d(this.f17634a)));
        b4 b4Var = this.G;
        Intrinsics.e(b4Var);
        ExoPlayer.b r11 = q11.r(b4Var);
        u2 u2Var = this.I;
        Intrinsics.e(u2Var);
        ExoPlayer h11 = r11.p(u2Var).h();
        h11.setPlayWhenReady(false);
        h11.M(this.F);
        h11.D(new f());
        this.f17652s = h11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String V(int i11) {
        switch (i11) {
            case 1:
                return PermissionConstants.MEDIA;
            case 2:
                return "MEDIA_INIT";
            case 3:
                return "DRM";
            case 4:
                return "MANIFEST";
            case 5:
                return "TIME_SYNC";
            case 6:
                return "AD";
            default:
                return NetworkUtil.NETWORK_TYPE_UNKNOWN;
        }
    }

    private final void X() {
        this.f17640g = new com.transsion.player.orplayer.c(new C0179h(), new Function1() { // from class: co.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Y;
                Y = h.Y(h.this, ((Boolean) obj).booleanValue());
                return Y;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(h hVar, boolean z10) {
        Iterator it = hVar.H.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onFocusChange(z10);
        }
        return Unit.f67184a;
    }

    private final void Z() {
        setMute(this.f17646m);
        Float f11 = this.f17643j;
        if (f11 != null) {
            setVolume(f11.floatValue());
        }
        setLooping(this.f17645l);
        setAutoPlay(this.f17644k);
        setSpeed(this.f17647n);
        SurfaceRenderView surfaceRenderView = this.f17638e;
        if (surfaceRenderView != null) {
            setSurfaceView(surfaceRenderView);
        }
        TextureRenderView textureRenderView = this.f17639f;
        if (textureRenderView != null) {
            setTextureView(textureRenderView);
        }
        setScaleMode(this.L);
    }

    private final void a0() {
        this.f17636c = false;
        this.f17650q = false;
        this.f17637d = false;
        Log.e("ORExoPlayer", "innerRelease");
        if (ko.m0.f67107a.a(this)) {
            ExoPlayer exoPlayer = this.f17652s;
            if (exoPlayer != null) {
                exoPlayer.release();
                return;
            }
            return;
        }
        ExoPlayer exoPlayer2 = this.f17652s;
        if (exoPlayer2 != null) {
            exoPlayer2.stop();
        }
        ExoPlayer exoPlayer3 = this.f17652s;
        if (exoPlayer3 != null) {
            exoPlayer3.B();
        }
        ExoPlayer exoPlayer4 = this.f17652s;
        if (exoPlayer4 != null) {
            exoPlayer4.clearVideoSurface();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b0(int i11) {
        return i11 == 1 || i11 == 2;
    }

    private final boolean c0(ao.e eVar) {
        PlayMimeType j11 = eVar.j();
        PlayMimeType playMimeType = PlayMimeType.RTMP;
        if (j11 == playMimeType) {
            return true;
        }
        String lowerCase = eVar.k().toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        if (!StringsKt.W(lowerCase, "rtmp://", false, 2, null)) {
            return false;
        }
        eVar.u(playMimeType);
        return true;
    }

    private final boolean d0(ao.e eVar) {
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

    private final void e0(String str) {
        String str2;
        a W = W();
        Double d11 = W.d();
        if (d11 != null) {
            double doubleValue = d11.doubleValue();
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            str2 = String.format("%.4f", Arrays.copyOf(new Object[]{Double.valueOf(doubleValue)}, 1));
            Intrinsics.g(str2, "format(...)");
        } else {
            str2 = "null";
        }
        long b11 = W.b();
        long c11 = W.c();
        long a11 = W.a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("bw-stats scene=");
        sb2.append(str);
        sb2.append(", downloadAll=");
        sb2.append(b11);
        sb2.append(", downloadMedia=");
        sb2.append(c11);
        sb2.append(", consumedEstimated=");
        sb2.append(a11);
        sb2.append(", redundancyRate=");
        sb2.append(str2);
    }

    private final void f0() {
        ExoPlayer exoPlayer = this.f17652s;
        if (exoPlayer == null) {
            return;
        }
        long g11 = RangesKt.g(exoPlayer.getCurrentPosition(), 0L);
        long g12 = RangesKt.g(exoPlayer.getBufferedPosition(), g11);
        long g13 = RangesKt.g(g12 - g11, 0L);
        double k11 = RangesKt.k((g13 * 100.0d) / this.f17655v, 0.0d, 100.0d);
        this.f17641h = Double.valueOf(k11);
        boolean z10 = g13 >= this.f17655v - this.f17656w;
        String format = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(k11)}, 1));
        Intrinsics.g(format, "format(...)");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("exo-buffer-pool scene=release, current=");
        sb2.append(g11);
        sb2.append(", bufferedPosition=");
        sb2.append(g12);
        sb2.append(", bufferedMs=");
        sb2.append(g13);
        sb2.append(", poolPercent=");
        sb2.append(format);
        sb2.append(", isPoolFull=");
        sb2.append(z10);
    }

    private final void g0() {
        this.J.removeCallbacks(this.K);
        this.J.postDelayed(this.K, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void h0(c.a aVar, i0 i0Var) {
        int size = i0Var.a().size();
        for (int i11 = 0; i11 < size; i11++) {
            E e11 = i0Var.a().get(i11);
            Intrinsics.g(e11, "get(...)");
            i0.a aVar2 = (i0.a) e11;
            int i12 = aVar2.f10173a;
            for (int i13 = 0; i13 < i12; i13++) {
                r b11 = aVar2.b(i13);
                Intrinsics.g(b11, "getTrackFormat(...)");
                oo.e eVar = oo.e.f71197a;
                oo.e.i(eVar, "ORExoPlayer", "onGetTracksInfo  MimeType:" + b11.f10243o + "， bitrate：" + b11.f10238j, false, 4, null);
                String str = b11.f10243o;
                if (str != null && StringsKt.c0(str, "video", false, 2, null)) {
                    String str2 = b11.f10243o;
                    this.f17657x = str2;
                    oo.e.f(eVar, "ORExoPlayer", "--------onGetTracksInfo curVideoMimeType:" + str2, false, 4, null);
                }
            }
        }
        if (this.f17658y == ORExoDecoderType.AV1 || !Intrinsics.c(this.f17657x, "video/av01") || Build.VERSION.SDK_INT > 29) {
            return;
        }
        oo.e.f71197a.c("ORExoPlayer", "exo av1，强制切换到软解， MimeType:" + this.f17657x, true);
        ao.e R = R();
        if (R != null) {
            setDataSource(R);
            prepare();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void i0() {
        i0 currentTracks;
        ExoPlayer exoPlayer;
        r R;
        r I;
        ExoPlayer exoPlayer2 = this.f17652s;
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
                    ExoPlayer exoPlayer3 = this.f17652s;
                    if (exoPlayer3 != null && (I = exoPlayer3.I()) != null) {
                        int i14 = I.f10238j;
                        int i15 = b11.f10238j;
                        if (i14 == i15) {
                            this.f17648o = i15;
                            oo.e.b(oo.e.f71197a, "ORExoPlayer", "--onPrepare2GetBitrate  MimeType:" + b11.f10243o + "，videoBitrate：" + i15, false, 4, null);
                            Iterator it = this.H.iterator();
                            while (it.hasNext()) {
                                ((com.transsion.player.orplayer.f) it.next()).onTracksVideoBitrateChange(this.f17648o);
                            }
                        }
                    }
                } else if (y.o(b11.f10243o) && (exoPlayer = this.f17652s) != null && (R = exoPlayer.R()) != null) {
                    int i16 = R.f10238j;
                    int i17 = b11.f10238j;
                    if (i16 == i17) {
                        this.f17649p = i17;
                        oo.e.b(oo.e.f71197a, "ORExoPlayer", "--onPrepare2GetBitrate  MimeType:" + b11.f10243o + "，audioBitrate：" + i17, false, 4, null);
                        Iterator it2 = this.H.iterator();
                        while (it2.hasNext()) {
                            ((com.transsion.player.orplayer.f) it2.next()).onTracksAudioBitrateChange(this.f17649p);
                        }
                    }
                }
            }
        }
    }

    private final long j0(long j11, long j12, long j13, long j14) {
        return RangesKt.g(Math.min(j12, j14) - Math.max(j11, j13), 0L);
    }

    private final void k0() {
        this.f17659z = 0L;
        this.A = 0L;
        this.B.clear();
        this.C.clear();
        this.D = -1L;
        this.E = 0L;
    }

    public static final /* synthetic */ ko.e0 l(h hVar) {
        hVar.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(long j11) {
        if (this.D < 0) {
            this.D = RangesKt.g(j11, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(h hVar) {
        ExoPlayer exoPlayer = hVar.f17652s;
        if (exoPlayer == null || exoPlayer.isPlaying()) {
            ExoPlayer exoPlayer2 = hVar.f17652s;
            long currentPosition = exoPlayer2 != null ? exoPlayer2.getCurrentPosition() : 0L;
            hVar.E = currentPosition;
            Iterator it = hVar.H.iterator();
            while (it.hasNext()) {
                ((com.transsion.player.orplayer.f) it.next()).onProgress(currentPosition, hVar.f17642i);
            }
            hVar.g0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String o0(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 5 ? NetworkUtil.NETWORK_TYPE_UNKNOWN : "METADATA" : "TEXT" : "VIDEO" : "AUDIO" : "DEFAULT";
    }

    public final boolean O(ao.e mediaSource) {
        r.a factory;
        Intrinsics.h(mediaSource, "mediaSource");
        String h11 = mediaSource.h();
        if (h11 == null) {
            h11 = mediaSource.k();
        }
        t a11 = new t.c().j(h11).d(String.valueOf(mediaSource.l())).b(mediaSource.g()).h(mediaSource.e()).a();
        Intrinsics.g(a11, "build(...)");
        a.InterfaceC0099a a12 = StringsKt.W(h11, "http", false, 2, null) ? co.d.f17629a.a(mediaSource.f(), mediaSource.d()) : new b.a(this.f17634a);
        PlayMimeType j11 = mediaSource.j();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("dash addStreamDataSource, mimeType:");
        sb2.append(j11);
        int i11 = e.f17673a[mediaSource.j().ordinal()];
        if (i11 == 1) {
            factory = new DashMediaSource.Factory(a12);
        } else {
            if (i11 != 2) {
                return false;
            }
            factory = new HlsMediaSource.Factory(a12);
        }
        androidx.media3.exoplayer.source.r d11 = factory.e(new w() { // from class: co.f
            @Override // androidx.media3.exoplayer.drm.w
            public final androidx.media3.exoplayer.drm.t a(t tVar) {
                androidx.media3.exoplayer.drm.t P;
                P = h.P(tVar);
                return P;
            }
        }).d(a11);
        ExoPlayer exoPlayer = this.f17652s;
        if (exoPlayer != null) {
            exoPlayer.U(d11);
        }
        this.f17642i = mediaSource;
        return true;
    }

    public final a W() {
        Double valueOf;
        List U0 = CollectionsKt.U0(this.C);
        if (this.D >= 0) {
            ExoPlayer exoPlayer = this.f17652s;
            long currentPosition = exoPlayer != null ? exoPlayer.getCurrentPosition() : this.E;
            long j11 = this.D;
            if (currentPosition > j11) {
                U0.add(new d(j11, currentPosition));
            }
        }
        long T = T(U0);
        if (T <= 0) {
            valueOf = null;
        } else {
            valueOf = Double.valueOf((r1 - T) / this.f17659z);
        }
        if (valueOf != null && valueOf.doubleValue() < 0.0d) {
            valueOf = Double.valueOf(0.0d);
        }
        return new a(this.f17659z, this.A, T, valueOf);
    }

    @Override // com.transsion.player.orplayer.g
    public boolean addDataSource(ao.e eVar) {
        return g.b.a(this, eVar);
    }

    @Override // com.transsion.player.orplayer.g
    public void addPlayerListener(com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        g.b.b(this, listener);
        if (this.H.contains(listener)) {
            return;
        }
        this.H.add(listener);
    }

    @Override // com.transsion.player.orplayer.g
    public void changeTrackSelection(mo.d mediaTrackGroup, int i11) {
        i0 currentTracks;
        f0 a11;
        Intrinsics.h(mediaTrackGroup, "mediaTrackGroup");
        int length = mediaTrackGroup.b().length;
        if (i11 < 0 || i11 >= length) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            this.f17648o = mediaTrackGroup.b()[i11].a();
            Iterator it = this.H.iterator();
            while (it.hasNext()) {
                ((com.transsion.player.orplayer.f) it.next()).onTracksVideoBitrateChange(this.f17648o);
            }
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        int i12 = this.f17648o;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("changeTrackSelection  mediaTrackGroup:");
        sb2.append(mediaTrackGroup);
        sb2.append("  index:");
        sb2.append(i11);
        sb2.append(", videoBitrate:");
        sb2.append(i12);
        ExoPlayer exoPlayer = this.f17652s;
        if (exoPlayer == null || (currentTracks = exoPlayer.getCurrentTracks()) == null || (a11 = mo.a.a(currentTracks, mediaTrackGroup)) == null) {
            return;
        }
        ExoPlayer exoPlayer2 = this.f17652s;
        Intrinsics.e(exoPlayer2);
        ExoPlayer exoPlayer3 = this.f17652s;
        Intrinsics.e(exoPlayer3);
        exoPlayer2.V(exoPlayer3.l().a().L(new g0(a11, i11)).F());
    }

    @Override // com.transsion.player.orplayer.g
    public void clearScreen() {
    }

    @Override // com.transsion.player.orplayer.g
    public void clearSurfaceOnly() {
        ExoPlayer exoPlayer = this.f17652s;
        if (exoPlayer != null) {
            exoPlayer.setVideoSurfaceView(null);
        }
        ExoPlayer exoPlayer2 = this.f17652s;
        if (exoPlayer2 != null) {
            exoPlayer2.setVideoTextureView(null);
        }
        this.f17638e = null;
        this.f17639f = null;
    }

    @Override // com.transsion.player.orplayer.g
    public ao.e currentMediaSource() {
        return this.f17642i;
    }

    @Override // com.transsion.player.orplayer.g
    public void enableHardwareDecoder(boolean z10) {
        if (!z10 && this.f17658y == ORExoDecoderType.HARDWARE) {
            oo.e.f71197a.a("ORExoPlayer", "1-硬解切到软解，重新创建设置", true);
            R();
        } else if (z10) {
            ORExoDecoderType oRExoDecoderType = this.f17658y;
            ORExoDecoderType oRExoDecoderType2 = ORExoDecoderType.HARDWARE;
            if (oRExoDecoderType != oRExoDecoderType2) {
                this.f17658y = oRExoDecoderType2;
                oo.e.f71197a.a("ORExoPlayer", "2-软解切换到硬解，重新创建设置", true);
                U(this.f17658y);
                Z();
            }
        }
    }

    @Override // com.transsion.player.orplayer.g
    public Pair getBitrate() {
        return new Pair(Integer.valueOf(this.f17648o), Integer.valueOf(this.f17649p));
    }

    @Override // com.transsion.player.orplayer.g
    public long getCurrentPosition() {
        ExoPlayer exoPlayer = this.f17652s;
        if (exoPlayer != null) {
            return exoPlayer.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.g
    public mo.c getCurrentTracks() {
        i0 currentTracks;
        mo.c c11;
        ExoPlayer exoPlayer = this.f17652s;
        return (exoPlayer == null || (currentTracks = exoPlayer.getCurrentTracks()) == null || (c11 = mo.a.c(currentTracks)) == null) ? new mo.c(null, 1, null) : c11;
    }

    @Override // com.transsion.player.orplayer.g
    public mo.b getCurrentVideoFormat() {
        androidx.media3.common.r I;
        ExoPlayer exoPlayer = this.f17652s;
        if (exoPlayer == null || (I = exoPlayer.I()) == null) {
            return null;
        }
        return mo.a.b(I);
    }

    @Override // com.transsion.player.orplayer.g
    public Object getDownloadBitrate() {
        return g.b.j(this);
    }

    @Override // com.transsion.player.orplayer.g
    public long getDuration() {
        ExoPlayer exoPlayer = this.f17652s;
        if (exoPlayer != null) {
            return exoPlayer.getDuration();
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
        return this.f17643j;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isComplete() {
        ExoPlayer exoPlayer = this.f17652s;
        return exoPlayer != null && exoPlayer.getPlaybackState() == 4;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isLoading() {
        return g.b.m(this);
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isMute() {
        ExoPlayer exoPlayer = this.f17652s;
        if (exoPlayer != null) {
            return exoPlayer.W();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isPlaying() {
        ExoPlayer exoPlayer = this.f17652s;
        if (exoPlayer != null) {
            return exoPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.g
    public boolean isPrepared() {
        ExoPlayer exoPlayer = this.f17652s;
        return exoPlayer != null && exoPlayer.getPlaybackState() == 3;
    }

    public final void l0(com.transsion.player.orplayer.e listener) {
        Intrinsics.h(listener, "listener");
        this.f17651r = listener;
    }

    @Override // com.transsion.player.orplayer.g
    public void pause() {
        com.transsion.player.orplayer.c cVar = this.f17640g;
        if (cVar != null) {
            cVar.g(true);
        }
        Log.e("ORExoPlayer", "pause");
        ExoPlayer exoPlayer = this.f17652s;
        S(exoPlayer != null ? exoPlayer.getCurrentPosition() : this.E);
        e0("pause");
        ExoPlayer exoPlayer2 = this.f17652s;
        if (exoPlayer2 != null) {
            exoPlayer2.pause();
        }
        ExoPlayer exoPlayer3 = this.f17652s;
        if (exoPlayer3 != null) {
            exoPlayer3.getPlayWhenReady();
        }
        com.transsion.player.orplayer.c cVar2 = this.f17640g;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void play() {
        ExoPlayer exoPlayer;
        Log.e("ORExoPlayer", MediaItem.MUSIC_FLOAT_STATE_PLAY);
        ExoPlayer exoPlayer2 = this.f17652s;
        if ((exoPlayer2 != null ? exoPlayer2.c() : null) != null && (exoPlayer = this.f17652s) != null) {
            exoPlayer.prepare();
        }
        ExoPlayer exoPlayer3 = this.f17652s;
        if (exoPlayer3 != null) {
            exoPlayer3.play();
        }
        com.transsion.player.orplayer.c cVar = this.f17640g;
        if (cVar != null) {
            cVar.g(false);
        }
        com.transsion.player.orplayer.c cVar2 = this.f17640g;
        if (cVar2 != null) {
            cVar2.e();
        }
        this.f17650q = false;
    }

    @Override // com.transsion.player.orplayer.g
    public void prepare() {
        Log.e("ORExoPlayer", "prepare");
        ExoPlayer exoPlayer = this.f17652s;
        if (exoPlayer != null) {
            exoPlayer.prepare();
        }
        this.f17650q = false;
    }

    @Override // com.transsion.player.orplayer.g
    public void release() {
        f0();
        ExoPlayer exoPlayer = this.f17652s;
        S(exoPlayer != null ? exoPlayer.getCurrentPosition() : this.E);
        e0("release");
        this.f17636c = false;
        this.f17650q = false;
        this.f17637d = false;
        Log.e("ORExoPlayer", "release");
        if (ko.m0.f67107a.a(this)) {
            ExoPlayer exoPlayer2 = this.f17652s;
            if (exoPlayer2 != null) {
                exoPlayer2.release();
            }
        } else {
            ExoPlayer exoPlayer3 = this.f17652s;
            if (exoPlayer3 != null) {
                exoPlayer3.stop();
            }
            ExoPlayer exoPlayer4 = this.f17652s;
            if (exoPlayer4 != null) {
                exoPlayer4.B();
            }
            ExoPlayer exoPlayer5 = this.f17652s;
            if (exoPlayer5 != null) {
                exoPlayer5.clearVideoSurface();
            }
        }
        for (com.transsion.player.orplayer.f fVar : this.H) {
            if (fVar != null) {
                fVar.onPlayerRelease(this.f17642i);
            }
        }
        a W = W();
        com.transsion.player.orplayer.e eVar = this.f17651r;
        if (eVar != null) {
            eVar.a(W.d(), W.b(), W.a(), this.f17641h);
        }
        com.transsion.player.orplayer.c cVar = this.f17640g;
        if (cVar != null) {
            cVar.b();
        }
        this.f17657x = null;
        this.f17658y = ORExoDecoderType.HARDWARE;
        this.f17642i = null;
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
    public void removePlayerListener(com.transsion.player.orplayer.f listener) {
        Intrinsics.h(listener, "listener");
        g.b.q(this, listener);
        this.H.remove(listener);
    }

    @Override // com.transsion.player.orplayer.g
    public boolean requestForce() {
        return g.b.r(this);
    }

    @Override // com.transsion.player.orplayer.g
    public void reset() {
        Log.e("ORExoPlayer", "reset    ");
        ExoPlayer exoPlayer = this.f17652s;
        S(exoPlayer != null ? exoPlayer.getCurrentPosition() : this.E);
        e0("reset");
        this.f17636c = false;
        this.f17650q = false;
        this.f17637d = false;
        ExoPlayer exoPlayer2 = this.f17652s;
        if (exoPlayer2 != null) {
            exoPlayer2.stop();
        }
        ExoPlayer exoPlayer3 = this.f17652s;
        if (exoPlayer3 != null) {
            exoPlayer3.B();
        }
        this.f17658y = ORExoDecoderType.HARDWARE;
        this.f17642i = null;
        for (com.transsion.player.orplayer.f fVar : this.H) {
            if (fVar != null) {
                fVar.onPlayerReset();
            }
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void seekTo(long j11) {
        ExoPlayer exoPlayer;
        Log.e("ORExoPlayer", "seekTo    mills:" + j11);
        this.f17650q = false;
        ExoPlayer exoPlayer2 = this.f17652s;
        if ((exoPlayer2 != null ? exoPlayer2.c() : null) != null && (exoPlayer = this.f17652s) != null) {
            exoPlayer.prepare();
        }
        ExoPlayer exoPlayer3 = this.f17652s;
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
        g.b.s(this, uuid, j11);
        this.f17650q = false;
        ExoPlayer exoPlayer2 = this.f17652s;
        int F = exoPlayer2 != null ? exoPlayer2.F() : 0;
        for (int i11 = 0; i11 < F; i11++) {
            ExoPlayer exoPlayer3 = this.f17652s;
            if (Intrinsics.c((exoPlayer3 == null || (O = exoPlayer3.O(i11)) == null || (hVar = O.f10293b) == null) ? null : hVar.f10389e, uuid)) {
                ExoPlayer exoPlayer4 = this.f17652s;
                if ((exoPlayer4 != null ? exoPlayer4.c() : null) != null) {
                    prepare();
                }
                ExoPlayer exoPlayer5 = this.f17652s;
                if (exoPlayer5 == null || exoPlayer5.t() != i11) {
                    Log.e("ORExoPlayer", "seekTo  index:" + i11 + " uuid:" + uuid);
                    ExoPlayer exoPlayer6 = this.f17652s;
                    if (exoPlayer6 != null) {
                        exoPlayer6.seekTo(i11, j11);
                    }
                } else {
                    if (isComplete() && (exoPlayer = this.f17652s) != null) {
                        exoPlayer.seekTo(j11);
                    }
                    Log.e("ORExoPlayer", "seekTo   uuid:" + uuid + " mills:" + j11 + "  是当前视频直接播放");
                }
                play();
                return;
            }
        }
        Log.e("ORExoPlayer", "seekTo   uuid:" + uuid + " mills:" + j11 + "  没有找到");
        pause();
    }

    @Override // com.transsion.player.orplayer.g
    public void setAutoPlay(boolean z10) {
        this.f17644k = z10;
        ExoPlayer exoPlayer = this.f17652s;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(z10);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setDataSource(ao.e mediaSource) {
        Intrinsics.h(mediaSource, "mediaSource");
        k0();
        oo.e.f71197a.a("ORExoPlayer", "setDataSource url:" + mediaSource.k(), true);
        Iterator it = this.H.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.f) it.next()).onSetDataSource();
        }
        if (d0(mediaSource)) {
            O(mediaSource);
            return;
        }
        if (c0(mediaSource)) {
            N(mediaSource);
            return;
        }
        t a11 = new t.c().j(mediaSource.k()).d(String.valueOf(mediaSource.l())).b(mediaSource.g()).a();
        Intrinsics.g(a11, "build(...)");
        ExoPlayer exoPlayer = this.f17652s;
        if (exoPlayer != null) {
            exoPlayer.H(a11);
        }
        this.f17642i = mediaSource;
    }

    @Override // com.transsion.player.orplayer.g
    public void setLooping(boolean z10) {
        this.f17645l = z10;
        ExoPlayer exoPlayer = this.f17652s;
        if (exoPlayer != null) {
            exoPlayer.setRepeatMode(z10 ? 1 : 0);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setMute(boolean z10) {
        this.f17646m = z10;
        ExoPlayer exoPlayer = this.f17652s;
        if (exoPlayer != null) {
            exoPlayer.A(z10, 1);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setPlayerConfig(bo.d dVar) {
        g.b.w(this, dVar);
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
        g.b.x(this, scaleMode);
        this.L = scaleMode;
        int i11 = e.f17674b[scaleMode.ordinal()];
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
        TextureRenderView textureRenderView = this.f17639f;
        if (textureRenderView != null) {
            textureRenderView.setScaleType(renderScaleMode);
        }
        SurfaceRenderView surfaceRenderView = this.f17638e;
        if (surfaceRenderView != null) {
            surfaceRenderView.setScaleType(renderScaleMode);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setSpeed(float f11) {
        this.f17647n = f11;
        ExoPlayer exoPlayer = this.f17652s;
        if (exoPlayer != null) {
            exoPlayer.a(f11);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setSurfaceView(SurfaceView surfaceView) {
        this.f17638e = surfaceView instanceof SurfaceRenderView ? (SurfaceRenderView) surfaceView : null;
        ExoPlayer exoPlayer = this.f17652s;
        if (exoPlayer != null) {
            exoPlayer.setVideoSurfaceView(surfaceView);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setTextureView(TextureView textureView) {
        this.f17639f = textureView instanceof TextureRenderView ? (TextureRenderView) textureView : null;
        ExoPlayer exoPlayer = this.f17652s;
        if (exoPlayer != null) {
            exoPlayer.setVideoTextureView(textureView);
        }
    }

    @Override // com.transsion.player.orplayer.g
    public void setVipResolution(boolean z10, int i11) {
        this.f17653t = Boolean.valueOf(z10);
        this.f17654u = i11;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("LongVideoView 非会员可以播放 vipResolution :");
        sb2.append(i11);
    }

    @Override // com.transsion.player.orplayer.g
    public void setVolume(float f11) {
        float l11 = RangesKt.l(f11, 0.0f, 2.0f);
        b4 b4Var = this.G;
        j jVar = b4Var instanceof j ? (j) b4Var : null;
        if (jVar != null) {
            jVar.s(l11);
        }
        ExoPlayer exoPlayer = this.f17652s;
        if (exoPlayer != null) {
            exoPlayer.setVolume(l11);
        }
        this.f17643j = Float.valueOf(l11);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setVolume  volume:");
        sb2.append(f11);
    }

    @Override // com.transsion.player.orplayer.g
    public void stop() {
        Log.e("ORExoPlayer", "stop    ");
        ExoPlayer exoPlayer = this.f17652s;
        S(exoPlayer != null ? exoPlayer.getCurrentPosition() : this.E);
        e0("stop");
        com.transsion.player.orplayer.c cVar = this.f17640g;
        if (cVar != null) {
            cVar.g(true);
        }
        ExoPlayer exoPlayer2 = this.f17652s;
        if (exoPlayer2 != null) {
            exoPlayer2.stop();
        }
        this.f17636c = false;
        this.f17650q = false;
        this.f17637d = false;
        com.transsion.player.orplayer.c cVar2 = this.f17640g;
        if (cVar2 != null) {
            cVar2.b();
        }
    }
}
