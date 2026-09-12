package com.transsion.mbwidget.data;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.mbwidget.data.SportWidgetDataManager", f = "SportWidgetDataManager.kt", l = {Sdk$SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE}, m = "requestMatch")
/* loaded from: classes5.dex */
public final class SportWidgetDataManager$requestMatch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SportWidgetDataManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SportWidgetDataManager$requestMatch$1(SportWidgetDataManager sportWidgetDataManager, Continuation<? super SportWidgetDataManager$requestMatch$1> continuation) {
        super(continuation);
        this.this$0 = sportWidgetDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object q11;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        q11 = this.this$0.q(this);
        return q11;
    }
}
