package com.transsion.push;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.push.PushTestActivity", f = "PushTestActivity.kt", l = {Sdk$SDKError.Reason.SILENT_MODE_MONITOR_ERROR_VALUE}, m = "seedLocalPushFromPreset")
/* loaded from: classes6.dex */
public final class PushTestActivity$seedLocalPushFromPreset$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PushTestActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushTestActivity$seedLocalPushFromPreset$1(PushTestActivity pushTestActivity, Continuation<? super PushTestActivity$seedLocalPushFromPreset$1> continuation) {
        super(continuation);
        this.this$0 = pushTestActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object s02;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        s02 = this.this$0.s0(this);
        return s02;
    }
}
