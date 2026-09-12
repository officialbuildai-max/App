package com.bykv.vk.openvk.preload.geckox.utils;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class f implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private static volatile f f20842a;

    public static f a() {
        if (f20842a == null) {
            synchronized (f.class) {
                try {
                    if (f20842a == null) {
                        f20842a = new f();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f20842a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        com.bykv.vk.openvk.preload.geckox.b.t().execute(runnable);
    }
}
