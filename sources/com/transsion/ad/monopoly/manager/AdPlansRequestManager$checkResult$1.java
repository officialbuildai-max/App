package com.transsion.ad.monopoly.manager;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.ad.monopoly.manager.AdPlansRequestManager", f = "AdPlansRequestManager.kt", l = {449, 460, 465}, m = "checkResult")
/* loaded from: classes5.dex */
public final class AdPlansRequestManager$checkResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdPlansRequestManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdPlansRequestManager$checkResult$1(AdPlansRequestManager adPlansRequestManager, Continuation<? super AdPlansRequestManager$checkResult$1> continuation) {
        super(continuation);
        this.this$0 = adPlansRequestManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object i11;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        i11 = this.this$0.i(null, null, this);
        return i11;
    }
}
