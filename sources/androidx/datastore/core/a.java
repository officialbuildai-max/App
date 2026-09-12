package androidx.datastore.core;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f8672a;

    public a(int i11) {
        this.f8672a = new AtomicInteger(i11);
    }

    public final int a() {
        return this.f8672a.decrementAndGet();
    }

    public final int b() {
        return this.f8672a.get();
    }

    public final int c() {
        return this.f8672a.getAndIncrement();
    }

    public final int d() {
        return this.f8672a.incrementAndGet();
    }
}
