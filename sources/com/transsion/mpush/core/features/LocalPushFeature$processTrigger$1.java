package com.transsion.mpush.core.features;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.mpush.core.features.LocalPushFeature", f = "LocalPushFeature.kt", l = {Sdk$SDKError.Reason.INVALID_INDEX_URL_VALUE, 139, 141}, m = "processTrigger")
/* loaded from: classes6.dex */
public final class LocalPushFeature$processTrigger$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalPushFeature this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalPushFeature$processTrigger$1(LocalPushFeature localPushFeature, Continuation<? super LocalPushFeature$processTrigger$1> continuation) {
        super(continuation);
        this.this$0 = localPushFeature;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m11;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m11 = this.this$0.m(0, this);
        return m11;
    }
}
