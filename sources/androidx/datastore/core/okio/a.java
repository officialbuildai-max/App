package androidx.datastore.core.okio;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f8706a;

    public a(boolean z10) {
        this.f8706a = new AtomicBoolean(z10);
    }

    public final boolean a() {
        return this.f8706a.get();
    }

    public final void b(boolean z10) {
        this.f8706a.set(z10);
    }
}
