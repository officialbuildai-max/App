package com.cloud.hisavana.sdk.bridge;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.cloud.hisavana.sdk.G;
import com.cloud.hisavana.sdk.N0;
import com.cloud.hisavana.sdk.P;
import com.cloud.hisavana.sdk.Z;
import com.cloud.hisavana.sdk.api.listener.AdCallback;
import com.cloud.hisavana.sdk.api.listener.d;
import com.cloud.hisavana.sdk.bridge.HisavanaAdJsBridge;
import com.cloud.hisavana.sdk.c0;
import com.cloud.hisavana.sdk.c1;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.athena.SSPTrackingHelper;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.common.util.i0;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.request.DeviceDTO;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.j3;
import com.cloud.hisavana.sdk.q3;
import com.cloud.hisavana.sdk.r2;
import com.cloud.hisavana.sdk.s3;
import com.cloud.hisavana.sdk.u0;
import com.cloud.hisavana.sdk.y;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.sdk.commonutil.util.e;
import com.cloud.tmc.ad.Constants;
import com.cloud.tmc.integration.event.EventConstants;
import i7.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class HisavanaAdJsBridge {
    public static final String INTERFACE_NAME = "HisavanaAdJsBridge";
    public static final String PS_CLICKTRACKING_URL = "PsClickTrackingUrl";
    public static final String PS_CLICK_CURRENT_TIMEMILLIS = "ClickCurrentTimeMillis";
    public static final String PS_TRACKTYPE = "PsTrackType";

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f21780f = Pattern.compile("^[0-9a-zA-Z]+$");

    /* renamed from: a, reason: collision with root package name */
    private final String f21781a = INTERFACE_NAME;

    /* renamed from: b, reason: collision with root package name */
    private String f21782b = EventConstants.KEY_SOURCE;

    /* renamed from: c, reason: collision with root package name */
    private String f21783c = "http://";

    /* renamed from: d, reason: collision with root package name */
    private String f21784d = "https://";

    /* renamed from: e, reason: collision with root package name */
    private WeakReference f21785e;

    /* loaded from: classes3.dex */
    public static class a extends AdCallback {

        /* renamed from: a, reason: collision with root package name */
        private final s3 f21786a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference f21787b;

        /* renamed from: c, reason: collision with root package name */
        private final AdsDTO f21788c;

        public a(s3 s3Var, HisavanaAdJsBridge hisavanaAdJsBridge, AdsDTO adsDTO) {
            this.f21786a = s3Var;
            this.f21787b = new WeakReference(hisavanaAdJsBridge);
            this.f21788c = adsDTO;
        }

        @Override // com.cloud.hisavana.sdk.api.listener.AdCallback
        public d d() {
            return null;
        }

        @Override // com.cloud.hisavana.sdk.api.listener.AdCallback
        public String e() {
            return "";
        }

        @Override // com.cloud.hisavana.sdk.api.listener.AdCallback
        public String g() {
            return "";
        }

        @Override // com.cloud.hisavana.sdk.api.listener.AdCallback
        public void m() {
            e4.b().d("JsAdmAdListener", "adm from js : onAdClicked");
            AthenaTracker.B(this.f21788c, 3, 0);
            HisavanaAdJsBridge hisavanaAdJsBridge = (HisavanaAdJsBridge) this.f21787b.get();
            if (hisavanaAdJsBridge != null) {
                hisavanaAdJsBridge.g(hisavanaAdJsBridge.d(this.f21788c.getUuid(), 3, 0), null);
            }
        }

        @Override // com.cloud.hisavana.sdk.api.listener.AdCallback
        public void p(AdsDTO adsDTO) {
            AthenaTracker.e0(this.f21788c);
            e4.b().d("JsAdmAdListener", "adm from js : onAdClosed");
            AthenaTracker.B(this.f21788c, 4, 0);
            this.f21786a.m();
            HisavanaAdJsBridge hisavanaAdJsBridge = (HisavanaAdJsBridge) this.f21787b.get();
            if (hisavanaAdJsBridge != null) {
                hisavanaAdJsBridge.g(hisavanaAdJsBridge.d(this.f21788c.getUuid(), 4, 0), null);
            }
        }

        @Override // com.cloud.hisavana.sdk.api.listener.AdCallback
        public void s() {
            e4.b().d("JsAdmAdListener", "adm from js : onAdShow");
            AthenaTracker.B(this.f21788c, 2, 0);
            HisavanaAdJsBridge hisavanaAdJsBridge = (HisavanaAdJsBridge) this.f21787b.get();
            if (hisavanaAdJsBridge != null) {
                hisavanaAdJsBridge.g(hisavanaAdJsBridge.d(this.f21788c.getUuid(), 2, 0), null);
            }
        }

        @Override // com.cloud.hisavana.sdk.api.listener.AdCallback
        public void t(TaErrorCode taErrorCode, G g11) {
            if (this.f21788c != null) {
                SSPTrackingHelper sSPTrackingHelper = SSPTrackingHelper.f22035a;
                sSPTrackingHelper.M(Integer.valueOf(taErrorCode.getErrorCode()), this.f21788c.getTriggerId(), this.f21788c.getCodeSeatId(), sSPTrackingHelper.m(g11));
            }
            int errorCode = taErrorCode == null ? -1 : taErrorCode.getErrorCode();
            e4.b().d("JsAdmAdListener", "adm from js : onAdShowError");
            AthenaTracker.B(this.f21788c, 2, errorCode);
            this.f21786a.m();
            HisavanaAdJsBridge hisavanaAdJsBridge = (HisavanaAdJsBridge) this.f21787b.get();
            if (hisavanaAdJsBridge != null) {
                hisavanaAdJsBridge.g(hisavanaAdJsBridge.d(this.f21788c.getUuid(), 2, errorCode), null);
            }
        }
    }

    public HisavanaAdJsBridge() {
    }

    public HisavanaAdJsBridge(WebView webView) {
        this.f21785e = new WeakReference(webView);
        Context context = webView == null ? null : webView.getContext();
        if (e.a() != null || context == null) {
            return;
        }
        e.i(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str, int i11, int i12) {
        return "javascript:hisavanaToJsForAdmCallBack('" + str + "'," + i11 + "," + i12 + ")";
    }

    private void f(AdsDTO adsDTO, String str, boolean z10) {
        if (adsDTO == null) {
            return;
        }
        AthenaTracker.E(adsDTO, adsDTO.getUuid(), str, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final String str, final ValueCallback valueCallback) {
        e4.b().d(INTERFACE_NAME, "[jsbridge]callBackToJS: " + str);
        Preconditions.d(new Preconditions.a() { // from class: d7.d
            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public final void onRun() {
                HisavanaAdJsBridge.this.m(str, valueCallback);
            }
        });
    }

    private boolean h(Context context, AdsDTO adsDTO) {
        if (context != null && adsDTO != null) {
            e4.b().d(INTERFACE_NAME, "start openWithClickUrls, clickUrls: " + adsDTO.getStoreDeeplink());
            ArrayList<String> storeDeeplink = adsDTO.getStoreDeeplink();
            if (storeDeeplink != null && !storeDeeplink.isEmpty()) {
                for (String str : storeDeeplink) {
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str)) {
                        if (!str.startsWith("palmplay://")) {
                            if (str.startsWith("aha://") && N0.t(context, adsDTO, str)) {
                                e4.b().d(INTERFACE_NAME, "startOpenAcquisitionLink,url is ahaLink: " + str);
                                f(adsDTO, str, true);
                                return true;
                            }
                            if (j(str) && N0.J(context, str, "com.android.vending")) {
                                e4.b().d(INTERFACE_NAME, "startOpenAcquisitionLink,url is GP link: " + str);
                                f(adsDTO, str, true);
                                return true;
                            }
                            if (N0.J(context, str, null)) {
                                e4.b().d(INTERFACE_NAME, "startOpenAcquisitionLink,url is other link: " + str);
                                f(adsDTO, str, true);
                                return true;
                            }
                        } else if (N0.T(adsDTO) || !adsDTO.getPslinkInfoStatus() || !N0.y(context, adsDTO.getPackageName(), adsDTO.getPackageName())) {
                            if (N0.v(context, adsDTO, str, false)) {
                                e4.b().d(INTERFACE_NAME, "startOpenAcquisitionLink,url is psLink: " + str);
                                f(adsDTO, str, true);
                                k(adsDTO);
                                return true;
                            }
                        }
                    }
                }
                f(adsDTO, null, false);
                return false;
            }
            e4.b().w(INTERFACE_NAME, "openWithClickUrls failed, clickUrls is empty.");
            f(adsDTO, null, false);
        }
        return false;
    }

    private boolean i(AdsDTO adsDTO) {
        Context a11 = e.a();
        if (a11 == null || adsDTO == null) {
            return false;
        }
        adsDTO.setClickid(j3.a());
        Integer trackType = adsDTO.getTrackType();
        if (N0.u(a11, adsDTO, adsDTO.getDeepLinkUrl(), null)) {
            if (trackType.intValue() == 0) {
                N0.U(adsDTO);
            }
            f(adsDTO, null, true);
            return true;
        }
        if (N0.T(adsDTO) && N0.V(a11, adsDTO.getPackageName())) {
            if (trackType.intValue() == 0) {
                N0.U(adsDTO);
            }
            f(adsDTO, null, true);
            return true;
        }
        if (!N0.T(adsDTO) || !N0.V(a11, adsDTO.getPsPackageName())) {
            return h(a11, adsDTO);
        }
        if (trackType.intValue() == 0) {
            N0.U(adsDTO);
        }
        f(adsDTO, null, true);
        return true;
    }

    public static boolean isAlphaNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return f21780f.matcher(str).matches();
    }

    private boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("market://") || str.contains(Constants.GP_DEEPLINK);
    }

    private void k(AdsDTO adsDTO) {
        if (adsDTO == null) {
            return;
        }
        boolean h11 = i0.h(e.a());
        if (adsDTO.getTrackType().intValue() == 0) {
            if (h11) {
                AthenaTracker.D(adsDTO, true);
            } else {
                N0.U(adsDTO);
                AthenaTracker.D(adsDTO, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(String str) {
        try {
            if (e.a() == null) {
                e4.b().w(INTERFACE_NAME, "[jsbridge]handleAdClick failed, HSCoreUtil is not init.");
                return;
            }
            AdsDTO adsDTO = (AdsDTO) GsonUtil.a(str, AdsDTO.class);
            if (adsDTO == null) {
                e4.b().w(INTERFACE_NAME, "[jsbridge]handleAdClick failed, adsDTO is null.");
                return;
            }
            WebView webView = (WebView) this.f21785e.get();
            Context a11 = (webView == null || webView.getContext() == null) ? e.a() : webView.getContext();
            AthenaTracker.W(adsDTO);
            N0.b(a11, adsDTO, new DownUpPointBean(0.0f, 0.0f, 0.0f, 0.0f, 0, 0), false);
        } catch (Throwable th2) {
            e4.b().w(INTERFACE_NAME, "[jsbridge]handleAdClick failed, error: " + th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(String str, ValueCallback valueCallback) {
        WebView webView;
        WeakReference weakReference = this.f21785e;
        if (weakReference == null || (webView = (WebView) weakReference.get()) == null) {
            return;
        }
        try {
            webView.evaluateJavascript(str, valueCallback);
        } catch (Exception unused) {
            e4.b().w(INTERFACE_NAME, "evaluate javascript failed:" + str);
        }
    }

    @JavascriptInterface
    public String getAppVersionCode() {
        if (e.a() == null) {
            e4.b().w(INTERFACE_NAME, "[jsbridge]getAppVersionCode failed, HSCoreUtil is not init.");
            return "";
        }
        String p11 = c.p();
        e4.b().d(INTERFACE_NAME, "[jsbridge]getAppVersionCode: " + p11);
        return p11;
    }

    @JavascriptInterface
    public String getAppVersionName() {
        if (e.a() == null) {
            e4.b().w(INTERFACE_NAME, "[jsbridge]getAppVersionName failed, HSCoreUtil is not init.");
            return "";
        }
        String q11 = c.q();
        e4.b().d(INTERFACE_NAME, "[jsbridge]getAppVersionName: " + q11);
        return q11;
    }

    @JavascriptInterface
    public String getDeviceInfo() {
        if (e.a() == null) {
            e4.b().w(INTERFACE_NAME, "[jsbridge]getDeviceInfo failed, HSCoreUtil is not init.");
            return "";
        }
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setBrand(c.a());
        deviceDTO.setModel(c.f());
        deviceDTO.setOsType(1);
        deviceDTO.setOsApiLevel(String.valueOf(c.g()));
        deviceDTO.setLanguage(Locale.getDefault().getLanguage());
        deviceDTO.setPsCountryCode(DeviceUtil.d());
        deviceDTO.setCpu(DeviceUtil.c());
        deviceDTO.setGaid(DeviceUtil.e());
        String d11 = GsonUtil.d(deviceDTO);
        e4.b().d(INTERFACE_NAME, "[jsbridge]getDeviceInfo");
        return d11;
    }

    @JavascriptInterface
    public long getPsVersion() {
        if (e.a() == null) {
            e4.b().w(INTERFACE_NAME, "[jsbridge]getPsVersion failed, HSCoreUtil is not init.");
            return 0L;
        }
        PackageInfo c11 = i0.c(e.a());
        if (c11 == null) {
            return 0L;
        }
        long longVersionCode = Build.VERSION.SDK_INT >= 28 ? c11.getLongVersionCode() : c11.versionCode;
        e4.b().d(INTERFACE_NAME, "[jsbridge]getPsVersion: " + longVersionCode);
        return longVersionCode;
    }

    @JavascriptInterface
    public String getSdkVersionCode() {
        if (e.a() == null) {
            e4.b().w(INTERFACE_NAME, "[jsbridge]getSdkVersionCode failed, HSCoreUtil is not init.");
            return "";
        }
        String valueOf = String.valueOf(c.m());
        e4.b().d(INTERFACE_NAME, "[jsbridge]getSdkVersionCode: " + valueOf);
        return valueOf;
    }

    @JavascriptInterface
    public void handleAdClick(final String str) {
        Preconditions.d(new Preconditions.a() { // from class: d7.e
            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public final void onRun() {
                HisavanaAdJsBridge.this.l(str);
            }
        });
    }

    @JavascriptInterface
    public boolean isAppInstalled(String str) {
        try {
        } catch (Exception unused) {
            e4.b().w(INTERFACE_NAME, "the package name is " + str + " is not installed");
        }
        if (e.a() != null) {
            return (TextUtils.isEmpty(str) || e.a().getPackageManager().getPackageInfo(str, 0) == null) ? false : true;
        }
        e4.b().w(INTERFACE_NAME, "[jsbridge]isAppInstalled failed, HSCoreUtil is not init.");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0086 A[Catch: all -> 0x0054, TRY_LEAVE, TryCatch #0 {all -> 0x0054, blocks: (B:10:0x0042, B:12:0x004b, B:15:0x0063, B:17:0x0086, B:27:0x005f), top: B:9:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean isMaterialExist(java.lang.String r6, int r7, boolean r8) {
        /*
            r5 = this;
            android.content.Context r0 = com.cloud.sdk.commonutil.util.e.a()
            r1 = 0
            java.lang.String r2 = "HisavanaAdJsBridge"
            if (r0 != 0) goto L13
            com.cloud.hisavana.sdk.e4 r6 = com.cloud.hisavana.sdk.e4.b()
            java.lang.String r7 = "[jsbridge]isMaterialExit, HSCoreUtil is not init."
            r6.w(r2, r7)
            return r1
        L13:
            com.cloud.hisavana.sdk.e4 r0 = com.cloud.hisavana.sdk.e4.b()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "isMaterialExit: url is "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = " source is "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r4 = ", isVastAd is "
            r3.append(r4)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            r0.w(r2, r3)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L42
            return r1
        L42:
            java.lang.String r0 = r5.f21783c     // Catch: java.lang.Throwable -> L54
            boolean r0 = r6.startsWith(r0)     // Catch: java.lang.Throwable -> L54
            r3 = 1
            if (r0 != 0) goto L56
            java.lang.String r0 = r5.f21784d     // Catch: java.lang.Throwable -> L54
            boolean r0 = r6.startsWith(r0)     // Catch: java.lang.Throwable -> L54
            if (r0 == 0) goto L63
            goto L56
        L54:
            r6 = move-exception
            goto L8e
        L56:
            r0 = 4
            if (r7 != r0) goto L5a
            goto L5f
        L5a:
            if (r8 == 0) goto L5e
            r0 = 3
            goto L5f
        L5e:
            r0 = r3
        L5f:
            java.lang.String r6 = com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil.e(r6, r0)     // Catch: java.lang.Throwable -> L54
        L63:
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L54
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L54
            com.cloud.hisavana.sdk.e4 r8 = com.cloud.hisavana.sdk.e4.b()     // Catch: java.lang.Throwable -> L54
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54
            r0.<init>()     // Catch: java.lang.Throwable -> L54
            java.lang.String r4 = "[jsbridge]isMaterialExit: file path is "
            r0.append(r4)     // Catch: java.lang.Throwable -> L54
            r0.append(r6)     // Catch: java.lang.Throwable -> L54
            java.lang.String r6 = r0.toString()     // Catch: java.lang.Throwable -> L54
            r8.w(r2, r6)     // Catch: java.lang.Throwable -> L54
            boolean r6 = r7.exists()     // Catch: java.lang.Throwable -> L54
            if (r6 == 0) goto L8d
            boolean r6 = r7.isFile()     // Catch: java.lang.Throwable -> L54
            if (r6 == 0) goto L8d
            r1 = r3
        L8d:
            return r1
        L8e:
            com.cloud.hisavana.sdk.e4 r7 = com.cloud.hisavana.sdk.e4.b()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "getMaterialPathByUrl, error:"
            r8.append(r0)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.w(r2, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.bridge.HisavanaAdJsBridge.isMaterialExist(java.lang.String, int, boolean):boolean");
    }

    @JavascriptInterface
    public boolean openPsDetail(String str, String str2) {
        if (a7.c.p()) {
            e4.b().d(INTERFACE_NAME, "[jsbridge]start openPsDetail: showId = " + str + ", adInfo = " + str2);
        }
        try {
            if (!e.h()) {
                e4.b().w(INTERFACE_NAME, "[jsbridge]openPsDetail failed, HSCoreUtil is not init.");
                return false;
            }
            AdsDTO adsDTO = (AdsDTO) GsonUtil.a(str2, AdsDTO.class);
            if (adsDTO == null) {
                AthenaTracker.F(null, str, false);
                AthenaTracker.E(null, str, null, false);
                e4.b().w(INTERFACE_NAME, "[jsbridge]openPsDetail failed, adsDTO is null.");
                return false;
            }
            adsDTO.setUuid(str);
            AdxImpBean adxImpBean = new AdxImpBean();
            adxImpBean.pmid = adsDTO.getJsCodeSeatId();
            adxImpBean.triggerId = adsDTO.getJsTriggerId();
            adxImpBean.requestId = adsDTO.getJsRequestId();
            adsDTO.setImpBeanRequest(adxImpBean);
            adsDTO.setPslinkInfo(N0.F(adsDTO));
            AthenaTracker.F(adsDTO.getJsTriggerId(), str, false);
            return i(adsDTO);
        } catch (Exception e11) {
            e4.b().w(INTERFACE_NAME, "[jsbridge]openPsDetail failed, error: " + Log.getStackTraceString(e11));
            AthenaTracker.F(null, str, false);
            AthenaTracker.E(null, str, null, false);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0117 A[Catch: all -> 0x0013, TRY_ENTER, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0003, B:5:0x0009, B:8:0x0016, B:10:0x001c, B:13:0x0026, B:16:0x0067, B:19:0x0072, B:21:0x007b, B:22:0x007f, B:24:0x00c1, B:27:0x00ca, B:29:0x00f3, B:31:0x00f9, B:33:0x0103, B:36:0x0117, B:38:0x0127, B:41:0x00d0, B:43:0x00db, B:45:0x00e6, B:47:0x00e0), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0127 A[Catch: all -> 0x0013, TRY_LEAVE, TryCatch #0 {all -> 0x0013, blocks: (B:3:0x0003, B:5:0x0009, B:8:0x0016, B:10:0x001c, B:13:0x0026, B:16:0x0067, B:19:0x0072, B:21:0x007b, B:22:0x007f, B:24:0x00c1, B:27:0x00ca, B:29:0x00f3, B:31:0x00f9, B:33:0x0103, B:36:0x0117, B:38:0x0127, B:41:0x00d0, B:43:0x00db, B:45:0x00e6, B:47:0x00e0), top: B:2:0x0003 }] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.webkit.WebResourceResponse shouldInterceptRequest(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.bridge.HisavanaAdJsBridge.shouldInterceptRequest(java.lang.String):android.webkit.WebResourceResponse");
    }

    @JavascriptInterface
    public void showAdmAdFromJs(String str, String str2, String str3, String str4, String str5) {
        AdsDTO adsDTO;
        if (!isAlphaNumeric(str4)) {
            e4.b().d(INTERFACE_NAME, "[jsbridge] showId is invalid，showId =null");
            str4 = "";
        }
        if (!e.h()) {
            e4.b().w(INTERFACE_NAME, "[jsbridge]openPsDetail failed, HSCoreUtil is not init.");
            g(d(str4, 2, TaErrorCode.CODE_UNINIT), null);
            return;
        }
        try {
            adsDTO = (AdsDTO) GsonUtil.a(str5, AdsDTO.class);
        } catch (Exception unused) {
            e4.b().w(INTERFACE_NAME, "showAdmAdFromJs: adInfo is not available");
            adsDTO = null;
        }
        if (adsDTO == null) {
            g(d(str4, 2, 6000), null);
            return;
        }
        adsDTO.setUuid(str4);
        AdxImpBean adxImpBean = new AdxImpBean();
        adxImpBean.pmid = str;
        adxImpBean.triggerId = str2;
        adxImpBean.requestId = str3;
        adsDTO.setImpBeanRequest(adxImpBean);
        adsDTO.setFromJs(true);
        adsDTO.setPslinkInfo(N0.F(adsDTO));
        AthenaTracker.B(adsDTO, 1, 0);
        s3 s3Var = new s3(new q3.b().e(adsDTO.getCodeSeatId()).g());
        s3Var.g(new a(s3Var, this, adsDTO));
        g(d(str4, 1, 0), null);
        s3Var.H(adsDTO);
    }

    @JavascriptInterface
    public void trackAdShow(String str) {
        try {
            if (e.a() == null) {
                e4.b().w(INTERFACE_NAME, "[jsbridge]trackAdShow failed, HSCoreUtil is not init.");
                return;
            }
            AdsDTO adsDTO = (AdsDTO) GsonUtil.a(str, AdsDTO.class);
            if (adsDTO == null) {
                e4.b().w(INTERFACE_NAME, "[jsbridge]handleShow failed, adsDTO is null.");
                return;
            }
            adsDTO.setShowReportTimeType(1);
            r2.a(adsDTO);
            DownUpPointBean downUpPointBean = new DownUpPointBean(0.0f, 0.0f, 0.0f, 0.0f, adsDTO.getImageWidth().intValue(), adsDTO.getImageHeight().intValue());
            adsDTO.setClickid(j3.a());
            c1.o(adsDTO.getShowTrackingUrls(), adsDTO, downUpPointBean);
            y yVar = y.f23172a;
            yVar.C(adsDTO);
            yVar.Q();
            if (adsDTO.getImpBeanRequest() != null) {
                P.g().k(adsDTO.getImpBeanRequest().pmid);
                if (adsDTO.getSource() == 4) {
                    Z.f21623a.q(adsDTO.getAdCreativeId(), adsDTO.getCodeSeatId());
                } else if (adsDTO.isOfflineAd()) {
                    adsDTO.setShowNum(Integer.valueOf(adsDTO.getShowNum().intValue() + 1));
                    c0.F().q(adsDTO);
                } else {
                    u0.f23073a.a(adsDTO);
                }
            }
            AdsDTO m679clone = adsDTO.m679clone();
            m679clone.setShowReportTimeType(2);
            r2.b(m679clone);
        } catch (Throwable th2) {
            e4.b().w(INTERFACE_NAME, "[jsbridge]handleShow failed, error: " + th2);
        }
    }

    @JavascriptInterface
    public void trackJSEvent(String str, int i11, String str2) {
        try {
            if (e.a() == null) {
                e4.b().w(INTERFACE_NAME, "[jsbridge]trackJSEvent failed, HSCoreUtil is not init.");
                return;
            }
            if (!TextUtils.isEmpty(str) && i11 > 0 && !TextUtils.isEmpty(str2)) {
                AthenaTracker.P(null, str, str2, i11);
                return;
            }
            e4.b().w(INTERFACE_NAME, "[jsbridge]trackJSEvent failed, info is empty.");
        } catch (Throwable th2) {
            e4.b().w(INTERFACE_NAME, "[jsbridge]handleShow failed, error: " + th2);
        }
    }

    public void updateWebViewReference(WebView webView) {
        this.f21785e = new WeakReference(webView);
        Context context = webView == null ? null : webView.getContext();
        if (e.a() != null || context == null) {
            return;
        }
        e.i(context);
    }
}
