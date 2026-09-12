package com.transsion.ad.bidding.base;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.hisavana.common.bean.AdditionalInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.bidding.base.AbsAdBidding$onLoadSuccess$1", f = "AbsAdBidding.kt", l = {TTAdConstant.AD_ID_IS_NULL_CODE}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class AbsAdBidding$onLoadSuccess$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ AdditionalInfo $additionalInfo;
    int label;
    final /* synthetic */ AbsAdBidding this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsAdBidding$onLoadSuccess$1(AbsAdBidding absAdBidding, AdditionalInfo additionalInfo, Continuation<? super AbsAdBidding$onLoadSuccess$1> continuation) {
        super(2, continuation);
        this.this$0 = absAdBidding;
        this.$additionalInfo = additionalInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AbsAdBidding$onLoadSuccess$1(this.this$0, this.$additionalInfo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((AbsAdBidding$onLoadSuccess$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object Y;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            AbsAdBidding absAdBidding = this.this$0;
            String str = "Hi 程序化加载成功 --> 直接竞价 --> placementId = " + this.$additionalInfo.getPlacementId();
            this.label = 1;
            Y = absAdBidding.Y(str, this);
            if (Y == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f67184a;
    }
}
