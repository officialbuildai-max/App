package q9;

import com.google.android.exoplayer2.audio.c;
import com.google.android.exoplayer2.o1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import q9.i0;

/* loaded from: classes4.dex */
public final class f implements m {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.c0 f73350a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f73351b;

    /* renamed from: c, reason: collision with root package name */
    private final String f73352c;

    /* renamed from: d, reason: collision with root package name */
    private String f73353d;

    /* renamed from: e, reason: collision with root package name */
    private g9.e0 f73354e;

    /* renamed from: f, reason: collision with root package name */
    private int f73355f;

    /* renamed from: g, reason: collision with root package name */
    private int f73356g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f73357h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f73358i;

    /* renamed from: j, reason: collision with root package name */
    private long f73359j;

    /* renamed from: k, reason: collision with root package name */
    private o1 f73360k;

    /* renamed from: l, reason: collision with root package name */
    private int f73361l;

    /* renamed from: m, reason: collision with root package name */
    private long f73362m;

    public f() {
        this(null);
    }

    public f(String str) {
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(new byte[16]);
        this.f73350a = c0Var;
        this.f73351b = new com.google.android.exoplayer2.util.d0(c0Var.f27614a);
        this.f73355f = 0;
        this.f73356g = 0;
        this.f73357h = false;
        this.f73358i = false;
        this.f73362m = C.TIME_UNSET;
        this.f73352c = str;
    }

    private boolean d(com.google.android.exoplayer2.util.d0 d0Var, byte[] bArr, int i11) {
        int min = Math.min(d0Var.a(), i11 - this.f73356g);
        d0Var.j(bArr, this.f73356g, min);
        int i12 = this.f73356g + min;
        this.f73356g = i12;
        return i12 == i11;
    }

    private void e() {
        this.f73350a.p(0);
        c.b d11 = com.google.android.exoplayer2.audio.c.d(this.f73350a);
        o1 o1Var = this.f73360k;
        if (o1Var == null || d11.f24685c != o1Var.f25563y || d11.f24684b != o1Var.f25564z || !"audio/ac4".equals(o1Var.f25550l)) {
            o1 E = new o1.b().S(this.f73353d).e0("audio/ac4").H(d11.f24685c).f0(d11.f24684b).V(this.f73352c).E();
            this.f73360k = E;
            this.f73354e.e(E);
        }
        this.f73361l = d11.f24686d;
        this.f73359j = (d11.f24687e * 1000000) / this.f73360k.f25564z;
    }

    private boolean f(com.google.android.exoplayer2.util.d0 d0Var) {
        int D;
        while (true) {
            if (d0Var.a() <= 0) {
                return false;
            }
            if (this.f73357h) {
                D = d0Var.D();
                this.f73357h = D == 172;
                if (D == 64 || D == 65) {
                    break;
                }
            } else {
                this.f73357h = d0Var.D() == 172;
            }
        }
        this.f73358i = D == 65;
        return true;
    }

    @Override // q9.m
    public void a(com.google.android.exoplayer2.util.d0 d0Var) {
        com.google.android.exoplayer2.util.a.i(this.f73354e);
        while (d0Var.a() > 0) {
            int i11 = this.f73355f;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        int min = Math.min(d0Var.a(), this.f73361l - this.f73356g);
                        this.f73354e.c(d0Var, min);
                        int i12 = this.f73356g + min;
                        this.f73356g = i12;
                        int i13 = this.f73361l;
                        if (i12 == i13) {
                            long j11 = this.f73362m;
                            if (j11 != C.TIME_UNSET) {
                                this.f73354e.d(j11, 1, i13, 0, null);
                                this.f73362m += this.f73359j;
                            }
                            this.f73355f = 0;
                        }
                    }
                } else if (d(d0Var, this.f73351b.d(), 16)) {
                    e();
                    this.f73351b.P(0);
                    this.f73354e.c(this.f73351b, 16);
                    this.f73355f = 2;
                }
            } else if (f(d0Var)) {
                this.f73355f = 1;
                this.f73351b.d()[0] = -84;
                this.f73351b.d()[1] = (byte) (this.f73358i ? 65 : 64);
                this.f73356g = 2;
            }
        }
    }

    @Override // q9.m
    public void b(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f73362m = j11;
        }
    }

    @Override // q9.m
    public void c(g9.n nVar, i0.d dVar) {
        dVar.a();
        this.f73353d = dVar.b();
        this.f73354e = nVar.track(dVar.c(), 1);
    }

    @Override // q9.m
    public void packetFinished() {
    }

    @Override // q9.m
    public void seek() {
        this.f73355f = 0;
        this.f73356g = 0;
        this.f73357h = false;
        this.f73358i = false;
        this.f73362m = C.TIME_UNSET;
    }
}
