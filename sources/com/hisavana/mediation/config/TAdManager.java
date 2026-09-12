package com.hisavana.mediation.config;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import be.o;
import be.v;
import com.cloud.hisavana.sdk.common.util.l0;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.cloud.sdk.commonutil.util.MitNetUtil;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.sdk.commonutil.util.c;
import com.cloud.sdk.commonutil.util.e;
import com.cloud.sdk.commonutil.util.m;
import com.hisavana.common.base.LogSwitch;
import com.hisavana.common.bean.AdMuteStatus;
import com.hisavana.common.bean.AppStartInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.tracking.TrackingManager;
import com.hisavana.common.utils.AdLogUtil;
import com.transsion.ga.AthenaAnalytics;
import j7.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class TAdManager {

    /* renamed from: a, reason: collision with root package name */
    public static AdConfig f33294a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f33295b;

    /* loaded from: classes.dex */
    public static final class AdConfig {

        /* renamed from: a, reason: collision with root package name */
        public boolean f33296a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f33297b;

        /* renamed from: c, reason: collision with root package name */
        public String f33298c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f33299d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f33300e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f33301f = false;

        /* renamed from: g, reason: collision with root package name */
        public String f33302g;

        /* renamed from: h, reason: collision with root package name */
        public List<String> f33303h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f33304i;

        /* renamed from: j, reason: collision with root package name */
        public int f33305j;

        /* renamed from: k, reason: collision with root package name */
        public OnCloudCompleteListener f33306k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f33307l;

        /* renamed from: m, reason: collision with root package name */
        public int f33308m;

        /* renamed from: n, reason: collision with root package name */
        public long f33309n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f33310o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f33311p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f33312q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f33313r;

        /* renamed from: s, reason: collision with root package name */
        public String f33314s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f33315t;

        public AdConfig(AdConfigBuilder adConfigBuilder) {
            this.f33296a = false;
            this.f33297b = false;
            this.f33299d = false;
            this.f33304i = true;
            this.f33307l = false;
            this.f33310o = false;
            this.f33311p = false;
            this.f33312q = false;
            this.f33313r = true;
            this.f33314s = "";
            this.f33315t = false;
            this.f33296a = adConfigBuilder.f33318c;
            this.f33297b = adConfigBuilder.f33319d;
            this.f33298c = adConfigBuilder.f33316a;
            this.f33299d = adConfigBuilder.f33320e;
            this.f33300e = adConfigBuilder.f33331p;
            this.f33302g = adConfigBuilder.f33322g;
            this.f33304i = adConfigBuilder.f33321f;
            this.f33303h = adConfigBuilder.f33323h;
            this.f33305j = adConfigBuilder.f33317b;
            this.f33306k = adConfigBuilder.f33326k;
            this.f33307l = adConfigBuilder.f33327l;
            this.f33308m = adConfigBuilder.f33329n;
            this.f33309n = adConfigBuilder.f33330o;
            this.f33310o = adConfigBuilder.f33332q;
            this.f33311p = adConfigBuilder.f33333r;
            this.f33312q = adConfigBuilder.f33334s;
            this.f33313r = adConfigBuilder.f33335t;
            this.f33314s = adConfigBuilder.f33336u;
            this.f33315t = adConfigBuilder.f33337v;
            AppStartInfo.channel = adConfigBuilder.f33324i;
            AppStartInfo.extInfo = adConfigBuilder.f33325j;
            AdMuteStatus.MUTE_ALL = adConfigBuilder.f33328m;
        }

        public boolean checkEnableRewardedToast() {
            if (TAdManager.f33294a != null) {
                return TAdManager.f33294a.f33311p;
            }
            return true;
        }

        public boolean checkEnableVideoAd() {
            if (TAdManager.f33294a != null) {
                return TAdManager.f33294a.f33313r;
            }
            return true;
        }

        public boolean checkEnableWebRecommendFeature() {
            if (TAdManager.f33294a != null) {
                return TAdManager.f33294a.f33312q;
            }
            return true;
        }

        public int getAppIconId() {
            return this.f33305j;
        }

        public String getAppId() {
            return this.f33298c;
        }

        public List<String> getCodeSeatIds() {
            return this.f33303h;
        }

        public int getDefaultMaterialMaxSize() {
            return this.f33308m;
        }

        public long getDefaultVersion() {
            return this.f33309n;
        }

        public String getPangleAppId() {
            return this.f33314s;
        }

        public boolean getPkgEvn() {
            return this.f33297b;
        }

        public boolean getShouldOptimizeImageLoading() {
            return this.f33310o;
        }

        public boolean isClosePangleWebFileLock() {
            return this.f33315t;
        }

        public boolean isDebug() {
            return this.f33296a;
        }

        public boolean isEnableGDPR() {
            return this.f33300e;
        }

        public boolean isInitAdmob() {
            return this.f33307l;
        }

        public boolean isInitAlliance() {
            return this.f33304i;
        }

        public boolean isLite() {
            return this.f33301f;
        }

        public boolean isTestDevice() {
            return this.f33299d;
        }

        public void releaseCloudListener() {
            this.f33306k = null;
        }

        public void setCodeSeatIds(List<String> list) {
            if (this.f33303h == null) {
                this.f33303h = new ArrayList();
            }
            this.f33303h.clear();
            HashSet hashSet = new HashSet(list);
            list.clear();
            list.addAll(hashSet);
            this.f33303h.addAll(list);
        }
    }

    /* loaded from: classes.dex */
    public static final class AdConfigBuilder {

        /* renamed from: b, reason: collision with root package name */
        public int f33317b;

        /* renamed from: g, reason: collision with root package name */
        public String f33322g;

        /* renamed from: h, reason: collision with root package name */
        public List<String> f33323h;

        /* renamed from: j, reason: collision with root package name */
        public Map<String, String> f33325j;

        /* renamed from: k, reason: collision with root package name */
        public OnCloudCompleteListener f33326k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f33327l;

        /* renamed from: n, reason: collision with root package name */
        public int f33329n;

        /* renamed from: o, reason: collision with root package name */
        public long f33330o;

        /* renamed from: a, reason: collision with root package name */
        public String f33316a = "";

        /* renamed from: c, reason: collision with root package name */
        public boolean f33318c = false;

        /* renamed from: d, reason: collision with root package name */
        public boolean f33319d = false;

        /* renamed from: e, reason: collision with root package name */
        public boolean f33320e = false;

        /* renamed from: f, reason: collision with root package name */
        public boolean f33321f = true;

        /* renamed from: i, reason: collision with root package name */
        public String f33324i = "";

        /* renamed from: m, reason: collision with root package name */
        public boolean f33328m = true;

        /* renamed from: p, reason: collision with root package name */
        public boolean f33331p = true;

        /* renamed from: q, reason: collision with root package name */
        public boolean f33332q = false;

        /* renamed from: r, reason: collision with root package name */
        public boolean f33333r = true;

        /* renamed from: s, reason: collision with root package name */
        public boolean f33334s = false;

        /* renamed from: t, reason: collision with root package name */
        public boolean f33335t = true;

        /* renamed from: u, reason: collision with root package name */
        public String f33336u = "";

        /* renamed from: v, reason: collision with root package name */
        public boolean f33337v = false;

        public AdConfig build() {
            return new AdConfig(this);
        }

        public AdConfigBuilder closePangleWebFileLock(boolean z10) {
            this.f33337v = z10;
            return this;
        }

        public AdConfigBuilder initAlliance(boolean z10) {
            this.f33321f = z10;
            return this;
        }

        public AdConfigBuilder initPangleAdvance(String str) {
            this.f33336u = str;
            return this;
        }

        public AdConfigBuilder isInitAdMob(boolean z10) {
            this.f33327l = z10;
            return this;
        }

        public AdConfigBuilder setAhaChannel(String str) {
            this.f33322g = str;
            return this;
        }

        public AdConfigBuilder setAppIconId(int i11) {
            this.f33317b = i11;
            return this;
        }

        public AdConfigBuilder setAppId(String str) {
            Preconditions.c(str, "appId can not be null");
            this.f33316a = str;
            return this;
        }

        public AdConfigBuilder setChannel(String str) {
            this.f33324i = str;
            return this;
        }

        public AdConfigBuilder setCloudCompleteListener(OnCloudCompleteListener onCloudCompleteListener) {
            this.f33326k = onCloudCompleteListener;
            return this;
        }

        public AdConfigBuilder setCodeSeatIds(List<String> list) {
            this.f33323h = list;
            return this;
        }

        public AdConfigBuilder setCustomParams(Map<String, String> map) {
            if (map != null && !map.isEmpty()) {
                this.f33325j = new HashMap();
                if (map.size() <= 10) {
                    this.f33325j.putAll(map);
                } else {
                    int i11 = 0;
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (i11 >= 10) {
                            break;
                        }
                        if (entry != null) {
                            i11++;
                            this.f33325j.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
            }
            return this;
        }

        public AdConfigBuilder setDebug(boolean z10) {
            this.f33318c = z10;
            this.f33319d = z10;
            return this;
        }

        public AdConfigBuilder setDefaultMaterialCacheSize(int i11) {
            this.f33329n = i11;
            return this;
        }

        public AdConfigBuilder setEnableVideoAd(boolean z10) {
            this.f33335t = z10;
            return this;
        }

        public AdConfigBuilder setEnableWebRecommendFeature(boolean z10) {
            this.f33334s = z10;
            return this;
        }

        public AdConfigBuilder setInternalDefaultAdVersion(long j11) {
            this.f33330o = j11;
            return this;
        }

        public AdConfigBuilder setMuteVideo(boolean z10) {
            this.f33328m = z10;
            AdLogUtil.Log().d("TAdManager", "SDK init , muteAllAd = " + z10);
            return this;
        }

        public AdConfigBuilder setRewardedCompletionToastEnabled(boolean z10) {
            this.f33333r = z10;
            return this;
        }

        public AdConfigBuilder setShouldOptimizeImageLoading(boolean z10) {
            this.f33332q = z10;
            return this;
        }

        public AdConfigBuilder testDevice(boolean z10) {
            this.f33320e = z10;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface OnCloudCompleteListener {
        void onCloudComplete(int i11, String str);
    }

    public static void a(@NonNull AdConfig adConfig) {
        if (f33294a != null) {
            AdLogUtil.Log().w(ComConstants.SDK_INIT, "Already initialized");
            return;
        }
        v.b(adConfig.f33297b);
        if (!adConfig.f33296a) {
            adConfig.f33296a = Log.isLoggable("ADSDK", 3);
        }
        if (!adConfig.f33296a) {
            c.NET_LOG.m().q(Log.isLoggable("AD_NET_LOG", 3));
        }
        AdLogUtil.Log().setLogSwitch(adConfig.f33296a);
        LogSwitch.isDebug = adConfig.f33296a;
        f33294a = adConfig;
        e.j(adConfig.f33296a);
        ComConstants.LITE = false;
        f33294a.f33301f = false;
        b();
        c();
        m.j((Application) e.a().getApplicationContext());
        e();
    }

    public static void b() {
        if (f33294a != null) {
            try {
                AthenaAnalytics.a0(TrackingManager.TID, "mediation" + i7.c.l());
            } catch (Throwable unused) {
            }
            AthenaAnalytics.Q(e.a(), "Mediation", TrackingManager.TID, f33294a.isDebug(), false);
            AthenaAnalytics.D(true);
            AthenaAnalytics.s(ComConstants.HS_APPID, getAppId());
            AthenaAnalytics.s(ComConstants.HS_VER, i7.c.l());
        }
    }

    public static void c() {
        o.a().d(e.a(), f33294a);
    }

    public static void d() {
        boolean z10;
        long currentTimeMillis = System.currentTimeMillis();
        long i11 = a.e().i(ComConstants.APP_ACTIVE_TIME, 0L);
        long i12 = a.e().i(ComConstants.FIRST_START_FOR_ONE_DAY, 0L);
        long c11 = l0.c(currentTimeMillis);
        if (i11 == 0) {
            a.e().q(ComConstants.APP_ACTIVE_TIME, currentTimeMillis);
        } else {
            currentTimeMillis = i11;
        }
        if (i12 != c11) {
            a.e().q(ComConstants.FIRST_START_FOR_ONE_DAY, c11);
            z10 = true;
        } else {
            z10 = false;
        }
        AppStartInfo.activeTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS Z").format(new Date(currentTimeMillis));
        AppStartInfo.isFirstStartToday = z10;
    }

    public static void e() {
        Bundle bundle = new Bundle();
        bundle.putLong(TrackingKey.INIT_TS, System.currentTimeMillis());
        bundle.putString(TrackingKey.CLD_APP_ID, getAppId());
        TrackingManager.trackInit(bundle);
    }

    public static String getAhaChannel() {
        AdConfig adConfig = f33294a;
        if (adConfig != null) {
            return adConfig.f33302g;
        }
        return null;
    }

    public static String getAppId() {
        AdConfig adConfig = f33294a;
        if (adConfig != null) {
            return adConfig.f33298c;
        }
        return null;
    }

    public static OnCloudCompleteListener getCloudCompleteListener() {
        AdConfig adConfig = f33294a;
        if (adConfig != null) {
            return adConfig.f33306k;
        }
        return null;
    }

    public static List<String> getCodeSeatIds() {
        AdConfig adConfig = f33294a;
        if (adConfig == null || adConfig.f33303h == null) {
            return null;
        }
        return new ArrayList(f33294a.f33303h);
    }

    public static synchronized void init(@NonNull final Context context, @NonNull AdConfig adConfig) {
        synchronized (TAdManager.class) {
            AdLogUtil.Log().e(ComConstants.SDK_INIT, "========================== HiSavana SDk init ========================== ");
            if (TextUtils.isEmpty(adConfig.f33298c)) {
                AdLogUtil.Log().e(ComConstants.SDK_INIT, "config or appId is null, please check");
                OnCloudCompleteListener onCloudCompleteListener = adConfig.f33306k;
                if (onCloudCompleteListener != null) {
                    onCloudCompleteListener.onCloudComplete(TAdErrorCode.CODE_INVALID_APP_ID, "Invalid app id");
                }
                return;
            }
            e.g(context);
            d();
            HSScopeHelper.f23249a.g(new Runnable() { // from class: com.hisavana.mediation.config.TAdManager.1
                @Override // java.lang.Runnable
                public void run() {
                    NetStateManager.setIsNetAvailable(MitNetUtil.c(context));
                    CloudControlConfigSync.q();
                }
            });
            a(adConfig);
            f33295b = true;
        }
    }

    public static boolean isDebug() {
        AdConfig adConfig = f33294a;
        if (adConfig != null) {
            return adConfig.f33296a;
        }
        return false;
    }

    public static boolean isTestDevice() {
        AdConfig adConfig = f33294a;
        if (adConfig != null) {
            return adConfig.isTestDevice();
        }
        return false;
    }

    public static void releaseCloudListener() {
        AdConfig adConfig = f33294a;
        if (adConfig != null) {
            adConfig.releaseCloudListener();
        }
    }

    public static void setAgeRestrictedUser(boolean z10) {
        AppStartInfo.ageRestrictedUser = z10;
    }

    public static void setCodeSeatIds(List<String> list) {
        if (list == null || list.size() == 0 || !f33295b) {
            AdLogUtil.Log().e(ComConstants.SDK_INIT, "setCodeSeatIds codeSeatIds is null or empty");
            return;
        }
        AdConfig adConfig = f33294a;
        if (adConfig == null) {
            AdLogUtil.Log().e(ComConstants.SDK_INIT, "setCodeSeatIds u must init first");
        } else {
            adConfig.setCodeSeatIds(list);
            CloudControlConfigSync.b(5);
        }
    }

    public static void setTrackSamplingFraction(int i11) {
        try {
            a7.c.t(i11);
        } catch (Throwable unused) {
        }
    }

    public static void setUserConsent(boolean z10) {
        AppStartInfo.userConsent = z10;
    }
}
