package com.tn.tranpay.event;

import android.app.Application;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f41601a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static Application f41602b;

    private a() {
    }

    public final Application a() {
        Application application = f41602b;
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("TranPay SDK must be initialized by calling TranPay.configure() first! Please ensure TranPay.configure() is called in Application.onCreate() for each process that uses the SDK.");
    }

    public final void b(Application application) {
        Intrinsics.h(application, "application");
        f41602b = application;
    }

    public final boolean c() {
        return f41602b != null;
    }
}
