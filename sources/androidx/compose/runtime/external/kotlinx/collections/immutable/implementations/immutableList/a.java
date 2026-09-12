package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
public abstract class a implements ListIterator, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    private int f3778a;

    /* renamed from: b, reason: collision with root package name */
    private int f3779b;

    public a(int i11, int i12) {
        this.f3778a = i11;
        this.f3779b = i12;
    }

    public final void a() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void c() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
    }

    public final int e() {
        return this.f3778a;
    }

    public final int f() {
        return this.f3779b;
    }

    public final void h(int i11) {
        this.f3778a = i11;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.f3778a < this.f3779b;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.f3778a > 0;
    }

    public final void i(int i11) {
        this.f3779b = i11;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.f3778a;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.f3778a - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
