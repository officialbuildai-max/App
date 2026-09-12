package androidx.media3.exoplayer;

import androidx.media3.exoplayer.source.r;
import java.util.Objects;

/* loaded from: classes2.dex */
class a4 {

    /* renamed from: a, reason: collision with root package name */
    private final w3 f11077a;

    /* renamed from: b, reason: collision with root package name */
    private final int f11078b;

    /* renamed from: c, reason: collision with root package name */
    private final w3 f11079c;

    /* renamed from: d, reason: collision with root package name */
    private int f11080d = 0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f11081e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f11082f = false;

    public a4(w3 w3Var, w3 w3Var2, int i11) {
        this.f11077a = w3Var;
        this.f11078b = i11;
        this.f11079c = w3Var2;
    }

    private boolean A() {
        return this.f11080d == 3;
    }

    private void C(w3 w3Var, g2.u uVar, n nVar, long j11, boolean z10) {
        if (y(w3Var)) {
            if (uVar != w3Var.getStream()) {
                d(w3Var, nVar);
            } else if (z10) {
                w3Var.resetPosition(j11);
            }
        }
    }

    private void E(boolean z10) {
        if (z10) {
            if (this.f11081e) {
                this.f11077a.reset();
                this.f11081e = false;
                return;
            }
            return;
        }
        if (this.f11082f) {
            ((w3) androidx.media3.common.util.a.e(this.f11079c)).reset();
            this.f11082f = false;
        }
    }

    private int K(w3 w3Var, y2 y2Var, j2.f0 f0Var, n nVar) {
        if (w3Var == null || !y(w3Var) || ((w3Var == this.f11077a && v()) || (w3Var == this.f11079c && A()))) {
            return 1;
        }
        g2.u stream = w3Var.getStream();
        g2.u[] uVarArr = y2Var.f13452c;
        int i11 = this.f11078b;
        boolean z10 = stream != uVarArr[i11];
        boolean c11 = f0Var.c(i11);
        if (c11 && !z10) {
            return 1;
        }
        if (!w3Var.isCurrentStreamFinal()) {
            w3Var.p(i(f0Var.f65879c[this.f11078b]), (g2.u) androidx.media3.common.util.a.e(y2Var.f13452c[this.f11078b]), y2Var.n(), y2Var.m(), y2Var.f13457h.f13470a);
            return 3;
        }
        if (!w3Var.isEnded()) {
            return 0;
        }
        d(w3Var, nVar);
        if (!c11 || u()) {
            E(w3Var == this.f11077a);
        }
        return 1;
    }

    private void P(w3 w3Var, long j11) {
        w3Var.setCurrentStreamFinal();
        if (w3Var instanceof i2.i) {
            ((i2.i) w3Var).g0(j11);
        }
    }

    private void X(boolean z10) {
        if (z10) {
            ((w3) androidx.media3.common.util.a.e(this.f11079c)).handleMessage(17, this.f11077a);
        } else {
            this.f11077a.handleMessage(17, androidx.media3.common.util.a.e(this.f11079c));
        }
    }

    private void d(w3 w3Var, n nVar) {
        androidx.media3.common.util.a.g(this.f11077a == w3Var || this.f11079c == w3Var);
        if (y(w3Var)) {
            nVar.a(w3Var);
            g(w3Var);
            w3Var.disable();
        }
    }

    private void g(w3 w3Var) {
        if (w3Var.getState() == 2) {
            w3Var.stop();
        }
    }

    private static androidx.media3.common.r[] i(j2.z zVar) {
        int length = zVar != null ? zVar.length() : 0;
        androidx.media3.common.r[] rVarArr = new androidx.media3.common.r[length];
        for (int i11 = 0; i11 < length; i11++) {
            rVarArr[i11] = ((j2.z) androidx.media3.common.util.a.e(zVar)).getFormat(i11);
        }
        return rVarArr;
    }

    private w3 l(y2 y2Var) {
        if (y2Var != null && y2Var.f13452c[this.f11078b] != null) {
            if (this.f11077a.getStream() == y2Var.f13452c[this.f11078b]) {
                return this.f11077a;
            }
            w3 w3Var = this.f11079c;
            if (w3Var != null && w3Var.getStream() == y2Var.f13452c[this.f11078b]) {
                return this.f11079c;
            }
        }
        return null;
    }

    private boolean p(y2 y2Var, w3 w3Var) {
        if (w3Var == null) {
            return true;
        }
        g2.u uVar = y2Var.f13452c[this.f11078b];
        if (w3Var.getStream() == null) {
            return true;
        }
        if (w3Var.getStream() == uVar && (uVar == null || w3Var.hasReadStreamToEnd() || q(w3Var, y2Var))) {
            return true;
        }
        y2 k11 = y2Var.k();
        return k11 != null && k11.f13452c[this.f11078b] == w3Var.getStream();
    }

    private boolean q(w3 w3Var, y2 y2Var) {
        y2 k11 = y2Var.k();
        return y2Var.f13457h.f13476g && k11 != null && k11.f13455f && ((w3Var instanceof i2.i) || (w3Var instanceof e2.c) || w3Var.e() >= k11.n());
    }

    private boolean v() {
        int i11 = this.f11080d;
        return i11 == 2 || i11 == 4;
    }

    private static boolean y(w3 w3Var) {
        return w3Var.getState() != 0;
    }

    public void B(g2.u uVar, n nVar, long j11, boolean z10) {
        C(this.f11077a, uVar, nVar, j11, z10);
        w3 w3Var = this.f11079c;
        if (w3Var != null) {
            C(w3Var, uVar, nVar, j11, z10);
        }
    }

    public void D() {
        int i11 = this.f11080d;
        if (i11 == 3 || i11 == 4) {
            X(i11 == 4);
            this.f11080d = this.f11080d != 4 ? 1 : 0;
        } else if (i11 == 2) {
            this.f11080d = 0;
        }
    }

    public void F(j2.f0 f0Var, j2.f0 f0Var2, long j11) {
        int i11;
        boolean c11 = f0Var.c(this.f11078b);
        boolean c12 = f0Var2.c(this.f11078b);
        w3 w3Var = (this.f11079c == null || (i11 = this.f11080d) == 3 || (i11 == 0 && y(this.f11077a))) ? this.f11077a : (w3) androidx.media3.common.util.a.e(this.f11079c);
        if (!c11 || w3Var.isCurrentStreamFinal()) {
            return;
        }
        boolean z10 = m() == -2;
        z3[] z3VarArr = f0Var.f65878b;
        int i12 = this.f11078b;
        z3 z3Var = z3VarArr[i12];
        z3 z3Var2 = f0Var2.f65878b[i12];
        if (!c12 || !Objects.equals(z3Var2, z3Var) || z10 || u()) {
            P(w3Var, j11);
        }
    }

    public void G(y2 y2Var) {
        ((w3) androidx.media3.common.util.a.e(l(y2Var))).maybeThrowStreamError();
    }

    public void H() {
        this.f11077a.release();
        this.f11081e = false;
        w3 w3Var = this.f11079c;
        if (w3Var != null) {
            w3Var.release();
            this.f11082f = false;
        }
    }

    public void I(long j11, long j12) {
        if (y(this.f11077a)) {
            this.f11077a.render(j11, j12);
        }
        w3 w3Var = this.f11079c;
        if (w3Var == null || !y(w3Var)) {
            return;
        }
        this.f11079c.render(j11, j12);
    }

    public int J(y2 y2Var, j2.f0 f0Var, n nVar) {
        int K = K(this.f11077a, y2Var, f0Var, nVar);
        return K == 1 ? K(this.f11079c, y2Var, f0Var, nVar) : K;
    }

    public void L() {
        if (!y(this.f11077a)) {
            E(true);
        }
        w3 w3Var = this.f11079c;
        if (w3Var == null || y(w3Var)) {
            return;
        }
        E(false);
    }

    public void M(y2 y2Var, long j11) {
        w3 l11 = l(y2Var);
        if (l11 != null) {
            l11.resetPosition(j11);
        }
    }

    public void N(long j11) {
        int i11;
        if (y(this.f11077a) && (i11 = this.f11080d) != 4 && i11 != 2) {
            P(this.f11077a, j11);
        }
        w3 w3Var = this.f11079c;
        if (w3Var == null || !y(w3Var) || this.f11080d == 3) {
            return;
        }
        P(this.f11079c, j11);
    }

    public void O(y2 y2Var, long j11) {
        P((w3) androidx.media3.common.util.a.e(l(y2Var)), j11);
    }

    public void Q(float f11, float f12) {
        this.f11077a.d(f11, f12);
        w3 w3Var = this.f11079c;
        if (w3Var != null) {
            w3Var.d(f11, f12);
        }
    }

    public void R(androidx.media3.common.e0 e0Var) {
        this.f11077a.m(e0Var);
        w3 w3Var = this.f11079c;
        if (w3Var != null) {
            w3Var.m(e0Var);
        }
    }

    public void S(Object obj) {
        if (m() != 2) {
            return;
        }
        int i11 = this.f11080d;
        if (i11 == 4 || i11 == 1) {
            ((w3) androidx.media3.common.util.a.e(this.f11079c)).handleMessage(1, obj);
        } else {
            this.f11077a.handleMessage(1, obj);
        }
    }

    public void T(float f11) {
        if (m() != 1) {
            return;
        }
        this.f11077a.handleMessage(2, Float.valueOf(f11));
        w3 w3Var = this.f11079c;
        if (w3Var != null) {
            w3Var.handleMessage(2, Float.valueOf(f11));
        }
    }

    public void U() {
        if (this.f11077a.getState() == 1 && this.f11080d != 4) {
            this.f11077a.start();
            return;
        }
        w3 w3Var = this.f11079c;
        if (w3Var == null || w3Var.getState() != 1 || this.f11080d == 3) {
            return;
        }
        this.f11079c.start();
    }

    public void V() {
        int i11;
        androidx.media3.common.util.a.g(!u());
        if (y(this.f11077a)) {
            i11 = 3;
        } else {
            w3 w3Var = this.f11079c;
            i11 = (w3Var == null || !y(w3Var)) ? 2 : 4;
        }
        this.f11080d = i11;
    }

    public void W() {
        if (y(this.f11077a)) {
            g(this.f11077a);
        }
        w3 w3Var = this.f11079c;
        if (w3Var == null || !y(w3Var)) {
            return;
        }
        g(this.f11079c);
    }

    public boolean a(y2 y2Var) {
        w3 l11 = l(y2Var);
        return l11 == null || l11.hasReadStreamToEnd() || l11.isReady() || l11.isEnded();
    }

    public void b(n nVar) {
        d(this.f11077a, nVar);
        w3 w3Var = this.f11079c;
        if (w3Var != null) {
            boolean z10 = y(w3Var) && this.f11080d != 3;
            d(this.f11079c, nVar);
            E(false);
            if (z10) {
                X(true);
            }
        }
        this.f11080d = 0;
    }

    public void c(n nVar) {
        if (u()) {
            int i11 = this.f11080d;
            boolean z10 = i11 == 4 || i11 == 2;
            int i12 = i11 != 4 ? 0 : 1;
            d(z10 ? this.f11077a : (w3) androidx.media3.common.util.a.e(this.f11079c), nVar);
            E(z10);
            this.f11080d = i12;
        }
    }

    public void e(z3 z3Var, j2.z zVar, g2.u uVar, long j11, boolean z10, boolean z11, long j12, long j13, r.b bVar, n nVar) {
        androidx.media3.common.r[] i11 = i(zVar);
        int i12 = this.f11080d;
        if (i12 == 0 || i12 == 2 || i12 == 4) {
            this.f11081e = true;
            this.f11077a.h(z3Var, i11, uVar, j11, z10, z11, j12, j13, bVar);
            nVar.c(this.f11077a);
        } else {
            this.f11082f = true;
            ((w3) androidx.media3.common.util.a.e(this.f11079c)).h(z3Var, i11, uVar, j11, z10, z11, j12, j13, bVar);
            nVar.c(this.f11079c);
        }
    }

    public void f() {
        if (y(this.f11077a)) {
            this.f11077a.c();
            return;
        }
        w3 w3Var = this.f11079c;
        if (w3Var == null || !y(w3Var)) {
            return;
        }
        this.f11079c.c();
    }

    public int h() {
        boolean y10 = y(this.f11077a);
        w3 w3Var = this.f11079c;
        return (y10 ? 1 : 0) + ((w3Var == null || !y(w3Var)) ? 0 : 1);
    }

    public long j(long j11, long j12) {
        long l11 = y(this.f11077a) ? this.f11077a.l(j11, j12) : Long.MAX_VALUE;
        w3 w3Var = this.f11079c;
        return (w3Var == null || !y(w3Var)) ? l11 : Math.min(l11, this.f11079c.l(j11, j12));
    }

    public long k(y2 y2Var) {
        w3 l11 = l(y2Var);
        Objects.requireNonNull(l11);
        return l11.e();
    }

    public int m() {
        return this.f11077a.getTrackType();
    }

    public void n(int i11, Object obj, y2 y2Var) {
        ((w3) androidx.media3.common.util.a.e(l(y2Var))).handleMessage(i11, obj);
    }

    public boolean o(y2 y2Var) {
        return p(y2Var, this.f11077a) && p(y2Var, this.f11079c);
    }

    public boolean r(y2 y2Var) {
        return ((w3) androidx.media3.common.util.a.e(l(y2Var))).hasReadStreamToEnd();
    }

    public boolean s() {
        return this.f11079c != null;
    }

    public boolean t() {
        boolean isEnded = y(this.f11077a) ? this.f11077a.isEnded() : true;
        w3 w3Var = this.f11079c;
        return (w3Var == null || !y(w3Var)) ? isEnded : isEnded & this.f11079c.isEnded();
    }

    public boolean u() {
        return v() || A();
    }

    public boolean w(y2 y2Var) {
        return l(y2Var) != null;
    }

    public boolean x() {
        int i11 = this.f11080d;
        return (i11 == 0 || i11 == 2 || i11 == 4) ? y(this.f11077a) : y((w3) androidx.media3.common.util.a.e(this.f11079c));
    }

    public boolean z(int i11) {
        return (v() && i11 == this.f11078b) || (A() && i11 != this.f11078b);
    }
}
