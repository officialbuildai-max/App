package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.upstream.k0;
import e9.u1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class a implements o {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f25732a = new ArrayList(1);

    /* renamed from: b, reason: collision with root package name */
    private final HashSet f25733b = new HashSet(1);

    /* renamed from: c, reason: collision with root package name */
    private final p.a f25734c = new p.a();

    /* renamed from: d, reason: collision with root package name */
    private final s.a f25735d = new s.a();

    /* renamed from: e, reason: collision with root package name */
    private Looper f25736e;

    /* renamed from: f, reason: collision with root package name */
    private k3 f25737f;

    /* renamed from: g, reason: collision with root package name */
    private u1 f25738g;

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean A() {
        return !this.f25733b.isEmpty();
    }

    protected abstract void B(k0 k0Var);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void C(k3 k3Var) {
        this.f25737f = k3Var;
        Iterator it = this.f25732a.iterator();
        while (it.hasNext()) {
            ((o.c) it.next()).a(this, k3Var);
        }
    }

    protected abstract void D();

    @Override // com.google.android.exoplayer2.source.o
    public /* synthetic */ boolean b() {
        return t9.k.b(this);
    }

    @Override // com.google.android.exoplayer2.source.o
    public /* synthetic */ k3 c() {
        return t9.k.a(this);
    }

    @Override // com.google.android.exoplayer2.source.o
    public final void e(o.c cVar) {
        this.f25732a.remove(cVar);
        if (!this.f25732a.isEmpty()) {
            o(cVar);
            return;
        }
        this.f25736e = null;
        this.f25737f = null;
        this.f25738g = null;
        this.f25733b.clear();
        D();
    }

    @Override // com.google.android.exoplayer2.source.o
    public final void g(Handler handler, p pVar) {
        com.google.android.exoplayer2.util.a.e(handler);
        com.google.android.exoplayer2.util.a.e(pVar);
        this.f25734c.g(handler, pVar);
    }

    @Override // com.google.android.exoplayer2.source.o
    public final void h(p pVar) {
        this.f25734c.C(pVar);
    }

    @Override // com.google.android.exoplayer2.source.o
    public final void i(o.c cVar, k0 k0Var, u1 u1Var) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.f25736e;
        com.google.android.exoplayer2.util.a.a(looper == null || looper == myLooper);
        this.f25738g = u1Var;
        k3 k3Var = this.f25737f;
        this.f25732a.add(cVar);
        if (this.f25736e == null) {
            this.f25736e = myLooper;
            this.f25733b.add(cVar);
            B(k0Var);
        } else if (k3Var != null) {
            m(cVar);
            cVar.a(this, k3Var);
        }
    }

    @Override // com.google.android.exoplayer2.source.o
    public final void m(o.c cVar) {
        com.google.android.exoplayer2.util.a.e(this.f25736e);
        boolean isEmpty = this.f25733b.isEmpty();
        this.f25733b.add(cVar);
        if (isEmpty) {
            y();
        }
    }

    @Override // com.google.android.exoplayer2.source.o
    public final void o(o.c cVar) {
        boolean isEmpty = this.f25733b.isEmpty();
        this.f25733b.remove(cVar);
        if (isEmpty || !this.f25733b.isEmpty()) {
            return;
        }
        x();
    }

    @Override // com.google.android.exoplayer2.source.o
    public final void q(Handler handler, com.google.android.exoplayer2.drm.s sVar) {
        com.google.android.exoplayer2.util.a.e(handler);
        com.google.android.exoplayer2.util.a.e(sVar);
        this.f25735d.g(handler, sVar);
    }

    @Override // com.google.android.exoplayer2.source.o
    public final void r(com.google.android.exoplayer2.drm.s sVar) {
        this.f25735d.t(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final s.a s(int i11, o.b bVar) {
        return this.f25735d.u(i11, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final s.a t(o.b bVar) {
        return this.f25735d.u(0, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final p.a u(int i11, o.b bVar, long j11) {
        return this.f25734c.F(i11, bVar, j11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final p.a v(o.b bVar) {
        return this.f25734c.F(0, bVar, 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final p.a w(o.b bVar, long j11) {
        com.google.android.exoplayer2.util.a.e(bVar);
        return this.f25734c.F(0, bVar, j11);
    }

    protected void x() {
    }

    protected void y() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final u1 z() {
        return (u1) com.google.android.exoplayer2.util.a.i(this.f25738g);
    }
}
