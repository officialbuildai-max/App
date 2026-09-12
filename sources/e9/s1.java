package e9;

import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.a2;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.n2;
import com.google.android.exoplayer2.o2;
import com.google.android.exoplayer2.p3;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource$HttpDataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidContentTypeException;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import com.google.android.exoplayer2.v1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.r4;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import e9.c;
import e9.t1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import y1.c3;
import y1.g2;
import y1.m2;
import y1.n3;
import y1.r2;
import y1.r3;

/* loaded from: classes4.dex */
public final class s1 implements c, t1.a {
    private boolean A;

    /* renamed from: a, reason: collision with root package name */
    private final Context f61885a;

    /* renamed from: b, reason: collision with root package name */
    private final t1 f61886b;

    /* renamed from: c, reason: collision with root package name */
    private final PlaybackSession f61887c;

    /* renamed from: i, reason: collision with root package name */
    private String f61893i;

    /* renamed from: j, reason: collision with root package name */
    private PlaybackMetrics.Builder f61894j;

    /* renamed from: k, reason: collision with root package name */
    private int f61895k;

    /* renamed from: n, reason: collision with root package name */
    private PlaybackException f61898n;

    /* renamed from: o, reason: collision with root package name */
    private b f61899o;

    /* renamed from: p, reason: collision with root package name */
    private b f61900p;

    /* renamed from: q, reason: collision with root package name */
    private b f61901q;

    /* renamed from: r, reason: collision with root package name */
    private com.google.android.exoplayer2.o1 f61902r;

    /* renamed from: s, reason: collision with root package name */
    private com.google.android.exoplayer2.o1 f61903s;

    /* renamed from: t, reason: collision with root package name */
    private com.google.android.exoplayer2.o1 f61904t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f61905u;

    /* renamed from: v, reason: collision with root package name */
    private int f61906v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f61907w;

    /* renamed from: x, reason: collision with root package name */
    private int f61908x;

    /* renamed from: y, reason: collision with root package name */
    private int f61909y;

    /* renamed from: z, reason: collision with root package name */
    private int f61910z;

    /* renamed from: e, reason: collision with root package name */
    private final k3.d f61889e = new k3.d();

    /* renamed from: f, reason: collision with root package name */
    private final k3.b f61890f = new k3.b();

    /* renamed from: h, reason: collision with root package name */
    private final HashMap f61892h = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private final HashMap f61891g = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final long f61888d = SystemClock.elapsedRealtime();

    /* renamed from: l, reason: collision with root package name */
    private int f61896l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f61897m = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f61911a;

        /* renamed from: b, reason: collision with root package name */
        public final int f61912b;

        public a(int i11, int i12) {
            this.f61911a = i11;
            this.f61912b = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.o1 f61913a;

        /* renamed from: b, reason: collision with root package name */
        public final int f61914b;

        /* renamed from: c, reason: collision with root package name */
        public final String f61915c;

        public b(com.google.android.exoplayer2.o1 o1Var, int i11, String str) {
            this.f61913a = o1Var;
            this.f61914b = i11;
            this.f61915c = str;
        }
    }

    private s1(Context context, PlaybackSession playbackSession) {
        this.f61885a = context.getApplicationContext();
        this.f61887c = playbackSession;
        r1 r1Var = new r1();
        this.f61886b = r1Var;
        r1Var.g(this);
    }

    private boolean A0(b bVar) {
        return bVar != null && bVar.f61915c.equals(this.f61886b.a());
    }

    public static s1 B0(Context context) {
        PlaybackSession createPlaybackSession;
        MediaMetricsManager a11 = r3.a(context.getSystemService("media_metrics"));
        if (a11 == null) {
            return null;
        }
        createPlaybackSession = a11.createPlaybackSession();
        return new s1(context, createPlaybackSession);
    }

    private void C0() {
        PlaybackMetrics build;
        PlaybackMetrics.Builder builder = this.f61894j;
        if (builder != null && this.A) {
            builder.setAudioUnderrunCount(this.f61910z);
            this.f61894j.setVideoFramesDropped(this.f61908x);
            this.f61894j.setVideoFramesPlayed(this.f61909y);
            Long l11 = (Long) this.f61891g.get(this.f61893i);
            this.f61894j.setNetworkTransferDurationMillis(l11 == null ? 0L : l11.longValue());
            Long l12 = (Long) this.f61892h.get(this.f61893i);
            this.f61894j.setNetworkBytesRead(l12 == null ? 0L : l12.longValue());
            this.f61894j.setStreamSource((l12 == null || l12.longValue() <= 0) ? 0 : 1);
            PlaybackSession playbackSession = this.f61887c;
            build = this.f61894j.build();
            playbackSession.reportPlaybackMetrics(build);
        }
        this.f61894j = null;
        this.f61893i = null;
        this.f61910z = 0;
        this.f61908x = 0;
        this.f61909y = 0;
        this.f61902r = null;
        this.f61903s = null;
        this.f61904t = null;
        this.A = false;
    }

    private static int D0(int i11) {
        switch (com.google.android.exoplayer2.util.p0.V(i11)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    private static DrmInitData E0(ImmutableList immutableList) {
        DrmInitData drmInitData;
        r4 it = immutableList.iterator();
        while (it.hasNext()) {
            p3.a aVar = (p3.a) it.next();
            for (int i11 = 0; i11 < aVar.f25657a; i11++) {
                if (aVar.e(i11) && (drmInitData = aVar.b(i11).f25553o) != null) {
                    return drmInitData;
                }
            }
        }
        return null;
    }

    private static int F0(DrmInitData drmInitData) {
        for (int i11 = 0; i11 < drmInitData.schemeDataCount; i11++) {
            UUID uuid = drmInitData.get(i11).uuid;
            if (uuid.equals(com.google.android.exoplayer2.l.f25243d)) {
                return 3;
            }
            if (uuid.equals(com.google.android.exoplayer2.l.f25244e)) {
                return 2;
            }
            if (uuid.equals(com.google.android.exoplayer2.l.f25242c)) {
                return 6;
            }
        }
        return 1;
    }

    private static a G0(PlaybackException playbackException, Context context, boolean z10) {
        int i11;
        boolean z11;
        if (playbackException.errorCode == 1001) {
            return new a(20, 0);
        }
        if (playbackException instanceof ExoPlaybackException) {
            ExoPlaybackException exoPlaybackException = (ExoPlaybackException) playbackException;
            z11 = exoPlaybackException.type == 1;
            i11 = exoPlaybackException.rendererFormatSupport;
        } else {
            i11 = 0;
            z11 = false;
        }
        Throwable th2 = (Throwable) com.google.android.exoplayer2.util.a.e(playbackException.getCause());
        if (!(th2 instanceof IOException)) {
            if (z11 && (i11 == 0 || i11 == 1)) {
                return new a(35, 0);
            }
            if (z11 && i11 == 3) {
                return new a(15, 0);
            }
            if (z11 && i11 == 2) {
                return new a(23, 0);
            }
            if (th2 instanceof MediaCodecRenderer.DecoderInitializationException) {
                return new a(13, com.google.android.exoplayer2.util.p0.W(((MediaCodecRenderer.DecoderInitializationException) th2).diagnosticInfo));
            }
            if (th2 instanceof MediaCodecDecoderException) {
                return new a(14, com.google.android.exoplayer2.util.p0.W(((MediaCodecDecoderException) th2).diagnosticInfo));
            }
            if (th2 instanceof OutOfMemoryError) {
                return new a(14, 0);
            }
            if (th2 instanceof AudioSink.InitializationException) {
                return new a(17, ((AudioSink.InitializationException) th2).audioTrackState);
            }
            if (th2 instanceof AudioSink.WriteException) {
                return new a(18, ((AudioSink.WriteException) th2).errorCode);
            }
            if (com.google.android.exoplayer2.util.p0.f27680a < 16 || !(th2 instanceof MediaCodec.CryptoException)) {
                return new a(22, 0);
            }
            int errorCode = ((MediaCodec.CryptoException) th2).getErrorCode();
            return new a(D0(errorCode), errorCode);
        }
        if (th2 instanceof HttpDataSource$InvalidResponseCodeException) {
            return new a(5, ((HttpDataSource$InvalidResponseCodeException) th2).responseCode);
        }
        if ((th2 instanceof HttpDataSource$InvalidContentTypeException) || (th2 instanceof ParserException)) {
            return new a(z10 ? 10 : 11, 0);
        }
        boolean z12 = th2 instanceof HttpDataSource$HttpDataSourceException;
        if (z12 || (th2 instanceof UdpDataSource.UdpDataSourceException)) {
            if (com.google.android.exoplayer2.util.z.d(context).f() == 1) {
                return new a(3, 0);
            }
            Throwable cause = th2.getCause();
            return cause instanceof UnknownHostException ? new a(6, 0) : cause instanceof SocketTimeoutException ? new a(7, 0) : (z12 && ((HttpDataSource$HttpDataSourceException) th2).type == 1) ? new a(4, 0) : new a(8, 0);
        }
        if (playbackException.errorCode == 1002) {
            return new a(21, 0);
        }
        if (!(th2 instanceof DrmSession.DrmSessionException)) {
            if (!(th2 instanceof FileDataSource.FileDataSourceException) || !(th2.getCause() instanceof FileNotFoundException)) {
                return new a(9, 0);
            }
            Throwable cause2 = ((Throwable) com.google.android.exoplayer2.util.a.e(th2.getCause())).getCause();
            return (com.google.android.exoplayer2.util.p0.f27680a >= 21 && (cause2 instanceof ErrnoException) && ((ErrnoException) cause2).errno == OsConstants.EACCES) ? new a(32, 0) : new a(31, 0);
        }
        Throwable th3 = (Throwable) com.google.android.exoplayer2.util.a.e(th2.getCause());
        int i12 = com.google.android.exoplayer2.util.p0.f27680a;
        if (i12 < 21 || !(th3 instanceof MediaDrm.MediaDrmStateException)) {
            return (i12 < 23 || !(th3 instanceof MediaDrmResetException)) ? (i12 < 18 || !(th3 instanceof NotProvisionedException)) ? (i12 < 18 || !(th3 instanceof DeniedByServerException)) ? th3 instanceof UnsupportedDrmException ? new a(23, 0) : th3 instanceof DefaultDrmSessionManager.MissingSchemeDataException ? new a(28, 0) : new a(30, 0) : new a(29, 0) : new a(24, 0) : new a(27, 0);
        }
        int W = com.google.android.exoplayer2.util.p0.W(((MediaDrm.MediaDrmStateException) th3).getDiagnosticInfo());
        return new a(D0(W), W);
    }

    private static Pair H0(String str) {
        String[] S0 = com.google.android.exoplayer2.util.p0.S0(str, "-");
        return Pair.create(S0[0], S0.length >= 2 ? S0[1] : null);
    }

    private static int J0(Context context) {
        switch (com.google.android.exoplayer2.util.z.d(context).f()) {
            case 0:
                return 0;
            case 1:
                return 9;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
            case 8:
            default:
                return 1;
            case 7:
                return 3;
            case 9:
                return 8;
            case 10:
                return 7;
        }
    }

    private static int K0(v1 v1Var) {
        v1.h hVar = v1Var.f27763b;
        if (hVar == null) {
            return 0;
        }
        int q02 = com.google.android.exoplayer2.util.p0.q0(hVar.f27826a, hVar.f27827b);
        if (q02 == 0) {
            return 3;
        }
        if (q02 != 1) {
            return q02 != 2 ? 1 : 4;
        }
        return 5;
    }

    private static int L0(int i11) {
        if (i11 == 1) {
            return 2;
        }
        if (i11 != 2) {
            return i11 != 3 ? 1 : 4;
        }
        return 3;
    }

    private void M0(c.b bVar) {
        for (int i11 = 0; i11 < bVar.d(); i11++) {
            int b11 = bVar.b(i11);
            c.a c11 = bVar.c(b11);
            if (b11 == 0) {
                this.f61886b.d(c11);
            } else if (b11 == 11) {
                this.f61886b.c(c11, this.f61895k);
            } else {
                this.f61886b.b(c11);
            }
        }
    }

    private void N0(long j11) {
        NetworkEvent.Builder networkType;
        NetworkEvent.Builder timeSinceCreatedMillis;
        NetworkEvent build;
        int J0 = J0(this.f61885a);
        if (J0 != this.f61897m) {
            this.f61897m = J0;
            PlaybackSession playbackSession = this.f61887c;
            networkType = g2.a().setNetworkType(J0);
            timeSinceCreatedMillis = networkType.setTimeSinceCreatedMillis(j11 - this.f61888d);
            build = timeSinceCreatedMillis.build();
            playbackSession.reportNetworkEvent(build);
        }
    }

    private void O0(long j11) {
        PlaybackErrorEvent.Builder timeSinceCreatedMillis;
        PlaybackErrorEvent.Builder errorCode;
        PlaybackErrorEvent.Builder subErrorCode;
        PlaybackErrorEvent.Builder exception;
        PlaybackErrorEvent build;
        PlaybackException playbackException = this.f61898n;
        if (playbackException == null) {
            return;
        }
        a G0 = G0(playbackException, this.f61885a, this.f61906v == 4);
        PlaybackSession playbackSession = this.f61887c;
        timeSinceCreatedMillis = c3.a().setTimeSinceCreatedMillis(j11 - this.f61888d);
        errorCode = timeSinceCreatedMillis.setErrorCode(G0.f61911a);
        subErrorCode = errorCode.setSubErrorCode(G0.f61912b);
        exception = subErrorCode.setException(playbackException);
        build = exception.build();
        playbackSession.reportPlaybackErrorEvent(build);
        this.A = true;
        this.f61898n = null;
    }

    private void P0(o2 o2Var, c.b bVar, long j11) {
        PlaybackStateEvent.Builder state;
        PlaybackStateEvent.Builder timeSinceCreatedMillis;
        PlaybackStateEvent build;
        if (o2Var.getPlaybackState() != 2) {
            this.f61905u = false;
        }
        if (o2Var.c() == null) {
            this.f61907w = false;
        } else if (bVar.a(10)) {
            this.f61907w = true;
        }
        int X0 = X0(o2Var);
        if (this.f61896l != X0) {
            this.f61896l = X0;
            this.A = true;
            PlaybackSession playbackSession = this.f61887c;
            state = n3.a().setState(this.f61896l);
            timeSinceCreatedMillis = state.setTimeSinceCreatedMillis(j11 - this.f61888d);
            build = timeSinceCreatedMillis.build();
            playbackSession.reportPlaybackStateEvent(build);
        }
    }

    private void Q0(o2 o2Var, c.b bVar, long j11) {
        if (bVar.a(2)) {
            p3 currentTracks = o2Var.getCurrentTracks();
            boolean c11 = currentTracks.c(2);
            boolean c12 = currentTracks.c(1);
            boolean c13 = currentTracks.c(3);
            if (c11 || c12 || c13) {
                if (!c11) {
                    V0(j11, null, 0);
                }
                if (!c12) {
                    R0(j11, null, 0);
                }
                if (!c13) {
                    T0(j11, null, 0);
                }
            }
        }
        if (A0(this.f61899o)) {
            b bVar2 = this.f61899o;
            com.google.android.exoplayer2.o1 o1Var = bVar2.f61913a;
            if (o1Var.f25556r != -1) {
                V0(j11, o1Var, bVar2.f61914b);
                this.f61899o = null;
            }
        }
        if (A0(this.f61900p)) {
            b bVar3 = this.f61900p;
            R0(j11, bVar3.f61913a, bVar3.f61914b);
            this.f61900p = null;
        }
        if (A0(this.f61901q)) {
            b bVar4 = this.f61901q;
            T0(j11, bVar4.f61913a, bVar4.f61914b);
            this.f61901q = null;
        }
    }

    private void R0(long j11, com.google.android.exoplayer2.o1 o1Var, int i11) {
        if (com.google.android.exoplayer2.util.p0.c(this.f61903s, o1Var)) {
            return;
        }
        if (this.f61903s == null && i11 == 0) {
            i11 = 1;
        }
        this.f61903s = o1Var;
        W0(0, j11, o1Var, i11);
    }

    private void S0(o2 o2Var, c.b bVar) {
        DrmInitData E0;
        if (bVar.a(0)) {
            c.a c11 = bVar.c(0);
            if (this.f61894j != null) {
                U0(c11.f61739b, c11.f61741d);
            }
        }
        if (bVar.a(2) && this.f61894j != null && (E0 = E0(o2Var.getCurrentTracks().b())) != null) {
            m2.a(com.google.android.exoplayer2.util.p0.j(this.f61894j)).setDrmType(F0(E0));
        }
        if (bVar.a(1011)) {
            this.f61910z++;
        }
    }

    private void T0(long j11, com.google.android.exoplayer2.o1 o1Var, int i11) {
        if (com.google.android.exoplayer2.util.p0.c(this.f61904t, o1Var)) {
            return;
        }
        if (this.f61904t == null && i11 == 0) {
            i11 = 1;
        }
        this.f61904t = o1Var;
        W0(2, j11, o1Var, i11);
    }

    private void U0(k3 k3Var, o.b bVar) {
        int f11;
        PlaybackMetrics.Builder builder = this.f61894j;
        if (bVar == null || (f11 = k3Var.f(bVar.f76237a)) == -1) {
            return;
        }
        k3Var.j(f11, this.f61890f);
        k3Var.r(this.f61890f.f25210c, this.f61889e);
        builder.setStreamType(K0(this.f61889e.f25225c));
        k3.d dVar = this.f61889e;
        if (dVar.f25236n != C.TIME_UNSET && !dVar.f25234l && !dVar.f25231i && !dVar.i()) {
            builder.setMediaDurationMillis(this.f61889e.g());
        }
        builder.setPlaybackType(this.f61889e.i() ? 2 : 1);
        this.A = true;
    }

    private void V0(long j11, com.google.android.exoplayer2.o1 o1Var, int i11) {
        if (com.google.android.exoplayer2.util.p0.c(this.f61902r, o1Var)) {
            return;
        }
        if (this.f61902r == null && i11 == 0) {
            i11 = 1;
        }
        this.f61902r = o1Var;
        W0(1, j11, o1Var, i11);
    }

    private void W0(int i11, long j11, com.google.android.exoplayer2.o1 o1Var, int i12) {
        TrackChangeEvent.Builder timeSinceCreatedMillis;
        TrackChangeEvent build;
        timeSinceCreatedMillis = y1.v1.a(i11).setTimeSinceCreatedMillis(j11 - this.f61888d);
        if (o1Var != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(L0(i12));
            String str = o1Var.f25549k;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = o1Var.f25550l;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = o1Var.f25547i;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i13 = o1Var.f25546h;
            if (i13 != -1) {
                timeSinceCreatedMillis.setBitrate(i13);
            }
            int i14 = o1Var.f25555q;
            if (i14 != -1) {
                timeSinceCreatedMillis.setWidth(i14);
            }
            int i15 = o1Var.f25556r;
            if (i15 != -1) {
                timeSinceCreatedMillis.setHeight(i15);
            }
            int i16 = o1Var.f25563y;
            if (i16 != -1) {
                timeSinceCreatedMillis.setChannelCount(i16);
            }
            int i17 = o1Var.f25564z;
            if (i17 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i17);
            }
            String str4 = o1Var.f25541c;
            if (str4 != null) {
                Pair H0 = H0(str4);
                timeSinceCreatedMillis.setLanguage((String) H0.first);
                Object obj = H0.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f11 = o1Var.f25557s;
            if (f11 != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f11);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.A = true;
        PlaybackSession playbackSession = this.f61887c;
        build = timeSinceCreatedMillis.build();
        playbackSession.reportTrackChangeEvent(build);
    }

    private int X0(o2 o2Var) {
        int playbackState = o2Var.getPlaybackState();
        if (this.f61905u) {
            return 5;
        }
        if (this.f61907w) {
            return 13;
        }
        if (playbackState == 4) {
            return 11;
        }
        if (playbackState == 2) {
            int i11 = this.f61896l;
            if (i11 == 0 || i11 == 2) {
                return 2;
            }
            if (o2Var.getPlayWhenReady()) {
                return o2Var.j() != 0 ? 10 : 6;
            }
            return 7;
        }
        if (playbackState == 3) {
            if (o2Var.getPlayWhenReady()) {
                return o2Var.j() != 0 ? 9 : 3;
            }
            return 4;
        }
        if (playbackState != 1 || this.f61896l == 0) {
            return this.f61896l;
        }
        return 12;
    }

    @Override // e9.c
    public /* synthetic */ void A(c.a aVar, Object obj, long j11) {
        e9.b.T(this, aVar, obj, j11);
    }

    @Override // e9.c
    public /* synthetic */ void B(c.a aVar, com.google.android.exoplayer2.o1 o1Var, com.google.android.exoplayer2.decoder.g gVar) {
        e9.b.h(this, aVar, o1Var, gVar);
    }

    @Override // e9.c
    public /* synthetic */ void C(c.a aVar, String str, long j11) {
        e9.b.b(this, aVar, str, j11);
    }

    @Override // e9.c
    public /* synthetic */ void D(c.a aVar, int i11, com.google.android.exoplayer2.o1 o1Var) {
        e9.b.r(this, aVar, i11, o1Var);
    }

    @Override // e9.c
    public /* synthetic */ void E(c.a aVar) {
        e9.b.x(this, aVar);
    }

    @Override // e9.c
    public /* synthetic */ void F(c.a aVar, int i11, long j11, long j12) {
        e9.b.k(this, aVar, i11, j11, j12);
    }

    @Override // e9.c
    public /* synthetic */ void G(c.a aVar, long j11, int i11) {
        e9.b.j0(this, aVar, j11, i11);
    }

    @Override // e9.c
    public /* synthetic */ void H(c.a aVar, com.google.android.exoplayer2.decoder.e eVar) {
        e9.b.i0(this, aVar, eVar);
    }

    @Override // e9.c
    public void I(o2 o2Var, c.b bVar) {
        if (bVar.d() == 0) {
            return;
        }
        M0(bVar);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        S0(o2Var, bVar);
        O0(elapsedRealtime);
        Q0(o2Var, bVar, elapsedRealtime);
        N0(elapsedRealtime);
        P0(o2Var, bVar, elapsedRealtime);
        if (bVar.a(1028)) {
            this.f61886b.e(bVar.c(1028));
        }
    }

    public LogSessionId I0() {
        LogSessionId sessionId;
        sessionId = this.f61887c.getSessionId();
        return sessionId;
    }

    @Override // e9.c
    public /* synthetic */ void J(c.a aVar) {
        e9.b.v(this, aVar);
    }

    @Override // e9.c
    public /* synthetic */ void K(c.a aVar, int i11) {
        e9.b.U(this, aVar, i11);
    }

    @Override // e9.c
    public /* synthetic */ void L(c.a aVar) {
        e9.b.W(this, aVar);
    }

    @Override // e9.c
    public void M(c.a aVar, PlaybackException playbackException) {
        this.f61898n = playbackException;
    }

    @Override // e9.c
    public /* synthetic */ void N(c.a aVar, int i11, com.google.android.exoplayer2.decoder.e eVar) {
        e9.b.p(this, aVar, i11, eVar);
    }

    @Override // e9.c
    public /* synthetic */ void O(c.a aVar, boolean z10) {
        e9.b.D(this, aVar, z10);
    }

    @Override // e9.c
    public /* synthetic */ void P(c.a aVar, com.google.android.exoplayer2.decoder.e eVar) {
        e9.b.e(this, aVar, eVar);
    }

    @Override // e9.t1.a
    public void Q(c.a aVar, String str, boolean z10) {
        o.b bVar = aVar.f61741d;
        if ((bVar == null || !bVar.b()) && str.equals(this.f61893i)) {
            C0();
        }
        this.f61891g.remove(str);
        this.f61892h.remove(str);
    }

    @Override // e9.c
    public /* synthetic */ void R(c.a aVar, int i11) {
        e9.b.S(this, aVar, i11);
    }

    @Override // e9.t1.a
    public void S(c.a aVar, String str) {
        PlaybackMetrics.Builder playerName;
        PlaybackMetrics.Builder playerVersion;
        o.b bVar = aVar.f61741d;
        if (bVar == null || !bVar.b()) {
            C0();
            this.f61893i = str;
            playerName = r2.a().setPlayerName("ExoPlayerLib");
            playerVersion = playerName.setPlayerVersion("2.18.1");
            this.f61894j = playerVersion;
            U0(aVar.f61739b, aVar.f61741d);
        }
    }

    @Override // e9.c
    public /* synthetic */ void T(c.a aVar, float f11) {
        e9.b.n0(this, aVar, f11);
    }

    @Override // e9.c
    public void U(c.a aVar, com.google.android.exoplayer2.decoder.e eVar) {
        this.f61908x += eVar.f24935g;
        this.f61909y += eVar.f24933e;
    }

    @Override // e9.c
    public /* synthetic */ void V(c.a aVar, p3 p3Var) {
        e9.b.c0(this, aVar, p3Var);
    }

    @Override // e9.c
    public /* synthetic */ void W(c.a aVar, int i11, long j11) {
        e9.b.B(this, aVar, i11, j11);
    }

    @Override // e9.c
    public /* synthetic */ void X(c.a aVar) {
        e9.b.V(this, aVar);
    }

    @Override // e9.c
    public /* synthetic */ void Y(c.a aVar, String str, long j11) {
        e9.b.f0(this, aVar, str, j11);
    }

    @Override // e9.c
    public /* synthetic */ void Z(c.a aVar, int i11, String str, long j11) {
        e9.b.q(this, aVar, i11, str, j11);
    }

    @Override // e9.c
    public /* synthetic */ void a(c.a aVar, String str) {
        e9.b.h0(this, aVar, str);
    }

    @Override // e9.c
    public void a0(c.a aVar, int i11, long j11, long j12) {
        o.b bVar = aVar.f61741d;
        if (bVar != null) {
            String f11 = this.f61886b.f(aVar.f61739b, (o.b) com.google.android.exoplayer2.util.a.e(bVar));
            Long l11 = (Long) this.f61892h.get(f11);
            Long l12 = (Long) this.f61891g.get(f11);
            this.f61892h.put(f11, Long.valueOf((l11 == null ? 0L : l11.longValue()) + j11));
            this.f61891g.put(f11, Long.valueOf((l12 != null ? l12.longValue() : 0L) + i11));
        }
    }

    @Override // e9.c
    public /* synthetic */ void b(c.a aVar, boolean z10) {
        e9.b.H(this, aVar, z10);
    }

    @Override // e9.c
    public /* synthetic */ void b0(c.a aVar, boolean z10) {
        e9.b.Y(this, aVar, z10);
    }

    @Override // e9.c
    public /* synthetic */ void c(c.a aVar, int i11) {
        e9.b.O(this, aVar, i11);
    }

    @Override // e9.c
    public /* synthetic */ void c0(c.a aVar, boolean z10) {
        e9.b.C(this, aVar, z10);
    }

    @Override // e9.c
    public /* synthetic */ void d(c.a aVar, t9.h hVar, t9.i iVar) {
        e9.b.G(this, aVar, hVar, iVar);
    }

    @Override // e9.c
    public /* synthetic */ void d0(c.a aVar, int i11, boolean z10) {
        e9.b.t(this, aVar, i11, z10);
    }

    @Override // e9.c
    public /* synthetic */ void e(c.a aVar, com.google.android.exoplayer2.o1 o1Var, com.google.android.exoplayer2.decoder.g gVar) {
        e9.b.l0(this, aVar, o1Var, gVar);
    }

    @Override // e9.c
    public /* synthetic */ void e0(c.a aVar, String str, long j11, long j12) {
        e9.b.c(this, aVar, str, j11, j12);
    }

    @Override // e9.c
    public /* synthetic */ void f(c.a aVar) {
        e9.b.w(this, aVar);
    }

    @Override // e9.c
    public /* synthetic */ void f0(c.a aVar) {
        e9.b.u(this, aVar);
    }

    @Override // e9.c
    public /* synthetic */ void g(c.a aVar, boolean z10, int i11) {
        e9.b.L(this, aVar, z10, i11);
    }

    @Override // e9.c
    public /* synthetic */ void g0(c.a aVar, int i11, com.google.android.exoplayer2.decoder.e eVar) {
        e9.b.o(this, aVar, i11, eVar);
    }

    @Override // e9.c
    public /* synthetic */ void h(c.a aVar, a2 a2Var) {
        e9.b.J(this, aVar, a2Var);
    }

    @Override // e9.c
    public /* synthetic */ void h0(c.a aVar) {
        e9.b.Q(this, aVar);
    }

    @Override // e9.c
    public /* synthetic */ void i(c.a aVar, Metadata metadata) {
        e9.b.K(this, aVar, metadata);
    }

    @Override // e9.c
    public /* synthetic */ void i0(c.a aVar, int i11) {
        e9.b.a0(this, aVar, i11);
    }

    @Override // e9.c
    public /* synthetic */ void j(c.a aVar, Exception exc) {
        e9.b.z(this, aVar, exc);
    }

    @Override // e9.c
    public /* synthetic */ void j0(c.a aVar, String str, long j11, long j12) {
        e9.b.g0(this, aVar, str, j11, j12);
    }

    @Override // e9.c
    public void k(c.a aVar, o2.e eVar, o2.e eVar2, int i11) {
        if (i11 == 1) {
            this.f61905u = true;
        }
        this.f61895k = i11;
    }

    @Override // e9.c
    public /* synthetic */ void k0(c.a aVar, List list) {
        e9.b.n(this, aVar, list);
    }

    @Override // e9.c
    public /* synthetic */ void l(c.a aVar, com.google.android.exoplayer2.r rVar) {
        e9.b.s(this, aVar, rVar);
    }

    @Override // e9.c
    public /* synthetic */ void l0(c.a aVar, boolean z10) {
        e9.b.X(this, aVar, z10);
    }

    @Override // e9.c
    public /* synthetic */ void m(c.a aVar, int i11) {
        e9.b.y(this, aVar, i11);
    }

    @Override // e9.c
    public /* synthetic */ void m0(c.a aVar, long j11) {
        e9.b.i(this, aVar, j11);
    }

    @Override // e9.c
    public /* synthetic */ void n(c.a aVar, String str) {
        e9.b.d(this, aVar, str);
    }

    @Override // e9.c
    public /* synthetic */ void n0(c.a aVar, t9.i iVar) {
        e9.b.d0(this, aVar, iVar);
    }

    @Override // e9.c
    public /* synthetic */ void o(c.a aVar, v1 v1Var, int i11) {
        e9.b.I(this, aVar, v1Var, i11);
    }

    @Override // e9.c
    public /* synthetic */ void o0(c.a aVar, com.google.android.exoplayer2.o1 o1Var) {
        e9.b.k0(this, aVar, o1Var);
    }

    @Override // e9.c
    public /* synthetic */ void p(c.a aVar, t9.h hVar, t9.i iVar) {
        e9.b.F(this, aVar, hVar, iVar);
    }

    @Override // e9.c
    public /* synthetic */ void p0(c.a aVar, TrackSelectionParameters trackSelectionParameters) {
        e9.b.b0(this, aVar, trackSelectionParameters);
    }

    @Override // e9.t1.a
    public void q(c.a aVar, String str, String str2) {
    }

    @Override // e9.c
    public /* synthetic */ void q0(c.a aVar, n2 n2Var) {
        e9.b.M(this, aVar, n2Var);
    }

    @Override // e9.c
    public /* synthetic */ void r(c.a aVar, ba.f fVar) {
        e9.b.m(this, aVar, fVar);
    }

    @Override // e9.c
    public /* synthetic */ void r0(c.a aVar, Exception exc) {
        e9.b.e0(this, aVar, exc);
    }

    @Override // e9.c
    public /* synthetic */ void s(c.a aVar, o2.b bVar) {
        e9.b.l(this, aVar, bVar);
    }

    @Override // e9.c
    public /* synthetic */ void s0(c.a aVar, int i11) {
        e9.b.N(this, aVar, i11);
    }

    @Override // e9.c
    public /* synthetic */ void t(c.a aVar, com.google.android.exoplayer2.decoder.e eVar) {
        e9.b.f(this, aVar, eVar);
    }

    @Override // e9.c
    public /* synthetic */ void t0(c.a aVar) {
        e9.b.A(this, aVar);
    }

    @Override // e9.c
    public void u(c.a aVar, t9.h hVar, t9.i iVar, IOException iOException, boolean z10) {
        this.f61906v = iVar.f76230a;
    }

    @Override // e9.c
    public /* synthetic */ void u0(c.a aVar, int i11, int i12, int i13, float f11) {
        e9.b.m0(this, aVar, i11, i12, i13, f11);
    }

    @Override // e9.c
    public /* synthetic */ void v(c.a aVar, Exception exc) {
        e9.b.a(this, aVar, exc);
    }

    @Override // e9.c
    public void v0(c.a aVar, com.google.android.exoplayer2.video.y yVar) {
        b bVar = this.f61899o;
        if (bVar != null) {
            com.google.android.exoplayer2.o1 o1Var = bVar.f61913a;
            if (o1Var.f25556r == -1) {
                this.f61899o = new b(o1Var.b().j0(yVar.f28063a).Q(yVar.f28064b).E(), bVar.f61914b, bVar.f61915c);
            }
        }
    }

    @Override // e9.c
    public /* synthetic */ void w(c.a aVar, com.google.android.exoplayer2.o1 o1Var) {
        e9.b.g(this, aVar, o1Var);
    }

    @Override // e9.c
    public /* synthetic */ void w0(c.a aVar, Exception exc) {
        e9.b.j(this, aVar, exc);
    }

    @Override // e9.t1.a
    public void x(c.a aVar, String str) {
    }

    @Override // e9.c
    public /* synthetic */ void x0(c.a aVar, int i11, int i12) {
        e9.b.Z(this, aVar, i11, i12);
    }

    @Override // e9.c
    public /* synthetic */ void y(c.a aVar, boolean z10, int i11) {
        e9.b.R(this, aVar, z10, i11);
    }

    @Override // e9.c
    public /* synthetic */ void y0(c.a aVar, t9.h hVar, t9.i iVar) {
        e9.b.E(this, aVar, hVar, iVar);
    }

    @Override // e9.c
    public void z(c.a aVar, t9.i iVar) {
        if (aVar.f61741d == null) {
            return;
        }
        b bVar = new b((com.google.android.exoplayer2.o1) com.google.android.exoplayer2.util.a.e(iVar.f76232c), iVar.f76233d, this.f61886b.f(aVar.f61739b, (o.b) com.google.android.exoplayer2.util.a.e(aVar.f61741d)));
        int i11 = iVar.f76231b;
        if (i11 != 0) {
            if (i11 == 1) {
                this.f61900p = bVar;
                return;
            } else if (i11 != 2) {
                if (i11 != 3) {
                    return;
                }
                this.f61901q = bVar;
                return;
            }
        }
        this.f61899o = bVar;
    }

    @Override // e9.c
    public /* synthetic */ void z0(c.a aVar, PlaybackException playbackException) {
        e9.b.P(this, aVar, playbackException);
    }
}
