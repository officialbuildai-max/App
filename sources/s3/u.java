package s3;

import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import l2.s0;
import s3.l0;
import s3.v;

/* loaded from: classes2.dex */
public final class u implements m {

    /* renamed from: a, reason: collision with root package name */
    private final String f75353a;

    /* renamed from: f, reason: collision with root package name */
    private String f75358f;

    /* renamed from: g, reason: collision with root package name */
    private s0 f75359g;

    /* renamed from: j, reason: collision with root package name */
    private boolean f75362j;

    /* renamed from: l, reason: collision with root package name */
    private int f75364l;

    /* renamed from: m, reason: collision with root package name */
    private int f75365m;

    /* renamed from: o, reason: collision with root package name */
    private int f75367o;

    /* renamed from: p, reason: collision with root package name */
    private int f75368p;

    /* renamed from: t, reason: collision with root package name */
    private int f75372t;

    /* renamed from: v, reason: collision with root package name */
    private boolean f75374v;

    /* renamed from: e, reason: collision with root package name */
    private int f75357e = 0;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f75354b = new androidx.media3.common.util.j0(new byte[15], 2);

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.common.util.i0 f75355c = new androidx.media3.common.util.i0();

    /* renamed from: d, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f75356d = new androidx.media3.common.util.j0();

    /* renamed from: q, reason: collision with root package name */
    private v.b f75369q = new v.b();

    /* renamed from: r, reason: collision with root package name */
    private int f75370r = -2147483647;

    /* renamed from: s, reason: collision with root package name */
    private int f75371s = -1;

    /* renamed from: u, reason: collision with root package name */
    private long f75373u = -1;

    /* renamed from: k, reason: collision with root package name */
    private boolean f75363k = true;

    /* renamed from: n, reason: collision with root package name */
    private boolean f75366n = true;

    /* renamed from: h, reason: collision with root package name */
    private double f75360h = -9.223372036854776E18d;

    /* renamed from: i, reason: collision with root package name */
    private double f75361i = -9.223372036854776E18d;

    public u(String str) {
        this.f75353a = str;
    }

    private void e(androidx.media3.common.util.j0 j0Var, androidx.media3.common.util.j0 j0Var2, boolean z10) {
        int f11 = j0Var.f();
        int min = Math.min(j0Var.a(), j0Var2.a());
        j0Var.l(j0Var2.e(), j0Var2.f(), min);
        j0Var2.X(min);
        if (z10) {
            j0Var.W(f11);
        }
    }

    private void f() {
        int i11;
        if (this.f75374v) {
            this.f75363k = false;
            i11 = 1;
        } else {
            i11 = 0;
        }
        double d11 = ((this.f75371s - this.f75372t) * 1000000.0d) / this.f75370r;
        long round = Math.round(this.f75360h);
        if (this.f75362j) {
            this.f75362j = false;
            this.f75360h = this.f75361i;
        } else {
            this.f75360h += d11;
        }
        this.f75359g.d(round, i11, this.f75368p, 0, null);
        this.f75374v = false;
        this.f75372t = 0;
        this.f75368p = 0;
    }

    private void g(androidx.media3.common.util.i0 i0Var) {
        v.c h11 = v.h(i0Var);
        this.f75370r = h11.f75379b;
        this.f75371s = h11.f75380c;
        long j11 = this.f75373u;
        long j12 = this.f75369q.f75376b;
        if (j11 != j12) {
            this.f75373u = j12;
            String str = "mhm1";
            if (h11.f75378a != -1) {
                str = "mhm1" + String.format(".%02X", Integer.valueOf(h11.f75378a));
            }
            byte[] bArr = h11.f75381d;
            this.f75359g.c(new r.b().f0(this.f75358f).U(this.f75353a).u0("audio/mhm1").v0(this.f75370r).S(str).g0((bArr == null || bArr.length <= 0) ? null : ImmutableList.of(a1.f10437f, bArr)).N());
        }
        this.f75374v = true;
    }

    private boolean h() {
        int g11 = this.f75354b.g();
        this.f75355c.o(this.f75354b.e(), g11);
        boolean g12 = v.g(this.f75355c, this.f75369q);
        if (g12) {
            this.f75367o = 0;
            this.f75368p += this.f75369q.f75377c + g11;
        }
        return g12;
    }

    private boolean i(int i11) {
        return i11 == 1 || i11 == 17;
    }

    private boolean j(androidx.media3.common.util.j0 j0Var) {
        int i11 = this.f75364l;
        if ((i11 & 2) == 0) {
            j0Var.W(j0Var.g());
            return false;
        }
        if ((i11 & 4) != 0) {
            return true;
        }
        while (j0Var.a() > 0) {
            int i12 = this.f75365m << 8;
            this.f75365m = i12;
            int H = i12 | j0Var.H();
            this.f75365m = H;
            if (v.e(H)) {
                j0Var.W(j0Var.f() - 3);
                this.f75365m = 0;
                return true;
            }
        }
        return false;
    }

    private void k(androidx.media3.common.util.j0 j0Var) {
        int min = Math.min(j0Var.a(), this.f75369q.f75377c - this.f75367o);
        this.f75359g.b(j0Var, min);
        this.f75367o += min;
    }

    @Override // s3.m
    public void a(androidx.media3.common.util.j0 j0Var) {
        androidx.media3.common.util.a.i(this.f75359g);
        while (j0Var.a() > 0) {
            int i11 = this.f75357e;
            if (i11 != 0) {
                if (i11 == 1) {
                    e(j0Var, this.f75354b, false);
                    if (this.f75354b.a() != 0) {
                        this.f75366n = false;
                    } else if (h()) {
                        this.f75354b.W(0);
                        s0 s0Var = this.f75359g;
                        androidx.media3.common.util.j0 j0Var2 = this.f75354b;
                        s0Var.b(j0Var2, j0Var2.g());
                        this.f75354b.S(2);
                        this.f75356d.S(this.f75369q.f75377c);
                        this.f75366n = true;
                        this.f75357e = 2;
                    } else if (this.f75354b.g() < 15) {
                        androidx.media3.common.util.j0 j0Var3 = this.f75354b;
                        j0Var3.V(j0Var3.g() + 1);
                        this.f75366n = false;
                    }
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException();
                    }
                    if (i(this.f75369q.f75375a)) {
                        e(j0Var, this.f75356d, true);
                    }
                    k(j0Var);
                    int i12 = this.f75367o;
                    v.b bVar = this.f75369q;
                    if (i12 == bVar.f75377c) {
                        int i13 = bVar.f75375a;
                        if (i13 == 1) {
                            g(new androidx.media3.common.util.i0(this.f75356d.e()));
                        } else if (i13 == 17) {
                            this.f75372t = v.f(new androidx.media3.common.util.i0(this.f75356d.e()));
                        } else if (i13 == 2) {
                            f();
                        }
                        this.f75357e = 1;
                    }
                }
            } else if (j(j0Var)) {
                this.f75357e = 1;
            }
        }
    }

    @Override // s3.m
    public void b(long j11, int i11) {
        this.f75364l = i11;
        if (!this.f75363k && (this.f75368p != 0 || !this.f75366n)) {
            this.f75362j = true;
        }
        if (j11 != C.TIME_UNSET) {
            if (this.f75362j) {
                this.f75361i = j11;
            } else {
                this.f75360h = j11;
            }
        }
    }

    @Override // s3.m
    public void c(boolean z10) {
    }

    @Override // s3.m
    public void d(l2.t tVar, l0.d dVar) {
        dVar.a();
        this.f75358f = dVar.b();
        this.f75359g = tVar.track(dVar.c(), 1);
    }

    @Override // s3.m
    public void seek() {
        this.f75357e = 0;
        this.f75365m = 0;
        this.f75354b.S(2);
        this.f75367o = 0;
        this.f75368p = 0;
        this.f75370r = -2147483647;
        this.f75371s = -1;
        this.f75372t = 0;
        this.f75373u = -1L;
        this.f75374v = false;
        this.f75362j = false;
        this.f75366n = true;
        this.f75363k = true;
        this.f75360h = -9.223372036854776E18d;
        this.f75361i = -9.223372036854776E18d;
    }
}
