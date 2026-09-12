package x3;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final Function0 f78162a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f78163b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f78164c;

    public a(Function0 closeAction) {
        Intrinsics.h(closeAction, "closeAction");
        this.f78162a = closeAction;
        this.f78163b = new AtomicInteger(0);
        this.f78164c = new AtomicBoolean(false);
    }

    private final boolean b() {
        return this.f78164c.get();
    }

    public final boolean a() {
        synchronized (this) {
            if (b()) {
                return false;
            }
            this.f78163b.incrementAndGet();
            return true;
        }
    }

    public final void c() {
        synchronized (this) {
            this.f78163b.decrementAndGet();
            if (this.f78163b.get() < 0) {
                throw new IllegalStateException("Unbalanced call to unblock() detected.");
            }
            Unit unit = Unit.f67184a;
        }
    }
}
