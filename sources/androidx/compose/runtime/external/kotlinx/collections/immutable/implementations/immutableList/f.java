package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class f extends a implements ListIterator, KMutableListIterator {

    /* renamed from: c, reason: collision with root package name */
    private final PersistentVectorBuilder f3788c;

    /* renamed from: d, reason: collision with root package name */
    private int f3789d;

    /* renamed from: e, reason: collision with root package name */
    private i f3790e;

    /* renamed from: f, reason: collision with root package name */
    private int f3791f;

    public f(PersistentVectorBuilder persistentVectorBuilder, int i11) {
        super(i11, persistentVectorBuilder.size());
        this.f3788c = persistentVectorBuilder;
        this.f3789d = persistentVectorBuilder.e();
        this.f3791f = -1;
        n();
    }

    private final void j() {
        if (this.f3789d != this.f3788c.e()) {
            throw new ConcurrentModificationException();
        }
    }

    private final void l() {
        if (this.f3791f == -1) {
            throw new IllegalStateException();
        }
    }

    private final void m() {
        i(this.f3788c.size());
        this.f3789d = this.f3788c.e();
        this.f3791f = -1;
        n();
    }

    private final void n() {
        Object[] f11 = this.f3788c.f();
        if (f11 == null) {
            this.f3790e = null;
            return;
        }
        int d11 = j.d(this.f3788c.size());
        int i11 = RangesKt.i(e(), d11);
        int h11 = (this.f3788c.h() / 5) + 1;
        i iVar = this.f3790e;
        if (iVar == null) {
            this.f3790e = new i(f11, i11, d11, h11);
        } else {
            Intrinsics.e(iVar);
            iVar.n(f11, i11, d11, h11);
        }
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.a, java.util.ListIterator
    public void add(Object obj) {
        j();
        this.f3788c.add(e(), obj);
        h(e() + 1);
        m();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        j();
        a();
        this.f3791f = e();
        i iVar = this.f3790e;
        if (iVar == null) {
            Object[] j11 = this.f3788c.j();
            int e11 = e();
            h(e11 + 1);
            return j11[e11];
        }
        if (iVar.hasNext()) {
            h(e() + 1);
            return iVar.next();
        }
        Object[] j12 = this.f3788c.j();
        int e12 = e();
        h(e12 + 1);
        return j12[e12 - iVar.f()];
    }

    @Override // java.util.ListIterator
    public Object previous() {
        j();
        c();
        this.f3791f = e() - 1;
        i iVar = this.f3790e;
        if (iVar == null) {
            Object[] j11 = this.f3788c.j();
            h(e() - 1);
            return j11[e()];
        }
        if (e() <= iVar.f()) {
            h(e() - 1);
            return iVar.previous();
        }
        Object[] j12 = this.f3788c.j();
        h(e() - 1);
        return j12[e() - iVar.f()];
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.a, java.util.ListIterator, java.util.Iterator
    public void remove() {
        j();
        l();
        this.f3788c.remove(this.f3791f);
        if (this.f3791f < e()) {
            h(this.f3791f);
        }
        m();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.a, java.util.ListIterator
    public void set(Object obj) {
        j();
        l();
        this.f3788c.set(this.f3791f, obj);
        this.f3789d = this.f3788c.e();
        n();
    }
}
