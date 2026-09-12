package com.transsion.usercenter.profile.viewmodel;

import androidx.view.b0;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.usercenter.profile.bean.SubscriptionStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.usercenter.profile.viewmodel.UserProfileViewModel$fetchSubscriptionStatus$1", f = "UserProfileViewModel.kt", l = {TmcConstants.NOTIFY_ADDHOME_GUIDE_BOTTOM_SHOW}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class UserProfileViewModel$fetchSubscriptionStatus$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $targetUID;
    int label;
    final /* synthetic */ UserProfileViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileViewModel$fetchSubscriptionStatus$1(UserProfileViewModel userProfileViewModel, String str, Continuation<? super UserProfileViewModel$fetchSubscriptionStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = userProfileViewModel;
        this.$targetUID = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserProfileViewModel$fetchSubscriptionStatus$1(this.this$0, this.$targetUID, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UserProfileViewModel$fetchSubscriptionStatus$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b0 b0Var;
        b0 b0Var2;
        b0 b0Var3;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                i0 b11 = y0.b();
                UserProfileViewModel$fetchSubscriptionStatus$1$dto$1 userProfileViewModel$fetchSubscriptionStatus$1$dto$1 = new UserProfileViewModel$fetchSubscriptionStatus$1$dto$1(this.this$0, this.$targetUID, null);
                this.label = 1;
                obj = i.g(b11, userProfileViewModel$fetchSubscriptionStatus$1$dto$1, this);
                if (obj == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            if (!Intrinsics.c(baseDto.getCode(), "0") || baseDto.getData() == null) {
                b0Var2 = this.this$0.f57441h;
                b0Var2.q(null);
            } else {
                b0Var3 = this.this$0.f57441h;
                SubscriptionStatus subscriptionStatus = (SubscriptionStatus) baseDto.getData();
                b0Var3.q(subscriptionStatus != null ? Boxing.a(subscriptionStatus.isSubscribed()) : null);
            }
        } catch (Exception e11) {
            lg.a.f68962a.i("UserProfileVM", "fetchSubscriptionStatus error: " + e11.getMessage(), false);
            b0Var = this.this$0.f57441h;
            b0Var.q(null);
        }
        return Unit.f67184a;
    }
}
