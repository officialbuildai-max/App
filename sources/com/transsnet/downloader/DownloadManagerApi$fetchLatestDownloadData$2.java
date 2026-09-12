package com.transsnet.downloader;

import com.cloud.tmc.offline.download.model.TaskResultKt;
import com.transsion.baselib.db.download.DownloadBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/n0;", "Lkotlin/Pair;", "", "", "Lcom/transsion/baselib/db/download/DownloadBean;", "<anonymous>", "(Lkotlinx/coroutines/n0;)Lkotlin/Pair;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.DownloadManagerApi$fetchLatestDownloadData$2", f = "DownloadManagerApi.kt", l = {TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY, 109}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class DownloadManagerApi$fetchLatestDownloadData$2 extends SuspendLambda implements Function2<n0, Continuation<? super Pair<? extends Integer, ? extends List<? extends DownloadBean>>>, Object> {
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DownloadManagerApi$fetchLatestDownloadData$2(Continuation<? super DownloadManagerApi$fetchLatestDownloadData$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerApi$fetchLatestDownloadData$2(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Pair<Integer, ? extends List<? extends DownloadBean>>> continuation) {
        return ((DownloadManagerApi$fetchLatestDownloadData$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r4.L$0
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r5)
            goto L4a
        L16:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1e:
            kotlin.ResultKt.b(r5)
            goto L35
        L22:
            kotlin.ResultKt.b(r5)
            com.transsnet.downloader.viewmodel.DownloadListManager$a r5 = com.transsnet.downloader.viewmodel.DownloadListManager.f60117m
            com.transsnet.downloader.viewmodel.DownloadListManager r5 = r5.a()
            r4.label = r3
            r1 = 3
            java.lang.Object r5 = r5.J(r1, r4)
            if (r5 != r0) goto L35
            return r0
        L35:
            java.util.List r5 = (java.util.List) r5
            com.transsnet.downloader.viewmodel.DownloadListManager$a r1 = com.transsnet.downloader.viewmodel.DownloadListManager.f60117m
            com.transsnet.downloader.viewmodel.DownloadListManager r1 = r1.a()
            r4.L$0 = r5
            r4.label = r2
            java.lang.Object r1 = r1.O(r4)
            if (r1 != r0) goto L48
            return r0
        L48:
            r0 = r5
            r5 = r1
        L4a:
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto L53
            int r5 = r5.size()
            goto L54
        L53:
            r5 = 0
        L54:
            kotlin.Pair r1 = new kotlin.Pair
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.d(r5)
            if (r0 != 0) goto L61
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L61:
            r1.<init>(r5, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.DownloadManagerApi$fetchLatestDownloadData$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
