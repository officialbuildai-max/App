package com.transsion.ad.monopoly.manager;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.ad.monopoly.manager.AdPlansRequestManager", f = "AdPlansRequestManager.kt", l = {373}, m = "updateAdPlanToDatabase")
/* loaded from: classes5.dex */
public final class AdPlansRequestManager$updateAdPlanToDatabase$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdPlansRequestManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdPlansRequestManager$updateAdPlanToDatabase$1(AdPlansRequestManager adPlansRequestManager, Continuation<? super AdPlansRequestManager$updateAdPlanToDatabase$1> continuation) {
        super(continuation);
        this.this$0 = adPlansRequestManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object w11;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        w11 = this.this$0.w(null, this);
        return w11;
    }
}
