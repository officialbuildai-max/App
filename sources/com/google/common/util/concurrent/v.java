package com.google.common.util.concurrent;

import java.util.concurrent.locks.LockSupport;

/* loaded from: classes4.dex */
abstract class v {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j11) {
        LockSupport.parkNanos(obj, Math.min(j11, 2147483647999999999L));
    }
}
