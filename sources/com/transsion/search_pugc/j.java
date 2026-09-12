package com.transsion.search_pugc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    public static final a f52544b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f52545c = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.search_pugc.i
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            j b11;
            b11 = j.b();
            return b11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f52546a = Executors.newFixedThreadPool(3);

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final j a() {
            return (j) j.f52545c.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final j b() {
        return new j();
    }

    public final void d(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        ExecutorService executorService = this.f52546a;
        if (executorService != null) {
            executorService.submit(runnable);
        }
    }
}
