package com.tn.lib.thread;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class e implements a {

    /* renamed from: b, reason: collision with root package name */
    private final Runnable f40931b;

    public e(Runnable mRunnable) {
        Intrinsics.h(mRunnable, "mRunnable");
        this.f40931b = mRunnable;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        this.f40931b.run();
        a.f40919a.a().remove(this);
        return false;
    }
}
