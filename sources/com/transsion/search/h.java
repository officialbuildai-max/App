package com.transsion.search;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static final a f52235b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f52236c = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.search.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            h b11;
            b11 = h.b();
            return b11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f52237a = Executors.newFixedThreadPool(3);

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h a() {
            return (h) h.f52236c.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h b() {
        return new h();
    }

    public final void d(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        ExecutorService executorService = this.f52237a;
        if (executorService != null) {
            executorService.submit(runnable);
        }
    }
}
