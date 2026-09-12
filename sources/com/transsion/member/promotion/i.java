package com.transsion.member.promotion;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.therouter.TheRouter;
import com.transsion.member.R$string;
import com.transsion.memberapi.IPremiumApi;
import com.transsion.memberapi.SkuPromotionItem;
import com.transsion.memberapi.SkuPromotionSku;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes5.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f46745a = new i();

    /* loaded from: classes5.dex */
    public static final class a implements com.transsion.payment.lib.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SkuPromotionItem f46746a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f46747b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f46748c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0 f46749d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f46750e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function0 f46751f;

        a(SkuPromotionItem skuPromotionItem, String str, String str2, Function0 function0, Context context, Function0 function02) {
            this.f46746a = skuPromotionItem;
            this.f46747b = str;
            this.f46748c = str2;
            this.f46749d = function0;
            this.f46750e = context;
            this.f46751f = function02;
        }

        @Override // com.transsion.payment.lib.b
        public void a(Integer num, String str, boolean z10, String str2) {
            a.C0856a.l(lg.a.f68962a, "premium_", "Payment failed " + str + ", " + num, false, 4, null);
            if (num != null && num.intValue() == -30) {
                com.tn.lib.widget.toast.core.h.f41533a.l(((AppCompatActivity) this.f46750e).getString(R$string.member_pay_pending));
            } else if (num != null && num.intValue() == 1003) {
                i.f46745a.d(num, str, str2 == null ? "" : str2, this.f46746a, this.f46748c, this.f46747b);
                com.tn.lib.widget.toast.core.h.f41533a.l(((AppCompatActivity) this.f46750e).getString(R$string.member_pay_processing));
            } else {
                i.f46745a.d(num, str, str2 == null ? "" : str2, this.f46746a, this.f46748c, this.f46747b);
                com.tn.lib.widget.toast.core.h.f41533a.l(((AppCompatActivity) this.f46750e).getString(R$string.member_pay_failed));
            }
            Function0 function0 = this.f46751f;
            if (function0 != null) {
            }
        }

        @Override // com.transsion.payment.lib.b
        public void b(boolean z10) {
        }

        @Override // com.transsion.payment.lib.b
        public void c(int i11, String balance, String str) {
            Intrinsics.h(balance, "balance");
            i.f46745a.e(this.f46746a, str, this.f46747b, this.f46748c);
            IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
            if (iPremiumApi != null) {
                iPremiumApi.g(null);
            }
            Function0 function0 = this.f46749d;
            if (function0 != null) {
            }
        }
    }

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(Integer num, String str, String str2, SkuPromotionItem skuPromotionItem, String str3, String str4) {
        String str5;
        SkuPromotionSku sku;
        HashMap hashMap = new HashMap();
        hashMap.put("opt_type", "pay_result");
        hashMap.put("result_type", "result_fail");
        hashMap.put("fail_code", String.valueOf(num));
        if (str == null) {
            str = "";
        }
        hashMap.put("fail_message", str);
        if (skuPromotionItem == null || (sku = skuPromotionItem.getSku()) == null || (str5 = sku.getSkuId()) == null) {
            str5 = "";
        }
        hashMap.put("sku_id", str5);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("order_id", str2);
        hashMap.put("trace_id", str4);
        hj.i iVar = hj.i.f64628a;
        if (str3 == null) {
            str3 = "";
        }
        iVar.s(str3, "purchase", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(SkuPromotionItem skuPromotionItem, String str, String str2, String str3) {
        String str4;
        SkuPromotionSku sku;
        HashMap hashMap = new HashMap();
        hashMap.put("opt_type", "pay_result");
        hashMap.put("result_type", "result_success");
        if (skuPromotionItem == null || (sku = skuPromotionItem.getSku()) == null || (str4 = sku.getSkuId()) == null) {
            str4 = "";
        }
        hashMap.put("sku_id", str4);
        if (str == null) {
            str = "";
        }
        hashMap.put("order_id", str);
        hashMap.put("trace_id", str2);
        hj.i iVar = hj.i.f64628a;
        if (str3 == null) {
            str3 = "";
        }
        iVar.s(str3, "purchase", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(String str, SkuPromotionItem skuPromotionItem, String str2, String str3, String str4, String orderId) {
        SkuPromotionSku sku;
        String skuId;
        Intrinsics.h(orderId, "orderId");
        com.transsion.baselib.helper.f.f43323a.a(str == null ? "" : str, str2, orderId, str3, (skuPromotionItem == null || (sku = skuPromotionItem.getSku()) == null || (skuId = sku.getSkuId()) == null) ? "" : skuId, str4);
        return Unit.f67184a;
    }

    public final void f(Context context, final SkuPromotionItem skuPromotionItem, final String str, final String str2, final String str3, final String traceId, Function0 function0, Function0 function02) {
        String str4;
        SkuPromotionSku sku;
        SkuPromotionSku sku2;
        String skuId;
        Intrinsics.h(traceId, "traceId");
        Double d11 = null;
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (skuPromotionItem == null || (str4 = skuPromotionItem.getMarketingActivityId()) == null) {
                str4 = "";
            }
            linkedHashMap.put("marketingActivityId", str4);
            com.transsion.payment.lib.f a11 = com.transsion.payment.lib.f.f47848b.a();
            String str5 = (skuPromotionItem == null || (sku2 = skuPromotionItem.getSku()) == null || (skuId = sku2.getSkuId()) == null) ? "" : skuId;
            if (skuPromotionItem != null && (sku = skuPromotionItem.getSku()) != null) {
                d11 = sku.getDiscountPrice();
            }
            a11.e(appCompatActivity, str5, d11, null, false, linkedHashMap, new a(skuPromotionItem, traceId, str, function0, context, function02), new Function1() { // from class: com.transsion.member.promotion.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit g11;
                    g11 = i.g(str, skuPromotionItem, str3, traceId, str2, (String) obj);
                    return g11;
                }
            });
        }
    }
}
