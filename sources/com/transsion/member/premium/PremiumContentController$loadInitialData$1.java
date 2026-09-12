package com.transsion.member.premium;

import com.transsion.member.promotion.PromotionManager;
import com.transsion.memberapi.MemberPriceData;
import com.transsion.memberapi.SkuPromotionDto;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.member.premium.PremiumContentController$loadInitialData$1", f = "PremiumContentController.kt", l = {201}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class PremiumContentController$loadInitialData$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PremiumContentController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PremiumContentController$loadInitialData$1(PremiumContentController premiumContentController, Continuation<? super PremiumContentController$loadInitialData$1> continuation) {
        super(2, continuation);
        this.this$0 = premiumContentController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PremiumContentController$loadInitialData$1 premiumContentController$loadInitialData$1 = new PremiumContentController$loadInitialData$1(this.this$0, continuation);
        premiumContentController$loadInitialData$1.L$0 = obj;
        return premiumContentController$loadInitialData$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PremiumContentController$loadInitialData$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MemberPriceData memberPriceData;
        MemberPriceData memberPriceData2;
        SkuPromotionDto skuPromotionDto;
        PromotionManager w11;
        PremiumContentController premiumContentController;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                PremiumContentController premiumContentController2 = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                w11 = premiumContentController2.w();
                this.L$0 = premiumContentController2;
                this.label = 1;
                Object o11 = w11.o(this);
                if (o11 == f11) {
                    return f11;
                }
                premiumContentController = premiumContentController2;
                obj = o11;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                premiumContentController = (PremiumContentController) this.L$0;
                ResultKt.b(obj);
            }
            premiumContentController.f46660h = (SkuPromotionDto) obj;
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        this.this$0.f46661i = true;
        a.C0856a c0856a = lg.a.f68962a;
        memberPriceData = this.this$0.f46659g;
        a.C0856a.f(c0856a, "liyang", "promotion返回！pendingGoodsData ->" + memberPriceData, false, 4, null);
        memberPriceData2 = this.this$0.f46659g;
        if (memberPriceData2 != null) {
            PremiumContentController premiumContentController3 = this.this$0;
            skuPromotionDto = premiumContentController3.f46660h;
            premiumContentController3.s(memberPriceData2, skuPromotionDto != null ? skuPromotionDto.getItems() : null);
        }
        return Unit.f67184a;
    }
}
