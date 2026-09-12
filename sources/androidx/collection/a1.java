package androidx.collection;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
public abstract class a1 {

    /* loaded from: classes.dex */
    public static final class a implements Iterator, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        private int f2336a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ y0 f2337b;

        a(y0 y0Var) {
            this.f2337b = y0Var;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2336a < this.f2337b.p();
        }

        @Override // java.util.Iterator
        public Object next() {
            y0 y0Var = this.f2337b;
            int i11 = this.f2336a;
            this.f2336a = i11 + 1;
            return y0Var.q(i11);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final Iterator a(y0 y0Var) {
        Intrinsics.h(y0Var, "<this>");
        return new a(y0Var);
    }
}
