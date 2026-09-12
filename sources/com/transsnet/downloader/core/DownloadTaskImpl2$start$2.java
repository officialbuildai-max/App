package com.transsnet.downloader.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.core.DownloadTaskImpl2$start$2", f = "DownloadTaskImpl2.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes7.dex */
final class DownloadTaskImpl2$start$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DownloadTaskImpl2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadTaskImpl2$start$2(DownloadTaskImpl2 downloadTaskImpl2, Continuation<? super DownloadTaskImpl2$start$2> continuation) {
        super(2, continuation);
        this.this$0 = downloadTaskImpl2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadTaskImpl2$start$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadTaskImpl2$start$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        com.transsnet.downloader.core.task.c cVar;
        c cVar2;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        lg.a.f68962a.p("download", new String[]{"DownloadTask2 has task, name = " + this.this$0.f58721c.getName()}, true);
        cVar = this.this$0.f58723e;
        if (cVar != null) {
            cVar.c(this.this$0.f58721c, false);
        }
        this.this$0.u();
        cVar2 = this.this$0.f58719a;
        cVar2.a(this.this$0.f58721c);
        return Unit.f67184a;
    }
}
