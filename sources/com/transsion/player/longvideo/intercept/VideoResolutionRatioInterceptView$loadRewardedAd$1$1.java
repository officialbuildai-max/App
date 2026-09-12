package com.transsion.player.longvideo.intercept;

import androidx.appcompat.app.AppCompatActivity;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.video.BiddingVideoManager;
import com.vungle.ads.internal.protos.Sdk$SDKError;
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
@DebugMetadata(c = "com.transsion.player.longvideo.intercept.VideoResolutionRatioInterceptView$loadRewardedAd$1$1", f = "VideoResolutionRatioInterceptView.kt", l = {Sdk$SDKError.Reason.PLACEMENT_AD_TYPE_MISMATCH_VALUE}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class VideoResolutionRatioInterceptView$loadRewardedAd$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppCompatActivity $activity;
    int label;
    final /* synthetic */ VideoResolutionRatioInterceptView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoResolutionRatioInterceptView$loadRewardedAd$1$1(VideoResolutionRatioInterceptView videoResolutionRatioInterceptView, AppCompatActivity appCompatActivity, Continuation<? super VideoResolutionRatioInterceptView$loadRewardedAd$1$1> continuation) {
        super(2, continuation);
        this.this$0 = videoResolutionRatioInterceptView;
        this.$activity = appCompatActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoResolutionRatioInterceptView$loadRewardedAd$1$1(this.this$0, this.$activity, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((VideoResolutionRatioInterceptView$loadRewardedAd$1$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BiddingVideoManager biddingVideoManager;
        BiddingVideoManager biddingVideoManager2;
        BiddingVideoManager biddingVideoManager3;
        BiddingVideoManager biddingVideoManager4;
        BiddingVideoManager biddingVideoManager5;
        BiddingVideoManager biddingVideoManager6;
        VideoResolutionRatioInterceptView$rewardInterceptListener$1 videoResolutionRatioInterceptView$rewardInterceptListener$1;
        String str;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            biddingVideoManager = this.this$0.rewardedAdManager;
            if (biddingVideoManager == null) {
                this.this$0.rewardedAdManager = new BiddingVideoManager();
                biddingVideoManager3 = this.this$0.rewardedAdManager;
                if (biddingVideoManager3 != null) {
                    biddingVideoManager3.O0("StreamVideoInterceptRewarded");
                }
                biddingVideoManager4 = this.this$0.rewardedAdManager;
                if (biddingVideoManager4 != null) {
                    com.transsion.ad.strategy.d dVar = com.transsion.ad.strategy.d.f42285a;
                    str = this.this$0.genre;
                    biddingVideoManager4.M0(dVar.a(str));
                }
                biddingVideoManager5 = this.this$0.rewardedAdManager;
                if (biddingVideoManager5 != null) {
                    biddingVideoManager5.L0(this.$activity);
                }
                biddingVideoManager6 = this.this$0.rewardedAdManager;
                if (biddingVideoManager6 != null) {
                    videoResolutionRatioInterceptView$rewardInterceptListener$1 = this.this$0.rewardInterceptListener;
                    biddingVideoManager6.N0(videoResolutionRatioInterceptView$rewardInterceptListener$1);
                }
            }
            biddingVideoManager2 = this.this$0.rewardedAdManager;
            if (biddingVideoManager2 != null) {
                this.label = 1;
                if (AbsAdBidding.w0(biddingVideoManager2, 0, false, this, 3, null) == f11) {
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
