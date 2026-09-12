package androidx.compose.foundation;

import androidx.compose.foundation.DefaultDebugIndication;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.n0;
import p.k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.compose.foundation.DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1", f = "Indication.kt", l = {240}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DefaultDebugIndication.DefaultDebugIndicationInstance this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements kotlinx.coroutines.flow.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f2659a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f2660b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f2661c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DefaultDebugIndication.DefaultDebugIndicationInstance f2662d;

        a(Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3, DefaultDebugIndication.DefaultDebugIndicationInstance defaultDebugIndicationInstance) {
            this.f2659a = intRef;
            this.f2660b = intRef2;
            this.f2661c = intRef3;
            this.f2662d = defaultDebugIndicationInstance;
        }

        @Override // kotlinx.coroutines.flow.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(p.f fVar, Continuation continuation) {
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13 = true;
            if (fVar instanceof k.b) {
                this.f2659a.element++;
            } else if (fVar instanceof k.c) {
                Ref.IntRef intRef = this.f2659a;
                intRef.element--;
            } else if (fVar instanceof k.a) {
                Ref.IntRef intRef2 = this.f2659a;
                intRef2.element--;
            } else if (fVar instanceof p.d) {
                this.f2660b.element++;
            } else if (fVar instanceof p.e) {
                Ref.IntRef intRef3 = this.f2660b;
                intRef3.element--;
            } else if (fVar instanceof p.b) {
                this.f2661c.element++;
            } else if (fVar instanceof p.c) {
                Ref.IntRef intRef4 = this.f2661c;
                intRef4.element--;
            }
            boolean z14 = false;
            boolean z15 = this.f2659a.element > 0;
            boolean z16 = this.f2660b.element > 0;
            boolean z17 = this.f2661c.element > 0;
            z10 = this.f2662d.f2656o;
            if (z10 != z15) {
                this.f2662d.f2656o = z15;
                z14 = true;
            }
            z11 = this.f2662d.f2657p;
            if (z11 != z16) {
                this.f2662d.f2657p = z16;
                z14 = true;
            }
            z12 = this.f2662d.f2658q;
            if (z12 != z17) {
                this.f2662d.f2658q = z17;
            } else {
                z13 = z14;
            }
            if (z13) {
                androidx.compose.ui.node.o.a(this.f2662d);
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1(DefaultDebugIndication.DefaultDebugIndicationInstance defaultDebugIndicationInstance, Continuation<? super DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultDebugIndicationInstance;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        p.g gVar;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            Ref.IntRef intRef = new Ref.IntRef();
            Ref.IntRef intRef2 = new Ref.IntRef();
            Ref.IntRef intRef3 = new Ref.IntRef();
            gVar = this.this$0.f2655n;
            kotlinx.coroutines.flow.b b11 = gVar.b();
            a aVar = new a(intRef, intRef2, intRef3, this.this$0);
            this.label = 1;
            if (b11.a(aVar, this) == f11) {
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
