package com.transsnet.flow.event;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsnet.flow.event.FlowEventBus", f = "FlowEventBus.kt", l = {64}, m = "observeWithoutLifecycle")
/* loaded from: classes7.dex */
public final class FlowEventBus$observeWithoutLifecycle$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowEventBus this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowEventBus$observeWithoutLifecycle$1(FlowEventBus flowEventBus, Continuation<? super FlowEventBus$observeWithoutLifecycle$1> continuation) {
        super(continuation);
        this.this$0 = flowEventBus;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.observeWithoutLifecycle(null, false, null, this);
    }
}
