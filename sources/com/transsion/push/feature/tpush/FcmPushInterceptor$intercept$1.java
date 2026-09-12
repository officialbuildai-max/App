package com.transsion.push.feature.tpush;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.push.feature.tpush.FcmPushInterceptor", f = "FcmPushInterceptor.kt", l = {77}, m = "intercept")
/* loaded from: classes6.dex */
public final class FcmPushInterceptor$intercept$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FcmPushInterceptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FcmPushInterceptor$intercept$1(FcmPushInterceptor fcmPushInterceptor, Continuation<? super FcmPushInterceptor$intercept$1> continuation) {
        super(continuation);
        this.this$0 = fcmPushInterceptor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.intercept(null, null, this);
    }
}
