package com.google.android.exoplayer2;

import android.os.Handler;
import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.source.o;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class e2 {

    /* renamed from: a, reason: collision with root package name */
    private final k3.b f25079a = new k3.b();

    /* renamed from: b, reason: collision with root package name */
    private final k3.d f25080b = new k3.d();

    /* renamed from: c, reason: collision with root package name */
    private final e9.a f25081c;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f25082d;

    /* renamed from: e, reason: collision with root package name */
    private long f25083e;

    /* renamed from: f, reason: collision with root package name */
    private int f25084f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f25085g;

    /* renamed from: h, reason: collision with root package name */
    private b2 f25086h;

    /* renamed from: i, reason: collision with root package name */
    private b2 f25087i;

    /* renamed from: j, reason: collision with root package name */
    private b2 f25088j;

    /* renamed from: k, reason: collision with root package name */
    private int f25089k;

    /* renamed from: l, reason: collision with root package name */
    private Object f25090l;

    /* renamed from: m, reason: collision with root package name */
    private long f25091m;

    public e2(e9.a aVar, Handler handler) {
        this.f25081c = aVar;
        this.f25082d = handler;
    }

    private static o.b A(k3 k3Var, Object obj, long j11, long j12, k3.d dVar, k3.b bVar) {
        k3Var.l(obj, bVar);
        k3Var.r(bVar.f25210c, dVar);
        int f11 = k3Var.f(obj);
        Object obj2 = obj;
        while (bVar.f25211d == 0 && bVar.f() > 0 && bVar.t(bVar.r()) && bVar.h(0L) == -1) {
            int i11 = f11 + 1;
            if (f11 >= dVar.f25238p) {
                break;
            }
            k3Var.k(i11, bVar, true);
            obj2 = com.google.android.exoplayer2.util.a.e(bVar.f25209b);
            f11 = i11;
        }
        k3Var.l(obj2, bVar);
        int h11 = bVar.h(j11);
        return h11 == -1 ? new o.b(obj2, j12, bVar.g(j11)) : new o.b(obj2, h11, bVar.n(h11), j12);
    }

    private long C(k3 k3Var, Object obj) {
        int f11;
        int i11 = k3Var.l(obj, this.f25079a).f25210c;
        Object obj2 = this.f25090l;
        if (obj2 != null && (f11 = k3Var.f(obj2)) != -1 && k3Var.j(f11, this.f25079a).f25210c == i11) {
            return this.f25091m;
        }
        for (b2 b2Var = this.f25086h; b2Var != null; b2Var = b2Var.j()) {
            if (b2Var.f24859b.equals(obj)) {
                return b2Var.f24863f.f24875a.f76240d;
            }
        }
        for (b2 b2Var2 = this.f25086h; b2Var2 != null; b2Var2 = b2Var2.j()) {
            int f12 = k3Var.f(b2Var2.f24859b);
            if (f12 != -1 && k3Var.j(f12, this.f25079a).f25210c == i11) {
                return b2Var2.f24863f.f24875a.f76240d;
            }
        }
        long j11 = this.f25083e;
        this.f25083e = 1 + j11;
        if (this.f25086h == null) {
            this.f25090l = obj;
            this.f25091m = j11;
        }
        return j11;
    }

    private boolean E(k3 k3Var) {
        b2 b2Var = this.f25086h;
        if (b2Var == null) {
            return true;
        }
        int f11 = k3Var.f(b2Var.f24859b);
        while (true) {
            f11 = k3Var.h(f11, this.f25079a, this.f25080b, this.f25084f, this.f25085g);
            while (b2Var.j() != null && !b2Var.f24863f.f24881g) {
                b2Var = b2Var.j();
            }
            b2 j11 = b2Var.j();
            if (f11 == -1 || j11 == null || k3Var.f(j11.f24859b) != f11) {
                break;
            }
            b2Var = j11;
        }
        boolean z10 = z(b2Var);
        b2Var.f24863f = r(k3Var, b2Var.f24863f);
        return !z10;
    }

    private boolean d(long j11, long j12) {
        return j11 == C.TIME_UNSET || j11 == j12;
    }

    private boolean e(c2 c2Var, c2 c2Var2) {
        return c2Var.f24876b == c2Var2.f24876b && c2Var.f24875a.equals(c2Var2.f24875a);
    }

    private c2 h(l2 l2Var) {
        return k(l2Var.f25297a, l2Var.f25298b, l2Var.f25299c, l2Var.f25314r);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00cc, code lost:
    
        if (r0.t(r0.r()) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.android.exoplayer2.c2 i(com.google.android.exoplayer2.k3 r20, com.google.android.exoplayer2.b2 r21, long r22) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e2.i(com.google.android.exoplayer2.k3, com.google.android.exoplayer2.b2, long):com.google.android.exoplayer2.c2");
    }

    private c2 k(k3 k3Var, o.b bVar, long j11, long j12) {
        k3Var.l(bVar.f76237a, this.f25079a);
        return bVar.b() ? l(k3Var, bVar.f76237a, bVar.f76238b, bVar.f76239c, j11, bVar.f76240d) : m(k3Var, bVar.f76237a, j12, j11, bVar.f76240d);
    }

    private c2 l(k3 k3Var, Object obj, int i11, int i12, long j11, long j12) {
        o.b bVar = new o.b(obj, i11, i12, j12);
        long e11 = k3Var.l(bVar.f76237a, this.f25079a).e(bVar.f76238b, bVar.f76239c);
        long j13 = i12 == this.f25079a.n(i11) ? this.f25079a.j() : 0L;
        return new c2(bVar, (e11 == C.TIME_UNSET || j13 < e11) ? j13 : Math.max(0L, e11 - 1), j11, C.TIME_UNSET, e11, this.f25079a.t(bVar.f76238b), false, false, false);
    }

    private c2 m(k3 k3Var, Object obj, long j11, long j12, long j13) {
        boolean z10;
        long j14;
        long j15;
        long j16;
        long j17 = j11;
        k3Var.l(obj, this.f25079a);
        int g11 = this.f25079a.g(j17);
        int i11 = 1;
        if (g11 == -1) {
            if (this.f25079a.f() > 0) {
                k3.b bVar = this.f25079a;
                if (bVar.t(bVar.r())) {
                    z10 = true;
                }
            }
            z10 = false;
        } else {
            if (this.f25079a.t(g11)) {
                long i12 = this.f25079a.i(g11);
                k3.b bVar2 = this.f25079a;
                if (i12 == bVar2.f25211d && bVar2.s(g11)) {
                    z10 = true;
                    g11 = -1;
                }
            }
            z10 = false;
        }
        o.b bVar3 = new o.b(obj, j13, g11);
        boolean s11 = s(bVar3);
        boolean u11 = u(k3Var, bVar3);
        boolean t11 = t(k3Var, bVar3, s11);
        boolean z11 = g11 != -1 && this.f25079a.t(g11);
        if (g11 != -1) {
            j15 = this.f25079a.i(g11);
        } else {
            if (!z10) {
                j14 = -9223372036854775807L;
                j16 = (j14 != C.TIME_UNSET || j14 == Long.MIN_VALUE) ? this.f25079a.f25211d : j14;
                if (j16 != C.TIME_UNSET && j17 >= j16) {
                    if (!t11 && z10) {
                        i11 = 0;
                    }
                    j17 = Math.max(0L, j16 - i11);
                }
                return new c2(bVar3, j17, j12, j14, j16, z11, s11, u11, t11);
            }
            j15 = this.f25079a.f25211d;
        }
        j14 = j15;
        if (j14 != C.TIME_UNSET) {
        }
        if (j16 != C.TIME_UNSET) {
            if (!t11) {
                i11 = 0;
            }
            j17 = Math.max(0L, j16 - i11);
        }
        return new c2(bVar3, j17, j12, j14, j16, z11, s11, u11, t11);
    }

    private long n(k3 k3Var, Object obj, int i11) {
        k3Var.l(obj, this.f25079a);
        long i12 = this.f25079a.i(i11);
        return i12 == Long.MIN_VALUE ? this.f25079a.f25211d : i12 + this.f25079a.l(i11);
    }

    private boolean s(o.b bVar) {
        return !bVar.b() && bVar.f76241e == -1;
    }

    private boolean t(k3 k3Var, o.b bVar, boolean z10) {
        int f11 = k3Var.f(bVar.f76237a);
        return !k3Var.r(k3Var.j(f11, this.f25079a).f25210c, this.f25080b).f25231i && k3Var.v(f11, this.f25079a, this.f25080b, this.f25084f, this.f25085g) && z10;
    }

    private boolean u(k3 k3Var, o.b bVar) {
        if (s(bVar)) {
            return k3Var.r(k3Var.l(bVar.f76237a, this.f25079a).f25210c, this.f25080b).f25238p == k3Var.f(bVar.f76237a);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(ImmutableList.a aVar, o.b bVar) {
        this.f25081c.A(aVar.e(), bVar);
    }

    private void x() {
        final ImmutableList.a builder = ImmutableList.builder();
        for (b2 b2Var = this.f25086h; b2Var != null; b2Var = b2Var.j()) {
            builder.a(b2Var.f24863f.f24875a);
        }
        b2 b2Var2 = this.f25087i;
        final o.b bVar = b2Var2 == null ? null : b2Var2.f24863f.f24875a;
        this.f25082d.post(new Runnable() { // from class: com.google.android.exoplayer2.d2
            @Override // java.lang.Runnable
            public final void run() {
                e2.this.w(builder, bVar);
            }
        });
    }

    public o.b B(k3 k3Var, Object obj, long j11) {
        long C = C(k3Var, obj);
        k3Var.l(obj, this.f25079a);
        k3Var.r(this.f25079a.f25210c, this.f25080b);
        boolean z10 = false;
        for (int f11 = k3Var.f(obj); f11 >= this.f25080b.f25237o; f11--) {
            k3Var.k(f11, this.f25079a, true);
            boolean z11 = this.f25079a.f() > 0;
            z10 |= z11;
            k3.b bVar = this.f25079a;
            if (bVar.h(bVar.f25211d) != -1) {
                obj = com.google.android.exoplayer2.util.a.e(this.f25079a.f25209b);
            }
            if (z10 && (!z11 || this.f25079a.f25211d != 0)) {
                break;
            }
        }
        return A(k3Var, obj, j11, C, this.f25080b, this.f25079a);
    }

    public boolean D() {
        b2 b2Var = this.f25088j;
        return b2Var == null || (!b2Var.f24863f.f24883i && b2Var.q() && this.f25088j.f24863f.f24879e != C.TIME_UNSET && this.f25089k < 100);
    }

    public boolean F(k3 k3Var, long j11, long j12) {
        c2 c2Var;
        b2 b2Var = this.f25086h;
        b2 b2Var2 = null;
        while (b2Var != null) {
            c2 c2Var2 = b2Var.f24863f;
            if (b2Var2 != null) {
                c2 i11 = i(k3Var, b2Var2, j11);
                if (i11 != null && e(c2Var2, i11)) {
                    c2Var = i11;
                }
                return !z(b2Var2);
            }
            c2Var = r(k3Var, c2Var2);
            b2Var.f24863f = c2Var.a(c2Var2.f24877c);
            if (!d(c2Var2.f24879e, c2Var.f24879e)) {
                b2Var.A();
                long j13 = c2Var.f24879e;
                return (z(b2Var) || (b2Var == this.f25087i && !b2Var.f24863f.f24880f && ((j12 > Long.MIN_VALUE ? 1 : (j12 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j12 > ((j13 > C.TIME_UNSET ? 1 : (j13 == C.TIME_UNSET ? 0 : -1)) == 0 ? Long.MAX_VALUE : b2Var.z(j13)) ? 1 : (j12 == ((j13 > C.TIME_UNSET ? 1 : (j13 == C.TIME_UNSET ? 0 : -1)) == 0 ? Long.MAX_VALUE : b2Var.z(j13)) ? 0 : -1)) >= 0))) ? false : true;
            }
            b2Var2 = b2Var;
            b2Var = b2Var.j();
        }
        return true;
    }

    public boolean G(k3 k3Var, int i11) {
        this.f25084f = i11;
        return E(k3Var);
    }

    public boolean H(k3 k3Var, boolean z10) {
        this.f25085g = z10;
        return E(k3Var);
    }

    public b2 b() {
        b2 b2Var = this.f25086h;
        if (b2Var == null) {
            return null;
        }
        if (b2Var == this.f25087i) {
            this.f25087i = b2Var.j();
        }
        this.f25086h.t();
        int i11 = this.f25089k - 1;
        this.f25089k = i11;
        if (i11 == 0) {
            this.f25088j = null;
            b2 b2Var2 = this.f25086h;
            this.f25090l = b2Var2.f24859b;
            this.f25091m = b2Var2.f24863f.f24875a.f76240d;
        }
        this.f25086h = this.f25086h.j();
        x();
        return this.f25086h;
    }

    public b2 c() {
        b2 b2Var = this.f25087i;
        com.google.android.exoplayer2.util.a.g((b2Var == null || b2Var.j() == null) ? false : true);
        this.f25087i = this.f25087i.j();
        x();
        return this.f25087i;
    }

    public void f() {
        if (this.f25089k == 0) {
            return;
        }
        b2 b2Var = (b2) com.google.android.exoplayer2.util.a.i(this.f25086h);
        this.f25090l = b2Var.f24859b;
        this.f25091m = b2Var.f24863f.f24875a.f76240d;
        while (b2Var != null) {
            b2Var.t();
            b2Var = b2Var.j();
        }
        this.f25086h = null;
        this.f25088j = null;
        this.f25087i = null;
        this.f25089k = 0;
        x();
    }

    public b2 g(z2[] z2VarArr, la.q qVar, com.google.android.exoplayer2.upstream.b bVar, h2 h2Var, c2 c2Var, la.r rVar) {
        b2 b2Var = this.f25088j;
        b2 b2Var2 = new b2(z2VarArr, b2Var == null ? 1000000000000L : (b2Var.l() + this.f25088j.f24863f.f24879e) - c2Var.f24876b, qVar, bVar, h2Var, c2Var, rVar);
        b2 b2Var3 = this.f25088j;
        if (b2Var3 != null) {
            b2Var3.w(b2Var2);
        } else {
            this.f25086h = b2Var2;
            this.f25087i = b2Var2;
        }
        this.f25090l = null;
        this.f25088j = b2Var2;
        this.f25089k++;
        x();
        return b2Var2;
    }

    public b2 j() {
        return this.f25088j;
    }

    public c2 o(long j11, l2 l2Var) {
        b2 b2Var = this.f25088j;
        return b2Var == null ? h(l2Var) : i(l2Var.f25297a, b2Var, j11);
    }

    public b2 p() {
        return this.f25086h;
    }

    public b2 q() {
        return this.f25087i;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.exoplayer2.c2 r(com.google.android.exoplayer2.k3 r19, com.google.android.exoplayer2.c2 r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            com.google.android.exoplayer2.source.o$b r3 = r2.f24875a
            boolean r12 = r0.s(r3)
            boolean r13 = r0.u(r1, r3)
            boolean r14 = r0.t(r1, r3, r12)
            com.google.android.exoplayer2.source.o$b r4 = r2.f24875a
            java.lang.Object r4 = r4.f76237a
            com.google.android.exoplayer2.k3$b r5 = r0.f25079a
            r1.l(r4, r5)
            boolean r1 = r3.b()
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = -1
            if (r1 != 0) goto L35
            int r1 = r3.f76241e
            if (r1 != r6) goto L2e
            goto L35
        L2e:
            com.google.android.exoplayer2.k3$b r7 = r0.f25079a
            long r7 = r7.i(r1)
            goto L36
        L35:
            r7 = r4
        L36:
            boolean r1 = r3.b()
            if (r1 == 0) goto L48
            com.google.android.exoplayer2.k3$b r1 = r0.f25079a
            int r4 = r3.f76238b
            int r5 = r3.f76239c
            long r4 = r1.e(r4, r5)
        L46:
            r9 = r4
            goto L5c
        L48:
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 == 0) goto L55
            r4 = -9223372036854775808
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 != 0) goto L53
            goto L55
        L53:
            r9 = r7
            goto L5c
        L55:
            com.google.android.exoplayer2.k3$b r1 = r0.f25079a
            long r4 = r1.m()
            goto L46
        L5c:
            boolean r1 = r3.b()
            if (r1 == 0) goto L6c
            com.google.android.exoplayer2.k3$b r1 = r0.f25079a
            int r4 = r3.f76238b
            boolean r1 = r1.t(r4)
        L6a:
            r11 = r1
            goto L7c
        L6c:
            int r1 = r3.f76241e
            if (r1 == r6) goto L7a
            com.google.android.exoplayer2.k3$b r4 = r0.f25079a
            boolean r1 = r4.t(r1)
            if (r1 == 0) goto L7a
            r1 = 1
            goto L6a
        L7a:
            r1 = 0
            goto L6a
        L7c:
            com.google.android.exoplayer2.c2 r15 = new com.google.android.exoplayer2.c2
            long r4 = r2.f24876b
            long r1 = r2.f24877c
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e2.r(com.google.android.exoplayer2.k3, com.google.android.exoplayer2.c2):com.google.android.exoplayer2.c2");
    }

    public boolean v(com.google.android.exoplayer2.source.n nVar) {
        b2 b2Var = this.f25088j;
        return b2Var != null && b2Var.f24858a == nVar;
    }

    public void y(long j11) {
        b2 b2Var = this.f25088j;
        if (b2Var != null) {
            b2Var.s(j11);
        }
    }

    public boolean z(b2 b2Var) {
        boolean z10 = false;
        com.google.android.exoplayer2.util.a.g(b2Var != null);
        if (b2Var.equals(this.f25088j)) {
            return false;
        }
        this.f25088j = b2Var;
        while (b2Var.j() != null) {
            b2Var = b2Var.j();
            if (b2Var == this.f25087i) {
                this.f25087i = this.f25086h;
                z10 = true;
            }
            b2Var.t();
            this.f25089k--;
        }
        this.f25088j.w(null);
        x();
        return z10;
    }
}
