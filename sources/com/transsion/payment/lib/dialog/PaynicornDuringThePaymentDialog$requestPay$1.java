package com.transsion.payment.lib.dialog;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.payment.lib.PaymentService;
import com.transsion.payment.lib.bean.CreateOrderReq;
import com.transsion.payment.lib.bean.CreateOrderRes;
import com.transsion.payment.lib.bean.PrePayInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.payment.lib.dialog.PaynicornDuringThePaymentDialog$requestPay$1", f = "PaynicornDuringThePaymentDialog.kt", l = {126}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class PaynicornDuringThePaymentDialog$requestPay$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PaynicornDuringThePaymentDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaynicornDuringThePaymentDialog$requestPay$1(PaynicornDuringThePaymentDialog paynicornDuringThePaymentDialog, Continuation<? super PaynicornDuringThePaymentDialog$requestPay$1> continuation) {
        super(2, continuation);
        this.this$0 = paynicornDuringThePaymentDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaynicornDuringThePaymentDialog$requestPay$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PaynicornDuringThePaymentDialog$requestPay$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PaymentService F0;
        CreateOrderReq createOrderReq;
        CreateOrderReq createOrderReq2;
        CreateOrderReq createOrderReq3;
        CreateOrderReq createOrderReq4;
        Map<String, String> h11;
        a G0;
        String str;
        PrePayInfo prePayInfo;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            F0 = this.this$0.F0();
            createOrderReq = this.this$0.mCreateOrderReq;
            String productId = createOrderReq != null ? createOrderReq.getProductId() : null;
            createOrderReq2 = this.this$0.mCreateOrderReq;
            Double payAmount = createOrderReq2 != null ? createOrderReq2.getPayAmount() : null;
            createOrderReq3 = this.this$0.mCreateOrderReq;
            String cpFrontPage = createOrderReq3 != null ? createOrderReq3.getCpFrontPage() : null;
            createOrderReq4 = this.this$0.mCreateOrderReq;
            if (createOrderReq4 == null || (h11 = createOrderReq4.getExtStrJson()) == null) {
                h11 = MapsKt.h();
            }
            Map<String, String> map = h11;
            this.label = 1;
            obj = F0.i(productId, payAmount, cpFrontPage, map, this);
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
        if (!Intrinsics.c(baseDto != null ? baseDto.getCode() : null, "0") || baseDto.getData() == null) {
            this.this$0.J0(1001, "requestPay() --> 请求接口创建订单....失败 --> code = " + (baseDto != null ? baseDto.getCode() : null));
        } else {
            G0 = this.this$0.G0();
            Function1 c11 = G0.c();
            if (c11 != null) {
                CreateOrderRes createOrderRes = (CreateOrderRes) baseDto.getData();
                if (createOrderRes == null || (prePayInfo = createOrderRes.getPrePayInfo()) == null || (str = prePayInfo.getOrderId()) == null) {
                    str = "";
                }
                c11.invoke(str);
            }
            this.this$0.M0((CreateOrderRes) baseDto.getData());
        }
        return Unit.f67184a;
    }
}
