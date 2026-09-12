package com.transsion.payment.lib;

import android.app.Application;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.Utils;
import com.transsion.payment.lib.bean.CreateOrderReq;
import com.transsion.payment.lib.dialog.PaynicornDuringThePaymentDialog;
import com.transsion.payment.lib.strategy.GoogleStrategy;
import com.transsion.payment.lib.strategy.PaynicornStrategy;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yg.b;

/* loaded from: classes6.dex */
public final class f {

    /* renamed from: b */
    public static final a f47848b = new a(null);

    /* renamed from: c */
    private static final Lazy f47849c = LazyKt.b(new Function0() { // from class: com.transsion.payment.lib.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            f d11;
            d11 = f.d();
            return d11;
        }
    });

    /* renamed from: a */
    private com.transsion.payment.lib.strategy.g f47850a;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final f a() {
            return (f) f.f47849c.getValue();
        }
    }

    public f() {
        b.a aVar = yg.b.f79132a;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        String e11 = aVar.e(a11);
        com.transsion.payment.lib.strategy.g googleStrategy = TextUtils.equals(e11, "gp") ? new GoogleStrategy() : new PaynicornStrategy();
        this.f47850a = googleStrategy;
        d.f47833a.a("PaymentManager() --> init{} --> channel = " + e11 + " -- payStrategy = " + googleStrategy.getClass().getSimpleName());
    }

    private final String c() {
        String simpleName = f.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public static final f d() {
        return new f();
    }

    public final void e(AppCompatActivity activity, String productId, Double d11, String str, boolean z10, Map map, b payCallback, Function1 function1) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(productId, "productId");
        Intrinsics.h(payCallback, "payCallback");
        CreateOrderReq createOrderReq = new CreateOrderReq(productId, str, z10, map, d11);
        b.a aVar = yg.b.f79132a;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        String e11 = aVar.e(a11);
        d.f47833a.a(c() + " --> requestPay() --> channel = " + e11 + " --> orderReq = " + createOrderReq);
        if (TextUtils.equals(e11, "gp")) {
            com.transsion.payment.lib.strategy.g gVar = this.f47850a;
            if (gVar != null) {
                gVar.b(activity, createOrderReq, z10, payCallback, function1);
                return;
            }
            return;
        }
        PaynicornDuringThePaymentDialog paynicornDuringThePaymentDialog = new PaynicornDuringThePaymentDialog();
        paynicornDuringThePaymentDialog.S0(payCallback);
        paynicornDuringThePaymentDialog.U0(createOrderReq);
        paynicornDuringThePaymentDialog.T0(function1);
        paynicornDuringThePaymentDialog.k0(activity, "PaynicornDuringThePaymentDialog");
    }

    public final void g() {
        Application a11 = Utils.a();
        com.transsion.payment.lib.strategy.g gVar = this.f47850a;
        if (gVar != null) {
            Intrinsics.e(a11);
            gVar.init(a11);
        }
    }
}
