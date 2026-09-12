package com.transsion.ugcvideodetail.viewmodel;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel", f = "UGCImmVideoDetailViewModel.kt", l = {367, 368}, m = "fetchVideoPlayInfoInternal")
/* loaded from: classes6.dex */
public final class UGCImmVideoDetailViewModel$fetchVideoPlayInfoInternal$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UGCImmVideoDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCImmVideoDetailViewModel$fetchVideoPlayInfoInternal$1(UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel, Continuation<? super UGCImmVideoDetailViewModel$fetchVideoPlayInfoInternal$1> continuation) {
        super(continuation);
        this.this$0 = uGCImmVideoDetailViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object y10;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        y10 = this.this$0.y(null, this);
        return y10;
    }
}
