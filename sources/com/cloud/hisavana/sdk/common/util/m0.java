package com.cloud.hisavana.sdk.common.util;

import com.cloud.sdk.commonutil.util.DeviceUtil;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class m0 {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f22245a = new AtomicInteger();

    public static String a() {
        return DeviceUtil.o();
    }

    public static String b() {
        String valueOf = String.valueOf(f22245a.incrementAndGet());
        String valueOf2 = String.valueOf((int) (((new SecureRandom().nextDouble() * 9.0d) + 1.0d) * 100000.0d));
        return valueOf + String.valueOf(System.currentTimeMillis()) + valueOf2;
    }
}
