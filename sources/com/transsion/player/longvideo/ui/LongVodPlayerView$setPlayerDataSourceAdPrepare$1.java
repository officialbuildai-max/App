package com.transsion.player.longvideo.ui;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.player.longvideo.ui.LongVodPlayerView$setPlayerDataSourceAdPrepare$1", f = "LongVodPlayerView.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class LongVodPlayerView$setPlayerDataSourceAdPrepare$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LongVodPlayerView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongVodPlayerView$setPlayerDataSourceAdPrepare$1(LongVodPlayerView longVodPlayerView, Continuation<? super LongVodPlayerView$setPlayerDataSourceAdPrepare$1> continuation) {
        super(2, continuation);
        this.this$0 = longVodPlayerView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongVodPlayerView$setPlayerDataSourceAdPrepare$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((LongVodPlayerView$setPlayerDataSourceAdPrepare$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Handler handler;
        Runnable runnable;
        long playTimeoutStream;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        a.C0856a.f(lg.a.f68962a, "premium_p", "LongVodPlayerView --> playerControl?.prepare() --> 这里才是设置播放器的播放资源", false, 4, null);
        this.this$0.playerControl.prepare();
        handler = this.this$0.playTimeoutHandler;
        runnable = this.this$0.playTimeoutRunnable;
        playTimeoutStream = this.this$0.getPlayTimeoutStream();
        handler.postDelayed(runnable, playTimeoutStream);
        if (this.this$0.n2() && !io.a.f65396a.b()) {
            this.this$0.r0();
        }
        return Unit.f67184a;
    }
}
