package com.transsnet.downloader.fragment;

import com.transsion.transfer.impl.TaskState;
import com.transsnet.downloader.widget.TransferBottomToolsView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import lg.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.fragment.TransferInnerMainFragment$onTaskStateChange$3", f = "TransferInnerMainFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes7.dex */
final class TransferInnerMainFragment$onTaskStateChange$3 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ TaskState $state;
    int label;
    final /* synthetic */ TransferInnerMainFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransferInnerMainFragment$onTaskStateChange$3(TaskState taskState, TransferInnerMainFragment transferInnerMainFragment, Continuation<? super TransferInnerMainFragment$onTaskStateChange$3> continuation) {
        super(2, continuation);
        this.$state = taskState;
        this.this$0 = transferInnerMainFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransferInnerMainFragment$onTaskStateChange$3(this.$state, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((TransferInnerMainFragment$onTaskStateChange$3) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (this.$state == TaskState.FINISH) {
            a.C0856a c0856a = lg.a.f68962a;
            str2 = this.this$0.logMsgTag;
            a.C0856a.f(c0856a, TransferBottomToolsView.TAG, str2 + " 客户端 有传输完成，刷新数据", false, 4, null);
            this.this$0.j0().d0().q(Boxing.a(true));
            this.this$0.k0().N();
        }
        a.C0856a c0856a2 = lg.a.f68962a;
        str = this.this$0.logMsgTag;
        a.C0856a.f(c0856a2, TransferBottomToolsView.TAG, str + "  客户端 state:" + this.$state, false, 4, null);
        this.this$0.f1();
        return Unit.f67184a;
    }
}
