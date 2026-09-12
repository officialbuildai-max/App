package com.transsion.usercenter.profile.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.usercenter.profile.b;
import com.transsion.usercenter.profile.bean.BffUserProfileData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/n0;", "Lcom/tn/lib/net/bean/BaseDto;", "Lcom/transsion/usercenter/profile/bean/BffUserProfileData;", "<anonymous>", "(Lkotlinx/coroutines/n0;)Lcom/tn/lib/net/bean/BaseDto;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.usercenter.profile.viewmodel.UserProfileViewModel$fetchUserProfileV3$1$dto$1", f = "UserProfileViewModel.kt", l = {105}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class UserProfileViewModel$fetchUserProfileV3$1$dto$1 extends SuspendLambda implements Function2<n0, Continuation<? super BaseDto<BffUserProfileData>>, Object> {
    final /* synthetic */ String $userId;
    int label;
    final /* synthetic */ UserProfileViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileViewModel$fetchUserProfileV3$1$dto$1(UserProfileViewModel userProfileViewModel, String str, Continuation<? super UserProfileViewModel$fetchUserProfileV3$1$dto$1> continuation) {
        super(2, continuation);
        this.this$0 = userProfileViewModel;
        this.$userId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserProfileViewModel$fetchUserProfileV3$1$dto$1(this.this$0, this.$userId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super BaseDto<BffUserProfileData>> continuation) {
        return ((UserProfileViewModel$fetchUserProfileV3$1$dto$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        com.transsion.usercenter.profile.b l11;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            l11 = this.this$0.l();
            String str = this.$userId;
            this.label = 1;
            obj = b.a.k(l11, str, null, this, 2, null);
            if (obj == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return obj;
    }
}
