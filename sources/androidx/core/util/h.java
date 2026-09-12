package androidx.core.util;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class h extends g {

    /* renamed from: c, reason: collision with root package name */
    private final Object f8351c;

    public h(int i11) {
        super(i11);
        this.f8351c = new Object();
    }

    @Override // androidx.core.util.g, androidx.core.util.f
    public Object acquire() {
        Object acquire;
        synchronized (this.f8351c) {
            acquire = super.acquire();
        }
        return acquire;
    }

    @Override // androidx.core.util.g, androidx.core.util.f
    public boolean release(Object instance) {
        boolean release;
        Intrinsics.h(instance, "instance");
        synchronized (this.f8351c) {
            release = super.release(instance);
        }
        return release;
    }
}
