package s3;

import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.Collections;
import l2.a;
import l2.s0;
import s3.l0;

/* loaded from: classes2.dex */
public final class i implements m {

    /* renamed from: x, reason: collision with root package name */
    private static final byte[] f75076x = {73, 68, 51};

    /* renamed from: a, reason: collision with root package name */
    private final boolean f75077a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.common.util.i0 f75078b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f75079c;

    /* renamed from: d, reason: collision with root package name */
    private final String f75080d;

    /* renamed from: e, reason: collision with root package name */
    private final int f75081e;

    /* renamed from: f, reason: collision with root package name */
    private final String f75082f;

    /* renamed from: g, reason: collision with root package name */
    private String f75083g;

    /* renamed from: h, reason: collision with root package name */
    private s0 f75084h;

    /* renamed from: i, reason: collision with root package name */
    private s0 f75085i;

    /* renamed from: j, reason: collision with root package name */
    private int f75086j;

    /* renamed from: k, reason: collision with root package name */
    private int f75087k;

    /* renamed from: l, reason: collision with root package name */
    private int f75088l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f75089m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f75090n;

    /* renamed from: o, reason: collision with root package name */
    private int f75091o;

    /* renamed from: p, reason: collision with root package name */
    private int f75092p;

    /* renamed from: q, reason: collision with root package name */
    private int f75093q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f75094r;

    /* renamed from: s, reason: collision with root package name */
    private long f75095s;

    /* renamed from: t, reason: collision with root package name */
    private int f75096t;

    /* renamed from: u, reason: collision with root package name */
    private long f75097u;

    /* renamed from: v, reason: collision with root package name */
    private s0 f75098v;

    /* renamed from: w, reason: collision with root package name */
    private long f75099w;

    public i(boolean z10, String str) {
        this(z10, null, 0, str);
    }

    public i(boolean z10, String str, int i11, String str2) {
        this.f75078b = new androidx.media3.common.util.i0(new byte[7]);
        this.f75079c = new androidx.media3.common.util.j0(Arrays.copyOf(f75076x, 10));
        this.f75091o = -1;
        this.f75092p = -1;
        this.f75095s = C.TIME_UNSET;
        this.f75097u = C.TIME_UNSET;
        this.f75077a = z10;
        this.f75080d = str;
        this.f75081e = i11;
        this.f75082f = str2;
        r();
    }

    private void e() {
        androidx.media3.common.util.a.e(this.f75084h);
        a1.i(this.f75098v);
        a1.i(this.f75085i);
    }

    private void f(androidx.media3.common.util.j0 j0Var) {
        if (j0Var.a() == 0) {
            return;
        }
        this.f75078b.f10470a[0] = j0Var.e()[j0Var.f()];
        this.f75078b.p(2);
        int h11 = this.f75078b.h(4);
        int i11 = this.f75092p;
        if (i11 != -1 && h11 != i11) {
            p();
            return;
        }
        if (!this.f75090n) {
            this.f75090n = true;
            this.f75091o = this.f75093q;
            this.f75092p = h11;
        }
        s();
    }

    private boolean g(androidx.media3.common.util.j0 j0Var, int i11) {
        j0Var.W(i11 + 1);
        if (!v(j0Var, this.f75078b.f10470a, 1)) {
            return false;
        }
        this.f75078b.p(4);
        int h11 = this.f75078b.h(1);
        int i12 = this.f75091o;
        if (i12 != -1 && h11 != i12) {
            return false;
        }
        if (this.f75092p != -1) {
            if (!v(j0Var, this.f75078b.f10470a, 1)) {
                return true;
            }
            this.f75078b.p(2);
            if (this.f75078b.h(4) != this.f75092p) {
                return false;
            }
            j0Var.W(i11 + 2);
        }
        if (!v(j0Var, this.f75078b.f10470a, 4)) {
            return true;
        }
        this.f75078b.p(14);
        int h12 = this.f75078b.h(13);
        if (h12 < 7) {
            return false;
        }
        byte[] e11 = j0Var.e();
        int g11 = j0Var.g();
        int i13 = i11 + h12;
        if (i13 >= g11) {
            return true;
        }
        byte b11 = e11[i13];
        if (b11 == -1) {
            int i14 = i13 + 1;
            if (i14 == g11) {
                return true;
            }
            return k((byte) -1, e11[i14]) && ((e11[i14] & 8) >> 3) == h11;
        }
        if (b11 != 73) {
            return false;
        }
        int i15 = i13 + 1;
        if (i15 == g11) {
            return true;
        }
        if (e11[i15] != 68) {
            return false;
        }
        int i16 = i13 + 2;
        return i16 == g11 || e11[i16] == 51;
    }

    private boolean h(androidx.media3.common.util.j0 j0Var, byte[] bArr, int i11) {
        int min = Math.min(j0Var.a(), i11 - this.f75087k);
        j0Var.l(bArr, this.f75087k, min);
        int i12 = this.f75087k + min;
        this.f75087k = i12;
        return i12 == i11;
    }

    private void i(androidx.media3.common.util.j0 j0Var) {
        byte[] e11 = j0Var.e();
        int f11 = j0Var.f();
        int g11 = j0Var.g();
        while (f11 < g11) {
            int i11 = f11 + 1;
            byte b11 = e11[f11];
            int i12 = b11 & 255;
            if (this.f75088l == 512 && k((byte) -1, (byte) i12) && (this.f75090n || g(j0Var, f11 - 1))) {
                this.f75093q = (b11 & 8) >> 3;
                this.f75089m = (b11 & 1) == 0;
                if (this.f75090n) {
                    s();
                } else {
                    q();
                }
                j0Var.W(i11);
                return;
            }
            int i13 = this.f75088l;
            int i14 = i12 | i13;
            if (i14 == 329) {
                this.f75088l = 768;
            } else if (i14 == 511) {
                this.f75088l = 512;
            } else if (i14 == 836) {
                this.f75088l = 1024;
            } else if (i14 == 1075) {
                t();
                j0Var.W(i11);
                return;
            } else if (i13 != 256) {
                this.f75088l = 256;
            }
            f11 = i11;
        }
        j0Var.W(f11);
    }

    private boolean k(byte b11, byte b12) {
        return l(((b11 & 255) << 8) | (b12 & 255));
    }

    public static boolean l(int i11) {
        return (i11 & 65526) == 65520;
    }

    private void m() {
        this.f75078b.p(0);
        if (this.f75094r) {
            this.f75078b.r(10);
        } else {
            int i11 = 2;
            int h11 = this.f75078b.h(2) + 1;
            if (h11 != 2) {
                androidx.media3.common.util.u.h("AdtsReader", "Detected audio object type: " + h11 + ", but assuming AAC LC.");
            } else {
                i11 = h11;
            }
            this.f75078b.r(5);
            byte[] a11 = l2.a.a(i11, this.f75092p, this.f75078b.h(3));
            a.b e11 = l2.a.e(a11);
            androidx.media3.common.r N = new r.b().f0(this.f75083g).U(this.f75082f).u0(MimeTypes.AUDIO_AAC).S(e11.f68608c).R(e11.f68607b).v0(e11.f68606a).g0(Collections.singletonList(a11)).j0(this.f75080d).s0(this.f75081e).N();
            this.f75095s = 1024000000 / N.F;
            this.f75084h.c(N);
            this.f75094r = true;
        }
        this.f75078b.r(4);
        int h12 = this.f75078b.h(13);
        int i12 = h12 - 7;
        if (this.f75089m) {
            i12 = h12 - 9;
        }
        u(this.f75084h, this.f75095s, 0, i12);
    }

    private void n() {
        this.f75085i.b(this.f75079c, 10);
        this.f75079c.W(6);
        u(this.f75085i, 0L, 10, this.f75079c.G() + 10);
    }

    private void o(androidx.media3.common.util.j0 j0Var) {
        int min = Math.min(j0Var.a(), this.f75096t - this.f75087k);
        this.f75098v.b(j0Var, min);
        int i11 = this.f75087k + min;
        this.f75087k = i11;
        if (i11 == this.f75096t) {
            androidx.media3.common.util.a.g(this.f75097u != C.TIME_UNSET);
            this.f75098v.d(this.f75097u, 1, this.f75096t, 0, null);
            this.f75097u += this.f75099w;
            r();
        }
    }

    private void p() {
        this.f75090n = false;
        r();
    }

    private void q() {
        this.f75086j = 1;
        this.f75087k = 0;
    }

    private void r() {
        this.f75086j = 0;
        this.f75087k = 0;
        this.f75088l = 256;
    }

    private void s() {
        this.f75086j = 3;
        this.f75087k = 0;
    }

    private void t() {
        this.f75086j = 2;
        this.f75087k = f75076x.length;
        this.f75096t = 0;
        this.f75079c.W(0);
    }

    private void u(s0 s0Var, long j11, int i11, int i12) {
        this.f75086j = 4;
        this.f75087k = i11;
        this.f75098v = s0Var;
        this.f75099w = j11;
        this.f75096t = i12;
    }

    private boolean v(androidx.media3.common.util.j0 j0Var, byte[] bArr, int i11) {
        if (j0Var.a() < i11) {
            return false;
        }
        j0Var.l(bArr, 0, i11);
        return true;
    }

    @Override // s3.m
    public void a(androidx.media3.common.util.j0 j0Var) {
        e();
        while (j0Var.a() > 0) {
            int i11 = this.f75086j;
            if (i11 == 0) {
                i(j0Var);
            } else if (i11 == 1) {
                f(j0Var);
            } else if (i11 != 2) {
                if (i11 == 3) {
                    if (h(j0Var, this.f75078b.f10470a, this.f75089m ? 7 : 5)) {
                        m();
                    }
                } else {
                    if (i11 != 4) {
                        throw new IllegalStateException();
                    }
                    o(j0Var);
                }
            } else if (h(j0Var, this.f75079c.e(), 10)) {
                n();
            }
        }
    }

    @Override // s3.m
    public void b(long j11, int i11) {
        this.f75097u = j11;
    }

    @Override // s3.m
    public void c(boolean z10) {
    }

    @Override // s3.m
    public void d(l2.t tVar, l0.d dVar) {
        dVar.a();
        this.f75083g = dVar.b();
        s0 track = tVar.track(dVar.c(), 1);
        this.f75084h = track;
        this.f75098v = track;
        if (!this.f75077a) {
            this.f75085i = new l2.n();
            return;
        }
        dVar.a();
        s0 track2 = tVar.track(dVar.c(), 5);
        this.f75085i = track2;
        track2.c(new r.b().f0(dVar.b()).U(this.f75082f).u0(MimeTypes.APPLICATION_ID3).N());
    }

    public long j() {
        return this.f75095s;
    }

    @Override // s3.m
    public void seek() {
        this.f75097u = C.TIME_UNSET;
        p();
    }
}
