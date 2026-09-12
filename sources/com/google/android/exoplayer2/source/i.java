package com.google.android.exoplayer2.source;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.source.d0;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.r;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.v1;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.b0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class i implements o.a {

    /* renamed from: a, reason: collision with root package name */
    private final a f26249a;

    /* renamed from: b, reason: collision with root package name */
    private k.a f26250b;

    /* renamed from: c, reason: collision with root package name */
    private o.a f26251c;

    /* renamed from: d, reason: collision with root package name */
    private com.google.android.exoplayer2.upstream.z f26252d;

    /* renamed from: e, reason: collision with root package name */
    private long f26253e;

    /* renamed from: f, reason: collision with root package name */
    private long f26254f;

    /* renamed from: g, reason: collision with root package name */
    private long f26255g;

    /* renamed from: h, reason: collision with root package name */
    private float f26256h;

    /* renamed from: i, reason: collision with root package name */
    private float f26257i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f26258j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final g9.r f26259a;

        /* renamed from: b, reason: collision with root package name */
        private final Map f26260b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        private final Set f26261c = new HashSet();

        /* renamed from: d, reason: collision with root package name */
        private final Map f26262d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private k.a f26263e;

        /* renamed from: f, reason: collision with root package name */
        private com.google.android.exoplayer2.drm.x f26264f;

        /* renamed from: g, reason: collision with root package name */
        private com.google.android.exoplayer2.upstream.z f26265g;

        public a(g9.r rVar) {
            this.f26259a = rVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ o.a k(k.a aVar) {
            return new x.b(aVar, this.f26259a);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0076  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private com.google.common.base.q l(int r5) {
            /*
                r4 = this;
                java.util.Map r0 = r4.f26260b
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                boolean r0 = r0.containsKey(r1)
                if (r0 == 0) goto L19
                java.util.Map r0 = r4.f26260b
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r5 = r0.get(r5)
                com.google.common.base.q r5 = (com.google.common.base.q) r5
                return r5
            L19:
                com.google.android.exoplayer2.upstream.k$a r0 = r4.f26263e
                java.lang.Object r0 = com.google.android.exoplayer2.util.a.e(r0)
                com.google.android.exoplayer2.upstream.k$a r0 = (com.google.android.exoplayer2.upstream.k.a) r0
                java.lang.Class<com.google.android.exoplayer2.source.o$a> r1 = com.google.android.exoplayer2.source.o.a.class
                r2 = 0
                if (r5 == 0) goto L5f
                r3 = 1
                if (r5 == r3) goto L53
                r3 = 2
                if (r5 == r3) goto L46
                r3 = 3
                if (r5 == r3) goto L3a
                r1 = 4
                if (r5 == r1) goto L33
                goto L6b
            L33:
                com.google.android.exoplayer2.source.h r1 = new com.google.android.exoplayer2.source.h     // Catch: java.lang.ClassNotFoundException -> L6b
                r1.<init>()     // Catch: java.lang.ClassNotFoundException -> L6b
            L38:
                r2 = r1
                goto L6b
            L3a:
                java.lang.Class<com.google.android.exoplayer2.source.rtsp.RtspMediaSource$Factory> r0 = com.google.android.exoplayer2.source.rtsp.RtspMediaSource.Factory.class
                java.lang.Class r0 = r0.asSubclass(r1)     // Catch: java.lang.ClassNotFoundException -> L6b
                com.google.android.exoplayer2.source.g r1 = new com.google.android.exoplayer2.source.g     // Catch: java.lang.ClassNotFoundException -> L6b
                r1.<init>()     // Catch: java.lang.ClassNotFoundException -> L6b
                goto L38
            L46:
                java.lang.Class<com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory> r3 = com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory.class
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch: java.lang.ClassNotFoundException -> L6b
                com.google.android.exoplayer2.source.f r3 = new com.google.android.exoplayer2.source.f     // Catch: java.lang.ClassNotFoundException -> L6b
                r3.<init>()     // Catch: java.lang.ClassNotFoundException -> L6b
            L51:
                r2 = r3
                goto L6b
            L53:
                java.lang.Class<com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory> r3 = com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory.class
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch: java.lang.ClassNotFoundException -> L6b
                com.google.android.exoplayer2.source.e r3 = new com.google.android.exoplayer2.source.e     // Catch: java.lang.ClassNotFoundException -> L6b
                r3.<init>()     // Catch: java.lang.ClassNotFoundException -> L6b
                goto L51
            L5f:
                java.lang.Class<com.google.android.exoplayer2.source.dash.DashMediaSource$Factory> r3 = com.google.android.exoplayer2.source.dash.DashMediaSource.Factory.class
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch: java.lang.ClassNotFoundException -> L6b
                com.google.android.exoplayer2.source.d r3 = new com.google.android.exoplayer2.source.d     // Catch: java.lang.ClassNotFoundException -> L6b
                r3.<init>()     // Catch: java.lang.ClassNotFoundException -> L6b
                goto L51
            L6b:
                java.util.Map r0 = r4.f26260b
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                r0.put(r1, r2)
                if (r2 == 0) goto L7f
                java.util.Set r0 = r4.f26261c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                r0.add(r5)
            L7f:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.i.a.l(int):com.google.common.base.q");
        }

        public o.a f(int i11) {
            o.a aVar = (o.a) this.f26262d.get(Integer.valueOf(i11));
            if (aVar != null) {
                return aVar;
            }
            com.google.common.base.q l11 = l(i11);
            if (l11 == null) {
                return null;
            }
            o.a aVar2 = (o.a) l11.get();
            com.google.android.exoplayer2.drm.x xVar = this.f26264f;
            if (xVar != null) {
                aVar2.b(xVar);
            }
            com.google.android.exoplayer2.upstream.z zVar = this.f26265g;
            if (zVar != null) {
                aVar2.c(zVar);
            }
            this.f26262d.put(Integer.valueOf(i11), aVar2);
            return aVar2;
        }

        public void m(k.a aVar) {
            if (aVar != this.f26263e) {
                this.f26263e = aVar;
                this.f26260b.clear();
                this.f26262d.clear();
            }
        }

        public void n(com.google.android.exoplayer2.drm.x xVar) {
            this.f26264f = xVar;
            Iterator it = this.f26262d.values().iterator();
            while (it.hasNext()) {
                ((o.a) it.next()).b(xVar);
            }
        }

        public void o(com.google.android.exoplayer2.upstream.z zVar) {
            this.f26265g = zVar;
            Iterator it = this.f26262d.values().iterator();
            while (it.hasNext()) {
                ((o.a) it.next()).c(zVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b implements g9.l {

        /* renamed from: a, reason: collision with root package name */
        private final o1 f26266a;

        public b(o1 o1Var) {
            this.f26266a = o1Var;
        }

        @Override // g9.l
        public void b(g9.n nVar) {
            g9.e0 track = nVar.track(0, 3);
            nVar.d(new b0.b(C.TIME_UNSET));
            nVar.endTracks();
            track.e(this.f26266a.b().e0("text/x-unknown").I(this.f26266a.f25550l).E());
        }

        @Override // g9.l
        public int c(g9.m mVar, g9.a0 a0Var) {
            return mVar.skip(Integer.MAX_VALUE) == -1 ? -1 : 0;
        }

        @Override // g9.l
        public boolean d(g9.m mVar) {
            return true;
        }

        @Override // g9.l
        public void release() {
        }

        @Override // g9.l
        public void seek(long j11, long j12) {
        }
    }

    public i(Context context, g9.r rVar) {
        this(new r.a(context), rVar);
    }

    public i(k.a aVar, g9.r rVar) {
        this.f26250b = aVar;
        a aVar2 = new a(rVar);
        this.f26249a = aVar2;
        aVar2.m(aVar);
        this.f26253e = C.TIME_UNSET;
        this.f26254f = C.TIME_UNSET;
        this.f26255g = C.TIME_UNSET;
        this.f26256h = -3.4028235E38f;
        this.f26257i = -3.4028235E38f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ o.a e(Class cls) {
        return j(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ o.a f(Class cls, k.a aVar) {
        return k(cls, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ g9.l[] g(o1 o1Var) {
        ba.k kVar = ba.k.f16380a;
        return new g9.l[]{kVar.a(o1Var) ? new ba.l(kVar.b(o1Var), o1Var) : new b(o1Var)};
    }

    private static o h(v1 v1Var, o oVar) {
        v1.d dVar = v1Var.f27767f;
        long j11 = dVar.f27784a;
        if (j11 == 0 && dVar.f27785b == Long.MIN_VALUE && !dVar.f27787d) {
            return oVar;
        }
        long B0 = p0.B0(j11);
        long B02 = p0.B0(v1Var.f27767f.f27785b);
        v1.d dVar2 = v1Var.f27767f;
        return new ClippingMediaSource(oVar, B0, B02, !dVar2.f27788e, dVar2.f27786c, dVar2.f27787d);
    }

    private o i(v1 v1Var, o oVar) {
        com.google.android.exoplayer2.util.a.e(v1Var.f27763b);
        v1Var.f27763b.getClass();
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static o.a j(Class cls) {
        try {
            return (o.a) cls.getConstructor(null).newInstance(null);
        } catch (Exception e11) {
            throw new IllegalStateException(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static o.a k(Class cls, k.a aVar) {
        try {
            return (o.a) cls.getConstructor(k.a.class).newInstance(aVar);
        } catch (Exception e11) {
            throw new IllegalStateException(e11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.source.o.a
    public o a(v1 v1Var) {
        com.google.android.exoplayer2.util.a.e(v1Var.f27763b);
        String scheme = v1Var.f27763b.f27826a.getScheme();
        if (scheme != null && scheme.equals("ssai")) {
            return ((o.a) com.google.android.exoplayer2.util.a.e(this.f26251c)).a(v1Var);
        }
        v1.h hVar = v1Var.f27763b;
        int q02 = p0.q0(hVar.f27826a, hVar.f27827b);
        o.a f11 = this.f26249a.f(q02);
        com.google.android.exoplayer2.util.a.j(f11, "No suitable media source factory found for content type: " + q02);
        v1.g.a b11 = v1Var.f27765d.b();
        if (v1Var.f27765d.f27816a == C.TIME_UNSET) {
            b11.k(this.f26253e);
        }
        if (v1Var.f27765d.f27819d == -3.4028235E38f) {
            b11.j(this.f26256h);
        }
        if (v1Var.f27765d.f27820e == -3.4028235E38f) {
            b11.h(this.f26257i);
        }
        if (v1Var.f27765d.f27817b == C.TIME_UNSET) {
            b11.i(this.f26254f);
        }
        if (v1Var.f27765d.f27818c == C.TIME_UNSET) {
            b11.g(this.f26255g);
        }
        v1.g f12 = b11.f();
        if (!f12.equals(v1Var.f27765d)) {
            v1Var = v1Var.b().c(f12).a();
        }
        o a11 = f11.a(v1Var);
        ImmutableList immutableList = ((v1.h) p0.j(v1Var.f27763b)).f27831f;
        if (!immutableList.isEmpty()) {
            o[] oVarArr = new o[immutableList.size() + 1];
            oVarArr[0] = a11;
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                if (this.f26258j) {
                    final o1 E = new o1.b().e0(((v1.l) immutableList.get(i11)).f27843b).V(((v1.l) immutableList.get(i11)).f27844c).g0(((v1.l) immutableList.get(i11)).f27845d).c0(((v1.l) immutableList.get(i11)).f27846e).U(((v1.l) immutableList.get(i11)).f27847f).S(((v1.l) immutableList.get(i11)).f27848g).E();
                    x.b bVar = new x.b(this.f26250b, new g9.r() { // from class: t9.f
                        @Override // g9.r
                        public /* synthetic */ g9.l[] c(Uri uri, Map map) {
                            return g9.q.a(this, uri, map);
                        }

                        @Override // g9.r
                        public final g9.l[] createExtractors() {
                            g9.l[] g11;
                            g11 = com.google.android.exoplayer2.source.i.g(o1.this);
                            return g11;
                        }
                    });
                    com.google.android.exoplayer2.upstream.z zVar = this.f26252d;
                    if (zVar != null) {
                        bVar.c(zVar);
                    }
                    oVarArr[i11 + 1] = bVar.a(v1.e(((v1.l) immutableList.get(i11)).f27842a.toString()));
                } else {
                    d0.b bVar2 = new d0.b(this.f26250b);
                    com.google.android.exoplayer2.upstream.z zVar2 = this.f26252d;
                    if (zVar2 != null) {
                        bVar2.b(zVar2);
                    }
                    oVarArr[i11 + 1] = bVar2.a((v1.l) immutableList.get(i11), C.TIME_UNSET);
                }
            }
            a11 = new MergingMediaSource(oVarArr);
        }
        return i(v1Var, h(v1Var, a11));
    }

    @Override // com.google.android.exoplayer2.source.o.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public i b(com.google.android.exoplayer2.drm.x xVar) {
        this.f26249a.n((com.google.android.exoplayer2.drm.x) com.google.android.exoplayer2.util.a.f(xVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior."));
        return this;
    }

    @Override // com.google.android.exoplayer2.source.o.a
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public i c(com.google.android.exoplayer2.upstream.z zVar) {
        this.f26252d = (com.google.android.exoplayer2.upstream.z) com.google.android.exoplayer2.util.a.f(zVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.f26249a.o(zVar);
        return this;
    }
}
