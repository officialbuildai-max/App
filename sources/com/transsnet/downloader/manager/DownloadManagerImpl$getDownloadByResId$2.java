package com.transsnet.downloader.manager;

import com.transsion.baselib.db.download.DownloadBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.manager.DownloadManagerImpl$getDownloadByResId$2", f = "DownloadManagerImpl.kt", l = {951}, m = "invokeSuspend")
/* loaded from: classes7.dex */
final class DownloadManagerImpl$getDownloadByResId$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<DownloadBean, Unit> $callback;
    final /* synthetic */ Ref.ObjectRef<DownloadBean> $downloadInfo;
    final /* synthetic */ String $resourceId;
    Object L$0;
    int label;
    final /* synthetic */ DownloadManagerImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadManagerImpl$getDownloadByResId$2(Ref.ObjectRef<DownloadBean> objectRef, String str, Function1<? super DownloadBean, Unit> function1, DownloadManagerImpl downloadManagerImpl, Continuation<? super DownloadManagerImpl$getDownloadByResId$2> continuation) {
        super(2, continuation);
        this.$downloadInfo = objectRef;
        this.$resourceId = str;
        this.$callback = function1;
        this.this$0 = downloadManagerImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerImpl$getDownloadByResId$2(this.$downloadInfo, this.$resourceId, this.$callback, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadManagerImpl$getDownloadByResId$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004c  */
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
            if (r1 == 0) goto L1b
            if (r1 != r2) goto L13
            java.lang.Object r0 = r5.L$0
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.ResultKt.b(r6)
            goto L3b
        L13:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1b:
            kotlin.ResultKt.b(r6)
            kotlin.jvm.internal.Ref$ObjectRef<com.transsion.baselib.db.download.DownloadBean> r6 = r5.$downloadInfo
            T r1 = r6.element
            if (r1 != 0) goto L5f
            java.lang.String r1 = r5.$resourceId
            if (r1 == 0) goto L41
            com.transsnet.downloader.manager.DownloadEsHelper$a r3 = com.transsnet.downloader.manager.DownloadEsHelper.f59542m
            com.transsnet.downloader.manager.DownloadEsHelper r3 = r3.a()
            r5.L$0 = r6
            r5.label = r2
            java.lang.Object r1 = r3.p(r1, r5)
            if (r1 != r0) goto L39
            return r0
        L39:
            r0 = r6
            r6 = r1
        L3b:
            com.transsion.baselib.db.download.DownloadBean r6 = (com.transsion.baselib.db.download.DownloadBean) r6
            r4 = r0
            r0 = r6
            r6 = r4
            goto L42
        L41:
            r0 = 0
        L42:
            r6.element = r0
            kotlin.jvm.internal.Ref$ObjectRef<com.transsion.baselib.db.download.DownloadBean> r6 = r5.$downloadInfo
            T r6 = r6.element
            com.transsion.baselib.db.download.DownloadBean r6 = (com.transsion.baselib.db.download.DownloadBean) r6
            if (r6 == 0) goto L5f
            com.transsnet.downloader.manager.DownloadManagerImpl r0 = r5.this$0
            java.util.List r1 = com.transsnet.downloader.manager.DownloadManagerImpl.W(r0)
            boolean r1 = r1.contains(r6)
            if (r1 != 0) goto L5f
            java.util.List r0 = com.transsnet.downloader.manager.DownloadManagerImpl.W(r0)
            r0.add(r6)
        L5f:
            kotlin.jvm.functions.Function1<com.transsion.baselib.db.download.DownloadBean, kotlin.Unit> r6 = r5.$callback
            kotlin.jvm.internal.Ref$ObjectRef<com.transsion.baselib.db.download.DownloadBean> r0 = r5.$downloadInfo
            T r0 = r0.element
            r6.invoke(r0)
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.manager.DownloadManagerImpl$getDownloadByResId$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
