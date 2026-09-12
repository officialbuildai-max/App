package com.tn.tranpay.viewmodel;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import androidx.view.b0;
import androidx.view.t0;
import com.google.gson.Gson;
import com.tn.tranpay.BillingParams;
import com.tn.tranpay.TranPayConfiguration;
import com.tn.tranpay.bean.CurrencyInfoBean;
import com.tn.tranpay.bean.LoadConfigContent;
import com.tn.tranpay.d;
import com.tn.tranpay.network.RetrofitClient;
import com.tn.tranpay.network.b;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

/* loaded from: classes4.dex */
public final class PaymentViewModel extends t0 {

    /* renamed from: b, reason: collision with root package name */
    private t1 f41741b;

    /* renamed from: c, reason: collision with root package name */
    private String f41742c;

    /* renamed from: d, reason: collision with root package name */
    private String f41743d;

    /* renamed from: e, reason: collision with root package name */
    private String f41744e;

    /* renamed from: f, reason: collision with root package name */
    private String f41745f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f41746g;

    /* renamed from: h, reason: collision with root package name */
    private String f41747h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f41748i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f41749j;

    /* renamed from: k, reason: collision with root package name */
    private d f41750k;

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f41740a = LazyKt.b(new Function0<b>() { // from class: com.tn.tranpay.viewmodel.PaymentViewModel$iPaymentApi$2
        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return (b) RetrofitClient.f41709a.d().b(b.class);
        }
    });

    /* renamed from: l, reason: collision with root package name */
    private final Gson f41751l = new Gson();

    /* renamed from: m, reason: collision with root package name */
    private final b0 f41752m = new b0();

    /* renamed from: n, reason: collision with root package name */
    private final b0 f41753n = new b0();

    /* renamed from: o, reason: collision with root package name */
    private final b0 f41754o = new b0();

    /* renamed from: p, reason: collision with root package name */
    private final b0 f41755p = new b0();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object B(java.lang.String r6, java.lang.String r7, java.lang.String r8, kotlin.coroutines.Continuation r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.tn.tranpay.viewmodel.PaymentViewModel$handleCancelPay$1
            if (r0 == 0) goto L13
            r0 = r9
            com.tn.tranpay.viewmodel.PaymentViewModel$handleCancelPay$1 r0 = (com.tn.tranpay.viewmodel.PaymentViewModel$handleCancelPay$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.tn.tranpay.viewmodel.PaymentViewModel$handleCancelPay$1 r0 = new com.tn.tranpay.viewmodel.PaymentViewModel$handleCancelPay$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L2a
            goto L6b
        L2a:
            r6 = move-exception
            goto L6f
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            kotlin.ResultKt.b(r9)
            kotlin.Result$Companion r9 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L2a
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L2a
            r9.<init>()     // Catch: java.lang.Throwable -> L2a
            java.lang.String r2 = "txnId"
            r9.put(r2, r6)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r6 = "bindToken"
            r9.put(r6, r8)     // Catch: java.lang.Throwable -> L2a
            java.lang.String r6 = "reason"
            r9.put(r6, r7)     // Catch: java.lang.Throwable -> L2a
            com.tn.tranpay.helper.c$a r6 = com.tn.tranpay.helper.c.f41706a     // Catch: java.lang.Throwable -> L2a
            java.lang.String r7 = r9.toString()     // Catch: java.lang.Throwable -> L2a
            java.lang.String r8 = "json.toString()"
            kotlin.jvm.internal.Intrinsics.g(r7, r8)     // Catch: java.lang.Throwable -> L2a
            okhttp3.RequestBody r6 = r6.a(r7)     // Catch: java.lang.Throwable -> L2a
            if (r6 == 0) goto L6e
            com.tn.tranpay.network.b r7 = r5.v()     // Catch: java.lang.Throwable -> L2a
            r0.label = r3     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r9 = r7.d(r6, r0)     // Catch: java.lang.Throwable -> L2a
            if (r9 != r1) goto L6b
            return r1
        L6b:
            com.tn.tranpay.bean.QueryOrderResultContent r9 = (com.tn.tranpay.bean.QueryOrderResultContent) r9     // Catch: java.lang.Throwable -> L2a
            r4 = r9
        L6e:
            return r4
        L6f:
            kotlin.Result$Companion r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.ResultKt.a(r6)
            java.lang.Object r6 = kotlin.Result.m1185constructorimpl(r6)
            java.lang.Throwable r6 = kotlin.Result.m1188exceptionOrNullimpl(r6)
            if (r6 == 0) goto L9b
            ai.a r7 = ai.a.f694a
            java.lang.String r6 = r6.getMessage()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "CancelOrder error is "
            r8.append(r9)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r8 = 2
            ai.a.e(r7, r6, r4, r8, r4)
            return r4
        L9b:
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tn.tranpay.viewmodel.PaymentViewModel.B(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:11:0x0029, B:12:0x0105, B:20:0x004e, B:21:0x0086, B:23:0x0092, B:25:0x00a2, B:27:0x00bb, B:28:0x00c0, B:30:0x00ee, B:35:0x009a, B:39:0x0055, B:41:0x006d), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ee A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:11:0x0029, B:12:0x0105, B:20:0x004e, B:21:0x0086, B:23:0x0092, B:25:0x00a2, B:27:0x00bb, B:28:0x00c0, B:30:0x00ee, B:35:0x009a, B:39:0x0055, B:41:0x006d), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object C(java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation r13) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tn.tranpay.viewmodel.PaymentViewModel.C(java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D(java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.tn.tranpay.viewmodel.PaymentViewModel$handleQuery$1
            if (r0 == 0) goto L13
            r0 = r7
            com.tn.tranpay.viewmodel.PaymentViewModel$handleQuery$1 r0 = (com.tn.tranpay.viewmodel.PaymentViewModel$handleQuery$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.tn.tranpay.viewmodel.PaymentViewModel$handleQuery$1 r0 = new com.tn.tranpay.viewmodel.PaymentViewModel$handleQuery$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L2a
            goto L61
        L2a:
            r6 = move-exception
            goto L65
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            kotlin.ResultKt.b(r7)
            kotlin.Result$Companion r7 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L2a
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L2a
            r7.<init>()     // Catch: java.lang.Throwable -> L2a
            java.lang.String r2 = "txnId"
            r7.put(r2, r6)     // Catch: java.lang.Throwable -> L2a
            com.tn.tranpay.helper.c$a r6 = com.tn.tranpay.helper.c.f41706a     // Catch: java.lang.Throwable -> L2a
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L2a
            java.lang.String r2 = "json.toString()"
            kotlin.jvm.internal.Intrinsics.g(r7, r2)     // Catch: java.lang.Throwable -> L2a
            okhttp3.RequestBody r6 = r6.a(r7)     // Catch: java.lang.Throwable -> L2a
            if (r6 == 0) goto L64
            com.tn.tranpay.network.b r7 = r5.v()     // Catch: java.lang.Throwable -> L2a
            r0.label = r3     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r7 = r7.a(r6, r0)     // Catch: java.lang.Throwable -> L2a
            if (r7 != r1) goto L61
            return r1
        L61:
            com.tn.tranpay.bean.QueryOrderResultContent r7 = (com.tn.tranpay.bean.QueryOrderResultContent) r7     // Catch: java.lang.Throwable -> L2a
            r4 = r7
        L64:
            return r4
        L65:
            kotlin.Result$Companion r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.ResultKt.a(r6)
            java.lang.Object r6 = kotlin.Result.m1185constructorimpl(r6)
            java.lang.Throwable r6 = kotlin.Result.m1188exceptionOrNullimpl(r6)
            if (r6 == 0) goto L91
            ai.a r7 = ai.a.f694a
            java.lang.String r6 = r6.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Query error is "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r0 = 2
            ai.a.e(r7, r6, r4, r0, r4)
            return r4
        L91:
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tn.tranpay.viewmodel.PaymentViewModel.D(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void E(BillingParams billingParams) {
        k.d(o0.a(y0.c()), null, null, new PaymentViewModel$loadConfig$1(this, billingParams, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object F(java.lang.String r9, java.lang.String r10, kotlin.coroutines.Continuation r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.tn.tranpay.viewmodel.PaymentViewModel$loadConfigBean$1
            if (r0 == 0) goto L13
            r0 = r11
            com.tn.tranpay.viewmodel.PaymentViewModel$loadConfigBean$1 r0 = (com.tn.tranpay.viewmodel.PaymentViewModel$loadConfigBean$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.tn.tranpay.viewmodel.PaymentViewModel$loadConfigBean$1 r0 = new com.tn.tranpay.viewmodel.PaymentViewModel$loadConfigBean$1
            r0.<init>(r8, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Throwable -> L2c
            goto Laf
        L2c:
            r9 = move-exception
            goto Lb3
        L2f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L37:
            kotlin.ResultKt.b(r11)
            kotlin.Result$Companion r11 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L2c
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L2c
            r11.<init>()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r2 = "txnId"
            r11.put(r2, r9)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r9 = "language"
            if (r10 == 0) goto L4e
            r11.put(r9, r10)     // Catch: java.lang.Throwable -> L2c
            goto L84
        L4e:
            com.tn.tranpay.TranPay r10 = com.tn.tranpay.TranPay.f41540a     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L64
            android.app.Application r10 = r10.d()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L64
            java.util.Locale r10 = r8.r(r10)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L64
            java.lang.String r10 = r10.getLanguage()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L64
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L64
            r11.put(r9, r10)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L64
            goto L84
        L64:
            r10 = move-exception
            ai.a r2 = ai.a.f694a     // Catch: java.lang.Throwable -> L2c
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> L2c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2c
            r6.<init>()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r7 = "Failed to get locale language: "
            r6.append(r7)     // Catch: java.lang.Throwable -> L2c
            r6.append(r10)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r10 = r6.toString()     // Catch: java.lang.Throwable -> L2c
            ai.a.e(r2, r10, r5, r3, r5)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r10 = "en"
            r11.put(r9, r10)     // Catch: java.lang.Throwable -> L2c
        L84:
            java.lang.String r9 = "timestamp"
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r10 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L2c
            r11.put(r9, r10)     // Catch: java.lang.Throwable -> L2c
            com.tn.tranpay.helper.c$a r9 = com.tn.tranpay.helper.c.f41706a     // Catch: java.lang.Throwable -> L2c
            java.lang.String r10 = r11.toString()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r11 = "json.toString()"
            kotlin.jvm.internal.Intrinsics.g(r10, r11)     // Catch: java.lang.Throwable -> L2c
            okhttp3.RequestBody r9 = r9.a(r10)     // Catch: java.lang.Throwable -> L2c
            if (r9 == 0) goto Lb2
            com.tn.tranpay.network.b r10 = r8.v()     // Catch: java.lang.Throwable -> L2c
            r0.label = r4     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r11 = r10.b(r9, r0)     // Catch: java.lang.Throwable -> L2c
            if (r11 != r1) goto Laf
            return r1
        Laf:
            com.tn.tranpay.bean.LoadConfigContent r11 = (com.tn.tranpay.bean.LoadConfigContent) r11     // Catch: java.lang.Throwable -> L2c
            r5 = r11
        Lb2:
            return r5
        Lb3:
            kotlin.Result$Companion r10 = kotlin.Result.INSTANCE
            java.lang.Object r9 = kotlin.ResultKt.a(r9)
            java.lang.Object r9 = kotlin.Result.m1185constructorimpl(r9)
            java.lang.Throwable r9 = kotlin.Result.m1188exceptionOrNullimpl(r9)
            if (r9 == 0) goto Lde
            ai.a r10 = ai.a.f694a
            java.lang.String r9 = r9.getMessage()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "LoadConfigFailed error is "
            r11.append(r0)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            ai.a.e(r10, r9, r5, r3, r5)
            return r5
        Lde:
            kotlin.KotlinNothingValueException r9 = new kotlin.KotlinNothingValueException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tn.tranpay.viewmodel.PaymentViewModel.F(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void H(PaymentViewModel paymentViewModel, String str, long j11, long j12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = 5000;
        }
        long j13 = j11;
        if ((i11 & 4) != 0) {
            j12 = 600000;
        }
        paymentViewModel.G(str, j13, j12);
    }

    private final void I(String str) {
        k.d(o0.a(y0.c()), null, null, new PaymentViewModel$queryOnce$1(this, str, null), 3, null);
    }

    public static /* synthetic */ void h(PaymentViewModel paymentViewModel, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = null;
        }
        paymentViewModel.g(str, str2, str3);
    }

    public static /* synthetic */ void k(PaymentViewModel paymentViewModel, String str, String str2, String str3, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        if ((i11 & 4) != 0) {
            str3 = null;
        }
        if ((i11 & 8) != 0) {
            z10 = false;
        }
        paymentViewModel.j(str, str2, str3, z10);
    }

    private final Locale r(Context context) {
        LocaleList locales;
        Locale locale;
        Configuration configuration = context.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT < 24) {
            Locale locale2 = configuration.locale;
            Intrinsics.g(locale2, "{\n            configuration.locale\n        }");
            return locale2;
        }
        locales = configuration.getLocales();
        locale = locales.get(0);
        Intrinsics.g(locale, "{\n            configuration.locales[0]\n        }");
        return locale;
    }

    private final b v() {
        Object value = this.f41740a.getValue();
        Intrinsics.g(value, "<get-iPaymentApi>(...)");
        return (b) value;
    }

    public final String A() {
        return this.f41742c;
    }

    public final void G(String txnId, long j11, long j12) {
        t1 d11;
        Intrinsics.h(txnId, "txnId");
        d11 = k.d(o0.a(y0.c()), null, null, new PaymentViewModel$query$1(j11, j12, this, txnId, null), 3, null);
        this.f41741b = d11;
    }

    public final void J() {
        t1 t1Var = this.f41741b;
        if (t1Var != null) {
            t1.a.b(t1Var, null, 1, null);
        }
        String str = this.f41742c;
        if (str != null) {
            I(str);
        }
    }

    public final void K(d dVar) {
        this.f41750k = dVar;
    }

    public final void L(boolean z10) {
        this.f41749j = z10;
    }

    public final void M(boolean z10) {
        this.f41748i = z10;
    }

    public final void N(String str) {
        this.f41743d = str;
    }

    public final void O(String str) {
        this.f41747h = str;
    }

    public final void P(String str) {
        this.f41742c = str;
    }

    public final void g(String txnId, String reason, String str) {
        Intrinsics.h(txnId, "txnId");
        Intrinsics.h(reason, "reason");
        k.d(o0.a(y0.c()), null, null, new PaymentViewModel$cancelPay$1(this, txnId, reason, str, null), 3, null);
    }

    public final void i() {
        t1 t1Var = this.f41741b;
        if (t1Var != null) {
            t1.a.b(t1Var, null, 1, null);
        }
    }

    public final void j(String payMethod, String str, String str2, boolean z10) {
        Intrinsics.h(payMethod, "payMethod");
        this.f41744e = str;
        this.f41745f = str2;
        this.f41746g = z10;
        this.f41755p.n(Boolean.TRUE);
        k.d(o0.a(y0.c()), null, null, new PaymentViewModel$cashierPay$1(this, payMethod, str, str2, null), 3, null);
    }

    public final void l(BillingParams params) {
        Intrinsics.h(params, "params");
        E(params);
    }

    public final String m() {
        String mobileCode;
        String areaCode;
        LoadConfigContent loadConfigContent = (LoadConfigContent) this.f41752m.f();
        if (loadConfigContent != null && (areaCode = loadConfigContent.getAreaCode()) != null) {
            return areaCode;
        }
        CurrencyInfoBean n11 = TranPayConfiguration.f41544a.n();
        return (n11 == null || (mobileCode = n11.getMobileCode()) == null) ? "" : mobileCode;
    }

    public final boolean n() {
        return this.f41746g;
    }

    public final d o() {
        return this.f41750k;
    }

    public final String p() {
        return this.f41745f;
    }

    public final b0 q() {
        return this.f41752m;
    }

    public final b0 s() {
        return this.f41753n;
    }

    public final boolean t() {
        return this.f41749j;
    }

    public final boolean u() {
        return this.f41748i;
    }

    public final b0 w() {
        return this.f41755p;
    }

    public final String x() {
        return this.f41747h;
    }

    public final String y() {
        return this.f41744e;
    }

    public final b0 z() {
        return this.f41754o;
    }
}
