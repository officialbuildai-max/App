package com.transsion.postdetail.shorttv.factory;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class ShortTvHistoryProvider implements qs.h {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @Override // qs.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(com.transsion.shorttv.bean.Subject r26, com.transsion.shorttv.bean.ShortTVItem r27, long r28, kotlin.coroutines.Continuation r30) {
        /*
            r25 = this;
            r0 = r30
            boolean r1 = r0 instanceof com.transsion.postdetail.shorttv.factory.ShortTvHistoryProvider$saveHistory$1
            if (r1 == 0) goto L17
            r1 = r0
            com.transsion.postdetail.shorttv.factory.ShortTvHistoryProvider$saveHistory$1 r1 = (com.transsion.postdetail.shorttv.factory.ShortTvHistoryProvider$saveHistory$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.label = r2
            r2 = r25
            goto L1e
        L17:
            com.transsion.postdetail.shorttv.factory.ShortTvHistoryProvider$saveHistory$1 r1 = new com.transsion.postdetail.shorttv.factory.ShortTvHistoryProvider$saveHistory$1
            r2 = r25
            r1.<init>(r2, r0)
        L1e:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r4 = r1.label
            r5 = 1
            if (r4 == 0) goto L38
            if (r4 != r5) goto L30
            kotlin.ResultKt.b(r0)
            goto Lc9
        L30:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L38:
            kotlin.ResultKt.b(r0)
            com.transsion.baselib.db.video.ShortTVPlayBean r0 = new com.transsion.baselib.db.video.ShortTVPlayBean
            java.lang.String r4 = r26.getSubjectId()
            java.lang.String r6 = ""
            if (r4 != 0) goto L47
            r7 = r6
            goto L48
        L47:
            r7 = r4
        L48:
            java.lang.String r4 = r27.getId()
            if (r4 != 0) goto L50
            r8 = r6
            goto L51
        L50:
            r8 = r4
        L51:
            int r9 = r27.getEp()
            int r10 = r27.getSe()
            int r11 = r26.getTotalEpisode()
            java.lang.String r14 = r26.getTitle()
            java.lang.String r15 = r26.getDescription()
            com.transsion.shorttv.bean.Cover r4 = r26.getCover()
            r6 = 0
            if (r4 == 0) goto L73
            java.lang.String r4 = r4.getUrl()
            r16 = r4
            goto L75
        L73:
            r16 = r6
        L75:
            com.transsion.shorttv.bean.Cover r4 = r26.getCover()
            if (r4 == 0) goto L82
            java.lang.String r4 = r4.getThumbnail()
            r17 = r4
            goto L84
        L82:
            r17 = r6
        L84:
            java.lang.String r18 = r27.getVideoId()
            com.transsion.shorttv.bean.Media r4 = r27.getVideo()
            if (r4 == 0) goto L9b
            com.transsion.shorttv.bean.Video r4 = r4.getVideoAddress()
            if (r4 == 0) goto L9b
            java.lang.String r4 = r4.getUrl()
            r19 = r4
            goto L9d
        L9b:
            r19 = r6
        L9d:
            long r20 = java.lang.System.currentTimeMillis()
            r23 = 8192(0x2000, float:1.14794E-41)
            r24 = 0
            r22 = 0
            r6 = r0
            r12 = r28
            r6.<init>(r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19, r20, r22, r23, r24)
            com.transsion.baselib.db.AppDatabase$g1 r4 = com.transsion.baselib.db.AppDatabase.INSTANCE
            android.app.Application r6 = com.blankj.utilcode.util.Utils.a()
            java.lang.String r7 = "getApp(...)"
            kotlin.jvm.internal.Intrinsics.g(r6, r7)
            com.transsion.baselib.db.AppDatabase r4 = r4.b(r6)
            com.transsion.baselib.db.video.ShortTVPlayDao r4 = r4.x1()
            r1.label = r5
            java.lang.Object r0 = r4.g(r0, r1)
            if (r0 != r3) goto Lc9
            return r3
        Lc9:
            my.e r0 = new my.e
            r1 = 0
            r0.<init>(r5, r1)
            com.transsnet.flow.event.AppScopeVMlProvider r1 = com.transsnet.flow.event.AppScopeVMlProvider.INSTANCE
            java.lang.Class<com.transsnet.flow.event.FlowEventBus> r3 = com.transsnet.flow.event.FlowEventBus.class
            androidx.lifecycle.t0 r1 = r1.getApplicationScopeViewModel(r3)
            com.transsnet.flow.event.FlowEventBus r1 = (com.transsnet.flow.event.FlowEventBus) r1
            java.lang.Class<my.e> r3 = my.e.class
            java.lang.String r3 = r3.getName()
            java.lang.String r4 = "getName(...)"
            kotlin.jvm.internal.Intrinsics.g(r3, r4)
            r4 = 0
            r1.postEvent(r3, r0, r4)
            kotlin.Unit r0 = kotlin.Unit.f67184a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.shorttv.factory.ShortTvHistoryProvider.a(com.transsion.shorttv.bean.Subject, com.transsion.shorttv.bean.ShortTVItem, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // qs.h
    public Object b(String str, String str2, Continuation continuation) {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        Object b11 = companion.b(a11).x1().b(str, str2, continuation);
        return b11 == IntrinsicsKt.f() ? b11 : Unit.f67184a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @Override // qs.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(java.lang.String r21, kotlin.coroutines.Continuation r22) {
        /*
            r20 = this;
            r0 = r22
            boolean r1 = r0 instanceof com.transsion.postdetail.shorttv.factory.ShortTvHistoryProvider$getHistory$1
            if (r1 == 0) goto L17
            r1 = r0
            com.transsion.postdetail.shorttv.factory.ShortTvHistoryProvider$getHistory$1 r1 = (com.transsion.postdetail.shorttv.factory.ShortTvHistoryProvider$getHistory$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.label = r2
            r2 = r20
            goto L1e
        L17:
            com.transsion.postdetail.shorttv.factory.ShortTvHistoryProvider$getHistory$1 r1 = new com.transsion.postdetail.shorttv.factory.ShortTvHistoryProvider$getHistory$1
            r2 = r20
            r1.<init>(r2, r0)
        L1e:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r4 = r1.label
            r5 = 1
            if (r4 == 0) goto L37
            if (r4 != r5) goto L2f
            kotlin.ResultKt.b(r0)
            goto L58
        L2f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L37:
            kotlin.ResultKt.b(r0)
            com.transsion.baselib.db.AppDatabase$g1 r0 = com.transsion.baselib.db.AppDatabase.INSTANCE
            android.app.Application r4 = com.blankj.utilcode.util.Utils.a()
            java.lang.String r6 = "getApp(...)"
            kotlin.jvm.internal.Intrinsics.g(r4, r6)
            com.transsion.baselib.db.AppDatabase r0 = r0.b(r4)
            com.transsion.baselib.db.video.ShortTVPlayDao r0 = r0.x1()
            r1.label = r5
            r4 = r21
            java.lang.Object r0 = r0.e(r4, r1)
            if (r0 != r3) goto L58
            return r3
        L58:
            com.transsion.baselib.db.video.ShortTVPlayBean r0 = (com.transsion.baselib.db.video.ShortTVPlayBean) r0
            if (r0 != 0) goto L5e
            r0 = 0
            return r0
        L5e:
            com.transsion.shorttv.bean.ShortTvInnerPlayBean r1 = new com.transsion.shorttv.bean.ShortTvInnerPlayBean
            r3 = r1
            java.lang.String r4 = r0.getSubjectId()
            java.lang.String r5 = r0.getId()
            int r6 = r0.getEp()
            int r7 = r0.getSe()
            int r8 = r0.getTotalEp()
            long r9 = r0.getProgress()
            java.lang.String r11 = r0.getTitle()
            java.lang.String r12 = r0.getDescription()
            java.lang.String r13 = r0.getCoverUrl()
            java.lang.String r14 = r0.getThumbnail()
            java.lang.String r15 = r0.getVideoId()
            java.lang.String r16 = r0.getVideoUrl()
            long r17 = r0.getTimeStamp()
            java.lang.String r19 = r0.getSubtitleSelectId()
            r3.<init>(r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r19)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.shorttv.factory.ShortTvHistoryProvider.c(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
