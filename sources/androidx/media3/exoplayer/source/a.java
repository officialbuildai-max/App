package androidx.media3.exoplayer.source;

import android.os.Handler;
import android.os.Looper;
import androidx.media3.exoplayer.drm.r;
import androidx.media3.exoplayer.source.r;
import androidx.media3.exoplayer.source.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import y1.f4;

/* loaded from: classes2.dex */
public abstract class a implements r {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f12708a = new ArrayList(1);

    /* renamed from: b, reason: collision with root package name */
    private final HashSet f12709b = new HashSet(1);

    /* renamed from: c, reason: collision with root package name */
    private final s.a f12710c = new s.a();

    /* renamed from: d, reason: collision with root package name */
    private final r.a f12711d = new r.a();

    /* renamed from: e, reason: collision with root package name */
    private Looper f12712e;

    /* renamed from: f, reason: collision with root package name */
    private androidx.media3.common.e0 f12713f;

    /* renamed from: g, reason: collision with root package name */
    private f4 f12714g;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void A(androidx.media3.common.e0 e0Var) {
        this.f12713f = e0Var;
        Iterator it = this.f12708a.iterator();
        while (it.hasNext()) {
            ((r.c) it.next()).a(this, e0Var);
        }
    }

    protected abstract void B();

    @Override // androidx.media3.exoplayer.source.r
    public /* synthetic */ boolean b() {
        return g2.k.c(this);
    }

    @Override // androidx.media3.exoplayer.source.r
    public /* synthetic */ androidx.media3.common.e0 c() {
        return g2.k.b(this);
    }

    @Override // androidx.media3.exoplayer.source.r
    public final void d(Handler handler, s sVar) {
        androidx.media3.common.util.a.e(handler);
        androidx.media3.common.util.a.e(sVar);
        this.f12710c.h(handler, sVar);
    }

    @Override // androidx.media3.exoplayer.source.r
    public final void e(s sVar) {
        this.f12710c.E(sVar);
    }

    @Override // androidx.media3.exoplayer.source.r
    public final void h(Handler handler, androidx.media3.exoplayer.drm.r rVar) {
        androidx.media3.common.util.a.e(handler);
        androidx.media3.common.util.a.e(rVar);
        this.f12711d.g(handler, rVar);
    }

    @Override // androidx.media3.exoplayer.source.r
    public final void i(androidx.media3.exoplayer.drm.r rVar) {
        this.f12711d.t(rVar);
    }

    @Override // androidx.media3.exoplayer.source.r
    public final void k(r.c cVar) {
        androidx.media3.common.util.a.e(this.f12712e);
        boolean isEmpty = this.f12709b.isEmpty();
        this.f12709b.add(cVar);
        if (isEmpty) {
            w();
        }
    }

    @Override // androidx.media3.exoplayer.source.r
    public /* synthetic */ void l(androidx.media3.common.t tVar) {
        g2.k.d(this, tVar);
    }

    @Override // androidx.media3.exoplayer.source.r
    public final void m(r.c cVar, w1.n nVar, f4 f4Var) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.f12712e;
        androidx.media3.common.util.a.a(looper == null || looper == myLooper);
        this.f12714g = f4Var;
        androidx.media3.common.e0 e0Var = this.f12713f;
        this.f12708a.add(cVar);
        if (this.f12712e == null) {
            this.f12712e = myLooper;
            this.f12709b.add(cVar);
            z(nVar);
        } else if (e0Var != null) {
            k(cVar);
            cVar.a(this, e0Var);
        }
    }

    @Override // androidx.media3.exoplayer.source.r
    public final void n(r.c cVar) {
        this.f12708a.remove(cVar);
        if (!this.f12708a.isEmpty()) {
            o(cVar);
            return;
        }
        this.f12712e = null;
        this.f12713f = null;
        this.f12714g = null;
        this.f12709b.clear();
        B();
    }

    @Override // androidx.media3.exoplayer.source.r
    public final void o(r.c cVar) {
        boolean isEmpty = this.f12709b.isEmpty();
        this.f12709b.remove(cVar);
        if (isEmpty || !this.f12709b.isEmpty()) {
            return;
        }
        v();
    }

    @Override // androidx.media3.exoplayer.source.r
    public /* synthetic */ boolean q(androidx.media3.common.t tVar) {
        return g2.k.a(this, tVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final r.a r(int i11, r.b bVar) {
        return this.f12711d.u(i11, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final r.a s(r.b bVar) {
        return this.f12711d.u(0, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final s.a t(int i11, r.b bVar) {
        return this.f12710c.H(i11, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final s.a u(r.b bVar) {
        return this.f12710c.H(0, bVar);
    }

    protected void v() {
    }

    protected void w() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final f4 x() {
        return (f4) androidx.media3.common.util.a.i(this.f12714g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean y() {
        return !this.f12709b.isEmpty();
    }

    protected abstract void z(w1.n nVar);
}
