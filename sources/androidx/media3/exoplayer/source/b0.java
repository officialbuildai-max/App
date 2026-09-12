package androidx.media3.exoplayer.source;

import android.net.Uri;
import android.os.Looper;
import androidx.media3.common.e0;
import androidx.media3.common.t;
import androidx.media3.common.util.a1;
import androidx.media3.datasource.a;
import androidx.media3.exoplayer.drm.r;
import androidx.media3.exoplayer.source.a0;
import androidx.media3.exoplayer.source.b0;
import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.source.s;
import androidx.media3.exoplayer.source.v;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import i3.s;
import java.util.Objects;
import l2.m0;
import y1.f4;

/* loaded from: classes2.dex */
public final class b0 extends androidx.media3.exoplayer.source.a implements a0.c {

    /* renamed from: h, reason: collision with root package name */
    private final a.InterfaceC0099a f12774h;

    /* renamed from: i, reason: collision with root package name */
    private final v.a f12775i;

    /* renamed from: j, reason: collision with root package name */
    private final androidx.media3.exoplayer.drm.t f12776j;

    /* renamed from: k, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.m f12777k;

    /* renamed from: l, reason: collision with root package name */
    private final int f12778l;

    /* renamed from: m, reason: collision with root package name */
    private final int f12779m;

    /* renamed from: n, reason: collision with root package name */
    private final androidx.media3.common.r f12780n;

    /* renamed from: o, reason: collision with root package name */
    private final com.google.common.base.q f12781o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f12782p;

    /* renamed from: q, reason: collision with root package name */
    private long f12783q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f12784r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f12785s;

    /* renamed from: t, reason: collision with root package name */
    private w1.n f12786t;

    /* renamed from: u, reason: collision with root package name */
    private androidx.media3.common.t f12787u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends m {
        a(androidx.media3.common.e0 e0Var) {
            super(e0Var);
        }

        @Override // androidx.media3.exoplayer.source.m, androidx.media3.common.e0
        public e0.b g(int i11, e0.b bVar, boolean z10) {
            super.g(i11, bVar, z10);
            bVar.f10021f = true;
            return bVar;
        }

        @Override // androidx.media3.exoplayer.source.m, androidx.media3.common.e0
        public e0.c o(int i11, e0.c cVar, long j11) {
            super.o(i11, cVar, j11);
            cVar.f10043k = true;
            return cVar;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements r.a {

        /* renamed from: a, reason: collision with root package name */
        private final a.InterfaceC0099a f12789a;

        /* renamed from: b, reason: collision with root package name */
        private v.a f12790b;

        /* renamed from: c, reason: collision with root package name */
        private androidx.media3.exoplayer.drm.w f12791c;

        /* renamed from: d, reason: collision with root package name */
        private androidx.media3.exoplayer.upstream.m f12792d;

        /* renamed from: e, reason: collision with root package name */
        private int f12793e;

        /* renamed from: f, reason: collision with root package name */
        private com.google.common.base.q f12794f;

        /* renamed from: g, reason: collision with root package name */
        private int f12795g;

        /* renamed from: h, reason: collision with root package name */
        private androidx.media3.common.r f12796h;

        public b(a.InterfaceC0099a interfaceC0099a) {
            this(interfaceC0099a, new l2.m());
        }

        public b(a.InterfaceC0099a interfaceC0099a, v.a aVar) {
            this(interfaceC0099a, aVar, new androidx.media3.exoplayer.drm.j(), new androidx.media3.exoplayer.upstream.k(), 1048576);
        }

        public b(a.InterfaceC0099a interfaceC0099a, v.a aVar, androidx.media3.exoplayer.drm.w wVar, androidx.media3.exoplayer.upstream.m mVar, int i11) {
            this.f12789a = interfaceC0099a;
            this.f12790b = aVar;
            this.f12791c = wVar;
            this.f12792d = mVar;
            this.f12793e = i11;
        }

        public b(a.InterfaceC0099a interfaceC0099a, final l2.x xVar) {
            this(interfaceC0099a, new v.a() { // from class: g2.t
                @Override // androidx.media3.exoplayer.source.v.a
                public final androidx.media3.exoplayer.source.v a(f4 f4Var) {
                    androidx.media3.exoplayer.source.v j11;
                    j11 = b0.b.j(l2.x.this, f4Var);
                    return j11;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ v j(l2.x xVar, f4 f4Var) {
            return new g2.b(xVar);
        }

        @Override // androidx.media3.exoplayer.source.r.a
        public /* synthetic */ r.a a(s.a aVar) {
            return g2.l.c(this, aVar);
        }

        @Override // androidx.media3.exoplayer.source.r.a
        public /* synthetic */ r.a b(int i11) {
            return g2.l.b(this, i11);
        }

        @Override // androidx.media3.exoplayer.source.r.a
        public /* synthetic */ r.a c(boolean z10) {
            return g2.l.a(this, z10);
        }

        @Override // androidx.media3.exoplayer.source.r.a
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public b0 d(androidx.media3.common.t tVar) {
            androidx.media3.common.util.a.e(tVar.f10293b);
            return new b0(tVar, this.f12789a, this.f12790b, this.f12791c.a(tVar), this.f12792d, this.f12793e, this.f12795g, this.f12796h, this.f12794f, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b i(int i11, androidx.media3.common.r rVar) {
            this.f12795g = i11;
            this.f12796h = (androidx.media3.common.r) androidx.media3.common.util.a.e(rVar);
            return this;
        }

        @Override // androidx.media3.exoplayer.source.r.a
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public b e(androidx.media3.exoplayer.drm.w wVar) {
            this.f12791c = (androidx.media3.exoplayer.drm.w) androidx.media3.common.util.a.f(wVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // androidx.media3.exoplayer.source.r.a
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public b f(androidx.media3.exoplayer.upstream.m mVar) {
            this.f12792d = (androidx.media3.exoplayer.upstream.m) androidx.media3.common.util.a.f(mVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }
    }

    private b0(androidx.media3.common.t tVar, a.InterfaceC0099a interfaceC0099a, v.a aVar, androidx.media3.exoplayer.drm.t tVar2, androidx.media3.exoplayer.upstream.m mVar, int i11, int i12, androidx.media3.common.r rVar, com.google.common.base.q qVar) {
        this.f12787u = tVar;
        this.f12774h = interfaceC0099a;
        this.f12775i = aVar;
        this.f12776j = tVar2;
        this.f12777k = mVar;
        this.f12778l = i11;
        this.f12780n = rVar;
        this.f12779m = i12;
        this.f12782p = true;
        this.f12783q = C.TIME_UNSET;
        this.f12781o = qVar;
    }

    /* synthetic */ b0(androidx.media3.common.t tVar, a.InterfaceC0099a interfaceC0099a, v.a aVar, androidx.media3.exoplayer.drm.t tVar2, androidx.media3.exoplayer.upstream.m mVar, int i11, int i12, androidx.media3.common.r rVar, com.google.common.base.q qVar, a aVar2) {
        this(tVar, interfaceC0099a, aVar, tVar2, mVar, i11, i12, rVar, qVar);
    }

    private t.h C() {
        return (t.h) androidx.media3.common.util.a.e(a().f10293b);
    }

    private void D() {
        androidx.media3.common.e0 wVar = new g2.w(this.f12783q, this.f12784r, false, this.f12785s, null, a());
        if (this.f12782p) {
            wVar = new a(wVar);
        }
        A(wVar);
    }

    @Override // androidx.media3.exoplayer.source.a
    protected void B() {
        this.f12776j.release();
    }

    @Override // androidx.media3.exoplayer.source.r
    public synchronized androidx.media3.common.t a() {
        return this.f12787u;
    }

    @Override // androidx.media3.exoplayer.source.r
    public q g(r.b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11) {
        androidx.media3.datasource.a createDataSource = this.f12774h.createDataSource();
        w1.n nVar = this.f12786t;
        if (nVar != null) {
            createDataSource.c(nVar);
        }
        t.h C = C();
        Uri uri = C.f10385a;
        v a11 = this.f12775i.a(x());
        androidx.media3.exoplayer.drm.t tVar = this.f12776j;
        r.a s11 = s(bVar);
        androidx.media3.exoplayer.upstream.m mVar = this.f12777k;
        s.a u11 = u(bVar);
        String str = C.f10389e;
        int i11 = this.f12778l;
        int i12 = this.f12779m;
        androidx.media3.common.r rVar = this.f12780n;
        long R0 = a1.R0(C.f10393i);
        com.google.common.base.q qVar = this.f12781o;
        return new a0(uri, createDataSource, a11, tVar, s11, mVar, u11, this, bVar2, str, i11, i12, rVar, R0, qVar != null ? (androidx.media3.exoplayer.util.c) qVar.get() : null);
    }

    @Override // androidx.media3.exoplayer.source.r
    public void j(q qVar) {
        ((a0) qVar).W();
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.r
    public synchronized void l(androidx.media3.common.t tVar) {
        this.f12787u = tVar;
    }

    @Override // androidx.media3.exoplayer.source.r
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // androidx.media3.exoplayer.source.a0.c
    public void p(long j11, m0 m0Var, boolean z10) {
        if (j11 == C.TIME_UNSET) {
            j11 = this.f12783q;
        }
        boolean isSeekable = m0Var.isSeekable();
        if (!this.f12782p && this.f12783q == j11 && this.f12784r == isSeekable && this.f12785s == z10) {
            return;
        }
        this.f12783q = j11;
        this.f12784r = isSeekable;
        this.f12785s = z10;
        this.f12782p = false;
        D();
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.r
    public boolean q(androidx.media3.common.t tVar) {
        t.h C = C();
        t.h hVar = tVar.f10293b;
        return hVar != null && hVar.f10385a.equals(C.f10385a) && hVar.f10393i == C.f10393i && Objects.equals(hVar.f10389e, C.f10389e);
    }

    @Override // androidx.media3.exoplayer.source.a
    protected void z(w1.n nVar) {
        this.f12786t = nVar;
        this.f12776j.c((Looper) androidx.media3.common.util.a.e(Looper.myLooper()), x());
        this.f12776j.prepare();
        D();
    }
}
