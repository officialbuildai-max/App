package com.transsion.publish;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class p {

    /* renamed from: b, reason: collision with root package name */
    public static final a f50512b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f50513c = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.publish.o
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            p b11;
            b11 = p.b();
            return b11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f50514a = Executors.newFixedThreadPool(3);

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final p a() {
            return (p) p.f50513c.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final p b() {
        return new p();
    }

    public final void d(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        ExecutorService executorService = this.f50514a;
        if (executorService != null) {
            executorService.submit(runnable);
        }
    }
}
