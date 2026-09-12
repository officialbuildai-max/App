package com.transsion.ad.bidding.video;

import com.hisavana.common.bean.AdditionalInfo;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini;
import com.transsion.ad.monopoly.model.AdPlans;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import oi.b;

/* loaded from: classes5.dex */
public final class BiddingVideoManager extends AbsAdBidding {

    /* renamed from: w, reason: collision with root package name */
    public static final Companion f42103w = new Companion(null);

    /* renamed from: v, reason: collision with root package name */
    private final ei.c f42104v = new ei.c();

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
            kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new BiddingVideoManager$Companion$preLoadAd$1(sceneId, map, null), 3, null);
        }
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public void S(List biddingPlan, AdPlans adPlans, int i11) {
        Intrinsics.h(biddingPlan, "biddingPlan");
        Intrinsics.h(adPlans, "adPlans");
        q b11 = q.f42121j.b(getMSceneId());
        if (b11 != null) {
            b11.d(getMSceneId());
        }
        AdditionalInfo g11 = b11 != null ? b11.g() : null;
        if (g11 == null) {
            b.a.c(this, 6, "addHiSavanaProvider() --> 激励视频广告同步获取失败 --> additionalInfo == null", null, false, 4, null);
            return;
        }
        if (u0(adPlans)) {
            adPlans.setBidEcpmCent(g11.getECPM());
        }
        biddingPlan.add(new BiddingIntermediateMaterialBean(adPlans.getBidEcpmCent(), adPlans, null, null, null, null, b11, Boolean.FALSE, getMSceneId(), null, null, 103, 1592, null));
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public int a0() {
        return 3;
    }

    @Override // oi.b
    public String getLogTag() {
        return "ad_v";
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public AbsBiddingBuyOutGemini h0() {
        return this.f42104v;
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public boolean r0() {
        Boolean j11;
        q b11 = q.f42121j.b(getMSceneId());
        if (b11 == null || (j11 = b11.j()) == null) {
            return false;
        }
        return j11.booleanValue();
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public void x0(String str) {
        q b11 = q.f42121j.b(getMSceneId());
        if (b11 != null) {
            b11.p(this);
        }
        if (b11 != null) {
            b11.b();
        }
    }
}
