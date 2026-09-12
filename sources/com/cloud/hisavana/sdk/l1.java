package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.sdk.common.bean.SSPWebPageReqInfo;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.request.AdxRequestBody;
import com.cloud.hisavana.sdk.data.bean.request.ApplicationDTO;
import com.cloud.hisavana.sdk.data.bean.request.ConfigRequestBody;
import com.cloud.hisavana.sdk.data.bean.request.DeviceDTO;
import com.cloud.hisavana.sdk.data.bean.request.OmSdk;
import com.cloud.hisavana.sdk.data.bean.request.UserDTO;
import com.cloud.hisavana.sdk.data.bean.response.ccofig.CustomCloudControlKey;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.MitNetUtil;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class l1 {

    /* renamed from: a, reason: collision with root package name */
    private static AdxRequestBody f22696a;

    /* renamed from: b, reason: collision with root package name */
    private static AdxRequestBody f22697b;

    private static AdxRequestBody a(boolean z10) {
        AdxRequestBody adxRequestBody = new AdxRequestBody();
        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setPackageName(com.cloud.sdk.commonutil.util.e.d());
        applicationDTO.setInstallTime(com.cloud.sdk.commonutil.util.b.a());
        applicationDTO.setVersionInt(i7.c.p());
        applicationDTO.setVersion(i7.c.q());
        applicationDTO.setSdkVersion(i7.c.l());
        applicationDTO.setSdkVersionCode(360200);
        applicationDTO.setUserAgent(com.cloud.sdk.commonutil.util.r.c());
        applicationDTO.setPsVersion(com.cloud.hisavana.sdk.common.util.i0.c(com.cloud.sdk.commonutil.util.e.a()) == null ? 0L : r2.versionCode);
        applicationDTO.setPsChannel("Online");
        applicationDTO.setPsApiVersion("1.0.7");
        adxRequestBody.application = applicationDTO;
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setType(i7.c.o());
        deviceDTO.setBrand(i7.c.a());
        deviceDTO.setModel(i7.c.f());
        deviceDTO.setMaker(i7.c.c());
        deviceDTO.setGaid(DeviceUtil.e());
        deviceDTO.setOsType(1);
        deviceDTO.setOsVersion(i7.c.h());
        deviceDTO.setScreenWidth(i7.c.k());
        deviceDTO.setScreenHeight(i7.c.j());
        deviceDTO.setScreenDensity(i7.c.i());
        deviceDTO.setTurnOffPerAds(DeviceUtil.f());
        deviceDTO.setCpu(DeviceUtil.c());
        deviceDTO.setOsApiLevel("" + i7.c.g());
        if (!z10 && i7.a.h0()) {
            String m11 = i7.a.m();
            if (!TextUtils.isEmpty(m11)) {
                deviceDTO.setAntifraud(m11);
            }
        }
        deviceDTO.setTotalRam(Long.valueOf(DeviceUtil.n()));
        adxRequestBody.device = deviceDTO;
        return adxRequestBody;
    }

    public static String b() {
        DeviceDTO deviceDTO;
        try {
            boolean f11 = f();
            ConfigRequestBody configRequestBody = new ConfigRequestBody();
            AdxRequestBody adxRequestBody = f22697b;
            configRequestBody.application = adxRequestBody.application;
            configRequestBody.device = adxRequestBody.device;
            configRequestBody.user = new UserDTO();
            configRequestBody.applicationId = a7.c.f440b;
            configRequestBody.testRequest = a7.c.q();
            if (!f11 && (deviceDTO = configRequestBody.device) != null && TextUtils.isEmpty(deviceDTO.getGaid())) {
                configRequestBody.device.setGaid(DeviceUtil.e());
            }
            configRequestBody.user.setBaseStation(DeviceUtil.g());
            configRequestBody.user.setLatitude(com.cloud.sdk.commonutil.util.d.d());
            configRequestBody.user.setLongitude(com.cloud.sdk.commonutil.util.d.f());
            configRequestBody.user.setCoordTime(com.cloud.sdk.commonutil.util.d.c());
            configRequestBody.ascribeEnable = com.cloud.hisavana.sdk.common.util.i0.g(com.cloud.sdk.commonutil.util.e.a());
            configRequestBody.customKeys = CustomCloudControlKey.getCustomRequestKeys();
            return GsonUtil.d(configRequestBody);
        } catch (Throwable th2) {
            e4.b().e(Log.getStackTraceString(th2));
            return "";
        }
    }

    public static String c(AdxImpBean adxImpBean) {
        return d(adxImpBean, null);
    }

    public static String d(AdxImpBean adxImpBean, SSPWebPageReqInfo sSPWebPageReqInfo) {
        try {
            boolean e11 = e();
            AdxRequestBody copy = AdxRequestBody.copy(f22696a);
            copy.requestId = !TextUtils.isEmpty(adxImpBean.requestId) ? adxImpBean.requestId : DeviceUtil.o();
            copy.testRequest = Boolean.valueOf(a7.c.q());
            copy.applicationId = a7.c.f440b;
            copy.apiType = 1;
            copy.defaultAd = false;
            copy.offlineAd = adxImpBean.offlineAd;
            copy.cachedAdCount = adxImpBean.cacheAdCount;
            copy.codeSeat.setId(adxImpBean.pmid);
            copy.codeSeat.setType(adxImpBean.adt);
            copy.codeSeat.setAdCount(adxImpBean.mAdCount);
            copy.codeSeat.setWidth(0);
            copy.codeSeat.setHeight(0);
            copy.codeSeat.setGameName(adxImpBean.gameName);
            copy.codeSeat.setGameScene(adxImpBean.gameScene);
            copy.codeSeat.setExtInfo(adxImpBean.extInfo);
            copy.codeSeat.setAdPriority(adxImpBean.supportEw ? 1 : 0);
            copy.codeSeat.setOfflineAdEnable(adxImpBean.offlineAdEnable);
            if (sSPWebPageReqInfo != null) {
                try {
                    copy.codeSeat.setWebPageInfo(sSPWebPageReqInfo);
                } catch (Throwable unused) {
                }
            }
            if (k1.o().r()) {
                OmSdk omSdk = new OmSdk();
                omSdk.api = r7;
                Integer[] numArr = {7};
                omSdk.omidpn = "hisavana";
                omSdk.omidpv = fe.a.b();
                copy.codeSeat.setOmSdk(omSdk);
            }
            DeviceDTO deviceDTO = copy.device;
            if (e11 && deviceDTO != null) {
                deviceDTO.setIpAddress(DeviceUtil.h());
                deviceDTO.setOneid(DeviceUtil.j());
            }
            if (deviceDTO != null) {
                deviceDTO.setImsi(i7.c.d());
                deviceDTO.setLanguage(Locale.getDefault().getLanguage());
                deviceDTO.setOperatorType(i7.c.e() + i7.c.d());
                deviceDTO.setGaid(DeviceUtil.e());
                deviceDTO.setNetworkConnectionType(String.valueOf(MitNetUtil.a(com.cloud.sdk.commonutil.util.e.a()).ordinal()));
                deviceDTO.setPsCountryCode(DeviceUtil.d());
            }
            copy.user.setBaseStation(DeviceUtil.g());
            copy.user.setLatitude(com.cloud.sdk.commonutil.util.d.d());
            copy.user.setLongitude(com.cloud.sdk.commonutil.util.d.f());
            copy.user.setCoordTime(com.cloud.sdk.commonutil.util.d.c());
            return GsonUtil.d(copy);
        } catch (Throwable th2) {
            e4.b().e(Log.getStackTraceString(th2));
            return "";
        }
    }

    private static synchronized boolean e() {
        synchronized (l1.class) {
            AdxRequestBody adxRequestBody = f22696a;
            if (adxRequestBody == null) {
                f22696a = a(false);
                return true;
            }
            DeviceDTO deviceDTO = adxRequestBody.device;
            if (deviceDTO != null && TextUtils.isEmpty(deviceDTO.getAntifraud()) && i7.a.h0()) {
                String m11 = i7.a.m();
                if (!TextUtils.isEmpty(m11)) {
                    f22696a.device.setAntifraud(m11);
                }
            }
            return false;
        }
    }

    private static synchronized boolean f() {
        synchronized (l1.class) {
            if (f22697b != null) {
                return false;
            }
            f22697b = a(true);
            return true;
        }
    }
}
