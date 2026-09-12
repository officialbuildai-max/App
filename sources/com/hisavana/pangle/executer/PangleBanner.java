package com.hisavana.pangle.executer;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerRequest;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.cloud.sdk.commonutil.util.e;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.BaseBanner;
import com.hisavana.common.base.WrapTadView;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.pangle.check.ExistsCheck;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.transsion.push.PushConstants;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class PangleBanner extends BaseBanner {

    /* renamed from: d, reason: collision with root package name */
    private View f33403d;

    /* renamed from: e, reason: collision with root package name */
    private PAGBannerAdLoadListener f33404e;

    /* renamed from: f, reason: collision with root package name */
    private PAGBannerAdInteractionListener f33405f;

    /* renamed from: g, reason: collision with root package name */
    private PAGBannerAd f33406g;

    /* renamed from: h, reason: collision with root package name */
    private PAGBannerRequest f33407h;

    public PangleBanner(Context context, Network network, int i11) {
        super(context, network);
        this.f33404e = new PAGBannerAdLoadListener() { // from class: com.hisavana.pangle.executer.PangleBanner.1
            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
            public void onAdLoaded(PAGBannerAd pAGBannerAd) {
                if (pAGBannerAd == null) {
                    return;
                }
                PangleBanner.this.f33406g = pAGBannerAd;
                PangleBanner pangleBanner = PangleBanner.this;
                pangleBanner.f33403d = pangleBanner.f33406g.getBannerView();
                if (PangleBanner.this.f33405f != null) {
                    PangleBanner.this.f33406g.setAdInteractionListener(PangleBanner.this.f33405f);
                    try {
                        double parseDouble = Double.parseDouble(PangleBanner.this.f33406g.getExtraInfo(BidResponsed.KEY_PRICE).toString());
                        if (parseDouble > 0.0d) {
                            PangleBanner.this.setEcpmPrice(parseDouble * 100.0d);
                        }
                    } catch (Exception e11) {
                        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, Log.getStackTraceString(e11));
                    }
                }
                PangleBanner.this.adLoaded();
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle onAdLoad");
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vS
            public void onError(int i12, String str) {
                PangleBanner.this.adFailedToLoad(new TAdErrorCode(i12, "Pangle Ads failed to load ad with error message: " + str));
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle onError pangle code：" + i12 + "，message：" + str);
            }
        };
        this.f33405f = new PAGBannerAdInteractionListener() { // from class: com.hisavana.pangle.executer.PangleBanner.2
            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdClicked() {
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdClick");
                PangleBanner.this.adClicked(null);
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdDismissed() {
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdDismissed");
                PangleBanner.this.adClosed();
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdShowed() {
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdShowed");
                PangleBanner.this.adImpression(null);
            }
        };
        this.f33407h = new PAGBannerRequest(i11 != 1 ? i11 != 2 ? i11 != 3 ? PAGBannerSize.BANNER_W_320_H_50 : new PAGBannerSize(Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE, 90) : PAGBannerSize.BANNER_W_300_H_250 : new PAGBannerSize(Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE, 100));
    }

    @Override // com.hisavana.common.base.BaseBanner, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseBanner
    protected View getBanner() {
        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "getBanner " + this.f33403d);
        WeakReference<Context> weakReference = this.mContext;
        Context context = (weakReference == null || weakReference.get() == null) ? null : this.mContext.get();
        if (this.f33403d == null && context != null) {
            this.f33403d = new View(e.a());
        }
        return this.f33403d;
    }

    @Override // com.hisavana.common.base.BaseBanner
    protected void onBannerDestroy() {
        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "onBannerDestroy");
        if (this.f33403d != null) {
            this.f33403d = null;
        }
        PAGBannerAd pAGBannerAd = this.f33406g;
        if (pAGBannerAd != null) {
            pAGBannerAd.destroy();
        }
        this.f33405f = null;
        this.f33404e = null;
    }

    @Override // com.hisavana.common.base.BaseBanner
    protected void onBannerLoad() {
        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "onBannerLoad");
        if (this.mNetwork == null) {
            adFailedToLoad(new TAdErrorCode(30003, "Pangle Ads failed to load ad error with mNetwork == null"));
        } else {
            final long currentTimeMillis = System.currentTimeMillis();
            ExistsCheck.initAdSource(this.mNetwork.getApplicationId(), new PAGSdk.PAGInitCallback() { // from class: com.hisavana.pangle.executer.PangleBanner.3
                @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
                public void fail(int i11, String str) {
                    PangleBanner.this.adFailedToLoad(new TAdErrorCode(i11, "Pangle Ads failed to load ad error with : PAGSdk.isInitSuccess() " + PAGSdk.isInitSuccess()));
                    AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "init onError code：" + i11 + "，message：" + str);
                }

                @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
                public void success() {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "init time " + currentTimeMillis2);
                    if (((BaseAd) PangleBanner.this).mNetwork != null && !TextUtils.isEmpty(((BaseAd) PangleBanner.this).mNetwork.getCodeSeatId()) && PangleBanner.this.f33404e != null) {
                        PAGBannerAd.loadAd(((BaseAd) PangleBanner.this).mNetwork.getCodeSeatId(), PangleBanner.this.f33407h, PangleBanner.this.f33404e);
                        return;
                    }
                    PangleBanner.this.adFailedToLoad(new TAdErrorCode(30003, "Pangle Ads failed to load ad error with : PAGSdk.isInitSuccess() " + PAGSdk.isInitSuccess()));
                }
            });
        }
    }

    @Override // com.hisavana.common.base.BaseBanner, com.hisavana.common.interfacz.IadView
    public void show(WrapTadView wrapTadView, String str, String str2) {
        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "showBanner");
        if (this.f33403d == null || wrapTadView == null) {
            onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
            AdLogUtil.Log().e(ExistsCheck.PANGLE_TAG, "showBanner show error,adView is null");
            return;
        }
        logTrigerShow(str, str2);
        wrapTadView.removeAllViews();
        wrapTadView.addView(this.f33403d);
        ViewGroup.LayoutParams layoutParams = this.f33403d.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(13);
            this.f33403d.setLayoutParams(layoutParams);
        }
        this.f33403d.setVisibility(0);
    }

    @Override // com.hisavana.common.base.BaseBanner
    protected void showBanner() {
    }
}
