package s3;

import androidx.media3.common.util.a1;
import androidx.media3.common.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes2.dex */
final class i0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f75100a;

    /* renamed from: d, reason: collision with root package name */
    private boolean f75103d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f75104e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f75105f;

    /* renamed from: b, reason: collision with root package name */
    private final p0 f75101b = new p0(0);

    /* renamed from: g, reason: collision with root package name */
    private long f75106g = C.TIME_UNSET;

    /* renamed from: h, reason: collision with root package name */
    private long f75107h = C.TIME_UNSET;

    /* renamed from: i, reason: collision with root package name */
    private long f75108i = C.TIME_UNSET;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f75102c = new androidx.media3.common.util.j0();

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0(int i11) {
        this.f75100a = i11;
    }

    private int a(l2.s sVar) {
        this.f75102c.T(a1.f10437f);
        this.f75103d = true;
        sVar.resetPeekPosition();
        return 0;
    }

    private int f(l2.s sVar, l2.l0 l0Var, int i11) {
        int min = (int) Math.min(this.f75100a, sVar.getLength());
        long j11 = 0;
        if (sVar.getPosition() != j11) {
            l0Var.f68743a = j11;
            return 1;
        }
        this.f75102c.S(min);
        sVar.resetPeekPosition();
        sVar.peekFully(this.f75102c.e(), 0, min);
        this.f75106g = g(this.f75102c, i11);
        this.f75104e = true;
        return 0;
    }

    private long g(androidx.media3.common.util.j0 j0Var, int i11) {
        int g11 = j0Var.g();
        for (int f11 = j0Var.f(); f11 < g11; f11++) {
            if (j0Var.e()[f11] == 71) {
                long c11 = m0.c(j0Var, f11, i11);
                if (c11 != C.TIME_UNSET) {
                    return c11;
                }
            }
        }
        return C.TIME_UNSET;
    }

    private int h(l2.s sVar, l2.l0 l0Var, int i11) {
        long length = sVar.getLength();
        int min = (int) Math.min(this.f75100a, length);
        long j11 = length - min;
        if (sVar.getPosition() != j11) {
            l0Var.f68743a = j11;
            return 1;
        }
        this.f75102c.S(min);
        sVar.resetPeekPosition();
        sVar.peekFully(this.f75102c.e(), 0, min);
        this.f75107h = i(this.f75102c, i11);
        this.f75105f = true;
        return 0;
    }

    private long i(androidx.media3.common.util.j0 j0Var, int i11) {
        int f11 = j0Var.f();
        int g11 = j0Var.g();
        for (int i12 = g11 - 188; i12 >= f11; i12--) {
            if (m0.b(j0Var.e(), f11, g11, i12)) {
                long c11 = m0.c(j0Var, i12, i11);
                if (c11 != C.TIME_UNSET) {
                    return c11;
                }
            }
        }
        return C.TIME_UNSET;
    }

    public long b() {
        return this.f75108i;
    }

    public p0 c() {
        return this.f75101b;
    }

    public boolean d() {
        return this.f75103d;
    }

    public int e(l2.s sVar, l2.l0 l0Var, int i11) {
        if (i11 <= 0) {
            return a(sVar);
        }
        if (!this.f75105f) {
            return h(sVar, l0Var, i11);
        }
        if (this.f75107h == C.TIME_UNSET) {
            return a(sVar);
        }
        if (!this.f75104e) {
            return f(sVar, l0Var, i11);
        }
        long j11 = this.f75106g;
        if (j11 == C.TIME_UNSET) {
            return a(sVar);
        }
        this.f75108i = this.f75101b.c(this.f75107h) - this.f75101b.b(j11);
        return a(sVar);
    }
}
