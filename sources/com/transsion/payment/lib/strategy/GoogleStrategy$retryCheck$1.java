package com.transsion.payment.lib.strategy;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.payment.lib.strategy.GoogleStrategy", f = "GoogleStrategy.kt", l = {335, 337}, m = "retryCheck")
/* loaded from: classes6.dex */
public final class GoogleStrategy$retryCheck$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GoogleStrategy this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleStrategy$retryCheck$1(GoogleStrategy googleStrategy, Continuation<? super GoogleStrategy$retryCheck$1> continuation) {
        super(continuation);
        this.this$0 = googleStrategy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object J;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        J = this.this$0.J(0L, null, this);
        return J;
    }
}
