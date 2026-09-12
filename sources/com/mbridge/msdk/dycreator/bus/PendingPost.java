package com.mbridge.msdk.dycreator.bus;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
final class PendingPost {

    /* renamed from: d, reason: collision with root package name */
    private static final List<PendingPost> f34857d = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    Object f34858a;

    /* renamed from: b, reason: collision with root package name */
    Subscription f34859b;

    /* renamed from: c, reason: collision with root package name */
    PendingPost f34860c;

    private PendingPost(Object obj, Subscription subscription) {
        this.f34858a = obj;
        this.f34859b = subscription;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PendingPost a(Subscription subscription, Object obj) {
        List<PendingPost> list = f34857d;
        synchronized (list) {
            try {
                int size = list.size();
                if (size <= 0) {
                    return new PendingPost(obj, subscription);
                }
                PendingPost remove = list.remove(size - 1);
                remove.f34858a = obj;
                remove.f34859b = subscription;
                remove.f34860c = null;
                return remove;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PendingPost pendingPost) {
        pendingPost.f34858a = null;
        pendingPost.f34859b = null;
        pendingPost.f34860c = null;
        List<PendingPost> list = f34857d;
        synchronized (list) {
            try {
                if (list.size() < 10000) {
                    list.add(pendingPost);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
