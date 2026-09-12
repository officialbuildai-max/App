package androidx.media3.exoplayer.hls;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.ParserException;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.common.x;
import androidx.media3.common.y;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.c4;
import androidx.media3.exoplayer.drm.r;
import androidx.media3.exoplayer.hls.e;
import androidx.media3.exoplayer.hls.r;
import androidx.media3.exoplayer.s2;
import androidx.media3.exoplayer.source.e0;
import androidx.media3.exoplayer.source.f0;
import androidx.media3.exoplayer.source.s;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.upstream.m;
import androidx.media3.exoplayer.v2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.g3;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import g2.z;
import j2.d0;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import l2.m0;
import l2.r0;
import l2.s0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class r implements Loader.b, Loader.e, f0, l2.t, e0.d {
    private static final Set Y = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 5)));
    private int A;
    private int B;
    private boolean C;
    private boolean D;
    private int E;
    private androidx.media3.common.r F;
    private androidx.media3.common.r G;
    private boolean H;
    private z I;
    private Set J;
    private int[] K;
    private int L;
    private boolean M;
    private boolean[] N;
    private boolean[] O;
    private long P;
    private long Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private long V;
    private DrmInitData W;
    private i X;

    /* renamed from: a, reason: collision with root package name */
    private final String f12036a;

    /* renamed from: b, reason: collision with root package name */
    private final int f12037b;

    /* renamed from: c, reason: collision with root package name */
    private final b f12038c;

    /* renamed from: d, reason: collision with root package name */
    private final e f12039d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.b f12040e;

    /* renamed from: f, reason: collision with root package name */
    private final androidx.media3.common.r f12041f;

    /* renamed from: g, reason: collision with root package name */
    private final androidx.media3.exoplayer.drm.t f12042g;

    /* renamed from: h, reason: collision with root package name */
    private final r.a f12043h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.m f12044i;

    /* renamed from: k, reason: collision with root package name */
    private final s.a f12046k;

    /* renamed from: l, reason: collision with root package name */
    private final int f12047l;

    /* renamed from: n, reason: collision with root package name */
    private final ArrayList f12049n;

    /* renamed from: o, reason: collision with root package name */
    private final List f12050o;

    /* renamed from: p, reason: collision with root package name */
    private final Runnable f12051p;

    /* renamed from: q, reason: collision with root package name */
    private final Runnable f12052q;

    /* renamed from: r, reason: collision with root package name */
    private final Handler f12053r;

    /* renamed from: s, reason: collision with root package name */
    private final ArrayList f12054s;

    /* renamed from: t, reason: collision with root package name */
    private final Map f12055t;

    /* renamed from: u, reason: collision with root package name */
    private h2.e f12056u;

    /* renamed from: v, reason: collision with root package name */
    private d[] f12057v;

    /* renamed from: x, reason: collision with root package name */
    private Set f12059x;

    /* renamed from: y, reason: collision with root package name */
    private SparseIntArray f12060y;

    /* renamed from: z, reason: collision with root package name */
    private s0 f12061z;

    /* renamed from: j, reason: collision with root package name */
    private final Loader f12045j = new Loader("Loader:HlsSampleStreamWrapper");

    /* renamed from: m, reason: collision with root package name */
    private final e.b f12048m = new e.b();

    /* renamed from: w, reason: collision with root package name */
    private int[] f12058w = new int[0];

    /* loaded from: classes2.dex */
    public interface b extends f0.a {
        void d(Uri uri);

        void onPrepared();
    }

    /* loaded from: classes2.dex */
    private static class c implements s0 {

        /* renamed from: g, reason: collision with root package name */
        private static final androidx.media3.common.r f12062g = new r.b().u0(MimeTypes.APPLICATION_ID3).N();

        /* renamed from: h, reason: collision with root package name */
        private static final androidx.media3.common.r f12063h = new r.b().u0(MimeTypes.APPLICATION_EMSG).N();

        /* renamed from: a, reason: collision with root package name */
        private final w2.b f12064a = new w2.b();

        /* renamed from: b, reason: collision with root package name */
        private final s0 f12065b;

        /* renamed from: c, reason: collision with root package name */
        private final androidx.media3.common.r f12066c;

        /* renamed from: d, reason: collision with root package name */
        private androidx.media3.common.r f12067d;

        /* renamed from: e, reason: collision with root package name */
        private byte[] f12068e;

        /* renamed from: f, reason: collision with root package name */
        private int f12069f;

        public c(s0 s0Var, int i11) {
            this.f12065b = s0Var;
            if (i11 == 1) {
                this.f12066c = f12062g;
            } else {
                if (i11 != 3) {
                    throw new IllegalArgumentException("Unknown metadataType: " + i11);
                }
                this.f12066c = f12063h;
            }
            this.f12068e = new byte[0];
            this.f12069f = 0;
        }

        private boolean h(w2.a aVar) {
            androidx.media3.common.r wrappedMetadataFormat = aVar.getWrappedMetadataFormat();
            return wrappedMetadataFormat != null && Objects.equals(this.f12066c.f10243o, wrappedMetadataFormat.f10243o);
        }

        private void i(int i11) {
            byte[] bArr = this.f12068e;
            if (bArr.length < i11) {
                this.f12068e = Arrays.copyOf(bArr, i11 + (i11 / 2));
            }
        }

        private j0 j(int i11, int i12) {
            int i13 = this.f12069f - i12;
            j0 j0Var = new j0(Arrays.copyOfRange(this.f12068e, i13 - i11, i13));
            byte[] bArr = this.f12068e;
            System.arraycopy(bArr, i13, bArr, 0, i12);
            this.f12069f = i12;
            return j0Var;
        }

        @Override // l2.s0
        public void a(j0 j0Var, int i11, int i12) {
            i(this.f12069f + i11);
            j0Var.l(this.f12068e, this.f12069f, i11);
            this.f12069f += i11;
        }

        @Override // l2.s0
        public /* synthetic */ void b(j0 j0Var, int i11) {
            r0.c(this, j0Var, i11);
        }

        @Override // l2.s0
        public void c(androidx.media3.common.r rVar) {
            this.f12067d = rVar;
            this.f12065b.c(this.f12066c);
        }

        @Override // l2.s0
        public void d(long j11, int i11, int i12, int i13, s0.a aVar) {
            androidx.media3.common.util.a.e(this.f12067d);
            j0 j12 = j(i12, i13);
            if (!Objects.equals(this.f12067d.f10243o, this.f12066c.f10243o)) {
                if (!MimeTypes.APPLICATION_EMSG.equals(this.f12067d.f10243o)) {
                    androidx.media3.common.util.u.h("HlsSampleStreamWrapper", "Ignoring sample for unsupported format: " + this.f12067d.f10243o);
                    return;
                }
                w2.a c11 = this.f12064a.c(j12);
                if (!h(c11)) {
                    androidx.media3.common.util.u.h("HlsSampleStreamWrapper", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.f12066c.f10243o, c11.getWrappedMetadataFormat()));
                    return;
                }
                j12 = new j0((byte[]) androidx.media3.common.util.a.e(c11.getWrappedMetadataBytes()));
            }
            int a11 = j12.a();
            this.f12065b.b(j12, a11);
            this.f12065b.d(j11, i11, a11, 0, aVar);
        }

        @Override // l2.s0
        public /* synthetic */ int e(androidx.media3.common.j jVar, int i11, boolean z10) {
            return r0.b(this, jVar, i11, z10);
        }

        @Override // l2.s0
        public /* synthetic */ void f(long j11) {
            r0.a(this, j11);
        }

        @Override // l2.s0
        public int g(androidx.media3.common.j jVar, int i11, boolean z10, int i12) {
            i(this.f12069f + i11);
            int read = jVar.read(this.f12068e, this.f12069f, i11);
            if (read != -1) {
                this.f12069f += read;
                return read;
            }
            if (z10) {
                return -1;
            }
            throw new EOFException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class d extends e0 {
        private final Map H;
        private DrmInitData I;

        private d(androidx.media3.exoplayer.upstream.b bVar, androidx.media3.exoplayer.drm.t tVar, r.a aVar, Map map) {
            super(bVar, tVar, aVar);
            this.H = map;
        }

        private x k0(x xVar) {
            if (xVar == null) {
                return null;
            }
            int e11 = xVar.e();
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i12 >= e11) {
                    i12 = -1;
                    break;
                }
                x.a d11 = xVar.d(i12);
                if ((d11 instanceof z2.m) && "com.apple.streaming.transportStreamTimestamp".equals(((z2.m) d11).f79325b)) {
                    break;
                }
                i12++;
            }
            if (i12 == -1) {
                return xVar;
            }
            if (e11 == 1) {
                return null;
            }
            x.a[] aVarArr = new x.a[e11 - 1];
            while (i11 < e11) {
                if (i11 != i12) {
                    aVarArr[i11 < i12 ? i11 : i11 - 1] = xVar.d(i11);
                }
                i11++;
            }
            return new x(aVarArr);
        }

        @Override // androidx.media3.exoplayer.source.e0, l2.s0
        public void d(long j11, int i11, int i12, int i13, s0.a aVar) {
            super.d(j11, i11, i12, i13, aVar);
        }

        public void l0(DrmInitData drmInitData) {
            this.I = drmInitData;
            L();
        }

        public void m0(i iVar) {
            i0(iVar.f11824k);
        }

        @Override // androidx.media3.exoplayer.source.e0
        public androidx.media3.common.r z(androidx.media3.common.r rVar) {
            DrmInitData drmInitData;
            DrmInitData drmInitData2 = this.I;
            if (drmInitData2 == null) {
                drmInitData2 = rVar.f10247s;
            }
            if (drmInitData2 != null && (drmInitData = (DrmInitData) this.H.get(drmInitData2.schemeType)) != null) {
                drmInitData2 = drmInitData;
            }
            x k02 = k0(rVar.f10240l);
            if (drmInitData2 != rVar.f10247s || k02 != rVar.f10240l) {
                rVar = rVar.b().Y(drmInitData2).n0(k02).N();
            }
            return super.z(rVar);
        }
    }

    public r(String str, int i11, b bVar, e eVar, Map map, androidx.media3.exoplayer.upstream.b bVar2, long j11, androidx.media3.common.r rVar, androidx.media3.exoplayer.drm.t tVar, r.a aVar, androidx.media3.exoplayer.upstream.m mVar, s.a aVar2, int i12) {
        this.f12036a = str;
        this.f12037b = i11;
        this.f12038c = bVar;
        this.f12039d = eVar;
        this.f12055t = map;
        this.f12040e = bVar2;
        this.f12041f = rVar;
        this.f12042g = tVar;
        this.f12043h = aVar;
        this.f12044i = mVar;
        this.f12046k = aVar2;
        this.f12047l = i12;
        Set set = Y;
        this.f12059x = new HashSet(set.size());
        this.f12060y = new SparseIntArray(set.size());
        this.f12057v = new d[0];
        this.O = new boolean[0];
        this.N = new boolean[0];
        ArrayList arrayList = new ArrayList();
        this.f12049n = arrayList;
        this.f12050o = Collections.unmodifiableList(arrayList);
        this.f12054s = new ArrayList();
        this.f12051p = new Runnable() { // from class: androidx.media3.exoplayer.hls.o
            @Override // java.lang.Runnable
            public final void run() {
                r.this.K();
            }
        };
        this.f12052q = new Runnable() { // from class: androidx.media3.exoplayer.hls.p
            @Override // java.lang.Runnable
            public final void run() {
                r.this.U();
            }
        };
        this.f12053r = a1.A();
        this.P = j11;
        this.Q = j11;
    }

    private i A() {
        return (i) this.f12049n.get(r0.size() - 1);
    }

    private s0 B(int i11, int i12) {
        androidx.media3.common.util.a.a(Y.contains(Integer.valueOf(i12)));
        int i13 = this.f12060y.get(i12, -1);
        if (i13 == -1) {
            return null;
        }
        if (this.f12059x.add(Integer.valueOf(i12))) {
            this.f12058w[i13] = i11;
        }
        return this.f12058w[i13] == i11 ? this.f12057v[i13] : s(i11, i12);
    }

    private static int C(int i11) {
        if (i11 == 1) {
            return 2;
        }
        if (i11 != 2) {
            return i11 != 3 ? 0 : 1;
        }
        return 3;
    }

    private void D(i iVar) {
        this.X = iVar;
        this.F = iVar.f64422d;
        this.Q = C.TIME_UNSET;
        this.f12049n.add(iVar);
        ImmutableList.a builder = ImmutableList.builder();
        for (d dVar : this.f12057v) {
            builder.a(Integer.valueOf(dVar.J()));
        }
        iVar.l(this, builder.e());
        for (d dVar2 : this.f12057v) {
            dVar2.m0(iVar);
            if (iVar.f11827n) {
                dVar2.j0();
            }
        }
    }

    private static boolean E(h2.e eVar) {
        return eVar instanceof i;
    }

    private boolean F() {
        return this.Q != C.TIME_UNSET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(i iVar) {
        this.f12038c.d(iVar.f11826m);
    }

    private void J() {
        int i11 = this.I.f63389a;
        int[] iArr = new int[i11];
        this.K = iArr;
        Arrays.fill(iArr, -1);
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = 0;
            while (true) {
                d[] dVarArr = this.f12057v;
                if (i13 >= dVarArr.length) {
                    break;
                }
                if (z((androidx.media3.common.r) androidx.media3.common.util.a.i(dVarArr[i13].I()), this.I.b(i12).a(0))) {
                    this.K[i12] = i13;
                    break;
                }
                i13++;
            }
        }
        Iterator it = this.f12054s.iterator();
        while (it.hasNext()) {
            ((m) it.next()).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (!this.H && this.K == null && this.C) {
            for (d dVar : this.f12057v) {
                if (dVar.I() == null) {
                    return;
                }
            }
            if (this.I != null) {
                J();
                return;
            }
            m();
            d0();
            this.f12038c.onPrepared();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        this.C = true;
        K();
    }

    private void Y() {
        for (d dVar : this.f12057v) {
            dVar.Z(this.R);
        }
        this.R = false;
    }

    private boolean Z(long j11, i iVar) {
        int length = this.f12057v.length;
        for (int i11 = 0; i11 < length; i11++) {
            d dVar = this.f12057v[i11];
            if (!(iVar != null ? dVar.b0(iVar.k(i11)) : dVar.c0(j11, false)) && (this.O[i11] || !this.M)) {
                return false;
            }
        }
        return true;
    }

    private void d0() {
        this.D = true;
    }

    private void i0(g2.u[] uVarArr) {
        this.f12054s.clear();
        for (g2.u uVar : uVarArr) {
            if (uVar != null) {
                this.f12054s.add((m) uVar);
            }
        }
    }

    private void j() {
        androidx.media3.common.util.a.g(this.D);
        androidx.media3.common.util.a.e(this.I);
        androidx.media3.common.util.a.e(this.J);
    }

    private void m() {
        androidx.media3.common.r rVar;
        int length = this.f12057v.length;
        int i11 = -2;
        int i12 = -1;
        int i13 = 0;
        while (true) {
            if (i13 >= length) {
                break;
            }
            String str = ((androidx.media3.common.r) androidx.media3.common.util.a.i(this.f12057v[i13].I())).f10243o;
            int i14 = y.t(str) ? 2 : y.o(str) ? 1 : y.s(str) ? 3 : -2;
            if (C(i14) > C(i11)) {
                i12 = i13;
                i11 = i14;
            } else if (i14 == i11 && i12 != -1) {
                i12 = -1;
            }
            i13++;
        }
        androidx.media3.common.f0 k11 = this.f12039d.k();
        int i15 = k11.f10053a;
        this.L = -1;
        this.K = new int[length];
        for (int i16 = 0; i16 < length; i16++) {
            this.K[i16] = i16;
        }
        androidx.media3.common.f0[] f0VarArr = new androidx.media3.common.f0[length];
        int i17 = 0;
        while (i17 < length) {
            androidx.media3.common.r rVar2 = (androidx.media3.common.r) androidx.media3.common.util.a.i(this.f12057v[i17].I());
            if (i17 == i12) {
                androidx.media3.common.r[] rVarArr = new androidx.media3.common.r[i15];
                for (int i18 = 0; i18 < i15; i18++) {
                    androidx.media3.common.r a11 = k11.a(i18);
                    if (i11 == 1 && (rVar = this.f12041f) != null) {
                        a11 = a11.j(rVar);
                    }
                    rVarArr[i18] = i15 == 1 ? rVar2.j(a11) : v(a11, rVar2, true);
                }
                f0VarArr[i17] = new androidx.media3.common.f0(this.f12036a, rVarArr);
                this.L = i17;
            } else {
                androidx.media3.common.r rVar3 = (i11 == 2 && y.o(rVar2.f10243o)) ? this.f12041f : null;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f12036a);
                sb2.append(":muxed:");
                sb2.append(i17 < i12 ? i17 : i17 - 1);
                f0VarArr[i17] = new androidx.media3.common.f0(sb2.toString(), v(rVar3, rVar2, false));
            }
            i17++;
        }
        this.I = u(f0VarArr);
        androidx.media3.common.util.a.g(this.J == null);
        this.J = Collections.emptySet();
    }

    private boolean n(int i11) {
        for (int i12 = i11; i12 < this.f12049n.size(); i12++) {
            if (((i) this.f12049n.get(i12)).f11827n) {
                return false;
            }
        }
        i iVar = (i) this.f12049n.get(i11);
        for (int i13 = 0; i13 < this.f12057v.length; i13++) {
            if (this.f12057v[i13].F() > iVar.k(i13)) {
                return false;
            }
        }
        return true;
    }

    private static l2.n s(int i11, int i12) {
        androidx.media3.common.util.u.h("HlsSampleStreamWrapper", "Unmapped track with id " + i11 + " of type " + i12);
        return new l2.n();
    }

    private e0 t(int i11, int i12) {
        int length = this.f12057v.length;
        boolean z10 = true;
        if (i12 != 1 && i12 != 2) {
            z10 = false;
        }
        d dVar = new d(this.f12040e, this.f12042g, this.f12043h, this.f12055t);
        dVar.e0(this.P);
        if (z10) {
            dVar.l0(this.W);
        }
        dVar.d0(this.V);
        i iVar = this.X;
        if (iVar != null) {
            dVar.m0(iVar);
        }
        dVar.g0(this);
        int i13 = length + 1;
        int[] copyOf = Arrays.copyOf(this.f12058w, i13);
        this.f12058w = copyOf;
        copyOf[length] = i11;
        this.f12057v = (d[]) a1.V0(this.f12057v, dVar);
        boolean[] copyOf2 = Arrays.copyOf(this.O, i13);
        this.O = copyOf2;
        copyOf2[length] = z10;
        this.M |= z10;
        this.f12059x.add(Integer.valueOf(i12));
        this.f12060y.append(i12, length);
        if (C(i12) > C(this.A)) {
            this.B = length;
            this.A = i12;
        }
        this.N = Arrays.copyOf(this.N, i13);
        return dVar;
    }

    private z u(androidx.media3.common.f0[] f0VarArr) {
        for (int i11 = 0; i11 < f0VarArr.length; i11++) {
            androidx.media3.common.f0 f0Var = f0VarArr[i11];
            androidx.media3.common.r[] rVarArr = new androidx.media3.common.r[f0Var.f10053a];
            for (int i12 = 0; i12 < f0Var.f10053a; i12++) {
                androidx.media3.common.r a11 = f0Var.a(i12);
                rVarArr[i12] = a11.c(this.f12042g.b(a11));
            }
            f0VarArr[i11] = new androidx.media3.common.f0(f0Var.f10054b, rVarArr);
        }
        return new z(f0VarArr);
    }

    private static androidx.media3.common.r v(androidx.media3.common.r rVar, androidx.media3.common.r rVar2, boolean z10) {
        String d11;
        String str;
        if (rVar == null) {
            return rVar2;
        }
        int k11 = y.k(rVar2.f10243o);
        if (a1.R(rVar.f10239k, k11) == 1) {
            d11 = a1.S(rVar.f10239k, k11);
            str = y.g(d11);
        } else {
            d11 = y.d(rVar.f10239k, rVar2.f10243o);
            str = rVar2.f10243o;
        }
        r.b S = rVar2.b().f0(rVar.f10229a).h0(rVar.f10230b).i0(rVar.f10231c).j0(rVar.f10232d).w0(rVar.f10233e).s0(rVar.f10234f).Q(z10 ? rVar.f10236h : -1).p0(z10 ? rVar.f10237i : -1).S(d11);
        if (k11 == 2) {
            S.B0(rVar.f10250v).d0(rVar.f10251w).b0(rVar.f10252x);
        }
        if (str != null) {
            S.u0(str);
        }
        int i11 = rVar.E;
        if (i11 != -1 && k11 == 1) {
            S.R(i11);
        }
        x xVar = rVar.f10240l;
        if (xVar != null) {
            x xVar2 = rVar2.f10240l;
            if (xVar2 != null) {
                xVar = xVar2.b(xVar);
            }
            S.n0(xVar);
        }
        return S.N();
    }

    private void w(int i11) {
        androidx.media3.common.util.a.g(!this.f12045j.i());
        while (true) {
            if (i11 >= this.f12049n.size()) {
                i11 = -1;
                break;
            } else if (n(i11)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 == -1) {
            return;
        }
        long j11 = A().f64426h;
        i x10 = x(i11);
        if (this.f12049n.isEmpty()) {
            this.Q = this.P;
        } else {
            ((i) g3.g(this.f12049n)).m();
        }
        this.T = false;
        this.f12046k.F(this.A, x10.f64425g, j11);
    }

    private i x(int i11) {
        i iVar = (i) this.f12049n.get(i11);
        ArrayList arrayList = this.f12049n;
        a1.c1(arrayList, i11, arrayList.size());
        for (int i12 = 0; i12 < this.f12057v.length; i12++) {
            this.f12057v[i12].w(iVar.k(i12));
        }
        return iVar;
    }

    private boolean y(i iVar) {
        int i11 = iVar.f11824k;
        int length = this.f12057v.length;
        for (int i12 = 0; i12 < length; i12++) {
            if (this.N[i12] && this.f12057v[i12].T() == i11) {
                return false;
            }
        }
        return true;
    }

    private static boolean z(androidx.media3.common.r rVar, androidx.media3.common.r rVar2) {
        String str = rVar.f10243o;
        String str2 = rVar2.f10243o;
        int k11 = y.k(str);
        if (k11 != 3) {
            return k11 == y.k(str2);
        }
        if (Objects.equals(str, str2)) {
            return !(MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str)) || rVar.J == rVar2.J;
        }
        return false;
    }

    public boolean G(int i11) {
        return !F() && this.f12057v[i11].N(this.T);
    }

    public boolean H() {
        return this.A == 2;
    }

    public void L() {
        this.f12045j.maybeThrowError();
        this.f12039d.p();
    }

    public void M(int i11) {
        L();
        this.f12057v[i11].Q();
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void q(h2.e eVar, long j11, long j12, boolean z10) {
        this.f12056u = null;
        g2.i iVar = new g2.i(eVar.f64419a, eVar.f64420b, eVar.d(), eVar.c(), j11, j12, eVar.a());
        this.f12044i.b(eVar.f64419a);
        this.f12046k.t(iVar, eVar.f64421c, this.f12037b, eVar.f64422d, eVar.f64423e, eVar.f64424f, eVar.f64425g, eVar.f64426h);
        if (z10) {
            return;
        }
        if (F() || this.E == 0) {
            Y();
        }
        if (this.E > 0) {
            this.f12038c.f(this);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void p(h2.e eVar, long j11, long j12) {
        this.f12056u = null;
        this.f12039d.r(eVar);
        g2.i iVar = new g2.i(eVar.f64419a, eVar.f64420b, eVar.d(), eVar.c(), j11, j12, eVar.a());
        this.f12044i.b(eVar.f64419a);
        this.f12046k.w(iVar, eVar.f64421c, this.f12037b, eVar.f64422d, eVar.f64423e, eVar.f64424f, eVar.f64425g, eVar.f64426h);
        if (this.D) {
            this.f12038c.f(this);
        } else {
            a(new v2.b().f(this.P).d());
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public Loader.c k(h2.e eVar, long j11, long j12, IOException iOException, int i11) {
        Loader.c g11;
        int i12;
        boolean E = E(eVar);
        if (E && !((i) eVar).o() && (iOException instanceof HttpDataSource.InvalidResponseCodeException) && ((i12 = ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode) == 410 || i12 == 404)) {
            return Loader.f13029d;
        }
        long a11 = eVar.a();
        g2.i iVar = new g2.i(eVar.f64419a, eVar.f64420b, eVar.d(), eVar.c(), j11, j12, a11);
        m.c cVar = new m.c(iVar, new g2.j(eVar.f64421c, this.f12037b, eVar.f64422d, eVar.f64423e, eVar.f64424f, a1.y1(eVar.f64425g), a1.y1(eVar.f64426h)), iOException, i11);
        m.b d11 = this.f12044i.d(d0.c(this.f12039d.l()), cVar);
        boolean o11 = (d11 == null || d11.f13090a != 2) ? false : this.f12039d.o(eVar, d11.f13091b);
        if (o11) {
            if (E && a11 == 0) {
                ArrayList arrayList = this.f12049n;
                androidx.media3.common.util.a.g(((i) arrayList.remove(arrayList.size() - 1)) == eVar);
                if (this.f12049n.isEmpty()) {
                    this.Q = this.P;
                } else {
                    ((i) g3.g(this.f12049n)).m();
                }
            }
            g11 = Loader.f13031f;
        } else {
            long c11 = this.f12044i.c(cVar);
            g11 = c11 != C.TIME_UNSET ? Loader.g(false, c11) : Loader.f13032g;
        }
        Loader.c cVar2 = g11;
        boolean c12 = cVar2.c();
        this.f12046k.y(iVar, eVar.f64421c, this.f12037b, eVar.f64422d, eVar.f64423e, eVar.f64424f, eVar.f64425g, eVar.f64426h, iOException, !c12);
        if (!c12) {
            this.f12056u = null;
            this.f12044i.b(eVar.f64419a);
        }
        if (o11) {
            if (this.D) {
                this.f12038c.f(this);
            } else {
                a(new v2.b().f(this.P).d());
            }
        }
        return cVar2;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void o(h2.e eVar, long j11, long j12, int i11) {
        this.f12046k.C(i11 == 0 ? new g2.i(eVar.f64419a, eVar.f64420b, j11) : new g2.i(eVar.f64419a, eVar.f64420b, eVar.d(), eVar.c(), j11, j12, eVar.a()), eVar.f64421c, this.f12037b, eVar.f64422d, eVar.f64423e, eVar.f64424f, eVar.f64425g, eVar.f64426h, i11);
    }

    public void R() {
        this.f12059x.clear();
    }

    public boolean S(Uri uri, m.c cVar, boolean z10) {
        m.b d11;
        if (!this.f12039d.q(uri)) {
            return true;
        }
        long j11 = (z10 || (d11 = this.f12044i.d(d0.c(this.f12039d.l()), cVar)) == null || d11.f13090a != 2) ? -9223372036854775807L : d11.f13091b;
        return this.f12039d.s(uri, j11) && j11 != C.TIME_UNSET;
    }

    public void T() {
        if (this.f12049n.isEmpty()) {
            return;
        }
        final i iVar = (i) g3.g(this.f12049n);
        int d11 = this.f12039d.d(iVar);
        if (d11 == 1) {
            iVar.t();
            return;
        }
        if (d11 == 0) {
            this.f12053r.post(new Runnable() { // from class: androidx.media3.exoplayer.hls.n
                @Override // java.lang.Runnable
                public final void run() {
                    r.this.I(iVar);
                }
            });
        } else if (d11 == 2 && !this.T && this.f12045j.i()) {
            this.f12045j.e();
        }
    }

    public void V(androidx.media3.common.f0[] f0VarArr, int i11, int... iArr) {
        this.I = u(f0VarArr);
        this.J = new HashSet();
        for (int i12 : iArr) {
            this.J.add(this.I.b(i12));
        }
        this.L = i11;
        Handler handler = this.f12053r;
        final b bVar = this.f12038c;
        Objects.requireNonNull(bVar);
        handler.post(new Runnable() { // from class: androidx.media3.exoplayer.hls.q
            @Override // java.lang.Runnable
            public final void run() {
                r.b.this.onPrepared();
            }
        });
        d0();
    }

    public int W(int i11, s2 s2Var, DecoderInputBuffer decoderInputBuffer, int i12) {
        if (F()) {
            return -3;
        }
        int i13 = 0;
        if (!this.f12049n.isEmpty()) {
            int i14 = 0;
            while (i14 < this.f12049n.size() - 1 && y((i) this.f12049n.get(i14))) {
                i14++;
            }
            a1.c1(this.f12049n, 0, i14);
            i iVar = (i) this.f12049n.get(0);
            androidx.media3.common.r rVar = iVar.f64422d;
            if (!rVar.equals(this.G)) {
                this.f12046k.j(this.f12037b, rVar, iVar.f64423e, iVar.f64424f, iVar.f64425g);
            }
            this.G = rVar;
        }
        if (!this.f12049n.isEmpty() && !((i) this.f12049n.get(0)).o()) {
            return -3;
        }
        int V = this.f12057v[i11].V(s2Var, decoderInputBuffer, i12, this.T);
        if (V == -5) {
            androidx.media3.common.r rVar2 = (androidx.media3.common.r) androidx.media3.common.util.a.e(s2Var.f12652b);
            if (i11 == this.B) {
                int d11 = Ints.d(this.f12057v[i11].T());
                while (i13 < this.f12049n.size() && ((i) this.f12049n.get(i13)).f11824k != d11) {
                    i13++;
                }
                rVar2 = rVar2.j(i13 < this.f12049n.size() ? ((i) this.f12049n.get(i13)).f64422d : (androidx.media3.common.r) androidx.media3.common.util.a.e(this.F));
            }
            s2Var.f12652b = rVar2;
        }
        return V;
    }

    public void X() {
        if (this.D) {
            for (d dVar : this.f12057v) {
                dVar.U();
            }
        }
        this.f12039d.t();
        this.f12045j.l(this);
        this.f12053r.removeCallbacksAndMessages(null);
        this.H = true;
        this.f12054s.clear();
    }

    @Override // androidx.media3.exoplayer.source.f0
    public boolean a(v2 v2Var) {
        List list;
        long max;
        if (this.T || this.f12045j.i() || this.f12045j.h()) {
            return false;
        }
        if (F()) {
            list = Collections.emptyList();
            max = this.Q;
            for (d dVar : this.f12057v) {
                dVar.e0(this.Q);
            }
        } else {
            list = this.f12050o;
            i A = A();
            max = A.f() ? A.f64426h : Math.max(this.P, A.f64425g);
        }
        List list2 = list;
        long j11 = max;
        this.f12048m.a();
        this.f12039d.f(v2Var, j11, list2, this.D || !list2.isEmpty(), this.f12048m);
        e.b bVar = this.f12048m;
        boolean z10 = bVar.f11812b;
        h2.e eVar = bVar.f11811a;
        Uri uri = bVar.f11813c;
        if (z10) {
            this.Q = C.TIME_UNSET;
            this.T = true;
            return true;
        }
        if (eVar == null) {
            if (uri != null) {
                this.f12038c.d(uri);
            }
            return false;
        }
        if (E(eVar)) {
            D((i) eVar);
        }
        this.f12056u = eVar;
        this.f12045j.m(eVar, this, this.f12044i.a(eVar.f64421c));
        return true;
    }

    public boolean a0(long j11, boolean z10) {
        i iVar;
        this.P = j11;
        if (F()) {
            this.Q = j11;
            return true;
        }
        if (this.f12039d.m()) {
            for (int i11 = 0; i11 < this.f12049n.size(); i11++) {
                iVar = (i) this.f12049n.get(i11);
                if (iVar.f64425g == j11) {
                    break;
                }
            }
        }
        iVar = null;
        if (this.C && !z10 && Z(j11, iVar)) {
            return false;
        }
        this.Q = j11;
        this.T = false;
        this.f12049n.clear();
        if (this.f12045j.i()) {
            if (this.C) {
                for (d dVar : this.f12057v) {
                    dVar.s();
                }
            }
            this.f12045j.e();
        } else {
            this.f12045j.f();
            Y();
        }
        return true;
    }

    public long b(long j11, c4 c4Var) {
        return this.f12039d.c(j11, c4Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x011a, code lost:
    
        if (r11.getSelectedIndexInTrackGroup() != r19.f12039d.k().b(r1.f64422d)) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b0(j2.z[] r20, boolean[] r21, g2.u[] r22, boolean[] r23, long r24, boolean r26) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.r.b0(j2.z[], boolean[], g2.u[], boolean[], long, boolean):boolean");
    }

    @Override // androidx.media3.exoplayer.source.e0.d
    public void c(androidx.media3.common.r rVar) {
        this.f12053r.post(this.f12051p);
    }

    public void c0(DrmInitData drmInitData) {
        if (Objects.equals(this.W, drmInitData)) {
            return;
        }
        this.W = drmInitData;
        int i11 = 0;
        while (true) {
            d[] dVarArr = this.f12057v;
            if (i11 >= dVarArr.length) {
                return;
            }
            if (this.O[i11]) {
                dVarArr[i11].l0(drmInitData);
            }
            i11++;
        }
    }

    public void discardBuffer(long j11, boolean z10) {
        if (!this.C || F()) {
            return;
        }
        int length = this.f12057v.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.f12057v[i11].r(j11, z10, this.N[i11]);
        }
    }

    public void e0(boolean z10) {
        this.f12039d.v(z10);
    }

    @Override // l2.t
    public void endTracks() {
        this.U = true;
        this.f12053r.post(this.f12052q);
    }

    @Override // l2.t
    public void f(m0 m0Var) {
    }

    public void f0(long j11) {
        if (this.V != j11) {
            this.V = j11;
            for (d dVar : this.f12057v) {
                dVar.d0(j11);
            }
        }
    }

    public int g0(int i11, long j11) {
        if (F()) {
            return 0;
        }
        d dVar = this.f12057v[i11];
        int H = dVar.H(j11, this.T);
        i iVar = (i) g3.h(this.f12049n, null);
        if (iVar != null && !iVar.o()) {
            H = Math.min(H, iVar.k(i11) - dVar.F());
        }
        dVar.h0(H);
        return H;
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException
        */
    @Override // androidx.media3.exoplayer.source.f0
    public long getBufferedPositionUs() {
        /*
            r7 = this;
            boolean r0 = r7.T
            if (r0 == 0) goto L7
            r0 = -9223372036854775808
            return r0
        L7:
            boolean r0 = r7.F()
            if (r0 == 0) goto L10
            long r0 = r7.Q
            return r0
        L10:
            long r0 = r7.P
            androidx.media3.exoplayer.hls.i r2 = r7.A()
            boolean r3 = r2.f()
            if (r3 == 0) goto L1d
            goto L36
        L1d:
            java.util.ArrayList r2 = r7.f12049n
            int r2 = r2.size()
            r3 = 1
            if (r2 <= r3) goto L35
            java.util.ArrayList r2 = r7.f12049n
            int r3 = r2.size()
            int r3 = r3 + (-2)
            java.lang.Object r2 = r2.get(r3)
            androidx.media3.exoplayer.hls.i r2 = (androidx.media3.exoplayer.hls.i) r2
            goto L36
        L35:
            r2 = 0
        L36:
            if (r2 == 0) goto L3e
            long r2 = r2.f64426h
            long r0 = java.lang.Math.max(r0, r2)
        L3e:
            boolean r2 = r7.C
            if (r2 == 0) goto L55
            androidx.media3.exoplayer.hls.r$d[] r2 = r7.f12057v
            int r3 = r2.length
            r4 = 0
        L46:
            if (r4 >= r3) goto L55
            r5 = r2[r4]
            long r5 = r5.C()
            long r0 = java.lang.Math.max(r0, r5)
            int r4 = r4 + 1
            goto L46
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.r.getBufferedPositionUs():long");
    }

    @Override // androidx.media3.exoplayer.source.f0
    public long getNextLoadPositionUs() {
        if (F()) {
            return this.Q;
        }
        if (this.T) {
            return Long.MIN_VALUE;
        }
        return A().f64426h;
    }

    public z getTrackGroups() {
        j();
        return this.I;
    }

    public void h0(int i11) {
        j();
        androidx.media3.common.util.a.e(this.K);
        int i12 = this.K[i11];
        androidx.media3.common.util.a.g(this.N[i12]);
        this.N[i12] = false;
    }

    @Override // androidx.media3.exoplayer.source.f0
    public boolean isLoading() {
        return this.f12045j.i();
    }

    public int l(int i11) {
        j();
        androidx.media3.common.util.a.e(this.K);
        int i12 = this.K[i11];
        if (i12 == -1) {
            return this.J.contains(this.I.b(i11)) ? -3 : -2;
        }
        boolean[] zArr = this.N;
        if (zArr[i12]) {
            return -2;
        }
        zArr[i12] = true;
        return i12;
    }

    public void maybeThrowPrepareError() {
        L();
        if (this.T && !this.D) {
            throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.e
    public void onLoaderReleased() {
        for (d dVar : this.f12057v) {
            dVar.W();
        }
    }

    public void r() {
        if (this.D) {
            return;
        }
        a(new v2.b().f(this.P).d());
    }

    @Override // androidx.media3.exoplayer.source.f0
    public void reevaluateBuffer(long j11) {
        if (this.f12045j.h() || F()) {
            return;
        }
        if (this.f12045j.i()) {
            androidx.media3.common.util.a.e(this.f12056u);
            if (this.f12039d.x(j11, this.f12056u, this.f12050o)) {
                this.f12045j.e();
                return;
            }
            return;
        }
        int size = this.f12050o.size();
        while (size > 0 && this.f12039d.d((i) this.f12050o.get(size - 1)) == 2) {
            size--;
        }
        if (size < this.f12050o.size()) {
            w(size);
        }
        int i11 = this.f12039d.i(j11, this.f12050o);
        if (i11 < this.f12049n.size()) {
            w(i11);
        }
    }

    @Override // l2.t
    public s0 track(int i11, int i12) {
        s0 s0Var;
        if (!Y.contains(Integer.valueOf(i12))) {
            int i13 = 0;
            while (true) {
                s0[] s0VarArr = this.f12057v;
                if (i13 >= s0VarArr.length) {
                    s0Var = null;
                    break;
                }
                if (this.f12058w[i13] == i11) {
                    s0Var = s0VarArr[i13];
                    break;
                }
                i13++;
            }
        } else {
            s0Var = B(i11, i12);
        }
        if (s0Var == null) {
            if (this.U) {
                return s(i11, i12);
            }
            s0Var = t(i11, i12);
        }
        if (i12 != 5) {
            return s0Var;
        }
        if (this.f12061z == null) {
            this.f12061z = new c(s0Var, this.f12047l);
        }
        return this.f12061z;
    }
}
