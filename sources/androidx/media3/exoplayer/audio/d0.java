package androidx.media3.exoplayer.audio;

import android.media.AudioDeviceInfo;
import android.os.Handler;
import android.os.SystemClock;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoderOutputBuffer;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.audio.x;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.s2;
import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.x2;
import androidx.media3.exoplayer.x3;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import org.mvel2.ast.ASTNode;

/* loaded from: classes2.dex */
public abstract class d0 extends androidx.media3.exoplayer.i implements x2 {
    private DecoderInputBuffer A;
    private SimpleDecoderOutputBuffer B;
    private DrmSession C;
    private DrmSession D;
    private int E;
    private boolean F;
    private boolean G;
    private long H;
    private boolean I;
    private boolean J;
    private boolean K;
    private long L;
    private final long[] M;
    private int N;
    private boolean O;
    private boolean P;
    private long Q;
    private long R;
    private long S;
    private boolean T;

    /* renamed from: r, reason: collision with root package name */
    private final x.a f11220r;

    /* renamed from: s, reason: collision with root package name */
    private final AudioSink f11221s;

    /* renamed from: t, reason: collision with root package name */
    private final DecoderInputBuffer f11222t;

    /* renamed from: u, reason: collision with root package name */
    private androidx.media3.exoplayer.j f11223u;

    /* renamed from: v, reason: collision with root package name */
    private androidx.media3.common.r f11224v;

    /* renamed from: w, reason: collision with root package name */
    private int f11225w;

    /* renamed from: x, reason: collision with root package name */
    private int f11226x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f11227y;

    /* renamed from: z, reason: collision with root package name */
    private androidx.media3.decoder.g f11228z;

    /* loaded from: classes2.dex */
    private static final class b {
        public static void a(AudioSink audioSink, Object obj) {
            audioSink.h((AudioDeviceInfo) obj);
        }
    }

    /* loaded from: classes2.dex */
    private final class c implements AudioSink.b {
        private c() {
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void a(Exception exc) {
            androidx.media3.common.util.u.d("DecoderAudioRenderer", "Audio sink error", exc);
            d0.this.f11220r.n(exc);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void b(long j11) {
            d0.this.f11220r.H(j11);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public /* synthetic */ void c() {
            z.c(this);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public /* synthetic */ void d() {
            z.b(this);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void e() {
            d0.this.O = true;
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public /* synthetic */ void f() {
            z.a(this);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void j(AudioSink.a aVar) {
            d0.this.f11220r.o(aVar);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void k(AudioSink.a aVar) {
            d0.this.f11220r.p(aVar);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void onPositionDiscontinuity() {
            d0.this.c0();
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void onSkipSilenceEnabledChanged(boolean z10) {
            d0.this.f11220r.I(z10);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void onUnderrun(int i11, long j11, long j12) {
            d0.this.f11220r.J(i11, j11, j12);
        }
    }

    public d0() {
        this((Handler) null, (x) null, new AudioProcessor[0]);
    }

    public d0(Handler handler, x xVar, AudioSink audioSink) {
        super(1);
        this.f11220r = new x.a(handler, xVar);
        this.f11221s = audioSink;
        audioSink.j(new c());
        this.f11222t = DecoderInputBuffer.f();
        this.E = 0;
        this.G = true;
        h0(C.TIME_UNSET);
        this.M = new long[10];
        this.Q = C.TIME_UNSET;
        this.R = C.TIME_UNSET;
        this.S = C.TIME_UNSET;
    }

    public d0(Handler handler, x xVar, e eVar, AudioProcessor... audioProcessorArr) {
        this(handler, xVar, new DefaultAudioSink.g().k((e) com.google.common.base.h.a(eVar, e.f11244c)).m(audioProcessorArr).j());
    }

    public d0(Handler handler, x xVar, AudioProcessor... audioProcessorArr) {
        this(handler, xVar, null, audioProcessorArr);
    }

    private boolean U() {
        if (this.B == null) {
            SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = (SimpleDecoderOutputBuffer) this.f11228z.dequeueOutputBuffer();
            this.B = simpleDecoderOutputBuffer;
            if (simpleDecoderOutputBuffer == null) {
                return false;
            }
            int i11 = simpleDecoderOutputBuffer.skippedOutputBufferCount;
            if (i11 > 0) {
                this.f11223u.f12118f += i11;
                this.f11221s.handleDiscontinuity();
            }
            if (this.B.isFirstSample()) {
                e0();
            }
        }
        if (this.B.isEndOfStream()) {
            if (this.E == 2) {
                f0();
                a0();
                this.G = true;
            } else {
                this.B.release();
                this.B = null;
                try {
                    d0();
                } catch (AudioSink.WriteException e11) {
                    throw r(e11, e11.format, e11.isRecoverable, 5002);
                }
            }
            return false;
        }
        this.S = C.TIME_UNSET;
        if (this.G) {
            this.f11221s.l(Y(this.f11228z).b().Z(this.f11225w).a0(this.f11226x).n0(this.f11224v.f10240l).X(this.f11224v.f10241m).f0(this.f11224v.f10229a).h0(this.f11224v.f10230b).i0(this.f11224v.f10231c).j0(this.f11224v.f10232d).w0(this.f11224v.f10233e).s0(this.f11224v.f10234f).N(), 0, X(this.f11228z));
            this.G = false;
        }
        AudioSink audioSink = this.f11221s;
        SimpleDecoderOutputBuffer simpleDecoderOutputBuffer2 = this.B;
        if (!audioSink.c(simpleDecoderOutputBuffer2.f11021b, simpleDecoderOutputBuffer2.timeUs, 1)) {
            this.S = this.B.timeUs;
            return false;
        }
        this.f11223u.f12117e++;
        this.B.release();
        this.B = null;
        return true;
    }

    private boolean V() {
        androidx.media3.decoder.g gVar = this.f11228z;
        if (gVar == null || this.E == 2 || this.J) {
            return false;
        }
        if (this.A == null) {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) gVar.dequeueInputBuffer();
            this.A = decoderInputBuffer;
            if (decoderInputBuffer == null) {
                return false;
            }
        }
        if (this.E == 1) {
            this.A.setFlags(4);
            this.f11228z.queueInputBuffer(this.A);
            this.A = null;
            this.E = 2;
            return false;
        }
        s2 u11 = u();
        int N = N(u11, this.A, 0);
        if (N == -5) {
            b0(u11);
            return true;
        }
        if (N != -4) {
            if (N != -3) {
                throw new IllegalStateException();
            }
            if (hasReadStreamToEnd()) {
                this.R = this.Q;
            }
            return false;
        }
        if (this.A.isEndOfStream()) {
            this.J = true;
            this.R = this.Q;
            this.f11228z.queueInputBuffer(this.A);
            this.A = null;
            return false;
        }
        if (!this.f11227y) {
            this.f11227y = true;
            this.A.addFlag(ASTNode.NOJIT);
        }
        this.Q = this.A.f11002e;
        if (hasReadStreamToEnd() || this.A.isLastSample()) {
            this.R = this.Q;
        }
        this.A.d();
        DecoderInputBuffer decoderInputBuffer2 = this.A;
        decoderInputBuffer2.f10998a = this.f11224v;
        this.f11228z.queueInputBuffer(decoderInputBuffer2);
        this.F = true;
        this.f11223u.f12115c++;
        this.A = null;
        return true;
    }

    private void W() {
        if (this.E != 0) {
            f0();
            a0();
            return;
        }
        this.A = null;
        SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = this.B;
        if (simpleDecoderOutputBuffer != null) {
            simpleDecoderOutputBuffer.release();
            this.B = null;
        }
        androidx.media3.decoder.g gVar = (androidx.media3.decoder.g) androidx.media3.common.util.a.e(this.f11228z);
        gVar.flush();
        gVar.a(w());
        this.F = false;
    }

    private void a0() {
        androidx.media3.decoder.b bVar;
        if (this.f11228z != null) {
            return;
        }
        g0(this.D);
        DrmSession drmSession = this.C;
        if (drmSession != null) {
            bVar = drmSession.c();
            if (bVar == null && this.C.getError() == null) {
                return;
            }
        } else {
            bVar = null;
        }
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            androidx.media3.common.util.q0.a("createAudioDecoder");
            androidx.media3.decoder.g T = T(this.f11224v, bVar);
            this.f11228z = T;
            T.a(w());
            androidx.media3.common.util.q0.b();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            this.f11220r.q(this.f11228z.getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
            this.f11223u.f12113a++;
        } catch (DecoderException e11) {
            androidx.media3.common.util.u.d("DecoderAudioRenderer", "Audio codec error", e11);
            this.f11220r.m(e11);
            throw q(e11, this.f11224v, 4001);
        } catch (OutOfMemoryError e12) {
            throw q(e12, this.f11224v, 4001);
        }
    }

    private void b0(s2 s2Var) {
        androidx.media3.common.r rVar = (androidx.media3.common.r) androidx.media3.common.util.a.e(s2Var.f12652b);
        i0(s2Var.f12651a);
        androidx.media3.common.r rVar2 = this.f11224v;
        this.f11224v = rVar;
        this.f11225w = rVar.H;
        this.f11226x = rVar.I;
        androidx.media3.decoder.g gVar = this.f11228z;
        if (gVar == null) {
            a0();
            this.f11220r.u(this.f11224v, null);
            return;
        }
        androidx.media3.exoplayer.k kVar = this.D != this.C ? new androidx.media3.exoplayer.k(gVar.getName(), rVar2, rVar, 0, 128) : S(gVar.getName(), rVar2, rVar);
        if (kVar.f12135d == 0) {
            if (this.F) {
                this.E = 1;
            } else {
                f0();
                a0();
                this.G = true;
            }
        }
        this.f11220r.u(this.f11224v, kVar);
    }

    private void d0() {
        this.K = true;
        this.f11221s.playToEndOfStream();
        this.S = this.R;
        this.T = true;
    }

    private void e0() {
        this.f11221s.handleDiscontinuity();
        if (this.N != 0) {
            h0(this.M[0]);
            int i11 = this.N - 1;
            this.N = i11;
            long[] jArr = this.M;
            System.arraycopy(jArr, 1, jArr, 0, i11);
        }
    }

    private void f0() {
        this.A = null;
        this.B = null;
        this.E = 0;
        this.F = false;
        this.Q = C.TIME_UNSET;
        this.R = C.TIME_UNSET;
        androidx.media3.decoder.g gVar = this.f11228z;
        if (gVar != null) {
            this.f11223u.f12114b++;
            gVar.release();
            this.f11220r.r(this.f11228z.getName());
            this.f11228z = null;
        }
        g0(null);
    }

    private void g0(DrmSession drmSession) {
        androidx.media3.exoplayer.drm.k.a(this.C, drmSession);
        this.C = drmSession;
    }

    private void h0(long j11) {
        this.L = j11;
        if (j11 != C.TIME_UNSET) {
            this.f11221s.n(j11);
        }
    }

    private void i0(DrmSession drmSession) {
        androidx.media3.exoplayer.drm.k.a(this.D, drmSession);
        this.D = drmSession;
    }

    private void l0() {
        long currentPositionUs = this.f11221s.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.I) {
                currentPositionUs = Math.max(this.H, currentPositionUs);
            }
            this.H = currentPositionUs;
            this.I = false;
        }
    }

    @Override // androidx.media3.exoplayer.i
    protected void C() {
        this.f11224v = null;
        this.G = true;
        h0(C.TIME_UNSET);
        this.O = false;
        this.S = C.TIME_UNSET;
        this.T = false;
        try {
            i0(null);
            f0();
            this.f11221s.reset();
        } finally {
            this.f11220r.s(this.f11223u);
        }
    }

    @Override // androidx.media3.exoplayer.i
    protected void D(boolean z10, boolean z11) {
        androidx.media3.exoplayer.j jVar = new androidx.media3.exoplayer.j();
        this.f11223u = jVar;
        this.f11220r.t(jVar);
        if (t().f13482b) {
            this.f11221s.d();
        } else {
            this.f11221s.disableTunneling();
        }
        this.f11221s.p(x());
        this.f11221s.r(s());
    }

    @Override // androidx.media3.exoplayer.i
    protected void F(long j11, boolean z10) {
        this.f11221s.flush();
        this.H = j11;
        this.S = C.TIME_UNSET;
        this.T = false;
        this.O = false;
        this.I = true;
        this.J = false;
        this.K = false;
        if (this.f11228z != null) {
            W();
        }
    }

    @Override // androidx.media3.exoplayer.i
    protected void J() {
        this.f11221s.play();
        this.P = true;
    }

    @Override // androidx.media3.exoplayer.i
    protected void K() {
        l0();
        this.f11221s.pause();
        this.P = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.i
    public void L(androidx.media3.common.r[] rVarArr, long j11, long j12, r.b bVar) {
        super.L(rVarArr, j11, j12, bVar);
        this.f11227y = false;
        if (this.L == C.TIME_UNSET) {
            h0(j12);
            return;
        }
        int i11 = this.N;
        if (i11 == this.M.length) {
            androidx.media3.common.util.u.h("DecoderAudioRenderer", "Too many stream changes, so dropping offset: " + this.M[this.N - 1]);
        } else {
            this.N = i11 + 1;
        }
        this.M[this.N - 1] = j12;
    }

    protected androidx.media3.exoplayer.k S(String str, androidx.media3.common.r rVar, androidx.media3.common.r rVar2) {
        return new androidx.media3.exoplayer.k(str, rVar, rVar2, 0, 1);
    }

    protected abstract androidx.media3.decoder.g T(androidx.media3.common.r rVar, androidx.media3.decoder.b bVar);

    protected int[] X(androidx.media3.decoder.g gVar) {
        return null;
    }

    protected abstract androidx.media3.common.r Y(androidx.media3.decoder.g gVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public final int Z(androidx.media3.common.r rVar) {
        return this.f11221s.o(rVar);
    }

    @Override // androidx.media3.exoplayer.y3
    public final int a(androidx.media3.common.r rVar) {
        if (!androidx.media3.common.y.o(rVar.f10243o)) {
            return x3.a(0);
        }
        int k02 = k0(rVar);
        return k02 <= 2 ? x3.a(k02) : x3.b(k02, 8, 32);
    }

    @Override // androidx.media3.exoplayer.x2
    public void b(androidx.media3.common.z zVar) {
        this.f11221s.b(zVar);
    }

    protected void c0() {
        this.I = true;
    }

    @Override // androidx.media3.exoplayer.i, androidx.media3.exoplayer.w3
    public x2 getMediaClock() {
        return this;
    }

    @Override // androidx.media3.exoplayer.x2
    public androidx.media3.common.z getPlaybackParameters() {
        return this.f11221s.getPlaybackParameters();
    }

    @Override // androidx.media3.exoplayer.x2
    public long getPositionUs() {
        if (getState() == 2) {
            l0();
        }
        return this.H;
    }

    @Override // androidx.media3.exoplayer.i, androidx.media3.exoplayer.t3.b
    public void handleMessage(int i11, Object obj) {
        if (i11 == 2) {
            this.f11221s.setVolume(((Float) obj).floatValue());
            return;
        }
        if (i11 == 3) {
            this.f11221s.f((androidx.media3.common.c) obj);
            return;
        }
        if (i11 == 6) {
            this.f11221s.q((androidx.media3.common.f) obj);
            return;
        }
        if (i11 == 12) {
            if (androidx.media3.common.util.a1.f10432a >= 23) {
                b.a(this.f11221s, obj);
            }
        } else if (i11 == 9) {
            this.f11221s.e(((Boolean) obj).booleanValue());
        } else if (i11 != 10) {
            super.handleMessage(i11, obj);
        } else {
            this.f11221s.setAudioSessionId(((Integer) obj).intValue());
        }
    }

    @Override // androidx.media3.exoplayer.x2
    public boolean i() {
        boolean z10 = this.O;
        this.O = false;
        return z10;
    }

    @Override // androidx.media3.exoplayer.w3
    public boolean isEnded() {
        return this.K && this.f11221s.isEnded();
    }

    @Override // androidx.media3.exoplayer.w3
    public boolean isReady() {
        return this.f11221s.hasPendingData() || (this.f11224v != null && (B() || this.B != null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean j0(androidx.media3.common.r rVar) {
        return this.f11221s.a(rVar);
    }

    protected abstract int k0(androidx.media3.common.r rVar);

    @Override // androidx.media3.exoplayer.i, androidx.media3.exoplayer.w3
    public long l(long j11, long j12) {
        if (this.S == C.TIME_UNSET) {
            return super.l(j11, j12);
        }
        long i11 = this.f11221s.i();
        if (!this.T && i11 == C.TIME_UNSET) {
            return super.l(j11, j12);
        }
        long j13 = this.S - j11;
        if (i11 != C.TIME_UNSET) {
            j13 = Math.min(i11, j13);
        }
        long j14 = (((float) j13) / (getPlaybackParameters() != null ? getPlaybackParameters().f10648a : 1.0f)) / 2.0f;
        if (this.P) {
            j14 -= androidx.media3.common.util.a1.R0(s().elapsedRealtime()) - j12;
        }
        return Math.max(10000L, j14);
    }

    @Override // androidx.media3.exoplayer.w3
    public void render(long j11, long j12) {
        if (this.K) {
            try {
                this.f11221s.playToEndOfStream();
                this.S = this.R;
                this.T = true;
                return;
            } catch (AudioSink.WriteException e11) {
                throw r(e11, e11.format, e11.isRecoverable, 5002);
            }
        }
        if (this.f11224v == null) {
            s2 u11 = u();
            this.f11222t.clear();
            int N = N(u11, this.f11222t, 2);
            if (N != -5) {
                if (N == -4) {
                    androidx.media3.common.util.a.g(this.f11222t.isEndOfStream());
                    this.J = true;
                    try {
                        d0();
                        return;
                    } catch (AudioSink.WriteException e12) {
                        throw q(e12, null, 5002);
                    }
                }
                return;
            }
            b0(u11);
        }
        a0();
        if (this.f11228z != null) {
            try {
                androidx.media3.common.util.q0.a("drainAndFeed");
                do {
                } while (U());
                do {
                } while (V());
                androidx.media3.common.util.q0.b();
                this.f11223u.c();
            } catch (DecoderException e13) {
                androidx.media3.common.util.u.d("DecoderAudioRenderer", "Audio codec error", e13);
                this.f11220r.m(e13);
                throw q(e13, this.f11224v, 4003);
            } catch (AudioSink.ConfigurationException e14) {
                throw q(e14, e14.format, 5001);
            } catch (AudioSink.InitializationException e15) {
                throw r(e15, e15.format, e15.isRecoverable, 5001);
            } catch (AudioSink.WriteException e16) {
                throw r(e16, e16.format, e16.isRecoverable, 5002);
            }
        }
    }
}
