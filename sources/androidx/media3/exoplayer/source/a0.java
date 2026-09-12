package androidx.media3.exoplayer.source;

import android.net.Uri;
import android.os.Handler;
import androidx.media3.common.ParserException;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.c4;
import androidx.media3.exoplayer.drm.r;
import androidx.media3.exoplayer.s2;
import androidx.media3.exoplayer.source.e0;
import androidx.media3.exoplayer.source.n;
import androidx.media3.exoplayer.source.q;
import androidx.media3.exoplayer.source.s;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.upstream.m;
import androidx.media3.exoplayer.v2;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import l2.m0;
import l2.s0;
import w1.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a0 implements q, l2.t, Loader.b, Loader.e, e0.d {
    private static final Map R = B();
    private static final androidx.media3.common.r S = new r.b().f0("icy").u0("application/x-icy").N();
    private boolean A;
    private f B;
    private m0 C;
    private long D;
    private boolean E;
    private int F;
    private boolean G;
    private boolean H;
    private boolean I;
    private int J;
    private boolean K;
    private long L;
    private long M;
    private boolean N;
    private int O;
    private boolean P;
    private boolean Q;

    /* renamed from: a, reason: collision with root package name */
    private final Uri f12715a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.datasource.a f12716b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.media3.exoplayer.drm.t f12717c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.m f12718d;

    /* renamed from: e, reason: collision with root package name */
    private final s.a f12719e;

    /* renamed from: f, reason: collision with root package name */
    private final r.a f12720f;

    /* renamed from: g, reason: collision with root package name */
    private final c f12721g;

    /* renamed from: h, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.b f12722h;

    /* renamed from: i, reason: collision with root package name */
    private final String f12723i;

    /* renamed from: j, reason: collision with root package name */
    private final long f12724j;

    /* renamed from: k, reason: collision with root package name */
    private final int f12725k;

    /* renamed from: l, reason: collision with root package name */
    private final androidx.media3.common.r f12726l;

    /* renamed from: m, reason: collision with root package name */
    private final long f12727m;

    /* renamed from: n, reason: collision with root package name */
    private final Loader f12728n;

    /* renamed from: o, reason: collision with root package name */
    private final v f12729o;

    /* renamed from: p, reason: collision with root package name */
    private final androidx.media3.common.util.l f12730p;

    /* renamed from: q, reason: collision with root package name */
    private final Runnable f12731q;

    /* renamed from: r, reason: collision with root package name */
    private final Runnable f12732r;

    /* renamed from: s, reason: collision with root package name */
    private final Handler f12733s;

    /* renamed from: t, reason: collision with root package name */
    private q.a f12734t;

    /* renamed from: u, reason: collision with root package name */
    private y2.b f12735u;

    /* renamed from: v, reason: collision with root package name */
    private e0[] f12736v;

    /* renamed from: w, reason: collision with root package name */
    private e[] f12737w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f12738x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f12739y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f12740z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends l2.d0 {
        a(m0 m0Var) {
            super(m0Var);
        }

        @Override // l2.d0, l2.m0
        public long getDurationUs() {
            return a0.this.D;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b implements Loader.d, n.a {

        /* renamed from: b, reason: collision with root package name */
        private final Uri f12743b;

        /* renamed from: c, reason: collision with root package name */
        private final w1.l f12744c;

        /* renamed from: d, reason: collision with root package name */
        private final v f12745d;

        /* renamed from: e, reason: collision with root package name */
        private final l2.t f12746e;

        /* renamed from: f, reason: collision with root package name */
        private final androidx.media3.common.util.l f12747f;

        /* renamed from: h, reason: collision with root package name */
        private volatile boolean f12749h;

        /* renamed from: j, reason: collision with root package name */
        private long f12751j;

        /* renamed from: l, reason: collision with root package name */
        private s0 f12753l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f12754m;

        /* renamed from: g, reason: collision with root package name */
        private final l2.l0 f12748g = new l2.l0();

        /* renamed from: i, reason: collision with root package name */
        private boolean f12750i = true;

        /* renamed from: a, reason: collision with root package name */
        private final long f12742a = g2.i.a();

        /* renamed from: k, reason: collision with root package name */
        private w1.h f12752k = g(0);

        public b(Uri uri, androidx.media3.datasource.a aVar, v vVar, l2.t tVar, androidx.media3.common.util.l lVar) {
            this.f12743b = uri;
            this.f12744c = new w1.l(aVar);
            this.f12745d = vVar;
            this.f12746e = tVar;
            this.f12747f = lVar;
        }

        private w1.h g(long j11) {
            return new h.b().i(this.f12743b).h(j11).f(a0.this.f12723i).b(6).e(a0.R).a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(long j11, long j12) {
            this.f12748g.f68743a = j11;
            this.f12751j = j12;
            this.f12750i = true;
            this.f12754m = false;
        }

        @Override // androidx.media3.exoplayer.source.n.a
        public void a(androidx.media3.common.util.j0 j0Var) {
            long max = !this.f12754m ? this.f12751j : Math.max(a0.this.D(true), this.f12751j);
            int a11 = j0Var.a();
            s0 s0Var = (s0) androidx.media3.common.util.a.e(this.f12753l);
            s0Var.b(j0Var, a11);
            s0Var.d(max, 1, a11, 0, null);
            this.f12754m = true;
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.d
        public void cancelLoad() {
            this.f12749h = true;
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.d
        public void load() {
            int i11 = 0;
            while (i11 == 0 && !this.f12749h) {
                try {
                    long j11 = this.f12748g.f68743a;
                    w1.h g11 = g(j11);
                    this.f12752k = g11;
                    long a11 = this.f12744c.a(g11);
                    if (this.f12749h) {
                        if (i11 != 1 && this.f12745d.b() != -1) {
                            this.f12748g.f68743a = this.f12745d.b();
                        }
                        w1.g.a(this.f12744c);
                        return;
                    }
                    if (a11 != -1) {
                        a11 += j11;
                        a0.this.P();
                    }
                    long j12 = a11;
                    a0.this.f12735u = y2.b.b(this.f12744c.getResponseHeaders());
                    androidx.media3.common.j jVar = this.f12744c;
                    if (a0.this.f12735u != null && a0.this.f12735u.f78942f != -1) {
                        jVar = new n(this.f12744c, a0.this.f12735u.f78942f, this);
                        s0 E = a0.this.E();
                        this.f12753l = E;
                        E.c(a0.S);
                    }
                    long j13 = j11;
                    this.f12745d.c(jVar, this.f12743b, this.f12744c.getResponseHeaders(), j11, j12, this.f12746e);
                    if (a0.this.f12735u != null) {
                        this.f12745d.a();
                    }
                    if (this.f12750i) {
                        this.f12745d.seek(j13, this.f12751j);
                        this.f12750i = false;
                    }
                    while (true) {
                        long j14 = j13;
                        while (i11 == 0 && !this.f12749h) {
                            try {
                                this.f12747f.a();
                                i11 = this.f12745d.d(this.f12748g);
                                j13 = this.f12745d.b();
                                if (j13 > a0.this.f12724j + j14) {
                                    break;
                                }
                            } catch (InterruptedException unused) {
                                throw new InterruptedIOException();
                            }
                        }
                        this.f12747f.d();
                        a0.this.f12733s.post(a0.this.f12732r);
                    }
                    if (i11 == 1) {
                        i11 = 0;
                    } else if (this.f12745d.b() != -1) {
                        this.f12748g.f68743a = this.f12745d.b();
                    }
                    w1.g.a(this.f12744c);
                } catch (Throwable th2) {
                    if (i11 != 1 && this.f12745d.b() != -1) {
                        this.f12748g.f68743a = this.f12745d.b();
                    }
                    w1.g.a(this.f12744c);
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface c {
        void p(long j11, m0 m0Var, boolean z10);
    }

    /* loaded from: classes2.dex */
    private final class d implements g2.u {

        /* renamed from: a, reason: collision with root package name */
        private final int f12756a;

        public d(int i11) {
            this.f12756a = i11;
        }

        @Override // g2.u
        public int c(s2 s2Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            return a0.this.V(this.f12756a, s2Var, decoderInputBuffer, i11);
        }

        @Override // g2.u
        public boolean isReady() {
            return a0.this.G(this.f12756a);
        }

        @Override // g2.u
        public void maybeThrowError() {
            a0.this.O(this.f12756a);
        }

        @Override // g2.u
        public int skipData(long j11) {
            return a0.this.Z(this.f12756a, j11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final int f12758a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f12759b;

        public e(int i11, boolean z10) {
            this.f12758a = i11;
            this.f12759b = z10;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.f12758a == eVar.f12758a && this.f12759b == eVar.f12759b;
        }

        public int hashCode() {
            return (this.f12758a * 31) + (this.f12759b ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public final g2.z f12760a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean[] f12761b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean[] f12762c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean[] f12763d;

        public f(g2.z zVar, boolean[] zArr) {
            this.f12760a = zVar;
            this.f12761b = zArr;
            int i11 = zVar.f63389a;
            this.f12762c = new boolean[i11];
            this.f12763d = new boolean[i11];
        }
    }

    public a0(Uri uri, androidx.media3.datasource.a aVar, v vVar, androidx.media3.exoplayer.drm.t tVar, r.a aVar2, androidx.media3.exoplayer.upstream.m mVar, s.a aVar3, c cVar, androidx.media3.exoplayer.upstream.b bVar, String str, int i11, int i12, androidx.media3.common.r rVar, long j11, androidx.media3.exoplayer.util.c cVar2) {
        this.f12715a = uri;
        this.f12716b = aVar;
        this.f12717c = tVar;
        this.f12720f = aVar2;
        this.f12718d = mVar;
        this.f12719e = aVar3;
        this.f12721g = cVar;
        this.f12722h = bVar;
        this.f12723i = str;
        this.f12724j = i11;
        this.f12725k = i12;
        this.f12726l = rVar;
        this.f12728n = cVar2 != null ? new Loader(cVar2) : new Loader("ProgressiveMediaPeriod");
        this.f12729o = vVar;
        this.f12727m = j11;
        this.f12730p = new androidx.media3.common.util.l();
        this.f12731q = new Runnable() { // from class: androidx.media3.exoplayer.source.x
            @Override // java.lang.Runnable
            public final void run() {
                a0.this.K();
            }
        };
        this.f12732r = new Runnable() { // from class: androidx.media3.exoplayer.source.y
            @Override // java.lang.Runnable
            public final void run() {
                a0.this.H();
            }
        };
        this.f12733s = a1.A();
        this.f12737w = new e[0];
        this.f12736v = new e0[0];
        this.M = C.TIME_UNSET;
        this.F = 1;
    }

    private boolean A(b bVar, int i11) {
        m0 m0Var;
        if (this.K || !((m0Var = this.C) == null || m0Var.getDurationUs() == C.TIME_UNSET)) {
            this.O = i11;
            return true;
        }
        if (this.f12739y && !b0()) {
            this.N = true;
            return false;
        }
        this.H = this.f12739y;
        this.L = 0L;
        this.O = 0;
        for (e0 e0Var : this.f12736v) {
            e0Var.Y();
        }
        bVar.h(0L, 0L);
        return true;
    }

    private static Map B() {
        HashMap hashMap = new HashMap();
        hashMap.put(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_NAME, "1");
        return Collections.unmodifiableMap(hashMap);
    }

    private int C() {
        int i11 = 0;
        for (e0 e0Var : this.f12736v) {
            i11 += e0Var.J();
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long D(boolean z10) {
        long j11 = Long.MIN_VALUE;
        for (int i11 = 0; i11 < this.f12736v.length; i11++) {
            if (z10 || ((f) androidx.media3.common.util.a.e(this.B)).f12762c[i11]) {
                j11 = Math.max(j11, this.f12736v[i11].C());
            }
        }
        return j11;
    }

    private boolean F() {
        return this.M != C.TIME_UNSET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        if (this.Q) {
            return;
        }
        ((q.a) androidx.media3.common.util.a.e(this.f12734t)).f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        this.K = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (this.Q || this.f12739y || !this.f12738x || this.C == null) {
            return;
        }
        for (e0 e0Var : this.f12736v) {
            if (e0Var.I() == null) {
                return;
            }
        }
        this.f12730p.d();
        int length = this.f12736v.length;
        androidx.media3.common.f0[] f0VarArr = new androidx.media3.common.f0[length];
        boolean[] zArr = new boolean[length];
        for (int i11 = 0; i11 < length; i11++) {
            androidx.media3.common.r rVar = (androidx.media3.common.r) androidx.media3.common.util.a.e(this.f12736v[i11].I());
            String str = rVar.f10243o;
            boolean o11 = androidx.media3.common.y.o(str);
            boolean z10 = o11 || androidx.media3.common.y.t(str);
            zArr[i11] = z10;
            this.f12740z = z10 | this.f12740z;
            this.A = this.f12727m != C.TIME_UNSET && length == 1 && androidx.media3.common.y.q(str);
            y2.b bVar = this.f12735u;
            if (bVar != null) {
                if (o11 || this.f12737w[i11].f12759b) {
                    androidx.media3.common.x xVar = rVar.f10240l;
                    rVar = rVar.b().n0(xVar == null ? new androidx.media3.common.x(bVar) : xVar.a(bVar)).N();
                }
                if (o11 && rVar.f10236h == -1 && rVar.f10237i == -1 && bVar.f78937a != -1) {
                    rVar = rVar.b().Q(bVar.f78937a).N();
                }
            }
            androidx.media3.common.r c11 = rVar.c(this.f12717c.b(rVar));
            f0VarArr[i11] = new androidx.media3.common.f0(Integer.toString(i11), c11);
            this.I = c11.f10249u | this.I;
        }
        this.B = new f(new g2.z(f0VarArr), zArr);
        if (this.A && this.D == C.TIME_UNSET) {
            this.D = this.f12727m;
            this.C = new a(this.C);
        }
        this.f12721g.p(this.D, this.C, this.E);
        this.f12739y = true;
        ((q.a) androidx.media3.common.util.a.e(this.f12734t)).c(this);
    }

    private void L(int i11) {
        z();
        f fVar = this.B;
        boolean[] zArr = fVar.f12763d;
        if (zArr[i11]) {
            return;
        }
        androidx.media3.common.r a11 = fVar.f12760a.b(i11).a(0);
        this.f12719e.j(androidx.media3.common.y.k(a11.f10243o), a11, 0, null, this.L);
        zArr[i11] = true;
    }

    private void M(int i11) {
        z();
        if (this.N) {
            if (!this.f12740z || this.B.f12761b[i11]) {
                if (this.f12736v[i11].N(false)) {
                    return;
                }
                this.M = 0L;
                this.N = false;
                this.H = true;
                this.L = 0L;
                this.O = 0;
                for (e0 e0Var : this.f12736v) {
                    e0Var.Y();
                }
                ((q.a) androidx.media3.common.util.a.e(this.f12734t)).f(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.f12733s.post(new Runnable() { // from class: androidx.media3.exoplayer.source.w
            @Override // java.lang.Runnable
            public final void run() {
                a0.this.I();
            }
        });
    }

    private s0 U(e eVar) {
        int length = this.f12736v.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (eVar.equals(this.f12737w[i11])) {
                return this.f12736v[i11];
            }
        }
        if (this.f12738x) {
            androidx.media3.common.util.u.h("ProgressiveMediaPeriod", "Extractor added new track (id=" + eVar.f12758a + ") after finishing tracks.");
            return new l2.n();
        }
        e0 l11 = e0.l(this.f12722h, this.f12717c, this.f12720f);
        l11.g0(this);
        int i12 = length + 1;
        e[] eVarArr = (e[]) Arrays.copyOf(this.f12737w, i12);
        eVarArr[length] = eVar;
        this.f12737w = (e[]) a1.j(eVarArr);
        e0[] e0VarArr = (e0[]) Arrays.copyOf(this.f12736v, i12);
        e0VarArr[length] = l11;
        this.f12736v = (e0[]) a1.j(e0VarArr);
        return l11;
    }

    private boolean X(boolean[] zArr, long j11, boolean z10) {
        int length = this.f12736v.length;
        for (int i11 = 0; i11 < length; i11++) {
            e0 e0Var = this.f12736v[i11];
            if (e0Var.F() != 0 || !z10) {
                if (!(this.A ? e0Var.b0(e0Var.A()) : e0Var.c0(j11, false)) && (zArr[i11] || !this.f12740z)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public void J(m0 m0Var) {
        this.C = this.f12735u == null ? m0Var : new m0.b(C.TIME_UNSET);
        this.D = m0Var.getDurationUs();
        boolean z10 = !this.K && m0Var.getDurationUs() == C.TIME_UNSET;
        this.E = z10;
        this.F = z10 ? 7 : 1;
        if (this.f12739y) {
            this.f12721g.p(this.D, m0Var, z10);
        } else {
            K();
        }
    }

    private void a0() {
        b bVar = new b(this.f12715a, this.f12716b, this.f12729o, this, this.f12730p);
        if (this.f12739y) {
            androidx.media3.common.util.a.g(F());
            long j11 = this.D;
            if (j11 != C.TIME_UNSET && this.M > j11) {
                this.P = true;
                this.M = C.TIME_UNSET;
                return;
            }
            bVar.h(((m0) androidx.media3.common.util.a.e(this.C)).getSeekPoints(this.M).f68767a.f68774b, this.M);
            for (e0 e0Var : this.f12736v) {
                e0Var.e0(this.M);
            }
            this.M = C.TIME_UNSET;
        }
        this.O = C();
        this.f12728n.m(bVar, this, this.f12718d.a(this.F));
    }

    private boolean b0() {
        return this.H || F();
    }

    private void z() {
        androidx.media3.common.util.a.g(this.f12739y);
        androidx.media3.common.util.a.e(this.B);
        androidx.media3.common.util.a.e(this.C);
    }

    s0 E() {
        return U(new e(0, true));
    }

    boolean G(int i11) {
        return !b0() && this.f12736v[i11].N(this.P);
    }

    void N() {
        this.f12728n.j(this.f12718d.a(this.F));
    }

    void O(int i11) {
        this.f12736v[i11].Q();
        N();
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void q(b bVar, long j11, long j12, boolean z10) {
        w1.l lVar = bVar.f12744c;
        g2.i iVar = new g2.i(bVar.f12742a, bVar.f12752k, lVar.e(), lVar.f(), j11, j12, lVar.d());
        this.f12718d.b(bVar.f12742a);
        this.f12719e.t(iVar, 1, -1, null, 0, null, bVar.f12751j, this.D);
        if (z10) {
            return;
        }
        for (e0 e0Var : this.f12736v) {
            e0Var.Y();
        }
        if (this.J > 0) {
            ((q.a) androidx.media3.common.util.a.e(this.f12734t)).f(this);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void p(b bVar, long j11, long j12) {
        if (this.D == C.TIME_UNSET && this.C != null) {
            long D = D(true);
            long j13 = D == Long.MIN_VALUE ? 0L : D + 10000;
            this.D = j13;
            this.f12721g.p(j13, this.C, this.E);
        }
        w1.l lVar = bVar.f12744c;
        g2.i iVar = new g2.i(bVar.f12742a, bVar.f12752k, lVar.e(), lVar.f(), j11, j12, lVar.d());
        this.f12718d.b(bVar.f12742a);
        this.f12719e.w(iVar, 1, -1, null, 0, null, bVar.f12751j, this.D);
        this.P = true;
        ((q.a) androidx.media3.common.util.a.e(this.f12734t)).f(this);
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public Loader.c k(b bVar, long j11, long j12, IOException iOException, int i11) {
        Loader.c g11;
        w1.l lVar = bVar.f12744c;
        g2.i iVar = new g2.i(bVar.f12742a, bVar.f12752k, lVar.e(), lVar.f(), j11, j12, lVar.d());
        long c11 = this.f12718d.c(new m.c(iVar, new g2.j(1, -1, null, 0, null, a1.y1(bVar.f12751j), a1.y1(this.D)), iOException, i11));
        if (c11 == C.TIME_UNSET) {
            g11 = Loader.f13032g;
        } else {
            int C = C();
            g11 = A(bVar, C) ? Loader.g(C > this.O, c11) : Loader.f13031f;
        }
        boolean c12 = g11.c();
        this.f12719e.y(iVar, 1, -1, null, 0, null, bVar.f12751j, this.D, iOException, !c12);
        if (!c12) {
            this.f12718d.b(bVar.f12742a);
        }
        return g11;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public void o(b bVar, long j11, long j12, int i11) {
        w1.l lVar = bVar.f12744c;
        this.f12719e.C(i11 == 0 ? new g2.i(bVar.f12742a, bVar.f12752k, j11) : new g2.i(bVar.f12742a, bVar.f12752k, lVar.e(), lVar.f(), j11, j12, lVar.d()), 1, -1, null, 0, null, bVar.f12751j, this.D, i11);
    }

    int V(int i11, s2 s2Var, DecoderInputBuffer decoderInputBuffer, int i12) {
        if (b0()) {
            return -3;
        }
        L(i11);
        int V = this.f12736v[i11].V(s2Var, decoderInputBuffer, i12, this.P);
        if (V == -3) {
            M(i11);
        }
        return V;
    }

    public void W() {
        if (this.f12739y) {
            for (e0 e0Var : this.f12736v) {
                e0Var.U();
            }
        }
        this.f12728n.l(this);
        this.f12733s.removeCallbacksAndMessages(null);
        this.f12734t = null;
        this.Q = true;
    }

    int Z(int i11, long j11) {
        if (b0()) {
            return 0;
        }
        L(i11);
        e0 e0Var = this.f12736v[i11];
        int H = e0Var.H(j11, this.P);
        e0Var.h0(H);
        if (H == 0) {
            M(i11);
        }
        return H;
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public boolean a(v2 v2Var) {
        if (this.P || this.f12728n.h() || this.N) {
            return false;
        }
        if ((this.f12739y || this.f12726l != null) && this.J == 0) {
            return false;
        }
        boolean f11 = this.f12730p.f();
        if (this.f12728n.i()) {
            return f11;
        }
        a0();
        return true;
    }

    @Override // androidx.media3.exoplayer.source.q
    public long b(long j11, c4 c4Var) {
        z();
        if (!this.C.isSeekable()) {
            return 0L;
        }
        m0.a seekPoints = this.C.getSeekPoints(j11);
        return c4Var.a(j11, seekPoints.f68767a.f68773a, seekPoints.f68768b.f68773a);
    }

    @Override // androidx.media3.exoplayer.source.e0.d
    public void c(androidx.media3.common.r rVar) {
        this.f12733s.post(this.f12731q);
    }

    @Override // androidx.media3.exoplayer.source.q
    public void discardBuffer(long j11, boolean z10) {
        if (this.A) {
            return;
        }
        z();
        if (F()) {
            return;
        }
        boolean[] zArr = this.B.f12762c;
        int length = this.f12736v.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.f12736v[i11].r(j11, z10, zArr[i11]);
        }
    }

    @Override // androidx.media3.exoplayer.source.q
    public long e(j2.z[] zVarArr, boolean[] zArr, g2.u[] uVarArr, boolean[] zArr2, long j11) {
        j2.z zVar;
        z();
        f fVar = this.B;
        g2.z zVar2 = fVar.f12760a;
        boolean[] zArr3 = fVar.f12762c;
        int i11 = this.J;
        int i12 = 0;
        for (int i13 = 0; i13 < zVarArr.length; i13++) {
            g2.u uVar = uVarArr[i13];
            if (uVar != null && (zVarArr[i13] == null || !zArr[i13])) {
                int i14 = ((d) uVar).f12756a;
                androidx.media3.common.util.a.g(zArr3[i14]);
                this.J--;
                zArr3[i14] = false;
                uVarArr[i13] = null;
            }
        }
        boolean z10 = !this.G ? j11 == 0 || this.A : i11 != 0;
        for (int i15 = 0; i15 < zVarArr.length; i15++) {
            if (uVarArr[i15] == null && (zVar = zVarArr[i15]) != null) {
                androidx.media3.common.util.a.g(zVar.length() == 1);
                androidx.media3.common.util.a.g(zVar.getIndexInTrackGroup(0) == 0);
                int d11 = zVar2.d(zVar.getTrackGroup());
                androidx.media3.common.util.a.g(!zArr3[d11]);
                this.J++;
                zArr3[d11] = true;
                this.I = zVar.getSelectedFormat().f10249u | this.I;
                uVarArr[i15] = new d(d11);
                zArr2[i15] = true;
                if (!z10) {
                    e0 e0Var = this.f12736v[d11];
                    z10 = (e0Var.F() == 0 || e0Var.c0(j11, true)) ? false : true;
                }
            }
        }
        if (this.J == 0) {
            this.N = false;
            this.H = false;
            this.I = false;
            if (this.f12728n.i()) {
                e0[] e0VarArr = this.f12736v;
                int length = e0VarArr.length;
                while (i12 < length) {
                    e0VarArr[i12].s();
                    i12++;
                }
                this.f12728n.e();
            } else {
                this.P = false;
                e0[] e0VarArr2 = this.f12736v;
                int length2 = e0VarArr2.length;
                while (i12 < length2) {
                    e0VarArr2[i12].Y();
                    i12++;
                }
            }
        } else if (z10) {
            j11 = seekToUs(j11);
            while (i12 < uVarArr.length) {
                if (uVarArr[i12] != null) {
                    zArr2[i12] = true;
                }
                i12++;
            }
        }
        this.G = true;
        return j11;
    }

    @Override // l2.t
    public void endTracks() {
        this.f12738x = true;
        this.f12733s.post(this.f12731q);
    }

    @Override // l2.t
    public void f(final m0 m0Var) {
        this.f12733s.post(new Runnable() { // from class: androidx.media3.exoplayer.source.z
            @Override // java.lang.Runnable
            public final void run() {
                a0.this.J(m0Var);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.q
    public void g(q.a aVar, long j11) {
        this.f12734t = aVar;
        if (this.f12726l == null) {
            this.f12730p.f();
            a0();
        } else {
            track(this.f12725k, 3).c(this.f12726l);
            J(new l2.h0(new long[]{0}, new long[]{0}, C.TIME_UNSET));
            endTracks();
            this.M = j11;
        }
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public long getBufferedPositionUs() {
        long j11;
        z();
        if (this.P || this.J == 0) {
            return Long.MIN_VALUE;
        }
        if (F()) {
            return this.M;
        }
        if (this.f12740z) {
            int length = this.f12736v.length;
            j11 = Long.MAX_VALUE;
            for (int i11 = 0; i11 < length; i11++) {
                f fVar = this.B;
                if (fVar.f12761b[i11] && fVar.f12762c[i11] && !this.f12736v[i11].M()) {
                    j11 = Math.min(j11, this.f12736v[i11].C());
                }
            }
        } else {
            j11 = Long.MAX_VALUE;
        }
        if (j11 == Long.MAX_VALUE) {
            j11 = D(false);
        }
        return j11 == Long.MIN_VALUE ? this.L : j11;
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public long getNextLoadPositionUs() {
        return getBufferedPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.q
    public g2.z getTrackGroups() {
        z();
        return this.B.f12760a;
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public boolean isLoading() {
        return this.f12728n.i() && this.f12730p.e();
    }

    @Override // androidx.media3.exoplayer.source.q
    public void maybeThrowPrepareError() {
        N();
        if (this.P && !this.f12739y) {
            throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.e
    public void onLoaderReleased() {
        for (e0 e0Var : this.f12736v) {
            e0Var.W();
        }
        this.f12729o.release();
    }

    @Override // androidx.media3.exoplayer.source.q
    public long readDiscontinuity() {
        if (this.I) {
            this.I = false;
            return this.L;
        }
        if (!this.H) {
            return C.TIME_UNSET;
        }
        if (!this.P && C() <= this.O) {
            return C.TIME_UNSET;
        }
        this.H = false;
        return this.L;
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public void reevaluateBuffer(long j11) {
    }

    @Override // androidx.media3.exoplayer.source.q
    public long seekToUs(long j11) {
        z();
        boolean[] zArr = this.B.f12761b;
        if (!this.C.isSeekable()) {
            j11 = 0;
        }
        int i11 = 0;
        this.H = false;
        boolean z10 = this.L == j11;
        this.L = j11;
        if (F()) {
            this.M = j11;
            return j11;
        }
        if (this.F != 7 && ((this.P || this.f12728n.i()) && X(zArr, j11, z10))) {
            return j11;
        }
        this.N = false;
        this.M = j11;
        this.P = false;
        this.I = false;
        if (this.f12728n.i()) {
            e0[] e0VarArr = this.f12736v;
            int length = e0VarArr.length;
            while (i11 < length) {
                e0VarArr[i11].s();
                i11++;
            }
            this.f12728n.e();
        } else {
            this.f12728n.f();
            e0[] e0VarArr2 = this.f12736v;
            int length2 = e0VarArr2.length;
            while (i11 < length2) {
                e0VarArr2[i11].Y();
                i11++;
            }
        }
        return j11;
    }

    @Override // l2.t
    public s0 track(int i11, int i12) {
        return U(new e(i11, false));
    }
}
