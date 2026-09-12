package com.transsion.ad.monopoly.intercept;

/* loaded from: classes5.dex */
public final class SceneInWhitelistHandler extends a {
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.transsion.ad.monopoly.intercept.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.lang.String r7, com.transsion.ad.db.plan.MbAdDbPlans r8, java.util.Map r9, kotlin.coroutines.Continuation r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.transsion.ad.monopoly.intercept.SceneInWhitelistHandler$doHandle$1
            if (r0 == 0) goto L13
            r0 = r10
            com.transsion.ad.monopoly.intercept.SceneInWhitelistHandler$doHandle$1 r0 = (com.transsion.ad.monopoly.intercept.SceneInWhitelistHandler$doHandle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.monopoly.intercept.SceneInWhitelistHandler$doHandle$1 r0 = new com.transsion.ad.monopoly.intercept.SceneInWhitelistHandler$doHandle$1
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.b(r10)
            goto L9a
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            kotlin.ResultKt.b(r10)
            if (r8 == 0) goto L3c
            java.util.List r10 = r8.getScenes()
            goto L3d
        L3c:
            r10 = 0
        L3d:
            r2 = r10
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L8b
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L49
            goto L8b
        L49:
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            boolean r2 = r10 instanceof java.util.Collection
            if (r2 == 0) goto L59
            r2 = r10
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L59
            goto L82
        L59:
            java.util.Iterator r10 = r10.iterator()
        L5d:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L82
            java.lang.Object r2 = r10.next()
            java.lang.String r2 = (java.lang.String) r2
            java.util.Locale r4 = java.util.Locale.ROOT
            java.lang.String r2 = r2.toLowerCase(r4)
            java.lang.String r5 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.g(r2, r5)
            java.lang.String r4 = r7.toLowerCase(r4)
            kotlin.jvm.internal.Intrinsics.g(r4, r5)
            boolean r2 = android.text.TextUtils.equals(r2, r4)
            if (r2 == 0) goto L5d
            goto L8b
        L82:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r7 = new com.transsion.ad.monopoly.model.AdPlansHitResponse
            r8 = 0
            java.lang.String r9 = "当前场景不在白名单中"
            r7.<init>(r8, r9)
            goto La3
        L8b:
            com.transsion.ad.monopoly.intercept.a r10 = r6.c()
            if (r10 == 0) goto L9f
            r0.label = r3
            java.lang.Object r10 = r10.b(r7, r8, r9, r0)
            if (r10 != r1) goto L9a
            return r1
        L9a:
            r7 = r10
            com.transsion.ad.monopoly.model.AdPlansHitResponse r7 = (com.transsion.ad.monopoly.model.AdPlansHitResponse) r7
            if (r7 != 0) goto La3
        L9f:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r7 = r6.e()
        La3:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.intercept.SceneInWhitelistHandler.b(java.lang.String, com.transsion.ad.db.plan.MbAdDbPlans, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
