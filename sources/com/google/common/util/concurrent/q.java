package com.google.common.util.concurrent;

import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private final Object f31089a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final String f31090b;

    /* renamed from: c, reason: collision with root package name */
    private volatile Logger f31091c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Class cls) {
        this.f31090b = cls.getName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Logger a() {
        Logger logger = this.f31091c;
        if (logger != null) {
            return logger;
        }
        synchronized (this.f31089a) {
            try {
                Logger logger2 = this.f31091c;
                if (logger2 != null) {
                    return logger2;
                }
                Logger logger3 = Logger.getLogger(this.f31090b);
                this.f31091c = logger3;
                return logger3;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
