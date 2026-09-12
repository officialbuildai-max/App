package com.transsion.ad.bidding.base;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.ad.bidding.base.AbsAdBidding", f = "AbsAdBidding.kt", l = {1163, 1192}, m = "getBiddingPlan")
/* loaded from: classes5.dex */
public final class AbsAdBidding$getBiddingPlan$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AbsAdBidding this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsAdBidding$getBiddingPlan$1(AbsAdBidding absAdBidding, Continuation<? super AbsAdBidding$getBiddingPlan$1> continuation) {
        super(continuation);
        this.this$0 = absAdBidding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d02;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        d02 = this.this$0.d0(null, 0, this);
        return d02;
    }
}
