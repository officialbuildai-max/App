package com.transsion.shorttv.db;

import kotlin.coroutines.Continuation;

/* loaded from: classes6.dex */
public interface ShortTvAdUnlockDao {

    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.Object a(com.transsion.shorttv.db.ShortTvAdUnlockDao r6, com.transsion.shorttv.db.e r7, kotlin.coroutines.Continuation r8) {
            /*
                boolean r0 = r8 instanceof com.transsion.shorttv.db.ShortTvAdUnlockDao$insertOrUpdate$1
                if (r0 == 0) goto L13
                r0 = r8
                com.transsion.shorttv.db.ShortTvAdUnlockDao$insertOrUpdate$1 r0 = (com.transsion.shorttv.db.ShortTvAdUnlockDao$insertOrUpdate$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.transsion.shorttv.db.ShortTvAdUnlockDao$insertOrUpdate$1 r0 = new com.transsion.shorttv.db.ShortTvAdUnlockDao$insertOrUpdate$1
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.label
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L48
                if (r2 == r5) goto L3b
                if (r2 == r4) goto L37
                if (r2 != r3) goto L2f
                kotlin.ResultKt.b(r8)
                goto L7c
            L2f:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L37:
                kotlin.ResultKt.b(r8)
                goto L6c
            L3b:
                java.lang.Object r6 = r0.L$1
                r7 = r6
                com.transsion.shorttv.db.e r7 = (com.transsion.shorttv.db.e) r7
                java.lang.Object r6 = r0.L$0
                com.transsion.shorttv.db.ShortTvAdUnlockDao r6 = (com.transsion.shorttv.db.ShortTvAdUnlockDao) r6
                kotlin.ResultKt.b(r8)
                goto L5c
            L48:
                kotlin.ResultKt.b(r8)
                java.lang.String r8 = r7.a()
                r0.L$0 = r6
                r0.L$1 = r7
                r0.label = r5
                java.lang.Object r8 = r6.a(r8, r0)
                if (r8 != r1) goto L5c
                return r1
            L5c:
                r2 = 0
                if (r8 != 0) goto L6f
                r0.L$0 = r2
                r0.L$1 = r2
                r0.label = r4
                java.lang.Object r6 = r6.d(r7, r0)
                if (r6 != r1) goto L6c
                return r1
            L6c:
                kotlin.Unit r6 = kotlin.Unit.f67184a
                return r6
            L6f:
                r0.L$0 = r2
                r0.L$1 = r2
                r0.label = r3
                java.lang.Object r6 = r6.c(r7, r0)
                if (r6 != r1) goto L7c
                return r1
            L7c:
                kotlin.Unit r6 = kotlin.Unit.f67184a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.db.ShortTvAdUnlockDao.DefaultImpls.a(com.transsion.shorttv.db.ShortTvAdUnlockDao, com.transsion.shorttv.db.e, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    Object a(String str, Continuation continuation);

    Object b(e eVar, Continuation continuation);

    Object c(e eVar, Continuation continuation);

    Object d(e eVar, Continuation continuation);
}
