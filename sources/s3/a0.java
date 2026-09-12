package s3;

import androidx.media3.common.util.a1;
import androidx.media3.common.util.p0;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes2.dex */
final class a0 {

    /* renamed from: c, reason: collision with root package name */
    private boolean f74985c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f74986d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f74987e;

    /* renamed from: a, reason: collision with root package name */
    private final p0 f74983a = new p0(0);

    /* renamed from: f, reason: collision with root package name */
    private long f74988f = C.TIME_UNSET;

    /* renamed from: g, reason: collision with root package name */
    private long f74989g = C.TIME_UNSET;

    /* renamed from: h, reason: collision with root package name */
    private long f74990h = C.TIME_UNSET;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f74984b = new androidx.media3.common.util.j0();

    private static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    private int b(l2.s sVar) {
        this.f74984b.T(a1.f10437f);
        this.f74985c = true;
        sVar.resetPeekPosition();
        return 0;
    }

    private int f(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
    }

    private int h(l2.s sVar, l2.l0 l0Var) {
        int min = (int) Math.min(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, sVar.getLength());
        long j11 = 0;
        if (sVar.getPosition() != j11) {
            l0Var.f68743a = j11;
            return 1;
        }
        this.f74984b.S(min);
        sVar.resetPeekPosition();
        sVar.peekFully(this.f74984b.e(), 0, min);
        this.f74988f = i(this.f74984b);
        this.f74986d = true;
        return 0;
    }

    private long i(androidx.media3.common.util.j0 j0Var) {
        int g11 = j0Var.g();
        for (int f11 = j0Var.f(); f11 < g11 - 3; f11++) {
            if (f(j0Var.e(), f11) == 442) {
                j0Var.W(f11 + 4);
                long l11 = l(j0Var);
                if (l11 != C.TIME_UNSET) {
                    return l11;
                }
            }
        }
        return C.TIME_UNSET;
    }

    private int j(l2.s sVar, l2.l0 l0Var) {
        long length = sVar.getLength();
        int min = (int) Math.min(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, length);
        long j11 = length - min;
        if (sVar.getPosition() != j11) {
            l0Var.f68743a = j11;
            return 1;
        }
        this.f74984b.S(min);
        sVar.resetPeekPosition();
        sVar.peekFully(this.f74984b.e(), 0, min);
        this.f74989g = k(this.f74984b);
        this.f74987e = true;
        return 0;
    }

    private long k(androidx.media3.common.util.j0 j0Var) {
        int f11 = j0Var.f();
        for (int g11 = j0Var.g() - 4; g11 >= f11; g11--) {
            if (f(j0Var.e(), g11) == 442) {
                j0Var.W(g11 + 4);
                long l11 = l(j0Var);
                if (l11 != C.TIME_UNSET) {
                    return l11;
                }
            }
        }
        return C.TIME_UNSET;
    }

    public static long l(androidx.media3.common.util.j0 j0Var) {
        int f11 = j0Var.f();
        if (j0Var.a() < 9) {
            return C.TIME_UNSET;
        }
        byte[] bArr = new byte[9];
        j0Var.l(bArr, 0, 9);
        j0Var.W(f11);
        return !a(bArr) ? C.TIME_UNSET : m(bArr);
    }

    private static long m(byte[] bArr) {
        byte b11 = bArr[0];
        long j11 = (((b11 & 56) >> 3) << 30) | ((b11 & 3) << 28) | ((bArr[1] & 255) << 20);
        byte b12 = bArr[2];
        return j11 | (((b12 & 248) >> 3) << 15) | ((b12 & 3) << 13) | ((bArr[3] & 255) << 5) | ((bArr[4] & 248) >> 3);
    }

    public long c() {
        return this.f74990h;
    }

    public p0 d() {
        return this.f74983a;
    }

    public boolean e() {
        return this.f74985c;
    }

    public int g(l2.s sVar, l2.l0 l0Var) {
        if (!this.f74987e) {
            return j(sVar, l0Var);
        }
        if (this.f74989g == C.TIME_UNSET) {
            return b(sVar);
        }
        if (!this.f74986d) {
            return h(sVar, l0Var);
        }
        long j11 = this.f74988f;
        if (j11 == C.TIME_UNSET) {
            return b(sVar);
        }
        this.f74990h = this.f74983a.c(this.f74989g) - this.f74983a.b(j11);
        return b(sVar);
    }
}
