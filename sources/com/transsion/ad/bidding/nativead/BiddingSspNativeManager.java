package com.transsion.ad.bidding.nativead;

import com.cloud.hisavana.sdk.api.view.TNativeView;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini;
import com.transsion.ad.monopoly.manager.AdPlansStorageManager;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.monopoly.plan.AdPlanUtil;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.ad.view.native_ad.BiddingBuyOutNativeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class BiddingSspNativeManager extends AbsAdBidding {
    public static final Companion A = new Companion(null);

    /* renamed from: y, reason: collision with root package name */
    private boolean f42077y;

    /* renamed from: v, reason: collision with root package name */
    private List f42074v = new ArrayList();

    /* renamed from: w, reason: collision with root package name */
    private Set f42075w = new LinkedHashSet();

    /* renamed from: x, reason: collision with root package name */
    private Set f42076x = new LinkedHashSet();

    /* renamed from: z, reason: collision with root package name */
    private final a f42078z = new a();

    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(Companion companion, String str, Map map, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                map = null;
            }
            companion.a(str, map);
        }

        public final void a(String sceneId, Map map) {
            Intrinsics.h(sceneId, "sceneId");
            k.d(o0.a(y0.b()), null, null, new BiddingSspNativeManager$Companion$preload$1(sceneId, map, null), 3, null);
        }
    }

    /* loaded from: classes5.dex */
    public static final class a extends com.cloud.hisavana.sdk.api.listener.d {
        a() {
        }

        @Override // com.cloud.hisavana.sdk.api.listener.d
        public void onNativeAdClick(TaNativeInfo taNativeInfo) {
            Object obj;
            AdsDTO adItem;
            super.onNativeAdClick(taNativeInfo);
            Iterator it = BiddingSspNativeManager.this.f42074v.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                TaNativeInfo sspNativeInfo = ((BiddingIntermediateMaterialBean) obj).getSspNativeInfo();
                if (Intrinsics.c(sspNativeInfo != null ? sspNativeInfo.getUuid() : null, taNativeInfo != null ? taNativeInfo.getUuid() : null)) {
                    break;
                }
            }
            BiddingIntermediateMaterialBean biddingIntermediateMaterialBean = (BiddingIntermediateMaterialBean) obj;
            if (biddingIntermediateMaterialBean != null) {
                ri.c cVar = ri.c.f74658a;
                String p02 = BiddingSspNativeManager.this.p0();
                String mSceneId = BiddingSspNativeManager.this.getMSceneId();
                AdPlans plans = biddingIntermediateMaterialBean.getPlans();
                String id2 = plans != null ? plans.getId() : null;
                String codeSeatId = (taNativeInfo == null || (adItem = taNativeInfo.getAdItem()) == null) ? null : adItem.getCodeSeatId();
                int a02 = BiddingSspNativeManager.this.a0();
                RecommendInfo c11 = AdPlanUtil.f42221a.c(biddingIntermediateMaterialBean.getPlans());
                Double ecpm = biddingIntermediateMaterialBean.getEcpm();
                String o02 = BiddingSspNativeManager.this.o0();
                AdPlans plans2 = biddingIntermediateMaterialBean.getPlans();
                ri.c.b(cVar, p02, mSceneId, id2, 0, codeSeatId, a02, false, null, c11, ecpm, null, o02, plans2 != null ? plans2.getAdSource() : null, 128, null);
                BiddingSspNativeManager.this.l(biddingIntermediateMaterialBean);
            }
        }

        @Override // com.cloud.hisavana.sdk.api.listener.d
        public void onNativeAdShow(TaNativeInfo taNativeInfo) {
            Object obj;
            AdsDTO adItem;
            super.onNativeAdShow(taNativeInfo);
            Iterator it = BiddingSspNativeManager.this.f42074v.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                TaNativeInfo sspNativeInfo = ((BiddingIntermediateMaterialBean) obj).getSspNativeInfo();
                if (Intrinsics.c(sspNativeInfo != null ? sspNativeInfo.getUuid() : null, taNativeInfo != null ? taNativeInfo.getUuid() : null)) {
                    break;
                }
            }
            BiddingIntermediateMaterialBean biddingIntermediateMaterialBean = (BiddingIntermediateMaterialBean) obj;
            if (biddingIntermediateMaterialBean != null) {
                ri.c cVar = ri.c.f74658a;
                String p02 = BiddingSspNativeManager.this.p0();
                String mSceneId = BiddingSspNativeManager.this.getMSceneId();
                AdPlans plans = biddingIntermediateMaterialBean.getPlans();
                String id2 = plans != null ? plans.getId() : null;
                String codeSeatId = (taNativeInfo == null || (adItem = taNativeInfo.getAdItem()) == null) ? null : adItem.getCodeSeatId();
                int a02 = BiddingSspNativeManager.this.a0();
                RecommendInfo c11 = AdPlanUtil.f42221a.c(biddingIntermediateMaterialBean.getPlans());
                Double ecpm = biddingIntermediateMaterialBean.getEcpm();
                String o02 = BiddingSspNativeManager.this.o0();
                AdPlans plans2 = biddingIntermediateMaterialBean.getPlans();
                ri.c.h(cVar, p02, mSceneId, id2, 0, codeSeatId, a02, false, null, c11, ecpm, null, o02, plans2 != null ? plans2.getAdSource() : null, 128, null);
                BiddingSspNativeManager.this.n(biddingIntermediateMaterialBean);
            }
        }
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public void S(List biddingPlan, AdPlans adPlans, int i11) {
        BiddingHiSspNativeProvider b11;
        AdPlans adPlans2 = adPlans;
        Intrinsics.h(biddingPlan, "biddingPlan");
        Intrinsics.h(adPlans2, "adPlans");
        BiddingHiSspNativeProvider b12 = BiddingHiSspNativeProvider.f42045h.b(getMSceneId());
        List<TaNativeInfo> i12 = b12 != null ? b12.i(com.transsion.ad.scene.a.f42255a.g(getMSceneId()), this.f42077y) : null;
        if (i12 != null) {
            for (TaNativeInfo taNativeInfo : i12) {
                if (u0(adPlans2)) {
                    adPlans2.setBidEcpmCent(Double.valueOf(taNativeInfo.getBidPrice()));
                }
                if (!com.transsion.ad.strategy.d.f42285a.d(g0()) || !taNativeInfo.isMatchVulgarBrand()) {
                    biddingPlan.add(new BiddingIntermediateMaterialBean(adPlans.getBidEcpmCent(), adPlans, null, taNativeInfo, null, null, null, Boolean.FALSE, getMSceneId(), null, null, 103, 1652, null));
                }
                adPlans2 = adPlans;
            }
        }
        this.f42074v.clear();
        this.f42074v.addAll(biddingPlan);
        if (i12 == null || !(!i12.isEmpty()) || (b11 = BiddingHiSspNativeProvider.f42045h.b(getMSceneId())) == null) {
            return;
        }
        b11.h(this.f42078z);
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public void V() {
        super.V();
        BiddingHiSspNativeProvider b11 = BiddingHiSspNativeProvider.f42045h.b(getMSceneId());
        if (b11 != null) {
            b11.r(this.f42078z);
        }
        for (TNativeView tNativeView : this.f42075w) {
            if (tNativeView != null) {
                tNativeView.destroy();
            }
        }
        this.f42075w.clear();
        for (BiddingBuyOutNativeView biddingBuyOutNativeView : this.f42076x) {
            if (biddingBuyOutNativeView != null) {
                biddingBuyOutNativeView.destroy();
            }
        }
        this.f42076x.clear();
        Iterator it = this.f42074v.iterator();
        while (it.hasNext()) {
            TaNativeInfo sspNativeInfo = ((BiddingIntermediateMaterialBean) it.next()).getSspNativeInfo();
            if (sspNativeInfo != null) {
                sspNativeInfo.destroy();
            }
        }
    }

    public final void V0(BiddingBuyOutNativeView biddingBuyOutNativeView) {
        this.f42076x.add(biddingBuyOutNativeView);
    }

    public final void W0(TNativeView tNativeView) {
        this.f42075w.add(tNativeView);
    }

    public final void X0(boolean z10) {
        this.f42077y = z10;
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public int a0() {
        return 2;
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public Object b0(Continuation continuation) {
        return AdPlansStorageManager.f42207a.h(getMSceneId(), g0(), getLogTag(), new AdPlanSourceManager.AdPlanEnum[0], continuation);
    }

    @Override // oi.b
    public String getLogTag() {
        return "ad_n";
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public AbsBiddingBuyOutGemini h0() {
        return null;
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public boolean r0() {
        return false;
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public void x0(String str) {
        BiddingHiSspNativeProvider b11 = BiddingHiSspNativeProvider.f42045h.b(getMSceneId());
        if (b11 != null) {
            b11.n();
        }
    }
}
