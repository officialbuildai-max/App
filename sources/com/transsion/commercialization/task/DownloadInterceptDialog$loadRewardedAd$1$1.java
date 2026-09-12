package com.transsion.commercialization.task;

import android.content.Context;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.video.BiddingVideoManager;
import com.transsion.commercialization.task.DownloadInterceptDialog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.commercialization.task.DownloadInterceptDialog$loadRewardedAd$1$1", f = "DownloadInterceptDialog.kt", l = {465}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class DownloadInterceptDialog$loadRewardedAd$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $it;
    int label;
    final /* synthetic */ DownloadInterceptDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadInterceptDialog$loadRewardedAd$1$1(DownloadInterceptDialog downloadInterceptDialog, Context context, Continuation<? super DownloadInterceptDialog$loadRewardedAd$1$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadInterceptDialog;
        this.$it = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadInterceptDialog$loadRewardedAd$1$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadInterceptDialog$loadRewardedAd$1$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BiddingVideoManager biddingVideoManager;
        BiddingVideoManager biddingVideoManager2;
        BiddingVideoManager biddingVideoManager3;
        BiddingVideoManager biddingVideoManager4;
        BiddingVideoManager biddingVideoManager5;
        DownloadInterceptDialog.d dVar;
        String str;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            biddingVideoManager = this.this$0.rewardedAdManager;
            if (biddingVideoManager != null) {
                biddingVideoManager.V();
            }
            this.this$0.rewardedAdManager = new BiddingVideoManager();
            biddingVideoManager2 = this.this$0.rewardedAdManager;
            if (biddingVideoManager2 != null) {
                str = this.this$0.interceptSceneId;
                biddingVideoManager2.O0(str);
            }
            biddingVideoManager3 = this.this$0.rewardedAdManager;
            if (biddingVideoManager3 != null) {
                biddingVideoManager3.L0(this.$it);
            }
            biddingVideoManager4 = this.this$0.rewardedAdManager;
            if (biddingVideoManager4 != null) {
                dVar = this.this$0.rewardInterceptListener;
                biddingVideoManager4.N0(dVar);
            }
            biddingVideoManager5 = this.this$0.rewardedAdManager;
            if (biddingVideoManager5 != null) {
                this.label = 1;
                if (AbsAdBidding.w0(biddingVideoManager5, 0, false, this, 3, null) == f11) {
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
