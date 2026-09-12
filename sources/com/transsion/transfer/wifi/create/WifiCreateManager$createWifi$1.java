package com.transsion.transfer.wifi.create;

import com.transsion.transfer.wifi.create.adapter.b;
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
@DebugMetadata(c = "com.transsion.transfer.wifi.create.WifiCreateManager$createWifi$1", f = "WifiCreateManager.kt", l = {84}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class WifiCreateManager$createWifi$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $listener;
    final /* synthetic */ n0 $scope;
    final /* synthetic */ lv.a $wifiInfoModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WifiCreateManager$createWifi$1(a aVar, lv.a aVar2, n0 n0Var, Continuation<? super WifiCreateManager$createWifi$1> continuation) {
        super(2, continuation);
        this.$listener = aVar;
        this.$wifiInfoModel = aVar2;
        this.$scope = n0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WifiCreateManager$createWifi$1(this.$listener, this.$wifiInfoModel, this.$scope, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((WifiCreateManager$createWifi$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b bVar;
        b bVar2;
        b i11;
        Object f11 = IntrinsicsKt.f();
        int i12 = this.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            WifiCreateManager wifiCreateManager = WifiCreateManager.f56005a;
            WifiCreateManager.f56006b = this.$listener;
            WifiCreateManager wifiCreateManager2 = WifiCreateManager.f56005a;
            wifiCreateManager2.onStart();
            bVar = WifiCreateManager.f56007c;
            if (bVar == null) {
                i11 = wifiCreateManager2.i();
                WifiCreateManager.f56007c = i11;
            }
            bVar2 = WifiCreateManager.f56007c;
            if (bVar2 != null) {
                lv.a aVar = this.$wifiInfoModel;
                n0 n0Var = this.$scope;
                this.label = 1;
                if (bVar2.i(aVar, wifiCreateManager2, n0Var, this) == f11) {
                    return f11;
                }
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f67184a;
    }
}
