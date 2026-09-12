package androidx.media3.exoplayer.source;

import androidx.media3.common.e0;
import androidx.media3.exoplayer.source.r;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class p extends l0 {

    /* renamed from: m, reason: collision with root package name */
    private final boolean f12953m;

    /* renamed from: n, reason: collision with root package name */
    private final e0.c f12954n;

    /* renamed from: o, reason: collision with root package name */
    private final e0.b f12955o;

    /* renamed from: p, reason: collision with root package name */
    private a f12956p;

    /* renamed from: q, reason: collision with root package name */
    private o f12957q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f12958r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f12959s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f12960t;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a extends m {

        /* renamed from: h, reason: collision with root package name */
        public static final Object f12961h = new Object();

        /* renamed from: f, reason: collision with root package name */
        private final Object f12962f;

        /* renamed from: g, reason: collision with root package name */
        private final Object f12963g;

        private a(androidx.media3.common.e0 e0Var, Object obj, Object obj2) {
            super(e0Var);
            this.f12962f = obj;
            this.f12963g = obj2;
        }

        public static a u(androidx.media3.common.t tVar) {
            return new a(new b(tVar), e0.c.f10023q, f12961h);
        }

        public static a v(androidx.media3.common.e0 e0Var, Object obj, Object obj2) {
            return new a(e0Var, obj, obj2);
        }

        @Override // androidx.media3.exoplayer.source.m, androidx.media3.common.e0
        public int b(Object obj) {
            Object obj2;
            androidx.media3.common.e0 e0Var = this.f12938e;
            if (f12961h.equals(obj) && (obj2 = this.f12963g) != null) {
                obj = obj2;
            }
            return e0Var.b(obj);
        }

        @Override // androidx.media3.exoplayer.source.m, androidx.media3.common.e0
        public e0.b g(int i11, e0.b bVar, boolean z10) {
            this.f12938e.g(i11, bVar, z10);
            if (Objects.equals(bVar.f10017b, this.f12963g) && z10) {
                bVar.f10017b = f12961h;
            }
            return bVar;
        }

        @Override // androidx.media3.exoplayer.source.m, androidx.media3.common.e0
        public Object m(int i11) {
            Object m11 = this.f12938e.m(i11);
            return Objects.equals(m11, this.f12963g) ? f12961h : m11;
        }

        @Override // androidx.media3.exoplayer.source.m, androidx.media3.common.e0
        public e0.c o(int i11, e0.c cVar, long j11) {
            this.f12938e.o(i11, cVar, j11);
            if (Objects.equals(cVar.f10033a, this.f12962f)) {
                cVar.f10033a = e0.c.f10023q;
            }
            return cVar;
        }

        public a t(androidx.media3.common.e0 e0Var) {
            return new a(e0Var, this.f12962f, this.f12963g);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends androidx.media3.common.e0 {

        /* renamed from: e, reason: collision with root package name */
        private final androidx.media3.common.t f12964e;

        public b(androidx.media3.common.t tVar) {
            this.f12964e = tVar;
        }

        @Override // androidx.media3.common.e0
        public int b(Object obj) {
            return obj == a.f12961h ? 0 : -1;
        }

        @Override // androidx.media3.common.e0
        public e0.b g(int i11, e0.b bVar, boolean z10) {
            bVar.u(z10 ? 0 : null, z10 ? a.f12961h : null, 0, C.TIME_UNSET, 0L, androidx.media3.common.b.f9955g, true);
            return bVar;
        }

        @Override // androidx.media3.common.e0
        public int i() {
            return 1;
        }

        @Override // androidx.media3.common.e0
        public Object m(int i11) {
            return a.f12961h;
        }

        @Override // androidx.media3.common.e0
        public e0.c o(int i11, e0.c cVar, long j11) {
            cVar.g(e0.c.f10023q, this.f12964e, null, C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, false, true, null, 0L, C.TIME_UNSET, 0, 0, 0L);
            cVar.f10043k = true;
            return cVar;
        }

        @Override // androidx.media3.common.e0
        public int p() {
            return 1;
        }
    }

    public p(r rVar, boolean z10) {
        super(rVar);
        this.f12953m = z10 && rVar.b();
        this.f12954n = new e0.c();
        this.f12955o = new e0.b();
        androidx.media3.common.e0 c11 = rVar.c();
        if (c11 == null) {
            this.f12956p = a.u(rVar.a());
        } else {
            this.f12956p = a.v(c11, null, null);
            this.f12960t = true;
        }
    }

    private Object U(Object obj) {
        return (this.f12956p.f12963g == null || !this.f12956p.f12963g.equals(obj)) ? obj : a.f12961h;
    }

    private Object V(Object obj) {
        return (this.f12956p.f12963g == null || !obj.equals(a.f12961h)) ? obj : this.f12956p.f12963g;
    }

    private boolean X(long j11) {
        o oVar = this.f12957q;
        int b11 = this.f12956p.b(oVar.f12944a.f12965a);
        if (b11 == -1) {
            return false;
        }
        long j12 = this.f12956p.f(b11, this.f12955o).f10019d;
        if (j12 != C.TIME_UNSET && j11 >= j12) {
            j11 = Math.max(0L, j12 - 1);
        }
        oVar.m(j11);
        return true;
    }

    @Override // androidx.media3.exoplayer.source.c, androidx.media3.exoplayer.source.a
    public void B() {
        this.f12959s = false;
        this.f12958r = false;
        super.B();
    }

    @Override // androidx.media3.exoplayer.source.l0
    protected r.b J(r.b bVar) {
        return bVar.a(U(bVar.f12965a));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00be  */
    @Override // androidx.media3.exoplayer.source.l0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void P(androidx.media3.common.e0 r15) {
        /*
            r14 = this;
            boolean r0 = r14.f12959s
            if (r0 == 0) goto L19
            androidx.media3.exoplayer.source.p$a r0 = r14.f12956p
            androidx.media3.exoplayer.source.p$a r15 = r0.t(r15)
            r14.f12956p = r15
            androidx.media3.exoplayer.source.o r15 = r14.f12957q
            if (r15 == 0) goto Lb1
            long r0 = r15.i()
            r14.X(r0)
            goto Lb1
        L19:
            boolean r0 = r15.q()
            if (r0 == 0) goto L36
            boolean r0 = r14.f12960t
            if (r0 == 0) goto L2a
            androidx.media3.exoplayer.source.p$a r0 = r14.f12956p
            androidx.media3.exoplayer.source.p$a r15 = r0.t(r15)
            goto L32
        L2a:
            java.lang.Object r0 = androidx.media3.common.e0.c.f10023q
            java.lang.Object r1 = androidx.media3.exoplayer.source.p.a.f12961h
            androidx.media3.exoplayer.source.p$a r15 = androidx.media3.exoplayer.source.p.a.v(r15, r0, r1)
        L32:
            r14.f12956p = r15
            goto Lb1
        L36:
            androidx.media3.common.e0$c r0 = r14.f12954n
            r1 = 0
            r15.n(r1, r0)
            androidx.media3.common.e0$c r0 = r14.f12954n
            long r2 = r0.c()
            androidx.media3.common.e0$c r0 = r14.f12954n
            java.lang.Object r0 = r0.f10033a
            androidx.media3.exoplayer.source.o r4 = r14.f12957q
            if (r4 == 0) goto L74
            long r4 = r4.j()
            androidx.media3.exoplayer.source.p$a r6 = r14.f12956p
            androidx.media3.exoplayer.source.o r7 = r14.f12957q
            androidx.media3.exoplayer.source.r$b r7 = r7.f12944a
            java.lang.Object r7 = r7.f12965a
            androidx.media3.common.e0$b r8 = r14.f12955o
            r6.h(r7, r8)
            androidx.media3.common.e0$b r6 = r14.f12955o
            long r6 = r6.o()
            long r6 = r6 + r4
            androidx.media3.exoplayer.source.p$a r4 = r14.f12956p
            androidx.media3.common.e0$c r5 = r14.f12954n
            androidx.media3.common.e0$c r1 = r4.n(r1, r5)
            long r4 = r1.c()
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 == 0) goto L74
            r12 = r6
            goto L75
        L74:
            r12 = r2
        L75:
            androidx.media3.common.e0$c r9 = r14.f12954n
            androidx.media3.common.e0$b r10 = r14.f12955o
            r11 = 0
            r8 = r15
            android.util.Pair r1 = r8.j(r9, r10, r11, r12)
            java.lang.Object r2 = r1.first
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r3 = r1.longValue()
            boolean r1 = r14.f12960t
            if (r1 == 0) goto L94
            androidx.media3.exoplayer.source.p$a r0 = r14.f12956p
            androidx.media3.exoplayer.source.p$a r15 = r0.t(r15)
            goto L98
        L94:
            androidx.media3.exoplayer.source.p$a r15 = androidx.media3.exoplayer.source.p.a.v(r15, r0, r2)
        L98:
            r14.f12956p = r15
            androidx.media3.exoplayer.source.o r15 = r14.f12957q
            if (r15 == 0) goto Lb1
            boolean r0 = r14.X(r3)
            if (r0 == 0) goto Lb1
            androidx.media3.exoplayer.source.r$b r15 = r15.f12944a
            java.lang.Object r0 = r15.f12965a
            java.lang.Object r0 = r14.V(r0)
            androidx.media3.exoplayer.source.r$b r15 = r15.a(r0)
            goto Lb2
        Lb1:
            r15 = 0
        Lb2:
            r0 = 1
            r14.f12960t = r0
            r14.f12959s = r0
            androidx.media3.exoplayer.source.p$a r0 = r14.f12956p
            r14.A(r0)
            if (r15 == 0) goto Lc9
            androidx.media3.exoplayer.source.o r0 = r14.f12957q
            java.lang.Object r0 = androidx.media3.common.util.a.e(r0)
            androidx.media3.exoplayer.source.o r0 = (androidx.media3.exoplayer.source.o) r0
            r0.h(r15)
        Lc9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.p.P(androidx.media3.common.e0):void");
    }

    @Override // androidx.media3.exoplayer.source.l0
    public void S() {
        if (this.f12953m) {
            return;
        }
        this.f12958r = true;
        R();
    }

    @Override // androidx.media3.exoplayer.source.r
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public o g(r.b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11) {
        o oVar = new o(bVar, bVar2, j11);
        oVar.o(this.f12937k);
        if (this.f12959s) {
            oVar.h(bVar.a(V(bVar.f12965a)));
        } else {
            this.f12957q = oVar;
            if (!this.f12958r) {
                this.f12958r = true;
                R();
            }
        }
        return oVar;
    }

    public androidx.media3.common.e0 W() {
        return this.f12956p;
    }

    @Override // androidx.media3.exoplayer.source.r
    public void j(q qVar) {
        ((o) qVar).n();
        if (qVar == this.f12957q) {
            this.f12957q = null;
        }
    }

    @Override // androidx.media3.exoplayer.source.l0, androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.r
    public void l(androidx.media3.common.t tVar) {
        if (this.f12960t) {
            this.f12956p = this.f12956p.t(new g2.x(this.f12956p.f12938e, tVar));
        } else {
            this.f12956p = a.u(tVar);
        }
        this.f12937k.l(tVar);
    }

    @Override // androidx.media3.exoplayer.source.c, androidx.media3.exoplayer.source.r
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.r
    public boolean q(androidx.media3.common.t tVar) {
        return this.f12937k.q(tVar);
    }
}
