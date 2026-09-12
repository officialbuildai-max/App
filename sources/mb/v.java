package mb;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class v implements ic.b {

    /* renamed from: b, reason: collision with root package name */
    private volatile Set f69624b = null;

    /* renamed from: a, reason: collision with root package name */
    private volatile Set f69623a = Collections.newSetFromMap(new ConcurrentHashMap());

    v(Collection collection) {
        this.f69623a.addAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static v b(Collection collection) {
        return new v((Set) collection);
    }

    private synchronized void d() {
        try {
            Iterator it = this.f69623a.iterator();
            while (it.hasNext()) {
                this.f69624b.add(((ic.b) it.next()).get());
            }
            this.f69623a = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(ic.b bVar) {
        try {
            if (this.f69624b == null) {
                this.f69623a.add(bVar);
            } else {
                this.f69624b.add(bVar.get());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // ic.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Set get() {
        if (this.f69624b == null) {
            synchronized (this) {
                try {
                    if (this.f69624b == null) {
                        this.f69624b = Collections.newSetFromMap(new ConcurrentHashMap());
                        d();
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableSet(this.f69624b);
    }
}
