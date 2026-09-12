package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.c3;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.hls.p;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.e;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.w;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import e9.u1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import t9.x;

/* loaded from: classes3.dex */
public final class k implements com.google.android.exoplayer2.source.n, p.b, HlsPlaylistTracker.b {

    /* renamed from: a, reason: collision with root package name */
    private final g f26052a;

    /* renamed from: b, reason: collision with root package name */
    private final HlsPlaylistTracker f26053b;

    /* renamed from: c, reason: collision with root package name */
    private final f f26054c;

    /* renamed from: d, reason: collision with root package name */
    private final k0 f26055d;

    /* renamed from: e, reason: collision with root package name */
    private final u f26056e;

    /* renamed from: f, reason: collision with root package name */
    private final s.a f26057f;

    /* renamed from: g, reason: collision with root package name */
    private final z f26058g;

    /* renamed from: h, reason: collision with root package name */
    private final p.a f26059h;

    /* renamed from: i, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.b f26060i;

    /* renamed from: l, reason: collision with root package name */
    private final t9.d f26063l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f26064m;

    /* renamed from: n, reason: collision with root package name */
    private final int f26065n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f26066o;

    /* renamed from: p, reason: collision with root package name */
    private final u1 f26067p;

    /* renamed from: q, reason: collision with root package name */
    private n.a f26068q;

    /* renamed from: r, reason: collision with root package name */
    private int f26069r;

    /* renamed from: s, reason: collision with root package name */
    private x f26070s;

    /* renamed from: w, reason: collision with root package name */
    private int f26074w;

    /* renamed from: x, reason: collision with root package name */
    private b0 f26075x;

    /* renamed from: j, reason: collision with root package name */
    private final IdentityHashMap f26061j = new IdentityHashMap();

    /* renamed from: k, reason: collision with root package name */
    private final q f26062k = new q();

    /* renamed from: t, reason: collision with root package name */
    private p[] f26071t = new p[0];

    /* renamed from: u, reason: collision with root package name */
    private p[] f26072u = new p[0];

    /* renamed from: v, reason: collision with root package name */
    private int[][] f26073v = new int[0];

    public k(g gVar, HlsPlaylistTracker hlsPlaylistTracker, f fVar, k0 k0Var, u uVar, s.a aVar, z zVar, p.a aVar2, com.google.android.exoplayer2.upstream.b bVar, t9.d dVar, boolean z10, int i11, boolean z11, u1 u1Var) {
        this.f26052a = gVar;
        this.f26053b = hlsPlaylistTracker;
        this.f26054c = fVar;
        this.f26055d = k0Var;
        this.f26056e = uVar;
        this.f26057f = aVar;
        this.f26058g = zVar;
        this.f26059h = aVar2;
        this.f26060i = bVar;
        this.f26063l = dVar;
        this.f26064m = z10;
        this.f26065n = i11;
        this.f26066o = z11;
        this.f26067p = u1Var;
        this.f26075x = dVar.a(new b0[0]);
    }

    private void i(long j11, List list, List list2, List list3, Map map) {
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i11 = 0; i11 < list.size(); i11++) {
            String str = ((e.a) list.get(i11)).f26233d;
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z10 = true;
                for (int i12 = 0; i12 < list.size(); i12++) {
                    if (p0.c(str, ((e.a) list.get(i12)).f26233d)) {
                        e.a aVar = (e.a) list.get(i12);
                        arrayList3.add(Integer.valueOf(i12));
                        arrayList.add(aVar.f26230a);
                        arrayList2.add(aVar.f26231b);
                        z10 &= p0.K(aVar.f26231b.f25547i, 1) == 1;
                    }
                }
                String valueOf = String.valueOf(str);
                String concat = valueOf.length() != 0 ? "audio:".concat(valueOf) : new String("audio:");
                p l11 = l(concat, 1, (Uri[]) arrayList.toArray((Uri[]) p0.k(new Uri[0])), (o1[]) arrayList2.toArray(new o1[0]), null, Collections.emptyList(), map, j11);
                list3.add(Ints.o(arrayList3));
                list2.add(l11);
                if (this.f26064m && z10) {
                    l11.Q(new TrackGroup[]{new TrackGroup(concat, (o1[]) arrayList2.toArray(new o1[0]))}, 0, new int[0]);
                }
            }
        }
    }

    private void j(com.google.android.exoplayer2.source.hls.playlist.e eVar, long j11, List list, List list2, Map map) {
        boolean z10;
        boolean z11;
        int size = eVar.f26221e.size();
        int[] iArr = new int[size];
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < eVar.f26221e.size(); i13++) {
            o1 o1Var = ((e.b) eVar.f26221e.get(i13)).f26235b;
            if (o1Var.f25556r > 0 || p0.L(o1Var.f25547i, 2) != null) {
                iArr[i13] = 2;
                i11++;
            } else if (p0.L(o1Var.f25547i, 1) != null) {
                iArr[i13] = 1;
                i12++;
            } else {
                iArr[i13] = -1;
            }
        }
        if (i11 > 0) {
            z10 = true;
            size = i11;
            z11 = false;
        } else if (i12 < size) {
            size -= i12;
            z11 = true;
            z10 = false;
        } else {
            z10 = false;
            z11 = false;
        }
        Uri[] uriArr = new Uri[size];
        o1[] o1VarArr = new o1[size];
        int[] iArr2 = new int[size];
        int i14 = 0;
        for (int i15 = 0; i15 < eVar.f26221e.size(); i15++) {
            if ((!z10 || iArr[i15] == 2) && (!z11 || iArr[i15] != 1)) {
                e.b bVar = (e.b) eVar.f26221e.get(i15);
                uriArr[i14] = bVar.f26234a;
                o1VarArr[i14] = bVar.f26235b;
                iArr2[i14] = i15;
                i14++;
            }
        }
        String str = o1VarArr[0].f25547i;
        int K = p0.K(str, 2);
        int K2 = p0.K(str, 1);
        boolean z12 = K2 <= 1 && K <= 1 && K2 + K > 0;
        p l11 = l("main", (z10 || K2 <= 0) ? 0 : 1, uriArr, o1VarArr, eVar.f26226j, eVar.f26227k, map, j11);
        list.add(l11);
        list2.add(iArr2);
        if (this.f26064m && z12) {
            ArrayList arrayList = new ArrayList();
            if (K > 0) {
                o1[] o1VarArr2 = new o1[size];
                for (int i16 = 0; i16 < size; i16++) {
                    o1VarArr2[i16] = o(o1VarArr[i16]);
                }
                arrayList.add(new TrackGroup("main", o1VarArr2));
                if (K2 > 0 && (eVar.f26226j != null || eVar.f26223g.isEmpty())) {
                    arrayList.add(new TrackGroup("main".concat(":audio"), m(o1VarArr[0], eVar.f26226j, false)));
                }
                List list3 = eVar.f26227k;
                if (list3 != null) {
                    for (int i17 = 0; i17 < list3.size(); i17++) {
                        StringBuilder sb2 = new StringBuilder("main".length() + 15);
                        sb2.append("main");
                        sb2.append(":cc:");
                        sb2.append(i17);
                        arrayList.add(new TrackGroup(sb2.toString(), (o1) list3.get(i17)));
                    }
                }
            } else {
                o1[] o1VarArr3 = new o1[size];
                for (int i18 = 0; i18 < size; i18++) {
                    o1VarArr3[i18] = m(o1VarArr[i18], eVar.f26226j, true);
                }
                arrayList.add(new TrackGroup("main", o1VarArr3));
            }
            TrackGroup trackGroup = new TrackGroup("main".concat(":id3"), new o1.b().S("ID3").e0(MimeTypes.APPLICATION_ID3).E());
            arrayList.add(trackGroup);
            l11.Q((TrackGroup[]) arrayList.toArray(new TrackGroup[0]), 0, arrayList.indexOf(trackGroup));
        }
    }

    private void k(long j11) {
        int i11 = 0;
        int i12 = 1;
        com.google.android.exoplayer2.source.hls.playlist.e eVar = (com.google.android.exoplayer2.source.hls.playlist.e) com.google.android.exoplayer2.util.a.e(this.f26053b.c());
        Map n11 = this.f26066o ? n(eVar.f26229m) : Collections.emptyMap();
        boolean isEmpty = eVar.f26221e.isEmpty();
        List list = eVar.f26223g;
        List list2 = eVar.f26224h;
        this.f26069r = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!isEmpty) {
            j(eVar, j11, arrayList, arrayList2, n11);
        }
        i(j11, list, arrayList, arrayList2, n11);
        this.f26074w = arrayList.size();
        int i13 = 0;
        while (i13 < list2.size()) {
            e.a aVar = (e.a) list2.get(i13);
            String str = aVar.f26233d;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 21);
            sb2.append("subtitle:");
            sb2.append(i13);
            sb2.append(":");
            sb2.append(str);
            String sb3 = sb2.toString();
            Uri[] uriArr = new Uri[i12];
            uriArr[i11] = aVar.f26230a;
            o1[] o1VarArr = new o1[i12];
            o1VarArr[i11] = aVar.f26231b;
            ArrayList arrayList3 = arrayList2;
            int i14 = i13;
            p l11 = l(sb3, 3, uriArr, o1VarArr, null, Collections.emptyList(), n11, j11);
            arrayList3.add(new int[]{i14});
            arrayList.add(l11);
            l11.Q(new TrackGroup[]{new TrackGroup(sb3, aVar.f26231b)}, 0, new int[0]);
            i13 = i14 + 1;
            i11 = 0;
            arrayList2 = arrayList3;
            i12 = 1;
        }
        int i15 = i11;
        this.f26071t = (p[]) arrayList.toArray(new p[i15]);
        this.f26073v = (int[][]) arrayList2.toArray(new int[i15]);
        p[] pVarArr = this.f26071t;
        this.f26069r = pVarArr.length;
        pVarArr[i15].Z(true);
        p[] pVarArr2 = this.f26071t;
        int length = pVarArr2.length;
        while (i11 < length) {
            pVarArr2[i11].o();
            i11++;
        }
        this.f26072u = this.f26071t;
    }

    private p l(String str, int i11, Uri[] uriArr, o1[] o1VarArr, o1 o1Var, List list, Map map, long j11) {
        return new p(str, i11, this, new e(this.f26052a, this.f26053b, uriArr, o1VarArr, this.f26054c, this.f26055d, this.f26062k, list, this.f26067p), map, this.f26060i, j11, o1Var, this.f26056e, this.f26057f, this.f26058g, this.f26059h, this.f26065n);
    }

    private static o1 m(o1 o1Var, o1 o1Var2, boolean z10) {
        String L;
        Metadata metadata;
        int i11;
        String str;
        int i12;
        int i13;
        String str2;
        if (o1Var2 != null) {
            L = o1Var2.f25547i;
            metadata = o1Var2.f25548j;
            i12 = o1Var2.f25563y;
            i11 = o1Var2.f25542d;
            i13 = o1Var2.f25543e;
            str = o1Var2.f25541c;
            str2 = o1Var2.f25540b;
        } else {
            L = p0.L(o1Var.f25547i, 1);
            metadata = o1Var.f25548j;
            if (z10) {
                i12 = o1Var.f25563y;
                i11 = o1Var.f25542d;
                i13 = o1Var.f25543e;
                str = o1Var.f25541c;
                str2 = o1Var.f25540b;
            } else {
                i11 = 0;
                str = null;
                i12 = -1;
                i13 = 0;
                str2 = null;
            }
        }
        return new o1.b().S(o1Var.f25539a).U(str2).K(o1Var.f25549k).e0(w.g(L)).I(L).X(metadata).G(z10 ? o1Var.f25544f : -1).Z(z10 ? o1Var.f25545g : -1).H(i12).g0(i11).c0(i13).V(str).E();
    }

    private static Map n(List list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap hashMap = new HashMap();
        int i11 = 0;
        while (i11 < arrayList.size()) {
            DrmInitData drmInitData = (DrmInitData) list.get(i11);
            String str = drmInitData.schemeType;
            i11++;
            int i12 = i11;
            while (i12 < arrayList.size()) {
                DrmInitData drmInitData2 = (DrmInitData) arrayList.get(i12);
                if (TextUtils.equals(drmInitData2.schemeType, str)) {
                    drmInitData = drmInitData.merge(drmInitData2);
                    arrayList.remove(i12);
                } else {
                    i12++;
                }
            }
            hashMap.put(str, drmInitData);
        }
        return hashMap;
    }

    private static o1 o(o1 o1Var) {
        String L = p0.L(o1Var.f25547i, 2);
        return new o1.b().S(o1Var.f25539a).U(o1Var.f25540b).K(o1Var.f25549k).e0(w.g(L)).I(L).X(o1Var.f25548j).G(o1Var.f25544f).Z(o1Var.f25545g).j0(o1Var.f25555q).Q(o1Var.f25556r).P(o1Var.f25557s).g0(o1Var.f25542d).c0(o1Var.f25543e).E();
    }

    @Override // com.google.android.exoplayer2.source.n
    public long a(long j11, c3 c3Var) {
        for (p pVar : this.f26072u) {
            if (pVar.E()) {
                return pVar.a(j11, c3Var);
            }
        }
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.n
    public long b(com.google.android.exoplayer2.trackselection.h[] hVarArr, boolean[] zArr, t9.s[] sVarArr, boolean[] zArr2, long j11) {
        t9.s[] sVarArr2 = sVarArr;
        int[] iArr = new int[hVarArr.length];
        int[] iArr2 = new int[hVarArr.length];
        for (int i11 = 0; i11 < hVarArr.length; i11++) {
            t9.s sVar = sVarArr2[i11];
            iArr[i11] = sVar == null ? -1 : ((Integer) this.f26061j.get(sVar)).intValue();
            iArr2[i11] = -1;
            com.google.android.exoplayer2.trackselection.h hVar = hVarArr[i11];
            if (hVar != null) {
                TrackGroup trackGroup = hVar.getTrackGroup();
                int i12 = 0;
                while (true) {
                    p[] pVarArr = this.f26071t;
                    if (i12 >= pVarArr.length) {
                        break;
                    }
                    if (pVarArr[i12].getTrackGroups().c(trackGroup) != -1) {
                        iArr2[i11] = i12;
                        break;
                    }
                    i12++;
                }
            }
        }
        this.f26061j.clear();
        int length = hVarArr.length;
        t9.s[] sVarArr3 = new t9.s[length];
        t9.s[] sVarArr4 = new t9.s[hVarArr.length];
        com.google.android.exoplayer2.trackselection.h[] hVarArr2 = new com.google.android.exoplayer2.trackselection.h[hVarArr.length];
        p[] pVarArr2 = new p[this.f26071t.length];
        int i13 = 0;
        int i14 = 0;
        boolean z10 = false;
        while (i14 < this.f26071t.length) {
            for (int i15 = 0; i15 < hVarArr.length; i15++) {
                com.google.android.exoplayer2.trackselection.h hVar2 = null;
                sVarArr4[i15] = iArr[i15] == i14 ? sVarArr2[i15] : null;
                if (iArr2[i15] == i14) {
                    hVar2 = hVarArr[i15];
                }
                hVarArr2[i15] = hVar2;
            }
            p pVar = this.f26071t[i14];
            int i16 = i13;
            int i17 = length;
            int i18 = i14;
            com.google.android.exoplayer2.trackselection.h[] hVarArr3 = hVarArr2;
            p[] pVarArr3 = pVarArr2;
            boolean W = pVar.W(hVarArr2, zArr, sVarArr4, zArr2, j11, z10);
            int i19 = 0;
            boolean z11 = false;
            while (true) {
                if (i19 >= hVarArr.length) {
                    break;
                }
                t9.s sVar2 = sVarArr4[i19];
                if (iArr2[i19] == i18) {
                    com.google.android.exoplayer2.util.a.e(sVar2);
                    sVarArr3[i19] = sVar2;
                    this.f26061j.put(sVar2, Integer.valueOf(i18));
                    z11 = true;
                } else if (iArr[i19] == i18) {
                    com.google.android.exoplayer2.util.a.g(sVar2 == null);
                }
                i19++;
            }
            if (z11) {
                pVarArr3[i16] = pVar;
                i13 = i16 + 1;
                if (i16 == 0) {
                    pVar.Z(true);
                    if (!W) {
                        p[] pVarArr4 = this.f26072u;
                        if (pVarArr4.length != 0 && pVar == pVarArr4[0]) {
                        }
                    }
                    this.f26062k.b();
                    z10 = true;
                } else {
                    pVar.Z(i18 < this.f26074w);
                }
            } else {
                i13 = i16;
            }
            i14 = i18 + 1;
            sVarArr2 = sVarArr;
            pVarArr2 = pVarArr3;
            length = i17;
            hVarArr2 = hVarArr3;
        }
        System.arraycopy(sVarArr3, 0, sVarArr2, 0, length);
        p[] pVarArr5 = (p[]) p0.G0(pVarArr2, i13);
        this.f26072u = pVarArr5;
        this.f26075x = this.f26063l.a(pVarArr5);
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void c() {
        for (p pVar : this.f26071t) {
            pVar.O();
        }
        this.f26068q.g(this);
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public boolean continueLoading(long j11) {
        if (this.f26070s != null) {
            return this.f26075x.continueLoading(j11);
        }
        for (p pVar : this.f26071t) {
            pVar.o();
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.hls.p.b
    public void d(Uri uri) {
        this.f26053b.d(uri);
    }

    @Override // com.google.android.exoplayer2.source.n
    public void discardBuffer(long j11, boolean z10) {
        for (p pVar : this.f26072u) {
            pVar.discardBuffer(j11, z10);
        }
    }

    @Override // com.google.android.exoplayer2.source.n
    public void e(n.a aVar, long j11) {
        this.f26068q = aVar;
        this.f26053b.m(this);
        k(j11);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public boolean f(Uri uri, z.c cVar, boolean z10) {
        boolean z11 = true;
        for (p pVar : this.f26071t) {
            z11 &= pVar.N(uri, cVar, z10);
        }
        this.f26068q.g(this);
        return z11;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public long getBufferedPositionUs() {
        return this.f26075x.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public long getNextLoadPositionUs() {
        return this.f26075x.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.n
    public x getTrackGroups() {
        return (x) com.google.android.exoplayer2.util.a.e(this.f26070s);
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public boolean isLoading() {
        return this.f26075x.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.n
    public void maybeThrowPrepareError() {
        for (p pVar : this.f26071t) {
            pVar.maybeThrowPrepareError();
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.p.b
    public void onPrepared() {
        int i11 = this.f26069r - 1;
        this.f26069r = i11;
        if (i11 > 0) {
            return;
        }
        int i12 = 0;
        for (p pVar : this.f26071t) {
            i12 += pVar.getTrackGroups().f76288a;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[i12];
        int i13 = 0;
        for (p pVar2 : this.f26071t) {
            int i14 = pVar2.getTrackGroups().f76288a;
            int i15 = 0;
            while (i15 < i14) {
                trackGroupArr[i13] = pVar2.getTrackGroups().b(i15);
                i15++;
                i13++;
            }
        }
        this.f26070s = new x(trackGroupArr);
        this.f26068q.h(this);
    }

    @Override // com.google.android.exoplayer2.source.b0.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void g(p pVar) {
        this.f26068q.g(this);
    }

    public void q() {
        this.f26053b.k(this);
        for (p pVar : this.f26071t) {
            pVar.S();
        }
        this.f26068q = null;
    }

    @Override // com.google.android.exoplayer2.source.n
    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public void reevaluateBuffer(long j11) {
        this.f26075x.reevaluateBuffer(j11);
    }

    @Override // com.google.android.exoplayer2.source.n
    public long seekToUs(long j11) {
        p[] pVarArr = this.f26072u;
        if (pVarArr.length > 0) {
            boolean V = pVarArr[0].V(j11, false);
            int i11 = 1;
            while (true) {
                p[] pVarArr2 = this.f26072u;
                if (i11 >= pVarArr2.length) {
                    break;
                }
                pVarArr2[i11].V(j11, V);
                i11++;
            }
            if (V) {
                this.f26062k.b();
            }
        }
        return j11;
    }
}
