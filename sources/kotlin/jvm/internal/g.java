package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes7.dex */
final class g implements Iterator, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f67436a;

    /* renamed from: b, reason: collision with root package name */
    private int f67437b;

    public g(Object[] array) {
        Intrinsics.h(array, "array");
        this.f67436a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f67437b < this.f67436a.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            Object[] objArr = this.f67436a;
            int i11 = this.f67437b;
            this.f67437b = i11 + 1;
            return objArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.f67437b--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
