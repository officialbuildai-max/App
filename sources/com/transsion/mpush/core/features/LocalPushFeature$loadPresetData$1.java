package com.transsion.mpush.core.features;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.mpush.core.features.LocalPushFeature", f = "LocalPushFeature.kt", l = {282, 283}, m = "loadPresetData")
/* loaded from: classes6.dex */
public final class LocalPushFeature$loadPresetData$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalPushFeature this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalPushFeature$loadPresetData$1(LocalPushFeature localPushFeature, Continuation<? super LocalPushFeature$loadPresetData$1> continuation) {
        super(continuation);
        this.this$0 = localPushFeature;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object g11;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        g11 = this.this$0.g(0, this);
        return g11;
    }
}
