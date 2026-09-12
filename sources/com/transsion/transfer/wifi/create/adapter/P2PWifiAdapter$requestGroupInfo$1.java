package com.transsion.transfer.wifi.create.adapter;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.transfer.wifi.create.adapter.P2PWifiAdapter", f = "P2PWifiAdapter.kt", l = {350}, m = "requestGroupInfo")
/* loaded from: classes6.dex */
public final class P2PWifiAdapter$requestGroupInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ P2PWifiAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P2PWifiAdapter$requestGroupInfo$1(P2PWifiAdapter p2PWifiAdapter, Continuation<? super P2PWifiAdapter$requestGroupInfo$1> continuation) {
        super(continuation);
        this.this$0 = p2PWifiAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object B;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        B = this.this$0.B(this);
        return B;
    }
}
