package com.transsion.payment.lib.strategy;

import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.payment.lib.PaymentService;
import com.transsion.payment.lib.b;
import com.transsion.payment.lib.bean.CreateOrderReq;
import com.transsion.payment.lib.bean.CreateOrderRes;
import com.transsion.payment.lib.bean.PrePayInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.payment.lib.strategy.GoogleStrategy$requestPay$1$2", f = "GoogleStrategy.kt", l = {95}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class GoogleStrategy$requestPay$1$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppCompatActivity $activity;
    final /* synthetic */ Function1<String, Unit> $createOrderCallback;
    final /* synthetic */ CreateOrderReq $createOrderReq;
    final /* synthetic */ com.transsion.payment.lib.b $payCallback;
    final /* synthetic */ boolean $subscriptOrder;
    int label;
    final /* synthetic */ GoogleStrategy this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GoogleStrategy$requestPay$1$2(GoogleStrategy googleStrategy, CreateOrderReq createOrderReq, AppCompatActivity appCompatActivity, boolean z10, com.transsion.payment.lib.b bVar, Function1<? super String, Unit> function1, Continuation<? super GoogleStrategy$requestPay$1$2> continuation) {
        super(2, continuation);
        this.this$0 = googleStrategy;
        this.$createOrderReq = createOrderReq;
        this.$activity = appCompatActivity;
        this.$subscriptOrder = z10;
        this.$payCallback = bVar;
        this.$createOrderCallback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoogleStrategy$requestPay$1$2(this.this$0, this.$createOrderReq, this.$activity, this.$subscriptOrder, this.$payCallback, this.$createOrderCallback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((GoogleStrategy$requestPay$1$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PaymentService z10;
        String code;
        PrePayInfo prePayInfo;
        String orderId;
        String tradingOrderId;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            z10 = this.this$0.z();
            String productId = this.$createOrderReq.getProductId();
            String cpFrontPage = this.$createOrderReq.getCpFrontPage();
            Map<String, String> extStrJson = this.$createOrderReq.getExtStrJson();
            this.label = 1;
            obj = z10.h(productId, cpFrontPage, extStrJson, this);
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
        if (Intrinsics.c(baseDto != null ? baseDto.getCode() : null, "0")) {
            CreateOrderRes createOrderRes = (CreateOrderRes) baseDto.getData();
            if (!TextUtils.isEmpty(createOrderRes != null ? createOrderRes.getTradingOrderId() : null)) {
                CreateOrderRes createOrderRes2 = (CreateOrderRes) baseDto.getData();
                String str = "";
                this.this$0.G(this.$activity, this.$createOrderReq.getProductId(), (createOrderRes2 == null || (tradingOrderId = createOrderRes2.getTradingOrderId()) == null) ? "" : tradingOrderId, this.$subscriptOrder, this.$payCallback);
                Function1<String, Unit> function1 = this.$createOrderCallback;
                if (function1 != null) {
                    CreateOrderRes createOrderRes3 = (CreateOrderRes) baseDto.getData();
                    if (createOrderRes3 != null && (prePayInfo = createOrderRes3.getPrePayInfo()) != null && (orderId = prePayInfo.getOrderId()) != null) {
                        str = orderId;
                    }
                    function1.invoke(str);
                }
                return Unit.f67184a;
            }
        }
        b.a.a(this.$payCallback, (baseDto == null || (code = baseDto.getCode()) == null) ? null : Boxing.d(Integer.parseInt(code)), String.valueOf(baseDto != null ? baseDto.getMsg() : null), false, null, 8, null);
        return Unit.f67184a;
    }
}
