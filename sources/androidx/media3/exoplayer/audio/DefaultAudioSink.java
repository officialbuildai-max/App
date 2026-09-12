package androidx.media3.exoplayer.audio;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioRouting;
import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;
import android.media.PlaybackParams;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.audio.b0;
import androidx.media3.exoplayer.audio.i;
import androidx.media3.exoplayer.audio.x0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.r4;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import y1.f4;

/* loaded from: classes2.dex */
public final class DefaultAudioSink implements AudioSink {

    /* renamed from: l0, reason: collision with root package name */
    public static boolean f11089l0;

    /* renamed from: m0, reason: collision with root package name */
    private static final Object f11090m0 = new Object();

    /* renamed from: n0, reason: collision with root package name */
    private static ScheduledExecutorService f11091n0;

    /* renamed from: o0, reason: collision with root package name */
    private static int f11092o0;
    private k A;
    private androidx.media3.common.c B;
    private j C;
    private j D;
    private androidx.media3.common.z E;
    private boolean F;
    private ByteBuffer G;
    private int H;
    private long I;
    private long J;
    private long K;
    private long L;
    private int M;
    private boolean N;
    private boolean O;
    private long P;
    private float Q;
    private ByteBuffer R;
    private int S;
    private ByteBuffer T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private int Z;

    /* renamed from: a, reason: collision with root package name */
    private final Context f11093a;

    /* renamed from: a0, reason: collision with root package name */
    private androidx.media3.common.f f11094a0;

    /* renamed from: b, reason: collision with root package name */
    private final t1.n f11095b;

    /* renamed from: b0, reason: collision with root package name */
    private androidx.media3.exoplayer.audio.j f11096b0;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f11097c;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f11098c0;

    /* renamed from: d, reason: collision with root package name */
    private final c0 f11099d;

    /* renamed from: d0, reason: collision with root package name */
    private long f11100d0;

    /* renamed from: e, reason: collision with root package name */
    private final f1 f11101e;

    /* renamed from: e0, reason: collision with root package name */
    private long f11102e0;

    /* renamed from: f, reason: collision with root package name */
    private final ImmutableList f11103f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f11104f0;

    /* renamed from: g, reason: collision with root package name */
    private final ImmutableList f11105g;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f11106g0;

    /* renamed from: h, reason: collision with root package name */
    private final b0 f11107h;

    /* renamed from: h0, reason: collision with root package name */
    private Looper f11108h0;

    /* renamed from: i, reason: collision with root package name */
    private final ArrayDeque f11109i;

    /* renamed from: i0, reason: collision with root package name */
    private long f11110i0;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f11111j;

    /* renamed from: j0, reason: collision with root package name */
    private long f11112j0;

    /* renamed from: k, reason: collision with root package name */
    private int f11113k;

    /* renamed from: k0, reason: collision with root package name */
    private Handler f11114k0;

    /* renamed from: l, reason: collision with root package name */
    private n f11115l;

    /* renamed from: m, reason: collision with root package name */
    private final l f11116m;

    /* renamed from: n, reason: collision with root package name */
    private final l f11117n;

    /* renamed from: o, reason: collision with root package name */
    private final e f11118o;

    /* renamed from: p, reason: collision with root package name */
    private final d f11119p;

    /* renamed from: q, reason: collision with root package name */
    private final ExoPlayer.a f11120q;

    /* renamed from: r, reason: collision with root package name */
    private final f f11121r;

    /* renamed from: s, reason: collision with root package name */
    private f4 f11122s;

    /* renamed from: t, reason: collision with root package name */
    private AudioSink.b f11123t;

    /* renamed from: u, reason: collision with root package name */
    private h f11124u;

    /* renamed from: v, reason: collision with root package name */
    private h f11125v;

    /* renamed from: w, reason: collision with root package name */
    private androidx.media3.common.audio.a f11126w;

    /* renamed from: x, reason: collision with root package name */
    private AudioTrack f11127x;

    /* renamed from: y, reason: collision with root package name */
    private androidx.media3.exoplayer.audio.e f11128y;

    /* renamed from: z, reason: collision with root package name */
    private androidx.media3.exoplayer.audio.i f11129z;

    /* loaded from: classes2.dex */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        private InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {
        public static long a(AudioTrack audioTrack, h hVar) {
            return hVar.f11144c == 0 ? hVar.d(audioTrack.getBufferSizeInFrames()) : androidx.media3.common.util.a1.g1(audioTrack.getBufferSizeInFrames(), 1000000L, x0.d(hVar.f11148g), RoundingMode.DOWN);
        }

        public static void b(AudioTrack audioTrack, androidx.media3.exoplayer.audio.j jVar) {
            audioTrack.setPreferredDevice(jVar == null ? null : jVar.f11278a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c {
        public static void a(AudioTrack audioTrack, f4 f4Var) {
            LogSessionId logSessionId;
            boolean equals;
            LogSessionId a11 = f4Var.a();
            logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
            equals = a11.equals(logSessionId);
            if (equals) {
                return;
            }
            audioTrack.setLogSessionId(a11);
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        androidx.media3.exoplayer.audio.k a(androidx.media3.common.r rVar, androidx.media3.common.c cVar);
    }

    /* loaded from: classes2.dex */
    public interface e {

        /* renamed from: a, reason: collision with root package name */
        public static final e f11130a = new x0.a().h();

        int a(int i11, int i12, int i13, int i14, int i15, int i16, double d11);
    }

    /* loaded from: classes2.dex */
    public interface f {

        /* renamed from: a, reason: collision with root package name */
        public static final f f11131a = new z0();

        AudioTrack a(AudioSink.a aVar, androidx.media3.common.c cVar, int i11);
    }

    /* loaded from: classes2.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        private final Context f11132a;

        /* renamed from: b, reason: collision with root package name */
        private androidx.media3.exoplayer.audio.e f11133b;

        /* renamed from: c, reason: collision with root package name */
        private t1.n f11134c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f11135d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f11136e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f11137f;

        /* renamed from: g, reason: collision with root package name */
        private e f11138g;

        /* renamed from: h, reason: collision with root package name */
        private f f11139h;

        /* renamed from: i, reason: collision with root package name */
        private d f11140i;

        /* renamed from: j, reason: collision with root package name */
        private ExoPlayer.a f11141j;

        @Deprecated
        public g() {
            this.f11132a = null;
            this.f11133b = androidx.media3.exoplayer.audio.e.f11244c;
            this.f11138g = e.f11130a;
            this.f11139h = f.f11131a;
        }

        public g(Context context) {
            this.f11132a = context;
            this.f11133b = androidx.media3.exoplayer.audio.e.f11244c;
            this.f11138g = e.f11130a;
            this.f11139h = f.f11131a;
        }

        public DefaultAudioSink j() {
            androidx.media3.common.util.a.g(!this.f11137f);
            this.f11137f = true;
            if (this.f11134c == null) {
                this.f11134c = new i(new AudioProcessor[0]);
            }
            if (this.f11140i == null) {
                this.f11140i = new f0(this.f11132a);
            }
            return new DefaultAudioSink(this);
        }

        public g k(androidx.media3.exoplayer.audio.e eVar) {
            androidx.media3.common.util.a.e(eVar);
            this.f11133b = eVar;
            return this;
        }

        public g l(t1.n nVar) {
            androidx.media3.common.util.a.e(nVar);
            this.f11134c = nVar;
            return this;
        }

        public g m(AudioProcessor[] audioProcessorArr) {
            androidx.media3.common.util.a.e(audioProcessorArr);
            return l(new i(audioProcessorArr));
        }

        public g n(boolean z10) {
            this.f11136e = z10;
            return this;
        }

        public g o(boolean z10) {
            this.f11135d = z10;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.media3.common.r f11142a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11143b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11144c;

        /* renamed from: d, reason: collision with root package name */
        public final int f11145d;

        /* renamed from: e, reason: collision with root package name */
        public final int f11146e;

        /* renamed from: f, reason: collision with root package name */
        public final int f11147f;

        /* renamed from: g, reason: collision with root package name */
        public final int f11148g;

        /* renamed from: h, reason: collision with root package name */
        public final int f11149h;

        /* renamed from: i, reason: collision with root package name */
        public final androidx.media3.common.audio.a f11150i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f11151j;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f11152k;

        /* renamed from: l, reason: collision with root package name */
        public final boolean f11153l;

        public h(androidx.media3.common.r rVar, int i11, int i12, int i13, int i14, int i15, int i16, int i17, androidx.media3.common.audio.a aVar, boolean z10, boolean z11, boolean z12) {
            this.f11142a = rVar;
            this.f11143b = i11;
            this.f11144c = i12;
            this.f11145d = i13;
            this.f11146e = i14;
            this.f11147f = i15;
            this.f11148g = i16;
            this.f11149h = i17;
            this.f11150i = aVar;
            this.f11151j = z10;
            this.f11152k = z11;
            this.f11153l = z12;
        }

        public AudioSink.a a() {
            return new AudioSink.a(this.f11148g, this.f11146e, this.f11147f, this.f11153l, this.f11144c == 1, this.f11149h);
        }

        public boolean b(h hVar) {
            return hVar.f11144c == this.f11144c && hVar.f11148g == this.f11148g && hVar.f11146e == this.f11146e && hVar.f11147f == this.f11147f && hVar.f11145d == this.f11145d && hVar.f11151j == this.f11151j && hVar.f11152k == this.f11152k;
        }

        public h c(int i11) {
            return new h(this.f11142a, this.f11143b, this.f11144c, this.f11145d, this.f11146e, this.f11147f, this.f11148g, i11, this.f11150i, this.f11151j, this.f11152k, this.f11153l);
        }

        public long d(long j11) {
            return androidx.media3.common.util.a1.d1(j11, this.f11146e);
        }

        public long e(long j11) {
            return androidx.media3.common.util.a1.d1(j11, this.f11142a.F);
        }

        public boolean f() {
            return this.f11144c == 1;
        }
    }

    /* loaded from: classes2.dex */
    public static class i implements t1.n {

        /* renamed from: a, reason: collision with root package name */
        private final AudioProcessor[] f11154a;

        /* renamed from: b, reason: collision with root package name */
        private final d1 f11155b;

        /* renamed from: c, reason: collision with root package name */
        private final androidx.media3.common.audio.d f11156c;

        public i(AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new d1(), new androidx.media3.common.audio.d());
        }

        public i(AudioProcessor[] audioProcessorArr, d1 d1Var, androidx.media3.common.audio.d dVar) {
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 2];
            this.f11154a = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.f11155b = d1Var;
            this.f11156c = dVar;
            audioProcessorArr2[audioProcessorArr.length] = d1Var;
            audioProcessorArr2[audioProcessorArr.length + 1] = dVar;
        }

        @Override // t1.n
        public boolean a(boolean z10) {
            this.f11155b.y(z10);
            return z10;
        }

        @Override // t1.n
        public androidx.media3.common.z b(androidx.media3.common.z zVar) {
            this.f11156c.e(zVar.f10648a);
            this.f11156c.d(zVar.f10649b);
            return zVar;
        }

        @Override // t1.n
        public AudioProcessor[] getAudioProcessors() {
            return this.f11154a;
        }

        @Override // t1.n
        public long getMediaDuration(long j11) {
            return this.f11156c.isActive() ? this.f11156c.c(j11) : j11;
        }

        @Override // t1.n
        public long getSkippedOutputFrameCount() {
            return this.f11155b.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class j {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.media3.common.z f11157a;

        /* renamed from: b, reason: collision with root package name */
        public final long f11158b;

        /* renamed from: c, reason: collision with root package name */
        public final long f11159c;

        /* renamed from: d, reason: collision with root package name */
        public long f11160d;

        private j(androidx.media3.common.z zVar, long j11, long j12) {
            this.f11157a = zVar;
            this.f11158b = j11;
            this.f11159c = j12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class k {

        /* renamed from: a, reason: collision with root package name */
        private final AudioTrack f11161a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.media3.exoplayer.audio.i f11162b;

        /* renamed from: c, reason: collision with root package name */
        private AudioRouting.OnRoutingChangedListener f11163c = new AudioRouting.OnRoutingChangedListener() { // from class: androidx.media3.exoplayer.audio.t0
            @Override // android.media.AudioRouting.OnRoutingChangedListener
            public final void onRoutingChanged(AudioRouting audioRouting) {
                DefaultAudioSink.k.this.b(audioRouting);
            }
        };

        public k(AudioTrack audioTrack, androidx.media3.exoplayer.audio.i iVar) {
            this.f11161a = audioTrack;
            this.f11162b = iVar;
            audioTrack.addOnRoutingChangedListener(this.f11163c, new Handler(Looper.myLooper()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x0005, code lost:
        
            r2 = r2.getRoutedDevice();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b(android.media.AudioRouting r2) {
            /*
                r1 = this;
                android.media.AudioRouting$OnRoutingChangedListener r0 = r1.f11163c
                if (r0 != 0) goto L5
                return
            L5:
                android.media.AudioDeviceInfo r2 = androidx.media3.exoplayer.audio.s0.a(r2)
                if (r2 == 0) goto L10
                androidx.media3.exoplayer.audio.i r0 = r1.f11162b
                r0.i(r2)
            L10:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.DefaultAudioSink.k.b(android.media.AudioRouting):void");
        }

        public void c() {
            this.f11161a.removeOnRoutingChangedListener(q0.a(androidx.media3.common.util.a.e(this.f11163c)));
            this.f11163c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class l {

        /* renamed from: a, reason: collision with root package name */
        private Exception f11164a;

        /* renamed from: b, reason: collision with root package name */
        private long f11165b = C.TIME_UNSET;

        /* renamed from: c, reason: collision with root package name */
        private long f11166c = C.TIME_UNSET;

        public void a() {
            this.f11164a = null;
            this.f11165b = C.TIME_UNSET;
            this.f11166c = C.TIME_UNSET;
        }

        public boolean b() {
            if (this.f11164a == null) {
                return false;
            }
            return DefaultAudioSink.C() || SystemClock.elapsedRealtime() < this.f11166c;
        }

        public void c(Exception exc) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f11164a == null) {
                this.f11164a = exc;
            }
            if (this.f11165b == C.TIME_UNSET && !DefaultAudioSink.C()) {
                this.f11165b = 200 + elapsedRealtime;
            }
            long j11 = this.f11165b;
            if (j11 == C.TIME_UNSET || elapsedRealtime < j11) {
                this.f11166c = elapsedRealtime + 50;
                return;
            }
            Exception exc2 = this.f11164a;
            if (exc2 != exc) {
                exc2.addSuppressed(exc);
            }
            Exception exc3 = this.f11164a;
            a();
            throw exc3;
        }
    }

    /* loaded from: classes2.dex */
    private final class m implements b0.a {
        private m() {
        }

        @Override // androidx.media3.exoplayer.audio.b0.a
        public void b(long j11) {
            if (DefaultAudioSink.this.f11123t != null) {
                DefaultAudioSink.this.f11123t.b(j11);
            }
        }

        @Override // androidx.media3.exoplayer.audio.b0.a
        public void onInvalidLatency(long j11) {
            androidx.media3.common.util.u.h("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j11);
        }

        @Override // androidx.media3.exoplayer.audio.b0.a
        public void onPositionFramesMismatch(long j11, long j12, long j13, long j14) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j11 + ", " + j12 + ", " + j13 + ", " + j14 + ", " + DefaultAudioSink.this.N() + ", " + DefaultAudioSink.this.O();
            if (DefaultAudioSink.f11089l0) {
                throw new InvalidAudioTrackTimestampException(str);
            }
            androidx.media3.common.util.u.h("DefaultAudioSink", str);
        }

        @Override // androidx.media3.exoplayer.audio.b0.a
        public void onSystemTimeUsMismatch(long j11, long j12, long j13, long j14) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j11 + ", " + j12 + ", " + j13 + ", " + j14 + ", " + DefaultAudioSink.this.N() + ", " + DefaultAudioSink.this.O();
            if (DefaultAudioSink.f11089l0) {
                throw new InvalidAudioTrackTimestampException(str);
            }
            androidx.media3.common.util.u.h("DefaultAudioSink", str);
        }

        @Override // androidx.media3.exoplayer.audio.b0.a
        public void onUnderrun(int i11, long j11) {
            if (DefaultAudioSink.this.f11123t != null) {
                DefaultAudioSink.this.f11123t.onUnderrun(i11, j11, SystemClock.elapsedRealtime() - DefaultAudioSink.this.f11102e0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class n {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f11168a = new Handler(Looper.myLooper());

        /* renamed from: b, reason: collision with root package name */
        private final AudioTrack$StreamEventCallback f11169b;

        /* loaded from: classes2.dex */
        class a extends AudioTrack$StreamEventCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ DefaultAudioSink f11171a;

            a(DefaultAudioSink defaultAudioSink) {
                this.f11171a = defaultAudioSink;
            }

            public void onDataRequest(AudioTrack audioTrack, int i11) {
                if (audioTrack.equals(DefaultAudioSink.this.f11127x) && DefaultAudioSink.this.f11123t != null && DefaultAudioSink.this.X) {
                    DefaultAudioSink.this.f11123t.d();
                }
            }

            public void onPresentationEnded(AudioTrack audioTrack) {
                if (audioTrack.equals(DefaultAudioSink.this.f11127x)) {
                    DefaultAudioSink.this.W = true;
                }
            }

            public void onTearDown(AudioTrack audioTrack) {
                if (audioTrack.equals(DefaultAudioSink.this.f11127x) && DefaultAudioSink.this.f11123t != null && DefaultAudioSink.this.X) {
                    DefaultAudioSink.this.f11123t.d();
                }
            }
        }

        public n() {
            this.f11169b = new a(DefaultAudioSink.this);
        }

        public void a(AudioTrack audioTrack) {
            Handler handler = this.f11168a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new w0(handler), this.f11169b);
        }

        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.f11169b);
            this.f11168a.removeCallbacksAndMessages(null);
        }
    }

    private DefaultAudioSink(g gVar) {
        Context context = gVar.f11132a;
        this.f11093a = context;
        this.B = androidx.media3.common.c.f9989g;
        this.f11128y = context != null ? null : gVar.f11133b;
        this.f11095b = gVar.f11134c;
        this.f11097c = gVar.f11135d;
        this.f11111j = androidx.media3.common.util.a1.f10432a >= 23 && gVar.f11136e;
        this.f11113k = 0;
        this.f11118o = gVar.f11138g;
        this.f11119p = (d) androidx.media3.common.util.a.e(gVar.f11140i);
        this.f11107h = new b0(new m());
        c0 c0Var = new c0();
        this.f11099d = c0Var;
        f1 f1Var = new f1();
        this.f11101e = f1Var;
        this.f11103f = ImmutableList.of((f1) new androidx.media3.common.audio.e(), (f1) c0Var, f1Var);
        this.f11105g = ImmutableList.of((f1) new e1(), (f1) c0Var, f1Var);
        this.Q = 1.0f;
        this.Z = 0;
        this.f11094a0 = new androidx.media3.common.f(0, 0.0f);
        androidx.media3.common.z zVar = androidx.media3.common.z.f10645d;
        this.D = new j(zVar, 0L, 0L);
        this.E = zVar;
        this.F = false;
        this.f11109i = new ArrayDeque();
        this.f11116m = new l();
        this.f11117n = new l();
        this.f11120q = gVar.f11141j;
        this.f11121r = gVar.f11139h;
    }

    static /* synthetic */ boolean C() {
        return Q();
    }

    private void D(long j11) {
        androidx.media3.common.z zVar;
        if (o0()) {
            zVar = androidx.media3.common.z.f10645d;
        } else {
            zVar = m0() ? this.f11095b.b(this.E) : androidx.media3.common.z.f10645d;
            this.E = zVar;
        }
        androidx.media3.common.z zVar2 = zVar;
        this.F = m0() ? this.f11095b.a(this.F) : false;
        this.f11109i.add(new j(zVar2, Math.max(0L, j11), this.f11125v.d(O())));
        l0();
        AudioSink.b bVar = this.f11123t;
        if (bVar != null) {
            bVar.onSkipSilenceEnabledChanged(this.F);
        }
    }

    private long E(long j11) {
        while (!this.f11109i.isEmpty() && j11 >= ((j) this.f11109i.getFirst()).f11159c) {
            this.D = (j) this.f11109i.remove();
        }
        j jVar = this.D;
        long j12 = j11 - jVar.f11159c;
        long g02 = androidx.media3.common.util.a1.g0(j12, jVar.f11157a.f10648a);
        if (!this.f11109i.isEmpty()) {
            j jVar2 = this.D;
            return jVar2.f11158b + g02 + jVar2.f11160d;
        }
        long mediaDuration = this.f11095b.getMediaDuration(j12);
        j jVar3 = this.D;
        long j13 = jVar3.f11158b + mediaDuration;
        jVar3.f11160d = mediaDuration - g02;
        return j13;
    }

    private long F(long j11) {
        long skippedOutputFrameCount = this.f11095b.getSkippedOutputFrameCount();
        long d11 = j11 + this.f11125v.d(skippedOutputFrameCount);
        long j12 = this.f11110i0;
        if (skippedOutputFrameCount > j12) {
            long d12 = this.f11125v.d(skippedOutputFrameCount - j12);
            this.f11110i0 = skippedOutputFrameCount;
            P(d12);
        }
        return d11;
    }

    private AudioTrack G(AudioSink.a aVar, androidx.media3.common.c cVar, int i11, androidx.media3.common.r rVar) {
        try {
            AudioTrack a11 = this.f11121r.a(aVar, cVar, i11);
            int state = a11.getState();
            if (state == 1) {
                return a11;
            }
            try {
                a11.release();
            } catch (Exception unused) {
            }
            throw new AudioSink.InitializationException(state, aVar.f11084b, aVar.f11085c, aVar.f11083a, rVar, aVar.f11087e, null);
        } catch (IllegalArgumentException | UnsupportedOperationException e11) {
            throw new AudioSink.InitializationException(0, aVar.f11084b, aVar.f11085c, aVar.f11083a, rVar, aVar.f11087e, e11);
        }
    }

    private AudioTrack H(h hVar) {
        try {
            AudioTrack G = G(hVar.a(), this.B, this.Z, hVar.f11142a);
            ExoPlayer.a aVar = this.f11120q;
            if (aVar != null) {
                aVar.w(U(G));
            }
            return G;
        } catch (AudioSink.InitializationException e11) {
            AudioSink.b bVar = this.f11123t;
            if (bVar != null) {
                bVar.a(e11);
            }
            throw e11;
        }
    }

    private AudioTrack I() {
        try {
            return H((h) androidx.media3.common.util.a.e(this.f11125v));
        } catch (AudioSink.InitializationException e11) {
            h hVar = this.f11125v;
            if (hVar.f11149h > 1000000) {
                h c11 = hVar.c(1000000);
                try {
                    AudioTrack H = H(c11);
                    this.f11125v = c11;
                    return H;
                } catch (AudioSink.InitializationException e12) {
                    e11.addSuppressed(e12);
                    X();
                    throw e11;
                }
            }
            X();
            throw e11;
        }
    }

    private void J(long j11) {
        int p02;
        AudioSink.b bVar;
        if (this.T == null || this.f11117n.b()) {
            return;
        }
        int remaining = this.T.remaining();
        if (this.f11098c0) {
            androidx.media3.common.util.a.g(j11 != C.TIME_UNSET);
            if (j11 == Long.MIN_VALUE) {
                j11 = this.f11100d0;
            } else {
                this.f11100d0 = j11;
            }
            p02 = q0(this.f11127x, this.T, remaining, j11);
        } else {
            p02 = p0(this.f11127x, this.T, remaining);
        }
        this.f11102e0 = SystemClock.elapsedRealtime();
        if (p02 < 0) {
            if (S(p02)) {
                if (O() <= 0) {
                    if (U(this.f11127x)) {
                        X();
                    }
                }
                r7 = true;
            }
            AudioSink.WriteException writeException = new AudioSink.WriteException(p02, this.f11125v.f11142a, r7);
            AudioSink.b bVar2 = this.f11123t;
            if (bVar2 != null) {
                bVar2.a(writeException);
            }
            if (!writeException.isRecoverable || this.f11093a == null) {
                this.f11117n.c(writeException);
                return;
            } else {
                this.f11128y = androidx.media3.exoplayer.audio.e.f11244c;
                throw writeException;
            }
        }
        this.f11117n.a();
        if (U(this.f11127x)) {
            if (this.L > 0) {
                this.f11106g0 = false;
            }
            if (this.X && (bVar = this.f11123t) != null && p02 < remaining && !this.f11106g0) {
                bVar.c();
            }
        }
        int i11 = this.f11125v.f11144c;
        if (i11 == 0) {
            this.K += p02;
        }
        if (p02 == remaining) {
            if (i11 != 0) {
                androidx.media3.common.util.a.g(this.T == this.R);
                this.L += this.M * this.S;
            }
            this.T = null;
        }
    }

    private boolean K() {
        if (!this.f11126w.f()) {
            J(Long.MIN_VALUE);
            return this.T == null;
        }
        this.f11126w.h();
        d0(Long.MIN_VALUE);
        if (!this.f11126w.e()) {
            return false;
        }
        ByteBuffer byteBuffer = this.T;
        return byteBuffer == null || !byteBuffer.hasRemaining();
    }

    private static int L(int i11, int i12, int i13) {
        int minBufferSize = AudioTrack.getMinBufferSize(i11, i12, i13);
        androidx.media3.common.util.a.g(minBufferSize != -2);
        return minBufferSize;
    }

    private static int M(int i11, ByteBuffer byteBuffer) {
        if (i11 == 20) {
            return l2.k0.h(byteBuffer);
        }
        if (i11 != 30) {
            switch (i11) {
                case 5:
                case 6:
                    break;
                case 7:
                case 8:
                    break;
                case 9:
                    int m11 = l2.i0.m(androidx.media3.common.util.a1.P(byteBuffer, byteBuffer.position()));
                    if (m11 != -1) {
                        return m11;
                    }
                    throw new IllegalArgumentException();
                case 10:
                    return 1024;
                case 11:
                case 12:
                    return 2048;
                default:
                    switch (i11) {
                        case 14:
                            int b11 = l2.b.b(byteBuffer);
                            if (b11 == -1) {
                                return 0;
                            }
                            return l2.b.i(byteBuffer, b11) * 16;
                        case 15:
                            return 512;
                        case 16:
                            return 1024;
                        case 17:
                            return l2.c.e(byteBuffer);
                        case 18:
                            break;
                        default:
                            throw new IllegalStateException("Unexpected audio encoding: " + i11);
                    }
            }
            return l2.b.e(byteBuffer);
        }
        return l2.p.f(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long N() {
        return this.f11125v.f11144c == 0 ? this.I / r0.f11143b : this.J;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long O() {
        return this.f11125v.f11144c == 0 ? androidx.media3.common.util.a1.l(this.K, r0.f11145d) : this.L;
    }

    private void P(long j11) {
        this.f11112j0 += j11;
        if (this.f11114k0 == null) {
            this.f11114k0 = new Handler(Looper.myLooper());
        }
        this.f11114k0.removeCallbacksAndMessages(null);
        this.f11114k0.postDelayed(new Runnable() { // from class: androidx.media3.exoplayer.audio.m0
            @Override // java.lang.Runnable
            public final void run() {
                DefaultAudioSink.this.Z();
            }
        }, 100L);
    }

    private static boolean Q() {
        boolean z10;
        synchronized (f11090m0) {
            z10 = f11092o0 > 0;
        }
        return z10;
    }

    private boolean R() {
        androidx.media3.exoplayer.audio.i iVar;
        f4 f4Var;
        if (this.f11116m.b()) {
            return false;
        }
        AudioTrack I = I();
        this.f11127x = I;
        if (U(I)) {
            e0(this.f11127x);
            h hVar = this.f11125v;
            if (hVar.f11152k) {
                AudioTrack audioTrack = this.f11127x;
                androidx.media3.common.r rVar = hVar.f11142a;
                audioTrack.setOffloadDelayPadding(rVar.H, rVar.I);
            }
        }
        int i11 = androidx.media3.common.util.a1.f10432a;
        if (i11 >= 31 && (f4Var = this.f11122s) != null) {
            c.a(this.f11127x, f4Var);
        }
        this.Z = this.f11127x.getAudioSessionId();
        b0 b0Var = this.f11107h;
        AudioTrack audioTrack2 = this.f11127x;
        h hVar2 = this.f11125v;
        b0Var.s(audioTrack2, hVar2.f11144c == 2, hVar2.f11148g, hVar2.f11145d, hVar2.f11149h);
        k0();
        int i12 = this.f11094a0.f10049a;
        if (i12 != 0) {
            this.f11127x.attachAuxEffect(i12);
            this.f11127x.setAuxEffectSendLevel(this.f11094a0.f10050b);
        }
        androidx.media3.exoplayer.audio.j jVar = this.f11096b0;
        if (jVar != null && i11 >= 23) {
            b.b(this.f11127x, jVar);
            androidx.media3.exoplayer.audio.i iVar2 = this.f11129z;
            if (iVar2 != null) {
                iVar2.i(this.f11096b0.f11278a);
            }
        }
        if (i11 >= 24 && (iVar = this.f11129z) != null) {
            this.A = new k(this.f11127x, iVar);
        }
        this.O = true;
        AudioSink.b bVar = this.f11123t;
        if (bVar != null) {
            bVar.j(this.f11125v.a());
        }
        return true;
    }

    private static boolean S(int i11) {
        return (androidx.media3.common.util.a1.f10432a >= 24 && i11 == -6) || i11 == -32;
    }

    private boolean T() {
        return this.f11127x != null;
    }

    private static boolean U(AudioTrack audioTrack) {
        boolean isOffloadedPlayback;
        if (androidx.media3.common.util.a1.f10432a >= 29) {
            isOffloadedPlayback = audioTrack.isOffloadedPlayback();
            if (isOffloadedPlayback) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W(AudioTrack audioTrack, final AudioSink.b bVar, Handler handler, final AudioSink.a aVar) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (bVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.n0
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioSink.b.this.k(aVar);
                    }
                });
            }
            synchronized (f11090m0) {
                try {
                    int i11 = f11092o0 - 1;
                    f11092o0 = i11;
                    if (i11 == 0) {
                        f11091n0.shutdown();
                        f11091n0 = null;
                    }
                } finally {
                }
            }
        } catch (Throwable th2) {
            if (bVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.n0
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioSink.b.this.k(aVar);
                    }
                });
            }
            synchronized (f11090m0) {
                try {
                    int i12 = f11092o0 - 1;
                    f11092o0 = i12;
                    if (i12 == 0) {
                        f11091n0.shutdown();
                        f11091n0 = null;
                    }
                    throw th2;
                } finally {
                }
            }
        }
    }

    private void X() {
        if (this.f11125v.f()) {
            this.f11104f0 = true;
        }
    }

    private ByteBuffer Y(ByteBuffer byteBuffer) {
        if (this.f11125v.f11144c != 0) {
            return byteBuffer;
        }
        int F = (int) androidx.media3.common.util.a1.F(androidx.media3.common.util.a1.R0(20L), this.f11125v.f11146e);
        long O = O();
        if (O >= F) {
            return byteBuffer;
        }
        h hVar = this.f11125v;
        return c1.a(byteBuffer, hVar.f11148g, hVar.f11145d, (int) O, F);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        if (this.f11112j0 >= 300000) {
            this.f11123t.e();
            this.f11112j0 = 0L;
        }
    }

    private void a0() {
        if (this.f11129z == null && this.f11093a != null) {
            this.f11108h0 = Looper.myLooper();
            androidx.media3.exoplayer.audio.i iVar = new androidx.media3.exoplayer.audio.i(this.f11093a, new i.f() { // from class: androidx.media3.exoplayer.audio.l0
                @Override // androidx.media3.exoplayer.audio.i.f
                public final void a(e eVar) {
                    DefaultAudioSink.this.b0(eVar);
                }
            }, this.B, this.f11096b0);
            this.f11129z = iVar;
            this.f11128y = iVar.g();
        }
        androidx.media3.common.util.a.e(this.f11128y);
    }

    private void c0() {
        if (this.V) {
            return;
        }
        this.V = true;
        this.f11107h.g(O());
        if (U(this.f11127x)) {
            this.W = false;
        }
        this.f11127x.stop();
        this.H = 0;
    }

    private void d0(long j11) {
        J(j11);
        if (this.T != null) {
            return;
        }
        if (!this.f11126w.f()) {
            ByteBuffer byteBuffer = this.R;
            if (byteBuffer != null) {
                j0(byteBuffer);
                J(j11);
                return;
            }
            return;
        }
        while (!this.f11126w.e()) {
            do {
                ByteBuffer d11 = this.f11126w.d();
                if (d11.hasRemaining()) {
                    j0(d11);
                    J(j11);
                } else {
                    ByteBuffer byteBuffer2 = this.R;
                    if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
                        return;
                    } else {
                        this.f11126w.i(this.R);
                    }
                }
            } while (this.T == null);
            return;
        }
    }

    private void e0(AudioTrack audioTrack) {
        if (this.f11115l == null) {
            this.f11115l = new n();
        }
        this.f11115l.a(audioTrack);
    }

    private static void f0(final AudioTrack audioTrack, final AudioSink.b bVar, final AudioSink.a aVar) {
        final Handler handler = new Handler(Looper.myLooper());
        synchronized (f11090m0) {
            try {
                if (f11091n0 == null) {
                    f11091n0 = androidx.media3.common.util.a1.T0("ExoPlayer:AudioTrackReleaseThread");
                }
                f11092o0++;
                f11091n0.schedule(new Runnable() { // from class: androidx.media3.exoplayer.audio.k0
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultAudioSink.W(audioTrack, bVar, handler, aVar);
                    }
                }, 20L, TimeUnit.MILLISECONDS);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void g0() {
        this.I = 0L;
        this.J = 0L;
        this.K = 0L;
        this.L = 0L;
        this.f11106g0 = false;
        this.M = 0;
        this.D = new j(this.E, 0L, 0L);
        this.P = 0L;
        this.C = null;
        this.f11109i.clear();
        this.R = null;
        this.S = 0;
        this.T = null;
        this.V = false;
        this.U = false;
        this.W = false;
        this.G = null;
        this.H = 0;
        this.f11101e.i();
        l0();
    }

    private void h0(androidx.media3.common.z zVar) {
        j jVar = new j(zVar, C.TIME_UNSET, C.TIME_UNSET);
        if (T()) {
            this.C = jVar;
        } else {
            this.D = jVar;
        }
    }

    private void i0() {
        if (T()) {
            try {
                this.f11127x.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(this.E.f10648a).setPitch(this.E.f10649b).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e11) {
                androidx.media3.common.util.u.i("DefaultAudioSink", "Failed to set playback params", e11);
            }
            androidx.media3.common.z zVar = new androidx.media3.common.z(this.f11127x.getPlaybackParams().getSpeed(), this.f11127x.getPlaybackParams().getPitch());
            this.E = zVar;
            this.f11107h.t(zVar.f10648a);
        }
    }

    private void j0(ByteBuffer byteBuffer) {
        androidx.media3.common.util.a.g(this.T == null);
        if (byteBuffer.hasRemaining()) {
            this.T = Y(byteBuffer);
        }
    }

    private void k0() {
        if (T()) {
            this.f11127x.setVolume(this.Q);
        }
    }

    private void l0() {
        androidx.media3.common.audio.a aVar = this.f11125v.f11150i;
        this.f11126w = aVar;
        aVar.b();
    }

    private boolean m0() {
        if (!this.f11098c0) {
            h hVar = this.f11125v;
            if (hVar.f11144c == 0 && !n0(hVar.f11142a.G)) {
                return true;
            }
        }
        return false;
    }

    private boolean n0(int i11) {
        return this.f11097c && androidx.media3.common.util.a1.F0(i11);
    }

    private boolean o0() {
        h hVar = this.f11125v;
        return hVar != null && hVar.f11151j && androidx.media3.common.util.a1.f10432a >= 23;
    }

    private static int p0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i11) {
        return audioTrack.write(byteBuffer, i11, 1);
    }

    private int q0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i11, long j11) {
        if (androidx.media3.common.util.a1.f10432a >= 26) {
            return audioTrack.write(byteBuffer, i11, 1, j11 * 1000);
        }
        if (this.G == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.G = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.G.putInt(1431633921);
        }
        if (this.H == 0) {
            this.G.putInt(4, i11);
            this.G.putLong(8, j11 * 1000);
            this.G.position(0);
            this.H = i11;
        }
        int remaining = this.G.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.G, remaining, 1);
            if (write < 0) {
                this.H = 0;
                return write;
            }
            if (write < remaining) {
                return 0;
            }
        }
        int p02 = p0(audioTrack, byteBuffer, i11);
        if (p02 < 0) {
            this.H = 0;
            return p02;
        }
        this.H -= p02;
        return p02;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean a(androidx.media3.common.r rVar) {
        return o(rVar) != 0;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void b(androidx.media3.common.z zVar) {
        this.E = new androidx.media3.common.z(androidx.media3.common.util.a1.o(zVar.f10648a, 0.1f, 8.0f), androidx.media3.common.util.a1.o(zVar.f10649b, 0.1f, 8.0f));
        if (o0()) {
            i0();
        } else {
            h0(zVar);
        }
    }

    public void b0(androidx.media3.exoplayer.audio.e eVar) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.f11108h0;
        if (looper != myLooper) {
            String name = looper == null ? "null" : looper.getThread().getName();
            throw new IllegalStateException("Current looper (" + (myLooper != null ? myLooper.getThread().getName() : "null") + ") is not the playback looper (" + name + ")");
        }
        androidx.media3.exoplayer.audio.e eVar2 = this.f11128y;
        if (eVar2 == null || eVar.equals(eVar2)) {
            return;
        }
        this.f11128y = eVar;
        AudioSink.b bVar = this.f11123t;
        if (bVar != null) {
            bVar.f();
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean c(ByteBuffer byteBuffer, long j11, int i11) {
        ByteBuffer byteBuffer2 = this.R;
        androidx.media3.common.util.a.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.f11124u != null) {
            if (!K()) {
                return false;
            }
            if (this.f11124u.b(this.f11125v)) {
                this.f11125v = this.f11124u;
                this.f11124u = null;
                AudioTrack audioTrack = this.f11127x;
                if (audioTrack != null && U(audioTrack) && this.f11125v.f11152k) {
                    if (this.f11127x.getPlayState() == 3) {
                        this.f11127x.setOffloadEndOfStream();
                        this.f11107h.a();
                    }
                    AudioTrack audioTrack2 = this.f11127x;
                    androidx.media3.common.r rVar = this.f11125v.f11142a;
                    audioTrack2.setOffloadDelayPadding(rVar.H, rVar.I);
                    this.f11106g0 = true;
                }
            } else {
                c0();
                if (hasPendingData()) {
                    return false;
                }
                flush();
            }
            D(j11);
        }
        if (!T()) {
            try {
                if (!R()) {
                    return false;
                }
            } catch (AudioSink.InitializationException e11) {
                if (e11.isRecoverable) {
                    throw e11;
                }
                this.f11116m.c(e11);
                return false;
            }
        }
        this.f11116m.a();
        if (this.O) {
            this.P = Math.max(0L, j11);
            this.N = false;
            this.O = false;
            if (o0()) {
                i0();
            }
            D(j11);
            if (this.X) {
                play();
            }
        }
        if (!this.f11107h.k(O())) {
            return false;
        }
        if (this.R == null) {
            androidx.media3.common.util.a.a(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            h hVar = this.f11125v;
            if (hVar.f11144c != 0 && this.M == 0) {
                int M = M(hVar.f11148g, byteBuffer);
                this.M = M;
                if (M == 0) {
                    return true;
                }
            }
            if (this.C != null) {
                if (!K()) {
                    return false;
                }
                D(j11);
                this.C = null;
            }
            long e12 = this.P + this.f11125v.e(N() - this.f11101e.h());
            if (!this.N && Math.abs(e12 - j11) > 200000) {
                AudioSink.b bVar = this.f11123t;
                if (bVar != null) {
                    bVar.a(new AudioSink.UnexpectedDiscontinuityException(j11, e12));
                }
                this.N = true;
            }
            if (this.N) {
                if (!K()) {
                    return false;
                }
                long j12 = j11 - e12;
                this.P += j12;
                this.N = false;
                D(j11);
                AudioSink.b bVar2 = this.f11123t;
                if (bVar2 != null && j12 != 0) {
                    bVar2.onPositionDiscontinuity();
                }
            }
            if (this.f11125v.f11144c == 0) {
                this.I += byteBuffer.remaining();
            } else {
                this.J += this.M * i11;
            }
            this.R = byteBuffer;
            this.S = i11;
        }
        d0(j11);
        if (!this.R.hasRemaining()) {
            this.R = null;
            this.S = 0;
            return true;
        }
        if (!this.f11107h.j(O())) {
            return false;
        }
        androidx.media3.common.util.u.h("DefaultAudioSink", "Resetting stalled audio track");
        flush();
        return true;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void d() {
        androidx.media3.common.util.a.g(this.Y);
        if (this.f11098c0) {
            return;
        }
        this.f11098c0 = true;
        flush();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void disableTunneling() {
        if (this.f11098c0) {
            this.f11098c0 = false;
            flush();
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void e(boolean z10) {
        this.F = z10;
        h0(o0() ? androidx.media3.common.z.f10645d : this.E);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void f(androidx.media3.common.c cVar) {
        if (this.B.equals(cVar)) {
            return;
        }
        this.B = cVar;
        if (this.f11098c0) {
            return;
        }
        androidx.media3.exoplayer.audio.i iVar = this.f11129z;
        if (iVar != null) {
            iVar.h(cVar);
        }
        flush();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void flush() {
        k kVar;
        if (T()) {
            g0();
            if (this.f11107h.i()) {
                this.f11127x.pause();
            }
            if (U(this.f11127x)) {
                ((n) androidx.media3.common.util.a.e(this.f11115l)).b(this.f11127x);
            }
            AudioSink.a a11 = this.f11125v.a();
            h hVar = this.f11124u;
            if (hVar != null) {
                this.f11125v = hVar;
                this.f11124u = null;
            }
            this.f11107h.q();
            if (androidx.media3.common.util.a1.f10432a >= 24 && (kVar = this.A) != null) {
                kVar.c();
                this.A = null;
            }
            f0(this.f11127x, this.f11123t, a11);
            this.f11127x = null;
        }
        this.f11117n.a();
        this.f11116m.a();
        this.f11110i0 = 0L;
        this.f11112j0 = 0L;
        Handler handler = this.f11114k0;
        if (handler != null) {
            ((Handler) androidx.media3.common.util.a.e(handler)).removeCallbacksAndMessages(null);
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public androidx.media3.exoplayer.audio.k g(androidx.media3.common.r rVar) {
        return this.f11104f0 ? androidx.media3.exoplayer.audio.k.f11279d : this.f11119p.a(rVar, this.B);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public long getCurrentPositionUs(boolean z10) {
        if (!T() || this.O) {
            return Long.MIN_VALUE;
        }
        return F(E(Math.min(this.f11107h.c(), this.f11125v.d(O()))));
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public androidx.media3.common.z getPlaybackParameters() {
        return this.E;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void h(AudioDeviceInfo audioDeviceInfo) {
        this.f11096b0 = audioDeviceInfo == null ? null : new androidx.media3.exoplayer.audio.j(audioDeviceInfo);
        androidx.media3.exoplayer.audio.i iVar = this.f11129z;
        if (iVar != null) {
            iVar.i(audioDeviceInfo);
        }
        AudioTrack audioTrack = this.f11127x;
        if (audioTrack != null) {
            b.b(audioTrack, this.f11096b0);
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void handleDiscontinuity() {
        this.N = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
    
        if (r3.W != false) goto L13;
     */
    @Override // androidx.media3.exoplayer.audio.AudioSink
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean hasPendingData() {
        /*
            r3 = this;
            boolean r0 = r3.T()
            if (r0 == 0) goto L26
            int r0 = androidx.media3.common.util.a1.f10432a
            r1 = 29
            if (r0 < r1) goto L18
            android.media.AudioTrack r0 = r3.f11127x
            boolean r0 = androidx.media3.exoplayer.audio.h0.a(r0)
            if (r0 == 0) goto L18
            boolean r0 = r3.W
            if (r0 != 0) goto L26
        L18:
            androidx.media3.exoplayer.audio.b0 r0 = r3.f11107h
            long r1 = r3.O()
            boolean r0 = r0.h(r1)
            if (r0 == 0) goto L26
            r0 = 1
            goto L27
        L26:
            r0 = 0
        L27:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.DefaultAudioSink.hasPendingData():boolean");
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public long i() {
        if (!T()) {
            return C.TIME_UNSET;
        }
        if (androidx.media3.common.util.a1.f10432a >= 23) {
            return b.a(this.f11127x, this.f11125v);
        }
        return androidx.media3.common.util.a1.g1(this.f11125v.f11149h, 1000000L, this.f11125v.f11144c == 0 ? r0.f11146e * r0.f11145d : x0.d(r0.f11148g), RoundingMode.DOWN);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean isEnded() {
        return !T() || (this.U && !hasPendingData());
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void j(AudioSink.b bVar) {
        this.f11123t = bVar;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void k(int i11) {
        androidx.media3.common.util.a.g(androidx.media3.common.util.a1.f10432a >= 29);
        this.f11113k = i11;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void l(androidx.media3.common.r rVar, int i11, int[] iArr) {
        androidx.media3.common.audio.a aVar;
        int i12;
        int i13;
        boolean z10;
        int i14;
        int intValue;
        int i15;
        boolean z11;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int a11;
        a0();
        if (MimeTypes.AUDIO_RAW.equals(rVar.f10243o)) {
            androidx.media3.common.util.a.a(androidx.media3.common.util.a1.G0(rVar.G));
            i12 = androidx.media3.common.util.a1.k0(rVar.G, rVar.E);
            ImmutableList.a aVar2 = new ImmutableList.a();
            if (n0(rVar.G)) {
                aVar2.l(this.f11105g);
            } else {
                aVar2.l(this.f11103f);
                aVar2.k(this.f11095b.getAudioProcessors());
            }
            androidx.media3.common.audio.a aVar3 = new androidx.media3.common.audio.a(aVar2.e());
            if (aVar3.equals(this.f11126w)) {
                aVar3 = this.f11126w;
            }
            this.f11101e.j(rVar.H, rVar.I);
            this.f11099d.h(iArr);
            try {
                AudioProcessor.a a12 = aVar3.a(new AudioProcessor.a(rVar));
                int i21 = a12.f9901c;
                int i22 = a12.f9899a;
                int M = androidx.media3.common.util.a1.M(a12.f9900b);
                i16 = 0;
                z10 = false;
                i13 = androidx.media3.common.util.a1.k0(i21, a12.f9900b);
                aVar = aVar3;
                i14 = i22;
                intValue = M;
                z11 = this.f11111j;
                i15 = i21;
            } catch (AudioProcessor.UnhandledAudioFormatException e11) {
                throw new AudioSink.ConfigurationException(e11, rVar);
            }
        } else {
            androidx.media3.common.audio.a aVar4 = new androidx.media3.common.audio.a(ImmutableList.of());
            int i23 = rVar.F;
            androidx.media3.exoplayer.audio.k g11 = this.f11113k != 0 ? g(rVar) : androidx.media3.exoplayer.audio.k.f11279d;
            if (this.f11113k == 0 || !g11.f11280a) {
                Pair h11 = this.f11128y.h(rVar, this.B);
                if (h11 == null) {
                    throw new AudioSink.ConfigurationException("Unable to configure passthrough for: " + rVar, rVar);
                }
                int intValue2 = ((Integer) h11.first).intValue();
                aVar = aVar4;
                i12 = -1;
                i13 = -1;
                z10 = false;
                i14 = i23;
                intValue = ((Integer) h11.second).intValue();
                i15 = intValue2;
                z11 = this.f11111j;
                i16 = 2;
            } else {
                int f11 = androidx.media3.common.y.f((String) androidx.media3.common.util.a.e(rVar.f10243o), rVar.f10239k);
                int M2 = androidx.media3.common.util.a1.M(rVar.E);
                aVar = aVar4;
                i16 = 1;
                z11 = true;
                i12 = -1;
                i13 = -1;
                i14 = i23;
                z10 = g11.f11281b;
                i15 = f11;
                intValue = M2;
            }
        }
        if (i15 == 0) {
            throw new AudioSink.ConfigurationException("Invalid output encoding (mode=" + i16 + ") for: " + rVar, rVar);
        }
        if (intValue == 0) {
            throw new AudioSink.ConfigurationException("Invalid output channel config (mode=" + i16 + ") for: " + rVar, rVar);
        }
        int i24 = rVar.f10238j;
        if (MimeTypes.AUDIO_DTS_EXPRESS.equals(rVar.f10243o) && i24 == -1) {
            i24 = 768000;
        }
        int i25 = i24;
        if (i11 != 0) {
            a11 = i11;
            i17 = i15;
            i18 = intValue;
            i19 = i13;
            i20 = i14;
        } else {
            i17 = i15;
            i18 = intValue;
            i19 = i13;
            i20 = i14;
            a11 = this.f11118o.a(L(i14, intValue, i15), i15, i16, i13 != -1 ? i13 : 1, i14, i25, z11 ? 8.0d : 1.0d);
        }
        this.f11104f0 = false;
        h hVar = new h(rVar, i12, i16, i19, i20, i18, i17, a11, aVar, z11, z10, this.f11098c0);
        if (T()) {
            this.f11124u = hVar;
        } else {
            this.f11125v = hVar;
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void m(int i11, int i12) {
        h hVar;
        AudioTrack audioTrack = this.f11127x;
        if (audioTrack == null || !U(audioTrack) || (hVar = this.f11125v) == null || !hVar.f11152k) {
            return;
        }
        this.f11127x.setOffloadDelayPadding(i11, i12);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public /* synthetic */ void n(long j11) {
        y.a(this, j11);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public int o(androidx.media3.common.r rVar) {
        a0();
        if (!MimeTypes.AUDIO_RAW.equals(rVar.f10243o)) {
            return this.f11128y.j(rVar, this.B) ? 2 : 0;
        }
        if (androidx.media3.common.util.a1.G0(rVar.G)) {
            int i11 = rVar.G;
            return (i11 == 2 || (this.f11097c && i11 == 4)) ? 2 : 1;
        }
        androidx.media3.common.util.u.h("DefaultAudioSink", "Invalid PCM encoding: " + rVar.G);
        return 0;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void p(f4 f4Var) {
        this.f11122s = f4Var;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void pause() {
        this.X = false;
        if (T()) {
            if (this.f11107h.p() || U(this.f11127x)) {
                this.f11127x.pause();
            }
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void play() {
        this.X = true;
        if (T()) {
            this.f11107h.v();
            this.f11127x.play();
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void playToEndOfStream() {
        if (!this.U && T() && K()) {
            c0();
            this.U = true;
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void q(androidx.media3.common.f fVar) {
        if (this.f11094a0.equals(fVar)) {
            return;
        }
        int i11 = fVar.f10049a;
        float f11 = fVar.f10050b;
        AudioTrack audioTrack = this.f11127x;
        if (audioTrack != null) {
            if (this.f11094a0.f10049a != i11) {
                audioTrack.attachAuxEffect(i11);
            }
            if (i11 != 0) {
                this.f11127x.setAuxEffectSendLevel(f11);
            }
        }
        this.f11094a0 = fVar;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void r(androidx.media3.common.util.i iVar) {
        this.f11107h.u(iVar);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void release() {
        androidx.media3.exoplayer.audio.i iVar = this.f11129z;
        if (iVar != null) {
            iVar.j();
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void reset() {
        flush();
        r4 it = this.f11103f.iterator();
        while (it.hasNext()) {
            ((AudioProcessor) it.next()).reset();
        }
        r4 it2 = this.f11105g.iterator();
        while (it2.hasNext()) {
            ((AudioProcessor) it2.next()).reset();
        }
        androidx.media3.common.audio.a aVar = this.f11126w;
        if (aVar != null) {
            aVar.j();
        }
        this.X = false;
        this.f11104f0 = false;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void setAudioSessionId(int i11) {
        if (this.Z != i11) {
            this.Z = i11;
            this.Y = i11 != 0;
            flush();
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void setVolume(float f11) {
        if (this.Q != f11) {
            this.Q = f11;
            k0();
        }
    }
}
