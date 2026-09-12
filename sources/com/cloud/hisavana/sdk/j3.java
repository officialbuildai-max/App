package com.cloud.hisavana.sdk;

import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public abstract class j3 {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f22637a = new AtomicInteger();

    public static String a() {
        String valueOf = String.valueOf(f22637a.incrementAndGet());
        String valueOf2 = String.valueOf((int) (((new SecureRandom().nextDouble() * 9.0d) + 1.0d) * 100000.0d));
        return valueOf + String.valueOf(System.currentTimeMillis()) + valueOf2;
    }
}
