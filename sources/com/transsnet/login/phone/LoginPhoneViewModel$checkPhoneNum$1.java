package com.transsnet.login.phone;

import com.transsnet.loginapi.bean.Country;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.login.phone.LoginPhoneViewModel$checkPhoneNum$1", f = "LoginPhoneViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class LoginPhoneViewModel$checkPhoneNum$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $phoneNum;
    int label;
    final /* synthetic */ LoginPhoneViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginPhoneViewModel$checkPhoneNum$1(LoginPhoneViewModel loginPhoneViewModel, String str, Continuation<? super LoginPhoneViewModel$checkPhoneNum$1> continuation) {
        super(2, continuation);
        this.this$0 = loginPhoneViewModel;
        this.$phoneNum = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginPhoneViewModel$checkPhoneNum$1(this.this$0, this.$phoneNum, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((LoginPhoneViewModel$checkPhoneNum$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        androidx.view.b0 b0Var;
        androidx.view.b0 b0Var2;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Country a11 = yy.a.f79217a.a(this.this$0.b(), this.$phoneNum);
        if (a11 != null) {
            String str = this.$phoneNum;
            LoginPhoneViewModel loginPhoneViewModel = this.this$0;
            String substring = str.substring(a11.getCode().length() + 1, str.length());
            Intrinsics.g(substring, "substring(...)");
            b0Var = loginPhoneViewModel.f60542c;
            b0Var.n(substring);
            b0Var2 = loginPhoneViewModel.f60541b;
            b0Var2.n(a11);
        }
        return Unit.f67184a;
    }
}
