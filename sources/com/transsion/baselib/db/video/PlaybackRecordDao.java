package com.transsion.baselib.db.video;

import kotlin.coroutines.Continuation;

/* loaded from: classes5.dex */
public interface PlaybackRecordDao {

    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.Object a(com.transsion.baselib.db.video.PlaybackRecordDao r7, com.transsion.baselib.db.video.PlaybackRecordTable r8, kotlin.coroutines.Continuation r9) {
            /*
                boolean r0 = r9 instanceof com.transsion.baselib.db.video.PlaybackRecordDao$insertOrUpdate$1
                if (r0 == 0) goto L13
                r0 = r9
                com.transsion.baselib.db.video.PlaybackRecordDao$insertOrUpdate$1 r0 = (com.transsion.baselib.db.video.PlaybackRecordDao$insertOrUpdate$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.transsion.baselib.db.video.PlaybackRecordDao$insertOrUpdate$1 r0 = new com.transsion.baselib.db.video.PlaybackRecordDao$insertOrUpdate$1
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.label
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L48
                if (r2 == r5) goto L3b
                if (r2 == r4) goto L37
                if (r2 != r3) goto L2f
                kotlin.ResultKt.b(r9)
                goto L84
            L2f:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L37:
                kotlin.ResultKt.b(r9)
                goto L74
            L3b:
                java.lang.Object r7 = r0.L$1
                r8 = r7
                com.transsion.baselib.db.video.PlaybackRecordTable r8 = (com.transsion.baselib.db.video.PlaybackRecordTable) r8
                java.lang.Object r7 = r0.L$0
                com.transsion.baselib.db.video.PlaybackRecordDao r7 = (com.transsion.baselib.db.video.PlaybackRecordDao) r7
                kotlin.ResultKt.b(r9)
                goto L64
            L48:
                kotlin.ResultKt.b(r9)
                java.lang.String r9 = r8.getSubjectId()
                int r2 = r8.getSe()
                int r6 = r8.getEp()
                r0.L$0 = r7
                r0.L$1 = r8
                r0.label = r5
                java.lang.Object r9 = r7.a(r9, r2, r6, r0)
                if (r9 != r1) goto L64
                return r1
            L64:
                r2 = 0
                if (r9 != 0) goto L77
                r0.L$0 = r2
                r0.L$1 = r2
                r0.label = r4
                java.lang.Object r7 = r7.c(r8, r0)
                if (r7 != r1) goto L74
                return r1
            L74:
                kotlin.Unit r7 = kotlin.Unit.f67184a
                return r7
            L77:
                r0.L$0 = r2
                r0.L$1 = r2
                r0.label = r3
                java.lang.Object r7 = r7.d(r8, r0)
                if (r7 != r1) goto L84
                return r1
            L84:
                kotlin.Unit r7 = kotlin.Unit.f67184a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.baselib.db.video.PlaybackRecordDao.DefaultImpls.a(com.transsion.baselib.db.video.PlaybackRecordDao, com.transsion.baselib.db.video.PlaybackRecordTable, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    Object a(String str, int i11, int i12, Continuation continuation);

    Object b(PlaybackRecordTable playbackRecordTable, Continuation continuation);

    Object c(PlaybackRecordTable playbackRecordTable, Continuation continuation);

    Object d(PlaybackRecordTable playbackRecordTable, Continuation continuation);
}
