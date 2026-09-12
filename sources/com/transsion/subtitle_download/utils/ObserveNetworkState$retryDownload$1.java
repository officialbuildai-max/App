package com.transsion.subtitle_download.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.subtitle_download.utils.ObserveNetworkState$retryDownload$1", f = "ObserveNetworkState.kt", l = {59, 66}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ObserveNetworkState$retryDownload$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $msg;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObserveNetworkState$retryDownload$1(String str, Continuation<? super ObserveNetworkState$retryDownload$1> continuation) {
        super(2, continuation);
        this.$msg = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ObserveNetworkState$retryDownload$1(this.$msg, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ObserveNetworkState$retryDownload$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0059  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.label
            r2 = 0
            r3 = 0
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L20
            if (r1 == r5) goto L1c
            if (r1 != r4) goto L14
            kotlin.ResultKt.b(r9)
            goto L55
        L14:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1c:
            kotlin.ResultKt.b(r9)
            goto L2e
        L20:
            kotlin.ResultKt.b(r9)
            r8.label = r5
            r6 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r9 = kotlinx.coroutines.u0.a(r6, r8)
            if (r9 != r0) goto L2e
            return r0
        L2e:
            nh.m r9 = nh.m.f70597a
            boolean r9 = r9.e()
            if (r9 != 0) goto L39
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        L39:
            com.transsion.subtitle_download.db.SubtitleDownloadDatabase$d r9 = com.transsion.subtitle_download.db.SubtitleDownloadDatabase.INSTANCE
            android.app.Application r1 = com.blankj.utilcode.util.Utils.a()
            java.lang.String r6 = "getApp(...)"
            kotlin.jvm.internal.Intrinsics.g(r1, r6)
            com.transsion.subtitle_download.db.SubtitleDownloadDatabase r9 = r9.b(r1)
            mu.a r9 = r9.l0()
            r8.label = r4
            java.lang.Object r9 = mu.a.C0869a.a(r9, r3, r8, r5, r2)
            if (r9 != r0) goto L55
            return r0
        L55:
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L9e
            java.lang.String r0 = r8.$msg
            com.transsion.subtitle_download.utils.b r1 = com.transsion.subtitle_download.utils.b.f55167a
            com.transsion.subtitle_download.utils.ObserveNetworkState r5 = com.transsion.subtitle_download.utils.ObserveNetworkState.f55165a
            java.lang.String r5 = com.transsion.subtitle_download.utils.ObserveNetworkState.a(r5)
            int r6 = r9.size()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r5)
            java.lang.String r5 = " --> retryDownload() --> "
            r7.append(r5)
            r7.append(r0)
            java.lang.String r0 = " --> 数据库获取到的失败的任务数量 it.size = "
            r7.append(r0)
            r7.append(r6)
            java.lang.String r0 = r7.toString()
            r1.a(r0)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L8c:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L9e
            java.lang.Object r0 = r9.next()
            com.transsion.subtitle_download.db.SubtitleDownloadTable r0 = (com.transsion.subtitle_download.db.SubtitleDownloadTable) r0
            com.transsion.subtitle_download.task.p r1 = com.transsion.subtitle_download.task.p.f55161a
            com.transsion.subtitle_download.task.p.e(r1, r0, r3, r4, r2)
            goto L8c
        L9e:
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subtitle_download.utils.ObserveNetworkState$retryDownload$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
