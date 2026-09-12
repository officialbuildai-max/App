package com.transsion.player.longvideo.intercept;

import androidx.appcompat.app.AppCompatActivity;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.player.longvideo.intercept.PlaybackInterceptAdView$innerLoadAd$3$1", f = "PlaybackInterceptAdView.kt", l = {357}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class PlaybackInterceptAdView$innerLoadAd$3$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppCompatActivity $activity;
    final /* synthetic */ String $sceneId;
    int label;
    final /* synthetic */ PlaybackInterceptAdView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlaybackInterceptAdView$innerLoadAd$3$1(PlaybackInterceptAdView playbackInterceptAdView, String str, AppCompatActivity appCompatActivity, Continuation<? super PlaybackInterceptAdView$innerLoadAd$3$1> continuation) {
        super(2, continuation);
        this.this$0 = playbackInterceptAdView;
        this.$sceneId = str;
        this.$activity = appCompatActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlaybackInterceptAdView$innerLoadAd$3$1(this.this$0, this.$sceneId, this.$activity, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PlaybackInterceptAdView$innerLoadAd$3$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BiddingNativeManager biddingNativeManager;
        BiddingNativeManager biddingNativeManager2;
        BiddingNativeManager biddingNativeManager3;
        BiddingNativeManager biddingNativeManager4;
        BiddingNativeManager biddingNativeManager5;
        di.a aVar;
        String str;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            this.this$0.landAd = new BiddingNativeManager();
            biddingNativeManager = this.this$0.landAd;
            if (biddingNativeManager != null) {
                biddingNativeManager.O0(this.$sceneId);
            }
            biddingNativeManager2 = this.this$0.landAd;
            if (biddingNativeManager2 != null) {
                com.transsion.ad.strategy.d dVar = com.transsion.ad.strategy.d.f42285a;
                str = this.this$0.genre;
                biddingNativeManager2.M0(dVar.a(str));
            }
            biddingNativeManager3 = this.this$0.landAd;
            if (biddingNativeManager3 != null) {
                biddingNativeManager3.L0(this.$activity);
            }
            biddingNativeManager4 = this.this$0.landAd;
            if (biddingNativeManager4 != null) {
                aVar = this.this$0.listener;
                biddingNativeManager4.N0(aVar);
            }
            biddingNativeManager5 = this.this$0.landAd;
            if (biddingNativeManager5 != null) {
                this.label = 1;
                if (AbsAdBidding.w0(biddingNativeManager5, 0, false, this, 3, null) == f11) {
                    return f11;
                }
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
