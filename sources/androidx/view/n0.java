package androidx.view;

import androidx.view.C1013c;
import androidx.view.Lifecycle;
import java.io.Closeable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class n0 implements r, Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final String f9708a;

    /* renamed from: b, reason: collision with root package name */
    private final l0 f9709b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f9710c;

    public n0(String key, l0 handle) {
        Intrinsics.h(key, "key");
        Intrinsics.h(handle, "handle");
        this.f9708a = key;
        this.f9709b = handle;
    }

    public final void b(C1013c registry, Lifecycle lifecycle) {
        Intrinsics.h(registry, "registry");
        Intrinsics.h(lifecycle, "lifecycle");
        if (this.f9710c) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f9710c = true;
        lifecycle.a(this);
        registry.h(this.f9708a, this.f9709b.c());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final l0 d() {
        return this.f9709b;
    }

    public final boolean h() {
        return this.f9710c;
    }

    @Override // androidx.view.r
    public void onStateChanged(u source, Lifecycle.Event event) {
        Intrinsics.h(source, "source");
        Intrinsics.h(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f9710c = false;
            source.getLifecycle().d(this);
        }
    }
}
