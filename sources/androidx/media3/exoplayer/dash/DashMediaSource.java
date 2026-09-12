package androidx.media3.exoplayer.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.media3.common.ParserException;
import androidx.media3.common.e0;
import androidx.media3.common.t;
import androidx.media3.common.u;
import androidx.media3.common.util.a1;
import androidx.media3.datasource.a;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.dash.a;
import androidx.media3.exoplayer.dash.d;
import androidx.media3.exoplayer.dash.f;
import androidx.media3.exoplayer.drm.j;
import androidx.media3.exoplayer.drm.w;
import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.source.s;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.upstream.k;
import androidx.media3.exoplayer.upstream.m;
import androidx.media3.exoplayer.upstream.o;
import androidx.media3.exoplayer.upstream.p;
import androidx.media3.exoplayer.upstream.q;
import androidx.media3.exoplayer.util.d;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g2.i;
import i3.s;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import w1.h;
import w1.n;

/* loaded from: classes2.dex */
public final class DashMediaSource extends androidx.media3.exoplayer.source.a {
    private Loader A;
    private n B;
    private IOException C;
    private Handler D;
    private t.g E;
    private Uri F;
    private Uri G;
    private a2.c H;
    private boolean I;
    private long J;
    private long K;
    private long L;
    private int M;
    private long N;
    private int O;
    private t P;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f11440h;

    /* renamed from: i, reason: collision with root package name */
    private final a.InterfaceC0099a f11441i;

    /* renamed from: j, reason: collision with root package name */
    private final a.InterfaceC0103a f11442j;

    /* renamed from: k, reason: collision with root package name */
    private final g2.e f11443k;

    /* renamed from: l, reason: collision with root package name */
    private final androidx.media3.exoplayer.drm.t f11444l;

    /* renamed from: m, reason: collision with root package name */
    private final m f11445m;

    /* renamed from: n, reason: collision with root package name */
    private final z1.b f11446n;

    /* renamed from: o, reason: collision with root package name */
    private final long f11447o;

    /* renamed from: p, reason: collision with root package name */
    private final long f11448p;

    /* renamed from: q, reason: collision with root package name */
    private final s.a f11449q;

    /* renamed from: r, reason: collision with root package name */
    private final q.a f11450r;

    /* renamed from: s, reason: collision with root package name */
    private final e f11451s;

    /* renamed from: t, reason: collision with root package name */
    private final Object f11452t;

    /* renamed from: u, reason: collision with root package name */
    private final SparseArray f11453u;

    /* renamed from: v, reason: collision with root package name */
    private final Runnable f11454v;

    /* renamed from: w, reason: collision with root package name */
    private final Runnable f11455w;

    /* renamed from: x, reason: collision with root package name */
    private final f.b f11456x;

    /* renamed from: y, reason: collision with root package name */
    private final p f11457y;

    /* renamed from: z, reason: collision with root package name */
    private androidx.media3.datasource.a f11458z;

    /* loaded from: classes2.dex */
    public static final class Factory implements r.a {

        /* renamed from: a, reason: collision with root package name */
        private final a.InterfaceC0103a f11459a;

        /* renamed from: b, reason: collision with root package name */
        private final a.InterfaceC0099a f11460b;

        /* renamed from: c, reason: collision with root package name */
        private w f11461c;

        /* renamed from: d, reason: collision with root package name */
        private g2.e f11462d;

        /* renamed from: e, reason: collision with root package name */
        private m f11463e;

        /* renamed from: f, reason: collision with root package name */
        private long f11464f;

        /* renamed from: g, reason: collision with root package name */
        private long f11465g;

        /* renamed from: h, reason: collision with root package name */
        private q.a f11466h;

        public Factory(a.InterfaceC0099a interfaceC0099a) {
            this(new d.a(interfaceC0099a), interfaceC0099a);
        }

        public Factory(a.InterfaceC0103a interfaceC0103a, a.InterfaceC0099a interfaceC0099a) {
            this.f11459a = (a.InterfaceC0103a) androidx.media3.common.util.a.e(interfaceC0103a);
            this.f11460b = interfaceC0099a;
            this.f11461c = new j();
            this.f11463e = new k();
            this.f11464f = 30000L;
            this.f11465g = 5000000L;
            this.f11462d = new g2.f();
            c(true);
        }

        @Override // androidx.media3.exoplayer.source.r.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public DashMediaSource d(t tVar) {
            androidx.media3.common.util.a.e(tVar.f10293b);
            q.a aVar = this.f11466h;
            if (aVar == null) {
                aVar = new a2.d();
            }
            List list = tVar.f10293b.f10388d;
            return new DashMediaSource(tVar, null, this.f11460b, !list.isEmpty() ? new androidx.media3.exoplayer.offline.r(aVar, list) : aVar, this.f11459a, this.f11462d, null, this.f11461c.a(tVar), this.f11463e, this.f11464f, this.f11465g, null);
        }

        @Override // androidx.media3.exoplayer.source.r.a
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Factory c(boolean z10) {
            this.f11459a.c(z10);
            return this;
        }

        @Override // androidx.media3.exoplayer.source.r.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Factory b(int i11) {
            this.f11459a.b(i11);
            return this;
        }

        @Override // androidx.media3.exoplayer.source.r.a
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Factory e(w wVar) {
            this.f11461c = (w) androidx.media3.common.util.a.f(wVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // androidx.media3.exoplayer.source.r.a
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Factory f(m mVar) {
            this.f11463e = (m) androidx.media3.common.util.a.f(mVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // androidx.media3.exoplayer.source.r.a
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public Factory a(s.a aVar) {
            this.f11459a.a((s.a) androidx.media3.common.util.a.e(aVar));
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements d.b {
        a() {
        }

        @Override // androidx.media3.exoplayer.util.d.b
        public void a(IOException iOException) {
            DashMediaSource.this.Y(iOException);
        }

        @Override // androidx.media3.exoplayer.util.d.b
        public void onInitialized() {
            DashMediaSource.this.Z(androidx.media3.exoplayer.util.d.i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b extends e0 {

        /* renamed from: e, reason: collision with root package name */
        private final long f11468e;

        /* renamed from: f, reason: collision with root package name */
        private final long f11469f;

        /* renamed from: g, reason: collision with root package name */
        private final long f11470g;

        /* renamed from: h, reason: collision with root package name */
        private final int f11471h;

        /* renamed from: i, reason: collision with root package name */
        private final long f11472i;

        /* renamed from: j, reason: collision with root package name */
        private final long f11473j;

        /* renamed from: k, reason: collision with root package name */
        private final long f11474k;

        /* renamed from: l, reason: collision with root package name */
        private final a2.c f11475l;

        /* renamed from: m, reason: collision with root package name */
        private final t f11476m;

        /* renamed from: n, reason: collision with root package name */
        private final t.g f11477n;

        public b(long j11, long j12, long j13, int i11, long j14, long j15, long j16, a2.c cVar, t tVar, t.g gVar) {
            androidx.media3.common.util.a.g(cVar.f123d == (gVar != null));
            this.f11468e = j11;
            this.f11469f = j12;
            this.f11470g = j13;
            this.f11471h = i11;
            this.f11472i = j14;
            this.f11473j = j15;
            this.f11474k = j16;
            this.f11475l = cVar;
            this.f11476m = tVar;
            this.f11477n = gVar;
        }

        private long s(long j11) {
            z1.e k11;
            long j12 = this.f11474k;
            if (!t(this.f11475l)) {
                return j12;
            }
            if (j11 > 0) {
                j12 += j11;
                if (j12 > this.f11473j) {
                    return C.TIME_UNSET;
                }
            }
            long j13 = this.f11472i + j12;
            long f11 = this.f11475l.f(0);
            int i11 = 0;
            while (i11 < this.f11475l.d() - 1 && j13 >= f11) {
                j13 -= f11;
                i11++;
                f11 = this.f11475l.f(i11);
            }
            a2.g c11 = this.f11475l.c(i11);
            int a11 = c11.a(2);
            return (a11 == -1 || (k11 = ((a2.j) ((a2.a) c11.f158c.get(a11)).f112c.get(0)).k()) == null || k11.f(f11) == 0) ? j12 : (j12 + k11.getTimeUs(k11.e(j13, f11))) - j13;
        }

        private static boolean t(a2.c cVar) {
            return cVar.f123d && cVar.f124e != C.TIME_UNSET && cVar.f121b == C.TIME_UNSET;
        }

        @Override // androidx.media3.common.e0
        public int b(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue() - this.f11471h) >= 0 && intValue < i()) {
                return intValue;
            }
            return -1;
        }

        @Override // androidx.media3.common.e0
        public e0.b g(int i11, e0.b bVar, boolean z10) {
            androidx.media3.common.util.a.c(i11, 0, i());
            return bVar.t(z10 ? this.f11475l.c(i11).f156a : null, z10 ? Integer.valueOf(this.f11471h + i11) : null, 0, this.f11475l.f(i11), a1.R0(this.f11475l.c(i11).f157b - this.f11475l.c(0).f157b) - this.f11472i);
        }

        @Override // androidx.media3.common.e0
        public int i() {
            return this.f11475l.d();
        }

        @Override // androidx.media3.common.e0
        public Object m(int i11) {
            androidx.media3.common.util.a.c(i11, 0, i());
            return Integer.valueOf(this.f11471h + i11);
        }

        @Override // androidx.media3.common.e0
        public e0.c o(int i11, e0.c cVar, long j11) {
            androidx.media3.common.util.a.c(i11, 0, 1);
            long s11 = s(j11);
            Object obj = e0.c.f10023q;
            t tVar = this.f11476m;
            a2.c cVar2 = this.f11475l;
            return cVar.g(obj, tVar, cVar2, this.f11468e, this.f11469f, this.f11470g, true, t(cVar2), this.f11477n, s11, this.f11473j, 0, i() - 1, this.f11472i);
        }

        @Override // androidx.media3.common.e0
        public int p() {
            return 1;
        }
    }

    /* loaded from: classes2.dex */
    private final class c implements f.b {
        private c() {
        }

        /* synthetic */ c(DashMediaSource dashMediaSource, a aVar) {
            this();
        }

        @Override // androidx.media3.exoplayer.dash.f.b
        public void a(long j11) {
            DashMediaSource.this.Q(j11);
        }

        @Override // androidx.media3.exoplayer.dash.f.b
        public void b() {
            DashMediaSource.this.R();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class d implements q.a {

        /* renamed from: a, reason: collision with root package name */
        private static final Pattern f11479a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        d() {
        }

        @Override // androidx.media3.exoplayer.upstream.q.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long parse(Uri uri, InputStream inputStream) {
            String readLine = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).readLine();
            try {
                Matcher matcher = f11479a.matcher(readLine);
                if (!matcher.matches()) {
                    throw ParserException.createForMalformedManifest("Couldn't parse timestamp: " + readLine, null);
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
    /* loaded from: classes2.dex */
    public final class e implements Loader.b {
        private e() {
        }

        /* synthetic */ e(DashMediaSource dashMediaSource, a aVar) {
            this();
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void q(q qVar, long j11, long j12, boolean z10) {
            DashMediaSource.this.S(qVar, j11, j12);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void p(q qVar, long j11, long j12) {
            DashMediaSource.this.T(qVar, j11, j12);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Loader.c k(q qVar, long j11, long j12, IOException iOException, int i11) {
            return DashMediaSource.this.U(qVar, j11, j12, iOException, i11);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void o(q qVar, long j11, long j12, int i11) {
            DashMediaSource.this.V(qVar, j11, j12, i11);
        }
    }

    /* loaded from: classes2.dex */
    final class f implements p {
        f() {
        }

        private void a() {
            if (DashMediaSource.this.C != null) {
                throw DashMediaSource.this.C;
            }
        }

        @Override // androidx.media3.exoplayer.upstream.p
        public void maybeThrowError() {
            DashMediaSource.this.A.maybeThrowError();
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class g implements Loader.b {
        private g() {
        }

        /* synthetic */ g(DashMediaSource dashMediaSource, a aVar) {
            this();
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void q(q qVar, long j11, long j12, boolean z10) {
            DashMediaSource.this.S(qVar, j11, j12);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void p(q qVar, long j11, long j12) {
            DashMediaSource.this.W(qVar, j11, j12);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Loader.c k(q qVar, long j11, long j12, IOException iOException, int i11) {
            return DashMediaSource.this.X(qVar, j11, j12, iOException);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        public /* synthetic */ void o(Loader.d dVar, long j11, long j12, int i11) {
            o.a(this, dVar, j11, j12, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class h implements q.a {
        private h() {
        }

        /* synthetic */ h(a aVar) {
            this();
        }

        @Override // androidx.media3.exoplayer.upstream.q.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long parse(Uri uri, InputStream inputStream) {
            return Long.valueOf(a1.Z0(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    static {
        u.a("media3.exoplayer.dash");
    }

    private DashMediaSource(t tVar, a2.c cVar, a.InterfaceC0099a interfaceC0099a, q.a aVar, a.InterfaceC0103a interfaceC0103a, g2.e eVar, androidx.media3.exoplayer.upstream.f fVar, androidx.media3.exoplayer.drm.t tVar2, m mVar, long j11, long j12) {
        this.P = tVar;
        this.E = tVar.f10295d;
        this.F = ((t.h) androidx.media3.common.util.a.e(tVar.f10293b)).f10385a;
        this.G = tVar.f10293b.f10385a;
        this.H = cVar;
        this.f11441i = interfaceC0099a;
        this.f11450r = aVar;
        this.f11442j = interfaceC0103a;
        this.f11444l = tVar2;
        this.f11445m = mVar;
        this.f11447o = j11;
        this.f11448p = j12;
        this.f11443k = eVar;
        this.f11446n = new z1.b();
        boolean z10 = cVar != null;
        this.f11440h = z10;
        a aVar2 = null;
        this.f11449q = u(null);
        this.f11452t = new Object();
        this.f11453u = new SparseArray();
        this.f11456x = new c(this, aVar2);
        this.N = C.TIME_UNSET;
        this.L = C.TIME_UNSET;
        if (!z10) {
            this.f11451s = new e(this, aVar2);
            this.f11457y = new f();
            this.f11454v = new Runnable() { // from class: z1.c
                @Override // java.lang.Runnable
                public final void run() {
                    DashMediaSource.this.g0();
                }
            };
            this.f11455w = new Runnable() { // from class: z1.d
                @Override // java.lang.Runnable
                public final void run() {
                    DashMediaSource.this.O();
                }
            };
            return;
        }
        androidx.media3.common.util.a.g(true ^ cVar.f123d);
        this.f11451s = null;
        this.f11454v = null;
        this.f11455w = null;
        this.f11457y = new p.a();
    }

    /* synthetic */ DashMediaSource(t tVar, a2.c cVar, a.InterfaceC0099a interfaceC0099a, q.a aVar, a.InterfaceC0103a interfaceC0103a, g2.e eVar, androidx.media3.exoplayer.upstream.f fVar, androidx.media3.exoplayer.drm.t tVar2, m mVar, long j11, long j12, a aVar2) {
        this(tVar, cVar, interfaceC0099a, aVar, interfaceC0103a, eVar, fVar, tVar2, mVar, j11, j12);
    }

    private static long I(a2.g gVar, long j11, long j12) {
        long R0 = a1.R0(gVar.f157b);
        boolean M = M(gVar);
        long j13 = Long.MAX_VALUE;
        for (int i11 = 0; i11 < gVar.f158c.size(); i11++) {
            a2.a aVar = (a2.a) gVar.f158c.get(i11);
            List list = aVar.f112c;
            int i12 = aVar.f111b;
            boolean z10 = (i12 == 1 || i12 == 2) ? false : true;
            if ((!M || !z10) && !list.isEmpty()) {
                z1.e k11 = ((a2.j) list.get(0)).k();
                if (k11 == null) {
                    return R0 + j11;
                }
                long i13 = k11.i(j11, j12);
                if (i13 == 0) {
                    return R0;
                }
                long b11 = (k11.b(j11, j12) + i13) - 1;
                j13 = Math.min(j13, k11.a(b11, j11) + k11.getTimeUs(b11) + R0);
            }
        }
        return j13;
    }

    private static long J(a2.g gVar, long j11, long j12) {
        long R0 = a1.R0(gVar.f157b);
        boolean M = M(gVar);
        long j13 = R0;
        for (int i11 = 0; i11 < gVar.f158c.size(); i11++) {
            a2.a aVar = (a2.a) gVar.f158c.get(i11);
            List list = aVar.f112c;
            int i12 = aVar.f111b;
            boolean z10 = (i12 == 1 || i12 == 2) ? false : true;
            if ((!M || !z10) && !list.isEmpty()) {
                z1.e k11 = ((a2.j) list.get(0)).k();
                if (k11 == null || k11.i(j11, j12) == 0) {
                    return R0;
                }
                j13 = Math.max(j13, k11.getTimeUs(k11.b(j11, j12)) + R0);
            }
        }
        return j13;
    }

    private static long K(a2.c cVar, long j11) {
        z1.e k11;
        int d11 = cVar.d() - 1;
        a2.g c11 = cVar.c(d11);
        long R0 = a1.R0(c11.f157b);
        long f11 = cVar.f(d11);
        long R02 = a1.R0(j11);
        long R03 = a1.R0(cVar.f120a);
        long R04 = a1.R0(cVar.f124e);
        if (R04 == C.TIME_UNSET || R04 >= 5000000) {
            R04 = 5000000;
        }
        for (int i11 = 0; i11 < c11.f158c.size(); i11++) {
            List list = ((a2.a) c11.f158c.get(i11)).f112c;
            if (!list.isEmpty() && (k11 = ((a2.j) list.get(0)).k()) != null) {
                long c12 = ((R03 + R0) + k11.c(f11, R02)) - R02;
                if (c12 > 0 && (c12 < R04 - 100000 || (c12 > R04 && c12 < R04 + 100000))) {
                    R04 = c12;
                }
            }
        }
        return com.google.common.math.f.c(R04, 1000L, RoundingMode.CEILING);
    }

    private long L() {
        return Math.min((this.M - 1) * 1000, 5000);
    }

    private static boolean M(a2.g gVar) {
        for (int i11 = 0; i11 < gVar.f158c.size(); i11++) {
            int i12 = ((a2.a) gVar.f158c.get(i11)).f111b;
            if (i12 == 1 || i12 == 2) {
                return true;
            }
        }
        return false;
    }

    private static boolean N(a2.g gVar) {
        for (int i11 = 0; i11 < gVar.f158c.size(); i11++) {
            z1.e k11 = ((a2.j) ((a2.a) gVar.f158c.get(i11)).f112c.get(0)).k();
            if (k11 == null || k11.g()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O() {
        a0(false);
    }

    private void P() {
        androidx.media3.exoplayer.util.d.l(this.A, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(IOException iOException) {
        androidx.media3.common.util.u.d("DashMediaSource", "Failed to resolve time offset.", iOException);
        this.L = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        a0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(long j11) {
        this.L = j11;
        a0(true);
    }

    private void a0(boolean z10) {
        a2.g gVar;
        long j11;
        long j12;
        for (int i11 = 0; i11 < this.f11453u.size(); i11++) {
            int keyAt = this.f11453u.keyAt(i11);
            if (keyAt >= this.O) {
                ((androidx.media3.exoplayer.dash.c) this.f11453u.valueAt(i11)).G(this.H, keyAt - this.O);
            }
        }
        a2.g c11 = this.H.c(0);
        int d11 = this.H.d() - 1;
        a2.g c12 = this.H.c(d11);
        long f11 = this.H.f(d11);
        long R0 = a1.R0(a1.h0(this.L));
        long J = J(c11, this.H.f(0), R0);
        long I = I(c12, f11, R0);
        boolean z11 = this.H.f123d && !N(c12);
        if (z11) {
            long j13 = this.H.f125f;
            if (j13 != C.TIME_UNSET) {
                J = Math.max(J, I - a1.R0(j13));
            }
        }
        long j14 = I - J;
        a2.c cVar = this.H;
        if (cVar.f123d) {
            androidx.media3.common.util.a.g(cVar.f120a != C.TIME_UNSET);
            long R02 = (R0 - a1.R0(this.H.f120a)) - J;
            h0(R02, j14);
            long y12 = this.H.f120a + a1.y1(J);
            long R03 = R02 - a1.R0(this.E.f10367a);
            long min = Math.min(this.f11448p, j14 / 2);
            j11 = y12;
            j12 = R03 < min ? min : R03;
            gVar = c11;
        } else {
            gVar = c11;
            j11 = C.TIME_UNSET;
            j12 = 0;
        }
        long R04 = J - a1.R0(gVar.f157b);
        a2.c cVar2 = this.H;
        A(new b(cVar2.f120a, j11, this.L, this.O, R04, j14, j12, cVar2, a(), this.H.f123d ? this.E : null));
        if (this.f11440h) {
            return;
        }
        this.D.removeCallbacks(this.f11455w);
        if (z11) {
            this.D.postDelayed(this.f11455w, K(this.H, a1.h0(this.L)));
        }
        if (this.I) {
            g0();
            return;
        }
        if (z10) {
            a2.c cVar3 = this.H;
            if (cVar3.f123d) {
                long j15 = cVar3.f124e;
                if (j15 != C.TIME_UNSET) {
                    if (j15 == 0) {
                        j15 = 5000;
                    }
                    e0(Math.max(0L, (this.J + j15) - SystemClock.elapsedRealtime()));
                }
            }
        }
    }

    private void b0(a2.o oVar) {
        String str = oVar.f210a;
        if (Objects.equals(str, "urn:mpeg:dash:utc:direct:2014") || Objects.equals(str, "urn:mpeg:dash:utc:direct:2012")) {
            c0(oVar);
            return;
        }
        if (Objects.equals(str, "urn:mpeg:dash:utc:http-iso:2014") || Objects.equals(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            d0(oVar, new d());
            return;
        }
        if (Objects.equals(str, "urn:mpeg:dash:utc:http-xsdate:2014") || Objects.equals(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            d0(oVar, new h(null));
        } else if (Objects.equals(str, "urn:mpeg:dash:utc:ntp:2014") || Objects.equals(str, "urn:mpeg:dash:utc:ntp:2012")) {
            P();
        } else {
            Y(new IOException("Unsupported UTC timing scheme"));
        }
    }

    private void c0(a2.o oVar) {
        try {
            Z(a1.Z0(oVar.f211b) - this.K);
        } catch (ParserException e11) {
            Y(e11);
        }
    }

    private void d0(a2.o oVar, q.a aVar) {
        f0(new q(this.f11458z, Uri.parse(oVar.f211b), 5, aVar), new g(this, null), 1);
    }

    private void e0(long j11) {
        this.D.postDelayed(this.f11454v, j11);
    }

    private void f0(q qVar, Loader.b bVar, int i11) {
        this.A.m(qVar, bVar, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        Uri uri;
        this.D.removeCallbacks(this.f11454v);
        if (this.A.h()) {
            return;
        }
        if (this.A.i()) {
            this.I = true;
            return;
        }
        synchronized (this.f11452t) {
            uri = this.F;
        }
        this.I = false;
        f0(new q(this.f11458z, new h.b().i(uri).b(1).a(), 4, this.f11450r), this.f11451s, this.f11445m.a(4));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void h0(long r19, long r21) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.DashMediaSource.h0(long, long):void");
    }

    @Override // androidx.media3.exoplayer.source.a
    protected void B() {
        this.I = false;
        this.f11458z = null;
        Loader loader = this.A;
        if (loader != null) {
            loader.k();
            this.A = null;
        }
        this.J = 0L;
        this.K = 0L;
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
        this.f11453u.clear();
        this.f11446n.i();
        this.f11444l.release();
    }

    void Q(long j11) {
        long j12 = this.N;
        if (j12 == C.TIME_UNSET || j12 < j11) {
            this.N = j11;
        }
    }

    void R() {
        this.D.removeCallbacks(this.f11455w);
        g0();
    }

    void S(q qVar, long j11, long j12) {
        i iVar = new i(qVar.f13096a, qVar.f13097b, qVar.d(), qVar.b(), j11, j12, qVar.a());
        this.f11445m.b(qVar.f13096a);
        this.f11449q.s(iVar, qVar.f13098c);
    }

    void T(q qVar, long j11, long j12) {
        i iVar = new i(qVar.f13096a, qVar.f13097b, qVar.d(), qVar.b(), j11, j12, qVar.a());
        this.f11445m.b(qVar.f13096a);
        this.f11449q.v(iVar, qVar.f13098c);
        a2.c cVar = (a2.c) qVar.c();
        a2.c cVar2 = this.H;
        int d11 = cVar2 == null ? 0 : cVar2.d();
        long j13 = cVar.c(0).f157b;
        int i11 = 0;
        while (i11 < d11 && this.H.c(i11).f157b < j13) {
            i11++;
        }
        if (cVar.f123d) {
            if (d11 - i11 > cVar.d()) {
                androidx.media3.common.util.u.h("DashMediaSource", "Loaded out of sync manifest");
            } else {
                long j14 = this.N;
                if (j14 == C.TIME_UNSET || cVar.f127h * 1000 > j14) {
                    this.M = 0;
                } else {
                    androidx.media3.common.util.u.h("DashMediaSource", "Loaded stale dynamic manifest: " + cVar.f127h + ", " + this.N);
                }
            }
            int i12 = this.M;
            this.M = i12 + 1;
            if (i12 < this.f11445m.a(qVar.f13098c)) {
                e0(L());
                return;
            } else {
                this.C = new DashManifestStaleException();
                return;
            }
        }
        this.H = cVar;
        this.I = cVar.f123d & this.I;
        this.J = j11 - j12;
        this.K = j11;
        this.O += i11;
        synchronized (this.f11452t) {
            try {
                if (qVar.f13097b.f77634a == this.F) {
                    Uri uri = this.H.f130k;
                    if (uri == null) {
                        uri = qVar.d();
                    }
                    this.F = uri;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        a2.c cVar3 = this.H;
        if (!cVar3.f123d || this.L != C.TIME_UNSET) {
            a0(true);
            return;
        }
        a2.o oVar = cVar3.f128i;
        if (oVar != null) {
            b0(oVar);
        } else {
            P();
        }
    }

    Loader.c U(q qVar, long j11, long j12, IOException iOException, int i11) {
        i iVar = new i(qVar.f13096a, qVar.f13097b, qVar.d(), qVar.b(), j11, j12, qVar.a());
        long c11 = this.f11445m.c(new m.c(iVar, new g2.j(qVar.f13098c), iOException, i11));
        Loader.c g11 = c11 == C.TIME_UNSET ? Loader.f13032g : Loader.g(false, c11);
        boolean c12 = g11.c();
        this.f11449q.z(iVar, qVar.f13098c, iOException, !c12);
        if (!c12) {
            this.f11445m.b(qVar.f13096a);
        }
        return g11;
    }

    void V(q qVar, long j11, long j12, int i11) {
        this.f11449q.B(i11 == 0 ? new i(qVar.f13096a, qVar.f13097b, j11) : new i(qVar.f13096a, qVar.f13097b, qVar.d(), qVar.b(), j11, j12, qVar.a()), qVar.f13098c, i11);
    }

    void W(q qVar, long j11, long j12) {
        i iVar = new i(qVar.f13096a, qVar.f13097b, qVar.d(), qVar.b(), j11, j12, qVar.a());
        this.f11445m.b(qVar.f13096a);
        this.f11449q.v(iVar, qVar.f13098c);
        Z(((Long) qVar.c()).longValue() - j11);
    }

    Loader.c X(q qVar, long j11, long j12, IOException iOException) {
        this.f11449q.z(new i(qVar.f13096a, qVar.f13097b, qVar.d(), qVar.b(), j11, j12, qVar.a()), qVar.f13098c, iOException, true);
        this.f11445m.b(qVar.f13096a);
        Y(iOException);
        return Loader.f13031f;
    }

    @Override // androidx.media3.exoplayer.source.r
    public synchronized t a() {
        return this.P;
    }

    @Override // androidx.media3.exoplayer.source.r
    public androidx.media3.exoplayer.source.q g(r.b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11) {
        int intValue = ((Integer) bVar.f12965a).intValue() - this.O;
        s.a u11 = u(bVar);
        androidx.media3.exoplayer.dash.c cVar = new androidx.media3.exoplayer.dash.c(intValue + this.O, this.H, this.f11446n, intValue, this.f11442j, this.B, null, this.f11444l, s(bVar), this.f11445m, u11, this.L, this.f11457y, bVar2, this.f11443k, this.f11456x, x());
        this.f11453u.put(cVar.f11483a, cVar);
        return cVar;
    }

    @Override // androidx.media3.exoplayer.source.r
    public void j(androidx.media3.exoplayer.source.q qVar) {
        androidx.media3.exoplayer.dash.c cVar = (androidx.media3.exoplayer.dash.c) qVar;
        cVar.C();
        this.f11453u.remove(cVar.f11483a);
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.r
    public synchronized void l(t tVar) {
        this.P = tVar;
    }

    @Override // androidx.media3.exoplayer.source.r
    public void maybeThrowSourceInfoRefreshError() {
        this.f11457y.maybeThrowError();
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.r
    public boolean q(t tVar) {
        t a11 = a();
        t.h hVar = (t.h) androidx.media3.common.util.a.e(a11.f10293b);
        t.h hVar2 = tVar.f10293b;
        return hVar2 != null && hVar2.f10385a.equals(hVar.f10385a) && hVar2.f10388d.equals(hVar.f10388d) && Objects.equals(hVar2.f10387c, hVar.f10387c) && a11.f10295d.equals(tVar.f10295d);
    }

    @Override // androidx.media3.exoplayer.source.a
    protected void z(n nVar) {
        this.B = nVar;
        this.f11444l.c(Looper.myLooper(), x());
        this.f11444l.prepare();
        if (this.f11440h) {
            a0(false);
            return;
        }
        this.f11458z = this.f11441i.createDataSource();
        this.A = new Loader("DashMediaSource");
        this.D = a1.A();
        g0();
    }
}
