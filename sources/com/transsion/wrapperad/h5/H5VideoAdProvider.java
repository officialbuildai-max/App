package com.transsion.wrapperad.h5;

import android.app.Activity;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.video.BiddingVideoManager;
import com.transsion.wrapperadapi.H5AdStateEnum;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes7.dex */
public final class H5VideoAdProvider {

    /* renamed from: b, reason: collision with root package name */
    private static jy.a f58293b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f58294c;

    /* renamed from: d, reason: collision with root package name */
    private static BiddingVideoManager f58295d;

    /* renamed from: a, reason: collision with root package name */
    public static final H5VideoAdProvider f58292a = new H5VideoAdProvider();

    /* renamed from: e, reason: collision with root package name */
    private static final a f58296e = new a();

    /* loaded from: classes7.dex */
    public static final class a extends di.a {
        a() {
        }

        @Override // di.a
        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            jy.a aVar = H5VideoAdProvider.f58293b;
            if (aVar != null) {
                aVar.onAdStateCallback(H5AdStateEnum.MB_H5_AD_STATE_ON_FAIL.getValue(), tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null);
            }
            H5VideoAdProvider.f58292a.g();
        }

        @Override // di.a
        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            BiddingVideoManager biddingVideoManager;
            super.j(biddingIntermediateMaterialBean);
            Activity b11 = com.blankj.utilcode.util.a.b();
            if (b11 == null || (biddingVideoManager = H5VideoAdProvider.f58295d) == null) {
                return;
            }
            AbsAdBidding.R0(biddingVideoManager, b11, biddingIntermediateMaterialBean, false, 4, null);
        }

        @Override // di.a
        public void m(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.m(biddingIntermediateMaterialBean);
            if (H5VideoAdProvider.f58294c) {
                jy.a aVar = H5VideoAdProvider.f58293b;
                if (aVar != null) {
                    aVar.onAdStateCallback(H5AdStateEnum.MB_H5_AD_STATE_ON_REWARDED.getValue(), "展示成功且有奖励");
                }
            } else {
                jy.a aVar2 = H5VideoAdProvider.f58293b;
                if (aVar2 != null) {
                    aVar2.onAdStateCallback(H5AdStateEnum.MB_H5_AD_STATE_ON_FAIL.getValue(), "展示成功无奖励");
                }
            }
            H5VideoAdProvider.f58292a.g();
        }

        @Override // di.a
        public void o(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.o(biddingIntermediateMaterialBean);
            H5VideoAdProvider.f58294c = true;
        }

        @Override // di.a
        public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.p(biddingIntermediateMaterialBean);
            jy.a aVar = H5VideoAdProvider.f58293b;
            if (aVar != null) {
                aVar.onAdStateCallback(H5AdStateEnum.MB_H5_AD_STATE_ON_FAIL.getValue(), "展示失败");
            }
            H5VideoAdProvider.f58292a.g();
        }
    }

    private H5VideoAdProvider() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        BiddingVideoManager biddingVideoManager = f58295d;
        if (biddingVideoManager != null) {
            biddingVideoManager.V();
        }
        f58295d = null;
    }

    public final void h(String str, jy.a callback) {
        Intrinsics.h(callback, "callback");
        if (f58295d == null) {
            f58295d = new BiddingVideoManager();
        }
        f58293b = callback;
        f58294c = false;
        k.d(o0.a(y0.b()), null, null, new H5VideoAdProvider$h5OpenAd$1(str, null), 3, null);
    }
}
