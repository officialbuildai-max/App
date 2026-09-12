package com.transsion.ad.monopoly.intercept;

/* loaded from: classes5.dex */
public final class CountryInWhitelistHandler extends a {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0077 -> B:10:0x0037). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(java.util.List r8, java.lang.String r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.intercept.CountryInWhitelistHandler.h(java.util.List, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.transsion.ad.monopoly.intercept.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.lang.String r7, com.transsion.ad.db.plan.MbAdDbPlans r8, java.util.Map r9, kotlin.coroutines.Continuation r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.transsion.ad.monopoly.intercept.CountryInWhitelistHandler$doHandle$1
            if (r0 == 0) goto L13
            r0 = r10
            com.transsion.ad.monopoly.intercept.CountryInWhitelistHandler$doHandle$1 r0 = (com.transsion.ad.monopoly.intercept.CountryInWhitelistHandler$doHandle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.monopoly.intercept.CountryInWhitelistHandler$doHandle$1 r0 = new com.transsion.ad.monopoly.intercept.CountryInWhitelistHandler$doHandle$1
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L47
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.b(r10)
            goto L8e
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            java.lang.Object r7 = r0.L$2
            r9 = r7
            java.util.Map r9 = (java.util.Map) r9
            java.lang.Object r7 = r0.L$1
            r8 = r7
            com.transsion.ad.db.plan.MbAdDbPlans r8 = (com.transsion.ad.db.plan.MbAdDbPlans) r8
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.b(r10)
            goto L71
        L47:
            kotlin.ResultKt.b(r10)
            if (r8 == 0) goto L51
            java.util.List r10 = r8.getCountry()
            goto L52
        L51:
            r10 = r5
        L52:
            r2 = r10
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L77
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L5e
            goto L77
        L5e:
            java.lang.String r2 = r8.getCountryCode()
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r9
            r0.label = r4
            java.lang.Object r10 = r6.h(r10, r2, r0)
            if (r10 != r1) goto L71
            return r1
        L71:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r4 = r10.booleanValue()
        L77:
            if (r4 == 0) goto L97
            com.transsion.ad.monopoly.intercept.a r10 = r6.c()
            if (r10 == 0) goto L92
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r10 = r10.b(r7, r8, r9, r0)
            if (r10 != r1) goto L8e
            return r1
        L8e:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r10 = (com.transsion.ad.monopoly.model.AdPlansHitResponse) r10
            if (r10 != 0) goto L9f
        L92:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r10 = r6.e()
            goto L9f
        L97:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r10 = new com.transsion.ad.monopoly.model.AdPlansHitResponse
            r7 = 0
            java.lang.String r8 = "当前国家不在白名单中"
            r10.<init>(r7, r8)
        L9f:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.intercept.CountryInWhitelistHandler.b(java.lang.String, com.transsion.ad.db.plan.MbAdDbPlans, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
