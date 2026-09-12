package com.transsion.shorttv.order;

import androidx.view.b0;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.shorttv.order.bean.CreatePaynicornOrderReqBean;
import com.transsion.shorttv.order.bean.HttpErrorBodyBean;
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
import retrofit2.HttpException;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.order.PayLoadingVM$createPayOrderId$1", f = "PayLoadingVM.kt", l = {Sdk$SDKMetric.SDKMetricType.AD_REWARD_USER_VALUE}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class PayLoadingVM$createPayOrderId$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreatePaynicornOrderReqBean $orderReq;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PayLoadingVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayLoadingVM$createPayOrderId$1(CreatePaynicornOrderReqBean createPaynicornOrderReqBean, PayLoadingVM payLoadingVM, Continuation<? super PayLoadingVM$createPayOrderId$1> continuation) {
        super(2, continuation);
        this.$orderReq = createPaynicornOrderReqBean;
        this.this$0 = payLoadingVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PayLoadingVM$createPayOrderId$1 payLoadingVM$createPayOrderId$1 = new PayLoadingVM$createPayOrderId$1(this.$orderReq, this.this$0, continuation);
        payLoadingVM$createPayOrderId$1.L$0 = obj;
        return payLoadingVM$createPayOrderId$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PayLoadingVM$createPayOrderId$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        HttpErrorBodyBean httpErrorBodyBean;
        b0 b0Var;
        PayLoadingVM payLoadingVM;
        b0 b0Var2;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                CreatePaynicornOrderReqBean createPaynicornOrderReqBean = this.$orderReq;
                PayLoadingVM payLoadingVM2 = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                g gVar = g.f53104a;
                this.L$0 = payLoadingVM2;
                this.label = 1;
                obj = gVar.b(createPaynicornOrderReqBean, this);
                if (obj == f11) {
                    return f11;
                }
                payLoadingVM = payLoadingVM2;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                payLoadingVM = (PayLoadingVM) this.L$0;
                ResultKt.b(obj);
            }
            b0Var2 = payLoadingVM.f53093d;
            b0Var2.n(((BaseDto) obj).getData());
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        PayLoadingVM payLoadingVM3 = this.this$0;
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            if (m1188exceptionOrNullimpl instanceof HttpException) {
                httpErrorBodyBean = HttpErrorBodyBean.INSTANCE.a((HttpException) m1188exceptionOrNullimpl);
            } else {
                String message = m1188exceptionOrNullimpl.getMessage();
                if (message == null) {
                    message = "";
                }
                httpErrorBodyBean = new HttpErrorBodyBean(message, TmcConstants.COLD_OPEN_TYPE, "");
            }
            b0Var = payLoadingVM3.f53095f;
            b0Var.n(httpErrorBodyBean);
        }
        return Unit.f67184a;
    }
}
