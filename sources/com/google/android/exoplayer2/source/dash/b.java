package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.c3;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.e;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.trackselection.h;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.p0;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import e9.u1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import t9.x;
import v9.i;
import x9.f;
import x9.g;
import x9.j;

/* loaded from: classes3.dex */
final class b implements n, b0.a, i.b {

    /* renamed from: y, reason: collision with root package name */
    private static final Pattern f25869y = Pattern.compile("CC([1-4])=(.+)");

    /* renamed from: z, reason: collision with root package name */
    private static final Pattern f25870z = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");

    /* renamed from: a, reason: collision with root package name */
    final int f25871a;

    /* renamed from: b, reason: collision with root package name */
    private final a.InterfaceC0370a f25872b;

    /* renamed from: c, reason: collision with root package name */
    private final k0 f25873c;

    /* renamed from: d, reason: collision with root package name */
    private final u f25874d;

    /* renamed from: e, reason: collision with root package name */
    private final z f25875e;

    /* renamed from: f, reason: collision with root package name */
    private final w9.b f25876f;

    /* renamed from: g, reason: collision with root package name */
    private final long f25877g;

    /* renamed from: h, reason: collision with root package name */
    private final a0 f25878h;

    /* renamed from: i, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.b f25879i;

    /* renamed from: j, reason: collision with root package name */
    private final x f25880j;

    /* renamed from: k, reason: collision with root package name */
    private final a[] f25881k;

    /* renamed from: l, reason: collision with root package name */
    private final t9.d f25882l;

    /* renamed from: m, reason: collision with root package name */
    private final e f25883m;

    /* renamed from: o, reason: collision with root package name */
    private final p.a f25885o;

    /* renamed from: p, reason: collision with root package name */
    private final s.a f25886p;

    /* renamed from: q, reason: collision with root package name */
    private final u1 f25887q;

    /* renamed from: r, reason: collision with root package name */
    private n.a f25888r;

    /* renamed from: u, reason: collision with root package name */
    private b0 f25891u;

    /* renamed from: v, reason: collision with root package name */
    private x9.c f25892v;

    /* renamed from: w, reason: collision with root package name */
    private int f25893w;

    /* renamed from: x, reason: collision with root package name */
    private List f25894x;

    /* renamed from: s, reason: collision with root package name */
    private i[] f25889s = u(0);

    /* renamed from: t, reason: collision with root package name */
    private d[] f25890t = new d[0];

    /* renamed from: n, reason: collision with root package name */
    private final IdentityHashMap f25884n = new IdentityHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f25895a;

        /* renamed from: b, reason: collision with root package name */
        public final int f25896b;

        /* renamed from: c, reason: collision with root package name */
        public final int f25897c;

        /* renamed from: d, reason: collision with root package name */
        public final int f25898d;

        /* renamed from: e, reason: collision with root package name */
        public final int f25899e;

        /* renamed from: f, reason: collision with root package name */
        public final int f25900f;

        /* renamed from: g, reason: collision with root package name */
        public final int f25901g;

        private a(int i11, int i12, int[] iArr, int i13, int i14, int i15, int i16) {
            this.f25896b = i11;
            this.f25895a = iArr;
            this.f25897c = i12;
            this.f25899e = i13;
            this.f25900f = i14;
            this.f25901g = i15;
            this.f25898d = i16;
        }

        public static a a(int[] iArr, int i11) {
            return new a(3, 1, iArr, i11, -1, -1, -1);
        }

        public static a b(int[] iArr, int i11) {
            return new a(5, 1, iArr, i11, -1, -1, -1);
        }

        public static a c(int i11) {
            return new a(5, 2, new int[0], -1, -1, -1, i11);
        }

        public static a d(int i11, int[] iArr, int i12, int i13, int i14) {
            return new a(i11, 0, iArr, i12, i13, i14, -1);
        }
    }

    public b(int i11, x9.c cVar, w9.b bVar, int i12, a.InterfaceC0370a interfaceC0370a, k0 k0Var, u uVar, s.a aVar, z zVar, p.a aVar2, long j11, a0 a0Var, com.google.android.exoplayer2.upstream.b bVar2, t9.d dVar, e.b bVar3, u1 u1Var) {
        this.f25871a = i11;
        this.f25892v = cVar;
        this.f25876f = bVar;
        this.f25893w = i12;
        this.f25872b = interfaceC0370a;
        this.f25873c = k0Var;
        this.f25874d = uVar;
        this.f25886p = aVar;
        this.f25875e = zVar;
        this.f25885o = aVar2;
        this.f25877g = j11;
        this.f25878h = a0Var;
        this.f25879i = bVar2;
        this.f25882l = dVar;
        this.f25887q = u1Var;
        this.f25883m = new e(cVar, bVar3, bVar2);
        this.f25891u = dVar.a(this.f25889s);
        g c11 = cVar.c(i12);
        List list = c11.f78222d;
        this.f25894x = list;
        Pair k11 = k(uVar, c11.f78221c, list);
        this.f25880j = (x) k11.first;
        this.f25881k = (a[]) k11.second;
    }

    private void A(h[] hVarArr, t9.s[] sVarArr, boolean[] zArr, long j11, int[] iArr) {
        for (int i11 = 0; i11 < hVarArr.length; i11++) {
            h hVar = hVarArr[i11];
            if (hVar != null) {
                t9.s sVar = sVarArr[i11];
                if (sVar == null) {
                    zArr[i11] = true;
                    a aVar = this.f25881k[iArr[i11]];
                    int i12 = aVar.f25897c;
                    if (i12 == 0) {
                        sVarArr[i11] = j(aVar, hVar, j11);
                    } else if (i12 == 2) {
                        sVarArr[i11] = new d((f) this.f25894x.get(aVar.f25898d), hVar.getTrackGroup().c(0), this.f25892v.f78187d);
                    }
                } else if (sVar instanceof i) {
                    ((com.google.android.exoplayer2.source.dash.a) ((i) sVar).q()).b(hVar);
                }
            }
        }
        for (int i13 = 0; i13 < hVarArr.length; i13++) {
            if (sVarArr[i13] == null && hVarArr[i13] != null) {
                a aVar2 = this.f25881k[iArr[i13]];
                if (aVar2.f25897c == 1) {
                    int q11 = q(i13, iArr);
                    if (q11 == -1) {
                        sVarArr[i13] = new t9.g();
                    } else {
                        sVarArr[i13] = ((i) sVarArr[q11]).F(j11, aVar2.f25896b);
                    }
                }
            }
        }
    }

    private static void f(List list, TrackGroup[] trackGroupArr, a[] aVarArr, int i11) {
        int i12 = 0;
        while (i12 < list.size()) {
            f fVar = (f) list.get(i12);
            o1 E = new o1.b().S(fVar.a()).e0(MimeTypes.APPLICATION_EMSG).E();
            String a11 = fVar.a();
            StringBuilder sb2 = new StringBuilder(String.valueOf(a11).length() + 12);
            sb2.append(a11);
            sb2.append(":");
            sb2.append(i12);
            trackGroupArr[i11] = new TrackGroup(sb2.toString(), E);
            aVarArr[i11] = a.c(i12);
            i12++;
            i11++;
        }
    }

    private static int i(u uVar, List list, int[][] iArr, int i11, boolean[] zArr, o1[][] o1VarArr, TrackGroup[] trackGroupArr, a[] aVarArr) {
        String sb2;
        int i12;
        int i13;
        int i14;
        int i15 = 0;
        int i16 = 0;
        while (i15 < i11) {
            int[] iArr2 = iArr[i15];
            ArrayList arrayList = new ArrayList();
            for (int i17 : iArr2) {
                arrayList.addAll(((x9.a) list.get(i17)).f78176c);
            }
            int size = arrayList.size();
            o1[] o1VarArr2 = new o1[size];
            for (int i18 = 0; i18 < size; i18++) {
                o1 o1Var = ((j) arrayList.get(i18)).f78234b;
                o1VarArr2[i18] = o1Var.c(uVar.a(o1Var));
            }
            x9.a aVar = (x9.a) list.get(iArr2[0]);
            int i19 = aVar.f78174a;
            if (i19 != -1) {
                sb2 = Integer.toString(i19);
            } else {
                StringBuilder sb3 = new StringBuilder(17);
                sb3.append("unset:");
                sb3.append(i15);
                sb2 = sb3.toString();
            }
            int i20 = i16 + 1;
            if (zArr[i15]) {
                i12 = i16 + 2;
            } else {
                i12 = i20;
                i20 = -1;
            }
            if (o1VarArr[i15].length != 0) {
                i13 = i12 + 1;
            } else {
                i13 = i12;
                i12 = -1;
            }
            trackGroupArr[i16] = new TrackGroup(sb2, o1VarArr2);
            aVarArr[i16] = a.d(aVar.f78175b, iArr2, i16, i20, i12);
            if (i20 != -1) {
                String concat = String.valueOf(sb2).concat(":emsg");
                trackGroupArr[i20] = new TrackGroup(concat, new o1.b().S(concat).e0(MimeTypes.APPLICATION_EMSG).E());
                aVarArr[i20] = a.b(iArr2, i16);
                i14 = -1;
            } else {
                i14 = -1;
            }
            if (i12 != i14) {
                trackGroupArr[i12] = new TrackGroup(String.valueOf(sb2).concat(":cc"), o1VarArr[i15]);
                aVarArr[i12] = a.a(iArr2, i16);
            }
            i15++;
            i16 = i13;
        }
        return i16;
    }

    private i j(a aVar, h hVar, long j11) {
        int i11;
        TrackGroup trackGroup;
        TrackGroup trackGroup2;
        int i12;
        int i13 = aVar.f25900f;
        boolean z10 = i13 != -1;
        e.c cVar = null;
        if (z10) {
            trackGroup = this.f25880j.b(i13);
            i11 = 1;
        } else {
            i11 = 0;
            trackGroup = null;
        }
        int i14 = aVar.f25901g;
        boolean z11 = i14 != -1;
        if (z11) {
            trackGroup2 = this.f25880j.b(i14);
            i11 += trackGroup2.f25727a;
        } else {
            trackGroup2 = null;
        }
        o1[] o1VarArr = new o1[i11];
        int[] iArr = new int[i11];
        if (z10) {
            o1VarArr[0] = trackGroup.c(0);
            iArr[0] = 5;
            i12 = 1;
        } else {
            i12 = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (z11) {
            for (int i15 = 0; i15 < trackGroup2.f25727a; i15++) {
                o1 c11 = trackGroup2.c(i15);
                o1VarArr[i12] = c11;
                iArr[i12] = 3;
                arrayList.add(c11);
                i12++;
            }
        }
        if (this.f25892v.f78187d && z10) {
            cVar = this.f25883m.k();
        }
        e.c cVar2 = cVar;
        i iVar = new i(aVar.f25896b, iArr, o1VarArr, this.f25872b.a(this.f25878h, this.f25892v, this.f25876f, this.f25893w, aVar.f25895a, hVar, aVar.f25896b, this.f25877g, z10, arrayList, cVar2, this.f25873c, this.f25887q), this, this.f25879i, j11, this.f25874d, this.f25886p, this.f25875e, this.f25885o);
        synchronized (this) {
            this.f25884n.put(iVar, cVar2);
        }
        return iVar;
    }

    private static Pair k(u uVar, List list, List list2) {
        int[][] p11 = p(list);
        int length = p11.length;
        boolean[] zArr = new boolean[length];
        o1[][] o1VarArr = new o1[length];
        int t11 = t(length, list, p11, zArr, o1VarArr) + length + list2.size();
        TrackGroup[] trackGroupArr = new TrackGroup[t11];
        a[] aVarArr = new a[t11];
        f(list2, trackGroupArr, aVarArr, i(uVar, list, p11, length, zArr, o1VarArr, trackGroupArr, aVarArr));
        return Pair.create(new x(trackGroupArr), aVarArr);
    }

    private static x9.e l(List list) {
        return m(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    private static x9.e m(List list, String str) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            x9.e eVar = (x9.e) list.get(i11);
            if (str.equals(eVar.f78211a)) {
                return eVar;
            }
        }
        return null;
    }

    private static x9.e n(List list) {
        return m(list, "http://dashif.org/guidelines/trickmode");
    }

    private static o1[] o(List list, int[] iArr) {
        for (int i11 : iArr) {
            x9.a aVar = (x9.a) list.get(i11);
            List list2 = ((x9.a) list.get(i11)).f78177d;
            for (int i12 = 0; i12 < list2.size(); i12++) {
                x9.e eVar = (x9.e) list2.get(i12);
                if ("urn:scte:dash:cc:cea-608:2015".equals(eVar.f78211a)) {
                    o1.b e02 = new o1.b().e0(MimeTypes.APPLICATION_CEA608);
                    int i13 = aVar.f78174a;
                    StringBuilder sb2 = new StringBuilder(18);
                    sb2.append(i13);
                    sb2.append(":cea608");
                    return w(eVar, f25869y, e02.S(sb2.toString()).E());
                }
                if ("urn:scte:dash:cc:cea-708:2015".equals(eVar.f78211a)) {
                    o1.b e03 = new o1.b().e0(MimeTypes.APPLICATION_CEA708);
                    int i14 = aVar.f78174a;
                    StringBuilder sb3 = new StringBuilder(18);
                    sb3.append(i14);
                    sb3.append(":cea708");
                    return w(eVar, f25870z, e03.S(sb3.toString()).E());
                }
            }
        }
        return new o1[0];
    }

    private static int[][] p(List list) {
        int i11;
        x9.e l11;
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i12 = 0; i12 < size; i12++) {
            sparseIntArray.put(((x9.a) list.get(i12)).f78174a, i12);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i12));
            arrayList.add(arrayList2);
            sparseArray.put(i12, arrayList2);
        }
        for (int i13 = 0; i13 < size; i13++) {
            x9.a aVar = (x9.a) list.get(i13);
            x9.e n11 = n(aVar.f78178e);
            if (n11 == null) {
                n11 = n(aVar.f78179f);
            }
            if (n11 == null || (i11 = sparseIntArray.get(Integer.parseInt(n11.f78212b), -1)) == -1) {
                i11 = i13;
            }
            if (i11 == i13 && (l11 = l(aVar.f78179f)) != null) {
                for (String str : p0.S0(l11.f78212b, ",")) {
                    int i14 = sparseIntArray.get(Integer.parseInt(str), -1);
                    if (i14 != -1) {
                        i11 = Math.min(i11, i14);
                    }
                }
            }
            if (i11 != i13) {
                List list2 = (List) sparseArray.get(i13);
                List list3 = (List) sparseArray.get(i11);
                list3.addAll(list2);
                sparseArray.put(i13, list3);
                arrayList.remove(list2);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2];
        for (int i15 = 0; i15 < size2; i15++) {
            int[] o11 = Ints.o((Collection) arrayList.get(i15));
            iArr[i15] = o11;
            Arrays.sort(o11);
        }
        return iArr;
    }

    private int q(int i11, int[] iArr) {
        int i12 = iArr[i11];
        if (i12 == -1) {
            return -1;
        }
        int i13 = this.f25881k[i12].f25899e;
        for (int i14 = 0; i14 < iArr.length; i14++) {
            int i15 = iArr[i14];
            if (i15 == i13 && this.f25881k[i15].f25897c == 0) {
                return i14;
            }
        }
        return -1;
    }

    private int[] r(h[] hVarArr) {
        int[] iArr = new int[hVarArr.length];
        for (int i11 = 0; i11 < hVarArr.length; i11++) {
            h hVar = hVarArr[i11];
            if (hVar != null) {
                iArr[i11] = this.f25880j.c(hVar.getTrackGroup());
            } else {
                iArr[i11] = -1;
            }
        }
        return iArr;
    }

    private static boolean s(List list, int[] iArr) {
        for (int i11 : iArr) {
            List list2 = ((x9.a) list.get(i11)).f78176c;
            for (int i12 = 0; i12 < list2.size(); i12++) {
                if (!((j) list2.get(i12)).f78237e.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int t(int i11, List list, int[][] iArr, boolean[] zArr, o1[][] o1VarArr) {
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            if (s(list, iArr[i13])) {
                zArr[i13] = true;
                i12++;
            }
            o1[] o11 = o(list, iArr[i13]);
            o1VarArr[i13] = o11;
            if (o11.length != 0) {
                i12++;
            }
        }
        return i12;
    }

    private static i[] u(int i11) {
        return new i[i11];
    }

    private static o1[] w(x9.e eVar, Pattern pattern, o1 o1Var) {
        String str = eVar.f78212b;
        if (str == null) {
            return new o1[]{o1Var};
        }
        String[] S0 = p0.S0(str, ";");
        o1[] o1VarArr = new o1[S0.length];
        for (int i11 = 0; i11 < S0.length; i11++) {
            Matcher matcher = pattern.matcher(S0[i11]);
            if (!matcher.matches()) {
                return new o1[]{o1Var};
            }
            int parseInt = Integer.parseInt(matcher.group(1));
            o1.b b11 = o1Var.b();
            String str2 = o1Var.f25539a;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 12);
            sb2.append(str2);
            sb2.append(":");
            sb2.append(parseInt);
            o1VarArr[i11] = b11.S(sb2.toString()).F(parseInt).V(matcher.group(2)).E();
        }
        return o1VarArr;
    }

    private void y(h[] hVarArr, boolean[] zArr, t9.s[] sVarArr) {
        for (int i11 = 0; i11 < hVarArr.length; i11++) {
            if (hVarArr[i11] == null || !zArr[i11]) {
                t9.s sVar = sVarArr[i11];
                if (sVar instanceof i) {
                    ((i) sVar).C(this);
                } else if (sVar instanceof i.a) {
                    ((i.a) sVar).b();
                }
                sVarArr[i11] = null;
            }
        }
    }

    private void z(h[] hVarArr, t9.s[] sVarArr, int[] iArr) {
        boolean z10;
        for (int i11 = 0; i11 < hVarArr.length; i11++) {
            t9.s sVar = sVarArr[i11];
            if ((sVar instanceof t9.g) || (sVar instanceof i.a)) {
                int q11 = q(i11, iArr);
                if (q11 == -1) {
                    z10 = sVarArr[i11] instanceof t9.g;
                } else {
                    t9.s sVar2 = sVarArr[i11];
                    z10 = (sVar2 instanceof i.a) && ((i.a) sVar2).f77289a == sVarArr[q11];
                }
                if (!z10) {
                    t9.s sVar3 = sVarArr[i11];
                    if (sVar3 instanceof i.a) {
                        ((i.a) sVar3).b();
                    }
                    sVarArr[i11] = null;
                }
            }
        }
    }

    public void B(x9.c cVar, int i11) {
        this.f25892v = cVar;
        this.f25893w = i11;
        this.f25883m.q(cVar);
        i[] iVarArr = this.f25889s;
        if (iVarArr != null) {
            for (i iVar : iVarArr) {
                ((com.google.android.exoplayer2.source.dash.a) iVar.q()).e(cVar, i11);
            }
            this.f25888r.g(this);
        }
        this.f25894x = cVar.c(i11).f78222d;
        for (d dVar : this.f25890t) {
            Iterator it = this.f25894x.iterator();
            while (true) {
                if (it.hasNext()) {
                    f fVar = (f) it.next();
                    if (fVar.a().equals(dVar.a())) {
                        dVar.d(fVar, cVar.f78187d && i11 == cVar.d() - 1);
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.n
    public long a(long j11, c3 c3Var) {
        for (i iVar : this.f25889s) {
            if (iVar.f77266a == 2) {
                return iVar.a(j11, c3Var);
            }
        }
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.n
    public long b(h[] hVarArr, boolean[] zArr, t9.s[] sVarArr, boolean[] zArr2, long j11) {
        int[] r11 = r(hVarArr);
        y(hVarArr, zArr, sVarArr);
        z(hVarArr, sVarArr, r11);
        A(hVarArr, sVarArr, zArr2, j11, r11);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (t9.s sVar : sVarArr) {
            if (sVar instanceof i) {
                arrayList.add((i) sVar);
            } else if (sVar instanceof d) {
                arrayList2.add((d) sVar);
            }
        }
        i[] u11 = u(arrayList.size());
        this.f25889s = u11;
        arrayList.toArray(u11);
        d[] dVarArr = new d[arrayList2.size()];
        this.f25890t = dVarArr;
        arrayList2.toArray(dVarArr);
        this.f25891u = this.f25882l.a(this.f25889s);
        return j11;
    }

    @Override // v9.i.b
    public synchronized void c(i iVar) {
        e.c cVar = (e.c) this.f25884n.remove(iVar);
        if (cVar != null) {
            cVar.n();
        }
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public boolean continueLoading(long j11) {
        return this.f25891u.continueLoading(j11);
    }

    @Override // com.google.android.exoplayer2.source.n
    public void discardBuffer(long j11, boolean z10) {
        for (i iVar : this.f25889s) {
            iVar.discardBuffer(j11, z10);
        }
    }

    @Override // com.google.android.exoplayer2.source.n
    public void e(n.a aVar, long j11) {
        this.f25888r = aVar;
        aVar.h(this);
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public long getBufferedPositionUs() {
        return this.f25891u.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public long getNextLoadPositionUs() {
        return this.f25891u.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.n
    public x getTrackGroups() {
        return this.f25880j;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public boolean isLoading() {
        return this.f25891u.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.n
    public void maybeThrowPrepareError() {
        this.f25878h.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.n
    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public void reevaluateBuffer(long j11) {
        this.f25891u.reevaluateBuffer(j11);
    }

    @Override // com.google.android.exoplayer2.source.n
    public long seekToUs(long j11) {
        for (i iVar : this.f25889s) {
            iVar.E(j11);
        }
        for (d dVar : this.f25890t) {
            dVar.b(j11);
        }
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.b0.a
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void g(i iVar) {
        this.f25888r.g(this);
    }

    public void x() {
        this.f25883m.o();
        for (i iVar : this.f25889s) {
            iVar.C(this);
        }
        this.f25888r = null;
    }
}
