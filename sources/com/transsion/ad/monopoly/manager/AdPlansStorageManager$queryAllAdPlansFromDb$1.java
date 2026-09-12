package com.transsion.ad.monopoly.manager;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.ad.monopoly.manager.AdPlansStorageManager", f = "AdPlansStorageManager.kt", l = {134}, m = "queryAllAdPlansFromDb")
/* loaded from: classes5.dex */
public final class AdPlansStorageManager$queryAllAdPlansFromDb$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdPlansStorageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdPlansStorageManager$queryAllAdPlansFromDb$1(AdPlansStorageManager adPlansStorageManager, Continuation<? super AdPlansStorageManager$queryAllAdPlansFromDb$1> continuation) {
        super(continuation);
        this.this$0 = adPlansStorageManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object t11;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        t11 = this.this$0.t(this);
        return t11;
    }
}
