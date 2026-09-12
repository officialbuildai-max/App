package com.transsion.subtitle.fragment;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.u0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.subtitle.fragment.SubtitleSelectListFragment$onComplete$1", f = "SubtitleSelectListFragment.kt", l = {234}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class SubtitleSelectListFragment$onComplete$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SubtitleSelectListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubtitleSelectListFragment$onComplete$1(SubtitleSelectListFragment subtitleSelectListFragment, Continuation<? super SubtitleSelectListFragment$onComplete$1> continuation) {
        super(2, continuation);
        this.this$0 = subtitleSelectListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SubtitleSelectListFragment$onComplete$1 subtitleSelectListFragment$onComplete$1 = new SubtitleSelectListFragment$onComplete$1(this.this$0, continuation);
        subtitleSelectListFragment$onComplete$1.L$0 = obj;
        return subtitleSelectListFragment$onComplete$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SubtitleSelectListFragment$onComplete$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        n0 n0Var;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            n0 n0Var2 = (n0) this.L$0;
            this.L$0 = n0Var2;
            this.label = 1;
            if (u0.a(500L, this) == f11) {
                return f11;
            }
            n0Var = n0Var2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            n0Var = (n0) this.L$0;
            ResultKt.b(obj);
        }
        com.transsion.subtitle.a.f54861a.a(n0Var.getClass().getSimpleName() + " --> onComplete() --> 刷新列表 --> 刷新状态");
        this.this$0.onHiddenChanged(false);
        return Unit.f67184a;
    }
}
