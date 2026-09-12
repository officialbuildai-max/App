package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
final class t {
    private long A;
    private long B;
    private long C;
    private boolean D;
    private long E;
    private long F;

    /* renamed from: a, reason: collision with root package name */
    private final a f24802a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f24803b;

    /* renamed from: c, reason: collision with root package name */
    private AudioTrack f24804c;

    /* renamed from: d, reason: collision with root package name */
    private int f24805d;

    /* renamed from: e, reason: collision with root package name */
    private int f24806e;

    /* renamed from: f, reason: collision with root package name */
    private s f24807f;

    /* renamed from: g, reason: collision with root package name */
    private int f24808g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f24809h;

    /* renamed from: i, reason: collision with root package name */
    private long f24810i;

    /* renamed from: j, reason: collision with root package name */
    private float f24811j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f24812k;

    /* renamed from: l, reason: collision with root package name */
    private long f24813l;

    /* renamed from: m, reason: collision with root package name */
    private long f24814m;

    /* renamed from: n, reason: collision with root package name */
    private Method f24815n;

    /* renamed from: o, reason: collision with root package name */
    private long f24816o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f24817p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f24818q;

    /* renamed from: r, reason: collision with root package name */
    private long f24819r;

    /* renamed from: s, reason: collision with root package name */
    private long f24820s;

    /* renamed from: t, reason: collision with root package name */
    private long f24821t;

    /* renamed from: u, reason: collision with root package name */
    private long f24822u;

    /* renamed from: v, reason: collision with root package name */
    private int f24823v;

    /* renamed from: w, reason: collision with root package name */
    private int f24824w;

    /* renamed from: x, reason: collision with root package name */
    private long f24825x;

    /* renamed from: y, reason: collision with root package name */
    private long f24826y;

    /* renamed from: z, reason: collision with root package name */
    private long f24827z;

    /* loaded from: classes3.dex */
    public interface a {
        void b(long j11);

        void onInvalidLatency(long j11);

        void onPositionFramesMismatch(long j11, long j12, long j13, long j14);

        void onSystemTimeUsMismatch(long j11, long j12, long j13, long j14);

        void onUnderrun(int i11, long j11);
    }

    public t(a aVar) {
        this.f24802a = (a) com.google.android.exoplayer2.util.a.e(aVar);
        if (p0.f27680a >= 18) {
            try {
                this.f24815n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f24803b = new long[10];
    }

    private boolean a() {
        return this.f24809h && ((AudioTrack) com.google.android.exoplayer2.util.a.e(this.f24804c)).getPlayState() == 2 && e() == 0;
    }

    private long b(long j11) {
        return (j11 * 1000000) / this.f24808g;
    }

    private long e() {
        AudioTrack audioTrack = (AudioTrack) com.google.android.exoplayer2.util.a.e(this.f24804c);
        if (this.f24825x != C.TIME_UNSET) {
            return Math.min(this.A, this.f24827z + ((((SystemClock.elapsedRealtime() * 1000) - this.f24825x) * this.f24808g) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = audioTrack.getPlaybackHeadPosition() & 4294967295L;
        if (this.f24809h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f24822u = this.f24820s;
            }
            playbackHeadPosition += this.f24822u;
        }
        if (p0.f27680a <= 29) {
            if (playbackHeadPosition == 0 && this.f24820s > 0 && playState == 3) {
                if (this.f24826y == C.TIME_UNSET) {
                    this.f24826y = SystemClock.elapsedRealtime();
                }
                return this.f24820s;
            }
            this.f24826y = C.TIME_UNSET;
        }
        if (this.f24820s > playbackHeadPosition) {
            this.f24821t++;
        }
        this.f24820s = playbackHeadPosition;
        return playbackHeadPosition + (this.f24821t << 32);
    }

    private long f() {
        return b(e());
    }

    private void l(long j11, long j12) {
        s sVar = (s) com.google.android.exoplayer2.util.a.e(this.f24807f);
        if (sVar.e(j11)) {
            long c11 = sVar.c();
            long b11 = sVar.b();
            if (Math.abs(c11 - j11) > 5000000) {
                this.f24802a.onSystemTimeUsMismatch(b11, c11, j11, j12);
                sVar.f();
            } else if (Math.abs(b(b11) - j12) <= 5000000) {
                sVar.a();
            } else {
                this.f24802a.onPositionFramesMismatch(b11, c11, j11, j12);
                sVar.f();
            }
        }
    }

    private void m() {
        long f11 = f();
        if (f11 == 0) {
            return;
        }
        long nanoTime = System.nanoTime() / 1000;
        if (nanoTime - this.f24814m >= 30000) {
            long[] jArr = this.f24803b;
            int i11 = this.f24823v;
            jArr[i11] = f11 - nanoTime;
            this.f24823v = (i11 + 1) % 10;
            int i12 = this.f24824w;
            if (i12 < 10) {
                this.f24824w = i12 + 1;
            }
            this.f24814m = nanoTime;
            this.f24813l = 0L;
            int i13 = 0;
            while (true) {
                int i14 = this.f24824w;
                if (i13 >= i14) {
                    break;
                }
                this.f24813l += this.f24803b[i13] / i14;
                i13++;
            }
        }
        if (this.f24809h) {
            return;
        }
        l(nanoTime, f11);
        n(nanoTime);
    }

    private void n(long j11) {
        Method method;
        if (!this.f24818q || (method = this.f24815n) == null || j11 - this.f24819r < 500000) {
            return;
        }
        try {
            long intValue = (((Integer) p0.j((Integer) method.invoke(com.google.android.exoplayer2.util.a.e(this.f24804c), null))).intValue() * 1000) - this.f24810i;
            this.f24816o = intValue;
            long max = Math.max(intValue, 0L);
            this.f24816o = max;
            if (max > 5000000) {
                this.f24802a.onInvalidLatency(max);
                this.f24816o = 0L;
            }
        } catch (Exception unused) {
            this.f24815n = null;
        }
        this.f24819r = j11;
    }

    private static boolean o(int i11) {
        return p0.f27680a < 23 && (i11 == 5 || i11 == 6);
    }

    private void r() {
        this.f24813l = 0L;
        this.f24824w = 0;
        this.f24823v = 0;
        this.f24814m = 0L;
        this.C = 0L;
        this.F = 0L;
        this.f24812k = false;
    }

    public int c(long j11) {
        return this.f24806e - ((int) (j11 - (e() * this.f24805d)));
    }

    public long d(boolean z10) {
        long f11;
        if (((AudioTrack) com.google.android.exoplayer2.util.a.e(this.f24804c)).getPlayState() == 3) {
            m();
        }
        long nanoTime = System.nanoTime() / 1000;
        s sVar = (s) com.google.android.exoplayer2.util.a.e(this.f24807f);
        boolean d11 = sVar.d();
        if (d11) {
            f11 = b(sVar.b()) + p0.a0(nanoTime - sVar.c(), this.f24811j);
        } else {
            f11 = this.f24824w == 0 ? f() : this.f24813l + nanoTime;
            if (!z10) {
                f11 = Math.max(0L, f11 - this.f24816o);
            }
        }
        if (this.D != d11) {
            this.F = this.C;
            this.E = this.B;
        }
        long j11 = nanoTime - this.F;
        if (j11 < 1000000) {
            long a02 = this.E + p0.a0(j11, this.f24811j);
            long j12 = (j11 * 1000) / 1000000;
            f11 = ((f11 * j12) + ((1000 - j12) * a02)) / 1000;
        }
        if (!this.f24812k) {
            long j13 = this.B;
            if (f11 > j13) {
                this.f24812k = true;
                this.f24802a.b(System.currentTimeMillis() - p0.e1(p0.f0(p0.e1(f11 - j13), this.f24811j)));
            }
        }
        this.C = nanoTime;
        this.B = f11;
        this.D = d11;
        return f11;
    }

    public void g(long j11) {
        this.f24827z = e();
        this.f24825x = SystemClock.elapsedRealtime() * 1000;
        this.A = j11;
    }

    public boolean h(long j11) {
        return j11 > e() || a();
    }

    public boolean i() {
        return ((AudioTrack) com.google.android.exoplayer2.util.a.e(this.f24804c)).getPlayState() == 3;
    }

    public boolean j(long j11) {
        return this.f24826y != C.TIME_UNSET && j11 > 0 && SystemClock.elapsedRealtime() - this.f24826y >= 200;
    }

    public boolean k(long j11) {
        int playState = ((AudioTrack) com.google.android.exoplayer2.util.a.e(this.f24804c)).getPlayState();
        if (this.f24809h) {
            if (playState == 2) {
                this.f24817p = false;
                return false;
            }
            if (playState == 1 && e() == 0) {
                return false;
            }
        }
        boolean z10 = this.f24817p;
        boolean h11 = h(j11);
        this.f24817p = h11;
        if (z10 && !h11 && playState != 1) {
            this.f24802a.onUnderrun(this.f24806e, p0.e1(this.f24810i));
        }
        return true;
    }

    public boolean p() {
        r();
        if (this.f24825x != C.TIME_UNSET) {
            return false;
        }
        ((s) com.google.android.exoplayer2.util.a.e(this.f24807f)).g();
        return true;
    }

    public void q() {
        r();
        this.f24804c = null;
        this.f24807f = null;
    }

    public void s(AudioTrack audioTrack, boolean z10, int i11, int i12, int i13) {
        this.f24804c = audioTrack;
        this.f24805d = i12;
        this.f24806e = i13;
        this.f24807f = new s(audioTrack);
        this.f24808g = audioTrack.getSampleRate();
        this.f24809h = z10 && o(i11);
        boolean u02 = p0.u0(i11);
        this.f24818q = u02;
        this.f24810i = u02 ? b(i13 / i12) : -9223372036854775807L;
        this.f24820s = 0L;
        this.f24821t = 0L;
        this.f24822u = 0L;
        this.f24817p = false;
        this.f24825x = C.TIME_UNSET;
        this.f24826y = C.TIME_UNSET;
        this.f24819r = 0L;
        this.f24816o = 0L;
        this.f24811j = 1.0f;
    }

    public void t(float f11) {
        this.f24811j = f11;
        s sVar = this.f24807f;
        if (sVar != null) {
            sVar.g();
        }
    }

    public void u() {
        ((s) com.google.android.exoplayer2.util.a.e(this.f24807f)).g();
    }
}
