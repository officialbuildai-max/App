package q9;

import com.google.android.exoplayer2.util.l0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import q9.i0;

/* loaded from: classes4.dex */
public final class w implements i0 {

    /* renamed from: a, reason: collision with root package name */
    private final m f73638a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.c0 f73639b = new com.google.android.exoplayer2.util.c0(new byte[10]);

    /* renamed from: c, reason: collision with root package name */
    private int f73640c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f73641d;

    /* renamed from: e, reason: collision with root package name */
    private l0 f73642e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f73643f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f73644g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f73645h;

    /* renamed from: i, reason: collision with root package name */
    private int f73646i;

    /* renamed from: j, reason: collision with root package name */
    private int f73647j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f73648k;

    /* renamed from: l, reason: collision with root package name */
    private long f73649l;

    public w(m mVar) {
        this.f73638a = mVar;
    }

    private boolean c(com.google.android.exoplayer2.util.d0 d0Var, byte[] bArr, int i11) {
        int min = Math.min(d0Var.a(), i11 - this.f73641d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            d0Var.Q(min);
        } else {
            d0Var.j(bArr, this.f73641d, min);
        }
        int i12 = this.f73641d + min;
        this.f73641d = i12;
        return i12 == i11;
    }

    private boolean d() {
        this.f73639b.p(0);
        int h11 = this.f73639b.h(24);
        if (h11 != 1) {
            com.google.android.exoplayer2.util.s.i("PesReader", "Unexpected start code prefix: " + h11);
            this.f73647j = -1;
            return false;
        }
        this.f73639b.r(8);
        int h12 = this.f73639b.h(16);
        this.f73639b.r(5);
        this.f73648k = this.f73639b.g();
        this.f73639b.r(2);
        this.f73643f = this.f73639b.g();
        this.f73644g = this.f73639b.g();
        this.f73639b.r(6);
        int h13 = this.f73639b.h(8);
        this.f73646i = h13;
        if (h12 == 0) {
            this.f73647j = -1;
        } else {
            int i11 = (h12 - 3) - h13;
            this.f73647j = i11;
            if (i11 < 0) {
                com.google.android.exoplayer2.util.s.i("PesReader", "Found negative packet payload size: " + this.f73647j);
                this.f73647j = -1;
            }
        }
        return true;
    }

    private void e() {
        this.f73639b.p(0);
        this.f73649l = C.TIME_UNSET;
        if (this.f73643f) {
            this.f73639b.r(4);
            this.f73639b.r(1);
            this.f73639b.r(1);
            long h11 = (this.f73639b.h(3) << 30) | (this.f73639b.h(15) << 15) | this.f73639b.h(15);
            this.f73639b.r(1);
            if (!this.f73645h && this.f73644g) {
                this.f73639b.r(4);
                this.f73639b.r(1);
                this.f73639b.r(1);
                this.f73639b.r(1);
                this.f73642e.b((this.f73639b.h(3) << 30) | (this.f73639b.h(15) << 15) | this.f73639b.h(15));
                this.f73645h = true;
            }
            this.f73649l = this.f73642e.b(h11);
        }
    }

    private void f(int i11) {
        this.f73640c = i11;
        this.f73641d = 0;
    }

    @Override // q9.i0
    public final void a(com.google.android.exoplayer2.util.d0 d0Var, int i11) {
        com.google.android.exoplayer2.util.a.i(this.f73642e);
        if ((i11 & 1) != 0) {
            int i12 = this.f73640c;
            if (i12 != 0 && i12 != 1) {
                if (i12 == 2) {
                    com.google.android.exoplayer2.util.s.i("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i12 != 3) {
                        throw new IllegalStateException();
                    }
                    if (this.f73647j != -1) {
                        com.google.android.exoplayer2.util.s.i("PesReader", "Unexpected start indicator: expected " + this.f73647j + " more bytes");
                    }
                    this.f73638a.packetFinished();
                }
            }
            f(1);
        }
        while (d0Var.a() > 0) {
            int i13 = this.f73640c;
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 == 2) {
                        if (c(d0Var, this.f73639b.f27614a, Math.min(10, this.f73646i)) && c(d0Var, null, this.f73646i)) {
                            e();
                            i11 |= this.f73648k ? 4 : 0;
                            this.f73638a.b(this.f73649l, i11);
                            f(3);
                        }
                    } else {
                        if (i13 != 3) {
                            throw new IllegalStateException();
                        }
                        int a11 = d0Var.a();
                        int i14 = this.f73647j;
                        int i15 = i14 != -1 ? a11 - i14 : 0;
                        if (i15 > 0) {
                            a11 -= i15;
                            d0Var.O(d0Var.e() + a11);
                        }
                        this.f73638a.a(d0Var);
                        int i16 = this.f73647j;
                        if (i16 != -1) {
                            int i17 = i16 - a11;
                            this.f73647j = i17;
                            if (i17 == 0) {
                                this.f73638a.packetFinished();
                                f(1);
                            }
                        }
                    }
                } else if (c(d0Var, this.f73639b.f27614a, 9)) {
                    f(d() ? 2 : 0);
                }
            } else {
                d0Var.Q(d0Var.a());
            }
        }
    }

    @Override // q9.i0
    public void b(l0 l0Var, g9.n nVar, i0.d dVar) {
        this.f73642e = l0Var;
        this.f73638a.c(nVar, dVar);
    }

    @Override // q9.i0
    public final void seek() {
        this.f73640c = 0;
        this.f73641d = 0;
        this.f73645h = false;
        this.f73638a.seek();
    }
}
