package com.transsion.ugcvideodetail.hepler.subtitle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ugcvideodetail.hepler.subtitle.UGCImmVideoSubtitleControlImp$selectSubtitle$6", f = "UGCImmVideoSubtitleControlImp.kt", l = {401}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class UGCImmVideoSubtitleControlImp$selectSubtitle$6 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ eu.a $bean;
    int label;
    final /* synthetic */ UGCImmVideoSubtitleControlImp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCImmVideoSubtitleControlImp$selectSubtitle$6(eu.a aVar, UGCImmVideoSubtitleControlImp uGCImmVideoSubtitleControlImp, Continuation<? super UGCImmVideoSubtitleControlImp$selectSubtitle$6> continuation) {
        super(2, continuation);
        this.$bean = aVar;
        this.this$0 = uGCImmVideoSubtitleControlImp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCImmVideoSubtitleControlImp$selectSubtitle$6(this.$bean, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCImmVideoSubtitleControlImp$selectSubtitle$6) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        r1 = r6.this$0.f56499f;
     */
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
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.ResultKt.b(r7)
            goto L5a
        Lf:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L17:
            kotlin.ResultKt.b(r7)
            eu.a r7 = r6.$bean
            if (r7 == 0) goto L5a
            com.transsion.subtitle_download.db.SubtitleDownloadTable r7 = r7.b()
            if (r7 == 0) goto L5a
            java.lang.String r7 = r7.getId()
            if (r7 == 0) goto L5a
            com.transsion.ugcvideodetail.hepler.subtitle.UGCImmVideoSubtitleControlImp r1 = r6.this$0
            com.transsion.ugcvideodetail.api.bean.UGCImmVideo r1 = com.transsion.ugcvideodetail.hepler.subtitle.UGCImmVideoSubtitleControlImp.r(r1)
            if (r1 == 0) goto L5a
            com.transsion.ugcvideodetail.api.bean.UGCVideo r1 = r1.getUgcVideo()
            if (r1 == 0) goto L5a
            java.lang.String r1 = r1.getUgcVideoId()
            if (r1 == 0) goto L5a
            com.transsion.baselib.db.AppDatabase$g1 r3 = com.transsion.baselib.db.AppDatabase.INSTANCE
            android.app.Application r4 = com.blankj.utilcode.util.Utils.a()
            java.lang.String r5 = "getApp(...)"
            kotlin.jvm.internal.Intrinsics.g(r4, r5)
            com.transsion.baselib.db.AppDatabase r3 = r3.b(r4)
            com.transsion.baselib.db.video.UGCVideoDetailPlayDao r3 = r3.C1()
            r6.label = r2
            java.lang.Object r7 = r3.b(r1, r7, r6)
            if (r7 != r0) goto L5a
            return r0
        L5a:
            kotlin.Unit r7 = kotlin.Unit.f67184a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.hepler.subtitle.UGCImmVideoSubtitleControlImp$selectSubtitle$6.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
