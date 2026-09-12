package com.transsion.payment.lib;

import android.app.Application;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.Utils;
import com.tencent.mmkv.MMKV;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.TranPay;
import com.tn.tranpay.TranPayClient;
import com.tn.tranpay.logger.LogLevel;
import com.transsion.payment.lib.b;
import com.transsion.payment.lib.bean.CreateOrderRes;
import com.transsion.payment.lib.bean.PrePayInfo;
import java.util.Locale;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import yg.b;

/* loaded from: classes6.dex */
public final class PaymentClientHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final PaymentClientHelper f47823a = new PaymentClientHelper();

    /* loaded from: classes6.dex */
    public static final class a implements com.tn.tranpay.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f47824a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0 f47825b;

        a(Function2 function2, Function0 function0) {
            this.f47824a = function2;
            this.f47825b = function0;
        }

        @Override // com.tn.tranpay.d
        public void a(com.tn.tranpay.b result, com.tn.tranpay.c cVar) {
            Intrinsics.h(result, "result");
            d dVar = d.f47833a;
            dVar.a("onPurchasesUpdated " + result + ", " + cVar);
            if (com.tn.tranpay.a.f41559a.a(result.b()) && cVar != null) {
                dVar.a(PaymentClientHelper.f47823a.b() + " --> observe() --> paynicorn result --> 轮询Paynicorn支付结果 ....");
                this.f47825b.invoke();
                return;
            }
            PaymentClientHelper paymentClientHelper = PaymentClientHelper.f47823a;
            dVar.b(paymentClientHelper.b() + " --> realPay() --> paynicorn result is cancel");
            int b11 = result.b();
            if (b11 == 1) {
                this.f47824a.invoke(1002, "observe() --> 取消支付");
                return;
            }
            if (b11 != 4) {
                this.f47824a.invoke(1004, "observe() --> 支付失败");
                return;
            }
            dVar.a(paymentClientHelper.b() + " --> processing--> paynicorn result --> 轮询Paynicorn支付结果 ....");
            this.f47824a.invoke(1003, "observe() --> 支付进行中");
        }
    }

    private PaymentClientHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b() {
        String simpleName = PaymentClientHelper.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void c() {
        String str;
        String str2;
        String string;
        MMKV c11 = bh.a.f16551a.c();
        String str3 = null;
        if (c11 == null || (string = c11.getString("custom_local_iso", "")) == null) {
            str = null;
        } else {
            str = string.toUpperCase(Locale.ROOT);
            Intrinsics.g(str, "toUpperCase(...)");
        }
        if (TextUtils.isEmpty(str)) {
            String g11 = ih.b.f65364a.g();
            if (g11 != null) {
                str3 = g11.toUpperCase(Locale.ROOT);
                Intrinsics.g(str3, "toUpperCase(...)");
            }
            str2 = str3;
        } else {
            str2 = str;
        }
        b.a aVar = yg.b.f79132a;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        String e11 = aVar.e(a11);
        if (e11 == null) {
            e11 = "gp";
        }
        String str4 = e11;
        TranPay tranPay = TranPay.f41540a;
        Application a12 = Utils.a();
        Intrinsics.g(a12, "getApp(...)");
        tranPay.b(a12, "3100484", c.f47830a.b(), str4, (r22 & 16) != 0 ? LogLevel.INFO : LogLevel.DEBUG, (r22 & 32) != 0 ? false : false, (r22 & 64) != 0, (r22 & 128) != 0 ? null : str2, (r22 & 256) != 0 ? com.tn.tranpay.e.f41591c.b() : null);
        tranPay.a(new PayLoggerPlugin());
    }

    public final void d(AppCompatActivity activity, final CreateOrderRes orderRequest, final b payCallback, final PaymentService paymentService) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(orderRequest, "orderRequest");
        Intrinsics.h(payCallback, "payCallback");
        Intrinsics.h(paymentService, "paymentService");
        d.f47833a.a(b() + " --> requestPay() --> 请求到数据 --> realPay() --> 打开端内WebView --> 展示收银台");
        PrePayInfo prePayInfo = orderRequest.getPrePayInfo();
        if ((prePayInfo != null ? prePayInfo.getOrderId() : null) == null || prePayInfo.getDescription() == null) {
            b.a.a(payCallback, 1001, "订单信息异常", false, null, 8, null);
            return;
        }
        payCallback.b(false);
        String price = prePayInfo.getPrice();
        if (price == null) {
            price = "0";
        }
        String str = price;
        String orderId = prePayInfo.getOrderId();
        String str2 = orderId == null ? "" : orderId;
        String description = prePayInfo.getDescription();
        String str3 = description == null ? "" : description;
        String txnId = orderRequest.getTxnId();
        String currency = prePayInfo.getCurrency();
        String referenceNo = prePayInfo.getReferenceNo();
        String str4 = referenceNo == null ? "" : referenceNo;
        String memo = prePayInfo.getMemo();
        Boolean payByLocalCurrency = prePayInfo.getPayByLocalCurrency();
        TranPayClient.f41542a.c(activity, new BillingParams(txnId, str, str2, str3, currency, str4, memo, null, null, false, payByLocalCurrency != null ? payByLocalCurrency.booleanValue() : false, 384, null), new com.tn.tranpay.d() { // from class: com.transsion.payment.lib.PaymentClientHelper$realPay$1
            @Override // com.tn.tranpay.d
            public void a(com.tn.tranpay.b result, com.tn.tranpay.c cVar) {
                Intrinsics.h(result, "result");
                d dVar = d.f47833a;
                dVar.a("onPurchasesUpdated " + result + ", " + cVar);
                if (com.tn.tranpay.a.f41559a.a(result.b()) && cVar != null) {
                    dVar.a(PaymentClientHelper.f47823a.b() + " --> realPay() --> paynicorn result --> 轮询Paynicorn支付结果 ....");
                    b.this.b(true);
                    k.d(o0.a(y0.b()), null, null, new PaymentClientHelper$realPay$1$onPurchasesUpdated$1(b.this, orderRequest, paymentService, null), 3, null);
                    return;
                }
                PaymentClientHelper paymentClientHelper = PaymentClientHelper.f47823a;
                dVar.b(paymentClientHelper.b() + " --> realPay() --> paynicorn result is cancel");
                b.this.b(false);
                int b11 = result.b();
                if (b11 == 1) {
                    b.this.a(1002, result.a(), false, orderRequest.getTradingOrderId());
                    return;
                }
                if (b11 != 4) {
                    b.this.a(1004, "observe() --> 支付失败", false, orderRequest.getTradingOrderId());
                    return;
                }
                dVar.a(paymentClientHelper.b() + " --> processing--> paynicorn result --> 轮询Paynicorn支付结果 ....");
                b.this.a(1003, "orderCheck4Paynicorn() --> code = 400 -- 支付未完成", false, orderRequest.getTradingOrderId());
            }
        });
    }

    public final void e(AppCompatActivity appCompatActivity, CreateOrderRes createOrderRes, Function2 payFail, Function0 orderCheck4Paynicorn) {
        Intrinsics.h(payFail, "payFail");
        Intrinsics.h(orderCheck4Paynicorn, "orderCheck4Paynicorn");
        d.f47833a.a(b() + " --> requestPay() --> 请求到数据 --> realPay() --> 打开端内WebView --> 展示收银台");
        PrePayInfo prePayInfo = createOrderRes != null ? createOrderRes.getPrePayInfo() : null;
        if ((prePayInfo != null ? prePayInfo.getOrderId() : null) == null || prePayInfo.getDescription() == null) {
            payFail.invoke(1001, "realPay() --> 打开端内WebView --> 展示收银台 -- > activity == null");
            return;
        }
        String price = prePayInfo.getPrice();
        if (price == null) {
            price = "0";
        }
        String str = price;
        String orderId = prePayInfo.getOrderId();
        String str2 = orderId == null ? "" : orderId;
        String description = prePayInfo.getDescription();
        String str3 = description == null ? "" : description;
        String txnId = createOrderRes.getTxnId();
        String currency = prePayInfo.getCurrency();
        String referenceNo = prePayInfo.getReferenceNo();
        String memo = prePayInfo.getMemo();
        Boolean payByLocalCurrency = prePayInfo.getPayByLocalCurrency();
        BillingParams billingParams = new BillingParams(txnId, str, str2, str3, currency, referenceNo, memo, null, null, false, payByLocalCurrency != null ? payByLocalCurrency.booleanValue() : false, 384, null);
        if (appCompatActivity != null) {
            TranPayClient.f41542a.c(appCompatActivity, billingParams, new a(payFail, orderCheck4Paynicorn));
        }
    }
}
