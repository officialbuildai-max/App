package com.tn.tranpay;

import com.tn.tranpay.bean.CurrencyInfoBean;
import com.tn.tranpay.helper.PaymentMMKV;
import com.tn.tranpay.network.RetrofitClient;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes4.dex */
public final class TranPayConfiguration {

    /* renamed from: b, reason: collision with root package name */
    private static String f41545b;

    /* renamed from: e, reason: collision with root package name */
    private static String f41548e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f41549f;

    /* renamed from: h, reason: collision with root package name */
    private static String f41551h;

    /* renamed from: i, reason: collision with root package name */
    private static String f41552i;

    /* renamed from: j, reason: collision with root package name */
    private static String f41553j;

    /* renamed from: k, reason: collision with root package name */
    private static String f41554k;

    /* renamed from: l, reason: collision with root package name */
    private static String f41555l;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f41556m;

    /* renamed from: n, reason: collision with root package name */
    private static CurrencyInfoBean f41557n;

    /* renamed from: a, reason: collision with root package name */
    public static final TranPayConfiguration f41544a = new TranPayConfiguration();

    /* renamed from: c, reason: collision with root package name */
    private static String f41546c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f41547d = "";

    /* renamed from: g, reason: collision with root package name */
    private static boolean f41550g = true;

    /* renamed from: o, reason: collision with root package name */
    private static final Lazy f41558o = LazyKt.b(new Function0<com.tn.tranpay.network.b>() { // from class: com.tn.tranpay.TranPayConfiguration$iPaymentApi$2
        @Override // kotlin.jvm.functions.Function0
        public final com.tn.tranpay.network.b invoke() {
            return (com.tn.tranpay.network.b) RetrofitClient.f41709a.d().b(com.tn.tranpay.network.b.class);
        }
    });

    private TranPayConfiguration() {
    }

    private final void E() {
        k.d(o0.a(y0.c()), null, null, new TranPayConfiguration$updateCurrencyInfo$1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(com.tn.tranpay.bean.CurrencyInfoBean r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.tn.tranpay.TranPayConfiguration$cacheCurrencyInfo$1
            if (r0 == 0) goto L13
            r0 = r8
            com.tn.tranpay.TranPayConfiguration$cacheCurrencyInfo$1 r0 = (com.tn.tranpay.TranPayConfiguration$cacheCurrencyInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.tn.tranpay.TranPayConfiguration$cacheCurrencyInfo$1 r0 = new com.tn.tranpay.TranPayConfiguration$cacheCurrencyInfo$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L33
            if (r2 != r4) goto L2b
            kotlin.ResultKt.b(r8)
            goto L6f
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            kotlin.ResultKt.b(r8)
            java.lang.String r8 = com.tn.tranpay.TranPayConfiguration.f41548e
            if (r8 == 0) goto L64
            int r8 = r8.length()
            if (r8 != 0) goto L41
            goto L64
        L41:
            com.tn.tranpay.helper.PaymentMMKV r8 = com.tn.tranpay.helper.PaymentMMKV.f41698a
            java.lang.String r0 = com.tn.tranpay.TranPayConfiguration.f41548e
            kotlin.jvm.internal.Intrinsics.e(r0)
            r8.b(r0, r7)
            ai.a r7 = ai.a.f694a
            java.lang.String r8 = com.tn.tranpay.TranPayConfiguration.f41548e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "按region缓存货币信息: region="
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            ai.a.g(r7, r8, r5, r3, r5)
            goto L76
        L64:
            com.tn.tranpay.helper.PaymentMMKV r8 = com.tn.tranpay.helper.PaymentMMKV.f41698a
            r0.label = r4
            java.lang.Object r7 = r8.a(r7, r0)
            if (r7 != r1) goto L6f
            return r1
        L6f:
            ai.a r7 = ai.a.f694a
            java.lang.String r8 = "按IP+日期缓存货币信息"
            ai.a.g(r7, r8, r5, r3, r5)
        L76:
            kotlin.Unit r7 = kotlin.Unit.f67184a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tn.tranpay.TranPayConfiguration.d(com.tn.tranpay.bean.CurrencyInfoBean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(boolean r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.tn.tranpay.TranPayConfiguration$fetchAndUpdateCurrencyInfo$1
            if (r0 == 0) goto L13
            r0 = r6
            com.tn.tranpay.TranPayConfiguration$fetchAndUpdateCurrencyInfo$1 r0 = (com.tn.tranpay.TranPayConfiguration$fetchAndUpdateCurrencyInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.tn.tranpay.TranPayConfiguration$fetchAndUpdateCurrencyInfo$1 r0 = new com.tn.tranpay.TranPayConfiguration$fetchAndUpdateCurrencyInfo$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            boolean r5 = r0.Z$0
            kotlin.ResultKt.b(r6)
            goto L41
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.b(r6)
            r0.Z$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.o(r0)
            if (r6 != r1) goto L41
            return r1
        L41:
            com.tn.tranpay.network.BaseDto r6 = (com.tn.tranpay.network.BaseDto) r6
            r0 = 0
            if (r6 == 0) goto L4d
            java.lang.Object r1 = r6.getData()
            com.tn.tranpay.bean.CurrencyInfoBean r1 = (com.tn.tranpay.bean.CurrencyInfoBean) r1
            goto L4e
        L4d:
            r1 = r0
        L4e:
            r2 = 2
            if (r1 == 0) goto L91
            java.lang.Object r6 = r6.getData()
            com.tn.tranpay.bean.CurrencyInfoBean r6 = (com.tn.tranpay.bean.CurrencyInfoBean) r6
            com.tn.tranpay.TranPayConfiguration.f41557n = r6
            if (r5 == 0) goto L60
            com.tn.tranpay.report.h r5 = com.tn.tranpay.report.h.f41739a
            r5.c(r3)
        L60:
            ai.a r5 = ai.a.f694a
            com.tn.tranpay.bean.CurrencyInfoBean r6 = com.tn.tranpay.TranPayConfiguration.f41557n
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Currency info updated successfully: "
            r1.append(r3)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            ai.a.g(r5, r6, r0, r2, r0)
            com.tn.tranpay.bean.CurrencyInfoBean r5 = com.tn.tranpay.TranPayConfiguration.f41557n
            if (r5 == 0) goto L81
            java.lang.String r5 = r5.getCountryCode()
            goto L82
        L81:
            r5 = r0
        L82:
            com.tn.tranpay.TranPayConfiguration.f41553j = r5
            com.tn.tranpay.bean.CurrencyInfoBean r5 = com.tn.tranpay.TranPayConfiguration.f41557n
            if (r5 == 0) goto L8c
            java.lang.String r0 = r5.getCurrency()
        L8c:
            com.tn.tranpay.TranPayConfiguration.f41554k = r0
            com.tn.tranpay.bean.CurrencyInfoBean r0 = com.tn.tranpay.TranPayConfiguration.f41557n
            goto La0
        L91:
            if (r5 == 0) goto L99
            com.tn.tranpay.report.h r5 = com.tn.tranpay.report.h.f41739a
            r6 = 0
            r5.c(r6)
        L99:
            ai.a r5 = ai.a.f694a
            java.lang.String r6 = "Failed to update currency info"
            ai.a.e(r5, r6, r0, r2, r0)
        La0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tn.tranpay.TranPayConfiguration.e(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object i(Continuation continuation) {
        String str = f41548e;
        if (str == null || str.length() == 0) {
            return PaymentMMKV.f41698a.f(continuation);
        }
        PaymentMMKV paymentMMKV = PaymentMMKV.f41698a;
        String str2 = f41548e;
        Intrinsics.e(str2);
        return paymentMMKV.g(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|7|(1:(1:(1:(6:12|13|14|15|16|(2:18|19)(2:21|(2:23|24)(1:25)))(2:27|28))(6:29|30|(2:32|(1:34)(2:35|14))|15|16|(0)(0)))(1:36))(2:44|(1:46))|37|(2:39|40)(7:41|(1:43)|30|(0)|15|16|(0)(0))))|49|6|7|(0)(0)|37|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0035, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ac, code lost:
    
        r0 = kotlin.Result.INSTANCE;
        r8 = kotlin.Result.m1185constructorimpl(kotlin.ResultKt.a(r8));
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:13:0x0030, B:15:0x00a7, B:29:0x0040, B:30:0x008e, B:32:0x0098, B:41:0x007b), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007b A[Catch: all -> 0x0035, TRY_ENTER, TryCatch #0 {all -> 0x0035, blocks: (B:13:0x0030, B:15:0x00a7, B:29:0x0040, B:30:0x008e, B:32:0x0098, B:41:0x007b), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(kotlin.coroutines.Continuation r8) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tn.tranpay.TranPayConfiguration.o(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final com.tn.tranpay.network.b r() {
        Object value = f41558o.getValue();
        Intrinsics.g(value, "<get-iPaymentApi>(...)");
        return (com.tn.tranpay.network.b) value;
    }

    public final void A(boolean z10) {
        f41550g = z10;
    }

    public final void B(String str) {
        f41548e = str;
    }

    public final void C() {
        E();
    }

    public final void D(BillingParams params) {
        Intrinsics.h(params, "params");
        f41551h = params.getOrderId();
        f41554k = params.getCurrency();
        f41555l = params.getAmount();
        f41552i = params.getTxnId();
    }

    public final Object f(Continuation continuation) {
        CurrencyInfoBean currencyInfoBean = f41557n;
        return currencyInfoBean == null ? e(false, continuation) : currencyInfoBean;
    }

    public final String g() {
        return f41555l;
    }

    public final String h() {
        return f41546c;
    }

    public final String j() {
        return f41547d;
    }

    public final String k() {
        return f41553j;
    }

    public final String l() {
        return f41545b;
    }

    public final String m() {
        return f41554k;
    }

    public final CurrencyInfoBean n() {
        return f41557n;
    }

    public final boolean p() {
        return f41549f;
    }

    public final boolean q() {
        return f41556m;
    }

    public final String s() {
        return f41551h;
    }

    public final String t() {
        return f41552i;
    }

    public final boolean u() {
        return f41550g;
    }

    public final void v(String str) {
        Intrinsics.h(str, "<set-?>");
        f41546c = str;
    }

    public final void w(String str) {
        Intrinsics.h(str, "<set-?>");
        f41547d = str;
    }

    public final void x(String str) {
        f41545b = str;
    }

    public final void y(boolean z10) {
        f41549f = z10;
    }

    public final void z(boolean z10) {
        f41556m = z10;
    }
}
