package u;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* loaded from: classes2.dex */
public class g extends e implements Iterator, KMutableIterator {

    /* renamed from: d, reason: collision with root package name */
    private final f f76628d;

    /* renamed from: e, reason: collision with root package name */
    private Object f76629e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f76630f;

    /* renamed from: g, reason: collision with root package name */
    private int f76631g;

    public g(f fVar, u[] uVarArr) {
        super(fVar.j(), uVarArr);
        this.f76628d = fVar;
        this.f76631g = fVar.i();
    }

    private final void j() {
        if (this.f76628d.i() != this.f76631g) {
            throw new ConcurrentModificationException();
        }
    }

    private final void l() {
        if (!this.f76630f) {
            throw new IllegalStateException();
        }
    }

    private final void m(int i11, t tVar, Object obj, int i12) {
        int i13 = i12 * 5;
        if (i13 > 30) {
            f()[i12].n(tVar.p(), tVar.p().length, 0);
            while (!Intrinsics.c(f()[i12].a(), obj)) {
                f()[i12].j();
            }
            i(i12);
            return;
        }
        int f11 = 1 << x.f(i11, i13);
        if (tVar.q(f11)) {
            f()[i12].n(tVar.p(), tVar.m() * 2, tVar.n(f11));
            i(i12);
        } else {
            int O = tVar.O(f11);
            t N = tVar.N(O);
            f()[i12].n(tVar.p(), tVar.m() * 2, O);
            m(i11, N, obj, i12 + 1);
        }
    }

    public final void n(Object obj, Object obj2) {
        if (this.f76628d.containsKey(obj)) {
            if (hasNext()) {
                Object c11 = c();
                this.f76628d.put(obj, obj2);
                m(c11 != null ? c11.hashCode() : 0, this.f76628d.j(), c11, 0);
            } else {
                this.f76628d.put(obj, obj2);
            }
            this.f76631g = this.f76628d.i();
        }
    }

    @Override // u.e, java.util.Iterator
    public Object next() {
        j();
        this.f76629e = c();
        this.f76630f = true;
        return super.next();
    }

    @Override // u.e, java.util.Iterator
    public void remove() {
        l();
        if (hasNext()) {
            Object c11 = c();
            TypeIntrinsics.d(this.f76628d).remove(this.f76629e);
            m(c11 != null ? c11.hashCode() : 0, this.f76628d.j(), c11, 0);
        } else {
            TypeIntrinsics.d(this.f76628d).remove(this.f76629e);
        }
        this.f76629e = null;
        this.f76630f = false;
        this.f76631g = this.f76628d.i();
    }
}
