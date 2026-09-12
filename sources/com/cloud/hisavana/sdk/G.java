package com.cloud.hisavana.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.hisavana.abtestkit.ABTestKit;
import com.cloud.hisavana.abtestkit.ABTestKitConfig;
import com.cloud.hisavana.abtestkit.OnInitCompleteListener;
import com.cloud.hisavana.sdk.api.listener.AdCallback;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.util.g;
import com.cloud.hisavana.sdk.data.bean.inapp.DefaultAdDTO;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.BidInfo;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class G implements com.cloud.hisavana.sdk.api.listener.f {

    /* renamed from: a, reason: collision with root package name */
    protected final e f21582a;

    /* renamed from: b, reason: collision with root package name */
    protected final q3 f21583b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f21584c;

    /* renamed from: d, reason: collision with root package name */
    protected BidInfo f21585d;

    /* renamed from: e, reason: collision with root package name */
    protected AdCallback f21586e;

    /* renamed from: f, reason: collision with root package name */
    protected List f21587f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f21589h = false;

    /* renamed from: g, reason: collision with root package name */
    protected J0 f21588g = new J0();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdsDTO f21590a;

        a(AdsDTO adsDTO) {
            this.f21590a = adsDTO;
        }

        @Override // java.lang.Runnable
        public void run() {
            u0.f23073a.a(this.f21590a);
        }
    }

    public G(q3 q3Var) {
        this.f21582a = e.j(q3Var, this);
        this.f21583b = q3Var;
        this.f21584c = q3Var.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D() {
        l.f22691a.a();
        v1.f23105a.c();
        com.cloud.hisavana.sdk.manager.b.f22793a.c();
    }

    private AdsDTO o() {
        List list = this.f21587f;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (AdsDTO) this.f21587f.get(0);
    }

    private int w() {
        if (this.f21583b.f() == null) {
            return 0;
        }
        return this.f21583b.f().getPictureDelayCloseTime();
    }

    private int y() {
        if (this.f21583b.f() == null) {
            return 0;
        }
        return this.f21583b.f().getVideoDelayCloseTime();
    }

    public boolean A() {
        AdsDTO o11 = o();
        return o11 != null && o11.getSource() == 4;
    }

    public boolean B() {
        AdsDTO o11 = o();
        if (o11 != null) {
            return o11.isMatchVulgarBrand();
        }
        return false;
    }

    public boolean C() {
        AdsDTO o11 = o();
        if (o11 != null) {
            return o11.isOfflineAd();
        }
        return false;
    }

    public void E() {
        this.f21582a.n();
        try {
            ABTestKit.init(com.cloud.sdk.commonutil.util.e.a(), new ABTestKitConfig.Builder().setUseTestEnvironment(g7.a.a()).setInitCompleteListener(new OnInitCompleteListener() { // from class: com.cloud.hisavana.sdk.f0
                @Override // com.cloud.hisavana.abtestkit.OnInitCompleteListener
                public final void onInitComplete() {
                    G.D();
                }
            }).build());
        } catch (Exception unused) {
        }
    }

    @Override // com.cloud.hisavana.sdk.api.listener.f
    public void b(TaErrorCode taErrorCode, Bundle bundle) {
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.x(this, taErrorCode, bundle);
        }
    }

    @Override // com.cloud.hisavana.sdk.api.listener.f
    public void c(List list, List list2, Bundle bundle, AdxImpBean adxImpBean) {
        d(list, bundle);
    }

    @Override // com.cloud.hisavana.sdk.api.listener.f
    public void d(List list, Bundle bundle) {
        this.f21587f = list;
        if (list == null || list.isEmpty()) {
            b(TaErrorCode.ERROR_AD_FETCHED_AD_IS_NULL, bundle);
            return;
        }
        if (this.f21584c) {
            i((AdsDTO) list.get(0), bundle);
        } else if (this.f21586e != null) {
            e4.b().d("BaseAd", "code seat id is " + this.f21583b.i() + ": fill success ,fill time is ------》" + bundle.getLong("time_consuming"));
            this.f21586e.q(this, bundle);
        }
        k1.o().n(3);
    }

    public void f() {
        h(o());
    }

    public void g(AdCallback adCallback) {
        this.f21586e = adCallback;
    }

    public void h(AdsDTO adsDTO) {
        if (adsDTO == null || adsDTO.isOfflineAd()) {
            return;
        }
        HSScopeHelper.f23249a.g(new a(adsDTO));
    }

    protected void i(AdsDTO adsDTO, Bundle bundle) {
        if (adsDTO == null) {
            AdCallback adCallback = this.f21586e;
            if (adCallback != null) {
                adCallback.v(TaErrorCode.ERROR_AD_BIDDING_AD_IS_NULL, this, bundle);
                return;
            }
            return;
        }
        BidInfo bidInfo = new BidInfo();
        bidInfo.setPrice(adsDTO.getFirstPrice());
        bidInfo.setCodeSeatId(this.f21583b.i());
        bidInfo.setAdCreativeId(adsDTO.getAdCreativeId());
        bidInfo.setBiddingToken(this.f21583b.n());
        bidInfo.setCurrency(Constants.CURRENCY.USD);
        AdCallback adCallback2 = this.f21586e;
        if (adCallback2 != null) {
            adCallback2.w(bidInfo, this, bundle);
        }
    }

    public void j(BidInfo bidInfo) {
        BidInfo bidInfo2 = this.f21585d;
        if (bidInfo2 == null || bidInfo != bidInfo2) {
            return;
        }
        this.f21584c = false;
        this.f21582a.D(this.f21587f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(boolean z10) {
        this.f21589h = z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int l(AdsDTO adsDTO) {
        DefaultAdDTO k11;
        if (adsDTO == null) {
            return 1114;
        }
        try {
            if (g.b(adsDTO)) {
                return 1101;
            }
            if (adsDTO.isOfflineAd() && adsDTO.getSource() == 3 && g.h(adsDTO, d.f22404a.G(adsDTO))) {
                return 1103;
            }
            int a11 = com.cloud.hisavana.sdk.common.util.d0.a(adsDTO.getPullNewestLive().intValue(), adsDTO.getPsPackageName(), adsDTO.getPackageName());
            if (a11 == 1) {
                return 1105;
            }
            if (a11 == 2) {
                return 1106;
            }
            if (adsDTO.getSource() == 4 && (k11 = e0.f22495a.k(adsDTO.getCodeSeatId(), adsDTO.getAdCreativeId())) != null && !TextUtils.isEmpty(k11.getDisplayedDate()) && TextUtils.equals(k11.getDisplayedDate(), b0.f21765a.d())) {
                if (k11.getDisplayedTimes() >= k11.getShowMaxOfDay()) {
                    return 1103;
                }
            }
            return 0;
        } catch (Exception e11) {
            e4.b().w("BaseAd", "getAdStatusForAdsDTO failed, error=" + e11.getMessage());
            return 0;
        }
    }

    public void m() {
        this.f21586e = null;
        J0 j02 = this.f21588g;
        if (j02 != null) {
            j02.a();
            this.f21588g = null;
        }
        e eVar = this.f21582a;
        if (eVar != null) {
            eVar.E();
        }
        AdsDTO o11 = o();
        if (o11 != null) {
            k4.f22682a.j(o11.getUuid());
        }
    }

    public int n(AdsDTO adsDTO) {
        if (adsDTO == null) {
            return 0;
        }
        int w11 = w();
        int y10 = y();
        e4.b().d("BaseAd", "picDelayTime: " + w11 + ", videoDelayTime: " + y10);
        return adsDTO.isVastTypeAd() ? y10 : w11;
    }

    public q3 p() {
        return this.f21583b;
    }

    public int q() {
        AdsDTO o11 = o();
        if (o11 != null) {
            return o11.getDspType().intValue();
        }
        return 1;
    }

    public int r() {
        int l11 = l(o());
        if (a7.c.p()) {
            e4.b().i("BaseAd", "isReady(), adId=" + v2.d(o()) + ", isReady=" + l11);
        }
        return l11;
    }

    public List s() {
        return this.f21587f;
    }

    public double t() {
        AdsDTO o11 = o();
        if (o11 != null) {
            return o11.getFirstPrice().doubleValue();
        }
        return 0.0d;
    }

    public int u() {
        AdsDTO o11 = o();
        if (o11 != null) {
            return o11.isOfflineAd() ? 1 : 0;
        }
        return -1;
    }

    public J0 v() {
        return this.f21588g;
    }

    public int x() {
        if (this.f21583b.f() == null) {
            return 0;
        }
        return this.f21583b.f().getRetentionEndCardRatio();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean z() {
        return this.f21589h;
    }
}
