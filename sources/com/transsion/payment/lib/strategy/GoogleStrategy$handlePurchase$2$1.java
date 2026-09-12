package com.transsion.payment.lib.strategy;

import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.payment.lib.PaymentService;
import com.transsion.payment.lib.bean.CheckPaymentBean;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.payment.lib.strategy.GoogleStrategy$handlePurchase$2$1", f = "GoogleStrategy.kt", l = {MiniAppConfigHelper.DEFAULT_MINIAPP_ALL_DATA_MAX_SIZE}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class GoogleStrategy$handlePurchase$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $gpOrderId;
    final /* synthetic */ String $orderId;
    final /* synthetic */ String $productId;
    final /* synthetic */ String $purchaseToken;
    int label;
    final /* synthetic */ GoogleStrategy this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleStrategy$handlePurchase$2$1(GoogleStrategy googleStrategy, String str, String str2, String str3, String str4, Continuation<? super GoogleStrategy$handlePurchase$2$1> continuation) {
        super(1, continuation);
        this.this$0 = googleStrategy;
        this.$productId = str;
        this.$purchaseToken = str2;
        this.$orderId = str3;
        this.$gpOrderId = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new GoogleStrategy$handlePurchase$2$1(this.this$0, this.$productId, this.$purchaseToken, this.$orderId, this.$gpOrderId, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((GoogleStrategy$handlePurchase$2$1) create(continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PaymentService z10;
        com.transsion.payment.lib.b bVar;
        com.transsion.payment.lib.b bVar2;
        com.transsion.payment.lib.b bVar3;
        String str;
        String addCoin;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            z10 = this.this$0.z();
            String str2 = this.$productId;
            String str3 = this.$purchaseToken;
            String str4 = this.$orderId;
            String str5 = this.$gpOrderId;
            this.label = 1;
            obj = z10.g(str2, str3, str4, str5, this);
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
        if (!Intrinsics.c(baseDto != null ? baseDto.getCode() : null, "0")) {
            throw new Exception(baseDto != null ? baseDto.getMsg() : null);
        }
        bVar = this.this$0.f47860j;
        int i12 = 0;
        if (bVar != null) {
            bVar.b(false);
        }
        com.transsion.payment.lib.d dVar = com.transsion.payment.lib.d.f47833a;
        dVar.a("Will callback success");
        bVar2 = this.this$0.f47860j;
        if (bVar2 != null) {
            CheckPaymentBean checkPaymentBean = (CheckPaymentBean) baseDto.getData();
            if (checkPaymentBean != null && (addCoin = checkPaymentBean.getAddCoin()) != null) {
                i12 = Integer.parseInt(addCoin);
            }
            CheckPaymentBean checkPaymentBean2 = (CheckPaymentBean) baseDto.getData();
            if (checkPaymentBean2 == null || (str = checkPaymentBean2.getBalanceCoin()) == null) {
                str = "";
            }
            bVar2.c(i12, str, this.$orderId);
        }
        bVar3 = this.this$0.f47860j;
        dVar.a("Has callback " + bVar3);
        this.this$0.f47860j = null;
        dVar.a("handlePurchase 发货成功");
        return Unit.f67184a;
    }
}
