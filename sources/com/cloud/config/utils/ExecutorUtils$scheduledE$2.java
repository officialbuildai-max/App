package com.cloud.config.utils;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
final class ExecutorUtils$scheduledE$2 extends Lambda implements Function0<ScheduledThreadPoolExecutor> {
    public static final ExecutorUtils$scheduledE$2 INSTANCE = new ExecutorUtils$scheduledE$2();

    ExecutorUtils$scheduledE$2() {
        super(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0, reason: not valid java name */
    public static final Thread m664invoke$lambda0(final Runnable runnable) {
        AtomicInteger atomicInteger;
        atomicInteger = ExecutorUtils.scheduledA;
        return ThreadsKt.b(false, false, null, Intrinsics.q("SCHEDULED ", Integer.valueOf(atomicInteger.incrementAndGet())), 1, new Function0<Unit>() { // from class: com.cloud.config.utils.ExecutorUtils$scheduledE$2$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m665invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m665invoke() {
                runnable.run();
            }
        }, 6, null);
    }

    @Override // kotlin.jvm.functions.Function0
    public final ScheduledThreadPoolExecutor invoke() {
        return new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: com.cloud.config.utils.e
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread m664invoke$lambda0;
                m664invoke$lambda0 = ExecutorUtils$scheduledE$2.m664invoke$lambda0(runnable);
                return m664invoke$lambda0;
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }
}
