package com.mbridge.msdk.dycreator.bus;

/* loaded from: classes5.dex */
final class Subscription {

    /* renamed from: a, reason: collision with root package name */
    final Object f34869a;

    /* renamed from: b, reason: collision with root package name */
    final SubscriberMethod f34870b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Subscription(Object obj, SubscriberMethod subscriberMethod) {
        this.f34869a = obj;
        this.f34870b = subscriberMethod;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Subscription)) {
            return false;
        }
        Subscription subscription = (Subscription) obj;
        return this.f34869a == subscription.f34869a && this.f34870b.equals(subscription.f34870b);
    }

    public int hashCode() {
        return this.f34869a.hashCode() + this.f34870b.f34866d.hashCode();
    }
}
