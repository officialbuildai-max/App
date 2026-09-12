package com.transsion.transfer.wifi.connect;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)Ljava/lang/String;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.transfer.wifi.connect.WifiConnectionManager$getCorrectAddNetAddress$2", f = "WifiConnectionManager.kt", l = {360, 370}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class WifiConnectionManager$getCorrectAddNetAddress$2 extends SuspendLambda implements Function2<n0, Continuation<? super String>, Object> {
    int I$0;
    int I$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WifiConnectionManager$getCorrectAddNetAddress$2(Continuation<? super WifiConnectionManager$getCorrectAddNetAddress$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WifiConnectionManager$getCorrectAddNetAddress$2(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super String> continuation) {
        return ((WifiConnectionManager$getCorrectAddNetAddress$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x009e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007a -> B:16:0x007d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.label
            r2 = 0
            r3 = 1
            r4 = 0
            r5 = 2
            if (r1 == 0) goto L25
            if (r1 == r3) goto L1d
            if (r1 != r5) goto L15
            kotlin.ResultKt.b(r11)
            goto L94
        L15:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1d:
            int r1 = r10.I$1
            int r6 = r10.I$0
            kotlin.ResultKt.b(r11)
            goto L7d
        L25:
            kotlin.ResultKt.b(r11)
            com.transsion.transfer.wifi.util.WifiUtils r11 = com.transsion.transfer.wifi.util.WifiUtils.f56083a
            android.net.NetworkInfo$DetailedState r11 = r11.i()
            r1 = r4
            r6 = r1
        L30:
            if (r1 != 0) goto L84
            r7 = 25
            if (r6 > r7) goto L84
            if (r11 == 0) goto L3c
            android.net.NetworkInfo$DetailedState r7 = android.net.NetworkInfo.DetailedState.CONNECTED
            if (r11 == r7) goto L84
        L3c:
            com.transsion.transfer.wifi.util.g r7 = com.transsion.transfer.wifi.util.g.f56093a
            com.transsion.transfer.wifi.connect.WifiConnectionManager r8 = com.transsion.transfer.wifi.connect.WifiConnectionManager.f55955a
            java.lang.String r8 = com.transsion.transfer.wifi.connect.WifiConnectionManager.f(r8)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r8)
            java.lang.String r8 = " --> getCorrectAddNetAddress() --> 第"
            r9.append(r8)
            r9.append(r6)
            java.lang.String r8 = "次addNet连接 ip信息 wifiStatus = "
            r9.append(r8)
            r9.append(r11)
            java.lang.String r8 = r9.toString()
            com.transsion.transfer.wifi.util.g.b(r7, r8, r4, r5, r2)
            if (r11 != 0) goto L6c
            android.net.NetworkInfo$DetailedState r7 = android.net.NetworkInfo.DetailedState.CONNECTED
            if (r11 == r7) goto L6a
            goto L6c
        L6a:
            r1 = r3
            goto L30
        L6c:
            int r6 = r6 + 1
            r10.I$0 = r6
            r10.I$1 = r1
            r10.label = r3
            r7 = 400(0x190, double:1.976E-321)
            java.lang.Object r11 = kotlinx.coroutines.u0.a(r7, r10)
            if (r11 != r0) goto L7d
            return r0
        L7d:
            com.transsion.transfer.wifi.util.WifiUtils r11 = com.transsion.transfer.wifi.util.WifiUtils.f56083a
            android.net.NetworkInfo$DetailedState r11 = r11.i()
            goto L30
        L84:
            kv.a r11 = kv.a.f68516a
            r11.c()
            com.transsion.transfer.wifi.util.WifiUtils r11 = com.transsion.transfer.wifi.util.WifiUtils.f56083a
            r10.label = r5
            java.lang.Object r11 = r11.h(r10)
            if (r11 != r0) goto L94
            return r0
        L94:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r0 = "0.0.0.0"
            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r11, r0)
            if (r0 == 0) goto Lc8
            com.transsion.transfer.wifi.util.WifiUtils r11 = com.transsion.transfer.wifi.util.WifiUtils.f56083a
            long r0 = r11.k()
            com.transsion.transfer.wifi.util.g r3 = com.transsion.transfer.wifi.util.g.f56093a
            com.transsion.transfer.wifi.connect.WifiConnectionManager r6 = com.transsion.transfer.wifi.connect.WifiConnectionManager.f55955a
            java.lang.String r6 = com.transsion.transfer.wifi.connect.WifiConnectionManager.f(r6)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            java.lang.String r6 = " --> getCorrectAddNetAddress() --> 经过多次获取，ip仍然为0.0.0.0，最后再获取一次 gateway = "
            r7.append(r6)
            r7.append(r0)
            java.lang.String r6 = r7.toString()
            com.transsion.transfer.wifi.util.g.d(r3, r6, r4, r5, r2)
            java.lang.String r11 = r11.t(r0)
            return r11
        Lc8:
            com.transsion.transfer.wifi.util.g r0 = com.transsion.transfer.wifi.util.g.f56093a
            com.transsion.transfer.wifi.connect.WifiConnectionManager r1 = com.transsion.transfer.wifi.connect.WifiConnectionManager.f55955a
            java.lang.String r1 = com.transsion.transfer.wifi.connect.WifiConnectionManager.f(r1)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = " --> getCorrectAddNetAddress() --> 已获取到正确的ip地址，ip = "
            r3.append(r1)
            r3.append(r11)
            java.lang.String r1 = r3.toString()
            com.transsion.transfer.wifi.util.g.d(r0, r1, r4, r5, r2)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.transfer.wifi.connect.WifiConnectionManager$getCorrectAddNetAddress$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
