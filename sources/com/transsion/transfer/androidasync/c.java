package com.transsion.transfer.androidasync;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    Semaphore f55327a = new Semaphore(0);

    public void a() {
        ThreadQueue orCreateThreadQueue = ThreadQueue.getOrCreateThreadQueue(Thread.currentThread());
        c cVar = orCreateThreadQueue.waiter;
        orCreateThreadQueue.waiter = this;
        Semaphore semaphore = orCreateThreadQueue.queueSemaphore;
        try {
            if (this.f55327a.tryAcquire()) {
                return;
            }
            while (true) {
                Runnable remove = orCreateThreadQueue.remove();
                if (remove == null) {
                    semaphore.acquire(Math.max(1, semaphore.availablePermits()));
                    if (this.f55327a.tryAcquire()) {
                        return;
                    }
                } else {
                    remove.run();
                }
            }
        } finally {
            orCreateThreadQueue.waiter = cVar;
        }
    }

    public void b() {
        this.f55327a.release();
        ThreadQueue.release(this);
    }

    public boolean c(long j11, TimeUnit timeUnit) {
        long convert = TimeUnit.MILLISECONDS.convert(j11, timeUnit);
        ThreadQueue orCreateThreadQueue = ThreadQueue.getOrCreateThreadQueue(Thread.currentThread());
        c cVar = orCreateThreadQueue.waiter;
        orCreateThreadQueue.waiter = this;
        Semaphore semaphore = orCreateThreadQueue.queueSemaphore;
        try {
            if (this.f55327a.tryAcquire()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            while (true) {
                Runnable remove = orCreateThreadQueue.remove();
                if (remove != null) {
                    remove.run();
                } else {
                    if (!semaphore.tryAcquire(Math.max(1, semaphore.availablePermits()), convert, TimeUnit.MILLISECONDS)) {
                        return false;
                    }
                    if (this.f55327a.tryAcquire()) {
                        return true;
                    }
                    if (System.currentTimeMillis() - currentTimeMillis >= convert) {
                        return false;
                    }
                }
            }
        } finally {
            orCreateThreadQueue.waiter = cVar;
        }
    }
}
