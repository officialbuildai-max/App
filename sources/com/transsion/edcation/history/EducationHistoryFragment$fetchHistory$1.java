package com.transsion.edcation.history;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.edcation.history.EducationHistoryFragment", f = "EducationHistoryFragment.kt", l = {Sdk$SDKError.Reason.PRIVACY_URL_ERROR_VALUE}, m = "fetchHistory")
/* loaded from: classes5.dex */
public final class EducationHistoryFragment$fetchHistory$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EducationHistoryFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EducationHistoryFragment$fetchHistory$1(EducationHistoryFragment educationHistoryFragment, Continuation<? super EducationHistoryFragment$fetchHistory$1> continuation) {
        super(continuation);
        this.this$0 = educationHistoryFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object i02;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        i02 = this.this$0.i0(false, this);
        return i02;
    }
}
