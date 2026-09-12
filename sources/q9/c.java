package q9;

import com.google.android.exoplayer2.audio.b;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import q9.i0;

/* loaded from: classes4.dex */
public final class c implements m {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.c0 f73322a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f73323b;

    /* renamed from: c, reason: collision with root package name */
    private final String f73324c;

    /* renamed from: d, reason: collision with root package name */
    private String f73325d;

    /* renamed from: e, reason: collision with root package name */
    private g9.e0 f73326e;

    /* renamed from: f, reason: collision with root package name */
    private int f73327f;

    /* renamed from: g, reason: collision with root package name */
    private int f73328g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f73329h;

    /* renamed from: i, reason: collision with root package name */
    private long f73330i;

    /* renamed from: j, reason: collision with root package name */
    private o1 f73331j;

    /* renamed from: k, reason: collision with root package name */
    private int f73332k;

    /* renamed from: l, reason: collision with root package name */
    private long f73333l;

    public c() {
        this(null);
    }

    public c(String str) {
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(new byte[128]);
        this.f73322a = c0Var;
        this.f73323b = new com.google.android.exoplayer2.util.d0(c0Var.f27614a);
        this.f73327f = 0;
        this.f73333l = C.TIME_UNSET;
        this.f73324c = str;
    }

    private boolean d(com.google.android.exoplayer2.util.d0 d0Var, byte[] bArr, int i11) {
        int min = Math.min(d0Var.a(), i11 - this.f73328g);
        d0Var.j(bArr, this.f73328g, min);
        int i12 = this.f73328g + min;
        this.f73328g = i12;
        return i12 == i11;
    }

    private void e() {
        this.f73322a.p(0);
        b.C0365b e11 = com.google.android.exoplayer2.audio.b.e(this.f73322a);
        o1 o1Var = this.f73331j;
        if (o1Var == null || e11.f24665d != o1Var.f25563y || e11.f24664c != o1Var.f25564z || !p0.c(e11.f24662a, o1Var.f25550l)) {
            o1 E = new o1.b().S(this.f73325d).e0(e11.f24662a).H(e11.f24665d).f0(e11.f24664c).V(this.f73324c).E();
            this.f73331j = E;
            this.f73326e.e(E);
        }
        this.f73332k = e11.f24666e;
        this.f73330i = (e11.f24667f * 1000000) / this.f73331j.f25564z;
    }

    private boolean f(com.google.android.exoplayer2.util.d0 d0Var) {
        while (true) {
            if (d0Var.a() <= 0) {
                return false;
            }
            if (this.f73329h) {
                int D = d0Var.D();
                if (D == 119) {
                    this.f73329h = false;
                    return true;
                }
                this.f73329h = D == 11;
            } else {
                this.f73329h = d0Var.D() == 11;
            }
        }
    }

    @Override // q9.m
    public void a(com.google.android.exoplayer2.util.d0 d0Var) {
        com.google.android.exoplayer2.util.a.i(this.f73326e);
        while (d0Var.a() > 0) {
            int i11 = this.f73327f;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        int min = Math.min(d0Var.a(), this.f73332k - this.f73328g);
                        this.f73326e.c(d0Var, min);
                        int i12 = this.f73328g + min;
                        this.f73328g = i12;
                        int i13 = this.f73332k;
                        if (i12 == i13) {
                            long j11 = this.f73333l;
                            if (j11 != C.TIME_UNSET) {
                                this.f73326e.d(j11, 1, i13, 0, null);
                                this.f73333l += this.f73330i;
                            }
                            this.f73327f = 0;
                        }
                    }
                } else if (d(d0Var, this.f73323b.d(), 128)) {
                    e();
                    this.f73323b.P(0);
                    this.f73326e.c(this.f73323b, 128);
                    this.f73327f = 2;
                }
            } else if (f(d0Var)) {
                this.f73327f = 1;
                this.f73323b.d()[0] = 11;
                this.f73323b.d()[1] = 119;
                this.f73328g = 2;
            }
        }
    }

    @Override // q9.m
    public void b(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f73333l = j11;
        }
    }

    @Override // q9.m
    public void c(g9.n nVar, i0.d dVar) {
        dVar.a();
        this.f73325d = dVar.b();
        this.f73326e = nVar.track(dVar.c(), 1);
    }

    @Override // q9.m
    public void packetFinished() {
    }

    @Override // q9.m
    public void seek() {
        this.f73327f = 0;
        this.f73328g = 0;
        this.f73329h = false;
        this.f73333l = C.TIME_UNSET;
    }
}
