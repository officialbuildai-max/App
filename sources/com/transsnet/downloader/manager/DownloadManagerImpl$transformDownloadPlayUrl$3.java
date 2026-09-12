package com.transsnet.downloader.manager;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)Ljava/lang/String;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.manager.DownloadManagerImpl$transformDownloadPlayUrl$3", f = "DownloadManagerImpl.kt", l = {1598}, m = "invokeSuspend")
/* loaded from: classes7.dex */
final class DownloadManagerImpl$transformDownloadPlayUrl$3 extends SuspendLambda implements Function2<n0, Continuation<? super String>, Object> {
    final /* synthetic */ int $ep;
    final /* synthetic */ String $subjectId;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ DownloadManagerImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadManagerImpl$transformDownloadPlayUrl$3(String str, int i11, String str2, DownloadManagerImpl downloadManagerImpl, Continuation<? super DownloadManagerImpl$transformDownloadPlayUrl$3> continuation) {
        super(2, continuation);
        this.$subjectId = str;
        this.$ep = i11;
        this.$url = str2;
        this.this$0 = downloadManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerImpl$transformDownloadPlayUrl$3(this.$subjectId, this.$ep, this.$url, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super String> continuation) {
        return ((DownloadManagerImpl$transformDownloadPlayUrl$3) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0040  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.ResultKt.b(r6)
            goto L3b
        Lf:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L17:
            kotlin.ResultKt.b(r6)
            com.transsnet.downloader.manager.DownloadEsHelper$a r6 = com.transsnet.downloader.manager.DownloadEsHelper.f59542m
            com.transsnet.downloader.manager.DownloadEsHelper r1 = r6.a()
            java.lang.String r3 = r5.$subjectId
            int r4 = r5.$ep
            com.transsion.baselib.db.download.DownloadBean r1 = r1.x(r3, r4)
            if (r1 != 0) goto L3e
            com.transsnet.downloader.manager.DownloadEsHelper r6 = r6.a()
            java.lang.String r1 = r5.$subjectId
            int r3 = r5.$ep
            r5.label = r2
            java.lang.Object r6 = r6.w(r1, r3, r5)
            if (r6 != r0) goto L3b
            return r0
        L3b:
            r1 = r6
            com.transsion.baselib.db.download.DownloadBean r1 = (com.transsion.baselib.db.download.DownloadBean) r1
        L3e:
            if (r1 != 0) goto L43
            java.lang.String r6 = r5.$url
            goto L65
        L43:
            boolean r6 = r1.isCompleted()
            if (r6 == 0) goto L5e
            java.lang.String r6 = r1.getPath()
            if (r6 == 0) goto L5b
            int r6 = r6.length()
            if (r6 != 0) goto L56
            goto L5b
        L56:
            java.lang.String r6 = r1.getPath()
            goto L65
        L5b:
            java.lang.String r6 = r5.$url
            goto L65
        L5e:
            com.transsnet.downloader.manager.DownloadManagerImpl r6 = r5.this$0
            r6.k(r1)
            java.lang.String r6 = r5.$url
        L65:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadManagerImpl$transformDownloadPlayUrl$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
