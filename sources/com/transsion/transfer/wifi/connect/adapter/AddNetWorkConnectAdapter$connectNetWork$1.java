package com.transsion.transfer.wifi.connect.adapter;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.transfer.wifi.connect.adapter.AddNetWorkConnectAdapter", f = "AddNetWorkConnectAdapter.kt", l = {126}, m = "connectNetWork")
/* loaded from: classes6.dex */
public final class AddNetWorkConnectAdapter$connectNetWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AddNetWorkConnectAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddNetWorkConnectAdapter$connectNetWork$1(AddNetWorkConnectAdapter addNetWorkConnectAdapter, Continuation<? super AddNetWorkConnectAdapter$connectNetWork$1> continuation) {
        super(continuation);
        this.this$0 = addNetWorkConnectAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object n11;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        n11 = this.this$0.n(this);
        return n11;
    }
}
