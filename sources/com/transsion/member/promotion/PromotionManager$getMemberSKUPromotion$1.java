package com.transsion.member.promotion;

import com.transsion.memberapi.SkuPromotionDto;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.member.promotion.PromotionManager$getMemberSKUPromotion$1", f = "PromotionManager.kt", l = {Sdk$SDKMetric.SDKMetricType.AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class PromotionManager$getMemberSKUPromotion$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PromotionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PromotionManager$getMemberSKUPromotion$1(PromotionManager promotionManager, Continuation<? super PromotionManager$getMemberSKUPromotion$1> continuation) {
        super(2, continuation);
        this.this$0 = promotionManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PromotionManager$getMemberSKUPromotion$1 promotionManager$getMemberSKUPromotion$1 = new PromotionManager$getMemberSKUPromotion$1(this.this$0, continuation);
        promotionManager$getMemberSKUPromotion$1.L$0 = obj;
        return promotionManager$getMemberSKUPromotion$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PromotionManager$getMemberSKUPromotion$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SkuPromotionRepository q11;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                PromotionManager promotionManager = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                q11 = promotionManager.q();
                this.label = 1;
                obj = q11.d(this);
                if (obj == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            Result.m1185constructorimpl((SkuPromotionDto) obj);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        return Unit.f67184a;
    }
}
