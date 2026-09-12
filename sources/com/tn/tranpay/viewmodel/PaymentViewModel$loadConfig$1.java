package com.tn.tranpay.viewmodel;

import ai.a;
import com.google.gson.Gson;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.bean.InputInfoBean;
import com.tn.tranpay.bean.LoadConfigContent;
import com.tn.tranpay.bean.MediumInputBean;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.tn.tranpay.viewmodel.PaymentViewModel$loadConfig$1", f = "PaymentViewModel.kt", l = {Sdk$SDKError.Reason.TPAT_ERROR_VALUE}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class PaymentViewModel$loadConfig$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ BillingParams $params;
    int label;
    final /* synthetic */ PaymentViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentViewModel$loadConfig$1(PaymentViewModel paymentViewModel, BillingParams billingParams, Continuation<? super PaymentViewModel$loadConfig$1> continuation) {
        super(2, continuation);
        this.this$0 = paymentViewModel;
        this.$params = billingParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaymentViewModel$loadConfig$1(this.this$0, this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PaymentViewModel$loadConfig$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Gson gson;
        Map<String, String> h11;
        List<MediumInputBean> medium;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            PaymentViewModel paymentViewModel = this.this$0;
            String txnId = this.$params.getTxnId();
            String language = this.$params.getLanguage();
            this.label = 1;
            obj = paymentViewModel.F(txnId, language, this);
            if (obj == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        LoadConfigContent loadConfigContent = (LoadConfigContent) obj;
        a aVar = a.f694a;
        gson = this.this$0.f41751l;
        a.g(aVar, "GetPaymentMethods result = " + gson.toJson(loadConfigContent), null, 2, null);
        a.g(aVar, "loadConfig code=" + (loadConfigContent != null ? loadConfigContent.getCode() : null) + ", message=" + (loadConfigContent != null ? loadConfigContent.getMessage() : null), null, 2, null);
        if (loadConfigContent == null || (h11 = loadConfigContent.getLanguagePackage()) == null) {
            h11 = MapsKt.h();
        }
        if (loadConfigContent != null && (medium = loadConfigContent.getMedium()) != null) {
            for (MediumInputBean mediumInputBean : medium) {
                a.c(a.f694a, "The medium.name: " + mediumInputBean.getName() + ", " + mediumInputBean.getCode(), null, 2, null);
                List<InputInfoBean> inputs = mediumInputBean.getInputs();
                if (inputs != null) {
                    for (InputInfoBean inputInfoBean : inputs) {
                        String str = h11.get(inputInfoBean.getTips());
                        String str2 = h11.get(inputInfoBean.getHint());
                        a.c(a.f694a, "InputTip: " + str + ", hint: " + str2, null, 2, null);
                        String realHint = inputInfoBean.getRealHint();
                        if (realHint != null) {
                            str2 = realHint;
                        } else if (str2 == null) {
                            str2 = inputInfoBean.getHint();
                        }
                        inputInfoBean.setRealHint(str2);
                        String realTips = inputInfoBean.getRealTips();
                        if (realTips != null) {
                            str = realTips;
                        } else if (str == null) {
                            str = inputInfoBean.getTips();
                        }
                        inputInfoBean.setRealTips(str);
                    }
                }
            }
        }
        if (loadConfigContent != null) {
            this.this$0.q().n(loadConfigContent);
        } else {
            this.this$0.q().n(null);
        }
        return Unit.f67184a;
    }
}
