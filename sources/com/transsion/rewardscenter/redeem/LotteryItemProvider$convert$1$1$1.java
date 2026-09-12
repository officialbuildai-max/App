package com.transsion.rewardscenter.redeem;

import com.transsion.rewardscenter.R$string;
import com.transsion.rewardscenter.model.RewardsCenterModel;
import com.transsion.rewardscenter.utils.RewardsCenterApiHelper;
import com.transsion.rewardscenter.utils.p;
import com.transsion.rewardscenterapi.RedeemLotteryResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.rewardscenter.redeem.LotteryItemProvider$convert$1$1$1", f = "LotteryItemProvider.kt", l = {75}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class LotteryItemProvider$convert$1$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    int label;
    final /* synthetic */ LotteryItemProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LotteryItemProvider$convert$1$1$1(String str, LotteryItemProvider lotteryItemProvider, Continuation<? super LotteryItemProvider$convert$1$1$1> continuation) {
        super(2, continuation);
        this.$id = str;
        this.this$0 = lotteryItemProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(LotteryItemProvider lotteryItemProvider, String str, String str2) {
        wp.a aVar;
        aVar = lotteryItemProvider.f51060e;
        aVar.c().o().n(Boolean.FALSE);
        if (str2 == null || StringsKt.q0(str2)) {
            str2 = lotteryItemProvider.k().getString(R$string.redeem_failed_tips);
        }
        Intrinsics.e(str2);
        p.a(false, str2);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(LotteryItemProvider lotteryItemProvider, RedeemLotteryResult redeemLotteryResult) {
        wp.a aVar;
        wp.a aVar2;
        aVar = lotteryItemProvider.f51060e;
        aVar.c().o().n(Boolean.FALSE);
        String string = lotteryItemProvider.k().getString(R$string.redeem_success);
        Intrinsics.g(string, "getString(...)");
        p.a(true, string);
        aVar2 = lotteryItemProvider.f51060e;
        RewardsCenterModel.j(aVar2.c(), null, 1, null);
        return Unit.f67184a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LotteryItemProvider$convert$1$1$1(this.$id, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((LotteryItemProvider$convert$1$1$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            RewardsCenterApiHelper rewardsCenterApiHelper = RewardsCenterApiHelper.f51346a;
            String str = this.$id;
            final LotteryItemProvider lotteryItemProvider = this.this$0;
            Function2 function2 = new Function2() { // from class: com.transsion.rewardscenter.redeem.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit g11;
                    g11 = LotteryItemProvider$convert$1$1$1.g(LotteryItemProvider.this, (String) obj2, (String) obj3);
                    return g11;
                }
            };
            final LotteryItemProvider lotteryItemProvider2 = this.this$0;
            Function1 function1 = new Function1() { // from class: com.transsion.rewardscenter.redeem.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit h11;
                    h11 = LotteryItemProvider$convert$1$1$1.h(LotteryItemProvider.this, (RedeemLotteryResult) obj2);
                    return h11;
                }
            };
            this.label = 1;
            if (rewardsCenterApiHelper.q(str, function2, function1, this) == f11) {
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
