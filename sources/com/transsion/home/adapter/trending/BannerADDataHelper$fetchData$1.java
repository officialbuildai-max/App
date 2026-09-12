package com.transsion.home.adapter.trending;

import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.home.adapter.trending.BannerADDataHelper;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
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
@DebugMetadata(c = "com.transsion.home.adapter.trending.BannerADDataHelper$fetchData$1", f = "BannerADDataHelper.kt", l = {Sdk$SDKMetric.SDKMetricType.AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class BannerADDataHelper$fetchData$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BannerADDataHelper$fetchData$1(Continuation<? super BannerADDataHelper$fetchData$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BannerADDataHelper$fetchData$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((BannerADDataHelper$fetchData$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BiddingNativeManager biddingNativeManager;
        BiddingNativeManager biddingNativeManager2;
        BiddingNativeManager biddingNativeManager3;
        BannerADDataHelper.a aVar;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            BannerADDataHelper bannerADDataHelper = BannerADDataHelper.f44708a;
            BannerADDataHelper.f44710c = new BiddingNativeManager();
            biddingNativeManager = BannerADDataHelper.f44710c;
            if (biddingNativeManager != null) {
                biddingNativeManager.O0("TrendingNativeBannerScene");
            }
            biddingNativeManager2 = BannerADDataHelper.f44710c;
            if (biddingNativeManager2 != null) {
                aVar = BannerADDataHelper.f44715h;
                biddingNativeManager2.N0(aVar);
            }
            biddingNativeManager3 = BannerADDataHelper.f44710c;
            if (biddingNativeManager3 != null) {
                this.label = 1;
                if (AbsAdBidding.w0(biddingNativeManager3, 0, false, this, 3, null) == f11) {
                    return f11;
                }
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        BannerADDataHelper bannerADDataHelper2 = BannerADDataHelper.f44708a;
        BannerADDataHelper.f44709b = com.transsion.ad.scene.a.p(com.transsion.ad.scene.a.f42255a, "TrendingNativeBannerScene", 0, 2, null);
        return Unit.f67184a;
    }
}
