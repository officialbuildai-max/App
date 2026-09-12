package ce;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import be.h;
import be.i;
import be.m;
import be.t;
import com.cloud.hisavana.sdk.common.util.l0;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.sdk.commonutil.util.e;
import com.hisavana.common.base.BaseAd;
import com.hisavana.common.bean.AdCache;
import com.hisavana.common.bean.AdNativeInfo;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.NativeAdWrapper;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.bean.TAdRequestBody;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.interfacz.ICacheAd;
import com.hisavana.common.manager.AdCacheManager;
import com.hisavana.common.mock.RecordTestInfo;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.tracking.TrackingManager;
import com.hisavana.common.tracking.TrackingUtil;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.hisavana.common.utils.MediaLogUtil;
import com.hisavana.common.utils.RunTimer;
import com.hisavana.mediation.bean.CloudControlConfig;
import com.hisavana.mediation.config.CloudControlConfigSync;
import com.hisavana.mediation.config.TAdManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public String f17194a;

    /* renamed from: b, reason: collision with root package name */
    public Context f17195b;

    /* renamed from: c, reason: collision with root package name */
    public RunTimer f17196c;

    /* renamed from: d, reason: collision with root package name */
    public be.c f17197d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f17198e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f17199f;

    /* renamed from: g, reason: collision with root package name */
    public CloudControlConfig.CodeSeat f17200g;

    /* renamed from: h, reason: collision with root package name */
    public t f17201h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f17202i;

    /* renamed from: j, reason: collision with root package name */
    public int f17203j;

    /* renamed from: k, reason: collision with root package name */
    public int f17204k;

    /* renamed from: l, reason: collision with root package name */
    public long f17205l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f17206m;
    public int mFillSource;

    /* renamed from: n, reason: collision with root package name */
    public final LinkedHashMap<String, String> f17207n;

    /* renamed from: o, reason: collision with root package name */
    public int f17208o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f17209p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f17210q;

    /* renamed from: r, reason: collision with root package name */
    public String f17211r;

    /* renamed from: s, reason: collision with root package name */
    public String f17212s;

    /* renamed from: t, reason: collision with root package name */
    public Map<String, Object> f17213t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f17214u;

    /* renamed from: v, reason: collision with root package name */
    public int f17215v;

    /* renamed from: w, reason: collision with root package name */
    public RunTimer.TimeOutCallback f17216w;

    /* renamed from: x, reason: collision with root package name */
    public String f17217x;

    /* renamed from: y, reason: collision with root package name */
    public long f17218y;

    /* renamed from: z, reason: collision with root package name */
    public Bundle f17219z;

    /* loaded from: classes4.dex */
    public class a implements RunTimer.TimeOutCallback {
        public a() {
        }

        @Override // com.hisavana.common.utils.RunTimer.TimeOutCallback
        public void isTimeOut() {
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> Load ad is time out ");
            b.this.clearCurrentAd();
            t tVar = b.this.f17201h;
            if (tVar != null) {
                tVar.onError(TAdErrorCode.ERROR_FILL_FAILED_WITH_MEDIATION_TIME_OUT);
            }
        }
    }

    /* renamed from: ce.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0173b implements Preconditions.a {
        public C0173b() {
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            b.this.o();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Preconditions.a {
        public c() {
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            b.this.s();
        }
    }

    public b() {
        this.f17194a = "";
        this.f17195b = null;
        this.f17198e = false;
        this.f17199f = false;
        this.f17203j = 60000;
        this.f17204k = 0;
        this.f17205l = 0L;
        this.f17206m = false;
        this.f17207n = new LinkedHashMap<>();
        this.f17215v = 1;
        this.f17216w = new a();
    }

    public b(Context context) {
        this.f17194a = "";
        this.f17195b = null;
        this.f17198e = false;
        this.f17199f = false;
        this.f17203j = 60000;
        this.f17204k = 0;
        this.f17205l = 0L;
        this.f17206m = false;
        this.f17207n = new LinkedHashMap<>();
        this.f17215v = 1;
        this.f17216w = new a();
        this.f17195b = context.getApplicationContext();
        if (e.a() == null) {
            e.i(context);
        }
        b();
    }

    public b(Context context, String str) {
        this.f17194a = "";
        this.f17195b = null;
        this.f17198e = false;
        this.f17199f = false;
        this.f17203j = 60000;
        this.f17204k = 0;
        this.f17205l = 0L;
        this.f17206m = false;
        this.f17207n = new LinkedHashMap<>();
        this.f17215v = 1;
        this.f17216w = new a();
        this.f17194a = str;
        this.f17195b = context.getApplicationContext();
        if (e.a() == null) {
            e.i(context);
        }
        b();
    }

    public abstract be.c a(CloudControlConfig.CodeSeat codeSeat);

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f17207n.get(str);
    }

    public final void a() {
        if (this.f17219z == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(TrackingKey.REQUEST_TYPE, 1);
        bundle.putString(TrackingKey.TRIGGER_ID, this.f17219z.getString(TrackingKey.TRIGGER_ID));
        bundle.putLong(TrackingKey.TRIGGER_TS, this.f17219z.getLong(TrackingKey.TRIGGER_TS));
        bundle.putInt("ad_type", this.f17219z.getInt("ad_type"));
        bundle.putString(TrackingKey.CLD_APP_ID, this.f17219z.getString(TrackingKey.CLD_APP_ID));
        bundle.putString(TrackingKey.CLD_CODE_SEAT_ID, this.f17219z.getString(TrackingKey.CLD_CODE_SEAT_ID));
        bundle.putString("app_id", this.f17219z.getString("app_id"));
        bundle.putString(TrackingKey.CODE_SEAT_ID, this.f17219z.getString(TrackingKey.CODE_SEAT_ID));
        bundle.putInt(TrackingKey.IS_RETREATAD, this.f17219z.getInt(TrackingKey.IS_RETREATAD));
        bundle.putString(TrackingKey.CLD_CONFIGURE_ID, j7.a.e().j("cloudControlVersion"));
        bundle.putInt(TrackingKey.IS_PRELOAD, this.f17219z.getInt(TrackingKey.IS_PRELOAD));
        bundle.putString(TrackingKey.TRAFFIC_GROUP_ID, this.f17219z.getString(TrackingKey.TRAFFIC_GROUP_ID));
        bundle.putString(TrackingKey.EXPERIMENT_GROUP_ID, this.f17219z.getString(TrackingKey.EXPERIMENT_GROUP_ID));
        TrackingManager.trackingAdCancel(bundle);
    }

    public final void a(Bundle bundle, double d11) {
        ArrayList caches;
        NativeAdWrapper nativeAdWrapper;
        StringBuilder sb2 = new StringBuilder();
        be.c cVar = this.f17197d;
        String str = "";
        int i11 = 0;
        if (cVar != null && (caches = cVar.G().getCaches(this.f17194a, 100, false, this.f17210q)) != null) {
            Iterator it = caches.iterator();
            int i12 = 0;
            while (it.hasNext()) {
                ICacheAd iCacheAd = (ICacheAd) it.next();
                if (iCacheAd.getEcpmPrice() < d11) {
                    i12++;
                    if (iCacheAd.getAdSource() == 0) {
                        if (iCacheAd instanceof BaseAd) {
                            sb2.append(((BaseAd) iCacheAd).mBundle.get(TrackingKey.REQUEST_ID));
                        } else if ((iCacheAd instanceof AdNativeInfo) && (nativeAdWrapper = ((AdNativeInfo) iCacheAd).getNativeAdWrapper()) != null && nativeAdWrapper.getAdImpl() != null) {
                            sb2.append(nativeAdWrapper.getAdImpl().mBundle.get(TrackingKey.REQUEST_ID));
                        }
                        sb2.append(",");
                    }
                }
            }
            if (sb2.toString().length() > 1) {
                str = sb2.substring(0, sb2.length() - 1);
                AdLogUtil.Log().d("TBaseAd", "bidding_platform_str" + str);
            }
            i11 = i12;
        }
        if (bundle != null) {
            bundle.putString(TrackingKey.BIDDING_FAIL_PLATFORM, str);
            bundle.putInt(TrackingKey.VALID_CACHE_MATERIAL_CNT, i11);
        }
    }

    public void a(TAdErrorCode tAdErrorCode) {
        t tVar = this.f17201h;
        if (tVar != null) {
            tVar.onError(tAdErrorCode);
        }
    }

    public void a(TAdNativeInfo tAdNativeInfo) {
        Network network;
        if (this.f17201h == null) {
            return;
        }
        AdditionalInfo f11 = f();
        if (tAdNativeInfo != null) {
            network = tAdNativeInfo.getNetwork();
            f11.setMediatorSource(tAdNativeInfo.getMediatorSourceName());
        } else {
            ICacheAd i11 = i();
            Network network2 = i11 == null ? null : i11.getNetwork();
            f11.setMediatorSource(i11 != null ? i11.getMediatorSourceName() : null);
            network = network2;
        }
        if (network != null) {
            f11.setSource(network.getSource());
            f11.setApplicationId(network.getApplicationId());
            f11.setApplicationKey(network.getApplicationKey());
            f11.setCodeSeatId(network.getCodeSeatId());
        }
        this.f17201h.s(f11);
    }

    public final void a(String str, String str2, int i11) {
        Bundle bundle = new Bundle();
        bundle.putString("scene_id", str2);
        bundle.putString(TrackingKey.SCENE_TOKEN, str);
        bundle.putInt(TrackingKey.IS_OFFLINE, !NetStateManager.checkNetworkState(false) ? 1 : 0);
        if (this.f17200g == null) {
            this.f17200g = h.a(this.f17194a);
        }
        CloudControlConfig.CodeSeat codeSeat = this.f17200g;
        if (codeSeat == null) {
            bundle.putInt(TrackingKey.CACHE_STATUS, 1);
        } else {
            AdCache cache = AdCacheManager.getCache(codeSeat.getCodeSeatType().intValue());
            if (cache != null) {
                if (cache.hasAds(this.f17194a, this.f17210q)) {
                    bundle.putInt(TrackingKey.CACHE_STATUS, 0);
                } else {
                    bundle.putInt(TrackingKey.CACHE_STATUS, this.f17198e ? 2 : 1);
                }
            }
        }
        bundle.putString(TrackingKey.CLD_CODE_SEAT_ID, this.f17194a);
        bundle.putString(TrackingKey.CLD_APP_ID, TAdManager.getAppId());
        bundle.putLong("ts", System.currentTimeMillis());
        bundle.putInt(TrackingKey.AD_COUNT, i11);
        TrackingManager.trackEnterScene(bundle);
    }

    public final void a(boolean z10, int i11) {
        a(z10, i11, 0);
    }

    public final void a(boolean z10, int i11, int i12) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f17205l < 1000) {
            AdLogUtil.Log().e("TBaseAd", "isReady interval time is not fit");
            return;
        }
        this.f17205l = currentTimeMillis;
        Bundle bundle = new Bundle();
        if (z10) {
            i11 = this.f17199f ? 1 : 2;
        }
        bundle.putInt("is_ready_status", i11);
        if (!z10 && i12 != 0) {
            try {
                bundle.putInt(TrackingKey.AD_EXPIRE_REASON, i12);
            } catch (Throwable th2) {
                AdLogUtil.Log().e("TBaseAd", Log.getStackTraceString(th2));
                return;
            }
        }
        bundle.putString(TrackingKey.CLD_CODE_SEAT_ID, this.f17194a);
        bundle.putString(TrackingKey.CLD_APP_ID, TAdManager.getAppId());
        bundle.putLong("ts", System.currentTimeMillis());
        TrackingManager.trackIsReady(bundle);
    }

    public abstract boolean a(int i11);

    public TAdErrorCode b(CloudControlConfig.CodeSeat codeSeat) {
        if (codeSeat == null) {
            return TAdErrorCode.ERROR_AD_UNIT_CONFIG_EMPTY;
        }
        if (TAdManager.isDebug()) {
            String str = "cloudControlEnable=" + codeSeat.getCloudControlEnable() + "\ncodeSeatId=" + codeSeat.getCodeSeatId() + "\ncodeSeatType=" + codeSeat.getCodeSeatType() + "\nadShowCountLimitDay=" + codeSeat.getAdShowCountLimitDay() + "\nadShowCountLimitDay=" + codeSeat.getAdShowCountLimitDay() + "\nadShowCountLimitHour=" + codeSeat.getAdShowCountLimitHour() + "\nadShowTimeInterval=" + codeSeat.getAdShowTimeInterval() + "\ncurrentShowInterval=" + (System.currentTimeMillis() - codeSeat.getLastShowTime()) + "\n";
            AdLogUtil.Log().i(ComConstants.AD_FLOW, "inspection info is: \n" + str);
        }
        if (!codeSeat.getCloudControlEnable().booleanValue()) {
            return TAdErrorCode.ERROR_CLOUD_AD_SEAT_IS_CLOSED;
        }
        this.f17208o = codeSeat.getCodeSeatType().intValue();
        if (!a(codeSeat.getCodeSeatType().intValue())) {
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> code seat type does not match request type");
            MediaLogUtil.e("TBaseAd", "code seat type does not match request type ---> " + codeSeat.getCodeSeatType());
            return TAdErrorCode.ERROR_AD_TYPE_LOAD_INCONSISTENCY;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long c11 = l0.c(currentTimeMillis);
        long b11 = l0.b(currentTimeMillis);
        if (codeSeat.getAdShowCountLimitDay().intValue() == 0 || (codeSeat.getAdShowCountLimitDay().intValue() != -1 && c11 == codeSeat.getTodayZeroClock() && codeSeat.getTodayShowTimes() >= codeSeat.getAdShowCountLimitDay().intValue())) {
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> ad show times can not exceed day show max");
            MediaLogUtil.e("TBaseAd", "ad show times reach the limit of day,day showTimes " + codeSeat.getAdShowCountLimitDay());
            return TAdErrorCode.ERROR_AD_SHOW_TIMES_OUT_OF_DAY;
        }
        if (codeSeat.getAdShowCountLimitHour().intValue() == 0 || (codeSeat.getAdShowCountLimitHour().intValue() != -1 && b11 == codeSeat.getCurrentHourZeroClock() && codeSeat.getCurrentHourShowTimes() >= codeSeat.getAdShowCountLimitHour().intValue())) {
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> ad display has reached the limit of hours");
            MediaLogUtil.e("TBaseAd", "ad display has reached the limit of hour,hour showTimes " + codeSeat.getAdShowCountLimitHour());
            return TAdErrorCode.ERROR_AD_SHOW_TIMES_OUT_OF_HOUR;
        }
        long lastShowTime = currentTimeMillis - codeSeat.getLastShowTime();
        if (lastShowTime <= 0) {
            lastShowTime = -lastShowTime;
        }
        if (codeSeat.getAdShowTimeInterval().intValue() == -1000 || lastShowTime > codeSeat.getAdShowTimeInterval().intValue()) {
            return null;
        }
        AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> ad display did not reach the interval");
        MediaLogUtil.e("TBaseAd", "ad display did not reach the interval,time " + codeSeat.getAdShowTimeInterval());
        return TAdErrorCode.ERROR_AD_SHOW_NOT_IN_INTERVAL;
    }

    public void b() {
        if (this.f17201h == null) {
            this.f17201h = new t(this);
        }
    }

    public final void b(int i11) {
        if (!e.h()) {
            AdLogUtil.Log().e("TBaseAd", "you should init first");
            return;
        }
        com.cloud.hisavana.sdk.manager.b.f22793a.d();
        this.f17202i = false;
        this.f17215v = i11;
        Preconditions.d(new Preconditions.a() { // from class: ce.a
            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public final void onRun() {
                b.this.k();
            }
        });
    }

    public void b(TAdErrorCode tAdErrorCode) {
        t tVar = this.f17201h;
        if (tVar != null) {
            tVar.onShowError(tAdErrorCode);
        }
    }

    public final void b(boolean z10, int i11) {
        int[] validAndInvalidAdNum;
        this.f17217x = TrackingUtil.getTriggerId();
        Bundle bundle = new Bundle();
        this.f17219z = bundle;
        bundle.putString(TrackingKey.TRIGGER_ID, this.f17217x);
        long currentTimeMillis = System.currentTimeMillis();
        this.f17218y = currentTimeMillis;
        this.f17219z.putLong(TrackingKey.TRIGGER_TS, currentTimeMillis);
        CloudControlConfig.CodeSeat codeSeat = this.f17200g;
        if (codeSeat != null) {
            this.f17219z.putInt("ad_type", codeSeat.getCodeSeatType().intValue());
            AdCache cache = AdCacheManager.getCache(this.f17200g.getCodeSeatType().intValue());
            if (cache != null && (validAndInvalidAdNum = cache.getValidAndInvalidAdNum(this.f17194a)) != null && validAndInvalidAdNum.length >= 2) {
                int i12 = validAndInvalidAdNum[0];
                int i13 = validAndInvalidAdNum[1];
                this.f17219z.putInt(TrackingKey.CACHE_VALID_ADS, i12);
                this.f17219z.putInt(TrackingKey.CACHE_EXPIRE_ADS, i13);
            }
            this.f17219z.putInt(TrackingKey.MULTI_COUNT, this.f17200g.getAdRequestConcurrentCount().intValue());
            this.f17219z.putInt(TrackingKey.BIDDING_DURATION, (this.f17215v == 2 ? this.f17200g.getRealtimeBiddingWaitTime() : this.f17200g.getBiddingWaitTime()).intValue());
            this.f17219z.putString(TrackingKey.TRAFFIC_GROUP_ID, this.f17200g.getTrafficGroupId());
            this.f17219z.putString(TrackingKey.EXPERIMENT_GROUP_ID, this.f17200g.getExperimentGroupId());
            this.f17219z.putInt(TrackingKey.REQUEST_NUM, this.f17200g.getCodeSeatType().intValue() == 6 ? this.f17200g.getAdRequestCount().intValue() : 1);
        }
        this.f17219z.putString("app_id", TAdManager.getAppId());
        this.f17219z.putString(TrackingKey.CODE_SEAT_ID, this.f17194a);
        this.f17219z.putInt(TrackingKey.IS_PRE_TRIGGER, z10 ? 1 : 0);
        this.f17219z.putString(TrackingKey.CLD_APP_ID, TAdManager.getAppId());
        this.f17219z.putString(TrackingKey.CLD_CODE_SEAT_ID, this.f17194a);
        this.f17219z.putInt(TrackingKey.AD_TRIGGER_STATUS, i11);
        this.f17219z.putInt(TrackingKey.PRIORITY_CODE, this.f17204k);
        this.f17219z.putInt(TrackingKey.IS_CONTAIN_VULGAR, this.f17210q ? 1 : 0);
        this.f17219z.putInt(TrackingKey.TRIGGER_MODE, this.f17215v);
        TrackingManager.trackingADTrigger(this.f17219z);
    }

    public int c(CloudControlConfig.CodeSeat codeSeat) {
        int i11 = 0;
        if (codeSeat == null) {
            return 0;
        }
        int intValue = codeSeat.getAdxShowRate().intValue();
        int intValue2 = codeSeat.getEwShowRate().intValue();
        Random random = new Random(System.currentTimeMillis());
        int abs = Math.abs(random.nextInt() % 100);
        int abs2 = Math.abs(random.nextInt() % 100);
        if (abs < intValue && abs2 < intValue2) {
            i11 = 3;
        } else if (abs < intValue) {
            i11 = 1;
        } else if (abs2 < intValue2) {
            i11 = 2;
        }
        AdLogUtil.Log().d("TBaseAd", "Traffic support config: adxShowRate " + intValue + " ewShowRate " + intValue2 + ",current random result is: " + i11);
        return i11;
    }

    public void c(TAdErrorCode tAdErrorCode) {
        if (this.f17201h != null) {
            AdditionalInfo f11 = f();
            if (tAdErrorCode != null) {
                f11.setErrorCode(tAdErrorCode);
            }
            this.f17201h.d(tAdErrorCode, f11);
        }
    }

    public abstract boolean c();

    public void clearCurrentAd() {
        if (this.f17198e && this.f17197d != null) {
            a();
        }
        stopTimer();
        be.c cVar = this.f17197d;
        if (cVar != null) {
            cVar.w();
        }
        setIsShowing(false);
        if (this.f17198e) {
            AdLogUtil.Log().d(ComConstants.AD_FLOW, "cancel request ad ");
        }
    }

    public i d() {
        i iVar = new i();
        iVar.c(this.f17219z);
        iVar.w(this.f17204k);
        iVar.k(this.f17210q);
        iVar.e(this.f17211r);
        iVar.j(this.f17212s);
        iVar.f(this.f17213t);
        iVar.n(this.f17214u);
        return iVar;
    }

    public void d(TAdErrorCode tAdErrorCode) {
        if (this.f17201h != null) {
            AdditionalInfo f11 = f();
            if (tAdErrorCode != null) {
                f11.setErrorCode(tAdErrorCode);
            }
            this.f17201h.n(tAdErrorCode, f11);
        }
    }

    public void destroy() {
        Preconditions.d(new C0173b());
    }

    public int e() {
        return this.f17208o;
    }

    public String enterScene(String str, int i11) {
        if (TextUtils.isEmpty(TAdManager.getAppId())) {
            AdLogUtil.Log().e("TBaseAd", "appId is empty");
            return "";
        }
        if (!e.h()) {
            AdLogUtil.Log().e("TBaseAd", "you should init first");
            return "";
        }
        Preconditions.a();
        String o11 = DeviceUtil.o();
        a(o11, str, i11);
        if (this.f17207n.size() >= 24) {
            Iterator<String> it = this.f17207n.keySet().iterator();
            if (it.hasNext()) {
                this.f17207n.remove(it.next());
            }
        }
        this.f17207n.put(o11, str);
        return o11;
    }

    public final AdditionalInfo f() {
        AdditionalInfo additionalInfo = new AdditionalInfo();
        additionalInfo.setPlacementId(this.f17194a);
        additionalInfo.setMcc(i7.c.d());
        additionalInfo.setTriggerId(this.f17217x);
        CloudControlConfig.CodeSeat codeSeat = this.f17200g;
        if (codeSeat != null) {
            additionalInfo.setTrafficGroupId(codeSeat.getTrafficGroupId());
            additionalInfo.setExperimentGroupId(this.f17200g.getExperimentGroupId());
        }
        additionalInfo.setSdkVersion(i7.c.l());
        return additionalInfo;
    }

    public final be.c g() {
        CloudControlConfig.CodeSeat codeSeat;
        if (this.f17201h == null || (codeSeat = this.f17200g) == null) {
            return null;
        }
        if (this.f17197d == null) {
            this.f17197d = a(codeSeat);
        }
        return this.f17197d;
    }

    public int getSupportFlag() {
        return this.f17204k;
    }

    public double getTopPrice(int i11) {
        AdCache cache = AdCacheManager.getCache(i11);
        if (cache == null) {
            return 0.0d;
        }
        return cache.getMaxPrice(this.f17194a, this.f17210q);
    }

    public final Network h() {
        CloudControlConfig.CodeSeat codeSeat = this.f17200g;
        if (codeSeat == null || codeSeat.getNetworks() == null) {
            return null;
        }
        for (Network network : this.f17200g.getNetworks()) {
            if (network != null && network.getSource().intValue() == 0) {
                return network;
            }
        }
        return null;
    }

    public boolean hasAd() {
        int i11;
        if (TextUtils.isEmpty(TAdManager.getAppId())) {
            AdLogUtil.Log().e("TBaseAd", "appId is empty");
            return false;
        }
        if (!e.h()) {
            AdLogUtil.Log().e("TBaseAd", "you should init first");
            return false;
        }
        if (this.f17206m) {
            a(false, 3);
            AdLogUtil.Log().d("TBaseAd", "current object is destroyed");
            return false;
        }
        if (TextUtils.isEmpty(this.f17194a)) {
            a(false, 4);
            AdLogUtil.Log().d("TBaseAd", "isReady,mAdUnit is null");
            return false;
        }
        if (this.f17200g == null) {
            this.f17200g = h.a(this.f17194a);
        }
        CloudControlConfig.CodeSeat codeSeat = this.f17200g;
        if (codeSeat == null) {
            a(false, 5);
            AdLogUtil.Log().d("TBaseAd", "isReady,mCodeSeatConfig is null");
            return false;
        }
        TAdErrorCode b11 = b(codeSeat);
        if (b11 != null) {
            a(false, b11.getErrorCode());
            AdLogUtil.Log().d("TBaseAd", "isReady,cloud control inspection failed");
            return false;
        }
        AdCache cache = AdCacheManager.getCache(this.f17200g.getCodeSeatType().intValue());
        if (cache == null) {
            a(false, 6);
            AdLogUtil.Log().d("TBaseAd", "isReady,no ad cache");
            return false;
        }
        boolean hasAds = cache.hasAds(this.f17194a, this.f17210q);
        AdLogUtil.Log().d("TBaseAd", "isReady key " + this.f17194a + " hasAd " + hasAds);
        if (hasAds) {
            a(true, 0);
        } else {
            try {
                i11 = cache.getLastExpireReason(this.f17194a);
            } catch (Throwable th2) {
                AdLogUtil.Log().e("TBaseAd", Log.getStackTraceString(th2));
                i11 = 0;
            }
            a(false, 0, i11);
            try {
                cache.clearLastExpireReason(this.f17194a);
            } catch (Throwable th3) {
                AdLogUtil.Log().e("TBaseAd", Log.getStackTraceString(th3));
            }
        }
        return hasAds;
    }

    public final ICacheAd i() {
        be.c cVar = this.f17197d;
        if (cVar == null) {
            return null;
        }
        return cVar.G().getCache(this.f17194a, false, 0, this.f17210q);
    }

    public boolean isLoaded() {
        return this.f17199f;
    }

    public final void j() {
        CloudControlConfig.CodeSeat codeSeat;
        if (this.f17201h == null || (codeSeat = this.f17200g) == null) {
            this.f17197d = null;
            return;
        }
        be.c a11 = a(codeSeat);
        this.f17197d = a11;
        if (a11 != null) {
            a11.k(this.f17201h);
            this.f17197d.o(this.f17196c);
            this.f17197d.R(this.f17215v);
        }
    }

    public final void k() {
        this.f17200g = h.a(this.f17194a);
        b(false, !NetStateManager.checkNetworkState(false) ? 1 : 0);
        m();
        if (this.f17209p && !c()) {
            a(TAdErrorCode.ERROR_CODE_AD_IS_SHOWING);
            return;
        }
        this.f17199f = false;
        clearCurrentAd();
        this.f17198e = true;
        if (this.f17206m) {
            this.f17198e = false;
            a(TAdErrorCode.ERROR_CURRENT_OBJECT_IS_DESTROYED);
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd -->current object haved been destroyed");
            MediaLogUtil.e("TBaseAd", "current object haved been destroyed");
            return;
        }
        if (TextUtils.isEmpty(TAdManager.getAppId())) {
            this.f17198e = false;
            a(TAdErrorCode.ERROR_INVALID_APP_ID);
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> Network request is invalid, the appId or appToken must be valid ----- Current app id is:" + TAdManager.getAppId());
            MediaLogUtil.e("TBaseAd", "loadAdInternal,appId is empty");
            return;
        }
        CloudControlConfig.CodeSeat codeSeat = this.f17200g;
        if (codeSeat == null) {
            MediaLogUtil.e("TBaseAd", "loadAdInternal,config is null；codeSeatId = " + this.f17194a);
            this.f17198e = false;
            CloudControlConfigSync.b(6);
            int f11 = j7.a.e().f(ComConstants.Pref.CLOUD_CONFIG_ERROR_CODE);
            if (f11 != 0) {
                a(ComConstants.transferCloudErrorCode(f11));
                return;
            } else {
                a(TAdErrorCode.ERROR_AD_UNIT_CONFIG_EMPTY);
                return;
            }
        }
        this.f17208o = codeSeat.getCodeSeatType().intValue();
        if (Boolean.FALSE.equals(this.f17200g.getCloudControlEnable())) {
            MediaLogUtil.e("TBaseAd", "loadAdInternal,config is closed");
            this.f17198e = false;
            a(TAdErrorCode.ERROR_CLOUD_AD_SEAT_IS_CLOSED);
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> current ad unit is close ");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long c11 = l0.c(currentTimeMillis);
        long b11 = l0.b(currentTimeMillis);
        if (this.f17200g.getAdShowCountLimitDay().intValue() == 0 || (this.f17200g.getAdShowCountLimitDay().intValue() != -1 && c11 == this.f17200g.getTodayZeroClock() && this.f17200g.getTodayShowTimes() >= this.f17200g.getAdShowCountLimitDay().intValue())) {
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> ad show times can not exceed day show max");
            MediaLogUtil.e("TBaseAd", "ad show times reach the limit of day,day showTimes " + this.f17200g.getAdShowCountLimitDay());
            this.f17198e = false;
            a(TAdErrorCode.ERROR_AD_SHOW_TIMES_OUT_OF_DAY);
            return;
        }
        if (this.f17200g.getAdShowCountLimitHour().intValue() == 0 || (this.f17200g.getAdShowCountLimitHour().intValue() != -1 && b11 == this.f17200g.getCurrentHourZeroClock() && this.f17200g.getCurrentHourShowTimes() >= this.f17200g.getAdShowCountLimitHour().intValue())) {
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> ad display has reached the limit of hours");
            MediaLogUtil.e("TBaseAd", "ad display has reached the limit of hour,hour showTimes " + this.f17200g.getAdShowCountLimitHour());
            this.f17198e = false;
            a(TAdErrorCode.ERROR_AD_SHOW_TIMES_OUT_OF_HOUR);
            return;
        }
        long lastShowTime = currentTimeMillis - this.f17200g.getLastShowTime();
        if (lastShowTime <= 0) {
            lastShowTime = -lastShowTime;
        }
        if (this.f17200g.getAdShowTimeInterval().intValue() != -1000 && lastShowTime <= this.f17200g.getAdShowTimeInterval().intValue()) {
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> ad display did not reach the interval");
            MediaLogUtil.e("TBaseAd", "ad display did not reach the interval,time " + this.f17200g.getAdShowTimeInterval());
            this.f17198e = false;
            a(TAdErrorCode.ERROR_AD_SHOW_NOT_IN_INTERVAL);
            return;
        }
        this.f17204k = c(this.f17200g);
        j();
        if (!a(e())) {
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> code seat type does not match request type");
            MediaLogUtil.e("TBaseAd", "code seat type does not match request type ---> " + this.f17200g.getCodeSeatType());
            this.f17198e = false;
            a(TAdErrorCode.ERROR_AD_TYPE_LOAD_INCONSISTENCY);
            return;
        }
        this.f17200g = m.a(this.f17200g);
        if (NetStateManager.checkNetworkState(false)) {
            p();
            r();
            return;
        }
        AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> net error ");
        MediaLogUtil.e("TBaseAd", "net error");
        this.f17198e = false;
        Network h11 = h();
        be.c g11 = g();
        if (h11 == null || g11 == null || !g11.d0()) {
            a(TAdErrorCode.ERROR_FILL_FAILED_WITH_NETWORK_EXCEPTION);
            return;
        }
        g11.g(this.f17219z);
        g11.O(this.f17200g.getAdRequestCount().intValue());
        if (g11.u(this.f17200g, h11)) {
            return;
        }
        a(TAdErrorCode.ERROR_FILL_FAILED_NO_NETWORK_AND_OFFLINE);
    }

    public void l() {
        if (this.f17201h == null) {
            return;
        }
        AdditionalInfo f11 = f();
        ICacheAd i11 = i();
        Network network = i11 != null ? i11.getNetwork() : null;
        if (network != null) {
            f11.setSource(network.getSource());
            f11.setApplicationId(network.getApplicationId());
            f11.setApplicationKey(network.getApplicationKey());
            f11.setCodeSeatId(network.getCodeSeatId());
            f11.setEcpm(network.getPrice());
            f11.setPrecision(AdUtil.isWaterFall(network) ? "estimated" : "exact");
            f11.setCurrency("USD");
            f11.setBidding(Boolean.valueOf(AdUtil.isBiddingNetwork(network)));
        }
        if (i11 != null) {
            f11.setMediatorSource(i11.getMediatorSourceName());
        }
        this.f17201h.c(f11);
    }

    public void loadAd() {
        b(1);
    }

    public final void m() {
        if (this.f17201h != null) {
            this.f17201h.q(f());
        }
    }

    public void n() {
        a((TAdNativeInfo) null);
    }

    public final void o() {
        t tVar = this.f17201h;
        if (tVar != null) {
            tVar.h(null);
            this.f17201h.g(null);
            this.f17201h.i(null);
        }
        this.f17201h = null;
        this.f17200g = null;
        RecordTestInfo.destroy();
        setIsShowing(false);
        clearCurrentAd();
        if (this.f17198e) {
            trackingAdLoaded(TAdErrorCode.CODE_CURRENT_OBJECT_IS_DESTROYED, TAdErrorCode.ERROR_CURRENT_OBJECT_IS_DESTROYED.getErrorMessage(), -1);
        }
        this.f17198e = false;
        this.f17206m = true;
    }

    public final void p() {
        CloudControlConfig.CodeSeat codeSeat = this.f17200g;
        if (codeSeat != null) {
            this.f17203j = codeSeat.getAdRequestTimeout().intValue() * 1000;
        }
        if (this.f17203j > 0) {
            if (this.f17196c == null) {
                this.f17196c = new RunTimer();
            }
            this.f17196c.cancelTimeTask();
            this.f17196c.setTimeOutCallback(this.f17216w);
            this.f17196c.setScheduleTime(this.f17203j);
            this.f17196c.runTimerTask();
        }
    }

    public void pause() {
        be.c cVar = this.f17197d;
        if (cVar != null) {
            cVar.i0();
        }
    }

    public final void preload() {
        loadAd();
    }

    public void q() {
    }

    public final void r() {
        if (this.f17200g == null) {
            MediaLogUtil.e("TBaseAd", "startLoadMediation codeSeat is null");
            a(TAdErrorCode.ERROR_AD_UNIT_CONFIG_EMPTY);
            return;
        }
        AdLogUtil.Log().i(ComConstants.AD_FLOW, "*----> TBaseAd - current cloudConfig is " + this.f17200g.toString());
        List<Network> networks = this.f17200g.getNetworks();
        if (networks == null || networks.isEmpty()) {
            AdLogUtil.Log().w(ComConstants.AD_FLOW, "TBaseAd --> ad is empty ");
            MediaLogUtil.e("TBaseAd", "startLoadMediation,network is empty");
            a(TAdErrorCode.ERROR_AD_SOURCE_LIST_IS_EMPTY);
            return;
        }
        be.c g11 = g();
        if (g11 != null) {
            g11.g(this.f17219z);
            if (g11.q(this.f17195b)) {
                return;
            }
            MediaLogUtil.e("TBaseAd", "prepare for request failed");
            a(TAdErrorCode.ERROR_PREPARE_REQUEST_FAILED);
        }
    }

    public void resume() {
        be.c cVar = this.f17197d;
        if (cVar != null) {
            cVar.m0();
        }
    }

    public final void s() {
        RunTimer runTimer = this.f17196c;
        if (runTimer != null) {
            runTimer.cancelTimeTask();
            this.f17196c = null;
        }
    }

    public void setAdLoadScenes(String str, String str2, Map<String, Object> map) {
        this.f17211r = str;
        this.f17212s = str2;
        this.f17213t = map;
    }

    public void setCodeSeatType(int i11) {
        this.f17208o = i11;
    }

    public void setContainVulgarContent(boolean z10) {
        this.f17210q = z10;
    }

    public void setCurrActivityFullscreen(boolean z10) {
        this.f17214u = z10;
    }

    public void setIsShowing(boolean z10) {
        this.f17209p = z10;
    }

    public void setLoaded(boolean z10) {
        this.f17199f = z10;
    }

    public void setLoading(boolean z10) {
        this.f17198e = z10;
    }

    public void setRequestBody(TAdRequestBody tAdRequestBody) {
        if (tAdRequestBody == null) {
            return;
        }
        b();
        this.f17203j = tAdRequestBody.getScheduleTime();
        t tVar = this.f17201h;
        if (tVar != null) {
            tVar.h(tAdRequestBody.getAdListener());
            this.f17201h.i(tAdRequestBody.getAdditionalListener());
        }
    }

    public void stopTimer() {
        Preconditions.d(new c());
    }

    public void t() {
        if (this.f17201h != null) {
            if (NetStateManager.checkNetworkState(false)) {
                TAdErrorCode tAdErrorCode = TAdErrorCode.ERROR_TRIGGER_SHOW_ONLINE_NO_AD;
                trackingTriggerShowError(tAdErrorCode);
                this.f17201h.onShowError(tAdErrorCode);
            } else {
                TAdErrorCode tAdErrorCode2 = TAdErrorCode.ERROR_RIGGER_SHOW_OFFLINE_NO_AD;
                trackingTriggerShowError(tAdErrorCode2);
                this.f17201h.onShowError(tAdErrorCode2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00d5 A[Catch: Exception -> 0x0038, TryCatch #0 {Exception -> 0x0038, blocks: (B:3:0x0028, B:5:0x002c, B:8:0x003b, B:10:0x006c, B:12:0x0070, B:15:0x008c, B:17:0x0098, B:19:0x00b5, B:21:0x00d5, B:22:0x00db, B:23:0x010e, B:26:0x0115, B:30:0x01b4, B:31:0x01ac, B:34:0x01c3, B:38:0x01e1, B:41:0x021c, B:43:0x023d, B:44:0x0246, B:46:0x024a, B:47:0x0260, B:49:0x0269, B:50:0x0281, B:53:0x028d, B:56:0x029b, B:58:0x0297, B:59:0x0289, B:60:0x0218, B:61:0x01dd, B:63:0x009e, B:65:0x00a2), top: B:2:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void trackingAdLoaded(int r27, java.lang.String r28, int r29) {
        /*
            Method dump skipped, instructions count: 686
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ce.b.trackingAdLoaded(int, java.lang.String, int):void");
    }

    public void trackingTriggerShowError(TAdErrorCode tAdErrorCode) {
        Bundle bundle = new Bundle();
        try {
            Bundle bundle2 = this.f17219z;
            if (bundle2 != null) {
                bundle.putString(TrackingKey.TRIGGER_ID, bundle2.getString(TrackingKey.TRIGGER_ID));
                bundle.putLong(TrackingKey.TRIGGER_TS, this.f17219z.getLong(TrackingKey.TRIGGER_TS));
                bundle.putDouble(TrackingKey.BIDDING_PRICE, this.f17219z.getDouble(TrackingKey.BIDDING_PRICE));
                bundle.putInt(TrackingKey.PLATFORM, this.f17219z.getInt(TrackingKey.PLATFORM));
            } else {
                bundle.putString(TrackingKey.TRIGGER_ID, TrackingUtil.getTriggerId());
                bundle.putLong(TrackingKey.TRIGGER_TS, System.currentTimeMillis());
            }
            if (this.f17200g == null) {
                this.f17200g = h.a(this.f17194a);
            }
            bundle.putString(TrackingKey.CLD_APP_ID, TAdManager.getAppId());
            bundle.putString("app_id", TAdManager.getAppId());
            bundle.putString(TrackingKey.CODE_SEAT_ID, this.f17194a);
            bundle.putString(TrackingKey.CLD_CODE_SEAT_ID, this.f17194a);
            bundle.putInt("ad_type", e());
            CloudControlConfig.CodeSeat codeSeat = this.f17200g;
            if (codeSeat != null) {
                bundle.putString(TrackingKey.TRAFFIC_GROUP_ID, codeSeat.getTrafficGroupId());
                bundle.putString(TrackingKey.EXPERIMENT_GROUP_ID, this.f17200g.getExperimentGroupId());
            }
            if (tAdErrorCode != null) {
                bundle.putString("error_code", String.valueOf(tAdErrorCode.getErrorCode()));
                bundle.putString(TrackingKey.ERROR_MESSAGE, TAdErrorCode.simpleErrorMessage(tAdErrorCode.getErrorMessage()));
            }
            bundle.putInt(TrackingKey.IS_OFFLINE, !NetStateManager.checkNetworkState(false) ? 1 : 0);
            ICacheAd i11 = i();
            if (i11 != null) {
                bundle.putString(TrackingKey.MEDIATOR_SOURCE, i11.getMediatorSourceName());
                bundle.putString(TrackingKey.MEDIATOR_CODE_SEAT_ID, i11.getMediatorSourceUnitId());
            }
            TrackingManager.trackingTriggerShow(bundle);
        } catch (Exception e11) {
            AdLogUtil.Log().e(ComConstants.AD_FLOW, Log.getStackTraceString(e11));
        }
    }
}
