package com.transsnet.login.interest;

import androidx.view.b0;
import com.transsnet.login.R$array;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.login.interest.LoginInterestViewModel$postInterest$1$1", f = "LoginInterestViewModel.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class LoginInterestViewModel$postInterest$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Integer> $datas;
    int label;
    final /* synthetic */ LoginInterestViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginInterestViewModel$postInterest$1$1(LoginInterestViewModel loginInterestViewModel, List<Integer> list, Continuation<? super LoginInterestViewModel$postInterest$1$1> continuation) {
        super(2, continuation);
        this.this$0 = loginInterestViewModel;
        this.$datas = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginInterestViewModel$postInterest$1$1(this.this$0, this.$datas, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((LoginInterestViewModel$postInterest$1$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b0 b0Var;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        String[] stringArray = this.this$0.b().getResources().getStringArray(R$array.interestId);
        Intrinsics.g(stringArray, "getStringArray(...)");
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        for (Object obj2 : this.$datas) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.u();
            }
            sb2.append(stringArray[((Number) obj2).intValue()]);
            if (i11 < r1.size() - 1) {
                sb2.append(",");
            }
            i11 = i12;
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "toString(...)");
        vy.d.f77603a.b().putString("login_show_interest", sb3);
        b0Var = this.this$0.f60496b;
        b0Var.n(sb3);
        return Unit.f67184a;
    }
}
