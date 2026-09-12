package q9;

import com.google.android.exoplayer2.o1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import q9.i0;

/* loaded from: classes4.dex */
public final class k implements m {

    /* renamed from: b, reason: collision with root package name */
    private final String f73449b;

    /* renamed from: c, reason: collision with root package name */
    private String f73450c;

    /* renamed from: d, reason: collision with root package name */
    private g9.e0 f73451d;

    /* renamed from: f, reason: collision with root package name */
    private int f73453f;

    /* renamed from: g, reason: collision with root package name */
    private int f73454g;

    /* renamed from: h, reason: collision with root package name */
    private long f73455h;

    /* renamed from: i, reason: collision with root package name */
    private o1 f73456i;

    /* renamed from: j, reason: collision with root package name */
    private int f73457j;

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f73448a = new com.google.android.exoplayer2.util.d0(new byte[18]);

    /* renamed from: e, reason: collision with root package name */
    private int f73452e = 0;

    /* renamed from: k, reason: collision with root package name */
    private long f73458k = C.TIME_UNSET;

    public k(String str) {
        this.f73449b = str;
    }

    private boolean d(com.google.android.exoplayer2.util.d0 d0Var, byte[] bArr, int i11) {
        int min = Math.min(d0Var.a(), i11 - this.f73453f);
        d0Var.j(bArr, this.f73453f, min);
        int i12 = this.f73453f + min;
        this.f73453f = i12;
        return i12 == i11;
    }

    private void e() {
        byte[] d11 = this.f73448a.d();
        if (this.f73456i == null) {
            o1 g11 = com.google.android.exoplayer2.audio.y.g(d11, this.f73450c, this.f73449b, null);
            this.f73456i = g11;
            this.f73451d.e(g11);
        }
        this.f73457j = com.google.android.exoplayer2.audio.y.a(d11);
        this.f73455h = (int) ((com.google.android.exoplayer2.audio.y.f(d11) * 1000000) / this.f73456i.f25564z);
    }

    private boolean f(com.google.android.exoplayer2.util.d0 d0Var) {
        while (d0Var.a() > 0) {
            int i11 = this.f73454g << 8;
            this.f73454g = i11;
            int D = i11 | d0Var.D();
            this.f73454g = D;
            if (com.google.android.exoplayer2.audio.y.d(D)) {
                byte[] d11 = this.f73448a.d();
                int i12 = this.f73454g;
                d11[0] = (byte) ((i12 >> 24) & 255);
                d11[1] = (byte) ((i12 >> 16) & 255);
                d11[2] = (byte) ((i12 >> 8) & 255);
                d11[3] = (byte) (i12 & 255);
                this.f73453f = 4;
                this.f73454g = 0;
                return true;
            }
        }
        return false;
    }

    @Override // q9.m
    public void a(com.google.android.exoplayer2.util.d0 d0Var) {
        com.google.android.exoplayer2.util.a.i(this.f73451d);
        while (d0Var.a() > 0) {
            int i11 = this.f73452e;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 != 2) {
                        throw new IllegalStateException();
                    }
                    int min = Math.min(d0Var.a(), this.f73457j - this.f73453f);
                    this.f73451d.c(d0Var, min);
                    int i12 = this.f73453f + min;
                    this.f73453f = i12;
                    int i13 = this.f73457j;
                    if (i12 == i13) {
                        long j11 = this.f73458k;
                        if (j11 != C.TIME_UNSET) {
                            this.f73451d.d(j11, 1, i13, 0, null);
                            this.f73458k += this.f73455h;
                        }
                        this.f73452e = 0;
                    }
                } else if (d(d0Var, this.f73448a.d(), 18)) {
                    e();
                    this.f73448a.P(0);
                    this.f73451d.c(this.f73448a, 18);
                    this.f73452e = 2;
                }
            } else if (f(d0Var)) {
                this.f73452e = 1;
            }
        }
    }

    @Override // q9.m
    public void b(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f73458k = j11;
        }
    }

    @Override // q9.m
    public void c(g9.n nVar, i0.d dVar) {
        dVar.a();
        this.f73450c = dVar.b();
        this.f73451d = nVar.track(dVar.c(), 1);
    }

    @Override // q9.m
    public void packetFinished() {
    }

    @Override // q9.m
    public void seek() {
        this.f73452e = 0;
        this.f73453f = 0;
        this.f73454g = 0;
        this.f73458k = C.TIME_UNSET;
    }
}
