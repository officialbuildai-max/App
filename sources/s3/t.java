package s3;

import androidx.media3.common.r;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import l2.i0;
import l2.s0;
import s3.l0;

/* loaded from: classes2.dex */
public final class t implements m {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f75339a;

    /* renamed from: b, reason: collision with root package name */
    private final i0.a f75340b;

    /* renamed from: c, reason: collision with root package name */
    private final String f75341c;

    /* renamed from: d, reason: collision with root package name */
    private final int f75342d;

    /* renamed from: e, reason: collision with root package name */
    private final String f75343e;

    /* renamed from: f, reason: collision with root package name */
    private s0 f75344f;

    /* renamed from: g, reason: collision with root package name */
    private String f75345g;

    /* renamed from: h, reason: collision with root package name */
    private int f75346h;

    /* renamed from: i, reason: collision with root package name */
    private int f75347i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f75348j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f75349k;

    /* renamed from: l, reason: collision with root package name */
    private long f75350l;

    /* renamed from: m, reason: collision with root package name */
    private int f75351m;

    /* renamed from: n, reason: collision with root package name */
    private long f75352n;

    public t(String str) {
        this(null, 0, str);
    }

    public t(String str, int i11, String str2) {
        this.f75346h = 0;
        androidx.media3.common.util.j0 j0Var = new androidx.media3.common.util.j0(4);
        this.f75339a = j0Var;
        j0Var.e()[0] = -1;
        this.f75340b = new i0.a();
        this.f75352n = C.TIME_UNSET;
        this.f75341c = str;
        this.f75342d = i11;
        this.f75343e = str2;
    }

    private void e(androidx.media3.common.util.j0 j0Var) {
        byte[] e11 = j0Var.e();
        int g11 = j0Var.g();
        for (int f11 = j0Var.f(); f11 < g11; f11++) {
            byte b11 = e11[f11];
            boolean z10 = (b11 & 255) == 255;
            boolean z11 = this.f75349k && (b11 & 224) == 224;
            this.f75349k = z10;
            if (z11) {
                j0Var.W(f11 + 1);
                this.f75349k = false;
                this.f75339a.e()[1] = e11[f11];
                this.f75347i = 2;
                this.f75346h = 1;
                return;
            }
        }
        j0Var.W(g11);
    }

    private void f(androidx.media3.common.util.j0 j0Var) {
        int min = Math.min(j0Var.a(), this.f75351m - this.f75347i);
        this.f75344f.b(j0Var, min);
        int i11 = this.f75347i + min;
        this.f75347i = i11;
        if (i11 < this.f75351m) {
            return;
        }
        androidx.media3.common.util.a.g(this.f75352n != C.TIME_UNSET);
        this.f75344f.d(this.f75352n, 1, this.f75351m, 0, null);
        this.f75352n += this.f75350l;
        this.f75347i = 0;
        this.f75346h = 0;
    }

    private void g(androidx.media3.common.util.j0 j0Var) {
        int min = Math.min(j0Var.a(), 4 - this.f75347i);
        j0Var.l(this.f75339a.e(), this.f75347i, min);
        int i11 = this.f75347i + min;
        this.f75347i = i11;
        if (i11 < 4) {
            return;
        }
        this.f75339a.W(0);
        if (!this.f75340b.a(this.f75339a.q())) {
            this.f75347i = 0;
            this.f75346h = 1;
            return;
        }
        this.f75351m = this.f75340b.f68731c;
        if (!this.f75348j) {
            this.f75350l = (r8.f68735g * 1000000) / r8.f68732d;
            this.f75344f.c(new r.b().f0(this.f75345g).U(this.f75343e).u0(this.f75340b.f68730b).k0(4096).R(this.f75340b.f68733e).v0(this.f75340b.f68732d).j0(this.f75341c).s0(this.f75342d).N());
            this.f75348j = true;
        }
        this.f75339a.W(0);
        this.f75344f.b(this.f75339a, 4);
        this.f75346h = 2;
    }

    @Override // s3.m
    public void a(androidx.media3.common.util.j0 j0Var) {
        androidx.media3.common.util.a.i(this.f75344f);
        while (j0Var.a() > 0) {
            int i11 = this.f75346h;
            if (i11 == 0) {
                e(j0Var);
            } else if (i11 == 1) {
                g(j0Var);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException();
                }
                f(j0Var);
            }
        }
    }

    @Override // s3.m
    public void b(long j11, int i11) {
        this.f75352n = j11;
    }

    @Override // s3.m
    public void c(boolean z10) {
    }

    @Override // s3.m
    public void d(l2.t tVar, l0.d dVar) {
        dVar.a();
        this.f75345g = dVar.b();
        this.f75344f = tVar.track(dVar.c(), 1);
    }

    @Override // s3.m
    public void seek() {
        this.f75346h = 0;
        this.f75347i = 0;
        this.f75349k = false;
        this.f75352n = C.TIME_UNSET;
    }
}
