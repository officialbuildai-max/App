package com.transsion.ad.strategy;

import com.transsion.ad.monopoly.MonopolyAdManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.u0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.strategy.AdObserveNetworkState$onConnected$2", f = "AdObserveNetworkState.kt", l = {71, 73}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class AdObserveNetworkState$onConnected$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdObserveNetworkState$onConnected$2(Continuation<? super AdObserveNetworkState$onConnected$2> continuation) {
        super(2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(boolean z10) {
        String e11;
        AtomicBoolean atomicBoolean;
        AdObserveNetworkState.f42264e = z10;
        oi.a aVar = oi.a.f71145a;
        e11 = AdObserveNetworkState.f42260a.e();
        oi.a.g(aVar, null, e11 + " --> onConnected() --> 广告请求结果--> result == " + z10, 0, false, 13, null);
        atomicBoolean = AdObserveNetworkState.f42262c;
        atomicBoolean.set(false);
        return Unit.f67184a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdObserveNetworkState$onConnected$2(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((AdObserveNetworkState$onConnected$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String e11;
        String str;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            this.label = 1;
            if (u0.a(500L, this) == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.f67184a;
            }
            ResultKt.b(obj);
        }
        oi.a aVar = oi.a.f71145a;
        e11 = AdObserveNetworkState.f42260a.e();
        oi.a.g(aVar, null, e11 + " --> onConnected() --> 网络变化，请求广告配置", 0, false, 13, null);
        MonopolyAdManager monopolyAdManager = MonopolyAdManager.f42177a;
        str = AdObserveNetworkState.f42261b;
        if (str == null) {
            str = "";
        }
        Function1 function1 = new Function1() { // from class: com.transsion.ad.strategy.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                Unit d11;
                d11 = AdObserveNetworkState$onConnected$2.d(((Boolean) obj2).booleanValue());
                return d11;
            }
        };
        this.label = 2;
        if (monopolyAdManager.b(str, function1, this) == f11) {
            return f11;
        }
        return Unit.f67184a;
    }
}
