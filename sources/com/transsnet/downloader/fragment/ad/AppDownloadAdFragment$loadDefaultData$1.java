package com.transsnet.downloader.fragment.ad;

import com.transsion.ad.bidding.icon.BiddingIconAdManager;
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
@DebugMetadata(c = "com.transsnet.downloader.fragment.ad.AppDownloadAdFragment$loadDefaultData$1", f = "AppDownloadAdFragment.kt", l = {111}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class AppDownloadAdFragment$loadDefaultData$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AppDownloadAdFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppDownloadAdFragment$loadDefaultData$1(AppDownloadAdFragment appDownloadAdFragment, Continuation<? super AppDownloadAdFragment$loadDefaultData$1> continuation) {
        super(2, continuation);
        this.this$0 = appDownloadAdFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppDownloadAdFragment$loadDefaultData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((AppDownloadAdFragment$loadDefaultData$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BiddingIconAdManager biddingIconAdManager;
        di.a aVar;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            biddingIconAdManager = this.this$0.adManager;
            int r11 = com.transsion.ad.scene.a.r(com.transsion.ad.scene.a.f42255a, "DownloadCenterAppDistributionScene", 0, 2, null);
            aVar = this.this$0.com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String;
            this.label = 1;
            if (BiddingIconAdManager.S(biddingIconAdManager, "DownloadCenterAppDistributionScene", true, r11, aVar, null, this, 16, null) == f11) {
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
