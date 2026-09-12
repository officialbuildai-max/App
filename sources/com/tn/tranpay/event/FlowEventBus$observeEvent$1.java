package com.tn.tranpay.event;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.x0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "T", "Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)Ljava/lang/Void;"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.tn.tranpay.event.FlowEventBus$observeEvent$1", f = "FlowEventBus.kt", l = {Sdk$SDKMetric.SDKMetricType.AD_REWARD_USER_VALUE}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class FlowEventBus$observeEvent$1 extends SuspendLambda implements Function2<n0, Continuation<?>, Object> {
    final /* synthetic */ i0 $dispatcher;
    final /* synthetic */ String $eventName;
    final /* synthetic */ boolean $isSticky;
    final /* synthetic */ Function1<T, Unit> $onReceived;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FlowEventBus this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowEventBus$observeEvent$1(FlowEventBus flowEventBus, String str, boolean z10, i0 i0Var, Function1<? super T, Unit> function1, Continuation<? super FlowEventBus$observeEvent$1> continuation) {
        super(2, continuation);
        this.this$0 = flowEventBus;
        this.$eventName = str;
        this.$isSticky = z10;
        this.$dispatcher = i0Var;
        this.$onReceived = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowEventBus$observeEvent$1 flowEventBus$observeEvent$1 = new FlowEventBus$observeEvent$1(this.this$0, this.$eventName, this.$isSticky, this.$dispatcher, this.$onReceived, continuation);
        flowEventBus$observeEvent$1.L$0 = obj;
        return flowEventBus$observeEvent$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<?> continuation) {
        return ((FlowEventBus$observeEvent$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        x0 eventFlow;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            final n0 n0Var = (n0) this.L$0;
            eventFlow = this.this$0.getEventFlow(this.$eventName, this.$isSticky);
            final i0 i0Var = this.$dispatcher;
            final FlowEventBus flowEventBus = this.this$0;
            final Function1<T, Unit> function1 = this.$onReceived;
            c cVar = new c() { // from class: com.tn.tranpay.event.FlowEventBus$observeEvent$1.1

                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "T", "Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
                @DebugMetadata(c = "com.tn.tranpay.event.FlowEventBus$observeEvent$1$1$1", f = "FlowEventBus.kt", l = {}, m = "invokeSuspend")
                /* renamed from: com.tn.tranpay.event.FlowEventBus$observeEvent$1$1$1, reason: invalid class name and collision with other inner class name */
                /* loaded from: classes4.dex */
                static final class C05921 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Function1<Object, Unit> $onReceived;
                    final /* synthetic */ Object $value;
                    int label;
                    final /* synthetic */ FlowEventBus this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C05921(FlowEventBus flowEventBus, Object obj, Function1<Object, Unit> function1, Continuation<? super C05921> continuation) {
                        super(2, continuation);
                        this.this$0 = flowEventBus;
                        this.$value = obj;
                        this.$onReceived = function1;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C05921(this.this$0, this.$value, this.$onReceived, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
                        return ((C05921) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.f();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        this.this$0.invokeReceived(this.$value, this.$onReceived);
                        return Unit.f67184a;
                    }
                }

                @Override // kotlinx.coroutines.flow.c
                public final Object emit(Object obj2, Continuation continuation) {
                    k.d(n0.this, i0Var, null, new C05921(flowEventBus, obj2, function1, null), 2, null);
                    return Unit.f67184a;
                }
            };
            this.label = 1;
            if (eventFlow.a(cVar, this) == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
