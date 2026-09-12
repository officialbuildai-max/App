package com.transsnet.downloader.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$initHistory$1", f = "DownloadReDetectorShortTVFragment.kt", l = {226, 227}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class DownloadReDetectorShortTVFragment$initHistory$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DownloadReDetectorShortTVFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadReDetectorShortTVFragment$initHistory$1(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, Continuation<? super DownloadReDetectorShortTVFragment$initHistory$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadReDetectorShortTVFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadReDetectorShortTVFragment$initHistory$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadReDetectorShortTVFragment$initHistory$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0054 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r7)
            goto L55
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            java.lang.Object r1 = r6.L$0
            com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment r1 = (com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment) r1
            kotlin.ResultKt.b(r7)
            goto L3e
        L22:
            kotlin.ResultKt.b(r7)
            com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment r7 = r6.this$0
            java.lang.String r7 = com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment.j1(r7)
            if (r7 == 0) goto L55
            com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment r1 = r6.this$0
            com.transsion.baselib.db.video.ShortTVPlayDao r4 = com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment.h1(r1)
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r4.e(r7, r6)
            if (r7 != r0) goto L3e
            return r0
        L3e:
            com.transsion.baselib.db.video.ShortTVPlayBean r7 = (com.transsion.baselib.db.video.ShortTVPlayBean) r7
            kotlinx.coroutines.a2 r3 = kotlinx.coroutines.y0.c()
            com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$initHistory$1$1$1 r4 = new com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$initHistory$1$1$1
            r5 = 0
            r4.<init>(r1, r7, r5)
            r6.L$0 = r5
            r6.label = r2
            java.lang.Object r7 = kotlinx.coroutines.i.g(r3, r4, r6)
            if (r7 != r0) goto L55
            return r0
        L55:
            kotlin.Unit r7 = kotlin.Unit.f67184a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$initHistory$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
