package y00;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes7.dex */
class b implements Iterator {

    /* renamed from: c, reason: collision with root package name */
    private static final WeakHashMap f78678c = new WeakHashMap();

    /* renamed from: a, reason: collision with root package name */
    private Object f78679a;

    /* renamed from: b, reason: collision with root package name */
    private Iterator f78680b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Object obj, Iterator it) {
        if (obj == null) {
            throw new IllegalArgumentException("parent object is null");
        }
        if (it == null) {
            throw new IllegalArgumentException("cannot wrap null iterator");
        }
        this.f78679a = obj;
        if (it.hasNext()) {
            this.f78680b = it;
            a(this);
        }
    }

    private static synchronized void a(b bVar) {
        synchronized (b.class) {
            try {
                WeakHashMap weakHashMap = f78678c;
                Set set = (Set) weakHashMap.get(bVar.f78679a);
                if (set == null) {
                    set = new HashSet();
                    weakHashMap.put(bVar.f78679a, set);
                }
                set.add(bVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static synchronized void b(b bVar) {
        synchronized (b.class) {
            if (!((Set) f78678c.get(bVar.f78679a)).contains(bVar)) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Object obj) {
        synchronized (b.class) {
            Set set = (Set) f78678c.get(obj);
            if (set != null) {
                set.clear();
            }
        }
    }

    private static synchronized void d(b bVar) {
        synchronized (b.class) {
            Set set = (Set) f78678c.get(bVar.f78679a);
            if (set != null) {
                set.remove(bVar);
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f78680b == null) {
            return false;
        }
        b(this);
        return this.f78680b.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        Iterator it = this.f78680b;
        if (it == null || !it.hasNext()) {
            throw new NoSuchElementException();
        }
        b(this);
        try {
            return this.f78680b.next();
        } finally {
            if (!this.f78680b.hasNext()) {
                this.f78680b = null;
                d(this);
            }
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
