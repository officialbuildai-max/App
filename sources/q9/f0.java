package q9;

import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes4.dex */
final class f0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f73363a;

    /* renamed from: d, reason: collision with root package name */
    private boolean f73366d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f73367e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f73368f;

    /* renamed from: b, reason: collision with root package name */
    private final l0 f73364b = new l0(0);

    /* renamed from: g, reason: collision with root package name */
    private long f73369g = C.TIME_UNSET;

    /* renamed from: h, reason: collision with root package name */
    private long f73370h = C.TIME_UNSET;

    /* renamed from: i, reason: collision with root package name */
    private long f73371i = C.TIME_UNSET;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.d0 f73365c = new com.google.android.exoplayer2.util.d0();

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(int i11) {
        this.f73363a = i11;
    }

    private int a(g9.m mVar) {
        this.f73365c.M(p0.f27685f);
        this.f73366d = true;
        mVar.resetPeekPosition();
        return 0;
    }

    private int f(g9.m mVar, g9.a0 a0Var, int i11) {
        int min = (int) Math.min(this.f73363a, mVar.getLength());
        long j11 = 0;
        if (mVar.getPosition() != j11) {
            a0Var.f63492a = j11;
            return 1;
        }
        this.f73365c.L(min);
        mVar.resetPeekPosition();
        mVar.peekFully(this.f73365c.d(), 0, min);
        this.f73369g = g(this.f73365c, i11);
        this.f73367e = true;
        return 0;
    }

    private long g(com.google.android.exoplayer2.util.d0 d0Var, int i11) {
        int f11 = d0Var.f();
        for (int e11 = d0Var.e(); e11 < f11; e11++) {
            if (d0Var.d()[e11] == 71) {
                long c11 = j0.c(d0Var, e11, i11);
                if (c11 != C.TIME_UNSET) {
                    return c11;
                }
            }
        }
        return C.TIME_UNSET;
    }

    private int h(g9.m mVar, g9.a0 a0Var, int i11) {
        long length = mVar.getLength();
        int min = (int) Math.min(this.f73363a, length);
        long j11 = length - min;
        if (mVar.getPosition() != j11) {
            a0Var.f63492a = j11;
            return 1;
        }
        this.f73365c.L(min);
        mVar.resetPeekPosition();
        mVar.peekFully(this.f73365c.d(), 0, min);
        this.f73370h = i(this.f73365c, i11);
        this.f73368f = true;
        return 0;
    }

    private long i(com.google.android.exoplayer2.util.d0 d0Var, int i11) {
        int e11 = d0Var.e();
        int f11 = d0Var.f();
        for (int i12 = f11 - 188; i12 >= e11; i12--) {
            if (j0.b(d0Var.d(), e11, f11, i12)) {
                long c11 = j0.c(d0Var, i12, i11);
                if (c11 != C.TIME_UNSET) {
                    return c11;
                }
            }
        }
        return C.TIME_UNSET;
    }

    public long b() {
        return this.f73371i;
    }

    public l0 c() {
        return this.f73364b;
    }

    public boolean d() {
        return this.f73366d;
    }

    public int e(g9.m mVar, g9.a0 a0Var, int i11) {
        if (i11 <= 0) {
            return a(mVar);
        }
        if (!this.f73368f) {
            return h(mVar, a0Var, i11);
        }
        if (this.f73370h == C.TIME_UNSET) {
            return a(mVar);
        }
        if (!this.f73367e) {
            return f(mVar, a0Var, i11);
        }
        long j11 = this.f73369g;
        if (j11 == C.TIME_UNSET) {
            return a(mVar);
        }
        long b11 = this.f73364b.b(this.f73370h) - this.f73364b.b(j11);
        this.f73371i = b11;
        if (b11 < 0) {
            com.google.android.exoplayer2.util.s.i("TsDurationReader", "Invalid duration: " + this.f73371i + ". Using TIME_UNSET instead.");
            this.f73371i = C.TIME_UNSET;
        }
        return a(mVar);
    }
}
