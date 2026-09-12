package v9;

import com.google.android.exoplayer2.c3;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import t9.s;

/* loaded from: classes4.dex */
public class i implements s, b0, Loader.b, Loader.e {

    /* renamed from: a, reason: collision with root package name */
    public final int f77266a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f77267b;

    /* renamed from: c, reason: collision with root package name */
    private final o1[] f77268c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean[] f77269d;

    /* renamed from: e, reason: collision with root package name */
    private final j f77270e;

    /* renamed from: f, reason: collision with root package name */
    private final b0.a f77271f;

    /* renamed from: g, reason: collision with root package name */
    private final p.a f77272g;

    /* renamed from: h, reason: collision with root package name */
    private final z f77273h;

    /* renamed from: i, reason: collision with root package name */
    private final Loader f77274i;

    /* renamed from: j, reason: collision with root package name */
    private final h f77275j;

    /* renamed from: k, reason: collision with root package name */
    private final ArrayList f77276k;

    /* renamed from: l, reason: collision with root package name */
    private final List f77277l;

    /* renamed from: m, reason: collision with root package name */
    private final a0 f77278m;

    /* renamed from: n, reason: collision with root package name */
    private final a0[] f77279n;

    /* renamed from: o, reason: collision with root package name */
    private final c f77280o;

    /* renamed from: p, reason: collision with root package name */
    private f f77281p;

    /* renamed from: q, reason: collision with root package name */
    private o1 f77282q;

    /* renamed from: r, reason: collision with root package name */
    private b f77283r;

    /* renamed from: s, reason: collision with root package name */
    private long f77284s;

    /* renamed from: t, reason: collision with root package name */
    private long f77285t;

    /* renamed from: u, reason: collision with root package name */
    private int f77286u;

    /* renamed from: v, reason: collision with root package name */
    private v9.a f77287v;

    /* renamed from: w, reason: collision with root package name */
    boolean f77288w;

    /* loaded from: classes4.dex */
    public final class a implements s {

        /* renamed from: a, reason: collision with root package name */
        public final i f77289a;

        /* renamed from: b, reason: collision with root package name */
        private final a0 f77290b;

        /* renamed from: c, reason: collision with root package name */
        private final int f77291c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f77292d;

        public a(i iVar, a0 a0Var, int i11) {
            this.f77289a = iVar;
            this.f77290b = a0Var;
            this.f77291c = i11;
        }

        private void a() {
            if (this.f77292d) {
                return;
            }
            i.this.f77272g.i(i.this.f77267b[this.f77291c], i.this.f77268c[this.f77291c], 0, null, i.this.f77285t);
            this.f77292d = true;
        }

        public void b() {
            com.google.android.exoplayer2.util.a.g(i.this.f77269d[this.f77291c]);
            i.this.f77269d[this.f77291c] = false;
        }

        @Override // t9.s
        public int c(p1 p1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            if (i.this.u()) {
                return -3;
            }
            if (i.this.f77287v != null && i.this.f77287v.g(this.f77291c + 1) <= this.f77290b.C()) {
                return -3;
            }
            a();
            return this.f77290b.S(p1Var, decoderInputBuffer, i11, i.this.f77288w);
        }

        @Override // t9.s
        public boolean isReady() {
            return !i.this.u() && this.f77290b.K(i.this.f77288w);
        }

        @Override // t9.s
        public void maybeThrowError() {
        }

        @Override // t9.s
        public int skipData(long j11) {
            if (i.this.u()) {
                return 0;
            }
            int E = this.f77290b.E(j11, i.this.f77288w);
            if (i.this.f77287v != null) {
                E = Math.min(E, i.this.f77287v.g(this.f77291c + 1) - this.f77290b.C());
            }
            this.f77290b.e0(E);
            if (E > 0) {
                a();
            }
            return E;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void c(i iVar);
    }

    public i(int i11, int[] iArr, o1[] o1VarArr, j jVar, b0.a aVar, com.google.android.exoplayer2.upstream.b bVar, long j11, u uVar, s.a aVar2, z zVar, p.a aVar3) {
        this.f77266a = i11;
        int i12 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.f77267b = iArr;
        this.f77268c = o1VarArr == null ? new o1[0] : o1VarArr;
        this.f77270e = jVar;
        this.f77271f = aVar;
        this.f77272g = aVar3;
        this.f77273h = zVar;
        this.f77274i = new Loader("ChunkSampleStream");
        this.f77275j = new h();
        ArrayList arrayList = new ArrayList();
        this.f77276k = arrayList;
        this.f77277l = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.f77279n = new a0[length];
        this.f77269d = new boolean[length];
        int i13 = length + 1;
        int[] iArr2 = new int[i13];
        a0[] a0VarArr = new a0[i13];
        a0 k11 = a0.k(bVar, uVar, aVar2);
        this.f77278m = k11;
        iArr2[0] = i11;
        a0VarArr[0] = k11;
        while (i12 < length) {
            a0 l11 = a0.l(bVar);
            this.f77279n[i12] = l11;
            int i14 = i12 + 1;
            a0VarArr[i14] = l11;
            iArr2[i14] = this.f77267b[i12];
            i12 = i14;
        }
        this.f77280o = new c(iArr2, a0VarArr);
        this.f77284s = j11;
        this.f77285t = j11;
    }

    private int A(int i11, int i12) {
        do {
            i12++;
            if (i12 >= this.f77276k.size()) {
                return this.f77276k.size() - 1;
            }
        } while (((v9.a) this.f77276k.get(i12)).g(0) <= i11);
        return i12 - 1;
    }

    private void D() {
        this.f77278m.V();
        for (a0 a0Var : this.f77279n) {
            a0Var.V();
        }
    }

    private void m(int i11) {
        int min = Math.min(A(i11, 0), this.f77286u);
        if (min > 0) {
            p0.M0(this.f77276k, 0, min);
            this.f77286u -= min;
        }
    }

    private void o(int i11) {
        com.google.android.exoplayer2.util.a.g(!this.f77274i.i());
        int size = this.f77276k.size();
        while (true) {
            if (i11 >= size) {
                i11 = -1;
                break;
            } else if (!s(i11)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 == -1) {
            return;
        }
        long j11 = r().f77262h;
        v9.a p11 = p(i11);
        if (this.f77276k.isEmpty()) {
            this.f77284s = this.f77285t;
        }
        this.f77288w = false;
        this.f77272g.D(this.f77266a, p11.f77261g, j11);
    }

    private v9.a p(int i11) {
        v9.a aVar = (v9.a) this.f77276k.get(i11);
        ArrayList arrayList = this.f77276k;
        p0.M0(arrayList, i11, arrayList.size());
        this.f77286u = Math.max(this.f77286u, this.f77276k.size());
        int i12 = 0;
        this.f77278m.u(aVar.g(0));
        while (true) {
            a0[] a0VarArr = this.f77279n;
            if (i12 >= a0VarArr.length) {
                return aVar;
            }
            a0 a0Var = a0VarArr[i12];
            i12++;
            a0Var.u(aVar.g(i12));
        }
    }

    private v9.a r() {
        return (v9.a) this.f77276k.get(r0.size() - 1);
    }

    private boolean s(int i11) {
        int C;
        v9.a aVar = (v9.a) this.f77276k.get(i11);
        if (this.f77278m.C() > aVar.g(0)) {
            return true;
        }
        int i12 = 0;
        do {
            a0[] a0VarArr = this.f77279n;
            if (i12 >= a0VarArr.length) {
                return false;
            }
            C = a0VarArr[i12].C();
            i12++;
        } while (C <= aVar.g(i12));
        return true;
    }

    private boolean t(f fVar) {
        return fVar instanceof v9.a;
    }

    private void v() {
        int A = A(this.f77278m.C(), this.f77286u - 1);
        while (true) {
            int i11 = this.f77286u;
            if (i11 > A) {
                return;
            }
            this.f77286u = i11 + 1;
            w(i11);
        }
    }

    private void w(int i11) {
        v9.a aVar = (v9.a) this.f77276k.get(i11);
        o1 o1Var = aVar.f77258d;
        if (!o1Var.equals(this.f77282q)) {
            this.f77272g.i(this.f77266a, o1Var, aVar.f77259e, aVar.f77260f, aVar.f77261g);
        }
        this.f77282q = o1Var;
    }

    public void B() {
        C(null);
    }

    public void C(b bVar) {
        this.f77283r = bVar;
        this.f77278m.R();
        for (a0 a0Var : this.f77279n) {
            a0Var.R();
        }
        this.f77274i.l(this);
    }

    public void E(long j11) {
        v9.a aVar;
        this.f77285t = j11;
        if (u()) {
            this.f77284s = j11;
            return;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f77276k.size(); i12++) {
            aVar = (v9.a) this.f77276k.get(i12);
            long j12 = aVar.f77261g;
            if (j12 == j11 && aVar.f77228k == C.TIME_UNSET) {
                break;
            } else {
                if (j12 > j11) {
                    break;
                }
            }
        }
        aVar = null;
        if (aVar != null ? this.f77278m.Y(aVar.g(0)) : this.f77278m.Z(j11, j11 < getNextLoadPositionUs())) {
            this.f77286u = A(this.f77278m.C(), 0);
            a0[] a0VarArr = this.f77279n;
            int length = a0VarArr.length;
            while (i11 < length) {
                a0VarArr[i11].Z(j11, true);
                i11++;
            }
            return;
        }
        this.f77284s = j11;
        this.f77288w = false;
        this.f77276k.clear();
        this.f77286u = 0;
        if (!this.f77274i.i()) {
            this.f77274i.f();
            D();
            return;
        }
        this.f77278m.r();
        a0[] a0VarArr2 = this.f77279n;
        int length2 = a0VarArr2.length;
        while (i11 < length2) {
            a0VarArr2[i11].r();
            i11++;
        }
        this.f77274i.e();
    }

    public a F(long j11, int i11) {
        for (int i12 = 0; i12 < this.f77279n.length; i12++) {
            if (this.f77267b[i12] == i11) {
                com.google.android.exoplayer2.util.a.g(!this.f77269d[i12]);
                this.f77269d[i12] = true;
                this.f77279n[i12].Z(j11, true);
                return new a(this, this.f77279n[i12], i12);
            }
        }
        throw new IllegalStateException();
    }

    public long a(long j11, c3 c3Var) {
        return this.f77270e.a(j11, c3Var);
    }

    @Override // t9.s
    public int c(p1 p1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        if (u()) {
            return -3;
        }
        v9.a aVar = this.f77287v;
        if (aVar != null && aVar.g(0) <= this.f77278m.C()) {
            return -3;
        }
        v();
        return this.f77278m.S(p1Var, decoderInputBuffer, i11, this.f77288w);
    }

    @Override // com.google.android.exoplayer2.source.b0
    public boolean continueLoading(long j11) {
        List list;
        long j12;
        if (this.f77288w || this.f77274i.i() || this.f77274i.h()) {
            return false;
        }
        boolean u11 = u();
        if (u11) {
            list = Collections.emptyList();
            j12 = this.f77284s;
        } else {
            list = this.f77277l;
            j12 = r().f77262h;
        }
        this.f77270e.f(j11, j12, list, this.f77275j);
        h hVar = this.f77275j;
        boolean z10 = hVar.f77265b;
        f fVar = hVar.f77264a;
        hVar.a();
        if (z10) {
            this.f77284s = C.TIME_UNSET;
            this.f77288w = true;
            return true;
        }
        if (fVar == null) {
            return false;
        }
        this.f77281p = fVar;
        if (t(fVar)) {
            v9.a aVar = (v9.a) fVar;
            if (u11) {
                long j13 = aVar.f77261g;
                long j14 = this.f77284s;
                if (j13 != j14) {
                    this.f77278m.b0(j14);
                    for (a0 a0Var : this.f77279n) {
                        a0Var.b0(this.f77284s);
                    }
                }
                this.f77284s = C.TIME_UNSET;
            }
            aVar.i(this.f77280o);
            this.f77276k.add(aVar);
        } else if (fVar instanceof m) {
            ((m) fVar).e(this.f77280o);
        }
        this.f77272g.A(new t9.h(fVar.f77255a, fVar.f77256b, this.f77274i.m(fVar, this, this.f77273h.a(fVar.f77257c))), fVar.f77257c, this.f77266a, fVar.f77258d, fVar.f77259e, fVar.f77260f, fVar.f77261g, fVar.f77262h);
        return true;
    }

    public void discardBuffer(long j11, boolean z10) {
        if (u()) {
            return;
        }
        int x10 = this.f77278m.x();
        this.f77278m.q(j11, z10, true);
        int x11 = this.f77278m.x();
        if (x11 > x10) {
            long y10 = this.f77278m.y();
            int i11 = 0;
            while (true) {
                a0[] a0VarArr = this.f77279n;
                if (i11 >= a0VarArr.length) {
                    break;
                }
                a0VarArr[i11].q(y10, z10, this.f77269d[i11]);
                i11++;
            }
        }
        m(x11);
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long getBufferedPositionUs() {
        if (this.f77288w) {
            return Long.MIN_VALUE;
        }
        if (u()) {
            return this.f77284s;
        }
        long j11 = this.f77285t;
        v9.a r11 = r();
        if (!r11.f()) {
            if (this.f77276k.size() > 1) {
                r11 = (v9.a) this.f77276k.get(r2.size() - 2);
            } else {
                r11 = null;
            }
        }
        if (r11 != null) {
            j11 = Math.max(j11, r11.f77262h);
        }
        return Math.max(j11, this.f77278m.z());
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long getNextLoadPositionUs() {
        if (u()) {
            return this.f77284s;
        }
        if (this.f77288w) {
            return Long.MIN_VALUE;
        }
        return r().f77262h;
    }

    @Override // com.google.android.exoplayer2.source.b0
    public boolean isLoading() {
        return this.f77274i.i();
    }

    @Override // t9.s
    public boolean isReady() {
        return !u() && this.f77278m.K(this.f77288w);
    }

    @Override // t9.s
    public void maybeThrowError() {
        this.f77274i.maybeThrowError();
        this.f77278m.N();
        if (this.f77274i.i()) {
            return;
        }
        this.f77270e.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void onLoaderReleased() {
        this.f77278m.T();
        for (a0 a0Var : this.f77279n) {
            a0Var.T();
        }
        this.f77270e.release();
        b bVar = this.f77283r;
        if (bVar != null) {
            bVar.c(this);
        }
    }

    public j q() {
        return this.f77270e;
    }

    @Override // com.google.android.exoplayer2.source.b0
    public void reevaluateBuffer(long j11) {
        if (this.f77274i.h() || u()) {
            return;
        }
        if (!this.f77274i.i()) {
            int preferredQueueSize = this.f77270e.getPreferredQueueSize(j11, this.f77277l);
            if (preferredQueueSize < this.f77276k.size()) {
                o(preferredQueueSize);
                return;
            }
            return;
        }
        f fVar = (f) com.google.android.exoplayer2.util.a.e(this.f77281p);
        if (!(t(fVar) && s(this.f77276k.size() - 1)) && this.f77270e.h(j11, fVar, this.f77277l)) {
            this.f77274i.e();
            if (t(fVar)) {
                this.f77287v = (v9.a) fVar;
            }
        }
    }

    @Override // t9.s
    public int skipData(long j11) {
        if (u()) {
            return 0;
        }
        int E = this.f77278m.E(j11, this.f77288w);
        v9.a aVar = this.f77287v;
        if (aVar != null) {
            E = Math.min(E, aVar.g(0) - this.f77278m.C());
        }
        this.f77278m.e0(E);
        v();
        return E;
    }

    boolean u() {
        return this.f77284s != C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void j(f fVar, long j11, long j12, boolean z10) {
        this.f77281p = null;
        this.f77287v = null;
        t9.h hVar = new t9.h(fVar.f77255a, fVar.f77256b, fVar.d(), fVar.c(), j11, j12, fVar.a());
        this.f77273h.b(fVar.f77255a);
        this.f77272g.r(hVar, fVar.f77257c, this.f77266a, fVar.f77258d, fVar.f77259e, fVar.f77260f, fVar.f77261g, fVar.f77262h);
        if (z10) {
            return;
        }
        if (u()) {
            D();
        } else if (t(fVar)) {
            p(this.f77276k.size() - 1);
            if (this.f77276k.isEmpty()) {
                this.f77284s = this.f77285t;
            }
        }
        this.f77271f.g(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void l(f fVar, long j11, long j12) {
        this.f77281p = null;
        this.f77270e.g(fVar);
        t9.h hVar = new t9.h(fVar.f77255a, fVar.f77256b, fVar.d(), fVar.c(), j11, j12, fVar.a());
        this.f77273h.b(fVar.f77255a);
        this.f77272g.u(hVar, fVar.f77257c, this.f77266a, fVar.f77258d, fVar.f77259e, fVar.f77260f, fVar.f77261g, fVar.f77262h);
        this.f77271f.g(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f3  */
    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.exoplayer2.upstream.Loader.c n(v9.f r32, long r33, long r35, java.io.IOException r37, int r38) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v9.i.n(v9.f, long, long, java.io.IOException, int):com.google.android.exoplayer2.upstream.Loader$c");
    }
}
