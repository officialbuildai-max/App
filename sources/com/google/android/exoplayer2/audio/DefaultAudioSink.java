package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;
import android.media.PlaybackParams;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.exoplayer.audio.w0;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.t;
import com.google.android.exoplayer2.audio.x;
import com.google.android.exoplayer2.n2;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import e9.u1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class DefaultAudioSink implements AudioSink {

    /* renamed from: c0, reason: collision with root package name */
    public static boolean f24589c0;
    private int A;
    private long B;
    private long C;
    private long D;
    private long E;
    private int F;
    private boolean G;
    private boolean H;
    private long I;
    private float J;
    private AudioProcessor[] K;
    private ByteBuffer[] L;
    private ByteBuffer M;
    private int N;
    private ByteBuffer O;
    private byte[] P;
    private int Q;
    private int R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private int W;
    private u X;
    private boolean Y;
    private long Z;

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.audio.f f24590a;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f24591a0;

    /* renamed from: b, reason: collision with root package name */
    private final b f24592b;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f24593b0;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f24594c;

    /* renamed from: d, reason: collision with root package name */
    private final w f24595d;

    /* renamed from: e, reason: collision with root package name */
    private final h0 f24596e;

    /* renamed from: f, reason: collision with root package name */
    private final AudioProcessor[] f24597f;

    /* renamed from: g, reason: collision with root package name */
    private final AudioProcessor[] f24598g;

    /* renamed from: h, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.h f24599h;

    /* renamed from: i, reason: collision with root package name */
    private final t f24600i;

    /* renamed from: j, reason: collision with root package name */
    private final ArrayDeque f24601j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f24602k;

    /* renamed from: l, reason: collision with root package name */
    private final int f24603l;

    /* renamed from: m, reason: collision with root package name */
    private j f24604m;

    /* renamed from: n, reason: collision with root package name */
    private final h f24605n;

    /* renamed from: o, reason: collision with root package name */
    private final h f24606o;

    /* renamed from: p, reason: collision with root package name */
    private final c f24607p;

    /* renamed from: q, reason: collision with root package name */
    private u1 f24608q;

    /* renamed from: r, reason: collision with root package name */
    private AudioSink.a f24609r;

    /* renamed from: s, reason: collision with root package name */
    private e f24610s;

    /* renamed from: t, reason: collision with root package name */
    private e f24611t;

    /* renamed from: u, reason: collision with root package name */
    private AudioTrack f24612u;

    /* renamed from: v, reason: collision with root package name */
    private com.google.android.exoplayer2.audio.e f24613v;

    /* renamed from: w, reason: collision with root package name */
    private g f24614w;

    /* renamed from: x, reason: collision with root package name */
    private g f24615x;

    /* renamed from: y, reason: collision with root package name */
    private n2 f24616y;

    /* renamed from: z, reason: collision with root package name */
    private ByteBuffer f24617z;

    /* loaded from: classes3.dex */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        private InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {
        public static void a(AudioTrack audioTrack, u1 u1Var) {
            LogSessionId logSessionId;
            boolean equals;
            LogSessionId a11 = u1Var.a();
            logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
            equals = a11.equals(logSessionId);
            if (equals) {
                return;
            }
            audioTrack.setLogSessionId(a11);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        boolean a(boolean z10);

        n2 b(n2 n2Var);

        AudioProcessor[] getAudioProcessors();

        long getMediaDuration(long j11);

        long getSkippedOutputFrameCount();
    }

    /* loaded from: classes3.dex */
    interface c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f24618a = new x.a().g();

        int a(int i11, int i12, int i13, int i14, int i15, double d11);
    }

    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: b, reason: collision with root package name */
        private b f24620b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f24621c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f24622d;

        /* renamed from: a, reason: collision with root package name */
        private com.google.android.exoplayer2.audio.f f24619a = com.google.android.exoplayer2.audio.f.f24714c;

        /* renamed from: e, reason: collision with root package name */
        private int f24623e = 0;

        /* renamed from: f, reason: collision with root package name */
        c f24624f = c.f24618a;

        public DefaultAudioSink f() {
            if (this.f24620b == null) {
                this.f24620b = new f(new AudioProcessor[0]);
            }
            return new DefaultAudioSink(this);
        }

        public d g(com.google.android.exoplayer2.audio.f fVar) {
            com.google.android.exoplayer2.util.a.e(fVar);
            this.f24619a = fVar;
            return this;
        }

        public d h(boolean z10) {
            this.f24622d = z10;
            return this;
        }

        public d i(boolean z10) {
            this.f24621c = z10;
            return this;
        }

        public d j(int i11) {
            this.f24623e = i11;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final o1 f24625a;

        /* renamed from: b, reason: collision with root package name */
        public final int f24626b;

        /* renamed from: c, reason: collision with root package name */
        public final int f24627c;

        /* renamed from: d, reason: collision with root package name */
        public final int f24628d;

        /* renamed from: e, reason: collision with root package name */
        public final int f24629e;

        /* renamed from: f, reason: collision with root package name */
        public final int f24630f;

        /* renamed from: g, reason: collision with root package name */
        public final int f24631g;

        /* renamed from: h, reason: collision with root package name */
        public final int f24632h;

        /* renamed from: i, reason: collision with root package name */
        public final AudioProcessor[] f24633i;

        public e(o1 o1Var, int i11, int i12, int i13, int i14, int i15, int i16, int i17, AudioProcessor[] audioProcessorArr) {
            this.f24625a = o1Var;
            this.f24626b = i11;
            this.f24627c = i12;
            this.f24628d = i13;
            this.f24629e = i14;
            this.f24630f = i15;
            this.f24631g = i16;
            this.f24632h = i17;
            this.f24633i = audioProcessorArr;
        }

        private AudioTrack d(boolean z10, com.google.android.exoplayer2.audio.e eVar, int i11) {
            int i12 = p0.f27680a;
            return i12 >= 29 ? f(z10, eVar, i11) : i12 >= 21 ? e(z10, eVar, i11) : g(eVar, i11);
        }

        private AudioTrack e(boolean z10, com.google.android.exoplayer2.audio.e eVar, int i11) {
            return new AudioTrack(i(eVar, z10), DefaultAudioSink.B(this.f24629e, this.f24630f, this.f24631g), this.f24632h, 1, i11);
        }

        private AudioTrack f(boolean z10, com.google.android.exoplayer2.audio.e eVar, int i11) {
            AudioTrack.Builder offloadedPlayback;
            offloadedPlayback = new AudioTrack.Builder().setAudioAttributes(i(eVar, z10)).setAudioFormat(DefaultAudioSink.B(this.f24629e, this.f24630f, this.f24631g)).setTransferMode(1).setBufferSizeInBytes(this.f24632h).setSessionId(i11).setOffloadedPlayback(this.f24627c == 1);
            return offloadedPlayback.build();
        }

        private AudioTrack g(com.google.android.exoplayer2.audio.e eVar, int i11) {
            int g02 = p0.g0(eVar.f24692c);
            return i11 == 0 ? new AudioTrack(g02, this.f24629e, this.f24630f, this.f24631g, this.f24632h, 1) : new AudioTrack(g02, this.f24629e, this.f24630f, this.f24631g, this.f24632h, 1, i11);
        }

        private static AudioAttributes i(com.google.android.exoplayer2.audio.e eVar, boolean z10) {
            return z10 ? j() : eVar.b().f24696a;
        }

        private static AudioAttributes j() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        public AudioTrack a(boolean z10, com.google.android.exoplayer2.audio.e eVar, int i11) {
            try {
                AudioTrack d11 = d(z10, eVar, i11);
                int state = d11.getState();
                if (state == 1) {
                    return d11;
                }
                try {
                    d11.release();
                } catch (Exception unused) {
                }
                throw new AudioSink.InitializationException(state, this.f24629e, this.f24630f, this.f24632h, this.f24625a, l(), null);
            } catch (IllegalArgumentException | UnsupportedOperationException e11) {
                throw new AudioSink.InitializationException(0, this.f24629e, this.f24630f, this.f24632h, this.f24625a, l(), e11);
            }
        }

        public boolean b(e eVar) {
            return eVar.f24627c == this.f24627c && eVar.f24631g == this.f24631g && eVar.f24629e == this.f24629e && eVar.f24630f == this.f24630f && eVar.f24628d == this.f24628d;
        }

        public e c(int i11) {
            return new e(this.f24625a, this.f24626b, this.f24627c, this.f24628d, this.f24629e, this.f24630f, this.f24631g, i11, this.f24633i);
        }

        public long h(long j11) {
            return (j11 * 1000000) / this.f24629e;
        }

        public long k(long j11) {
            return (j11 * 1000000) / this.f24625a.f25564z;
        }

        public boolean l() {
            return this.f24627c == 1;
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements b {

        /* renamed from: a, reason: collision with root package name */
        private final AudioProcessor[] f24634a;

        /* renamed from: b, reason: collision with root package name */
        private final e0 f24635b;

        /* renamed from: c, reason: collision with root package name */
        private final g0 f24636c;

        public f(AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new e0(), new g0());
        }

        public f(AudioProcessor[] audioProcessorArr, e0 e0Var, g0 g0Var) {
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 2];
            this.f24634a = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.f24635b = e0Var;
            this.f24636c = g0Var;
            audioProcessorArr2[audioProcessorArr.length] = e0Var;
            audioProcessorArr2[audioProcessorArr.length + 1] = g0Var;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public boolean a(boolean z10) {
            this.f24635b.q(z10);
            return z10;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public n2 b(n2 n2Var) {
            this.f24636c.d(n2Var.f25529a);
            this.f24636c.c(n2Var.f25530b);
            return n2Var;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public AudioProcessor[] getAudioProcessors() {
            return this.f24634a;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public long getMediaDuration(long j11) {
            return this.f24636c.b(j11);
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public long getSkippedOutputFrameCount() {
            return this.f24635b.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final n2 f24637a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f24638b;

        /* renamed from: c, reason: collision with root package name */
        public final long f24639c;

        /* renamed from: d, reason: collision with root package name */
        public final long f24640d;

        private g(n2 n2Var, boolean z10, long j11, long j12) {
            this.f24637a = n2Var;
            this.f24638b = z10;
            this.f24639c = j11;
            this.f24640d = j12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        private final long f24641a;

        /* renamed from: b, reason: collision with root package name */
        private Exception f24642b;

        /* renamed from: c, reason: collision with root package name */
        private long f24643c;

        public h(long j11) {
            this.f24641a = j11;
        }

        public void a() {
            this.f24642b = null;
        }

        public void b(Exception exc) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f24642b == null) {
                this.f24642b = exc;
                this.f24643c = this.f24641a + elapsedRealtime;
            }
            if (elapsedRealtime >= this.f24643c) {
                Exception exc2 = this.f24642b;
                if (exc2 != exc) {
                    exc2.addSuppressed(exc);
                }
                Exception exc3 = this.f24642b;
                a();
                throw exc3;
            }
        }
    }

    /* loaded from: classes3.dex */
    private final class i implements t.a {
        private i() {
        }

        @Override // com.google.android.exoplayer2.audio.t.a
        public void b(long j11) {
            if (DefaultAudioSink.this.f24609r != null) {
                DefaultAudioSink.this.f24609r.b(j11);
            }
        }

        @Override // com.google.android.exoplayer2.audio.t.a
        public void onInvalidLatency(long j11) {
            com.google.android.exoplayer2.util.s.i("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j11);
        }

        @Override // com.google.android.exoplayer2.audio.t.a
        public void onPositionFramesMismatch(long j11, long j12, long j13, long j14) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j11 + ", " + j12 + ", " + j13 + ", " + j14 + ", " + DefaultAudioSink.this.I() + ", " + DefaultAudioSink.this.J();
            if (DefaultAudioSink.f24589c0) {
                throw new InvalidAudioTrackTimestampException(str);
            }
            com.google.android.exoplayer2.util.s.i("DefaultAudioSink", str);
        }

        @Override // com.google.android.exoplayer2.audio.t.a
        public void onSystemTimeUsMismatch(long j11, long j12, long j13, long j14) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j11 + ", " + j12 + ", " + j13 + ", " + j14 + ", " + DefaultAudioSink.this.I() + ", " + DefaultAudioSink.this.J();
            if (DefaultAudioSink.f24589c0) {
                throw new InvalidAudioTrackTimestampException(str);
            }
            com.google.android.exoplayer2.util.s.i("DefaultAudioSink", str);
        }

        @Override // com.google.android.exoplayer2.audio.t.a
        public void onUnderrun(int i11, long j11) {
            if (DefaultAudioSink.this.f24609r != null) {
                DefaultAudioSink.this.f24609r.onUnderrun(i11, j11, SystemClock.elapsedRealtime() - DefaultAudioSink.this.Z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class j {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f24645a = new Handler();

        /* renamed from: b, reason: collision with root package name */
        private final AudioTrack$StreamEventCallback f24646b;

        /* loaded from: classes3.dex */
        class a extends AudioTrack$StreamEventCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ DefaultAudioSink f24648a;

            a(DefaultAudioSink defaultAudioSink) {
                this.f24648a = defaultAudioSink;
            }

            public void onDataRequest(AudioTrack audioTrack, int i11) {
                com.google.android.exoplayer2.util.a.g(audioTrack == DefaultAudioSink.this.f24612u);
                if (DefaultAudioSink.this.f24609r == null || !DefaultAudioSink.this.U) {
                    return;
                }
                DefaultAudioSink.this.f24609r.d();
            }

            public void onTearDown(AudioTrack audioTrack) {
                com.google.android.exoplayer2.util.a.g(audioTrack == DefaultAudioSink.this.f24612u);
                if (DefaultAudioSink.this.f24609r == null || !DefaultAudioSink.this.U) {
                    return;
                }
                DefaultAudioSink.this.f24609r.d();
            }
        }

        public j() {
            this.f24646b = new a(DefaultAudioSink.this);
        }

        public void a(AudioTrack audioTrack) {
            Handler handler = this.f24645a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new w0(handler), this.f24646b);
        }

        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.f24646b);
            this.f24645a.removeCallbacksAndMessages(null);
        }
    }

    private DefaultAudioSink(d dVar) {
        this.f24590a = dVar.f24619a;
        b bVar = dVar.f24620b;
        this.f24592b = bVar;
        int i11 = p0.f27680a;
        this.f24594c = i11 >= 21 && dVar.f24621c;
        this.f24602k = i11 >= 23 && dVar.f24622d;
        this.f24603l = i11 >= 29 ? dVar.f24623e : 0;
        this.f24607p = dVar.f24624f;
        com.google.android.exoplayer2.util.h hVar = new com.google.android.exoplayer2.util.h(com.google.android.exoplayer2.util.e.f27621a);
        this.f24599h = hVar;
        hVar.f();
        this.f24600i = new t(new i());
        w wVar = new w();
        this.f24595d = wVar;
        h0 h0Var = new h0();
        this.f24596e = h0Var;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new d0(), wVar, h0Var);
        Collections.addAll(arrayList, bVar.getAudioProcessors());
        this.f24597f = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[0]);
        this.f24598g = new AudioProcessor[]{new z()};
        this.J = 1.0f;
        this.f24613v = com.google.android.exoplayer2.audio.e.f24688g;
        this.W = 0;
        this.X = new u(0, 0.0f);
        n2 n2Var = n2.f25527d;
        this.f24615x = new g(n2Var, false, 0L, 0L);
        this.f24616y = n2Var;
        this.R = -1;
        this.K = new AudioProcessor[0];
        this.L = new ByteBuffer[0];
        this.f24601j = new ArrayDeque();
        this.f24605n = new h(100L);
        this.f24606o = new h(100L);
    }

    private void A() {
        int i11 = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.K;
            if (i11 >= audioProcessorArr.length) {
                return;
            }
            AudioProcessor audioProcessor = audioProcessorArr[i11];
            audioProcessor.flush();
            this.L[i11] = audioProcessor.getOutput();
            i11++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AudioFormat B(int i11, int i12, int i13) {
        return new AudioFormat.Builder().setSampleRate(i11).setChannelMask(i12).setEncoding(i13).build();
    }

    private n2 C() {
        return F().f24637a;
    }

    private static int D(int i11, int i12, int i13) {
        int minBufferSize = AudioTrack.getMinBufferSize(i11, i12, i13);
        com.google.android.exoplayer2.util.a.g(minBufferSize != -2);
        return minBufferSize;
    }

    private static int E(int i11, ByteBuffer byteBuffer) {
        switch (i11) {
            case 5:
            case 6:
            case 18:
                return com.google.android.exoplayer2.audio.b.d(byteBuffer);
            case 7:
            case 8:
                return y.e(byteBuffer);
            case 9:
                int m11 = b0.m(p0.I(byteBuffer, byteBuffer.position()));
                if (m11 != -1) {
                    return m11;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 13:
            default:
                throw new IllegalStateException("Unexpected audio encoding: " + i11);
            case 14:
                int a11 = com.google.android.exoplayer2.audio.b.a(byteBuffer);
                if (a11 == -1) {
                    return 0;
                }
                return com.google.android.exoplayer2.audio.b.h(byteBuffer, a11) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return com.google.android.exoplayer2.audio.c.c(byteBuffer);
        }
    }

    private g F() {
        g gVar = this.f24614w;
        return gVar != null ? gVar : !this.f24601j.isEmpty() ? (g) this.f24601j.getLast() : this.f24615x;
    }

    private int G(AudioFormat audioFormat, AudioAttributes audioAttributes) {
        boolean isOffloadedPlaybackSupported;
        int playbackOffloadSupport;
        int i11 = p0.f27680a;
        if (i11 >= 31) {
            playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
            return playbackOffloadSupport;
        }
        isOffloadedPlaybackSupported = AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes);
        if (isOffloadedPlaybackSupported) {
            return (i11 == 30 && p0.f27683d.startsWith("Pixel")) ? 2 : 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long I() {
        return this.f24611t.f24627c == 0 ? this.B / r0.f24626b : this.C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long J() {
        return this.f24611t.f24627c == 0 ? this.D / r0.f24628d : this.E;
    }

    private boolean K() {
        u1 u1Var;
        if (!this.f24599h.e()) {
            return false;
        }
        AudioTrack y10 = y();
        this.f24612u = y10;
        if (N(y10)) {
            R(this.f24612u);
            if (this.f24603l != 3) {
                AudioTrack audioTrack = this.f24612u;
                o1 o1Var = this.f24611t.f24625a;
                audioTrack.setOffloadDelayPadding(o1Var.B, o1Var.C);
            }
        }
        if (p0.f27680a >= 31 && (u1Var = this.f24608q) != null) {
            a.a(this.f24612u, u1Var);
        }
        this.W = this.f24612u.getAudioSessionId();
        t tVar = this.f24600i;
        AudioTrack audioTrack2 = this.f24612u;
        e eVar = this.f24611t;
        tVar.s(audioTrack2, eVar.f24627c == 2, eVar.f24631g, eVar.f24628d, eVar.f24632h);
        V();
        int i11 = this.X.f24828a;
        if (i11 != 0) {
            this.f24612u.attachAuxEffect(i11);
            this.f24612u.setAuxEffectSendLevel(this.X.f24829b);
        }
        this.H = true;
        return true;
    }

    private static boolean L(int i11) {
        return (p0.f27680a >= 24 && i11 == -6) || i11 == -32;
    }

    private boolean M() {
        return this.f24612u != null;
    }

    private static boolean N(AudioTrack audioTrack) {
        boolean isOffloadedPlayback;
        if (p0.f27680a >= 29) {
            isOffloadedPlayback = audioTrack.isOffloadedPlayback();
            if (isOffloadedPlayback) {
                return true;
            }
        }
        return false;
    }

    private void O() {
        if (this.f24611t.l()) {
            this.f24591a0 = true;
        }
    }

    private void P() {
        if (this.T) {
            return;
        }
        this.T = true;
        this.f24600i.g(J());
        this.f24612u.stop();
        this.A = 0;
    }

    private void Q(long j11) {
        ByteBuffer byteBuffer;
        int length = this.K.length;
        int i11 = length;
        while (i11 >= 0) {
            if (i11 > 0) {
                byteBuffer = this.L[i11 - 1];
            } else {
                byteBuffer = this.M;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.f24583a;
                }
            }
            if (i11 == length) {
                c0(byteBuffer, j11);
            } else {
                AudioProcessor audioProcessor = this.K[i11];
                if (i11 > this.R) {
                    audioProcessor.queueInput(byteBuffer);
                }
                ByteBuffer output = audioProcessor.getOutput();
                this.L[i11] = output;
                if (output.hasRemaining()) {
                    i11++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i11--;
            }
        }
    }

    private void R(AudioTrack audioTrack) {
        if (this.f24604m == null) {
            this.f24604m = new j();
        }
        this.f24604m.a(audioTrack);
    }

    private void S() {
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.f24593b0 = false;
        this.F = 0;
        this.f24615x = new g(C(), H(), 0L, 0L);
        this.I = 0L;
        this.f24614w = null;
        this.f24601j.clear();
        this.M = null;
        this.N = 0;
        this.O = null;
        this.T = false;
        this.S = false;
        this.R = -1;
        this.f24617z = null;
        this.A = 0;
        this.f24596e.i();
        A();
    }

    private void T(n2 n2Var, boolean z10) {
        g F = F();
        if (n2Var.equals(F.f24637a) && z10 == F.f24638b) {
            return;
        }
        g gVar = new g(n2Var, z10, C.TIME_UNSET, C.TIME_UNSET);
        if (M()) {
            this.f24614w = gVar;
        } else {
            this.f24615x = gVar;
        }
    }

    private void U(n2 n2Var) {
        if (M()) {
            try {
                this.f24612u.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(n2Var.f25529a).setPitch(n2Var.f25530b).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e11) {
                com.google.android.exoplayer2.util.s.j("DefaultAudioSink", "Failed to set playback params", e11);
            }
            n2Var = new n2(this.f24612u.getPlaybackParams().getSpeed(), this.f24612u.getPlaybackParams().getPitch());
            this.f24600i.t(n2Var.f25529a);
        }
        this.f24616y = n2Var;
    }

    private void V() {
        if (M()) {
            if (p0.f27680a >= 21) {
                W(this.f24612u, this.J);
            } else {
                X(this.f24612u, this.J);
            }
        }
    }

    private static void W(AudioTrack audioTrack, float f11) {
        audioTrack.setVolume(f11);
    }

    private static void X(AudioTrack audioTrack, float f11) {
        audioTrack.setStereoVolume(f11, f11);
    }

    private void Y() {
        AudioProcessor[] audioProcessorArr = this.f24611t.f24633i;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : audioProcessorArr) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.K = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.L = new ByteBuffer[size];
        A();
    }

    private boolean Z() {
        return (this.Y || !MimeTypes.AUDIO_RAW.equals(this.f24611t.f24625a.f25550l) || a0(this.f24611t.f24625a.A)) ? false : true;
    }

    private boolean a0(int i11) {
        return this.f24594c && p0.t0(i11);
    }

    private boolean b0(o1 o1Var, com.google.android.exoplayer2.audio.e eVar) {
        int f11;
        int G;
        int G2;
        if (p0.f27680a < 29 || this.f24603l == 0 || (f11 = com.google.android.exoplayer2.util.w.f((String) com.google.android.exoplayer2.util.a.e(o1Var.f25550l), o1Var.f25547i)) == 0 || (G = p0.G(o1Var.f25563y)) == 0 || (G2 = G(B(o1Var.f25564z, G, f11), eVar.b().f24696a)) == 0) {
            return false;
        }
        if (G2 == 1) {
            return ((o1Var.B != 0 || o1Var.C != 0) && (this.f24603l == 1)) ? false : true;
        }
        if (G2 == 2) {
            return true;
        }
        throw new IllegalStateException();
    }

    private void c0(ByteBuffer byteBuffer, long j11) {
        int d02;
        AudioSink.a aVar;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.O;
            if (byteBuffer2 != null) {
                com.google.android.exoplayer2.util.a.a(byteBuffer2 == byteBuffer);
            } else {
                this.O = byteBuffer;
                if (p0.f27680a < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.P;
                    if (bArr == null || bArr.length < remaining) {
                        this.P = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.P, 0, remaining);
                    byteBuffer.position(position);
                    this.Q = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (p0.f27680a < 21) {
                int c11 = this.f24600i.c(this.D);
                if (c11 > 0) {
                    d02 = this.f24612u.write(this.P, this.Q, Math.min(remaining2, c11));
                    if (d02 > 0) {
                        this.Q += d02;
                        byteBuffer.position(byteBuffer.position() + d02);
                    }
                } else {
                    d02 = 0;
                }
            } else if (this.Y) {
                com.google.android.exoplayer2.util.a.g(j11 != C.TIME_UNSET);
                d02 = e0(this.f24612u, byteBuffer, remaining2, j11);
            } else {
                d02 = d0(this.f24612u, byteBuffer, remaining2);
            }
            this.Z = SystemClock.elapsedRealtime();
            if (d02 < 0) {
                boolean L = L(d02);
                if (L) {
                    O();
                }
                AudioSink.WriteException writeException = new AudioSink.WriteException(d02, this.f24611t.f24625a, L);
                AudioSink.a aVar2 = this.f24609r;
                if (aVar2 != null) {
                    aVar2.a(writeException);
                }
                if (writeException.isRecoverable) {
                    throw writeException;
                }
                this.f24606o.b(writeException);
                return;
            }
            this.f24606o.a();
            if (N(this.f24612u)) {
                if (this.E > 0) {
                    this.f24593b0 = false;
                }
                if (this.U && (aVar = this.f24609r) != null && d02 < remaining2 && !this.f24593b0) {
                    aVar.c();
                }
            }
            int i11 = this.f24611t.f24627c;
            if (i11 == 0) {
                this.D += d02;
            }
            if (d02 == remaining2) {
                if (i11 != 0) {
                    com.google.android.exoplayer2.util.a.g(byteBuffer == this.M);
                    this.E += this.F * this.N;
                }
                this.O = null;
            }
        }
    }

    private static int d0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i11) {
        return audioTrack.write(byteBuffer, i11, 1);
    }

    private int e0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i11, long j11) {
        if (p0.f27680a >= 26) {
            return audioTrack.write(byteBuffer, i11, 1, j11 * 1000);
        }
        if (this.f24617z == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.f24617z = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.f24617z.putInt(1431633921);
        }
        if (this.A == 0) {
            this.f24617z.putInt(4, i11);
            this.f24617z.putLong(8, j11 * 1000);
            this.f24617z.position(0);
            this.A = i11;
        }
        int remaining = this.f24617z.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.f24617z, remaining, 1);
            if (write < 0) {
                this.A = 0;
                return write;
            }
            if (write < remaining) {
                return 0;
            }
        }
        int d02 = d0(audioTrack, byteBuffer, i11);
        if (d02 < 0) {
            this.A = 0;
            return d02;
        }
        this.A -= d02;
        return d02;
    }

    private void u(long j11) {
        n2 b11 = Z() ? this.f24592b.b(C()) : n2.f25527d;
        boolean a11 = Z() ? this.f24592b.a(H()) : false;
        this.f24601j.add(new g(b11, a11, Math.max(0L, j11), this.f24611t.h(J())));
        Y();
        AudioSink.a aVar = this.f24609r;
        if (aVar != null) {
            aVar.onSkipSilenceEnabledChanged(a11);
        }
    }

    private long v(long j11) {
        while (!this.f24601j.isEmpty() && j11 >= ((g) this.f24601j.getFirst()).f24640d) {
            this.f24615x = (g) this.f24601j.remove();
        }
        g gVar = this.f24615x;
        long j12 = j11 - gVar.f24640d;
        if (gVar.f24637a.equals(n2.f25527d)) {
            return this.f24615x.f24639c + j12;
        }
        if (this.f24601j.isEmpty()) {
            return this.f24615x.f24639c + this.f24592b.getMediaDuration(j12);
        }
        g gVar2 = (g) this.f24601j.getFirst();
        return gVar2.f24639c - p0.a0(gVar2.f24640d - j11, this.f24615x.f24637a.f25529a);
    }

    private long w(long j11) {
        return j11 + this.f24611t.h(this.f24592b.getSkippedOutputFrameCount());
    }

    private AudioTrack x(e eVar) {
        try {
            return eVar.a(this.Y, this.f24613v, this.W);
        } catch (AudioSink.InitializationException e11) {
            AudioSink.a aVar = this.f24609r;
            if (aVar != null) {
                aVar.a(e11);
            }
            throw e11;
        }
    }

    private AudioTrack y() {
        try {
            return x((e) com.google.android.exoplayer2.util.a.e(this.f24611t));
        } catch (AudioSink.InitializationException e11) {
            e eVar = this.f24611t;
            if (eVar.f24632h > 1000000) {
                e c11 = eVar.c(1000000);
                try {
                    AudioTrack x10 = x(c11);
                    this.f24611t = c11;
                    return x10;
                } catch (AudioSink.InitializationException e12) {
                    e11.addSuppressed(e12);
                    O();
                    throw e11;
                }
            }
            O();
            throw e11;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0029 -> B:4:0x0009). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean z() {
        /*
            r9 = this;
            int r0 = r9.R
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto Lb
            r9.R = r2
        L9:
            r0 = r1
            goto Lc
        Lb:
            r0 = r2
        Lc:
            int r4 = r9.R
            com.google.android.exoplayer2.audio.AudioProcessor[] r5 = r9.K
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L2f
            r4 = r5[r4]
            if (r0 == 0) goto L1f
            r4.queueEndOfStream()
        L1f:
            r9.Q(r7)
            boolean r0 = r4.isEnded()
            if (r0 != 0) goto L29
            return r2
        L29:
            int r0 = r9.R
            int r0 = r0 + r1
            r9.R = r0
            goto L9
        L2f:
            java.nio.ByteBuffer r0 = r9.O
            if (r0 == 0) goto L3b
            r9.c0(r0, r7)
            java.nio.ByteBuffer r0 = r9.O
            if (r0 == 0) goto L3b
            return r2
        L3b:
            r9.R = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DefaultAudioSink.z():boolean");
    }

    public boolean H() {
        return F().f24638b;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean a(o1 o1Var) {
        return h(o1Var) != 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void b(n2 n2Var) {
        n2 n2Var2 = new n2(p0.p(n2Var.f25529a, 0.1f, 8.0f), p0.p(n2Var.f25530b, 0.1f, 8.0f));
        if (!this.f24602k || p0.f27680a < 23) {
            T(n2Var2, H());
        } else {
            U(n2Var2);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean c(ByteBuffer byteBuffer, long j11, int i11) {
        ByteBuffer byteBuffer2 = this.M;
        com.google.android.exoplayer2.util.a.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.f24610s != null) {
            if (!z()) {
                return false;
            }
            if (this.f24610s.b(this.f24611t)) {
                this.f24611t = this.f24610s;
                this.f24610s = null;
                if (N(this.f24612u) && this.f24603l != 3) {
                    if (this.f24612u.getPlayState() == 3) {
                        this.f24612u.setOffloadEndOfStream();
                    }
                    AudioTrack audioTrack = this.f24612u;
                    o1 o1Var = this.f24611t.f24625a;
                    audioTrack.setOffloadDelayPadding(o1Var.B, o1Var.C);
                    this.f24593b0 = true;
                }
            } else {
                P();
                if (hasPendingData()) {
                    return false;
                }
                flush();
            }
            u(j11);
        }
        if (!M()) {
            try {
                if (!K()) {
                    return false;
                }
            } catch (AudioSink.InitializationException e11) {
                if (e11.isRecoverable) {
                    throw e11;
                }
                this.f24605n.b(e11);
                return false;
            }
        }
        this.f24605n.a();
        if (this.H) {
            this.I = Math.max(0L, j11);
            this.G = false;
            this.H = false;
            if (this.f24602k && p0.f27680a >= 23) {
                U(this.f24616y);
            }
            u(j11);
            if (this.U) {
                play();
            }
        }
        if (!this.f24600i.k(J())) {
            return false;
        }
        if (this.M == null) {
            com.google.android.exoplayer2.util.a.a(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            e eVar = this.f24611t;
            if (eVar.f24627c != 0 && this.F == 0) {
                int E = E(eVar.f24631g, byteBuffer);
                this.F = E;
                if (E == 0) {
                    return true;
                }
            }
            if (this.f24614w != null) {
                if (!z()) {
                    return false;
                }
                u(j11);
                this.f24614w = null;
            }
            long k11 = this.I + this.f24611t.k(I() - this.f24596e.h());
            if (!this.G && Math.abs(k11 - j11) > 200000) {
                this.f24609r.a(new AudioSink.UnexpectedDiscontinuityException(j11, k11));
                this.G = true;
            }
            if (this.G) {
                if (!z()) {
                    return false;
                }
                long j12 = j11 - k11;
                this.I += j12;
                this.G = false;
                u(j11);
                AudioSink.a aVar = this.f24609r;
                if (aVar != null && j12 != 0) {
                    aVar.onPositionDiscontinuity();
                }
            }
            if (this.f24611t.f24627c == 0) {
                this.B += byteBuffer.remaining();
            } else {
                this.C += this.F * i11;
            }
            this.M = byteBuffer;
            this.N = i11;
        }
        Q(j11);
        if (!this.M.hasRemaining()) {
            this.M = null;
            this.N = 0;
            return true;
        }
        if (!this.f24600i.j(J())) {
            return false;
        }
        com.google.android.exoplayer2.util.s.i("DefaultAudioSink", "Resetting stalled audio track");
        flush();
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void d() {
        com.google.android.exoplayer2.util.a.g(p0.f27680a >= 21);
        com.google.android.exoplayer2.util.a.g(this.V);
        if (this.Y) {
            return;
        }
        this.Y = true;
        flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void disableTunneling() {
        if (this.Y) {
            this.Y = false;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void e(boolean z10) {
        T(C(), z10);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void f(com.google.android.exoplayer2.audio.e eVar) {
        if (this.f24613v.equals(eVar)) {
            return;
        }
        this.f24613v = eVar;
        if (this.Y) {
            return;
        }
        flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void flush() {
        if (M()) {
            S();
            if (this.f24600i.i()) {
                this.f24612u.pause();
            }
            if (N(this.f24612u)) {
                ((j) com.google.android.exoplayer2.util.a.e(this.f24604m)).b(this.f24612u);
            }
            final AudioTrack audioTrack = this.f24612u;
            this.f24612u = null;
            if (p0.f27680a < 21 && !this.V) {
                this.W = 0;
            }
            e eVar = this.f24610s;
            if (eVar != null) {
                this.f24611t = eVar;
                this.f24610s = null;
            }
            this.f24600i.q();
            this.f24599h.d();
            new Thread("ExoPlayer:AudioTrackReleaseThread") { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        DefaultAudioSink.this.f24599h.f();
                    }
                }
            }.start();
        }
        this.f24606o.a();
        this.f24605n.a();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void g(AudioSink.a aVar) {
        this.f24609r = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long getCurrentPositionUs(boolean z10) {
        if (!M() || this.H) {
            return Long.MIN_VALUE;
        }
        return w(v(Math.min(this.f24600i.d(z10), this.f24611t.h(J()))));
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public n2 getPlaybackParameters() {
        return this.f24602k ? this.f24616y : C();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public int h(o1 o1Var) {
        if (!MimeTypes.AUDIO_RAW.equals(o1Var.f25550l)) {
            return ((this.f24591a0 || !b0(o1Var, this.f24613v)) && !this.f24590a.h(o1Var)) ? 0 : 2;
        }
        if (p0.u0(o1Var.A)) {
            int i11 = o1Var.A;
            return (i11 == 2 || (this.f24594c && i11 == 4)) ? 2 : 1;
        }
        com.google.android.exoplayer2.util.s.i("DefaultAudioSink", "Invalid PCM encoding: " + o1Var.A);
        return 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void handleDiscontinuity() {
        this.G = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean hasPendingData() {
        return M() && this.f24600i.h(J());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void i() {
        if (p0.f27680a < 25) {
            flush();
            return;
        }
        this.f24606o.a();
        this.f24605n.a();
        if (M()) {
            S();
            if (this.f24600i.i()) {
                this.f24612u.pause();
            }
            this.f24612u.flush();
            this.f24600i.q();
            t tVar = this.f24600i;
            AudioTrack audioTrack = this.f24612u;
            e eVar = this.f24611t;
            tVar.s(audioTrack, eVar.f24627c == 2, eVar.f24631g, eVar.f24628d, eVar.f24632h);
            this.H = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isEnded() {
        return !M() || (this.S && !hasPendingData());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void j(u uVar) {
        if (this.X.equals(uVar)) {
            return;
        }
        int i11 = uVar.f24828a;
        float f11 = uVar.f24829b;
        AudioTrack audioTrack = this.f24612u;
        if (audioTrack != null) {
            if (this.X.f24828a != i11) {
                audioTrack.attachAuxEffect(i11);
            }
            if (i11 != 0) {
                this.f24612u.setAuxEffectSendLevel(f11);
            }
        }
        this.X = uVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void k(u1 u1Var) {
        this.f24608q = u1Var;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void l(o1 o1Var, int i11, int[] iArr) {
        int i12;
        AudioProcessor[] audioProcessorArr;
        int i13;
        int intValue;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int a11;
        int[] iArr2;
        if (MimeTypes.AUDIO_RAW.equals(o1Var.f25550l)) {
            com.google.android.exoplayer2.util.a.a(p0.u0(o1Var.A));
            int e02 = p0.e0(o1Var.A, o1Var.f25563y);
            AudioProcessor[] audioProcessorArr2 = a0(o1Var.A) ? this.f24598g : this.f24597f;
            this.f24596e.j(o1Var.B, o1Var.C);
            if (p0.f27680a < 21 && o1Var.f25563y == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i19 = 0; i19 < 6; i19++) {
                    iArr2[i19] = i19;
                }
            } else {
                iArr2 = iArr;
            }
            this.f24595d.h(iArr2);
            AudioProcessor.a aVar = new AudioProcessor.a(o1Var.f25564z, o1Var.f25563y, o1Var.A);
            for (AudioProcessor audioProcessor : audioProcessorArr2) {
                try {
                    AudioProcessor.a a12 = audioProcessor.a(aVar);
                    if (audioProcessor.isActive()) {
                        aVar = a12;
                    }
                } catch (AudioProcessor.UnhandledAudioFormatException e11) {
                    throw new AudioSink.ConfigurationException(e11, o1Var);
                }
            }
            int i20 = aVar.f24587c;
            int i21 = aVar.f24585a;
            int G = p0.G(aVar.f24586b);
            audioProcessorArr = audioProcessorArr2;
            i15 = p0.e0(i20, aVar.f24586b);
            i16 = i20;
            i13 = i21;
            intValue = G;
            i14 = e02;
            i17 = 0;
        } else {
            AudioProcessor[] audioProcessorArr3 = new AudioProcessor[0];
            int i22 = o1Var.f25564z;
            if (b0(o1Var, this.f24613v)) {
                i12 = 1;
                audioProcessorArr = audioProcessorArr3;
                i13 = i22;
                i16 = com.google.android.exoplayer2.util.w.f((String) com.google.android.exoplayer2.util.a.e(o1Var.f25550l), o1Var.f25547i);
                i14 = -1;
                i15 = -1;
                intValue = p0.G(o1Var.f25563y);
            } else {
                Pair f11 = this.f24590a.f(o1Var);
                if (f11 == null) {
                    throw new AudioSink.ConfigurationException("Unable to configure passthrough for: " + o1Var, o1Var);
                }
                int intValue2 = ((Integer) f11.first).intValue();
                i12 = 2;
                audioProcessorArr = audioProcessorArr3;
                i13 = i22;
                intValue = ((Integer) f11.second).intValue();
                i14 = -1;
                i15 = -1;
                i16 = intValue2;
            }
            i17 = i12;
        }
        if (i11 != 0) {
            a11 = i11;
            i18 = i16;
        } else {
            i18 = i16;
            a11 = this.f24607p.a(D(i13, intValue, i16), i16, i17, i15, i13, this.f24602k ? 8.0d : 1.0d);
        }
        if (i18 == 0) {
            throw new AudioSink.ConfigurationException("Invalid output encoding (mode=" + i17 + ") for: " + o1Var, o1Var);
        }
        if (intValue == 0) {
            throw new AudioSink.ConfigurationException("Invalid output channel config (mode=" + i17 + ") for: " + o1Var, o1Var);
        }
        this.f24591a0 = false;
        e eVar = new e(o1Var, i14, i17, i15, i13, intValue, i18, a11, audioProcessorArr);
        if (M()) {
            this.f24610s = eVar;
        } else {
            this.f24611t = eVar;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.U = false;
        if (M() && this.f24600i.p()) {
            this.f24612u.pause();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.U = true;
        if (M()) {
            this.f24600i.u();
            this.f24612u.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void playToEndOfStream() {
        if (!this.S && M() && z()) {
            P();
            this.S = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        flush();
        for (AudioProcessor audioProcessor : this.f24597f) {
            audioProcessor.reset();
        }
        for (AudioProcessor audioProcessor2 : this.f24598g) {
            audioProcessor2.reset();
        }
        this.U = false;
        this.f24591a0 = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioSessionId(int i11) {
        if (this.W != i11) {
            this.W = i11;
            this.V = i11 != 0;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f11) {
        if (this.J != f11) {
            this.J = f11;
            V();
        }
    }
}
