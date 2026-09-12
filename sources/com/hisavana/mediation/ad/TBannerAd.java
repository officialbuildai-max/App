package com.hisavana.mediation.ad;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewParent;
import be.a;
import be.c;
import be.i;
import ce.b;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.sdk.commonutil.util.e;
import com.hisavana.common.base.BaseBanner;
import com.hisavana.common.base.WrapTadView;
import com.hisavana.common.bean.AdCache;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.ICacheAd;
import com.hisavana.common.interfacz.WrapTAdAllianceListener;
import com.hisavana.common.manager.AdCacheManager;
import com.hisavana.common.manager.RequestingAdManager;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class TBannerAd extends b {
    public WrapTadView D;
    public boolean F;
    public boolean G;
    public String H;
    public int A = -1;
    public int B = 0;
    public int C = 0;
    public int E = 0;

    public TBannerAd(Context context, WrapTadView wrapTadView) {
        this.f17195b = context;
        if (context != null && e.a() == null) {
            e.i(context);
        }
        b();
        this.D = wrapTadView;
    }

    @Override // ce.b
    public c a(CloudControlConfig.CodeSeat codeSeat) {
        i d11 = d();
        d11.s(this.A);
        d11.u(this.E);
        d11.p(this.B);
        d11.m(this.C);
        d11.q(this.F);
        d11.g(this.G);
        return new a(codeSeat, d11, this.f17201h);
    }

    @Override // ce.b
    public boolean a(int i11) {
        return i11 == 2;
    }

    public void c(int i11) {
        this.A = i11;
    }

    @Override // ce.b
    public boolean c() {
        return true;
    }

    @Override // ce.b
    public void clearCurrentAd() {
        if (this.f17209p) {
            return;
        }
        super.clearCurrentAd();
    }

    public void d(int i11) {
        this.C = i11;
    }

    @Override // ce.b
    public void destroy() {
        super.destroy();
        WrapTadView wrapTadView = this.D;
        if (wrapTadView != null) {
            wrapTadView.removeAllViews();
            ViewParent parent = this.D.getParent();
            if (parent instanceof ViewGroup) {
                try {
                    ((ViewGroup) parent).removeView(this.D);
                } catch (Exception e11) {
                    AdLogUtil.Log().e("TBannerAd", "Failed to remove banner view: " + e11.getMessage());
                }
            }
        }
        this.D = null;
        u();
    }

    public void e(int i11) {
        this.B = i11;
    }

    @Override // ce.b
    public String enterScene(String str, int i11) {
        Preconditions.a();
        String enterScene = super.enterScene(str, i11);
        this.H = enterScene;
        return enterScene;
    }

    @Override // ce.b
    public void q() {
        AdLogUtil.Log().d(ComConstants.AD_FLOW, "show ad if avaliable");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("must call show in main thread");
        }
        if (this.D == null) {
            AdLogUtil.Log().d(ComConstants.AD_FLOW, "TBannerAd --> mBannerView is null");
            return;
        }
        n();
        if (this.f17209p) {
            setIsShowing(false);
            clearCurrentAd();
        }
        this.D.removeAllViews();
        c g11 = g();
        if (g11 != null) {
            try {
                g11.k(this.f17201h);
                BaseBanner baseBanner = (BaseBanner) g11.e(this.f17210q);
                if (baseBanner == null || !baseBanner.canShow()) {
                    t();
                    AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBannerAd --> no ad or ad is expired");
                } else {
                    WrapTAdAllianceListener tAdAllianceListener = baseBanner.getTAdAllianceListener();
                    if (tAdAllianceListener != null && tAdAllianceListener.getAdListener() == null) {
                        AdLogUtil.Log().i("TBannerAd", "TBannerAd setAdListener");
                        tAdAllianceListener.setAdListener(this.f17201h);
                    }
                    baseBanner.mBundle.putInt(TrackingKey.FILLING_SOURCE, this.mFillSource);
                    baseBanner.mBundle.putInt(TrackingKey.IS_CONTAIN_VULGAR, this.f17210q ? 1 : 0);
                    setIsShowing(true);
                    WrapTadView wrapTadView = this.D;
                    String str = this.H;
                    baseBanner.show(wrapTadView, str, a(str));
                }
                u();
            } catch (Throwable th2) {
                AdLogUtil.Log().e(ComConstants.AD_FLOW, "TBannerAd --> exception:" + Log.getStackTraceString(th2));
                t();
            }
        }
    }

    public void setAdUnitId(String str) {
        this.f17194a = str;
    }

    public void setBannerType(int i11) {
        this.E = i11;
    }

    public void setCloseDirectlyWithoutJumping(boolean z10) {
        this.G = z10;
    }

    public void setHideAdCloseView(boolean z10) {
        this.F = z10;
    }

    public final void u() {
        ArrayList caches;
        AdLogUtil.Log().d("TBannerAd", "destroyFoldAd ");
        AdCache cache = AdCacheManager.getCache(e());
        if (cache != null && (caches = cache.getCaches(this.f17194a, Integer.MAX_VALUE, false, this.f17210q)) != null && !caches.isEmpty()) {
            Iterator it = caches.iterator();
            while (it.hasNext()) {
                ICacheAd iCacheAd = (ICacheAd) it.next();
                if ((iCacheAd instanceof BaseBanner) && ((BaseBanner) iCacheAd).destroyFoldAd()) {
                    cache.removeCache(this.f17194a, iCacheAd);
                    AdLogUtil.Log().d("TBannerAd", "destroyFoldAd removeCache " + iCacheAd);
                }
            }
        }
        RequestingAdManager.getInstance().destroyFoldAd(this.f17194a);
    }
}
