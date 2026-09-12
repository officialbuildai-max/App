package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.v1;
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
import java.util.Map;

/* loaded from: classes3.dex */
public final class MergingMediaSource extends c {

    /* renamed from: v, reason: collision with root package name */
    private static final v1 f25712v = new v1.c().d("MergingMediaSource").a();

    /* renamed from: k, reason: collision with root package name */
    private final boolean f25713k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f25714l;

    /* renamed from: m, reason: collision with root package name */
    private final o[] f25715m;

    /* renamed from: n, reason: collision with root package name */
    private final k3[] f25716n;

    /* renamed from: o, reason: collision with root package name */
    private final ArrayList f25717o;

    /* renamed from: p, reason: collision with root package name */
    private final t9.d f25718p;

    /* renamed from: q, reason: collision with root package name */
    private final Map f25719q;

    /* renamed from: r, reason: collision with root package name */
    private final j3 f25720r;

    /* renamed from: s, reason: collision with root package name */
    private int f25721s;

    /* renamed from: t, reason: collision with root package name */
    private long[][] f25722t;

    /* renamed from: u, reason: collision with root package name */
    private IllegalMergeException f25723u;

    /* loaded from: classes3.dex */
    public static final class IllegalMergeException extends IOException {
        public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
        public final int reason;

        public IllegalMergeException(int i11) {
            this.reason = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a extends j {

        /* renamed from: d, reason: collision with root package name */
        private final long[] f25724d;

        /* renamed from: e, reason: collision with root package name */
        private final long[] f25725e;

        public a(k3 k3Var, Map map) {
            super(k3Var);
            int t11 = k3Var.t();
            this.f25725e = new long[k3Var.t()];
            k3.d dVar = new k3.d();
            for (int i11 = 0; i11 < t11; i11++) {
                this.f25725e[i11] = k3Var.r(i11, dVar).f25236n;
            }
            int m11 = k3Var.m();
            this.f25724d = new long[m11];
            k3.b bVar = new k3.b();
            for (int i12 = 0; i12 < m11; i12++) {
                k3Var.k(i12, bVar, true);
                long longValue = ((Long) com.google.android.exoplayer2.util.a.e((Long) map.get(bVar.f25209b))).longValue();
                long[] jArr = this.f25724d;
                longValue = longValue == Long.MIN_VALUE ? bVar.f25211d : longValue;
                jArr[i12] = longValue;
                long j11 = bVar.f25211d;
                if (j11 != C.TIME_UNSET) {
                    long[] jArr2 = this.f25725e;
                    int i13 = bVar.f25210c;
                    jArr2[i13] = jArr2[i13] - (j11 - longValue);
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.k3
        public k3.b k(int i11, k3.b bVar, boolean z10) {
            super.k(i11, bVar, z10);
            bVar.f25211d = this.f25724d[i11];
            return bVar;
        }

        @Override // com.google.android.exoplayer2.source.j, com.google.android.exoplayer2.k3
        public k3.d s(int i11, k3.d dVar, long j11) {
            long j12;
            super.s(i11, dVar, j11);
            long j13 = this.f25725e[i11];
            dVar.f25236n = j13;
            if (j13 != C.TIME_UNSET) {
                long j14 = dVar.f25235m;
                if (j14 != C.TIME_UNSET) {
                    j12 = Math.min(j14, j13);
                    dVar.f25235m = j12;
                    return dVar;
                }
            }
            j12 = dVar.f25235m;
            dVar.f25235m = j12;
            return dVar;
        }
    }

    public MergingMediaSource(boolean z10, boolean z11, t9.d dVar, o... oVarArr) {
        this.f25713k = z10;
        this.f25714l = z11;
        this.f25715m = oVarArr;
        this.f25718p = dVar;
        this.f25717o = new ArrayList(Arrays.asList(oVarArr));
        this.f25721s = -1;
        this.f25716n = new k3[oVarArr.length];
        this.f25722t = new long[0];
        this.f25719q = new HashMap();
        this.f25720r = MultimapBuilder.a().a().g();
    }

    public MergingMediaSource(boolean z10, boolean z11, o... oVarArr) {
        this(z10, z11, new t9.e(), oVarArr);
    }

    public MergingMediaSource(boolean z10, o... oVarArr) {
        this(z10, false, oVarArr);
    }

    public MergingMediaSource(o... oVarArr) {
        this(false, oVarArr);
    }

    private void L() {
        k3.b bVar = new k3.b();
        for (int i11 = 0; i11 < this.f25721s; i11++) {
            long j11 = -this.f25716n[0].j(i11, bVar).q();
            int i12 = 1;
            while (true) {
                k3[] k3VarArr = this.f25716n;
                if (i12 < k3VarArr.length) {
                    this.f25722t[i11][i12] = j11 - (-k3VarArr[i12].j(i11, bVar).q());
                    i12++;
                }
            }
        }
    }

    private void O() {
        k3[] k3VarArr;
        k3.b bVar = new k3.b();
        for (int i11 = 0; i11 < this.f25721s; i11++) {
            int i12 = 0;
            long j11 = Long.MIN_VALUE;
            while (true) {
                k3VarArr = this.f25716n;
                if (i12 >= k3VarArr.length) {
                    break;
                }
                long m11 = k3VarArr[i12].j(i11, bVar).m();
                if (m11 != C.TIME_UNSET) {
                    long j12 = m11 + this.f25722t[i11][i12];
                    if (j11 == Long.MIN_VALUE || j12 < j11) {
                        j11 = j12;
                    }
                }
                i12++;
            }
            Object q11 = k3VarArr[0].q(i11);
            this.f25719q.put(q11, Long.valueOf(j11));
            Iterator it = this.f25720r.get(q11).iterator();
            while (it.hasNext()) {
                ((b) it.next()).l(0L, j11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void B(k0 k0Var) {
        super.B(k0Var);
        for (int i11 = 0; i11 < this.f25715m.length; i11++) {
            K(Integer.valueOf(i11), this.f25715m[i11]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void D() {
        super.D();
        Arrays.fill(this.f25716n, (Object) null);
        this.f25721s = -1;
        this.f25723u = null;
        this.f25717o.clear();
        Collections.addAll(this.f25717o, this.f25715m);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.c
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public o.b F(Integer num, o.b bVar) {
        if (num.intValue() == 0) {
            return bVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.c
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void I(Integer num, o oVar, k3 k3Var) {
        if (this.f25723u != null) {
            return;
        }
        if (this.f25721s == -1) {
            this.f25721s = k3Var.m();
        } else if (k3Var.m() != this.f25721s) {
            this.f25723u = new IllegalMergeException(0);
            return;
        }
        if (this.f25722t.length == 0) {
            this.f25722t = (long[][]) Array.newInstance((Class<?>) Long.TYPE, this.f25721s, this.f25716n.length);
        }
        this.f25717o.remove(oVar);
        this.f25716n[num.intValue()] = k3Var;
        if (this.f25717o.isEmpty()) {
            if (this.f25713k) {
                L();
            }
            k3 k3Var2 = this.f25716n[0];
            if (this.f25714l) {
                O();
                k3Var2 = new a(k3Var2, this.f25719q);
            }
            C(k3Var2);
        }
    }

    @Override // com.google.android.exoplayer2.source.o
    public v1 a() {
        o[] oVarArr = this.f25715m;
        return oVarArr.length > 0 ? oVarArr[0].a() : f25712v;
    }

    @Override // com.google.android.exoplayer2.source.o
    public n d(o.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        int length = this.f25715m.length;
        n[] nVarArr = new n[length];
        int f11 = this.f25716n[0].f(bVar.f76237a);
        for (int i11 = 0; i11 < length; i11++) {
            nVarArr[i11] = this.f25715m[i11].d(bVar.c(this.f25716n[i11].q(f11)), bVar2, j11 - this.f25722t[f11][i11]);
        }
        q qVar = new q(this.f25718p, this.f25722t[f11], nVarArr);
        if (!this.f25714l) {
            return qVar;
        }
        b bVar3 = new b(qVar, true, 0L, ((Long) com.google.android.exoplayer2.util.a.e((Long) this.f25719q.get(bVar.f76237a))).longValue());
        this.f25720r.put(bVar.f76237a, bVar3);
        return bVar3;
    }

    @Override // com.google.android.exoplayer2.source.o
    public void k(n nVar) {
        if (this.f25714l) {
            b bVar = (b) nVar;
            Iterator it = this.f25720r.entries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((b) entry.getValue()).equals(bVar)) {
                    this.f25720r.remove(entry.getKey(), entry.getValue());
                    break;
                }
            }
            nVar = bVar.f25770a;
        }
        q qVar = (q) nVar;
        int i11 = 0;
        while (true) {
            o[] oVarArr = this.f25715m;
            if (i11 >= oVarArr.length) {
                return;
            }
            oVarArr[i11].k(qVar.c(i11));
            i11++;
        }
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.o
    public void maybeThrowSourceInfoRefreshError() {
        IllegalMergeException illegalMergeException = this.f25723u;
        if (illegalMergeException != null) {
            throw illegalMergeException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }
}
