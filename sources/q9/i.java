package q9;

import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.Collections;
import q9.i0;

/* loaded from: classes4.dex */
public final class i implements m {

    /* renamed from: v, reason: collision with root package name */
    private static final byte[] f73412v = {73, 68, 51};

    /* renamed from: a, reason: collision with root package name */
    private final boolean f73413a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.c0 f73414b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f73415c;

    /* renamed from: d, reason: collision with root package name */
    private final String f73416d;

    /* renamed from: e, reason: collision with root package name */
    private String f73417e;

    /* renamed from: f, reason: collision with root package name */
    private g9.e0 f73418f;

    /* renamed from: g, reason: collision with root package name */
    private g9.e0 f73419g;

    /* renamed from: h, reason: collision with root package name */
    private int f73420h;

    /* renamed from: i, reason: collision with root package name */
    private int f73421i;

    /* renamed from: j, reason: collision with root package name */
    private int f73422j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f73423k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f73424l;

    /* renamed from: m, reason: collision with root package name */
    private int f73425m;

    /* renamed from: n, reason: collision with root package name */
    private int f73426n;

    /* renamed from: o, reason: collision with root package name */
    private int f73427o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f73428p;

    /* renamed from: q, reason: collision with root package name */
    private long f73429q;

    /* renamed from: r, reason: collision with root package name */
    private int f73430r;

    /* renamed from: s, reason: collision with root package name */
    private long f73431s;

    /* renamed from: t, reason: collision with root package name */
    private g9.e0 f73432t;

    /* renamed from: u, reason: collision with root package name */
    private long f73433u;

    public i(boolean z10) {
        this(z10, null);
    }

    public i(boolean z10, String str) {
        this.f73414b = new com.google.android.exoplayer2.util.c0(new byte[7]);
        this.f73415c = new com.google.android.exoplayer2.util.d0(Arrays.copyOf(f73412v, 10));
        q();
        this.f73425m = -1;
        this.f73426n = -1;
        this.f73429q = C.TIME_UNSET;
        this.f73431s = C.TIME_UNSET;
        this.f73413a = z10;
        this.f73416d = str;
    }

    private void d() {
        com.google.android.exoplayer2.util.a.e(this.f73418f);
        p0.j(this.f73432t);
        p0.j(this.f73419g);
    }

    private void e(com.google.android.exoplayer2.util.d0 d0Var) {
        if (d0Var.a() == 0) {
            return;
        }
        this.f73414b.f27614a[0] = d0Var.d()[d0Var.e()];
        this.f73414b.p(2);
        int h11 = this.f73414b.h(4);
        int i11 = this.f73426n;
        if (i11 != -1 && h11 != i11) {
            o();
            return;
        }
        if (!this.f73424l) {
            this.f73424l = true;
            this.f73425m = this.f73427o;
            this.f73426n = h11;
        }
        r();
    }

    private boolean f(com.google.android.exoplayer2.util.d0 d0Var, int i11) {
        d0Var.P(i11 + 1);
        if (!u(d0Var, this.f73414b.f27614a, 1)) {
            return false;
        }
        this.f73414b.p(4);
        int h11 = this.f73414b.h(1);
        int i12 = this.f73425m;
        if (i12 != -1 && h11 != i12) {
            return false;
        }
        if (this.f73426n != -1) {
            if (!u(d0Var, this.f73414b.f27614a, 1)) {
                return true;
            }
            this.f73414b.p(2);
            if (this.f73414b.h(4) != this.f73426n) {
                return false;
            }
            d0Var.P(i11 + 2);
        }
        if (!u(d0Var, this.f73414b.f27614a, 4)) {
            return true;
        }
        this.f73414b.p(14);
        int h12 = this.f73414b.h(13);
        if (h12 < 7) {
            return false;
        }
        byte[] d11 = d0Var.d();
        int f11 = d0Var.f();
        int i13 = i11 + h12;
        if (i13 >= f11) {
            return true;
        }
        byte b11 = d11[i13];
        if (b11 == -1) {
            int i14 = i13 + 1;
            if (i14 == f11) {
                return true;
            }
            return j((byte) -1, d11[i14]) && ((d11[i14] & 8) >> 3) == h11;
        }
        if (b11 != 73) {
            return false;
        }
        int i15 = i13 + 1;
        if (i15 == f11) {
            return true;
        }
        if (d11[i15] != 68) {
            return false;
        }
        int i16 = i13 + 2;
        return i16 == f11 || d11[i16] == 51;
    }

    private boolean g(com.google.android.exoplayer2.util.d0 d0Var, byte[] bArr, int i11) {
        int min = Math.min(d0Var.a(), i11 - this.f73421i);
        d0Var.j(bArr, this.f73421i, min);
        int i12 = this.f73421i + min;
        this.f73421i = i12;
        return i12 == i11;
    }

    private void h(com.google.android.exoplayer2.util.d0 d0Var) {
        byte[] d11 = d0Var.d();
        int e11 = d0Var.e();
        int f11 = d0Var.f();
        while (e11 < f11) {
            int i11 = e11 + 1;
            byte b11 = d11[e11];
            int i12 = b11 & 255;
            if (this.f73422j == 512 && j((byte) -1, (byte) i12) && (this.f73424l || f(d0Var, e11 - 1))) {
                this.f73427o = (b11 & 8) >> 3;
                this.f73423k = (b11 & 1) == 0;
                if (this.f73424l) {
                    r();
                } else {
                    p();
                }
                d0Var.P(i11);
                return;
            }
            int i13 = this.f73422j;
            int i14 = i12 | i13;
            if (i14 == 329) {
                this.f73422j = 768;
            } else if (i14 == 511) {
                this.f73422j = 512;
            } else if (i14 == 836) {
                this.f73422j = 1024;
            } else if (i14 == 1075) {
                s();
                d0Var.P(i11);
                return;
            } else if (i13 != 256) {
                this.f73422j = 256;
            }
            e11 = i11;
        }
        d0Var.P(e11);
    }

    private boolean j(byte b11, byte b12) {
        return k(((b11 & 255) << 8) | (b12 & 255));
    }

    public static boolean k(int i11) {
        return (i11 & 65526) == 65520;
    }

    private void l() {
        this.f73414b.p(0);
        if (this.f73428p) {
            this.f73414b.r(10);
        } else {
            int i11 = 2;
            int h11 = this.f73414b.h(2) + 1;
            if (h11 != 2) {
                com.google.android.exoplayer2.util.s.i("AdtsReader", "Detected audio object type: " + h11 + ", but assuming AAC LC.");
            } else {
                i11 = h11;
            }
            this.f73414b.r(5);
            byte[] b11 = com.google.android.exoplayer2.audio.a.b(i11, this.f73426n, this.f73414b.h(3));
            a.b f11 = com.google.android.exoplayer2.audio.a.f(b11);
            o1 E = new o1.b().S(this.f73417e).e0(MimeTypes.AUDIO_AAC).I(f11.f24654c).H(f11.f24653b).f0(f11.f24652a).T(Collections.singletonList(b11)).V(this.f73416d).E();
            this.f73429q = 1024000000 / E.f25564z;
            this.f73418f.e(E);
            this.f73428p = true;
        }
        this.f73414b.r(4);
        int h12 = this.f73414b.h(13);
        int i12 = h12 - 7;
        if (this.f73423k) {
            i12 = h12 - 9;
        }
        t(this.f73418f, this.f73429q, 0, i12);
    }

    private void m() {
        this.f73419g.c(this.f73415c, 10);
        this.f73415c.P(6);
        t(this.f73419g, 0L, 10, this.f73415c.C() + 10);
    }

    private void n(com.google.android.exoplayer2.util.d0 d0Var) {
        int min = Math.min(d0Var.a(), this.f73430r - this.f73421i);
        this.f73432t.c(d0Var, min);
        int i11 = this.f73421i + min;
        this.f73421i = i11;
        int i12 = this.f73430r;
        if (i11 == i12) {
            long j11 = this.f73431s;
            if (j11 != C.TIME_UNSET) {
                this.f73432t.d(j11, 1, i12, 0, null);
                this.f73431s += this.f73433u;
            }
            q();
        }
    }

    private void o() {
        this.f73424l = false;
        q();
    }

    private void p() {
        this.f73420h = 1;
        this.f73421i = 0;
    }

    private void q() {
        this.f73420h = 0;
        this.f73421i = 0;
        this.f73422j = 256;
    }

    private void r() {
        this.f73420h = 3;
        this.f73421i = 0;
    }

    private void s() {
        this.f73420h = 2;
        this.f73421i = f73412v.length;
        this.f73430r = 0;
        this.f73415c.P(0);
    }

    private void t(g9.e0 e0Var, long j11, int i11, int i12) {
        this.f73420h = 4;
        this.f73421i = i11;
        this.f73432t = e0Var;
        this.f73433u = j11;
        this.f73430r = i12;
    }

    private boolean u(com.google.android.exoplayer2.util.d0 d0Var, byte[] bArr, int i11) {
        if (d0Var.a() < i11) {
            return false;
        }
        d0Var.j(bArr, 0, i11);
        return true;
    }

    @Override // q9.m
    public void a(com.google.android.exoplayer2.util.d0 d0Var) {
        d();
        while (d0Var.a() > 0) {
            int i11 = this.f73420h;
            if (i11 == 0) {
                h(d0Var);
            } else if (i11 == 1) {
                e(d0Var);
            } else if (i11 != 2) {
                if (i11 == 3) {
                    if (g(d0Var, this.f73414b.f27614a, this.f73423k ? 7 : 5)) {
                        l();
                    }
                } else {
                    if (i11 != 4) {
                        throw new IllegalStateException();
                    }
                    n(d0Var);
                }
            } else if (g(d0Var, this.f73415c.d(), 10)) {
                m();
            }
        }
    }

    @Override // q9.m
    public void b(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f73431s = j11;
        }
    }

    @Override // q9.m
    public void c(g9.n nVar, i0.d dVar) {
        dVar.a();
        this.f73417e = dVar.b();
        g9.e0 track = nVar.track(dVar.c(), 1);
        this.f73418f = track;
        this.f73432t = track;
        if (!this.f73413a) {
            this.f73419g = new g9.k();
            return;
        }
        dVar.a();
        g9.e0 track2 = nVar.track(dVar.c(), 5);
        this.f73419g = track2;
        track2.e(new o1.b().S(dVar.b()).e0(MimeTypes.APPLICATION_ID3).E());
    }

    public long i() {
        return this.f73429q;
    }

    @Override // q9.m
    public void packetFinished() {
    }

    @Override // q9.m
    public void seek() {
        this.f73431s = C.TIME_UNSET;
        o();
    }
}
