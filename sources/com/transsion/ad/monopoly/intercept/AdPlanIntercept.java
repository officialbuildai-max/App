package com.transsion.ad.monopoly.intercept;

import com.transsion.ad.monopoly.intercept.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes5.dex */
public final class AdPlanIntercept {

    /* renamed from: a, reason: collision with root package name */
    public static final AdPlanIntercept f42180a = new AdPlanIntercept();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f42181b = LazyKt.b(new Function0() { // from class: com.transsion.ad.monopoly.intercept.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            a c11;
            c11 = AdPlanIntercept.c();
            return c11;
        }
    });

    private AdPlanIntercept() {
    }

    private final a b() {
        return (a) f42181b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a c() {
        a b11 = new a.C0597a().a(new ShowOnNetworkStateHandler()).a(new SceneInWhitelistHandler()).a(new CountryInWhitelistHandler()).a(new InDenyBrandHandler()).a(new BrandInWhitelistHandler()).a(new InDenyModelHandler()).a(new ModelInWhitelistHandler()).a(new ValidTimeHandler()).a(new ValidDispatchTimeHandler()).a(new ValidTimesHandler()).a(new g()).a(new f()).a(new AdResourceDownloadedHandler()).b();
        if (b11 != null) {
            return b11;
        }
        throw new IllegalStateException("AdPlanIntercept: handler chain build failed");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(1:10)(2:19|20))(3:21|22|(1:24))|11|12|(1:17)(2:14|15)))|27|6|7|(0)(0)|11|12|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0029, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:
    
        r6 = kotlin.Result.INSTANCE;
        r5 = kotlin.Result.m1185constructorimpl(kotlin.ResultKt.a(r5));
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.lang.String r5, com.transsion.ad.db.plan.MbAdDbPlans r6, java.util.Map r7, kotlin.coroutines.Continuation r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.transsion.ad.monopoly.intercept.AdPlanIntercept$isHit$1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsion.ad.monopoly.intercept.AdPlanIntercept$isHit$1 r0 = (com.transsion.ad.monopoly.intercept.AdPlanIntercept$isHit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.monopoly.intercept.AdPlanIntercept$isHit$1 r0 = new com.transsion.ad.monopoly.intercept.AdPlanIntercept$isHit$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L29
            goto L45
        L29:
            r5 = move-exception
            goto L4c
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.b(r8)
            kotlin.Result$Companion r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L29
            com.transsion.ad.monopoly.intercept.a r8 = r4.b()     // Catch: java.lang.Throwable -> L29
            r0.label = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r8 = r8.b(r5, r6, r7, r0)     // Catch: java.lang.Throwable -> L29
            if (r8 != r1) goto L45
            return r1
        L45:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r8 = (com.transsion.ad.monopoly.model.AdPlansHitResponse) r8     // Catch: java.lang.Throwable -> L29
            java.lang.Object r5 = kotlin.Result.m1185constructorimpl(r8)     // Catch: java.lang.Throwable -> L29
            goto L56
        L4c:
            kotlin.Result$Companion r6 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.ResultKt.a(r5)
            java.lang.Object r5 = kotlin.Result.m1185constructorimpl(r5)
        L56:
            java.lang.Throwable r6 = kotlin.Result.m1188exceptionOrNullimpl(r5)
            if (r6 != 0) goto L5d
            goto L67
        L5d:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r5 = new com.transsion.ad.monopoly.model.AdPlansHitResponse
            r7 = 0
            java.lang.String r6 = r6.getMessage()
            r5.<init>(r7, r6)
        L67:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.intercept.AdPlanIntercept.d(java.lang.String, com.transsion.ad.db.plan.MbAdDbPlans, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
