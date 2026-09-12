package com.transsion.wrapperad.h5;

import android.app.Activity;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.interstitial.BiddingInterstitialManager;
import com.transsion.wrapperadapi.H5AdStateEnum;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes7.dex */
public final class H5InterstitialAdProvider {

    /* renamed from: b, reason: collision with root package name */
    private static jy.a f58289b;

    /* renamed from: c, reason: collision with root package name */
    private static BiddingInterstitialManager f58290c;

    /* renamed from: a, reason: collision with root package name */
    public static final H5InterstitialAdProvider f58288a = new H5InterstitialAdProvider();

    /* renamed from: d, reason: collision with root package name */
    private static final a f58291d = new a();

    /* loaded from: classes7.dex */
    public static final class a extends di.a {
        a() {
        }

        @Override // di.a
        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            jy.a aVar = H5InterstitialAdProvider.f58289b;
            if (aVar != null) {
                aVar.onAdStateCallback(H5AdStateEnum.MB_H5_AD_STATE_ON_FAIL.getValue(), tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null);
            }
            H5InterstitialAdProvider.f58288a.e();
        }

        @Override // di.a
        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            BiddingInterstitialManager biddingInterstitialManager;
            super.j(biddingIntermediateMaterialBean);
            Activity b11 = com.blankj.utilcode.util.a.b();
            if (b11 == null || (biddingInterstitialManager = H5InterstitialAdProvider.f58290c) == null) {
                return;
            }
            AbsAdBidding.R0(biddingInterstitialManager, b11, biddingIntermediateMaterialBean, false, 4, null);
        }

        @Override // di.a
        public void m(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.m(biddingIntermediateMaterialBean);
            jy.a aVar = H5InterstitialAdProvider.f58289b;
            if (aVar != null) {
                aVar.onAdStateCallback(H5AdStateEnum.MB_H5_AD_STATE_ON_REWARDED.getValue(), "展示成功");
            }
            H5InterstitialAdProvider.f58288a.e();
        }

        @Override // di.a
        public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.p(biddingIntermediateMaterialBean);
            jy.a aVar = H5InterstitialAdProvider.f58289b;
            if (aVar != null) {
                aVar.onAdStateCallback(H5AdStateEnum.MB_H5_AD_STATE_ON_FAIL.getValue(), "展示失败");
            }
            H5InterstitialAdProvider.f58288a.e();
        }
    }

    private H5InterstitialAdProvider() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        BiddingInterstitialManager biddingInterstitialManager = f58290c;
        if (biddingInterstitialManager != null) {
            biddingInterstitialManager.V();
        }
        f58290c = null;
    }

    public final void f(String str, jy.a callback) {
        Intrinsics.h(callback, "callback");
        if (f58290c == null) {
            f58290c = new BiddingInterstitialManager();
        }
        f58289b = callback;
        k.d(o0.a(y0.b()), null, null, new H5InterstitialAdProvider$h5OpenAd$1(str, null), 3, null);
    }
}
