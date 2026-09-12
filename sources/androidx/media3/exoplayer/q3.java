package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.q3;
import androidx.media3.exoplayer.source.r;
import g2.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q3 {

    /* renamed from: a, reason: collision with root package name */
    private final y1.f4 f12542a;

    /* renamed from: e, reason: collision with root package name */
    private final d f12546e;

    /* renamed from: h, reason: collision with root package name */
    private final y1.a f12549h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.media3.common.util.p f12550i;

    /* renamed from: k, reason: collision with root package name */
    private boolean f12552k;

    /* renamed from: l, reason: collision with root package name */
    private w1.n f12553l;

    /* renamed from: j, reason: collision with root package name */
    private g2.v f12551j = new v.a(0);

    /* renamed from: c, reason: collision with root package name */
    private final IdentityHashMap f12544c = new IdentityHashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map f12545d = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final List f12543b = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final HashMap f12547f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private final Set f12548g = new HashSet();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class a implements androidx.media3.exoplayer.source.s, androidx.media3.exoplayer.drm.r {

        /* renamed from: a, reason: collision with root package name */
        private final c f12554a;

        public a(c cVar) {
            this.f12554a = cVar;
        }

        private Pair U(int i11, r.b bVar) {
            r.b bVar2 = null;
            if (bVar != null) {
                r.b n11 = q3.n(this.f12554a, bVar);
                if (n11 == null) {
                    return null;
                }
                bVar2 = n11;
            }
            return Pair.create(Integer.valueOf(q3.s(this.f12554a, i11)), bVar2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void V(Pair pair, g2.j jVar) {
            q3.this.f12549h.E(((Integer) pair.first).intValue(), (r.b) pair.second, jVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void W(Pair pair) {
            q3.this.f12549h.q(((Integer) pair.first).intValue(), (r.b) pair.second);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void X(Pair pair) {
            q3.this.f12549h.w(((Integer) pair.first).intValue(), (r.b) pair.second);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void Y(Pair pair) {
            q3.this.f12549h.A(((Integer) pair.first).intValue(), (r.b) pair.second);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void Z(Pair pair, int i11) {
            q3.this.f12549h.r(((Integer) pair.first).intValue(), (r.b) pair.second, i11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a0(Pair pair, Exception exc) {
            q3.this.f12549h.x(((Integer) pair.first).intValue(), (r.b) pair.second, exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b0(Pair pair) {
            q3.this.f12549h.G(((Integer) pair.first).intValue(), (r.b) pair.second);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c0(Pair pair, g2.i iVar, g2.j jVar) {
            q3.this.f12549h.l(((Integer) pair.first).intValue(), (r.b) pair.second, iVar, jVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d0(Pair pair, g2.i iVar, g2.j jVar) {
            q3.this.f12549h.C(((Integer) pair.first).intValue(), (r.b) pair.second, iVar, jVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e0(Pair pair, g2.i iVar, g2.j jVar, IOException iOException, boolean z10) {
            q3.this.f12549h.y(((Integer) pair.first).intValue(), (r.b) pair.second, iVar, jVar, iOException, z10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f0(Pair pair, g2.i iVar, g2.j jVar, int i11) {
            q3.this.f12549h.F(((Integer) pair.first).intValue(), (r.b) pair.second, iVar, jVar, i11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g0(Pair pair, g2.j jVar) {
            q3.this.f12549h.D(((Integer) pair.first).intValue(), (r.b) androidx.media3.common.util.a.e((r.b) pair.second), jVar);
        }

        @Override // androidx.media3.exoplayer.drm.r
        public void A(int i11, r.b bVar) {
            final Pair U = U(i11, bVar);
            if (U != null) {
                q3.this.f12550i.post(new Runnable() { // from class: androidx.media3.exoplayer.f3
                    @Override // java.lang.Runnable
                    public final void run() {
                        q3.a.this.Y(U);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.source.s
        public void C(int i11, r.b bVar, final g2.i iVar, final g2.j jVar) {
            final Pair U = U(i11, bVar);
            if (U != null) {
                q3.this.f12550i.post(new Runnable() { // from class: androidx.media3.exoplayer.l3
                    @Override // java.lang.Runnable
                    public final void run() {
                        q3.a.this.d0(U, iVar, jVar);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.source.s
        public void D(int i11, r.b bVar, final g2.j jVar) {
            final Pair U = U(i11, bVar);
            if (U != null) {
                q3.this.f12550i.post(new Runnable() { // from class: androidx.media3.exoplayer.e3
                    @Override // java.lang.Runnable
                    public final void run() {
                        q3.a.this.g0(U, jVar);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.source.s
        public void E(int i11, r.b bVar, final g2.j jVar) {
            final Pair U = U(i11, bVar);
            if (U != null) {
                q3.this.f12550i.post(new Runnable() { // from class: androidx.media3.exoplayer.j3
                    @Override // java.lang.Runnable
                    public final void run() {
                        q3.a.this.V(U, jVar);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.source.s
        public void F(int i11, r.b bVar, final g2.i iVar, final g2.j jVar, final int i12) {
            final Pair U = U(i11, bVar);
            if (U != null) {
                q3.this.f12550i.post(new Runnable() { // from class: androidx.media3.exoplayer.n3
                    @Override // java.lang.Runnable
                    public final void run() {
                        q3.a.this.f0(U, iVar, jVar, i12);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.drm.r
        public void G(int i11, r.b bVar) {
            final Pair U = U(i11, bVar);
            if (U != null) {
                q3.this.f12550i.post(new Runnable() { // from class: androidx.media3.exoplayer.k3
                    @Override // java.lang.Runnable
                    public final void run() {
                        q3.a.this.b0(U);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.source.s
        public void l(int i11, r.b bVar, final g2.i iVar, final g2.j jVar) {
            final Pair U = U(i11, bVar);
            if (U != null) {
                q3.this.f12550i.post(new Runnable() { // from class: androidx.media3.exoplayer.h3
                    @Override // java.lang.Runnable
                    public final void run() {
                        q3.a.this.c0(U, iVar, jVar);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.drm.r
        public void q(int i11, r.b bVar) {
            final Pair U = U(i11, bVar);
            if (U != null) {
                q3.this.f12550i.post(new Runnable() { // from class: androidx.media3.exoplayer.g3
                    @Override // java.lang.Runnable
                    public final void run() {
                        q3.a.this.W(U);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.drm.r
        public void r(int i11, r.b bVar, final int i12) {
            final Pair U = U(i11, bVar);
            if (U != null) {
                q3.this.f12550i.post(new Runnable() { // from class: androidx.media3.exoplayer.m3
                    @Override // java.lang.Runnable
                    public final void run() {
                        q3.a.this.Z(U, i12);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.drm.r
        public void w(int i11, r.b bVar) {
            final Pair U = U(i11, bVar);
            if (U != null) {
                q3.this.f12550i.post(new Runnable() { // from class: androidx.media3.exoplayer.p3
                    @Override // java.lang.Runnable
                    public final void run() {
                        q3.a.this.X(U);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.drm.r
        public void x(int i11, r.b bVar, final Exception exc) {
            final Pair U = U(i11, bVar);
            if (U != null) {
                q3.this.f12550i.post(new Runnable() { // from class: androidx.media3.exoplayer.i3
                    @Override // java.lang.Runnable
                    public final void run() {
                        q3.a.this.a0(U, exc);
                    }
                });
            }
        }

        @Override // androidx.media3.exoplayer.source.s
        public void y(int i11, r.b bVar, final g2.i iVar, final g2.j jVar, final IOException iOException, final boolean z10) {
            final Pair U = U(i11, bVar);
            if (U != null) {
                q3.this.f12550i.post(new Runnable() { // from class: androidx.media3.exoplayer.o3
                    @Override // java.lang.Runnable
                    public final void run() {
                        q3.a.this.e0(U, iVar, jVar, iOException, z10);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.media3.exoplayer.source.r f12556a;

        /* renamed from: b, reason: collision with root package name */
        public final r.c f12557b;

        /* renamed from: c, reason: collision with root package name */
        public final a f12558c;

        public b(androidx.media3.exoplayer.source.r rVar, r.c cVar, a aVar) {
            this.f12556a = rVar;
            this.f12557b = cVar;
            this.f12558c = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c implements c3 {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.media3.exoplayer.source.p f12559a;

        /* renamed from: d, reason: collision with root package name */
        public int f12562d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f12563e;

        /* renamed from: c, reason: collision with root package name */
        public final List f12561c = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final Object f12560b = new Object();

        public c(androidx.media3.exoplayer.source.r rVar, boolean z10) {
            this.f12559a = new androidx.media3.exoplayer.source.p(rVar, z10);
        }

        @Override // androidx.media3.exoplayer.c3
        public Object a() {
            return this.f12560b;
        }

        @Override // androidx.media3.exoplayer.c3
        public androidx.media3.common.e0 b() {
            return this.f12559a.W();
        }

        public void c(int i11) {
            this.f12562d = i11;
            this.f12563e = false;
            this.f12561c.clear();
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a();
    }

    public q3(d dVar, y1.a aVar, androidx.media3.common.util.p pVar, y1.f4 f4Var) {
        this.f12542a = f4Var;
        this.f12546e = dVar;
        this.f12549h = aVar;
        this.f12550i = pVar;
    }

    private void B(int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            c cVar = (c) this.f12543b.remove(i13);
            this.f12545d.remove(cVar.f12560b);
            g(i13, -cVar.f12559a.W().p());
            cVar.f12563e = true;
            if (this.f12552k) {
                v(cVar);
            }
        }
    }

    private void g(int i11, int i12) {
        while (i11 < this.f12543b.size()) {
            ((c) this.f12543b.get(i11)).f12562d += i12;
            i11++;
        }
    }

    private void j(c cVar) {
        b bVar = (b) this.f12547f.get(cVar);
        if (bVar != null) {
            bVar.f12556a.o(bVar.f12557b);
        }
    }

    private void k() {
        Iterator it = this.f12548g.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.f12561c.isEmpty()) {
                j(cVar);
                it.remove();
            }
        }
    }

    private void l(c cVar) {
        this.f12548g.add(cVar);
        b bVar = (b) this.f12547f.get(cVar);
        if (bVar != null) {
            bVar.f12556a.k(bVar.f12557b);
        }
    }

    private static Object m(Object obj) {
        return androidx.media3.exoplayer.a.v(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static r.b n(c cVar, r.b bVar) {
        for (int i11 = 0; i11 < cVar.f12561c.size(); i11++) {
            if (((r.b) cVar.f12561c.get(i11)).f12968d == bVar.f12968d) {
                return bVar.a(p(cVar, bVar.f12965a));
            }
        }
        return null;
    }

    private static Object o(Object obj) {
        return androidx.media3.exoplayer.a.w(obj);
    }

    private static Object p(c cVar, Object obj) {
        return androidx.media3.exoplayer.a.y(cVar.f12560b, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int s(c cVar, int i11) {
        return i11 + cVar.f12562d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(androidx.media3.exoplayer.source.r rVar, androidx.media3.common.e0 e0Var) {
        this.f12546e.a();
    }

    private void v(c cVar) {
        if (cVar.f12563e && cVar.f12561c.isEmpty()) {
            b bVar = (b) androidx.media3.common.util.a.e((b) this.f12547f.remove(cVar));
            bVar.f12556a.n(bVar.f12557b);
            bVar.f12556a.e(bVar.f12558c);
            bVar.f12556a.i(bVar.f12558c);
            this.f12548g.remove(cVar);
        }
    }

    private void x(c cVar) {
        androidx.media3.exoplayer.source.p pVar = cVar.f12559a;
        r.c cVar2 = new r.c() { // from class: androidx.media3.exoplayer.d3
            @Override // androidx.media3.exoplayer.source.r.c
            public final void a(androidx.media3.exoplayer.source.r rVar, androidx.media3.common.e0 e0Var) {
                q3.this.u(rVar, e0Var);
            }
        };
        a aVar = new a(cVar);
        this.f12547f.put(cVar, new b(pVar, cVar2, aVar));
        pVar.d(androidx.media3.common.util.a1.C(), aVar);
        pVar.h(androidx.media3.common.util.a1.C(), aVar);
        pVar.m(cVar2, this.f12553l, this.f12542a);
    }

    public androidx.media3.common.e0 A(int i11, int i12, g2.v vVar) {
        androidx.media3.common.util.a.a(i11 >= 0 && i11 <= i12 && i12 <= r());
        this.f12551j = vVar;
        B(i11, i12);
        return i();
    }

    public androidx.media3.common.e0 C(List list, g2.v vVar) {
        B(0, this.f12543b.size());
        return f(this.f12543b.size(), list, vVar);
    }

    public androidx.media3.common.e0 D(g2.v vVar) {
        int r11 = r();
        if (vVar.getLength() != r11) {
            vVar = vVar.cloneAndClear().cloneAndInsert(0, r11);
        }
        this.f12551j = vVar;
        return i();
    }

    public androidx.media3.common.e0 E(int i11, int i12, List list) {
        androidx.media3.common.util.a.a(i11 >= 0 && i11 <= i12 && i12 <= r());
        androidx.media3.common.util.a.a(list.size() == i12 - i11);
        for (int i13 = i11; i13 < i12; i13++) {
            ((c) this.f12543b.get(i13)).f12559a.l((androidx.media3.common.t) list.get(i13 - i11));
        }
        return i();
    }

    public androidx.media3.common.e0 f(int i11, List list, g2.v vVar) {
        if (!list.isEmpty()) {
            this.f12551j = vVar;
            for (int i12 = i11; i12 < list.size() + i11; i12++) {
                c cVar = (c) list.get(i12 - i11);
                if (i12 > 0) {
                    c cVar2 = (c) this.f12543b.get(i12 - 1);
                    cVar.c(cVar2.f12562d + cVar2.f12559a.W().p());
                } else {
                    cVar.c(0);
                }
                g(i12, cVar.f12559a.W().p());
                this.f12543b.add(i12, cVar);
                this.f12545d.put(cVar.f12560b, cVar);
                if (this.f12552k) {
                    x(cVar);
                    if (this.f12544c.isEmpty()) {
                        this.f12548g.add(cVar);
                    } else {
                        j(cVar);
                    }
                }
            }
        }
        return i();
    }

    public androidx.media3.exoplayer.source.q h(r.b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11) {
        Object o11 = o(bVar.f12965a);
        r.b a11 = bVar.a(m(bVar.f12965a));
        c cVar = (c) androidx.media3.common.util.a.e((c) this.f12545d.get(o11));
        l(cVar);
        cVar.f12561c.add(a11);
        androidx.media3.exoplayer.source.o g11 = cVar.f12559a.g(a11, bVar2, j11);
        this.f12544c.put(g11, cVar);
        k();
        return g11;
    }

    public androidx.media3.common.e0 i() {
        if (this.f12543b.isEmpty()) {
            return androidx.media3.common.e0.f10007a;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f12543b.size(); i12++) {
            c cVar = (c) this.f12543b.get(i12);
            cVar.f12562d = i11;
            i11 += cVar.f12559a.W().p();
        }
        return new u3(this.f12543b, this.f12551j);
    }

    public g2.v q() {
        return this.f12551j;
    }

    public int r() {
        return this.f12543b.size();
    }

    public boolean t() {
        return this.f12552k;
    }

    public void w(w1.n nVar) {
        androidx.media3.common.util.a.g(!this.f12552k);
        this.f12553l = nVar;
        for (int i11 = 0; i11 < this.f12543b.size(); i11++) {
            c cVar = (c) this.f12543b.get(i11);
            x(cVar);
            this.f12548g.add(cVar);
        }
        this.f12552k = true;
    }

    public void y() {
        for (b bVar : this.f12547f.values()) {
            try {
                bVar.f12556a.n(bVar.f12557b);
            } catch (RuntimeException e11) {
                androidx.media3.common.util.u.d("MediaSourceList", "Failed to release child source.", e11);
            }
            bVar.f12556a.e(bVar.f12558c);
            bVar.f12556a.i(bVar.f12558c);
        }
        this.f12547f.clear();
        this.f12548g.clear();
        this.f12552k = false;
    }

    public void z(androidx.media3.exoplayer.source.q qVar) {
        c cVar = (c) androidx.media3.common.util.a.e((c) this.f12544c.remove(qVar));
        cVar.f12559a.j(qVar);
        cVar.f12561c.remove(((androidx.media3.exoplayer.source.o) qVar).f12944a);
        if (!this.f12544c.isEmpty()) {
            k();
        }
        v(cVar);
    }
}
