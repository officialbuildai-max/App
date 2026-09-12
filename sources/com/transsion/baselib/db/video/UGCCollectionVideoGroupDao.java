package com.transsion.baselib.db.video;

import java.util.List;
import kotlin.coroutines.Continuation;

/* loaded from: classes5.dex */
public interface UGCCollectionVideoGroupDao {

    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.Object a(com.transsion.baselib.db.video.UGCCollectionVideoGroupDao r8, java.lang.String r9, java.util.List r10, kotlin.coroutines.Continuation r11) {
            /*
                Method dump skipped, instructions count: 231
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.baselib.db.video.UGCCollectionVideoGroupDao.DefaultImpls.a(com.transsion.baselib.db.video.UGCCollectionVideoGroupDao, java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0049 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.Object b(com.transsion.baselib.db.video.UGCCollectionVideoGroupDao r4, java.lang.String r5, kotlin.coroutines.Continuation r6) {
            /*
                boolean r0 = r6 instanceof com.transsion.baselib.db.video.UGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1
                if (r0 == 0) goto L13
                r0 = r6
                com.transsion.baselib.db.video.UGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1 r0 = (com.transsion.baselib.db.video.UGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.transsion.baselib.db.video.UGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1 r0 = new com.transsion.baselib.db.video.UGCCollectionVideoGroupDao$getCollectionIdByUgcVideoId$1
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L36
                if (r2 != r3) goto L2e
                java.lang.Object r4 = r0.L$0
                r5 = r4
                java.lang.String r5 = (java.lang.String) r5
                kotlin.ResultKt.b(r6)
                goto L44
            L2e:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L36:
                kotlin.ResultKt.b(r6)
                r0.L$0 = r5
                r0.label = r3
                java.lang.Object r6 = r4.e(r0)
                if (r6 != r1) goto L44
                return r1
            L44:
                java.util.List r6 = (java.util.List) r6
                r4 = 0
                if (r6 != 0) goto L4a
                return r4
            L4a:
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                java.util.Iterator r6 = r6.iterator()
            L50:
                boolean r0 = r6.hasNext()
                if (r0 == 0) goto L68
                java.lang.Object r0 = r6.next()
                r1 = r0
                com.transsion.baselib.db.video.UGCCollectionVideoGroup r1 = (com.transsion.baselib.db.video.UGCCollectionVideoGroup) r1
                java.util.ArrayList r1 = r1.getUgcVideoIds()
                boolean r1 = r1.contains(r5)
                if (r1 == 0) goto L50
                goto L69
            L68:
                r0 = r4
            L69:
                com.transsion.baselib.db.video.UGCCollectionVideoGroup r0 = (com.transsion.baselib.db.video.UGCCollectionVideoGroup) r0
                if (r0 == 0) goto L71
                java.lang.String r4 = r0.getCollectionId()
            L71:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.baselib.db.video.UGCCollectionVideoGroupDao.DefaultImpls.b(com.transsion.baselib.db.video.UGCCollectionVideoGroupDao, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    Object a(String str, List list, Continuation continuation);

    Object b(UGCCollectionVideoGroup uGCCollectionVideoGroup, Continuation continuation);

    Object c(String str, Continuation continuation);

    Object d(String str, Continuation continuation);

    Object e(Continuation continuation);
}
