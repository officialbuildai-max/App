package com.transsnet.downloader.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.TAdErrorCode;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.interstitial.BiddingInterstitialManager;
import com.transsion.ad.bidding.video.BiddingVideoManager;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Deprecated
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0007*\u0002-1\b\u0017\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J!\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/transsnet/downloader/fragment/DownloadReDetectorShortTVADFragment;", "Lcom/transsnet/downloader/fragment/DownloadReDetectorBaseFragment;", "Lpy/e0;", "<init>", "()V", "", "U0", "S0", "R0", "onDestroy", "initViewData", "Landroid/view/LayoutInflater;", "inflater", "O0", "(Landroid/view/LayoutInflater;)Lpy/e0;", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewModel", "initListener", "retryLoadData", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "hidden", "onHiddenChanged", "(Z)V", "Lry/f;", "l", "Lkotlin/Lazy;", "N0", "()Lry/f;", "shortTVReporter", "Lcom/transsion/ad/bidding/video/BiddingVideoManager;", "m", "Lcom/transsion/ad/bidding/video/BiddingVideoManager;", "videoManager", "Lcom/transsion/ad/bidding/interstitial/BiddingInterstitialManager;", "n", "Lcom/transsion/ad/bidding/interstitial/BiddingInterstitialManager;", "interstitialManager", "com/transsnet/downloader/fragment/DownloadReDetectorShortTVADFragment$videoListener$1", "o", "Lcom/transsnet/downloader/fragment/DownloadReDetectorShortTVADFragment$videoListener$1;", "videoListener", "com/transsnet/downloader/fragment/DownloadReDetectorShortTVADFragment$interstitialListener$1", TtmlNode.TAG_P, "Lcom/transsnet/downloader/fragment/DownloadReDetectorShortTVADFragment$interstitialListener$1;", "interstitialListener", CampaignEx.JSON_KEY_AD_Q, "a", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public class DownloadReDetectorShortTVADFragment extends DownloadReDetectorBaseFragment<py.e0> {

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private BiddingVideoManager videoManager;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private BiddingInterstitialManager interstitialManager;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final Lazy shortTVReporter = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.fragment.s3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ry.f T0;
            T0 = DownloadReDetectorShortTVADFragment.T0();
            return T0;
        }
    });

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final DownloadReDetectorShortTVADFragment$videoListener$1 videoListener = new di.a() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorShortTVADFragment$videoListener$1

        /* renamed from: d, reason: collision with root package name */
        private boolean f59103d;

        @Override // di.a
        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            DownloadReDetectorShortTVADFragment.this.R0();
        }

        @Override // di.a
        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            kotlinx.coroutines.k.d(androidx.view.v.a(DownloadReDetectorShortTVADFragment.this), null, null, new DownloadReDetectorShortTVADFragment$videoListener$1$onBiddingLoad$1(DownloadReDetectorShortTVADFragment.this, biddingIntermediateMaterialBean, null), 3, null);
        }

        @Override // di.a
        public void m(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            androidx.view.b0 p11;
            super.m(biddingIntermediateMaterialBean);
            if (this.f59103d) {
                DownloadResourcesDetectorViewModel viewModel = DownloadReDetectorShortTVADFragment.this.getViewModel();
                if (viewModel != null) {
                    viewModel.K("ad_success");
                }
            } else {
                DownloadResourcesDetectorViewModel viewModel2 = DownloadReDetectorShortTVADFragment.this.getViewModel();
                if (viewModel2 != null) {
                    viewModel2.K("ad_cancel");
                }
            }
            DownloadResourcesDetectorViewModel viewModel3 = DownloadReDetectorShortTVADFragment.this.getViewModel();
            if (viewModel3 == null || (p11 = viewModel3.p()) == null) {
                return;
            }
            p11.q(5);
        }

        @Override // di.a
        public void o(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.o(biddingIntermediateMaterialBean);
            this.f59103d = true;
        }

        @Override // di.a
        public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.p(biddingIntermediateMaterialBean);
            DownloadReDetectorShortTVADFragment.this.R0();
        }
    };

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final DownloadReDetectorShortTVADFragment$interstitialListener$1 interstitialListener = new di.a() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorShortTVADFragment$interstitialListener$1
        @Override // di.a
        public void i(TAdErrorCode tAdErrorCode) {
            androidx.view.b0 p11;
            super.i(tAdErrorCode);
            DownloadResourcesDetectorViewModel viewModel = DownloadReDetectorShortTVADFragment.this.getViewModel();
            if (viewModel != null) {
                viewModel.K("ad_load_fail");
            }
            DownloadResourcesDetectorViewModel viewModel2 = DownloadReDetectorShortTVADFragment.this.getViewModel();
            if (viewModel2 == null || (p11 = viewModel2.p()) == null) {
                return;
            }
            p11.q(5);
        }

        @Override // di.a
        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            kotlinx.coroutines.k.d(androidx.view.v.a(DownloadReDetectorShortTVADFragment.this), null, null, new DownloadReDetectorShortTVADFragment$interstitialListener$1$onBiddingLoad$1(DownloadReDetectorShortTVADFragment.this, biddingIntermediateMaterialBean, null), 3, null);
        }

        @Override // di.a
        public void m(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            androidx.view.b0 p11;
            super.m(biddingIntermediateMaterialBean);
            DownloadResourcesDetectorViewModel viewModel = DownloadReDetectorShortTVADFragment.this.getViewModel();
            if (viewModel != null) {
                viewModel.K("ad_success");
            }
            DownloadResourcesDetectorViewModel viewModel2 = DownloadReDetectorShortTVADFragment.this.getViewModel();
            if (viewModel2 == null || (p11 = viewModel2.p()) == null) {
                return;
            }
            p11.q(5);
        }

        @Override // di.a
        public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            androidx.view.b0 p11;
            super.p(biddingIntermediateMaterialBean);
            DownloadResourcesDetectorViewModel viewModel = DownloadReDetectorShortTVADFragment.this.getViewModel();
            if (viewModel != null) {
                viewModel.K("ad_load_fail");
            }
            DownloadResourcesDetectorViewModel viewModel2 = DownloadReDetectorShortTVADFragment.this.getViewModel();
            if (viewModel2 == null || (p11 = viewModel2.p()) == null) {
                return;
            }
            p11.q(5);
        }
    };

    /* renamed from: com.transsnet.downloader.fragment.DownloadReDetectorShortTVADFragment$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadReDetectorShortTVADFragment a() {
            return new DownloadReDetectorShortTVADFragment();
        }
    }

    private final ry.f N0() {
        return (ry.f) this.shortTVReporter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(DownloadReDetectorShortTVADFragment downloadReDetectorShortTVADFragment, View view) {
        androidx.view.b0 p11;
        DownloadResourcesDetectorViewModel viewModel = downloadReDetectorShortTVADFragment.getViewModel();
        if (viewModel == null || (p11 = viewModel.p()) == null) {
            return;
        }
        p11.q(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(DownloadReDetectorShortTVADFragment downloadReDetectorShortTVADFragment, View view) {
        androidx.view.b0 H;
        String str;
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 1000L)) {
            return;
        }
        DownloadResourcesDetectorViewModel viewModel = downloadReDetectorShortTVADFragment.getViewModel();
        if (viewModel != null && (H = viewModel.H()) != null && (str = (String) H.f()) != null) {
            ry.f.b(downloadReDetectorShortTVADFragment.N0(), str, "dialog_minitv_download_unlock", "1", null, 8, null);
        }
        downloadReDetectorShortTVADFragment.S0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0() {
        BiddingInterstitialManager biddingInterstitialManager = this.interstitialManager;
        if (biddingInterstitialManager != null) {
            biddingInterstitialManager.V();
        }
        BiddingInterstitialManager biddingInterstitialManager2 = new BiddingInterstitialManager();
        this.interstitialManager = biddingInterstitialManager2;
        biddingInterstitialManager2.O0("ShortTvInterstitialScene");
        BiddingInterstitialManager biddingInterstitialManager3 = this.interstitialManager;
        if (biddingInterstitialManager3 != null) {
            biddingInterstitialManager3.N0(this.interstitialListener);
        }
        kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new DownloadReDetectorShortTVADFragment$loadInterstitialAd$1(this, null), 3, null);
    }

    private final void S0() {
        BiddingVideoManager biddingVideoManager = this.videoManager;
        if (biddingVideoManager != null) {
            biddingVideoManager.V();
        }
        BiddingVideoManager biddingVideoManager2 = new BiddingVideoManager();
        this.videoManager = biddingVideoManager2;
        biddingVideoManager2.O0("ShortTvVideoScene");
        BiddingVideoManager biddingVideoManager3 = this.videoManager;
        if (biddingVideoManager3 != null) {
            biddingVideoManager3.N0(this.videoListener);
        }
        kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new DownloadReDetectorShortTVADFragment$loadVideoAd$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ry.f T0() {
        return new ry.f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void U0() {
        AppCompatTextView appCompatTextView;
        androidx.view.b0 D;
        DownloadResourcesDetectorViewModel viewModel = getViewModel();
        String str = (viewModel == null || (D = viewModel.D()) == null) ? null : (String) D.f();
        if (str == null || str.length() == 0) {
            str = String.valueOf(com.transsnet.downloader.util.d0.f60049a.e());
        }
        py.e0 e0Var = (py.e0) getMViewBinding();
        if (e0Var == null || (appCompatTextView = e0Var.f72796d) == null) {
            return;
        }
        appCompatTextView.setText(Utils.a().getString(R$string.download_short_tv_watch_ad_ep, str));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public py.e0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        py.e0 c11 = py.e0.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        AppCompatTextView appCompatTextView;
        AppCompatImageView appCompatImageView;
        U0();
        py.e0 e0Var = (py.e0) getMViewBinding();
        if (e0Var != null && (appCompatImageView = e0Var.f72795c) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.t3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorShortTVADFragment.P0(DownloadReDetectorShortTVADFragment.this, view);
                }
            });
        }
        py.e0 e0Var2 = (py.e0) getMViewBinding();
        if (e0Var2 == null || (appCompatTextView = e0Var2.f72797e) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.u3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadReDetectorShortTVADFragment.Q0(DownloadReDetectorShortTVADFragment.this, view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BiddingVideoManager biddingVideoManager = this.videoManager;
        if (biddingVideoManager != null) {
            biddingVideoManager.V();
        }
        BiddingInterstitialManager biddingInterstitialManager = this.interstitialManager;
        if (biddingInterstitialManager != null) {
            biddingInterstitialManager.V();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            return;
        }
        U0();
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
    }
}
