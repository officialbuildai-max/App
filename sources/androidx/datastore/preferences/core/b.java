package androidx.datastore.preferences.core;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f8737a;

    public b(boolean z10) {
        this.f8737a = new AtomicBoolean(z10);
    }

    public final boolean a() {
        return this.f8737a.get();
    }

    public final void b(boolean z10) {
        this.f8737a.set(z10);
    }
}
