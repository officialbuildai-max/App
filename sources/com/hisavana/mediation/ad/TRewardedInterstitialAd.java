package com.hisavana.mediation.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import be.c;
import be.h;
import be.r;
import ce.b;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.sdk.commonutil.util.e;
import com.hisavana.common.base.BaseVideo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.interfacz.WrapTAdAllianceListener;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.tracking.TrackingManager;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import com.hisavana.mediation.config.TAdManager;

/* loaded from: classes4.dex */
public class TRewardedInterstitialAd extends b {
    public TRewardedInterstitialAd(Context context, String str) {
        super(context, str);
    }

    @Override // ce.b
    public c a(CloudControlConfig.CodeSeat codeSeat) {
        return new r(codeSeat, d(), this.f17201h);
    }

    @Override // ce.b
    public boolean a(int i11) {
        return i11 == 7;
    }

    @Override // ce.b
    public boolean c() {
        return false;
    }

    public void show(Activity activity) {
        show(activity, "");
    }

    public void show(Activity activity, String str) {
        if (TextUtils.isEmpty(TAdManager.getAppId())) {
            AdLogUtil.Log().e("video", "appId is empty");
            return;
        }
        if (!e.h()) {
            AdLogUtil.Log().e("video", "you should init first");
            return;
        }
        n();
        if (this.f17206m) {
            TAdErrorCode tAdErrorCode = TAdErrorCode.ERROR_CURRENT_OBJECT_IS_DESTROYED;
            trackingTriggerShowError(tAdErrorCode);
            b(tAdErrorCode);
            return;
        }
        if (this.f17200g == null) {
            this.f17200g = h.a(this.f17194a);
        }
        TAdErrorCode b11 = b(this.f17200g);
        if (b11 != null) {
            trackingTriggerShowError(b11);
            b(b11);
            return;
        }
        try {
            c g11 = g();
            if (g11 == null) {
                AdLogUtil.Log().w("video", "show error,interstitial rewarded handler is null");
                TAdErrorCode tAdErrorCode2 = TAdErrorCode.ERROR_AD_HANDLER_IS_NULL;
                trackingTriggerShowError(tAdErrorCode2);
                b(tAdErrorCode2);
                return;
            }
            BaseVideo baseVideo = (BaseVideo) g11.e(this.f17210q);
            if (baseVideo == null || !baseVideo.canShow()) {
                AdLogUtil.Log().w("video", "no ad or ad is expired");
                t();
                return;
            }
            WrapTAdAllianceListener tAdAllianceListener = baseVideo.getTAdAllianceListener();
            if (tAdAllianceListener != null && tAdAllianceListener.getAdListener() == null) {
                AdLogUtil.Log().i("video", "TRewardedInterstitial setAdListener");
                tAdAllianceListener.setAdListener(this.f17201h);
            }
            baseVideo.mBundle.putInt(TrackingKey.FILLING_SOURCE, this.mFillSource);
            baseVideo.mBundle.putInt(TrackingKey.IS_CONTAIN_VULGAR, this.f17210q ? 1 : 0);
            setIsShowing(true);
            baseVideo.showVideo(activity, str, a(str));
        } catch (Exception unused) {
            AdLogUtil.Log().e("video", "show exception");
            t();
        }
    }

    public void trackInterstitialRewardGuideClose() {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt(TrackingKey.IS_OFFLINE, !NetStateManager.checkNetworkState(false) ? 1 : 0);
            bundle.putString(TrackingKey.CLD_CODE_SEAT_ID, this.f17194a);
            bundle.putString(TrackingKey.CLD_APP_ID, TAdManager.getAppId());
            bundle.putLong("ts", System.currentTimeMillis());
            TrackingManager.trackInterstitialRewardGuideClose(bundle);
        } catch (Exception unused) {
        }
    }
}
