package com.google.common.util.concurrent;

/* loaded from: classes4.dex */
abstract class w {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Throwable th2, Class cls) {
        return cls.isInstance(th2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Throwable th2) {
        com.google.common.base.m.o(th2);
        if (th2 instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
    }
}
