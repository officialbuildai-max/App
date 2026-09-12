package com.cloud.hisavana.sdk.api.listener;

import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.hisavana.sdk.G;
import com.cloud.hisavana.sdk.api.adx.TBannerView;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.athena.SSPTrackingHelper;
import com.cloud.hisavana.sdk.common.bean.AdActiveInfo;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.BidInfo;
import com.cloud.hisavana.sdk.e4;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class AdCallback {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(d dVar) {
        if (dVar != null) {
            dVar.onAdClosed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(d dVar, TBannerView tBannerView) {
        if (dVar != null) {
            dVar.onAdClosed(tBannerView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(d dVar, TaNativeInfo taNativeInfo) {
        if (dVar != null) {
            dVar.onAdClosed(taNativeInfo);
        }
    }

    public void A() {
        d d11 = d();
        if (d11 != null) {
            d11.onRewarded();
        }
    }

    public void B() {
        g f11 = f();
        if (f11 != null) {
            f11.onClick();
        }
    }

    public void C() {
        g f11 = f();
        if (f11 != null) {
            f11.a();
        }
    }

    public void D(G g11) {
    }

    public abstract d d();

    public abstract String e();

    public g f() {
        return null;
    }

    public abstract String g();

    public void k(AdsDTO adsDTO) {
        l(adsDTO, null);
    }

    public void l(AdsDTO adsDTO, AdImage adImage) {
        d d11;
        if (adsDTO == null) {
            return;
        }
        String adPackageName = adsDTO.getAdPackageName();
        e4.b().d("ssp", "onAdActivate --> packageName = " + adPackageName);
        if (TextUtils.isEmpty(adPackageName) || (d11 = d()) == null) {
            return;
        }
        AdActiveInfo adActiveInfo = new AdActiveInfo();
        adActiveInfo.setPackageName(adPackageName);
        adActiveInfo.setEcpm(adsDTO.getFirstPrice());
        if (adImage != null) {
            adActiveInfo.setImageUrl(adImage.getImgUrl());
        }
        d11.onAdActivate(adActiveInfo);
    }

    public void m() {
        d d11 = d();
        if (d11 != null) {
            d11.onAdClicked();
        }
    }

    public void n(final TBannerView tBannerView, AdsDTO adsDTO) {
        AthenaTracker.e0(adsDTO);
        final d d11 = d();
        HSScopeHelper.f23249a.h(new Runnable() { // from class: com.cloud.hisavana.sdk.api.listener.b
            @Override // java.lang.Runnable
            public final void run() {
                AdCallback.i(d.this, tBannerView);
            }
        });
    }

    public void o(final TaNativeInfo taNativeInfo, AdsDTO adsDTO) {
        AthenaTracker.e0(adsDTO);
        final d d11 = d();
        HSScopeHelper.f23249a.h(new Runnable() { // from class: com.cloud.hisavana.sdk.api.listener.c
            @Override // java.lang.Runnable
            public final void run() {
                AdCallback.j(d.this, taNativeInfo);
            }
        });
    }

    public void p(AdsDTO adsDTO) {
        AthenaTracker.e0(adsDTO);
        final d d11 = d();
        HSScopeHelper.f23249a.h(new Runnable() { // from class: com.cloud.hisavana.sdk.api.listener.a
            @Override // java.lang.Runnable
            public final void run() {
                AdCallback.h(d.this);
            }
        });
    }

    public void q(G g11, Bundle bundle) {
        d d11 = d();
        try {
            SSPTrackingHelper.f22035a.A(0, g11.p(), g11.s(), bundle.getString("offline_ad_status"), bundle.getString("default_ad_status"), bundle.getInt("cache_offline_ad_count"), bundle.getLong("time_consuming"), d11 == null ? 3 : 1);
        } catch (Throwable unused) {
        }
        if (d11 != null) {
            d11.onAdLoaded();
        }
    }

    public void r(G g11, List list, Bundle bundle) {
        d d11 = d();
        int i11 = d11 == null ? 3 : 1;
        try {
            if (bundle.getInt("s_recommend_req", 0) == 1) {
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    try {
                        if (list.get(0) != null) {
                            arrayList.addAll(((TaNativeInfo) list.get(0)).getRecommendInfos());
                        }
                    } catch (Throwable unused) {
                    }
                }
                SSPTrackingHelper.f22035a.G(g11.p(), arrayList, bundle.getLong("time_consuming"), bundle.getBoolean("s_rec_temp_data", false));
            } else {
                SSPTrackingHelper.f22035a.A(0, g11.p(), g11.s(), bundle.getString("offline_ad_status"), bundle.getString("default_ad_status"), bundle.getInt("cache_offline_ad_count"), bundle.getLong("time_consuming"), i11);
            }
        } catch (Throwable unused2) {
        }
        if (d11 != null) {
            d11.onAdLoaded(list);
        }
    }

    public void s() {
        d d11 = d();
        if (d11 != null) {
            d11.onAdShow();
        }
    }

    public void t(TaErrorCode taErrorCode, G g11) {
        d d11 = d();
        SSPTrackingHelper sSPTrackingHelper = SSPTrackingHelper.f22035a;
        sSPTrackingHelper.M(Integer.valueOf(taErrorCode.getErrorCode()), g(), e(), sSPTrackingHelper.m(g11));
        if (d11 != null) {
            d11.onAdShowError(taErrorCode);
        }
    }

    public void u(TaErrorCode taErrorCode, G g11, Bundle bundle) {
        SSPTrackingHelper sSPTrackingHelper = SSPTrackingHelper.f22035a;
        sSPTrackingHelper.N(Integer.valueOf(taErrorCode.getErrorCode()), g(), e(), sSPTrackingHelper.m(g11), bundle);
    }

    public void v(TaErrorCode taErrorCode, G g11, Bundle bundle) {
        d d11 = d();
        SSPTrackingHelper.f22035a.B(taErrorCode.getErrorCode(), g11.p(), g11.s(), bundle.getString("offline_ad_status"), bundle.getString("default_ad_status"), bundle.getInt("cache_offline_ad_count"), bundle.getLong("time_consuming"), d11 == null ? 3 : 1, true);
        if (d11 != null) {
            d11.onBiddingFailed(taErrorCode);
        }
    }

    public void w(BidInfo bidInfo, G g11, Bundle bundle) {
        d d11 = d();
        try {
            SSPTrackingHelper.f22035a.B(0, g11.p(), g11.s(), bundle.getString("offline_ad_status"), bundle.getString("default_ad_status"), bundle.getInt("cache_offline_ad_count"), bundle.getLong("time_consuming"), d11 == null ? 3 : 1, true);
        } catch (Throwable unused) {
        }
        if (d11 != null) {
            d11.onBiddingSuccess(bidInfo);
        }
    }

    public void x(G g11, TaErrorCode taErrorCode, Bundle bundle) {
        d d11 = d();
        SSPTrackingHelper.f22035a.A(taErrorCode.getErrorCode(), g11.p(), g11.s(), bundle.getString("offline_ad_status"), bundle.getString("default_ad_status"), bundle.getInt("cache_offline_ad_count"), bundle.getLong("time_consuming"), d11 == null ? 3 : 1);
        if (d11 != null) {
            d11.onError(taErrorCode);
        }
    }

    public void y(TaNativeInfo taNativeInfo) {
        d d11 = d();
        if (d11 != null) {
            d11.onNativeAdClick(taNativeInfo);
            l(taNativeInfo.getAdItem(), taNativeInfo.getImage());
        }
    }

    public void z(final TaNativeInfo taNativeInfo) {
        final d d11 = d();
        if (d11 != null) {
            HSScopeHelper.f23249a.h(new Runnable() { // from class: com.cloud.hisavana.sdk.api.listener.AdCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    d11.onNativeAdShow(taNativeInfo);
                }
            });
        }
    }
}
