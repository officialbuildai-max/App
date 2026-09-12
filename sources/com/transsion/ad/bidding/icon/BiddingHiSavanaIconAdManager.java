package com.transsion.ad.bidding.icon;

import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.bean.TAdRequestBody;
import com.hisavana.mediation.ad.TNativeAd;
import com.transsion.ad.bidding.base.x;
import com.transsion.ad.hi.HiSavanaAdManager;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class BiddingHiSavanaIconAdManager extends x {

    /* renamed from: d, reason: collision with root package name */
    private boolean f41982d;

    /* renamed from: e, reason: collision with root package name */
    private TNativeAd f41983e;

    /* renamed from: f, reason: collision with root package name */
    private di.a f41984f;

    /* renamed from: g, reason: collision with root package name */
    private String f41985g;

    private final String getClassTag() {
        String simpleName = BiddingHiSavanaIconAdManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void b() {
        this.f41984f = null;
        TNativeAd tNativeAd = this.f41983e;
        if (tNativeAd != null) {
            tNativeAd.destroy();
        }
        this.f41983e = null;
    }

    public final void c(String sceneId) {
        Intrinsics.h(sceneId, "sceneId");
        k.d(o0.a(y0.c()), null, null, new BiddingHiSavanaIconAdManager$enterScene$1(this, sceneId, null), 3, null);
    }

    public final TNativeAd d() {
        return this.f41983e;
    }

    public final void e() {
        if (!HiSavanaAdManager.f42171a.i()) {
            di.a aVar = this.f41984f;
            if (aVar != null) {
                aVar.onLoadFailure(new TAdErrorCode(103, "广告SDK没有初始化"), new AdditionalInfo());
                return;
            }
            return;
        }
        String h11 = com.transsion.ad.scene.a.f42255a.h(getSceneId());
        if (h11 == null) {
            h11 = "";
        }
        if (TextUtils.isEmpty(h11)) {
            di.a aVar2 = this.f41984f;
            if (aVar2 != null) {
                aVar2.onLoadFailure(new TAdErrorCode(103, "当前场景配置不存在"), new AdditionalInfo());
                return;
            }
            return;
        }
        if (this.f41982d) {
            return;
        }
        this.f41982d = true;
        if (this.f41983e == null) {
            TNativeAd tNativeAd = new TNativeAd(Utils.a(), h11);
            this.f41983e = tNativeAd;
            tNativeAd.setRequestBody(new TAdRequestBody.AdRequestBodyBuild().setAdditionalListener(this).build());
            oi.a.o(oi.a.f71145a, "ad_ic", getClassTag() + " --> loadAd() --> ==================== mPlacementId = " + h11 + " --> create TNativeAd() =================== ", 0, false, 4, null);
        }
        TNativeAd tNativeAd2 = this.f41983e;
        if (tNativeAd2 != null) {
            tNativeAd2.loadAd();
        }
    }

    public final void f(di.a listener) {
        Intrinsics.h(listener, "listener");
        this.f41984f = listener;
    }

    public final void g(String sceneId) {
        Intrinsics.h(sceneId, "sceneId");
        this.f41985g = sceneId;
    }

    public final String getSceneId() {
        return this.f41985g;
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onClick(TAdNativeInfo tAdNativeInfo, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onClick(tAdNativeInfo, additionalInfo);
        di.a aVar = this.f41984f;
        if (aVar != null) {
            aVar.onClick(tAdNativeInfo, additionalInfo);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadFailure(TAdErrorCode tAdErrorCode, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onLoadFailure(tAdErrorCode, additionalInfo);
        di.a aVar = this.f41984f;
        if (aVar != null) {
            aVar.onLoadFailure(tAdErrorCode, additionalInfo);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadSuccess(AdditionalInfo additionalInfo) {
        di.a aVar;
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onLoadSuccess(additionalInfo);
        TNativeAd tNativeAd = this.f41983e;
        List<TAdNativeInfo> nativeAdInfo = tNativeAd != null ? tNativeAd.getNativeAdInfo() : null;
        if (nativeAdInfo == null || (aVar = this.f41984f) == null) {
            return;
        }
        aVar.q(nativeAdInfo);
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onShow(TAdNativeInfo tAdNativeInfo, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onShow(tAdNativeInfo, additionalInfo);
        di.a aVar = this.f41984f;
        if (aVar != null) {
            aVar.onShow(tAdNativeInfo, additionalInfo);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onShowError(TAdErrorCode tAdErrorCode, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onShowError(tAdErrorCode, additionalInfo);
        di.a aVar = this.f41984f;
        if (aVar != null) {
            aVar.onShowError(tAdErrorCode, additionalInfo);
        }
    }
}
