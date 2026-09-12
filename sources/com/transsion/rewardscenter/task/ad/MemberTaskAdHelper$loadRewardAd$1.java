package com.transsion.rewardscenter.task.ad;

import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.video.BiddingVideoManager;
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
@DebugMetadata(c = "com.transsion.rewardscenter.task.ad.MemberTaskAdHelper$loadRewardAd$1", f = "MemberTaskAdHelper.kt", l = {262}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class MemberTaskAdHelper$loadRewardAd$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MemberTaskAdHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberTaskAdHelper$loadRewardAd$1(MemberTaskAdHelper memberTaskAdHelper, Continuation<? super MemberTaskAdHelper$loadRewardAd$1> continuation) {
        super(2, continuation);
        this.this$0 = memberTaskAdHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MemberTaskAdHelper$loadRewardAd$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((MemberTaskAdHelper$loadRewardAd$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BiddingVideoManager biddingVideoManager;
        BiddingVideoManager biddingVideoManager2;
        BiddingVideoManager biddingVideoManager3;
        BiddingVideoManager biddingVideoManager4;
        MemberTaskAdHelper$rewardAdListener$1 memberTaskAdHelper$rewardAdListener$1;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            this.this$0.f51101m = new BiddingVideoManager();
            biddingVideoManager = this.this$0.f51101m;
            if (biddingVideoManager != null) {
                biddingVideoManager.O0("MemberTaskRewardedScene");
            }
            biddingVideoManager2 = this.this$0.f51101m;
            if (biddingVideoManager2 != null) {
                biddingVideoManager2.M0(null);
            }
            biddingVideoManager3 = this.this$0.f51101m;
            if (biddingVideoManager3 != null) {
                memberTaskAdHelper$rewardAdListener$1 = this.this$0.f51105q;
                biddingVideoManager3.N0(memberTaskAdHelper$rewardAdListener$1);
            }
            biddingVideoManager4 = this.this$0.f51101m;
            if (biddingVideoManager4 != null) {
                this.label = 1;
                if (AbsAdBidding.w0(biddingVideoManager4, 0, false, this, 3, null) == f11) {
                    return f11;
                }
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
