package com.transsnet.downloader.fragment;

import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadPanelFragment$initData$1", f = "DownloadPanelFragment.kt", l = {Sdk$SDKError.Reason.AD_NOT_LOADED_VALUE}, m = "invokeSuspend")
/* loaded from: classes7.dex */
final class DownloadPanelFragment$initData$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DownloadPanelFragment this$0;

    /* loaded from: classes7.dex */
    public static final class a extends di.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DownloadPanelFragment f58986d;

        a(DownloadPanelFragment downloadPanelFragment) {
            this.f58986d = downloadPanelFragment;
        }

        @Override // di.a
        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            DownloadListManager.a aVar = DownloadListManager.f60117m;
            DownloadListManager.I(aVar.a(), aVar.a().V(), false, this.f58986d.getSeriesNativeManager(), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadPanelFragment$initData$1(DownloadPanelFragment downloadPanelFragment, Continuation<? super DownloadPanelFragment$initData$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadPanelFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadPanelFragment$initData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadPanelFragment$initData$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BiddingNativeManager biddingNativeManager;
        DownloadPanelFragment downloadPanelFragment;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            DownloadPanelFragment downloadPanelFragment2 = this.this$0;
            biddingNativeManager = new BiddingNativeManager();
            DownloadPanelFragment downloadPanelFragment3 = this.this$0;
            biddingNativeManager.O0("DownloadTvListScene");
            biddingNativeManager.N0(new a(downloadPanelFragment3));
            this.L$0 = biddingNativeManager;
            this.L$1 = downloadPanelFragment2;
            this.label = 1;
            if (AbsAdBidding.w0(biddingNativeManager, 0, false, this, 3, null) == f11) {
                return f11;
            }
            downloadPanelFragment = downloadPanelFragment2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            downloadPanelFragment = (DownloadPanelFragment) this.L$1;
            biddingNativeManager = (BiddingNativeManager) this.L$0;
            ResultKt.b(obj);
        }
        downloadPanelFragment.y1(biddingNativeManager);
        return Unit.f67184a;
    }
}
