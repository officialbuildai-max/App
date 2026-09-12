package com.transsion.ad.monopoly.intercept;

/* loaded from: classes5.dex */
public final class BrandInWhitelistHandler extends a {
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.transsion.ad.monopoly.intercept.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.lang.String r12, com.transsion.ad.db.plan.MbAdDbPlans r13, java.util.Map r14, kotlin.coroutines.Continuation r15) {
        /*
            r11 = this;
            boolean r0 = r15 instanceof com.transsion.ad.monopoly.intercept.BrandInWhitelistHandler$doHandle$1
            if (r0 == 0) goto L13
            r0 = r15
            com.transsion.ad.monopoly.intercept.BrandInWhitelistHandler$doHandle$1 r0 = (com.transsion.ad.monopoly.intercept.BrandInWhitelistHandler$doHandle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.monopoly.intercept.BrandInWhitelistHandler$doHandle$1 r0 = new com.transsion.ad.monopoly.intercept.BrandInWhitelistHandler$doHandle$1
            r0.<init>(r11, r15)
        L18:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L3a
            if (r2 == r3) goto L35
            if (r2 != r4) goto L2d
            kotlin.ResultKt.b(r15)
            goto Lb5
        L2d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L35:
            kotlin.ResultKt.b(r15)
            goto Ld5
        L3a:
            kotlin.ResultKt.b(r15)
            r15 = 0
            if (r13 == 0) goto L45
            java.util.List r2 = r13.getBrand()
            goto L46
        L45:
            r2 = r15
        L46:
            r5 = r2
            java.util.Collection r5 = (java.util.Collection) r5
            if (r5 == 0) goto Lc6
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L53
            goto Lc6
        L53:
            ih.b r3 = ih.b.f65364a
            java.lang.String r3 = r3.d()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            boolean r5 = r2 instanceof java.util.Collection
            r6 = 0
            if (r5 == 0) goto L6a
            r5 = r2
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L6a
            goto Lbe
        L6a:
            java.util.Iterator r2 = r2.iterator()
        L6e:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto Lbe
            java.lang.Object r5 = r2.next()
            java.lang.String r5 = (java.lang.String) r5
            java.util.Locale r7 = java.util.Locale.ROOT
            java.lang.String r8 = r5.toLowerCase(r7)
            java.lang.String r9 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.g(r8, r9)
            java.lang.String r10 = r3.toLowerCase(r7)
            kotlin.jvm.internal.Intrinsics.g(r10, r9)
            boolean r8 = kotlin.text.StringsKt.c0(r8, r10, r6, r4, r15)
            if (r8 != 0) goto La6
            java.lang.String r8 = r3.toLowerCase(r7)
            kotlin.jvm.internal.Intrinsics.g(r8, r9)
            java.lang.String r5 = r5.toLowerCase(r7)
            kotlin.jvm.internal.Intrinsics.g(r5, r9)
            boolean r5 = kotlin.text.StringsKt.c0(r8, r5, r6, r4, r15)
            if (r5 == 0) goto L6e
        La6:
            com.transsion.ad.monopoly.intercept.a r15 = r11.c()
            if (r15 == 0) goto Lb9
            r0.label = r4
            java.lang.Object r15 = r15.b(r12, r13, r14, r0)
            if (r15 != r1) goto Lb5
            return r1
        Lb5:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r15 = (com.transsion.ad.monopoly.model.AdPlansHitResponse) r15
            if (r15 != 0) goto Lc5
        Lb9:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r15 = r11.e()
            goto Lc5
        Lbe:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r15 = new com.transsion.ad.monopoly.model.AdPlansHitResponse
            java.lang.String r12 = "当前手机品牌不在白名单中"
            r15.<init>(r6, r12)
        Lc5:
            return r15
        Lc6:
            com.transsion.ad.monopoly.intercept.a r15 = r11.c()
            if (r15 == 0) goto Ld9
            r0.label = r3
            java.lang.Object r15 = r15.b(r12, r13, r14, r0)
            if (r15 != r1) goto Ld5
            return r1
        Ld5:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r15 = (com.transsion.ad.monopoly.model.AdPlansHitResponse) r15
            if (r15 != 0) goto Ldd
        Ld9:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r15 = r11.e()
        Ldd:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.intercept.BrandInWhitelistHandler.b(java.lang.String, com.transsion.ad.db.plan.MbAdDbPlans, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
