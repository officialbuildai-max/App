package com.transsion.ad.bidding.banner;

import com.hisavana.common.bean.AdditionalInfo;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini;
import com.transsion.ad.monopoly.model.AdPlans;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a extends AbsAdBidding {

    /* renamed from: v, reason: collision with root package name */
    private BiddingHiSavanaBannerProvider f41844v;

    /* renamed from: w, reason: collision with root package name */
    private BiddingBuyOutBannerView f41845w;

    /* renamed from: x, reason: collision with root package name */
    private AdditionalInfo f41846x;

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public void S(List biddingPlan, AdPlans adPlans, int i11) {
        Intrinsics.h(biddingPlan, "biddingPlan");
        Intrinsics.h(adPlans, "adPlans");
        if (this.f41846x != null) {
            if (u0(adPlans)) {
                AdditionalInfo additionalInfo = this.f41846x;
                adPlans.setBidEcpmCent(additionalInfo != null ? additionalInfo.getECPM() : null);
            }
            biddingPlan.add(new BiddingIntermediateMaterialBean(adPlans.getBidEcpmCent(), adPlans, null, null, this.f41844v, null, null, Boolean.FALSE, getMSceneId(), null, null, 103, 1644, null));
        }
    }

    public final void S0() {
        BiddingBuyOutBannerView biddingBuyOutBannerView = this.f41845w;
        if (biddingBuyOutBannerView != null) {
            biddingBuyOutBannerView.showAd();
        }
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public boolean U() {
        return true;
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public void V() {
        super.V();
        BiddingBuyOutBannerView biddingBuyOutBannerView = this.f41845w;
        if (biddingBuyOutBannerView != null) {
            biddingBuyOutBannerView.destroy();
        }
        this.f41845w = null;
        BiddingHiSavanaBannerProvider biddingHiSavanaBannerProvider = this.f41844v;
        if (biddingHiSavanaBannerProvider != null) {
            biddingHiSavanaBannerProvider.b();
        }
        this.f41844v = null;
        this.f41846x = null;
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public int a0() {
        return 1;
    }

    @Override // oi.b
    public String getLogTag() {
        return "ad_b";
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public AbsBiddingBuyOutGemini h0() {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
    
        if (r0 == null) goto L16;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.util.AttributeSet, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean] */
    @Override // com.transsion.ad.bidding.base.AbsAdBidding, di.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j(com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L8
            com.transsion.ad.bidding.banner.BiddingHiSavanaBannerProvider r1 = r9.getHiSavanaBannerProvider()
            goto L9
        L8:
            r1 = r0
        L9:
            if (r1 != 0) goto L46
            android.content.Context r1 = r8.f0()
            if (r1 == 0) goto L32
            com.transsion.ad.bidding.banner.BiddingBuyOutBannerView r2 = new com.transsion.ad.bidding.banner.BiddingBuyOutBannerView
            r3 = 2
            r2.<init>(r1, r0, r3, r0)
            r8.f41845w = r2
            r2.setEcpmObject(r9)
            com.transsion.ad.bidding.banner.BiddingBuyOutBannerView r1 = r8.f41845w
            if (r1 == 0) goto L27
            java.lang.String r2 = r8.getMSceneId()
            r1.setSceneId(r2)
        L27:
            com.transsion.ad.bidding.banner.BiddingBuyOutBannerView r1 = r8.f41845w
            if (r1 == 0) goto L30
            r1.setListener(r8)
            kotlin.Unit r0 = kotlin.Unit.f67184a
        L30:
            if (r0 != 0) goto L3e
        L32:
            r6 = 12
            r7 = 0
            r2 = 6
            java.lang.String r3 = "getContext() is null"
            r4 = 0
            r5 = 0
            r1 = r8
            oi.b.a.c(r1, r2, r3, r4, r5, r6, r7)
        L3e:
            if (r9 == 0) goto L51
            com.transsion.ad.bidding.banner.BiddingBuyOutBannerView r0 = r8.f41845w
            r9.setBannerView(r0)
            goto L51
        L46:
            com.transsion.ad.bidding.banner.BiddingHiSavanaBannerProvider r1 = r8.f41844v
            if (r1 == 0) goto L4e
            android.view.View r0 = r1.d()
        L4e:
            r9.setBannerView(r0)
        L51:
            super.j(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.bidding.banner.a.j(com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean):void");
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding, com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadSuccess(AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onLoadSuccess(additionalInfo);
        this.f41846x = additionalInfo;
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public boolean r0() {
        return false;
    }

    @Override // com.transsion.ad.bidding.base.AbsAdBidding
    public void x0(String str) {
        if (this.f41844v == null) {
            BiddingHiSavanaBannerProvider biddingHiSavanaBannerProvider = new BiddingHiSavanaBannerProvider();
            this.f41844v = biddingHiSavanaBannerProvider;
            biddingHiSavanaBannerProvider.m(getMSceneId());
            BiddingHiSavanaBannerProvider biddingHiSavanaBannerProvider2 = this.f41844v;
            if (biddingHiSavanaBannerProvider2 != null) {
                biddingHiSavanaBannerProvider2.k(g0());
            }
            BiddingHiSavanaBannerProvider biddingHiSavanaBannerProvider3 = this.f41844v;
            if (biddingHiSavanaBannerProvider3 != null) {
                biddingHiSavanaBannerProvider3.j(f0());
            }
            BiddingHiSavanaBannerProvider biddingHiSavanaBannerProvider4 = this.f41844v;
            if (biddingHiSavanaBannerProvider4 != null) {
                biddingHiSavanaBannerProvider4.l(this);
            }
        }
        BiddingHiSavanaBannerProvider biddingHiSavanaBannerProvider5 = this.f41844v;
        if (biddingHiSavanaBannerProvider5 != null) {
            biddingHiSavanaBannerProvider5.h();
        }
        BiddingHiSavanaBannerProvider biddingHiSavanaBannerProvider6 = this.f41844v;
        if (biddingHiSavanaBannerProvider6 != null) {
            biddingHiSavanaBannerProvider6.c(getMSceneId());
        }
    }
}
