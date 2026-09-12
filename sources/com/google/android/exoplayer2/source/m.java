package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.v1;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes3.dex */
public final class m extends c {

    /* renamed from: k, reason: collision with root package name */
    private final o f26282k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f26283l;

    /* renamed from: m, reason: collision with root package name */
    private final k3.d f26284m;

    /* renamed from: n, reason: collision with root package name */
    private final k3.b f26285n;

    /* renamed from: o, reason: collision with root package name */
    private a f26286o;

    /* renamed from: p, reason: collision with root package name */
    private l f26287p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f26288q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f26289r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f26290s;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a extends j {

        /* renamed from: f, reason: collision with root package name */
        public static final Object f26291f = new Object();

        /* renamed from: d, reason: collision with root package name */
        private final Object f26292d;

        /* renamed from: e, reason: collision with root package name */
        private final Object f26293e;

        private a(k3 k3Var, Object obj, Object obj2) {
            super(k3Var);
            this.f26292d = obj;
            this.f26293e = obj2;
        }

        public static a A(v1 v1Var) {
            return new a(new b(v1Var), k3.d.f25219r, f26291f);
        }

        public static a B(k3 k3Var, Object obj, Object obj2) {
            return new a(k3Var, obj, obj2);
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.k3
        public int f(Object obj) {
            Object obj2;
            k3 k3Var = this.f26267c;
            if (f26291f.equals(obj) && (obj2 = this.f26293e) != null) {
                obj = obj2;
            }
            return k3Var.f(obj);
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.k3
        public k3.b k(int i11, k3.b bVar, boolean z10) {
            this.f26267c.k(i11, bVar, z10);
            if (p0.c(bVar.f25209b, this.f26293e) && z10) {
                bVar.f25209b = f26291f;
            }
            return bVar;
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.k3
        public Object q(int i11) {
            Object q11 = this.f26267c.q(i11);
            return p0.c(q11, this.f26293e) ? f26291f : q11;
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.k3
        public k3.d s(int i11, k3.d dVar, long j11) {
            this.f26267c.s(i11, dVar, j11);
            if (p0.c(dVar.f25223a, this.f26292d)) {
                dVar.f25223a = k3.d.f25219r;
            }
            return dVar;
        }

        public a z(k3 k3Var) {
            return new a(k3Var, this.f26292d, this.f26293e);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends k3 {

        /* renamed from: c, reason: collision with root package name */
        private final v1 f26294c;

        public b(v1 v1Var) {
            this.f26294c = v1Var;
        }

        @Override // com.google.android.exoplayer2.k3
        public int f(Object obj) {
            return obj == a.f26291f ? 0 : -1;
        }

        @Override // com.google.android.exoplayer2.k3
        public k3.b k(int i11, k3.b bVar, boolean z10) {
            bVar.w(z10 ? 0 : null, z10 ? a.f26291f : null, 0, C.TIME_UNSET, 0L, u9.c.f76812g, true);
            return bVar;
        }

        @Override // com.google.android.exoplayer2.k3
        public int m() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.k3
        public Object q(int i11) {
            return a.f26291f;
        }

        @Override // com.google.android.exoplayer2.k3
        public k3.d s(int i11, k3.d dVar, long j11) {
            dVar.k(k3.d.f25219r, this.f26294c, null, C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, false, true, null, 0L, C.TIME_UNSET, 0, 0, 0L);
            dVar.f25234l = true;
            return dVar;
        }

        @Override // com.google.android.exoplayer2.k3
        public int t() {
            return 1;
        }
    }

    public m(o oVar, boolean z10) {
        this.f26282k = oVar;
        this.f26283l = z10 && oVar.b();
        this.f26284m = new k3.d();
        this.f26285n = new k3.b();
        k3 c11 = oVar.c();
        if (c11 == null) {
            this.f26286o = a.A(oVar.a());
        } else {
            this.f26286o = a.B(c11, null, null);
            this.f26290s = true;
        }
    }

    private Object M(Object obj) {
        return (this.f26286o.f26293e == null || !this.f26286o.f26293e.equals(obj)) ? obj : a.f26291f;
    }

    private Object N(Object obj) {
        return (this.f26286o.f26293e == null || !obj.equals(a.f26291f)) ? obj : this.f26286o.f26293e;
    }

    private void R(long j11) {
        l lVar = this.f26287p;
        int f11 = this.f26286o.f(lVar.f26273a.f76237a);
        if (f11 == -1) {
            return;
        }
        long j12 = this.f26286o.j(f11, this.f26285n).f25211d;
        if (j12 != C.TIME_UNSET && j11 >= j12) {
            j11 = Math.max(0L, j12 - 1);
        }
        lVar.l(j11);
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void B(k0 k0Var) {
        super.B(k0Var);
        if (this.f26283l) {
            return;
        }
        this.f26288q = true;
        K(null, this.f26282k);
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void D() {
        this.f26289r = false;
        this.f26288q = false;
        super.D();
    }

    @Override // com.google.android.exoplayer2.source.o
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public l d(o.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        l lVar = new l(bVar, bVar2, j11);
        lVar.n(this.f26282k);
        if (this.f26289r) {
            lVar.c(bVar.c(N(bVar.f76237a)));
        } else {
            this.f26287p = lVar;
            if (!this.f26288q) {
                this.f26288q = true;
                K(null, this.f26282k);
            }
        }
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.c
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public o.b F(Void r12, o.b bVar) {
        return bVar.c(M(bVar.f76237a));
    }

    public k3 P() {
        return this.f26286o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00bb  */
    @Override // com.google.android.exoplayer2.source.c
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void I(java.lang.Void r13, com.google.android.exoplayer2.source.o r14, com.google.android.exoplayer2.k3 r15) {
        /*
            r12 = this;
            boolean r13 = r12.f26289r
            if (r13 == 0) goto L19
            com.google.android.exoplayer2.source.m$a r13 = r12.f26286o
            com.google.android.exoplayer2.source.m$a r13 = r13.z(r15)
            r12.f26286o = r13
            com.google.android.exoplayer2.source.l r13 = r12.f26287p
            if (r13 == 0) goto Lae
            long r13 = r13.f()
            r12.R(r13)
            goto Lae
        L19:
            boolean r13 = r15.u()
            if (r13 == 0) goto L36
            boolean r13 = r12.f26290s
            if (r13 == 0) goto L2a
            com.google.android.exoplayer2.source.m$a r13 = r12.f26286o
            com.google.android.exoplayer2.source.m$a r13 = r13.z(r15)
            goto L32
        L2a:
            java.lang.Object r13 = com.google.android.exoplayer2.k3.d.f25219r
            java.lang.Object r14 = com.google.android.exoplayer2.source.m.a.f26291f
            com.google.android.exoplayer2.source.m$a r13 = com.google.android.exoplayer2.source.m.a.B(r15, r13, r14)
        L32:
            r12.f26286o = r13
            goto Lae
        L36:
            com.google.android.exoplayer2.k3$d r13 = r12.f26284m
            r14 = 0
            r15.r(r14, r13)
            com.google.android.exoplayer2.k3$d r13 = r12.f26284m
            long r0 = r13.f()
            com.google.android.exoplayer2.k3$d r13 = r12.f26284m
            java.lang.Object r13 = r13.f25223a
            com.google.android.exoplayer2.source.l r2 = r12.f26287p
            if (r2 == 0) goto L74
            long r2 = r2.i()
            com.google.android.exoplayer2.source.m$a r4 = r12.f26286o
            com.google.android.exoplayer2.source.l r5 = r12.f26287p
            com.google.android.exoplayer2.source.o$b r5 = r5.f26273a
            java.lang.Object r5 = r5.f76237a
            com.google.android.exoplayer2.k3$b r6 = r12.f26285n
            r4.l(r5, r6)
            com.google.android.exoplayer2.k3$b r4 = r12.f26285n
            long r4 = r4.q()
            long r4 = r4 + r2
            com.google.android.exoplayer2.source.m$a r2 = r12.f26286o
            com.google.android.exoplayer2.k3$d r3 = r12.f26284m
            com.google.android.exoplayer2.k3$d r14 = r2.r(r14, r3)
            long r2 = r14.f()
            int r14 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r14 == 0) goto L74
            r10 = r4
            goto L75
        L74:
            r10 = r0
        L75:
            com.google.android.exoplayer2.k3$d r7 = r12.f26284m
            com.google.android.exoplayer2.k3$b r8 = r12.f26285n
            r9 = 0
            r6 = r15
            android.util.Pair r14 = r6.n(r7, r8, r9, r10)
            java.lang.Object r0 = r14.first
            java.lang.Object r14 = r14.second
            java.lang.Long r14 = (java.lang.Long) r14
            long r1 = r14.longValue()
            boolean r14 = r12.f26290s
            if (r14 == 0) goto L94
            com.google.android.exoplayer2.source.m$a r13 = r12.f26286o
            com.google.android.exoplayer2.source.m$a r13 = r13.z(r15)
            goto L98
        L94:
            com.google.android.exoplayer2.source.m$a r13 = com.google.android.exoplayer2.source.m.a.B(r15, r13, r0)
        L98:
            r12.f26286o = r13
            com.google.android.exoplayer2.source.l r13 = r12.f26287p
            if (r13 == 0) goto Lae
            r12.R(r1)
            com.google.android.exoplayer2.source.o$b r13 = r13.f26273a
            java.lang.Object r14 = r13.f76237a
            java.lang.Object r14 = r12.N(r14)
            com.google.android.exoplayer2.source.o$b r13 = r13.c(r14)
            goto Laf
        Lae:
            r13 = 0
        Laf:
            r14 = 1
            r12.f26290s = r14
            r12.f26289r = r14
            com.google.android.exoplayer2.source.m$a r14 = r12.f26286o
            r12.C(r14)
            if (r13 == 0) goto Lc6
            com.google.android.exoplayer2.source.l r14 = r12.f26287p
            java.lang.Object r14 = com.google.android.exoplayer2.util.a.e(r14)
            com.google.android.exoplayer2.source.l r14 = (com.google.android.exoplayer2.source.l) r14
            r14.c(r13)
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.m.I(java.lang.Void, com.google.android.exoplayer2.source.o, com.google.android.exoplayer2.k3):void");
    }

    @Override // com.google.android.exoplayer2.source.o
    public v1 a() {
        return this.f26282k.a();
    }

    @Override // com.google.android.exoplayer2.source.o
    public void k(n nVar) {
        ((l) nVar).m();
        if (nVar == this.f26287p) {
            this.f26287p = null;
        }
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.o
    public void maybeThrowSourceInfoRefreshError() {
    }
}
