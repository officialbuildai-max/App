package com.transsion.baselib.db.place;

import java.util.List;
import kotlin.coroutines.Continuation;

/* loaded from: classes5.dex */
public interface PlaceDao {

    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:19:0x005e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.Object a(com.transsion.baselib.db.place.PlaceDao r5, java.util.List r6, kotlin.coroutines.Continuation r7) {
            /*
                boolean r0 = r7 instanceof com.transsion.baselib.db.place.PlaceDao$insertList$1
                if (r0 == 0) goto L13
                r0 = r7
                com.transsion.baselib.db.place.PlaceDao$insertList$1 r0 = (com.transsion.baselib.db.place.PlaceDao$insertList$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.transsion.baselib.db.place.PlaceDao$insertList$1 r0 = new com.transsion.baselib.db.place.PlaceDao$insertList$1
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L41
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                kotlin.ResultKt.b(r7)
                goto L5f
            L2c:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L34:
                java.lang.Object r5 = r0.L$1
                r6 = r5
                java.util.List r6 = (java.util.List) r6
                java.lang.Object r5 = r0.L$0
                com.transsion.baselib.db.place.PlaceDao r5 = (com.transsion.baselib.db.place.PlaceDao) r5
                kotlin.ResultKt.b(r7)
                goto L51
            L41:
                kotlin.ResultKt.b(r7)
                r0.L$0 = r5
                r0.L$1 = r6
                r0.label = r4
                java.lang.Object r7 = r5.a(r0)
                if (r7 != r1) goto L51
                return r1
            L51:
                r7 = 0
                r0.L$0 = r7
                r0.L$1 = r7
                r0.label = r3
                java.lang.Object r5 = r5.b(r6, r0)
                if (r5 != r1) goto L5f
                return r1
            L5f:
                kotlin.Unit r5 = kotlin.Unit.f67184a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.baselib.db.place.PlaceDao.DefaultImpls.a(com.transsion.baselib.db.place.PlaceDao, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    Object a(Continuation continuation);

    Object b(List list, Continuation continuation);

    Object c(List list, Continuation continuation);

    Object d(Continuation continuation);
}
