package com.transsion.payment.lib;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class PaymentService {

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f47829a = LazyKt.b(new Function0() { // from class: com.transsion.payment.lib.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            a f11;
            f11 = PaymentService.f();
            return f11;
        }
    });

    private final String b() {
        String simpleName = PaymentService.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final a c() {
        return (a) this.f47829a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a f() {
        return (a) zg.c.f79537e.a().h(a.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(kotlin.coroutines.Continuation r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.transsion.payment.lib.PaymentService$getSkuList$1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsion.payment.lib.PaymentService$getSkuList$1 r0 = (com.transsion.payment.lib.PaymentService$getSkuList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.payment.lib.PaymentService$getSkuList$1 r0 = new com.transsion.payment.lib.PaymentService$getSkuList$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L29
            goto L4b
        L29:
            r8 = move-exception
            goto L4c
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L33:
            kotlin.ResultKt.b(r8)
            kotlin.Result$Companion r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L29
            com.transsion.payment.lib.a r8 = r7.c()     // Catch: java.lang.Throwable -> L29
            vg.a$a r2 = vg.a.f77447a     // Catch: java.lang.Throwable -> L29
            java.lang.String r2 = r2.a()     // Catch: java.lang.Throwable -> L29
            r0.label = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r8 = r8.e(r2, r0)     // Catch: java.lang.Throwable -> L29
            if (r8 != r1) goto L4b
            return r1
        L4b:
            return r8
        L4c:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.ResultKt.a(r8)
            java.lang.Object r8 = kotlin.Result.m1185constructorimpl(r8)
            java.lang.Throwable r8 = kotlin.Result.m1188exceptionOrNullimpl(r8)
            if (r8 == 0) goto Lcb
            boolean r0 = r8 instanceof retrofit2.HttpException
            r1 = 0
            if (r0 == 0) goto La9
            com.transsion.payment.lib.d r0 = com.transsion.payment.lib.d.f47833a
            java.lang.String r2 = r7.b()
            r3 = r8
            retrofit2.HttpException r3 = (retrofit2.HttpException) r3
            int r4 = r3.code()
            java.lang.String r5 = r3.message()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            java.lang.String r2 = " --> getSkuList() --> code = "
            r6.append(r2)
            r6.append(r4)
            java.lang.String r2 = " -- message = "
            r6.append(r2)
            r6.append(r5)
            java.lang.String r2 = r6.toString()
            r0.b(r2)
            com.tn.lib.net.bean.BaseDto r0 = new com.tn.lib.net.bean.BaseDto
            java.lang.String r8 = r8.getMessage()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r2 = r3.code()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = ""
            r0.<init>(r8, r2, r1, r3)
            return r0
        La9:
            com.transsion.payment.lib.d r0 = com.transsion.payment.lib.d.f47833a
            java.lang.String r2 = r7.b()
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = " --> getSkuList() --> error = "
            r3.append(r2)
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            r0.b(r8)
            return r1
        Lcb:
            kotlin.KotlinNothingValueException r8 = new kotlin.KotlinNothingValueException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.payment.lib.PaymentService.d(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.transsion.payment.lib.PaymentService$orderCheck4Paynicorn$1
            if (r0 == 0) goto L13
            r0 = r7
            com.transsion.payment.lib.PaymentService$orderCheck4Paynicorn$1 r0 = (com.transsion.payment.lib.PaymentService$orderCheck4Paynicorn$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.payment.lib.PaymentService$orderCheck4Paynicorn$1 r0 = new com.transsion.payment.lib.PaymentService$orderCheck4Paynicorn$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L29
            goto L6c
        L29:
            r6 = move-exception
            goto L6f
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.ResultKt.b(r7)
            kotlin.Result$Companion r7 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L29
            com.google.gson.JsonObject r7 = new com.google.gson.JsonObject     // Catch: java.lang.Throwable -> L29
            r7.<init>()     // Catch: java.lang.Throwable -> L29
            java.lang.String r2 = "tradingOrderId"
            r7.addProperty(r2, r6)     // Catch: java.lang.Throwable -> L29
            okhttp3.RequestBody$Companion r6 = okhttp3.RequestBody.INSTANCE     // Catch: java.lang.Throwable -> L29
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L29
            java.lang.String r2 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.g(r7, r2)     // Catch: java.lang.Throwable -> L29
            okhttp3.MediaType$Companion r2 = okhttp3.MediaType.INSTANCE     // Catch: java.lang.Throwable -> L29
            java.lang.String r4 = "application/json"
            okhttp3.MediaType r2 = r2.parse(r4)     // Catch: java.lang.Throwable -> L29
            okhttp3.RequestBody r6 = r6.create(r7, r2)     // Catch: java.lang.Throwable -> L29
            com.transsion.payment.lib.a r7 = r5.c()     // Catch: java.lang.Throwable -> L29
            vg.a$a r2 = vg.a.f77447a     // Catch: java.lang.Throwable -> L29
            java.lang.String r2 = r2.a()     // Catch: java.lang.Throwable -> L29
            r0.label = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r7 = r7.a(r2, r6, r0)     // Catch: java.lang.Throwable -> L29
            if (r7 != r1) goto L6c
            return r1
        L6c:
            com.tn.lib.net.bean.BaseDto r7 = (com.tn.lib.net.bean.BaseDto) r7     // Catch: java.lang.Throwable -> L29
            return r7
        L6f:
            kotlin.Result$Companion r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.ResultKt.a(r6)
            java.lang.Object r6 = kotlin.Result.m1185constructorimpl(r6)
            java.lang.Throwable r6 = kotlin.Result.m1188exceptionOrNullimpl(r6)
            if (r6 == 0) goto Lce
            boolean r7 = r6 instanceof retrofit2.HttpException
            r0 = 0
            if (r7 == 0) goto Lb0
            com.transsion.payment.lib.bean.HttpErrorBodyBean$a r7 = com.transsion.payment.lib.bean.HttpErrorBodyBean.INSTANCE
            retrofit2.HttpException r6 = (retrofit2.HttpException) r6
            com.transsion.payment.lib.bean.HttpErrorBodyBean r6 = r7.a(r6)
            com.tn.lib.net.bean.BaseDto r7 = new com.tn.lib.net.bean.BaseDto
            java.lang.String r1 = ""
            if (r6 == 0) goto L98
            java.lang.String r2 = r6.getMessage()
            if (r2 != 0) goto L99
        L98:
            r2 = r1
        L99:
            if (r6 == 0) goto La1
            java.lang.String r3 = r6.getCode()
            if (r3 != 0) goto La2
        La1:
            r3 = r1
        La2:
            if (r6 == 0) goto Lac
            java.lang.String r6 = r6.getReason()
            if (r6 != 0) goto Lab
            goto Lac
        Lab:
            r1 = r6
        Lac:
            r7.<init>(r2, r3, r0, r1)
            return r7
        Lb0:
            com.transsion.payment.lib.d r7 = com.transsion.payment.lib.d.f47833a
            java.lang.String r1 = r5.b()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = " --> orderCheck4Paynicorn() --> it = "
            r2.append(r1)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            r7.b(r6)
            return r0
        Lce:
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.payment.lib.PaymentService.e(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, kotlin.coroutines.Continuation r9) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.payment.lib.PaymentService.g(java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(java.lang.String r5, java.lang.String r6, java.util.Map r7, kotlin.coroutines.Continuation r8) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.payment.lib.PaymentService.h(java.lang.String, java.lang.String, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.lang.String r6, java.lang.Double r7, java.lang.String r8, java.util.Map r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.payment.lib.PaymentService.i(java.lang.String, java.lang.Double, java.lang.String, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
