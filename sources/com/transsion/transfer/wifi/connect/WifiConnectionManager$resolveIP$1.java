package com.transsion.transfer.wifi.connect;

import android.text.TextUtils;
import com.transsion.transfer.wifi.util.WifiUtils;
import com.transsion.transfer.wifi.util.g;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.transfer.wifi.connect.WifiConnectionManager$resolveIP$1", f = "WifiConnectionManager.kt", l = {Sdk$SDKError.Reason.GENERATE_JSON_DATA_ERROR_VALUE}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class WifiConnectionManager$resolveIP$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WifiConnectionManager$resolveIP$1(Continuation<? super WifiConnectionManager$resolveIP$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WifiConnectionManager$resolveIP$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((WifiConnectionManager$resolveIP$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String o11;
        long j11;
        String o12;
        long j12;
        String o13;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            g gVar = g.f56093a;
            o11 = WifiConnectionManager.f55955a.o();
            g.b(gVar, o11 + " --> resolveIP(address: InetAddress?) --> P2P连接成功但ip为空，尝试轮询获取正确ip ....", false, 2, null);
            WifiUtils wifiUtils = WifiUtils.f56083a;
            this.label = 1;
            obj = wifiUtils.h(this);
            if (obj == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            j11 = WifiConnectionManager.f55963i;
            long j13 = currentTimeMillis - j11;
            g gVar2 = g.f56093a;
            WifiConnectionManager wifiConnectionManager = WifiConnectionManager.f55955a;
            o12 = wifiConnectionManager.o();
            g.b(gVar2, o12 + " --> resolveIP(address: InetAddress?) --> 连接P2P失败, 耗时 = " + j13 + " -- 原因 = P2P地址获取异常，重试后仍然异常", false, 2, null);
            wifiConnectionManager.b(2002);
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            j12 = WifiConnectionManager.f55963i;
            long j14 = currentTimeMillis2 - j12;
            g gVar3 = g.f56093a;
            WifiConnectionManager wifiConnectionManager2 = WifiConnectionManager.f55955a;
            o13 = wifiConnectionManager2.o();
            g.b(gVar3, o13 + " --> resolveIP(address: InetAddress?) --> P2P连接成功轮询后成功连接耗时 = " + j14 + " -- P2P连接成功轮询后ip = " + str, false, 2, null);
            wifiConnectionManager2.e(str);
        }
        return Unit.f67184a;
    }
}
