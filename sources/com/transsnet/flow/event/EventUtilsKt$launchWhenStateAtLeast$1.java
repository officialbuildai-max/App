package com.transsnet.flow.event;

import androidx.view.Lifecycle;
import androidx.view.PausingDispatcherKt;
import androidx.view.u;
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
@DebugMetadata(c = "com.transsnet.flow.event.EventUtilsKt$launchWhenStateAtLeast$1", f = "EventUtils.kt", l = {50}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class EventUtilsKt$launchWhenStateAtLeast$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<n0, Continuation<? super T>, Object> $block;
    final /* synthetic */ Lifecycle.State $minState;
    final /* synthetic */ u $this_launchWhenStateAtLeast;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EventUtilsKt$launchWhenStateAtLeast$1(u uVar, Lifecycle.State state, Function2<? super n0, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super EventUtilsKt$launchWhenStateAtLeast$1> continuation) {
        super(2, continuation);
        this.$this_launchWhenStateAtLeast = uVar;
        this.$minState = state;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventUtilsKt$launchWhenStateAtLeast$1(this.$this_launchWhenStateAtLeast, this.$minState, this.$block, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((EventUtilsKt$launchWhenStateAtLeast$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            Lifecycle lifecycle = this.$this_launchWhenStateAtLeast.getLifecycle();
            Lifecycle.State state = this.$minState;
            Function2<n0, Continuation<? super T>, Object> function2 = this.$block;
            this.label = 1;
            if (PausingDispatcherKt.b(lifecycle, state, function2, this) == f11) {
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
