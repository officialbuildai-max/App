package com.transsion.usercenter.profile.viewmodel;

import androidx.view.b0;
import bh.b;
import com.blankj.utilcode.util.o;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.usercenter.profile.bean.ToggleSubscriptionRequest;
import com.transsion.usercenter.profile.bean.ToggleSubscriptionResult;
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
import okhttp3.RequestBody;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.usercenter.profile.viewmodel.UserProfileViewModel$toggleSubscription$1", f = "UserProfileViewModel.kt", l = {130}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class UserProfileViewModel$toggleSubscription$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $subscribe;
    final /* synthetic */ String $targetUID;
    int label;
    final /* synthetic */ UserProfileViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileViewModel$toggleSubscription$1(String str, boolean z10, UserProfileViewModel userProfileViewModel, Continuation<? super UserProfileViewModel$toggleSubscription$1> continuation) {
        super(2, continuation);
        this.$targetUID = str;
        this.$subscribe = z10;
        this.this$0 = userProfileViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserProfileViewModel$toggleSubscription$1(this.$targetUID, this.$subscribe, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UserProfileViewModel$toggleSubscription$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
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
                String j11 = o.j(new ToggleSubscriptionRequest(this.$targetUID, this.$subscribe));
                b.a aVar = bh.b.f16553a;
                Intrinsics.e(j11);
                RequestBody a11 = aVar.a(j11);
                i0 b11 = y0.b();
                UserProfileViewModel$toggleSubscription$1$dto$1 userProfileViewModel$toggleSubscription$1$dto$1 = new UserProfileViewModel$toggleSubscription$1$dto$1(this.this$0, a11, null);
                this.label = 1;
                obj = i.g(b11, userProfileViewModel$toggleSubscription$1$dto$1, this);
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
                ToggleSubscriptionResult toggleSubscriptionResult = (ToggleSubscriptionResult) baseDto.getData();
                b0Var3.q(toggleSubscriptionResult != null ? Boxing.a(toggleSubscriptionResult.isSubscribed()) : null);
            }
        } catch (Exception e11) {
            lg.a.f68962a.i("UserProfileVM", "toggleSubscription error: " + e11.getMessage(), false);
            b0Var = this.this$0.f57441h;
            b0Var.q(null);
        }
        return Unit.f67184a;
    }
}
