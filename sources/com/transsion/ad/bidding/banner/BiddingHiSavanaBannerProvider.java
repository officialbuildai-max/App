package com.transsion.ad.bidding.banner;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.bean.TAdRequestBody;
import com.hisavana.mediation.ad.TBannerView;
import com.transsion.ad.bidding.base.x;
import com.transsion.ad.hi.HiSavanaAdManager;
import com.transsion.ad.strategy.d;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class BiddingHiSavanaBannerProvider extends x {

    /* renamed from: d, reason: collision with root package name */
    private String f41839d;

    /* renamed from: e, reason: collision with root package name */
    private Map f41840e;

    /* renamed from: f, reason: collision with root package name */
    private di.a f41841f;

    /* renamed from: g, reason: collision with root package name */
    private Context f41842g;

    /* renamed from: h, reason: collision with root package name */
    private TBannerView f41843h;

    private final Context e() {
        return this.f41842g;
    }

    private final Map f() {
        Map map = this.f41840e;
        return map == null ? MapsKt.h() : map;
    }

    private final di.a g() {
        return this.f41841f;
    }

    private final void i(String str) {
        di.a g11 = g();
        if (g11 != null) {
            g11.onLoadFailure(new TAdErrorCode(103, str), new AdditionalInfo());
        }
    }

    public final void b() {
        TBannerView tBannerView = this.f41843h;
        ViewParent parent = tBannerView != null ? tBannerView.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.f41843h);
        }
        TBannerView tBannerView2 = this.f41843h;
        if (tBannerView2 != null) {
            tBannerView2.destroy();
        }
        this.f41843h = null;
    }

    public final void c(String sceneId) {
        Intrinsics.h(sceneId, "sceneId");
        k.d(o0.a(y0.c()), null, null, new BiddingHiSavanaBannerProvider$enterScene$1(this, sceneId, null), 3, null);
    }

    public final View d() {
        return this.f41843h;
    }

    public final String getSceneId() {
        String str = this.f41839d;
        return str == null ? "" : str;
    }

    public final void h() {
        TBannerView tBannerView;
        if (!HiSavanaAdManager.f42171a.i()) {
            i("HiSavana 广告SDK未初始化");
            return;
        }
        if (com.transsion.ad.scene.c.b(com.transsion.ad.scene.c.f42257a, getSceneId(), false, 2, null)) {
            i("广告位已关闭");
            return;
        }
        if (TextUtils.isEmpty(getSceneId())) {
            i("sceneId is empty");
            return;
        }
        if (e() == null) {
            i("context is null");
            return;
        }
        if (this.f41843h == null) {
            this.f41843h = new TBannerView(e());
            if (d.f42285a.d(f()) && (tBannerView = this.f41843h) != null) {
                tBannerView.setContainVulgarContent(true);
            }
            TBannerView tBannerView2 = this.f41843h;
            if (tBannerView2 != null) {
                tBannerView2.setAdSize(2);
            }
            TBannerView tBannerView3 = this.f41843h;
            if (tBannerView3 != null) {
                tBannerView3.setAdUnitId(com.transsion.ad.scene.a.f42255a.h(this.f41839d));
            }
            TBannerView tBannerView4 = this.f41843h;
            if (tBannerView4 != null) {
                tBannerView4.setHideAdCloseView(true);
            }
            TAdRequestBody build = new TAdRequestBody.AdRequestBodyBuild().setAdditionalListener(this).build();
            TBannerView tBannerView5 = this.f41843h;
            if (tBannerView5 != null) {
                tBannerView5.setRequestBody(build);
            }
        }
        TBannerView tBannerView6 = this.f41843h;
        if (tBannerView6 != null) {
            tBannerView6.loadAd();
        }
    }

    public final void j(Context context) {
        this.f41842g = context;
    }

    public final void k(Map map) {
        this.f41840e = map;
    }

    public final void l(di.a aVar) {
        this.f41841f = aVar;
    }

    public final void m(String str) {
        this.f41839d = str;
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onClick(TAdNativeInfo tAdNativeInfo, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onClick(tAdNativeInfo, additionalInfo);
        di.a g11 = g();
        if (g11 != null) {
            g11.onClick(tAdNativeInfo, additionalInfo);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadFailure(TAdErrorCode tAdErrorCode, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onLoadFailure(tAdErrorCode, additionalInfo);
        di.a g11 = g();
        if (g11 != null) {
            g11.onLoadFailure(tAdErrorCode, additionalInfo);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadSuccess(AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onLoadSuccess(additionalInfo);
        di.a g11 = g();
        if (g11 != null) {
            g11.onLoadSuccess(additionalInfo);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onShow(TAdNativeInfo tAdNativeInfo, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onShow(tAdNativeInfo, additionalInfo);
        di.a g11 = g();
        if (g11 != null) {
            g11.onShow(tAdNativeInfo, additionalInfo);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onShowError(TAdErrorCode tAdErrorCode, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onShowError(tAdErrorCode, additionalInfo);
        di.a g11 = g();
        if (g11 != null) {
            g11.onShowError(tAdErrorCode, additionalInfo);
        }
    }
}
