package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.r;
import androidx.media3.common.t;
import androidx.media3.datasource.a;
import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.source.s;
import com.google.common.collect.ImmutableList;
import w1.h;

/* loaded from: classes2.dex */
public final class h0 extends androidx.media3.exoplayer.source.a {

    /* renamed from: h, reason: collision with root package name */
    private final w1.h f12879h;

    /* renamed from: i, reason: collision with root package name */
    private final a.InterfaceC0099a f12880i;

    /* renamed from: j, reason: collision with root package name */
    private final androidx.media3.common.r f12881j;

    /* renamed from: k, reason: collision with root package name */
    private final long f12882k;

    /* renamed from: l, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.m f12883l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f12884m;

    /* renamed from: n, reason: collision with root package name */
    private final androidx.media3.common.e0 f12885n;

    /* renamed from: o, reason: collision with root package name */
    private final androidx.media3.common.t f12886o;

    /* renamed from: p, reason: collision with root package name */
    private final com.google.common.base.q f12887p;

    /* renamed from: q, reason: collision with root package name */
    private w1.n f12888q;

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final a.InterfaceC0099a f12889a;

        /* renamed from: b, reason: collision with root package name */
        private androidx.media3.exoplayer.upstream.m f12890b = new androidx.media3.exoplayer.upstream.k();

        /* renamed from: c, reason: collision with root package name */
        private boolean f12891c = true;

        /* renamed from: d, reason: collision with root package name */
        private Object f12892d;

        /* renamed from: e, reason: collision with root package name */
        private String f12893e;

        /* renamed from: f, reason: collision with root package name */
        private com.google.common.base.q f12894f;

        public b(a.InterfaceC0099a interfaceC0099a) {
            this.f12889a = (a.InterfaceC0099a) androidx.media3.common.util.a.e(interfaceC0099a);
        }

        public h0 a(t.k kVar, long j11) {
            return new h0(this.f12893e, kVar, this.f12889a, j11, this.f12890b, this.f12891c, this.f12892d, this.f12894f);
        }

        public b b(androidx.media3.exoplayer.upstream.m mVar) {
            if (mVar == null) {
                mVar = new androidx.media3.exoplayer.upstream.k();
            }
            this.f12890b = mVar;
            return this;
        }
    }

    private h0(String str, t.k kVar, a.InterfaceC0099a interfaceC0099a, long j11, androidx.media3.exoplayer.upstream.m mVar, boolean z10, Object obj, com.google.common.base.q qVar) {
        this.f12880i = interfaceC0099a;
        this.f12882k = j11;
        this.f12883l = mVar;
        this.f12884m = z10;
        androidx.media3.common.t a11 = new t.c().i(Uri.EMPTY).d(kVar.f10411a.toString()).g(ImmutableList.of(kVar)).h(obj).a();
        this.f12886o = a11;
        r.b h02 = new r.b().u0((String) com.google.common.base.h.a(kVar.f10412b, "text/x-unknown")).j0(kVar.f10413c).w0(kVar.f10414d).s0(kVar.f10415e).h0(kVar.f10416f);
        String str2 = kVar.f10417g;
        this.f12881j = h02.f0(str2 == null ? str : str2).N();
        this.f12879h = new h.b().i(kVar.f10411a).b(1).a();
        this.f12885n = new g2.w(j11, true, false, false, null, a11);
        this.f12887p = qVar;
    }

    @Override // androidx.media3.exoplayer.source.a
    protected void B() {
    }

    @Override // androidx.media3.exoplayer.source.r
    public androidx.media3.common.t a() {
        return this.f12886o;
    }

    @Override // androidx.media3.exoplayer.source.r
    public q g(r.b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11) {
        w1.h hVar = this.f12879h;
        a.InterfaceC0099a interfaceC0099a = this.f12880i;
        w1.n nVar = this.f12888q;
        androidx.media3.common.r rVar = this.f12881j;
        long j12 = this.f12882k;
        androidx.media3.exoplayer.upstream.m mVar = this.f12883l;
        s.a u11 = u(bVar);
        boolean z10 = this.f12884m;
        com.google.common.base.q qVar = this.f12887p;
        return new g0(hVar, interfaceC0099a, nVar, rVar, j12, mVar, u11, z10, qVar != null ? (androidx.media3.exoplayer.util.c) qVar.get() : null);
    }

    @Override // androidx.media3.exoplayer.source.r
    public void j(q qVar) {
        ((g0) qVar).j();
    }

    @Override // androidx.media3.exoplayer.source.r
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // androidx.media3.exoplayer.source.a
    protected void z(w1.n nVar) {
        this.f12888q = nVar;
        A(this.f12885n);
    }
}
