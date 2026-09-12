package com.amazonaws;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class SDKGlobalConfiguration {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f18402a = new AtomicInteger(0);

    public static int a() {
        return f18402a.get();
    }

    public static void b(int i11) {
        f18402a.set(i11);
    }
}
