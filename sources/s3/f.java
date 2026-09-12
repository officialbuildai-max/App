package s3;

import androidx.media3.common.r;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import l2.c;
import l2.s0;
import s3.l0;

/* loaded from: classes2.dex */
public final class f implements m {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.media3.common.util.i0 f75039a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f75040b;

    /* renamed from: c, reason: collision with root package name */
    private final String f75041c;

    /* renamed from: d, reason: collision with root package name */
    private final int f75042d;

    /* renamed from: e, reason: collision with root package name */
    private final String f75043e;

    /* renamed from: f, reason: collision with root package name */
    private String f75044f;

    /* renamed from: g, reason: collision with root package name */
    private s0 f75045g;

    /* renamed from: h, reason: collision with root package name */
    private int f75046h;

    /* renamed from: i, reason: collision with root package name */
    private int f75047i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f75048j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f75049k;

    /* renamed from: l, reason: collision with root package name */
    private long f75050l;

    /* renamed from: m, reason: collision with root package name */
    private androidx.media3.common.r f75051m;

    /* renamed from: n, reason: collision with root package name */
    private int f75052n;

    /* renamed from: o, reason: collision with root package name */
    private long f75053o;

    public f(String str) {
        this(null, 0, str);
    }

    public f(String str, int i11, String str2) {
        androidx.media3.common.util.i0 i0Var = new androidx.media3.common.util.i0(new byte[16]);
        this.f75039a = i0Var;
        this.f75040b = new androidx.media3.common.util.j0(i0Var.f10470a);
        this.f75046h = 0;
        this.f75047i = 0;
        this.f75048j = false;
        this.f75049k = false;
        this.f75053o = C.TIME_UNSET;
        this.f75041c = str;
        this.f75042d = i11;
        this.f75043e = str2;
    }

    private boolean e(androidx.media3.common.util.j0 j0Var, byte[] bArr, int i11) {
        int min = Math.min(j0Var.a(), i11 - this.f75047i);
        j0Var.l(bArr, this.f75047i, min);
        int i12 = this.f75047i + min;
        this.f75047i = i12;
        return i12 == i11;
    }

    private void f() {
        this.f75039a.p(0);
        c.C0852c f11 = l2.c.f(this.f75039a);
        androidx.media3.common.r rVar = this.f75051m;
        if (rVar == null || f11.f68647c != rVar.E || f11.f68646b != rVar.F || !"audio/ac4".equals(rVar.f10243o)) {
            androidx.media3.common.r N = new r.b().f0(this.f75044f).U(this.f75043e).u0("audio/ac4").R(f11.f68647c).v0(f11.f68646b).j0(this.f75041c).s0(this.f75042d).N();
            this.f75051m = N;
            this.f75045g.c(N);
        }
        this.f75052n = f11.f68648d;
        this.f75050l = (f11.f68649e * 1000000) / this.f75051m.F;
    }

    private boolean g(androidx.media3.common.util.j0 j0Var) {
        int H;
        while (true) {
            if (j0Var.a() <= 0) {
                return false;
            }
            if (this.f75048j) {
                H = j0Var.H();
                this.f75048j = H == 172;
                if (H == 64 || H == 65) {
                    break;
                }
            } else {
                this.f75048j = j0Var.H() == 172;
            }
        }
        this.f75049k = H == 65;
        return true;
    }

    @Override // s3.m
    public void a(androidx.media3.common.util.j0 j0Var) {
        androidx.media3.common.util.a.i(this.f75045g);
        while (j0Var.a() > 0) {
            int i11 = this.f75046h;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        int min = Math.min(j0Var.a(), this.f75052n - this.f75047i);
                        this.f75045g.b(j0Var, min);
                        int i12 = this.f75047i + min;
                        this.f75047i = i12;
                        if (i12 == this.f75052n) {
                            androidx.media3.common.util.a.g(this.f75053o != C.TIME_UNSET);
                            this.f75045g.d(this.f75053o, 1, this.f75052n, 0, null);
                            this.f75053o += this.f75050l;
                            this.f75046h = 0;
                        }
                    }
                } else if (e(j0Var, this.f75040b.e(), 16)) {
                    f();
                    this.f75040b.W(0);
                    this.f75045g.b(this.f75040b, 16);
                    this.f75046h = 2;
                }
            } else if (g(j0Var)) {
                this.f75046h = 1;
                this.f75040b.e()[0] = -84;
                this.f75040b.e()[1] = (byte) (this.f75049k ? 65 : 64);
                this.f75047i = 2;
            }
        }
    }

    @Override // s3.m
    public void b(long j11, int i11) {
        this.f75053o = j11;
    }

    @Override // s3.m
    public void c(boolean z10) {
    }

    @Override // s3.m
    public void d(l2.t tVar, l0.d dVar) {
        dVar.a();
        this.f75044f = dVar.b();
        this.f75045g = tVar.track(dVar.c(), 1);
    }

    @Override // s3.m
    public void seek() {
        this.f75046h = 0;
        this.f75047i = 0;
        this.f75048j = false;
        this.f75049k = false;
        this.f75053o = C.TIME_UNSET;
    }
}
