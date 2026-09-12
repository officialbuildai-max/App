package com.transsion.ad.monopoly.intercept;

/* loaded from: classes5.dex */
public final class ValidTimeHandler extends a {
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.transsion.ad.monopoly.intercept.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.lang.String r11, com.transsion.ad.db.plan.MbAdDbPlans r12, java.util.Map r13, kotlin.coroutines.Continuation r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.transsion.ad.monopoly.intercept.ValidTimeHandler$doHandle$1
            if (r0 == 0) goto L13
            r0 = r14
            com.transsion.ad.monopoly.intercept.ValidTimeHandler$doHandle$1 r0 = (com.transsion.ad.monopoly.intercept.ValidTimeHandler$doHandle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.monopoly.intercept.ValidTimeHandler$doHandle$1 r0 = new com.transsion.ad.monopoly.intercept.ValidTimeHandler$doHandle$1
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r14)
            goto L6d
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            kotlin.ResultKt.b(r14)
            ti.p r14 = ti.p.f76389a
            long r4 = r14.d()
            r6 = 0
            if (r12 == 0) goto L49
            java.lang.String r14 = r12.getStartTime()
            if (r14 == 0) goto L49
            long r8 = java.lang.Long.parseLong(r14)
            goto L4a
        L49:
            r8 = r6
        L4a:
            if (r12 == 0) goto L56
            java.lang.String r14 = r12.getEndTime()
            if (r14 == 0) goto L56
            long r6 = java.lang.Long.parseLong(r14)
        L56:
            int r14 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r14 > 0) goto L76
            int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r14 > 0) goto L76
            com.transsion.ad.monopoly.intercept.a r14 = r10.c()
            if (r14 == 0) goto L71
            r0.label = r3
            java.lang.Object r14 = r14.b(r11, r12, r13, r0)
            if (r14 != r1) goto L6d
            return r1
        L6d:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r14 = (com.transsion.ad.monopoly.model.AdPlansHitResponse) r14
            if (r14 != 0) goto L7e
        L71:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r14 = r10.e()
            goto L7e
        L76:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r14 = new com.transsion.ad.monopoly.model.AdPlansHitResponse
            r11 = 0
            java.lang.String r12 = "当前不在展示时间内--有效期"
            r14.<init>(r11, r12)
        L7e:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.intercept.ValidTimeHandler.b(java.lang.String, com.transsion.ad.db.plan.MbAdDbPlans, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
