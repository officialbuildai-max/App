package com.transsion.transfer.androidasync;

import java.io.Closeable;
import java.nio.channels.Selector;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class x implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private Selector f55721a;

    /* renamed from: b, reason: collision with root package name */
    public AtomicBoolean f55722b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    Semaphore f55723c = new Semaphore(0);

    public x(Selector selector) {
        this.f55721a = selector;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f55721a.close();
    }

    public Selector d() {
        return this.f55721a;
    }

    public Set h() {
        return this.f55721a.keys();
    }

    public boolean isOpen() {
        return this.f55721a.isOpen();
    }

    public void k() {
        l(0L);
    }

    public void l(long j11) {
        try {
            this.f55723c.drainPermits();
            this.f55721a.select(j11);
        } finally {
            this.f55723c.release(Integer.MAX_VALUE);
        }
    }

    public int m() {
        return this.f55721a.selectNow();
    }

    public Set n() {
        return this.f55721a.selectedKeys();
    }

    public boolean o() {
        for (int i11 = 0; i11 < 100; i11++) {
            try {
                this.f55723c.tryAcquire(10L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                return true;
            }
        }
        return false;
    }

    public void p() {
        boolean tryAcquire = this.f55723c.tryAcquire();
        this.f55721a.wakeup();
        if (tryAcquire) {
            if (this.f55722b.getAndSet(true)) {
                this.f55721a.wakeup();
                return;
            }
            try {
                o();
                this.f55721a.wakeup();
            } finally {
                this.f55722b.set(false);
            }
        }
    }
}
