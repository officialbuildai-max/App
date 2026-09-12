package com.hisavana.pangle.executer;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeRequest;
import com.cloud.sdk.commonutil.util.e;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.base.BaseNative;
import com.hisavana.common.bean.AdNativeInfo;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.hisavana.pangle.check.ExistsCheck;
import com.hisavana.pangle.util.PlatformUtil;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class PangleNative extends BaseNative {

    /* renamed from: d, reason: collision with root package name */
    private PAGNativeAdLoadListener f33419d;

    /* renamed from: e, reason: collision with root package name */
    private PAGNativeAdInteractionListener f33420e;

    /* renamed from: f, reason: collision with root package name */
    private PAGNativeAd f33421f;

    /* renamed from: g, reason: collision with root package name */
    private AdNativeInfo f33422g;

    public PangleNative(Context context, Network network, int i11) {
        super(context, network, i11);
        this.f33419d = new PAGNativeAdLoadListener() { // from class: com.hisavana.pangle.executer.PangleNative.1
            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
            public void onAdLoaded(PAGNativeAd pAGNativeAd) {
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "onAdLoad");
                PangleNative.this.f33421f = pAGNativeAd;
                if (PangleNative.this.f33421f == null || PangleNative.this.f33421f.getNativeAdData() == null) {
                    return;
                }
                TAdNativeInfo tAdNativeInfo = PlatformUtil.getTAdNativeInfo(pAGNativeAd, ((BaseNative) PangleNative.this).mAdt, PangleNative.this.getTtl(), PangleNative.this);
                int filter = PangleNative.this.filter(tAdNativeInfo);
                if (filter == 0) {
                    ((BaseNative) PangleNative.this).mNatives.add(tAdNativeInfo);
                } else {
                    AdUtil.release(tAdNativeInfo);
                }
                if (!((BaseNative) PangleNative.this).mNatives.isEmpty()) {
                    PangleNative pangleNative = PangleNative.this;
                    pangleNative.adLoaded(((BaseNative) pangleNative).mNatives);
                    return;
                }
                PangleNative.this.adFailedToLoad(new TAdErrorCode(filter, "ad filter"));
                AdLogUtil.Log().w(ExistsCheck.PANGLE_TAG, "ad not pass sensitive check or no icon or image filter:" + filter);
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vS
            public void onError(int i12, String str) {
                PangleNative.this.adFailedToLoad(new TAdErrorCode(i12, "Pangle Ads failed to load ad with error message: " + str));
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads failed to load ad with error code：" + i12 + "，message: " + str);
            }
        };
        this.f33420e = new PAGNativeAdInteractionListener() { // from class: com.hisavana.pangle.executer.PangleNative.2
            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdClicked() {
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdClick");
                PangleNative pangleNative = PangleNative.this;
                pangleNative.adClicked(pangleNative.f33422g);
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdDismissed() {
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdDismissed");
                PangleNative.this.adClosed();
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdShowed() {
                AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "Pangle Ads onAdShowed");
                PangleNative pangleNative = PangleNative.this;
                pangleNative.adImpression(pangleNative.f33422g);
            }
        };
    }

    @Override // com.hisavana.common.base.BaseNative, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        this.f33421f = null;
        this.f33419d = null;
        this.f33420e = null;
        this.f33422g = null;
        AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseNative
    protected void initNative() {
        Network network = this.mNetwork;
        if (network == null) {
            adFailedToLoad(new TAdErrorCode(30003, "Pangle Ads failed to load ad error with mNetwork == null"));
        } else {
            ExistsCheck.initAdSource(network.getApplicationId(), new PAGSdk.PAGInitCallback() { // from class: com.hisavana.pangle.executer.PangleNative.3
                @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
                public void fail(int i11, String str) {
                    PangleNative.this.adFailedToLoad(new TAdErrorCode(i11, "Pangle Ads failed to load ad error with : PAGSdk.isInitSuccess() " + PAGSdk.isInitSuccess()));
                    AdLogUtil.Log().d(ExistsCheck.PANGLE_TAG, "init onError code：" + i11 + "，message：" + str);
                }

                @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
                public void success() {
                    if (((BaseAd) PangleNative.this).mNetwork != null && !TextUtils.isEmpty(((BaseAd) PangleNative.this).mNetwork.getCodeSeatId()) && PangleNative.this.f33419d != null) {
                        PAGNativeAd.loadAd(((BaseAd) PangleNative.this).mNetwork.getCodeSeatId(), new PAGNativeRequest(), PangleNative.this.f33419d);
                        return;
                    }
                    PangleNative.this.adFailedToLoad(new TAdErrorCode(30003, "Pangle Ads failed to load ad error with : PAGSdk.isInitSuccess() " + PAGSdk.isInitSuccess()));
                }
            });
        }
    }

    @Override // com.hisavana.common.base.BaseNative
    protected void onNativeAdStartLoad() {
    }

    @Override // com.hisavana.common.interfacz.IadNative
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, AdNativeInfo adNativeInfo) {
        PAGNativeAd pAGNativeAd;
        this.f33422g = adNativeInfo;
        logTrigerShow(adNativeInfo);
        ArrayList arrayList = new ArrayList();
        arrayList.add(viewGroup);
        arrayList.addAll(list);
        ArrayList arrayList2 = new ArrayList();
        for (View view : list) {
            if (view instanceof Button) {
                arrayList2.add(view);
            }
        }
        ImageView imageView = new ImageView(e.a());
        PAGNativeAdInteractionListener pAGNativeAdInteractionListener = this.f33420e;
        if (pAGNativeAdInteractionListener == null || (pAGNativeAd = this.f33421f) == null) {
            return;
        }
        pAGNativeAd.registerViewForInteraction(viewGroup, arrayList, arrayList2, imageView, pAGNativeAdInteractionListener);
        setNativeCloseListener(viewGroup, adNativeInfo);
    }

    @Override // com.hisavana.common.interfacz.IadNative
    public void unregisterView(@NonNull AdNativeInfo adNativeInfo) {
    }
}
