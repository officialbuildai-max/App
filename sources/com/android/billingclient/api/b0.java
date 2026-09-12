package com.android.billingclient.api;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class b0 implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final ThreadFactory f19124a = Executors.defaultThreadFactory();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f19125b = new AtomicInteger(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(i iVar) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger = this.f19125b;
        Thread newThread = this.f19124a.newThread(runnable);
        newThread.setName("PlayBillingLibrary-" + atomicInteger.getAndIncrement());
        return newThread;
    }
}
