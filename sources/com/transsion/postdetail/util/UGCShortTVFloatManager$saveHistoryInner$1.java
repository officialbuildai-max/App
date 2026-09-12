package com.transsion.postdetail.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.util.UGCShortTVFloatManager$saveHistoryInner$1", f = "UGCShortTVFloatManager.kt", l = {59, 63}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class UGCShortTVFloatManager$saveHistoryInner$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ px.a $floatBean;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCShortTVFloatManager$saveHistoryInner$1(px.a aVar, Function0<Unit> function0, Continuation<? super UGCShortTVFloatManager$saveHistoryInner$1> continuation) {
        super(2, continuation);
        this.$floatBean = aVar;
        this.$callback = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UGCShortTVFloatManager$saveHistoryInner$1 uGCShortTVFloatManager$saveHistoryInner$1 = new UGCShortTVFloatManager$saveHistoryInner$1(this.$floatBean, this.$callback, continuation);
        uGCShortTVFloatManager$saveHistoryInner$1.L$0 = obj;
        return uGCShortTVFloatManager$saveHistoryInner$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCShortTVFloatManager$saveHistoryInner$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0085 A[Catch: all -> 0x0024, TryCatch #0 {all -> 0x0024, blocks: (B:13:0x001f, B:14:0x00a1, B:22:0x005f, B:24:0x006b, B:26:0x0071, B:30:0x007f, B:32:0x0085, B:34:0x008b, B:37:0x007a), top: B:2:0x0008 }] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlin.jvm.functions.Function0<kotlin.Unit>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6, types: [kotlin.jvm.functions.Function0] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r13.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L27
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.ResultKt.b(r14)
            goto Ld1
        L13:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L1b:
            java.lang.Object r1 = r13.L$0
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            kotlin.ResultKt.b(r14)     // Catch: java.lang.Throwable -> L24
            goto La1
        L24:
            r14 = move-exception
            goto Lb3
        L27:
            kotlin.ResultKt.b(r14)
            java.lang.Object r14 = r13.L$0
            kotlinx.coroutines.n0 r14 = (kotlinx.coroutines.n0) r14
            px.a r14 = r13.$floatBean
            if (r14 == 0) goto Ld1
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r13.$callback
            lg.a$a r4 = lg.a.f68962a
            int r5 = r14.c()
            long r6 = r14.n()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "shorttv-----saveHistory, ep:"
            r8.append(r9)
            r8.append(r5)
            java.lang.String r5 = ", progress:"
            r8.append(r5)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r8 = 4
            r9 = 0
            java.lang.String r5 = "VideoFloat"
            r7 = 0
            lg.a.C0856a.f(r4, r5, r6, r7, r8, r9)
            kotlin.Result$Companion r4 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L24
            long r8 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L24
            com.transsion.ugcvideodetail.api.bean.UGCVideo r4 = r14.v()     // Catch: java.lang.Throwable -> L24
            if (r4 == 0) goto L7a
            com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection r4 = r4.getBelongToCollection()     // Catch: java.lang.Throwable -> L24
            if (r4 == 0) goto L7a
            java.lang.String r4 = r4.getCollectionId()     // Catch: java.lang.Throwable -> L24
            if (r4 != 0) goto L78
            goto L7a
        L78:
            r6 = r4
            goto L7f
        L7a:
            java.lang.String r4 = r14.r()     // Catch: java.lang.Throwable -> L24
            goto L78
        L7f:
            com.transsion.ugcvideodetail.api.bean.UGCVideo r4 = r14.v()     // Catch: java.lang.Throwable -> L24
            if (r4 == 0) goto La1
            java.lang.String r7 = r4.getUgcVideoId()     // Catch: java.lang.Throwable -> L24
            if (r7 == 0) goto La1
            com.transsion.postdetail.util.UGCShortTVFloatManager r4 = com.transsion.postdetail.util.UGCShortTVFloatManager.f50207b     // Catch: java.lang.Throwable -> L24
            com.transsion.baselib.db.video.UGCVideoDetailPlayDao r5 = com.transsion.postdetail.util.UGCShortTVFloatManager.f(r4)     // Catch: java.lang.Throwable -> L24
            long r10 = r14.n()     // Catch: java.lang.Throwable -> L24
            r13.L$0 = r1     // Catch: java.lang.Throwable -> L24
            r13.label = r3     // Catch: java.lang.Throwable -> L24
            r12 = r13
            java.lang.Object r14 = r5.k(r6, r7, r8, r10, r12)     // Catch: java.lang.Throwable -> L24
            if (r14 != r0) goto La1
            return r0
        La1:
            lg.a$a r3 = lg.a.f68962a     // Catch: java.lang.Throwable -> L24
            java.lang.String r4 = "VideoFloat"
            java.lang.String r5 = "shorttv--saveHistory--end"
            r7 = 4
            r8 = 0
            r6 = 0
            lg.a.C0856a.f(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L24
            kotlin.Unit r14 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L24
            kotlin.Result.m1185constructorimpl(r14)     // Catch: java.lang.Throwable -> L24
            goto Lbc
        Lb3:
            kotlin.Result$Companion r3 = kotlin.Result.INSTANCE
            java.lang.Object r14 = kotlin.ResultKt.a(r14)
            kotlin.Result.m1185constructorimpl(r14)
        Lbc:
            kotlinx.coroutines.a2 r14 = kotlinx.coroutines.y0.c()
            com.transsion.postdetail.util.UGCShortTVFloatManager$saveHistoryInner$1$1$2 r3 = new com.transsion.postdetail.util.UGCShortTVFloatManager$saveHistoryInner$1$1$2
            r4 = 0
            r3.<init>(r1, r4)
            r13.L$0 = r4
            r13.label = r2
            java.lang.Object r14 = kotlinx.coroutines.i.g(r14, r3, r13)
            if (r14 != r0) goto Ld1
            return r0
        Ld1:
            kotlin.Unit r14 = kotlin.Unit.f67184a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.util.UGCShortTVFloatManager$saveHistoryInner$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
