package com.google.common.util.concurrent;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;

/* loaded from: classes4.dex */
public abstract class AbstractScheduledService {

    /* renamed from: a, reason: collision with root package name */
    private static final q f31048a = new q(AbstractScheduledService.class);

    /* loaded from: classes4.dex */
    private final class ServiceDelegate extends b {

        /* loaded from: classes4.dex */
        class Task implements Runnable {
            final /* synthetic */ ServiceDelegate this$1;

            Task(ServiceDelegate serviceDelegate) {
            }

            @Override // java.lang.Runnable
            public void run() {
                ServiceDelegate.c(null).lock();
                try {
                    ServiceDelegate.d(null);
                    throw null;
                } catch (Throwable th2) {
                    try {
                        w.b(th2);
                        try {
                            throw null;
                        } catch (Exception e11) {
                            w.b(e11);
                            AbstractScheduledService.f31048a.a().log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e11);
                            throw null;
                        }
                    } catch (Throwable th3) {
                        ServiceDelegate.c(null).unlock();
                        throw th3;
                    }
                }
            }
        }

        static /* synthetic */ ReentrantLock c(ServiceDelegate serviceDelegate) {
            throw null;
        }

        static /* synthetic */ a d(ServiceDelegate serviceDelegate) {
            throw null;
        }
    }

    /* loaded from: classes4.dex */
    interface a {
    }
}
