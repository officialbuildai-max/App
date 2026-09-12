package com.transsion.commercialization.task.wheel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.commercialization.task.wheel.TreasureWheelDialog$lotteryDraw$1", f = "TreasureWheelDialog.kt", l = {166, 168}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class TreasureWheelDialog$lotteryDraw$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TreasureWheelDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TreasureWheelDialog$lotteryDraw$1(TreasureWheelDialog treasureWheelDialog, Continuation<? super TreasureWheelDialog$lotteryDraw$1> continuation) {
        super(2, continuation);
        this.this$0 = treasureWheelDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TreasureWheelDialog$lotteryDraw$1 treasureWheelDialog$lotteryDraw$1 = new TreasureWheelDialog$lotteryDraw$1(this.this$0, continuation);
        treasureWheelDialog$lotteryDraw$1.L$0 = obj;
        return treasureWheelDialog$lotteryDraw$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((TreasureWheelDialog$lotteryDraw$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00f8 A[Catch: all -> 0x001e, TryCatch #0 {all -> 0x001e, blocks: (B:7:0x0019, B:8:0x00e6, B:10:0x00ec, B:12:0x00f0, B:14:0x00f8, B:15:0x00fc, B:16:0x0101, B:34:0x002d, B:35:0x00a3, B:37:0x00af, B:39:0x00b5, B:41:0x00bb, B:42:0x00c1, B:48:0x003b, B:50:0x0064, B:52:0x006a, B:53:0x0070), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0119  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.commercialization.task.wheel.TreasureWheelDialog$lotteryDraw$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
