package s3;

import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import l2.p;
import l2.s0;
import s3.l0;

/* loaded from: classes2.dex */
public final class k implements m {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f75111a;

    /* renamed from: c, reason: collision with root package name */
    private final String f75113c;

    /* renamed from: d, reason: collision with root package name */
    private final int f75114d;

    /* renamed from: e, reason: collision with root package name */
    private final String f75115e;

    /* renamed from: f, reason: collision with root package name */
    private String f75116f;

    /* renamed from: g, reason: collision with root package name */
    private s0 f75117g;

    /* renamed from: i, reason: collision with root package name */
    private int f75119i;

    /* renamed from: j, reason: collision with root package name */
    private int f75120j;

    /* renamed from: k, reason: collision with root package name */
    private long f75121k;

    /* renamed from: l, reason: collision with root package name */
    private androidx.media3.common.r f75122l;

    /* renamed from: m, reason: collision with root package name */
    private int f75123m;

    /* renamed from: n, reason: collision with root package name */
    private int f75124n;

    /* renamed from: h, reason: collision with root package name */
    private int f75118h = 0;

    /* renamed from: q, reason: collision with root package name */
    private long f75127q = C.TIME_UNSET;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f75112b = new AtomicInteger();

    /* renamed from: o, reason: collision with root package name */
    private int f75125o = -1;

    /* renamed from: p, reason: collision with root package name */
    private int f75126p = -1;

    public k(String str, int i11, int i12, String str2) {
        this.f75111a = new androidx.media3.common.util.j0(new byte[i12]);
        this.f75113c = str;
        this.f75114d = i11;
        this.f75115e = str2;
    }

    private boolean e(androidx.media3.common.util.j0 j0Var, byte[] bArr, int i11) {
        int min = Math.min(j0Var.a(), i11 - this.f75119i);
        j0Var.l(bArr, this.f75119i, min);
        int i12 = this.f75119i + min;
        this.f75119i = i12;
        return i12 == i11;
    }

    private void f() {
        byte[] e11 = this.f75111a.e();
        if (this.f75122l == null) {
            androidx.media3.common.r h11 = l2.p.h(e11, this.f75116f, this.f75113c, this.f75114d, this.f75115e, null);
            this.f75122l = h11;
            this.f75117g.c(h11);
        }
        this.f75123m = l2.p.b(e11);
        this.f75121k = Ints.d(a1.d1(l2.p.g(e11), this.f75122l.F));
    }

    private void g() {
        p.b i11 = l2.p.i(this.f75111a.e());
        j(i11);
        this.f75123m = i11.f68797d;
        long j11 = i11.f68798e;
        if (j11 == C.TIME_UNSET) {
            j11 = 0;
        }
        this.f75121k = j11;
    }

    private void h() {
        p.b k11 = l2.p.k(this.f75111a.e(), this.f75112b);
        if (this.f75124n == 3) {
            j(k11);
        }
        this.f75123m = k11.f68797d;
        long j11 = k11.f68798e;
        if (j11 == C.TIME_UNSET) {
            j11 = 0;
        }
        this.f75121k = j11;
    }

    private boolean i(androidx.media3.common.util.j0 j0Var) {
        while (j0Var.a() > 0) {
            int i11 = this.f75120j << 8;
            this.f75120j = i11;
            int H = i11 | j0Var.H();
            this.f75120j = H;
            int c11 = l2.p.c(H);
            this.f75124n = c11;
            if (c11 != 0) {
                byte[] e11 = this.f75111a.e();
                int i12 = this.f75120j;
                e11[0] = (byte) ((i12 >> 24) & 255);
                e11[1] = (byte) ((i12 >> 16) & 255);
                e11[2] = (byte) ((i12 >> 8) & 255);
                e11[3] = (byte) (i12 & 255);
                this.f75119i = 4;
                this.f75120j = 0;
                return true;
            }
        }
        return false;
    }

    private void j(p.b bVar) {
        int i11;
        int i12 = bVar.f68795b;
        if (i12 == -2147483647 || (i11 = bVar.f68796c) == -1) {
            return;
        }
        androidx.media3.common.r rVar = this.f75122l;
        if (rVar != null && i11 == rVar.E && i12 == rVar.F && Objects.equals(bVar.f68794a, rVar.f10243o)) {
            return;
        }
        androidx.media3.common.r rVar2 = this.f75122l;
        androidx.media3.common.r N = (rVar2 == null ? new r.b() : rVar2.b()).f0(this.f75116f).U(this.f75115e).u0(bVar.f68794a).R(bVar.f68796c).v0(bVar.f68795b).j0(this.f75113c).s0(this.f75114d).N();
        this.f75122l = N;
        this.f75117g.c(N);
    }

    @Override // s3.m
    public void a(androidx.media3.common.util.j0 j0Var) {
        androidx.media3.common.util.a.i(this.f75117g);
        while (j0Var.a() > 0) {
            switch (this.f75118h) {
                case 0:
                    if (!i(j0Var)) {
                        break;
                    } else {
                        int i11 = this.f75124n;
                        if (i11 != 3 && i11 != 4) {
                            if (i11 != 1) {
                                this.f75118h = 2;
                                break;
                            } else {
                                this.f75118h = 1;
                                break;
                            }
                        } else {
                            this.f75118h = 4;
                            break;
                        }
                    }
                case 1:
                    if (!e(j0Var, this.f75111a.e(), 18)) {
                        break;
                    } else {
                        f();
                        this.f75111a.W(0);
                        this.f75117g.b(this.f75111a, 18);
                        this.f75118h = 6;
                        break;
                    }
                case 2:
                    if (!e(j0Var, this.f75111a.e(), 7)) {
                        break;
                    } else {
                        this.f75125o = l2.p.j(this.f75111a.e());
                        this.f75118h = 3;
                        break;
                    }
                case 3:
                    if (!e(j0Var, this.f75111a.e(), this.f75125o)) {
                        break;
                    } else {
                        g();
                        this.f75111a.W(0);
                        this.f75117g.b(this.f75111a, this.f75125o);
                        this.f75118h = 6;
                        break;
                    }
                case 4:
                    if (!e(j0Var, this.f75111a.e(), 6)) {
                        break;
                    } else {
                        int l11 = l2.p.l(this.f75111a.e());
                        this.f75126p = l11;
                        int i12 = this.f75119i;
                        if (i12 > l11) {
                            int i13 = i12 - l11;
                            this.f75119i = i12 - i13;
                            j0Var.W(j0Var.f() - i13);
                        }
                        this.f75118h = 5;
                        break;
                    }
                case 5:
                    if (!e(j0Var, this.f75111a.e(), this.f75126p)) {
                        break;
                    } else {
                        h();
                        this.f75111a.W(0);
                        this.f75117g.b(this.f75111a, this.f75126p);
                        this.f75118h = 6;
                        break;
                    }
                case 6:
                    int min = Math.min(j0Var.a(), this.f75123m - this.f75119i);
                    this.f75117g.b(j0Var, min);
                    int i14 = this.f75119i + min;
                    this.f75119i = i14;
                    if (i14 == this.f75123m) {
                        androidx.media3.common.util.a.g(this.f75127q != C.TIME_UNSET);
                        this.f75117g.d(this.f75127q, this.f75124n == 4 ? 0 : 1, this.f75123m, 0, null);
                        this.f75127q += this.f75121k;
                        this.f75118h = 0;
                        break;
                    } else {
                        break;
                    }
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // s3.m
    public void b(long j11, int i11) {
        this.f75127q = j11;
    }

    @Override // s3.m
    public void c(boolean z10) {
    }

    @Override // s3.m
    public void d(l2.t tVar, l0.d dVar) {
        dVar.a();
        this.f75116f = dVar.b();
        this.f75117g = tVar.track(dVar.c(), 1);
    }

    @Override // s3.m
    public void seek() {
        this.f75118h = 0;
        this.f75119i = 0;
        this.f75120j = 0;
        this.f75127q = C.TIME_UNSET;
        this.f75112b.set(0);
    }
}
