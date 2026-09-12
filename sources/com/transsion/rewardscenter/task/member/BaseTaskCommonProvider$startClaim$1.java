package com.transsion.rewardscenter.task.member;

import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.transsion.rewardscenter.R$layout;
import com.transsion.rewardscenter.R$string;
import com.transsion.rewardscenter.utils.RewardsCenterApiHelper;
import com.transsion.rewardscenter.utils.p;
import com.transsion.rewardscenterapi.MemberTaskItem;
import com.transsion.rewardscenterapi.TaskRewards;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import uh.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.rewardscenter.task.member.BaseTaskCommonProvider$startClaim$1", f = "BaseTaskCommonProvider.kt", l = {Sdk$SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
final class BaseTaskCommonProvider$startClaim$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ MemberTaskItem $item;
    int label;
    final /* synthetic */ BaseTaskCommonProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTaskCommonProvider$startClaim$1(MemberTaskItem memberTaskItem, BaseTaskCommonProvider baseTaskCommonProvider, Continuation<? super BaseTaskCommonProvider$startClaim$1> continuation) {
        super(2, continuation);
        this.$item = memberTaskItem;
        this.this$0 = baseTaskCommonProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(BaseTaskCommonProvider baseTaskCommonProvider, String str, String str2) {
        baseTaskCommonProvider.B().c().o().n(Boolean.FALSE);
        String string = baseTaskCommonProvider.k().getString(R$string.claim_points_failed_tips);
        Intrinsics.g(string, "getString(...)");
        p.a(false, string);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(BaseTaskCommonProvider baseTaskCommonProvider, TaskRewards taskRewards) {
        List<Object> data;
        MemberTaskItem memberTaskItem;
        Integer rewardAmount;
        Integer currentPoint;
        List<Object> data2;
        List<Object> data3;
        MemberTaskItem memberTaskItem2;
        MemberTaskItem taskInfo;
        baseTaskCommonProvider.B().c().o().n(Boolean.FALSE);
        BaseProviderMultiAdapter g11 = baseTaskCommonProvider.g();
        int i11 = -1;
        if (g11 != null && (data2 = g11.getData()) != null) {
            int i12 = 0;
            for (Object obj : data2) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    CollectionsKt.u();
                }
                MemberTaskItem memberTaskItem3 = (MemberTaskItem) obj;
                if (Intrinsics.c(memberTaskItem3.getTaskId(), (taskRewards == null || (taskInfo = taskRewards.getTaskInfo()) == null) ? null : taskInfo.getTaskId()) && memberTaskItem3.getTaskId() != null) {
                    MemberTaskItem taskInfo2 = taskRewards != null ? taskRewards.getTaskInfo() : null;
                    BaseProviderMultiAdapter g12 = baseTaskCommonProvider.g();
                    if (g12 != null && (data3 = g12.getData()) != null && (memberTaskItem2 = (MemberTaskItem) data3.get(i12)) != null) {
                        memberTaskItem2.setStatus(taskInfo2 != null ? taskInfo2.getStatus() : null);
                        memberTaskItem2.setProgress(taskInfo2 != null ? taskInfo2.getProgress() : null);
                        memberTaskItem2.setTotalProgress(taskInfo2 != null ? taskInfo2.getTotalProgress() : null);
                    }
                    i11 = i12;
                }
                i12 = i13;
            }
        }
        if (taskRewards != null && (currentPoint = taskRewards.getCurrentPoint()) != null) {
            baseTaskCommonProvider.B().c().C(currentPoint.intValue());
        }
        if (i11 < 0) {
            return Unit.f67184a;
        }
        BaseProviderMultiAdapter g13 = baseTaskCommonProvider.g();
        int intValue = (g13 == null || (data = g13.getData()) == null || (memberTaskItem = (MemberTaskItem) data.get(i11)) == null || (rewardAmount = memberTaskItem.getRewardAmount()) == null) ? 0 : rewardAmount.intValue();
        b.a aVar = uh.b.f76876a;
        int i14 = R$layout.claim_succeed_layout;
        String string = baseTaskCommonProvider.k().getString(R$string.claim_points_receive_tips, Integer.valueOf(intValue));
        Intrinsics.g(string, "getString(...)");
        aVar.g(i14, string, (r13 & 4) != 0 ? 0 : 80, (r13 & 8) != 0 ? 0 : 0, (r13 & 16) != 0 ? 0 : a0.a(66.0f));
        baseTaskCommonProvider.G();
        BaseProviderMultiAdapter g14 = baseTaskCommonProvider.g();
        if (g14 != null) {
            g14.notifyItemChanged(i11);
        }
        return Unit.f67184a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseTaskCommonProvider$startClaim$1(this.$item, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((BaseTaskCommonProvider$startClaim$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            RewardsCenterApiHelper rewardsCenterApiHelper = RewardsCenterApiHelper.f51346a;
            String taskId = this.$item.getTaskId();
            final BaseTaskCommonProvider baseTaskCommonProvider = this.this$0;
            Function2 function2 = new Function2() { // from class: com.transsion.rewardscenter.task.member.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit g11;
                    g11 = BaseTaskCommonProvider$startClaim$1.g(BaseTaskCommonProvider.this, (String) obj2, (String) obj3);
                    return g11;
                }
            };
            final BaseTaskCommonProvider baseTaskCommonProvider2 = this.this$0;
            Function1 function1 = new Function1() { // from class: com.transsion.rewardscenter.task.member.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit h11;
                    h11 = BaseTaskCommonProvider$startClaim$1.h(BaseTaskCommonProvider.this, (TaskRewards) obj2);
                    return h11;
                }
            };
            this.label = 1;
            if (rewardsCenterApiHelper.u(taskId, function2, function1, this) == f11) {
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
