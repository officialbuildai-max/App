package com.transsion.ugcvideodetail.hepler;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ugcvideodetail.hepler.UGCVideoFloatManager$saveHistoryInner$2", f = "UGCVideoFloatManager.kt", l = {86}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class UGCVideoFloatManager$saveHistoryInner$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ px.a $floatBean;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCVideoFloatManager$saveHistoryInner$2(px.a aVar, Continuation<? super UGCVideoFloatManager$saveHistoryInner$2> continuation) {
        super(2, continuation);
        this.$floatBean = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UGCVideoFloatManager$saveHistoryInner$2 uGCVideoFloatManager$saveHistoryInner$2 = new UGCVideoFloatManager$saveHistoryInner$2(this.$floatBean, continuation);
        uGCVideoFloatManager$saveHistoryInner$2.L$0 = obj;
        return uGCVideoFloatManager$saveHistoryInner$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCVideoFloatManager$saveHistoryInner$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ad A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r12.label
            r2 = 1
            if (r1 == 0) goto L1b
            if (r1 != r2) goto L13
            kotlin.ResultKt.b(r13)     // Catch: java.lang.Throwable -> L10
            goto Lae
        L10:
            r13 = move-exception
            goto Lc0
        L13:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L1b:
            kotlin.ResultKt.b(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.n0 r13 = (kotlinx.coroutines.n0) r13
            px.a r13 = r12.$floatBean
            if (r13 == 0) goto Lc9
            long r6 = java.lang.System.currentTimeMillis()
            lg.a$a r1 = lg.a.f68962a
            java.lang.String r3 = r13.r()
            int r4 = r13.q()
            int r5 = r13.c()
            long r8 = r13.n()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "stream-----saveHistory, subjectId:"
            r10.append(r11)
            r10.append(r3)
            java.lang.String r3 = " time:"
            r10.append(r3)
            r10.append(r6)
            java.lang.String r3 = ",se:"
            r10.append(r3)
            r10.append(r4)
            java.lang.String r3 = " ep:"
            r10.append(r3)
            r10.append(r5)
            java.lang.String r3 = ", progress:"
            r10.append(r3)
            r10.append(r8)
            java.lang.String r3 = r10.toString()
            java.lang.String r4 = "VideoFloat"
            r1.c(r4, r3, r2)
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L10
            com.transsion.ugcvideodetail.api.bean.UGCVideo r1 = r13.v()     // Catch: java.lang.Throwable -> L10
            if (r1 == 0) goto L89
            com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection r1 = r1.getBelongToCollection()     // Catch: java.lang.Throwable -> L10
            if (r1 == 0) goto L89
            java.lang.String r1 = r1.getCollectionId()     // Catch: java.lang.Throwable -> L10
            if (r1 != 0) goto L87
            goto L89
        L87:
            r4 = r1
            goto L8e
        L89:
            java.lang.String r1 = r13.r()     // Catch: java.lang.Throwable -> L10
            goto L87
        L8e:
            com.transsion.ugcvideodetail.api.bean.UGCVideo r1 = r13.v()     // Catch: java.lang.Throwable -> L10
            if (r1 == 0) goto Lae
            java.lang.String r5 = r1.getUgcVideoId()     // Catch: java.lang.Throwable -> L10
            if (r5 == 0) goto Lae
            com.transsion.ugcvideodetail.hepler.UGCVideoFloatManager r1 = com.transsion.ugcvideodetail.hepler.UGCVideoFloatManager.f56413b     // Catch: java.lang.Throwable -> L10
            com.transsion.baselib.db.video.UGCVideoDetailPlayDao r3 = com.transsion.ugcvideodetail.hepler.UGCVideoFloatManager.f(r1)     // Catch: java.lang.Throwable -> L10
            long r8 = r13.n()     // Catch: java.lang.Throwable -> L10
            r12.label = r2     // Catch: java.lang.Throwable -> L10
            r10 = r12
            java.lang.Object r13 = r3.k(r4, r5, r6, r8, r10)     // Catch: java.lang.Throwable -> L10
            if (r13 != r0) goto Lae
            return r0
        Lae:
            lg.a$a r0 = lg.a.f68962a     // Catch: java.lang.Throwable -> L10
            java.lang.String r1 = "VideoFloat"
            java.lang.String r2 = "saveHistory--end"
            r4 = 4
            r5 = 0
            r3 = 0
            lg.a.C0856a.f(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L10
            kotlin.Unit r13 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L10
            kotlin.Result.m1185constructorimpl(r13)     // Catch: java.lang.Throwable -> L10
            goto Lc9
        Lc0:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r13 = kotlin.ResultKt.a(r13)
            kotlin.Result.m1185constructorimpl(r13)
        Lc9:
            kotlin.Unit r13 = kotlin.Unit.f67184a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.hepler.UGCVideoFloatManager$saveHistoryInner$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
