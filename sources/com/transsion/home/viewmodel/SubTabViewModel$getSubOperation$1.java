package com.transsion.home.viewmodel;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.home.viewmodel.SubTabViewModel", f = "SubTabViewModel.kt", l = {149, 151}, m = "getSubOperation")
/* loaded from: classes5.dex */
public final class SubTabViewModel$getSubOperation$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SubTabViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubTabViewModel$getSubOperation$1(SubTabViewModel subTabViewModel, Continuation<? super SubTabViewModel$getSubOperation$1> continuation) {
        super(continuation);
        this.this$0 = subTabViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object r11;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        r11 = this.this$0.r(0, null, this);
        return r11;
    }
}
