package androidx.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMutableIterator;

/* loaded from: classes.dex */
public abstract class k implements Iterator, KMutableIterator {

    /* renamed from: a, reason: collision with root package name */
    private int f2364a;

    /* renamed from: b, reason: collision with root package name */
    private int f2365b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2366c;

    public k(int i11) {
        this.f2364a = i11;
    }

    protected abstract Object a(int i11);

    protected abstract void c(int i11);

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f2365b < this.f2364a;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object a11 = a(this.f2365b);
        this.f2365b++;
        this.f2366c = true;
        return a11;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.f2366c) {
            n.d.b("Call next() before removing an element.");
        }
        int i11 = this.f2365b - 1;
        this.f2365b = i11;
        c(i11);
        this.f2364a--;
        this.f2366c = false;
    }
}
