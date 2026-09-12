package y1;

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
import androidx.media3.common.DrmInitData;
import androidx.media3.common.ParserException;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.a0;
import androidx.media3.common.e0;
import androidx.media3.common.i0;
import androidx.media3.common.t;
import androidx.media3.datasource.FileDataSource;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.UdpDataSource;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.UnsupportedDrmException;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.source.r;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.r4;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;
import y1.c;
import y1.c4;

/* loaded from: classes2.dex */
public final class b4 implements c, c4.a {
    private int A;
    private boolean B;

    /* renamed from: a, reason: collision with root package name */
    private final Context f78702a;

    /* renamed from: c, reason: collision with root package name */
    private final c4 f78704c;

    /* renamed from: d, reason: collision with root package name */
    private final PlaybackSession f78705d;

    /* renamed from: j, reason: collision with root package name */
    private String f78711j;

    /* renamed from: k, reason: collision with root package name */
    private PlaybackMetrics.Builder f78712k;

    /* renamed from: l, reason: collision with root package name */
    private int f78713l;

    /* renamed from: o, reason: collision with root package name */
    private PlaybackException f78716o;

    /* renamed from: p, reason: collision with root package name */
    private b f78717p;

    /* renamed from: q, reason: collision with root package name */
    private b f78718q;

    /* renamed from: r, reason: collision with root package name */
    private b f78719r;

    /* renamed from: s, reason: collision with root package name */
    private androidx.media3.common.r f78720s;

    /* renamed from: t, reason: collision with root package name */
    private androidx.media3.common.r f78721t;

    /* renamed from: u, reason: collision with root package name */
    private androidx.media3.common.r f78722u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f78723v;

    /* renamed from: w, reason: collision with root package name */
    private int f78724w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f78725x;

    /* renamed from: y, reason: collision with root package name */
    private int f78726y;

    /* renamed from: z, reason: collision with root package name */
    private int f78727z;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f78703b = androidx.media3.common.util.c.a();

    /* renamed from: f, reason: collision with root package name */
    private final e0.c f78707f = new e0.c();

    /* renamed from: g, reason: collision with root package name */
    private final e0.b f78708g = new e0.b();

    /* renamed from: i, reason: collision with root package name */
    private final HashMap f78710i = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private final HashMap f78709h = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final long f78706e = SystemClock.elapsedRealtime();

    /* renamed from: m, reason: collision with root package name */
    private int f78714m = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f78715n = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f78728a;

        /* renamed from: b, reason: collision with root package name */
        public final int f78729b;

        public a(int i11, int i12) {
            this.f78728a = i11;
            this.f78729b = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.media3.common.r f78730a;

        /* renamed from: b, reason: collision with root package name */
        public final int f78731b;

        /* renamed from: c, reason: collision with root package name */
        public final String f78732c;

        public b(androidx.media3.common.r rVar, int i11, String str) {
            this.f78730a = rVar;
            this.f78731b = i11;
            this.f78732c = str;
        }
    }

    private b4(Context context, PlaybackSession playbackSession) {
        this.f78702a = context.getApplicationContext();
        this.f78705d = playbackSession;
        u1 u1Var = new u1();
        this.f78704c = u1Var;
        u1Var.g(this);
    }

    private boolean D0(b bVar) {
        return bVar != null && bVar.f78732c.equals(this.f78704c.a());
    }

    public static b4 E0(Context context) {
        PlaybackSession createPlaybackSession;
        MediaMetricsManager a11 = r3.a(context.getSystemService("media_metrics"));
        if (a11 == null) {
            return null;
        }
        createPlaybackSession = a11.createPlaybackSession();
        return new b4(context, createPlaybackSession);
    }

    private void F0() {
        final PlaybackMetrics build;
        PlaybackMetrics.Builder builder = this.f78712k;
        if (builder != null && this.B) {
            builder.setAudioUnderrunCount(this.A);
            this.f78712k.setVideoFramesDropped(this.f78726y);
            this.f78712k.setVideoFramesPlayed(this.f78727z);
            Long l11 = (Long) this.f78709h.get(this.f78711j);
            this.f78712k.setNetworkTransferDurationMillis(l11 == null ? 0L : l11.longValue());
            Long l12 = (Long) this.f78710i.get(this.f78711j);
            this.f78712k.setNetworkBytesRead(l12 == null ? 0L : l12.longValue());
            this.f78712k.setStreamSource((l12 == null || l12.longValue() <= 0) ? 0 : 1);
            build = this.f78712k.build();
            this.f78703b.execute(new Runnable() { // from class: y1.z3
                @Override // java.lang.Runnable
                public final void run() {
                    b4.this.P0(build);
                }
            });
        }
        this.f78712k = null;
        this.f78711j = null;
        this.A = 0;
        this.f78726y = 0;
        this.f78727z = 0;
        this.f78720s = null;
        this.f78721t = null;
        this.f78722u = null;
        this.B = false;
    }

    private static int G0(int i11) {
        switch (androidx.media3.common.util.a1.b0(i11)) {
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

    private static DrmInitData H0(ImmutableList immutableList) {
        DrmInitData drmInitData;
        r4 it = immutableList.iterator();
        while (it.hasNext()) {
            i0.a aVar = (i0.a) it.next();
            for (int i11 = 0; i11 < aVar.f10173a; i11++) {
                if (aVar.h(i11) && (drmInitData = aVar.b(i11).f10247s) != null) {
                    return drmInitData;
                }
            }
        }
        return null;
    }

    private static int I0(DrmInitData drmInitData) {
        for (int i11 = 0; i11 < drmInitData.schemeDataCount; i11++) {
            UUID uuid = drmInitData.get(i11).uuid;
            if (uuid.equals(androidx.media3.common.h.f10066d)) {
                return 3;
            }
            if (uuid.equals(androidx.media3.common.h.f10067e)) {
                return 2;
            }
            if (uuid.equals(androidx.media3.common.h.f10065c)) {
                return 6;
            }
        }
        return 1;
    }

    private static a J0(PlaybackException playbackException, Context context, boolean z10) {
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
        Throwable th2 = (Throwable) androidx.media3.common.util.a.e(playbackException.getCause());
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
                return new a(13, androidx.media3.common.util.a1.c0(((MediaCodecRenderer.DecoderInitializationException) th2).diagnosticInfo));
            }
            if (th2 instanceof MediaCodecDecoderException) {
                return new a(14, ((MediaCodecDecoderException) th2).errorCode);
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
            if (!(th2 instanceof MediaCodec.CryptoException)) {
                return new a(22, 0);
            }
            int errorCode = ((MediaCodec.CryptoException) th2).getErrorCode();
            return new a(G0(errorCode), errorCode);
        }
        if (th2 instanceof HttpDataSource.InvalidResponseCodeException) {
            return new a(5, ((HttpDataSource.InvalidResponseCodeException) th2).responseCode);
        }
        if ((th2 instanceof HttpDataSource.InvalidContentTypeException) || (th2 instanceof ParserException)) {
            return new a(z10 ? 10 : 11, 0);
        }
        boolean z12 = th2 instanceof HttpDataSource.HttpDataSourceException;
        if (z12 || (th2 instanceof UdpDataSource.UdpDataSourceException)) {
            if (androidx.media3.common.util.z.e(context).g() == 1) {
                return new a(3, 0);
            }
            Throwable cause = th2.getCause();
            return cause instanceof UnknownHostException ? new a(6, 0) : cause instanceof SocketTimeoutException ? new a(7, 0) : (z12 && ((HttpDataSource.HttpDataSourceException) th2).type == 1) ? new a(4, 0) : new a(8, 0);
        }
        if (playbackException.errorCode == 1002) {
            return new a(21, 0);
        }
        if (th2 instanceof DrmSession.DrmSessionException) {
            Throwable th3 = (Throwable) androidx.media3.common.util.a.e(th2.getCause());
            if (!(th3 instanceof MediaDrm.MediaDrmStateException)) {
                return (androidx.media3.common.util.a1.f10432a < 23 || !(th3 instanceof MediaDrmResetException)) ? th3 instanceof NotProvisionedException ? new a(24, 0) : th3 instanceof DeniedByServerException ? new a(29, 0) : th3 instanceof UnsupportedDrmException ? new a(23, 0) : th3 instanceof DefaultDrmSessionManager.MissingSchemeDataException ? new a(28, 0) : new a(30, 0) : new a(27, 0);
            }
            int c02 = androidx.media3.common.util.a1.c0(((MediaDrm.MediaDrmStateException) th3).getDiagnosticInfo());
            return new a(G0(c02), c02);
        }
        if (!(th2 instanceof FileDataSource.FileDataSourceException) || !(th2.getCause() instanceof FileNotFoundException)) {
            return new a(9, 0);
        }
        Throwable cause2 = ((Throwable) androidx.media3.common.util.a.e(th2.getCause())).getCause();
        return ((cause2 instanceof ErrnoException) && ((ErrnoException) cause2).errno == OsConstants.EACCES) ? new a(32, 0) : new a(31, 0);
    }

    private static Pair K0(String str) {
        String[] o12 = androidx.media3.common.util.a1.o1(str, "-");
        return Pair.create(o12[0], o12.length >= 2 ? o12[1] : null);
    }

    private static int M0(Context context) {
        switch (androidx.media3.common.util.z.e(context).g()) {
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

    private static int N0(androidx.media3.common.t tVar) {
        t.h hVar = tVar.f10293b;
        if (hVar == null) {
            return 0;
        }
        int A0 = androidx.media3.common.util.a1.A0(hVar.f10385a, hVar.f10386b);
        if (A0 == 0) {
            return 3;
        }
        if (A0 != 1) {
            return A0 != 2 ? 1 : 4;
        }
        return 5;
    }

    private static int O0(int i11) {
        if (i11 == 1) {
            return 2;
        }
        if (i11 != 2) {
            return i11 != 3 ? 1 : 4;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(PlaybackMetrics playbackMetrics) {
        this.f78705d.reportPlaybackMetrics(playbackMetrics);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(NetworkEvent networkEvent) {
        this.f78705d.reportNetworkEvent(networkEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(PlaybackErrorEvent playbackErrorEvent) {
        this.f78705d.reportPlaybackErrorEvent(playbackErrorEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(PlaybackStateEvent playbackStateEvent) {
        this.f78705d.reportPlaybackStateEvent(playbackStateEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(TrackChangeEvent trackChangeEvent) {
        this.f78705d.reportTrackChangeEvent(trackChangeEvent);
    }

    private void U0(c.b bVar) {
        for (int i11 = 0; i11 < bVar.d(); i11++) {
            int b11 = bVar.b(i11);
            c.a c11 = bVar.c(b11);
            if (b11 == 0) {
                this.f78704c.f(c11);
            } else if (b11 == 11) {
                this.f78704c.d(c11, this.f78713l);
            } else {
                this.f78704c.c(c11);
            }
        }
    }

    private void V0(long j11) {
        NetworkEvent.Builder networkType;
        NetworkEvent.Builder timeSinceCreatedMillis;
        final NetworkEvent build;
        int M0 = M0(this.f78702a);
        if (M0 != this.f78715n) {
            this.f78715n = M0;
            networkType = g2.a().setNetworkType(M0);
            timeSinceCreatedMillis = networkType.setTimeSinceCreatedMillis(j11 - this.f78706e);
            build = timeSinceCreatedMillis.build();
            this.f78703b.execute(new Runnable() { // from class: y1.x3
                @Override // java.lang.Runnable
                public final void run() {
                    b4.this.Q0(build);
                }
            });
        }
    }

    private void W0(long j11) {
        PlaybackErrorEvent.Builder timeSinceCreatedMillis;
        PlaybackErrorEvent.Builder errorCode;
        PlaybackErrorEvent.Builder subErrorCode;
        PlaybackErrorEvent.Builder exception;
        final PlaybackErrorEvent build;
        PlaybackException playbackException = this.f78716o;
        if (playbackException == null) {
            return;
        }
        a J0 = J0(playbackException, this.f78702a, this.f78724w == 4);
        timeSinceCreatedMillis = c3.a().setTimeSinceCreatedMillis(j11 - this.f78706e);
        errorCode = timeSinceCreatedMillis.setErrorCode(J0.f78728a);
        subErrorCode = errorCode.setSubErrorCode(J0.f78729b);
        exception = subErrorCode.setException(playbackException);
        build = exception.build();
        this.f78703b.execute(new Runnable() { // from class: y1.y3
            @Override // java.lang.Runnable
            public final void run() {
                b4.this.R0(build);
            }
        });
        this.B = true;
        this.f78716o = null;
    }

    private void X0(androidx.media3.common.a0 a0Var, c.b bVar, long j11) {
        PlaybackStateEvent.Builder state;
        PlaybackStateEvent.Builder timeSinceCreatedMillis;
        final PlaybackStateEvent build;
        if (a0Var.getPlaybackState() != 2) {
            this.f78723v = false;
        }
        if (a0Var.c() == null) {
            this.f78725x = false;
        } else if (bVar.a(10)) {
            this.f78725x = true;
        }
        int f12 = f1(a0Var);
        if (this.f78714m != f12) {
            this.f78714m = f12;
            this.B = true;
            state = n3.a().setState(this.f78714m);
            timeSinceCreatedMillis = state.setTimeSinceCreatedMillis(j11 - this.f78706e);
            build = timeSinceCreatedMillis.build();
            this.f78703b.execute(new Runnable() { // from class: y1.a4
                @Override // java.lang.Runnable
                public final void run() {
                    b4.this.S0(build);
                }
            });
        }
    }

    private void Y0(androidx.media3.common.a0 a0Var, c.b bVar, long j11) {
        if (bVar.a(2)) {
            androidx.media3.common.i0 currentTracks = a0Var.getCurrentTracks();
            boolean c11 = currentTracks.c(2);
            boolean c12 = currentTracks.c(1);
            boolean c13 = currentTracks.c(3);
            if (c11 || c12 || c13) {
                if (!c11) {
                    d1(j11, null, 0);
                }
                if (!c12) {
                    Z0(j11, null, 0);
                }
                if (!c13) {
                    b1(j11, null, 0);
                }
            }
        }
        if (D0(this.f78717p)) {
            b bVar2 = this.f78717p;
            androidx.media3.common.r rVar = bVar2.f78730a;
            if (rVar.f10251w != -1) {
                d1(j11, rVar, bVar2.f78731b);
                this.f78717p = null;
            }
        }
        if (D0(this.f78718q)) {
            b bVar3 = this.f78718q;
            Z0(j11, bVar3.f78730a, bVar3.f78731b);
            this.f78718q = null;
        }
        if (D0(this.f78719r)) {
            b bVar4 = this.f78719r;
            b1(j11, bVar4.f78730a, bVar4.f78731b);
            this.f78719r = null;
        }
    }

    private void Z0(long j11, androidx.media3.common.r rVar, int i11) {
        if (Objects.equals(this.f78721t, rVar)) {
            return;
        }
        if (this.f78721t == null && i11 == 0) {
            i11 = 1;
        }
        this.f78721t = rVar;
        e1(0, j11, rVar, i11);
    }

    private void a1(androidx.media3.common.a0 a0Var, c.b bVar) {
        DrmInitData H0;
        if (bVar.a(0)) {
            c.a c11 = bVar.c(0);
            if (this.f78712k != null) {
                c1(c11.f78734b, c11.f78736d);
            }
        }
        if (bVar.a(2) && this.f78712k != null && (H0 = H0(a0Var.getCurrentTracks().a())) != null) {
            m2.a(androidx.media3.common.util.a1.i(this.f78712k)).setDrmType(I0(H0));
        }
        if (bVar.a(1011)) {
            this.A++;
        }
    }

    private void b1(long j11, androidx.media3.common.r rVar, int i11) {
        if (Objects.equals(this.f78722u, rVar)) {
            return;
        }
        if (this.f78722u == null && i11 == 0) {
            i11 = 1;
        }
        this.f78722u = rVar;
        e1(2, j11, rVar, i11);
    }

    private void c1(androidx.media3.common.e0 e0Var, r.b bVar) {
        int b11;
        PlaybackMetrics.Builder builder = this.f78712k;
        if (bVar == null || (b11 = e0Var.b(bVar.f12965a)) == -1) {
            return;
        }
        e0Var.f(b11, this.f78708g);
        e0Var.n(this.f78708g.f10018c, this.f78707f);
        builder.setStreamType(N0(this.f78707f.f10035c));
        e0.c cVar = this.f78707f;
        if (cVar.f10045m != C.TIME_UNSET && !cVar.f10043k && !cVar.f10041i && !cVar.f()) {
            builder.setMediaDurationMillis(this.f78707f.d());
        }
        builder.setPlaybackType(this.f78707f.f() ? 2 : 1);
        this.B = true;
    }

    private void d1(long j11, androidx.media3.common.r rVar, int i11) {
        if (Objects.equals(this.f78720s, rVar)) {
            return;
        }
        if (this.f78720s == null && i11 == 0) {
            i11 = 1;
        }
        this.f78720s = rVar;
        e1(1, j11, rVar, i11);
    }

    private void e1(int i11, long j11, androidx.media3.common.r rVar, int i12) {
        TrackChangeEvent.Builder timeSinceCreatedMillis;
        final TrackChangeEvent build;
        timeSinceCreatedMillis = v1.a(i11).setTimeSinceCreatedMillis(j11 - this.f78706e);
        if (rVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(O0(i12));
            String str = rVar.f10242n;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = rVar.f10243o;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = rVar.f10239k;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i13 = rVar.f10238j;
            if (i13 != -1) {
                timeSinceCreatedMillis.setBitrate(i13);
            }
            int i14 = rVar.f10250v;
            if (i14 != -1) {
                timeSinceCreatedMillis.setWidth(i14);
            }
            int i15 = rVar.f10251w;
            if (i15 != -1) {
                timeSinceCreatedMillis.setHeight(i15);
            }
            int i16 = rVar.E;
            if (i16 != -1) {
                timeSinceCreatedMillis.setChannelCount(i16);
            }
            int i17 = rVar.F;
            if (i17 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i17);
            }
            String str4 = rVar.f10232d;
            if (str4 != null) {
                Pair K0 = K0(str4);
                timeSinceCreatedMillis.setLanguage((String) K0.first);
                Object obj = K0.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f11 = rVar.f10252x;
            if (f11 != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f11);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.B = true;
        build = timeSinceCreatedMillis.build();
        this.f78703b.execute(new Runnable() { // from class: y1.w3
            @Override // java.lang.Runnable
            public final void run() {
                b4.this.T0(build);
            }
        });
    }

    private int f1(androidx.media3.common.a0 a0Var) {
        int playbackState = a0Var.getPlaybackState();
        if (this.f78723v) {
            return 5;
        }
        if (this.f78725x) {
            return 13;
        }
        if (playbackState == 4) {
            return 11;
        }
        if (playbackState == 2) {
            int i11 = this.f78714m;
            if (i11 == 0 || i11 == 2 || i11 == 12) {
                return 2;
            }
            if (a0Var.getPlayWhenReady()) {
                return a0Var.j() != 0 ? 10 : 6;
            }
            return 7;
        }
        if (playbackState == 3) {
            if (a0Var.getPlayWhenReady()) {
                return a0Var.j() != 0 ? 9 : 3;
            }
            return 4;
        }
        if (playbackState != 1 || this.f78714m == 0) {
            return this.f78714m;
        }
        return 12;
    }

    @Override // y1.c
    public /* synthetic */ void A(c.a aVar) {
        y1.b.w(this, aVar);
    }

    @Override // y1.c
    public /* synthetic */ void B(c.a aVar) {
        y1.b.X(this, aVar);
    }

    @Override // y1.c4.a
    public void C(c.a aVar, String str) {
    }

    @Override // y1.c
    public /* synthetic */ void D(c.a aVar, PlaybackException playbackException) {
        y1.b.Q(this, aVar, playbackException);
    }

    @Override // y1.c
    public void E(c.a aVar, androidx.media3.exoplayer.j jVar) {
        this.f78726y += jVar.f12119g;
        this.f78727z += jVar.f12117e;
    }

    @Override // y1.c
    public void F(c.a aVar, a0.e eVar, a0.e eVar2, int i11) {
        if (i11 == 1) {
            this.f78723v = true;
        }
        this.f78713l = i11;
    }

    @Override // y1.c
    public /* synthetic */ void G(c.a aVar, Object obj, long j11) {
        y1.b.U(this, aVar, obj, j11);
    }

    @Override // y1.c4.a
    public void H(c.a aVar, String str, String str2) {
    }

    @Override // y1.c
    public /* synthetic */ void I(c.a aVar, g2.i iVar, g2.j jVar) {
        y1.b.G(this, aVar, iVar, jVar);
    }

    @Override // y1.c
    public void J(c.a aVar, int i11, long j11, long j12) {
        r.b bVar = aVar.f78736d;
        if (bVar != null) {
            String b11 = this.f78704c.b(aVar.f78734b, (r.b) androidx.media3.common.util.a.e(bVar));
            Long l11 = (Long) this.f78710i.get(b11);
            Long l12 = (Long) this.f78709h.get(b11);
            this.f78710i.put(b11, Long.valueOf((l11 == null ? 0L : l11.longValue()) + j11));
            this.f78709h.put(b11, Long.valueOf((l12 != null ? l12.longValue() : 0L) + i11));
        }
    }

    @Override // y1.c
    public /* synthetic */ void K(c.a aVar, androidx.media3.exoplayer.j jVar) {
        y1.b.f(this, aVar, jVar);
    }

    @Override // y1.c
    public /* synthetic */ void L(c.a aVar, int i11) {
        y1.b.i(this, aVar, i11);
    }

    public LogSessionId L0() {
        LogSessionId sessionId;
        sessionId = this.f78705d.getSessionId();
        return sessionId;
    }

    @Override // y1.c
    public /* synthetic */ void M(c.a aVar, boolean z10) {
        y1.b.I(this, aVar, z10);
    }

    @Override // y1.c
    public /* synthetic */ void N(c.a aVar, int i11, long j11, long j12) {
        y1.b.m(this, aVar, i11, j11, j12);
    }

    @Override // y1.c
    public /* synthetic */ void O(c.a aVar, boolean z10, int i11) {
        y1.b.M(this, aVar, z10, i11);
    }

    @Override // y1.c
    public /* synthetic */ void P(c.a aVar, androidx.media3.common.z zVar) {
        y1.b.N(this, aVar, zVar);
    }

    @Override // y1.c
    public /* synthetic */ void Q(c.a aVar) {
        y1.b.z(this, aVar);
    }

    @Override // y1.c
    public /* synthetic */ void R(c.a aVar, String str, long j11, long j12) {
        y1.b.c(this, aVar, str, j11, j12);
    }

    @Override // y1.c
    public void S(c.a aVar, androidx.media3.common.m0 m0Var) {
        b bVar = this.f78717p;
        if (bVar != null) {
            androidx.media3.common.r rVar = bVar.f78730a;
            if (rVar.f10251w == -1) {
                this.f78717p = new b(rVar.b().B0(m0Var.f10197a).d0(m0Var.f10198b).N(), bVar.f78731b, bVar.f78732c);
            }
        }
    }

    @Override // y1.c
    public /* synthetic */ void T(c.a aVar, long j11, int i11) {
        y1.b.k0(this, aVar, j11, i11);
    }

    @Override // y1.c
    public /* synthetic */ void U(c.a aVar, int i11) {
        y1.b.x(this, aVar, i11);
    }

    @Override // y1.c
    public /* synthetic */ void V(c.a aVar, int i11) {
        y1.b.P(this, aVar, i11);
    }

    @Override // y1.c
    public /* synthetic */ void W(c.a aVar, String str, long j11) {
        y1.b.b(this, aVar, str, j11);
    }

    @Override // y1.c
    public /* synthetic */ void X(c.a aVar, Exception exc) {
        y1.b.y(this, aVar, exc);
    }

    @Override // y1.c
    public /* synthetic */ void Y(c.a aVar, AudioSink.a aVar2) {
        y1.b.k(this, aVar, aVar2);
    }

    @Override // y1.c
    public /* synthetic */ void Z(c.a aVar, String str) {
        y1.b.i0(this, aVar, str);
    }

    @Override // y1.c
    public /* synthetic */ void a(c.a aVar, androidx.media3.exoplayer.j jVar) {
        y1.b.e(this, aVar, jVar);
    }

    @Override // y1.c
    public /* synthetic */ void a0(c.a aVar, String str) {
        y1.b.d(this, aVar, str);
    }

    @Override // y1.c
    public /* synthetic */ void b(c.a aVar, float f11) {
        y1.b.n0(this, aVar, f11);
    }

    @Override // y1.c
    public /* synthetic */ void b0(c.a aVar, boolean z10, int i11) {
        y1.b.S(this, aVar, z10, i11);
    }

    @Override // y1.c
    public void c(c.a aVar, PlaybackException playbackException) {
        this.f78716o = playbackException;
    }

    @Override // y1.c
    public /* synthetic */ void c0(c.a aVar, a0.b bVar) {
        y1.b.n(this, aVar, bVar);
    }

    @Override // y1.c
    public /* synthetic */ void d(c.a aVar, int i11) {
        y1.b.T(this, aVar, i11);
    }

    @Override // y1.c
    public void d0(androidx.media3.common.a0 a0Var, c.b bVar) {
        if (bVar.d() == 0) {
            return;
        }
        U0(bVar);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        a1(a0Var, bVar);
        W0(elapsedRealtime);
        Y0(a0Var, bVar, elapsedRealtime);
        V0(elapsedRealtime);
        X0(a0Var, bVar, elapsedRealtime);
        if (bVar.a(1028)) {
            this.f78704c.e(bVar.c(1028));
        }
    }

    @Override // y1.c4.a
    public void e(c.a aVar, String str) {
        PlaybackMetrics.Builder playerName;
        PlaybackMetrics.Builder playerVersion;
        r.b bVar = aVar.f78736d;
        if (bVar == null || !bVar.b()) {
            F0();
            this.f78711j = str;
            playerName = r2.a().setPlayerName("AndroidXMedia3");
            playerVersion = playerName.setPlayerVersion("1.7.1");
            this.f78712k = playerVersion;
            c1(aVar.f78734b, aVar.f78736d);
        }
    }

    @Override // y1.c
    public /* synthetic */ void e0(c.a aVar, boolean z10) {
        y1.b.Y(this, aVar, z10);
    }

    @Override // y1.c
    public /* synthetic */ void f(c.a aVar, int i11, int i12, boolean z10) {
        y1.b.V(this, aVar, i11, i12, z10);
    }

    @Override // y1.c
    public /* synthetic */ void f0(c.a aVar, int i11, int i12, int i13, float f11) {
        y1.b.m0(this, aVar, i11, i12, i13, f11);
    }

    @Override // y1.c
    public /* synthetic */ void g(c.a aVar, boolean z10) {
        y1.b.C(this, aVar, z10);
    }

    @Override // y1.c
    public /* synthetic */ void g0(c.a aVar, androidx.media3.common.v vVar) {
        y1.b.K(this, aVar, vVar);
    }

    @Override // y1.c
    public /* synthetic */ void h(c.a aVar, int i11, long j11) {
        y1.b.A(this, aVar, i11, j11);
    }

    @Override // y1.c
    public /* synthetic */ void h0(c.a aVar, Exception exc) {
        y1.b.f0(this, aVar, exc);
    }

    @Override // y1.c
    public /* synthetic */ void i(c.a aVar, u1.b bVar) {
        y1.b.q(this, aVar, bVar);
    }

    @Override // y1.c
    public /* synthetic */ void i0(c.a aVar, androidx.media3.common.r rVar, androidx.media3.exoplayer.k kVar) {
        y1.b.g(this, aVar, rVar, kVar);
    }

    @Override // y1.c
    public void j(c.a aVar, g2.j jVar) {
        if (aVar.f78736d == null) {
            return;
        }
        b bVar = new b((androidx.media3.common.r) androidx.media3.common.util.a.e(jVar.f63340c), jVar.f63341d, this.f78704c.b(aVar.f78734b, (r.b) androidx.media3.common.util.a.e(aVar.f78736d)));
        int i11 = jVar.f63339b;
        if (i11 != 0) {
            if (i11 == 1) {
                this.f78718q = bVar;
                return;
            } else if (i11 != 2) {
                if (i11 != 3) {
                    return;
                }
                this.f78719r = bVar;
                return;
            }
        }
        this.f78717p = bVar;
    }

    @Override // y1.c
    public /* synthetic */ void j0(c.a aVar, long j11) {
        y1.b.h(this, aVar, j11);
    }

    @Override // y1.c
    public /* synthetic */ void k(c.a aVar) {
        y1.b.v(this, aVar);
    }

    @Override // y1.c
    public /* synthetic */ void k0(c.a aVar, g2.i iVar, g2.j jVar, int i11) {
        y1.b.H(this, aVar, iVar, jVar, i11);
    }

    @Override // y1.c4.a
    public void l(c.a aVar, String str, boolean z10) {
        r.b bVar = aVar.f78736d;
        if ((bVar == null || !bVar.b()) && str.equals(this.f78711j)) {
            F0();
        }
        this.f78709h.remove(str);
        this.f78710i.remove(str);
    }

    @Override // y1.c
    public /* synthetic */ void l0(c.a aVar, int i11) {
        y1.b.O(this, aVar, i11);
    }

    @Override // y1.c
    public /* synthetic */ void m(c.a aVar, androidx.media3.common.x xVar) {
        y1.b.L(this, aVar, xVar);
    }

    @Override // y1.c
    public /* synthetic */ void m0(c.a aVar, boolean z10) {
        y1.b.Z(this, aVar, z10);
    }

    @Override // y1.c
    public /* synthetic */ void n(c.a aVar, boolean z10) {
        y1.b.D(this, aVar, z10);
    }

    @Override // y1.c
    public /* synthetic */ void n0(c.a aVar, Exception exc) {
        y1.b.j(this, aVar, exc);
    }

    @Override // y1.c
    public /* synthetic */ void o(c.a aVar, Exception exc) {
        y1.b.a(this, aVar, exc);
    }

    @Override // y1.c
    public /* synthetic */ void o0(c.a aVar, androidx.media3.exoplayer.j jVar) {
        y1.b.j0(this, aVar, jVar);
    }

    @Override // y1.c
    public /* synthetic */ void p(c.a aVar) {
        y1.b.t(this, aVar);
    }

    @Override // y1.c
    public /* synthetic */ void p0(c.a aVar, int i11, int i12) {
        y1.b.a0(this, aVar, i11, i12);
    }

    @Override // y1.c
    public /* synthetic */ void q(c.a aVar, String str, long j11, long j12) {
        y1.b.h0(this, aVar, str, j11, j12);
    }

    @Override // y1.c
    public /* synthetic */ void q0(c.a aVar) {
        y1.b.R(this, aVar);
    }

    @Override // y1.c
    public /* synthetic */ void r(c.a aVar, g2.i iVar, g2.j jVar) {
        y1.b.E(this, aVar, iVar, jVar);
    }

    @Override // y1.c
    public /* synthetic */ void r0(c.a aVar, List list) {
        y1.b.p(this, aVar, list);
    }

    @Override // y1.c
    public /* synthetic */ void s(c.a aVar, AudioSink.a aVar2) {
        y1.b.l(this, aVar, aVar2);
    }

    @Override // y1.c
    public /* synthetic */ void s0(c.a aVar, int i11, boolean z10) {
        y1.b.s(this, aVar, i11, z10);
    }

    @Override // y1.c
    public /* synthetic */ void t(c.a aVar) {
        y1.b.u(this, aVar);
    }

    @Override // y1.c
    public /* synthetic */ void t0(c.a aVar, androidx.media3.common.t tVar, int i11) {
        y1.b.J(this, aVar, tVar, i11);
    }

    @Override // y1.c
    public /* synthetic */ void u(c.a aVar, androidx.media3.common.m mVar) {
        y1.b.r(this, aVar, mVar);
    }

    @Override // y1.c
    public /* synthetic */ void u0(c.a aVar, androidx.media3.common.h0 h0Var) {
        y1.b.c0(this, aVar, h0Var);
    }

    @Override // y1.c
    public void v(c.a aVar, g2.i iVar, g2.j jVar, IOException iOException, boolean z10) {
        this.f78724w = jVar.f63338a;
    }

    @Override // y1.c
    public /* synthetic */ void v0(c.a aVar, g2.j jVar) {
        y1.b.e0(this, aVar, jVar);
    }

    @Override // y1.c
    public /* synthetic */ void w(c.a aVar, String str, long j11) {
        y1.b.g0(this, aVar, str, j11);
    }

    @Override // y1.c
    public /* synthetic */ void w0(c.a aVar, int i11) {
        y1.b.b0(this, aVar, i11);
    }

    @Override // y1.c
    public /* synthetic */ void x(c.a aVar, androidx.media3.common.r rVar, androidx.media3.exoplayer.k kVar) {
        y1.b.l0(this, aVar, rVar, kVar);
    }

    @Override // y1.c
    public /* synthetic */ void x0(c.a aVar, g2.i iVar, g2.j jVar) {
        y1.b.F(this, aVar, iVar, jVar);
    }

    @Override // y1.c
    public /* synthetic */ void y(c.a aVar, androidx.media3.common.i0 i0Var) {
        y1.b.d0(this, aVar, i0Var);
    }

    @Override // y1.c
    public /* synthetic */ void z(c.a aVar, int i11) {
        y1.b.W(this, aVar, i11);
    }
}
