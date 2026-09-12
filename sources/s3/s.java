package s3;

import androidx.media3.common.ParserException;
import androidx.media3.common.r;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import l2.a;
import l2.s0;
import s3.l0;

/* loaded from: classes2.dex */
public final class s implements m {

    /* renamed from: a, reason: collision with root package name */
    private final String f75316a;

    /* renamed from: b, reason: collision with root package name */
    private final int f75317b;

    /* renamed from: c, reason: collision with root package name */
    private final String f75318c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f75319d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.media3.common.util.i0 f75320e;

    /* renamed from: f, reason: collision with root package name */
    private s0 f75321f;

    /* renamed from: g, reason: collision with root package name */
    private String f75322g;

    /* renamed from: h, reason: collision with root package name */
    private androidx.media3.common.r f75323h;

    /* renamed from: i, reason: collision with root package name */
    private int f75324i;

    /* renamed from: j, reason: collision with root package name */
    private int f75325j;

    /* renamed from: k, reason: collision with root package name */
    private int f75326k;

    /* renamed from: l, reason: collision with root package name */
    private int f75327l;

    /* renamed from: m, reason: collision with root package name */
    private long f75328m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f75329n;

    /* renamed from: o, reason: collision with root package name */
    private int f75330o;

    /* renamed from: p, reason: collision with root package name */
    private int f75331p;

    /* renamed from: q, reason: collision with root package name */
    private int f75332q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f75333r;

    /* renamed from: s, reason: collision with root package name */
    private long f75334s;

    /* renamed from: t, reason: collision with root package name */
    private int f75335t;

    /* renamed from: u, reason: collision with root package name */
    private long f75336u;

    /* renamed from: v, reason: collision with root package name */
    private int f75337v;

    /* renamed from: w, reason: collision with root package name */
    private String f75338w;

    public s(String str, int i11, String str2) {
        this.f75316a = str;
        this.f75317b = i11;
        this.f75318c = str2;
        androidx.media3.common.util.j0 j0Var = new androidx.media3.common.util.j0(1024);
        this.f75319d = j0Var;
        this.f75320e = new androidx.media3.common.util.i0(j0Var.e());
        this.f75328m = C.TIME_UNSET;
    }

    private static long e(androidx.media3.common.util.i0 i0Var) {
        return i0Var.h((i0Var.h(2) + 1) * 8);
    }

    private void f(androidx.media3.common.util.i0 i0Var) {
        if (!i0Var.g()) {
            this.f75329n = true;
            k(i0Var);
        } else if (!this.f75329n) {
            return;
        }
        if (this.f75330o != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        if (this.f75331p != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        j(i0Var, i(i0Var));
        if (this.f75333r) {
            i0Var.r((int) this.f75334s);
        }
    }

    private int g(androidx.media3.common.util.i0 i0Var) {
        int b11 = i0Var.b();
        a.b d11 = l2.a.d(i0Var, true);
        this.f75338w = d11.f68608c;
        this.f75335t = d11.f68606a;
        this.f75337v = d11.f68607b;
        return b11 - i0Var.b();
    }

    private void h(androidx.media3.common.util.i0 i0Var) {
        int h11 = i0Var.h(3);
        this.f75332q = h11;
        if (h11 == 0) {
            i0Var.r(8);
            return;
        }
        if (h11 == 1) {
            i0Var.r(9);
            return;
        }
        if (h11 == 3 || h11 == 4 || h11 == 5) {
            i0Var.r(6);
        } else {
            if (h11 != 6 && h11 != 7) {
                throw new IllegalStateException();
            }
            i0Var.r(1);
        }
    }

    private int i(androidx.media3.common.util.i0 i0Var) {
        int h11;
        if (this.f75332q != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        int i11 = 0;
        do {
            h11 = i0Var.h(8);
            i11 += h11;
        } while (h11 == 255);
        return i11;
    }

    private void j(androidx.media3.common.util.i0 i0Var, int i11) {
        int e11 = i0Var.e();
        if ((e11 & 7) == 0) {
            this.f75319d.W(e11 >> 3);
        } else {
            i0Var.i(this.f75319d.e(), 0, i11 * 8);
            this.f75319d.W(0);
        }
        this.f75321f.b(this.f75319d, i11);
        androidx.media3.common.util.a.g(this.f75328m != C.TIME_UNSET);
        this.f75321f.d(this.f75328m, 1, i11, 0, null);
        this.f75328m += this.f75336u;
    }

    private void k(androidx.media3.common.util.i0 i0Var) {
        boolean g11;
        int h11 = i0Var.h(1);
        int h12 = h11 == 1 ? i0Var.h(1) : 0;
        this.f75330o = h12;
        if (h12 != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        if (h11 == 1) {
            e(i0Var);
        }
        if (!i0Var.g()) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        this.f75331p = i0Var.h(6);
        int h13 = i0Var.h(4);
        int h14 = i0Var.h(3);
        if (h13 != 0 || h14 != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        if (h11 == 0) {
            int e11 = i0Var.e();
            int g12 = g(i0Var);
            i0Var.p(e11);
            byte[] bArr = new byte[(g12 + 7) / 8];
            i0Var.i(bArr, 0, g12);
            androidx.media3.common.r N = new r.b().f0(this.f75322g).U(this.f75318c).u0(MimeTypes.AUDIO_AAC).S(this.f75338w).R(this.f75337v).v0(this.f75335t).g0(Collections.singletonList(bArr)).j0(this.f75316a).s0(this.f75317b).N();
            if (!N.equals(this.f75323h)) {
                this.f75323h = N;
                this.f75336u = 1024000000 / N.F;
                this.f75321f.c(N);
            }
        } else {
            i0Var.r(((int) e(i0Var)) - g(i0Var));
        }
        h(i0Var);
        boolean g13 = i0Var.g();
        this.f75333r = g13;
        this.f75334s = 0L;
        if (g13) {
            if (h11 == 1) {
                this.f75334s = e(i0Var);
            }
            do {
                g11 = i0Var.g();
                this.f75334s = (this.f75334s << 8) + i0Var.h(8);
            } while (g11);
        }
        if (i0Var.g()) {
            i0Var.r(8);
        }
    }

    private void l(int i11) {
        this.f75319d.S(i11);
        this.f75320e.n(this.f75319d.e());
    }

    @Override // s3.m
    public void a(androidx.media3.common.util.j0 j0Var) {
        androidx.media3.common.util.a.i(this.f75321f);
        while (j0Var.a() > 0) {
            int i11 = this.f75324i;
            if (i11 != 0) {
                if (i11 == 1) {
                    int H = j0Var.H();
                    if ((H & 224) == 224) {
                        this.f75327l = H;
                        this.f75324i = 2;
                    } else if (H != 86) {
                        this.f75324i = 0;
                    }
                } else if (i11 == 2) {
                    int H2 = ((this.f75327l & (-225)) << 8) | j0Var.H();
                    this.f75326k = H2;
                    if (H2 > this.f75319d.e().length) {
                        l(this.f75326k);
                    }
                    this.f75325j = 0;
                    this.f75324i = 3;
                } else {
                    if (i11 != 3) {
                        throw new IllegalStateException();
                    }
                    int min = Math.min(j0Var.a(), this.f75326k - this.f75325j);
                    j0Var.l(this.f75320e.f10470a, this.f75325j, min);
                    int i12 = this.f75325j + min;
                    this.f75325j = i12;
                    if (i12 == this.f75326k) {
                        this.f75320e.p(0);
                        f(this.f75320e);
                        this.f75324i = 0;
                    }
                }
            } else if (j0Var.H() == 86) {
                this.f75324i = 1;
            }
        }
    }

    @Override // s3.m
    public void b(long j11, int i11) {
        this.f75328m = j11;
    }

    @Override // s3.m
    public void c(boolean z10) {
    }

    @Override // s3.m
    public void d(l2.t tVar, l0.d dVar) {
        dVar.a();
        this.f75321f = tVar.track(dVar.c(), 1);
        this.f75322g = dVar.b();
    }

    @Override // s3.m
    public void seek() {
        this.f75324i = 0;
        this.f75328m = C.TIME_UNSET;
        this.f75329n = false;
    }
}
