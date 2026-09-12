package com.transsnet.downloader.view;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import py.r;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.view.DownloadingTipsDialogFragment$showAd$1$1$onBiddingLoad$1$1", f = "DownloadingTipsDialogFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes7.dex */
final class DownloadingTipsDialogFragment$showAd$1$1$onBiddingLoad$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $it;
    final /* synthetic */ BiddingIntermediateMaterialBean $maxEcpmObject;
    int label;
    final /* synthetic */ DownloadingTipsDialogFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadingTipsDialogFragment$showAd$1$1$onBiddingLoad$1$1(DownloadingTipsDialogFragment downloadingTipsDialogFragment, FragmentActivity fragmentActivity, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, Continuation<? super DownloadingTipsDialogFragment$showAd$1$1$onBiddingLoad$1$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadingTipsDialogFragment;
        this.$it = fragmentActivity;
        this.$maxEcpmObject = biddingIntermediateMaterialBean;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadingTipsDialogFragment$showAd$1$1$onBiddingLoad$1$1(this.this$0, this.$it, this.$maxEcpmObject, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadingTipsDialogFragment$showAd$1$1$onBiddingLoad$1$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        r rVar;
        BiddingNativeManager biddingNativeManager;
        r rVar2;
        NativeWrapperAdView nativeWrapperAdView;
        BiddingNativeManager biddingNativeManager2;
        CardView cardView;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        rVar = this.this$0.mViewBinding;
        if (rVar != null && (cardView = rVar.f73016c) != null) {
            cardView.setVisibility(0);
        }
        cy.b bVar = cy.b.f61063a;
        FragmentActivity fragmentActivity = this.$it;
        biddingNativeManager = this.this$0.nativeManager;
        com.transsion.ad.bidding.base.r a11 = bVar.a(fragmentActivity, biddingNativeManager != null ? biddingNativeManager.getMSceneId() : null);
        rVar2 = this.this$0.mViewBinding;
        if (rVar2 != null && (nativeWrapperAdView = rVar2.f73015b) != null) {
            biddingNativeManager2 = this.this$0.nativeManager;
            nativeWrapperAdView.bindNativeView(biddingNativeManager2, a11, this.$maxEcpmObject);
        }
        return Unit.f67184a;
    }
}
