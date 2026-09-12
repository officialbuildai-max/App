package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.e;
import androidx.compose.ui.input.pointer.e0;
import androidx.compose.ui.input.pointer.w;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.o2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import o0.a0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/e0;", "", "<anonymous>", "(Landroidx/compose/ui/input/pointer/e0;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1", f = "Draggable.kt", l = {524}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DragGestureNode$initializePointerInputNode$1 extends SuspendLambda implements Function2<e0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DragGestureNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1", f = "Draggable.kt", l = {526}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ e0 $$this$SuspendingPointerInputModifierNode;
        final /* synthetic */ Function2<w, y.g, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function1<w, Unit> $onDragEnd;
        final /* synthetic */ Function3<w, w, y.g, Unit> $onDragStart;
        final /* synthetic */ Function0<Boolean> $shouldAwaitTouchSlop;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DragGestureNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(DragGestureNode dragGestureNode, e0 e0Var, Function3<? super w, ? super w, ? super y.g, Unit> function3, Function1<? super w, Unit> function1, Function0<Unit> function0, Function0<Boolean> function02, Function2<? super w, ? super y.g, Unit> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = dragGestureNode;
            this.$$this$SuspendingPointerInputModifierNode = e0Var;
            this.$onDragStart = function3;
            this.$onDragEnd = function1;
            this.$onDragCancel = function0;
            this.$shouldAwaitTouchSlop = function02;
            this.$onDrag = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$$this$SuspendingPointerInputModifierNode, this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$shouldAwaitTouchSlop, this.$onDrag, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r12.label
                r2 = 1
                if (r1 == 0) goto L1d
                if (r1 != r2) goto L15
                java.lang.Object r0 = r12.L$0
                kotlinx.coroutines.n0 r0 = (kotlinx.coroutines.n0) r0
                kotlin.ResultKt.b(r13)     // Catch: java.util.concurrent.CancellationException -> L13
                goto L5d
            L13:
                r13 = move-exception
                goto L46
            L15:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1d:
                kotlin.ResultKt.b(r13)
                java.lang.Object r13 = r12.L$0
                kotlinx.coroutines.n0 r13 = (kotlinx.coroutines.n0) r13
                androidx.compose.foundation.gestures.DragGestureNode r1 = r12.this$0     // Catch: java.util.concurrent.CancellationException -> L42
                androidx.compose.foundation.gestures.Orientation r8 = androidx.compose.foundation.gestures.DragGestureNode.K1(r1)     // Catch: java.util.concurrent.CancellationException -> L42
                androidx.compose.ui.input.pointer.e0 r3 = r12.$$this$SuspendingPointerInputModifierNode     // Catch: java.util.concurrent.CancellationException -> L42
                kotlin.jvm.functions.Function3<androidx.compose.ui.input.pointer.w, androidx.compose.ui.input.pointer.w, y.g, kotlin.Unit> r4 = r12.$onDragStart     // Catch: java.util.concurrent.CancellationException -> L42
                kotlin.jvm.functions.Function1<androidx.compose.ui.input.pointer.w, kotlin.Unit> r5 = r12.$onDragEnd     // Catch: java.util.concurrent.CancellationException -> L42
                kotlin.jvm.functions.Function0<kotlin.Unit> r6 = r12.$onDragCancel     // Catch: java.util.concurrent.CancellationException -> L42
                kotlin.jvm.functions.Function0<java.lang.Boolean> r7 = r12.$shouldAwaitTouchSlop     // Catch: java.util.concurrent.CancellationException -> L42
                kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.w, y.g, kotlin.Unit> r9 = r12.$onDrag     // Catch: java.util.concurrent.CancellationException -> L42
                r12.L$0 = r13     // Catch: java.util.concurrent.CancellationException -> L42
                r12.label = r2     // Catch: java.util.concurrent.CancellationException -> L42
                r10 = r12
                java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.b(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.util.concurrent.CancellationException -> L42
                if (r13 != r0) goto L5d
                return r0
            L42:
                r0 = move-exception
                r11 = r0
                r0 = r13
                r13 = r11
            L46:
                androidx.compose.foundation.gestures.DragGestureNode r1 = r12.this$0
                kotlinx.coroutines.channels.d r1 = androidx.compose.foundation.gestures.DragGestureNode.J1(r1)
                if (r1 == 0) goto L57
                androidx.compose.foundation.gestures.e$a r2 = androidx.compose.foundation.gestures.e.a.f2795a
                java.lang.Object r1 = r1.c(r2)
                kotlinx.coroutines.channels.h.b(r1)
            L57:
                boolean r0 = kotlinx.coroutines.o0.g(r0)
                if (r0 == 0) goto L60
            L5d:
                kotlin.Unit r13 = kotlin.Unit.f67184a
                return r13
            L60:
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragGestureNode$initializePointerInputNode$1(DragGestureNode dragGestureNode, Continuation<? super DragGestureNode$initializePointerInputNode$1> continuation) {
        super(2, continuation);
        this.this$0 = dragGestureNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureNode$initializePointerInputNode$1 dragGestureNode$initializePointerInputNode$1 = new DragGestureNode$initializePointerInputNode$1(this.this$0, continuation);
        dragGestureNode$initializePointerInputNode$1.L$0 = obj;
        return dragGestureNode$initializePointerInputNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(e0 e0Var, Continuation<? super Unit> continuation) {
        return ((DragGestureNode$initializePointerInputNode$1) create(e0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            e0 e0Var = (e0) this.L$0;
            final androidx.compose.ui.input.pointer.util.a aVar = new androidx.compose.ui.input.pointer.util.a();
            final DragGestureNode dragGestureNode = this.this$0;
            Function3<w, w, y.g, Unit> function3 = new Function3<w, w, y.g, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragStart$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                    m31invoke0AR0LA0((w) obj2, (w) obj3, ((y.g) obj4).v());
                    return Unit.f67184a;
                }

                /* renamed from: invoke-0AR0LA0, reason: not valid java name */
                public final void m31invoke0AR0LA0(w wVar, w wVar2, long j11) {
                    boolean z10;
                    kotlinx.coroutines.channels.d dVar;
                    kotlinx.coroutines.channels.d dVar2;
                    if (((Boolean) DragGestureNode.this.T1().invoke(wVar)).booleanValue()) {
                        z10 = DragGestureNode.this.f2744w;
                        if (!z10) {
                            dVar2 = DragGestureNode.this.f2742u;
                            if (dVar2 == null) {
                                DragGestureNode.this.f2742u = kotlinx.coroutines.channels.g.b(Integer.MAX_VALUE, null, null, 6, null);
                            }
                            DragGestureNode.this.c2();
                        }
                        e0.c.c(aVar, wVar);
                        long q11 = y.g.q(wVar2.h(), j11);
                        dVar = DragGestureNode.this.f2742u;
                        if (dVar != null) {
                            kotlinx.coroutines.channels.h.b(dVar.c(new e.c(q11, null)));
                        }
                    }
                }
            };
            final DragGestureNode dragGestureNode2 = this.this$0;
            Function1<w, Unit> function1 = new Function1<w, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragEnd$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((w) obj2);
                    return Unit.f67184a;
                }

                public final void invoke(w wVar) {
                    kotlinx.coroutines.channels.d dVar;
                    long b11;
                    e0.c.c(androidx.compose.ui.input.pointer.util.a.this, wVar);
                    float e11 = ((o2) androidx.compose.ui.node.e.a(dragGestureNode2, CompositionLocalsKt.j())).e();
                    long b12 = androidx.compose.ui.input.pointer.util.a.this.b(a0.a(e11, e11));
                    androidx.compose.ui.input.pointer.util.a.this.e();
                    dVar = dragGestureNode2.f2742u;
                    if (dVar != null) {
                        b11 = DraggableKt.b(b12);
                        kotlinx.coroutines.channels.h.b(dVar.c(new e.d(b11, null)));
                    }
                }
            };
            final DragGestureNode dragGestureNode3 = this.this$0;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragCancel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m30invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m30invoke() {
                    kotlinx.coroutines.channels.d dVar;
                    dVar = DragGestureNode.this.f2742u;
                    if (dVar != null) {
                        kotlinx.coroutines.channels.h.b(dVar.c(e.a.f2795a));
                    }
                }
            };
            final DragGestureNode dragGestureNode4 = this.this$0;
            Function0<Boolean> function02 = new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$shouldAwaitTouchSlop$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(!DragGestureNode.this.b2());
                }
            };
            final DragGestureNode dragGestureNode5 = this.this$0;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, e0Var, function3, function1, function0, function02, new Function2<w, y.g, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDrag$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    m29invokeUv8p0NA((w) obj2, ((y.g) obj3).v());
                    return Unit.f67184a;
                }

                /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
                public final void m29invokeUv8p0NA(w wVar, long j11) {
                    kotlinx.coroutines.channels.d dVar;
                    e0.c.c(androidx.compose.ui.input.pointer.util.a.this, wVar);
                    dVar = dragGestureNode5.f2742u;
                    if (dVar != null) {
                        kotlinx.coroutines.channels.h.b(dVar.c(new e.b(j11, null)));
                    }
                }
            }, null);
            this.label = 1;
            if (o0.e(anonymousClass1, this) == f11) {
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
