package q9;

import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes4.dex */
final class y {

    /* renamed from: c, reason: collision with root package name */
    private boolean f73654c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f73655d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f73656e;

    /* renamed from: a, reason: collision with root package name */
    private final l0 f73652a = new l0(0);

    /* renamed from: f, reason: collision with root package name */
    private long f73657f = C.TIME_UNSET;

    /* renamed from: g, reason: collision with root package name */
    private long f73658g = C.TIME_UNSET;

    /* renamed from: h, reason: collision with root package name */
    private long f73659h = C.TIME_UNSET;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f73653b = new com.google.android.exoplayer2.util.d0();

    private static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    private int b(g9.m mVar) {
        this.f73653b.M(p0.f27685f);
        this.f73654c = true;
        mVar.resetPeekPosition();
        return 0;
    }

    private int f(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
    }

    private int h(g9.m mVar, g9.a0 a0Var) {
        int min = (int) Math.min(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, mVar.getLength());
        long j11 = 0;
        if (mVar.getPosition() != j11) {
            a0Var.f63492a = j11;
            return 1;
        }
        this.f73653b.L(min);
        mVar.resetPeekPosition();
        mVar.peekFully(this.f73653b.d(), 0, min);
        this.f73657f = i(this.f73653b);
        this.f73655d = true;
        return 0;
    }

    private long i(com.google.android.exoplayer2.util.d0 d0Var) {
        int f11 = d0Var.f();
        for (int e11 = d0Var.e(); e11 < f11 - 3; e11++) {
            if (f(d0Var.d(), e11) == 442) {
                d0Var.P(e11 + 4);
                long l11 = l(d0Var);
                if (l11 != C.TIME_UNSET) {
                    return l11;
                }
            }
        }
        return C.TIME_UNSET;
    }

    private int j(g9.m mVar, g9.a0 a0Var) {
        long length = mVar.getLength();
        int min = (int) Math.min(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, length);
        long j11 = length - min;
        if (mVar.getPosition() != j11) {
            a0Var.f63492a = j11;
            return 1;
        }
        this.f73653b.L(min);
        mVar.resetPeekPosition();
        mVar.peekFully(this.f73653b.d(), 0, min);
        this.f73658g = k(this.f73653b);
        this.f73656e = true;
        return 0;
    }

    private long k(com.google.android.exoplayer2.util.d0 d0Var) {
        int e11 = d0Var.e();
        for (int f11 = d0Var.f() - 4; f11 >= e11; f11--) {
            if (f(d0Var.d(), f11) == 442) {
                d0Var.P(f11 + 4);
                long l11 = l(d0Var);
                if (l11 != C.TIME_UNSET) {
                    return l11;
                }
            }
        }
        return C.TIME_UNSET;
    }

    public static long l(com.google.android.exoplayer2.util.d0 d0Var) {
        int e11 = d0Var.e();
        if (d0Var.a() < 9) {
            return C.TIME_UNSET;
        }
        byte[] bArr = new byte[9];
        d0Var.j(bArr, 0, 9);
        d0Var.P(e11);
        return !a(bArr) ? C.TIME_UNSET : m(bArr);
    }

    private static long m(byte[] bArr) {
        byte b11 = bArr[0];
        long j11 = (((b11 & 56) >> 3) << 30) | ((b11 & 3) << 28) | ((bArr[1] & 255) << 20);
        byte b12 = bArr[2];
        return j11 | (((b12 & 248) >> 3) << 15) | ((b12 & 3) << 13) | ((bArr[3] & 255) << 5) | ((bArr[4] & 248) >> 3);
    }

    public long c() {
        return this.f73659h;
    }

    public l0 d() {
        return this.f73652a;
    }

    public boolean e() {
        return this.f73654c;
    }

    public int g(g9.m mVar, g9.a0 a0Var) {
        if (!this.f73656e) {
            return j(mVar, a0Var);
        }
        if (this.f73658g == C.TIME_UNSET) {
            return b(mVar);
        }
        if (!this.f73655d) {
            return h(mVar, a0Var);
        }
        long j11 = this.f73657f;
        if (j11 == C.TIME_UNSET) {
            return b(mVar);
        }
        long b11 = this.f73652a.b(this.f73658g) - this.f73652a.b(j11);
        this.f73659h = b11;
        if (b11 < 0) {
            com.google.android.exoplayer2.util.s.i("PsDurationReader", "Invalid duration: " + this.f73659h + ". Using TIME_UNSET instead.");
            this.f73659h = C.TIME_UNSET;
        }
        return b(mVar);
    }
}
