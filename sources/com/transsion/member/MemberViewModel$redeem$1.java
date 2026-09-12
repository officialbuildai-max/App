package com.transsion.member;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.member.MemberViewModel", f = "MemberViewModel.kt", l = {370}, m = "redeem")
/* loaded from: classes5.dex */
public final class MemberViewModel$redeem$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MemberViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberViewModel$redeem$1(MemberViewModel memberViewModel, Continuation<? super MemberViewModel$redeem$1> continuation) {
        super(continuation);
        this.this$0 = memberViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object S;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        S = this.this$0.S(null, this);
        return S;
    }
}
