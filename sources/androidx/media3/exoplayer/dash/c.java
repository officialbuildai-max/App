package androidx.media3.exoplayer.dash;

import a2.g;
import a2.j;
import android.util.Pair;
import android.util.SparseArray;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.c4;
import androidx.media3.exoplayer.dash.a;
import androidx.media3.exoplayer.dash.f;
import androidx.media3.exoplayer.drm.r;
import androidx.media3.exoplayer.drm.t;
import androidx.media3.exoplayer.source.f0;
import androidx.media3.exoplayer.source.q;
import androidx.media3.exoplayer.source.s;
import androidx.media3.exoplayer.upstream.m;
import androidx.media3.exoplayer.upstream.p;
import androidx.media3.exoplayer.v2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import g2.u;
import g2.z;
import h2.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import w1.n;
import y1.f4;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c implements q, f0.a, h.b {
    private static final Pattern A = Pattern.compile("CC([1-4])=(.+)");
    private static final Pattern B = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");

    /* renamed from: a, reason: collision with root package name */
    final int f11483a;

    /* renamed from: b, reason: collision with root package name */
    private final a.InterfaceC0103a f11484b;

    /* renamed from: c, reason: collision with root package name */
    private final n f11485c;

    /* renamed from: d, reason: collision with root package name */
    private final t f11486d;

    /* renamed from: e, reason: collision with root package name */
    private final m f11487e;

    /* renamed from: f, reason: collision with root package name */
    private final z1.b f11488f;

    /* renamed from: g, reason: collision with root package name */
    private final long f11489g;

    /* renamed from: h, reason: collision with root package name */
    private final p f11490h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.b f11491i;

    /* renamed from: j, reason: collision with root package name */
    private final z f11492j;

    /* renamed from: k, reason: collision with root package name */
    private final a[] f11493k;

    /* renamed from: l, reason: collision with root package name */
    private final g2.e f11494l;

    /* renamed from: m, reason: collision with root package name */
    private final f f11495m;

    /* renamed from: o, reason: collision with root package name */
    private final s.a f11497o;

    /* renamed from: p, reason: collision with root package name */
    private final r.a f11498p;

    /* renamed from: q, reason: collision with root package name */
    private final f4 f11499q;

    /* renamed from: r, reason: collision with root package name */
    private q.a f11500r;

    /* renamed from: u, reason: collision with root package name */
    private f0 f11503u;

    /* renamed from: v, reason: collision with root package name */
    private a2.c f11504v;

    /* renamed from: w, reason: collision with root package name */
    private int f11505w;

    /* renamed from: x, reason: collision with root package name */
    private List f11506x;

    /* renamed from: z, reason: collision with root package name */
    private long f11508z;

    /* renamed from: y, reason: collision with root package name */
    private boolean f11507y = true;

    /* renamed from: s, reason: collision with root package name */
    private h[] f11501s = z(0);

    /* renamed from: t, reason: collision with root package name */
    private e[] f11502t = new e[0];

    /* renamed from: n, reason: collision with root package name */
    private final IdentityHashMap f11496n = new IdentityHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f11509a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11510b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11511c;

        /* renamed from: d, reason: collision with root package name */
        public final int f11512d;

        /* renamed from: e, reason: collision with root package name */
        public final int f11513e;

        /* renamed from: f, reason: collision with root package name */
        public final int f11514f;

        /* renamed from: g, reason: collision with root package name */
        public final int f11515g;

        /* renamed from: h, reason: collision with root package name */
        public final ImmutableList f11516h;

        private a(int i11, int i12, int[] iArr, int i13, int i14, int i15, int i16, ImmutableList immutableList) {
            this.f11510b = i11;
            this.f11509a = iArr;
            this.f11511c = i12;
            this.f11513e = i13;
            this.f11514f = i14;
            this.f11515g = i15;
            this.f11512d = i16;
            this.f11516h = immutableList;
        }

        public static a a(int[] iArr, int i11, ImmutableList immutableList) {
            return new a(3, 1, iArr, i11, -1, -1, -1, immutableList);
        }

        public static a b(int[] iArr, int i11) {
            return new a(5, 1, iArr, i11, -1, -1, -1, ImmutableList.of());
        }

        public static a c(int i11) {
            return new a(5, 2, new int[0], -1, -1, -1, i11, ImmutableList.of());
        }

        public static a d(int i11, int[] iArr, int i12, int i13, int i14) {
            return new a(i11, 0, iArr, i12, i13, i14, -1, ImmutableList.of());
        }
    }

    public c(int i11, a2.c cVar, z1.b bVar, int i12, a.InterfaceC0103a interfaceC0103a, n nVar, androidx.media3.exoplayer.upstream.f fVar, t tVar, r.a aVar, m mVar, s.a aVar2, long j11, p pVar, androidx.media3.exoplayer.upstream.b bVar2, g2.e eVar, f.b bVar3, f4 f4Var) {
        this.f11483a = i11;
        this.f11504v = cVar;
        this.f11488f = bVar;
        this.f11505w = i12;
        this.f11484b = interfaceC0103a;
        this.f11485c = nVar;
        this.f11486d = tVar;
        this.f11498p = aVar;
        this.f11487e = mVar;
        this.f11497o = aVar2;
        this.f11489g = j11;
        this.f11490h = pVar;
        this.f11491i = bVar2;
        this.f11494l = eVar;
        this.f11499q = f4Var;
        this.f11495m = new f(cVar, bVar3, bVar2);
        this.f11503u = eVar.b();
        g c11 = cVar.c(i12);
        List list = c11.f159d;
        this.f11506x = list;
        Pair m11 = m(tVar, interfaceC0103a, c11.f158c, list);
        this.f11492j = (z) m11.first;
        this.f11493k = (a[]) m11.second;
    }

    private static androidx.media3.common.r[] B(a2.e eVar, Pattern pattern, androidx.media3.common.r rVar) {
        String str = eVar.f149b;
        if (str == null) {
            return new androidx.media3.common.r[]{rVar};
        }
        String[] o12 = a1.o1(str, ";");
        androidx.media3.common.r[] rVarArr = new androidx.media3.common.r[o12.length];
        for (int i11 = 0; i11 < o12.length; i11++) {
            Matcher matcher = pattern.matcher(o12[i11]);
            if (!matcher.matches()) {
                return new androidx.media3.common.r[]{rVar};
            }
            int parseInt = Integer.parseInt(matcher.group(1));
            rVarArr[i11] = rVar.b().f0(rVar.f10229a + ":" + parseInt).O(parseInt).j0(matcher.group(2)).N();
        }
        return rVarArr;
    }

    private void D(j2.z[] zVarArr, boolean[] zArr, u[] uVarArr) {
        for (int i11 = 0; i11 < zVarArr.length; i11++) {
            if (zVarArr[i11] == null || !zArr[i11]) {
                u uVar = uVarArr[i11];
                if (uVar instanceof h) {
                    ((h) uVar).G(this);
                } else if (uVar instanceof h.a) {
                    ((h.a) uVar).b();
                }
                uVarArr[i11] = null;
            }
        }
    }

    private void E(j2.z[] zVarArr, u[] uVarArr, int[] iArr) {
        boolean z10;
        for (int i11 = 0; i11 < zVarArr.length; i11++) {
            u uVar = uVarArr[i11];
            if ((uVar instanceof g2.h) || (uVar instanceof h.a)) {
                int t11 = t(i11, iArr);
                if (t11 == -1) {
                    z10 = uVarArr[i11] instanceof g2.h;
                } else {
                    u uVar2 = uVarArr[i11];
                    z10 = (uVar2 instanceof h.a) && ((h.a) uVar2).f64455a == uVarArr[t11];
                }
                if (!z10) {
                    u uVar3 = uVarArr[i11];
                    if (uVar3 instanceof h.a) {
                        ((h.a) uVar3).b();
                    }
                    uVarArr[i11] = null;
                }
            }
        }
    }

    private void F(j2.z[] zVarArr, u[] uVarArr, boolean[] zArr, long j11, int[] iArr) {
        for (int i11 = 0; i11 < zVarArr.length; i11++) {
            j2.z zVar = zVarArr[i11];
            if (zVar != null) {
                u uVar = uVarArr[i11];
                if (uVar == null) {
                    zArr[i11] = true;
                    a aVar = this.f11493k[iArr[i11]];
                    int i12 = aVar.f11511c;
                    if (i12 == 0) {
                        uVarArr[i11] = l(aVar, zVar, j11);
                    } else if (i12 == 2) {
                        uVarArr[i11] = new e((a2.f) this.f11506x.get(aVar.f11512d), zVar.getTrackGroup().a(0), this.f11504v.f123d);
                    }
                } else if (uVar instanceof h) {
                    ((androidx.media3.exoplayer.dash.a) ((h) uVar).u()).e(zVar);
                }
            }
        }
        for (int i13 = 0; i13 < zVarArr.length; i13++) {
            if (uVarArr[i13] == null && zVarArr[i13] != null) {
                a aVar2 = this.f11493k[iArr[i13]];
                if (aVar2.f11511c == 1) {
                    int t11 = t(i13, iArr);
                    if (t11 == -1) {
                        uVarArr[i13] = new g2.h();
                    } else {
                        uVarArr[i13] = ((h) uVarArr[t11]).J(j11, aVar2.f11510b);
                    }
                }
            }
        }
    }

    private static void j(List list, androidx.media3.common.f0[] f0VarArr, a[] aVarArr, int i11) {
        int i12 = 0;
        while (i12 < list.size()) {
            a2.f fVar = (a2.f) list.get(i12);
            f0VarArr[i11] = new androidx.media3.common.f0(fVar.a() + ":" + i12, new r.b().f0(fVar.a()).u0(MimeTypes.APPLICATION_EMSG).N());
            aVarArr[i11] = a.c(i12);
            i12++;
            i11++;
        }
    }

    private static int k(t tVar, a.InterfaceC0103a interfaceC0103a, List list, int[][] iArr, int i11, boolean[] zArr, androidx.media3.common.r[][] rVarArr, androidx.media3.common.f0[] f0VarArr, a[] aVarArr) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i17 < i11) {
            int[] iArr2 = iArr[i17];
            ArrayList arrayList = new ArrayList();
            int length = iArr2.length;
            for (int i19 = i16; i19 < length; i19++) {
                arrayList.addAll(((a2.a) list.get(iArr2[i19])).f112c);
            }
            int size = arrayList.size();
            androidx.media3.common.r[] rVarArr2 = new androidx.media3.common.r[size];
            for (int i20 = i16; i20 < size; i20++) {
                androidx.media3.common.r rVar = ((j) arrayList.get(i20)).f171b;
                rVarArr2[i20] = rVar.b().V(tVar.b(rVar)).N();
            }
            a2.a aVar = (a2.a) list.get(iArr2[i16]);
            long j11 = aVar.f110a;
            String l11 = j11 != -1 ? Long.toString(j11) : "unset:" + i17;
            int i21 = i18 + 1;
            if (zArr[i17]) {
                i12 = i18 + 2;
            } else {
                i12 = i21;
                i21 = -1;
            }
            if (rVarArr[i17].length != 0) {
                i13 = i12 + 1;
            } else {
                i13 = i12;
                i12 = -1;
            }
            y(interfaceC0103a, rVarArr2);
            f0VarArr[i18] = new androidx.media3.common.f0(l11, rVarArr2);
            aVarArr[i18] = a.d(aVar.f111b, iArr2, i18, i21, i12);
            if (i21 != -1) {
                String str = l11 + ":emsg";
                i14 = 0;
                f0VarArr[i21] = new androidx.media3.common.f0(str, new r.b().f0(str).u0(MimeTypes.APPLICATION_EMSG).N());
                aVarArr[i21] = a.b(iArr2, i18);
                i15 = -1;
            } else {
                i14 = 0;
                i15 = -1;
            }
            if (i12 != i15) {
                aVarArr[i12] = a.a(iArr2, i18, ImmutableList.copyOf(rVarArr[i17]));
                y(interfaceC0103a, rVarArr[i17]);
                f0VarArr[i12] = new androidx.media3.common.f0(l11 + ":cc", rVarArr[i17]);
            }
            i17++;
            i18 = i13;
            i16 = i14;
        }
        return i18;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private h l(a aVar, j2.z zVar, long j11) {
        int i11;
        androidx.media3.common.f0 f0Var;
        int i12;
        int i13 = aVar.f11514f;
        boolean z10 = i13 != -1;
        f.c cVar = null;
        if (z10) {
            f0Var = this.f11492j.b(i13);
            i11 = 1;
        } else {
            i11 = 0;
            f0Var = null;
        }
        int i14 = aVar.f11515g;
        ImmutableList of2 = i14 != -1 ? this.f11493k[i14].f11516h : ImmutableList.of();
        int size = i11 + of2.size();
        androidx.media3.common.r[] rVarArr = new androidx.media3.common.r[size];
        int[] iArr = new int[size];
        if (z10) {
            rVarArr[0] = f0Var.a(0);
            iArr[0] = 5;
            i12 = 1;
        } else {
            i12 = 0;
        }
        ArrayList arrayList = new ArrayList();
        for (int i15 = 0; i15 < of2.size(); i15++) {
            androidx.media3.common.r rVar = (androidx.media3.common.r) of2.get(i15);
            rVarArr[i12] = rVar;
            iArr[i12] = 3;
            arrayList.add(rVar);
            i12++;
        }
        if (this.f11504v.f123d && z10) {
            cVar = this.f11495m.k();
        }
        f.c cVar2 = cVar;
        h hVar = new h(aVar.f11510b, iArr, rVarArr, this.f11484b.e(this.f11490h, this.f11504v, this.f11488f, this.f11505w, aVar.f11509a, zVar, aVar.f11510b, this.f11489g, z10, arrayList, cVar2, this.f11485c, this.f11499q, null), this, this.f11491i, j11, this.f11486d, this.f11498p, this.f11487e, this.f11497o, this.f11507y, null);
        synchronized (this) {
            this.f11496n.put(hVar, cVar2);
        }
        return hVar;
    }

    private static Pair m(t tVar, a.InterfaceC0103a interfaceC0103a, List list, List list2) {
        int[][] s11 = s(list);
        int length = s11.length;
        boolean[] zArr = new boolean[length];
        androidx.media3.common.r[][] rVarArr = new androidx.media3.common.r[length];
        int w11 = w(length, list, s11, zArr, rVarArr) + length + list2.size();
        androidx.media3.common.f0[] f0VarArr = new androidx.media3.common.f0[w11];
        a[] aVarArr = new a[w11];
        j(list2, f0VarArr, aVarArr, k(tVar, interfaceC0103a, list, s11, length, zArr, rVarArr, f0VarArr, aVarArr));
        return Pair.create(new z(f0VarArr), aVarArr);
    }

    private static boolean n(a2.a aVar, a2.a aVar2) {
        if (aVar.f111b != aVar2.f111b) {
            return false;
        }
        if (aVar.f112c.isEmpty() || aVar2.f112c.isEmpty()) {
            return true;
        }
        androidx.media3.common.r rVar = ((j) aVar.f112c.get(0)).f171b;
        androidx.media3.common.r rVar2 = ((j) aVar2.f112c.get(0)).f171b;
        return Objects.equals(rVar.f10232d, rVar2.f10232d) && rVar.f10234f == rVar2.f10234f;
    }

    private static a2.e o(List list) {
        return p(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    private static a2.e p(List list, String str) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            a2.e eVar = (a2.e) list.get(i11);
            if (str.equals(eVar.f148a)) {
                return eVar;
            }
        }
        return null;
    }

    private static a2.e q(List list) {
        return p(list, "http://dashif.org/guidelines/trickmode");
    }

    private static androidx.media3.common.r[] r(List list, int[] iArr) {
        for (int i11 : iArr) {
            a2.a aVar = (a2.a) list.get(i11);
            List list2 = ((a2.a) list.get(i11)).f113d;
            for (int i12 = 0; i12 < list2.size(); i12++) {
                a2.e eVar = (a2.e) list2.get(i12);
                if ("urn:scte:dash:cc:cea-608:2015".equals(eVar.f148a)) {
                    return B(eVar, A, new r.b().u0(MimeTypes.APPLICATION_CEA608).f0(aVar.f110a + ":cea608").N());
                }
                if ("urn:scte:dash:cc:cea-708:2015".equals(eVar.f148a)) {
                    return B(eVar, B, new r.b().u0(MimeTypes.APPLICATION_CEA708).f0(aVar.f110a + ":cea708").N());
                }
            }
        }
        return new androidx.media3.common.r[0];
    }

    private static int[][] s(List list) {
        a2.e o11;
        Integer num;
        int size = list.size();
        HashMap p11 = Maps.p(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i11 = 0; i11 < size; i11++) {
            p11.put(Long.valueOf(((a2.a) list.get(i11)).f110a), Integer.valueOf(i11));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i11));
            arrayList.add(arrayList2);
            sparseArray.put(i11, arrayList2);
        }
        for (int i12 = 0; i12 < size; i12++) {
            a2.a aVar = (a2.a) list.get(i12);
            a2.e q11 = q(aVar.f114e);
            if (q11 == null) {
                q11 = q(aVar.f115f);
            }
            int intValue = (q11 == null || (num = (Integer) p11.get(Long.valueOf(Long.parseLong(q11.f149b)))) == null) ? i12 : num.intValue();
            if (intValue == i12 && (o11 = o(aVar.f115f)) != null) {
                for (String str : a1.o1(o11.f149b, ",")) {
                    Integer num2 = (Integer) p11.get(Long.valueOf(Long.parseLong(str)));
                    if (num2 != null && n(aVar, (a2.a) list.get(num2.intValue()))) {
                        intValue = Math.min(intValue, num2.intValue());
                    }
                }
            }
            if (intValue != i12) {
                List list2 = (List) sparseArray.get(i12);
                List list3 = (List) sparseArray.get(intValue);
                list3.addAll(list2);
                sparseArray.put(i12, list3);
                arrayList.remove(list2);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2];
        for (int i13 = 0; i13 < size2; i13++) {
            int[] o12 = Ints.o((Collection) arrayList.get(i13));
            iArr[i13] = o12;
            Arrays.sort(o12);
        }
        return iArr;
    }

    private int t(int i11, int[] iArr) {
        int i12 = iArr[i11];
        if (i12 == -1) {
            return -1;
        }
        int i13 = this.f11493k[i12].f11513e;
        for (int i14 = 0; i14 < iArr.length; i14++) {
            int i15 = iArr[i14];
            if (i15 == i13 && this.f11493k[i15].f11511c == 0) {
                return i14;
            }
        }
        return -1;
    }

    private int[] u(j2.z[] zVarArr) {
        int[] iArr = new int[zVarArr.length];
        for (int i11 = 0; i11 < zVarArr.length; i11++) {
            j2.z zVar = zVarArr[i11];
            if (zVar != null) {
                iArr[i11] = this.f11492j.d(zVar.getTrackGroup());
            } else {
                iArr[i11] = -1;
            }
        }
        return iArr;
    }

    private static boolean v(List list, int[] iArr) {
        for (int i11 : iArr) {
            List list2 = ((a2.a) list.get(i11)).f112c;
            for (int i12 = 0; i12 < list2.size(); i12++) {
                if (!((j) list2.get(i12)).f174e.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int w(int i11, List list, int[][] iArr, boolean[] zArr, androidx.media3.common.r[][] rVarArr) {
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            if (v(list, iArr[i13])) {
                zArr[i13] = true;
                i12++;
            }
            androidx.media3.common.r[] r11 = r(list, iArr[i13]);
            rVarArr[i13] = r11;
            if (r11.length != 0) {
                i12++;
            }
        }
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List x(h hVar) {
        return ImmutableList.of(Integer.valueOf(hVar.f64430a));
    }

    private static void y(a.InterfaceC0103a interfaceC0103a, androidx.media3.common.r[] rVarArr) {
        for (int i11 = 0; i11 < rVarArr.length; i11++) {
            rVarArr[i11] = interfaceC0103a.d(rVarArr[i11]);
        }
    }

    private static h[] z(int i11) {
        return new h[i11];
    }

    @Override // androidx.media3.exoplayer.source.f0.a
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void f(h hVar) {
        this.f11500r.f(this);
    }

    public void C() {
        this.f11495m.o();
        for (h hVar : this.f11501s) {
            hVar.G(this);
        }
        this.f11500r = null;
    }

    public void G(a2.c cVar, int i11) {
        this.f11504v = cVar;
        this.f11505w = i11;
        this.f11495m.q(cVar);
        h[] hVarArr = this.f11501s;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                ((androidx.media3.exoplayer.dash.a) hVar.u()).g(cVar, i11);
            }
            this.f11500r.f(this);
        }
        this.f11506x = cVar.c(i11).f159d;
        for (e eVar : this.f11502t) {
            Iterator it = this.f11506x.iterator();
            while (true) {
                if (it.hasNext()) {
                    a2.f fVar = (a2.f) it.next();
                    if (fVar.a().equals(eVar.a())) {
                        eVar.d(fVar, cVar.f123d && i11 == cVar.d() - 1);
                    }
                }
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public boolean a(v2 v2Var) {
        return this.f11503u.a(v2Var);
    }

    @Override // androidx.media3.exoplayer.source.q
    public long b(long j11, c4 c4Var) {
        for (h hVar : this.f11501s) {
            if (hVar.f64430a == 2) {
                return hVar.b(j11, c4Var);
            }
        }
        return j11;
    }

    @Override // androidx.media3.exoplayer.source.q
    public void discardBuffer(long j11, boolean z10) {
        for (h hVar : this.f11501s) {
            hVar.discardBuffer(j11, z10);
        }
    }

    @Override // androidx.media3.exoplayer.source.q
    public long e(j2.z[] zVarArr, boolean[] zArr, u[] uVarArr, boolean[] zArr2, long j11) {
        int[] u11 = u(zVarArr);
        D(zVarArr, zArr, uVarArr);
        E(zVarArr, uVarArr, u11);
        F(zVarArr, uVarArr, zArr2, j11, u11);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (u uVar : uVarArr) {
            if (uVar instanceof h) {
                arrayList.add((h) uVar);
            } else if (uVar instanceof e) {
                arrayList2.add((e) uVar);
            }
        }
        h[] z10 = z(arrayList.size());
        this.f11501s = z10;
        arrayList.toArray(z10);
        e[] eVarArr = new e[arrayList2.size()];
        this.f11502t = eVarArr;
        arrayList2.toArray(eVarArr);
        this.f11503u = this.f11494l.a(arrayList, Lists.o(arrayList, new com.google.common.base.f() { // from class: androidx.media3.exoplayer.dash.b
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                List x10;
                x10 = c.x((h) obj);
                return x10;
            }
        }));
        if (this.f11507y) {
            this.f11507y = false;
            this.f11508z = j11;
        }
        return j11;
    }

    @Override // androidx.media3.exoplayer.source.q
    public void g(q.a aVar, long j11) {
        this.f11500r = aVar;
        aVar.c(this);
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public long getBufferedPositionUs() {
        return this.f11503u.getBufferedPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public long getNextLoadPositionUs() {
        return this.f11503u.getNextLoadPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.q
    public z getTrackGroups() {
        return this.f11492j;
    }

    @Override // h2.h.b
    public synchronized void h(h hVar) {
        f.c cVar = (f.c) this.f11496n.remove(hVar);
        if (cVar != null) {
            cVar.o();
        }
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public boolean isLoading() {
        return this.f11503u.isLoading();
    }

    @Override // androidx.media3.exoplayer.source.q
    public void maybeThrowPrepareError() {
        this.f11490h.maybeThrowError();
    }

    @Override // androidx.media3.exoplayer.source.q
    public long readDiscontinuity() {
        for (h hVar : this.f11501s) {
            if (hVar.m()) {
                return this.f11508z;
            }
        }
        return C.TIME_UNSET;
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public void reevaluateBuffer(long j11) {
        for (h hVar : this.f11501s) {
            if (!hVar.isLoading()) {
                hVar.t(this.f11504v.f(this.f11505w));
            }
        }
        this.f11503u.reevaluateBuffer(j11);
    }

    @Override // androidx.media3.exoplayer.source.q
    public long seekToUs(long j11) {
        for (h hVar : this.f11501s) {
            hVar.I(j11);
        }
        for (e eVar : this.f11502t) {
            eVar.b(j11);
        }
        return j11;
    }
}
