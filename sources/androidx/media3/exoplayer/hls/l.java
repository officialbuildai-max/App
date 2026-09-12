package androidx.media3.exoplayer.hls;

import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.x;
import androidx.media3.common.y;
import androidx.media3.exoplayer.c4;
import androidx.media3.exoplayer.drm.r;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.hls.playlist.d;
import androidx.media3.exoplayer.hls.r;
import androidx.media3.exoplayer.source.f0;
import androidx.media3.exoplayer.source.q;
import androidx.media3.exoplayer.source.s;
import androidx.media3.exoplayer.upstream.m;
import androidx.media3.exoplayer.v2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import g2.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import y1.f4;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l implements androidx.media3.exoplayer.source.q, HlsPlaylistTracker.b {

    /* renamed from: a, reason: collision with root package name */
    private final g f11840a;

    /* renamed from: b, reason: collision with root package name */
    private final HlsPlaylistTracker f11841b;

    /* renamed from: c, reason: collision with root package name */
    private final f f11842c;

    /* renamed from: d, reason: collision with root package name */
    private final w1.n f11843d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.media3.exoplayer.drm.t f11844e;

    /* renamed from: f, reason: collision with root package name */
    private final r.a f11845f;

    /* renamed from: g, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.m f11846g;

    /* renamed from: h, reason: collision with root package name */
    private final s.a f11847h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.b f11848i;

    /* renamed from: l, reason: collision with root package name */
    private final g2.e f11851l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f11852m;

    /* renamed from: n, reason: collision with root package name */
    private final int f11853n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f11854o;

    /* renamed from: p, reason: collision with root package name */
    private final f4 f11855p;

    /* renamed from: r, reason: collision with root package name */
    private final long f11857r;

    /* renamed from: s, reason: collision with root package name */
    private q.a f11858s;

    /* renamed from: t, reason: collision with root package name */
    private int f11859t;

    /* renamed from: u, reason: collision with root package name */
    private z f11860u;

    /* renamed from: y, reason: collision with root package name */
    private int f11864y;

    /* renamed from: z, reason: collision with root package name */
    private f0 f11865z;

    /* renamed from: q, reason: collision with root package name */
    private final r.b f11856q = new b();

    /* renamed from: j, reason: collision with root package name */
    private final IdentityHashMap f11849j = new IdentityHashMap();

    /* renamed from: k, reason: collision with root package name */
    private final t f11850k = new t();

    /* renamed from: v, reason: collision with root package name */
    private r[] f11861v = new r[0];

    /* renamed from: w, reason: collision with root package name */
    private r[] f11862w = new r[0];

    /* renamed from: x, reason: collision with root package name */
    private int[][] f11863x = new int[0];

    /* loaded from: classes2.dex */
    private class b implements r.b {
        private b() {
        }

        @Override // androidx.media3.exoplayer.source.f0.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void f(r rVar) {
            l.this.f11858s.f(l.this);
        }

        @Override // androidx.media3.exoplayer.hls.r.b
        public void d(Uri uri) {
            l.this.f11841b.d(uri);
        }

        @Override // androidx.media3.exoplayer.hls.r.b
        public void onPrepared() {
            if (l.h(l.this) > 0) {
                return;
            }
            int i11 = 0;
            for (r rVar : l.this.f11861v) {
                i11 += rVar.getTrackGroups().f63389a;
            }
            androidx.media3.common.f0[] f0VarArr = new androidx.media3.common.f0[i11];
            int i12 = 0;
            for (r rVar2 : l.this.f11861v) {
                int i13 = rVar2.getTrackGroups().f63389a;
                int i14 = 0;
                while (i14 < i13) {
                    f0VarArr[i12] = rVar2.getTrackGroups().b(i14);
                    i14++;
                    i12++;
                }
            }
            l.this.f11860u = new z(f0VarArr);
            l.this.f11858s.c(l.this);
        }
    }

    public l(g gVar, HlsPlaylistTracker hlsPlaylistTracker, f fVar, w1.n nVar, androidx.media3.exoplayer.upstream.f fVar2, androidx.media3.exoplayer.drm.t tVar, r.a aVar, androidx.media3.exoplayer.upstream.m mVar, s.a aVar2, androidx.media3.exoplayer.upstream.b bVar, g2.e eVar, boolean z10, int i11, boolean z11, f4 f4Var, long j11) {
        this.f11840a = gVar;
        this.f11841b = hlsPlaylistTracker;
        this.f11842c = fVar;
        this.f11843d = nVar;
        this.f11844e = tVar;
        this.f11845f = aVar;
        this.f11846g = mVar;
        this.f11847h = aVar2;
        this.f11848i = bVar;
        this.f11851l = eVar;
        this.f11852m = z10;
        this.f11853n = i11;
        this.f11854o = z11;
        this.f11855p = f4Var;
        this.f11857r = j11;
        this.f11865z = eVar.b();
    }

    static /* synthetic */ int h(l lVar) {
        int i11 = lVar.f11859t - 1;
        lVar.f11859t = i11;
        return i11;
    }

    private void m(long j11, List list, List list2, List list3, Map map) {
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i11 = 0; i11 < list.size(); i11++) {
            String str = ((d.a) list.get(i11)).f12028d;
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z10 = true;
                for (int i12 = 0; i12 < list.size(); i12++) {
                    if (Objects.equals(str, ((d.a) list.get(i12)).f12028d)) {
                        d.a aVar = (d.a) list.get(i12);
                        arrayList3.add(Integer.valueOf(i12));
                        arrayList.add(aVar.f12025a);
                        arrayList2.add(aVar.f12026b);
                        z10 &= a1.R(aVar.f12026b.f10239k, 1) == 1;
                    }
                }
                String str2 = "audio:" + str;
                r p11 = p(str2, 1, (Uri[]) arrayList.toArray((Uri[]) a1.j(new Uri[0])), (androidx.media3.common.r[]) arrayList2.toArray(new androidx.media3.common.r[0]), null, Collections.emptyList(), map, j11);
                list3.add(Ints.o(arrayList3));
                list2.add(p11);
                if (this.f11852m && z10) {
                    p11.V(new androidx.media3.common.f0[]{new androidx.media3.common.f0(str2, (androidx.media3.common.r[]) arrayList2.toArray(new androidx.media3.common.r[0]))}, 0, new int[0]);
                }
            }
        }
    }

    private void n(androidx.media3.exoplayer.hls.playlist.d dVar, long j11, List list, List list2, Map map) {
        int i11;
        boolean z10;
        boolean z11;
        int size = dVar.f12016e.size();
        int[] iArr = new int[size];
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < dVar.f12016e.size(); i14++) {
            androidx.media3.common.r rVar = ((d.b) dVar.f12016e.get(i14)).f12030b;
            if (rVar.f10251w > 0 || a1.S(rVar.f10239k, 2) != null) {
                iArr[i14] = 2;
                i12++;
            } else if (a1.S(rVar.f10239k, 1) != null) {
                iArr[i14] = 1;
                i13++;
            } else {
                iArr[i14] = -1;
            }
        }
        if (i12 > 0) {
            i11 = i12;
            z10 = true;
            z11 = false;
        } else if (i13 < size) {
            i11 = size - i13;
            z11 = true;
            z10 = false;
        } else {
            i11 = size;
            z10 = false;
            z11 = false;
        }
        Uri[] uriArr = new Uri[i11];
        androidx.media3.common.r[] rVarArr = new androidx.media3.common.r[i11];
        int[] iArr2 = new int[i11];
        int i15 = 0;
        for (int i16 = 0; i16 < dVar.f12016e.size(); i16++) {
            if ((!z10 || iArr[i16] == 2) && (!z11 || iArr[i16] != 1)) {
                d.b bVar = (d.b) dVar.f12016e.get(i16);
                uriArr[i15] = bVar.f12029a;
                rVarArr[i15] = bVar.f12030b;
                iArr2[i15] = i16;
                i15++;
            }
        }
        String str = rVarArr[0].f10239k;
        int R = a1.R(str, 2);
        int R2 = a1.R(str, 1);
        boolean z12 = (R2 == 1 || (R2 == 0 && dVar.f12018g.isEmpty())) && R <= 1 && R2 + R > 0;
        r p11 = p("main", (z10 || R2 <= 0) ? 0 : 1, uriArr, rVarArr, dVar.f12021j, dVar.f12022k, map, j11);
        list.add(p11);
        list2.add(iArr2);
        if (this.f11852m && z12) {
            ArrayList arrayList = new ArrayList();
            if (R > 0) {
                androidx.media3.common.r[] rVarArr2 = new androidx.media3.common.r[i11];
                for (int i17 = 0; i17 < i11; i17++) {
                    rVarArr2[i17] = s(rVarArr[i17]);
                }
                arrayList.add(new androidx.media3.common.f0("main", rVarArr2));
                if (R2 > 0 && (dVar.f12021j != null || dVar.f12018g.isEmpty())) {
                    arrayList.add(new androidx.media3.common.f0("main:audio", q(rVarArr[0], dVar.f12021j, false)));
                }
                List list3 = dVar.f12022k;
                if (list3 != null) {
                    for (int i18 = 0; i18 < list3.size(); i18++) {
                        arrayList.add(new androidx.media3.common.f0("main:cc:" + i18, this.f11840a.d((androidx.media3.common.r) list3.get(i18))));
                    }
                }
            } else {
                androidx.media3.common.r[] rVarArr3 = new androidx.media3.common.r[i11];
                for (int i19 = 0; i19 < i11; i19++) {
                    rVarArr3[i19] = q(rVarArr[i19], dVar.f12021j, true);
                }
                arrayList.add(new androidx.media3.common.f0("main", rVarArr3));
            }
            androidx.media3.common.f0 f0Var = new androidx.media3.common.f0("main:id3", new r.b().f0("ID3").u0(MimeTypes.APPLICATION_ID3).N());
            arrayList.add(f0Var);
            p11.V((androidx.media3.common.f0[]) arrayList.toArray(new androidx.media3.common.f0[0]), 0, arrayList.indexOf(f0Var));
        }
    }

    private void o(long j11) {
        int i11 = 0;
        int i12 = 1;
        androidx.media3.exoplayer.hls.playlist.d dVar = (androidx.media3.exoplayer.hls.playlist.d) androidx.media3.common.util.a.e(this.f11841b.c());
        Map r11 = this.f11854o ? r(dVar.f12024m) : Collections.emptyMap();
        boolean isEmpty = dVar.f12016e.isEmpty();
        List list = dVar.f12018g;
        List list2 = dVar.f12019h;
        this.f11859t = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!isEmpty) {
            n(dVar, j11, arrayList, arrayList2, r11);
        }
        m(j11, list, arrayList, arrayList2, r11);
        this.f11864y = arrayList.size();
        int i13 = 0;
        while (i13 < list2.size()) {
            d.a aVar = (d.a) list2.get(i13);
            String str = "subtitle:" + i13 + ":" + aVar.f12028d;
            androidx.media3.common.r rVar = aVar.f12026b;
            Uri[] uriArr = new Uri[i12];
            uriArr[i11] = aVar.f12025a;
            androidx.media3.common.r[] rVarArr = new androidx.media3.common.r[i12];
            rVarArr[i11] = rVar;
            ArrayList arrayList3 = arrayList2;
            int i14 = i13;
            r p11 = p(str, 3, uriArr, rVarArr, null, Collections.emptyList(), r11, j11);
            arrayList3.add(new int[]{i14});
            arrayList.add(p11);
            p11.V(new androidx.media3.common.f0[]{new androidx.media3.common.f0(str, this.f11840a.d(rVar))}, 0, new int[0]);
            i13 = i14 + 1;
            i11 = 0;
            arrayList2 = arrayList3;
            i12 = 1;
        }
        int i15 = i11;
        this.f11861v = (r[]) arrayList.toArray(new r[i15]);
        this.f11863x = (int[][]) arrayList2.toArray(new int[i15]);
        this.f11859t = this.f11861v.length;
        for (int i16 = i15; i16 < this.f11864y; i16++) {
            this.f11861v[i16].e0(true);
        }
        r[] rVarArr2 = this.f11861v;
        int length = rVarArr2.length;
        for (int i17 = i15; i17 < length; i17++) {
            rVarArr2[i17].r();
        }
        this.f11862w = this.f11861v;
    }

    private r p(String str, int i11, Uri[] uriArr, androidx.media3.common.r[] rVarArr, androidx.media3.common.r rVar, List list, Map map, long j11) {
        return new r(str, i11, this.f11856q, new e(this.f11840a, this.f11841b, uriArr, rVarArr, this.f11842c, this.f11843d, this.f11850k, this.f11857r, list, this.f11855p, null), map, this.f11848i, j11, rVar, this.f11844e, this.f11845f, this.f11846g, this.f11847h, this.f11853n);
    }

    private static androidx.media3.common.r q(androidx.media3.common.r rVar, androidx.media3.common.r rVar2, boolean z10) {
        x xVar;
        int i11;
        String str;
        int i12;
        int i13;
        String str2;
        String str3;
        List list;
        List of2 = ImmutableList.of();
        if (rVar2 != null) {
            str3 = rVar2.f10239k;
            xVar = rVar2.f10240l;
            i12 = rVar2.E;
            i11 = rVar2.f10233e;
            i13 = rVar2.f10234f;
            str = rVar2.f10232d;
            str2 = rVar2.f10230b;
            list = rVar2.f10231c;
        } else {
            String S = a1.S(rVar.f10239k, 1);
            xVar = rVar.f10240l;
            if (z10) {
                i12 = rVar.E;
                i11 = rVar.f10233e;
                i13 = rVar.f10234f;
                str = rVar.f10232d;
                str2 = rVar.f10230b;
                of2 = rVar.f10231c;
            } else {
                i11 = 0;
                str = null;
                i12 = -1;
                i13 = 0;
                str2 = null;
            }
            List list2 = of2;
            str3 = S;
            list = list2;
        }
        return new r.b().f0(rVar.f10229a).h0(str2).i0(list).U(rVar.f10242n).u0(y.g(str3)).S(str3).n0(xVar).Q(z10 ? rVar.f10236h : -1).p0(z10 ? rVar.f10237i : -1).R(i12).w0(i11).s0(i13).j0(str).N();
    }

    private static Map r(List list) {
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

    private static androidx.media3.common.r s(androidx.media3.common.r rVar) {
        String S = a1.S(rVar.f10239k, 2);
        return new r.b().f0(rVar.f10229a).h0(rVar.f10230b).i0(rVar.f10231c).U(rVar.f10242n).u0(y.g(S)).S(S).n0(rVar.f10240l).Q(rVar.f10236h).p0(rVar.f10237i).B0(rVar.f10250v).d0(rVar.f10251w).b0(rVar.f10252x).w0(rVar.f10233e).s0(rVar.f10234f).N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List t(r rVar) {
        return rVar.getTrackGroups().c();
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public boolean a(v2 v2Var) {
        if (this.f11860u != null) {
            return this.f11865z.a(v2Var);
        }
        for (r rVar : this.f11861v) {
            rVar.r();
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.source.q
    public long b(long j11, c4 c4Var) {
        for (r rVar : this.f11862w) {
            if (rVar.H()) {
                return rVar.b(j11, c4Var);
            }
        }
        return j11;
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker.b
    public void c() {
        for (r rVar : this.f11861v) {
            rVar.T();
        }
        this.f11858s.f(this);
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker.b
    public boolean d(Uri uri, m.c cVar, boolean z10) {
        boolean z11 = true;
        for (r rVar : this.f11861v) {
            z11 &= rVar.S(uri, cVar, z10);
        }
        this.f11858s.f(this);
        return z11;
    }

    @Override // androidx.media3.exoplayer.source.q
    public void discardBuffer(long j11, boolean z10) {
        for (r rVar : this.f11862w) {
            rVar.discardBuffer(j11, z10);
        }
    }

    @Override // androidx.media3.exoplayer.source.q
    public long e(j2.z[] zVarArr, boolean[] zArr, g2.u[] uVarArr, boolean[] zArr2, long j11) {
        g2.u[] uVarArr2 = uVarArr;
        int[] iArr = new int[zVarArr.length];
        int[] iArr2 = new int[zVarArr.length];
        for (int i11 = 0; i11 < zVarArr.length; i11++) {
            g2.u uVar = uVarArr2[i11];
            iArr[i11] = uVar == null ? -1 : ((Integer) this.f11849j.get(uVar)).intValue();
            iArr2[i11] = -1;
            j2.z zVar = zVarArr[i11];
            if (zVar != null) {
                androidx.media3.common.f0 trackGroup = zVar.getTrackGroup();
                int i12 = 0;
                while (true) {
                    r[] rVarArr = this.f11861v;
                    if (i12 >= rVarArr.length) {
                        break;
                    }
                    if (rVarArr[i12].getTrackGroups().d(trackGroup) != -1) {
                        iArr2[i11] = i12;
                        break;
                    }
                    i12++;
                }
            }
        }
        this.f11849j.clear();
        int length = zVarArr.length;
        g2.u[] uVarArr3 = new g2.u[length];
        g2.u[] uVarArr4 = new g2.u[zVarArr.length];
        j2.z[] zVarArr2 = new j2.z[zVarArr.length];
        r[] rVarArr2 = new r[this.f11861v.length];
        int i13 = 0;
        int i14 = 0;
        boolean z10 = false;
        while (i14 < this.f11861v.length) {
            for (int i15 = 0; i15 < zVarArr.length; i15++) {
                j2.z zVar2 = null;
                uVarArr4[i15] = iArr[i15] == i14 ? uVarArr2[i15] : null;
                if (iArr2[i15] == i14) {
                    zVar2 = zVarArr[i15];
                }
                zVarArr2[i15] = zVar2;
            }
            r rVar = this.f11861v[i14];
            int i16 = i13;
            int i17 = length;
            int i18 = i14;
            j2.z[] zVarArr3 = zVarArr2;
            r[] rVarArr3 = rVarArr2;
            boolean b02 = rVar.b0(zVarArr2, zArr, uVarArr4, zArr2, j11, z10);
            int i19 = 0;
            boolean z11 = false;
            while (true) {
                if (i19 >= zVarArr.length) {
                    break;
                }
                g2.u uVar2 = uVarArr4[i19];
                if (iArr2[i19] == i18) {
                    androidx.media3.common.util.a.e(uVar2);
                    uVarArr3[i19] = uVar2;
                    this.f11849j.put(uVar2, Integer.valueOf(i18));
                    z11 = true;
                } else if (iArr[i19] == i18) {
                    androidx.media3.common.util.a.g(uVar2 == null);
                }
                i19++;
            }
            if (z11) {
                rVarArr3[i16] = rVar;
                i13 = i16 + 1;
                if (i16 == 0) {
                    rVar.e0(true);
                    if (!b02) {
                        r[] rVarArr4 = this.f11862w;
                        if (rVarArr4.length != 0 && rVar == rVarArr4[0]) {
                        }
                    }
                    this.f11850k.b();
                    z10 = true;
                } else {
                    rVar.e0(i18 < this.f11864y);
                }
            } else {
                i13 = i16;
            }
            i14 = i18 + 1;
            uVarArr2 = uVarArr;
            rVarArr2 = rVarArr3;
            length = i17;
            zVarArr2 = zVarArr3;
        }
        System.arraycopy(uVarArr3, 0, uVarArr2, 0, length);
        r[] rVarArr5 = (r[]) a1.X0(rVarArr2, i13);
        this.f11862w = rVarArr5;
        ImmutableList copyOf = ImmutableList.copyOf(rVarArr5);
        this.f11865z = this.f11851l.a(copyOf, Lists.o(copyOf, new com.google.common.base.f() { // from class: androidx.media3.exoplayer.hls.k
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                List t11;
                t11 = l.t((r) obj);
                return t11;
            }
        }));
        return j11;
    }

    @Override // androidx.media3.exoplayer.source.q
    public void g(q.a aVar, long j11) {
        this.f11858s = aVar;
        this.f11841b.n(this);
        o(j11);
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public long getBufferedPositionUs() {
        return this.f11865z.getBufferedPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public long getNextLoadPositionUs() {
        return this.f11865z.getNextLoadPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.q
    public z getTrackGroups() {
        return (z) androidx.media3.common.util.a.e(this.f11860u);
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public boolean isLoading() {
        return this.f11865z.isLoading();
    }

    @Override // androidx.media3.exoplayer.source.q
    public void maybeThrowPrepareError() {
        for (r rVar : this.f11861v) {
            rVar.maybeThrowPrepareError();
        }
    }

    @Override // androidx.media3.exoplayer.source.q
    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public void reevaluateBuffer(long j11) {
        this.f11865z.reevaluateBuffer(j11);
    }

    @Override // androidx.media3.exoplayer.source.q
    public long seekToUs(long j11) {
        r[] rVarArr = this.f11862w;
        if (rVarArr.length > 0) {
            boolean a02 = rVarArr[0].a0(j11, false);
            int i11 = 1;
            while (true) {
                r[] rVarArr2 = this.f11862w;
                if (i11 >= rVarArr2.length) {
                    break;
                }
                rVarArr2[i11].a0(j11, a02);
                i11++;
            }
            if (a02) {
                this.f11850k.b();
            }
        }
        return j11;
    }

    public void u() {
        this.f11841b.m(this);
        for (r rVar : this.f11861v) {
            rVar.X();
        }
        this.f11858s = null;
    }
}
