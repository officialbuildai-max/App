package j2;

import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.source.r;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.g3;
import com.google.common.collect.i3;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j2.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class a extends c {

    /* renamed from: i, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.e f65830i;

    /* renamed from: j, reason: collision with root package name */
    private final long f65831j;

    /* renamed from: k, reason: collision with root package name */
    private final long f65832k;

    /* renamed from: l, reason: collision with root package name */
    private final long f65833l;

    /* renamed from: m, reason: collision with root package name */
    private final int f65834m;

    /* renamed from: n, reason: collision with root package name */
    private final int f65835n;

    /* renamed from: o, reason: collision with root package name */
    private final float f65836o;

    /* renamed from: p, reason: collision with root package name */
    private final float f65837p;

    /* renamed from: q, reason: collision with root package name */
    private final ImmutableList f65838q;

    /* renamed from: r, reason: collision with root package name */
    private final androidx.media3.common.util.i f65839r;

    /* renamed from: s, reason: collision with root package name */
    private float f65840s;

    /* renamed from: t, reason: collision with root package name */
    private int f65841t;

    /* renamed from: u, reason: collision with root package name */
    private int f65842u;

    /* renamed from: v, reason: collision with root package name */
    private long f65843v;

    /* renamed from: w, reason: collision with root package name */
    private h2.m f65844w;

    /* renamed from: x, reason: collision with root package name */
    private long f65845x;

    /* renamed from: j2.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0823a {

        /* renamed from: a, reason: collision with root package name */
        public final long f65846a;

        /* renamed from: b, reason: collision with root package name */
        public final long f65847b;

        public C0823a(long j11, long j12) {
            this.f65846a = j11;
            this.f65847b = j12;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0823a)) {
                return false;
            }
            C0823a c0823a = (C0823a) obj;
            return this.f65846a == c0823a.f65846a && this.f65847b == c0823a.f65847b;
        }

        public int hashCode() {
            return (((int) this.f65846a) * 31) + ((int) this.f65847b);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements z.b {

        /* renamed from: a, reason: collision with root package name */
        private final int f65848a;

        /* renamed from: b, reason: collision with root package name */
        private final int f65849b;

        /* renamed from: c, reason: collision with root package name */
        private final int f65850c;

        /* renamed from: d, reason: collision with root package name */
        private final int f65851d;

        /* renamed from: e, reason: collision with root package name */
        private final int f65852e;

        /* renamed from: f, reason: collision with root package name */
        private final float f65853f;

        /* renamed from: g, reason: collision with root package name */
        private final float f65854g;

        /* renamed from: h, reason: collision with root package name */
        private final androidx.media3.common.util.i f65855h;

        public b() {
            this(10000, 25000, 25000, 0.7f);
        }

        public b(int i11, int i12, int i13, float f11) {
            this(i11, i12, i13, 1279, 719, f11, 0.75f, androidx.media3.common.util.i.f10469a);
        }

        public b(int i11, int i12, int i13, int i14, int i15, float f11, float f12, androidx.media3.common.util.i iVar) {
            this.f65848a = i11;
            this.f65849b = i12;
            this.f65850c = i13;
            this.f65851d = i14;
            this.f65852e = i15;
            this.f65853f = f11;
            this.f65854g = f12;
            this.f65855h = iVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // j2.z.b
        public final z[] a(z.a[] aVarArr, androidx.media3.exoplayer.upstream.e eVar, r.b bVar, androidx.media3.common.e0 e0Var) {
            ImmutableList o11 = a.o(aVarArr);
            z[] zVarArr = new z[aVarArr.length];
            for (int i11 = 0; i11 < aVarArr.length; i11++) {
                z.a aVar = aVarArr[i11];
                if (aVar != null) {
                    int[] iArr = aVar.f65976b;
                    if (iArr.length != 0) {
                        zVarArr[i11] = iArr.length == 1 ? new a0(aVar.f65975a, iArr[0], aVar.f65977c) : b(aVar.f65975a, iArr, aVar.f65977c, eVar, (ImmutableList) o11.get(i11));
                    }
                }
            }
            return zVarArr;
        }

        protected a b(androidx.media3.common.f0 f0Var, int[] iArr, int i11, androidx.media3.exoplayer.upstream.e eVar, ImmutableList immutableList) {
            return new a(f0Var, iArr, i11, eVar, this.f65848a, this.f65849b, this.f65850c, this.f65851d, this.f65852e, this.f65853f, this.f65854g, immutableList, this.f65855h);
        }
    }

    protected a(androidx.media3.common.f0 f0Var, int[] iArr, int i11, androidx.media3.exoplayer.upstream.e eVar, long j11, long j12, long j13, int i12, int i13, float f11, float f12, List list, androidx.media3.common.util.i iVar) {
        super(f0Var, iArr, i11);
        androidx.media3.exoplayer.upstream.e eVar2;
        long j14;
        if (j13 < j11) {
            androidx.media3.common.util.u.h("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            eVar2 = eVar;
            j14 = j11;
        } else {
            eVar2 = eVar;
            j14 = j13;
        }
        this.f65830i = eVar2;
        this.f65831j = j11 * 1000;
        this.f65832k = j12 * 1000;
        this.f65833l = j14 * 1000;
        this.f65834m = i12;
        this.f65835n = i13;
        this.f65836o = f11;
        this.f65837p = f12;
        this.f65838q = ImmutableList.copyOf((Collection) list);
        this.f65839r = iVar;
        this.f65840s = 1.0f;
        this.f65842u = 0;
        this.f65843v = C.TIME_UNSET;
        this.f65845x = -2147483647L;
    }

    private static void l(List list, long[] jArr) {
        long j11 = 0;
        for (long j12 : jArr) {
            j11 += j12;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            ImmutableList.a aVar = (ImmutableList.a) list.get(i11);
            if (aVar != null) {
                aVar.a(new C0823a(j11, jArr[i11]));
            }
        }
    }

    private int n(long j11, long j12) {
        long p11 = p(j12);
        int i11 = 0;
        for (int i12 = 0; i12 < this.f65867b; i12++) {
            if (j11 == Long.MIN_VALUE || !d(i12, j11)) {
                androidx.media3.common.r format = getFormat(i12);
                if (m(format, format.f10238j, p11)) {
                    return i12;
                }
                i11 = i12;
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static ImmutableList o(z.a[] aVarArr) {
        ArrayList arrayList = new ArrayList();
        for (z.a aVar : aVarArr) {
            if (aVar == null || aVar.f65976b.length <= 1) {
                arrayList.add(null);
            } else {
                ImmutableList.a builder = ImmutableList.builder();
                builder.a(new C0823a(0L, 0L));
                arrayList.add(builder);
            }
        }
        long[][] t11 = t(aVarArr);
        int[] iArr = new int[t11.length];
        long[] jArr = new long[t11.length];
        for (int i11 = 0; i11 < t11.length; i11++) {
            long[] jArr2 = t11[i11];
            jArr[i11] = jArr2.length == 0 ? 0L : jArr2[0];
        }
        l(arrayList, jArr);
        ImmutableList u11 = u(t11);
        for (int i12 = 0; i12 < u11.size(); i12++) {
            int intValue = ((Integer) u11.get(i12)).intValue();
            int i13 = iArr[intValue] + 1;
            iArr[intValue] = i13;
            jArr[intValue] = t11[intValue][i13];
            l(arrayList, jArr);
        }
        for (int i14 = 0; i14 < aVarArr.length; i14++) {
            if (arrayList.get(i14) != null) {
                jArr[i14] = jArr[i14] * 2;
            }
        }
        l(arrayList, jArr);
        ImmutableList.a builder2 = ImmutableList.builder();
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            ImmutableList.a aVar2 = (ImmutableList.a) arrayList.get(i15);
            builder2.a(aVar2 == null ? ImmutableList.of() : aVar2.e());
        }
        return builder2.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long p(long j11) {
        long v11 = v(j11);
        if (this.f65838q.isEmpty()) {
            return v11;
        }
        int i11 = 1;
        while (i11 < this.f65838q.size() - 1 && ((C0823a) this.f65838q.get(i11)).f65846a < v11) {
            i11++;
        }
        C0823a c0823a = (C0823a) this.f65838q.get(i11 - 1);
        C0823a c0823a2 = (C0823a) this.f65838q.get(i11);
        long j12 = c0823a.f65846a;
        float f11 = ((float) (v11 - j12)) / ((float) (c0823a2.f65846a - j12));
        return c0823a.f65847b + (f11 * ((float) (c0823a2.f65847b - r2)));
    }

    private long q(List list) {
        if (list.isEmpty()) {
            return C.TIME_UNSET;
        }
        h2.m mVar = (h2.m) g3.g(list);
        long j11 = mVar.f64425g;
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long j12 = mVar.f64426h;
        return j12 != C.TIME_UNSET ? j12 - j11 : C.TIME_UNSET;
    }

    private long s(h2.n[] nVarArr, List list) {
        int i11 = this.f65841t;
        if (i11 < nVarArr.length && nVarArr[i11].next()) {
            h2.n nVar = nVarArr[this.f65841t];
            return nVar.b() - nVar.a();
        }
        for (h2.n nVar2 : nVarArr) {
            if (nVar2.next()) {
                return nVar2.b() - nVar2.a();
            }
        }
        return q(list);
    }

    private static long[][] t(z.a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length];
        for (int i11 = 0; i11 < aVarArr.length; i11++) {
            z.a aVar = aVarArr[i11];
            if (aVar == null) {
                jArr[i11] = new long[0];
            } else {
                jArr[i11] = new long[aVar.f65976b.length];
                int i12 = 0;
                while (true) {
                    int[] iArr = aVar.f65976b;
                    if (i12 >= iArr.length) {
                        break;
                    }
                    long j11 = aVar.f65975a.a(iArr[i12]).f10238j;
                    long[] jArr2 = jArr[i11];
                    if (j11 == -1) {
                        j11 = 0;
                    }
                    jArr2[i12] = j11;
                    i12++;
                }
                Arrays.sort(jArr[i11]);
            }
        }
        return jArr;
    }

    private static ImmutableList u(long[][] jArr) {
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

    private long v(long j11) {
        long bitrateEstimate = this.f65830i.getBitrateEstimate();
        this.f65845x = bitrateEstimate;
        long j12 = ((float) bitrateEstimate) * this.f65836o;
        if (this.f65830i.a() == C.TIME_UNSET || j11 == C.TIME_UNSET) {
            return ((float) j12) / this.f65840s;
        }
        float f11 = (float) j11;
        return (((float) j12) * Math.max((f11 / this.f65840s) - ((float) r2), 0.0f)) / f11;
    }

    private long w(long j11, long j12) {
        if (j11 == C.TIME_UNSET) {
            return this.f65831j;
        }
        if (j12 != C.TIME_UNSET) {
            j11 -= j12;
        }
        return Math.min(((float) j11) * this.f65837p, this.f65831j);
    }

    @Override // j2.c, j2.z
    public void disable() {
        this.f65844w = null;
    }

    @Override // j2.z
    public void e(long j11, long j12, long j13, List list, h2.n[] nVarArr) {
        long elapsedRealtime = this.f65839r.elapsedRealtime();
        long s11 = s(nVarArr, list);
        int i11 = this.f65842u;
        if (i11 == 0) {
            this.f65842u = 1;
            this.f65841t = n(elapsedRealtime, s11);
            return;
        }
        int i12 = this.f65841t;
        int f11 = list.isEmpty() ? -1 : f(((h2.m) g3.g(list)).f64422d);
        if (f11 != -1) {
            i11 = ((h2.m) g3.g(list)).f64423e;
            i12 = f11;
        }
        int n11 = n(elapsedRealtime, s11);
        if (n11 != i12 && !d(i12, elapsedRealtime)) {
            androidx.media3.common.r format = getFormat(i12);
            androidx.media3.common.r format2 = getFormat(n11);
            long w11 = w(j13, s11);
            int i13 = format2.f10238j;
            int i14 = format.f10238j;
            if ((i13 > i14 && j12 < w11) || (i13 < i14 && j12 >= this.f65832k)) {
                n11 = i12;
            }
        }
        if (n11 != i12) {
            i11 = 3;
        }
        this.f65842u = i11;
        this.f65841t = n11;
    }

    @Override // j2.c, j2.z
    public void enable() {
        this.f65843v = C.TIME_UNSET;
        this.f65844w = null;
    }

    @Override // j2.c, j2.z
    public int evaluateQueueSize(long j11, List list) {
        int i11;
        int i12;
        long elapsedRealtime = this.f65839r.elapsedRealtime();
        if (!x(elapsedRealtime, list)) {
            return list.size();
        }
        this.f65843v = elapsedRealtime;
        this.f65844w = list.isEmpty() ? null : (h2.m) g3.g(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long l02 = a1.l0(((h2.m) list.get(size - 1)).f64425g - j11, this.f65840s);
        long r11 = r();
        if (l02 < r11) {
            return size;
        }
        androidx.media3.common.r format = getFormat(n(elapsedRealtime, q(list)));
        for (int i13 = 0; i13 < size; i13++) {
            h2.m mVar = (h2.m) list.get(i13);
            androidx.media3.common.r rVar = mVar.f64422d;
            if (a1.l0(mVar.f64425g - j11, this.f65840s) >= r11 && rVar.f10238j < format.f10238j && (i11 = rVar.f10251w) != -1 && i11 <= this.f65835n && (i12 = rVar.f10250v) != -1 && i12 <= this.f65834m && i11 < format.f10251w) {
                return i13;
            }
        }
        return size;
    }

    @Override // j2.z
    public int getSelectedIndex() {
        return this.f65841t;
    }

    @Override // j2.z
    public Object getSelectionData() {
        return null;
    }

    @Override // j2.z
    public int getSelectionReason() {
        return this.f65842u;
    }

    protected boolean m(androidx.media3.common.r rVar, int i11, long j11) {
        return ((long) i11) <= j11;
    }

    @Override // j2.c, j2.z
    public void onPlaybackSpeed(float f11) {
        this.f65840s = f11;
    }

    protected long r() {
        return this.f65833l;
    }

    protected boolean x(long j11, List list) {
        long j12 = this.f65843v;
        return j12 == C.TIME_UNSET || j11 - j12 >= 1000 || !(list.isEmpty() || ((h2.m) g3.g(list)).equals(this.f65844w));
    }
}
