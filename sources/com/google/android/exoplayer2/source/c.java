package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.util.p0;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class c extends com.google.android.exoplayer2.source.a {

    /* renamed from: h, reason: collision with root package name */
    private final HashMap f25780h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    private Handler f25781i;

    /* renamed from: j, reason: collision with root package name */
    private k0 f25782j;

    /* loaded from: classes3.dex */
    private final class a implements p, com.google.android.exoplayer2.drm.s {

        /* renamed from: a, reason: collision with root package name */
        private final Object f25783a;

        /* renamed from: b, reason: collision with root package name */
        private p.a f25784b;

        /* renamed from: c, reason: collision with root package name */
        private s.a f25785c;

        public a(Object obj) {
            this.f25784b = c.this.v(null);
            this.f25785c = c.this.t(null);
            this.f25783a = obj;
        }

        private boolean G(int i11, o.b bVar) {
            o.b bVar2;
            if (bVar != null) {
                bVar2 = c.this.F(this.f25783a, bVar);
                if (bVar2 == null) {
                    return false;
                }
            } else {
                bVar2 = null;
            }
            int H = c.this.H(this.f25783a, i11);
            p.a aVar = this.f25784b;
            if (aVar.f26295a != H || !p0.c(aVar.f26296b, bVar2)) {
                this.f25784b = c.this.u(H, bVar2, 0L);
            }
            s.a aVar2 = this.f25785c;
            if (aVar2.f25066a == H && p0.c(aVar2.f25067b, bVar2)) {
                return true;
            }
            this.f25785c = c.this.s(H, bVar2);
            return true;
        }

        private t9.i H(t9.i iVar) {
            long G = c.this.G(this.f25783a, iVar.f76235f);
            long G2 = c.this.G(this.f25783a, iVar.f76236g);
            return (G == iVar.f76235f && G2 == iVar.f76236g) ? iVar : new t9.i(iVar.f76230a, iVar.f76231b, iVar.f76232c, iVar.f76233d, iVar.f76234e, G, G2);
        }

        @Override // com.google.android.exoplayer2.drm.s
        public void B(int i11, o.b bVar) {
            if (G(i11, bVar)) {
                this.f25785c.h();
            }
        }

        @Override // com.google.android.exoplayer2.drm.s
        public void D(int i11, o.b bVar, int i12) {
            if (G(i11, bVar)) {
                this.f25785c.k(i12);
            }
        }

        @Override // com.google.android.exoplayer2.drm.s
        public void E(int i11, o.b bVar) {
            if (G(i11, bVar)) {
                this.f25785c.m();
            }
        }

        @Override // com.google.android.exoplayer2.drm.s
        public void F(int i11, o.b bVar) {
            if (G(i11, bVar)) {
                this.f25785c.j();
            }
        }

        @Override // com.google.android.exoplayer2.source.p
        public void l(int i11, o.b bVar, t9.i iVar) {
            if (G(i11, bVar)) {
                this.f25784b.E(H(iVar));
            }
        }

        @Override // com.google.android.exoplayer2.source.p
        public void p(int i11, o.b bVar, t9.h hVar, t9.i iVar) {
            if (G(i11, bVar)) {
                this.f25784b.B(hVar, H(iVar));
            }
        }

        @Override // com.google.android.exoplayer2.drm.s
        public void r(int i11, o.b bVar) {
            if (G(i11, bVar)) {
                this.f25785c.i();
            }
        }

        @Override // com.google.android.exoplayer2.drm.s
        public /* synthetic */ void s(int i11, o.b bVar) {
            com.google.android.exoplayer2.drm.l.a(this, i11, bVar);
        }

        @Override // com.google.android.exoplayer2.source.p
        public void u(int i11, o.b bVar, t9.h hVar, t9.i iVar) {
            if (G(i11, bVar)) {
                this.f25784b.s(hVar, H(iVar));
            }
        }

        @Override // com.google.android.exoplayer2.source.p
        public void w(int i11, o.b bVar, t9.i iVar) {
            if (G(i11, bVar)) {
                this.f25784b.j(H(iVar));
            }
        }

        @Override // com.google.android.exoplayer2.source.p
        public void x(int i11, o.b bVar, t9.h hVar, t9.i iVar, IOException iOException, boolean z10) {
            if (G(i11, bVar)) {
                this.f25784b.y(hVar, H(iVar), iOException, z10);
            }
        }

        @Override // com.google.android.exoplayer2.drm.s
        public void y(int i11, o.b bVar, Exception exc) {
            if (G(i11, bVar)) {
                this.f25785c.l(exc);
            }
        }

        @Override // com.google.android.exoplayer2.source.p
        public void z(int i11, o.b bVar, t9.h hVar, t9.i iVar) {
            if (G(i11, bVar)) {
                this.f25784b.v(hVar, H(iVar));
            }
        }
    }

    /* loaded from: classes3.dex */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final o f25787a;

        /* renamed from: b, reason: collision with root package name */
        public final o.c f25788b;

        /* renamed from: c, reason: collision with root package name */
        public final a f25789c;

        public b(o oVar, o.c cVar, a aVar) {
            this.f25787a = oVar;
            this.f25788b = cVar;
            this.f25789c = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.a
    public void B(k0 k0Var) {
        this.f25782j = k0Var;
        this.f25781i = p0.w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.a
    public void D() {
        for (b bVar : this.f25780h.values()) {
            bVar.f25787a.e(bVar.f25788b);
            bVar.f25787a.h(bVar.f25789c);
            bVar.f25787a.r(bVar.f25789c);
        }
        this.f25780h.clear();
    }

    protected o.b F(Object obj, o.b bVar) {
        return bVar;
    }

    protected long G(Object obj, long j11) {
        return j11;
    }

    protected int H(Object obj, int i11) {
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public abstract void I(Object obj, o oVar, k3 k3Var);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void K(final Object obj, o oVar) {
        com.google.android.exoplayer2.util.a.a(!this.f25780h.containsKey(obj));
        o.c cVar = new o.c() { // from class: t9.b
            @Override // com.google.android.exoplayer2.source.o.c
            public final void a(com.google.android.exoplayer2.source.o oVar2, k3 k3Var) {
                com.google.android.exoplayer2.source.c.this.I(obj, oVar2, k3Var);
            }
        };
        a aVar = new a(obj);
        this.f25780h.put(obj, new b(oVar, cVar, aVar));
        oVar.g((Handler) com.google.android.exoplayer2.util.a.e(this.f25781i), aVar);
        oVar.q((Handler) com.google.android.exoplayer2.util.a.e(this.f25781i), aVar);
        oVar.i(cVar, this.f25782j, z());
        if (A()) {
            return;
        }
        oVar.o(cVar);
    }

    @Override // com.google.android.exoplayer2.source.o
    public void maybeThrowSourceInfoRefreshError() {
        Iterator it = this.f25780h.values().iterator();
        while (it.hasNext()) {
            ((b) it.next()).f25787a.maybeThrowSourceInfoRefreshError();
        }
    }

    @Override // com.google.android.exoplayer2.source.a
    protected void x() {
        for (b bVar : this.f25780h.values()) {
            bVar.f25787a.o(bVar.f25788b);
        }
    }

    @Override // com.google.android.exoplayer2.source.a
    protected void y() {
        for (b bVar : this.f25780h.values()) {
            bVar.f25787a.m(bVar.f25788b);
        }
    }
}
