package com.transsnet.downloader.view;

import androidx.fragment.app.FragmentActivity;
import androidx.view.v;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baselib.db.download.DownloadBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.view.DownloadingTipsDialogFragment$showAd$1", f = "DownloadingTipsDialogFragment.kt", l = {237}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class DownloadingTipsDialogFragment$showAd$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DownloadingTipsDialogFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadingTipsDialogFragment$showAd$1(DownloadingTipsDialogFragment downloadingTipsDialogFragment, Continuation<? super DownloadingTipsDialogFragment$showAd$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadingTipsDialogFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadingTipsDialogFragment$showAd$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadingTipsDialogFragment$showAd$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BiddingNativeManager biddingNativeManager;
        BiddingNativeManager biddingNativeManager2;
        BiddingNativeManager biddingNativeManager3;
        BiddingNativeManager biddingNativeManager4;
        BiddingNativeManager biddingNativeManager5;
        DownloadBean downloadBean;
        String str;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            biddingNativeManager = this.this$0.nativeManager;
            if (biddingNativeManager == null) {
                this.this$0.nativeManager = new BiddingNativeManager();
                biddingNativeManager3 = this.this$0.nativeManager;
                if (biddingNativeManager3 != null) {
                    biddingNativeManager3.O0("DownloadPopupScene");
                }
                biddingNativeManager4 = this.this$0.nativeManager;
                if (biddingNativeManager4 != null) {
                    com.transsion.ad.strategy.d dVar = com.transsion.ad.strategy.d.f42285a;
                    downloadBean = this.this$0.data;
                    if (downloadBean == null || (str = downloadBean.getGenre()) == null) {
                        str = "";
                    }
                    biddingNativeManager4.M0(dVar.a(str));
                }
                biddingNativeManager5 = this.this$0.nativeManager;
                if (biddingNativeManager5 != null) {
                    final DownloadingTipsDialogFragment downloadingTipsDialogFragment = this.this$0;
                    biddingNativeManager5.N0(new di.a() { // from class: com.transsnet.downloader.view.DownloadingTipsDialogFragment$showAd$1.1
                        @Override // di.a
                        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                            super.j(biddingIntermediateMaterialBean);
                            FragmentActivity activity = DownloadingTipsDialogFragment.this.getActivity();
                            if (activity != null) {
                                k.d(v.a(activity), null, null, new DownloadingTipsDialogFragment$showAd$1$1$onBiddingLoad$1$1(DownloadingTipsDialogFragment.this, activity, biddingIntermediateMaterialBean, null), 3, null);
                            }
                        }
                    });
                }
            }
            biddingNativeManager2 = this.this$0.nativeManager;
            if (biddingNativeManager2 != null) {
                this.label = 1;
                if (AbsAdBidding.w0(biddingNativeManager2, 0, false, this, 3, null) == f11) {
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
