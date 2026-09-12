package com.hisavana.mintegral.bidding;

import android.content.Context;
import android.os.Looper;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.sdk.commonutil.util.e;
import com.hisavana.common.base.BaseQueryPrice;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.IBidWithNotify;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mintegral.bidding.MintegralBidding;
import com.hisavana.mintegral.check.ExistsCheck;
import com.hisavana.mintegral.check.MBridgeSDKManager;
import com.mbridge.msdk.mbbid.out.BannerBidRequestParams;
import com.mbridge.msdk.mbbid.out.BidListennning;
import com.mbridge.msdk.mbbid.out.BidLossCode;
import com.mbridge.msdk.mbbid.out.BidManager;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.mbridge.msdk.mbbid.out.SplashBidRequestParams;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class MintegralBidding extends BaseQueryPrice {

    /* renamed from: a, reason: collision with root package name */
    private int f33343a;

    /* renamed from: b, reason: collision with root package name */
    int f33344b;

    /* renamed from: c, reason: collision with root package name */
    int f33345c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.hisavana.mintegral.bidding.MintegralBidding$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass2 implements BidListennning {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f33349a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Network f33350b;

        AnonymousClass2(long j11, Network network) {
            this.f33349a = j11;
            this.f33350b = network;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            if (((BaseQueryPrice) MintegralBidding.this).mQueryPriceListener != null) {
                ((BaseQueryPrice) MintegralBidding.this).mQueryPriceListener.onQueryPriceFailed();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Network network) {
            if (((BaseQueryPrice) MintegralBidding.this).mQueryPriceListener != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(network);
                ((BaseQueryPrice) MintegralBidding.this).mQueryPriceListener.onQueryPriceSuccess(arrayList);
            }
        }

        @Override // com.mbridge.msdk.mbbid.out.BidListennning
        public void onFailed(String str) {
            long currentTimeMillis = System.currentTimeMillis() - this.f33349a;
            AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "*---->mintegral bidding request fail --- : " + this.f33350b.getCodeSeatId() + " | " + str + ",time use:" + currentTimeMillis);
            if (this.f33350b == null) {
                return;
            }
            MintegralBidding.this.trackingBiddingFailed(TAdErrorCode.CODE_REQUEST_BIDDING_FAILED, str);
            Preconditions.d(new Preconditions.a() { // from class: com.hisavana.mintegral.bidding.b
                @Override // com.cloud.sdk.commonutil.util.Preconditions.a
                public final void onRun() {
                    MintegralBidding.AnonymousClass2.this.c();
                }
            });
        }

        @Override // com.mbridge.msdk.mbbid.out.BidListennning
        public void onSuccessed(BidResponsed bidResponsed) {
            long currentTimeMillis = System.currentTimeMillis() - this.f33349a;
            if (bidResponsed == null || this.f33350b == null) {
                return;
            }
            Double valueOf = Double.valueOf(0.0d);
            try {
                valueOf = Double.valueOf(Double.parseDouble(bidResponsed.getPrice()) * 100.0d);
            } catch (Exception unused) {
                AdLogUtil.Log().e(ExistsCheck.MINTEGRAL_TAG, "*----> mintegral bidding success ---,price is:" + valueOf + ",id:" + this.f33350b.getCodeSeatId() + ",time use:" + currentTimeMillis);
            }
            MintegralBidding.this.trackingBiddingSuccess(valueOf.doubleValue());
            this.f33350b.setPrice(valueOf);
            this.f33350b.setBidInfo(new BidWithNotify(bidResponsed));
            AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "*----> mintegral bidding success ---,price is:" + valueOf + ",id:" + this.f33350b.getCodeSeatId());
            final Network network = this.f33350b;
            Preconditions.d(new Preconditions.a() { // from class: com.hisavana.mintegral.bidding.a
                @Override // com.cloud.sdk.commonutil.util.Preconditions.a
                public final void onRun() {
                    MintegralBidding.AnonymousClass2.this.d(network);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class BidWithNotify implements IBidWithNotify {

        /* renamed from: a, reason: collision with root package name */
        private final BidResponsed f33352a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f33353b = false;

        /* renamed from: c, reason: collision with root package name */
        private long f33354c = System.currentTimeMillis();

        BidWithNotify(BidResponsed bidResponsed) {
            this.f33352a = bidResponsed;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            this.f33352a.sendLossNotice(e.a(), BidLossCode.bidPriceNotHighest());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            this.f33352a.sendWinNotice(e.a());
            this.f33353b = true;
        }

        @Override // com.hisavana.common.interfacz.IBidWithNotify
        public String getPayload() {
            if (this.f33352a == null) {
                return "";
            }
            AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "mintegral getPayload" + this.f33352a.getBidToken());
            return this.f33352a.getBidToken();
        }

        @Override // com.hisavana.common.interfacz.IBidWithNotify
        public boolean isExpired() {
            return Math.abs(System.currentTimeMillis() - this.f33354c) > ((long) ComConstants.BID_PRICE_CACHE_TIME);
        }

        @Override // com.hisavana.common.interfacz.IBidWithNotify
        public void notifyLoss() {
            if (this.f33353b || this.f33352a == null) {
                return;
            }
            AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "notify mintegral bidding failed");
            if (Looper.myLooper() == Looper.getMainLooper()) {
                HSScopeHelper.f23249a.g(new Runnable() { // from class: com.hisavana.mintegral.bidding.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        MintegralBidding.BidWithNotify.this.c();
                    }
                });
            } else {
                this.f33352a.sendLossNotice(e.a(), BidLossCode.bidPriceNotHighest());
            }
        }

        @Override // com.hisavana.common.interfacz.IBidWithNotify
        public void notifyWin() {
            if (this.f33352a == null) {
                return;
            }
            AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "notify mintegral bidding win");
            if (Looper.myLooper() == Looper.getMainLooper()) {
                HSScopeHelper.f23249a.g(new Runnable() { // from class: com.hisavana.mintegral.bidding.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        MintegralBidding.BidWithNotify.this.d();
                    }
                });
            } else {
                this.f33352a.sendWinNotice(e.a());
                this.f33353b = true;
            }
        }
    }

    private void b() {
        int i11 = this.f33343a;
        if (i11 == 1) {
            this.f33344b = 100;
            this.f33345c = Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE;
        } else if (i11 == 2) {
            this.f33344b = 250;
            this.f33345c = Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE;
        } else if (i11 != 3) {
            this.f33344b = 50;
            this.f33345c = Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE;
        } else {
            this.f33344b = 90;
            this.f33345c = Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE;
        }
    }

    @Override // com.hisavana.common.base.BaseQueryPrice
    public void destroy() {
        this.mQueryPriceListener = null;
    }

    @Override // com.hisavana.common.base.BaseQueryPrice
    public void queryPrice(Context context, final Network network) {
        if (network == null || context == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        ExistsCheck.initAdSource(network.getApplicationId(), network.getApplicationKey(), new MBridgeSDKManager.MBridgeSDKInitializeListener() { // from class: com.hisavana.mintegral.bidding.MintegralBidding.1
            @Override // com.hisavana.mintegral.check.MBridgeSDKManager.MBridgeSDKInitializeListener
            public void onInitializeFailure(String str) {
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "init onError message：" + str);
            }

            @Override // com.hisavana.mintegral.check.MBridgeSDKManager.MBridgeSDKInitializeListener
            public void onInitializeSuccess(String str, String str2) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "onInitializeSuccess，init time " + currentTimeMillis2);
                MintegralBidding.this.startQueryPrice(network);
            }
        });
    }

    @Override // com.hisavana.common.base.BaseQueryPrice
    public void setBannerSize(int i11) {
        this.f33343a = i11;
    }

    public void startQueryPrice(Network network) {
        BidManager bidManager;
        if (network == null) {
            return;
        }
        int adt = network.getAdt();
        if (adt == 2) {
            b();
            bidManager = new BidManager(new BannerBidRequestParams("", network.getCodeSeatId(), this.f33345c, this.f33344b));
        } else if (adt != 4) {
            bidManager = new BidManager("", network.getCodeSeatId());
        } else {
            AdLogUtil.Log().d(ExistsCheck.MINTEGRAL_TAG, "*---->mintegral bidding getOrientation() --- :" + getOrientation());
            bidManager = new BidManager(new SplashBidRequestParams("", network.getCodeSeatId(), true, getOrientation(), 30, 30));
        }
        long currentTimeMillis = System.currentTimeMillis();
        trackingBiddingStart();
        bidManager.setBidListener(new AnonymousClass2(currentTimeMillis, network));
        bidManager.bid();
    }
}
