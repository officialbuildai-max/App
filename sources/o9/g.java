package o9;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.x;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import g9.a0;
import g9.b0;
import g9.e0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import o9.a;

/* loaded from: classes4.dex */
public class g implements g9.l {
    public static final g9.r I = new g9.r() { // from class: o9.e
        @Override // g9.r
        public /* synthetic */ g9.l[] c(Uri uri, Map map) {
            return g9.q.a(this, uri, map);
        }

        @Override // g9.r
        public final g9.l[] createExtractors() {
            g9.l[] k11;
            k11 = g.k();
            return k11;
        }
    };
    private static final byte[] J = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final o1 K = new o1.b().e0(MimeTypes.APPLICATION_EMSG).E();
    private int A;
    private int B;
    private int C;
    private boolean D;
    private g9.n E;
    private e0[] F;
    private e0[] G;
    private boolean H;

    /* renamed from: a, reason: collision with root package name */
    private final int f70915a;

    /* renamed from: b, reason: collision with root package name */
    private final o f70916b;

    /* renamed from: c, reason: collision with root package name */
    private final List f70917c;

    /* renamed from: d, reason: collision with root package name */
    private final SparseArray f70918d;

    /* renamed from: e, reason: collision with root package name */
    private final d0 f70919e;

    /* renamed from: f, reason: collision with root package name */
    private final d0 f70920f;

    /* renamed from: g, reason: collision with root package name */
    private final d0 f70921g;

    /* renamed from: h, reason: collision with root package name */
    private final byte[] f70922h;

    /* renamed from: i, reason: collision with root package name */
    private final d0 f70923i;

    /* renamed from: j, reason: collision with root package name */
    private final l0 f70924j;

    /* renamed from: k, reason: collision with root package name */
    private final com.google.android.exoplayer2.metadata.emsg.b f70925k;

    /* renamed from: l, reason: collision with root package name */
    private final d0 f70926l;

    /* renamed from: m, reason: collision with root package name */
    private final ArrayDeque f70927m;

    /* renamed from: n, reason: collision with root package name */
    private final ArrayDeque f70928n;

    /* renamed from: o, reason: collision with root package name */
    private final e0 f70929o;

    /* renamed from: p, reason: collision with root package name */
    private int f70930p;

    /* renamed from: q, reason: collision with root package name */
    private int f70931q;

    /* renamed from: r, reason: collision with root package name */
    private long f70932r;

    /* renamed from: s, reason: collision with root package name */
    private int f70933s;

    /* renamed from: t, reason: collision with root package name */
    private d0 f70934t;

    /* renamed from: u, reason: collision with root package name */
    private long f70935u;

    /* renamed from: v, reason: collision with root package name */
    private int f70936v;

    /* renamed from: w, reason: collision with root package name */
    private long f70937w;

    /* renamed from: x, reason: collision with root package name */
    private long f70938x;

    /* renamed from: y, reason: collision with root package name */
    private long f70939y;

    /* renamed from: z, reason: collision with root package name */
    private b f70940z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f70941a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f70942b;

        /* renamed from: c, reason: collision with root package name */
        public final int f70943c;

        public a(long j11, boolean z10, int i11) {
            this.f70941a = j11;
            this.f70942b = z10;
            this.f70943c = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final e0 f70944a;

        /* renamed from: d, reason: collision with root package name */
        public r f70947d;

        /* renamed from: e, reason: collision with root package name */
        public c f70948e;

        /* renamed from: f, reason: collision with root package name */
        public int f70949f;

        /* renamed from: g, reason: collision with root package name */
        public int f70950g;

        /* renamed from: h, reason: collision with root package name */
        public int f70951h;

        /* renamed from: i, reason: collision with root package name */
        public int f70952i;

        /* renamed from: l, reason: collision with root package name */
        private boolean f70955l;

        /* renamed from: b, reason: collision with root package name */
        public final q f70945b = new q();

        /* renamed from: c, reason: collision with root package name */
        public final d0 f70946c = new d0();

        /* renamed from: j, reason: collision with root package name */
        private final d0 f70953j = new d0(1);

        /* renamed from: k, reason: collision with root package name */
        private final d0 f70954k = new d0();

        public b(e0 e0Var, r rVar, c cVar) {
            this.f70944a = e0Var;
            this.f70947d = rVar;
            this.f70948e = cVar;
            j(rVar, cVar);
        }

        public int c() {
            int i11 = !this.f70955l ? this.f70947d.f71039g[this.f70949f] : this.f70945b.f71025k[this.f70949f] ? 1 : 0;
            return g() != null ? i11 | 1073741824 : i11;
        }

        public long d() {
            return !this.f70955l ? this.f70947d.f71035c[this.f70949f] : this.f70945b.f71021g[this.f70951h];
        }

        public long e() {
            return !this.f70955l ? this.f70947d.f71038f[this.f70949f] : this.f70945b.c(this.f70949f);
        }

        public int f() {
            return !this.f70955l ? this.f70947d.f71036d[this.f70949f] : this.f70945b.f71023i[this.f70949f];
        }

        public p g() {
            if (!this.f70955l) {
                return null;
            }
            int i11 = ((c) p0.j(this.f70945b.f71015a)).f70904a;
            p pVar = this.f70945b.f71028n;
            if (pVar == null) {
                pVar = this.f70947d.f71033a.a(i11);
            }
            if (pVar == null || !pVar.f71010a) {
                return null;
            }
            return pVar;
        }

        public boolean h() {
            this.f70949f++;
            if (!this.f70955l) {
                return false;
            }
            int i11 = this.f70950g + 1;
            this.f70950g = i11;
            int[] iArr = this.f70945b.f71022h;
            int i12 = this.f70951h;
            if (i11 != iArr[i12]) {
                return true;
            }
            this.f70951h = i12 + 1;
            this.f70950g = 0;
            return false;
        }

        public int i(int i11, int i12) {
            d0 d0Var;
            p g11 = g();
            if (g11 == null) {
                return 0;
            }
            int i13 = g11.f71013d;
            if (i13 != 0) {
                d0Var = this.f70945b.f71029o;
            } else {
                byte[] bArr = (byte[]) p0.j(g11.f71014e);
                this.f70954k.N(bArr, bArr.length);
                d0 d0Var2 = this.f70954k;
                i13 = bArr.length;
                d0Var = d0Var2;
            }
            boolean g12 = this.f70945b.g(this.f70949f);
            boolean z10 = g12 || i12 != 0;
            this.f70953j.d()[0] = (byte) ((z10 ? 128 : 0) | i13);
            this.f70953j.P(0);
            this.f70944a.f(this.f70953j, 1, 1);
            this.f70944a.f(d0Var, i13, 1);
            if (!z10) {
                return i13 + 1;
            }
            if (!g12) {
                this.f70946c.L(8);
                byte[] d11 = this.f70946c.d();
                d11[0] = 0;
                d11[1] = 1;
                d11[2] = (byte) ((i12 >> 8) & 255);
                d11[3] = (byte) (i12 & 255);
                d11[4] = (byte) ((i11 >> 24) & 255);
                d11[5] = (byte) ((i11 >> 16) & 255);
                d11[6] = (byte) ((i11 >> 8) & 255);
                d11[7] = (byte) (i11 & 255);
                this.f70944a.f(this.f70946c, 8, 1);
                return i13 + 9;
            }
            d0 d0Var3 = this.f70945b.f71029o;
            int J = d0Var3.J();
            d0Var3.Q(-2);
            int i14 = (J * 6) + 2;
            if (i12 != 0) {
                this.f70946c.L(i14);
                byte[] d12 = this.f70946c.d();
                d0Var3.j(d12, 0, i14);
                int i15 = (((d12[2] & 255) << 8) | (d12[3] & 255)) + i12;
                d12[2] = (byte) ((i15 >> 8) & 255);
                d12[3] = (byte) (i15 & 255);
                d0Var3 = this.f70946c;
            }
            this.f70944a.f(d0Var3, i14, 1);
            return i13 + 1 + i14;
        }

        public void j(r rVar, c cVar) {
            this.f70947d = rVar;
            this.f70948e = cVar;
            this.f70944a.e(rVar.f71033a.f71004f);
            k();
        }

        public void k() {
            this.f70945b.f();
            this.f70949f = 0;
            this.f70951h = 0;
            this.f70950g = 0;
            this.f70952i = 0;
            this.f70955l = false;
        }

        public void l(long j11) {
            int i11 = this.f70949f;
            while (true) {
                q qVar = this.f70945b;
                if (i11 >= qVar.f71020f || qVar.c(i11) >= j11) {
                    return;
                }
                if (this.f70945b.f71025k[i11]) {
                    this.f70952i = i11;
                }
                i11++;
            }
        }

        public void m() {
            p g11 = g();
            if (g11 == null) {
                return;
            }
            d0 d0Var = this.f70945b.f71029o;
            int i11 = g11.f71013d;
            if (i11 != 0) {
                d0Var.Q(i11);
            }
            if (this.f70945b.g(this.f70949f)) {
                d0Var.Q(d0Var.J() * 6);
            }
        }

        public void n(DrmInitData drmInitData) {
            p a11 = this.f70947d.f71033a.a(((c) p0.j(this.f70945b.f71015a)).f70904a);
            this.f70944a.e(this.f70947d.f71033a.f71004f.b().M(drmInitData.copyWithSchemeType(a11 != null ? a11.f71011b : null)).E());
        }
    }

    public g() {
        this(0);
    }

    public g(int i11) {
        this(i11, null);
    }

    public g(int i11, l0 l0Var) {
        this(i11, l0Var, null, Collections.emptyList());
    }

    public g(int i11, l0 l0Var, o oVar) {
        this(i11, l0Var, oVar, Collections.emptyList());
    }

    public g(int i11, l0 l0Var, o oVar, List list) {
        this(i11, l0Var, oVar, list, null);
    }

    public g(int i11, l0 l0Var, o oVar, List list, e0 e0Var) {
        this.f70915a = i11;
        this.f70924j = l0Var;
        this.f70916b = oVar;
        this.f70917c = Collections.unmodifiableList(list);
        this.f70929o = e0Var;
        this.f70925k = new com.google.android.exoplayer2.metadata.emsg.b();
        this.f70926l = new d0(16);
        this.f70919e = new d0(x.f27718a);
        this.f70920f = new d0(5);
        this.f70921g = new d0();
        byte[] bArr = new byte[16];
        this.f70922h = bArr;
        this.f70923i = new d0(bArr);
        this.f70927m = new ArrayDeque();
        this.f70928n = new ArrayDeque();
        this.f70918d = new SparseArray();
        this.f70938x = C.TIME_UNSET;
        this.f70937w = C.TIME_UNSET;
        this.f70939y = C.TIME_UNSET;
        this.E = g9.n.f63576i1;
        this.F = new e0[0];
        this.G = new e0[0];
    }

    private static long A(d0 d0Var) {
        d0Var.P(8);
        return o9.a.c(d0Var.n()) == 1 ? d0Var.I() : d0Var.F();
    }

    private static b B(d0 d0Var, SparseArray sparseArray, boolean z10) {
        d0Var.P(8);
        int b11 = o9.a.b(d0Var.n());
        b bVar = (b) (z10 ? sparseArray.valueAt(0) : sparseArray.get(d0Var.n()));
        if (bVar == null) {
            return null;
        }
        if ((b11 & 1) != 0) {
            long I2 = d0Var.I();
            q qVar = bVar.f70945b;
            qVar.f71017c = I2;
            qVar.f71018d = I2;
        }
        c cVar = bVar.f70948e;
        bVar.f70945b.f71015a = new c((b11 & 2) != 0 ? d0Var.n() - 1 : cVar.f70904a, (b11 & 8) != 0 ? d0Var.n() : cVar.f70905b, (b11 & 16) != 0 ? d0Var.n() : cVar.f70906c, (b11 & 32) != 0 ? d0Var.n() : cVar.f70907d);
        return bVar;
    }

    private static void C(a.C0886a c0886a, SparseArray sparseArray, boolean z10, int i11, byte[] bArr) {
        b B = B(((a.b) com.google.android.exoplayer2.util.a.e(c0886a.g(1952868452))).f70874b, sparseArray, z10);
        if (B == null) {
            return;
        }
        q qVar = B.f70945b;
        long j11 = qVar.f71031q;
        boolean z11 = qVar.f71032r;
        B.k();
        B.f70955l = true;
        a.b g11 = c0886a.g(1952867444);
        if (g11 == null || (i11 & 2) != 0) {
            qVar.f71031q = j11;
            qVar.f71032r = z11;
        } else {
            qVar.f71031q = A(g11.f70874b);
            qVar.f71032r = true;
        }
        F(c0886a, B, i11);
        p a11 = B.f70947d.f71033a.a(((c) com.google.android.exoplayer2.util.a.e(qVar.f71015a)).f70904a);
        a.b g12 = c0886a.g(1935763834);
        if (g12 != null) {
            v((p) com.google.android.exoplayer2.util.a.e(a11), g12.f70874b, qVar);
        }
        a.b g13 = c0886a.g(1935763823);
        if (g13 != null) {
            u(g13.f70874b, qVar);
        }
        a.b g14 = c0886a.g(1936027235);
        if (g14 != null) {
            y(g14.f70874b, qVar);
        }
        w(c0886a, a11 != null ? a11.f71011b : null, qVar);
        int size = c0886a.f70872c.size();
        for (int i12 = 0; i12 < size; i12++) {
            a.b bVar = (a.b) c0886a.f70872c.get(i12);
            if (bVar.f70870a == 1970628964) {
                G(bVar.f70874b, qVar, bArr);
            }
        }
    }

    private static Pair D(d0 d0Var) {
        d0Var.P(12);
        return Pair.create(Integer.valueOf(d0Var.n()), new c(d0Var.n() - 1, d0Var.n(), d0Var.n(), d0Var.n()));
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int E(o9.g.b r34, int r35, int r36, com.google.android.exoplayer2.util.d0 r37, int r38) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o9.g.E(o9.g$b, int, int, com.google.android.exoplayer2.util.d0, int):int");
    }

    private static void F(a.C0886a c0886a, b bVar, int i11) {
        List list = c0886a.f70872c;
        int size = list.size();
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < size; i14++) {
            a.b bVar2 = (a.b) list.get(i14);
            if (bVar2.f70870a == 1953658222) {
                d0 d0Var = bVar2.f70874b;
                d0Var.P(12);
                int H = d0Var.H();
                if (H > 0) {
                    i13 += H;
                    i12++;
                }
            }
        }
        bVar.f70951h = 0;
        bVar.f70950g = 0;
        bVar.f70949f = 0;
        bVar.f70945b.e(i12, i13);
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            a.b bVar3 = (a.b) list.get(i17);
            if (bVar3.f70870a == 1953658222) {
                i16 = E(bVar, i15, i11, bVar3.f70874b, i16);
                i15++;
            }
        }
    }

    private static void G(d0 d0Var, q qVar, byte[] bArr) {
        d0Var.P(8);
        d0Var.j(bArr, 0, 16);
        if (Arrays.equals(bArr, J)) {
            x(d0Var, 16, qVar);
        }
    }

    private void H(long j11) {
        while (!this.f70927m.isEmpty() && ((a.C0886a) this.f70927m.peek()).f70871b == j11) {
            m((a.C0886a) this.f70927m.pop());
        }
        f();
    }

    private boolean I(g9.m mVar) {
        if (this.f70933s == 0) {
            if (!mVar.readFully(this.f70926l.d(), 0, 8, true)) {
                return false;
            }
            this.f70933s = 8;
            this.f70926l.P(0);
            this.f70932r = this.f70926l.F();
            this.f70931q = this.f70926l.n();
        }
        long j11 = this.f70932r;
        if (j11 == 1) {
            mVar.readFully(this.f70926l.d(), 8, 8);
            this.f70933s += 8;
            this.f70932r = this.f70926l.I();
        } else if (j11 == 0) {
            long length = mVar.getLength();
            if (length == -1 && !this.f70927m.isEmpty()) {
                length = ((a.C0886a) this.f70927m.peek()).f70871b;
            }
            if (length != -1) {
                this.f70932r = (length - mVar.getPosition()) + this.f70933s;
            }
        }
        if (this.f70932r < this.f70933s) {
            throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
        }
        long position = mVar.getPosition() - this.f70933s;
        int i11 = this.f70931q;
        if ((i11 == 1836019558 || i11 == 1835295092) && !this.H) {
            this.E.d(new b0.b(this.f70938x, position));
            this.H = true;
        }
        if (this.f70931q == 1836019558) {
            int size = this.f70918d.size();
            for (int i12 = 0; i12 < size; i12++) {
                q qVar = ((b) this.f70918d.valueAt(i12)).f70945b;
                qVar.f71016b = position;
                qVar.f71018d = position;
                qVar.f71017c = position;
            }
        }
        int i13 = this.f70931q;
        if (i13 == 1835295092) {
            this.f70940z = null;
            this.f70935u = position + this.f70932r;
            this.f70930p = 2;
            return true;
        }
        if (M(i13)) {
            long position2 = (mVar.getPosition() + this.f70932r) - 8;
            this.f70927m.push(new a.C0886a(this.f70931q, position2));
            if (this.f70932r == this.f70933s) {
                H(position2);
            } else {
                f();
            }
        } else if (N(this.f70931q)) {
            if (this.f70933s != 8) {
                throw ParserException.createForUnsupportedContainerFeature("Leaf atom defines extended atom size (unsupported).");
            }
            long j12 = this.f70932r;
            if (j12 > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Leaf atom with length > 2147483647 (unsupported).");
            }
            d0 d0Var = new d0((int) j12);
            System.arraycopy(this.f70926l.d(), 0, d0Var.d(), 0, 8);
            this.f70934t = d0Var;
            this.f70930p = 1;
        } else {
            if (this.f70932r > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Skipping atom with length > 2147483647 (unsupported).");
            }
            this.f70934t = null;
            this.f70930p = 1;
        }
        return true;
    }

    private void J(g9.m mVar) {
        int i11 = ((int) this.f70932r) - this.f70933s;
        d0 d0Var = this.f70934t;
        if (d0Var != null) {
            mVar.readFully(d0Var.d(), 8, i11);
            o(new a.b(this.f70931q, d0Var), mVar.getPosition());
        } else {
            mVar.skipFully(i11);
        }
        H(mVar.getPosition());
    }

    private void K(g9.m mVar) {
        int size = this.f70918d.size();
        long j11 = Long.MAX_VALUE;
        b bVar = null;
        for (int i11 = 0; i11 < size; i11++) {
            q qVar = ((b) this.f70918d.valueAt(i11)).f70945b;
            if (qVar.f71030p) {
                long j12 = qVar.f71018d;
                if (j12 < j11) {
                    bVar = (b) this.f70918d.valueAt(i11);
                    j11 = j12;
                }
            }
        }
        if (bVar == null) {
            this.f70930p = 3;
            return;
        }
        int position = (int) (j11 - mVar.getPosition());
        if (position < 0) {
            throw ParserException.createForMalformedContainer("Offset to encryption data was negative.", null);
        }
        mVar.skipFully(position);
        bVar.f70945b.b(mVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean L(g9.m mVar) {
        int b11;
        b bVar = this.f70940z;
        Throwable th2 = null;
        if (bVar == null) {
            bVar = i(this.f70918d);
            if (bVar == null) {
                int position = (int) (this.f70935u - mVar.getPosition());
                if (position < 0) {
                    throw ParserException.createForMalformedContainer("Offset to end of mdat was negative.", null);
                }
                mVar.skipFully(position);
                f();
                return false;
            }
            int d11 = (int) (bVar.d() - mVar.getPosition());
            if (d11 < 0) {
                s.i("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                d11 = 0;
            }
            mVar.skipFully(d11);
            this.f70940z = bVar;
        }
        int i11 = 4;
        int i12 = 1;
        if (this.f70930p == 3) {
            int f11 = bVar.f();
            this.A = f11;
            if (bVar.f70949f < bVar.f70952i) {
                mVar.skipFully(f11);
                bVar.m();
                if (!bVar.h()) {
                    this.f70940z = null;
                }
                this.f70930p = 3;
                return true;
            }
            if (bVar.f70947d.f71033a.f71005g == 1) {
                this.A = f11 - 8;
                mVar.skipFully(8);
            }
            if ("audio/ac4".equals(bVar.f70947d.f71033a.f71004f.f25550l)) {
                this.B = bVar.i(this.A, 7);
                com.google.android.exoplayer2.audio.c.a(this.A, this.f70923i);
                bVar.f70944a.c(this.f70923i, 7);
                this.B += 7;
            } else {
                this.B = bVar.i(this.A, 0);
            }
            this.A += this.B;
            this.f70930p = 4;
            this.C = 0;
        }
        o oVar = bVar.f70947d.f71033a;
        e0 e0Var = bVar.f70944a;
        long e11 = bVar.e();
        l0 l0Var = this.f70924j;
        if (l0Var != null) {
            e11 = l0Var.a(e11);
        }
        long j11 = e11;
        if (oVar.f71008j == 0) {
            while (true) {
                int i13 = this.B;
                int i14 = this.A;
                if (i13 >= i14) {
                    break;
                }
                this.B += e0Var.b(mVar, i14 - i13, false);
            }
        } else {
            byte[] d12 = this.f70920f.d();
            d12[0] = 0;
            d12[1] = 0;
            d12[2] = 0;
            int i15 = oVar.f71008j;
            int i16 = i15 + 1;
            int i17 = 4 - i15;
            while (this.B < this.A) {
                int i18 = this.C;
                if (i18 == 0) {
                    mVar.readFully(d12, i17, i16);
                    this.f70920f.P(0);
                    int n11 = this.f70920f.n();
                    if (n11 < i12) {
                        throw ParserException.createForMalformedContainer("Invalid NAL length", th2);
                    }
                    this.C = n11 - 1;
                    this.f70919e.P(0);
                    e0Var.c(this.f70919e, i11);
                    e0Var.c(this.f70920f, i12);
                    this.D = (this.G.length <= 0 || !x.g(oVar.f71004f.f25550l, d12[i11])) ? 0 : i12;
                    this.B += 5;
                    this.A += i17;
                } else {
                    if (this.D) {
                        this.f70921g.L(i18);
                        mVar.readFully(this.f70921g.d(), 0, this.C);
                        e0Var.c(this.f70921g, this.C);
                        b11 = this.C;
                        int q11 = x.q(this.f70921g.d(), this.f70921g.f());
                        this.f70921g.P(MimeTypes.VIDEO_H265.equals(oVar.f71004f.f25550l) ? 1 : 0);
                        this.f70921g.O(q11);
                        g9.c.a(j11, this.f70921g, this.G);
                    } else {
                        b11 = e0Var.b(mVar, i18, false);
                    }
                    this.B += b11;
                    this.C -= b11;
                    th2 = null;
                    i11 = 4;
                    i12 = 1;
                }
            }
        }
        int c11 = bVar.c();
        p g11 = bVar.g();
        e0Var.d(j11, c11, this.A, 0, g11 != null ? g11.f71012c : null);
        r(j11);
        if (!bVar.h()) {
            this.f70940z = null;
        }
        this.f70930p = 3;
        return true;
    }

    private static boolean M(int i11) {
        return i11 == 1836019574 || i11 == 1953653099 || i11 == 1835297121 || i11 == 1835626086 || i11 == 1937007212 || i11 == 1836019558 || i11 == 1953653094 || i11 == 1836475768 || i11 == 1701082227;
    }

    private static boolean N(int i11) {
        return i11 == 1751411826 || i11 == 1835296868 || i11 == 1836476516 || i11 == 1936286840 || i11 == 1937011556 || i11 == 1937011827 || i11 == 1668576371 || i11 == 1937011555 || i11 == 1937011578 || i11 == 1937013298 || i11 == 1937007471 || i11 == 1668232756 || i11 == 1937011571 || i11 == 1952867444 || i11 == 1952868452 || i11 == 1953196132 || i11 == 1953654136 || i11 == 1953658222 || i11 == 1886614376 || i11 == 1935763834 || i11 == 1935763823 || i11 == 1936027235 || i11 == 1970628964 || i11 == 1935828848 || i11 == 1936158820 || i11 == 1701606260 || i11 == 1835362404 || i11 == 1701671783;
    }

    private static int e(int i11) {
        if (i11 >= 0) {
            return i11;
        }
        throw ParserException.createForMalformedContainer("Unexpected negative value: " + i11, null);
    }

    private void f() {
        this.f70930p = 0;
        this.f70933s = 0;
    }

    private c g(SparseArray sparseArray, int i11) {
        return sparseArray.size() == 1 ? (c) sparseArray.valueAt(0) : (c) com.google.android.exoplayer2.util.a.e((c) sparseArray.get(i11));
    }

    private static DrmInitData h(List list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < size; i11++) {
            a.b bVar = (a.b) list.get(i11);
            if (bVar.f70870a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] d11 = bVar.f70874b.d();
                UUID f11 = l.f(d11);
                if (f11 == null) {
                    s.i("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(f11, MimeTypes.VIDEO_MP4, d11));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private static b i(SparseArray sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j11 = Long.MAX_VALUE;
        for (int i11 = 0; i11 < size; i11++) {
            b bVar2 = (b) sparseArray.valueAt(i11);
            if ((bVar2.f70955l || bVar2.f70949f != bVar2.f70947d.f71034b) && (!bVar2.f70955l || bVar2.f70951h != bVar2.f70945b.f71019e)) {
                long d11 = bVar2.d();
                if (d11 < j11) {
                    bVar = bVar2;
                    j11 = d11;
                }
            }
        }
        return bVar;
    }

    private void j() {
        int i11;
        e0[] e0VarArr = new e0[2];
        this.F = e0VarArr;
        e0 e0Var = this.f70929o;
        int i12 = 0;
        if (e0Var != null) {
            e0VarArr[0] = e0Var;
            i11 = 1;
        } else {
            i11 = 0;
        }
        int i13 = 100;
        if ((this.f70915a & 4) != 0) {
            e0VarArr[i11] = this.E.track(100, 5);
            i13 = 101;
            i11++;
        }
        e0[] e0VarArr2 = (e0[]) p0.G0(this.F, i11);
        this.F = e0VarArr2;
        for (e0 e0Var2 : e0VarArr2) {
            e0Var2.e(K);
        }
        this.G = new e0[this.f70917c.size()];
        while (i12 < this.G.length) {
            e0 track = this.E.track(i13, 3);
            track.e((o1) this.f70917c.get(i12));
            this.G[i12] = track;
            i12++;
            i13++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ g9.l[] k() {
        return new g9.l[]{new g()};
    }

    private void m(a.C0886a c0886a) {
        int i11 = c0886a.f70870a;
        if (i11 == 1836019574) {
            q(c0886a);
        } else if (i11 == 1836019558) {
            p(c0886a);
        } else {
            if (this.f70927m.isEmpty()) {
                return;
            }
            ((a.C0886a) this.f70927m.peek()).d(c0886a);
        }
    }

    private void n(d0 d0Var) {
        long N0;
        String str;
        long N02;
        String str2;
        long F;
        long j11;
        if (this.F.length == 0) {
            return;
        }
        d0Var.P(8);
        int c11 = o9.a.c(d0Var.n());
        if (c11 == 0) {
            String str3 = (String) com.google.android.exoplayer2.util.a.e(d0Var.x());
            String str4 = (String) com.google.android.exoplayer2.util.a.e(d0Var.x());
            long F2 = d0Var.F();
            N0 = p0.N0(d0Var.F(), 1000000L, F2);
            long j12 = this.f70939y;
            long j13 = j12 != C.TIME_UNSET ? j12 + N0 : -9223372036854775807L;
            str = str3;
            N02 = p0.N0(d0Var.F(), 1000L, F2);
            str2 = str4;
            F = d0Var.F();
            j11 = j13;
        } else {
            if (c11 != 1) {
                s.i("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + c11);
                return;
            }
            long F3 = d0Var.F();
            j11 = p0.N0(d0Var.I(), 1000000L, F3);
            long N03 = p0.N0(d0Var.F(), 1000L, F3);
            long F4 = d0Var.F();
            str = (String) com.google.android.exoplayer2.util.a.e(d0Var.x());
            N02 = N03;
            F = F4;
            str2 = (String) com.google.android.exoplayer2.util.a.e(d0Var.x());
            N0 = -9223372036854775807L;
        }
        byte[] bArr = new byte[d0Var.a()];
        d0Var.j(bArr, 0, d0Var.a());
        d0 d0Var2 = new d0(this.f70925k.a(new EventMessage(str, str2, N02, F, bArr)));
        int a11 = d0Var2.a();
        for (e0 e0Var : this.F) {
            d0Var2.P(0);
            e0Var.c(d0Var2, a11);
        }
        if (j11 == C.TIME_UNSET) {
            this.f70928n.addLast(new a(N0, true, a11));
            this.f70936v += a11;
            return;
        }
        if (!this.f70928n.isEmpty()) {
            this.f70928n.addLast(new a(j11, false, a11));
            this.f70936v += a11;
            return;
        }
        l0 l0Var = this.f70924j;
        if (l0Var != null) {
            j11 = l0Var.a(j11);
        }
        for (e0 e0Var2 : this.F) {
            e0Var2.d(j11, 1, a11, 0, null);
        }
    }

    private void o(a.b bVar, long j11) {
        if (!this.f70927m.isEmpty()) {
            ((a.C0886a) this.f70927m.peek()).e(bVar);
            return;
        }
        int i11 = bVar.f70870a;
        if (i11 != 1936286840) {
            if (i11 == 1701671783) {
                n(bVar.f70874b);
            }
        } else {
            Pair z10 = z(bVar.f70874b, j11);
            this.f70939y = ((Long) z10.first).longValue();
            this.E.d((b0) z10.second);
            this.H = true;
        }
    }

    private void p(a.C0886a c0886a) {
        t(c0886a, this.f70918d, this.f70916b != null, this.f70915a, this.f70922h);
        DrmInitData h11 = h(c0886a.f70872c);
        if (h11 != null) {
            int size = this.f70918d.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((b) this.f70918d.valueAt(i11)).n(h11);
            }
        }
        if (this.f70937w != C.TIME_UNSET) {
            int size2 = this.f70918d.size();
            for (int i12 = 0; i12 < size2; i12++) {
                ((b) this.f70918d.valueAt(i12)).l(this.f70937w);
            }
            this.f70937w = C.TIME_UNSET;
        }
    }

    private void q(a.C0886a c0886a) {
        int i11 = 0;
        com.google.android.exoplayer2.util.a.h(this.f70916b == null, "Unexpected moov box.");
        DrmInitData h11 = h(c0886a.f70872c);
        a.C0886a c0886a2 = (a.C0886a) com.google.android.exoplayer2.util.a.e(c0886a.f(1836475768));
        SparseArray sparseArray = new SparseArray();
        int size = c0886a2.f70872c.size();
        long j11 = -9223372036854775807L;
        for (int i12 = 0; i12 < size; i12++) {
            a.b bVar = (a.b) c0886a2.f70872c.get(i12);
            int i13 = bVar.f70870a;
            if (i13 == 1953654136) {
                Pair D = D(bVar.f70874b);
                sparseArray.put(((Integer) D.first).intValue(), (c) D.second);
            } else if (i13 == 1835362404) {
                j11 = s(bVar.f70874b);
            }
        }
        List A = o9.b.A(c0886a, new g9.x(), j11, h11, (this.f70915a & 16) != 0, false, new com.google.common.base.f() { // from class: o9.f
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return g.this.l((o) obj);
            }
        });
        int size2 = A.size();
        if (this.f70918d.size() != 0) {
            com.google.android.exoplayer2.util.a.g(this.f70918d.size() == size2);
            while (i11 < size2) {
                r rVar = (r) A.get(i11);
                o oVar = rVar.f71033a;
                ((b) this.f70918d.get(oVar.f70999a)).j(rVar, g(sparseArray, oVar.f70999a));
                i11++;
            }
            return;
        }
        while (i11 < size2) {
            r rVar2 = (r) A.get(i11);
            o oVar2 = rVar2.f71033a;
            this.f70918d.put(oVar2.f70999a, new b(this.E.track(i11, oVar2.f71000b), rVar2, g(sparseArray, oVar2.f70999a)));
            this.f70938x = Math.max(this.f70938x, oVar2.f71003e);
            i11++;
        }
        this.E.endTracks();
    }

    private void r(long j11) {
        while (!this.f70928n.isEmpty()) {
            a aVar = (a) this.f70928n.removeFirst();
            this.f70936v -= aVar.f70943c;
            long j12 = aVar.f70941a;
            if (aVar.f70942b) {
                j12 += j11;
            }
            l0 l0Var = this.f70924j;
            if (l0Var != null) {
                j12 = l0Var.a(j12);
            }
            for (e0 e0Var : this.F) {
                e0Var.d(j12, 1, aVar.f70943c, this.f70936v, null);
            }
        }
    }

    private static long s(d0 d0Var) {
        d0Var.P(8);
        return o9.a.c(d0Var.n()) == 0 ? d0Var.F() : d0Var.I();
    }

    private static void t(a.C0886a c0886a, SparseArray sparseArray, boolean z10, int i11, byte[] bArr) {
        int size = c0886a.f70873d.size();
        for (int i12 = 0; i12 < size; i12++) {
            a.C0886a c0886a2 = (a.C0886a) c0886a.f70873d.get(i12);
            if (c0886a2.f70870a == 1953653094) {
                C(c0886a2, sparseArray, z10, i11, bArr);
            }
        }
    }

    private static void u(d0 d0Var, q qVar) {
        d0Var.P(8);
        int n11 = d0Var.n();
        if ((o9.a.b(n11) & 1) == 1) {
            d0Var.Q(8);
        }
        int H = d0Var.H();
        if (H == 1) {
            qVar.f71018d += o9.a.c(n11) == 0 ? d0Var.F() : d0Var.I();
        } else {
            throw ParserException.createForMalformedContainer("Unexpected saio entry count: " + H, null);
        }
    }

    private static void v(p pVar, d0 d0Var, q qVar) {
        int i11;
        int i12 = pVar.f71013d;
        d0Var.P(8);
        if ((o9.a.b(d0Var.n()) & 1) == 1) {
            d0Var.Q(8);
        }
        int D = d0Var.D();
        int H = d0Var.H();
        if (H > qVar.f71020f) {
            throw ParserException.createForMalformedContainer("Saiz sample count " + H + " is greater than fragment sample count" + qVar.f71020f, null);
        }
        if (D == 0) {
            boolean[] zArr = qVar.f71027m;
            i11 = 0;
            for (int i13 = 0; i13 < H; i13++) {
                int D2 = d0Var.D();
                i11 += D2;
                zArr[i13] = D2 > i12;
            }
        } else {
            i11 = D * H;
            Arrays.fill(qVar.f71027m, 0, H, D > i12);
        }
        Arrays.fill(qVar.f71027m, H, qVar.f71020f, false);
        if (i11 > 0) {
            qVar.d(i11);
        }
    }

    private static void w(a.C0886a c0886a, String str, q qVar) {
        byte[] bArr = null;
        d0 d0Var = null;
        d0 d0Var2 = null;
        for (int i11 = 0; i11 < c0886a.f70872c.size(); i11++) {
            a.b bVar = (a.b) c0886a.f70872c.get(i11);
            d0 d0Var3 = bVar.f70874b;
            int i12 = bVar.f70870a;
            if (i12 == 1935828848) {
                d0Var3.P(12);
                if (d0Var3.n() == 1936025959) {
                    d0Var = d0Var3;
                }
            } else if (i12 == 1936158820) {
                d0Var3.P(12);
                if (d0Var3.n() == 1936025959) {
                    d0Var2 = d0Var3;
                }
            }
        }
        if (d0Var == null || d0Var2 == null) {
            return;
        }
        d0Var.P(8);
        int c11 = o9.a.c(d0Var.n());
        d0Var.Q(4);
        if (c11 == 1) {
            d0Var.Q(4);
        }
        if (d0Var.n() != 1) {
            throw ParserException.createForUnsupportedContainerFeature("Entry count in sbgp != 1 (unsupported).");
        }
        d0Var2.P(8);
        int c12 = o9.a.c(d0Var2.n());
        d0Var2.Q(4);
        if (c12 == 1) {
            if (d0Var2.F() == 0) {
                throw ParserException.createForUnsupportedContainerFeature("Variable length description in sgpd found (unsupported)");
            }
        } else if (c12 >= 2) {
            d0Var2.Q(4);
        }
        if (d0Var2.F() != 1) {
            throw ParserException.createForUnsupportedContainerFeature("Entry count in sgpd != 1 (unsupported).");
        }
        d0Var2.Q(1);
        int D = d0Var2.D();
        int i13 = (D & 240) >> 4;
        int i14 = D & 15;
        boolean z10 = d0Var2.D() == 1;
        if (z10) {
            int D2 = d0Var2.D();
            byte[] bArr2 = new byte[16];
            d0Var2.j(bArr2, 0, 16);
            if (D2 == 0) {
                int D3 = d0Var2.D();
                bArr = new byte[D3];
                d0Var2.j(bArr, 0, D3);
            }
            qVar.f71026l = true;
            qVar.f71028n = new p(z10, str, D2, bArr2, i13, i14, bArr);
        }
    }

    private static void x(d0 d0Var, int i11, q qVar) {
        d0Var.P(i11 + 8);
        int b11 = o9.a.b(d0Var.n());
        if ((b11 & 1) != 0) {
            throw ParserException.createForUnsupportedContainerFeature("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z10 = (b11 & 2) != 0;
        int H = d0Var.H();
        if (H == 0) {
            Arrays.fill(qVar.f71027m, 0, qVar.f71020f, false);
            return;
        }
        if (H == qVar.f71020f) {
            Arrays.fill(qVar.f71027m, 0, H, z10);
            qVar.d(d0Var.a());
            qVar.a(d0Var);
        } else {
            throw ParserException.createForMalformedContainer("Senc sample count " + H + " is different from fragment sample count" + qVar.f71020f, null);
        }
    }

    private static void y(d0 d0Var, q qVar) {
        x(d0Var, 0, qVar);
    }

    private static Pair z(d0 d0Var, long j11) {
        long I2;
        long I3;
        d0Var.P(8);
        int c11 = o9.a.c(d0Var.n());
        d0Var.Q(4);
        long F = d0Var.F();
        if (c11 == 0) {
            I2 = d0Var.F();
            I3 = d0Var.F();
        } else {
            I2 = d0Var.I();
            I3 = d0Var.I();
        }
        long j12 = I2;
        long j13 = j11 + I3;
        long N0 = p0.N0(j12, 1000000L, F);
        d0Var.Q(2);
        int J2 = d0Var.J();
        int[] iArr = new int[J2];
        long[] jArr = new long[J2];
        long[] jArr2 = new long[J2];
        long[] jArr3 = new long[J2];
        long j14 = N0;
        int i11 = 0;
        long j15 = j12;
        while (i11 < J2) {
            int n11 = d0Var.n();
            if ((n11 & Integer.MIN_VALUE) != 0) {
                throw ParserException.createForMalformedContainer("Unhandled indirect reference", null);
            }
            long F2 = d0Var.F();
            iArr[i11] = n11 & Integer.MAX_VALUE;
            jArr[i11] = j13;
            jArr3[i11] = j14;
            long j16 = j15 + F2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i12 = J2;
            long N02 = p0.N0(j16, 1000000L, F);
            jArr4[i11] = N02 - jArr5[i11];
            d0Var.Q(4);
            j13 += r1[i11];
            i11++;
            iArr = iArr;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            J2 = i12;
            j15 = j16;
            j14 = N02;
        }
        return Pair.create(Long.valueOf(N0), new g9.d(iArr, jArr, jArr2, jArr3));
    }

    @Override // g9.l
    public void b(g9.n nVar) {
        this.E = nVar;
        f();
        j();
        o oVar = this.f70916b;
        if (oVar != null) {
            this.f70918d.put(0, new b(nVar.track(0, oVar.f71000b), new r(this.f70916b, new long[0], new int[0], 0, new long[0], new int[0], 0L), new c(0, 0, 0, 0)));
            this.E.endTracks();
        }
    }

    @Override // g9.l
    public int c(g9.m mVar, a0 a0Var) {
        while (true) {
            int i11 = this.f70930p;
            if (i11 != 0) {
                if (i11 == 1) {
                    J(mVar);
                } else if (i11 == 2) {
                    K(mVar);
                } else if (L(mVar)) {
                    return 0;
                }
            } else if (!I(mVar)) {
                return -1;
            }
        }
    }

    @Override // g9.l
    public boolean d(g9.m mVar) {
        return n.b(mVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public o l(o oVar) {
        return oVar;
    }

    @Override // g9.l
    public void release() {
    }

    @Override // g9.l
    public void seek(long j11, long j12) {
        int size = this.f70918d.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((b) this.f70918d.valueAt(i11)).k();
        }
        this.f70928n.clear();
        this.f70936v = 0;
        this.f70937w = j12;
        this.f70927m.clear();
        f();
    }
}
