package androidx.compose.ui.platform;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class u2 {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.runtime.collection.b f5940a = new androidx.compose.runtime.collection.b(new Reference[16], 0);

    /* renamed from: b, reason: collision with root package name */
    private final ReferenceQueue f5941b = new ReferenceQueue();

    private final void a() {
        Reference poll;
        do {
            poll = this.f5941b.poll();
            if (poll != null) {
                this.f5940a.t(poll);
            }
        } while (poll != null);
    }

    public final Object b() {
        a();
        while (this.f5940a.q()) {
            Object obj = ((Reference) this.f5940a.v(r0.n() - 1)).get();
            if (obj != null) {
                return obj;
            }
        }
        return null;
    }

    public final void c(Object obj) {
        a();
        this.f5940a.b(new WeakReference(obj, this.f5941b));
    }
}
