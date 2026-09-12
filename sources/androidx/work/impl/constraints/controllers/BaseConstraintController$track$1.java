package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.o;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/o;", "Landroidx/work/impl/constraints/b;", "", "<anonymous>", "(Lkotlinx/coroutines/channels/o;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "androidx.work.impl.constraints.controllers.BaseConstraintController$track$1", f = "ContraintControllers.kt", l = {62}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class BaseConstraintController$track$1 extends SuspendLambda implements Function2<o, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BaseConstraintController this$0;

    /* loaded from: classes2.dex */
    public static final class a implements androidx.work.impl.constraints.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseConstraintController f15680a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ o f15681b;

        a(BaseConstraintController baseConstraintController, o oVar) {
            this.f15680a = baseConstraintController;
            this.f15681b = oVar;
        }

        @Override // androidx.work.impl.constraints.a
        public void a(Object obj) {
            this.f15681b.d().c(this.f15680a.f(obj) ? new b.C0142b(this.f15680a.e()) : b.a.f15674a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseConstraintController$track$1(BaseConstraintController baseConstraintController, Continuation<? super BaseConstraintController$track$1> continuation) {
        super(2, continuation);
        this.this$0 = baseConstraintController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(BaseConstraintController baseConstraintController, a aVar) {
        i4.g gVar;
        gVar = baseConstraintController.f15679a;
        gVar.g(aVar);
        return Unit.f67184a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BaseConstraintController$track$1 baseConstraintController$track$1 = new BaseConstraintController$track$1(this.this$0, continuation);
        baseConstraintController$track$1.L$0 = obj;
        return baseConstraintController$track$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(o oVar, Continuation<? super Unit> continuation) {
        return ((BaseConstraintController$track$1) create(oVar, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        i4.g gVar;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            o oVar = (o) this.L$0;
            final a aVar = new a(this.this$0, oVar);
            gVar = this.this$0.f15679a;
            gVar.c(aVar);
            final BaseConstraintController baseConstraintController = this.this$0;
            Function0 function0 = new Function0() { // from class: androidx.work.impl.constraints.controllers.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit d11;
                    d11 = BaseConstraintController$track$1.d(BaseConstraintController.this, aVar);
                    return d11;
                }
            };
            this.label = 1;
            if (ProduceKt.a(oVar, function0, this) == f11) {
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
