package com.hisavana.mediation.ad;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import be.c;
import be.h;
import be.i;
import be.n;
import ce.b;
import com.cloud.hisavana.sdk.common.bean.SSPWebPageReqInfo;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.sdk.commonutil.util.e;
import com.hisavana.common.bean.NativeAdWrapper;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.tracking.TrackingManager;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import com.hisavana.mediation.config.TAdManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class TNativeAd extends b {
    public int A;
    public int B;
    public SSPWebPageReqInfo C;
    public final List<WeakReference<TAdNativeView>> D;

    public TNativeAd(Context context, String str) {
        super(context, str);
        this.A = 1;
        this.B = 0;
        this.D = new ArrayList();
    }

    @Override // ce.b
    public c a(CloudControlConfig.CodeSeat codeSeat) {
        i d11 = d();
        d11.b(this.A);
        d11.i(this.B);
        d11.d(this.C);
        return new n(codeSeat, d11, this.f17201h);
    }

    public final void a(TAdErrorCode tAdErrorCode, int i11) {
        Bundle bundle = new Bundle();
        bundle.putInt("ad_number", i11);
        bundle.putString(TrackingKey.CLD_APP_ID, TAdManager.getAppId());
        bundle.putString(TrackingKey.CLD_CODE_SEAT_ID, this.f17194a);
        bundle.putLong("ts", System.currentTimeMillis());
        if (tAdErrorCode != null) {
            bundle.putString("error_code", String.valueOf(tAdErrorCode.getErrorCode()));
        }
        TrackingManager.trackGetNativeInfo(bundle);
    }

    @Override // ce.b
    public boolean a(int i11) {
        return i11 == 1 || i11 == 10 || i11 == 6;
    }

    public void bindNativeView(@NonNull TAdNativeView tAdNativeView, @NonNull TAdNativeInfo tAdNativeInfo, @NonNull ViewBinder viewBinder) {
        bindNativeView(tAdNativeView, tAdNativeInfo, viewBinder, "");
    }

    public void bindNativeView(@NonNull TAdNativeView tAdNativeView, @NonNull TAdNativeInfo tAdNativeInfo, @NonNull ViewBinder viewBinder, String str) {
        if (!e.h()) {
            AdLogUtil.Log().e("TNativeAd", "you should init first");
            return;
        }
        a(tAdNativeInfo);
        if (this.f17210q && tAdNativeInfo.isMatchVulgarBrand()) {
            AdLogUtil.Log().e("TNativeAd", "nativeInfo is match vulgar");
            TAdErrorCode tAdErrorCode = TAdErrorCode.ERROR_CODE_SHOW_VULGAR;
            trackingTriggerShowError(tAdErrorCode);
            b(tAdErrorCode);
            return;
        }
        tAdNativeInfo.setSceneToken(str);
        tAdNativeInfo.setSceneId(a(str));
        NativeAdWrapper nativeAdWrapper = tAdNativeInfo.getNativeAdWrapper();
        if (nativeAdWrapper != null && nativeAdWrapper.getAdImpl() != null && nativeAdWrapper.getAdImpl().mBundle != null) {
            nativeAdWrapper.getAdImpl().mBundle.putInt(TrackingKey.FILLING_SOURCE, tAdNativeInfo.getFillSource());
            nativeAdWrapper.getAdImpl().mBundle.putInt(TrackingKey.IS_CONTAIN_VULGAR, this.f17210q ? 1 : 0);
        }
        c g11 = g();
        if (g11 instanceof n) {
            ((n) g11).r0(tAdNativeInfo, this.f17201h);
        }
        tAdNativeView.a(tAdNativeInfo, viewBinder);
        this.D.add(new WeakReference<>(tAdNativeView));
    }

    public final int c(int i11) {
        return i11 == 6 ? Integer.MAX_VALUE : 1;
    }

    @Override // ce.b
    public boolean c() {
        return true;
    }

    @Override // ce.b
    public void clearCurrentAd() {
        super.clearCurrentAd();
    }

    @Override // ce.b
    public void destroy() {
        super.destroy();
        for (WeakReference<TAdNativeView> weakReference : this.D) {
            if (weakReference.get() != null) {
                weakReference.get().release();
            }
        }
        this.D.clear();
    }

    public List<TAdNativeInfo> getNativeAdInfo() {
        try {
            if (this.f17206m) {
                a(TAdErrorCode.ERROR_AD_REQUEST_TIME_OUT, 0);
                return new ArrayList();
            }
            CloudControlConfig.CodeSeat a11 = h.a(this.f17194a);
            setCodeSeatType(a11 == null ? -1 : a11.getCodeSeatType().intValue());
            TAdErrorCode b11 = b(a11);
            if (b11 != null) {
                a(b11, 0);
                return new ArrayList();
            }
            c g11 = g();
            if (g11 != null && a11 != null) {
                ArrayList q02 = ((n) g11).q0(g11.V(), Math.max(1, Math.min(c(a11.getCodeSeatType().intValue()), a11.getAdRequestCount().intValue())), true, this.f17210q);
                if (q02 != null && !q02.isEmpty()) {
                    a((TAdErrorCode) null, q02.size());
                } else if (NetStateManager.checkNetworkState(false)) {
                    a(TAdErrorCode.ERROR_TRIGGER_SHOW_ONLINE_NO_AD, 0);
                } else {
                    a(TAdErrorCode.ERROR_RIGGER_SHOW_OFFLINE_NO_AD, 0);
                }
                return q02;
            }
            return new ArrayList();
        } catch (Exception e11) {
            AdLogUtil.Log().e("TNativeAd", Log.getStackTraceString(e11));
            return new ArrayList();
        }
    }

    public int getNativeInfoSize() {
        try {
            CloudControlConfig.CodeSeat a11 = h.a(this.f17194a);
            if (a11 == null) {
                return 0;
            }
            setCodeSeatType(a11.getCodeSeatType().intValue());
            c g11 = g();
            if (g11 == null) {
                return 0;
            }
            ArrayList q02 = ((n) g11).q0(g11.V(), Math.max(1, Math.min(c(a11.getCodeSeatType().intValue()), a11.getAdRequestCount().intValue())), false, this.f17210q);
            if (q02 == null) {
                return 0;
            }
            return q02.size();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public void setAdMobPosition(int i11) {
        this.A = i11;
    }

    public void setAdmobMediaAspectRatio(int i11) {
        this.B = i11;
    }

    public void setRecommendReqInfo(SSPWebPageReqInfo sSPWebPageReqInfo) {
        this.C = sSPWebPageReqInfo;
    }
}
