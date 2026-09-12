package com.transsion.payment.lib.strategy;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.payment.lib.strategy.GoogleStrategy", f = "GoogleStrategy.kt", l = {289}, m = "handlePurchase")
/* loaded from: classes6.dex */
public final class GoogleStrategy$handlePurchase$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GoogleStrategy this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleStrategy$handlePurchase$1(GoogleStrategy googleStrategy, Continuation<? super GoogleStrategy$handlePurchase$1> continuation) {
        super(continuation);
        this.this$0 = googleStrategy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object B;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        B = this.this$0.B(null, this);
        return B;
    }
}
