package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.c3;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.source.n;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;

/* loaded from: classes3.dex */
final class q implements n, n.a {

    /* renamed from: a, reason: collision with root package name */
    private final n[] f26301a;

    /* renamed from: c, reason: collision with root package name */
    private final t9.d f26303c;

    /* renamed from: f, reason: collision with root package name */
    private n.a f26306f;

    /* renamed from: g, reason: collision with root package name */
    private t9.x f26307g;

    /* renamed from: i, reason: collision with root package name */
    private b0 f26309i;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList f26304d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final HashMap f26305e = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final IdentityHashMap f26302b = new IdentityHashMap();

    /* renamed from: h, reason: collision with root package name */
    private n[] f26308h = new n[0];

    /* loaded from: classes3.dex */
    private static final class a implements com.google.android.exoplayer2.trackselection.h {

        /* renamed from: a, reason: collision with root package name */
        private final com.google.android.exoplayer2.trackselection.h f26310a;

        /* renamed from: b, reason: collision with root package name */
        private final TrackGroup f26311b;

        public a(com.google.android.exoplayer2.trackselection.h hVar, TrackGroup trackGroup) {
            this.f26310a = hVar;
            this.f26311b = trackGroup;
        }

        @Override // com.google.android.exoplayer2.trackselection.h
        public void a() {
            this.f26310a.a();
        }

        @Override // com.google.android.exoplayer2.trackselection.h
        public void b(boolean z10) {
            this.f26310a.b(z10);
        }

        @Override // com.google.android.exoplayer2.trackselection.h
        public boolean blacklist(int i11, long j11) {
            return this.f26310a.blacklist(i11, j11);
        }

        @Override // com.google.android.exoplayer2.trackselection.h
        public void c() {
            this.f26310a.c();
        }

        @Override // com.google.android.exoplayer2.trackselection.h
        public void d(long j11, long j12, long j13, List list, v9.o[] oVarArr) {
            this.f26310a.d(j11, j12, j13, list, oVarArr);
        }

        @Override // com.google.android.exoplayer2.trackselection.h
        public void disable() {
            this.f26310a.disable();
        }

        @Override // com.google.android.exoplayer2.trackselection.h
        public boolean e(int i11, long j11) {
            return this.f26310a.e(i11, j11);
        }

        @Override // com.google.android.exoplayer2.trackselection.h
        public void enable() {
            this.f26310a.enable();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f26310a.equals(aVar.f26310a) && this.f26311b.equals(aVar.f26311b);
        }

        @Override // com.google.android.exoplayer2.trackselection.h
        public int evaluateQueueSize(long j11, List list) {
            return this.f26310a.evaluateQueueSize(j11, list);
        }

        @Override // com.google.android.exoplayer2.trackselection.h
        public boolean f(long j11, v9.f fVar, List list) {
            return this.f26310a.f(j11, fVar, list);
        }

        @Override // la.m
        public int g(o1 o1Var) {
            return this.f26310a.g(o1Var);
        }

        @Override // la.m
        public o1 getFormat(int i11) {
            return this.f26310a.getFormat(i11);
        }

        @Override // la.m
        public int getIndexInTrackGroup(int i11) {
            return this.f26310a.getIndexInTrackGroup(i11);
        }

        @Override // com.google.android.exoplayer2.trackselection.h
        public o1 getSelectedFormat() {
            return this.f26310a.getSelectedFormat();
        }

        @Override // com.google.android.exoplayer2.trackselection.h
        public int getSelectedIndex() {
            return this.f26310a.getSelectedIndex();
        }

        @Override // com.google.android.exoplayer2.trackselection.h
        public int getSelectedIndexInTrackGroup() {
            return this.f26310a.getSelectedIndexInTrackGroup();
        }

        @Override // com.google.android.exoplayer2.trackselection.h
        public Object getSelectionData() {
            return this.f26310a.getSelectionData();
        }

        @Override // com.google.android.exoplayer2.trackselection.h
        public int getSelectionReason() {
            return this.f26310a.getSelectionReason();
        }

        @Override // la.m
        public TrackGroup getTrackGroup() {
            return this.f26311b;
        }

        public int hashCode() {
            return ((527 + this.f26311b.hashCode()) * 31) + this.f26310a.hashCode();
        }

        @Override // la.m
        public int indexOf(int i11) {
            return this.f26310a.indexOf(i11);
        }

        @Override // la.m
        public int length() {
            return this.f26310a.length();
        }

        @Override // com.google.android.exoplayer2.trackselection.h
        public void onPlaybackSpeed(float f11) {
            this.f26310a.onPlaybackSpeed(f11);
        }
    }

    /* loaded from: classes3.dex */
    private static final class b implements n, n.a {

        /* renamed from: a, reason: collision with root package name */
        private final n f26312a;

        /* renamed from: b, reason: collision with root package name */
        private final long f26313b;

        /* renamed from: c, reason: collision with root package name */
        private n.a f26314c;

        public b(n nVar, long j11) {
            this.f26312a = nVar;
            this.f26313b = j11;
        }

        @Override // com.google.android.exoplayer2.source.n
        public long a(long j11, c3 c3Var) {
            return this.f26312a.a(j11 - this.f26313b, c3Var) + this.f26313b;
        }

        @Override // com.google.android.exoplayer2.source.n
        public long b(com.google.android.exoplayer2.trackselection.h[] hVarArr, boolean[] zArr, t9.s[] sVarArr, boolean[] zArr2, long j11) {
            t9.s[] sVarArr2 = new t9.s[sVarArr.length];
            int i11 = 0;
            while (true) {
                t9.s sVar = null;
                if (i11 >= sVarArr.length) {
                    break;
                }
                c cVar = (c) sVarArr[i11];
                if (cVar != null) {
                    sVar = cVar.a();
                }
                sVarArr2[i11] = sVar;
                i11++;
            }
            long b11 = this.f26312a.b(hVarArr, zArr, sVarArr2, zArr2, j11 - this.f26313b);
            for (int i12 = 0; i12 < sVarArr.length; i12++) {
                t9.s sVar2 = sVarArr2[i12];
                if (sVar2 == null) {
                    sVarArr[i12] = null;
                } else {
                    t9.s sVar3 = sVarArr[i12];
                    if (sVar3 == null || ((c) sVar3).a() != sVar2) {
                        sVarArr[i12] = new c(sVar2, this.f26313b);
                    }
                }
            }
            return b11 + this.f26313b;
        }

        @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
        public boolean continueLoading(long j11) {
            return this.f26312a.continueLoading(j11 - this.f26313b);
        }

        @Override // com.google.android.exoplayer2.source.n
        public void discardBuffer(long j11, boolean z10) {
            this.f26312a.discardBuffer(j11 - this.f26313b, z10);
        }

        @Override // com.google.android.exoplayer2.source.n
        public void e(n.a aVar, long j11) {
            this.f26314c = aVar;
            this.f26312a.e(this, j11 - this.f26313b);
        }

        @Override // com.google.android.exoplayer2.source.b0.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void g(n nVar) {
            ((n.a) com.google.android.exoplayer2.util.a.e(this.f26314c)).g(this);
        }

        @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
        public long getBufferedPositionUs() {
            long bufferedPositionUs = this.f26312a.getBufferedPositionUs();
            if (bufferedPositionUs == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.f26313b + bufferedPositionUs;
        }

        @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
        public long getNextLoadPositionUs() {
            long nextLoadPositionUs = this.f26312a.getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.f26313b + nextLoadPositionUs;
        }

        @Override // com.google.android.exoplayer2.source.n
        public t9.x getTrackGroups() {
            return this.f26312a.getTrackGroups();
        }

        @Override // com.google.android.exoplayer2.source.n.a
        public void h(n nVar) {
            ((n.a) com.google.android.exoplayer2.util.a.e(this.f26314c)).h(this);
        }

        @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
        public boolean isLoading() {
            return this.f26312a.isLoading();
        }

        @Override // com.google.android.exoplayer2.source.n
        public void maybeThrowPrepareError() {
            this.f26312a.maybeThrowPrepareError();
        }

        @Override // com.google.android.exoplayer2.source.n
        public long readDiscontinuity() {
            long readDiscontinuity = this.f26312a.readDiscontinuity();
            return readDiscontinuity == C.TIME_UNSET ? C.TIME_UNSET : this.f26313b + readDiscontinuity;
        }

        @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
        public void reevaluateBuffer(long j11) {
            this.f26312a.reevaluateBuffer(j11 - this.f26313b);
        }

        @Override // com.google.android.exoplayer2.source.n
        public long seekToUs(long j11) {
            return this.f26312a.seekToUs(j11 - this.f26313b) + this.f26313b;
        }
    }

    /* loaded from: classes3.dex */
    private static final class c implements t9.s {

        /* renamed from: a, reason: collision with root package name */
        private final t9.s f26315a;

        /* renamed from: b, reason: collision with root package name */
        private final long f26316b;

        public c(t9.s sVar, long j11) {
            this.f26315a = sVar;
            this.f26316b = j11;
        }

        public t9.s a() {
            return this.f26315a;
        }

        @Override // t9.s
        public int c(p1 p1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            int c11 = this.f26315a.c(p1Var, decoderInputBuffer, i11);
            if (c11 == -4) {
                decoderInputBuffer.f24899e = Math.max(0L, decoderInputBuffer.f24899e + this.f26316b);
            }
            return c11;
        }

        @Override // t9.s
        public boolean isReady() {
            return this.f26315a.isReady();
        }

        @Override // t9.s
        public void maybeThrowError() {
            this.f26315a.maybeThrowError();
        }

        @Override // t9.s
        public int skipData(long j11) {
            return this.f26315a.skipData(j11 - this.f26316b);
        }
    }

    public q(t9.d dVar, long[] jArr, n... nVarArr) {
        this.f26303c = dVar;
        this.f26301a = nVarArr;
        this.f26309i = dVar.a(new b0[0]);
        for (int i11 = 0; i11 < nVarArr.length; i11++) {
            long j11 = jArr[i11];
            if (j11 != 0) {
                this.f26301a[i11] = new b(nVarArr[i11], j11);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.n
    public long a(long j11, c3 c3Var) {
        n[] nVarArr = this.f26308h;
        return (nVarArr.length > 0 ? nVarArr[0] : this.f26301a[0]).a(j11, c3Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    @Override // com.google.android.exoplayer2.source.n
    public long b(com.google.android.exoplayer2.trackselection.h[] hVarArr, boolean[] zArr, t9.s[] sVarArr, boolean[] zArr2, long j11) {
        t9.s sVar;
        int[] iArr = new int[hVarArr.length];
        int[] iArr2 = new int[hVarArr.length];
        int i11 = 0;
        while (true) {
            sVar = null;
            if (i11 >= hVarArr.length) {
                break;
            }
            t9.s sVar2 = sVarArr[i11];
            Integer num = sVar2 != null ? (Integer) this.f26302b.get(sVar2) : null;
            iArr[i11] = num == null ? -1 : num.intValue();
            iArr2[i11] = -1;
            com.google.android.exoplayer2.trackselection.h hVar = hVarArr[i11];
            if (hVar != null) {
                TrackGroup trackGroup = (TrackGroup) com.google.android.exoplayer2.util.a.e((TrackGroup) this.f26305e.get(hVar.getTrackGroup()));
                int i12 = 0;
                while (true) {
                    n[] nVarArr = this.f26301a;
                    if (i12 >= nVarArr.length) {
                        break;
                    }
                    if (nVarArr[i12].getTrackGroups().c(trackGroup) != -1) {
                        iArr2[i11] = i12;
                        break;
                    }
                    i12++;
                }
            }
            i11++;
        }
        this.f26302b.clear();
        int length = hVarArr.length;
        t9.s[] sVarArr2 = new t9.s[length];
        t9.s[] sVarArr3 = new t9.s[hVarArr.length];
        com.google.android.exoplayer2.trackselection.h[] hVarArr2 = new com.google.android.exoplayer2.trackselection.h[hVarArr.length];
        ArrayList arrayList = new ArrayList(this.f26301a.length);
        long j12 = j11;
        int i13 = 0;
        com.google.android.exoplayer2.trackselection.h[] hVarArr3 = hVarArr2;
        while (i13 < this.f26301a.length) {
            for (int i14 = 0; i14 < hVarArr.length; i14++) {
                sVarArr3[i14] = iArr[i14] == i13 ? sVarArr[i14] : sVar;
                if (iArr2[i14] == i13) {
                    com.google.android.exoplayer2.trackselection.h hVar2 = (com.google.android.exoplayer2.trackselection.h) com.google.android.exoplayer2.util.a.e(hVarArr[i14]);
                    hVarArr3[i14] = new a(hVar2, (TrackGroup) com.google.android.exoplayer2.util.a.e((TrackGroup) this.f26305e.get(hVar2.getTrackGroup())));
                } else {
                    hVarArr3[i14] = sVar;
                }
            }
            int i15 = i13;
            ArrayList arrayList2 = arrayList;
            com.google.android.exoplayer2.trackselection.h[] hVarArr4 = hVarArr3;
            long b11 = this.f26301a[i13].b(hVarArr3, zArr, sVarArr3, zArr2, j12);
            if (i15 == 0) {
                j12 = b11;
            } else if (b11 != j12) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z10 = false;
            for (int i16 = 0; i16 < hVarArr.length; i16++) {
                if (iArr2[i16] == i15) {
                    t9.s sVar3 = (t9.s) com.google.android.exoplayer2.util.a.e(sVarArr3[i16]);
                    sVarArr2[i16] = sVarArr3[i16];
                    this.f26302b.put(sVar3, Integer.valueOf(i15));
                    z10 = true;
                } else if (iArr[i16] == i15) {
                    com.google.android.exoplayer2.util.a.g(sVarArr3[i16] == null);
                }
            }
            if (z10) {
                arrayList2.add(this.f26301a[i15]);
            }
            i13 = i15 + 1;
            arrayList = arrayList2;
            hVarArr3 = hVarArr4;
            sVar = null;
        }
        System.arraycopy(sVarArr2, 0, sVarArr, 0, length);
        n[] nVarArr2 = (n[]) arrayList.toArray(new n[0]);
        this.f26308h = nVarArr2;
        this.f26309i = this.f26303c.a(nVarArr2);
        return j12;
    }

    public n c(int i11) {
        n nVar = this.f26301a[i11];
        return nVar instanceof b ? ((b) nVar).f26312a : nVar;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public boolean continueLoading(long j11) {
        if (this.f26304d.isEmpty()) {
            return this.f26309i.continueLoading(j11);
        }
        int size = this.f26304d.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((n) this.f26304d.get(i11)).continueLoading(j11);
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.n
    public void discardBuffer(long j11, boolean z10) {
        for (n nVar : this.f26308h) {
            nVar.discardBuffer(j11, z10);
        }
    }

    @Override // com.google.android.exoplayer2.source.n
    public void e(n.a aVar, long j11) {
        this.f26306f = aVar;
        Collections.addAll(this.f26304d, this.f26301a);
        for (n nVar : this.f26301a) {
            nVar.e(this, j11);
        }
    }

    @Override // com.google.android.exoplayer2.source.b0.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void g(n nVar) {
        ((n.a) com.google.android.exoplayer2.util.a.e(this.f26306f)).g(this);
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public long getBufferedPositionUs() {
        return this.f26309i.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public long getNextLoadPositionUs() {
        return this.f26309i.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.n
    public t9.x getTrackGroups() {
        return (t9.x) com.google.android.exoplayer2.util.a.e(this.f26307g);
    }

    @Override // com.google.android.exoplayer2.source.n.a
    public void h(n nVar) {
        this.f26304d.remove(nVar);
        if (!this.f26304d.isEmpty()) {
            return;
        }
        int i11 = 0;
        for (n nVar2 : this.f26301a) {
            i11 += nVar2.getTrackGroups().f76288a;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[i11];
        int i12 = 0;
        int i13 = 0;
        while (true) {
            n[] nVarArr = this.f26301a;
            if (i12 >= nVarArr.length) {
                this.f26307g = new t9.x(trackGroupArr);
                ((n.a) com.google.android.exoplayer2.util.a.e(this.f26306f)).h(this);
                return;
            }
            t9.x trackGroups = nVarArr[i12].getTrackGroups();
            int i14 = trackGroups.f76288a;
            int i15 = 0;
            while (i15 < i14) {
                TrackGroup b11 = trackGroups.b(i15);
                TrackGroup b12 = b11.b(i12 + ":" + b11.f25728b);
                this.f26305e.put(b12, b11);
                trackGroupArr[i13] = b12;
                i15++;
                i13++;
            }
            i12++;
        }
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public boolean isLoading() {
        return this.f26309i.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.n
    public void maybeThrowPrepareError() {
        for (n nVar : this.f26301a) {
            nVar.maybeThrowPrepareError();
        }
    }

    @Override // com.google.android.exoplayer2.source.n
    public long readDiscontinuity() {
        long j11 = -9223372036854775807L;
        for (n nVar : this.f26308h) {
            long readDiscontinuity = nVar.readDiscontinuity();
            if (readDiscontinuity != C.TIME_UNSET) {
                if (j11 == C.TIME_UNSET) {
                    for (n nVar2 : this.f26308h) {
                        if (nVar2 == nVar) {
                            break;
                        }
                        if (nVar2.seekToUs(readDiscontinuity) != readDiscontinuity) {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j11 = readDiscontinuity;
                } else if (readDiscontinuity != j11) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (j11 != C.TIME_UNSET && nVar.seekToUs(j11) != j11) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public void reevaluateBuffer(long j11) {
        this.f26309i.reevaluateBuffer(j11);
    }

    @Override // com.google.android.exoplayer2.source.n
    public long seekToUs(long j11) {
        long seekToUs = this.f26308h[0].seekToUs(j11);
        int i11 = 1;
        while (true) {
            n[] nVarArr = this.f26308h;
            if (i11 >= nVarArr.length) {
                return seekToUs;
            }
            if (nVarArr[i11].seekToUs(seekToUs) != seekToUs) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i11++;
        }
    }
}
