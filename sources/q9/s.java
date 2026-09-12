package q9;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.o1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import q9.i0;

/* loaded from: classes4.dex */
public final class s implements m {

    /* renamed from: a, reason: collision with root package name */
    private final String f73597a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f73598b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.c0 f73599c;

    /* renamed from: d, reason: collision with root package name */
    private g9.e0 f73600d;

    /* renamed from: e, reason: collision with root package name */
    private String f73601e;

    /* renamed from: f, reason: collision with root package name */
    private o1 f73602f;

    /* renamed from: g, reason: collision with root package name */
    private int f73603g;

    /* renamed from: h, reason: collision with root package name */
    private int f73604h;

    /* renamed from: i, reason: collision with root package name */
    private int f73605i;

    /* renamed from: j, reason: collision with root package name */
    private int f73606j;

    /* renamed from: k, reason: collision with root package name */
    private long f73607k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f73608l;

    /* renamed from: m, reason: collision with root package name */
    private int f73609m;

    /* renamed from: n, reason: collision with root package name */
    private int f73610n;

    /* renamed from: o, reason: collision with root package name */
    private int f73611o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f73612p;

    /* renamed from: q, reason: collision with root package name */
    private long f73613q;

    /* renamed from: r, reason: collision with root package name */
    private int f73614r;

    /* renamed from: s, reason: collision with root package name */
    private long f73615s;

    /* renamed from: t, reason: collision with root package name */
    private int f73616t;

    /* renamed from: u, reason: collision with root package name */
    private String f73617u;

    public s(String str) {
        this.f73597a = str;
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(1024);
        this.f73598b = d0Var;
        this.f73599c = new com.google.android.exoplayer2.util.c0(d0Var.d());
        this.f73607k = C.TIME_UNSET;
    }

    private static long d(com.google.android.exoplayer2.util.c0 c0Var) {
        return c0Var.h((c0Var.h(2) + 1) * 8);
    }

    private void e(com.google.android.exoplayer2.util.c0 c0Var) {
        if (!c0Var.g()) {
            this.f73608l = true;
            j(c0Var);
        } else if (!this.f73608l) {
            return;
        }
        if (this.f73609m != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        if (this.f73610n != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        i(c0Var, h(c0Var));
        if (this.f73612p) {
            c0Var.r((int) this.f73613q);
        }
    }

    private int f(com.google.android.exoplayer2.util.c0 c0Var) {
        int b11 = c0Var.b();
        a.b e11 = com.google.android.exoplayer2.audio.a.e(c0Var, true);
        this.f73617u = e11.f24654c;
        this.f73614r = e11.f24652a;
        this.f73616t = e11.f24653b;
        return b11 - c0Var.b();
    }

    private void g(com.google.android.exoplayer2.util.c0 c0Var) {
        int h11 = c0Var.h(3);
        this.f73611o = h11;
        if (h11 == 0) {
            c0Var.r(8);
            return;
        }
        if (h11 == 1) {
            c0Var.r(9);
            return;
        }
        if (h11 == 3 || h11 == 4 || h11 == 5) {
            c0Var.r(6);
        } else {
            if (h11 != 6 && h11 != 7) {
                throw new IllegalStateException();
            }
            c0Var.r(1);
        }
    }

    private int h(com.google.android.exoplayer2.util.c0 c0Var) {
        int h11;
        if (this.f73611o != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        int i11 = 0;
        do {
            h11 = c0Var.h(8);
            i11 += h11;
        } while (h11 == 255);
        return i11;
    }

    private void i(com.google.android.exoplayer2.util.c0 c0Var, int i11) {
        int e11 = c0Var.e();
        if ((e11 & 7) == 0) {
            this.f73598b.P(e11 >> 3);
        } else {
            c0Var.i(this.f73598b.d(), 0, i11 * 8);
            this.f73598b.P(0);
        }
        this.f73600d.c(this.f73598b, i11);
        long j11 = this.f73607k;
        if (j11 != C.TIME_UNSET) {
            this.f73600d.d(j11, 1, i11, 0, null);
            this.f73607k += this.f73615s;
        }
    }

    private void j(com.google.android.exoplayer2.util.c0 c0Var) {
        boolean g11;
        int h11 = c0Var.h(1);
        int h12 = h11 == 1 ? c0Var.h(1) : 0;
        this.f73609m = h12;
        if (h12 != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        if (h11 == 1) {
            d(c0Var);
        }
        if (!c0Var.g()) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        this.f73610n = c0Var.h(6);
        int h13 = c0Var.h(4);
        int h14 = c0Var.h(3);
        if (h13 != 0 || h14 != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        if (h11 == 0) {
            int e11 = c0Var.e();
            int f11 = f(c0Var);
            c0Var.p(e11);
            byte[] bArr = new byte[(f11 + 7) / 8];
            c0Var.i(bArr, 0, f11);
            o1 E = new o1.b().S(this.f73601e).e0(MimeTypes.AUDIO_AAC).I(this.f73617u).H(this.f73616t).f0(this.f73614r).T(Collections.singletonList(bArr)).V(this.f73597a).E();
            if (!E.equals(this.f73602f)) {
                this.f73602f = E;
                this.f73615s = 1024000000 / E.f25564z;
                this.f73600d.e(E);
            }
        } else {
            c0Var.r(((int) d(c0Var)) - f(c0Var));
        }
        g(c0Var);
        boolean g12 = c0Var.g();
        this.f73612p = g12;
        this.f73613q = 0L;
        if (g12) {
            if (h11 == 1) {
                this.f73613q = d(c0Var);
            }
            do {
                g11 = c0Var.g();
                this.f73613q = (this.f73613q << 8) + c0Var.h(8);
            } while (g11);
        }
        if (c0Var.g()) {
            c0Var.r(8);
        }
    }

    private void k(int i11) {
        this.f73598b.L(i11);
        this.f73599c.n(this.f73598b.d());
    }

    @Override // q9.m
    public void a(com.google.android.exoplayer2.util.d0 d0Var) {
        com.google.android.exoplayer2.util.a.i(this.f73600d);
        while (d0Var.a() > 0) {
            int i11 = this.f73603g;
            if (i11 != 0) {
                if (i11 == 1) {
                    int D = d0Var.D();
                    if ((D & 224) == 224) {
                        this.f73606j = D;
                        this.f73603g = 2;
                    } else if (D != 86) {
                        this.f73603g = 0;
                    }
                } else if (i11 == 2) {
                    int D2 = ((this.f73606j & (-225)) << 8) | d0Var.D();
                    this.f73605i = D2;
                    if (D2 > this.f73598b.d().length) {
                        k(this.f73605i);
                    }
                    this.f73604h = 0;
                    this.f73603g = 3;
                } else {
                    if (i11 != 3) {
                        throw new IllegalStateException();
                    }
                    int min = Math.min(d0Var.a(), this.f73605i - this.f73604h);
                    d0Var.j(this.f73599c.f27614a, this.f73604h, min);
                    int i12 = this.f73604h + min;
                    this.f73604h = i12;
                    if (i12 == this.f73605i) {
                        this.f73599c.p(0);
                        e(this.f73599c);
                        this.f73603g = 0;
                    }
                }
            } else if (d0Var.D() == 86) {
                this.f73603g = 1;
            }
        }
    }

    @Override // q9.m
    public void b(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f73607k = j11;
        }
    }

    @Override // q9.m
    public void c(g9.n nVar, i0.d dVar) {
        dVar.a();
        this.f73600d = nVar.track(dVar.c(), 1);
        this.f73601e = dVar.b();
    }

    @Override // q9.m
    public void packetFinished() {
    }

    @Override // q9.m
    public void seek() {
        this.f73603g = 0;
        this.f73607k = C.TIME_UNSET;
        this.f73608l = false;
    }
}
