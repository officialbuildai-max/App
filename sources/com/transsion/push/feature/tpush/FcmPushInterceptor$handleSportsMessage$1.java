package com.transsion.push.feature.tpush;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.push.feature.tpush.FcmPushInterceptor", f = "FcmPushInterceptor.kt", l = {88}, m = "handleSportsMessage")
/* loaded from: classes6.dex */
public final class FcmPushInterceptor$handleSportsMessage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FcmPushInterceptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FcmPushInterceptor$handleSportsMessage$1(FcmPushInterceptor fcmPushInterceptor, Continuation<? super FcmPushInterceptor$handleSportsMessage$1> continuation) {
        super(continuation);
        this.this$0 = fcmPushInterceptor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        f11 = this.this$0.f(null, null, this);
        return f11;
    }
}
