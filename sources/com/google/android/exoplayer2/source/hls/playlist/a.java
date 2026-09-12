package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.hls.f;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.a;
import com.google.android.exoplayer2.source.hls.playlist.d;
import com.google.android.exoplayer2.source.hls.playlist.e;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.g3;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import t9.h;
import t9.i;

/* loaded from: classes3.dex */
public final class a implements HlsPlaylistTracker, Loader.b {

    /* renamed from: p, reason: collision with root package name */
    public static final HlsPlaylistTracker.a f26147p = new HlsPlaylistTracker.a() { // from class: y9.b
        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.a
        public final HlsPlaylistTracker a(f fVar, z zVar, e eVar) {
            return new com.google.android.exoplayer2.source.hls.playlist.a(fVar, zVar, eVar);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final f f26148a;

    /* renamed from: b, reason: collision with root package name */
    private final y9.e f26149b;

    /* renamed from: c, reason: collision with root package name */
    private final z f26150c;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap f26151d;

    /* renamed from: e, reason: collision with root package name */
    private final CopyOnWriteArrayList f26152e;

    /* renamed from: f, reason: collision with root package name */
    private final double f26153f;

    /* renamed from: g, reason: collision with root package name */
    private p.a f26154g;

    /* renamed from: h, reason: collision with root package name */
    private Loader f26155h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f26156i;

    /* renamed from: j, reason: collision with root package name */
    private HlsPlaylistTracker.c f26157j;

    /* renamed from: k, reason: collision with root package name */
    private e f26158k;

    /* renamed from: l, reason: collision with root package name */
    private Uri f26159l;

    /* renamed from: m, reason: collision with root package name */
    private d f26160m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f26161n;

    /* renamed from: o, reason: collision with root package name */
    private long f26162o;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements HlsPlaylistTracker.b {
        private b() {
        }

        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
        public void c() {
            a.this.f26152e.remove(this);
        }

        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
        public boolean f(Uri uri, z.c cVar, boolean z10) {
            c cVar2;
            if (a.this.f26160m == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                List list = ((e) p0.j(a.this.f26158k)).f26221e;
                int i11 = 0;
                for (int i12 = 0; i12 < list.size(); i12++) {
                    c cVar3 = (c) a.this.f26151d.get(((e.b) list.get(i12)).f26234a);
                    if (cVar3 != null && elapsedRealtime < cVar3.f26171h) {
                        i11++;
                    }
                }
                z.b d11 = a.this.f26150c.d(new z.a(1, 0, a.this.f26158k.f26221e.size(), i11), cVar);
                if (d11 != null && d11.f27594a == 2 && (cVar2 = (c) a.this.f26151d.get(uri)) != null) {
                    cVar2.h(d11.f27595b);
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class c implements Loader.b {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f26164a;

        /* renamed from: b, reason: collision with root package name */
        private final Loader f26165b = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");

        /* renamed from: c, reason: collision with root package name */
        private final k f26166c;

        /* renamed from: d, reason: collision with root package name */
        private d f26167d;

        /* renamed from: e, reason: collision with root package name */
        private long f26168e;

        /* renamed from: f, reason: collision with root package name */
        private long f26169f;

        /* renamed from: g, reason: collision with root package name */
        private long f26170g;

        /* renamed from: h, reason: collision with root package name */
        private long f26171h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f26172i;

        /* renamed from: j, reason: collision with root package name */
        private IOException f26173j;

        public c(Uri uri) {
            this.f26164a = uri;
            this.f26166c = a.this.f26148a.a(4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean h(long j11) {
            this.f26171h = SystemClock.elapsedRealtime() + j11;
            return this.f26164a.equals(a.this.f26159l) && !a.this.L();
        }

        private Uri i() {
            d dVar = this.f26167d;
            if (dVar != null) {
                d.f fVar = dVar.f26195v;
                if (fVar.f26214a != C.TIME_UNSET || fVar.f26218e) {
                    Uri.Builder buildUpon = this.f26164a.buildUpon();
                    d dVar2 = this.f26167d;
                    if (dVar2.f26195v.f26218e) {
                        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(dVar2.f26184k + dVar2.f26191r.size()));
                        d dVar3 = this.f26167d;
                        if (dVar3.f26187n != C.TIME_UNSET) {
                            List list = dVar3.f26192s;
                            int size = list.size();
                            if (!list.isEmpty() && ((d.b) g3.g(list)).f26197m) {
                                size--;
                            }
                            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(size));
                        }
                    }
                    d.f fVar2 = this.f26167d.f26195v;
                    if (fVar2.f26214a != C.TIME_UNSET) {
                        buildUpon.appendQueryParameter("_HLS_skip", fVar2.f26215b ? "v2" : "YES");
                    }
                    return buildUpon.build();
                }
            }
            return this.f26164a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(Uri uri) {
            this.f26172i = false;
            q(uri);
        }

        private void q(Uri uri) {
            b0 b0Var = new b0(this.f26166c, uri, 4, a.this.f26149b.b(a.this.f26158k, this.f26167d));
            a.this.f26154g.z(new h(b0Var.f27325a, b0Var.f27326b, this.f26165b.m(b0Var, this, a.this.f26150c.a(b0Var.f27327c))), b0Var.f27327c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(final Uri uri) {
            this.f26171h = 0L;
            if (this.f26172i || this.f26165b.i() || this.f26165b.h()) {
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime >= this.f26170g) {
                q(uri);
            } else {
                this.f26172i = true;
                a.this.f26156i.postDelayed(new Runnable() { // from class: com.google.android.exoplayer2.source.hls.playlist.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.c.this.o(uri);
                    }
                }, this.f26170g - elapsedRealtime);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w(d dVar, h hVar) {
            boolean z10;
            d dVar2 = this.f26167d;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f26168e = elapsedRealtime;
            d G = a.this.G(dVar2, dVar);
            this.f26167d = G;
            IOException iOException = null;
            if (G != dVar2) {
                this.f26173j = null;
                this.f26169f = elapsedRealtime;
                a.this.R(this.f26164a, G);
            } else if (!G.f26188o) {
                if (dVar.f26184k + dVar.f26191r.size() < this.f26167d.f26184k) {
                    iOException = new HlsPlaylistTracker.PlaylistResetException(this.f26164a);
                    z10 = true;
                } else {
                    z10 = false;
                    if (elapsedRealtime - this.f26169f > p0.e1(r13.f26186m) * a.this.f26153f) {
                        iOException = new HlsPlaylistTracker.PlaylistStuckException(this.f26164a);
                    }
                }
                if (iOException != null) {
                    this.f26173j = iOException;
                    a.this.N(this.f26164a, new z.c(hVar, new i(4), iOException, 1), z10);
                }
            }
            d dVar3 = this.f26167d;
            this.f26170g = elapsedRealtime + p0.e1(!dVar3.f26195v.f26218e ? dVar3 != dVar2 ? dVar3.f26186m : dVar3.f26186m / 2 : 0L);
            if ((this.f26167d.f26187n != C.TIME_UNSET || this.f26164a.equals(a.this.f26159l)) && !this.f26167d.f26188o) {
                r(i());
            }
        }

        public d k() {
            return this.f26167d;
        }

        public boolean m() {
            int i11;
            if (this.f26167d == null) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(30000L, p0.e1(this.f26167d.f26194u));
            d dVar = this.f26167d;
            return dVar.f26188o || (i11 = dVar.f26177d) == 2 || i11 == 1 || this.f26168e + max > elapsedRealtime;
        }

        public void p() {
            r(this.f26164a);
        }

        public void s() {
            this.f26165b.maybeThrowError();
            IOException iOException = this.f26173j;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public void j(b0 b0Var, long j11, long j12, boolean z10) {
            h hVar = new h(b0Var.f27325a, b0Var.f27326b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
            a.this.f26150c.b(b0Var.f27325a);
            a.this.f26154g.q(hVar, 4);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public void l(b0 b0Var, long j11, long j12) {
            y9.d dVar = (y9.d) b0Var.c();
            h hVar = new h(b0Var.f27325a, b0Var.f27326b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
            if (dVar instanceof d) {
                w((d) dVar, hVar);
                a.this.f26154g.t(hVar, 4);
            } else {
                this.f26173j = ParserException.createForMalformedManifest("Loaded playlist has unexpected type.", null);
                a.this.f26154g.x(hVar, 4, this.f26173j, true);
            }
            a.this.f26150c.b(b0Var.f27325a);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public Loader.c n(b0 b0Var, long j11, long j12, IOException iOException, int i11) {
            Loader.c cVar;
            h hVar = new h(b0Var.f27325a, b0Var.f27326b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
            boolean z10 = iOException instanceof HlsPlaylistParser.DeltaUpdateException;
            if ((b0Var.d().getQueryParameter("_HLS_msn") != null) || z10) {
                int i12 = iOException instanceof HttpDataSource$InvalidResponseCodeException ? ((HttpDataSource$InvalidResponseCodeException) iOException).responseCode : Integer.MAX_VALUE;
                if (z10 || i12 == 400 || i12 == 503) {
                    this.f26170g = SystemClock.elapsedRealtime();
                    p();
                    ((p.a) p0.j(a.this.f26154g)).x(hVar, b0Var.f27327c, iOException, true);
                    return Loader.f27300f;
                }
            }
            z.c cVar2 = new z.c(hVar, new i(b0Var.f27327c), iOException, i11);
            if (a.this.N(this.f26164a, cVar2, false)) {
                long c11 = a.this.f26150c.c(cVar2);
                cVar = c11 != C.TIME_UNSET ? Loader.g(false, c11) : Loader.f27301g;
            } else {
                cVar = Loader.f27300f;
            }
            boolean c12 = cVar.c();
            a.this.f26154g.x(hVar, b0Var.f27327c, iOException, !c12);
            if (!c12) {
                a.this.f26150c.b(b0Var.f27325a);
            }
            return cVar;
        }

        public void x() {
            this.f26165b.k();
        }
    }

    public a(f fVar, z zVar, y9.e eVar) {
        this(fVar, zVar, eVar, 3.5d);
    }

    public a(f fVar, z zVar, y9.e eVar, double d11) {
        this.f26148a = fVar;
        this.f26149b = eVar;
        this.f26150c = zVar;
        this.f26153f = d11;
        this.f26152e = new CopyOnWriteArrayList();
        this.f26151d = new HashMap();
        this.f26162o = C.TIME_UNSET;
    }

    private void E(List list) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Uri uri = (Uri) list.get(i11);
            this.f26151d.put(uri, new c(uri));
        }
    }

    private static d.C0374d F(d dVar, d dVar2) {
        int i11 = (int) (dVar2.f26184k - dVar.f26184k);
        List list = dVar.f26191r;
        if (i11 < list.size()) {
            return (d.C0374d) list.get(i11);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d G(d dVar, d dVar2) {
        return !dVar2.e(dVar) ? dVar2.f26188o ? dVar.c() : dVar : dVar2.b(I(dVar, dVar2), H(dVar, dVar2));
    }

    private int H(d dVar, d dVar2) {
        d.C0374d F;
        if (dVar2.f26182i) {
            return dVar2.f26183j;
        }
        d dVar3 = this.f26160m;
        int i11 = dVar3 != null ? dVar3.f26183j : 0;
        return (dVar == null || (F = F(dVar, dVar2)) == null) ? i11 : (dVar.f26183j + F.f26206d) - ((d.C0374d) dVar2.f26191r.get(0)).f26206d;
    }

    private long I(d dVar, d dVar2) {
        if (dVar2.f26189p) {
            return dVar2.f26181h;
        }
        d dVar3 = this.f26160m;
        long j11 = dVar3 != null ? dVar3.f26181h : 0L;
        if (dVar == null) {
            return j11;
        }
        int size = dVar.f26191r.size();
        d.C0374d F = F(dVar, dVar2);
        return F != null ? dVar.f26181h + F.f26207e : ((long) size) == dVar2.f26184k - dVar.f26184k ? dVar.d() : j11;
    }

    private Uri J(Uri uri) {
        d.c cVar;
        d dVar = this.f26160m;
        if (dVar == null || !dVar.f26195v.f26218e || (cVar = (d.c) dVar.f26193t.get(uri)) == null) {
            return uri;
        }
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(cVar.f26199b));
        int i11 = cVar.f26200c;
        if (i11 != -1) {
            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(i11));
        }
        return buildUpon.build();
    }

    private boolean K(Uri uri) {
        List list = this.f26158k.f26221e;
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (uri.equals(((e.b) list.get(i11)).f26234a)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L() {
        List list = this.f26158k.f26221e;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i11 = 0; i11 < size; i11++) {
            c cVar = (c) com.google.android.exoplayer2.util.a.e((c) this.f26151d.get(((e.b) list.get(i11)).f26234a));
            if (elapsedRealtime > cVar.f26171h) {
                Uri uri = cVar.f26164a;
                this.f26159l = uri;
                cVar.r(J(uri));
                return true;
            }
        }
        return false;
    }

    private void M(Uri uri) {
        if (uri.equals(this.f26159l) || !K(uri)) {
            return;
        }
        d dVar = this.f26160m;
        if (dVar == null || !dVar.f26188o) {
            this.f26159l = uri;
            c cVar = (c) this.f26151d.get(uri);
            d dVar2 = cVar.f26167d;
            if (dVar2 == null || !dVar2.f26188o) {
                cVar.r(J(uri));
            } else {
                this.f26160m = dVar2;
                this.f26157j.f(dVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N(Uri uri, z.c cVar, boolean z10) {
        Iterator it = this.f26152e.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            z11 |= !((HlsPlaylistTracker.b) it.next()).f(uri, cVar, z10);
        }
        return z11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(Uri uri, d dVar) {
        if (uri.equals(this.f26159l)) {
            if (this.f26160m == null) {
                this.f26161n = !dVar.f26188o;
                this.f26162o = dVar.f26181h;
            }
            this.f26160m = dVar;
            this.f26157j.f(dVar);
        }
        Iterator it = this.f26152e.iterator();
        while (it.hasNext()) {
            ((HlsPlaylistTracker.b) it.next()).c();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void j(b0 b0Var, long j11, long j12, boolean z10) {
        h hVar = new h(b0Var.f27325a, b0Var.f27326b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
        this.f26150c.b(b0Var.f27325a);
        this.f26154g.q(hVar, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void l(b0 b0Var, long j11, long j12) {
        y9.d dVar = (y9.d) b0Var.c();
        boolean z10 = dVar instanceof d;
        e d11 = z10 ? e.d(dVar.f79073a) : (e) dVar;
        this.f26158k = d11;
        this.f26159l = ((e.b) d11.f26221e.get(0)).f26234a;
        this.f26152e.add(new b());
        E(d11.f26220d);
        h hVar = new h(b0Var.f27325a, b0Var.f27326b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
        c cVar = (c) this.f26151d.get(this.f26159l);
        if (z10) {
            cVar.w((d) dVar, hVar);
        } else {
            cVar.p();
        }
        this.f26150c.b(b0Var.f27325a);
        this.f26154g.t(hVar, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public Loader.c n(b0 b0Var, long j11, long j12, IOException iOException, int i11) {
        h hVar = new h(b0Var.f27325a, b0Var.f27326b, b0Var.d(), b0Var.b(), j11, j12, b0Var.a());
        long c11 = this.f26150c.c(new z.c(hVar, new i(b0Var.f27327c), iOException, i11));
        boolean z10 = c11 == C.TIME_UNSET;
        this.f26154g.x(hVar, b0Var.f27327c, iOException, z10);
        if (z10) {
            this.f26150c.b(b0Var.f27325a);
        }
        return z10 ? Loader.f27301g : Loader.g(false, c11);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void a(Uri uri) {
        ((c) this.f26151d.get(uri)).s();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public long b() {
        return this.f26162o;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public e c() {
        return this.f26158k;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void d(Uri uri) {
        ((c) this.f26151d.get(uri)).p();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean e(Uri uri) {
        return ((c) this.f26151d.get(uri)).m();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean f() {
        return this.f26161n;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean g(Uri uri, long j11) {
        if (((c) this.f26151d.get(uri)) != null) {
            return !r2.h(j11);
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void h() {
        Loader loader = this.f26155h;
        if (loader != null) {
            loader.maybeThrowError();
        }
        Uri uri = this.f26159l;
        if (uri != null) {
            a(uri);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public d i(Uri uri, boolean z10) {
        d k11 = ((c) this.f26151d.get(uri)).k();
        if (k11 != null && z10) {
            M(uri);
        }
        return k11;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void k(HlsPlaylistTracker.b bVar) {
        this.f26152e.remove(bVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void m(HlsPlaylistTracker.b bVar) {
        com.google.android.exoplayer2.util.a.e(bVar);
        this.f26152e.add(bVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void o(Uri uri, p.a aVar, HlsPlaylistTracker.c cVar) {
        this.f26156i = p0.w();
        this.f26154g = aVar;
        this.f26157j = cVar;
        b0 b0Var = new b0(this.f26148a.a(4), uri, 4, this.f26149b.a());
        com.google.android.exoplayer2.util.a.g(this.f26155h == null);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        this.f26155h = loader;
        aVar.z(new h(b0Var.f27325a, b0Var.f27326b, loader.m(b0Var, this, this.f26150c.a(b0Var.f27327c))), b0Var.f27327c);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void stop() {
        this.f26159l = null;
        this.f26160m = null;
        this.f26158k = null;
        this.f26162o = C.TIME_UNSET;
        this.f26155h.k();
        this.f26155h = null;
        Iterator it = this.f26151d.values().iterator();
        while (it.hasNext()) {
            ((c) it.next()).x();
        }
        this.f26156i.removeCallbacksAndMessages(null);
        this.f26156i = null;
        this.f26151d.clear();
    }
}
