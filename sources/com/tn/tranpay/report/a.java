package com.tn.tranpay.report;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class a implements ThreadFactory {

    /* renamed from: d, reason: collision with root package name */
    public static final C0593a f41716d = new C0593a(null);

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicInteger f41717e = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    private final ThreadGroup f41718a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f41719b;

    /* renamed from: c, reason: collision with root package name */
    private final String f41720c;

    /* renamed from: com.tn.tranpay.report.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0593a {
        private C0593a() {
        }

        public /* synthetic */ C0593a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(String pre) {
        ThreadGroup threadGroup;
        Intrinsics.h(pre, "pre");
        this.f41719b = new AtomicInteger(1);
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
            Intrinsics.g(threadGroup, "s.threadGroup");
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
            Intrinsics.e(threadGroup);
        }
        this.f41718a = threadGroup;
        this.f41720c = pre + "-pool-" + f41717e.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r11) {
        Intrinsics.h(r11, "r");
        Thread thread = new Thread(this.f41718a, r11, this.f41720c + this.f41719b.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
