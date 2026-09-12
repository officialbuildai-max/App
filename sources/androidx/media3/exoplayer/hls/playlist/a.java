package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.a1;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.exoplayer.hls.f;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.hls.playlist.a;
import androidx.media3.exoplayer.hls.playlist.c;
import androidx.media3.exoplayer.hls.playlist.d;
import androidx.media3.exoplayer.source.s;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.upstream.m;
import androidx.media3.exoplayer.upstream.q;
import c2.e;
import com.google.common.collect.g3;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g2.i;
import g2.j;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import w1.h;

/* loaded from: classes2.dex */
public final class a implements HlsPlaylistTracker, Loader.b {

    /* renamed from: p, reason: collision with root package name */
    public static final HlsPlaylistTracker.a f11922p = new HlsPlaylistTracker.a() { // from class: c2.b
        @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker.a
        public final HlsPlaylistTracker a(f fVar, m mVar, e eVar, androidx.media3.exoplayer.upstream.f fVar2) {
            return new androidx.media3.exoplayer.hls.playlist.a(fVar, mVar, eVar, fVar2);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final f f11923a;

    /* renamed from: b, reason: collision with root package name */
    private final e f11924b;

    /* renamed from: c, reason: collision with root package name */
    private final m f11925c;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap f11926d;

    /* renamed from: e, reason: collision with root package name */
    private final CopyOnWriteArrayList f11927e;

    /* renamed from: f, reason: collision with root package name */
    private final double f11928f;

    /* renamed from: g, reason: collision with root package name */
    private s.a f11929g;

    /* renamed from: h, reason: collision with root package name */
    private Loader f11930h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f11931i;

    /* renamed from: j, reason: collision with root package name */
    private HlsPlaylistTracker.c f11932j;

    /* renamed from: k, reason: collision with root package name */
    private d f11933k;

    /* renamed from: l, reason: collision with root package name */
    private Uri f11934l;

    /* renamed from: m, reason: collision with root package name */
    private androidx.media3.exoplayer.hls.playlist.c f11935m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f11936n;

    /* renamed from: o, reason: collision with root package name */
    private long f11937o;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements HlsPlaylistTracker.b {
        private b() {
        }

        @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker.b
        public void c() {
            a.this.f11927e.remove(this);
        }

        @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker.b
        public boolean d(Uri uri, m.c cVar, boolean z10) {
            c cVar2;
            if (a.this.f11935m == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                List list = ((d) a1.i(a.this.f11933k)).f12016e;
                int i11 = 0;
                for (int i12 = 0; i12 < list.size(); i12++) {
                    c cVar3 = (c) a.this.f11926d.get(((d.b) list.get(i12)).f12029a);
                    if (cVar3 != null && elapsedRealtime < cVar3.f11946h) {
                        i11++;
                    }
                }
                m.b d11 = a.this.f11925c.d(new m.a(1, 0, a.this.f11933k.f12016e.size(), i11), cVar);
                if (d11 != null && d11.f13090a == 2 && (cVar2 = (c) a.this.f11926d.get(uri)) != null) {
                    cVar2.h(d11.f13091b);
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class c implements Loader.b {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f11939a;

        /* renamed from: b, reason: collision with root package name */
        private final Loader f11940b = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");

        /* renamed from: c, reason: collision with root package name */
        private final androidx.media3.datasource.a f11941c;

        /* renamed from: d, reason: collision with root package name */
        private androidx.media3.exoplayer.hls.playlist.c f11942d;

        /* renamed from: e, reason: collision with root package name */
        private long f11943e;

        /* renamed from: f, reason: collision with root package name */
        private long f11944f;

        /* renamed from: g, reason: collision with root package name */
        private long f11945g;

        /* renamed from: h, reason: collision with root package name */
        private long f11946h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f11947i;

        /* renamed from: j, reason: collision with root package name */
        private IOException f11948j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f11949k;

        public c(Uri uri) {
            this.f11939a = uri;
            this.f11941c = a.this.f11923a.a(4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean h(long j11) {
            this.f11946h = SystemClock.elapsedRealtime() + j11;
            return this.f11939a.equals(a.this.f11934l) && !a.this.P();
        }

        private Uri i() {
            androidx.media3.exoplayer.hls.playlist.c cVar = this.f11942d;
            if (cVar != null) {
                c.h hVar = cVar.f11971v;
                if (hVar.f12009a != C.TIME_UNSET || hVar.f12013e) {
                    Uri.Builder buildUpon = this.f11939a.buildUpon();
                    androidx.media3.exoplayer.hls.playlist.c cVar2 = this.f11942d;
                    if (cVar2.f11971v.f12013e) {
                        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(cVar2.f11960k + cVar2.f11967r.size()));
                        androidx.media3.exoplayer.hls.playlist.c cVar3 = this.f11942d;
                        if (cVar3.f11963n != C.TIME_UNSET) {
                            List list = cVar3.f11968s;
                            int size = list.size();
                            if (!list.isEmpty() && ((c.d) g3.g(list)).f11992m) {
                                size--;
                            }
                            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(size));
                        }
                    }
                    c.h hVar2 = this.f11942d.f11971v;
                    if (hVar2.f12009a != C.TIME_UNSET) {
                        buildUpon.appendQueryParameter("_HLS_skip", hVar2.f12010b ? "v2" : "YES");
                    }
                    return buildUpon.build();
                }
            }
            return this.f11939a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(Uri uri) {
            this.f11947i = false;
            s(uri);
        }

        private void s(Uri uri) {
            q.a b11 = a.this.f11924b.b(a.this.f11933k, this.f11942d);
            h a11 = new h.b().i(uri).b(1).a();
            a.v(a.this);
            q qVar = new q(this.f11941c, a11, 4, b11);
            this.f11940b.m(qVar, this, a.this.f11925c.a(qVar.f13098c));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(final Uri uri) {
            this.f11946h = 0L;
            if (this.f11947i || this.f11940b.i() || this.f11940b.h()) {
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime >= this.f11945g) {
                s(uri);
            } else {
                this.f11947i = true;
                a.this.f11931i.postDelayed(new Runnable() { // from class: androidx.media3.exoplayer.hls.playlist.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.c.this.n(uri);
                    }
                }, this.f11945g - elapsedRealtime);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z(androidx.media3.exoplayer.hls.playlist.c cVar, i iVar) {
            boolean z10;
            androidx.media3.exoplayer.hls.playlist.c cVar2 = this.f11942d;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f11943e = elapsedRealtime;
            androidx.media3.exoplayer.hls.playlist.c J = a.this.J(cVar2, cVar);
            this.f11942d = J;
            IOException iOException = null;
            if (J != cVar2) {
                this.f11948j = null;
                this.f11944f = elapsedRealtime;
                a.this.W(this.f11939a, J);
            } else if (!J.f11964o) {
                if (cVar.f11960k + cVar.f11967r.size() < this.f11942d.f11960k) {
                    iOException = new HlsPlaylistTracker.PlaylistResetException(this.f11939a);
                    z10 = true;
                } else {
                    z10 = false;
                    if (elapsedRealtime - this.f11944f > a1.y1(r13.f11962m) * a.this.f11928f) {
                        iOException = new HlsPlaylistTracker.PlaylistStuckException(this.f11939a);
                    }
                }
                if (iOException != null) {
                    this.f11948j = iOException;
                    a.this.R(this.f11939a, new m.c(iVar, new j(4), iOException, 1), z10);
                }
            }
            androidx.media3.exoplayer.hls.playlist.c cVar3 = this.f11942d;
            this.f11945g = (elapsedRealtime + a1.y1(!cVar3.f11971v.f12013e ? cVar3 != cVar2 ? cVar3.f11962m : cVar3.f11962m / 2 : 0L)) - iVar.f63336f;
            if (this.f11942d.f11964o) {
                return;
            }
            if (this.f11939a.equals(a.this.f11934l) || this.f11949k) {
                t(i());
            }
        }

        public void A() {
            this.f11940b.k();
        }

        public void B(boolean z10) {
            this.f11949k = z10;
        }

        public androidx.media3.exoplayer.hls.playlist.c j() {
            return this.f11942d;
        }

        public boolean l() {
            return this.f11949k;
        }

        public boolean m() {
            int i11;
            if (this.f11942d == null) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(30000L, a1.y1(this.f11942d.f11970u));
            androidx.media3.exoplayer.hls.playlist.c cVar = this.f11942d;
            return cVar.f11964o || (i11 = cVar.f11953d) == 2 || i11 == 1 || this.f11943e + max > elapsedRealtime;
        }

        public void r(boolean z10) {
            t(z10 ? i() : this.f11939a);
        }

        public void u() {
            this.f11940b.maybeThrowError();
            IOException iOException = this.f11948j;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public void q(q qVar, long j11, long j12, boolean z10) {
            i iVar = new i(qVar.f13096a, qVar.f13097b, qVar.d(), qVar.b(), j11, j12, qVar.a());
            a.this.f11925c.b(qVar.f13096a);
            a.this.f11929g.s(iVar, 4);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public void p(q qVar, long j11, long j12) {
            c2.d dVar = (c2.d) qVar.c();
            i iVar = new i(qVar.f13096a, qVar.f13097b, qVar.d(), qVar.b(), j11, j12, qVar.a());
            if (dVar instanceof androidx.media3.exoplayer.hls.playlist.c) {
                z((androidx.media3.exoplayer.hls.playlist.c) dVar, iVar);
                a.this.f11929g.v(iVar, 4);
            } else {
                this.f11948j = ParserException.createForMalformedManifest("Loaded playlist has unexpected type.", null);
                a.this.f11929g.z(iVar, 4, this.f11948j, true);
            }
            a.this.f11925c.b(qVar.f13096a);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public Loader.c k(q qVar, long j11, long j12, IOException iOException, int i11) {
            Loader.c cVar;
            i iVar = new i(qVar.f13096a, qVar.f13097b, qVar.d(), qVar.b(), j11, j12, qVar.a());
            boolean z10 = iOException instanceof HlsPlaylistParser.DeltaUpdateException;
            if ((qVar.d().getQueryParameter("_HLS_msn") != null) || z10) {
                int i12 = iOException instanceof HttpDataSource.InvalidResponseCodeException ? ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode : Integer.MAX_VALUE;
                if (z10 || i12 == 400 || i12 == 503) {
                    this.f11945g = SystemClock.elapsedRealtime();
                    r(false);
                    ((s.a) a1.i(a.this.f11929g)).z(iVar, qVar.f13098c, iOException, true);
                    return Loader.f13031f;
                }
            }
            m.c cVar2 = new m.c(iVar, new j(qVar.f13098c), iOException, i11);
            if (a.this.R(this.f11939a, cVar2, false)) {
                long c11 = a.this.f11925c.c(cVar2);
                cVar = c11 != C.TIME_UNSET ? Loader.g(false, c11) : Loader.f13032g;
            } else {
                cVar = Loader.f13031f;
            }
            boolean c12 = cVar.c();
            a.this.f11929g.z(iVar, qVar.f13098c, iOException, !c12);
            if (!c12) {
                a.this.f11925c.b(qVar.f13096a);
            }
            return cVar;
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public void o(q qVar, long j11, long j12, int i11) {
            a.this.f11929g.B(i11 == 0 ? new i(qVar.f13096a, qVar.f13097b, j11) : new i(qVar.f13096a, qVar.f13097b, qVar.d(), qVar.b(), j11, j12, qVar.a()), qVar.f13098c, i11);
        }
    }

    public a(f fVar, m mVar, e eVar, androidx.media3.exoplayer.upstream.f fVar2) {
        this(fVar, mVar, eVar, fVar2, 3.5d);
    }

    public a(f fVar, m mVar, e eVar, androidx.media3.exoplayer.upstream.f fVar2, double d11) {
        this.f11923a = fVar;
        this.f11924b = eVar;
        this.f11925c = mVar;
        this.f11928f = d11;
        this.f11927e = new CopyOnWriteArrayList();
        this.f11926d = new HashMap();
        this.f11937o = C.TIME_UNSET;
    }

    private void H(List list) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Uri uri = (Uri) list.get(i11);
            this.f11926d.put(uri, new c(uri));
        }
    }

    private static c.f I(androidx.media3.exoplayer.hls.playlist.c cVar, androidx.media3.exoplayer.hls.playlist.c cVar2) {
        int i11 = (int) (cVar2.f11960k - cVar.f11960k);
        List list = cVar.f11967r;
        if (i11 < list.size()) {
            return (c.f) list.get(i11);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public androidx.media3.exoplayer.hls.playlist.c J(androidx.media3.exoplayer.hls.playlist.c cVar, androidx.media3.exoplayer.hls.playlist.c cVar2) {
        return !cVar2.e(cVar) ? cVar2.f11964o ? cVar.c() : cVar : cVar2.b(L(cVar, cVar2), K(cVar, cVar2));
    }

    private int K(androidx.media3.exoplayer.hls.playlist.c cVar, androidx.media3.exoplayer.hls.playlist.c cVar2) {
        c.f I;
        if (cVar2.f11958i) {
            return cVar2.f11959j;
        }
        androidx.media3.exoplayer.hls.playlist.c cVar3 = this.f11935m;
        int i11 = cVar3 != null ? cVar3.f11959j : 0;
        return (cVar == null || (I = I(cVar, cVar2)) == null) ? i11 : (cVar.f11959j + I.f12001d) - ((c.f) cVar2.f11967r.get(0)).f12001d;
    }

    private long L(androidx.media3.exoplayer.hls.playlist.c cVar, androidx.media3.exoplayer.hls.playlist.c cVar2) {
        if (cVar2.f11965p) {
            return cVar2.f11957h;
        }
        androidx.media3.exoplayer.hls.playlist.c cVar3 = this.f11935m;
        long j11 = cVar3 != null ? cVar3.f11957h : 0L;
        if (cVar == null) {
            return j11;
        }
        int size = cVar.f11967r.size();
        c.f I = I(cVar, cVar2);
        return I != null ? cVar.f11957h + I.f12002e : ((long) size) == cVar2.f11960k - cVar.f11960k ? cVar.d() : j11;
    }

    private Uri M(Uri uri) {
        c.e eVar;
        androidx.media3.exoplayer.hls.playlist.c cVar = this.f11935m;
        if (cVar == null || !cVar.f11971v.f12013e || (eVar = (c.e) cVar.f11969t.get(uri)) == null) {
            return uri;
        }
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(eVar.f11994b));
        int i11 = eVar.f11995c;
        if (i11 != -1) {
            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(i11));
        }
        return buildUpon.build();
    }

    private boolean N(Uri uri) {
        List list = this.f11933k.f12016e;
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (uri.equals(((d.b) list.get(i11)).f12029a)) {
                return true;
            }
        }
        return false;
    }

    private void O(Uri uri) {
        c cVar = (c) this.f11926d.get(uri);
        androidx.media3.exoplayer.hls.playlist.c j11 = cVar.j();
        if (cVar.l()) {
            return;
        }
        cVar.B(true);
        if (j11 == null || j11.f11964o) {
            return;
        }
        cVar.r(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P() {
        List list = this.f11933k.f12016e;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i11 = 0; i11 < size; i11++) {
            c cVar = (c) androidx.media3.common.util.a.e((c) this.f11926d.get(((d.b) list.get(i11)).f12029a));
            if (elapsedRealtime > cVar.f11946h) {
                Uri uri = cVar.f11939a;
                this.f11934l = uri;
                cVar.t(M(uri));
                return true;
            }
        }
        return false;
    }

    private void Q(Uri uri) {
        if (uri.equals(this.f11934l) || !N(uri)) {
            return;
        }
        androidx.media3.exoplayer.hls.playlist.c cVar = this.f11935m;
        if (cVar == null || !cVar.f11964o) {
            this.f11934l = uri;
            c cVar2 = (c) this.f11926d.get(uri);
            androidx.media3.exoplayer.hls.playlist.c cVar3 = cVar2.f11942d;
            if (cVar3 == null || !cVar3.f11964o) {
                cVar2.t(M(uri));
            } else {
                this.f11935m = cVar3;
                this.f11932j.f(cVar3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean R(Uri uri, m.c cVar, boolean z10) {
        Iterator it = this.f11927e.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            z11 |= !((HlsPlaylistTracker.b) it.next()).d(uri, cVar, z10);
        }
        return z11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Uri uri, androidx.media3.exoplayer.hls.playlist.c cVar) {
        if (uri.equals(this.f11934l)) {
            if (this.f11935m == null) {
                this.f11936n = !cVar.f11964o;
                this.f11937o = cVar.f11957h;
            }
            this.f11935m = cVar;
            this.f11932j.f(cVar);
        }
        Iterator it = this.f11927e.iterator();
        while (it.hasNext()) {
            ((HlsPlaylistTracker.b) it.next()).c();
        }
    }

    static /* synthetic */ androidx.media3.exoplayer.upstream.f v(a aVar) {
        aVar.getClass();
        return null;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public void q(q qVar, long j11, long j12, boolean z10) {
        i iVar = new i(qVar.f13096a, qVar.f13097b, qVar.d(), qVar.b(), j11, j12, qVar.a());
        this.f11925c.b(qVar.f13096a);
        this.f11929g.s(iVar, 4);
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public void p(q qVar, long j11, long j12) {
        c2.d dVar = (c2.d) qVar.c();
        boolean z10 = dVar instanceof androidx.media3.exoplayer.hls.playlist.c;
        d d11 = z10 ? d.d(dVar.f17066a) : (d) dVar;
        this.f11933k = d11;
        this.f11934l = ((d.b) d11.f12016e.get(0)).f12029a;
        this.f11927e.add(new b());
        H(d11.f12015d);
        i iVar = new i(qVar.f13096a, qVar.f13097b, qVar.d(), qVar.b(), j11, j12, qVar.a());
        c cVar = (c) this.f11926d.get(this.f11934l);
        if (z10) {
            cVar.z((androidx.media3.exoplayer.hls.playlist.c) dVar, iVar);
        } else {
            cVar.r(false);
        }
        this.f11925c.b(qVar.f13096a);
        this.f11929g.v(iVar, 4);
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public Loader.c k(q qVar, long j11, long j12, IOException iOException, int i11) {
        i iVar = new i(qVar.f13096a, qVar.f13097b, qVar.d(), qVar.b(), j11, j12, qVar.a());
        long c11 = this.f11925c.c(new m.c(iVar, new j(qVar.f13098c), iOException, i11));
        boolean z10 = c11 == C.TIME_UNSET;
        this.f11929g.z(iVar, qVar.f13098c, iOException, z10);
        if (z10) {
            this.f11925c.b(qVar.f13096a);
        }
        return z10 ? Loader.f13032g : Loader.g(false, c11);
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public void o(q qVar, long j11, long j12, int i11) {
        this.f11929g.B(i11 == 0 ? new i(qVar.f13096a, qVar.f13097b, j11) : new i(qVar.f13096a, qVar.f13097b, qVar.d(), qVar.b(), j11, j12, qVar.a()), qVar.f13098c, i11);
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public void a(Uri uri) {
        ((c) this.f11926d.get(uri)).u();
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public long b() {
        return this.f11937o;
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public d c() {
        return this.f11933k;
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public void d(Uri uri) {
        ((c) this.f11926d.get(uri)).r(true);
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public boolean e(Uri uri) {
        return ((c) this.f11926d.get(uri)).m();
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public boolean f() {
        return this.f11936n;
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public boolean g(Uri uri, long j11) {
        if (((c) this.f11926d.get(uri)) != null) {
            return !r2.h(j11);
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public void h() {
        Loader loader = this.f11930h;
        if (loader != null) {
            loader.maybeThrowError();
        }
        Uri uri = this.f11934l;
        if (uri != null) {
            a(uri);
        }
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public androidx.media3.exoplayer.hls.playlist.c i(Uri uri, boolean z10) {
        androidx.media3.exoplayer.hls.playlist.c j11 = ((c) this.f11926d.get(uri)).j();
        if (j11 != null && z10) {
            Q(uri);
            O(uri);
        }
        return j11;
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public void j(Uri uri, s.a aVar, HlsPlaylistTracker.c cVar) {
        this.f11931i = a1.A();
        this.f11929g = aVar;
        this.f11932j = cVar;
        q qVar = new q(this.f11923a.a(4), new h.b().i(uri).b(1).a(), 4, this.f11924b.a());
        androidx.media3.common.util.a.g(this.f11930h == null);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        this.f11930h = loader;
        loader.m(qVar, this, this.f11925c.a(qVar.f13098c));
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public void l(Uri uri) {
        c cVar = (c) this.f11926d.get(uri);
        if (cVar != null) {
            cVar.B(false);
        }
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public void m(HlsPlaylistTracker.b bVar) {
        this.f11927e.remove(bVar);
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public void n(HlsPlaylistTracker.b bVar) {
        androidx.media3.common.util.a.e(bVar);
        this.f11927e.add(bVar);
    }

    @Override // androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker
    public void stop() {
        this.f11934l = null;
        this.f11935m = null;
        this.f11933k = null;
        this.f11937o = C.TIME_UNSET;
        this.f11930h.k();
        this.f11930h = null;
        Iterator it = this.f11926d.values().iterator();
        while (it.hasNext()) {
            ((c) it.next()).A();
        }
        this.f11931i.removeCallbacksAndMessages(null);
        this.f11931i = null;
        this.f11926d.clear();
    }
}
