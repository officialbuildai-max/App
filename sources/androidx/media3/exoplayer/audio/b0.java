package androidx.media3.exoplayer.audio;

import android.media.AudioTrack;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
final class b0 {
    private long A;
    private long B;
    private long C;
    private long D;
    private boolean E;
    private long F;
    private long G;
    private boolean H;
    private long I;
    private androidx.media3.common.util.i J;

    /* renamed from: a, reason: collision with root package name */
    private final a f11187a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f11188b;

    /* renamed from: c, reason: collision with root package name */
    private AudioTrack f11189c;

    /* renamed from: d, reason: collision with root package name */
    private int f11190d;

    /* renamed from: e, reason: collision with root package name */
    private int f11191e;

    /* renamed from: f, reason: collision with root package name */
    private a0 f11192f;

    /* renamed from: g, reason: collision with root package name */
    private int f11193g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f11194h;

    /* renamed from: i, reason: collision with root package name */
    private long f11195i;

    /* renamed from: j, reason: collision with root package name */
    private float f11196j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f11197k;

    /* renamed from: l, reason: collision with root package name */
    private long f11198l;

    /* renamed from: m, reason: collision with root package name */
    private long f11199m;

    /* renamed from: n, reason: collision with root package name */
    private Method f11200n;

    /* renamed from: o, reason: collision with root package name */
    private long f11201o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f11202p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f11203q;

    /* renamed from: r, reason: collision with root package name */
    private long f11204r;

    /* renamed from: s, reason: collision with root package name */
    private long f11205s;

    /* renamed from: t, reason: collision with root package name */
    private long f11206t;

    /* renamed from: u, reason: collision with root package name */
    private long f11207u;

    /* renamed from: v, reason: collision with root package name */
    private long f11208v;

    /* renamed from: w, reason: collision with root package name */
    private int f11209w;

    /* renamed from: x, reason: collision with root package name */
    private int f11210x;

    /* renamed from: y, reason: collision with root package name */
    private long f11211y;

    /* renamed from: z, reason: collision with root package name */
    private long f11212z;

    /* loaded from: classes2.dex */
    public interface a {
        void b(long j11);

        void onInvalidLatency(long j11);

        void onPositionFramesMismatch(long j11, long j12, long j13, long j14);

        void onSystemTimeUsMismatch(long j11, long j12, long j13, long j14);

        void onUnderrun(int i11, long j11);
    }

    public b0(a aVar) {
        this.f11187a = (a) androidx.media3.common.util.a.e(aVar);
        try {
            this.f11200n = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.f11188b = new long[10];
        this.J = androidx.media3.common.util.i.f10469a;
    }

    private boolean b() {
        return this.f11194h && ((AudioTrack) androidx.media3.common.util.a.e(this.f11189c)).getPlayState() == 2 && d() == 0;
    }

    private long d() {
        if (this.f11211y != C.TIME_UNSET) {
            return Math.min(this.B, f());
        }
        long elapsedRealtime = this.J.elapsedRealtime();
        if (elapsedRealtime - this.f11205s >= 5) {
            w(elapsedRealtime);
            this.f11205s = elapsedRealtime;
        }
        return this.f11206t + this.I + (this.f11207u << 32);
    }

    private long e() {
        return androidx.media3.common.util.a1.d1(d(), this.f11193g);
    }

    private long f() {
        if (((AudioTrack) androidx.media3.common.util.a.e(this.f11189c)).getPlayState() == 2) {
            return this.A;
        }
        return this.A + androidx.media3.common.util.a1.F(androidx.media3.common.util.a1.g0(androidx.media3.common.util.a1.R0(this.J.elapsedRealtime()) - this.f11211y, this.f11196j), this.f11193g);
    }

    private void l(long j11) {
        a0 a0Var = (a0) androidx.media3.common.util.a.e(this.f11192f);
        if (a0Var.f(j11)) {
            long d11 = a0Var.d();
            long c11 = a0Var.c();
            long e11 = e();
            if (Math.abs(d11 - j11) > 5000000) {
                this.f11187a.onSystemTimeUsMismatch(c11, d11, j11, e11);
                a0Var.g();
            } else if (Math.abs(androidx.media3.common.util.a1.d1(c11, this.f11193g) - e11) <= 5000000) {
                a0Var.a();
            } else {
                this.f11187a.onPositionFramesMismatch(c11, d11, j11, e11);
                a0Var.g();
            }
        }
    }

    private void m() {
        long nanoTime = this.J.nanoTime() / 1000;
        if (nanoTime - this.f11199m >= 30000) {
            long e11 = e();
            if (e11 != 0) {
                this.f11188b[this.f11209w] = androidx.media3.common.util.a1.l0(e11, this.f11196j) - nanoTime;
                this.f11209w = (this.f11209w + 1) % 10;
                int i11 = this.f11210x;
                if (i11 < 10) {
                    this.f11210x = i11 + 1;
                }
                this.f11199m = nanoTime;
                this.f11198l = 0L;
                int i12 = 0;
                while (true) {
                    int i13 = this.f11210x;
                    if (i12 >= i13) {
                        break;
                    }
                    this.f11198l += this.f11188b[i12] / i13;
                    i12++;
                }
            } else {
                return;
            }
        }
        if (this.f11194h) {
            return;
        }
        l(nanoTime);
        n(nanoTime);
    }

    private void n(long j11) {
        Method method;
        if (!this.f11203q || (method = this.f11200n) == null || j11 - this.f11204r < 500000) {
            return;
        }
        try {
            long intValue = (((Integer) androidx.media3.common.util.a1.i((Integer) method.invoke(androidx.media3.common.util.a.e(this.f11189c), null))).intValue() * 1000) - this.f11195i;
            this.f11201o = intValue;
            long max = Math.max(intValue, 0L);
            this.f11201o = max;
            if (max > 5000000) {
                this.f11187a.onInvalidLatency(max);
                this.f11201o = 0L;
            }
        } catch (Exception unused) {
            this.f11200n = null;
        }
        this.f11204r = j11;
    }

    private static boolean o(int i11) {
        return androidx.media3.common.util.a1.f10432a < 23 && (i11 == 5 || i11 == 6);
    }

    private void r() {
        this.f11198l = 0L;
        this.f11210x = 0;
        this.f11209w = 0;
        this.f11199m = 0L;
        this.D = 0L;
        this.G = 0L;
        this.f11197k = false;
    }

    private void w(long j11) {
        int playState = ((AudioTrack) androidx.media3.common.util.a.e(this.f11189c)).getPlayState();
        if (playState == 1) {
            return;
        }
        long playbackHeadPosition = r0.getPlaybackHeadPosition() & 4294967295L;
        if (this.f11194h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f11208v = this.f11206t;
            }
            playbackHeadPosition += this.f11208v;
        }
        if (androidx.media3.common.util.a1.f10432a <= 29) {
            if (playbackHeadPosition == 0 && this.f11206t > 0 && playState == 3) {
                if (this.f11212z == C.TIME_UNSET) {
                    this.f11212z = j11;
                    return;
                }
                return;
            }
            this.f11212z = C.TIME_UNSET;
        }
        long j12 = this.f11206t;
        if (j12 > playbackHeadPosition) {
            if (this.H) {
                this.I += j12;
                this.H = false;
            } else {
                this.f11207u++;
            }
        }
        this.f11206t = playbackHeadPosition;
    }

    public void a() {
        this.H = true;
        a0 a0Var = this.f11192f;
        if (a0Var != null) {
            a0Var.b();
        }
    }

    public long c() {
        long min;
        AudioTrack audioTrack = (AudioTrack) androidx.media3.common.util.a.e(this.f11189c);
        if (audioTrack.getPlayState() == 3) {
            m();
        }
        long nanoTime = this.J.nanoTime() / 1000;
        a0 a0Var = (a0) androidx.media3.common.util.a.e(this.f11192f);
        boolean e11 = a0Var.e();
        if (e11) {
            min = androidx.media3.common.util.a1.d1(a0Var.c(), this.f11193g) + androidx.media3.common.util.a1.g0(nanoTime - a0Var.d(), this.f11196j);
        } else {
            long max = Math.max(0L, (this.f11210x == 0 ? this.f11211y != C.TIME_UNSET ? androidx.media3.common.util.a1.d1(f(), this.f11193g) : e() : androidx.media3.common.util.a1.g0(this.f11198l + nanoTime, this.f11196j)) - this.f11201o);
            min = this.f11211y != C.TIME_UNSET ? Math.min(androidx.media3.common.util.a1.d1(this.B, this.f11193g), max) : max;
        }
        if (this.E != e11) {
            this.G = this.D;
            this.F = this.C;
        }
        long j11 = nanoTime - this.G;
        if (j11 < 1000000) {
            long g02 = this.F + androidx.media3.common.util.a1.g0(j11, this.f11196j);
            long j12 = (j11 * 1000) / 1000000;
            min = ((min * j12) + ((1000 - j12) * g02)) / 1000;
        }
        if (!this.f11197k && min > this.C && audioTrack.getPlayState() == 3) {
            this.f11197k = true;
            this.f11187a.b(this.J.currentTimeMillis() - androidx.media3.common.util.a1.y1(androidx.media3.common.util.a1.l0(androidx.media3.common.util.a1.y1(min - this.C), this.f11196j)));
        }
        this.D = nanoTime;
        this.C = min;
        this.E = e11;
        return min;
    }

    public void g(long j11) {
        this.A = d();
        this.f11211y = androidx.media3.common.util.a1.R0(this.J.elapsedRealtime());
        this.B = j11;
    }

    public boolean h(long j11) {
        return j11 > androidx.media3.common.util.a1.F(c(), this.f11193g) || b();
    }

    public boolean i() {
        return ((AudioTrack) androidx.media3.common.util.a.e(this.f11189c)).getPlayState() == 3;
    }

    public boolean j(long j11) {
        return this.f11212z != C.TIME_UNSET && j11 > 0 && this.J.elapsedRealtime() - this.f11212z >= 200;
    }

    public boolean k(long j11) {
        int playState = ((AudioTrack) androidx.media3.common.util.a.e(this.f11189c)).getPlayState();
        if (this.f11194h) {
            if (playState == 2) {
                this.f11202p = false;
                return false;
            }
            if (playState == 1 && d() == 0) {
                return false;
            }
        }
        boolean z10 = this.f11202p;
        boolean h11 = h(j11);
        this.f11202p = h11;
        if (z10 && !h11 && playState != 1) {
            this.f11187a.onUnderrun(this.f11191e, androidx.media3.common.util.a1.y1(this.f11195i));
        }
        return true;
    }

    public boolean p() {
        r();
        if (this.f11211y == C.TIME_UNSET) {
            ((a0) androidx.media3.common.util.a.e(this.f11192f)).h();
            return true;
        }
        this.A = d();
        return false;
    }

    public void q() {
        r();
        this.f11189c = null;
        this.f11192f = null;
    }

    public void s(AudioTrack audioTrack, boolean z10, int i11, int i12, int i13) {
        this.f11189c = audioTrack;
        this.f11190d = i12;
        this.f11191e = i13;
        this.f11192f = new a0(audioTrack);
        this.f11193g = audioTrack.getSampleRate();
        this.f11194h = z10 && o(i11);
        boolean G0 = androidx.media3.common.util.a1.G0(i11);
        this.f11203q = G0;
        this.f11195i = G0 ? androidx.media3.common.util.a1.d1(i13 / i12, this.f11193g) : -9223372036854775807L;
        this.f11206t = 0L;
        this.f11207u = 0L;
        this.H = false;
        this.I = 0L;
        this.f11208v = 0L;
        this.f11202p = false;
        this.f11211y = C.TIME_UNSET;
        this.f11212z = C.TIME_UNSET;
        this.f11204r = 0L;
        this.f11201o = 0L;
        this.f11196j = 1.0f;
    }

    public void t(float f11) {
        this.f11196j = f11;
        a0 a0Var = this.f11192f;
        if (a0Var != null) {
            a0Var.h();
        }
        r();
    }

    public void u(androidx.media3.common.util.i iVar) {
        this.J = iVar;
    }

    public void v() {
        if (this.f11211y != C.TIME_UNSET) {
            this.f11211y = androidx.media3.common.util.a1.R0(this.J.elapsedRealtime());
        }
        ((a0) androidx.media3.common.util.a.e(this.f11192f)).h();
    }
}
