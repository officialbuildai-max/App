package com.tn.tranpay;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.tn.tranpay.TranPayConfiguration", f = "TranPayConfiguration.kt", l = {80, 88, 91}, m = "getCurrencyInfoBean")
/* loaded from: classes4.dex */
public final class TranPayConfiguration$getCurrencyInfoBean$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TranPayConfiguration this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TranPayConfiguration$getCurrencyInfoBean$1(TranPayConfiguration tranPayConfiguration, Continuation<? super TranPayConfiguration$getCurrencyInfoBean$1> continuation) {
        super(continuation);
        this.this$0 = tranPayConfiguration;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object o11;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        o11 = this.this$0.o(this);
        return o11;
    }
}
