package com.hisavana.mediation.ad;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import be.c;
import be.h;
import be.i;
import be.s;
import be.t;
import ce.b;
import com.cloud.sdk.commonutil.util.e;
import com.hisavana.adxlibrary.excuter.AdxWrapperSplash;
import com.hisavana.common.base.BaseSplash;
import com.hisavana.common.bean.AdCache;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.OnSkipListener;
import com.hisavana.common.interfacz.TAdListener;
import com.hisavana.common.interfacz.WrapTAdAllianceListener;
import com.hisavana.common.manager.AdCacheManager;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.MediaLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import com.hisavana.mediation.config.TAdManager;

/* loaded from: classes4.dex */
public class TSplashAd extends b {

    @ComConstants.SplashModeIntDef
    public int A;
    public int B;
    public Float C;
    public String D;
    public boolean E;
    public boolean F;
    public AdxWrapperSplash G;
    public OnSkipListener H;

    public TSplashAd(Context context, String str) {
        super(context);
        this.A = 1;
        this.B = 1;
        this.E = false;
        this.F = false;
        this.f17194a = str;
    }

    public static boolean hasCache(String str) {
        AdCache cache = AdCacheManager.getCache(4);
        int adNum = cache != null ? cache.getAdNum(str) : 0;
        AdLogUtil.Log().d("TSplashAd", "placementId " + str + ",adNum = " + adNum);
        MediaLogUtil.d("TSplashAd", "placementId " + str + ",adNum = " + adNum);
        return adNum > 0;
    }

    @Override // ce.b
    public c a(CloudControlConfig.CodeSeat codeSeat) {
        i d11 = d();
        d11.A(this.B);
        d11.C(this.A);
        return new s(codeSeat, d11, this.f17201h);
    }

    @Override // ce.b
    public boolean a(int i11) {
        return i11 == 4;
    }

    @Override // ce.b
    public boolean c() {
        return false;
    }

    @Override // ce.b
    public void clearCurrentAd() {
        super.clearCurrentAd();
    }

    @Override // ce.b
    public void destroy() {
        if (!this.E) {
            super.destroy();
            return;
        }
        AdxWrapperSplash adxWrapperSplash = this.G;
        if (adxWrapperSplash != null) {
            adxWrapperSplash.destroy();
        }
    }

    @Override // ce.b
    public double getTopPrice(int i11) {
        if (!this.E) {
            return super.getTopPrice(i11);
        }
        AdxWrapperSplash adxWrapperSplash = this.G;
        if (adxWrapperSplash == null) {
            return 0.0d;
        }
        return adxWrapperSplash.getEcpmPrice();
    }

    @Override // ce.b
    public void loadAd() {
        if (!this.E) {
            super.loadAd();
            return;
        }
        e.g(this.f17195b.getApplicationContext());
        AdxWrapperSplash debug = new AdxWrapperSplash(this.f17195b, this.D, this.f17194a).setSplashMode(this.A).setContainVulgarContent(this.f17210q).setAdLoadScenes(this.f17211r, this.f17212s, this.f17213t).setAdditionalListener(this.f17201h.a()).setSkipListener(this.H).setDebug(this.F);
        this.G = debug;
        debug.loadAd();
    }

    @Override // ce.b
    public void pause() {
        super.pause();
    }

    @Override // ce.b
    public void resume() {
        super.resume();
    }

    public void setAdUnitId(String str) {
        this.f17194a = str;
    }

    public void setLogoLayoutHeightRatio(Float f11) {
        if (f11 == null) {
            return;
        }
        if (f11.floatValue() < 0.1f || f11.floatValue() > 0.2f) {
            this.C = Float.valueOf(0.2f);
        } else {
            this.C = f11;
        }
    }

    public void setOnShowListener(TAdListener tAdListener) {
        t tVar = this.f17201h;
        if (tVar != null) {
            tVar.h(tAdListener);
        }
    }

    public void setOnSkipListener(OnSkipListener onSkipListener) {
        t tVar = this.f17201h;
        if (tVar != null) {
            tVar.g(onSkipListener);
        }
        this.H = onSkipListener;
        AdxWrapperSplash adxWrapperSplash = this.G;
        if (adxWrapperSplash != null) {
            adxWrapperSplash.setSkipListener(onSkipListener);
        }
    }

    public void setOnlySourceAdx(String str, boolean z10) {
        this.E = true;
        this.D = str;
        this.F = z10;
    }

    public void setOrientation(int i11) {
        if (i11 != 1 && i11 != 2) {
            throw new IllegalArgumentException("place use SplashAdOrientation.APP_SPLASH_AD_ORIENTATION_PORTRAIT or SplashAdOrientation.APP_SPLASH_AD_ORIENTATION_LANDSCAPE");
        }
        this.B = i11;
        AdLogUtil.Log().d("TSplashAd", "current orientation is " + i11);
    }

    public void setSplashMode(@ComConstants.SplashModeIntDef int i11) {
        this.A = i11;
    }

    public void showAd(@NonNull TSplashView tSplashView) {
        showAd(tSplashView, null, "");
    }

    public void showAd(@NonNull TSplashView tSplashView, View view) {
        showAd(tSplashView, view, "");
    }

    public void showAd(@NonNull TSplashView tSplashView, View view, String str) {
        if (TextUtils.isEmpty(TAdManager.getAppId())) {
            AdLogUtil.Log().e("TSplashAd", "appId is empty");
            return;
        }
        if (!e.h()) {
            AdLogUtil.Log().e("TSplashAd", "you should init first");
            return;
        }
        if (this.E) {
            AdxWrapperSplash adxWrapperSplash = this.G;
            if (adxWrapperSplash != null) {
                adxWrapperSplash.setLogoLayoutHeightRatio(this.C);
                this.G.showAd(tSplashView, view);
                return;
            }
            return;
        }
        n();
        AdLogUtil.Log().d("TSplashAd", "showAd sceneToken " + str);
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
            AdLogUtil.Log().d("TSplashAd", "showAd errorCode " + b11);
            return;
        }
        c g11 = g();
        if (g11 == null) {
            AdLogUtil.Log().w("TSplashAd", "show error,splash handler is null");
            t();
            return;
        }
        Object e11 = g11.e(this.f17210q);
        if (e11 instanceof BaseSplash) {
            BaseSplash baseSplash = (BaseSplash) e11;
            if (baseSplash.canShow()) {
                WrapTAdAllianceListener tAdAllianceListener = baseSplash.getTAdAllianceListener();
                if (tAdAllianceListener != null && tAdAllianceListener.getAdListener() == null) {
                    AdLogUtil.Log().i("TSplashAd", "TSplash setAdListener");
                    tAdAllianceListener.setAdListener(this.f17201h);
                }
                baseSplash.mBundle.putInt(TrackingKey.FILLING_SOURCE, this.mFillSource);
                baseSplash.mBundle.putInt(TrackingKey.IS_CONTAIN_VULGAR, this.f17210q ? 1 : 0);
                baseSplash.setLogoLayoutHeightRatio(this.C);
                baseSplash.addLogoLayout(view);
                setIsShowing(true);
                baseSplash.show(tSplashView, str, a(str));
                return;
            }
        }
        AdLogUtil.Log().w("TSplashAd", "no ad or ad is expired ");
        t();
    }

    public void showAd(@NonNull TSplashView tSplashView, String str) {
        showAd(tSplashView, null, str);
    }
}
