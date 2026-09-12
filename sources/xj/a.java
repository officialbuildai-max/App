package xj;

import com.therouter.router.RouteItem;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a implements bg.b {

    /* renamed from: a, reason: collision with root package name */
    private final bg.b f78430a;

    /* renamed from: b, reason: collision with root package name */
    private final RouteItem f78431b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f78432c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f78433d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f78434e;

    public a(bg.b delegate, RouteItem postcard) {
        Intrinsics.h(delegate, "delegate");
        Intrinsics.h(postcard, "postcard");
        this.f78430a = delegate;
        this.f78431b = postcard;
        this.f78432c = new AtomicBoolean(false);
        this.f78433d = new AtomicBoolean(false);
        this.f78434e = new AtomicBoolean(false);
    }

    @Override // bg.b
    public void a(RouteItem postcard) {
        Intrinsics.h(postcard, "postcard");
        if (this.f78432c.get()) {
            return;
        }
        this.f78433d.set(true);
    }

    public final boolean b() {
        if (this.f78432c.get() || !this.f78433d.get() || !this.f78434e.compareAndSet(false, true)) {
            return false;
        }
        this.f78430a.a(this.f78431b);
        return true;
    }

    public final void c() {
        this.f78432c.set(true);
    }
}
