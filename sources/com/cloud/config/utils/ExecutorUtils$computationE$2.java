package com.cloud.config.utils;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ThreadPoolExecutor;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
final class ExecutorUtils$computationE$2 extends Lambda implements Function0<ThreadPoolExecutor> {
    public static final ExecutorUtils$computationE$2 INSTANCE = new ExecutorUtils$computationE$2();

    ExecutorUtils$computationE$2() {
        super(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0, reason: not valid java name */
    public static final Thread m658invoke$lambda0(final Runnable runnable) {
        AtomicInteger atomicInteger;
        atomicInteger = ExecutorUtils.computationA;
        return ThreadsKt.b(false, false, null, Intrinsics.q("COMPUTATION ", Integer.valueOf(atomicInteger.incrementAndGet())), 5, new Function0<Unit>() { // from class: com.cloud.config.utils.ExecutorUtils$computationE$2$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m659invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m659invoke() {
                runnable.run();
            }
        }, 6, null);
    }

    @Override // kotlin.jvm.functions.Function0
    public final ThreadPoolExecutor invoke() {
        int i11;
        int i12;
        i11 = ExecutorUtils.CPU_CORE;
        i12 = ExecutorUtils.CPU_CORE;
        return new ThreadPoolExecutor(i11, i12, 0L, TimeUnit.NANOSECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.cloud.config.utils.b
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread m658invoke$lambda0;
                m658invoke$lambda0 = ExecutorUtils$computationE$2.m658invoke$lambda0(runnable);
                return m658invoke$lambda0;
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }
}
