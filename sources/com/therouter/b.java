package com.therouter;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f40778a;

    /* renamed from: b, reason: collision with root package name */
    private long f40779b;

    public b(String trace) {
        Intrinsics.h(trace, "trace");
        this.f40778a = trace;
        this.f40779b = System.currentTimeMillis();
    }

    public final long a() {
        return this.f40779b;
    }

    public final String b() {
        return this.f40778a;
    }
}
