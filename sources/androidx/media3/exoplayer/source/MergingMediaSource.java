package androidx.media3.exoplayer.source;

import androidx.media3.common.e0;
import androidx.media3.common.t;
import androidx.media3.exoplayer.source.r;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.j3;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class MergingMediaSource extends androidx.media3.exoplayer.source.c {

    /* renamed from: w, reason: collision with root package name */
    private static final androidx.media3.common.t f12691w = new t.c().d("MergingMediaSource").a();

    /* renamed from: k, reason: collision with root package name */
    private final boolean f12692k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f12693l;

    /* renamed from: m, reason: collision with root package name */
    private final r[] f12694m;

    /* renamed from: n, reason: collision with root package name */
    private final List f12695n;

    /* renamed from: o, reason: collision with root package name */
    private final androidx.media3.common.e0[] f12696o;

    /* renamed from: p, reason: collision with root package name */
    private final ArrayList f12697p;

    /* renamed from: q, reason: collision with root package name */
    private final g2.e f12698q;

    /* renamed from: r, reason: collision with root package name */
    private final Map f12699r;

    /* renamed from: s, reason: collision with root package name */
    private final j3 f12700s;

    /* renamed from: t, reason: collision with root package name */
    private int f12701t;

    /* renamed from: u, reason: collision with root package name */
    private long[][] f12702u;

    /* renamed from: v, reason: collision with root package name */
    private IllegalMergeException f12703v;

    /* loaded from: classes2.dex */
    public static final class IllegalMergeException extends IOException {
        public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
        public final int reason;

        public IllegalMergeException(int i11) {
            this.reason = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b extends m {

        /* renamed from: f, reason: collision with root package name */
        private final long[] f12704f;

        /* renamed from: g, reason: collision with root package name */
        private final long[] f12705g;

        public b(androidx.media3.common.e0 e0Var, Map map) {
            super(e0Var);
            int p11 = e0Var.p();
            this.f12705g = new long[e0Var.p()];
            e0.c cVar = new e0.c();
            for (int i11 = 0; i11 < p11; i11++) {
                this.f12705g[i11] = e0Var.n(i11, cVar).f10045m;
            }
            int i12 = e0Var.i();
            this.f12704f = new long[i12];
            e0.b bVar = new e0.b();
            for (int i13 = 0; i13 < i12; i13++) {
                e0Var.g(i13, bVar, true);
                long longValue = ((Long) androidx.media3.common.util.a.e((Long) map.get(bVar.f10017b))).longValue();
                long[] jArr = this.f12704f;
                longValue = longValue == Long.MIN_VALUE ? bVar.f10019d : longValue;
                jArr[i13] = longValue;
                long j11 = bVar.f10019d;
                if (j11 != C.TIME_UNSET) {
                    long[] jArr2 = this.f12705g;
                    int i14 = bVar.f10018c;
                    jArr2[i14] = jArr2[i14] - (j11 - longValue);
                }
            }
        }

        @Override // androidx.media3.exoplayer.source.m, androidx.media3.common.e0
        public e0.b g(int i11, e0.b bVar, boolean z10) {
            super.g(i11, bVar, z10);
            bVar.f10019d = this.f12704f[i11];
            return bVar;
        }

        @Override // androidx.media3.exoplayer.source.m, androidx.media3.common.e0
        public e0.c o(int i11, e0.c cVar, long j11) {
            long j12;
            super.o(i11, cVar, j11);
            long j13 = this.f12705g[i11];
            cVar.f10045m = j13;
            if (j13 != C.TIME_UNSET) {
                long j14 = cVar.f10044l;
                if (j14 != C.TIME_UNSET) {
                    j12 = Math.min(j14, j13);
                    cVar.f10044l = j12;
                    return cVar;
                }
            }
            j12 = cVar.f10044l;
            cVar.f10044l = j12;
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final r.b f12706a;

        /* renamed from: b, reason: collision with root package name */
        private final q f12707b;

        private c(r.b bVar, q qVar) {
            this.f12706a = bVar;
            this.f12707b = qVar;
        }
    }

    public MergingMediaSource(boolean z10, boolean z11, g2.e eVar, r... rVarArr) {
        this.f12692k = z10;
        this.f12693l = z11;
        this.f12694m = rVarArr;
        this.f12698q = eVar;
        this.f12697p = new ArrayList(Arrays.asList(rVarArr));
        this.f12701t = -1;
        this.f12695n = new ArrayList(rVarArr.length);
        for (int i11 = 0; i11 < rVarArr.length; i11++) {
            this.f12695n.add(new ArrayList());
        }
        this.f12696o = new androidx.media3.common.e0[rVarArr.length];
        this.f12702u = new long[0];
        this.f12699r = new HashMap();
        this.f12700s = MultimapBuilder.a().a().g();
    }

    public MergingMediaSource(boolean z10, boolean z11, r... rVarArr) {
        this(z10, z11, new g2.f(), rVarArr);
    }

    public MergingMediaSource(boolean z10, r... rVarArr) {
        this(z10, false, rVarArr);
    }

    public MergingMediaSource(r... rVarArr) {
        this(false, rVarArr);
    }

    private void J() {
        e0.b bVar = new e0.b();
        for (int i11 = 0; i11 < this.f12701t; i11++) {
            long j11 = -this.f12696o[0].f(i11, bVar).o();
            int i12 = 1;
            while (true) {
                androidx.media3.common.e0[] e0VarArr = this.f12696o;
                if (i12 < e0VarArr.length) {
                    this.f12702u[i11][i12] = j11 - (-e0VarArr[i12].f(i11, bVar).o());
                    i12++;
                }
            }
        }
    }

    private void M() {
        androidx.media3.common.e0[] e0VarArr;
        e0.b bVar = new e0.b();
        for (int i11 = 0; i11 < this.f12701t; i11++) {
            int i12 = 0;
            long j11 = Long.MIN_VALUE;
            while (true) {
                e0VarArr = this.f12696o;
                if (i12 >= e0VarArr.length) {
                    break;
                }
                long k11 = e0VarArr[i12].f(i11, bVar).k();
                if (k11 != C.TIME_UNSET) {
                    long j12 = k11 + this.f12702u[i11][i12];
                    if (j11 == Long.MIN_VALUE || j12 < j11) {
                        j11 = j12;
                    }
                }
                i12++;
            }
            Object m11 = e0VarArr[0].m(i11);
            this.f12699r.put(m11, Long.valueOf(j11));
            Iterator it = this.f12700s.get(m11).iterator();
            while (it.hasNext()) {
                ((androidx.media3.exoplayer.source.b) it.next()).n(0L, j11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.c, androidx.media3.exoplayer.source.a
    public void B() {
        super.B();
        Arrays.fill(this.f12696o, (Object) null);
        this.f12701t = -1;
        this.f12703v = null;
        this.f12697p.clear();
        Collections.addAll(this.f12697p, this.f12694m);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.c
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public r.b D(Integer num, r.b bVar) {
        List list = (List) this.f12695n.get(num.intValue());
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (((c) list.get(i11)).f12706a.equals(bVar)) {
                return ((c) ((List) this.f12695n.get(0)).get(i11)).f12706a;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.c
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void G(Integer num, r rVar, androidx.media3.common.e0 e0Var) {
        if (this.f12703v != null) {
            return;
        }
        if (this.f12701t == -1) {
            this.f12701t = e0Var.i();
        } else if (e0Var.i() != this.f12701t) {
            this.f12703v = new IllegalMergeException(0);
            return;
        }
        if (this.f12702u.length == 0) {
            this.f12702u = (long[][]) Array.newInstance((Class<?>) Long.TYPE, this.f12701t, this.f12696o.length);
        }
        this.f12697p.remove(rVar);
        this.f12696o[num.intValue()] = e0Var;
        if (this.f12697p.isEmpty()) {
            if (this.f12692k) {
                J();
            }
            androidx.media3.common.e0 e0Var2 = this.f12696o[0];
            if (this.f12693l) {
                M();
                e0Var2 = new b(e0Var2, this.f12699r);
            }
            A(e0Var2);
        }
    }

    @Override // androidx.media3.exoplayer.source.r
    public androidx.media3.common.t a() {
        r[] rVarArr = this.f12694m;
        return rVarArr.length > 0 ? rVarArr[0].a() : f12691w;
    }

    @Override // androidx.media3.exoplayer.source.r
    public q g(r.b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11) {
        int length = this.f12694m.length;
        q[] qVarArr = new q[length];
        int b11 = this.f12696o[0].b(bVar.f12965a);
        for (int i11 = 0; i11 < length; i11++) {
            r.b a11 = bVar.a(this.f12696o[i11].m(b11));
            qVarArr[i11] = this.f12694m[i11].g(a11, bVar2, j11 - this.f12702u[b11][i11]);
            ((List) this.f12695n.get(i11)).add(new c(a11, qVarArr[i11]));
        }
        u uVar = new u(this.f12698q, this.f12702u[b11], qVarArr);
        if (!this.f12693l) {
            return uVar;
        }
        androidx.media3.exoplayer.source.b bVar3 = new androidx.media3.exoplayer.source.b(uVar, false, 0L, ((Long) androidx.media3.common.util.a.e((Long) this.f12699r.get(bVar.f12965a))).longValue());
        this.f12700s.put(bVar.f12965a, bVar3);
        return bVar3;
    }

    @Override // androidx.media3.exoplayer.source.r
    public void j(q qVar) {
        if (this.f12693l) {
            androidx.media3.exoplayer.source.b bVar = (androidx.media3.exoplayer.source.b) qVar;
            Iterator it = this.f12700s.entries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((androidx.media3.exoplayer.source.b) entry.getValue()).equals(bVar)) {
                    this.f12700s.remove(entry.getKey(), entry.getValue());
                    break;
                }
            }
            qVar = bVar.f12764a;
        }
        u uVar = (u) qVar;
        for (int i11 = 0; i11 < this.f12694m.length; i11++) {
            List list = (List) this.f12695n.get(i11);
            int i12 = 0;
            while (true) {
                if (i12 >= list.size()) {
                    break;
                }
                if (((c) list.get(i12)).f12707b.equals(qVar)) {
                    list.remove(i12);
                    break;
                }
                i12++;
            }
            this.f12694m[i11].j(uVar.i(i11));
        }
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.r
    public void l(androidx.media3.common.t tVar) {
        this.f12694m[0].l(tVar);
    }

    @Override // androidx.media3.exoplayer.source.c, androidx.media3.exoplayer.source.r
    public void maybeThrowSourceInfoRefreshError() {
        IllegalMergeException illegalMergeException = this.f12703v;
        if (illegalMergeException != null) {
            throw illegalMergeException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.r
    public boolean q(androidx.media3.common.t tVar) {
        r[] rVarArr = this.f12694m;
        return rVarArr.length > 0 && rVarArr[0].q(tVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.c, androidx.media3.exoplayer.source.a
    public void z(w1.n nVar) {
        super.z(nVar);
        for (int i11 = 0; i11 < this.f12694m.length; i11++) {
            I(Integer.valueOf(i11), this.f12694m[i11]);
        }
    }
}
