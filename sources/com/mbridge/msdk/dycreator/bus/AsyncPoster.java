package com.mbridge.msdk.dycreator.bus;

/* loaded from: classes5.dex */
class AsyncPoster implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final PendingPostQueue f34828a = new PendingPostQueue();

    /* renamed from: b, reason: collision with root package name */
    private final EventBus f34829b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsyncPoster(EventBus eventBus) {
        this.f34829b = eventBus;
    }

    public void enqueue(Subscription subscription, Object obj) {
        this.f34828a.a(PendingPost.a(subscription, obj));
        EventBus.f34833n.execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        PendingPost a11 = this.f34828a.a();
        if (a11 == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f34829b.a(a11);
    }
}
