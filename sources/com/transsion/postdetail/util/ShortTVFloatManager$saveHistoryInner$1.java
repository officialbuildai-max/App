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
@DebugMetadata(c = "com.transsion.postdetail.util.ShortTVFloatManager$saveHistoryInner$1", f = "ShortTVFloatManager.kt", l = {62, 63}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class ShortTVFloatManager$saveHistoryInner$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ px.a $floatBean;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVFloatManager$saveHistoryInner$1(px.a aVar, Function0<Unit> function0, Continuation<? super ShortTVFloatManager$saveHistoryInner$1> continuation) {
        super(2, continuation);
        this.$floatBean = aVar;
        this.$callback = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTVFloatManager$saveHistoryInner$1(this.$floatBean, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ShortTVFloatManager$saveHistoryInner$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0089 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L23
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.ResultKt.b(r12)
            goto L8a
        L13:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1b:
            java.lang.Object r1 = r11.L$0
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            kotlin.ResultKt.b(r12)
            goto L75
        L23:
            kotlin.ResultKt.b(r12)
            px.a r12 = r11.$floatBean
            if (r12 == 0) goto L8a
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r11.$callback
            lg.a$a r4 = lg.a.f68962a
            int r5 = r12.c()
            long r6 = r12.n()
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
            com.transsion.postdetail.util.ShortTVFloatManager r4 = com.transsion.postdetail.util.ShortTVFloatManager.f50203b
            com.transsion.baselib.db.video.ShortTVPlayDao r5 = com.transsion.postdetail.util.ShortTVFloatManager.g(r4)
            java.lang.String r6 = r12.r()
            int r7 = r12.c()
            long r8 = r12.n()
            r11.L$0 = r1
            r11.label = r3
            r10 = r11
            java.lang.Object r12 = r5.h(r6, r7, r8, r10)
            if (r12 != r0) goto L75
            return r0
        L75:
            kotlinx.coroutines.a2 r12 = kotlinx.coroutines.y0.c()
            com.transsion.postdetail.util.ShortTVFloatManager$saveHistoryInner$1$1$1 r3 = new com.transsion.postdetail.util.ShortTVFloatManager$saveHistoryInner$1$1$1
            r4 = 0
            r3.<init>(r1, r4)
            r11.L$0 = r4
            r11.label = r2
            java.lang.Object r12 = kotlinx.coroutines.i.g(r12, r3, r11)
            if (r12 != r0) goto L8a
            return r0
        L8a:
            kotlin.Unit r12 = kotlin.Unit.f67184a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.util.ShortTVFloatManager$saveHistoryInner$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
