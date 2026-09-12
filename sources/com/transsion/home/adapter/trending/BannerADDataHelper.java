package com.transsion.home.adapter.trending;

import android.widget.ImageView;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.mediation.ad.TMediaView;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.wrapperad.R$id;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes5.dex */
public final class BannerADDataHelper {

    /* renamed from: c, reason: collision with root package name */
    private static BiddingNativeManager f44710c;

    /* renamed from: d, reason: collision with root package name */
    private static Function2 f44711d;

    /* renamed from: e, reason: collision with root package name */
    private static NativeWrapperAdView f44712e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f44713f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f44714g;

    /* renamed from: a, reason: collision with root package name */
    public static final BannerADDataHelper f44708a = new BannerADDataHelper();

    /* renamed from: b, reason: collision with root package name */
    private static int f44709b = 1;

    /* renamed from: h, reason: collision with root package name */
    private static final a f44715h = new a();

    /* renamed from: i, reason: collision with root package name */
    public static final int f44716i = 8;

    /* loaded from: classes5.dex */
    public static final class a extends di.a {
        a() {
        }

        @Override // di.a
        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            a.C0856a.f(lg.a.f68962a, "BannerADDataHelper", "--> onBiddingError() --> p0 = " + (tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null), false, 4, null);
            Function2 function2 = BannerADDataHelper.f44711d;
            if (function2 != null) {
                function2.invoke(null, Integer.valueOf(BannerADDataHelper.f44709b));
            }
            BannerADDataHelper.f44713f = false;
            BannerADDataHelper.f44714g = true;
        }

        @Override // di.a
        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            a.C0856a.f(lg.a.f68962a, "BannerADDataHelper", "--> onBiddingLoad() --> " + biddingIntermediateMaterialBean, false, 4, null);
            Function2 function2 = BannerADDataHelper.f44711d;
            if (function2 != null) {
                function2.invoke(biddingIntermediateMaterialBean, Integer.valueOf(BannerADDataHelper.f44709b));
            }
            BannerADDataHelper.f44713f = false;
            BannerADDataHelper.f44714g = false;
        }

        @Override // di.a
        public void n(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.n(biddingIntermediateMaterialBean);
            BannerADDataHelper.f44714g = true;
        }

        @Override // di.a
        public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.p(biddingIntermediateMaterialBean);
            BannerADDataHelper.f44714g = true;
        }
    }

    private BannerADDataHelper() {
    }

    public final void i(NativeWrapperAdView nativeWrapperAdView, r rVar, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        f44712e = nativeWrapperAdView;
        if (nativeWrapperAdView != null) {
            nativeWrapperAdView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (nativeWrapperAdView != null) {
            nativeWrapperAdView.bindNativeView(f44710c, rVar, biddingIntermediateMaterialBean);
        }
    }

    public final void j() {
        BiddingNativeManager biddingNativeManager = f44710c;
        if (biddingNativeManager != null) {
            biddingNativeManager.V();
        }
        f44710c = null;
    }

    public final void k(Function2 function2) {
        if (f44713f) {
            return;
        }
        f44713f = true;
        f44711d = function2;
        j();
        k.d(o0.a(y0.b()), null, null, new BannerADDataHelper$fetchData$1(null), 3, null);
    }

    public final void l() {
        TMediaView tMediaView;
        NativeWrapperAdView nativeWrapperAdView = f44712e;
        if (nativeWrapperAdView == null || (tMediaView = (TMediaView) nativeWrapperAdView.findViewById(R$id.ad_media)) == null) {
            return;
        }
        tMediaView.performClick();
    }

    public final boolean m() {
        return f44714g;
    }

    public final void n() {
        f44712e = null;
    }
}
