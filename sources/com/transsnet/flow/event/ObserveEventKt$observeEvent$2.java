package com.transsnet.flow.event;

import androidx.view.v0;
import androidx.view.y0;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.flow.event.ObserveEventKt$observeEvent$2", f = "ObserveEvent.kt", l = {Sdk$SDKError.Reason.INVALID_RI_ENDPOINT_VALUE}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class ObserveEventKt$observeEvent$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isSticky;
    final /* synthetic */ Function1<Object, Unit> $onReceived;
    final /* synthetic */ y0 $scope;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObserveEventKt$observeEvent$2(y0 y0Var, boolean z10, Function1<Object, Unit> function1, Continuation<? super ObserveEventKt$observeEvent$2> continuation) {
        super(2, continuation);
        this.$scope = y0Var;
        this.$isSticky = z10;
        this.$onReceived = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ObserveEventKt$observeEvent$2(this.$scope, this.$isSticky, this.$onReceived, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ObserveEventKt$observeEvent$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            FlowEventBus flowEventBus = (FlowEventBus) new v0(this.$scope).a(FlowEventBus.class);
            Intrinsics.n(4, "T");
            String name = Object.class.getName();
            Intrinsics.g(name, "getName(...)");
            boolean z10 = this.$isSticky;
            Function1<Object, Unit> function1 = this.$onReceived;
            this.label = 1;
            if (flowEventBus.observeWithoutLifecycle(name, z10, function1, this) == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f67184a;
    }
}
