package androidx.compose.runtime;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
final class j0 implements Iterator, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    private final j2 f3846a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3847b;

    /* renamed from: c, reason: collision with root package name */
    private int f3848c;

    /* renamed from: d, reason: collision with root package name */
    private final int f3849d;

    public j0(j2 j2Var, int i11, int i12) {
        this.f3846a = j2Var;
        this.f3847b = i12;
        this.f3848c = i11;
        this.f3849d = j2Var.t();
        if (j2Var.u()) {
            throw new ConcurrentModificationException();
        }
    }

    private final void c() {
        if (this.f3846a.t() != this.f3849d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public androidx.compose.runtime.tooling.b next() {
        int I;
        c();
        int i11 = this.f3848c;
        I = l2.I(this.f3846a.o(), i11);
        this.f3848c = I + i11;
        return new k2(this.f3846a, i11, this.f3849d);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3848c < this.f3847b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
