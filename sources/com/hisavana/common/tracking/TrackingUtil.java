package com.hisavana.common.tracking;

import com.cloud.sdk.commonutil.util.DeviceUtil;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class TrackingUtil {
    private static final AtomicInteger atomicInteger = new AtomicInteger();

    public static String getRequestId() {
        return DeviceUtil.o();
    }

    public static String getTriggerId() {
        String valueOf = String.valueOf(atomicInteger.incrementAndGet());
        String valueOf2 = String.valueOf((int) (((Math.random() * 9.0d) + 1.0d) * 100000.0d));
        return valueOf + String.valueOf(System.currentTimeMillis()) + valueOf2;
    }
}
