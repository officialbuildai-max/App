package com.cloud.hisavana.sdk;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class b2 {

    /* renamed from: a, reason: collision with root package name */
    public static final b2 f21767a = new b2();

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicLong f21768b = new AtomicLong(0);

    /* renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap f21769c = new ConcurrentHashMap();

    private b2() {
    }

    private final long a() {
        return f21768b.incrementAndGet();
    }

    public final long b(q observer) {
        Intrinsics.h(observer, "observer");
        long a11 = a();
        if (e4.c()) {
            e4.b().d("Rewarded", "registerObserver " + a11);
        }
        f21769c.put(Long.valueOf(a11), observer);
        return a11;
    }

    public final void c(long j11) {
        if (e4.c()) {
            e4.b().d("Rewarded", "unregisterObserver " + j11);
        }
        try {
            f21769c.remove(Long.valueOf(j11));
        } catch (Exception e11) {
            e4.b().w("Rewarded", "Failed to unregister observer: " + e11.getMessage(), e11);
        }
    }

    public final void d(long j11, String event, Object obj) {
        Intrinsics.h(event, "event");
        if (e4.c()) {
            e4.b().d("Rewarded", "broadcast " + j11 + ", " + event);
        }
        try {
            q qVar = (q) f21769c.get(Long.valueOf(j11));
            if (qVar != null) {
                qVar.a(j11, event, obj);
            }
        } catch (Exception e11) {
            e4.b().e("Rewarded", "Error in observer.onEvent: " + e11.getMessage());
        }
    }
}
