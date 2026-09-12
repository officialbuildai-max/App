package q9;

import com.google.android.exoplayer2.audio.b0;
import com.google.android.exoplayer2.o1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import q9.i0;

/* loaded from: classes4.dex */
public final class t implements m {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f73618a;

    /* renamed from: b, reason: collision with root package name */
    private final b0.a f73619b;

    /* renamed from: c, reason: collision with root package name */
    private final String f73620c;

    /* renamed from: d, reason: collision with root package name */
    private g9.e0 f73621d;

    /* renamed from: e, reason: collision with root package name */
    private String f73622e;

    /* renamed from: f, reason: collision with root package name */
    private int f73623f;

    /* renamed from: g, reason: collision with root package name */
    private int f73624g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f73625h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f73626i;

    /* renamed from: j, reason: collision with root package name */
    private long f73627j;

    /* renamed from: k, reason: collision with root package name */
    private int f73628k;

    /* renamed from: l, reason: collision with root package name */
    private long f73629l;

    public t() {
        this(null);
    }

    public t(String str) {
        this.f73623f = 0;
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(4);
        this.f73618a = d0Var;
        d0Var.d()[0] = -1;
        this.f73619b = new b0.a();
        this.f73629l = C.TIME_UNSET;
        this.f73620c = str;
    }

    private void d(com.google.android.exoplayer2.util.d0 d0Var) {
        byte[] d11 = d0Var.d();
        int f11 = d0Var.f();
        for (int e11 = d0Var.e(); e11 < f11; e11++) {
            byte b11 = d11[e11];
            boolean z10 = (b11 & 255) == 255;
            boolean z11 = this.f73626i && (b11 & 224) == 224;
            this.f73626i = z10;
            if (z11) {
                d0Var.P(e11 + 1);
                this.f73626i = false;
                this.f73618a.d()[1] = d11[e11];
                this.f73624g = 2;
                this.f73623f = 1;
                return;
            }
        }
        d0Var.P(f11);
    }

    private void e(com.google.android.exoplayer2.util.d0 d0Var) {
        int min = Math.min(d0Var.a(), this.f73628k - this.f73624g);
        this.f73621d.c(d0Var, min);
        int i11 = this.f73624g + min;
        this.f73624g = i11;
        int i12 = this.f73628k;
        if (i11 < i12) {
            return;
        }
        long j11 = this.f73629l;
        if (j11 != C.TIME_UNSET) {
            this.f73621d.d(j11, 1, i12, 0, null);
            this.f73629l += this.f73627j;
        }
        this.f73624g = 0;
        this.f73623f = 0;
    }

    private void f(com.google.android.exoplayer2.util.d0 d0Var) {
        int min = Math.min(d0Var.a(), 4 - this.f73624g);
        d0Var.j(this.f73618a.d(), this.f73624g, min);
        int i11 = this.f73624g + min;
        this.f73624g = i11;
        if (i11 < 4) {
            return;
        }
        this.f73618a.P(0);
        if (!this.f73619b.a(this.f73618a.n())) {
            this.f73624g = 0;
            this.f73623f = 1;
            return;
        }
        this.f73628k = this.f73619b.f24677c;
        if (!this.f73625h) {
            this.f73627j = (r8.f24681g * 1000000) / r8.f24678d;
            this.f73621d.e(new o1.b().S(this.f73622e).e0(this.f73619b.f24676b).W(4096).H(this.f73619b.f24679e).f0(this.f73619b.f24678d).V(this.f73620c).E());
            this.f73625h = true;
        }
        this.f73618a.P(0);
        this.f73621d.c(this.f73618a, 4);
        this.f73623f = 2;
    }

    @Override // q9.m
    public void a(com.google.android.exoplayer2.util.d0 d0Var) {
        com.google.android.exoplayer2.util.a.i(this.f73621d);
        while (d0Var.a() > 0) {
            int i11 = this.f73623f;
            if (i11 == 0) {
                d(d0Var);
            } else if (i11 == 1) {
                f(d0Var);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException();
                }
                e(d0Var);
            }
        }
    }

    @Override // q9.m
    public void b(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f73629l = j11;
        }
    }

    @Override // q9.m
    public void c(g9.n nVar, i0.d dVar) {
        dVar.a();
        this.f73622e = dVar.b();
        this.f73621d = nVar.track(dVar.c(), 1);
    }

    @Override // q9.m
    public void packetFinished() {
    }

    @Override // q9.m
    public void seek() {
        this.f73623f = 0;
        this.f73624g = 0;
        this.f73626i = false;
        this.f73629l = C.TIME_UNSET;
    }
}
