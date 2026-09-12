package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.util.p0;
import g9.e0;

/* loaded from: classes3.dex */
public class a0 implements g9.e0 {
    private o1 A;
    private o1 B;
    private int C;
    private boolean D;
    private boolean E;
    private long F;
    private boolean G;

    /* renamed from: a, reason: collision with root package name */
    private final y f25739a;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.android.exoplayer2.drm.u f25742d;

    /* renamed from: e, reason: collision with root package name */
    private final s.a f25743e;

    /* renamed from: f, reason: collision with root package name */
    private d f25744f;

    /* renamed from: g, reason: collision with root package name */
    private o1 f25745g;

    /* renamed from: h, reason: collision with root package name */
    private DrmSession f25746h;

    /* renamed from: p, reason: collision with root package name */
    private int f25754p;

    /* renamed from: q, reason: collision with root package name */
    private int f25755q;

    /* renamed from: r, reason: collision with root package name */
    private int f25756r;

    /* renamed from: s, reason: collision with root package name */
    private int f25757s;

    /* renamed from: w, reason: collision with root package name */
    private boolean f25761w;

    /* renamed from: z, reason: collision with root package name */
    private boolean f25764z;

    /* renamed from: b, reason: collision with root package name */
    private final b f25740b = new b();

    /* renamed from: i, reason: collision with root package name */
    private int f25747i = 1000;

    /* renamed from: j, reason: collision with root package name */
    private int[] f25748j = new int[1000];

    /* renamed from: k, reason: collision with root package name */
    private long[] f25749k = new long[1000];

    /* renamed from: n, reason: collision with root package name */
    private long[] f25752n = new long[1000];

    /* renamed from: m, reason: collision with root package name */
    private int[] f25751m = new int[1000];

    /* renamed from: l, reason: collision with root package name */
    private int[] f25750l = new int[1000];

    /* renamed from: o, reason: collision with root package name */
    private e0.a[] f25753o = new e0.a[1000];

    /* renamed from: c, reason: collision with root package name */
    private final f0 f25741c = new f0(new com.google.android.exoplayer2.util.i() { // from class: com.google.android.exoplayer2.source.z
        @Override // com.google.android.exoplayer2.util.i
        public final void accept(Object obj) {
            a0.L((a0.c) obj);
        }
    });

    /* renamed from: t, reason: collision with root package name */
    private long f25758t = Long.MIN_VALUE;

    /* renamed from: u, reason: collision with root package name */
    private long f25759u = Long.MIN_VALUE;

    /* renamed from: v, reason: collision with root package name */
    private long f25760v = Long.MIN_VALUE;

    /* renamed from: y, reason: collision with root package name */
    private boolean f25763y = true;

    /* renamed from: x, reason: collision with root package name */
    private boolean f25762x = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f25765a;

        /* renamed from: b, reason: collision with root package name */
        public long f25766b;

        /* renamed from: c, reason: collision with root package name */
        public e0.a f25767c;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final o1 f25768a;

        /* renamed from: b, reason: collision with root package name */
        public final u.b f25769b;

        private c(o1 o1Var, u.b bVar) {
            this.f25768a = o1Var;
            this.f25769b = bVar;
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void c(o1 o1Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a0(com.google.android.exoplayer2.upstream.b bVar, com.google.android.exoplayer2.drm.u uVar, s.a aVar) {
        this.f25742d = uVar;
        this.f25743e = aVar;
        this.f25739a = new y(bVar);
    }

    private long B(int i11) {
        long j11 = Long.MIN_VALUE;
        if (i11 == 0) {
            return Long.MIN_VALUE;
        }
        int D = D(i11 - 1);
        for (int i12 = 0; i12 < i11; i12++) {
            j11 = Math.max(j11, this.f25752n[D]);
            if ((this.f25751m[D] & 1) != 0) {
                break;
            }
            D--;
            if (D == -1) {
                D = this.f25747i - 1;
            }
        }
        return j11;
    }

    private int D(int i11) {
        int i12 = this.f25756r + i11;
        int i13 = this.f25747i;
        return i12 < i13 ? i12 : i12 - i13;
    }

    private boolean H() {
        return this.f25757s != this.f25754p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L(c cVar) {
        cVar.f25769b.release();
    }

    private boolean M(int i11) {
        DrmSession drmSession = this.f25746h;
        return drmSession == null || drmSession.getState() == 4 || ((this.f25751m[i11] & 1073741824) == 0 && this.f25746h.b());
    }

    private void O(o1 o1Var, p1 p1Var) {
        o1 o1Var2 = this.f25745g;
        boolean z10 = o1Var2 == null;
        DrmInitData drmInitData = z10 ? null : o1Var2.f25553o;
        this.f25745g = o1Var;
        DrmInitData drmInitData2 = o1Var.f25553o;
        com.google.android.exoplayer2.drm.u uVar = this.f25742d;
        p1Var.f25652b = uVar != null ? o1Var.c(uVar.a(o1Var)) : o1Var;
        p1Var.f25651a = this.f25746h;
        if (this.f25742d == null) {
            return;
        }
        if (z10 || !p0.c(drmInitData, drmInitData2)) {
            DrmSession drmSession = this.f25746h;
            DrmSession c11 = this.f25742d.c(this.f25743e, o1Var);
            this.f25746h = c11;
            p1Var.f25651a = c11;
            if (drmSession != null) {
                drmSession.f(this.f25743e);
            }
        }
    }

    private synchronized int P(p1 p1Var, DecoderInputBuffer decoderInputBuffer, boolean z10, boolean z11, b bVar) {
        try {
            decoderInputBuffer.f24898d = false;
            if (!H()) {
                if (!z11 && !this.f25761w) {
                    o1 o1Var = this.B;
                    if (o1Var == null || (!z10 && o1Var == this.f25745g)) {
                        return -3;
                    }
                    O((o1) com.google.android.exoplayer2.util.a.e(o1Var), p1Var);
                    return -5;
                }
                decoderInputBuffer.k(4);
                return -4;
            }
            o1 o1Var2 = ((c) this.f25741c.f(C())).f25768a;
            if (!z10 && o1Var2 == this.f25745g) {
                int D = D(this.f25757s);
                if (!M(D)) {
                    decoderInputBuffer.f24898d = true;
                    return -3;
                }
                decoderInputBuffer.k(this.f25751m[D]);
                long j11 = this.f25752n[D];
                decoderInputBuffer.f24899e = j11;
                if (j11 < this.f25758t) {
                    decoderInputBuffer.a(Integer.MIN_VALUE);
                }
                bVar.f25765a = this.f25750l[D];
                bVar.f25766b = this.f25749k[D];
                bVar.f25767c = this.f25753o[D];
                return -4;
            }
            O(o1Var2, p1Var);
            return -5;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void U() {
        DrmSession drmSession = this.f25746h;
        if (drmSession != null) {
            drmSession.f(this.f25743e);
            this.f25746h = null;
            this.f25745g = null;
        }
    }

    private synchronized void X() {
        this.f25757s = 0;
        this.f25739a.o();
    }

    private synchronized boolean c0(o1 o1Var) {
        try {
            this.f25763y = false;
            if (p0.c(o1Var, this.B)) {
                return false;
            }
            if (this.f25741c.h() || !((c) this.f25741c.g()).f25768a.equals(o1Var)) {
                this.B = o1Var;
            } else {
                this.B = ((c) this.f25741c.g()).f25768a;
            }
            o1 o1Var2 = this.B;
            this.D = com.google.android.exoplayer2.util.w.a(o1Var2.f25550l, o1Var2.f25547i);
            this.E = false;
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private synchronized boolean h(long j11) {
        if (this.f25754p == 0) {
            return j11 > this.f25759u;
        }
        if (A() >= j11) {
            return false;
        }
        t(this.f25755q + j(j11));
        return true;
    }

    private synchronized void i(long j11, int i11, long j12, int i12, e0.a aVar) {
        try {
            int i13 = this.f25754p;
            if (i13 > 0) {
                int D = D(i13 - 1);
                com.google.android.exoplayer2.util.a.a(this.f25749k[D] + ((long) this.f25750l[D]) <= j12);
            }
            this.f25761w = (536870912 & i11) != 0;
            this.f25760v = Math.max(this.f25760v, j11);
            int D2 = D(this.f25754p);
            this.f25752n[D2] = j11;
            this.f25749k[D2] = j12;
            this.f25750l[D2] = i12;
            this.f25751m[D2] = i11;
            this.f25753o[D2] = aVar;
            this.f25748j[D2] = this.C;
            if (this.f25741c.h() || !((c) this.f25741c.g()).f25768a.equals(this.B)) {
                com.google.android.exoplayer2.drm.u uVar = this.f25742d;
                this.f25741c.b(G(), new c((o1) com.google.android.exoplayer2.util.a.e(this.B), uVar != null ? uVar.d(this.f25743e, this.B) : u.b.f25073a));
            }
            int i14 = this.f25754p + 1;
            this.f25754p = i14;
            int i15 = this.f25747i;
            if (i14 == i15) {
                int i16 = i15 + 1000;
                int[] iArr = new int[i16];
                long[] jArr = new long[i16];
                long[] jArr2 = new long[i16];
                int[] iArr2 = new int[i16];
                int[] iArr3 = new int[i16];
                e0.a[] aVarArr = new e0.a[i16];
                int i17 = this.f25756r;
                int i18 = i15 - i17;
                System.arraycopy(this.f25749k, i17, jArr, 0, i18);
                System.arraycopy(this.f25752n, this.f25756r, jArr2, 0, i18);
                System.arraycopy(this.f25751m, this.f25756r, iArr2, 0, i18);
                System.arraycopy(this.f25750l, this.f25756r, iArr3, 0, i18);
                System.arraycopy(this.f25753o, this.f25756r, aVarArr, 0, i18);
                System.arraycopy(this.f25748j, this.f25756r, iArr, 0, i18);
                int i19 = this.f25756r;
                System.arraycopy(this.f25749k, 0, jArr, i18, i19);
                System.arraycopy(this.f25752n, 0, jArr2, i18, i19);
                System.arraycopy(this.f25751m, 0, iArr2, i18, i19);
                System.arraycopy(this.f25750l, 0, iArr3, i18, i19);
                System.arraycopy(this.f25753o, 0, aVarArr, i18, i19);
                System.arraycopy(this.f25748j, 0, iArr, i18, i19);
                this.f25749k = jArr;
                this.f25752n = jArr2;
                this.f25751m = iArr2;
                this.f25750l = iArr3;
                this.f25753o = aVarArr;
                this.f25748j = iArr;
                this.f25756r = 0;
                this.f25747i = i16;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private int j(long j11) {
        int i11 = this.f25754p;
        int D = D(i11 - 1);
        while (i11 > this.f25757s && this.f25752n[D] >= j11) {
            i11--;
            D--;
            if (D == -1) {
                D = this.f25747i - 1;
            }
        }
        return i11;
    }

    public static a0 k(com.google.android.exoplayer2.upstream.b bVar, com.google.android.exoplayer2.drm.u uVar, s.a aVar) {
        return new a0(bVar, (com.google.android.exoplayer2.drm.u) com.google.android.exoplayer2.util.a.e(uVar), (s.a) com.google.android.exoplayer2.util.a.e(aVar));
    }

    public static a0 l(com.google.android.exoplayer2.upstream.b bVar) {
        return new a0(bVar, null, null);
    }

    private synchronized long m(long j11, boolean z10, boolean z11) {
        int i11;
        try {
            int i12 = this.f25754p;
            if (i12 != 0) {
                long[] jArr = this.f25752n;
                int i13 = this.f25756r;
                if (j11 >= jArr[i13]) {
                    if (z11 && (i11 = this.f25757s) != i12) {
                        i12 = i11 + 1;
                    }
                    int v11 = v(i13, i12, j11, z10);
                    if (v11 == -1) {
                        return -1L;
                    }
                    return p(v11);
                }
            }
            return -1L;
        } finally {
        }
    }

    private synchronized long n() {
        int i11 = this.f25754p;
        if (i11 == 0) {
            return -1L;
        }
        return p(i11);
    }

    private long p(int i11) {
        this.f25759u = Math.max(this.f25759u, B(i11));
        this.f25754p -= i11;
        int i12 = this.f25755q + i11;
        this.f25755q = i12;
        int i13 = this.f25756r + i11;
        this.f25756r = i13;
        int i14 = this.f25747i;
        if (i13 >= i14) {
            this.f25756r = i13 - i14;
        }
        int i15 = this.f25757s - i11;
        this.f25757s = i15;
        if (i15 < 0) {
            this.f25757s = 0;
        }
        this.f25741c.e(i12);
        if (this.f25754p != 0) {
            return this.f25749k[this.f25756r];
        }
        int i16 = this.f25756r;
        if (i16 == 0) {
            i16 = this.f25747i;
        }
        return this.f25749k[i16 - 1] + this.f25750l[r6];
    }

    private long t(int i11) {
        int G = G() - i11;
        boolean z10 = false;
        com.google.android.exoplayer2.util.a.a(G >= 0 && G <= this.f25754p - this.f25757s);
        int i12 = this.f25754p - G;
        this.f25754p = i12;
        this.f25760v = Math.max(this.f25759u, B(i12));
        if (G == 0 && this.f25761w) {
            z10 = true;
        }
        this.f25761w = z10;
        this.f25741c.d(i11);
        int i13 = this.f25754p;
        if (i13 == 0) {
            return 0L;
        }
        return this.f25749k[D(i13 - 1)] + this.f25750l[r9];
    }

    private int v(int i11, int i12, long j11, boolean z10) {
        int i13 = -1;
        for (int i14 = 0; i14 < i12; i14++) {
            long j12 = this.f25752n[i11];
            if (j12 > j11) {
                return i13;
            }
            if (!z10 || (this.f25751m[i11] & 1) != 0) {
                if (j12 == j11) {
                    return i14;
                }
                i13 = i14;
            }
            i11++;
            if (i11 == this.f25747i) {
                i11 = 0;
            }
        }
        return i13;
    }

    public final synchronized long A() {
        return Math.max(this.f25759u, B(this.f25757s));
    }

    public final int C() {
        return this.f25755q + this.f25757s;
    }

    public final synchronized int E(long j11, boolean z10) {
        int D = D(this.f25757s);
        if (H() && j11 >= this.f25752n[D]) {
            if (j11 > this.f25760v && z10) {
                return this.f25754p - this.f25757s;
            }
            int v11 = v(D, this.f25754p - this.f25757s, j11, true);
            if (v11 == -1) {
                return 0;
            }
            return v11;
        }
        return 0;
    }

    public final synchronized o1 F() {
        return this.f25763y ? null : this.B;
    }

    public final int G() {
        return this.f25755q + this.f25754p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void I() {
        this.f25764z = true;
    }

    public final synchronized boolean J() {
        return this.f25761w;
    }

    public synchronized boolean K(boolean z10) {
        o1 o1Var;
        boolean z11 = true;
        if (H()) {
            if (((c) this.f25741c.f(C())).f25768a != this.f25745g) {
                return true;
            }
            return M(D(this.f25757s));
        }
        if (!z10 && !this.f25761w && ((o1Var = this.B) == null || o1Var == this.f25745g)) {
            z11 = false;
        }
        return z11;
    }

    public void N() {
        DrmSession drmSession = this.f25746h;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) com.google.android.exoplayer2.util.a.e(this.f25746h.getError()));
        }
    }

    public final synchronized int Q() {
        try {
        } catch (Throwable th2) {
            throw th2;
        }
        return H() ? this.f25748j[D(this.f25757s)] : this.C;
    }

    public void R() {
        r();
        U();
    }

    public int S(p1 p1Var, DecoderInputBuffer decoderInputBuffer, int i11, boolean z10) {
        int P = P(p1Var, decoderInputBuffer, (i11 & 2) != 0, z10, this.f25740b);
        if (P == -4 && !decoderInputBuffer.h()) {
            boolean z11 = (i11 & 1) != 0;
            if ((i11 & 4) == 0) {
                if (z11) {
                    this.f25739a.f(decoderInputBuffer, this.f25740b);
                } else {
                    this.f25739a.m(decoderInputBuffer, this.f25740b);
                }
            }
            if (!z11) {
                this.f25757s++;
            }
        }
        return P;
    }

    public void T() {
        W(true);
        U();
    }

    public final void V() {
        W(false);
    }

    public void W(boolean z10) {
        this.f25739a.n();
        this.f25754p = 0;
        this.f25755q = 0;
        this.f25756r = 0;
        this.f25757s = 0;
        this.f25762x = true;
        this.f25758t = Long.MIN_VALUE;
        this.f25759u = Long.MIN_VALUE;
        this.f25760v = Long.MIN_VALUE;
        this.f25761w = false;
        this.f25741c.c();
        if (z10) {
            this.A = null;
            this.B = null;
            this.f25763y = true;
        }
    }

    public final synchronized boolean Y(int i11) {
        X();
        int i12 = this.f25755q;
        if (i11 >= i12 && i11 <= this.f25754p + i12) {
            this.f25758t = Long.MIN_VALUE;
            this.f25757s = i11 - i12;
            return true;
        }
        return false;
    }

    public final synchronized boolean Z(long j11, boolean z10) {
        X();
        int D = D(this.f25757s);
        if (H() && j11 >= this.f25752n[D] && (j11 <= this.f25760v || z10)) {
            int v11 = v(D, this.f25754p - this.f25757s, j11, true);
            if (v11 == -1) {
                return false;
            }
            this.f25758t = j11;
            this.f25757s += v11;
            return true;
        }
        return false;
    }

    @Override // g9.e0
    public final int a(com.google.android.exoplayer2.upstream.g gVar, int i11, boolean z10, int i12) {
        return this.f25739a.p(gVar, i11, z10);
    }

    public final void a0(long j11) {
        if (this.F != j11) {
            this.F = j11;
            I();
        }
    }

    @Override // g9.e0
    public /* synthetic */ int b(com.google.android.exoplayer2.upstream.g gVar, int i11, boolean z10) {
        return g9.d0.a(this, gVar, i11, z10);
    }

    public final void b0(long j11) {
        this.f25758t = j11;
    }

    @Override // g9.e0
    public /* synthetic */ void c(com.google.android.exoplayer2.util.d0 d0Var, int i11) {
        g9.d0.b(this, d0Var, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    @Override // g9.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(long r12, int r14, int r15, int r16, g9.e0.a r17) {
        /*
            r11 = this;
            r8 = r11
            boolean r0 = r8.f25764z
            if (r0 == 0) goto L10
            com.google.android.exoplayer2.o1 r0 = r8.A
            java.lang.Object r0 = com.google.android.exoplayer2.util.a.i(r0)
            com.google.android.exoplayer2.o1 r0 = (com.google.android.exoplayer2.o1) r0
            r11.e(r0)
        L10:
            r0 = r14 & 1
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L18
            r3 = r2
            goto L19
        L18:
            r3 = r1
        L19:
            boolean r4 = r8.f25762x
            if (r4 == 0) goto L22
            if (r3 != 0) goto L20
            return
        L20:
            r8.f25762x = r1
        L22:
            long r4 = r8.F
            long r4 = r4 + r12
            boolean r6 = r8.D
            if (r6 == 0) goto L54
            long r6 = r8.f25758t
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 >= 0) goto L30
            return
        L30:
            if (r0 != 0) goto L54
            boolean r0 = r8.E
            if (r0 != 0) goto L50
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "Overriding unexpected non-sync sample for format: "
            r0.append(r6)
            com.google.android.exoplayer2.o1 r6 = r8.B
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = "SampleQueue"
            com.google.android.exoplayer2.util.s.i(r6, r0)
            r8.E = r2
        L50:
            r0 = r14 | 1
            r6 = r0
            goto L55
        L54:
            r6 = r14
        L55:
            boolean r0 = r8.G
            if (r0 == 0) goto L66
            if (r3 == 0) goto L65
            boolean r0 = r11.h(r4)
            if (r0 != 0) goto L62
            goto L65
        L62:
            r8.G = r1
            goto L66
        L65:
            return
        L66:
            com.google.android.exoplayer2.source.y r0 = r8.f25739a
            long r0 = r0.e()
            r7 = r15
            long r2 = (long) r7
            long r0 = r0 - r2
            r2 = r16
            long r2 = (long) r2
            long r9 = r0 - r2
            r0 = r11
            r1 = r4
            r3 = r6
            r4 = r9
            r6 = r15
            r7 = r17
            r0.i(r1, r3, r4, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.a0.d(long, int, int, int, g9.e0$a):void");
    }

    public final void d0(d dVar) {
        this.f25744f = dVar;
    }

    @Override // g9.e0
    public final void e(o1 o1Var) {
        o1 w11 = w(o1Var);
        this.f25764z = false;
        this.A = o1Var;
        boolean c02 = c0(w11);
        d dVar = this.f25744f;
        if (dVar == null || !c02) {
            return;
        }
        dVar.c(w11);
    }

    public final synchronized void e0(int i11) {
        boolean z10;
        if (i11 >= 0) {
            try {
                if (this.f25757s + i11 <= this.f25754p) {
                    z10 = true;
                    com.google.android.exoplayer2.util.a.a(z10);
                    this.f25757s += i11;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        z10 = false;
        com.google.android.exoplayer2.util.a.a(z10);
        this.f25757s += i11;
    }

    @Override // g9.e0
    public final void f(com.google.android.exoplayer2.util.d0 d0Var, int i11, int i12) {
        this.f25739a.q(d0Var, i11);
    }

    public final void f0(int i11) {
        this.C = i11;
    }

    public final void g0() {
        this.G = true;
    }

    public synchronized long o() {
        int i11 = this.f25757s;
        if (i11 == 0) {
            return -1L;
        }
        return p(i11);
    }

    public final void q(long j11, boolean z10, boolean z11) {
        this.f25739a.b(m(j11, z10, z11));
    }

    public final void r() {
        this.f25739a.b(n());
    }

    public final void s() {
        this.f25739a.b(o());
    }

    public final void u(int i11) {
        this.f25739a.c(t(i11));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public o1 w(o1 o1Var) {
        return (this.F == 0 || o1Var.f25554p == Long.MAX_VALUE) ? o1Var : o1Var.b().i0(o1Var.f25554p + this.F).E();
    }

    public final int x() {
        return this.f25755q;
    }

    public final synchronized long y() {
        return this.f25754p == 0 ? Long.MIN_VALUE : this.f25752n[this.f25756r];
    }

    public final synchronized long z() {
        return this.f25760v;
    }
}
