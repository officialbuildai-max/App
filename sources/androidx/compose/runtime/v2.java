package androidx.compose.runtime;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;

/* loaded from: classes.dex */
public final class v2 {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference f4130a = new AtomicReference(androidx.compose.runtime.internal.g.a());

    /* renamed from: b, reason: collision with root package name */
    private final Object f4131b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private Object f4132c;

    public final Object a() {
        long id2 = Thread.currentThread().getId();
        return id2 == ActualAndroid_androidKt.d() ? this.f4132c : ((androidx.compose.runtime.internal.f) this.f4130a.get()).b(id2);
    }

    public final void b(Object obj) {
        long id2 = Thread.currentThread().getId();
        if (id2 == ActualAndroid_androidKt.d()) {
            this.f4132c = obj;
            return;
        }
        synchronized (this.f4131b) {
            androidx.compose.runtime.internal.f fVar = (androidx.compose.runtime.internal.f) this.f4130a.get();
            if (fVar.d(id2, obj)) {
                return;
            }
            this.f4130a.set(fVar.c(id2, obj));
            Unit unit = Unit.f67184a;
        }
    }
}
