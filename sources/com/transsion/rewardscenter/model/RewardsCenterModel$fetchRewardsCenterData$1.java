package com.transsion.rewardscenter.model;

import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.rewardscenter.utils.n;
import com.transsion.rewardscenterapi.RewardsCenterData;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import lg.a;
import up.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.rewardscenter.model.RewardsCenterModel$fetchRewardsCenterData$1", f = "RewardsCenterModel.kt", l = {MBSupportMuteAdType.REWARD_VIDEO}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class RewardsCenterModel$fetchRewardsCenterData$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RewardsCenterModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardsCenterModel$fetchRewardsCenterData$1(Function0<Unit> function0, RewardsCenterModel rewardsCenterModel, Continuation<? super RewardsCenterModel$fetchRewardsCenterData$1> continuation) {
        super(2, continuation);
        this.$callback = function0;
        this.this$0 = rewardsCenterModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RewardsCenterModel$fetchRewardsCenterData$1 rewardsCenterModel$fetchRewardsCenterData$1 = new RewardsCenterModel$fetchRewardsCenterData$1(this.$callback, this.this$0, continuation);
        rewardsCenterModel$fetchRewardsCenterData$1.L$0 = obj;
        return rewardsCenterModel$fetchRewardsCenterData$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((RewardsCenterModel$fetchRewardsCenterData$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        up.a s11;
        Object d11;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                RewardsCenterModel rewardsCenterModel = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                s11 = rewardsCenterModel.s();
                this.label = 1;
                d11 = a.C0966a.d(s11, null, this, 1, null);
                if (d11 == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                d11 = obj;
            }
            m1185constructorimpl = Result.m1185constructorimpl((BaseDto) d11);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        RewardsCenterModel rewardsCenterModel2 = this.this$0;
        if (Result.m1192isSuccessimpl(m1185constructorimpl)) {
            BaseDto baseDto = (BaseDto) m1185constructorimpl;
            if (n.a(baseDto)) {
                RewardsCenterData rewardsCenterData = (RewardsCenterData) baseDto.getData();
                if (rewardsCenterData != null) {
                    rewardsCenterModel2.p().q(rewardsCenterData.getLottery());
                    rewardsCenterModel2.x().q(rewardsCenterData.getUser());
                    rewardsCenterModel2.r().q(rewardsCenterData.getRedeem());
                    rewardsCenterModel2.v().q(rewardsCenterData.getTask());
                    rewardsCenterModel2.t().q(rewardsCenterData.getRule());
                    a.C0856a.f(lg.a.f68962a, "RewardsCenter", "fetchRewardsCenterData onSuccess: " + rewardsCenterData, false, 4, null);
                }
            } else {
                a.C0856a.f(lg.a.f68962a, "RewardsCenter", "fetchRewardsCenterData onFailure: " + baseDto.getCode() + ", " + baseDto.getMsg(), false, 4, null);
            }
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a.f(lg.a.f68962a, "RewardsCenter", "fetchRewardsCenterData error: " + m1188exceptionOrNullimpl.getMessage(), false, 4, null);
        }
        Function0<Unit> function0 = this.$callback;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.f67184a;
    }
}
