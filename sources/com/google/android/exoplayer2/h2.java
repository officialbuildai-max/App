package com.google.android.exoplayer2;

import android.os.Handler;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import t9.t;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class h2 {

    /* renamed from: a, reason: collision with root package name */
    private final e9.u1 f25167a;

    /* renamed from: e, reason: collision with root package name */
    private final d f25171e;

    /* renamed from: f, reason: collision with root package name */
    private final p.a f25172f;

    /* renamed from: g, reason: collision with root package name */
    private final s.a f25173g;

    /* renamed from: h, reason: collision with root package name */
    private final HashMap f25174h;

    /* renamed from: i, reason: collision with root package name */
    private final Set f25175i;

    /* renamed from: k, reason: collision with root package name */
    private boolean f25177k;

    /* renamed from: l, reason: collision with root package name */
    private com.google.android.exoplayer2.upstream.k0 f25178l;

    /* renamed from: j, reason: collision with root package name */
    private t9.t f25176j = new t.a(0);

    /* renamed from: c, reason: collision with root package name */
    private final IdentityHashMap f25169c = new IdentityHashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map f25170d = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final List f25168b = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class a implements com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.drm.s {

        /* renamed from: a, reason: collision with root package name */
        private final c f25179a;

        /* renamed from: b, reason: collision with root package name */
        private p.a f25180b;

        /* renamed from: c, reason: collision with root package name */
        private s.a f25181c;

        public a(c cVar) {
            this.f25180b = h2.this.f25172f;
            this.f25181c = h2.this.f25173g;
            this.f25179a = cVar;
        }

        private boolean G(int i11, o.b bVar) {
            o.b bVar2;
            if (bVar != null) {
                bVar2 = h2.n(this.f25179a, bVar);
                if (bVar2 == null) {
                    return false;
                }
            } else {
                bVar2 = null;
            }
            int r11 = h2.r(this.f25179a, i11);
            p.a aVar = this.f25180b;
            if (aVar.f26295a != r11 || !com.google.android.exoplayer2.util.p0.c(aVar.f26296b, bVar2)) {
                this.f25180b = h2.this.f25172f.F(r11, bVar2, 0L);
            }
            s.a aVar2 = this.f25181c;
            if (aVar2.f25066a == r11 && com.google.android.exoplayer2.util.p0.c(aVar2.f25067b, bVar2)) {
                return true;
            }
            this.f25181c = h2.this.f25173g.u(r11, bVar2);
            return true;
        }

        @Override // com.google.android.exoplayer2.drm.s
        public void B(int i11, o.b bVar) {
            if (G(i11, bVar)) {
                this.f25181c.h();
            }
        }

        @Override // com.google.android.exoplayer2.drm.s
        public void D(int i11, o.b bVar, int i12) {
            if (G(i11, bVar)) {
                this.f25181c.k(i12);
            }
        }

        @Override // com.google.android.exoplayer2.drm.s
        public void E(int i11, o.b bVar) {
            if (G(i11, bVar)) {
                this.f25181c.m();
            }
        }

        @Override // com.google.android.exoplayer2.drm.s
        public void F(int i11, o.b bVar) {
            if (G(i11, bVar)) {
                this.f25181c.j();
            }
        }

        @Override // com.google.android.exoplayer2.source.p
        public void l(int i11, o.b bVar, t9.i iVar) {
            if (G(i11, bVar)) {
                this.f25180b.E(iVar);
            }
        }

        @Override // com.google.android.exoplayer2.source.p
        public void p(int i11, o.b bVar, t9.h hVar, t9.i iVar) {
            if (G(i11, bVar)) {
                this.f25180b.B(hVar, iVar);
            }
        }

        @Override // com.google.android.exoplayer2.drm.s
        public void r(int i11, o.b bVar) {
            if (G(i11, bVar)) {
                this.f25181c.i();
            }
        }

        @Override // com.google.android.exoplayer2.drm.s
        public /* synthetic */ void s(int i11, o.b bVar) {
            com.google.android.exoplayer2.drm.l.a(this, i11, bVar);
        }

        @Override // com.google.android.exoplayer2.source.p
        public void u(int i11, o.b bVar, t9.h hVar, t9.i iVar) {
            if (G(i11, bVar)) {
                this.f25180b.s(hVar, iVar);
            }
        }

        @Override // com.google.android.exoplayer2.source.p
        public void w(int i11, o.b bVar, t9.i iVar) {
            if (G(i11, bVar)) {
                this.f25180b.j(iVar);
            }
        }

        @Override // com.google.android.exoplayer2.source.p
        public void x(int i11, o.b bVar, t9.h hVar, t9.i iVar, IOException iOException, boolean z10) {
            if (G(i11, bVar)) {
                this.f25180b.y(hVar, iVar, iOException, z10);
            }
        }

        @Override // com.google.android.exoplayer2.drm.s
        public void y(int i11, o.b bVar, Exception exc) {
            if (G(i11, bVar)) {
                this.f25181c.l(exc);
            }
        }

        @Override // com.google.android.exoplayer2.source.p
        public void z(int i11, o.b bVar, t9.h hVar, t9.i iVar) {
            if (G(i11, bVar)) {
                this.f25180b.v(hVar, iVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.o f25183a;

        /* renamed from: b, reason: collision with root package name */
        public final o.c f25184b;

        /* renamed from: c, reason: collision with root package name */
        public final a f25185c;

        public b(com.google.android.exoplayer2.source.o oVar, o.c cVar, a aVar) {
            this.f25183a = oVar;
            this.f25184b = cVar;
            this.f25185c = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class c implements f2 {

        /* renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.m f25186a;

        /* renamed from: d, reason: collision with root package name */
        public int f25189d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f25190e;

        /* renamed from: c, reason: collision with root package name */
        public final List f25188c = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final Object f25187b = new Object();

        public c(com.google.android.exoplayer2.source.o oVar, boolean z10) {
            this.f25186a = new com.google.android.exoplayer2.source.m(oVar, z10);
        }

        @Override // com.google.android.exoplayer2.f2
        public Object a() {
            return this.f25187b;
        }

        @Override // com.google.android.exoplayer2.f2
        public k3 b() {
            return this.f25186a.P();
        }

        public void c(int i11) {
            this.f25189d = i11;
            this.f25190e = false;
            this.f25188c.clear();
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a();
    }

    public h2(d dVar, e9.a aVar, Handler handler, e9.u1 u1Var) {
        this.f25167a = u1Var;
        this.f25171e = dVar;
        p.a aVar2 = new p.a();
        this.f25172f = aVar2;
        s.a aVar3 = new s.a();
        this.f25173g = aVar3;
        this.f25174h = new HashMap();
        this.f25175i = new HashSet();
        aVar2.g(handler, aVar);
        aVar3.g(handler, aVar);
    }

    private void A(int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            c cVar = (c) this.f25168b.remove(i13);
            this.f25170d.remove(cVar.f25187b);
            g(i13, -cVar.f25186a.P().t());
            cVar.f25190e = true;
            if (this.f25177k) {
                u(cVar);
            }
        }
    }

    private void g(int i11, int i12) {
        while (i11 < this.f25168b.size()) {
            ((c) this.f25168b.get(i11)).f25189d += i12;
            i11++;
        }
    }

    private void j(c cVar) {
        b bVar = (b) this.f25174h.get(cVar);
        if (bVar != null) {
            bVar.f25183a.o(bVar.f25184b);
        }
    }

    private void k() {
        Iterator it = this.f25175i.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.f25188c.isEmpty()) {
                j(cVar);
                it.remove();
            }
        }
    }

    private void l(c cVar) {
        this.f25175i.add(cVar);
        b bVar = (b) this.f25174h.get(cVar);
        if (bVar != null) {
            bVar.f25183a.m(bVar.f25184b);
        }
    }

    private static Object m(Object obj) {
        return com.google.android.exoplayer2.a.B(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static o.b n(c cVar, o.b bVar) {
        for (int i11 = 0; i11 < cVar.f25188c.size(); i11++) {
            if (((o.b) cVar.f25188c.get(i11)).f76240d == bVar.f76240d) {
                return bVar.c(p(cVar, bVar.f76237a));
            }
        }
        return null;
    }

    private static Object o(Object obj) {
        return com.google.android.exoplayer2.a.C(obj);
    }

    private static Object p(c cVar, Object obj) {
        return com.google.android.exoplayer2.a.E(cVar.f25187b, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int r(c cVar, int i11) {
        return i11 + cVar.f25189d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(com.google.android.exoplayer2.source.o oVar, k3 k3Var) {
        this.f25171e.a();
    }

    private void u(c cVar) {
        if (cVar.f25190e && cVar.f25188c.isEmpty()) {
            b bVar = (b) com.google.android.exoplayer2.util.a.e((b) this.f25174h.remove(cVar));
            bVar.f25183a.e(bVar.f25184b);
            bVar.f25183a.h(bVar.f25185c);
            bVar.f25183a.r(bVar.f25185c);
            this.f25175i.remove(cVar);
        }
    }

    private void w(c cVar) {
        com.google.android.exoplayer2.source.m mVar = cVar.f25186a;
        o.c cVar2 = new o.c() { // from class: com.google.android.exoplayer2.g2
            @Override // com.google.android.exoplayer2.source.o.c
            public final void a(com.google.android.exoplayer2.source.o oVar, k3 k3Var) {
                h2.this.t(oVar, k3Var);
            }
        };
        a aVar = new a(cVar);
        this.f25174h.put(cVar, new b(mVar, cVar2, aVar));
        mVar.g(com.google.android.exoplayer2.util.p0.y(), aVar);
        mVar.q(com.google.android.exoplayer2.util.p0.y(), aVar);
        mVar.i(cVar2, this.f25178l, this.f25167a);
    }

    public k3 B(List list, t9.t tVar) {
        A(0, this.f25168b.size());
        return f(this.f25168b.size(), list, tVar);
    }

    public k3 C(t9.t tVar) {
        int q11 = q();
        if (tVar.getLength() != q11) {
            tVar = tVar.cloneAndClear().cloneAndInsert(0, q11);
        }
        this.f25176j = tVar;
        return i();
    }

    public k3 f(int i11, List list, t9.t tVar) {
        if (!list.isEmpty()) {
            this.f25176j = tVar;
            for (int i12 = i11; i12 < list.size() + i11; i12++) {
                c cVar = (c) list.get(i12 - i11);
                if (i12 > 0) {
                    c cVar2 = (c) this.f25168b.get(i12 - 1);
                    cVar.c(cVar2.f25189d + cVar2.f25186a.P().t());
                } else {
                    cVar.c(0);
                }
                g(i12, cVar.f25186a.P().t());
                this.f25168b.add(i12, cVar);
                this.f25170d.put(cVar.f25187b, cVar);
                if (this.f25177k) {
                    w(cVar);
                    if (this.f25169c.isEmpty()) {
                        this.f25175i.add(cVar);
                    } else {
                        j(cVar);
                    }
                }
            }
        }
        return i();
    }

    public com.google.android.exoplayer2.source.n h(o.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        Object o11 = o(bVar.f76237a);
        o.b c11 = bVar.c(m(bVar.f76237a));
        c cVar = (c) com.google.android.exoplayer2.util.a.e((c) this.f25170d.get(o11));
        l(cVar);
        cVar.f25188c.add(c11);
        com.google.android.exoplayer2.source.l d11 = cVar.f25186a.d(c11, bVar2, j11);
        this.f25169c.put(d11, cVar);
        k();
        return d11;
    }

    public k3 i() {
        if (this.f25168b.isEmpty()) {
            return k3.f25205a;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f25168b.size(); i12++) {
            c cVar = (c) this.f25168b.get(i12);
            cVar.f25189d = i11;
            i11 += cVar.f25186a.P().t();
        }
        return new t2(this.f25168b, this.f25176j);
    }

    public int q() {
        return this.f25168b.size();
    }

    public boolean s() {
        return this.f25177k;
    }

    public void v(com.google.android.exoplayer2.upstream.k0 k0Var) {
        com.google.android.exoplayer2.util.a.g(!this.f25177k);
        this.f25178l = k0Var;
        for (int i11 = 0; i11 < this.f25168b.size(); i11++) {
            c cVar = (c) this.f25168b.get(i11);
            w(cVar);
            this.f25175i.add(cVar);
        }
        this.f25177k = true;
    }

    public void x() {
        for (b bVar : this.f25174h.values()) {
            try {
                bVar.f25183a.e(bVar.f25184b);
            } catch (RuntimeException e11) {
                com.google.android.exoplayer2.util.s.d("MediaSourceList", "Failed to release child source.", e11);
            }
            bVar.f25183a.h(bVar.f25185c);
            bVar.f25183a.r(bVar.f25185c);
        }
        this.f25174h.clear();
        this.f25175i.clear();
        this.f25177k = false;
    }

    public void y(com.google.android.exoplayer2.source.n nVar) {
        c cVar = (c) com.google.android.exoplayer2.util.a.e((c) this.f25169c.remove(nVar));
        cVar.f25186a.k(nVar);
        cVar.f25188c.remove(((com.google.android.exoplayer2.source.l) nVar).f26273a);
        if (!this.f25169c.isEmpty()) {
            k();
        }
        u(cVar);
    }

    public k3 z(int i11, int i12, t9.t tVar) {
        com.google.android.exoplayer2.util.a.a(i11 >= 0 && i11 <= i12 && i12 <= q());
        this.f25176j = tVar;
        A(i11, i12);
        return i();
    }
}
