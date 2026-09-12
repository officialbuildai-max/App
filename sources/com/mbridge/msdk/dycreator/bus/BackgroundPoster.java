package com.mbridge.msdk.dycreator.bus;

import android.util.Log;

/* loaded from: classes5.dex */
final class BackgroundPoster implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final PendingPostQueue f34830a = new PendingPostQueue();

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f34831b;

    /* renamed from: c, reason: collision with root package name */
    private final EventBus f34832c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackgroundPoster(EventBus eventBus) {
        this.f34832c = eventBus;
    }

    public void enqueue(Subscription subscription, Object obj) {
        PendingPost a11 = PendingPost.a(subscription, obj);
        synchronized (this) {
            try {
                this.f34830a.a(a11);
                if (!this.f34831b) {
                    this.f34831b = true;
                    EventBus.f34833n.execute(this);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                try {
                    PendingPost a11 = this.f34830a.a(1000);
                    if (a11 == null) {
                        synchronized (this) {
                            a11 = this.f34830a.a();
                            if (a11 == null) {
                                this.f34831b = false;
                                this.f34831b = false;
                                return;
                            }
                        }
                    }
                    this.f34832c.a(a11);
                } catch (InterruptedException e11) {
                    Log.w("Event", Thread.currentThread().getName() + " was interruppted", e11);
                    this.f34831b = false;
                    return;
                }
            } catch (Throwable th2) {
                this.f34831b = false;
                throw th2;
            }
        }
    }
}
