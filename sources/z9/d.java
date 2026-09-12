package z9;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.g;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.x;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.e0;
import g9.n;

/* loaded from: classes4.dex */
final class d implements e {

    /* renamed from: c, reason: collision with root package name */
    private final j f79503c;

    /* renamed from: d, reason: collision with root package name */
    private e0 f79504d;

    /* renamed from: e, reason: collision with root package name */
    private int f79505e;

    /* renamed from: h, reason: collision with root package name */
    private int f79508h;

    /* renamed from: i, reason: collision with root package name */
    private long f79509i;

    /* renamed from: b, reason: collision with root package name */
    private final d0 f79502b = new d0(x.f27718a);

    /* renamed from: a, reason: collision with root package name */
    private final d0 f79501a = new d0();

    /* renamed from: f, reason: collision with root package name */
    private long f79506f = C.TIME_UNSET;

    /* renamed from: g, reason: collision with root package name */
    private int f79507g = -1;

    public d(j jVar) {
        this.f79503c = jVar;
    }

    private static int d(int i11) {
        return i11 == 5 ? 1 : 0;
    }

    private void e(d0 d0Var, int i11) {
        byte b11 = d0Var.d()[0];
        byte b12 = d0Var.d()[1];
        int i12 = (b11 & 224) | (b12 & 31);
        boolean z10 = (b12 & 128) > 0;
        boolean z11 = (b12 & 64) > 0;
        if (z10) {
            this.f79508h += i();
            d0Var.d()[1] = (byte) i12;
            this.f79501a.M(d0Var.d());
            this.f79501a.P(1);
        } else {
            int b13 = g.b(this.f79507g);
            if (i11 != b13) {
                s.i("RtpH264Reader", p0.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(b13), Integer.valueOf(i11)));
                return;
            } else {
                this.f79501a.M(d0Var.d());
                this.f79501a.P(2);
            }
        }
        int a11 = this.f79501a.a();
        this.f79504d.c(this.f79501a, a11);
        this.f79508h += a11;
        if (z11) {
            this.f79505e = d(i12 & 31);
        }
    }

    private void f(d0 d0Var) {
        int a11 = d0Var.a();
        this.f79508h += i();
        this.f79504d.c(d0Var, a11);
        this.f79508h += a11;
        this.f79505e = d(d0Var.d()[0] & 31);
    }

    private void g(d0 d0Var) {
        d0Var.D();
        while (d0Var.a() > 4) {
            int J = d0Var.J();
            this.f79508h += i();
            this.f79504d.c(d0Var, J);
            this.f79508h += J;
        }
        this.f79505e = 0;
    }

    private static long h(long j11, long j12, long j13) {
        return j11 + p0.N0(j12 - j13, 1000000L, 90000L);
    }

    private int i() {
        this.f79502b.P(0);
        int a11 = this.f79502b.a();
        ((e0) com.google.android.exoplayer2.util.a.e(this.f79504d)).c(this.f79502b, a11);
        return a11;
    }

    @Override // z9.e
    public void a(d0 d0Var, long j11, int i11, boolean z10) {
        try {
            int i12 = d0Var.d()[0] & 31;
            com.google.android.exoplayer2.util.a.i(this.f79504d);
            if (i12 > 0 && i12 < 24) {
                f(d0Var);
            } else if (i12 == 24) {
                g(d0Var);
            } else {
                if (i12 != 28) {
                    throw ParserException.createForMalformedManifest(String.format("RTP H264 packetization mode [%d] not supported.", Integer.valueOf(i12)), null);
                }
                e(d0Var, i11);
            }
            if (z10) {
                if (this.f79506f == C.TIME_UNSET) {
                    this.f79506f = j11;
                }
                this.f79504d.d(h(this.f79509i, j11, this.f79506f), this.f79505e, this.f79508h, 0, null);
                this.f79508h = 0;
            }
            this.f79507g = i11;
        } catch (IndexOutOfBoundsException e11) {
            throw ParserException.createForMalformedManifest(null, e11);
        }
    }

    @Override // z9.e
    public void b(long j11, int i11) {
    }

    @Override // z9.e
    public void c(n nVar, int i11) {
        e0 track = nVar.track(i11, 2);
        this.f79504d = track;
        ((e0) p0.j(track)).e(this.f79503c.f26485c);
    }

    @Override // z9.e
    public void seek(long j11, long j12) {
        this.f79506f = j11;
        this.f79508h = 0;
        this.f79509i = j12;
    }
}
