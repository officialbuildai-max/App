package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f31252a = new AtomicInteger();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f31253b = new AtomicInteger();

    public void a() {
        this.f31253b.getAndIncrement();
    }

    public void b() {
        this.f31252a.getAndIncrement();
    }

    public void c() {
        this.f31253b.set(0);
    }
}
