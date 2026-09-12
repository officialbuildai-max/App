package com.transsion.ad.ps.attribution;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.ad.ps.attribution.AttributionConsumeManager", f = "AttributionConsumeManager.kt", l = {Sdk$SDKError.Reason.GZIP_ENCODE_ERROR_VALUE, 126, 128}, m = "doNetWork")
/* loaded from: classes5.dex */
public final class AttributionConsumeManager$doNetWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AttributionConsumeManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttributionConsumeManager$doNetWork$1(AttributionConsumeManager attributionConsumeManager, Continuation<? super AttributionConsumeManager$doNetWork$1> continuation) {
        super(continuation);
        this.this$0 = attributionConsumeManager;
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
