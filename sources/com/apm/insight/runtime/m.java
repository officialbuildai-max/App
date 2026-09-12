package com.apm.insight.runtime;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes2.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static volatile p f19908a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile Handler f19909b;

    public static p a() {
        if (f19908a == null) {
            b();
        }
        return f19908a;
    }

    private static HandlerThread b() {
        if (f19908a == null) {
            synchronized (m.class) {
                try {
                    if (f19908a == null) {
                        p pVar = new p("default_npth_thread");
                        f19908a = pVar;
                        pVar.b();
                    }
                } finally {
                }
            }
        }
        return f19908a.c();
    }
}
