package com.transsion.subroom.activity;

import com.hisavana.common.bean.TAdErrorCode;
import com.therouter.TheRouter;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.interstitial.BiddingInterstitialManager;
import com.transsion.memberapi.IPremiumApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class MainDialogAdManager extends di.a {

    /* renamed from: d, reason: collision with root package name */
    private MainActivity f54633d;

    /* renamed from: e, reason: collision with root package name */
    private BiddingInterstitialManager f54634e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f54635f;

    /* renamed from: g, reason: collision with root package name */
    private final String f54636g = "MainDialogInterstitialScene";

    private final void D(MainActivity mainActivity) {
        ii.b bVar = ii.b.f65371a;
        if (bVar.a(this.f54636g)) {
            if (hi.c.f64590a.a()) {
                ii.b.d(bVar, this.f54636g, false, 2, null);
            } else if (this.f54634e != null) {
                ii.b.d(bVar, this.f54636g, false, 2, null);
            } else {
                this.f54633d = mainActivity;
                kotlinx.coroutines.k.d(androidx.view.v.a(mainActivity), null, null, new MainDialogAdManager$loadAd$1(this, null), 3, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(MainDialogAdManager mainDialogAdManager) {
        mainDialogAdManager.f54635f = true;
        ii.b.g(ii.b.f65371a, mainDialogAdManager.f54636g, null, 2, null);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(MainDialogAdManager mainDialogAdManager) {
        mainDialogAdManager.f54635f = false;
        ii.b.f65371a.e(mainDialogAdManager.f54636g, true);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(MainDialogAdManager mainDialogAdManager, MainActivity mainActivity, Throwable it) {
        Intrinsics.h(it, "it");
        a.C0856a.f(lg.a.f68962a, "premium_discount", "会员促销弹窗展示失败 --> " + it.getMessage() + " --> 继续展示首页广告", false, 4, null);
        mainDialogAdManager.D(mainActivity);
        return Unit.f67184a;
    }

    private final void I() {
        BiddingInterstitialManager biddingInterstitialManager = this.f54634e;
        if (biddingInterstitialManager != null) {
            biddingInterstitialManager.V();
        }
        this.f54634e = null;
        this.f54633d = null;
        this.f54635f = false;
    }

    public final void E(final MainActivity activity) {
        Intrinsics.h(activity, "activity");
        if (this.f54635f) {
            a.C0856a.f(lg.a.f68962a, "premium_discount", "首页弹窗 --> 已有弹窗正在展示", false, 4, null);
            return;
        }
        if (!ii.b.f65371a.a(this.f54636g)) {
            a.C0856a.f(lg.a.f68962a, "premium_discount", "首页弹窗 --> 不满足展示条件", false, 4, null);
            return;
        }
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        if (iPremiumApi != null) {
            iPremiumApi.d(activity, this.f54636g, null, new Function0() { // from class: com.transsion.subroom.activity.y
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit F;
                    F = MainDialogAdManager.F(MainDialogAdManager.this);
                    return F;
                }
            }, new Function0() { // from class: com.transsion.subroom.activity.z
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit G;
                    G = MainDialogAdManager.G(MainDialogAdManager.this);
                    return G;
                }
            }, new Function1() { // from class: com.transsion.subroom.activity.a0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit H;
                    H = MainDialogAdManager.H(MainDialogAdManager.this, activity, (Throwable) obj);
                    return H;
                }
            });
        }
    }

    @Override // di.a
    public void i(TAdErrorCode tAdErrorCode) {
        super.i(tAdErrorCode);
        ii.b.f65371a.e(this.f54636g, false);
        I();
    }

    @Override // di.a
    public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        super.j(biddingIntermediateMaterialBean);
        ii.b bVar = ii.b.f65371a;
        if (bVar.a(this.f54636g)) {
            BiddingInterstitialManager biddingInterstitialManager = this.f54634e;
            if (biddingInterstitialManager != null) {
                AbsAdBidding.R0(biddingInterstitialManager, this.f54633d, biddingIntermediateMaterialBean, false, 4, null);
            }
            this.f54635f = true;
            ii.b.g(bVar, this.f54636g, null, 2, null);
        }
    }

    @Override // di.a
    public void m(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        super.m(biddingIntermediateMaterialBean);
        ii.b.f65371a.e(this.f54636g, true);
        I();
    }

    @Override // di.a
    public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        super.p(biddingIntermediateMaterialBean);
        ii.b.f65371a.e(this.f54636g, false);
        I();
    }
}
