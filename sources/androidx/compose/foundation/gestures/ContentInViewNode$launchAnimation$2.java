package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ContentInViewNode;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.v1;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2", f = "ContentInViewNode.kt", l = {196}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ContentInViewNode$launchAnimation$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ UpdatableAnimationState $animationState;
    final /* synthetic */ d $bringIntoViewSpec;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ContentInViewNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/h;", "", "<anonymous>", "(Landroidx/compose/foundation/gestures/h;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1", f = "ContentInViewNode.kt", l = {201}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<h, Continuation<? super Unit>, Object> {
        final /* synthetic */ t1 $animationJob;
        final /* synthetic */ UpdatableAnimationState $animationState;
        final /* synthetic */ d $bringIntoViewSpec;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ContentInViewNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UpdatableAnimationState updatableAnimationState, ContentInViewNode contentInViewNode, d dVar, t1 t1Var, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$animationState = updatableAnimationState;
            this.this$0 = contentInViewNode;
            this.$bringIntoViewSpec = dVar;
            this.$animationJob = t1Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$animationState, this.this$0, this.$bringIntoViewSpec, this.$animationJob, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(h hVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(hVar, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            float N1;
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                final h hVar = (h) this.L$0;
                UpdatableAnimationState updatableAnimationState = this.$animationState;
                N1 = this.this$0.N1(this.$bringIntoViewSpec);
                updatableAnimationState.j(N1);
                final UpdatableAnimationState updatableAnimationState2 = this.$animationState;
                final ContentInViewNode contentInViewNode = this.this$0;
                final t1 t1Var = this.$animationJob;
                Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewNode.launchAnimation.2.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke(((Number) obj2).floatValue());
                        return Unit.f67184a;
                    }

                    public final void invoke(float f12) {
                        boolean z10;
                        ScrollingLogic scrollingLogic;
                        z10 = ContentInViewNode.this.f2712p;
                        float f13 = z10 ? 1.0f : -1.0f;
                        scrollingLogic = ContentInViewNode.this.f2711o;
                        float A = f13 * scrollingLogic.A(scrollingLogic.u(hVar.b(scrollingLogic.u(scrollingLogic.B(f13 * f12)), androidx.compose.ui.input.nestedscroll.e.f5014a.b())));
                        if (Math.abs(A) < Math.abs(f12)) {
                            JobKt__JobKt.f(t1Var, "Scroll animation cancelled because scroll was not consumed (" + A + " < " + f12 + ')', null, 2, null);
                        }
                    }
                };
                final ContentInViewNode contentInViewNode2 = this.this$0;
                final UpdatableAnimationState updatableAnimationState3 = this.$animationState;
                final d dVar = this.$bringIntoViewSpec;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewNode.launchAnimation.2.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m28invoke();
                        return Unit.f67184a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m28invoke() {
                        androidx.compose.runtime.collection.b bVar;
                        boolean z10;
                        float N12;
                        y.i S1;
                        androidx.compose.runtime.collection.b bVar2;
                        androidx.compose.runtime.collection.b bVar3;
                        androidx.compose.runtime.collection.b bVar4;
                        BringIntoViewRequestPriorityQueue bringIntoViewRequestPriorityQueue = ContentInViewNode.this.f2715s;
                        ContentInViewNode contentInViewNode3 = ContentInViewNode.this;
                        while (true) {
                            bVar = bringIntoViewRequestPriorityQueue.f2704a;
                            if (!bVar.q()) {
                                break;
                            }
                            bVar2 = bringIntoViewRequestPriorityQueue.f2704a;
                            y.i iVar = (y.i) ((ContentInViewNode.a) bVar2.r()).b().invoke();
                            if (!(iVar == null ? true : ContentInViewNode.V1(contentInViewNode3, iVar, 0L, 1, null))) {
                                break;
                            }
                            bVar3 = bringIntoViewRequestPriorityQueue.f2704a;
                            bVar4 = bringIntoViewRequestPriorityQueue.f2704a;
                            ((ContentInViewNode.a) bVar3.v(bVar4.n() - 1)).a().resumeWith(Result.m1185constructorimpl(Unit.f67184a));
                        }
                        z10 = ContentInViewNode.this.f2718v;
                        if (z10) {
                            S1 = ContentInViewNode.this.S1();
                            if (S1 != null && ContentInViewNode.V1(ContentInViewNode.this, S1, 0L, 1, null)) {
                                ContentInViewNode.this.f2718v = false;
                            }
                        }
                        UpdatableAnimationState updatableAnimationState4 = updatableAnimationState3;
                        N12 = ContentInViewNode.this.N1(dVar);
                        updatableAnimationState4.j(N12);
                    }
                };
                this.label = 1;
                if (updatableAnimationState2.h(function1, function0, this) == f11) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentInViewNode$launchAnimation$2(ContentInViewNode contentInViewNode, UpdatableAnimationState updatableAnimationState, d dVar, Continuation<? super ContentInViewNode$launchAnimation$2> continuation) {
        super(2, continuation);
        this.this$0 = contentInViewNode;
        this.$animationState = updatableAnimationState;
        this.$bringIntoViewSpec = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ContentInViewNode$launchAnimation$2 contentInViewNode$launchAnimation$2 = new ContentInViewNode$launchAnimation$2(this.this$0, this.$animationState, this.$bringIntoViewSpec, continuation);
        contentInViewNode$launchAnimation$2.L$0 = obj;
        return contentInViewNode$launchAnimation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ContentInViewNode$launchAnimation$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ScrollingLogic scrollingLogic;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            try {
                if (i11 == 0) {
                    ResultKt.b(obj);
                    t1 k11 = v1.k(((n0) this.L$0).getCoroutineContext());
                    this.this$0.f2720x = true;
                    scrollingLogic = this.this$0.f2711o;
                    MutatePriority mutatePriority = MutatePriority.Default;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$animationState, this.this$0, this.$bringIntoViewSpec, k11, null);
                    this.label = 1;
                    if (scrollingLogic.v(mutatePriority, anonymousClass1, this) == f11) {
                        return f11;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                this.this$0.f2715s.d();
                this.this$0.f2720x = false;
                this.this$0.f2715s.b(null);
                this.this$0.f2718v = false;
                return Unit.f67184a;
            } catch (CancellationException e11) {
                throw e11;
            }
        } catch (Throwable th2) {
            this.this$0.f2720x = false;
            this.this$0.f2715s.b(null);
            this.this$0.f2718v = false;
            throw th2;
        }
    }
}
