package androidx.media3.exoplayer.source;

import android.os.Handler;
import androidx.media3.common.e0;
import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.drm.r;
import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.source.s;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes2.dex */
public abstract class c extends androidx.media3.exoplayer.source.a {

    /* renamed from: h, reason: collision with root package name */
    private final HashMap f12797h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    private Handler f12798i;

    /* renamed from: j, reason: collision with root package name */
    private w1.n f12799j;

    /* loaded from: classes2.dex */
    private final class a implements s, androidx.media3.exoplayer.drm.r {

        /* renamed from: a, reason: collision with root package name */
        private final Object f12800a;

        /* renamed from: b, reason: collision with root package name */
        private s.a f12801b;

        /* renamed from: c, reason: collision with root package name */
        private r.a f12802c;

        public a(Object obj) {
            this.f12801b = c.this.u(null);
            this.f12802c = c.this.s(null);
            this.f12800a = obj;
        }

        private boolean I(int i11, r.b bVar) {
            r.b bVar2;
            if (bVar != null) {
                bVar2 = c.this.D(this.f12800a, bVar);
                if (bVar2 == null) {
                    return false;
                }
            } else {
                bVar2 = null;
            }
            int F = c.this.F(this.f12800a, i11);
            s.a aVar = this.f12801b;
            if (aVar.f12970a != F || !Objects.equals(aVar.f12971b, bVar2)) {
                this.f12801b = c.this.t(F, bVar2);
            }
            r.a aVar2 = this.f12802c;
            if (aVar2.f11689a == F && Objects.equals(aVar2.f11690b, bVar2)) {
                return true;
            }
            this.f12802c = c.this.r(F, bVar2);
            return true;
        }

        private g2.j J(g2.j jVar, r.b bVar) {
            long E = c.this.E(this.f12800a, jVar.f63343f, bVar);
            long E2 = c.this.E(this.f12800a, jVar.f63344g, bVar);
            return (E == jVar.f63343f && E2 == jVar.f63344g) ? jVar : new g2.j(jVar.f63338a, jVar.f63339b, jVar.f63340c, jVar.f63341d, jVar.f63342e, E, E2);
        }

        @Override // androidx.media3.exoplayer.drm.r
        public void A(int i11, r.b bVar) {
            if (I(i11, bVar)) {
                this.f12802c.j();
            }
        }

        @Override // androidx.media3.exoplayer.source.s
        public void C(int i11, r.b bVar, g2.i iVar, g2.j jVar) {
            if (I(i11, bVar)) {
                this.f12801b.x(iVar, J(jVar, bVar));
            }
        }

        @Override // androidx.media3.exoplayer.source.s
        public void D(int i11, r.b bVar, g2.j jVar) {
            if (I(i11, bVar)) {
                this.f12801b.G(J(jVar, bVar));
            }
        }

        @Override // androidx.media3.exoplayer.source.s
        public void E(int i11, r.b bVar, g2.j jVar) {
            if (I(i11, bVar)) {
                this.f12801b.k(J(jVar, bVar));
            }
        }

        @Override // androidx.media3.exoplayer.source.s
        public void F(int i11, r.b bVar, g2.i iVar, g2.j jVar, int i12) {
            if (I(i11, bVar)) {
                this.f12801b.D(iVar, J(jVar, bVar), i12);
            }
        }

        @Override // androidx.media3.exoplayer.drm.r
        public void G(int i11, r.b bVar) {
            if (I(i11, bVar)) {
                this.f12802c.m();
            }
        }

        @Override // androidx.media3.exoplayer.source.s
        public void l(int i11, r.b bVar, g2.i iVar, g2.j jVar) {
            if (I(i11, bVar)) {
                this.f12801b.u(iVar, J(jVar, bVar));
            }
        }

        @Override // androidx.media3.exoplayer.drm.r
        public void q(int i11, r.b bVar) {
            if (I(i11, bVar)) {
                this.f12802c.h();
            }
        }

        @Override // androidx.media3.exoplayer.drm.r
        public void r(int i11, r.b bVar, int i12) {
            if (I(i11, bVar)) {
                this.f12802c.k(i12);
            }
        }

        @Override // androidx.media3.exoplayer.drm.r
        public void w(int i11, r.b bVar) {
            if (I(i11, bVar)) {
                this.f12802c.i();
            }
        }

        @Override // androidx.media3.exoplayer.drm.r
        public void x(int i11, r.b bVar, Exception exc) {
            if (I(i11, bVar)) {
                this.f12802c.l(exc);
            }
        }

        @Override // androidx.media3.exoplayer.source.s
        public void y(int i11, r.b bVar, g2.i iVar, g2.j jVar, IOException iOException, boolean z10) {
            if (I(i11, bVar)) {
                this.f12801b.A(iVar, J(jVar, bVar), iOException, z10);
            }
        }
    }

    /* loaded from: classes2.dex */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final r f12804a;

        /* renamed from: b, reason: collision with root package name */
        public final r.c f12805b;

        /* renamed from: c, reason: collision with root package name */
        public final a f12806c;

        public b(r rVar, r.c cVar, a aVar) {
            this.f12804a = rVar;
            this.f12805b = cVar;
            this.f12806c = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.a
    public void B() {
        for (b bVar : this.f12797h.values()) {
            bVar.f12804a.n(bVar.f12805b);
            bVar.f12804a.e(bVar.f12806c);
            bVar.f12804a.i(bVar.f12806c);
        }
        this.f12797h.clear();
    }

    protected abstract r.b D(Object obj, r.b bVar);

    protected long E(Object obj, long j11, r.b bVar) {
        return j11;
    }

    protected int F(Object obj, int i11) {
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public abstract void G(Object obj, r rVar, androidx.media3.common.e0 e0Var);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void I(final Object obj, r rVar) {
        androidx.media3.common.util.a.a(!this.f12797h.containsKey(obj));
        r.c cVar = new r.c() { // from class: g2.c
            @Override // androidx.media3.exoplayer.source.r.c
            public final void a(androidx.media3.exoplayer.source.r rVar2, e0 e0Var) {
                androidx.media3.exoplayer.source.c.this.G(obj, rVar2, e0Var);
            }
        };
        a aVar = new a(obj);
        this.f12797h.put(obj, new b(rVar, cVar, aVar));
        rVar.d((Handler) androidx.media3.common.util.a.e(this.f12798i), aVar);
        rVar.h((Handler) androidx.media3.common.util.a.e(this.f12798i), aVar);
        rVar.m(cVar, this.f12799j, x());
        if (y()) {
            return;
        }
        rVar.o(cVar);
    }

    @Override // androidx.media3.exoplayer.source.r
    public void maybeThrowSourceInfoRefreshError() {
        Iterator it = this.f12797h.values().iterator();
        while (it.hasNext()) {
            ((b) it.next()).f12804a.maybeThrowSourceInfoRefreshError();
        }
    }

    @Override // androidx.media3.exoplayer.source.a
    protected void v() {
        for (b bVar : this.f12797h.values()) {
            bVar.f12804a.o(bVar.f12805b);
        }
    }

    @Override // androidx.media3.exoplayer.source.a
    protected void w() {
        for (b bVar : this.f12797h.values()) {
            bVar.f12804a.k(bVar.f12805b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.a
    public void z(w1.n nVar) {
        this.f12799j = nVar;
        this.f12798i = a1.A();
    }
}
