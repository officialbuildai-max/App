package androidx.media3.exoplayer.source;

import android.content.Context;
import android.net.Uri;
import androidx.media3.common.r;
import androidx.media3.common.t;
import androidx.media3.common.util.a1;
import androidx.media3.datasource.a;
import androidx.media3.datasource.b;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.hls.HlsMediaSource;
import androidx.media3.exoplayer.source.ClippingMediaSource;
import androidx.media3.exoplayer.source.b0;
import androidx.media3.exoplayer.source.h0;
import androidx.media3.exoplayer.source.i;
import androidx.media3.exoplayer.source.l;
import androidx.media3.exoplayer.source.r;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import i3.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import l2.m0;
import l2.s0;

/* loaded from: classes2.dex */
public final class i implements r.a {

    /* renamed from: a, reason: collision with root package name */
    private final a f12895a;

    /* renamed from: b, reason: collision with root package name */
    private a.InterfaceC0099a f12896b;

    /* renamed from: c, reason: collision with root package name */
    private s.a f12897c;

    /* renamed from: d, reason: collision with root package name */
    private r.a f12898d;

    /* renamed from: e, reason: collision with root package name */
    private androidx.media3.exoplayer.upstream.m f12899e;

    /* renamed from: f, reason: collision with root package name */
    private long f12900f;

    /* renamed from: g, reason: collision with root package name */
    private long f12901g;

    /* renamed from: h, reason: collision with root package name */
    private long f12902h;

    /* renamed from: i, reason: collision with root package name */
    private float f12903i;

    /* renamed from: j, reason: collision with root package name */
    private float f12904j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f12905k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final l2.x f12906a;

        /* renamed from: d, reason: collision with root package name */
        private a.InterfaceC0099a f12909d;

        /* renamed from: f, reason: collision with root package name */
        private s.a f12911f;

        /* renamed from: g, reason: collision with root package name */
        private int f12912g;

        /* renamed from: h, reason: collision with root package name */
        private androidx.media3.exoplayer.drm.w f12913h;

        /* renamed from: i, reason: collision with root package name */
        private androidx.media3.exoplayer.upstream.m f12914i;

        /* renamed from: b, reason: collision with root package name */
        private final Map f12907b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        private final Map f12908c = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private boolean f12910e = true;

        public a(l2.x xVar, s.a aVar) {
            this.f12906a = xVar;
            this.f12911f = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ r.a k(a.InterfaceC0099a interfaceC0099a) {
            return new b0.b(interfaceC0099a, this.f12906a);
        }

        private com.google.common.base.q l(int i11) {
            com.google.common.base.q qVar;
            com.google.common.base.q qVar2;
            com.google.common.base.q qVar3 = (com.google.common.base.q) this.f12907b.get(Integer.valueOf(i11));
            if (qVar3 != null) {
                return qVar3;
            }
            final a.InterfaceC0099a interfaceC0099a = (a.InterfaceC0099a) androidx.media3.common.util.a.e(this.f12909d);
            if (i11 == 0) {
                final Class asSubclass = DashMediaSource.Factory.class.asSubclass(r.a.class);
                qVar = new com.google.common.base.q() { // from class: androidx.media3.exoplayer.source.d
                    @Override // com.google.common.base.q
                    public final Object get() {
                        r.a i12;
                        i12 = i.i(asSubclass, interfaceC0099a);
                        return i12;
                    }
                };
            } else if (i11 == 1) {
                final Class<? extends U> asSubclass2 = Class.forName("androidx.media3.exoplayer.smoothstreaming.SsMediaSource$Factory").asSubclass(r.a.class);
                qVar = new com.google.common.base.q() { // from class: androidx.media3.exoplayer.source.e
                    @Override // com.google.common.base.q
                    public final Object get() {
                        r.a i12;
                        i12 = i.i(asSubclass2, interfaceC0099a);
                        return i12;
                    }
                };
            } else {
                if (i11 != 2) {
                    if (i11 == 3) {
                        final Class<? extends U> asSubclass3 = Class.forName("androidx.media3.exoplayer.rtsp.RtspMediaSource$Factory").asSubclass(r.a.class);
                        qVar2 = new com.google.common.base.q() { // from class: androidx.media3.exoplayer.source.g
                            @Override // com.google.common.base.q
                            public final Object get() {
                                r.a h11;
                                h11 = i.h(asSubclass3);
                                return h11;
                            }
                        };
                    } else {
                        if (i11 != 4) {
                            throw new IllegalArgumentException("Unrecognized contentType: " + i11);
                        }
                        qVar2 = new com.google.common.base.q() { // from class: androidx.media3.exoplayer.source.h
                            @Override // com.google.common.base.q
                            public final Object get() {
                                r.a k11;
                                k11 = i.a.this.k(interfaceC0099a);
                                return k11;
                            }
                        };
                    }
                    this.f12907b.put(Integer.valueOf(i11), qVar2);
                    return qVar2;
                }
                final Class asSubclass4 = HlsMediaSource.Factory.class.asSubclass(r.a.class);
                qVar = new com.google.common.base.q() { // from class: androidx.media3.exoplayer.source.f
                    @Override // com.google.common.base.q
                    public final Object get() {
                        r.a i12;
                        i12 = i.i(asSubclass4, interfaceC0099a);
                        return i12;
                    }
                };
            }
            qVar2 = qVar;
            this.f12907b.put(Integer.valueOf(i11), qVar2);
            return qVar2;
        }

        public r.a f(int i11) {
            r.a aVar = (r.a) this.f12908c.get(Integer.valueOf(i11));
            if (aVar != null) {
                return aVar;
            }
            r.a aVar2 = (r.a) l(i11).get();
            androidx.media3.exoplayer.drm.w wVar = this.f12913h;
            if (wVar != null) {
                aVar2.e(wVar);
            }
            androidx.media3.exoplayer.upstream.m mVar = this.f12914i;
            if (mVar != null) {
                aVar2.f(mVar);
            }
            aVar2.a(this.f12911f);
            aVar2.c(this.f12910e);
            aVar2.b(this.f12912g);
            this.f12908c.put(Integer.valueOf(i11), aVar2);
            return aVar2;
        }

        public void m(int i11) {
            this.f12912g = i11;
            this.f12906a.b(i11);
        }

        public void n(a.InterfaceC0099a interfaceC0099a) {
            if (interfaceC0099a != this.f12909d) {
                this.f12909d = interfaceC0099a;
                this.f12907b.clear();
                this.f12908c.clear();
            }
        }

        public void o(androidx.media3.exoplayer.drm.w wVar) {
            this.f12913h = wVar;
            Iterator it = this.f12908c.values().iterator();
            while (it.hasNext()) {
                ((r.a) it.next()).e(wVar);
            }
        }

        public void p(int i11) {
            l2.x xVar = this.f12906a;
            if (xVar instanceof l2.m) {
                ((l2.m) xVar).l(i11);
            }
        }

        public void q(androidx.media3.exoplayer.upstream.m mVar) {
            this.f12914i = mVar;
            Iterator it = this.f12908c.values().iterator();
            while (it.hasNext()) {
                ((r.a) it.next()).f(mVar);
            }
        }

        public void r(boolean z10) {
            this.f12910e = z10;
            this.f12906a.d(z10);
            Iterator it = this.f12908c.values().iterator();
            while (it.hasNext()) {
                ((r.a) it.next()).c(z10);
            }
        }

        public void s(s.a aVar) {
            this.f12911f = aVar;
            this.f12906a.a(aVar);
            Iterator it = this.f12908c.values().iterator();
            while (it.hasNext()) {
                ((r.a) it.next()).a(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements l2.r {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.media3.common.r f12915a;

        public b(androidx.media3.common.r rVar) {
            this.f12915a = rVar;
        }

        @Override // l2.r
        public void b(l2.t tVar) {
            s0 track = tVar.track(0, 3);
            tVar.f(new m0.b(C.TIME_UNSET));
            tVar.endTracks();
            track.c(this.f12915a.b().u0("text/x-unknown").S(this.f12915a.f10243o).N());
        }

        @Override // l2.r
        public int c(l2.s sVar, l2.l0 l0Var) {
            return sVar.skip(Integer.MAX_VALUE) == -1 ? -1 : 0;
        }

        @Override // l2.r
        public boolean d(l2.s sVar) {
            return true;
        }

        @Override // l2.r
        public /* synthetic */ l2.r e() {
            return l2.q.b(this);
        }

        @Override // l2.r
        public /* synthetic */ List f() {
            return l2.q.a(this);
        }

        @Override // l2.r
        public void release() {
        }

        @Override // l2.r
        public void seek(long j11, long j12) {
        }
    }

    public i(Context context) {
        this(new b.a(context));
    }

    public i(Context context, l2.x xVar) {
        this(new b.a(context), xVar);
    }

    public i(a.InterfaceC0099a interfaceC0099a) {
        this(interfaceC0099a, new l2.m());
    }

    public i(a.InterfaceC0099a interfaceC0099a, l2.x xVar) {
        this.f12896b = interfaceC0099a;
        i3.h hVar = new i3.h();
        this.f12897c = hVar;
        a aVar = new a(xVar, hVar);
        this.f12895a = aVar;
        aVar.n(interfaceC0099a);
        this.f12900f = C.TIME_UNSET;
        this.f12901g = C.TIME_UNSET;
        this.f12902h = C.TIME_UNSET;
        this.f12903i = -3.4028235E38f;
        this.f12904j = -3.4028235E38f;
        this.f12905k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ r.a h(Class cls) {
        return o(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ r.a i(Class cls, a.InterfaceC0099a interfaceC0099a) {
        return p(cls, interfaceC0099a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ l2.r[] l(androidx.media3.common.r rVar) {
        return new l2.r[]{this.f12897c.a(rVar) ? new i3.n(this.f12897c.c(rVar), null) : new b(rVar)};
    }

    private static r m(androidx.media3.common.t tVar, r rVar) {
        t.d dVar = tVar.f10297f;
        return (dVar.f10322b == 0 && dVar.f10324d == Long.MIN_VALUE && !dVar.f10326f) ? rVar : new ClippingMediaSource.b(rVar).m(tVar.f10297f.f10322b).k(tVar.f10297f.f10324d).j(!tVar.f10297f.f10327g).i(tVar.f10297f.f10325e).l(tVar.f10297f.f10326f).h();
    }

    private r n(androidx.media3.common.t tVar, r rVar) {
        androidx.media3.common.util.a.e(tVar.f10293b);
        tVar.f10293b.getClass();
        return rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static r.a o(Class cls) {
        try {
            return (r.a) cls.getConstructor(null).newInstance(null);
        } catch (Exception e11) {
            throw new IllegalStateException(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static r.a p(Class cls, a.InterfaceC0099a interfaceC0099a) {
        try {
            return (r.a) cls.getConstructor(a.InterfaceC0099a.class).newInstance(interfaceC0099a);
        } catch (Exception e11) {
            throw new IllegalStateException(e11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.r.a
    public r d(androidx.media3.common.t tVar) {
        androidx.media3.common.util.a.e(tVar.f10293b);
        String scheme = tVar.f10293b.f10385a.getScheme();
        if (scheme != null && scheme.equals("ssai")) {
            return ((r.a) androidx.media3.common.util.a.e(this.f12898d)).d(tVar);
        }
        if (Objects.equals(tVar.f10293b.f10386b, "application/x-image-uri")) {
            long R0 = a1.R0(tVar.f10293b.f10393i);
            android.support.v4.media.session.c.a(androidx.media3.common.util.a.e(null));
            return new l.b(R0, null).d(tVar);
        }
        t.h hVar = tVar.f10293b;
        int A0 = a1.A0(hVar.f10385a, hVar.f10386b);
        if (tVar.f10293b.f10393i != C.TIME_UNSET) {
            this.f12895a.p(1);
        }
        try {
            r.a f11 = this.f12895a.f(A0);
            t.g.a a11 = tVar.f10295d.a();
            if (tVar.f10295d.f10367a == C.TIME_UNSET) {
                a11.k(this.f12900f);
            }
            if (tVar.f10295d.f10370d == -3.4028235E38f) {
                a11.j(this.f12903i);
            }
            if (tVar.f10295d.f10371e == -3.4028235E38f) {
                a11.h(this.f12904j);
            }
            if (tVar.f10295d.f10368b == C.TIME_UNSET) {
                a11.i(this.f12901g);
            }
            if (tVar.f10295d.f10369c == C.TIME_UNSET) {
                a11.g(this.f12902h);
            }
            t.g f12 = a11.f();
            if (!f12.equals(tVar.f10295d)) {
                tVar = tVar.a().c(f12).a();
            }
            r d11 = f11.d(tVar);
            ImmutableList immutableList = ((t.h) a1.i(tVar.f10293b)).f10390f;
            if (!immutableList.isEmpty()) {
                r[] rVarArr = new r[immutableList.size() + 1];
                rVarArr[0] = d11;
                for (int i11 = 0; i11 < immutableList.size(); i11++) {
                    if (this.f12905k) {
                        final androidx.media3.common.r N = new r.b().u0(((t.k) immutableList.get(i11)).f10412b).j0(((t.k) immutableList.get(i11)).f10413c).w0(((t.k) immutableList.get(i11)).f10414d).s0(((t.k) immutableList.get(i11)).f10415e).h0(((t.k) immutableList.get(i11)).f10416f).f0(((t.k) immutableList.get(i11)).f10417g).N();
                        b0.b bVar = new b0.b(this.f12896b, new l2.x() { // from class: g2.g
                            @Override // l2.x
                            public /* synthetic */ l2.x a(s.a aVar) {
                                return l2.w.d(this, aVar);
                            }

                            @Override // l2.x
                            public /* synthetic */ l2.x b(int i12) {
                                return l2.w.b(this, i12);
                            }

                            @Override // l2.x
                            public /* synthetic */ l2.r[] c(Uri uri, Map map) {
                                return l2.w.a(this, uri, map);
                            }

                            @Override // l2.x
                            public final l2.r[] createExtractors() {
                                l2.r[] l11;
                                l11 = androidx.media3.exoplayer.source.i.this.l(N);
                                return l11;
                            }

                            @Override // l2.x
                            public /* synthetic */ l2.x d(boolean z10) {
                                return l2.w.c(this, z10);
                            }
                        });
                        if (this.f12897c.a(N)) {
                            N = N.b().u0("application/x-media3-cues").S(N.f10243o).W(this.f12897c.b(N)).N();
                        }
                        b0.b i12 = bVar.i(0, N);
                        androidx.media3.exoplayer.upstream.m mVar = this.f12899e;
                        if (mVar != null) {
                            i12.f(mVar);
                        }
                        rVarArr[i11 + 1] = i12.d(androidx.media3.common.t.b(((t.k) immutableList.get(i11)).f10411a.toString()));
                    } else {
                        h0.b bVar2 = new h0.b(this.f12896b);
                        androidx.media3.exoplayer.upstream.m mVar2 = this.f12899e;
                        if (mVar2 != null) {
                            bVar2.b(mVar2);
                        }
                        rVarArr[i11 + 1] = bVar2.a((t.k) immutableList.get(i11), C.TIME_UNSET);
                    }
                }
                d11 = new MergingMediaSource(rVarArr);
            }
            return n(tVar, m(tVar, d11));
        } catch (ClassNotFoundException e11) {
            throw new IllegalStateException(e11);
        }
    }

    @Override // androidx.media3.exoplayer.source.r.a
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public i c(boolean z10) {
        this.f12905k = z10;
        this.f12895a.r(z10);
        return this;
    }

    @Override // androidx.media3.exoplayer.source.r.a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public i b(int i11) {
        this.f12895a.m(i11);
        return this;
    }

    public i q(a.InterfaceC0099a interfaceC0099a) {
        this.f12896b = interfaceC0099a;
        this.f12895a.n(interfaceC0099a);
        return this;
    }

    @Override // androidx.media3.exoplayer.source.r.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public i e(androidx.media3.exoplayer.drm.w wVar) {
        this.f12895a.o((androidx.media3.exoplayer.drm.w) androidx.media3.common.util.a.f(wVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior."));
        return this;
    }

    @Override // androidx.media3.exoplayer.source.r.a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public i f(androidx.media3.exoplayer.upstream.m mVar) {
        this.f12899e = (androidx.media3.exoplayer.upstream.m) androidx.media3.common.util.a.f(mVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.f12895a.q(mVar);
        return this;
    }

    @Override // androidx.media3.exoplayer.source.r.a
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public i a(s.a aVar) {
        this.f12897c = (s.a) androidx.media3.common.util.a.e(aVar);
        this.f12895a.s(aVar);
        return this;
    }
}
