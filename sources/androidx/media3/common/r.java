package androidx.media3.common;

import android.text.TextUtils;
import androidx.media3.common.util.a1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class r {
    private static final r P = new b().N();
    private static final String Q = a1.C0(0);
    private static final String R = a1.C0(1);
    private static final String S = a1.C0(2);
    private static final String T = a1.C0(3);
    private static final String U = a1.C0(4);
    private static final String V = a1.C0(5);
    private static final String W = a1.C0(6);
    private static final String X = a1.C0(7);
    private static final String Y = a1.C0(8);
    private static final String Z = a1.C0(9);

    /* renamed from: a0, reason: collision with root package name */
    private static final String f10204a0 = a1.C0(10);

    /* renamed from: b0, reason: collision with root package name */
    private static final String f10205b0 = a1.C0(11);

    /* renamed from: c0, reason: collision with root package name */
    private static final String f10206c0 = a1.C0(12);

    /* renamed from: d0, reason: collision with root package name */
    private static final String f10207d0 = a1.C0(13);

    /* renamed from: e0, reason: collision with root package name */
    private static final String f10208e0 = a1.C0(14);

    /* renamed from: f0, reason: collision with root package name */
    private static final String f10209f0 = a1.C0(15);

    /* renamed from: g0, reason: collision with root package name */
    private static final String f10210g0 = a1.C0(16);

    /* renamed from: h0, reason: collision with root package name */
    private static final String f10211h0 = a1.C0(17);

    /* renamed from: i0, reason: collision with root package name */
    private static final String f10212i0 = a1.C0(18);

    /* renamed from: j0, reason: collision with root package name */
    private static final String f10213j0 = a1.C0(19);

    /* renamed from: k0, reason: collision with root package name */
    private static final String f10214k0 = a1.C0(20);

    /* renamed from: l0, reason: collision with root package name */
    private static final String f10215l0 = a1.C0(21);

    /* renamed from: m0, reason: collision with root package name */
    private static final String f10216m0 = a1.C0(22);

    /* renamed from: n0, reason: collision with root package name */
    private static final String f10217n0 = a1.C0(23);

    /* renamed from: o0, reason: collision with root package name */
    private static final String f10218o0 = a1.C0(24);

    /* renamed from: p0, reason: collision with root package name */
    private static final String f10219p0 = a1.C0(25);

    /* renamed from: q0, reason: collision with root package name */
    private static final String f10220q0 = a1.C0(26);

    /* renamed from: r0, reason: collision with root package name */
    private static final String f10221r0 = a1.C0(27);

    /* renamed from: s0, reason: collision with root package name */
    private static final String f10222s0 = a1.C0(28);

    /* renamed from: t0, reason: collision with root package name */
    private static final String f10223t0 = a1.C0(29);

    /* renamed from: u0, reason: collision with root package name */
    private static final String f10224u0 = a1.C0(30);

    /* renamed from: v0, reason: collision with root package name */
    private static final String f10225v0 = a1.C0(31);

    /* renamed from: w0, reason: collision with root package name */
    private static final String f10226w0 = a1.C0(32);

    /* renamed from: x0, reason: collision with root package name */
    private static final String f10227x0 = a1.C0(33);

    /* renamed from: y0, reason: collision with root package name */
    private static final String f10228y0 = a1.C0(34);
    public final byte[] A;
    public final int B;
    public final i C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public final int K;
    public final int L;
    public final int M;
    public final int N;
    private int O;

    /* renamed from: a, reason: collision with root package name */
    public final String f10229a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10230b;

    /* renamed from: c, reason: collision with root package name */
    public final List f10231c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10232d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10233e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10234f;

    /* renamed from: g, reason: collision with root package name */
    public final int f10235g;

    /* renamed from: h, reason: collision with root package name */
    public final int f10236h;

    /* renamed from: i, reason: collision with root package name */
    public final int f10237i;

    /* renamed from: j, reason: collision with root package name */
    public final int f10238j;

    /* renamed from: k, reason: collision with root package name */
    public final String f10239k;

    /* renamed from: l, reason: collision with root package name */
    public final x f10240l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f10241m;

    /* renamed from: n, reason: collision with root package name */
    public final String f10242n;

    /* renamed from: o, reason: collision with root package name */
    public final String f10243o;

    /* renamed from: p, reason: collision with root package name */
    public final int f10244p;

    /* renamed from: q, reason: collision with root package name */
    public final int f10245q;

    /* renamed from: r, reason: collision with root package name */
    public final List f10246r;

    /* renamed from: s, reason: collision with root package name */
    public final DrmInitData f10247s;

    /* renamed from: t, reason: collision with root package name */
    public final long f10248t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f10249u;

    /* renamed from: v, reason: collision with root package name */
    public final int f10250v;

    /* renamed from: w, reason: collision with root package name */
    public final int f10251w;

    /* renamed from: x, reason: collision with root package name */
    public final float f10252x;

    /* renamed from: y, reason: collision with root package name */
    public final int f10253y;

    /* renamed from: z, reason: collision with root package name */
    public final float f10254z;

    /* loaded from: classes2.dex */
    public static final class b {
        private int A;
        private i B;
        private int C;
        private int D;
        private int E;
        private int F;
        private int G;
        private int H;
        private int I;
        private int J;
        private int K;
        private int L;
        private int M;

        /* renamed from: a, reason: collision with root package name */
        private String f10255a;

        /* renamed from: b, reason: collision with root package name */
        private String f10256b;

        /* renamed from: c, reason: collision with root package name */
        private List f10257c;

        /* renamed from: d, reason: collision with root package name */
        private String f10258d;

        /* renamed from: e, reason: collision with root package name */
        private int f10259e;

        /* renamed from: f, reason: collision with root package name */
        private int f10260f;

        /* renamed from: g, reason: collision with root package name */
        private int f10261g;

        /* renamed from: h, reason: collision with root package name */
        private int f10262h;

        /* renamed from: i, reason: collision with root package name */
        private int f10263i;

        /* renamed from: j, reason: collision with root package name */
        private String f10264j;

        /* renamed from: k, reason: collision with root package name */
        private x f10265k;

        /* renamed from: l, reason: collision with root package name */
        private Object f10266l;

        /* renamed from: m, reason: collision with root package name */
        private String f10267m;

        /* renamed from: n, reason: collision with root package name */
        private String f10268n;

        /* renamed from: o, reason: collision with root package name */
        private int f10269o;

        /* renamed from: p, reason: collision with root package name */
        private int f10270p;

        /* renamed from: q, reason: collision with root package name */
        private List f10271q;

        /* renamed from: r, reason: collision with root package name */
        private DrmInitData f10272r;

        /* renamed from: s, reason: collision with root package name */
        private long f10273s;

        /* renamed from: t, reason: collision with root package name */
        private boolean f10274t;

        /* renamed from: u, reason: collision with root package name */
        private int f10275u;

        /* renamed from: v, reason: collision with root package name */
        private int f10276v;

        /* renamed from: w, reason: collision with root package name */
        private float f10277w;

        /* renamed from: x, reason: collision with root package name */
        private int f10278x;

        /* renamed from: y, reason: collision with root package name */
        private float f10279y;

        /* renamed from: z, reason: collision with root package name */
        private byte[] f10280z;

        public b() {
            this.f10257c = ImmutableList.of();
            this.f10262h = -1;
            this.f10263i = -1;
            this.f10269o = -1;
            this.f10270p = -1;
            this.f10273s = Long.MAX_VALUE;
            this.f10275u = -1;
            this.f10276v = -1;
            this.f10277w = -1.0f;
            this.f10279y = 1.0f;
            this.A = -1;
            this.C = -1;
            this.D = -1;
            this.E = -1;
            this.F = -1;
            this.I = -1;
            this.J = 1;
            this.K = -1;
            this.L = -1;
            this.M = 0;
            this.f10261g = 0;
        }

        private b(r rVar) {
            this.f10255a = rVar.f10229a;
            this.f10256b = rVar.f10230b;
            this.f10257c = rVar.f10231c;
            this.f10258d = rVar.f10232d;
            this.f10259e = rVar.f10233e;
            this.f10260f = rVar.f10234f;
            this.f10262h = rVar.f10236h;
            this.f10263i = rVar.f10237i;
            this.f10264j = rVar.f10239k;
            this.f10265k = rVar.f10240l;
            this.f10266l = rVar.f10241m;
            this.f10267m = rVar.f10242n;
            this.f10268n = rVar.f10243o;
            this.f10269o = rVar.f10244p;
            this.f10270p = rVar.f10245q;
            this.f10271q = rVar.f10246r;
            this.f10272r = rVar.f10247s;
            this.f10273s = rVar.f10248t;
            this.f10274t = rVar.f10249u;
            this.f10275u = rVar.f10250v;
            this.f10276v = rVar.f10251w;
            this.f10277w = rVar.f10252x;
            this.f10278x = rVar.f10253y;
            this.f10279y = rVar.f10254z;
            this.f10280z = rVar.A;
            this.A = rVar.B;
            this.B = rVar.C;
            this.C = rVar.D;
            this.D = rVar.E;
            this.E = rVar.F;
            this.F = rVar.G;
            this.G = rVar.H;
            this.H = rVar.I;
            this.I = rVar.J;
            this.J = rVar.K;
            this.K = rVar.L;
            this.L = rVar.M;
            this.M = rVar.N;
        }

        public b A0(int i11) {
            this.L = i11;
            return this;
        }

        public b B0(int i11) {
            this.f10275u = i11;
            return this;
        }

        public r N() {
            return new r(this);
        }

        public b O(int i11) {
            this.I = i11;
            return this;
        }

        public b P(int i11) {
            this.f10261g = i11;
            return this;
        }

        public b Q(int i11) {
            this.f10262h = i11;
            return this;
        }

        public b R(int i11) {
            this.D = i11;
            return this;
        }

        public b S(String str) {
            this.f10264j = str;
            return this;
        }

        public b T(i iVar) {
            this.B = iVar;
            return this;
        }

        public b U(String str) {
            this.f10267m = y.u(str);
            return this;
        }

        public b V(int i11) {
            this.M = i11;
            return this;
        }

        public b W(int i11) {
            this.J = i11;
            return this;
        }

        public b X(Object obj) {
            this.f10266l = obj;
            return this;
        }

        public b Y(DrmInitData drmInitData) {
            this.f10272r = drmInitData;
            return this;
        }

        public b Z(int i11) {
            this.G = i11;
            return this;
        }

        public b a0(int i11) {
            this.H = i11;
            return this;
        }

        public b b0(float f11) {
            this.f10277w = f11;
            return this;
        }

        public b c0(boolean z10) {
            this.f10274t = z10;
            return this;
        }

        public b d0(int i11) {
            this.f10276v = i11;
            return this;
        }

        public b e0(int i11) {
            this.f10255a = Integer.toString(i11);
            return this;
        }

        public b f0(String str) {
            this.f10255a = str;
            return this;
        }

        public b g0(List list) {
            this.f10271q = list;
            return this;
        }

        public b h0(String str) {
            this.f10256b = str;
            return this;
        }

        public b i0(List list) {
            this.f10257c = ImmutableList.copyOf((Collection) list);
            return this;
        }

        public b j0(String str) {
            this.f10258d = str;
            return this;
        }

        public b k0(int i11) {
            this.f10269o = i11;
            return this;
        }

        public b l0(int i11) {
            this.f10270p = i11;
            return this;
        }

        public b m0(int i11) {
            this.C = i11;
            return this;
        }

        public b n0(x xVar) {
            this.f10265k = xVar;
            return this;
        }

        public b o0(int i11) {
            this.F = i11;
            return this;
        }

        public b p0(int i11) {
            this.f10263i = i11;
            return this;
        }

        public b q0(float f11) {
            this.f10279y = f11;
            return this;
        }

        public b r0(byte[] bArr) {
            this.f10280z = bArr;
            return this;
        }

        public b s0(int i11) {
            this.f10260f = i11;
            return this;
        }

        public b t0(int i11) {
            this.f10278x = i11;
            return this;
        }

        public b u0(String str) {
            this.f10268n = y.u(str);
            return this;
        }

        public b v0(int i11) {
            this.E = i11;
            return this;
        }

        public b w0(int i11) {
            this.f10259e = i11;
            return this;
        }

        public b x0(int i11) {
            this.A = i11;
            return this;
        }

        public b y0(long j11) {
            this.f10273s = j11;
            return this;
        }

        public b z0(int i11) {
            this.K = i11;
            return this;
        }
    }

    private r(b bVar) {
        this.f10229a = bVar.f10255a;
        String U0 = a1.U0(bVar.f10258d);
        this.f10232d = U0;
        if (bVar.f10257c.isEmpty() && bVar.f10256b != null) {
            this.f10231c = ImmutableList.of(new s(U0, bVar.f10256b));
            this.f10230b = bVar.f10256b;
        } else if (bVar.f10257c.isEmpty() || bVar.f10256b != null) {
            androidx.media3.common.util.a.g(g(bVar));
            this.f10231c = bVar.f10257c;
            this.f10230b = bVar.f10256b;
        } else {
            this.f10231c = bVar.f10257c;
            this.f10230b = d(bVar.f10257c, U0);
        }
        this.f10233e = bVar.f10259e;
        androidx.media3.common.util.a.h(bVar.f10261g == 0 || (bVar.f10260f & 32768) != 0, "Auxiliary track type must only be set to a value other than AUXILIARY_TRACK_TYPE_UNDEFINED only when ROLE_FLAG_AUXILIARY is set");
        this.f10234f = bVar.f10260f;
        this.f10235g = bVar.f10261g;
        int i11 = bVar.f10262h;
        this.f10236h = i11;
        int i12 = bVar.f10263i;
        this.f10237i = i12;
        this.f10238j = i12 != -1 ? i12 : i11;
        this.f10239k = bVar.f10264j;
        this.f10240l = bVar.f10265k;
        this.f10241m = bVar.f10266l;
        this.f10242n = bVar.f10267m;
        this.f10243o = bVar.f10268n;
        this.f10244p = bVar.f10269o;
        this.f10245q = bVar.f10270p;
        this.f10246r = bVar.f10271q == null ? Collections.emptyList() : bVar.f10271q;
        DrmInitData drmInitData = bVar.f10272r;
        this.f10247s = drmInitData;
        this.f10248t = bVar.f10273s;
        this.f10249u = bVar.f10274t;
        this.f10250v = bVar.f10275u;
        this.f10251w = bVar.f10276v;
        this.f10252x = bVar.f10277w;
        this.f10253y = bVar.f10278x == -1 ? 0 : bVar.f10278x;
        this.f10254z = bVar.f10279y == -1.0f ? 1.0f : bVar.f10279y;
        this.A = bVar.f10280z;
        this.B = bVar.A;
        this.C = bVar.B;
        this.D = bVar.C;
        this.E = bVar.D;
        this.F = bVar.E;
        this.G = bVar.F;
        this.H = bVar.G == -1 ? 0 : bVar.G;
        this.I = bVar.H != -1 ? bVar.H : 0;
        this.J = bVar.I;
        this.K = bVar.J;
        this.L = bVar.K;
        this.M = bVar.L;
        if (bVar.M != 0 || drmInitData == null) {
            this.N = bVar.M;
        } else {
            this.N = 1;
        }
    }

    private static String d(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            if (TextUtils.equals(sVar.f10283a, str)) {
                return sVar.f10284b;
            }
        }
        return ((s) list.get(0)).f10284b;
    }

    private static boolean g(b bVar) {
        if (bVar.f10257c.isEmpty() && bVar.f10256b == null) {
            return true;
        }
        for (int i11 = 0; i11 < bVar.f10257c.size(); i11++) {
            if (((s) bVar.f10257c.get(i11)).f10284b.equals(bVar.f10256b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String h(s sVar) {
        return sVar.f10283a + ": " + sVar.f10284b;
    }

    public static String i(r rVar) {
        if (rVar == null) {
            return "null";
        }
        com.google.common.base.g g11 = com.google.common.base.g.g(',');
        StringBuilder sb2 = new StringBuilder();
        sb2.append("id=");
        sb2.append(rVar.f10229a);
        sb2.append(", mimeType=");
        sb2.append(rVar.f10243o);
        if (rVar.f10242n != null) {
            sb2.append(", container=");
            sb2.append(rVar.f10242n);
        }
        if (rVar.f10238j != -1) {
            sb2.append(", bitrate=");
            sb2.append(rVar.f10238j);
        }
        if (rVar.f10239k != null) {
            sb2.append(", codecs=");
            sb2.append(rVar.f10239k);
        }
        if (rVar.f10247s != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i11 = 0;
            while (true) {
                DrmInitData drmInitData = rVar.f10247s;
                if (i11 >= drmInitData.schemeDataCount) {
                    break;
                }
                UUID uuid = drmInitData.get(i11).uuid;
                if (uuid.equals(h.f10064b)) {
                    linkedHashSet.add(C.CENC_TYPE_cenc);
                } else if (uuid.equals(h.f10065c)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(h.f10067e)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(h.f10066d)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(h.f10063a)) {
                    linkedHashSet.add("universal");
                } else {
                    linkedHashSet.add("unknown (" + uuid + ")");
                }
                i11++;
            }
            sb2.append(", drm=[");
            g11.b(sb2, linkedHashSet);
            sb2.append(']');
        }
        if (rVar.f10250v != -1 && rVar.f10251w != -1) {
            sb2.append(", res=");
            sb2.append(rVar.f10250v);
            sb2.append("x");
            sb2.append(rVar.f10251w);
        }
        if (!com.google.common.math.b.a(rVar.f10254z, 1.0d, 0.001d)) {
            sb2.append(", par=");
            sb2.append(a1.G("%.3f", Float.valueOf(rVar.f10254z)));
        }
        i iVar = rVar.C;
        if (iVar != null && iVar.i()) {
            sb2.append(", color=");
            sb2.append(rVar.C.m());
        }
        if (rVar.f10252x != -1.0f) {
            sb2.append(", fps=");
            sb2.append(rVar.f10252x);
        }
        if (rVar.D != -1) {
            sb2.append(", maxSubLayers=");
            sb2.append(rVar.D);
        }
        if (rVar.E != -1) {
            sb2.append(", channels=");
            sb2.append(rVar.E);
        }
        if (rVar.F != -1) {
            sb2.append(", sample_rate=");
            sb2.append(rVar.F);
        }
        if (rVar.f10232d != null) {
            sb2.append(", language=");
            sb2.append(rVar.f10232d);
        }
        if (!rVar.f10231c.isEmpty()) {
            sb2.append(", labels=[");
            g11.b(sb2, Lists.o(rVar.f10231c, new com.google.common.base.f() { // from class: androidx.media3.common.q
                @Override // com.google.common.base.f
                public final Object apply(Object obj) {
                    String h11;
                    h11 = r.h((s) obj);
                    return h11;
                }
            }));
            sb2.append("]");
        }
        if (rVar.f10233e != 0) {
            sb2.append(", selectionFlags=[");
            g11.b(sb2, a1.n0(rVar.f10233e));
            sb2.append("]");
        }
        if (rVar.f10234f != 0) {
            sb2.append(", roleFlags=[");
            g11.b(sb2, a1.m0(rVar.f10234f));
            sb2.append("]");
        }
        if (rVar.f10241m != null) {
            sb2.append(", customData=");
            sb2.append(rVar.f10241m);
        }
        if ((rVar.f10234f & 32768) != 0) {
            sb2.append(", auxiliaryTrackType=");
            sb2.append(a1.N(rVar.f10235g));
        }
        return sb2.toString();
    }

    public b b() {
        return new b();
    }

    public r c(int i11) {
        return b().V(i11).N();
    }

    public int e() {
        int i11;
        int i12 = this.f10250v;
        if (i12 == -1 || (i11 = this.f10251w) == -1) {
            return -1;
        }
        return i12 * i11;
    }

    public boolean equals(Object obj) {
        int i11;
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        int i12 = this.O;
        if (i12 == 0 || (i11 = rVar.O) == 0 || i12 == i11) {
            return this.f10233e == rVar.f10233e && this.f10234f == rVar.f10234f && this.f10235g == rVar.f10235g && this.f10236h == rVar.f10236h && this.f10237i == rVar.f10237i && this.f10244p == rVar.f10244p && this.f10248t == rVar.f10248t && this.f10250v == rVar.f10250v && this.f10251w == rVar.f10251w && this.f10253y == rVar.f10253y && this.B == rVar.B && this.D == rVar.D && this.E == rVar.E && this.F == rVar.F && this.G == rVar.G && this.H == rVar.H && this.I == rVar.I && this.J == rVar.J && this.L == rVar.L && this.M == rVar.M && this.N == rVar.N && Float.compare(this.f10252x, rVar.f10252x) == 0 && Float.compare(this.f10254z, rVar.f10254z) == 0 && Objects.equals(this.f10229a, rVar.f10229a) && Objects.equals(this.f10230b, rVar.f10230b) && this.f10231c.equals(rVar.f10231c) && Objects.equals(this.f10239k, rVar.f10239k) && Objects.equals(this.f10242n, rVar.f10242n) && Objects.equals(this.f10243o, rVar.f10243o) && Objects.equals(this.f10232d, rVar.f10232d) && Arrays.equals(this.A, rVar.A) && Objects.equals(this.f10240l, rVar.f10240l) && Objects.equals(this.C, rVar.C) && Objects.equals(this.f10247s, rVar.f10247s) && f(rVar) && Objects.equals(this.f10241m, rVar.f10241m);
        }
        return false;
    }

    public boolean f(r rVar) {
        if (this.f10246r.size() != rVar.f10246r.size()) {
            return false;
        }
        for (int i11 = 0; i11 < this.f10246r.size(); i11++) {
            if (!Arrays.equals((byte[]) this.f10246r.get(i11), (byte[]) rVar.f10246r.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.O == 0) {
            String str = this.f10229a;
            int hashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f10230b;
            int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f10231c.hashCode()) * 31;
            String str3 = this.f10232d;
            int hashCode3 = (((((((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f10233e) * 31) + this.f10234f) * 31) + this.f10235g) * 31) + this.f10236h) * 31) + this.f10237i) * 31;
            String str4 = this.f10239k;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            x xVar = this.f10240l;
            int hashCode5 = (hashCode4 + (xVar == null ? 0 : xVar.hashCode())) * 31;
            Object obj = this.f10241m;
            int hashCode6 = (hashCode5 + (obj == null ? 0 : obj.hashCode())) * 31;
            String str5 = this.f10242n;
            int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f10243o;
            this.O = ((((((((((((((((((((((((((((((((((((hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.f10244p) * 31) + ((int) this.f10248t)) * 31) + this.f10250v) * 31) + this.f10251w) * 31) + Float.floatToIntBits(this.f10252x)) * 31) + this.f10253y) * 31) + Float.floatToIntBits(this.f10254z)) * 31) + this.B) * 31) + this.D) * 31) + this.E) * 31) + this.F) * 31) + this.G) * 31) + this.H) * 31) + this.I) * 31) + this.J) * 31) + this.L) * 31) + this.M) * 31) + this.N;
        }
        return this.O;
    }

    public r j(r rVar) {
        String str;
        if (this == rVar) {
            return this;
        }
        int k11 = y.k(this.f10243o);
        String str2 = rVar.f10229a;
        int i11 = rVar.L;
        int i12 = rVar.M;
        String str3 = rVar.f10230b;
        if (str3 == null) {
            str3 = this.f10230b;
        }
        List list = !rVar.f10231c.isEmpty() ? rVar.f10231c : this.f10231c;
        String str4 = this.f10232d;
        if ((k11 == 3 || k11 == 1) && (str = rVar.f10232d) != null) {
            str4 = str;
        }
        int i13 = this.f10236h;
        if (i13 == -1) {
            i13 = rVar.f10236h;
        }
        int i14 = this.f10237i;
        if (i14 == -1) {
            i14 = rVar.f10237i;
        }
        String str5 = this.f10239k;
        if (str5 == null) {
            String S2 = a1.S(rVar.f10239k, k11);
            if (a1.q1(S2).length == 1) {
                str5 = S2;
            }
        }
        x xVar = this.f10240l;
        x b11 = xVar == null ? rVar.f10240l : xVar.b(rVar.f10240l);
        float f11 = this.f10252x;
        if (f11 == -1.0f && k11 == 2) {
            f11 = rVar.f10252x;
        }
        return b().f0(str2).h0(str3).i0(list).j0(str4).w0(this.f10233e | rVar.f10233e).s0(this.f10234f | rVar.f10234f).Q(i13).p0(i14).S(str5).n0(b11).Y(DrmInitData.createSessionCreationData(rVar.f10247s, this.f10247s)).b0(f11).z0(i11).A0(i12).N();
    }

    public String toString() {
        return "Format(" + this.f10229a + ", " + this.f10230b + ", " + this.f10242n + ", " + this.f10243o + ", " + this.f10239k + ", " + this.f10238j + ", " + this.f10232d + ", [" + this.f10250v + ", " + this.f10251w + ", " + this.f10252x + ", " + this.C + "], [" + this.E + ", " + this.F + "])";
    }
}
