package com.transsion.baselib.db.video;

import kotlin.coroutines.Continuation;

/* loaded from: classes5.dex */
public interface UGCVideoDetailPlayDao {

    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:13:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.Object a(com.transsion.baselib.db.video.UGCVideoDetailPlayDao r6, java.lang.String r7, kotlin.coroutines.Continuation r8) {
            /*
                boolean r0 = r8 instanceof com.transsion.baselib.db.video.UGCVideoDetailPlayDao$getDataByUGCVideoId$1
                if (r0 == 0) goto L13
                r0 = r8
                com.transsion.baselib.db.video.UGCVideoDetailPlayDao$getDataByUGCVideoId$1 r0 = (com.transsion.baselib.db.video.UGCVideoDetailPlayDao$getDataByUGCVideoId$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.transsion.baselib.db.video.UGCVideoDetailPlayDao$getDataByUGCVideoId$1 r0 = new com.transsion.baselib.db.video.UGCVideoDetailPlayDao$getDataByUGCVideoId$1
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L42
                if (r2 == r4) goto L35
                if (r2 != r3) goto L2d
                kotlin.ResultKt.b(r8)
                goto L79
            L2d:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L35:
                java.lang.Object r6 = r0.L$1
                r7 = r6
                java.lang.String r7 = (java.lang.String) r7
                java.lang.Object r6 = r0.L$0
                com.transsion.baselib.db.video.UGCVideoDetailPlayDao r6 = (com.transsion.baselib.db.video.UGCVideoDetailPlayDao) r6
                kotlin.ResultKt.b(r8)
                goto L63
            L42:
                kotlin.ResultKt.b(r8)
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r2 = "SINGLE_"
                r8.append(r2)
                r8.append(r7)
                java.lang.String r8 = r8.toString()
                r0.L$0 = r6
                r0.L$1 = r7
                r0.label = r4
                java.lang.Object r8 = r6.g(r8, r0)
                if (r8 != r1) goto L63
                return r1
            L63:
                com.transsion.baselib.db.video.UGCVideoDetailPlayBean r8 = (com.transsion.baselib.db.video.UGCVideoDetailPlayBean) r8
                if (r8 == 0) goto L6c
                com.transsion.baselib.db.video.UGCVideoDetailPlayBean r6 = r8.toBusinessBean()
                return r6
            L6c:
                r0.L$0 = r5
                r0.L$1 = r5
                r0.label = r3
                java.lang.Object r8 = r6.m(r7, r0)
                if (r8 != r1) goto L79
                return r1
            L79:
                com.transsion.baselib.db.video.UGCVideoDetailPlayBean r8 = (com.transsion.baselib.db.video.UGCVideoDetailPlayBean) r8
                if (r8 == 0) goto L81
                com.transsion.baselib.db.video.UGCVideoDetailPlayBean r5 = r8.toBusinessBean()
            L81:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.baselib.db.video.UGCVideoDetailPlayDao.DefaultImpls.a(com.transsion.baselib.db.video.UGCVideoDetailPlayDao, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0021. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x011b  */
        /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00e0  */
        /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00a7  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.Object b(com.transsion.baselib.db.video.UGCVideoDetailPlayDao r6, java.lang.String r7, kotlin.coroutines.Continuation r8) {
            /*
                Method dump skipped, instructions count: 306
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.baselib.db.video.UGCVideoDetailPlayDao.DefaultImpls.b(com.transsion.baselib.db.video.UGCVideoDetailPlayDao, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00cb  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0101 A[LOOP:0: B:20:0x00fb->B:22:0x0101, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00bb A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00bc  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0098 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.Object c(com.transsion.baselib.db.video.UGCVideoDetailPlayDao r8, int r9, int r10, kotlin.coroutines.Continuation r11) {
            /*
                Method dump skipped, instructions count: 272
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.baselib.db.video.UGCVideoDetailPlayDao.DefaultImpls.c(com.transsion.baselib.db.video.UGCVideoDetailPlayDao, int, int, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.Object d(com.transsion.baselib.db.video.UGCVideoDetailPlayDao r6, com.transsion.baselib.db.video.UGCVideoDetailPlayBean r7, kotlin.coroutines.Continuation r8) {
            /*
                boolean r0 = r8 instanceof com.transsion.baselib.db.video.UGCVideoDetailPlayDao$insertOrUpdate$1
                if (r0 == 0) goto L13
                r0 = r8
                com.transsion.baselib.db.video.UGCVideoDetailPlayDao$insertOrUpdate$1 r0 = (com.transsion.baselib.db.video.UGCVideoDetailPlayDao$insertOrUpdate$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.transsion.baselib.db.video.UGCVideoDetailPlayDao$insertOrUpdate$1 r0 = new com.transsion.baselib.db.video.UGCVideoDetailPlayDao$insertOrUpdate$1
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
                goto L80
            L2f:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L37:
                kotlin.ResultKt.b(r8)
                goto L70
            L3b:
                java.lang.Object r6 = r0.L$1
                r7 = r6
                com.transsion.baselib.db.video.UGCVideoDetailPlayBean r7 = (com.transsion.baselib.db.video.UGCVideoDetailPlayBean) r7
                java.lang.Object r6 = r0.L$0
                com.transsion.baselib.db.video.UGCVideoDetailPlayDao r6 = (com.transsion.baselib.db.video.UGCVideoDetailPlayDao) r6
                kotlin.ResultKt.b(r8)
                goto L60
            L48:
                kotlin.ResultKt.b(r8)
                java.lang.String r8 = r7.getCollectionId()
                java.lang.String r2 = r7.getUgcVideoId()
                r0.L$0 = r6
                r0.L$1 = r7
                r0.label = r5
                java.lang.Object r8 = r6.s(r8, r2, r0)
                if (r8 != r1) goto L60
                return r1
            L60:
                r2 = 0
                if (r8 != 0) goto L73
                r0.L$0 = r2
                r0.L$1 = r2
                r0.label = r4
                java.lang.Object r6 = r6.p(r7, r0)
                if (r6 != r1) goto L70
                return r1
            L70:
                kotlin.Unit r6 = kotlin.Unit.f67184a
                return r6
            L73:
                r0.L$0 = r2
                r0.L$1 = r2
                r0.label = r3
                java.lang.Object r6 = r6.v(r7, r0)
                if (r6 != r1) goto L80
                return r1
            L80:
                kotlin.Unit r6 = kotlin.Unit.f67184a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.baselib.db.video.UGCVideoDetailPlayDao.DefaultImpls.d(com.transsion.baselib.db.video.UGCVideoDetailPlayDao, com.transsion.baselib.db.video.UGCVideoDetailPlayBean, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x00e1  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0141  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.Object e(com.transsion.baselib.db.video.UGCVideoDetailPlayDao r59, java.lang.String r60, java.lang.String r61, long r62, long r64, kotlin.coroutines.Continuation r66) {
            /*
                Method dump skipped, instructions count: 344
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.baselib.db.video.UGCVideoDetailPlayDao.DefaultImpls.e(com.transsion.baselib.db.video.UGCVideoDetailPlayDao, java.lang.String, java.lang.String, long, long, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    Object a(Continuation continuation);

    Object b(String str, String str2, Continuation continuation);

    Object c(String str, Continuation continuation);

    Object d(int i11, int i12, Continuation continuation);

    Object e(String str, String str2, long j11, long j12, int i11, Continuation continuation);

    Object f(int i11, int i12, Continuation continuation);

    Object g(String str, Continuation continuation);

    Object h(String str, String str2, long j11, Continuation continuation);

    Object i(int i11, int i12, String str, Continuation continuation);

    Object j(String str, Continuation continuation);

    Object k(String str, String str2, long j11, long j12, Continuation continuation);

    Object l(String str, String str2, Continuation continuation);

    Object m(String str, Continuation continuation);

    Object n(UGCVideoDetailPlayBean uGCVideoDetailPlayBean, Continuation continuation);

    Object o(int i11, int i12, Continuation continuation);

    Object p(UGCVideoDetailPlayBean uGCVideoDetailPlayBean, Continuation continuation);

    Object q(String str, String str2, Continuation continuation);

    Object r(String str, Continuation continuation);

    Object s(String str, String str2, Continuation continuation);

    Object t(String str, String str2, String str3, Continuation continuation);

    Object u(String str, Continuation continuation);

    Object v(UGCVideoDetailPlayBean uGCVideoDetailPlayBean, Continuation continuation);

    Object w(int i11, int i12, String str, Continuation continuation);
}
