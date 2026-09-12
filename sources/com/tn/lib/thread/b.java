package com.tn.lib.thread;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f40922a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static final List f40923b = new ArrayList();

    private b() {
    }

    public final void a(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        e eVar = new e(runnable);
        a.f40919a.a().add(eVar);
        if (Intrinsics.c(Looper.getMainLooper(), Looper.myLooper())) {
            Looper.myQueue().addIdleHandler(eVar);
        } else {
            Looper.getMainLooper().getQueue().addIdleHandler(eVar);
        }
    }
}
