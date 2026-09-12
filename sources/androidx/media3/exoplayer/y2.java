package androidx.media3.exoplayer;

import androidx.media3.exoplayer.source.q;
import androidx.media3.exoplayer.source.r;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class y2 {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.media3.exoplayer.source.q f13450a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13451b;

    /* renamed from: c, reason: collision with root package name */
    public final g2.u[] f13452c;

    /* renamed from: d, reason: collision with root package name */
    public final long f13453d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13454e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13455f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13456g;

    /* renamed from: h, reason: collision with root package name */
    public z2 f13457h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f13458i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean[] f13459j;

    /* renamed from: k, reason: collision with root package name */
    private final y3[] f13460k;

    /* renamed from: l, reason: collision with root package name */
    private final j2.e0 f13461l;

    /* renamed from: m, reason: collision with root package name */
    private final q3 f13462m;

    /* renamed from: n, reason: collision with root package name */
    private y2 f13463n;

    /* renamed from: o, reason: collision with root package name */
    private g2.z f13464o;

    /* renamed from: p, reason: collision with root package name */
    private j2.f0 f13465p;

    /* renamed from: q, reason: collision with root package name */
    private long f13466q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        y2 a(z2 z2Var, long j11);
    }

    public y2(y3[] y3VarArr, long j11, j2.e0 e0Var, androidx.media3.exoplayer.upstream.b bVar, q3 q3Var, z2 z2Var, j2.f0 f0Var, long j12) {
        this.f13460k = y3VarArr;
        this.f13466q = j11;
        this.f13461l = e0Var;
        this.f13462m = q3Var;
        r.b bVar2 = z2Var.f13470a;
        this.f13451b = bVar2.f12965a;
        this.f13457h = z2Var;
        this.f13453d = j12;
        this.f13464o = g2.z.f63387d;
        this.f13465p = f0Var;
        this.f13452c = new g2.u[y3VarArr.length];
        this.f13459j = new boolean[y3VarArr.length];
        this.f13450a = f(bVar2, q3Var, bVar, z2Var.f13471b, z2Var.f13473d, z2Var.f13475f);
    }

    private void c(g2.u[] uVarArr) {
        int i11 = 0;
        while (true) {
            y3[] y3VarArr = this.f13460k;
            if (i11 >= y3VarArr.length) {
                return;
            }
            if (y3VarArr[i11].getTrackType() == -2 && this.f13465p.c(i11)) {
                uVarArr[i11] = new g2.h();
            }
            i11++;
        }
    }

    private static androidx.media3.exoplayer.source.q f(r.b bVar, q3 q3Var, androidx.media3.exoplayer.upstream.b bVar2, long j11, long j12, boolean z10) {
        androidx.media3.exoplayer.source.q h11 = q3Var.h(bVar, bVar2, j11);
        return j12 != C.TIME_UNSET ? new androidx.media3.exoplayer.source.b(h11, !z10, 0L, j12) : h11;
    }

    private void g() {
        if (!u()) {
            return;
        }
        int i11 = 0;
        while (true) {
            j2.f0 f0Var = this.f13465p;
            if (i11 >= f0Var.f65877a) {
                return;
            }
            boolean c11 = f0Var.c(i11);
            j2.z zVar = this.f13465p.f65879c[i11];
            if (c11 && zVar != null) {
                zVar.disable();
            }
            i11++;
        }
    }

    private void h(g2.u[] uVarArr) {
        int i11 = 0;
        while (true) {
            y3[] y3VarArr = this.f13460k;
            if (i11 >= y3VarArr.length) {
                return;
            }
            if (y3VarArr[i11].getTrackType() == -2) {
                uVarArr[i11] = null;
            }
            i11++;
        }
    }

    private void i() {
        if (!u()) {
            return;
        }
        int i11 = 0;
        while (true) {
            j2.f0 f0Var = this.f13465p;
            if (i11 >= f0Var.f65877a) {
                return;
            }
            boolean c11 = f0Var.c(i11);
            j2.z zVar = this.f13465p.f65879c[i11];
            if (c11 && zVar != null) {
                zVar.enable();
            }
            i11++;
        }
    }

    private boolean u() {
        return this.f13463n == null;
    }

    private static void y(q3 q3Var, androidx.media3.exoplayer.source.q qVar) {
        try {
            if (qVar instanceof androidx.media3.exoplayer.source.b) {
                q3Var.z(((androidx.media3.exoplayer.source.b) qVar).f12764a);
            } else {
                q3Var.z(qVar);
            }
        } catch (RuntimeException e11) {
            androidx.media3.common.util.u.d("MediaPeriodHolder", "Period release failed.", e11);
        }
    }

    public void A(y2 y2Var) {
        if (y2Var == this.f13463n) {
            return;
        }
        g();
        this.f13463n = y2Var;
        i();
    }

    public void B(long j11) {
        this.f13466q = j11;
    }

    public long C(long j11) {
        return j11 - m();
    }

    public long D(long j11) {
        return j11 + m();
    }

    public void E() {
        androidx.media3.exoplayer.source.q qVar = this.f13450a;
        if (qVar instanceof androidx.media3.exoplayer.source.b) {
            long j11 = this.f13457h.f13473d;
            if (j11 == C.TIME_UNSET) {
                j11 = Long.MIN_VALUE;
            }
            ((androidx.media3.exoplayer.source.b) qVar).n(0L, j11);
        }
    }

    public long a(j2.f0 f0Var, long j11, boolean z10) {
        return b(f0Var, j11, z10, new boolean[this.f13460k.length]);
    }

    public long b(j2.f0 f0Var, long j11, boolean z10, boolean[] zArr) {
        int i11 = 0;
        while (true) {
            boolean z11 = true;
            if (i11 >= f0Var.f65877a) {
                break;
            }
            boolean[] zArr2 = this.f13459j;
            if (z10 || !f0Var.b(this.f13465p, i11)) {
                z11 = false;
            }
            zArr2[i11] = z11;
            i11++;
        }
        h(this.f13452c);
        g();
        this.f13465p = f0Var;
        i();
        long e11 = this.f13450a.e(f0Var.f65879c, this.f13459j, this.f13452c, zArr, j11);
        c(this.f13452c);
        this.f13456g = false;
        int i12 = 0;
        while (true) {
            g2.u[] uVarArr = this.f13452c;
            if (i12 >= uVarArr.length) {
                return e11;
            }
            if (uVarArr[i12] != null) {
                androidx.media3.common.util.a.g(f0Var.c(i12));
                if (this.f13460k[i12].getTrackType() != -2) {
                    this.f13456g = true;
                }
            } else {
                androidx.media3.common.util.a.g(f0Var.f65879c[i12] == null);
            }
            i12++;
        }
    }

    public boolean d(z2 z2Var) {
        if (b3.e(this.f13457h.f13474e, z2Var.f13474e)) {
            z2 z2Var2 = this.f13457h;
            if (z2Var2.f13471b == z2Var.f13471b && z2Var2.f13470a.equals(z2Var.f13470a)) {
                return true;
            }
        }
        return false;
    }

    public void e(v2 v2Var) {
        androidx.media3.common.util.a.g(u());
        this.f13450a.a(v2Var);
    }

    public long j() {
        if (!this.f13455f) {
            return this.f13457h.f13471b;
        }
        long bufferedPositionUs = this.f13456g ? this.f13450a.getBufferedPositionUs() : Long.MIN_VALUE;
        return bufferedPositionUs == Long.MIN_VALUE ? this.f13457h.f13474e : bufferedPositionUs;
    }

    public y2 k() {
        return this.f13463n;
    }

    public long l() {
        if (this.f13455f) {
            return this.f13450a.getNextLoadPositionUs();
        }
        return 0L;
    }

    public long m() {
        return this.f13466q;
    }

    public long n() {
        return this.f13457h.f13471b + this.f13466q;
    }

    public g2.z o() {
        return this.f13464o;
    }

    public j2.f0 p() {
        return this.f13465p;
    }

    public void q(float f11, androidx.media3.common.e0 e0Var, boolean z10) {
        this.f13455f = true;
        this.f13464o = this.f13450a.getTrackGroups();
        j2.f0 z11 = z(f11, e0Var, z10);
        z2 z2Var = this.f13457h;
        long j11 = z2Var.f13471b;
        long j12 = z2Var.f13474e;
        if (j12 != C.TIME_UNSET && j11 >= j12) {
            j11 = Math.max(0L, j12 - 1);
        }
        long a11 = a(z11, j11, false);
        long j13 = this.f13466q;
        z2 z2Var2 = this.f13457h;
        this.f13466q = j13 + (z2Var2.f13471b - a11);
        this.f13457h = z2Var2.b(a11);
    }

    public boolean r() {
        try {
            if (this.f13455f) {
                for (g2.u uVar : this.f13452c) {
                    if (uVar != null) {
                        uVar.maybeThrowError();
                    }
                }
            } else {
                this.f13450a.maybeThrowPrepareError();
            }
            return false;
        } catch (IOException unused) {
            return true;
        }
    }

    public boolean s() {
        return this.f13455f && (!this.f13456g || this.f13450a.getBufferedPositionUs() == Long.MIN_VALUE);
    }

    public boolean t() {
        return this.f13455f && (s() || j() - this.f13457h.f13471b >= this.f13453d);
    }

    public void v(q.a aVar, long j11) {
        this.f13454e = true;
        this.f13450a.g(aVar, j11);
    }

    public void w(long j11) {
        androidx.media3.common.util.a.g(u());
        if (this.f13455f) {
            this.f13450a.reevaluateBuffer(C(j11));
        }
    }

    public void x() {
        g();
        y(this.f13462m, this.f13450a);
    }

    public j2.f0 z(float f11, androidx.media3.common.e0 e0Var, boolean z10) {
        j2.f0 k11 = this.f13461l.k(this.f13460k, o(), this.f13457h.f13470a, e0Var);
        for (int i11 = 0; i11 < k11.f65877a; i11++) {
            if (k11.c(i11)) {
                if (k11.f65879c[i11] == null && this.f13460k[i11].getTrackType() != -2) {
                    r3 = false;
                }
                androidx.media3.common.util.a.g(r3);
            } else {
                androidx.media3.common.util.a.g(k11.f65879c[i11] == null);
            }
        }
        for (j2.z zVar : k11.f65879c) {
            if (zVar != null) {
                zVar.onPlaybackSpeed(f11);
                zVar.b(z10);
            }
        }
        return k11;
    }
}
