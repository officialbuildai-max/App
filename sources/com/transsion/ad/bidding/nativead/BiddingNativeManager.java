package com.transsion.ad.bidding.nativead;

import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.mediation.ad.TAdNativeView;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.view.native_ad.BiddingBuyOutNativeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class BiddingNativeManager extends AbsAdBidding {

    /* renamed from: y, reason: collision with root package name */
    public static final Companion f42070y = new Companion(null);

    /* renamed from: v, reason: collision with root package name */
    private Set f42071v = new LinkedHashSet();

    /* renamed from: w, reason: collision with root package name */
    private Set f42072w = new LinkedHashSet();

    /* renamed from: x, reason: collision with root package name */
    private List f42073x = new ArrayList();

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
            i.d(o0.a(y0.b()), null, null, new BiddingNativeManager$Companion$preload$1(sceneId, map, null), 3, null);
        }
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public void S(List biddingPlan, AdPlans adPlans, int i11) {
        Intrinsics.h(biddingPlan, "biddingPlan");
        Intrinsics.h(adPlans, "adPlans");
        BiddingHiSavanaNativeProvider b11 = BiddingHiSavanaNativeProvider.f42037j.b(getMSceneId());
        if (b11 != null) {
            b11.j(getMSceneId());
        }
        TAdNativeInfo k11 = b11 != null ? b11.k() : null;
        if (com.transsion.ad.strategy.d.f42285a.d(g0()) && k11 != null && k11.isMatchVulgarBrand()) {
            k11.release();
            return;
        }
        if (k11 != null) {
            if (u0(adPlans)) {
                adPlans.setBidEcpmCent(Double.valueOf(k11.getEcpmPrice()));
            }
            biddingPlan.add(new BiddingIntermediateMaterialBean(adPlans.getBidEcpmCent(), adPlans, k11, null, null, null, null, Boolean.FALSE, getMSceneId(), null, null, 103, 1656, null));
        }
    }

    public final void S0(BiddingBuyOutNativeView biddingBuyOutNativeView) {
        this.f42072w.add(biddingBuyOutNativeView);
    }

    public final void T0(TAdNativeView tAdNativeView) {
        this.f42071v.add(tAdNativeView);
    }

    public final boolean U0() {
        AdPlanSourceManager adPlanSourceManager = AdPlanSourceManager.f42220a;
        BiddingIntermediateMaterialBean n02 = n0();
        return adPlanSourceManager.e(n02 != null ? n02.getPlans() : null);
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public void V() {
        TAdNativeInfo nativeInfo;
        BiddingHiSavanaNativeProvider b11 = BiddingHiSavanaNativeProvider.f42037j.b(getMSceneId());
        if (b11 != null) {
            b11.x(this);
        }
        BiddingIntermediateMaterialBean n02 = n0();
        if (n02 != null && (nativeInfo = n02.getNativeInfo()) != null) {
            nativeInfo.release();
        }
        Iterator it = this.f42073x.iterator();
        while (it.hasNext()) {
            TAdNativeInfo nativeInfo2 = ((BiddingIntermediateMaterialBean) it.next()).getNativeInfo();
            if (nativeInfo2 != null) {
                nativeInfo2.release();
            }
        }
        for (BiddingBuyOutNativeView biddingBuyOutNativeView : this.f42072w) {
            if (biddingBuyOutNativeView != null) {
                biddingBuyOutNativeView.destroy();
            }
        }
        this.f42072w.clear();
        for (TAdNativeView tAdNativeView : this.f42071v) {
            if (tAdNativeView != null) {
                tAdNativeView.release();
            }
        }
        this.f42071v.clear();
        super.V();
    }

    public final boolean V0() {
        return n0() != null;
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public int a0() {
        return 2;
    }

    @Override // oi.b
    public String getLogTag() {
        return "ad_n";
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public AbsBiddingBuyOutGemini h0() {
        return null;
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding, di.a
    public void k(List list) {
        super.k(list);
        Iterator it = this.f42073x.iterator();
        while (it.hasNext()) {
            TAdNativeInfo nativeInfo = ((BiddingIntermediateMaterialBean) it.next()).getNativeInfo();
            if (nativeInfo != null) {
                nativeInfo.release();
            }
        }
        this.f42073x.clear();
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                this.f42073x.add((BiddingIntermediateMaterialBean) it2.next());
            }
        }
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public boolean r0() {
        BiddingHiSavanaNativeProvider b11 = BiddingHiSavanaNativeProvider.f42037j.b(getMSceneId());
        if (b11 != null) {
            return b11.o();
        }
        return false;
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public void x0(String str) {
        BiddingHiSavanaNativeProvider b11 = BiddingHiSavanaNativeProvider.f42037j.b(getMSceneId());
        if (b11 != null) {
            b11.g(this);
        }
        if (b11 != null) {
            b11.i("addHiSavanaLoad()");
        }
    }
}
