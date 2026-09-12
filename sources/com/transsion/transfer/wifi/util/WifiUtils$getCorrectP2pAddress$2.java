package com.transsion.transfer.wifi.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)Ljava/lang/String;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.transfer.wifi.util.WifiUtils$getCorrectP2pAddress$2", f = "WifiUtils.kt", l = {262}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class WifiUtils$getCorrectP2pAddress$2 extends SuspendLambda implements Function2<n0, Continuation<? super String>, Object> {
    int I$0;
    int I$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WifiUtils$getCorrectP2pAddress$2(Continuation<? super WifiUtils$getCorrectP2pAddress$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WifiUtils$getCorrectP2pAddress$2(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super String> continuation) {
        return ((WifiUtils$getCorrectP2pAddress$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0072 -> B:5:0x0013). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r14.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L1d
            if (r1 != r3) goto L15
            int r1 = r14.I$1
            int r4 = r14.I$0
            kotlin.ResultKt.b(r15)
        L13:
            r15 = r1
            goto L24
        L15:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L1d:
            kotlin.ResultKt.b(r15)
            r15 = 60
            r4 = r15
            r15 = r2
        L24:
            r5 = 0
            r1 = 0
            r7 = 2
            if (r15 >= r4) goto L7e
            com.transsion.transfer.wifi.util.WifiUtils r8 = com.transsion.transfer.wifi.util.WifiUtils.f56083a
            long r9 = r8.k()
            com.transsion.transfer.wifi.util.g r11 = com.transsion.transfer.wifi.util.g.f56093a
            java.lang.String r12 = com.transsion.transfer.wifi.util.WifiUtils.b(r8)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r12)
            java.lang.String r12 = " --> getCorrectP2pAddress() --> 第"
            r13.append(r12)
            r13.append(r15)
            java.lang.String r12 = "次p2p连接 -- ip信息 gateway = "
            r13.append(r12)
            r13.append(r9)
            java.lang.String r12 = r13.toString()
            com.transsion.transfer.wifi.util.g.b(r11, r12, r2, r7, r1)
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 != 0) goto L75
            java.lang.String r1 = r8.j()
            boolean r1 = com.transsion.transfer.wifi.util.WifiUtils.c(r8, r1)
            if (r1 == 0) goto L64
            goto L75
        L64:
            int r1 = r15 + 1
            r14.I$0 = r4
            r14.I$1 = r1
            r14.label = r3
            r5 = 200(0xc8, double:9.9E-322)
            java.lang.Object r15 = kotlinx.coroutines.u0.a(r5, r14)
            if (r15 != r0) goto L13
            return r0
        L75:
            long r0 = r8.k()
            java.lang.String r15 = r8.t(r0)
            return r15
        L7e:
            com.transsion.transfer.wifi.util.g r15 = com.transsion.transfer.wifi.util.g.f56093a
            com.transsion.transfer.wifi.util.WifiUtils r0 = com.transsion.transfer.wifi.util.WifiUtils.f56083a
            java.lang.String r3 = com.transsion.transfer.wifi.util.WifiUtils.b(r0)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = " --> getCorrectP2pAddress() --> 多次获取当前wifi ip，仍然异常，返回默认的0.0.0.0"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.transsion.transfer.wifi.util.g.b(r15, r3, r2, r7, r1)
            java.lang.String r15 = r0.t(r5)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.transfer.wifi.util.WifiUtils$getCorrectP2pAddress$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
