package com.mbridge.msdk.dycreator.bus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: classes5.dex */
final class HandlerPoster extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final PendingPostQueue f34853a;

    /* renamed from: b, reason: collision with root package name */
    private final int f34854b;

    /* renamed from: c, reason: collision with root package name */
    private final EventBus f34855c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f34856d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerPoster(EventBus eventBus, Looper looper, int i11) {
        super(looper);
        this.f34855c = eventBus;
        this.f34854b = i11;
        this.f34853a = new PendingPostQueue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Subscription subscription, Object obj) {
        PendingPost a11 = PendingPost.a(subscription, obj);
        synchronized (this) {
            try {
                this.f34853a.a(a11);
                if (!this.f34856d) {
                    this.f34856d = true;
                    if (!sendMessage(obtainMessage())) {
                        throw new EventBusException("Could not send handler message");
                    }
                }
            } finally {
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                PendingPost a11 = this.f34853a.a();
                if (a11 == null) {
                    synchronized (this) {
                        a11 = this.f34853a.a();
                        if (a11 == null) {
                            this.f34856d = false;
                            return;
                        }
                    }
                }
                this.f34855c.a(a11);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.f34854b);
            if (!sendMessage(obtainMessage())) {
                throw new EventBusException("Could not send handler message");
            }
            this.f34856d = true;
        } catch (Throwable th2) {
            this.f34856d = false;
            throw th2;
        }
    }
}
