package v;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes2.dex */
public class c implements Iterator, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    private Object f77087a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f77088b;

    /* renamed from: c, reason: collision with root package name */
    private int f77089c;

    public c(Object obj, Map map) {
        this.f77087a = obj;
        this.f77088b = map;
    }

    private final void a() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f77089c < this.f77088b.size();
    }

    @Override // java.util.Iterator
    public Object next() {
        a();
        Object obj = this.f77087a;
        this.f77089c++;
        Object obj2 = this.f77088b.get(obj);
        if (obj2 != null) {
            this.f77087a = ((a) obj2).c();
            return obj;
        }
        throw new ConcurrentModificationException("Hash code of an element (" + obj + ") has changed after it was added to the persistent set.");
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
