package com.mbridge.msdk.dycreator.bus;

/* loaded from: classes5.dex */
final class PendingPostQueue {

    /* renamed from: a, reason: collision with root package name */
    private PendingPost f34861a;

    /* renamed from: b, reason: collision with root package name */
    private PendingPost f34862b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized PendingPost a() {
        PendingPost pendingPost;
        pendingPost = this.f34861a;
        if (pendingPost != null) {
            PendingPost pendingPost2 = pendingPost.f34860c;
            this.f34861a = pendingPost2;
            if (pendingPost2 == null) {
                this.f34862b = null;
            }
        }
        return pendingPost;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized PendingPost a(int i11) throws InterruptedException {
        try {
            if (this.f34861a == null) {
                wait(i11);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(PendingPost pendingPost) {
        try {
            if (pendingPost == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            PendingPost pendingPost2 = this.f34862b;
            if (pendingPost2 != null) {
                pendingPost2.f34860c = pendingPost;
                this.f34862b = pendingPost;
            } else {
                if (this.f34861a != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.f34862b = pendingPost;
                this.f34861a = pendingPost;
            }
            notifyAll();
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
