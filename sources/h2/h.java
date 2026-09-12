package h2;

import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.y;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.c4;
import androidx.media3.exoplayer.drm.r;
import androidx.media3.exoplayer.drm.t;
import androidx.media3.exoplayer.s2;
import androidx.media3.exoplayer.source.e0;
import androidx.media3.exoplayer.source.f0;
import androidx.media3.exoplayer.source.s;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.v2;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g2.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class h implements u, f0, Loader.b, Loader.e {

    /* renamed from: a, reason: collision with root package name */
    public final int f64430a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f64431b;

    /* renamed from: c, reason: collision with root package name */
    private final r[] f64432c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean[] f64433d;

    /* renamed from: e, reason: collision with root package name */
    private final i f64434e;

    /* renamed from: f, reason: collision with root package name */
    private final f0.a f64435f;

    /* renamed from: g, reason: collision with root package name */
    private final s.a f64436g;

    /* renamed from: h, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.m f64437h;

    /* renamed from: i, reason: collision with root package name */
    private final Loader f64438i;

    /* renamed from: j, reason: collision with root package name */
    private final g f64439j;

    /* renamed from: k, reason: collision with root package name */
    private final ArrayList f64440k;

    /* renamed from: l, reason: collision with root package name */
    private final List f64441l;

    /* renamed from: m, reason: collision with root package name */
    private final e0 f64442m;

    /* renamed from: n, reason: collision with root package name */
    private final e0[] f64443n;

    /* renamed from: o, reason: collision with root package name */
    private final c f64444o;

    /* renamed from: p, reason: collision with root package name */
    private e f64445p;

    /* renamed from: q, reason: collision with root package name */
    private r f64446q;

    /* renamed from: r, reason: collision with root package name */
    private b f64447r;

    /* renamed from: s, reason: collision with root package name */
    private long f64448s;

    /* renamed from: t, reason: collision with root package name */
    private long f64449t;

    /* renamed from: u, reason: collision with root package name */
    private int f64450u;

    /* renamed from: v, reason: collision with root package name */
    private h2.a f64451v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f64452w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f64453x;

    /* renamed from: y, reason: collision with root package name */
    boolean f64454y;

    /* loaded from: classes2.dex */
    public final class a implements u {

        /* renamed from: a, reason: collision with root package name */
        public final h f64455a;

        /* renamed from: b, reason: collision with root package name */
        private final e0 f64456b;

        /* renamed from: c, reason: collision with root package name */
        private final int f64457c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f64458d;

        public a(h hVar, e0 e0Var, int i11) {
            this.f64455a = hVar;
            this.f64456b = e0Var;
            this.f64457c = i11;
        }

        private void a() {
            if (this.f64458d) {
                return;
            }
            h.this.f64436g.j(h.this.f64431b[this.f64457c], h.this.f64432c[this.f64457c], 0, null, h.this.f64449t);
            this.f64458d = true;
        }

        public void b() {
            androidx.media3.common.util.a.g(h.this.f64433d[this.f64457c]);
            h.this.f64433d[this.f64457c] = false;
        }

        @Override // g2.u
        public int c(s2 s2Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            if (h.this.y()) {
                return -3;
            }
            if (h.this.f64451v != null && h.this.f64451v.g(this.f64457c + 1) <= this.f64456b.F()) {
                return -3;
            }
            a();
            return this.f64456b.V(s2Var, decoderInputBuffer, i11, h.this.f64454y);
        }

        @Override // g2.u
        public boolean isReady() {
            return !h.this.y() && this.f64456b.N(h.this.f64454y);
        }

        @Override // g2.u
        public void maybeThrowError() {
        }

        @Override // g2.u
        public int skipData(long j11) {
            if (h.this.y()) {
                return 0;
            }
            int H = this.f64456b.H(j11, h.this.f64454y);
            if (h.this.f64451v != null) {
                H = Math.min(H, h.this.f64451v.g(this.f64457c + 1) - this.f64456b.F());
            }
            this.f64456b.h0(H);
            if (H > 0) {
                a();
            }
            return H;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void h(h hVar);
    }

    public h(int i11, int[] iArr, r[] rVarArr, i iVar, f0.a aVar, androidx.media3.exoplayer.upstream.b bVar, long j11, t tVar, r.a aVar2, androidx.media3.exoplayer.upstream.m mVar, s.a aVar3, boolean z10, androidx.media3.exoplayer.util.c cVar) {
        this.f64430a = i11;
        int i12 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.f64431b = iArr;
        this.f64432c = rVarArr == null ? new androidx.media3.common.r[0] : rVarArr;
        this.f64434e = iVar;
        this.f64435f = aVar;
        this.f64436g = aVar3;
        this.f64437h = mVar;
        this.f64452w = z10;
        this.f64438i = cVar != null ? new Loader(cVar) : new Loader("ChunkSampleStream");
        this.f64439j = new g();
        ArrayList arrayList = new ArrayList();
        this.f64440k = arrayList;
        this.f64441l = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.f64443n = new e0[length];
        this.f64433d = new boolean[length];
        int i13 = length + 1;
        int[] iArr2 = new int[i13];
        e0[] e0VarArr = new e0[i13];
        e0 l11 = e0.l(bVar, tVar, aVar2);
        this.f64442m = l11;
        iArr2[0] = i11;
        e0VarArr[0] = l11;
        while (i12 < length) {
            e0 m11 = e0.m(bVar);
            this.f64443n[i12] = m11;
            int i14 = i12 + 1;
            e0VarArr[i14] = m11;
            iArr2[i14] = this.f64431b[i12];
            i12 = i14;
        }
        this.f64444o = new c(iArr2, e0VarArr);
        this.f64448s = j11;
        this.f64449t = j11;
    }

    private void A(int i11) {
        h2.a aVar = (h2.a) this.f64440k.get(i11);
        androidx.media3.common.r rVar = aVar.f64422d;
        if (!rVar.equals(this.f64446q)) {
            this.f64436g.j(this.f64430a, rVar, aVar.f64423e, aVar.f64424f, aVar.f64425g);
        }
        this.f64446q = rVar;
    }

    private int F(int i11, int i12) {
        do {
            i12++;
            if (i12 >= this.f64440k.size()) {
                return this.f64440k.size() - 1;
            }
        } while (((h2.a) this.f64440k.get(i12)).g(0) <= i11);
        return i12 - 1;
    }

    private void H() {
        this.f64442m.Y();
        for (e0 e0Var : this.f64443n) {
            e0Var.Y();
        }
    }

    private void n(int i11) {
        int min = Math.min(F(i11, 0), this.f64450u);
        if (min > 0) {
            a1.c1(this.f64440k, 0, min);
            this.f64450u -= min;
        }
    }

    private void r(int i11) {
        androidx.media3.common.util.a.g(!this.f64438i.i());
        int size = this.f64440k.size();
        while (true) {
            if (i11 >= size) {
                i11 = -1;
                break;
            } else if (!w(i11)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 == -1) {
            return;
        }
        long j11 = v().f64426h;
        h2.a s11 = s(i11);
        if (this.f64440k.isEmpty()) {
            this.f64448s = this.f64449t;
        }
        this.f64454y = false;
        this.f64436g.F(this.f64430a, s11.f64425g, j11);
    }

    private h2.a s(int i11) {
        h2.a aVar = (h2.a) this.f64440k.get(i11);
        ArrayList arrayList = this.f64440k;
        a1.c1(arrayList, i11, arrayList.size());
        this.f64450u = Math.max(this.f64450u, this.f64440k.size());
        int i12 = 0;
        this.f64442m.w(aVar.g(0));
        while (true) {
            e0[] e0VarArr = this.f64443n;
            if (i12 >= e0VarArr.length) {
                return aVar;
            }
            e0 e0Var = e0VarArr[i12];
            i12++;
            e0Var.w(aVar.g(i12));
        }
    }

    private h2.a v() {
        return (h2.a) this.f64440k.get(r0.size() - 1);
    }

    private boolean w(int i11) {
        int F;
        h2.a aVar = (h2.a) this.f64440k.get(i11);
        if (this.f64442m.F() > aVar.g(0)) {
            return true;
        }
        int i12 = 0;
        do {
            e0[] e0VarArr = this.f64443n;
            if (i12 >= e0VarArr.length) {
                return false;
            }
            F = e0VarArr[i12].F();
            i12++;
        } while (F <= aVar.g(i12));
        return true;
    }

    private boolean x(e eVar) {
        return eVar instanceof h2.a;
    }

    private void z() {
        int F = F(this.f64442m.F(), this.f64450u - 1);
        while (true) {
            int i11 = this.f64450u;
            if (i11 > F) {
                return;
            }
            this.f64450u = i11 + 1;
            A(i11);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void q(e eVar, long j11, long j12, boolean z10) {
        this.f64445p = null;
        this.f64451v = null;
        g2.i iVar = new g2.i(eVar.f64419a, eVar.f64420b, eVar.d(), eVar.c(), j11, j12, eVar.a());
        this.f64437h.b(eVar.f64419a);
        this.f64436g.t(iVar, eVar.f64421c, this.f64430a, eVar.f64422d, eVar.f64423e, eVar.f64424f, eVar.f64425g, eVar.f64426h);
        if (z10) {
            return;
        }
        if (y()) {
            H();
        } else if (x(eVar)) {
            s(this.f64440k.size() - 1);
            if (this.f64440k.isEmpty()) {
                this.f64448s = this.f64449t;
            }
        }
        this.f64435f.f(this);
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void p(e eVar, long j11, long j12) {
        this.f64445p = null;
        this.f64434e.a(eVar);
        g2.i iVar = new g2.i(eVar.f64419a, eVar.f64420b, eVar.d(), eVar.c(), j11, j12, eVar.a());
        this.f64437h.b(eVar.f64419a);
        this.f64436g.w(iVar, eVar.f64421c, this.f64430a, eVar.f64422d, eVar.f64423e, eVar.f64424f, eVar.f64425g, eVar.f64426h);
        this.f64435f.f(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f3  */
    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.media3.exoplayer.upstream.Loader.c k(h2.e r32, long r33, long r35, java.io.IOException r37, int r38) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.h.k(h2.e, long, long, java.io.IOException, int):androidx.media3.exoplayer.upstream.Loader$c");
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void o(e eVar, long j11, long j12, int i11) {
        this.f64436g.C(i11 == 0 ? new g2.i(eVar.f64419a, eVar.f64420b, j11) : new g2.i(eVar.f64419a, eVar.f64420b, eVar.d(), eVar.c(), j11, j12, eVar.a()), eVar.f64421c, this.f64430a, eVar.f64422d, eVar.f64423e, eVar.f64424f, eVar.f64425g, eVar.f64426h, i11);
    }

    public void G(b bVar) {
        this.f64447r = bVar;
        this.f64442m.U();
        for (e0 e0Var : this.f64443n) {
            e0Var.U();
        }
        this.f64438i.l(this);
    }

    public void I(long j11) {
        h2.a aVar;
        this.f64449t = j11;
        int i11 = 0;
        this.f64452w = false;
        if (y()) {
            this.f64448s = j11;
            return;
        }
        for (int i12 = 0; i12 < this.f64440k.size(); i12++) {
            aVar = (h2.a) this.f64440k.get(i12);
            long j12 = aVar.f64425g;
            if (j12 == j11 && aVar.f64389k == C.TIME_UNSET) {
                break;
            } else {
                if (j12 > j11) {
                    break;
                }
            }
        }
        aVar = null;
        if (aVar != null ? this.f64442m.b0(aVar.g(0)) : this.f64442m.c0(j11, j11 < getNextLoadPositionUs())) {
            this.f64450u = F(this.f64442m.F(), 0);
            e0[] e0VarArr = this.f64443n;
            int length = e0VarArr.length;
            while (i11 < length) {
                e0VarArr[i11].c0(j11, true);
                i11++;
            }
            return;
        }
        this.f64448s = j11;
        this.f64454y = false;
        this.f64440k.clear();
        this.f64450u = 0;
        if (!this.f64438i.i()) {
            this.f64438i.f();
            H();
            return;
        }
        this.f64442m.s();
        e0[] e0VarArr2 = this.f64443n;
        int length2 = e0VarArr2.length;
        while (i11 < length2) {
            e0VarArr2[i11].s();
            i11++;
        }
        this.f64438i.e();
    }

    public a J(long j11, int i11) {
        for (int i12 = 0; i12 < this.f64443n.length; i12++) {
            if (this.f64431b[i12] == i11) {
                androidx.media3.common.util.a.g(!this.f64433d[i12]);
                this.f64433d[i12] = true;
                this.f64443n[i12].c0(j11, true);
                return new a(this, this.f64443n[i12], i12);
            }
        }
        throw new IllegalStateException();
    }

    @Override // androidx.media3.exoplayer.source.f0
    public boolean a(v2 v2Var) {
        List list;
        long j11;
        if (this.f64454y || this.f64438i.i() || this.f64438i.h()) {
            return false;
        }
        boolean y10 = y();
        if (y10) {
            list = Collections.emptyList();
            j11 = this.f64448s;
        } else {
            list = this.f64441l;
            j11 = v().f64426h;
        }
        this.f64434e.c(v2Var, j11, list, this.f64439j);
        g gVar = this.f64439j;
        boolean z10 = gVar.f64429b;
        e eVar = gVar.f64428a;
        gVar.a();
        if (z10) {
            this.f64448s = C.TIME_UNSET;
            this.f64454y = true;
            return true;
        }
        if (eVar == null) {
            return false;
        }
        this.f64445p = eVar;
        if (x(eVar)) {
            h2.a aVar = (h2.a) eVar;
            if (y10) {
                long j12 = aVar.f64425g;
                long j13 = this.f64448s;
                if (j12 < j13) {
                    this.f64442m.e0(j13);
                    for (e0 e0Var : this.f64443n) {
                        e0Var.e0(this.f64448s);
                    }
                    if (this.f64452w) {
                        androidx.media3.common.r rVar = aVar.f64422d;
                        this.f64453x = !y.a(rVar.f10243o, rVar.f10239k);
                    }
                }
                this.f64452w = false;
                this.f64448s = C.TIME_UNSET;
            }
            aVar.i(this.f64444o);
            this.f64440k.add(aVar);
        } else if (eVar instanceof l) {
            ((l) eVar).e(this.f64444o);
        }
        this.f64438i.m(eVar, this, this.f64437h.a(eVar.f64421c));
        return true;
    }

    public long b(long j11, c4 c4Var) {
        return this.f64434e.b(j11, c4Var);
    }

    @Override // g2.u
    public int c(s2 s2Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        if (y()) {
            return -3;
        }
        h2.a aVar = this.f64451v;
        if (aVar != null && aVar.g(0) <= this.f64442m.F()) {
            return -3;
        }
        z();
        return this.f64442m.V(s2Var, decoderInputBuffer, i11, this.f64454y);
    }

    public void discardBuffer(long j11, boolean z10) {
        if (y()) {
            return;
        }
        int A = this.f64442m.A();
        this.f64442m.r(j11, z10, true);
        int A2 = this.f64442m.A();
        if (A2 > A) {
            long B = this.f64442m.B();
            int i11 = 0;
            while (true) {
                e0[] e0VarArr = this.f64443n;
                if (i11 >= e0VarArr.length) {
                    break;
                }
                e0VarArr[i11].r(B, z10, this.f64433d[i11]);
                i11++;
            }
        }
        n(A2);
    }

    @Override // androidx.media3.exoplayer.source.f0
    public long getBufferedPositionUs() {
        if (this.f64454y) {
            return Long.MIN_VALUE;
        }
        if (y()) {
            return this.f64448s;
        }
        long j11 = this.f64449t;
        h2.a v11 = v();
        if (!v11.f()) {
            if (this.f64440k.size() > 1) {
                v11 = (h2.a) this.f64440k.get(r2.size() - 2);
            } else {
                v11 = null;
            }
        }
        if (v11 != null) {
            j11 = Math.max(j11, v11.f64426h);
        }
        return Math.max(j11, this.f64442m.C());
    }

    @Override // androidx.media3.exoplayer.source.f0
    public long getNextLoadPositionUs() {
        if (y()) {
            return this.f64448s;
        }
        if (this.f64454y) {
            return Long.MIN_VALUE;
        }
        return v().f64426h;
    }

    @Override // androidx.media3.exoplayer.source.f0
    public boolean isLoading() {
        return this.f64438i.i();
    }

    @Override // g2.u
    public boolean isReady() {
        return !y() && this.f64442m.N(this.f64454y);
    }

    public boolean m() {
        try {
            return this.f64453x;
        } finally {
            this.f64453x = false;
        }
    }

    @Override // g2.u
    public void maybeThrowError() {
        this.f64438i.maybeThrowError();
        this.f64442m.Q();
        if (this.f64438i.i()) {
            return;
        }
        this.f64434e.maybeThrowError();
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.e
    public void onLoaderReleased() {
        this.f64442m.W();
        for (e0 e0Var : this.f64443n) {
            e0Var.W();
        }
        this.f64434e.release();
        b bVar = this.f64447r;
        if (bVar != null) {
            bVar.h(this);
        }
    }

    @Override // androidx.media3.exoplayer.source.f0
    public void reevaluateBuffer(long j11) {
        if (this.f64438i.h() || y()) {
            return;
        }
        if (!this.f64438i.i()) {
            int preferredQueueSize = this.f64434e.getPreferredQueueSize(j11, this.f64441l);
            if (preferredQueueSize < this.f64440k.size()) {
                r(preferredQueueSize);
                return;
            }
            return;
        }
        e eVar = (e) androidx.media3.common.util.a.e(this.f64445p);
        if (!(x(eVar) && w(this.f64440k.size() - 1)) && this.f64434e.d(j11, eVar, this.f64441l)) {
            this.f64438i.e();
            if (x(eVar)) {
                this.f64451v = (h2.a) eVar;
            }
        }
    }

    @Override // g2.u
    public int skipData(long j11) {
        if (y()) {
            return 0;
        }
        int H = this.f64442m.H(j11, this.f64454y);
        h2.a aVar = this.f64451v;
        if (aVar != null) {
            H = Math.min(H, aVar.g(0) - this.f64442m.F());
        }
        this.f64442m.h0(H);
        z();
        return H;
    }

    public void t(long j11) {
        androidx.media3.common.util.a.g(!this.f64438i.i());
        if (y() || j11 == C.TIME_UNSET || this.f64440k.isEmpty()) {
            return;
        }
        h2.a v11 = v();
        long j12 = v11.f64390l;
        if (j12 == C.TIME_UNSET) {
            j12 = v11.f64426h;
        }
        if (j12 <= j11) {
            return;
        }
        long C = this.f64442m.C();
        if (C <= j11) {
            return;
        }
        this.f64442m.u(j11);
        for (e0 e0Var : this.f64443n) {
            e0Var.u(j11);
        }
        this.f64436g.F(this.f64430a, j11, C);
    }

    public i u() {
        return this.f64434e;
    }

    boolean y() {
        return this.f64448s != C.TIME_UNSET;
    }
}
