package com.transsion.ad.monopoly.intercept;

/* loaded from: classes5.dex */
public final class InDenyModelHandler extends a {
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @Override // com.transsion.ad.monopoly.intercept.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.lang.String r16, com.transsion.ad.db.plan.MbAdDbPlans r17, java.util.Map r18, kotlin.coroutines.Continuation r19) {
        /*
            r15 = this;
            r0 = r17
            r1 = r19
            boolean r2 = r1 instanceof com.transsion.ad.monopoly.intercept.InDenyModelHandler$doHandle$1
            if (r2 == 0) goto L18
            r2 = r1
            com.transsion.ad.monopoly.intercept.InDenyModelHandler$doHandle$1 r2 = (com.transsion.ad.monopoly.intercept.InDenyModelHandler$doHandle$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.label = r3
            r3 = r15
            goto L1e
        L18:
            com.transsion.ad.monopoly.intercept.InDenyModelHandler$doHandle$1 r2 = new com.transsion.ad.monopoly.intercept.InDenyModelHandler$doHandle$1
            r3 = r15
            r2.<init>(r15, r1)
        L1e:
            java.lang.Object r1 = r2.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r5 = r2.label
            r6 = 1
            if (r5 == 0) goto L38
            if (r5 != r6) goto L30
            kotlin.ResultKt.b(r1)
            goto Lbf
        L30:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L38:
            kotlin.ResultKt.b(r1)
            r1 = 0
            if (r0 == 0) goto L43
            java.util.List r5 = r17.getDenyModel()
            goto L44
        L43:
            r5 = r1
        L44:
            r7 = r5
            java.util.Collection r7 = (java.util.Collection) r7
            if (r7 == 0) goto Lac
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L50
            goto Lac
        L50:
            ih.b r7 = ih.b.f65364a
            java.lang.String r7 = r7.l()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            boolean r8 = r5 instanceof java.util.Collection
            if (r8 == 0) goto L66
            r8 = r5
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L66
            goto Lac
        L66:
            java.util.Iterator r5 = r5.iterator()
        L6a:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto Lac
            java.lang.Object r8 = r5.next()
            java.lang.String r8 = (java.lang.String) r8
            java.util.Locale r9 = java.util.Locale.ROOT
            java.lang.String r10 = r8.toLowerCase(r9)
            java.lang.String r11 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.g(r10, r11)
            java.lang.String r12 = r7.toLowerCase(r9)
            kotlin.jvm.internal.Intrinsics.g(r12, r11)
            r13 = 0
            r14 = 2
            boolean r10 = kotlin.text.StringsKt.c0(r10, r12, r13, r14, r1)
            if (r10 != 0) goto La4
            java.lang.String r10 = r7.toLowerCase(r9)
            kotlin.jvm.internal.Intrinsics.g(r10, r11)
            java.lang.String r8 = r8.toLowerCase(r9)
            kotlin.jvm.internal.Intrinsics.g(r8, r11)
            boolean r8 = kotlin.text.StringsKt.c0(r10, r8, r13, r14, r1)
            if (r8 == 0) goto L6a
        La4:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r0 = new com.transsion.ad.monopoly.model.AdPlansHitResponse
            java.lang.String r1 = "当前手机机型在黑名单中"
            r0.<init>(r13, r1)
            goto Lc8
        Lac:
            com.transsion.ad.monopoly.intercept.a r1 = r15.c()
            if (r1 == 0) goto Lc4
            r2.label = r6
            r5 = r16
            r6 = r18
            java.lang.Object r1 = r1.b(r5, r0, r6, r2)
            if (r1 != r4) goto Lbf
            return r4
        Lbf:
            r0 = r1
            com.transsion.ad.monopoly.model.AdPlansHitResponse r0 = (com.transsion.ad.monopoly.model.AdPlansHitResponse) r0
            if (r0 != 0) goto Lc8
        Lc4:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r0 = r15.e()
        Lc8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.intercept.InDenyModelHandler.b(java.lang.String, com.transsion.ad.db.plan.MbAdDbPlans, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
