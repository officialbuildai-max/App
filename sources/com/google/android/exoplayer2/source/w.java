package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.c3;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.i0;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.b0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class w implements n, g9.n, Loader.b, Loader.e, a0.d {
    private static final Map M = y();
    private static final o1 N = new o1.b().S("icy").e0("application/x-icy").E();
    private boolean A;
    private boolean C;
    private boolean D;
    private int E;
    private boolean F;
    private long G;
    private boolean I;
    private int J;
    private boolean K;
    private boolean L;

    /* renamed from: a, reason: collision with root package name */
    private final Uri f26694a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.k f26695b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.android.exoplayer2.drm.u f26696c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.z f26697d;

    /* renamed from: e, reason: collision with root package name */
    private final p.a f26698e;

    /* renamed from: f, reason: collision with root package name */
    private final s.a f26699f;

    /* renamed from: g, reason: collision with root package name */
    private final b f26700g;

    /* renamed from: h, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.b f26701h;

    /* renamed from: i, reason: collision with root package name */
    private final String f26702i;

    /* renamed from: j, reason: collision with root package name */
    private final long f26703j;

    /* renamed from: l, reason: collision with root package name */
    private final r f26705l;

    /* renamed from: q, reason: collision with root package name */
    private n.a f26710q;

    /* renamed from: r, reason: collision with root package name */
    private IcyHeaders f26711r;

    /* renamed from: u, reason: collision with root package name */
    private boolean f26714u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f26715v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f26716w;

    /* renamed from: x, reason: collision with root package name */
    private e f26717x;

    /* renamed from: y, reason: collision with root package name */
    private g9.b0 f26718y;

    /* renamed from: k, reason: collision with root package name */
    private final Loader f26704k = new Loader("ProgressiveMediaPeriod");

    /* renamed from: m, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.h f26706m = new com.google.android.exoplayer2.util.h();

    /* renamed from: n, reason: collision with root package name */
    private final Runnable f26707n = new Runnable() { // from class: com.google.android.exoplayer2.source.s
        @Override // java.lang.Runnable
        public final void run() {
            w.this.H();
        }
    };

    /* renamed from: o, reason: collision with root package name */
    private final Runnable f26708o = new Runnable() { // from class: com.google.android.exoplayer2.source.t
        @Override // java.lang.Runnable
        public final void run() {
            w.this.E();
        }
    };

    /* renamed from: p, reason: collision with root package name */
    private final Handler f26709p = p0.w();

    /* renamed from: t, reason: collision with root package name */
    private d[] f26713t = new d[0];

    /* renamed from: s, reason: collision with root package name */
    private a0[] f26712s = new a0[0];
    private long H = C.TIME_UNSET;

    /* renamed from: z, reason: collision with root package name */
    private long f26719z = C.TIME_UNSET;
    private int B = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class a implements Loader.d, k.a {

        /* renamed from: b, reason: collision with root package name */
        private final Uri f26721b;

        /* renamed from: c, reason: collision with root package name */
        private final i0 f26722c;

        /* renamed from: d, reason: collision with root package name */
        private final r f26723d;

        /* renamed from: e, reason: collision with root package name */
        private final g9.n f26724e;

        /* renamed from: f, reason: collision with root package name */
        private final com.google.android.exoplayer2.util.h f26725f;

        /* renamed from: h, reason: collision with root package name */
        private volatile boolean f26727h;

        /* renamed from: j, reason: collision with root package name */
        private long f26729j;

        /* renamed from: l, reason: collision with root package name */
        private g9.e0 f26731l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f26732m;

        /* renamed from: g, reason: collision with root package name */
        private final g9.a0 f26726g = new g9.a0();

        /* renamed from: i, reason: collision with root package name */
        private boolean f26728i = true;

        /* renamed from: a, reason: collision with root package name */
        private final long f26720a = t9.h.a();

        /* renamed from: k, reason: collision with root package name */
        private com.google.android.exoplayer2.upstream.n f26730k = g(0);

        public a(Uri uri, com.google.android.exoplayer2.upstream.k kVar, r rVar, g9.n nVar, com.google.android.exoplayer2.util.h hVar) {
            this.f26721b = uri;
            this.f26722c = new i0(kVar);
            this.f26723d = rVar;
            this.f26724e = nVar;
            this.f26725f = hVar;
        }

        private com.google.android.exoplayer2.upstream.n g(long j11) {
            return new n.b().i(this.f26721b).h(j11).f(w.this.f26702i).b(6).e(w.M).a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(long j11, long j12) {
            this.f26726g.f63492a = j11;
            this.f26729j = j12;
            this.f26728i = true;
            this.f26732m = false;
        }

        @Override // com.google.android.exoplayer2.source.k.a
        public void a(com.google.android.exoplayer2.util.d0 d0Var) {
            long max = !this.f26732m ? this.f26729j : Math.max(w.this.A(true), this.f26729j);
            int a11 = d0Var.a();
            g9.e0 e0Var = (g9.e0) com.google.android.exoplayer2.util.a.e(this.f26731l);
            e0Var.c(d0Var, a11);
            e0Var.d(max, 1, a11, 0, null);
            this.f26732m = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.d
        public void cancelLoad() {
            this.f26727h = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.d
        public void load() {
            int i11 = 0;
            while (i11 == 0 && !this.f26727h) {
                try {
                    long j11 = this.f26726g.f63492a;
                    com.google.android.exoplayer2.upstream.n g11 = g(j11);
                    this.f26730k = g11;
                    long a11 = this.f26722c.a(g11);
                    if (a11 != -1) {
                        a11 += j11;
                        w.this.M();
                    }
                    long j12 = a11;
                    w.this.f26711r = IcyHeaders.parse(this.f26722c.getResponseHeaders());
                    com.google.android.exoplayer2.upstream.g gVar = this.f26722c;
                    if (w.this.f26711r != null && w.this.f26711r.metadataInterval != -1) {
                        gVar = new k(this.f26722c, w.this.f26711r.metadataInterval, this);
                        g9.e0 B = w.this.B();
                        this.f26731l = B;
                        B.e(w.N);
                    }
                    long j13 = j11;
                    this.f26723d.d(gVar, this.f26721b, this.f26722c.getResponseHeaders(), j11, j12, this.f26724e);
                    if (w.this.f26711r != null) {
                        this.f26723d.a();
                    }
                    if (this.f26728i) {
                        this.f26723d.seek(j13, this.f26729j);
                        this.f26728i = false;
                    }
                    while (true) {
                        long j14 = j13;
                        while (i11 == 0 && !this.f26727h) {
                            try {
                                this.f26725f.a();
                                i11 = this.f26723d.c(this.f26726g);
                                j13 = this.f26723d.b();
                                if (j13 > w.this.f26703j + j14) {
                                    break;
                                }
                            } catch (InterruptedException unused) {
                                throw new InterruptedIOException();
                            }
                        }
                        this.f26725f.d();
                        w.this.f26709p.post(w.this.f26708o);
                    }
                    if (i11 == 1) {
                        i11 = 0;
                    } else if (this.f26723d.b() != -1) {
                        this.f26726g.f63492a = this.f26723d.b();
                    }
                    com.google.android.exoplayer2.upstream.m.a(this.f26722c);
                } catch (Throwable th2) {
                    if (i11 != 1 && this.f26723d.b() != -1) {
                        this.f26726g.f63492a = this.f26723d.b();
                    }
                    com.google.android.exoplayer2.upstream.m.a(this.f26722c);
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface b {
        void p(long j11, boolean z10, boolean z11);
    }

    /* loaded from: classes3.dex */
    private final class c implements t9.s {

        /* renamed from: a, reason: collision with root package name */
        private final int f26734a;

        public c(int i11) {
            this.f26734a = i11;
        }

        @Override // t9.s
        public int c(p1 p1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            return w.this.R(this.f26734a, p1Var, decoderInputBuffer, i11);
        }

        @Override // t9.s
        public boolean isReady() {
            return w.this.D(this.f26734a);
        }

        @Override // t9.s
        public void maybeThrowError() {
            w.this.L(this.f26734a);
        }

        @Override // t9.s
        public int skipData(long j11) {
            return w.this.V(this.f26734a, j11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f26736a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f26737b;

        public d(int i11, boolean z10) {
            this.f26736a = i11;
            this.f26737b = z10;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f26736a == dVar.f26736a && this.f26737b == dVar.f26737b;
        }

        public int hashCode() {
            return (this.f26736a * 31) + (this.f26737b ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final t9.x f26738a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean[] f26739b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean[] f26740c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean[] f26741d;

        public e(t9.x xVar, boolean[] zArr) {
            this.f26738a = xVar;
            this.f26739b = zArr;
            int i11 = xVar.f76288a;
            this.f26740c = new boolean[i11];
            this.f26741d = new boolean[i11];
        }
    }

    public w(Uri uri, com.google.android.exoplayer2.upstream.k kVar, r rVar, com.google.android.exoplayer2.drm.u uVar, s.a aVar, com.google.android.exoplayer2.upstream.z zVar, p.a aVar2, b bVar, com.google.android.exoplayer2.upstream.b bVar2, String str, int i11) {
        this.f26694a = uri;
        this.f26695b = kVar;
        this.f26696c = uVar;
        this.f26699f = aVar;
        this.f26697d = zVar;
        this.f26698e = aVar2;
        this.f26700g = bVar;
        this.f26701h = bVar2;
        this.f26702i = str;
        this.f26703j = i11;
        this.f26705l = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A(boolean z10) {
        long j11 = Long.MIN_VALUE;
        for (int i11 = 0; i11 < this.f26712s.length; i11++) {
            if (z10 || ((e) com.google.android.exoplayer2.util.a.e(this.f26717x)).f26740c[i11]) {
                j11 = Math.max(j11, this.f26712s[i11].z());
            }
        }
        return j11;
    }

    private boolean C() {
        return this.H != C.TIME_UNSET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        if (this.L) {
            return;
        }
        ((n.a) com.google.android.exoplayer2.util.a.e(this.f26710q)).g(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
        this.F = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        if (this.L || this.f26715v || !this.f26714u || this.f26718y == null) {
            return;
        }
        for (a0 a0Var : this.f26712s) {
            if (a0Var.F() == null) {
                return;
            }
        }
        this.f26706m.d();
        int length = this.f26712s.length;
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        boolean[] zArr = new boolean[length];
        for (int i11 = 0; i11 < length; i11++) {
            o1 o1Var = (o1) com.google.android.exoplayer2.util.a.e(this.f26712s[i11].F());
            String str = o1Var.f25550l;
            boolean p11 = com.google.android.exoplayer2.util.w.p(str);
            boolean z10 = p11 || com.google.android.exoplayer2.util.w.t(str);
            zArr[i11] = z10;
            this.f26716w = z10 | this.f26716w;
            IcyHeaders icyHeaders = this.f26711r;
            if (icyHeaders != null) {
                if (p11 || this.f26713t[i11].f26737b) {
                    Metadata metadata = o1Var.f25548j;
                    o1Var = o1Var.b().X(metadata == null ? new Metadata(icyHeaders) : metadata.copyWithAppendedEntries(icyHeaders)).E();
                }
                if (p11 && o1Var.f25544f == -1 && o1Var.f25545g == -1 && icyHeaders.bitrate != -1) {
                    o1Var = o1Var.b().G(icyHeaders.bitrate).E();
                }
            }
            trackGroupArr[i11] = new TrackGroup(Integer.toString(i11), o1Var.c(this.f26696c.a(o1Var)));
        }
        this.f26717x = new e(new t9.x(trackGroupArr), zArr);
        this.f26715v = true;
        ((n.a) com.google.android.exoplayer2.util.a.e(this.f26710q)).h(this);
    }

    private void I(int i11) {
        w();
        e eVar = this.f26717x;
        boolean[] zArr = eVar.f26741d;
        if (zArr[i11]) {
            return;
        }
        o1 c11 = eVar.f26738a.b(i11).c(0);
        this.f26698e.i(com.google.android.exoplayer2.util.w.l(c11.f25550l), c11, 0, null, this.G);
        zArr[i11] = true;
    }

    private void J(int i11) {
        w();
        boolean[] zArr = this.f26717x.f26739b;
        if (this.I && zArr[i11]) {
            if (this.f26712s[i11].K(false)) {
                return;
            }
            this.H = 0L;
            this.I = false;
            this.D = true;
            this.G = 0L;
            this.J = 0;
            for (a0 a0Var : this.f26712s) {
                a0Var.V();
            }
            ((n.a) com.google.android.exoplayer2.util.a.e(this.f26710q)).g(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        this.f26709p.post(new Runnable() { // from class: com.google.android.exoplayer2.source.u
            @Override // java.lang.Runnable
            public final void run() {
                w.this.F();
            }
        });
    }

    private g9.e0 Q(d dVar) {
        int length = this.f26712s.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (dVar.equals(this.f26713t[i11])) {
                return this.f26712s[i11];
            }
        }
        a0 k11 = a0.k(this.f26701h, this.f26696c, this.f26699f);
        k11.d0(this);
        int i12 = length + 1;
        d[] dVarArr = (d[]) Arrays.copyOf(this.f26713t, i12);
        dVarArr[length] = dVar;
        this.f26713t = (d[]) p0.k(dVarArr);
        a0[] a0VarArr = (a0[]) Arrays.copyOf(this.f26712s, i12);
        a0VarArr[length] = k11;
        this.f26712s = (a0[]) p0.k(a0VarArr);
        return k11;
    }

    private boolean T(boolean[] zArr, long j11) {
        int length = this.f26712s.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (!this.f26712s[i11].Z(j11, false) && (zArr[i11] || !this.f26716w)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public void G(g9.b0 b0Var) {
        this.f26718y = this.f26711r == null ? b0Var : new b0.b(C.TIME_UNSET);
        this.f26719z = b0Var.getDurationUs();
        boolean z10 = !this.F && b0Var.getDurationUs() == C.TIME_UNSET;
        this.A = z10;
        this.B = z10 ? 7 : 1;
        this.f26700g.p(this.f26719z, b0Var.isSeekable(), this.A);
        if (this.f26715v) {
            return;
        }
        H();
    }

    private void W() {
        a aVar = new a(this.f26694a, this.f26695b, this.f26705l, this, this.f26706m);
        if (this.f26715v) {
            com.google.android.exoplayer2.util.a.g(C());
            long j11 = this.f26719z;
            if (j11 != C.TIME_UNSET && this.H > j11) {
                this.K = true;
                this.H = C.TIME_UNSET;
                return;
            }
            aVar.h(((g9.b0) com.google.android.exoplayer2.util.a.e(this.f26718y)).getSeekPoints(this.H).f63493a.f63499b, this.H);
            for (a0 a0Var : this.f26712s) {
                a0Var.b0(this.H);
            }
            this.H = C.TIME_UNSET;
        }
        this.J = z();
        this.f26698e.A(new t9.h(aVar.f26720a, aVar.f26730k, this.f26704k.m(aVar, this, this.f26697d.a(this.B))), 1, -1, null, 0, null, aVar.f26729j, this.f26719z);
    }

    private boolean X() {
        return this.D || C();
    }

    private void w() {
        com.google.android.exoplayer2.util.a.g(this.f26715v);
        com.google.android.exoplayer2.util.a.e(this.f26717x);
        com.google.android.exoplayer2.util.a.e(this.f26718y);
    }

    private boolean x(a aVar, int i11) {
        g9.b0 b0Var;
        if (this.F || !((b0Var = this.f26718y) == null || b0Var.getDurationUs() == C.TIME_UNSET)) {
            this.J = i11;
            return true;
        }
        if (this.f26715v && !X()) {
            this.I = true;
            return false;
        }
        this.D = this.f26715v;
        this.G = 0L;
        this.J = 0;
        for (a0 a0Var : this.f26712s) {
            a0Var.V();
        }
        aVar.h(0L, 0L);
        return true;
    }

    private static Map y() {
        HashMap hashMap = new HashMap();
        hashMap.put(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_NAME, "1");
        return Collections.unmodifiableMap(hashMap);
    }

    private int z() {
        int i11 = 0;
        for (a0 a0Var : this.f26712s) {
            i11 += a0Var.G();
        }
        return i11;
    }

    g9.e0 B() {
        return Q(new d(0, true));
    }

    boolean D(int i11) {
        return !X() && this.f26712s[i11].K(this.K);
    }

    void K() {
        this.f26704k.j(this.f26697d.a(this.B));
    }

    void L(int i11) {
        this.f26712s[i11].N();
        K();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void j(a aVar, long j11, long j12, boolean z10) {
        i0 i0Var = aVar.f26722c;
        t9.h hVar = new t9.h(aVar.f26720a, aVar.f26730k, i0Var.h(), i0Var.i(), j11, j12, i0Var.f());
        this.f26697d.b(aVar.f26720a);
        this.f26698e.r(hVar, 1, -1, null, 0, null, aVar.f26729j, this.f26719z);
        if (z10) {
            return;
        }
        for (a0 a0Var : this.f26712s) {
            a0Var.V();
        }
        if (this.E > 0) {
            ((n.a) com.google.android.exoplayer2.util.a.e(this.f26710q)).g(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void l(a aVar, long j11, long j12) {
        g9.b0 b0Var;
        if (this.f26719z == C.TIME_UNSET && (b0Var = this.f26718y) != null) {
            boolean isSeekable = b0Var.isSeekable();
            long A = A(true);
            long j13 = A == Long.MIN_VALUE ? 0L : A + 10000;
            this.f26719z = j13;
            this.f26700g.p(j13, isSeekable, this.A);
        }
        i0 i0Var = aVar.f26722c;
        t9.h hVar = new t9.h(aVar.f26720a, aVar.f26730k, i0Var.h(), i0Var.i(), j11, j12, i0Var.f());
        this.f26697d.b(aVar.f26720a);
        this.f26698e.u(hVar, 1, -1, null, 0, null, aVar.f26729j, this.f26719z);
        this.K = true;
        ((n.a) com.google.android.exoplayer2.util.a.e(this.f26710q)).g(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public Loader.c n(a aVar, long j11, long j12, IOException iOException, int i11) {
        Loader.c g11;
        i0 i0Var = aVar.f26722c;
        t9.h hVar = new t9.h(aVar.f26720a, aVar.f26730k, i0Var.h(), i0Var.i(), j11, j12, i0Var.f());
        long c11 = this.f26697d.c(new z.c(hVar, new t9.i(1, -1, null, 0, null, p0.e1(aVar.f26729j), p0.e1(this.f26719z)), iOException, i11));
        if (c11 == C.TIME_UNSET) {
            g11 = Loader.f27301g;
        } else {
            int z10 = z();
            g11 = x(aVar, z10) ? Loader.g(z10 > this.J, c11) : Loader.f27300f;
        }
        boolean c12 = g11.c();
        this.f26698e.w(hVar, 1, -1, null, 0, null, aVar.f26729j, this.f26719z, iOException, !c12);
        if (!c12) {
            this.f26697d.b(aVar.f26720a);
        }
        return g11;
    }

    int R(int i11, p1 p1Var, DecoderInputBuffer decoderInputBuffer, int i12) {
        if (X()) {
            return -3;
        }
        I(i11);
        int S = this.f26712s[i11].S(p1Var, decoderInputBuffer, i12, this.K);
        if (S == -3) {
            J(i11);
        }
        return S;
    }

    public void S() {
        if (this.f26715v) {
            for (a0 a0Var : this.f26712s) {
                a0Var.R();
            }
        }
        this.f26704k.l(this);
        this.f26709p.removeCallbacksAndMessages(null);
        this.f26710q = null;
        this.L = true;
    }

    int V(int i11, long j11) {
        if (X()) {
            return 0;
        }
        I(i11);
        a0 a0Var = this.f26712s[i11];
        int E = a0Var.E(j11, this.K);
        a0Var.e0(E);
        if (E == 0) {
            J(i11);
        }
        return E;
    }

    @Override // com.google.android.exoplayer2.source.n
    public long a(long j11, c3 c3Var) {
        w();
        if (!this.f26718y.isSeekable()) {
            return 0L;
        }
        b0.a seekPoints = this.f26718y.getSeekPoints(j11);
        return c3Var.a(j11, seekPoints.f63493a.f63498a, seekPoints.f63494b.f63498a);
    }

    @Override // com.google.android.exoplayer2.source.n
    public long b(com.google.android.exoplayer2.trackselection.h[] hVarArr, boolean[] zArr, t9.s[] sVarArr, boolean[] zArr2, long j11) {
        com.google.android.exoplayer2.trackselection.h hVar;
        w();
        e eVar = this.f26717x;
        t9.x xVar = eVar.f26738a;
        boolean[] zArr3 = eVar.f26740c;
        int i11 = this.E;
        int i12 = 0;
        for (int i13 = 0; i13 < hVarArr.length; i13++) {
            t9.s sVar = sVarArr[i13];
            if (sVar != null && (hVarArr[i13] == null || !zArr[i13])) {
                int i14 = ((c) sVar).f26734a;
                com.google.android.exoplayer2.util.a.g(zArr3[i14]);
                this.E--;
                zArr3[i14] = false;
                sVarArr[i13] = null;
            }
        }
        boolean z10 = !this.C ? j11 == 0 : i11 != 0;
        for (int i15 = 0; i15 < hVarArr.length; i15++) {
            if (sVarArr[i15] == null && (hVar = hVarArr[i15]) != null) {
                com.google.android.exoplayer2.util.a.g(hVar.length() == 1);
                com.google.android.exoplayer2.util.a.g(hVar.getIndexInTrackGroup(0) == 0);
                int c11 = xVar.c(hVar.getTrackGroup());
                com.google.android.exoplayer2.util.a.g(!zArr3[c11]);
                this.E++;
                zArr3[c11] = true;
                sVarArr[i15] = new c(c11);
                zArr2[i15] = true;
                if (!z10) {
                    a0 a0Var = this.f26712s[c11];
                    z10 = (a0Var.Z(j11, true) || a0Var.C() == 0) ? false : true;
                }
            }
        }
        if (this.E == 0) {
            this.I = false;
            this.D = false;
            if (this.f26704k.i()) {
                a0[] a0VarArr = this.f26712s;
                int length = a0VarArr.length;
                while (i12 < length) {
                    a0VarArr[i12].r();
                    i12++;
                }
                this.f26704k.e();
            } else {
                a0[] a0VarArr2 = this.f26712s;
                int length2 = a0VarArr2.length;
                while (i12 < length2) {
                    a0VarArr2[i12].V();
                    i12++;
                }
            }
        } else if (z10) {
            j11 = seekToUs(j11);
            while (i12 < sVarArr.length) {
                if (sVarArr[i12] != null) {
                    zArr2[i12] = true;
                }
                i12++;
            }
        }
        this.C = true;
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.a0.d
    public void c(o1 o1Var) {
        this.f26709p.post(this.f26707n);
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public boolean continueLoading(long j11) {
        if (this.K || this.f26704k.h() || this.I) {
            return false;
        }
        if (this.f26715v && this.E == 0) {
            return false;
        }
        boolean f11 = this.f26706m.f();
        if (this.f26704k.i()) {
            return f11;
        }
        W();
        return true;
    }

    @Override // g9.n
    public void d(final g9.b0 b0Var) {
        this.f26709p.post(new Runnable() { // from class: com.google.android.exoplayer2.source.v
            @Override // java.lang.Runnable
            public final void run() {
                w.this.G(b0Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.n
    public void discardBuffer(long j11, boolean z10) {
        w();
        if (C()) {
            return;
        }
        boolean[] zArr = this.f26717x.f26740c;
        int length = this.f26712s.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.f26712s[i11].q(j11, z10, zArr[i11]);
        }
    }

    @Override // com.google.android.exoplayer2.source.n
    public void e(n.a aVar, long j11) {
        this.f26710q = aVar;
        this.f26706m.f();
        W();
    }

    @Override // g9.n
    public void endTracks() {
        this.f26714u = true;
        this.f26709p.post(this.f26707n);
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public long getBufferedPositionUs() {
        long j11;
        w();
        if (this.K || this.E == 0) {
            return Long.MIN_VALUE;
        }
        if (C()) {
            return this.H;
        }
        if (this.f26716w) {
            int length = this.f26712s.length;
            j11 = Long.MAX_VALUE;
            for (int i11 = 0; i11 < length; i11++) {
                e eVar = this.f26717x;
                if (eVar.f26739b[i11] && eVar.f26740c[i11] && !this.f26712s[i11].J()) {
                    j11 = Math.min(j11, this.f26712s[i11].z());
                }
            }
        } else {
            j11 = Long.MAX_VALUE;
        }
        if (j11 == Long.MAX_VALUE) {
            j11 = A(false);
        }
        return j11 == Long.MIN_VALUE ? this.G : j11;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public long getNextLoadPositionUs() {
        return getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.n
    public t9.x getTrackGroups() {
        w();
        return this.f26717x.f26738a;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public boolean isLoading() {
        return this.f26704k.i() && this.f26706m.e();
    }

    @Override // com.google.android.exoplayer2.source.n
    public void maybeThrowPrepareError() {
        K();
        if (this.K && !this.f26715v) {
            throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void onLoaderReleased() {
        for (a0 a0Var : this.f26712s) {
            a0Var.T();
        }
        this.f26705l.release();
    }

    @Override // com.google.android.exoplayer2.source.n
    public long readDiscontinuity() {
        if (!this.D) {
            return C.TIME_UNSET;
        }
        if (!this.K && z() <= this.J) {
            return C.TIME_UNSET;
        }
        this.D = false;
        return this.G;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public void reevaluateBuffer(long j11) {
    }

    @Override // com.google.android.exoplayer2.source.n
    public long seekToUs(long j11) {
        w();
        boolean[] zArr = this.f26717x.f26739b;
        if (!this.f26718y.isSeekable()) {
            j11 = 0;
        }
        int i11 = 0;
        this.D = false;
        this.G = j11;
        if (C()) {
            this.H = j11;
            return j11;
        }
        if (this.B != 7 && T(zArr, j11)) {
            return j11;
        }
        this.I = false;
        this.H = j11;
        this.K = false;
        if (this.f26704k.i()) {
            a0[] a0VarArr = this.f26712s;
            int length = a0VarArr.length;
            while (i11 < length) {
                a0VarArr[i11].r();
                i11++;
            }
            this.f26704k.e();
        } else {
            this.f26704k.f();
            a0[] a0VarArr2 = this.f26712s;
            int length2 = a0VarArr2.length;
            while (i11 < length2) {
                a0VarArr2[i11].V();
                i11++;
            }
        }
        return j11;
    }

    @Override // g9.n
    public g9.e0 track(int i11, int i12) {
        return Q(new d(i11, false));
    }
}
