package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.trackselection.h;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.g3;
import com.google.common.collect.i3;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import la.l;
import v9.n;

/* loaded from: classes3.dex */
public class a extends la.b {

    /* renamed from: h, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.e f26834h;

    /* renamed from: i, reason: collision with root package name */
    private final long f26835i;

    /* renamed from: j, reason: collision with root package name */
    private final long f26836j;

    /* renamed from: k, reason: collision with root package name */
    private final long f26837k;

    /* renamed from: l, reason: collision with root package name */
    private final int f26838l;

    /* renamed from: m, reason: collision with root package name */
    private final int f26839m;

    /* renamed from: n, reason: collision with root package name */
    private final float f26840n;

    /* renamed from: o, reason: collision with root package name */
    private final float f26841o;

    /* renamed from: p, reason: collision with root package name */
    private final ImmutableList f26842p;

    /* renamed from: q, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.e f26843q;

    /* renamed from: r, reason: collision with root package name */
    private float f26844r;

    /* renamed from: s, reason: collision with root package name */
    private int f26845s;

    /* renamed from: t, reason: collision with root package name */
    private int f26846t;

    /* renamed from: u, reason: collision with root package name */
    private long f26847u;

    /* renamed from: v, reason: collision with root package name */
    private n f26848v;

    /* renamed from: com.google.android.exoplayer2.trackselection.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0379a {

        /* renamed from: a, reason: collision with root package name */
        public final long f26849a;

        /* renamed from: b, reason: collision with root package name */
        public final long f26850b;

        public C0379a(long j11, long j12) {
            this.f26849a = j11;
            this.f26850b = j12;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0379a)) {
                return false;
            }
            C0379a c0379a = (C0379a) obj;
            return this.f26849a == c0379a.f26849a && this.f26850b == c0379a.f26850b;
        }

        public int hashCode() {
            return (((int) this.f26849a) * 31) + ((int) this.f26850b);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements h.b {

        /* renamed from: a, reason: collision with root package name */
        private final int f26851a;

        /* renamed from: b, reason: collision with root package name */
        private final int f26852b;

        /* renamed from: c, reason: collision with root package name */
        private final int f26853c;

        /* renamed from: d, reason: collision with root package name */
        private final int f26854d;

        /* renamed from: e, reason: collision with root package name */
        private final int f26855e;

        /* renamed from: f, reason: collision with root package name */
        private final float f26856f;

        /* renamed from: g, reason: collision with root package name */
        private final float f26857g;

        /* renamed from: h, reason: collision with root package name */
        private final com.google.android.exoplayer2.util.e f26858h;

        public b() {
            this(10000, 25000, 25000, 0.7f);
        }

        public b(int i11, int i12, int i13, float f11) {
            this(i11, i12, i13, 1279, 719, f11, 0.75f, com.google.android.exoplayer2.util.e.f27621a);
        }

        public b(int i11, int i12, int i13, int i14, int i15, float f11, float f12, com.google.android.exoplayer2.util.e eVar) {
            this.f26851a = i11;
            this.f26852b = i12;
            this.f26853c = i13;
            this.f26854d = i14;
            this.f26855e = i15;
            this.f26856f = f11;
            this.f26857g = f12;
            this.f26858h = eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.trackselection.h.b
        public final h[] a(h.a[] aVarArr, com.google.android.exoplayer2.upstream.e eVar, o.b bVar, k3 k3Var) {
            ImmutableList n11 = a.n(aVarArr);
            h[] hVarArr = new h[aVarArr.length];
            for (int i11 = 0; i11 < aVarArr.length; i11++) {
                h.a aVar = aVarArr[i11];
                if (aVar != null) {
                    int[] iArr = aVar.f26926b;
                    if (iArr.length != 0) {
                        hVarArr[i11] = iArr.length == 1 ? new l(aVar.f26925a, iArr[0], aVar.f26927c) : b(aVar.f26925a, iArr, aVar.f26927c, eVar, (ImmutableList) n11.get(i11));
                    }
                }
            }
            return hVarArr;
        }

        protected a b(TrackGroup trackGroup, int[] iArr, int i11, com.google.android.exoplayer2.upstream.e eVar, ImmutableList immutableList) {
            return new a(trackGroup, iArr, i11, eVar, this.f26851a, this.f26852b, this.f26853c, this.f26854d, this.f26855e, this.f26856f, this.f26857g, immutableList, this.f26858h);
        }
    }

    protected a(TrackGroup trackGroup, int[] iArr, int i11, com.google.android.exoplayer2.upstream.e eVar, long j11, long j12, long j13, int i12, int i13, float f11, float f12, List list, com.google.android.exoplayer2.util.e eVar2) {
        super(trackGroup, iArr, i11);
        com.google.android.exoplayer2.upstream.e eVar3;
        long j14;
        if (j13 < j11) {
            s.i("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            eVar3 = eVar;
            j14 = j11;
        } else {
            eVar3 = eVar;
            j14 = j13;
        }
        this.f26834h = eVar3;
        this.f26835i = j11 * 1000;
        this.f26836j = j12 * 1000;
        this.f26837k = j14 * 1000;
        this.f26838l = i12;
        this.f26839m = i13;
        this.f26840n = f11;
        this.f26841o = f12;
        this.f26842p = ImmutableList.copyOf((Collection) list);
        this.f26843q = eVar2;
        this.f26844r = 1.0f;
        this.f26846t = 0;
        this.f26847u = C.TIME_UNSET;
    }

    private static void k(List list, long[] jArr) {
        long j11 = 0;
        for (long j12 : jArr) {
            j11 += j12;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            ImmutableList.a aVar = (ImmutableList.a) list.get(i11);
            if (aVar != null) {
                aVar.a(new C0379a(j11, jArr[i11]));
            }
        }
    }

    private int m(long j11, long j12) {
        long o11 = o(j12);
        int i11 = 0;
        for (int i12 = 0; i12 < this.f68902b; i12++) {
            if (j11 == Long.MIN_VALUE || !e(i12, j11)) {
                o1 format = getFormat(i12);
                if (l(format, format.f25546h, o11)) {
                    return i12;
                }
                i11 = i12;
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static ImmutableList n(h.a[] aVarArr) {
        ArrayList arrayList = new ArrayList();
        for (h.a aVar : aVarArr) {
            if (aVar == null || aVar.f26926b.length <= 1) {
                arrayList.add(null);
            } else {
                ImmutableList.a builder = ImmutableList.builder();
                builder.a(new C0379a(0L, 0L));
                arrayList.add(builder);
            }
        }
        long[][] s11 = s(aVarArr);
        int[] iArr = new int[s11.length];
        long[] jArr = new long[s11.length];
        for (int i11 = 0; i11 < s11.length; i11++) {
            long[] jArr2 = s11[i11];
            jArr[i11] = jArr2.length == 0 ? 0L : jArr2[0];
        }
        k(arrayList, jArr);
        ImmutableList t11 = t(s11);
        for (int i12 = 0; i12 < t11.size(); i12++) {
            int intValue = ((Integer) t11.get(i12)).intValue();
            int i13 = iArr[intValue] + 1;
            iArr[intValue] = i13;
            jArr[intValue] = s11[intValue][i13];
            k(arrayList, jArr);
        }
        for (int i14 = 0; i14 < aVarArr.length; i14++) {
            if (arrayList.get(i14) != null) {
                jArr[i14] = jArr[i14] * 2;
            }
        }
        k(arrayList, jArr);
        ImmutableList.a builder2 = ImmutableList.builder();
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            ImmutableList.a aVar2 = (ImmutableList.a) arrayList.get(i15);
            builder2.a(aVar2 == null ? ImmutableList.of() : aVar2.e());
        }
        return builder2.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long o(long j11) {
        long u11 = u(j11);
        if (this.f26842p.isEmpty()) {
            return u11;
        }
        int i11 = 1;
        while (i11 < this.f26842p.size() - 1 && ((C0379a) this.f26842p.get(i11)).f26849a < u11) {
            i11++;
        }
        C0379a c0379a = (C0379a) this.f26842p.get(i11 - 1);
        C0379a c0379a2 = (C0379a) this.f26842p.get(i11);
        long j12 = c0379a.f26849a;
        float f11 = ((float) (u11 - j12)) / ((float) (c0379a2.f26849a - j12));
        return c0379a.f26850b + (f11 * ((float) (c0379a2.f26850b - r2)));
    }

    private long p(List list) {
        if (list.isEmpty()) {
            return C.TIME_UNSET;
        }
        n nVar = (n) g3.g(list);
        long j11 = nVar.f77261g;
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long j12 = nVar.f77262h;
        return j12 != C.TIME_UNSET ? j12 - j11 : C.TIME_UNSET;
    }

    private long r(v9.o[] oVarArr, List list) {
        int i11 = this.f26845s;
        if (i11 < oVarArr.length && oVarArr[i11].next()) {
            v9.o oVar = oVarArr[this.f26845s];
            return oVar.b() - oVar.a();
        }
        for (v9.o oVar2 : oVarArr) {
            if (oVar2.next()) {
                return oVar2.b() - oVar2.a();
            }
        }
        return p(list);
    }

    private static long[][] s(h.a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length];
        for (int i11 = 0; i11 < aVarArr.length; i11++) {
            h.a aVar = aVarArr[i11];
            if (aVar == null) {
                jArr[i11] = new long[0];
            } else {
                jArr[i11] = new long[aVar.f26926b.length];
                int i12 = 0;
                while (true) {
                    if (i12 >= aVar.f26926b.length) {
                        break;
                    }
                    jArr[i11][i12] = aVar.f26925a.c(r5[i12]).f25546h;
                    i12++;
                }
                Arrays.sort(jArr[i11]);
            }
        }
        return jArr;
    }

    private static ImmutableList t(long[][] jArr) {
        i3 g11 = MultimapBuilder.e().a().g();
        for (int i11 = 0; i11 < jArr.length; i11++) {
            long[] jArr2 = jArr[i11];
            if (jArr2.length > 1) {
                int length = jArr2.length;
                double[] dArr = new double[length];
                int i12 = 0;
                while (true) {
                    long[] jArr3 = jArr[i11];
                    double d11 = 0.0d;
                    if (i12 >= jArr3.length) {
                        break;
                    }
                    long j11 = jArr3[i12];
                    if (j11 != -1) {
                        d11 = Math.log(j11);
                    }
                    dArr[i12] = d11;
                    i12++;
                }
                int i13 = length - 1;
                double d12 = dArr[i13] - dArr[0];
                int i14 = 0;
                while (i14 < i13) {
                    double d13 = dArr[i14];
                    i14++;
                    g11.put(Double.valueOf(d12 == 0.0d ? 1.0d : (((d13 + dArr[i14]) * 0.5d) - dArr[0]) / d12), Integer.valueOf(i11));
                }
            }
        }
        return ImmutableList.copyOf(g11.values());
    }

    private long u(long j11) {
        long bitrateEstimate = ((float) this.f26834h.getBitrateEstimate()) * this.f26840n;
        if (this.f26834h.a() == C.TIME_UNSET || j11 == C.TIME_UNSET) {
            return ((float) bitrateEstimate) / this.f26844r;
        }
        float f11 = (float) j11;
        return (((float) bitrateEstimate) * Math.max((f11 / this.f26844r) - ((float) r2), 0.0f)) / f11;
    }

    private long v(long j11, long j12) {
        if (j11 == C.TIME_UNSET) {
            return this.f26835i;
        }
        if (j12 != C.TIME_UNSET) {
            j11 -= j12;
        }
        return Math.min(((float) j11) * this.f26841o, this.f26835i);
    }

    @Override // com.google.android.exoplayer2.trackselection.h
    public void d(long j11, long j12, long j13, List list, v9.o[] oVarArr) {
        long elapsedRealtime = this.f26843q.elapsedRealtime();
        long r11 = r(oVarArr, list);
        int i11 = this.f26846t;
        if (i11 == 0) {
            this.f26846t = 1;
            this.f26845s = m(elapsedRealtime, r11);
            return;
        }
        int i12 = this.f26845s;
        int g11 = list.isEmpty() ? -1 : g(((n) g3.g(list)).f77258d);
        if (g11 != -1) {
            i11 = ((n) g3.g(list)).f77259e;
            i12 = g11;
        }
        int m11 = m(elapsedRealtime, r11);
        if (!e(i12, elapsedRealtime)) {
            o1 format = getFormat(i12);
            o1 format2 = getFormat(m11);
            long v11 = v(j13, r11);
            int i13 = format2.f25546h;
            int i14 = format.f25546h;
            if ((i13 > i14 && j12 < v11) || (i13 < i14 && j12 >= this.f26836j)) {
                m11 = i12;
            }
        }
        if (m11 != i12) {
            i11 = 3;
        }
        this.f26846t = i11;
        this.f26845s = m11;
    }

    @Override // la.b, com.google.android.exoplayer2.trackselection.h
    public void disable() {
        this.f26848v = null;
    }

    @Override // la.b, com.google.android.exoplayer2.trackselection.h
    public void enable() {
        this.f26847u = C.TIME_UNSET;
        this.f26848v = null;
    }

    @Override // la.b, com.google.android.exoplayer2.trackselection.h
    public int evaluateQueueSize(long j11, List list) {
        int i11;
        int i12;
        long elapsedRealtime = this.f26843q.elapsedRealtime();
        if (!w(elapsedRealtime, list)) {
            return list.size();
        }
        this.f26847u = elapsedRealtime;
        this.f26848v = list.isEmpty() ? null : (n) g3.g(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long f02 = p0.f0(((n) list.get(size - 1)).f77261g - j11, this.f26844r);
        long q11 = q();
        if (f02 < q11) {
            return size;
        }
        o1 format = getFormat(m(elapsedRealtime, p(list)));
        for (int i13 = 0; i13 < size; i13++) {
            n nVar = (n) list.get(i13);
            o1 o1Var = nVar.f77258d;
            if (p0.f0(nVar.f77261g - j11, this.f26844r) >= q11 && o1Var.f25546h < format.f25546h && (i11 = o1Var.f25556r) != -1 && i11 <= this.f26839m && (i12 = o1Var.f25555q) != -1 && i12 <= this.f26838l && i11 < format.f25556r) {
                return i13;
            }
        }
        return size;
    }

    @Override // com.google.android.exoplayer2.trackselection.h
    public int getSelectedIndex() {
        return this.f26845s;
    }

    @Override // com.google.android.exoplayer2.trackselection.h
    public Object getSelectionData() {
        return null;
    }

    @Override // com.google.android.exoplayer2.trackselection.h
    public int getSelectionReason() {
        return this.f26846t;
    }

    protected boolean l(o1 o1Var, int i11, long j11) {
        return ((long) i11) <= j11;
    }

    @Override // la.b, com.google.android.exoplayer2.trackselection.h
    public void onPlaybackSpeed(float f11) {
        this.f26844r = f11;
    }

    protected long q() {
        return this.f26837k;
    }

    protected boolean w(long j11, List list) {
        long j12 = this.f26847u;
        return j12 == C.TIME_UNSET || j11 - j12 >= 1000 || !(list.isEmpty() || ((n) g3.g(list)).equals(this.f26848v));
    }
}
