package com.transsion.videofloat.manager;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import lg.a;
import ox.e;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.videofloat.manager.VideoPipManagerImp$closePip$1$1", f = "VideoPipManagerImp.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes7.dex */
final class VideoPipManagerImp$closePip$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $addCache;
    int label;
    final /* synthetic */ VideoPipManagerImp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPipManagerImp$closePip$1$1(VideoPipManagerImp videoPipManagerImp, boolean z10, Continuation<? super VideoPipManagerImp$closePip$1$1> continuation) {
        super(2, continuation);
        this.this$0 = videoPipManagerImp;
        this.$addCache = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoPipManagerImp$closePip$1$1(this.this$0, this.$addCache, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((VideoPipManagerImp$closePip$1$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        px.a aVar;
        String str;
        FragmentActivity fragmentActivity;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        aVar = this.this$0.f58033d;
        if (aVar != null) {
            VideoPipManagerImp videoPipManagerImp = this.this$0;
            boolean z10 = this.$addCache;
            a.C0856a c0856a = lg.a.f68962a;
            str = videoPipManagerImp.f58031b;
            String k11 = aVar.k();
            fragmentActivity = videoPipManagerImp.f58032c;
            c0856a.u("VideoFloat-pip", str + " 手动打开播放页，closePip--- " + k11 + "， activity:" + fragmentActivity, true);
            if (z10) {
                a0.f58056a.a(aVar.k(), aVar.f());
            }
        }
        e.b.b(this.this$0, null, 1, null);
        this.this$0.G();
        this.this$0.f58043n = false;
        this.this$0.f58035f = null;
        this.this$0.f58036g = null;
        this.this$0.f58037h = null;
        this.this$0.f58038i = null;
        this.this$0.f58039j = null;
        this.this$0.f58033d = null;
        return Unit.f67184a;
    }
}
