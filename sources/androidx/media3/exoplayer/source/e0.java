package androidx.media3.exoplayer.source;

import androidx.media3.common.DrmInitData;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.r;
import androidx.media3.exoplayer.drm.t;
import androidx.media3.exoplayer.s2;
import androidx.media3.exoplayer.source.e0;
import java.util.Objects;
import l2.r0;
import l2.s0;
import org.mvel2.ast.ASTNode;

/* loaded from: classes2.dex */
public class e0 implements s0 {
    private androidx.media3.common.r A;
    private androidx.media3.common.r B;
    private long C;
    private boolean E;
    private long F;
    private boolean G;

    /* renamed from: a, reason: collision with root package name */
    private final c0 f12822a;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.media3.exoplayer.drm.t f12825d;

    /* renamed from: e, reason: collision with root package name */
    private final r.a f12826e;

    /* renamed from: f, reason: collision with root package name */
    private d f12827f;

    /* renamed from: g, reason: collision with root package name */
    private androidx.media3.common.r f12828g;

    /* renamed from: h, reason: collision with root package name */
    private DrmSession f12829h;

    /* renamed from: p, reason: collision with root package name */
    private int f12837p;

    /* renamed from: q, reason: collision with root package name */
    private int f12838q;

    /* renamed from: r, reason: collision with root package name */
    private int f12839r;

    /* renamed from: s, reason: collision with root package name */
    private int f12840s;

    /* renamed from: w, reason: collision with root package name */
    private boolean f12844w;

    /* renamed from: z, reason: collision with root package name */
    private boolean f12847z;

    /* renamed from: b, reason: collision with root package name */
    private final b f12823b = new b();

    /* renamed from: i, reason: collision with root package name */
    private int f12830i = 1000;

    /* renamed from: j, reason: collision with root package name */
    private long[] f12831j = new long[1000];

    /* renamed from: k, reason: collision with root package name */
    private long[] f12832k = new long[1000];

    /* renamed from: n, reason: collision with root package name */
    private long[] f12835n = new long[1000];

    /* renamed from: m, reason: collision with root package name */
    private int[] f12834m = new int[1000];

    /* renamed from: l, reason: collision with root package name */
    private int[] f12833l = new int[1000];

    /* renamed from: o, reason: collision with root package name */
    private s0.a[] f12836o = new s0.a[1000];

    /* renamed from: c, reason: collision with root package name */
    private final j0 f12824c = new j0(new androidx.media3.common.util.m() { // from class: androidx.media3.exoplayer.source.d0
        @Override // androidx.media3.common.util.m
        public final void accept(Object obj) {
            e0.O((e0.c) obj);
        }
    });

    /* renamed from: t, reason: collision with root package name */
    private long f12841t = Long.MIN_VALUE;

    /* renamed from: u, reason: collision with root package name */
    private long f12842u = Long.MIN_VALUE;

    /* renamed from: v, reason: collision with root package name */
    private long f12843v = Long.MIN_VALUE;

    /* renamed from: y, reason: collision with root package name */
    private boolean f12846y = true;

    /* renamed from: x, reason: collision with root package name */
    private boolean f12845x = true;
    private boolean D = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f12848a;

        /* renamed from: b, reason: collision with root package name */
        public long f12849b;

        /* renamed from: c, reason: collision with root package name */
        public s0.a f12850c;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.media3.common.r f12851a;

        /* renamed from: b, reason: collision with root package name */
        public final t.b f12852b;

        private c(androidx.media3.common.r rVar, t.b bVar) {
            this.f12851a = rVar;
            this.f12852b = bVar;
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void c(androidx.media3.common.r rVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e0(androidx.media3.exoplayer.upstream.b bVar, androidx.media3.exoplayer.drm.t tVar, r.a aVar) {
        this.f12825d = tVar;
        this.f12826e = aVar;
        this.f12822a = new c0(bVar);
    }

    private long E(int i11) {
        long j11 = Long.MIN_VALUE;
        if (i11 == 0) {
            return Long.MIN_VALUE;
        }
        int G = G(i11 - 1);
        for (int i12 = 0; i12 < i11; i12++) {
            j11 = Math.max(j11, this.f12835n[G]);
            if ((this.f12834m[G] & 1) != 0) {
                break;
            }
            G--;
            if (G == -1) {
                G = this.f12830i - 1;
            }
        }
        return j11;
    }

    private int G(int i11) {
        int i12 = this.f12839r + i11;
        int i13 = this.f12830i;
        return i12 < i13 ? i12 : i12 - i13;
    }

    private boolean K() {
        return this.f12840s != this.f12837p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(c cVar) {
        cVar.f12852b.release();
    }

    private boolean P(int i11) {
        DrmSession drmSession = this.f12829h;
        return drmSession == null || drmSession.getState() == 4 || ((this.f12834m[i11] & 1073741824) == 0 && this.f12829h.b());
    }

    private void R(androidx.media3.common.r rVar, s2 s2Var) {
        androidx.media3.common.r rVar2 = this.f12828g;
        boolean z10 = rVar2 == null;
        DrmInitData drmInitData = rVar2 == null ? null : rVar2.f10247s;
        this.f12828g = rVar;
        DrmInitData drmInitData2 = rVar.f10247s;
        androidx.media3.exoplayer.drm.t tVar = this.f12825d;
        s2Var.f12652b = tVar != null ? rVar.c(tVar.b(rVar)) : rVar;
        s2Var.f12651a = this.f12829h;
        if (this.f12825d == null) {
            return;
        }
        if (z10 || !Objects.equals(drmInitData, drmInitData2)) {
            DrmSession drmSession = this.f12829h;
            DrmSession a11 = this.f12825d.a(this.f12826e, rVar);
            this.f12829h = a11;
            s2Var.f12651a = a11;
            if (drmSession != null) {
                drmSession.f(this.f12826e);
            }
        }
    }

    private synchronized int S(s2 s2Var, DecoderInputBuffer decoderInputBuffer, boolean z10, boolean z11, b bVar) {
        try {
            decoderInputBuffer.f11001d = false;
            if (!K()) {
                if (!z11 && !this.f12844w) {
                    androidx.media3.common.r rVar = this.B;
                    if (rVar == null || (!z10 && rVar == this.f12828g)) {
                        return -3;
                    }
                    R((androidx.media3.common.r) androidx.media3.common.util.a.e(rVar), s2Var);
                    return -5;
                }
                decoderInputBuffer.setFlags(4);
                decoderInputBuffer.f11002e = Long.MIN_VALUE;
                return -4;
            }
            androidx.media3.common.r rVar2 = ((c) this.f12824c.f(F())).f12851a;
            if (!z10 && rVar2 == this.f12828g) {
                int G = G(this.f12840s);
                if (!P(G)) {
                    decoderInputBuffer.f11001d = true;
                    return -3;
                }
                decoderInputBuffer.setFlags(this.f12834m[G]);
                if (this.f12840s == this.f12837p - 1 && (z11 || this.f12844w)) {
                    decoderInputBuffer.addFlag(ASTNode.DISCARD);
                }
                decoderInputBuffer.f11002e = this.f12835n[G];
                bVar.f12848a = this.f12833l[G];
                bVar.f12849b = this.f12832k[G];
                bVar.f12850c = this.f12836o[G];
                return -4;
            }
            R(rVar2, s2Var);
            return -5;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void X() {
        DrmSession drmSession = this.f12829h;
        if (drmSession != null) {
            drmSession.f(this.f12826e);
            this.f12829h = null;
            this.f12828g = null;
        }
    }

    private synchronized void a0() {
        this.f12840s = 0;
        this.f12822a.o();
    }

    private synchronized boolean f0(androidx.media3.common.r rVar) {
        try {
            this.f12846y = false;
            if (Objects.equals(rVar, this.B)) {
                return false;
            }
            if (this.f12824c.h() || !((c) this.f12824c.g()).f12851a.equals(rVar)) {
                this.B = rVar;
            } else {
                this.B = ((c) this.f12824c.g()).f12851a;
            }
            boolean z10 = this.D;
            androidx.media3.common.r rVar2 = this.B;
            this.D = z10 & androidx.media3.common.y.a(rVar2.f10243o, rVar2.f10239k);
            this.E = false;
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private synchronized boolean i(long j11) {
        if (this.f12837p == 0) {
            return j11 > this.f12842u;
        }
        if (D() >= j11) {
            return false;
        }
        v(this.f12838q + k(j11));
        return true;
    }

    private synchronized void j(long j11, int i11, long j12, int i12, s0.a aVar) {
        try {
            int i13 = this.f12837p;
            if (i13 > 0) {
                int G = G(i13 - 1);
                androidx.media3.common.util.a.a(this.f12832k[G] + ((long) this.f12833l[G]) <= j12);
            }
            this.f12844w = (536870912 & i11) != 0;
            this.f12843v = Math.max(this.f12843v, j11);
            int G2 = G(this.f12837p);
            this.f12835n[G2] = j11;
            this.f12832k[G2] = j12;
            this.f12833l[G2] = i12;
            this.f12834m[G2] = i11;
            this.f12836o[G2] = aVar;
            this.f12831j[G2] = this.C;
            if (this.f12824c.h() || !((c) this.f12824c.g()).f12851a.equals(this.B)) {
                androidx.media3.common.r rVar = (androidx.media3.common.r) androidx.media3.common.util.a.e(this.B);
                androidx.media3.exoplayer.drm.t tVar = this.f12825d;
                this.f12824c.b(J(), new c(rVar, tVar != null ? tVar.d(this.f12826e, rVar) : t.b.f11695a));
            }
            int i14 = this.f12837p + 1;
            this.f12837p = i14;
            int i15 = this.f12830i;
            if (i14 == i15) {
                int i16 = i15 + 1000;
                long[] jArr = new long[i16];
                long[] jArr2 = new long[i16];
                long[] jArr3 = new long[i16];
                int[] iArr = new int[i16];
                int[] iArr2 = new int[i16];
                s0.a[] aVarArr = new s0.a[i16];
                int i17 = this.f12839r;
                int i18 = i15 - i17;
                System.arraycopy(this.f12832k, i17, jArr2, 0, i18);
                System.arraycopy(this.f12835n, this.f12839r, jArr3, 0, i18);
                System.arraycopy(this.f12834m, this.f12839r, iArr, 0, i18);
                System.arraycopy(this.f12833l, this.f12839r, iArr2, 0, i18);
                System.arraycopy(this.f12836o, this.f12839r, aVarArr, 0, i18);
                System.arraycopy(this.f12831j, this.f12839r, jArr, 0, i18);
                int i19 = this.f12839r;
                System.arraycopy(this.f12832k, 0, jArr2, i18, i19);
                System.arraycopy(this.f12835n, 0, jArr3, i18, i19);
                System.arraycopy(this.f12834m, 0, iArr, i18, i19);
                System.arraycopy(this.f12833l, 0, iArr2, i18, i19);
                System.arraycopy(this.f12836o, 0, aVarArr, i18, i19);
                System.arraycopy(this.f12831j, 0, jArr, i18, i19);
                this.f12832k = jArr2;
                this.f12835n = jArr3;
                this.f12834m = iArr;
                this.f12833l = iArr2;
                this.f12836o = aVarArr;
                this.f12831j = jArr;
                this.f12839r = 0;
                this.f12830i = i16;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private int k(long j11) {
        int i11 = this.f12837p;
        int G = G(i11 - 1);
        while (i11 > this.f12840s && this.f12835n[G] >= j11) {
            i11--;
            G--;
            if (G == -1) {
                G = this.f12830i - 1;
            }
        }
        return i11;
    }

    public static e0 l(androidx.media3.exoplayer.upstream.b bVar, androidx.media3.exoplayer.drm.t tVar, r.a aVar) {
        return new e0(bVar, (androidx.media3.exoplayer.drm.t) androidx.media3.common.util.a.e(tVar), (r.a) androidx.media3.common.util.a.e(aVar));
    }

    public static e0 m(androidx.media3.exoplayer.upstream.b bVar) {
        return new e0(bVar, null, null);
    }

    private synchronized long n(long j11, boolean z10, boolean z11) {
        int i11;
        try {
            int i12 = this.f12837p;
            if (i12 != 0) {
                long[] jArr = this.f12835n;
                int i13 = this.f12839r;
                if (j11 >= jArr[i13]) {
                    if (z11 && (i11 = this.f12840s) != i12) {
                        i12 = i11 + 1;
                    }
                    int y10 = y(i13, i12, j11, z10);
                    if (y10 == -1) {
                        return -1L;
                    }
                    return q(y10);
                }
            }
            return -1L;
        } finally {
        }
    }

    private synchronized long o() {
        int i11 = this.f12837p;
        if (i11 == 0) {
            return -1L;
        }
        return q(i11);
    }

    private long q(int i11) {
        this.f12842u = Math.max(this.f12842u, E(i11));
        this.f12837p -= i11;
        int i12 = this.f12838q + i11;
        this.f12838q = i12;
        int i13 = this.f12839r + i11;
        this.f12839r = i13;
        int i14 = this.f12830i;
        if (i13 >= i14) {
            this.f12839r = i13 - i14;
        }
        int i15 = this.f12840s - i11;
        this.f12840s = i15;
        if (i15 < 0) {
            this.f12840s = 0;
        }
        this.f12824c.e(i12);
        if (this.f12837p != 0) {
            return this.f12832k[this.f12839r];
        }
        int i16 = this.f12839r;
        if (i16 == 0) {
            i16 = this.f12830i;
        }
        return this.f12832k[i16 - 1] + this.f12833l[r6];
    }

    private long v(int i11) {
        int J = J() - i11;
        boolean z10 = false;
        androidx.media3.common.util.a.a(J >= 0 && J <= this.f12837p - this.f12840s);
        int i12 = this.f12837p - J;
        this.f12837p = i12;
        this.f12843v = Math.max(this.f12842u, E(i12));
        if (J == 0 && this.f12844w) {
            z10 = true;
        }
        this.f12844w = z10;
        this.f12824c.d(i11);
        int i13 = this.f12837p;
        if (i13 == 0) {
            return 0L;
        }
        return this.f12832k[G(i13 - 1)] + this.f12833l[r9];
    }

    private int x(int i11, int i12, long j11, boolean z10) {
        for (int i13 = 0; i13 < i12; i13++) {
            if (this.f12835n[i11] >= j11) {
                return i13;
            }
            i11++;
            if (i11 == this.f12830i) {
                i11 = 0;
            }
        }
        if (z10) {
            return i12;
        }
        return -1;
    }

    private int y(int i11, int i12, long j11, boolean z10) {
        int i13 = -1;
        for (int i14 = 0; i14 < i12; i14++) {
            long j12 = this.f12835n[i11];
            if (j12 > j11) {
                return i13;
            }
            if (!z10 || (this.f12834m[i11] & 1) != 0) {
                if (j12 == j11) {
                    return i14;
                }
                i13 = i14;
            }
            i11++;
            if (i11 == this.f12830i) {
                i11 = 0;
            }
        }
        return i13;
    }

    public final int A() {
        return this.f12838q;
    }

    public final synchronized long B() {
        return this.f12837p == 0 ? Long.MIN_VALUE : this.f12835n[this.f12839r];
    }

    public final synchronized long C() {
        return this.f12843v;
    }

    public final synchronized long D() {
        return Math.max(this.f12842u, E(this.f12840s));
    }

    public final int F() {
        return this.f12838q + this.f12840s;
    }

    public final synchronized int H(long j11, boolean z10) {
        int G = G(this.f12840s);
        if (K() && j11 >= this.f12835n[G]) {
            if (j11 > this.f12843v && z10) {
                return this.f12837p - this.f12840s;
            }
            int y10 = y(G, this.f12837p - this.f12840s, j11, true);
            if (y10 == -1) {
                return 0;
            }
            return y10;
        }
        return 0;
    }

    public final synchronized androidx.media3.common.r I() {
        return this.f12846y ? null : this.B;
    }

    public final int J() {
        return this.f12838q + this.f12837p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void L() {
        this.f12847z = true;
    }

    public final synchronized boolean M() {
        return this.f12844w;
    }

    public synchronized boolean N(boolean z10) {
        androidx.media3.common.r rVar;
        boolean z11 = true;
        if (K()) {
            if (((c) this.f12824c.f(F())).f12851a != this.f12828g) {
                return true;
            }
            return P(G(this.f12840s));
        }
        if (!z10 && !this.f12844w && ((rVar = this.B) == null || rVar == this.f12828g)) {
            z11 = false;
        }
        return z11;
    }

    public void Q() {
        DrmSession drmSession = this.f12829h;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) androidx.media3.common.util.a.e(this.f12829h.getError()));
        }
    }

    public final synchronized long T() {
        try {
        } catch (Throwable th2) {
            throw th2;
        }
        return K() ? this.f12831j[G(this.f12840s)] : this.C;
    }

    public void U() {
        s();
        X();
    }

    public int V(s2 s2Var, DecoderInputBuffer decoderInputBuffer, int i11, boolean z10) {
        int S = S(s2Var, decoderInputBuffer, (i11 & 2) != 0, z10, this.f12823b);
        if (S == -4 && !decoderInputBuffer.isEndOfStream()) {
            boolean z11 = (i11 & 1) != 0;
            if ((i11 & 4) == 0) {
                if (z11) {
                    this.f12822a.f(decoderInputBuffer, this.f12823b);
                } else {
                    this.f12822a.m(decoderInputBuffer, this.f12823b);
                }
            }
            if (!z11) {
                this.f12840s++;
            }
        }
        return S;
    }

    public void W() {
        Z(true);
        X();
    }

    public final void Y() {
        Z(false);
    }

    public void Z(boolean z10) {
        this.f12822a.n();
        this.f12837p = 0;
        this.f12838q = 0;
        this.f12839r = 0;
        this.f12840s = 0;
        this.f12845x = true;
        this.f12841t = Long.MIN_VALUE;
        this.f12842u = Long.MIN_VALUE;
        this.f12843v = Long.MIN_VALUE;
        this.f12844w = false;
        this.f12824c.c();
        if (z10) {
            this.A = null;
            this.B = null;
            this.f12846y = true;
            this.D = true;
        }
    }

    @Override // l2.s0
    public final void a(androidx.media3.common.util.j0 j0Var, int i11, int i12) {
        this.f12822a.q(j0Var, i11);
    }

    @Override // l2.s0
    public /* synthetic */ void b(androidx.media3.common.util.j0 j0Var, int i11) {
        r0.c(this, j0Var, i11);
    }

    public final synchronized boolean b0(int i11) {
        a0();
        int i12 = this.f12838q;
        if (i11 >= i12 && i11 <= this.f12837p + i12) {
            this.f12841t = Long.MIN_VALUE;
            this.f12840s = i11 - i12;
            return true;
        }
        return false;
    }

    @Override // l2.s0
    public final void c(androidx.media3.common.r rVar) {
        androidx.media3.common.r z10 = z(rVar);
        this.f12847z = false;
        this.A = rVar;
        boolean f02 = f0(z10);
        d dVar = this.f12827f;
        if (dVar == null || !f02) {
            return;
        }
        dVar.c(z10);
    }

    public final synchronized boolean c0(long j11, boolean z10) {
        try {
            a0();
            int G = G(this.f12840s);
            if (K() && j11 >= this.f12835n[G] && (j11 <= this.f12843v || z10)) {
                int x10 = this.D ? x(G, this.f12837p - this.f12840s, j11, z10) : y(G, this.f12837p - this.f12840s, j11, true);
                if (x10 == -1) {
                    return false;
                }
                this.f12841t = j11;
                this.f12840s += x10;
                return true;
            }
            return false;
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    @Override // l2.s0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(long r12, int r14, int r15, int r16, l2.s0.a r17) {
        /*
            r11 = this;
            r8 = r11
            boolean r0 = r8.f12847z
            if (r0 == 0) goto L10
            androidx.media3.common.r r0 = r8.A
            java.lang.Object r0 = androidx.media3.common.util.a.i(r0)
            androidx.media3.common.r r0 = (androidx.media3.common.r) r0
            r11.c(r0)
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
            boolean r4 = r8.f12845x
            if (r4 == 0) goto L22
            if (r3 != 0) goto L20
            return
        L20:
            r8.f12845x = r1
        L22:
            long r4 = r8.F
            long r4 = r4 + r12
            boolean r6 = r8.D
            if (r6 == 0) goto L54
            long r6 = r8.f12841t
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
            androidx.media3.common.r r6 = r8.B
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = "SampleQueue"
            androidx.media3.common.util.u.h(r6, r0)
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
            boolean r0 = r11.i(r4)
            if (r0 != 0) goto L62
            goto L65
        L62:
            r8.G = r1
            goto L66
        L65:
            return
        L66:
            androidx.media3.exoplayer.source.c0 r0 = r8.f12822a
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
            r0.j(r1, r3, r4, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.e0.d(long, int, int, int, l2.s0$a):void");
    }

    public final void d0(long j11) {
        if (this.F != j11) {
            this.F = j11;
            L();
        }
    }

    @Override // l2.s0
    public /* synthetic */ int e(androidx.media3.common.j jVar, int i11, boolean z10) {
        return r0.b(this, jVar, i11, z10);
    }

    public final void e0(long j11) {
        this.f12841t = j11;
    }

    @Override // l2.s0
    public /* synthetic */ void f(long j11) {
        r0.a(this, j11);
    }

    @Override // l2.s0
    public final int g(androidx.media3.common.j jVar, int i11, boolean z10, int i12) {
        return this.f12822a.p(jVar, i11, z10);
    }

    public final void g0(d dVar) {
        this.f12827f = dVar;
    }

    public final synchronized void h0(int i11) {
        boolean z10;
        if (i11 >= 0) {
            try {
                if (this.f12840s + i11 <= this.f12837p) {
                    z10 = true;
                    androidx.media3.common.util.a.a(z10);
                    this.f12840s += i11;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        z10 = false;
        androidx.media3.common.util.a.a(z10);
        this.f12840s += i11;
    }

    public final void i0(long j11) {
        this.C = j11;
    }

    public final void j0() {
        this.G = true;
    }

    public synchronized long p() {
        int i11 = this.f12840s;
        if (i11 == 0) {
            return -1L;
        }
        return q(i11);
    }

    public final void r(long j11, boolean z10, boolean z11) {
        this.f12822a.b(n(j11, z10, z11));
    }

    public final void s() {
        this.f12822a.b(o());
    }

    public final void t() {
        this.f12822a.b(p());
    }

    public final void u(long j11) {
        if (this.f12837p == 0) {
            return;
        }
        androidx.media3.common.util.a.a(j11 > D());
        w(this.f12838q + k(j11));
    }

    public final void w(int i11) {
        this.f12822a.c(v(i11));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public androidx.media3.common.r z(androidx.media3.common.r rVar) {
        return (this.F == 0 || rVar.f10248t == Long.MAX_VALUE) ? rVar : rVar.b().y0(rVar.f10248t + this.F).N();
    }
}
