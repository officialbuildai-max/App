package q1;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final e f73170a = new e();

    /* renamed from: b, reason: collision with root package name */
    private final Map f73171b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Set f73172c = new LinkedHashSet();

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f73173d;

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (Exception e11) {
                throw new RuntimeException(e11);
            }
        }
    }

    public final void d(AutoCloseable closeable) {
        Intrinsics.h(closeable, "closeable");
        if (this.f73173d) {
            g(closeable);
            return;
        }
        synchronized (this.f73170a) {
            this.f73172c.add(closeable);
            Unit unit = Unit.f67184a;
        }
    }

    public final void e(String key, AutoCloseable closeable) {
        AutoCloseable autoCloseable;
        Intrinsics.h(key, "key");
        Intrinsics.h(closeable, "closeable");
        if (this.f73173d) {
            g(closeable);
            return;
        }
        synchronized (this.f73170a) {
            autoCloseable = (AutoCloseable) this.f73171b.put(key, closeable);
        }
        g(autoCloseable);
    }

    public final void f() {
        if (this.f73173d) {
            return;
        }
        this.f73173d = true;
        synchronized (this.f73170a) {
            try {
                Iterator it = this.f73171b.values().iterator();
                while (it.hasNext()) {
                    g((AutoCloseable) it.next());
                }
                Iterator it2 = this.f73172c.iterator();
                while (it2.hasNext()) {
                    g((AutoCloseable) it2.next());
                }
                this.f73172c.clear();
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final AutoCloseable h(String key) {
        AutoCloseable autoCloseable;
        Intrinsics.h(key, "key");
        synchronized (this.f73170a) {
            autoCloseable = (AutoCloseable) this.f73171b.get(key);
        }
        return autoCloseable;
    }
}
