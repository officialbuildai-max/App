package com.transsion.shorttv.order;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.order.PayLoadingVM$checkPayOrderId$1", f = "PayLoadingVM.kt", l = {71}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class PayLoadingVM$checkPayOrderId$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isDebug;
    final /* synthetic */ String $projectName;
    final /* synthetic */ String $tradingOrderId;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    final /* synthetic */ PayLoadingVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayLoadingVM$checkPayOrderId$1(String str, String str2, boolean z10, PayLoadingVM payLoadingVM, Continuation<? super PayLoadingVM$checkPayOrderId$1> continuation) {
        super(2, continuation);
        this.$tradingOrderId = str;
        this.$projectName = str2;
        this.$isDebug = z10;
        this.this$0 = payLoadingVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PayLoadingVM$checkPayOrderId$1 payLoadingVM$checkPayOrderId$1 = new PayLoadingVM$checkPayOrderId$1(this.$tradingOrderId, this.$projectName, this.$isDebug, this.this$0, continuation);
        payLoadingVM$checkPayOrderId$1.L$0 = obj;
        return payLoadingVM$checkPayOrderId$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PayLoadingVM$checkPayOrderId$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b5, code lost:
    
        if (r0.intValue() != 5) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b7, code lost:
    
        r0 = r4.f53095f;
        r1 = (com.transsion.shorttv.order.bean.GetPaynicornOrderStatusRespEntity) r11.getData();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c1, code lost:
    
        if (r1 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c3, code lost:
    
        r1 = r1.getOrderStatus();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c7, code lost:
    
        if (r1 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ca, code lost:
    
        r6 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00cd, code lost:
    
        r11 = (com.transsion.shorttv.order.bean.GetPaynicornOrderStatusRespEntity) r11.getData();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d3, code lost:
    
        if (r11 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d5, code lost:
    
        r11 = r11.getDescription();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d9, code lost:
    
        if (r11 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00dc, code lost:
    
        r5 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00df, code lost:
    
        r0.n(new com.transsion.shorttv.order.bean.HttpErrorBodyBean(r5, r6, null, 4, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00de, code lost:
    
        r5 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00cc, code lost:
    
        r6 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00aa, code lost:
    
        if (r0.intValue() != 3) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x007d, code lost:
    
        if (r0.intValue() != 1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0074, code lost:
    
        if (r0.intValue() != 0) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x012d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.order.PayLoadingVM$checkPayOrderId$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
