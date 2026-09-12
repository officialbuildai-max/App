package s3;

import androidx.media3.common.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import s3.l0;

/* loaded from: classes2.dex */
public final class y implements l0 {

    /* renamed from: a, reason: collision with root package name */
    private final m f75390a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.common.util.i0 f75391b = new androidx.media3.common.util.i0(new byte[10]);

    /* renamed from: c, reason: collision with root package name */
    private int f75392c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f75393d;

    /* renamed from: e, reason: collision with root package name */
    private p0 f75394e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f75395f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f75396g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f75397h;

    /* renamed from: i, reason: collision with root package name */
    private int f75398i;

    /* renamed from: j, reason: collision with root package name */
    private int f75399j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f75400k;

    /* renamed from: l, reason: collision with root package name */
    private long f75401l;

    public y(m mVar) {
        this.f75390a = mVar;
    }

    private boolean d(androidx.media3.common.util.j0 j0Var, byte[] bArr, int i11) {
        int min = Math.min(j0Var.a(), i11 - this.f75393d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            j0Var.X(min);
        } else {
            j0Var.l(bArr, this.f75393d, min);
        }
        int i12 = this.f75393d + min;
        this.f75393d = i12;
        return i12 == i11;
    }

    private boolean e() {
        this.f75391b.p(0);
        int h11 = this.f75391b.h(24);
        if (h11 != 1) {
            androidx.media3.common.util.u.h("PesReader", "Unexpected start code prefix: " + h11);
            this.f75399j = -1;
            return false;
        }
        this.f75391b.r(8);
        int h12 = this.f75391b.h(16);
        this.f75391b.r(5);
        this.f75400k = this.f75391b.g();
        this.f75391b.r(2);
        this.f75395f = this.f75391b.g();
        this.f75396g = this.f75391b.g();
        this.f75391b.r(6);
        int h13 = this.f75391b.h(8);
        this.f75398i = h13;
        if (h12 == 0) {
            this.f75399j = -1;
        } else {
            int i11 = (h12 - 3) - h13;
            this.f75399j = i11;
            if (i11 < 0) {
                androidx.media3.common.util.u.h("PesReader", "Found negative packet payload size: " + this.f75399j);
                this.f75399j = -1;
            }
        }
        return true;
    }

    private void f() {
        this.f75391b.p(0);
        this.f75401l = C.TIME_UNSET;
        if (this.f75395f) {
            this.f75391b.r(4);
            this.f75391b.r(1);
            this.f75391b.r(1);
            long h11 = (this.f75391b.h(3) << 30) | (this.f75391b.h(15) << 15) | this.f75391b.h(15);
            this.f75391b.r(1);
            if (!this.f75397h && this.f75396g) {
                this.f75391b.r(4);
                this.f75391b.r(1);
                this.f75391b.r(1);
                this.f75391b.r(1);
                this.f75394e.b((this.f75391b.h(3) << 30) | (this.f75391b.h(15) << 15) | this.f75391b.h(15));
                this.f75397h = true;
            }
            this.f75401l = this.f75394e.b(h11);
        }
    }

    private void g(int i11) {
        this.f75392c = i11;
        this.f75393d = 0;
    }

    @Override // s3.l0
    public void a(androidx.media3.common.util.j0 j0Var, int i11) {
        androidx.media3.common.util.a.i(this.f75394e);
        if ((i11 & 1) != 0) {
            int i12 = this.f75392c;
            if (i12 != 0 && i12 != 1) {
                if (i12 == 2) {
                    androidx.media3.common.util.u.h("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i12 != 3) {
                        throw new IllegalStateException();
                    }
                    if (this.f75399j != -1) {
                        androidx.media3.common.util.u.h("PesReader", "Unexpected start indicator: expected " + this.f75399j + " more bytes");
                    }
                    this.f75390a.c(j0Var.g() == 0);
                }
            }
            g(1);
        }
        while (j0Var.a() > 0) {
            int i13 = this.f75392c;
            if (i13 == 0) {
                j0Var.X(j0Var.a());
            } else if (i13 != 1) {
                if (i13 == 2) {
                    if (d(j0Var, this.f75391b.f10470a, Math.min(10, this.f75398i)) && d(j0Var, null, this.f75398i)) {
                        f();
                        i11 |= this.f75400k ? 4 : 0;
                        this.f75390a.b(this.f75401l, i11);
                        g(3);
                    }
                } else {
                    if (i13 != 3) {
                        throw new IllegalStateException();
                    }
                    int a11 = j0Var.a();
                    int i14 = this.f75399j;
                    int i15 = i14 == -1 ? 0 : a11 - i14;
                    if (i15 > 0) {
                        a11 -= i15;
                        j0Var.V(j0Var.f() + a11);
                    }
                    this.f75390a.a(j0Var);
                    int i16 = this.f75399j;
                    if (i16 != -1) {
                        int i17 = i16 - a11;
                        this.f75399j = i17;
                        if (i17 == 0) {
                            this.f75390a.c(false);
                            g(1);
                        }
                    }
                }
            } else if (d(j0Var, this.f75391b.f10470a, 9)) {
                g(e() ? 2 : 0);
            }
        }
    }

    @Override // s3.l0
    public void b(p0 p0Var, l2.t tVar, l0.d dVar) {
        this.f75394e = p0Var;
        this.f75390a.d(tVar, dVar);
    }

    public boolean c(boolean z10) {
        return this.f75392c == 3 && this.f75399j == -1 && !(z10 && (this.f75390a instanceof n)) && (!z10 || e());
    }

    @Override // s3.l0
    public void seek() {
        this.f75392c = 0;
        this.f75393d = 0;
        this.f75397h = false;
        this.f75390a.seek();
    }
}
