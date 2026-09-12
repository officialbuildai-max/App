package com.transsion.ad.monopoly.intercept;

/* loaded from: classes5.dex */
public final class ValidTimesHandler extends a {
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.transsion.ad.monopoly.intercept.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.lang.String r6, com.transsion.ad.db.plan.MbAdDbPlans r7, java.util.Map r8, kotlin.coroutines.Continuation r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.transsion.ad.monopoly.intercept.ValidTimesHandler$doHandle$1
            if (r0 == 0) goto L13
            r0 = r9
            com.transsion.ad.monopoly.intercept.ValidTimesHandler$doHandle$1 r0 = (com.transsion.ad.monopoly.intercept.ValidTimesHandler$doHandle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.monopoly.intercept.ValidTimesHandler$doHandle$1 r0 = new com.transsion.ad.monopoly.intercept.ValidTimesHandler$doHandle$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r9)
            goto L5a
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.ResultKt.b(r9)
            r9 = 0
            if (r7 == 0) goto L42
            java.lang.Integer r2 = r7.getDisplayTimes()
            if (r2 == 0) goto L42
            int r2 = r2.intValue()
            goto L43
        L42:
            r2 = r9
        L43:
            com.transsion.ad.monopoly.intercept.NonAdShowedTimesManager r4 = com.transsion.ad.monopoly.intercept.NonAdShowedTimesManager.f42188a
            int r4 = r4.b(r7)
            if (r4 >= r2) goto L63
            com.transsion.ad.monopoly.intercept.a r9 = r5.c()
            if (r9 == 0) goto L5e
            r0.label = r3
            java.lang.Object r9 = r9.b(r6, r7, r8, r0)
            if (r9 != r1) goto L5a
            return r1
        L5a:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r9 = (com.transsion.ad.monopoly.model.AdPlansHitResponse) r9
            if (r9 != 0) goto L6b
        L5e:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r9 = r5.e()
            goto L6b
        L63:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r6 = new com.transsion.ad.monopoly.model.AdPlansHitResponse
            java.lang.String r7 = "展示次数已经达到上限"
            r6.<init>(r9, r7)
            r9 = r6
        L6b:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.intercept.ValidTimesHandler.b(java.lang.String, com.transsion.ad.db.plan.MbAdDbPlans, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
