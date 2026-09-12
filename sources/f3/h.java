package f3;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.ParserException;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.p0;
import androidx.media3.container.d;
import androidx.media3.container.i;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import i3.s;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import l2.e0;
import l2.l0;
import l2.m0;
import l2.q0;
import l2.s0;

/* loaded from: classes2.dex */
public class h implements l2.r {
    public static final l2.x M = new l2.x() { // from class: f3.f
        @Override // l2.x
        public /* synthetic */ l2.x a(s.a aVar) {
            return l2.w.d(this, aVar);
        }

        @Override // l2.x
        public /* synthetic */ l2.x b(int i11) {
            return l2.w.b(this, i11);
        }

        @Override // l2.x
        public /* synthetic */ l2.r[] c(Uri uri, Map map) {
            return l2.w.a(this, uri, map);
        }

        @Override // l2.x
        public final l2.r[] createExtractors() {
            l2.r[] s11;
            s11 = h.s();
            return s11;
        }

        @Override // l2.x
        public /* synthetic */ l2.x d(boolean z10) {
            return l2.w.c(this, z10);
        }
    };
    private static final byte[] N = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final androidx.media3.common.r O = new r.b().u0(MimeTypes.APPLICATION_EMSG).N();
    private long A;
    private long B;
    private b C;
    private int D;
    private int E;
    private int F;
    private boolean G;
    private boolean H;
    private l2.t I;
    private s0[] J;
    private s0[] K;
    private boolean L;

    /* renamed from: a, reason: collision with root package name */
    private final s.a f62324a;

    /* renamed from: b, reason: collision with root package name */
    private final int f62325b;

    /* renamed from: c, reason: collision with root package name */
    private final t f62326c;

    /* renamed from: d, reason: collision with root package name */
    private final List f62327d;

    /* renamed from: e, reason: collision with root package name */
    private final SparseArray f62328e;

    /* renamed from: f, reason: collision with root package name */
    private final j0 f62329f;

    /* renamed from: g, reason: collision with root package name */
    private final j0 f62330g;

    /* renamed from: h, reason: collision with root package name */
    private final j0 f62331h;

    /* renamed from: i, reason: collision with root package name */
    private final byte[] f62332i;

    /* renamed from: j, reason: collision with root package name */
    private final j0 f62333j;

    /* renamed from: k, reason: collision with root package name */
    private final p0 f62334k;

    /* renamed from: l, reason: collision with root package name */
    private final w2.c f62335l;

    /* renamed from: m, reason: collision with root package name */
    private final j0 f62336m;

    /* renamed from: n, reason: collision with root package name */
    private final ArrayDeque f62337n;

    /* renamed from: o, reason: collision with root package name */
    private final ArrayDeque f62338o;

    /* renamed from: p, reason: collision with root package name */
    private final androidx.media3.container.i f62339p;

    /* renamed from: q, reason: collision with root package name */
    private final s0 f62340q;

    /* renamed from: r, reason: collision with root package name */
    private ImmutableList f62341r;

    /* renamed from: s, reason: collision with root package name */
    private int f62342s;

    /* renamed from: t, reason: collision with root package name */
    private int f62343t;

    /* renamed from: u, reason: collision with root package name */
    private long f62344u;

    /* renamed from: v, reason: collision with root package name */
    private int f62345v;

    /* renamed from: w, reason: collision with root package name */
    private j0 f62346w;

    /* renamed from: x, reason: collision with root package name */
    private long f62347x;

    /* renamed from: y, reason: collision with root package name */
    private int f62348y;

    /* renamed from: z, reason: collision with root package name */
    private long f62349z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f62350a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f62351b;

        /* renamed from: c, reason: collision with root package name */
        public final int f62352c;

        public a(long j11, boolean z10, int i11) {
            this.f62350a = j11;
            this.f62351b = z10;
            this.f62352c = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final s0 f62353a;

        /* renamed from: d, reason: collision with root package name */
        public w f62356d;

        /* renamed from: e, reason: collision with root package name */
        public c f62357e;

        /* renamed from: f, reason: collision with root package name */
        public int f62358f;

        /* renamed from: g, reason: collision with root package name */
        public int f62359g;

        /* renamed from: h, reason: collision with root package name */
        public int f62360h;

        /* renamed from: i, reason: collision with root package name */
        public int f62361i;

        /* renamed from: j, reason: collision with root package name */
        private final String f62362j;

        /* renamed from: m, reason: collision with root package name */
        private boolean f62365m;

        /* renamed from: b, reason: collision with root package name */
        public final v f62354b = new v();

        /* renamed from: c, reason: collision with root package name */
        public final j0 f62355c = new j0();

        /* renamed from: k, reason: collision with root package name */
        private final j0 f62363k = new j0(1);

        /* renamed from: l, reason: collision with root package name */
        private final j0 f62364l = new j0();

        public b(s0 s0Var, w wVar, c cVar, String str) {
            this.f62353a = s0Var;
            this.f62356d = wVar;
            this.f62357e = cVar;
            this.f62362j = str;
            j(wVar, cVar);
        }

        public int c() {
            int i11 = !this.f62365m ? this.f62356d.f62455g[this.f62358f] : this.f62354b.f62441k[this.f62358f] ? 1 : 0;
            return g() != null ? i11 | 1073741824 : i11;
        }

        public long d() {
            return !this.f62365m ? this.f62356d.f62451c[this.f62358f] : this.f62354b.f62437g[this.f62360h];
        }

        public long e() {
            return !this.f62365m ? this.f62356d.f62454f[this.f62358f] : this.f62354b.c(this.f62358f);
        }

        public int f() {
            return !this.f62365m ? this.f62356d.f62452d[this.f62358f] : this.f62354b.f62439i[this.f62358f];
        }

        public u g() {
            if (!this.f62365m) {
                return null;
            }
            int i11 = ((c) a1.i(this.f62354b.f62431a)).f62311a;
            u uVar = this.f62354b.f62444n;
            if (uVar == null) {
                uVar = this.f62356d.f62449a.b(i11);
            }
            if (uVar == null || !uVar.f62426a) {
                return null;
            }
            return uVar;
        }

        public boolean h() {
            this.f62358f++;
            if (!this.f62365m) {
                return false;
            }
            int i11 = this.f62359g + 1;
            this.f62359g = i11;
            int[] iArr = this.f62354b.f62438h;
            int i12 = this.f62360h;
            if (i11 != iArr[i12]) {
                return true;
            }
            this.f62360h = i12 + 1;
            this.f62359g = 0;
            return false;
        }

        public int i(int i11, int i12) {
            j0 j0Var;
            u g11 = g();
            if (g11 == null) {
                return 0;
            }
            int i13 = g11.f62429d;
            if (i13 != 0) {
                j0Var = this.f62354b.f62445o;
            } else {
                byte[] bArr = (byte[]) a1.i(g11.f62430e);
                this.f62364l.U(bArr, bArr.length);
                j0 j0Var2 = this.f62364l;
                i13 = bArr.length;
                j0Var = j0Var2;
            }
            boolean g12 = this.f62354b.g(this.f62358f);
            boolean z10 = g12 || i12 != 0;
            this.f62363k.e()[0] = (byte) ((z10 ? 128 : 0) | i13);
            this.f62363k.W(0);
            this.f62353a.a(this.f62363k, 1, 1);
            this.f62353a.a(j0Var, i13, 1);
            if (!z10) {
                return i13 + 1;
            }
            if (!g12) {
                this.f62355c.S(8);
                byte[] e11 = this.f62355c.e();
                e11[0] = 0;
                e11[1] = 1;
                e11[2] = (byte) ((i12 >> 8) & 255);
                e11[3] = (byte) (i12 & 255);
                e11[4] = (byte) ((i11 >> 24) & 255);
                e11[5] = (byte) ((i11 >> 16) & 255);
                e11[6] = (byte) ((i11 >> 8) & 255);
                e11[7] = (byte) (i11 & 255);
                this.f62353a.a(this.f62355c, 8, 1);
                return i13 + 9;
            }
            j0 j0Var3 = this.f62354b.f62445o;
            int P = j0Var3.P();
            j0Var3.X(-2);
            int i14 = (P * 6) + 2;
            if (i12 != 0) {
                this.f62355c.S(i14);
                byte[] e12 = this.f62355c.e();
                j0Var3.l(e12, 0, i14);
                int i15 = (((e12[2] & 255) << 8) | (e12[3] & 255)) + i12;
                e12[2] = (byte) ((i15 >> 8) & 255);
                e12[3] = (byte) (i15 & 255);
                j0Var3 = this.f62355c;
            }
            this.f62353a.a(j0Var3, i14, 1);
            return i13 + 1 + i14;
        }

        public void j(w wVar, c cVar) {
            this.f62356d = wVar;
            this.f62357e = cVar;
            this.f62353a.c(wVar.f62449a.f62420g.b().U(this.f62362j).N());
            k();
        }

        public void k() {
            this.f62354b.f();
            this.f62358f = 0;
            this.f62360h = 0;
            this.f62359g = 0;
            this.f62361i = 0;
            this.f62365m = false;
        }

        public void l(long j11) {
            int i11 = this.f62358f;
            while (true) {
                v vVar = this.f62354b;
                if (i11 >= vVar.f62436f || vVar.c(i11) > j11) {
                    return;
                }
                if (this.f62354b.f62441k[i11]) {
                    this.f62361i = i11;
                }
                i11++;
            }
        }

        public void m() {
            u g11 = g();
            if (g11 == null) {
                return;
            }
            j0 j0Var = this.f62354b.f62445o;
            int i11 = g11.f62429d;
            if (i11 != 0) {
                j0Var.X(i11);
            }
            if (this.f62354b.g(this.f62358f)) {
                j0Var.X(j0Var.P() * 6);
            }
        }

        public void n(DrmInitData drmInitData) {
            u b11 = this.f62356d.f62449a.b(((c) a1.i(this.f62354b.f62431a)).f62311a);
            this.f62353a.c(this.f62356d.f62449a.f62420g.b().U(this.f62362j).Y(drmInitData.copyWithSchemeType(b11 != null ? b11.f62427b : null)).N());
        }
    }

    @Deprecated
    public h() {
        this(s.a.f65046a, 32, null, null, ImmutableList.of(), null);
    }

    public h(s.a aVar, int i11) {
        this(aVar, i11, null, null, ImmutableList.of(), null);
    }

    public h(s.a aVar, int i11, p0 p0Var, t tVar, List list, s0 s0Var) {
        this.f62324a = aVar;
        this.f62325b = i11;
        this.f62334k = p0Var;
        this.f62326c = tVar;
        this.f62327d = Collections.unmodifiableList(list);
        this.f62340q = s0Var;
        this.f62335l = new w2.c();
        this.f62336m = new j0(16);
        this.f62329f = new j0(androidx.media3.container.g.f10675a);
        this.f62330g = new j0(6);
        this.f62331h = new j0();
        byte[] bArr = new byte[16];
        this.f62332i = bArr;
        this.f62333j = new j0(bArr);
        this.f62337n = new ArrayDeque();
        this.f62338o = new ArrayDeque();
        this.f62328e = new SparseArray();
        this.f62341r = ImmutableList.of();
        this.A = C.TIME_UNSET;
        this.f62349z = C.TIME_UNSET;
        this.B = C.TIME_UNSET;
        this.I = l2.t.f68806n1;
        this.J = new s0[0];
        this.K = new s0[0];
        this.f62339p = new androidx.media3.container.i(new i.b() { // from class: f3.g
            @Override // androidx.media3.container.i.b
            public final void a(long j11, j0 j0Var) {
                h.this.r(j11, j0Var);
            }
        });
    }

    private static long A(j0 j0Var) {
        j0Var.W(8);
        return f3.b.p(j0Var.q()) == 0 ? j0Var.J() : j0Var.O();
    }

    private static void B(d.b bVar, SparseArray sparseArray, boolean z10, int i11, byte[] bArr) {
        int size = bVar.f10668d.size();
        for (int i12 = 0; i12 < size; i12++) {
            d.b bVar2 = (d.b) bVar.f10668d.get(i12);
            if (bVar2.f10665a == 1953653094) {
                K(bVar2, sparseArray, z10, i11, bArr);
            }
        }
    }

    private static void C(j0 j0Var, v vVar) {
        j0Var.W(8);
        int q11 = j0Var.q();
        if ((f3.b.o(q11) & 1) == 1) {
            j0Var.X(8);
        }
        int L = j0Var.L();
        if (L == 1) {
            vVar.f62434d += f3.b.p(q11) == 0 ? j0Var.J() : j0Var.O();
        } else {
            throw ParserException.createForMalformedContainer("Unexpected saio entry count: " + L, null);
        }
    }

    private static void D(u uVar, j0 j0Var, v vVar) {
        int i11;
        int i12 = uVar.f62429d;
        j0Var.W(8);
        if ((f3.b.o(j0Var.q()) & 1) == 1) {
            j0Var.X(8);
        }
        int H = j0Var.H();
        int L = j0Var.L();
        if (L > vVar.f62436f) {
            throw ParserException.createForMalformedContainer("Saiz sample count " + L + " is greater than fragment sample count" + vVar.f62436f, null);
        }
        if (H == 0) {
            boolean[] zArr = vVar.f62443m;
            i11 = 0;
            for (int i13 = 0; i13 < L; i13++) {
                int H2 = j0Var.H();
                i11 += H2;
                zArr[i13] = H2 > i12;
            }
        } else {
            i11 = H * L;
            Arrays.fill(vVar.f62443m, 0, L, H > i12);
        }
        Arrays.fill(vVar.f62443m, L, vVar.f62436f, false);
        if (i11 > 0) {
            vVar.d(i11);
        }
    }

    private static void E(d.b bVar, String str, v vVar) {
        byte[] bArr = null;
        j0 j0Var = null;
        j0 j0Var2 = null;
        for (int i11 = 0; i11 < bVar.f10667c.size(); i11++) {
            d.c cVar = (d.c) bVar.f10667c.get(i11);
            j0 j0Var3 = cVar.f10669b;
            int i12 = cVar.f10665a;
            if (i12 == 1935828848) {
                j0Var3.W(12);
                if (j0Var3.q() == 1936025959) {
                    j0Var = j0Var3;
                }
            } else if (i12 == 1936158820) {
                j0Var3.W(12);
                if (j0Var3.q() == 1936025959) {
                    j0Var2 = j0Var3;
                }
            }
        }
        if (j0Var == null || j0Var2 == null) {
            return;
        }
        j0Var.W(8);
        int p11 = f3.b.p(j0Var.q());
        j0Var.X(4);
        if (p11 == 1) {
            j0Var.X(4);
        }
        if (j0Var.q() != 1) {
            throw ParserException.createForUnsupportedContainerFeature("Entry count in sbgp != 1 (unsupported).");
        }
        j0Var2.W(8);
        int p12 = f3.b.p(j0Var2.q());
        j0Var2.X(4);
        if (p12 == 1) {
            if (j0Var2.J() == 0) {
                throw ParserException.createForUnsupportedContainerFeature("Variable length description in sgpd found (unsupported)");
            }
        } else if (p12 >= 2) {
            j0Var2.X(4);
        }
        if (j0Var2.J() != 1) {
            throw ParserException.createForUnsupportedContainerFeature("Entry count in sgpd != 1 (unsupported).");
        }
        j0Var2.X(1);
        int H = j0Var2.H();
        int i13 = (H & 240) >> 4;
        int i14 = H & 15;
        boolean z10 = j0Var2.H() == 1;
        if (z10) {
            int H2 = j0Var2.H();
            byte[] bArr2 = new byte[16];
            j0Var2.l(bArr2, 0, 16);
            if (H2 == 0) {
                int H3 = j0Var2.H();
                bArr = new byte[H3];
                j0Var2.l(bArr, 0, H3);
            }
            vVar.f62442l = true;
            vVar.f62444n = new u(z10, str, H2, bArr2, i13, i14, bArr);
        }
    }

    private static void F(j0 j0Var, int i11, v vVar) {
        j0Var.W(i11 + 8);
        int o11 = f3.b.o(j0Var.q());
        if ((o11 & 1) != 0) {
            throw ParserException.createForUnsupportedContainerFeature("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z10 = (o11 & 2) != 0;
        int L = j0Var.L();
        if (L == 0) {
            Arrays.fill(vVar.f62443m, 0, vVar.f62436f, false);
            return;
        }
        if (L == vVar.f62436f) {
            Arrays.fill(vVar.f62443m, 0, L, z10);
            vVar.d(j0Var.a());
            vVar.a(j0Var);
        } else {
            throw ParserException.createForMalformedContainer("Senc sample count " + L + " is different from fragment sample count" + vVar.f62436f, null);
        }
    }

    private static void G(j0 j0Var, v vVar) {
        F(j0Var, 0, vVar);
    }

    private static Pair H(j0 j0Var, long j11) {
        long O2;
        long O3;
        j0Var.W(8);
        int p11 = f3.b.p(j0Var.q());
        j0Var.X(4);
        long J = j0Var.J();
        if (p11 == 0) {
            O2 = j0Var.J();
            O3 = j0Var.J();
        } else {
            O2 = j0Var.O();
            O3 = j0Var.O();
        }
        long j12 = O2;
        long j13 = j11 + O3;
        long e12 = a1.e1(j12, 1000000L, J);
        j0Var.X(2);
        int P = j0Var.P();
        int[] iArr = new int[P];
        long[] jArr = new long[P];
        long[] jArr2 = new long[P];
        long[] jArr3 = new long[P];
        long j14 = e12;
        int i11 = 0;
        long j15 = j12;
        while (i11 < P) {
            int q11 = j0Var.q();
            if ((q11 & Integer.MIN_VALUE) != 0) {
                throw ParserException.createForMalformedContainer("Unhandled indirect reference", null);
            }
            long J2 = j0Var.J();
            iArr[i11] = q11 & Integer.MAX_VALUE;
            jArr[i11] = j13;
            jArr3[i11] = j14;
            long j16 = j15 + J2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i12 = P;
            long e13 = a1.e1(j16, 1000000L, J);
            jArr4[i11] = e13 - jArr5[i11];
            j0Var.X(4);
            j13 += r1[i11];
            i11++;
            iArr = iArr;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            P = i12;
            j15 = j16;
            j14 = e13;
        }
        return Pair.create(Long.valueOf(e12), new l2.h(iArr, jArr, jArr2, jArr3));
    }

    private static long I(j0 j0Var) {
        j0Var.W(8);
        return f3.b.p(j0Var.q()) == 1 ? j0Var.O() : j0Var.J();
    }

    private static b J(j0 j0Var, SparseArray sparseArray, boolean z10) {
        j0Var.W(8);
        int o11 = f3.b.o(j0Var.q());
        b bVar = (b) (z10 ? sparseArray.valueAt(0) : sparseArray.get(j0Var.q()));
        if (bVar == null) {
            return null;
        }
        if ((o11 & 1) != 0) {
            long O2 = j0Var.O();
            v vVar = bVar.f62354b;
            vVar.f62433c = O2;
            vVar.f62434d = O2;
        }
        c cVar = bVar.f62357e;
        bVar.f62354b.f62431a = new c((o11 & 2) != 0 ? j0Var.q() - 1 : cVar.f62311a, (o11 & 8) != 0 ? j0Var.q() : cVar.f62312b, (o11 & 16) != 0 ? j0Var.q() : cVar.f62313c, (o11 & 32) != 0 ? j0Var.q() : cVar.f62314d);
        return bVar;
    }

    private static void K(d.b bVar, SparseArray sparseArray, boolean z10, int i11, byte[] bArr) {
        b J = J(((d.c) androidx.media3.common.util.a.e(bVar.e(1952868452))).f10669b, sparseArray, z10);
        if (J == null) {
            return;
        }
        v vVar = J.f62354b;
        long j11 = vVar.f62447q;
        boolean z11 = vVar.f62448r;
        J.k();
        J.f62365m = true;
        d.c e11 = bVar.e(1952867444);
        if (e11 == null || (i11 & 2) != 0) {
            vVar.f62447q = j11;
            vVar.f62448r = z11;
        } else {
            vVar.f62447q = I(e11.f10669b);
            vVar.f62448r = true;
        }
        N(bVar, J, i11);
        u b11 = J.f62356d.f62449a.b(((c) androidx.media3.common.util.a.e(vVar.f62431a)).f62311a);
        d.c e12 = bVar.e(1935763834);
        if (e12 != null) {
            D((u) androidx.media3.common.util.a.e(b11), e12.f10669b, vVar);
        }
        d.c e13 = bVar.e(1935763823);
        if (e13 != null) {
            C(e13.f10669b, vVar);
        }
        d.c e14 = bVar.e(1936027235);
        if (e14 != null) {
            G(e14.f10669b, vVar);
        }
        E(bVar, b11 != null ? b11.f62427b : null, vVar);
        int size = bVar.f10667c.size();
        for (int i12 = 0; i12 < size; i12++) {
            d.c cVar = (d.c) bVar.f10667c.get(i12);
            if (cVar.f10665a == 1970628964) {
                O(cVar.f10669b, vVar, bArr);
            }
        }
    }

    private static Pair L(j0 j0Var) {
        j0Var.W(12);
        return Pair.create(Integer.valueOf(j0Var.q()), new c(j0Var.q() - 1, j0Var.q(), j0Var.q(), j0Var.q()));
    }

    private static int M(b bVar, int i11, int i12, j0 j0Var, int i13) {
        boolean z10;
        int i14;
        boolean z11;
        int i15;
        boolean z12;
        boolean z13;
        boolean z14;
        int i16;
        b bVar2 = bVar;
        j0Var.W(8);
        int o11 = f3.b.o(j0Var.q());
        t tVar = bVar2.f62356d.f62449a;
        v vVar = bVar2.f62354b;
        c cVar = (c) a1.i(vVar.f62431a);
        vVar.f62438h[i11] = j0Var.L();
        long[] jArr = vVar.f62437g;
        long j11 = vVar.f62433c;
        jArr[i11] = j11;
        if ((o11 & 1) != 0) {
            jArr[i11] = j11 + j0Var.q();
        }
        boolean z15 = (o11 & 4) != 0;
        int i17 = cVar.f62314d;
        if (z15) {
            i17 = j0Var.q();
        }
        boolean z16 = (o11 & 256) != 0;
        boolean z17 = (o11 & 512) != 0;
        boolean z18 = (o11 & 1024) != 0;
        boolean z19 = (o11 & 2048) != 0;
        long j12 = q(tVar) ? ((long[]) a1.i(tVar.f62423j))[0] : 0L;
        int[] iArr = vVar.f62439i;
        long[] jArr2 = vVar.f62440j;
        boolean[] zArr = vVar.f62441k;
        int i18 = i17;
        boolean z20 = tVar.f62415b == 2 && (i12 & 1) != 0;
        int i19 = i13 + vVar.f62438h[i11];
        boolean z21 = z20;
        long j13 = tVar.f62416c;
        long j14 = vVar.f62447q;
        int i20 = i13;
        while (i20 < i19) {
            int i21 = i(z16 ? j0Var.q() : cVar.f62312b);
            if (z17) {
                i14 = j0Var.q();
                z10 = z16;
            } else {
                z10 = z16;
                i14 = cVar.f62313c;
            }
            int i22 = i(i14);
            if (z18) {
                z11 = z15;
                i15 = j0Var.q();
            } else if (i20 == 0 && z15) {
                z11 = z15;
                i15 = i18;
            } else {
                z11 = z15;
                i15 = cVar.f62314d;
            }
            if (z19) {
                z12 = z19;
                z13 = z17;
                z14 = z18;
                i16 = j0Var.q();
            } else {
                z12 = z19;
                z13 = z17;
                z14 = z18;
                i16 = 0;
            }
            long e12 = a1.e1((i16 + j14) - j12, 1000000L, j13);
            jArr2[i20] = e12;
            if (!vVar.f62448r) {
                jArr2[i20] = e12 + bVar2.f62356d.f62456h;
            }
            iArr[i20] = i22;
            zArr[i20] = ((i15 >> 16) & 1) == 0 && (!z21 || i20 == 0);
            j14 += i21;
            i20++;
            bVar2 = bVar;
            z16 = z10;
            z15 = z11;
            z19 = z12;
            z17 = z13;
            z18 = z14;
        }
        vVar.f62447q = j14;
        return i19;
    }

    private static void N(d.b bVar, b bVar2, int i11) {
        List list = bVar.f10667c;
        int size = list.size();
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < size; i14++) {
            d.c cVar = (d.c) list.get(i14);
            if (cVar.f10665a == 1953658222) {
                j0 j0Var = cVar.f10669b;
                j0Var.W(12);
                int L = j0Var.L();
                if (L > 0) {
                    i13 += L;
                    i12++;
                }
            }
        }
        bVar2.f62360h = 0;
        bVar2.f62359g = 0;
        bVar2.f62358f = 0;
        bVar2.f62354b.e(i12, i13);
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            d.c cVar2 = (d.c) list.get(i17);
            if (cVar2.f10665a == 1953658222) {
                i16 = M(bVar2, i15, i11, cVar2.f10669b, i16);
                i15++;
            }
        }
    }

    private static void O(j0 j0Var, v vVar, byte[] bArr) {
        j0Var.W(8);
        j0Var.l(bArr, 0, 16);
        if (Arrays.equals(bArr, N)) {
            F(j0Var, 16, vVar);
        }
    }

    private void P(long j11) {
        while (!this.f62337n.isEmpty() && ((d.b) this.f62337n.peek()).f10666b == j11) {
            u((d.b) this.f62337n.pop());
        }
        k();
    }

    private boolean Q(l2.s sVar) {
        if (this.f62345v == 0) {
            if (!sVar.readFully(this.f62336m.e(), 0, 8, true)) {
                return false;
            }
            this.f62345v = 8;
            this.f62336m.W(0);
            this.f62344u = this.f62336m.J();
            this.f62343t = this.f62336m.q();
        }
        long j11 = this.f62344u;
        if (j11 == 1) {
            sVar.readFully(this.f62336m.e(), 8, 8);
            this.f62345v += 8;
            this.f62344u = this.f62336m.O();
        } else if (j11 == 0) {
            long length = sVar.getLength();
            if (length == -1 && !this.f62337n.isEmpty()) {
                length = ((d.b) this.f62337n.peek()).f10666b;
            }
            if (length != -1) {
                this.f62344u = (length - sVar.getPosition()) + this.f62345v;
            }
        }
        if (this.f62344u < this.f62345v) {
            throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
        }
        long position = sVar.getPosition() - this.f62345v;
        int i11 = this.f62343t;
        if ((i11 == 1836019558 || i11 == 1835295092) && !this.L) {
            this.I.f(new m0.b(this.A, position));
            this.L = true;
        }
        if (this.f62343t == 1836019558) {
            int size = this.f62328e.size();
            for (int i12 = 0; i12 < size; i12++) {
                v vVar = ((b) this.f62328e.valueAt(i12)).f62354b;
                vVar.f62432b = position;
                vVar.f62434d = position;
                vVar.f62433c = position;
            }
        }
        int i13 = this.f62343t;
        if (i13 == 1835295092) {
            this.C = null;
            this.f62347x = position + this.f62344u;
            this.f62342s = 2;
            return true;
        }
        if (U(i13)) {
            long position2 = (sVar.getPosition() + this.f62344u) - 8;
            this.f62337n.push(new d.b(this.f62343t, position2));
            if (this.f62344u == this.f62345v) {
                P(position2);
            } else {
                k();
            }
        } else if (V(this.f62343t)) {
            if (this.f62345v != 8) {
                throw ParserException.createForUnsupportedContainerFeature("Leaf atom defines extended atom size (unsupported).");
            }
            if (this.f62344u > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Leaf atom with length > 2147483647 (unsupported).");
            }
            j0 j0Var = new j0((int) this.f62344u);
            System.arraycopy(this.f62336m.e(), 0, j0Var.e(), 0, 8);
            this.f62346w = j0Var;
            this.f62342s = 1;
        } else {
            if (this.f62344u > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Skipping atom with length > 2147483647 (unsupported).");
            }
            this.f62346w = null;
            this.f62342s = 1;
        }
        return true;
    }

    private void R(l2.s sVar) {
        int i11 = (int) (this.f62344u - this.f62345v);
        j0 j0Var = this.f62346w;
        if (j0Var != null) {
            sVar.readFully(j0Var.e(), 8, i11);
            w(new d.c(this.f62343t, j0Var), sVar.getPosition());
        } else {
            sVar.skipFully(i11);
        }
        P(sVar.getPosition());
    }

    private void S(l2.s sVar) {
        int size = this.f62328e.size();
        long j11 = Long.MAX_VALUE;
        b bVar = null;
        for (int i11 = 0; i11 < size; i11++) {
            v vVar = ((b) this.f62328e.valueAt(i11)).f62354b;
            if (vVar.f62446p) {
                long j12 = vVar.f62434d;
                if (j12 < j11) {
                    bVar = (b) this.f62328e.valueAt(i11);
                    j11 = j12;
                }
            }
        }
        if (bVar == null) {
            this.f62342s = 3;
            return;
        }
        int position = (int) (j11 - sVar.getPosition());
        if (position < 0) {
            throw ParserException.createForMalformedContainer("Offset to encryption data was negative.", null);
        }
        sVar.skipFully(position);
        bVar.f62354b.b(sVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0111, code lost:
    
        if ((r5.f62424k + r12) <= (r16.D - r16.E)) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean T(l2.s r17) {
        /*
            Method dump skipped, instructions count: 573
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.h.T(l2.s):boolean");
    }

    private static boolean U(int i11) {
        return i11 == 1836019574 || i11 == 1953653099 || i11 == 1835297121 || i11 == 1835626086 || i11 == 1937007212 || i11 == 1836019558 || i11 == 1953653094 || i11 == 1836475768 || i11 == 1701082227;
    }

    private static boolean V(int i11) {
        return i11 == 1751411826 || i11 == 1835296868 || i11 == 1836476516 || i11 == 1936286840 || i11 == 1937011556 || i11 == 1937011827 || i11 == 1668576371 || i11 == 1937011555 || i11 == 1937011578 || i11 == 1937013298 || i11 == 1937007471 || i11 == 1668232756 || i11 == 1937011571 || i11 == 1952867444 || i11 == 1952868452 || i11 == 1953196132 || i11 == 1953654136 || i11 == 1953658222 || i11 == 1886614376 || i11 == 1935763834 || i11 == 1935763823 || i11 == 1936027235 || i11 == 1970628964 || i11 == 1935828848 || i11 == 1936158820 || i11 == 1701606260 || i11 == 1835362404 || i11 == 1701671783;
    }

    private boolean h(androidx.media3.common.r rVar) {
        return Objects.equals(rVar.f10243o, MimeTypes.VIDEO_H264) ? (this.f62325b & 64) != 0 : Objects.equals(rVar.f10243o, MimeTypes.VIDEO_H265) && (this.f62325b & 128) != 0;
    }

    private static int i(int i11) {
        if (i11 >= 0) {
            return i11;
        }
        throw ParserException.createForMalformedContainer("Unexpected negative value: " + i11, null);
    }

    public static int j(int i11) {
        int i12 = (i11 & 1) != 0 ? 64 : 0;
        return (i11 & 2) != 0 ? i12 | 128 : i12;
    }

    private void k() {
        this.f62342s = 0;
        this.f62345v = 0;
    }

    private c l(SparseArray sparseArray, int i11) {
        return sparseArray.size() == 1 ? (c) sparseArray.valueAt(0) : (c) androidx.media3.common.util.a.e((c) sparseArray.get(i11));
    }

    private static DrmInitData m(List list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < size; i11++) {
            d.c cVar = (d.c) list.get(i11);
            if (cVar.f10665a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] e11 = cVar.f10669b.e();
                UUID f11 = p.f(e11);
                if (f11 == null) {
                    androidx.media3.common.util.u.h("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(f11, MimeTypes.VIDEO_MP4, e11));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private static b n(SparseArray sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j11 = Long.MAX_VALUE;
        for (int i11 = 0; i11 < size; i11++) {
            b bVar2 = (b) sparseArray.valueAt(i11);
            if ((bVar2.f62365m || bVar2.f62358f != bVar2.f62356d.f62450b) && (!bVar2.f62365m || bVar2.f62360h != bVar2.f62354b.f62435e)) {
                long d11 = bVar2.d();
                if (d11 < j11) {
                    bVar = bVar2;
                    j11 = d11;
                }
            }
        }
        return bVar;
    }

    private void p() {
        int i11;
        s0[] s0VarArr = new s0[2];
        this.J = s0VarArr;
        s0 s0Var = this.f62340q;
        int i12 = 0;
        if (s0Var != null) {
            s0VarArr[0] = s0Var;
            i11 = 1;
        } else {
            i11 = 0;
        }
        int i13 = 100;
        if ((this.f62325b & 4) != 0) {
            s0VarArr[i11] = this.I.track(100, 5);
            i13 = 101;
            i11++;
        }
        s0[] s0VarArr2 = (s0[]) a1.X0(this.J, i11);
        this.J = s0VarArr2;
        for (s0 s0Var2 : s0VarArr2) {
            s0Var2.c(O);
        }
        this.K = new s0[this.f62327d.size()];
        while (i12 < this.K.length) {
            s0 track = this.I.track(i13, 3);
            track.c((androidx.media3.common.r) this.f62327d.get(i12));
            this.K[i12] = track;
            i12++;
            i13++;
        }
    }

    private static boolean q(t tVar) {
        long[] jArr = tVar.f62422i;
        if (jArr == null || jArr.length != 1 || tVar.f62423j == null) {
            return false;
        }
        long j11 = jArr[0];
        return j11 == 0 || a1.e1(j11, 1000000L, tVar.f62417d) + a1.e1(tVar.f62423j[0], 1000000L, tVar.f62416c) >= tVar.f62418e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(long j11, j0 j0Var) {
        l2.g.a(j11, j0Var, this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l2.r[] s() {
        return new l2.r[]{new h(s.a.f65046a, 32)};
    }

    private void u(d.b bVar) {
        int i11 = bVar.f10665a;
        if (i11 == 1836019574) {
            y(bVar);
        } else if (i11 == 1836019558) {
            x(bVar);
        } else {
            if (this.f62337n.isEmpty()) {
                return;
            }
            ((d.b) this.f62337n.peek()).b(bVar);
        }
    }

    private void v(j0 j0Var) {
        long e12;
        String str;
        long e13;
        String str2;
        long J;
        long j11;
        if (this.J.length == 0) {
            return;
        }
        j0Var.W(8);
        int p11 = f3.b.p(j0Var.q());
        if (p11 == 0) {
            String str3 = (String) androidx.media3.common.util.a.e(j0Var.B());
            String str4 = (String) androidx.media3.common.util.a.e(j0Var.B());
            long J2 = j0Var.J();
            e12 = a1.e1(j0Var.J(), 1000000L, J2);
            long j12 = this.B;
            long j13 = j12 != C.TIME_UNSET ? j12 + e12 : -9223372036854775807L;
            str = str3;
            e13 = a1.e1(j0Var.J(), 1000L, J2);
            str2 = str4;
            J = j0Var.J();
            j11 = j13;
        } else {
            if (p11 != 1) {
                androidx.media3.common.util.u.h("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + p11);
                return;
            }
            long J3 = j0Var.J();
            j11 = a1.e1(j0Var.O(), 1000000L, J3);
            long e14 = a1.e1(j0Var.J(), 1000L, J3);
            long J4 = j0Var.J();
            str = (String) androidx.media3.common.util.a.e(j0Var.B());
            e13 = e14;
            J = J4;
            str2 = (String) androidx.media3.common.util.a.e(j0Var.B());
            e12 = -9223372036854775807L;
        }
        byte[] bArr = new byte[j0Var.a()];
        j0Var.l(bArr, 0, j0Var.a());
        j0 j0Var2 = new j0(this.f62335l.a(new w2.a(str, str2, e13, J, bArr)));
        int a11 = j0Var2.a();
        for (s0 s0Var : this.J) {
            j0Var2.W(0);
            s0Var.b(j0Var2, a11);
        }
        if (j11 == C.TIME_UNSET) {
            this.f62338o.addLast(new a(e12, true, a11));
            this.f62348y += a11;
            return;
        }
        if (!this.f62338o.isEmpty()) {
            this.f62338o.addLast(new a(j11, false, a11));
            this.f62348y += a11;
            return;
        }
        p0 p0Var = this.f62334k;
        if (p0Var != null && !p0Var.g()) {
            this.f62338o.addLast(new a(j11, false, a11));
            this.f62348y += a11;
            return;
        }
        p0 p0Var2 = this.f62334k;
        if (p0Var2 != null) {
            j11 = p0Var2.a(j11);
        }
        for (s0 s0Var2 : this.J) {
            s0Var2.d(j11, 1, a11, 0, null);
        }
    }

    private void w(d.c cVar, long j11) {
        if (!this.f62337n.isEmpty()) {
            ((d.b) this.f62337n.peek()).c(cVar);
            return;
        }
        int i11 = cVar.f10665a;
        if (i11 != 1936286840) {
            if (i11 == 1701671783) {
                v(cVar.f10669b);
            }
        } else {
            Pair H = H(cVar.f10669b, j11);
            this.B = ((Long) H.first).longValue();
            this.I.f((m0) H.second);
            this.L = true;
        }
    }

    private void x(d.b bVar) {
        B(bVar, this.f62328e, this.f62326c != null, this.f62325b, this.f62332i);
        DrmInitData m11 = m(bVar.f10667c);
        if (m11 != null) {
            int size = this.f62328e.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((b) this.f62328e.valueAt(i11)).n(m11);
            }
        }
        if (this.f62349z != C.TIME_UNSET) {
            int size2 = this.f62328e.size();
            for (int i12 = 0; i12 < size2; i12++) {
                ((b) this.f62328e.valueAt(i12)).l(this.f62349z);
            }
            this.f62349z = C.TIME_UNSET;
        }
    }

    private void y(d.b bVar) {
        int i11 = 0;
        androidx.media3.common.util.a.h(this.f62326c == null, "Unexpected moov box.");
        DrmInitData m11 = m(bVar.f10667c);
        d.b bVar2 = (d.b) androidx.media3.common.util.a.e(bVar.d(1836475768));
        SparseArray sparseArray = new SparseArray();
        int size = bVar2.f10667c.size();
        long j11 = -9223372036854775807L;
        for (int i12 = 0; i12 < size; i12++) {
            d.c cVar = (d.c) bVar2.f10667c.get(i12);
            int i13 = cVar.f10665a;
            if (i13 == 1953654136) {
                Pair L = L(cVar.f10669b);
                sparseArray.put(((Integer) L.first).intValue(), (c) L.second);
            } else if (i13 == 1835362404) {
                j11 = A(cVar.f10669b);
            }
        }
        List G = f3.b.G(bVar, new e0(), j11, m11, (this.f62325b & 16) != 0, false, new com.google.common.base.f() { // from class: f3.e
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return h.this.t((t) obj);
            }
        });
        int size2 = G.size();
        if (this.f62328e.size() != 0) {
            androidx.media3.common.util.a.g(this.f62328e.size() == size2);
            while (i11 < size2) {
                w wVar = (w) G.get(i11);
                t tVar = wVar.f62449a;
                ((b) this.f62328e.get(tVar.f62414a)).j(wVar, l(sparseArray, tVar.f62414a));
                i11++;
            }
            return;
        }
        String b11 = k.b(G);
        while (i11 < size2) {
            w wVar2 = (w) G.get(i11);
            t tVar2 = wVar2.f62449a;
            s0 track = this.I.track(i11, tVar2.f62415b);
            track.f(tVar2.f62418e);
            this.f62328e.put(tVar2.f62414a, new b(track, wVar2, l(sparseArray, tVar2.f62414a), b11));
            this.A = Math.max(this.A, tVar2.f62418e);
            i11++;
        }
        this.I.endTracks();
    }

    private void z(long j11) {
        while (!this.f62338o.isEmpty()) {
            a aVar = (a) this.f62338o.removeFirst();
            this.f62348y -= aVar.f62352c;
            long j12 = aVar.f62350a;
            if (aVar.f62351b) {
                j12 += j11;
            }
            p0 p0Var = this.f62334k;
            if (p0Var != null) {
                j12 = p0Var.a(j12);
            }
            for (s0 s0Var : this.J) {
                s0Var.d(j12, 1, aVar.f62352c, this.f62348y, null);
            }
        }
    }

    @Override // l2.r
    public void b(l2.t tVar) {
        if ((this.f62325b & 32) == 0) {
            tVar = new i3.t(tVar, this.f62324a);
        }
        this.I = tVar;
        k();
        p();
        t tVar2 = this.f62326c;
        if (tVar2 != null) {
            this.f62328e.put(0, new b(this.I.track(0, tVar2.f62415b), new w(this.f62326c, new long[0], new int[0], 0, new long[0], new int[0], 0L), new c(0, 0, 0, 0), k.a(this.f62326c.f62420g)));
            this.I.endTracks();
        }
    }

    @Override // l2.r
    public int c(l2.s sVar, l0 l0Var) {
        while (true) {
            int i11 = this.f62342s;
            if (i11 != 0) {
                if (i11 == 1) {
                    R(sVar);
                } else if (i11 == 2) {
                    S(sVar);
                } else if (T(sVar)) {
                    return 0;
                }
            } else if (!Q(sVar)) {
                this.f62339p.d();
                return -1;
            }
        }
    }

    @Override // l2.r
    public boolean d(l2.s sVar) {
        q0 b11 = s.b(sVar);
        this.f62341r = b11 != null ? ImmutableList.of(b11) : ImmutableList.of();
        return b11 == null;
    }

    @Override // l2.r
    public /* synthetic */ l2.r e() {
        return l2.q.b(this);
    }

    @Override // l2.r
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public ImmutableList f() {
        return this.f62341r;
    }

    @Override // l2.r
    public void release() {
    }

    @Override // l2.r
    public void seek(long j11, long j12) {
        int size = this.f62328e.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((b) this.f62328e.valueAt(i11)).k();
        }
        this.f62338o.clear();
        this.f62348y = 0;
        this.f62339p.b();
        this.f62349z = j12;
        this.f62337n.clear();
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public t t(t tVar) {
        return tVar;
    }
}
