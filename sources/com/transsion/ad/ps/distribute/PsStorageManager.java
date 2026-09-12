package com.transsion.ad.ps.distribute;

/* loaded from: classes5.dex */
public final class PsStorageManager {

    /* renamed from: a, reason: collision with root package name */
    public static final PsStorageManager f42249a = new PsStorageManager();

    private PsStorageManager() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.transsion.ad.ps.distribute.PsStorageManager$deleteInvalidFile$1
            if (r0 == 0) goto L13
            r0 = r6
            com.transsion.ad.ps.distribute.PsStorageManager$deleteInvalidFile$1 r0 = (com.transsion.ad.ps.distribute.PsStorageManager$deleteInvalidFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.ps.distribute.PsStorageManager$deleteInvalidFile$1 r0 = new com.transsion.ad.ps.distribute.PsStorageManager$deleteInvalidFile$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            java.util.HashSet r0 = (java.util.HashSet) r0
            kotlin.ResultKt.b(r6)
            goto L4d
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            kotlin.ResultKt.b(r6)
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>()
            com.transsion.ad.ps.distribute.PsDbManager r2 = com.transsion.ad.ps.distribute.PsDbManager.f42243a
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r0 = r2.d(r0)
            if (r0 != r1) goto L4a
            return r1
        L4a:
            r4 = r0
            r0 = r6
            r6 = r4
        L4d:
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L7e
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L57:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L7e
            java.lang.Object r1 = r6.next()
            com.transsion.ad.db.pslink.PsLinkAdPlan r1 = (com.transsion.ad.db.pslink.PsLinkAdPlan) r1
            java.lang.String r1 = r1.getPsLinkAdInfoStr()
            java.lang.Class<com.transsion.ad.ps.model.PsLinkAdInfo> r2 = com.transsion.ad.ps.model.PsLinkAdInfo.class
            java.lang.Object r1 = com.blankj.utilcode.util.o.d(r1, r2)
            com.transsion.ad.ps.model.PsLinkAdInfo r1 = (com.transsion.ad.ps.model.PsLinkAdInfo) r1
            java.lang.String r2 = r1.getPath()
            r0.add(r2)
            java.lang.String r1 = r1.getAdvertiserAvatarPath()
            r0.add(r1)
            goto L57
        L7e:
            com.transsion.ad.a r6 = com.transsion.ad.a.f41834a
            java.lang.String r6 = r6.a()
            char r1 = java.io.File.separatorChar
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            r2.append(r1)
            java.lang.String r6 = r2.toString()
            ti.h r1 = ti.h.f76382a
            java.io.File r2 = new java.io.File
            r2.<init>(r6)
            r1.c(r2, r0)
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.ps.distribute.PsStorageManager.a(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
