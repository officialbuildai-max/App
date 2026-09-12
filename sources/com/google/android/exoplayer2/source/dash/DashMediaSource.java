package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.j;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.drm.x;
import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.c;
import com.google.android.exoplayer2.source.dash.e;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.v;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.g0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.v1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import t9.i;

/* loaded from: classes3.dex */
public final class DashMediaSource extends com.google.android.exoplayer2.source.a {
    private Loader A;
    private k0 B;
    private IOException C;
    private Handler D;
    private v1.g E;
    private Uri F;
    private Uri G;
    private x9.c H;
    private boolean I;
    private long J;
    private long K;
    private long L;
    private int M;
    private long N;
    private int O;

    /* renamed from: h, reason: collision with root package name */
    private final v1 f25827h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f25828i;

    /* renamed from: j, reason: collision with root package name */
    private final k.a f25829j;

    /* renamed from: k, reason: collision with root package name */
    private final a.InterfaceC0370a f25830k;

    /* renamed from: l, reason: collision with root package name */
    private final t9.d f25831l;

    /* renamed from: m, reason: collision with root package name */
    private final u f25832m;

    /* renamed from: n, reason: collision with root package name */
    private final z f25833n;

    /* renamed from: o, reason: collision with root package name */
    private final w9.b f25834o;

    /* renamed from: p, reason: collision with root package name */
    private final long f25835p;

    /* renamed from: q, reason: collision with root package name */
    private final p.a f25836q;

    /* renamed from: r, reason: collision with root package name */
    private final b0.a f25837r;

    /* renamed from: s, reason: collision with root package name */
    private final e f25838s;

    /* renamed from: t, reason: collision with root package name */
    private final Object f25839t;

    /* renamed from: u, reason: collision with root package name */
    private final SparseArray f25840u;

    /* renamed from: v, reason: collision with root package name */
    private final Runnable f25841v;

    /* renamed from: w, reason: collision with root package name */
    private final Runnable f25842w;

    /* renamed from: x, reason: collision with root package name */
    private final e.b f25843x;

    /* renamed from: y, reason: collision with root package name */
    private final a0 f25844y;

    /* renamed from: z, reason: collision with root package name */
    private k f25845z;

    /* loaded from: classes3.dex */
    public static final class Factory implements o.a {

        /* renamed from: a, reason: collision with root package name */
        private final a.InterfaceC0370a f25846a;

        /* renamed from: b, reason: collision with root package name */
        private final k.a f25847b;

        /* renamed from: c, reason: collision with root package name */
        private x f25848c;

        /* renamed from: d, reason: collision with root package name */
        private t9.d f25849d;

        /* renamed from: e, reason: collision with root package name */
        private z f25850e;

        /* renamed from: f, reason: collision with root package name */
        private long f25851f;

        /* renamed from: g, reason: collision with root package name */
        private b0.a f25852g;

        public Factory(a.InterfaceC0370a interfaceC0370a, k.a aVar) {
            this.f25846a = (a.InterfaceC0370a) com.google.android.exoplayer2.util.a.e(interfaceC0370a);
            this.f25847b = aVar;
            this.f25848c = new j();
            this.f25850e = new v();
            this.f25851f = 30000L;
            this.f25849d = new t9.e();
        }

        public Factory(k.a aVar) {
            this(new c.a(aVar), aVar);
        }

        @Override // com.google.android.exoplayer2.source.o.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public DashMediaSource a(v1 v1Var) {
            com.google.android.exoplayer2.util.a.e(v1Var.f27763b);
            b0.a aVar = this.f25852g;
            if (aVar == null) {
                aVar = new x9.d();
            }
            List list = v1Var.f27763b.f27829d;
            return new DashMediaSource(v1Var, null, this.f25847b, !list.isEmpty() ? new com.google.android.exoplayer2.offline.d(aVar, list) : aVar, this.f25846a, this.f25849d, this.f25848c.a(v1Var), this.f25850e, this.f25851f, null);
        }

        @Override // com.google.android.exoplayer2.source.o.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Factory b(x xVar) {
            if (xVar == null) {
                xVar = new j();
            }
            this.f25848c = xVar;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.o.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Factory c(z zVar) {
            if (zVar == null) {
                zVar = new v();
            }
            this.f25850e = zVar;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements g0.b {
        a() {
        }

        @Override // com.google.android.exoplayer2.util.g0.b
        public void a(IOException iOException) {
            DashMediaSource.this.Z(iOException);
        }

        @Override // com.google.android.exoplayer2.util.g0.b
        public void onInitialized() {
            DashMediaSource.this.a0(g0.h());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b extends k3 {

        /* renamed from: c, reason: collision with root package name */
        private final long f25854c;

        /* renamed from: d, reason: collision with root package name */
        private final long f25855d;

        /* renamed from: e, reason: collision with root package name */
        private final long f25856e;

        /* renamed from: f, reason: collision with root package name */
        private final int f25857f;

        /* renamed from: g, reason: collision with root package name */
        private final long f25858g;

        /* renamed from: h, reason: collision with root package name */
        private final long f25859h;

        /* renamed from: i, reason: collision with root package name */
        private final long f25860i;

        /* renamed from: j, reason: collision with root package name */
        private final x9.c f25861j;

        /* renamed from: k, reason: collision with root package name */
        private final v1 f25862k;

        /* renamed from: l, reason: collision with root package name */
        private final v1.g f25863l;

        public b(long j11, long j12, long j13, int i11, long j14, long j15, long j16, x9.c cVar, v1 v1Var, v1.g gVar) {
            com.google.android.exoplayer2.util.a.g(cVar.f78187d == (gVar != null));
            this.f25854c = j11;
            this.f25855d = j12;
            this.f25856e = j13;
            this.f25857f = i11;
            this.f25858g = j14;
            this.f25859h = j15;
            this.f25860i = j16;
            this.f25861j = cVar;
            this.f25862k = v1Var;
            this.f25863l = gVar;
        }

        private long y(long j11) {
            w9.e k11;
            long j12 = this.f25860i;
            if (!z(this.f25861j)) {
                return j12;
            }
            if (j11 > 0) {
                j12 += j11;
                if (j12 > this.f25859h) {
                    return C.TIME_UNSET;
                }
            }
            long j13 = this.f25858g + j12;
            long f11 = this.f25861j.f(0);
            int i11 = 0;
            while (i11 < this.f25861j.d() - 1 && j13 >= f11) {
                j13 -= f11;
                i11++;
                f11 = this.f25861j.f(i11);
            }
            x9.g c11 = this.f25861j.c(i11);
            int a11 = c11.a(2);
            return (a11 == -1 || (k11 = ((x9.j) ((x9.a) c11.f78221c.get(a11)).f78176c.get(0)).k()) == null || k11.f(f11) == 0) ? j12 : (j12 + k11.getTimeUs(k11.e(j13, f11))) - j13;
        }

        private static boolean z(x9.c cVar) {
            return cVar.f78187d && cVar.f78188e != C.TIME_UNSET && cVar.f78185b == C.TIME_UNSET;
        }

        @Override // com.google.android.exoplayer2.k3
        public int f(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue() - this.f25857f) >= 0 && intValue < m()) {
                return intValue;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.k3
        public k3.b k(int i11, k3.b bVar, boolean z10) {
            com.google.android.exoplayer2.util.a.c(i11, 0, m());
            return bVar.v(z10 ? this.f25861j.c(i11).f78219a : null, z10 ? Integer.valueOf(this.f25857f + i11) : null, 0, this.f25861j.f(i11), p0.B0(this.f25861j.c(i11).f78220b - this.f25861j.c(0).f78220b) - this.f25858g);
        }

        @Override // com.google.android.exoplayer2.k3
        public int m() {
            return this.f25861j.d();
        }

        @Override // com.google.android.exoplayer2.k3
        public Object q(int i11) {
            com.google.android.exoplayer2.util.a.c(i11, 0, m());
            return Integer.valueOf(this.f25857f + i11);
        }

        @Override // com.google.android.exoplayer2.k3
        public k3.d s(int i11, k3.d dVar, long j11) {
            com.google.android.exoplayer2.util.a.c(i11, 0, 1);
            long y10 = y(j11);
            Object obj = k3.d.f25219r;
            v1 v1Var = this.f25862k;
            x9.c cVar = this.f25861j;
            return dVar.k(obj, v1Var, cVar, this.f25854c, this.f25855d, this.f25856e, true, z(cVar), this.f25863l, y10, this.f25859h, 0, m() - 1, this.f25858g);
        }

        @Override // com.google.android.exoplayer2.k3
        public int t() {
            return 1;
        }
    }

    /* loaded from: classes3.dex */
    private final class c implements e.b {
        private c() {
        }

        /* synthetic */ c(DashMediaSource dashMediaSource, a aVar) {
            this();
        }

        @Override // com.google.android.exoplayer2.source.dash.e.b
        public void a(long j11) {
            DashMediaSource.this.S(j11);
        }

        @Override // com.google.android.exoplayer2.source.dash.e.b
        public void b() {
            DashMediaSource.this.T();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class d implements b0.a {

        /* renamed from: a, reason: collision with root package name */
        private static final Pattern f25865a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        d() {
        }

        @Override // com.google.android.exoplayer2.upstream.b0.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long parse(Uri uri, InputStream inputStream) {
            String readLine = new BufferedReader(new InputStreamReader(inputStream, com.google.common.base.c.f30282c)).readLine();
            try {
                Matcher matcher = f25865a.matcher(readLine);
                if (!matcher.matches()) {
                    String valueOf = String.valueOf(readLine);
                    throw ParserException.createForMalformedManifest(valueOf.length() != 0 ? "Couldn't parse timestamp: ".concat(valueOf) : new String("Couldn't parse timestamp: "), null);
                }
                String group = matcher.group(1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                long time = simpleDateFormat.parse(group).getTime();
                if (!"Z".equals(matcher.group(2))) {
                    long j11 = "+".equals(matcher.group(4)) ? 1L : -1L;
                    long parseLong = Long.parseLong(matcher.group(5));
                    String group2 = matcher.group(7);
                    time -= j11 * (((parseLong * 60) + (TextUtils.isEmpty(group2) ? 0L : Long.parseLong(group2))) * 60000);
                }
                return Long.valueOf(time);
            } catch (ParseException e11) {
                throw ParserException.createForMalformedManifest(null, e11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class e implements Loader.b {
        private e() {
        }

        /* synthetic */ e(DashMediaSource dashMediaSource, a aVar) {
            this();
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void j(b0 b0Var, long j11, long j12, boolean z10) {
            DashMediaSource.this.U(b0Var, j11, j12);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void l(b0 b0Var, long j11, long j12) {
            DashMediaSource.this.V(b0Var, j11, j12);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Loader.c n(b0 b0Var, long j11, long j12, IOException iOException, int i11) {
            return DashMediaSource.this.W(b0Var, j11, j12, iOException, i11);
        }
    }

    /* loaded from: classes3.dex */
    final class f implements a0 {
        f() {
        }

        private void a() {
            if (DashMediaSource.this.C != null) {
                throw DashMediaSource.this.C;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.a0
        public void maybeThrowError() {
            DashMediaSource.this.A.maybeThrowError();
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class g implements Loader.b {
        private g() {
        }

        /* synthetic */ g(DashMediaSource dashMediaSource, a aVar) {
            this();
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void j(b0 b0Var, long j11, long j12, boolean z10) {
            DashMediaSource.this.U(b0Var, j11, j12);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void l(b0 b0Var, long j11, long j12) {
            DashMediaSource.this.X(b0Var, j11, j12);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Loader.c n(b0 b0Var, long j11, long j12, IOException iOException, int i11) {
            return DashMediaSource.this.Y(b0Var, j11, j12, iOException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class h implements b0.a {
        private h() {
        }

        /* synthetic */ h(a aVar) {
            this();
        }

        @Override // com.google.android.exoplayer2.upstream.b0.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long parse(Uri uri, InputStream inputStream) {
            return Long.valueOf(p0.I0(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    static {
        m1.a("goog.exo.dash");
    }

    private DashMediaSource(v1 v1Var, x9.c cVar, k.a aVar, b0.a aVar2, a.InterfaceC0370a interfaceC0370a, t9.d dVar, u uVar, z zVar, long j11) {
        this.f25827h = v1Var;
        this.E = v1Var.f27765d;
        this.F = ((v1.h) com.google.android.exoplayer2.util.a.e(v1Var.f27763b)).f27826a;
        this.G = v1Var.f27763b.f27826a;
        this.H = cVar;
        this.f25829j = aVar;
        this.f25837r = aVar2;
        this.f25830k = interfaceC0370a;
        this.f25832m = uVar;
        this.f25833n = zVar;
        this.f25835p = j11;
        this.f25831l = dVar;
        this.f25834o = new w9.b();
        boolean z10 = cVar != null;
        this.f25828i = z10;
        a aVar3 = null;
        this.f25836q = v(null);
        this.f25839t = new Object();
        this.f25840u = new SparseArray();
        this.f25843x = new c(this, aVar3);
        this.N = C.TIME_UNSET;
        this.L = C.TIME_UNSET;
        if (!z10) {
            this.f25838s = new e(this, aVar3);
            this.f25844y = new f();
            this.f25841v = new Runnable() { // from class: w9.c
                @Override // java.lang.Runnable
                public final void run() {
                    DashMediaSource.this.h0();
                }
            };
            this.f25842w = new Runnable() { // from class: w9.d
                @Override // java.lang.Runnable
                public final void run() {
                    DashMediaSource.this.Q();
                }
            };
            return;
        }
        com.google.android.exoplayer2.util.a.g(true ^ cVar.f78187d);
        this.f25838s = null;
        this.f25841v = null;
        this.f25842w = null;
        this.f25844y = new a0.a();
    }

    /* synthetic */ DashMediaSource(v1 v1Var, x9.c cVar, k.a aVar, b0.a aVar2, a.InterfaceC0370a interfaceC0370a, t9.d dVar, u uVar, z zVar, long j11, a aVar3) {
        this(v1Var, cVar, aVar, aVar2, interfaceC0370a, dVar, uVar, zVar, j11);
    }

    private static long K(x9.g gVar, long j11, long j12) {
        long B0 = p0.B0(gVar.f78220b);
        boolean O = O(gVar);
        long j13 = Long.MAX_VALUE;
        for (int i11 = 0; i11 < gVar.f78221c.size(); i11++) {
            x9.a aVar = (x9.a) gVar.f78221c.get(i11);
            List list = aVar.f78176c;
            if ((!O || aVar.f78175b != 3) && !list.isEmpty()) {
                w9.e k11 = ((x9.j) list.get(0)).k();
                if (k11 == null) {
                    return B0 + j11;
                }
                long i12 = k11.i(j11, j12);
                if (i12 == 0) {
                    return B0;
                }
                long b11 = (k11.b(j11, j12) + i12) - 1;
                j13 = Math.min(j13, k11.a(b11, j11) + k11.getTimeUs(b11) + B0);
            }
        }
        return j13;
    }

    private static long L(x9.g gVar, long j11, long j12) {
        long B0 = p0.B0(gVar.f78220b);
        boolean O = O(gVar);
        long j13 = B0;
        for (int i11 = 0; i11 < gVar.f78221c.size(); i11++) {
            x9.a aVar = (x9.a) gVar.f78221c.get(i11);
            List list = aVar.f78176c;
            if ((!O || aVar.f78175b != 3) && !list.isEmpty()) {
                w9.e k11 = ((x9.j) list.get(0)).k();
                if (k11 == null || k11.i(j11, j12) == 0) {
                    return B0;
                }
                j13 = Math.max(j13, k11.getTimeUs(k11.b(j11, j12)) + B0);
            }
        }
        return j13;
    }

    private static long M(x9.c cVar, long j11) {
        w9.e k11;
        int d11 = cVar.d() - 1;
        x9.g c11 = cVar.c(d11);
        long B0 = p0.B0(c11.f78220b);
        long f11 = cVar.f(d11);
        long B02 = p0.B0(j11);
        long B03 = p0.B0(cVar.f78184a);
        long B04 = p0.B0(5000L);
        for (int i11 = 0; i11 < c11.f78221c.size(); i11++) {
            List list = ((x9.a) c11.f78221c.get(i11)).f78176c;
            if (!list.isEmpty() && (k11 = ((x9.j) list.get(0)).k()) != null) {
                long c12 = ((B03 + B0) + k11.c(f11, B02)) - B02;
                if (c12 < B04 - 100000 || (c12 > B04 && c12 < B04 + 100000)) {
                    B04 = c12;
                }
            }
        }
        return com.google.common.math.f.c(B04, 1000L, RoundingMode.CEILING);
    }

    private long N() {
        return Math.min((this.M - 1) * 1000, 5000);
    }

    private static boolean O(x9.g gVar) {
        for (int i11 = 0; i11 < gVar.f78221c.size(); i11++) {
            int i12 = ((x9.a) gVar.f78221c.get(i11)).f78175b;
            if (i12 == 1 || i12 == 2) {
                return true;
            }
        }
        return false;
    }

    private static boolean P(x9.g gVar) {
        for (int i11 = 0; i11 < gVar.f78221c.size(); i11++) {
            w9.e k11 = ((x9.j) ((x9.a) gVar.f78221c.get(i11)).f78176c.get(0)).k();
            if (k11 == null || k11.g()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q() {
        b0(false);
    }

    private void R() {
        g0.j(this.A, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(IOException iOException) {
        s.d("DashMediaSource", "Failed to resolve time offset.", iOException);
        b0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(long j11) {
        this.L = j11;
        b0(true);
    }

    private void b0(boolean z10) {
        x9.g gVar;
        long j11;
        long j12;
        for (int i11 = 0; i11 < this.f25840u.size(); i11++) {
            int keyAt = this.f25840u.keyAt(i11);
            if (keyAt >= this.O) {
                ((com.google.android.exoplayer2.source.dash.b) this.f25840u.valueAt(i11)).B(this.H, keyAt - this.O);
            }
        }
        x9.g c11 = this.H.c(0);
        int d11 = this.H.d() - 1;
        x9.g c12 = this.H.c(d11);
        long f11 = this.H.f(d11);
        long B0 = p0.B0(p0.b0(this.L));
        long L = L(c11, this.H.f(0), B0);
        long K = K(c12, f11, B0);
        boolean z11 = this.H.f78187d && !P(c12);
        if (z11) {
            long j13 = this.H.f78189f;
            if (j13 != C.TIME_UNSET) {
                L = Math.max(L, K - p0.B0(j13));
            }
        }
        long j14 = K - L;
        x9.c cVar = this.H;
        if (cVar.f78187d) {
            com.google.android.exoplayer2.util.a.g(cVar.f78184a != C.TIME_UNSET);
            long B02 = (B0 - p0.B0(this.H.f78184a)) - L;
            i0(B02, j14);
            long e12 = this.H.f78184a + p0.e1(L);
            long B03 = B02 - p0.B0(this.E.f27816a);
            long min = Math.min(5000000L, j14 / 2);
            j11 = e12;
            j12 = B03 < min ? min : B03;
            gVar = c11;
        } else {
            gVar = c11;
            j11 = C.TIME_UNSET;
            j12 = 0;
        }
        long B04 = L - p0.B0(gVar.f78220b);
        x9.c cVar2 = this.H;
        C(new b(cVar2.f78184a, j11, this.L, this.O, B04, j14, j12, cVar2, this.f25827h, cVar2.f78187d ? this.E : null));
        if (this.f25828i) {
            return;
        }
        this.D.removeCallbacks(this.f25842w);
        if (z11) {
            this.D.postDelayed(this.f25842w, M(this.H, p0.b0(this.L)));
        }
        if (this.I) {
            h0();
            return;
        }
        if (z10) {
            x9.c cVar3 = this.H;
            if (cVar3.f78187d) {
                long j15 = cVar3.f78188e;
                if (j15 != C.TIME_UNSET) {
                    if (j15 == 0) {
                        j15 = 5000;
                    }
                    f0(Math.max(0L, (this.J + j15) - SystemClock.elapsedRealtime()));
                }
            }
        }
    }

    private void c0(x9.o oVar) {
        String str = oVar.f78274a;
        if (p0.c(str, "urn:mpeg:dash:utc:direct:2014") || p0.c(str, "urn:mpeg:dash:utc:direct:2012")) {
            d0(oVar);
            return;
        }
        if (p0.c(str, "urn:mpeg:dash:utc:http-iso:2014") || p0.c(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            e0(oVar, new d());
            return;
        }
        if (p0.c(str, "urn:mpeg:dash:utc:http-xsdate:2014") || p0.c(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            e0(oVar, new h(null));
        } else if (p0.c(str, "urn:mpeg:dash:utc:ntp:2014") || p0.c(str, "urn:mpeg:dash:utc:ntp:2012")) {
            R();
        } else {
            Z(new IOException("Unsupported UTC timing scheme"));
        }
    }

    private void d0(x9.o oVar) {
        try {
            a0(p0.I0(oVar.f78275b) - this.K);
        } catch (ParserException e11) {
            Z(e11);
        }
    }

    private void e0(x9.o oVar, b0.a aVar) {
        g0(new b0(this.f25845z, Uri.parse(oVar.f78275b), 5, aVar), new g(this, null), 1);
    }

    private void f0(long j11) {
        this.D.postDelayed(this.f25841v, j11);
    }

    private void g0(b0 b0Var, Loader.b bVar, int i11) {
        this.f25836q.z(new t9.h(b0Var.f27325a, b0Var.f27326b, this.A.m(b0Var, bVar, i11)), b0Var.f27327c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        Uri uri;
        this.D.removeCallbacks(this.f25841v);
        if (this.A.h()) {
            return;
        }
        if (this.A.i()) {
            this.I = true;
            return;
        }
        synchronized (this.f25839t) {
            uri = this.F;
        }
        this.I = false;
        g0(new b0(this.f25845z, uri, 4, this.f25837r), this.f25838s, this.f25833n.a(4));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void i0(long r18, long r20) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.i0(long, long):void");
    }

    @Override // com.google.android.exoplayer2.source.a
    protected void B(k0 k0Var) {
        this.B = k0Var;
        this.f25832m.prepare();
        this.f25832m.b(Looper.myLooper(), z());
        if (this.f25828i) {
            b0(false);
            return;
        }
        this.f25845z = this.f25829j.createDataSource();
        this.A = new Loader("DashMediaSource");
        this.D = p0.w();
        h0();
    }

    @Override // com.google.android.exoplayer2.source.a
    protected void D() {
        this.I = false;
        this.f25845z = null;
        Loader loader = this.A;
        if (loader != null) {
            loader.k();
            this.A = null;
        }
        this.J = 0L;
        this.K = 0L;
        this.H = this.f25828i ? this.H : null;
        this.F = this.G;
        this.C = null;
        Handler handler = this.D;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.D = null;
        }
        this.L = C.TIME_UNSET;
        this.M = 0;
        this.N = C.TIME_UNSET;
        this.O = 0;
        this.f25840u.clear();
        this.f25834o.i();
        this.f25832m.release();
    }

    void S(long j11) {
        long j12 = this.N;
        if (j12 == C.TIME_UNSET || j12 < j11) {
            this.N = j11;
        }
    }

    void T() {
        this.D.removeCallbacks(this.f25842w);
        h0();
    }

    void U(b0 b0Var, long j11, long j12) {
        t9.h hVar = new t9.h(b0Var.f27325a, b0Var.f27326b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
        this.f25833n.b(b0Var.f27325a);
        this.f25836q.q(hVar, b0Var.f27327c);
    }

    void V(b0 b0Var, long j11, long j12) {
        t9.h hVar = new t9.h(b0Var.f27325a, b0Var.f27326b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
        this.f25833n.b(b0Var.f27325a);
        this.f25836q.t(hVar, b0Var.f27327c);
        x9.c cVar = (x9.c) b0Var.c();
        x9.c cVar2 = this.H;
        int d11 = cVar2 == null ? 0 : cVar2.d();
        long j13 = cVar.c(0).f78220b;
        int i11 = 0;
        while (i11 < d11 && this.H.c(i11).f78220b < j13) {
            i11++;
        }
        if (cVar.f78187d) {
            if (d11 - i11 > cVar.d()) {
                s.i("DashMediaSource", "Loaded out of sync manifest");
            } else {
                long j14 = this.N;
                if (j14 != C.TIME_UNSET) {
                    long j15 = cVar.f78191h;
                    if (1000 * j15 <= j14) {
                        StringBuilder sb2 = new StringBuilder(73);
                        sb2.append("Loaded stale dynamic manifest: ");
                        sb2.append(j15);
                        sb2.append(", ");
                        sb2.append(j14);
                        s.i("DashMediaSource", sb2.toString());
                    }
                }
                this.M = 0;
            }
            int i12 = this.M;
            this.M = i12 + 1;
            if (i12 < this.f25833n.a(b0Var.f27327c)) {
                f0(N());
                return;
            } else {
                this.C = new DashManifestStaleException();
                return;
            }
        }
        this.H = cVar;
        this.I = cVar.f78187d & this.I;
        this.J = j11 - j12;
        this.K = j11;
        synchronized (this.f25839t) {
            try {
                if (b0Var.f27326b.f27491a == this.F) {
                    Uri uri = this.H.f78194k;
                    if (uri == null) {
                        uri = b0Var.d();
                    }
                    this.F = uri;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (d11 != 0) {
            this.O += i11;
            b0(true);
            return;
        }
        x9.c cVar3 = this.H;
        if (!cVar3.f78187d) {
            b0(true);
            return;
        }
        x9.o oVar = cVar3.f78192i;
        if (oVar != null) {
            c0(oVar);
        } else {
            R();
        }
    }

    Loader.c W(b0 b0Var, long j11, long j12, IOException iOException, int i11) {
        t9.h hVar = new t9.h(b0Var.f27325a, b0Var.f27326b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
        long c11 = this.f25833n.c(new z.c(hVar, new i(b0Var.f27327c), iOException, i11));
        Loader.c g11 = c11 == C.TIME_UNSET ? Loader.f27301g : Loader.g(false, c11);
        boolean c12 = g11.c();
        this.f25836q.x(hVar, b0Var.f27327c, iOException, !c12);
        if (!c12) {
            this.f25833n.b(b0Var.f27325a);
        }
        return g11;
    }

    void X(b0 b0Var, long j11, long j12) {
        t9.h hVar = new t9.h(b0Var.f27325a, b0Var.f27326b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
        this.f25833n.b(b0Var.f27325a);
        this.f25836q.t(hVar, b0Var.f27327c);
        a0(((Long) b0Var.c()).longValue() - j11);
    }

    Loader.c Y(b0 b0Var, long j11, long j12, IOException iOException) {
        this.f25836q.x(new t9.h(b0Var.f27325a, b0Var.f27326b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a()), b0Var.f27327c, iOException, true);
        this.f25833n.b(b0Var.f27325a);
        Z(iOException);
        return Loader.f27300f;
    }

    @Override // com.google.android.exoplayer2.source.o
    public v1 a() {
        return this.f25827h;
    }

    @Override // com.google.android.exoplayer2.source.o
    public n d(o.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        int intValue = ((Integer) bVar.f76237a).intValue() - this.O;
        p.a w11 = w(bVar, this.H.c(intValue).f78220b);
        com.google.android.exoplayer2.source.dash.b bVar3 = new com.google.android.exoplayer2.source.dash.b(intValue + this.O, this.H, this.f25834o, intValue, this.f25830k, this.B, this.f25832m, t(bVar), this.f25833n, w11, this.L, this.f25844y, bVar2, this.f25831l, this.f25843x, z());
        this.f25840u.put(bVar3.f25871a, bVar3);
        return bVar3;
    }

    @Override // com.google.android.exoplayer2.source.o
    public void k(n nVar) {
        com.google.android.exoplayer2.source.dash.b bVar = (com.google.android.exoplayer2.source.dash.b) nVar;
        bVar.x();
        this.f25840u.remove(bVar.f25871a);
    }

    @Override // com.google.android.exoplayer2.source.o
    public void maybeThrowSourceInfoRefreshError() {
        this.f25844y.maybeThrowError();
    }
}
