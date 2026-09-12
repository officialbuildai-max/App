package androidx.media3.exoplayer.source;

import androidx.media3.common.r;
import androidx.media3.exoplayer.c4;
import androidx.media3.exoplayer.source.q;
import androidx.media3.exoplayer.v2;
import com.google.common.collect.Lists;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;

/* loaded from: classes2.dex */
final class u implements q, q.a {

    /* renamed from: a, reason: collision with root package name */
    private final q[] f12975a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean[] f12976b;

    /* renamed from: d, reason: collision with root package name */
    private final g2.e f12978d;

    /* renamed from: g, reason: collision with root package name */
    private q.a f12981g;

    /* renamed from: h, reason: collision with root package name */
    private g2.z f12982h;

    /* renamed from: j, reason: collision with root package name */
    private f0 f12984j;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList f12979e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final HashMap f12980f = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final IdentityHashMap f12977c = new IdentityHashMap();

    /* renamed from: i, reason: collision with root package name */
    private q[] f12983i = new q[0];

    /* loaded from: classes2.dex */
    private static final class a implements j2.z {

        /* renamed from: a, reason: collision with root package name */
        private final j2.z f12985a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.media3.common.f0 f12986b;

        public a(j2.z zVar, androidx.media3.common.f0 f0Var) {
            this.f12985a = zVar;
            this.f12986b = f0Var;
        }

        @Override // j2.z
        public void a() {
            this.f12985a.a();
        }

        @Override // j2.z
        public void b(boolean z10) {
            this.f12985a.b(z10);
        }

        @Override // j2.z
        public void c() {
            this.f12985a.c();
        }

        @Override // j2.z
        public boolean d(int i11, long j11) {
            return this.f12985a.d(i11, j11);
        }

        @Override // j2.z
        public void disable() {
            this.f12985a.disable();
        }

        @Override // j2.z
        public void e(long j11, long j12, long j13, List list, h2.n[] nVarArr) {
            this.f12985a.e(j11, j12, j13, list, nVarArr);
        }

        @Override // j2.z
        public void enable() {
            this.f12985a.enable();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f12985a.equals(aVar.f12985a) && this.f12986b.equals(aVar.f12986b);
        }

        @Override // j2.z
        public int evaluateQueueSize(long j11, List list) {
            return this.f12985a.evaluateQueueSize(j11, list);
        }

        @Override // j2.c0
        public int f(androidx.media3.common.r rVar) {
            return this.f12985a.indexOf(this.f12986b.b(rVar));
        }

        @Override // j2.z
        public boolean g(int i11, long j11) {
            return this.f12985a.g(i11, j11);
        }

        @Override // j2.c0
        public androidx.media3.common.r getFormat(int i11) {
            return this.f12986b.a(this.f12985a.getIndexInTrackGroup(i11));
        }

        @Override // j2.c0
        public int getIndexInTrackGroup(int i11) {
            return this.f12985a.getIndexInTrackGroup(i11);
        }

        @Override // j2.z
        public androidx.media3.common.r getSelectedFormat() {
            return this.f12986b.a(this.f12985a.getSelectedIndexInTrackGroup());
        }

        @Override // j2.z
        public int getSelectedIndex() {
            return this.f12985a.getSelectedIndex();
        }

        @Override // j2.z
        public int getSelectedIndexInTrackGroup() {
            return this.f12985a.getSelectedIndexInTrackGroup();
        }

        @Override // j2.z
        public Object getSelectionData() {
            return this.f12985a.getSelectionData();
        }

        @Override // j2.z
        public int getSelectionReason() {
            return this.f12985a.getSelectionReason();
        }

        @Override // j2.c0
        public androidx.media3.common.f0 getTrackGroup() {
            return this.f12986b;
        }

        @Override // j2.z
        public boolean h(long j11, h2.e eVar, List list) {
            return this.f12985a.h(j11, eVar, list);
        }

        public int hashCode() {
            return ((527 + this.f12986b.hashCode()) * 31) + this.f12985a.hashCode();
        }

        @Override // j2.c0
        public int indexOf(int i11) {
            return this.f12985a.indexOf(i11);
        }

        @Override // j2.c0
        public int length() {
            return this.f12985a.length();
        }

        @Override // j2.z
        public void onPlaybackSpeed(float f11) {
            this.f12985a.onPlaybackSpeed(f11);
        }
    }

    public u(g2.e eVar, long[] jArr, q... qVarArr) {
        this.f12978d = eVar;
        this.f12975a = qVarArr;
        this.f12984j = eVar.b();
        this.f12976b = new boolean[qVarArr.length];
        for (int i11 = 0; i11 < qVarArr.length; i11++) {
            long j11 = jArr[i11];
            if (j11 != 0) {
                this.f12976b[i11] = true;
                this.f12975a[i11] = new k0(qVarArr[i11], j11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List j(q qVar) {
        return qVar.getTrackGroups().c();
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public boolean a(v2 v2Var) {
        if (this.f12979e.isEmpty()) {
            return this.f12984j.a(v2Var);
        }
        int size = this.f12979e.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((q) this.f12979e.get(i11)).a(v2Var);
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.source.q
    public long b(long j11, c4 c4Var) {
        q[] qVarArr = this.f12983i;
        return (qVarArr.length > 0 ? qVarArr[0] : this.f12975a[0]).b(j11, c4Var);
    }

    @Override // androidx.media3.exoplayer.source.q.a
    public void c(q qVar) {
        this.f12979e.remove(qVar);
        if (!this.f12979e.isEmpty()) {
            return;
        }
        int i11 = 0;
        for (q qVar2 : this.f12975a) {
            i11 += qVar2.getTrackGroups().f63389a;
        }
        androidx.media3.common.f0[] f0VarArr = new androidx.media3.common.f0[i11];
        int i12 = 0;
        int i13 = 0;
        while (true) {
            q[] qVarArr = this.f12975a;
            if (i12 >= qVarArr.length) {
                this.f12982h = new g2.z(f0VarArr);
                ((q.a) androidx.media3.common.util.a.e(this.f12981g)).c(this);
                return;
            }
            g2.z trackGroups = qVarArr[i12].getTrackGroups();
            int i14 = trackGroups.f63389a;
            int i15 = 0;
            while (i15 < i14) {
                androidx.media3.common.f0 b11 = trackGroups.b(i15);
                androidx.media3.common.r[] rVarArr = new androidx.media3.common.r[b11.f10053a];
                for (int i16 = 0; i16 < b11.f10053a; i16++) {
                    androidx.media3.common.r a11 = b11.a(i16);
                    r.b b12 = a11.b();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i12);
                    sb2.append(":");
                    String str = a11.f10229a;
                    if (str == null) {
                        str = "";
                    }
                    sb2.append(str);
                    rVarArr[i16] = b12.f0(sb2.toString()).N();
                }
                androidx.media3.common.f0 f0Var = new androidx.media3.common.f0(i12 + ":" + b11.f10054b, rVarArr);
                this.f12980f.put(f0Var, b11);
                f0VarArr[i13] = f0Var;
                i15++;
                i13++;
            }
            i12++;
        }
    }

    @Override // androidx.media3.exoplayer.source.q
    public void discardBuffer(long j11, boolean z10) {
        for (q qVar : this.f12983i) {
            qVar.discardBuffer(j11, z10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    @Override // androidx.media3.exoplayer.source.q
    public long e(j2.z[] zVarArr, boolean[] zArr, g2.u[] uVarArr, boolean[] zArr2, long j11) {
        g2.u uVar;
        int[] iArr = new int[zVarArr.length];
        int[] iArr2 = new int[zVarArr.length];
        int i11 = 0;
        int i12 = 0;
        while (true) {
            uVar = null;
            if (i12 >= zVarArr.length) {
                break;
            }
            g2.u uVar2 = uVarArr[i12];
            Integer num = uVar2 != null ? (Integer) this.f12977c.get(uVar2) : null;
            iArr[i12] = num == null ? -1 : num.intValue();
            j2.z zVar = zVarArr[i12];
            if (zVar != null) {
                String str = zVar.getTrackGroup().f10054b;
                iArr2[i12] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr2[i12] = -1;
            }
            i12++;
        }
        this.f12977c.clear();
        int length = zVarArr.length;
        g2.u[] uVarArr2 = new g2.u[length];
        g2.u[] uVarArr3 = new g2.u[zVarArr.length];
        j2.z[] zVarArr2 = new j2.z[zVarArr.length];
        ArrayList arrayList = new ArrayList(this.f12975a.length);
        long j12 = j11;
        int i13 = 0;
        j2.z[] zVarArr3 = zVarArr2;
        while (i13 < this.f12975a.length) {
            for (int i14 = i11; i14 < zVarArr.length; i14++) {
                uVarArr3[i14] = iArr[i14] == i13 ? uVarArr[i14] : uVar;
                if (iArr2[i14] == i13) {
                    j2.z zVar2 = (j2.z) androidx.media3.common.util.a.e(zVarArr[i14]);
                    zVarArr3[i14] = new a(zVar2, (androidx.media3.common.f0) androidx.media3.common.util.a.e((androidx.media3.common.f0) this.f12980f.get(zVar2.getTrackGroup())));
                } else {
                    zVarArr3[i14] = uVar;
                }
            }
            int i15 = i13;
            ArrayList arrayList2 = arrayList;
            j2.z[] zVarArr4 = zVarArr3;
            long e11 = this.f12975a[i13].e(zVarArr3, zArr, uVarArr3, zArr2, j12);
            if (i15 == 0) {
                j12 = e11;
            } else if (e11 != j12) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z10 = false;
            for (int i16 = 0; i16 < zVarArr.length; i16++) {
                if (iArr2[i16] == i15) {
                    g2.u uVar3 = (g2.u) androidx.media3.common.util.a.e(uVarArr3[i16]);
                    uVarArr2[i16] = uVarArr3[i16];
                    this.f12977c.put(uVar3, Integer.valueOf(i15));
                    z10 = true;
                } else if (iArr[i16] == i15) {
                    androidx.media3.common.util.a.g(uVarArr3[i16] == null);
                }
            }
            if (z10) {
                arrayList2.add(this.f12975a[i15]);
            }
            i13 = i15 + 1;
            arrayList = arrayList2;
            zVarArr3 = zVarArr4;
            i11 = 0;
            uVar = null;
        }
        int i17 = i11;
        ArrayList arrayList3 = arrayList;
        System.arraycopy(uVarArr2, i17, uVarArr, i17, length);
        this.f12983i = (q[]) arrayList3.toArray(new q[i17]);
        this.f12984j = this.f12978d.a(arrayList3, Lists.o(arrayList3, new com.google.common.base.f() { // from class: androidx.media3.exoplayer.source.t
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                List j13;
                j13 = u.j((q) obj);
                return j13;
            }
        }));
        return j12;
    }

    @Override // androidx.media3.exoplayer.source.q
    public void g(q.a aVar, long j11) {
        this.f12981g = aVar;
        Collections.addAll(this.f12979e, this.f12975a);
        for (q qVar : this.f12975a) {
            qVar.g(this, j11);
        }
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public long getBufferedPositionUs() {
        return this.f12984j.getBufferedPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public long getNextLoadPositionUs() {
        return this.f12984j.getNextLoadPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.q
    public g2.z getTrackGroups() {
        return (g2.z) androidx.media3.common.util.a.e(this.f12982h);
    }

    public q i(int i11) {
        return this.f12976b[i11] ? ((k0) this.f12975a[i11]).h() : this.f12975a[i11];
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public boolean isLoading() {
        return this.f12984j.isLoading();
    }

    @Override // androidx.media3.exoplayer.source.f0.a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void f(q qVar) {
        ((q.a) androidx.media3.common.util.a.e(this.f12981g)).f(this);
    }

    @Override // androidx.media3.exoplayer.source.q
    public void maybeThrowPrepareError() {
        for (q qVar : this.f12975a) {
            qVar.maybeThrowPrepareError();
        }
    }

    @Override // androidx.media3.exoplayer.source.q
    public long readDiscontinuity() {
        long j11 = -9223372036854775807L;
        for (q qVar : this.f12983i) {
            long readDiscontinuity = qVar.readDiscontinuity();
            if (readDiscontinuity != C.TIME_UNSET) {
                if (j11 == C.TIME_UNSET) {
                    for (q qVar2 : this.f12983i) {
                        if (qVar2 == qVar) {
                            break;
                        }
                        if (qVar2.seekToUs(readDiscontinuity) != readDiscontinuity) {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j11 = readDiscontinuity;
                } else if (readDiscontinuity != j11) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (j11 != C.TIME_UNSET && qVar.seekToUs(j11) != j11) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j11;
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public void reevaluateBuffer(long j11) {
        this.f12984j.reevaluateBuffer(j11);
    }

    @Override // androidx.media3.exoplayer.source.q
    public long seekToUs(long j11) {
        long seekToUs = this.f12983i[0].seekToUs(j11);
        int i11 = 1;
        while (true) {
            q[] qVarArr = this.f12983i;
            if (i11 >= qVarArr.length) {
                return seekToUs;
            }
            if (qVarArr[i11].seekToUs(seekToUs) != seekToUs) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i11++;
        }
    }
}
