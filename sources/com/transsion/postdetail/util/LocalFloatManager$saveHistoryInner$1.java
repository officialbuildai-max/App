package com.transsion.postdetail.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.util.LocalFloatManager$saveHistoryInner$1", f = "LocalFloatManager.kt", l = {60, 62, 63}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class LocalFloatManager$saveHistoryInner$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ px.a $floatBean;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalFloatManager$saveHistoryInner$1(px.a aVar, Function0<Unit> function0, Continuation<? super LocalFloatManager$saveHistoryInner$1> continuation) {
        super(2, continuation);
        this.$floatBean = aVar;
        this.$callback = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalFloatManager$saveHistoryInner$1(this.$floatBean, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((LocalFloatManager$saveHistoryInner$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0086 A[RETURN] */
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
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2e
            if (r1 == r4) goto L26
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            kotlin.ResultKt.b(r13)
            goto L9c
        L16:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L1e:
            java.lang.Object r1 = r12.L$0
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            kotlin.ResultKt.b(r13)
            goto L87
        L26:
            java.lang.Object r1 = r12.L$0
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            kotlin.ResultKt.b(r13)
            goto L7a
        L2e:
            kotlin.ResultKt.b(r13)
            px.a r13 = r12.$floatBean
            if (r13 == 0) goto L9c
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r12.$callback
            java.lang.String r5 = r13.p()
            if (r5 == 0) goto L7a
            lg.a$a r6 = lg.a.f68962a
            int r7 = r13.c()
            long r8 = r13.n()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "local-----saveHistory, ep:"
            r10.append(r11)
            r10.append(r7)
            java.lang.String r7 = ", progress:"
            r10.append(r7)
            r10.append(r8)
            java.lang.String r7 = r10.toString()
            java.lang.String r8 = "VideoFloat"
            r6.c(r8, r7, r4)
            com.transsnet.downloader.manager.DownloadEsHelper$a r6 = com.transsnet.downloader.manager.DownloadEsHelper.f59542m
            com.transsnet.downloader.manager.DownloadEsHelper r6 = r6.a()
            long r7 = r13.n()
            r12.L$0 = r1
            r12.label = r4
            java.lang.Object r13 = r6.e0(r5, r7, r12)
            if (r13 != r0) goto L7a
            return r0
        L7a:
            r12.L$0 = r1
            r12.label = r3
            r3 = 200(0xc8, double:9.9E-322)
            java.lang.Object r13 = kotlinx.coroutines.u0.a(r3, r12)
            if (r13 != r0) goto L87
            return r0
        L87:
            kotlinx.coroutines.a2 r13 = kotlinx.coroutines.y0.c()
            com.transsion.postdetail.util.LocalFloatManager$saveHistoryInner$1$1$2 r3 = new com.transsion.postdetail.util.LocalFloatManager$saveHistoryInner$1$1$2
            r4 = 0
            r3.<init>(r1, r4)
            r12.L$0 = r4
            r12.label = r2
            java.lang.Object r13 = kotlinx.coroutines.i.g(r13, r3, r12)
            if (r13 != r0) goto L9c
            return r0
        L9c:
            kotlin.Unit r13 = kotlin.Unit.f67184a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.util.LocalFloatManager$saveHistoryInner$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
