package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.c3;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.hls.e;
import com.google.android.exoplayer2.source.hls.p;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.w;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.g3;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import g9.e0;
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
import t9.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class p implements Loader.b, Loader.e, b0, g9.n, a0.d {
    private static final Set Y = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 5)));
    private int A;
    private int B;
    private boolean C;
    private boolean D;
    private int E;
    private o1 F;
    private o1 G;
    private boolean H;
    private x I;
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
    private final String f26082a;

    /* renamed from: b, reason: collision with root package name */
    private final int f26083b;

    /* renamed from: c, reason: collision with root package name */
    private final b f26084c;

    /* renamed from: d, reason: collision with root package name */
    private final e f26085d;

    /* renamed from: e, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.b f26086e;

    /* renamed from: f, reason: collision with root package name */
    private final o1 f26087f;

    /* renamed from: g, reason: collision with root package name */
    private final u f26088g;

    /* renamed from: h, reason: collision with root package name */
    private final s.a f26089h;

    /* renamed from: i, reason: collision with root package name */
    private final z f26090i;

    /* renamed from: k, reason: collision with root package name */
    private final p.a f26092k;

    /* renamed from: l, reason: collision with root package name */
    private final int f26093l;

    /* renamed from: n, reason: collision with root package name */
    private final ArrayList f26095n;

    /* renamed from: o, reason: collision with root package name */
    private final List f26096o;

    /* renamed from: p, reason: collision with root package name */
    private final Runnable f26097p;

    /* renamed from: q, reason: collision with root package name */
    private final Runnable f26098q;

    /* renamed from: r, reason: collision with root package name */
    private final Handler f26099r;

    /* renamed from: s, reason: collision with root package name */
    private final ArrayList f26100s;

    /* renamed from: t, reason: collision with root package name */
    private final Map f26101t;

    /* renamed from: u, reason: collision with root package name */
    private v9.f f26102u;

    /* renamed from: v, reason: collision with root package name */
    private d[] f26103v;

    /* renamed from: x, reason: collision with root package name */
    private Set f26105x;

    /* renamed from: y, reason: collision with root package name */
    private SparseIntArray f26106y;

    /* renamed from: z, reason: collision with root package name */
    private e0 f26107z;

    /* renamed from: j, reason: collision with root package name */
    private final Loader f26091j = new Loader("Loader:HlsSampleStreamWrapper");

    /* renamed from: m, reason: collision with root package name */
    private final e.b f26094m = new e.b();

    /* renamed from: w, reason: collision with root package name */
    private int[] f26104w = new int[0];

    /* loaded from: classes3.dex */
    public interface b extends b0.a {
        void d(Uri uri);

        void onPrepared();
    }

    /* loaded from: classes3.dex */
    private static class c implements e0 {

        /* renamed from: g, reason: collision with root package name */
        private static final o1 f26108g = new o1.b().e0(MimeTypes.APPLICATION_ID3).E();

        /* renamed from: h, reason: collision with root package name */
        private static final o1 f26109h = new o1.b().e0(MimeTypes.APPLICATION_EMSG).E();

        /* renamed from: a, reason: collision with root package name */
        private final com.google.android.exoplayer2.metadata.emsg.a f26110a = new com.google.android.exoplayer2.metadata.emsg.a();

        /* renamed from: b, reason: collision with root package name */
        private final e0 f26111b;

        /* renamed from: c, reason: collision with root package name */
        private final o1 f26112c;

        /* renamed from: d, reason: collision with root package name */
        private o1 f26113d;

        /* renamed from: e, reason: collision with root package name */
        private byte[] f26114e;

        /* renamed from: f, reason: collision with root package name */
        private int f26115f;

        public c(e0 e0Var, int i11) {
            this.f26111b = e0Var;
            if (i11 == 1) {
                this.f26112c = f26108g;
            } else {
                if (i11 != 3) {
                    StringBuilder sb2 = new StringBuilder(33);
                    sb2.append("Unknown metadataType: ");
                    sb2.append(i11);
                    throw new IllegalArgumentException(sb2.toString());
                }
                this.f26112c = f26109h;
            }
            this.f26114e = new byte[0];
            this.f26115f = 0;
        }

        private boolean g(EventMessage eventMessage) {
            o1 wrappedMetadataFormat = eventMessage.getWrappedMetadataFormat();
            return wrappedMetadataFormat != null && p0.c(this.f26112c.f25550l, wrappedMetadataFormat.f25550l);
        }

        private void h(int i11) {
            byte[] bArr = this.f26114e;
            if (bArr.length < i11) {
                this.f26114e = Arrays.copyOf(bArr, i11 + (i11 / 2));
            }
        }

        private d0 i(int i11, int i12) {
            int i13 = this.f26115f - i12;
            d0 d0Var = new d0(Arrays.copyOfRange(this.f26114e, i13 - i11, i13));
            byte[] bArr = this.f26114e;
            System.arraycopy(bArr, i13, bArr, 0, i12);
            this.f26115f = i12;
            return d0Var;
        }

        @Override // g9.e0
        public int a(com.google.android.exoplayer2.upstream.g gVar, int i11, boolean z10, int i12) {
            h(this.f26115f + i11);
            int read = gVar.read(this.f26114e, this.f26115f, i11);
            if (read != -1) {
                this.f26115f += read;
                return read;
            }
            if (z10) {
                return -1;
            }
            throw new EOFException();
        }

        @Override // g9.e0
        public /* synthetic */ int b(com.google.android.exoplayer2.upstream.g gVar, int i11, boolean z10) {
            return g9.d0.a(this, gVar, i11, z10);
        }

        @Override // g9.e0
        public /* synthetic */ void c(d0 d0Var, int i11) {
            g9.d0.b(this, d0Var, i11);
        }

        @Override // g9.e0
        public void d(long j11, int i11, int i12, int i13, e0.a aVar) {
            com.google.android.exoplayer2.util.a.e(this.f26113d);
            d0 i14 = i(i12, i13);
            if (!p0.c(this.f26113d.f25550l, this.f26112c.f25550l)) {
                if (!MimeTypes.APPLICATION_EMSG.equals(this.f26113d.f25550l)) {
                    String valueOf = String.valueOf(this.f26113d.f25550l);
                    com.google.android.exoplayer2.util.s.i("HlsSampleStreamWrapper", valueOf.length() != 0 ? "Ignoring sample for unsupported format: ".concat(valueOf) : new String("Ignoring sample for unsupported format: "));
                    return;
                } else {
                    EventMessage c11 = this.f26110a.c(i14);
                    if (!g(c11)) {
                        com.google.android.exoplayer2.util.s.i("HlsSampleStreamWrapper", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.f26112c.f25550l, c11.getWrappedMetadataFormat()));
                        return;
                    }
                    i14 = new d0((byte[]) com.google.android.exoplayer2.util.a.e(c11.getWrappedMetadataBytes()));
                }
            }
            int a11 = i14.a();
            this.f26111b.c(i14, a11);
            this.f26111b.d(j11, i11, a11, i13, aVar);
        }

        @Override // g9.e0
        public void e(o1 o1Var) {
            this.f26113d = o1Var;
            this.f26111b.e(this.f26112c);
        }

        @Override // g9.e0
        public void f(d0 d0Var, int i11, int i12) {
            h(this.f26115f + i11);
            d0Var.j(this.f26114e, this.f26115f, i11);
            this.f26115f += i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class d extends a0 {
        private final Map H;
        private DrmInitData I;

        private d(com.google.android.exoplayer2.upstream.b bVar, u uVar, s.a aVar, Map map) {
            super(bVar, uVar, aVar);
            this.H = map;
        }

        private Metadata h0(Metadata metadata) {
            if (metadata == null) {
                return null;
            }
            int length = metadata.length();
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    i12 = -1;
                    break;
                }
                Metadata.Entry entry = metadata.get(i12);
                if ((entry instanceof PrivFrame) && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame) entry).owner)) {
                    break;
                }
                i12++;
            }
            if (i12 == -1) {
                return metadata;
            }
            if (length == 1) {
                return null;
            }
            Metadata.Entry[] entryArr = new Metadata.Entry[length - 1];
            while (i11 < length) {
                if (i11 != i12) {
                    entryArr[i11 < i12 ? i11 : i11 - 1] = metadata.get(i11);
                }
                i11++;
            }
            return new Metadata(entryArr);
        }

        @Override // com.google.android.exoplayer2.source.a0, g9.e0
        public void d(long j11, int i11, int i12, int i13, e0.a aVar) {
            super.d(j11, i11, i12, i13, aVar);
        }

        public void i0(DrmInitData drmInitData) {
            this.I = drmInitData;
            I();
        }

        public void j0(i iVar) {
            f0(iVar.f26036k);
        }

        @Override // com.google.android.exoplayer2.source.a0
        public o1 w(o1 o1Var) {
            DrmInitData drmInitData;
            DrmInitData drmInitData2 = this.I;
            if (drmInitData2 == null) {
                drmInitData2 = o1Var.f25553o;
            }
            if (drmInitData2 != null && (drmInitData = (DrmInitData) this.H.get(drmInitData2.schemeType)) != null) {
                drmInitData2 = drmInitData;
            }
            Metadata h02 = h0(o1Var.f25548j);
            if (drmInitData2 != o1Var.f25553o || h02 != o1Var.f25548j) {
                o1Var = o1Var.b().M(drmInitData2).X(h02).E();
            }
            return super.w(o1Var);
        }
    }

    public p(String str, int i11, b bVar, e eVar, Map map, com.google.android.exoplayer2.upstream.b bVar2, long j11, o1 o1Var, u uVar, s.a aVar, z zVar, p.a aVar2, int i12) {
        this.f26082a = str;
        this.f26083b = i11;
        this.f26084c = bVar;
        this.f26085d = eVar;
        this.f26101t = map;
        this.f26086e = bVar2;
        this.f26087f = o1Var;
        this.f26088g = uVar;
        this.f26089h = aVar;
        this.f26090i = zVar;
        this.f26092k = aVar2;
        this.f26093l = i12;
        Set set = Y;
        this.f26105x = new HashSet(set.size());
        this.f26106y = new SparseIntArray(set.size());
        this.f26103v = new d[0];
        this.O = new boolean[0];
        this.N = new boolean[0];
        ArrayList arrayList = new ArrayList();
        this.f26095n = arrayList;
        this.f26096o = Collections.unmodifiableList(arrayList);
        this.f26100s = new ArrayList();
        this.f26097p = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.n
            @Override // java.lang.Runnable
            public final void run() {
                p.this.G();
            }
        };
        this.f26098q = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.o
            @Override // java.lang.Runnable
            public final void run() {
                p.this.P();
            }
        };
        this.f26099r = p0.w();
        this.P = j11;
        this.Q = j11;
    }

    private void A(i iVar) {
        this.X = iVar;
        this.F = iVar.f77258d;
        this.Q = C.TIME_UNSET;
        this.f26095n.add(iVar);
        ImmutableList.a builder = ImmutableList.builder();
        for (d dVar : this.f26103v) {
            builder.a(Integer.valueOf(dVar.G()));
        }
        iVar.l(this, builder.e());
        for (d dVar2 : this.f26103v) {
            dVar2.j0(iVar);
            if (iVar.f26039n) {
                dVar2.g0();
            }
        }
    }

    private static boolean B(v9.f fVar) {
        return fVar instanceof i;
    }

    private boolean C() {
        return this.Q != C.TIME_UNSET;
    }

    private void F() {
        int i11 = this.I.f76288a;
        int[] iArr = new int[i11];
        this.K = iArr;
        Arrays.fill(iArr, -1);
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = 0;
            while (true) {
                d[] dVarArr = this.f26103v;
                if (i13 >= dVarArr.length) {
                    break;
                }
                if (w((o1) com.google.android.exoplayer2.util.a.i(dVarArr[i13].F()), this.I.b(i12).c(0))) {
                    this.K[i12] = i13;
                    break;
                }
                i13++;
            }
        }
        Iterator it = this.f26100s.iterator();
        while (it.hasNext()) {
            ((l) it.next()).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        if (!this.H && this.K == null && this.C) {
            for (d dVar : this.f26103v) {
                if (dVar.F() == null) {
                    return;
                }
            }
            if (this.I != null) {
                F();
                return;
            }
            k();
            Y();
            this.f26084c.onPrepared();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.C = true;
        G();
    }

    private void T() {
        for (d dVar : this.f26103v) {
            dVar.W(this.R);
        }
        this.R = false;
    }

    private boolean U(long j11) {
        int length = this.f26103v.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (!this.f26103v[i11].Z(j11, false) && (this.O[i11] || !this.M)) {
                return false;
            }
        }
        return true;
    }

    private void Y() {
        this.D = true;
    }

    private void d0(t9.s[] sVarArr) {
        this.f26100s.clear();
        for (t9.s sVar : sVarArr) {
            if (sVar != null) {
                this.f26100s.add((l) sVar);
            }
        }
    }

    private void h() {
        com.google.android.exoplayer2.util.a.g(this.D);
        com.google.android.exoplayer2.util.a.e(this.I);
        com.google.android.exoplayer2.util.a.e(this.J);
    }

    private void k() {
        int i11;
        o1 o1Var;
        int length = this.f26103v.length;
        int i12 = -2;
        int i13 = -1;
        int i14 = 0;
        while (true) {
            if (i14 >= length) {
                break;
            }
            String str = ((o1) com.google.android.exoplayer2.util.a.i(this.f26103v[i14].F())).f25550l;
            i11 = w.t(str) ? 2 : w.p(str) ? 1 : w.s(str) ? 3 : -2;
            if (z(i11) > z(i12)) {
                i13 = i14;
                i12 = i11;
            } else if (i11 == i12 && i13 != -1) {
                i13 = -1;
            }
            i14++;
        }
        TrackGroup j11 = this.f26085d.j();
        int i15 = j11.f25727a;
        this.L = -1;
        this.K = new int[length];
        for (int i16 = 0; i16 < length; i16++) {
            this.K[i16] = i16;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        int i17 = 0;
        while (i17 < length) {
            o1 o1Var2 = (o1) com.google.android.exoplayer2.util.a.i(this.f26103v[i17].F());
            if (i17 == i13) {
                o1[] o1VarArr = new o1[i15];
                for (int i18 = 0; i18 < i15; i18++) {
                    o1 c11 = j11.c(i18);
                    if (i12 == 1 && (o1Var = this.f26087f) != null) {
                        c11 = c11.j(o1Var);
                    }
                    o1VarArr[i18] = i15 == 1 ? o1Var2.j(c11) : s(c11, o1Var2, true);
                }
                trackGroupArr[i17] = new TrackGroup(this.f26082a, o1VarArr);
                this.L = i17;
            } else {
                o1 o1Var3 = (i12 == i11 && w.p(o1Var2.f25550l)) ? this.f26087f : null;
                String str2 = this.f26082a;
                int i19 = i17 < i13 ? i17 : i17 - 1;
                StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 18);
                sb2.append(str2);
                sb2.append(":muxed:");
                sb2.append(i19);
                trackGroupArr[i17] = new TrackGroup(sb2.toString(), s(o1Var3, o1Var2, false));
            }
            i17++;
            i11 = 2;
        }
        this.I = r(trackGroupArr);
        com.google.android.exoplayer2.util.a.g(this.J == null);
        this.J = Collections.emptySet();
    }

    private boolean m(int i11) {
        for (int i12 = i11; i12 < this.f26095n.size(); i12++) {
            if (((i) this.f26095n.get(i12)).f26039n) {
                return false;
            }
        }
        i iVar = (i) this.f26095n.get(i11);
        for (int i13 = 0; i13 < this.f26103v.length; i13++) {
            if (this.f26103v[i13].C() > iVar.k(i13)) {
                return false;
            }
        }
        return true;
    }

    private static g9.k p(int i11, int i12) {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("Unmapped track with id ");
        sb2.append(i11);
        sb2.append(" of type ");
        sb2.append(i12);
        com.google.android.exoplayer2.util.s.i("HlsSampleStreamWrapper", sb2.toString());
        return new g9.k();
    }

    private a0 q(int i11, int i12) {
        int length = this.f26103v.length;
        boolean z10 = true;
        if (i12 != 1 && i12 != 2) {
            z10 = false;
        }
        d dVar = new d(this.f26086e, this.f26088g, this.f26089h, this.f26101t);
        dVar.b0(this.P);
        if (z10) {
            dVar.i0(this.W);
        }
        dVar.a0(this.V);
        i iVar = this.X;
        if (iVar != null) {
            dVar.j0(iVar);
        }
        dVar.d0(this);
        int i13 = length + 1;
        int[] copyOf = Arrays.copyOf(this.f26104w, i13);
        this.f26104w = copyOf;
        copyOf[length] = i11;
        this.f26103v = (d[]) p0.E0(this.f26103v, dVar);
        boolean[] copyOf2 = Arrays.copyOf(this.O, i13);
        this.O = copyOf2;
        copyOf2[length] = z10;
        this.M |= z10;
        this.f26105x.add(Integer.valueOf(i12));
        this.f26106y.append(i12, length);
        if (z(i12) > z(this.A)) {
            this.B = length;
            this.A = i12;
        }
        this.N = Arrays.copyOf(this.N, i13);
        return dVar;
    }

    private x r(TrackGroup[] trackGroupArr) {
        for (int i11 = 0; i11 < trackGroupArr.length; i11++) {
            TrackGroup trackGroup = trackGroupArr[i11];
            o1[] o1VarArr = new o1[trackGroup.f25727a];
            for (int i12 = 0; i12 < trackGroup.f25727a; i12++) {
                o1 c11 = trackGroup.c(i12);
                o1VarArr[i12] = c11.c(this.f26088g.a(c11));
            }
            trackGroupArr[i11] = new TrackGroup(trackGroup.f25728b, o1VarArr);
        }
        return new x(trackGroupArr);
    }

    private static o1 s(o1 o1Var, o1 o1Var2, boolean z10) {
        String d11;
        String str;
        if (o1Var == null) {
            return o1Var2;
        }
        int l11 = w.l(o1Var2.f25550l);
        if (p0.K(o1Var.f25547i, l11) == 1) {
            d11 = p0.L(o1Var.f25547i, l11);
            str = w.g(d11);
        } else {
            d11 = w.d(o1Var.f25547i, o1Var2.f25550l);
            str = o1Var2.f25550l;
        }
        o1.b I = o1Var2.b().S(o1Var.f25539a).U(o1Var.f25540b).V(o1Var.f25541c).g0(o1Var.f25542d).c0(o1Var.f25543e).G(z10 ? o1Var.f25544f : -1).Z(z10 ? o1Var.f25545g : -1).I(d11);
        if (l11 == 2) {
            I.j0(o1Var.f25555q).Q(o1Var.f25556r).P(o1Var.f25557s);
        }
        if (str != null) {
            I.e0(str);
        }
        int i11 = o1Var.f25563y;
        if (i11 != -1 && l11 == 1) {
            I.H(i11);
        }
        Metadata metadata = o1Var.f25548j;
        if (metadata != null) {
            Metadata metadata2 = o1Var2.f25548j;
            if (metadata2 != null) {
                metadata = metadata2.copyWithAppendedEntriesFrom(metadata);
            }
            I.X(metadata);
        }
        return I.E();
    }

    private void t(int i11) {
        com.google.android.exoplayer2.util.a.g(!this.f26091j.i());
        while (true) {
            if (i11 >= this.f26095n.size()) {
                i11 = -1;
                break;
            } else if (m(i11)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 == -1) {
            return;
        }
        long j11 = x().f77262h;
        i u11 = u(i11);
        if (this.f26095n.isEmpty()) {
            this.Q = this.P;
        } else {
            ((i) g3.g(this.f26095n)).m();
        }
        this.T = false;
        this.f26092k.D(this.A, u11.f77261g, j11);
    }

    private i u(int i11) {
        i iVar = (i) this.f26095n.get(i11);
        ArrayList arrayList = this.f26095n;
        p0.M0(arrayList, i11, arrayList.size());
        for (int i12 = 0; i12 < this.f26103v.length; i12++) {
            this.f26103v[i12].u(iVar.k(i12));
        }
        return iVar;
    }

    private boolean v(i iVar) {
        int i11 = iVar.f26036k;
        int length = this.f26103v.length;
        for (int i12 = 0; i12 < length; i12++) {
            if (this.N[i12] && this.f26103v[i12].Q() == i11) {
                return false;
            }
        }
        return true;
    }

    private static boolean w(o1 o1Var, o1 o1Var2) {
        String str = o1Var.f25550l;
        String str2 = o1Var2.f25550l;
        int l11 = w.l(str);
        if (l11 != 3) {
            return l11 == w.l(str2);
        }
        if (p0.c(str, str2)) {
            return !(MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str)) || o1Var.D == o1Var2.D;
        }
        return false;
    }

    private i x() {
        return (i) this.f26095n.get(r0.size() - 1);
    }

    private e0 y(int i11, int i12) {
        com.google.android.exoplayer2.util.a.a(Y.contains(Integer.valueOf(i12)));
        int i13 = this.f26106y.get(i12, -1);
        if (i13 == -1) {
            return null;
        }
        if (this.f26105x.add(Integer.valueOf(i12))) {
            this.f26104w[i13] = i11;
        }
        return this.f26104w[i13] == i11 ? this.f26103v[i13] : p(i11, i12);
    }

    private static int z(int i11) {
        if (i11 == 1) {
            return 2;
        }
        if (i11 != 2) {
            return i11 != 3 ? 0 : 1;
        }
        return 3;
    }

    public boolean D(int i11) {
        return !C() && this.f26103v[i11].K(this.T);
    }

    public boolean E() {
        return this.A == 2;
    }

    public void H() {
        this.f26091j.maybeThrowError();
        this.f26085d.n();
    }

    public void I(int i11) {
        H();
        this.f26103v[i11].N();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void j(v9.f fVar, long j11, long j12, boolean z10) {
        this.f26102u = null;
        t9.h hVar = new t9.h(fVar.f77255a, fVar.f77256b, fVar.d(), fVar.c(), j11, j12, fVar.a());
        this.f26090i.b(fVar.f77255a);
        this.f26092k.r(hVar, fVar.f77257c, this.f26083b, fVar.f77258d, fVar.f77259e, fVar.f77260f, fVar.f77261g, fVar.f77262h);
        if (z10) {
            return;
        }
        if (C() || this.E == 0) {
            T();
        }
        if (this.E > 0) {
            this.f26084c.g(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void l(v9.f fVar, long j11, long j12) {
        this.f26102u = null;
        this.f26085d.p(fVar);
        t9.h hVar = new t9.h(fVar.f77255a, fVar.f77256b, fVar.d(), fVar.c(), j11, j12, fVar.a());
        this.f26090i.b(fVar.f77255a);
        this.f26092k.u(hVar, fVar.f77257c, this.f26083b, fVar.f77258d, fVar.f77259e, fVar.f77260f, fVar.f77261g, fVar.f77262h);
        if (this.D) {
            this.f26084c.g(this);
        } else {
            continueLoading(this.P);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public Loader.c n(v9.f fVar, long j11, long j12, IOException iOException, int i11) {
        Loader.c g11;
        int i12;
        boolean B = B(fVar);
        if (B && !((i) fVar).o() && (iOException instanceof HttpDataSource$InvalidResponseCodeException) && ((i12 = ((HttpDataSource$InvalidResponseCodeException) iOException).responseCode) == 410 || i12 == 404)) {
            return Loader.f27298d;
        }
        long a11 = fVar.a();
        t9.h hVar = new t9.h(fVar.f77255a, fVar.f77256b, fVar.d(), fVar.c(), j11, j12, a11);
        z.c cVar = new z.c(hVar, new t9.i(fVar.f77257c, this.f26083b, fVar.f77258d, fVar.f77259e, fVar.f77260f, p0.e1(fVar.f77261g), p0.e1(fVar.f77262h)), iOException, i11);
        z.b d11 = this.f26090i.d(com.google.android.exoplayer2.trackselection.j.c(this.f26085d.k()), cVar);
        boolean m11 = (d11 == null || d11.f27594a != 2) ? false : this.f26085d.m(fVar, d11.f27595b);
        if (m11) {
            if (B && a11 == 0) {
                ArrayList arrayList = this.f26095n;
                com.google.android.exoplayer2.util.a.g(((i) arrayList.remove(arrayList.size() - 1)) == fVar);
                if (this.f26095n.isEmpty()) {
                    this.Q = this.P;
                } else {
                    ((i) g3.g(this.f26095n)).m();
                }
            }
            g11 = Loader.f27300f;
        } else {
            long c11 = this.f26090i.c(cVar);
            g11 = c11 != C.TIME_UNSET ? Loader.g(false, c11) : Loader.f27301g;
        }
        Loader.c cVar2 = g11;
        boolean c12 = cVar2.c();
        this.f26092k.w(hVar, fVar.f77257c, this.f26083b, fVar.f77258d, fVar.f77259e, fVar.f77260f, fVar.f77261g, fVar.f77262h, iOException, !c12);
        if (!c12) {
            this.f26102u = null;
            this.f26090i.b(fVar.f77255a);
        }
        if (m11) {
            if (this.D) {
                this.f26084c.g(this);
            } else {
                continueLoading(this.P);
            }
        }
        return cVar2;
    }

    public void M() {
        this.f26105x.clear();
    }

    public boolean N(Uri uri, z.c cVar, boolean z10) {
        z.b d11;
        if (!this.f26085d.o(uri)) {
            return true;
        }
        long j11 = (z10 || (d11 = this.f26090i.d(com.google.android.exoplayer2.trackselection.j.c(this.f26085d.k()), cVar)) == null || d11.f27594a != 2) ? -9223372036854775807L : d11.f27595b;
        return this.f26085d.q(uri, j11) && j11 != C.TIME_UNSET;
    }

    public void O() {
        if (this.f26095n.isEmpty()) {
            return;
        }
        i iVar = (i) g3.g(this.f26095n);
        int c11 = this.f26085d.c(iVar);
        if (c11 == 1) {
            iVar.t();
        } else if (c11 == 2 && !this.T && this.f26091j.i()) {
            this.f26091j.e();
        }
    }

    public void Q(TrackGroup[] trackGroupArr, int i11, int... iArr) {
        this.I = r(trackGroupArr);
        this.J = new HashSet();
        for (int i12 : iArr) {
            this.J.add(this.I.b(i12));
        }
        this.L = i11;
        Handler handler = this.f26099r;
        final b bVar = this.f26084c;
        Objects.requireNonNull(bVar);
        handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.hls.m
            @Override // java.lang.Runnable
            public final void run() {
                p.b.this.onPrepared();
            }
        });
        Y();
    }

    public int R(int i11, p1 p1Var, DecoderInputBuffer decoderInputBuffer, int i12) {
        if (C()) {
            return -3;
        }
        int i13 = 0;
        if (!this.f26095n.isEmpty()) {
            int i14 = 0;
            while (i14 < this.f26095n.size() - 1 && v((i) this.f26095n.get(i14))) {
                i14++;
            }
            p0.M0(this.f26095n, 0, i14);
            i iVar = (i) this.f26095n.get(0);
            o1 o1Var = iVar.f77258d;
            if (!o1Var.equals(this.G)) {
                this.f26092k.i(this.f26083b, o1Var, iVar.f77259e, iVar.f77260f, iVar.f77261g);
            }
            this.G = o1Var;
        }
        if (!this.f26095n.isEmpty() && !((i) this.f26095n.get(0)).o()) {
            return -3;
        }
        int S = this.f26103v[i11].S(p1Var, decoderInputBuffer, i12, this.T);
        if (S == -5) {
            o1 o1Var2 = (o1) com.google.android.exoplayer2.util.a.e(p1Var.f25652b);
            if (i11 == this.B) {
                int Q = this.f26103v[i11].Q();
                while (i13 < this.f26095n.size() && ((i) this.f26095n.get(i13)).f26036k != Q) {
                    i13++;
                }
                o1Var2 = o1Var2.j(i13 < this.f26095n.size() ? ((i) this.f26095n.get(i13)).f77258d : (o1) com.google.android.exoplayer2.util.a.e(this.F));
            }
            p1Var.f25652b = o1Var2;
        }
        return S;
    }

    public void S() {
        if (this.D) {
            for (d dVar : this.f26103v) {
                dVar.R();
            }
        }
        this.f26091j.l(this);
        this.f26099r.removeCallbacksAndMessages(null);
        this.H = true;
        this.f26100s.clear();
    }

    public boolean V(long j11, boolean z10) {
        this.P = j11;
        if (C()) {
            this.Q = j11;
            return true;
        }
        if (this.C && !z10 && U(j11)) {
            return false;
        }
        this.Q = j11;
        this.T = false;
        this.f26095n.clear();
        if (this.f26091j.i()) {
            if (this.C) {
                for (d dVar : this.f26103v) {
                    dVar.r();
                }
            }
            this.f26091j.e();
        } else {
            this.f26091j.f();
            T();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x011a, code lost:
    
        if (r11.getSelectedIndexInTrackGroup() != r19.f26085d.j().d(r1.f77258d)) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean W(com.google.android.exoplayer2.trackselection.h[] r20, boolean[] r21, t9.s[] r22, boolean[] r23, long r24, boolean r26) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.p.W(com.google.android.exoplayer2.trackselection.h[], boolean[], t9.s[], boolean[], long, boolean):boolean");
    }

    public void X(DrmInitData drmInitData) {
        if (p0.c(this.W, drmInitData)) {
            return;
        }
        this.W = drmInitData;
        int i11 = 0;
        while (true) {
            d[] dVarArr = this.f26103v;
            if (i11 >= dVarArr.length) {
                return;
            }
            if (this.O[i11]) {
                dVarArr[i11].i0(drmInitData);
            }
            i11++;
        }
    }

    public void Z(boolean z10) {
        this.f26085d.t(z10);
    }

    public long a(long j11, c3 c3Var) {
        return this.f26085d.b(j11, c3Var);
    }

    public void a0(long j11) {
        if (this.V != j11) {
            this.V = j11;
            for (d dVar : this.f26103v) {
                dVar.a0(j11);
            }
        }
    }

    public int b0(int i11, long j11) {
        if (C()) {
            return 0;
        }
        d dVar = this.f26103v[i11];
        int E = dVar.E(j11, this.T);
        i iVar = (i) g3.h(this.f26095n, null);
        if (iVar != null && !iVar.o()) {
            E = Math.min(E, iVar.k(i11) - dVar.C());
        }
        dVar.e0(E);
        return E;
    }

    @Override // com.google.android.exoplayer2.source.a0.d
    public void c(o1 o1Var) {
        this.f26099r.post(this.f26097p);
    }

    public void c0(int i11) {
        h();
        com.google.android.exoplayer2.util.a.e(this.K);
        int i12 = this.K[i11];
        com.google.android.exoplayer2.util.a.g(this.N[i12]);
        this.N[i12] = false;
    }

    @Override // com.google.android.exoplayer2.source.b0
    public boolean continueLoading(long j11) {
        List list;
        long max;
        if (this.T || this.f26091j.i() || this.f26091j.h()) {
            return false;
        }
        if (C()) {
            list = Collections.emptyList();
            max = this.Q;
            for (d dVar : this.f26103v) {
                dVar.b0(this.Q);
            }
        } else {
            list = this.f26096o;
            i x10 = x();
            max = x10.f() ? x10.f77262h : Math.max(this.P, x10.f77261g);
        }
        List list2 = list;
        long j12 = max;
        this.f26094m.a();
        this.f26085d.e(j11, j12, list2, this.D || !list2.isEmpty(), this.f26094m);
        e.b bVar = this.f26094m;
        boolean z10 = bVar.f26022b;
        v9.f fVar = bVar.f26021a;
        Uri uri = bVar.f26023c;
        if (z10) {
            this.Q = C.TIME_UNSET;
            this.T = true;
            return true;
        }
        if (fVar == null) {
            if (uri != null) {
                this.f26084c.d(uri);
            }
            return false;
        }
        if (B(fVar)) {
            A((i) fVar);
        }
        this.f26102u = fVar;
        this.f26092k.A(new t9.h(fVar.f77255a, fVar.f77256b, this.f26091j.m(fVar, this, this.f26090i.a(fVar.f77257c))), fVar.f77257c, this.f26083b, fVar.f77258d, fVar.f77259e, fVar.f77260f, fVar.f77261g, fVar.f77262h);
        return true;
    }

    @Override // g9.n
    public void d(g9.b0 b0Var) {
    }

    public void discardBuffer(long j11, boolean z10) {
        if (!this.C || C()) {
            return;
        }
        int length = this.f26103v.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.f26103v[i11].q(j11, z10, this.N[i11]);
        }
    }

    @Override // g9.n
    public void endTracks() {
        this.U = true;
        this.f26099r.post(this.f26098q);
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException
        */
    @Override // com.google.android.exoplayer2.source.b0
    public long getBufferedPositionUs() {
        /*
            r7 = this;
            boolean r0 = r7.T
            if (r0 == 0) goto L7
            r0 = -9223372036854775808
            return r0
        L7:
            boolean r0 = r7.C()
            if (r0 == 0) goto L10
            long r0 = r7.Q
            return r0
        L10:
            long r0 = r7.P
            com.google.android.exoplayer2.source.hls.i r2 = r7.x()
            boolean r3 = r2.f()
            if (r3 == 0) goto L1d
            goto L36
        L1d:
            java.util.ArrayList r2 = r7.f26095n
            int r2 = r2.size()
            r3 = 1
            if (r2 <= r3) goto L35
            java.util.ArrayList r2 = r7.f26095n
            int r3 = r2.size()
            int r3 = r3 + (-2)
            java.lang.Object r2 = r2.get(r3)
            com.google.android.exoplayer2.source.hls.i r2 = (com.google.android.exoplayer2.source.hls.i) r2
            goto L36
        L35:
            r2 = 0
        L36:
            if (r2 == 0) goto L3e
            long r2 = r2.f77262h
            long r0 = java.lang.Math.max(r0, r2)
        L3e:
            boolean r2 = r7.C
            if (r2 == 0) goto L55
            com.google.android.exoplayer2.source.hls.p$d[] r2 = r7.f26103v
            int r3 = r2.length
            r4 = 0
        L46:
            if (r4 >= r3) goto L55
            r5 = r2[r4]
            long r5 = r5.z()
            long r0 = java.lang.Math.max(r0, r5)
            int r4 = r4 + 1
            goto L46
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.p.getBufferedPositionUs():long");
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long getNextLoadPositionUs() {
        if (C()) {
            return this.Q;
        }
        if (this.T) {
            return Long.MIN_VALUE;
        }
        return x().f77262h;
    }

    public x getTrackGroups() {
        h();
        return this.I;
    }

    public int i(int i11) {
        h();
        com.google.android.exoplayer2.util.a.e(this.K);
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

    @Override // com.google.android.exoplayer2.source.b0
    public boolean isLoading() {
        return this.f26091j.i();
    }

    public void maybeThrowPrepareError() {
        H();
        if (this.T && !this.D) {
            throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
        }
    }

    public void o() {
        if (this.D) {
            return;
        }
        continueLoading(this.P);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void onLoaderReleased() {
        for (d dVar : this.f26103v) {
            dVar.T();
        }
    }

    @Override // com.google.android.exoplayer2.source.b0
    public void reevaluateBuffer(long j11) {
        if (this.f26091j.h() || C()) {
            return;
        }
        if (this.f26091j.i()) {
            com.google.android.exoplayer2.util.a.e(this.f26102u);
            if (this.f26085d.v(j11, this.f26102u, this.f26096o)) {
                this.f26091j.e();
                return;
            }
            return;
        }
        int size = this.f26096o.size();
        while (size > 0 && this.f26085d.c((i) this.f26096o.get(size - 1)) == 2) {
            size--;
        }
        if (size < this.f26096o.size()) {
            t(size);
        }
        int h11 = this.f26085d.h(j11, this.f26096o);
        if (h11 < this.f26095n.size()) {
            t(h11);
        }
    }

    @Override // g9.n
    public e0 track(int i11, int i12) {
        e0 e0Var;
        if (!Y.contains(Integer.valueOf(i12))) {
            int i13 = 0;
            while (true) {
                e0[] e0VarArr = this.f26103v;
                if (i13 >= e0VarArr.length) {
                    e0Var = null;
                    break;
                }
                if (this.f26104w[i13] == i11) {
                    e0Var = e0VarArr[i13];
                    break;
                }
                i13++;
            }
        } else {
            e0Var = y(i11, i12);
        }
        if (e0Var == null) {
            if (this.U) {
                return p(i11, i12);
            }
            e0Var = q(i11, i12);
        }
        if (i12 != 5) {
            return e0Var;
        }
        if (this.f26107z == null) {
            this.f26107z = new c(e0Var, this.f26093l);
        }
        return this.f26107z;
    }
}
