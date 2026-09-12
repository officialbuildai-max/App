package com.transsion.baseui.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/c;", "", "", "<anonymous>", "(Lkotlinx/coroutines/flow/c;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.baseui.util.TimeUtilKt$countdownByFlow$1", f = "TimeUtil.kt", l = {326, 327}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class TimeUtilKt$countdownByFlow$1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.c, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $max;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeUtilKt$countdownByFlow$1(int i11, Continuation<? super TimeUtilKt$countdownByFlow$1> continuation) {
        super(2, continuation);
        this.$max = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TimeUtilKt$countdownByFlow$1 timeUtilKt$countdownByFlow$1 = new TimeUtilKt$countdownByFlow$1(this.$max, continuation);
        timeUtilKt$countdownByFlow$1.L$0 = obj;
        return timeUtilKt$countdownByFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.flow.c cVar, Continuation<? super Unit> continuation) {
        return ((TimeUtilKt$countdownByFlow$1) create(cVar, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
    
        if (r1 != 0) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0036  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0056 -> B:6:0x0059). Please report as a decompilation issue!!! */
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
            r2 = -1
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2b
            if (r1 == r4) goto L21
            if (r1 != r3) goto L19
            int r1 = r8.I$0
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.flow.c r5 = (kotlinx.coroutines.flow.c) r5
            kotlin.ResultKt.b(r9)
            goto L59
        L19:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L21:
            int r1 = r8.I$0
            java.lang.Object r5 = r8.L$0
            kotlinx.coroutines.flow.c r5 = (kotlinx.coroutines.flow.c) r5
            kotlin.ResultKt.b(r9)
            goto L48
        L2b:
            kotlin.ResultKt.b(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.flow.c r9 = (kotlinx.coroutines.flow.c) r9
            int r1 = r8.$max
        L34:
            if (r2 >= r1) goto L5c
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.d(r1)
            r8.L$0 = r9
            r8.I$0 = r1
            r8.label = r4
            java.lang.Object r5 = r9.emit(r5, r8)
            if (r5 != r0) goto L47
            return r0
        L47:
            r5 = r9
        L48:
            if (r1 == 0) goto L59
            r8.L$0 = r5
            r8.I$0 = r1
            r8.label = r3
            r6 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r9 = kotlinx.coroutines.u0.a(r6, r8)
            if (r9 != r0) goto L59
            return r0
        L59:
            r9 = r5
            int r1 = r1 + r2
            goto L34
        L5c:
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.baseui.util.TimeUtilKt$countdownByFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
