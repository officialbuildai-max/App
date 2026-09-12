package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.c3;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.rtsp.RtspClient;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.rtsp.c;
import com.google.android.exoplayer2.source.rtsp.e;
import com.google.android.exoplayer2.source.rtsp.p;
import com.google.android.exoplayer2.source.rtsp.u;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.net.BindException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.net.SocketFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class p implements com.google.android.exoplayer2.source.n {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.b f26502a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f26503b = p0.w();

    /* renamed from: c, reason: collision with root package name */
    private final b f26504c;

    /* renamed from: d, reason: collision with root package name */
    private final RtspClient f26505d;

    /* renamed from: e, reason: collision with root package name */
    private final List f26506e;

    /* renamed from: f, reason: collision with root package name */
    private final List f26507f;

    /* renamed from: g, reason: collision with root package name */
    private final c f26508g;

    /* renamed from: h, reason: collision with root package name */
    private final c.a f26509h;

    /* renamed from: i, reason: collision with root package name */
    private n.a f26510i;

    /* renamed from: j, reason: collision with root package name */
    private ImmutableList f26511j;

    /* renamed from: k, reason: collision with root package name */
    private IOException f26512k;

    /* renamed from: l, reason: collision with root package name */
    private RtspMediaSource.RtspPlaybackException f26513l;

    /* renamed from: m, reason: collision with root package name */
    private long f26514m;

    /* renamed from: n, reason: collision with root package name */
    private long f26515n;

    /* renamed from: o, reason: collision with root package name */
    private long f26516o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f26517p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f26518q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f26519r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f26520s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f26521t;

    /* renamed from: u, reason: collision with root package name */
    private int f26522u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f26523v;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class b implements g9.n, Loader.b, a0.d, RtspClient.e, RtspClient.d {
        private b() {
        }

        @Override // com.google.android.exoplayer2.source.rtsp.RtspClient.e
        public void a(String str, Throwable th2) {
            p.this.f26512k = th2 == null ? new IOException(str) : new IOException(str, th2);
        }

        @Override // com.google.android.exoplayer2.source.rtsp.RtspClient.d
        public void b(RtspMediaSource.RtspPlaybackException rtspPlaybackException) {
            p.this.f26513l = rtspPlaybackException;
        }

        @Override // com.google.android.exoplayer2.source.a0.d
        public void c(o1 o1Var) {
            Handler handler = p.this.f26503b;
            final p pVar = p.this;
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.rtsp.r
                @Override // java.lang.Runnable
                public final void run() {
                    p.t(p.this);
                }
            });
        }

        @Override // g9.n
        public void d(g9.b0 b0Var) {
        }

        @Override // com.google.android.exoplayer2.source.rtsp.RtspClient.d
        public void e() {
            p.this.f26505d.E0(0L);
        }

        @Override // g9.n
        public void endTracks() {
            Handler handler = p.this.f26503b;
            final p pVar = p.this;
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.rtsp.q
                @Override // java.lang.Runnable
                public final void run() {
                    p.t(p.this);
                }
            });
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.source.rtsp.RtspClient.d
        public void f(long j11, ImmutableList immutableList) {
            ArrayList arrayList = new ArrayList(immutableList.size());
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                arrayList.add((String) com.google.android.exoplayer2.util.a.e(((f0) immutableList.get(i11)).f26425c.getPath()));
            }
            for (int i12 = 0; i12 < p.this.f26507f.size(); i12++) {
                if (!arrayList.contains(((d) p.this.f26507f.get(i12)).c().getPath())) {
                    p.this.f26508g.a();
                    if (p.this.I()) {
                        p.this.f26518q = true;
                        p.this.f26515n = C.TIME_UNSET;
                        p.this.f26514m = C.TIME_UNSET;
                        p.this.f26516o = C.TIME_UNSET;
                    }
                }
            }
            for (int i13 = 0; i13 < immutableList.size(); i13++) {
                f0 f0Var = (f0) immutableList.get(i13);
                com.google.android.exoplayer2.source.rtsp.e G = p.this.G(f0Var.f26425c);
                if (G != null) {
                    G.f(f0Var.f26423a);
                    G.e(f0Var.f26424b);
                    if (p.this.I() && p.this.f26515n == p.this.f26514m) {
                        G.d(j11, f0Var.f26423a);
                    }
                }
            }
            if (!p.this.I()) {
                if (p.this.f26516o != C.TIME_UNSET) {
                    p pVar = p.this;
                    pVar.seekToUs(pVar.f26516o);
                    p.this.f26516o = C.TIME_UNSET;
                    return;
                }
                return;
            }
            if (p.this.f26515n == p.this.f26514m) {
                p.this.f26515n = C.TIME_UNSET;
                p.this.f26514m = C.TIME_UNSET;
            } else {
                p.this.f26515n = C.TIME_UNSET;
                p pVar2 = p.this;
                pVar2.seekToUs(pVar2.f26514m);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.source.rtsp.RtspClient.e
        public void g(d0 d0Var, ImmutableList immutableList) {
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                t tVar = (t) immutableList.get(i11);
                p pVar = p.this;
                e eVar = new e(tVar, i11, pVar.f26509h);
                p.this.f26506e.add(eVar);
                eVar.j();
            }
            p.this.f26508g.b(d0Var);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public void j(com.google.android.exoplayer2.source.rtsp.e eVar, long j11, long j12, boolean z10) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void l(com.google.android.exoplayer2.source.rtsp.e eVar, long j11, long j12) {
            if (p.this.getBufferedPositionUs() == 0) {
                if (p.this.f26523v) {
                    return;
                }
                p.this.N();
                p.this.f26523v = true;
                return;
            }
            for (int i11 = 0; i11 < p.this.f26506e.size(); i11++) {
                e eVar2 = (e) p.this.f26506e.get(i11);
                if (eVar2.f26529a.f26526b == eVar) {
                    eVar2.c();
                    return;
                }
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public Loader.c n(com.google.android.exoplayer2.source.rtsp.e eVar, long j11, long j12, IOException iOException, int i11) {
            if (!p.this.f26520s) {
                p.this.f26512k = iOException;
            } else if (!(iOException.getCause() instanceof BindException)) {
                p.this.f26513l = new RtspMediaSource.RtspPlaybackException(eVar.f26398b.f26541b.toString(), iOException);
            } else if (p.c(p.this) < 3) {
                return Loader.f27298d;
            }
            return Loader.f27300f;
        }

        @Override // g9.n
        public g9.e0 track(int i11, int i12) {
            return ((e) com.google.android.exoplayer2.util.a.e((e) p.this.f26506e.get(i11))).f26531c;
        }
    }

    /* loaded from: classes3.dex */
    interface c {
        void a();

        void b(d0 d0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class d {

        /* renamed from: a, reason: collision with root package name */
        public final t f26525a;

        /* renamed from: b, reason: collision with root package name */
        private final com.google.android.exoplayer2.source.rtsp.e f26526b;

        /* renamed from: c, reason: collision with root package name */
        private String f26527c;

        public d(t tVar, int i11, c.a aVar) {
            this.f26525a = tVar;
            this.f26526b = new com.google.android.exoplayer2.source.rtsp.e(i11, tVar, new e.a() { // from class: com.google.android.exoplayer2.source.rtsp.s
                @Override // com.google.android.exoplayer2.source.rtsp.e.a
                public final void a(String str, c cVar) {
                    p.d.this.f(str, cVar);
                }
            }, p.this.f26504c, aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(String str, com.google.android.exoplayer2.source.rtsp.c cVar) {
            this.f26527c = str;
            u.b g11 = cVar.g();
            if (g11 != null) {
                p.this.f26505d.v0(cVar.d(), g11);
                p.this.f26523v = true;
            }
            p.this.K();
        }

        public Uri c() {
            return this.f26526b.f26398b.f26541b;
        }

        public String d() {
            com.google.android.exoplayer2.util.a.i(this.f26527c);
            return this.f26527c;
        }

        public boolean e() {
            return this.f26527c != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class e {

        /* renamed from: a, reason: collision with root package name */
        public final d f26529a;

        /* renamed from: b, reason: collision with root package name */
        private final Loader f26530b;

        /* renamed from: c, reason: collision with root package name */
        private final com.google.android.exoplayer2.source.a0 f26531c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f26532d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f26533e;

        public e(t tVar, int i11, c.a aVar) {
            this.f26529a = new d(tVar, i11, aVar);
            StringBuilder sb2 = new StringBuilder(55);
            sb2.append("ExoPlayer:RtspMediaPeriod:RtspLoaderWrapper ");
            sb2.append(i11);
            this.f26530b = new Loader(sb2.toString());
            com.google.android.exoplayer2.source.a0 l11 = com.google.android.exoplayer2.source.a0.l(p.this.f26502a);
            this.f26531c = l11;
            l11.d0(p.this.f26504c);
        }

        public void c() {
            if (this.f26532d) {
                return;
            }
            this.f26529a.f26526b.cancelLoad();
            this.f26532d = true;
            p.this.R();
        }

        public long d() {
            return this.f26531c.z();
        }

        public boolean e() {
            return this.f26531c.K(this.f26532d);
        }

        public int f(p1 p1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            return this.f26531c.S(p1Var, decoderInputBuffer, i11, this.f26532d);
        }

        public void g() {
            if (this.f26533e) {
                return;
            }
            this.f26530b.k();
            this.f26531c.T();
            this.f26533e = true;
        }

        public void h(long j11) {
            if (this.f26532d) {
                return;
            }
            this.f26529a.f26526b.c();
            this.f26531c.V();
            this.f26531c.b0(j11);
        }

        public int i(long j11) {
            int E = this.f26531c.E(j11, this.f26532d);
            this.f26531c.e0(E);
            return E;
        }

        public void j() {
            this.f26530b.m(this.f26529a.f26526b, p.this.f26504c, 0);
        }
    }

    /* loaded from: classes3.dex */
    private final class f implements t9.s {

        /* renamed from: a, reason: collision with root package name */
        private final int f26535a;

        public f(int i11) {
            this.f26535a = i11;
        }

        @Override // t9.s
        public int c(p1 p1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            return p.this.L(this.f26535a, p1Var, decoderInputBuffer, i11);
        }

        @Override // t9.s
        public boolean isReady() {
            return p.this.H(this.f26535a);
        }

        @Override // t9.s
        public void maybeThrowError() {
            if (p.this.f26513l != null) {
                throw p.this.f26513l;
            }
        }

        @Override // t9.s
        public int skipData(long j11) {
            return p.this.P(this.f26535a, j11);
        }
    }

    public p(com.google.android.exoplayer2.upstream.b bVar, c.a aVar, Uri uri, c cVar, String str, SocketFactory socketFactory, boolean z10) {
        this.f26502a = bVar;
        this.f26509h = aVar;
        this.f26508g = cVar;
        b bVar2 = new b();
        this.f26504c = bVar2;
        this.f26505d = new RtspClient(bVar2, bVar2, str, uri, socketFactory, z10);
        this.f26506e = new ArrayList();
        this.f26507f = new ArrayList();
        this.f26515n = C.TIME_UNSET;
        this.f26514m = C.TIME_UNSET;
        this.f26516o = C.TIME_UNSET;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static ImmutableList F(ImmutableList immutableList) {
        ImmutableList.a aVar = new ImmutableList.a();
        for (int i11 = 0; i11 < immutableList.size(); i11++) {
            aVar.a(new TrackGroup(Integer.toString(i11), (o1) com.google.android.exoplayer2.util.a.e(((e) immutableList.get(i11)).f26531c.F())));
        }
        return aVar.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.android.exoplayer2.source.rtsp.e G(Uri uri) {
        for (int i11 = 0; i11 < this.f26506e.size(); i11++) {
            if (!((e) this.f26506e.get(i11)).f26532d) {
                d dVar = ((e) this.f26506e.get(i11)).f26529a;
                if (dVar.c().equals(uri)) {
                    return dVar.f26526b;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I() {
        return this.f26515n != C.TIME_UNSET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (this.f26519r || this.f26520s) {
            return;
        }
        for (int i11 = 0; i11 < this.f26506e.size(); i11++) {
            if (((e) this.f26506e.get(i11)).f26531c.F() == null) {
                return;
            }
        }
        this.f26520s = true;
        this.f26511j = F(ImmutableList.copyOf((Collection) this.f26506e));
        ((n.a) com.google.android.exoplayer2.util.a.e(this.f26510i)).h(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        boolean z10 = true;
        for (int i11 = 0; i11 < this.f26507f.size(); i11++) {
            z10 &= ((d) this.f26507f.get(i11)).e();
        }
        if (z10 && this.f26521t) {
            this.f26505d.B0(this.f26507f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void N() {
        this.f26505d.x0();
        c.a b11 = this.f26509h.b();
        if (b11 == null) {
            this.f26513l = new RtspMediaSource.RtspPlaybackException("No fallback data channel factory for TCP retry");
            return;
        }
        ArrayList arrayList = new ArrayList(this.f26506e.size());
        ArrayList arrayList2 = new ArrayList(this.f26507f.size());
        for (int i11 = 0; i11 < this.f26506e.size(); i11++) {
            e eVar = (e) this.f26506e.get(i11);
            if (eVar.f26532d) {
                arrayList.add(eVar);
            } else {
                e eVar2 = new e(eVar.f26529a.f26525a, i11, b11);
                arrayList.add(eVar2);
                eVar2.j();
                if (this.f26507f.contains(eVar.f26529a)) {
                    arrayList2.add(eVar2.f26529a);
                }
            }
        }
        ImmutableList copyOf = ImmutableList.copyOf((Collection) this.f26506e);
        this.f26506e.clear();
        this.f26506e.addAll(arrayList);
        this.f26507f.clear();
        this.f26507f.addAll(arrayList2);
        for (int i12 = 0; i12 < copyOf.size(); i12++) {
            ((e) copyOf.get(i12)).c();
        }
    }

    private boolean O(long j11) {
        for (int i11 = 0; i11 < this.f26506e.size(); i11++) {
            if (!((e) this.f26506e.get(i11)).f26531c.Z(j11, false)) {
                return false;
            }
        }
        return true;
    }

    private boolean Q() {
        return this.f26518q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        this.f26517p = true;
        for (int i11 = 0; i11 < this.f26506e.size(); i11++) {
            this.f26517p &= ((e) this.f26506e.get(i11)).f26532d;
        }
    }

    static /* synthetic */ int c(p pVar) {
        int i11 = pVar.f26522u;
        pVar.f26522u = i11 + 1;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void t(p pVar) {
        pVar.J();
    }

    boolean H(int i11) {
        return !Q() && ((e) this.f26506e.get(i11)).e();
    }

    int L(int i11, p1 p1Var, DecoderInputBuffer decoderInputBuffer, int i12) {
        if (Q()) {
            return -3;
        }
        return ((e) this.f26506e.get(i11)).f(p1Var, decoderInputBuffer, i12);
    }

    public void M() {
        for (int i11 = 0; i11 < this.f26506e.size(); i11++) {
            ((e) this.f26506e.get(i11)).g();
        }
        p0.n(this.f26505d);
        this.f26519r = true;
    }

    int P(int i11, long j11) {
        if (Q()) {
            return -3;
        }
        return ((e) this.f26506e.get(i11)).i(j11);
    }

    @Override // com.google.android.exoplayer2.source.n
    public long a(long j11, c3 c3Var) {
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.n
    public long b(com.google.android.exoplayer2.trackselection.h[] hVarArr, boolean[] zArr, t9.s[] sVarArr, boolean[] zArr2, long j11) {
        for (int i11 = 0; i11 < hVarArr.length; i11++) {
            if (sVarArr[i11] != null && (hVarArr[i11] == null || !zArr[i11])) {
                sVarArr[i11] = null;
            }
        }
        this.f26507f.clear();
        for (int i12 = 0; i12 < hVarArr.length; i12++) {
            com.google.android.exoplayer2.trackselection.h hVar = hVarArr[i12];
            if (hVar != null) {
                TrackGroup trackGroup = hVar.getTrackGroup();
                int indexOf = ((ImmutableList) com.google.android.exoplayer2.util.a.e(this.f26511j)).indexOf(trackGroup);
                this.f26507f.add(((e) com.google.android.exoplayer2.util.a.e((e) this.f26506e.get(indexOf))).f26529a);
                if (this.f26511j.contains(trackGroup) && sVarArr[i12] == null) {
                    sVarArr[i12] = new f(indexOf);
                    zArr2[i12] = true;
                }
            }
        }
        for (int i13 = 0; i13 < this.f26506e.size(); i13++) {
            e eVar = (e) this.f26506e.get(i13);
            if (!this.f26507f.contains(eVar.f26529a)) {
                eVar.c();
            }
        }
        this.f26521t = true;
        K();
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public boolean continueLoading(long j11) {
        return isLoading();
    }

    @Override // com.google.android.exoplayer2.source.n
    public void discardBuffer(long j11, boolean z10) {
        if (I()) {
            return;
        }
        for (int i11 = 0; i11 < this.f26506e.size(); i11++) {
            e eVar = (e) this.f26506e.get(i11);
            if (!eVar.f26532d) {
                eVar.f26531c.q(j11, z10, true);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.n
    public void e(n.a aVar, long j11) {
        this.f26510i = aVar;
        try {
            this.f26505d.C0();
        } catch (IOException e11) {
            this.f26512k = e11;
            p0.n(this.f26505d);
        }
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public long getBufferedPositionUs() {
        if (this.f26517p || this.f26506e.isEmpty()) {
            return Long.MIN_VALUE;
        }
        long j11 = this.f26514m;
        if (j11 != C.TIME_UNSET) {
            return j11;
        }
        boolean z10 = true;
        long j12 = Long.MAX_VALUE;
        for (int i11 = 0; i11 < this.f26506e.size(); i11++) {
            e eVar = (e) this.f26506e.get(i11);
            if (!eVar.f26532d) {
                j12 = Math.min(j12, eVar.d());
                z10 = false;
            }
        }
        if (z10 || j12 == Long.MIN_VALUE) {
            return 0L;
        }
        return j12;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public long getNextLoadPositionUs() {
        return getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.n
    public t9.x getTrackGroups() {
        com.google.android.exoplayer2.util.a.g(this.f26520s);
        return new t9.x((TrackGroup[]) ((ImmutableList) com.google.android.exoplayer2.util.a.e(this.f26511j)).toArray(new TrackGroup[0]));
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public boolean isLoading() {
        return !this.f26517p;
    }

    @Override // com.google.android.exoplayer2.source.n
    public void maybeThrowPrepareError() {
        IOException iOException = this.f26512k;
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // com.google.android.exoplayer2.source.n
    public long readDiscontinuity() {
        if (!this.f26518q) {
            return C.TIME_UNSET;
        }
        this.f26518q = false;
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public void reevaluateBuffer(long j11) {
    }

    @Override // com.google.android.exoplayer2.source.n
    public long seekToUs(long j11) {
        if (getBufferedPositionUs() == 0 && !this.f26523v) {
            this.f26516o = j11;
            return j11;
        }
        discardBuffer(j11, false);
        this.f26514m = j11;
        if (I()) {
            int r02 = this.f26505d.r0();
            if (r02 == 1) {
                return j11;
            }
            if (r02 != 2) {
                throw new IllegalStateException();
            }
            this.f26515n = j11;
            this.f26505d.y0(j11);
            return j11;
        }
        if (O(j11)) {
            return j11;
        }
        this.f26515n = j11;
        this.f26505d.y0(j11);
        for (int i11 = 0; i11 < this.f26506e.size(); i11++) {
            ((e) this.f26506e.get(i11)).h(j11);
        }
        return j11;
    }
}
