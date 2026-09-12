package com.google.android.exoplayer2.source.smoothstreaming;

import com.google.android.exoplayer2.c3;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.trackselection.h;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.z;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import t9.d;
import t9.x;
import v9.i;

/* loaded from: classes3.dex */
final class c implements n, b0.a {

    /* renamed from: a, reason: collision with root package name */
    private final b.a f26617a;

    /* renamed from: b, reason: collision with root package name */
    private final k0 f26618b;

    /* renamed from: c, reason: collision with root package name */
    private final a0 f26619c;

    /* renamed from: d, reason: collision with root package name */
    private final u f26620d;

    /* renamed from: e, reason: collision with root package name */
    private final s.a f26621e;

    /* renamed from: f, reason: collision with root package name */
    private final z f26622f;

    /* renamed from: g, reason: collision with root package name */
    private final p.a f26623g;

    /* renamed from: h, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.b f26624h;

    /* renamed from: i, reason: collision with root package name */
    private final x f26625i;

    /* renamed from: j, reason: collision with root package name */
    private final d f26626j;

    /* renamed from: k, reason: collision with root package name */
    private n.a f26627k;

    /* renamed from: l, reason: collision with root package name */
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a f26628l;

    /* renamed from: m, reason: collision with root package name */
    private i[] f26629m;

    /* renamed from: n, reason: collision with root package name */
    private b0 f26630n;

    public c(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, b.a aVar2, k0 k0Var, d dVar, u uVar, s.a aVar3, z zVar, p.a aVar4, a0 a0Var, com.google.android.exoplayer2.upstream.b bVar) {
        this.f26628l = aVar;
        this.f26617a = aVar2;
        this.f26618b = k0Var;
        this.f26619c = a0Var;
        this.f26620d = uVar;
        this.f26621e = aVar3;
        this.f26622f = zVar;
        this.f26623g = aVar4;
        this.f26624h = bVar;
        this.f26626j = dVar;
        this.f26625i = f(aVar, uVar);
        i[] i11 = i(0);
        this.f26629m = i11;
        this.f26630n = dVar.a(i11);
    }

    private i c(h hVar, long j11) {
        int c11 = this.f26625i.c(hVar.getTrackGroup());
        return new i(this.f26628l.f26668f[c11].f26674a, null, null, this.f26617a.a(this.f26619c, this.f26628l, c11, hVar, this.f26618b), this, this.f26624h, j11, this.f26620d, this.f26621e, this.f26622f, this.f26623g);
    }

    private static x f(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, u uVar) {
        TrackGroup[] trackGroupArr = new TrackGroup[aVar.f26668f.length];
        int i11 = 0;
        while (true) {
            a.b[] bVarArr = aVar.f26668f;
            if (i11 >= bVarArr.length) {
                return new x(trackGroupArr);
            }
            o1[] o1VarArr = bVarArr[i11].f26683j;
            o1[] o1VarArr2 = new o1[o1VarArr.length];
            for (int i12 = 0; i12 < o1VarArr.length; i12++) {
                o1 o1Var = o1VarArr[i12];
                o1VarArr2[i12] = o1Var.c(uVar.a(o1Var));
            }
            trackGroupArr[i11] = new TrackGroup(Integer.toString(i11), o1VarArr2);
            i11++;
        }
    }

    private static i[] i(int i11) {
        return new i[i11];
    }

    @Override // com.google.android.exoplayer2.source.n
    public long a(long j11, c3 c3Var) {
        for (i iVar : this.f26629m) {
            if (iVar.f77266a == 2) {
                return iVar.a(j11, c3Var);
            }
        }
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.n
    public long b(h[] hVarArr, boolean[] zArr, t9.s[] sVarArr, boolean[] zArr2, long j11) {
        h hVar;
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < hVarArr.length; i11++) {
            t9.s sVar = sVarArr[i11];
            if (sVar != null) {
                i iVar = (i) sVar;
                if (hVarArr[i11] == null || !zArr[i11]) {
                    iVar.B();
                    sVarArr[i11] = null;
                } else {
                    ((b) iVar.q()).b(hVarArr[i11]);
                    arrayList.add(iVar);
                }
            }
            if (sVarArr[i11] == null && (hVar = hVarArr[i11]) != null) {
                i c11 = c(hVar, j11);
                arrayList.add(c11);
                sVarArr[i11] = c11;
                zArr2[i11] = true;
            }
        }
        i[] i12 = i(arrayList.size());
        this.f26629m = i12;
        arrayList.toArray(i12);
        this.f26630n = this.f26626j.a(this.f26629m);
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public boolean continueLoading(long j11) {
        return this.f26630n.continueLoading(j11);
    }

    @Override // com.google.android.exoplayer2.source.n
    public void discardBuffer(long j11, boolean z10) {
        for (i iVar : this.f26629m) {
            iVar.discardBuffer(j11, z10);
        }
    }

    @Override // com.google.android.exoplayer2.source.n
    public void e(n.a aVar, long j11) {
        this.f26627k = aVar;
        aVar.h(this);
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public long getBufferedPositionUs() {
        return this.f26630n.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public long getNextLoadPositionUs() {
        return this.f26630n.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.n
    public x getTrackGroups() {
        return this.f26625i;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public boolean isLoading() {
        return this.f26630n.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.b0.a
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void g(i iVar) {
        this.f26627k.g(this);
    }

    public void k() {
        for (i iVar : this.f26629m) {
            iVar.B();
        }
        this.f26627k = null;
    }

    public void l(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        this.f26628l = aVar;
        for (i iVar : this.f26629m) {
            ((b) iVar.q()).c(aVar);
        }
        this.f26627k.g(this);
    }

    @Override // com.google.android.exoplayer2.source.n
    public void maybeThrowPrepareError() {
        this.f26619c.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.n
    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public void reevaluateBuffer(long j11) {
        this.f26630n.reevaluateBuffer(j11);
    }

    @Override // com.google.android.exoplayer2.source.n
    public long seekToUs(long j11) {
        for (i iVar : this.f26629m) {
            iVar.E(j11);
        }
        return j11;
    }
}
