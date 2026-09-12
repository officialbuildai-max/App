package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.a;
import com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener;
import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.hisavana.sdk.data.bean.response.ConfigResponseBody;
import com.cloud.hisavana.sdk.data.bean.response.ConfigTotalDTO;
import com.cloud.hisavana.sdk.data.bean.response.ccofig.CommonConfigDTO;
import com.cloud.hisavana.sdk.data.bean.response.ccofig.CustomConfigManager;
import com.cloud.hisavana.sdk.data.bean.response.ccofig.CustomConfigsKt;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.cloud.sdk.commonutil.util.MitNetUtil;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.transsion.gslb.DomainManager;
import com.vungle.ads.internal.ConfigManager;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class k1 {

    /* renamed from: a, reason: collision with root package name */
    private AtomicBoolean f22665a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f22666b;

    /* renamed from: c, reason: collision with root package name */
    private volatile String f22667c;

    /* renamed from: d, reason: collision with root package name */
    private volatile long f22668d;

    /* renamed from: e, reason: collision with root package name */
    private volatile long f22669e;

    /* renamed from: f, reason: collision with root package name */
    private volatile String f22670f;

    /* renamed from: g, reason: collision with root package name */
    private volatile String f22671g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f22672h;

    /* renamed from: i, reason: collision with root package name */
    private volatile Boolean f22673i;

    /* renamed from: j, reason: collision with root package name */
    private volatile ConfigTotalDTO.ExtInfo f22674j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements a.b {
        a() {
        }

        @Override // com.cloud.hisavana.sdk.common.http.a.b
        public String a() {
            return l1.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends CommonResponseListener<ConfigResponseBody> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f22676b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f22677c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f22678d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f22679e;

        b(long j11, int i11, String str, boolean z10) {
            this.f22676b = j11;
            this.f22677c = i11;
            this.f22678d = str;
            this.f22679e = z10;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            AthenaTracker.J(this.f22677c, this.f22678d, (int) (System.currentTimeMillis() - this.f22676b), 1, taErrorCode == null ? "request error" : taErrorCode.getErrorMessage(), "");
            k1.this.f22665a.set(false);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(int i11, ConfigResponseBody configResponseBody) {
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.CommonResponseListener
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void h(int i11, ConfigResponseBody configResponseBody, String str) {
            long currentTimeMillis = System.currentTimeMillis() - this.f22676b;
            k1.this.f22665a.set(false);
            e4.b().d(ConfigManager.TAG, "onRequestSuccess statusCode " + i11);
            k1.this.f22668d = System.currentTimeMillis();
            j7.a.e().q("requestConfigTime", k1.this.f22668d);
            if (configResponseBody == null || configResponseBody.getCode().intValue() != 0) {
                AthenaTracker.J(this.f22677c, this.f22678d, (int) currentTimeMillis, 1, "response is null or responseCode is wrong", "");
                return;
            }
            ConfigTotalDTO data = configResponseBody.getData();
            AthenaTracker.J(this.f22677c, this.f22678d, (int) currentTimeMillis, 0, "", k1.this.f22667c);
            if (data != null) {
                k1.this.i(data, this.f22677c, true);
                if (TextUtils.isEmpty(str) || !this.f22679e) {
                    return;
                }
                j7.a.e().r("ssp_cloud_config_raw_response", str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final k1 f22681a = new k1(null);
    }

    private k1() {
        this.f22665a = new AtomicBoolean(false);
        this.f22666b = new AtomicBoolean(false);
        this.f22672h = false;
        this.f22673i = Boolean.FALSE;
        this.f22670f = j7.a.e().j("hisavanaRequestUrl");
        this.f22672h = j7.a.e().c("show_ru_style");
        this.f22673i = Boolean.valueOf(j7.a.e().d("is_om_id_enabled", false));
        j(j7.a.e().j("cloudConfigExtInfo"));
        CustomConfigManager.parseCustomTabData();
        CustomConfigManager.parseABTestData();
        CustomConfigManager.parseCommonConfigData();
    }

    /* synthetic */ k1(a aVar) {
        this();
    }

    private String c() {
        if (TextUtils.isEmpty(this.f22671g)) {
            this.f22671g = j7.a.e().j(CustomConfigsKt.DCDN_URL);
        }
        if (TextUtils.isEmpty(this.f22671g) || this.f22671g.equals(DomainManager.BLANK_DOMAIN)) {
            this.f22671g = g7.a.f() + g7.a.i();
        }
        return this.f22671g;
    }

    private void e(int i11) {
        if (i11 != 1) {
            return;
        }
        try {
            if (this.f22666b.compareAndSet(false, true)) {
                int g11 = j7.a.e().g("ssp_sdk_version_code", 0);
                int m11 = i7.c.m();
                j7.a.e().p("ssp_sdk_version_code", m11);
                if (g11 != 0 && g11 < m11) {
                    String j11 = j7.a.e().j("ssp_cloud_config_raw_response");
                    if (TextUtils.isEmpty(j11)) {
                        e4.b().d(ConfigManager.TAG, "checkVersionUpgradeAndReparse: no cached raw response, skip");
                        return;
                    }
                    ConfigResponseBody configResponseBody = (ConfigResponseBody) GsonUtil.a(j11, ConfigResponseBody.class);
                    if (configResponseBody == null || configResponseBody.getCode().intValue() != 0 || configResponseBody.getData() == null) {
                        return;
                    }
                    e4.b().d(ConfigManager.TAG, "checkVersionUpgradeAndReparse: re-parsing for version upgrade " + g11 + " -> " + m11);
                    ConfigTotalDTO data = configResponseBody.getData();
                    if (data != null) {
                        i(data, i11, false);
                    }
                }
            }
        } catch (Throwable th2) {
            e4.b().w(ConfigManager.TAG, "checkVersionUpgradeAndReparse failed: " + th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(int i11, String str) {
        e(i11);
        Map d11 = P.g().d();
        if (d11 != null && !d11.isEmpty()) {
            for (ConfigCodeSeatDTO configCodeSeatDTO : d11.values()) {
                P.g().i(configCodeSeatDTO);
                P.g().b(configCodeSeatDTO);
            }
        }
        boolean c11 = MitNetUtil.c(com.cloud.sdk.commonutil.util.e.a());
        NetStateManager.setIsNetAvailable(c11);
        if (!c11 || this.f22665a.get()) {
            if (i11 != 3) {
                AthenaTracker.j0(null, i11);
                AthenaTracker.Y(null, i11, 2);
            }
            e4.b().e(ConfigManager.TAG, "requestCloudControl net is not available,or is requesting");
            return;
        }
        if (this.f22667c == null) {
            this.f22667c = j7.a.e().k("hisavanaCurrentCloudControlVersion", null);
        }
        if (this.f22667c == null) {
            g(i11, str, true);
            return;
        }
        if (!TextUtils.equals(j7.a.e().j("new_hisavana_ver"), this.f22667c)) {
            g(i11, str, true);
            return;
        }
        if (this.f22668d == 0) {
            this.f22668d = j7.a.e().i("requestConfigTime", 0L);
        }
        if (this.f22669e == 0) {
            this.f22669e = j7.a.e().i("requestConfigInterval", TmcConstants.MINIAPP_TIME_DIFF);
        }
        if (System.currentTimeMillis() - this.f22668d > this.f22669e) {
            g(i11, str, false);
            return;
        }
        e4.b().e(ConfigManager.TAG, "time is not ready");
        if (d11 != null) {
            k(d11.values(), i11);
        } else {
            e4.b().e(ConfigManager.TAG, "requestCloudControl download material fail,config list is null");
        }
    }

    private void g(int i11, String str, boolean z10) {
        if (this.f22665a.get()) {
            e4.b().d(ConfigManager.TAG, "config is requesting");
            return;
        }
        e4.b().d(ConfigManager.TAG, "request type " + i11);
        this.f22665a.set(true);
        AthenaTracker.I(i11, str);
        com.cloud.hisavana.sdk.common.http.a q11 = new com.cloud.hisavana.sdk.common.http.a().m(new b(System.currentTimeMillis(), i11, str, z10)).o(new a()).k(a7.c.p()).q(g7.a.e() + g7.a.d());
        if (q11 != null) {
            q11.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ConfigTotalDTO configTotalDTO, int i11, boolean z10) {
        Boolean bool;
        String str;
        int intValue = configTotalDTO.getCloudControlCacheInterval().intValue();
        if (intValue > 0) {
            this.f22669e = intValue * 3600000;
            j7.a.e().q("requestConfigInterval", this.f22669e);
        }
        this.f22672h = configTotalDTO.isShowRuStyle();
        j7.a.e().o("show_ru_style", this.f22672h);
        if (!this.f22673i.booleanValue() && configTotalDTO.isOmIdEnabled()) {
            s0.c(com.cloud.sdk.commonutil.util.e.a(), true);
        }
        this.f22673i = Boolean.valueOf(configTotalDTO.isOmIdEnabled());
        j7.a.e().o("is_om_id_enabled", this.f22673i.booleanValue());
        if (configTotalDTO.getAdInternalBlackBrands() == null || configTotalDTO.getAdInternalBlackBrands().isEmpty()) {
            j7.a.e().s("ad_internal_black_brands");
        } else {
            e4.b().d(ConfigManager.TAG, " ad internal black brands：" + configTotalDTO.getAdInternalBlackBrands().toString());
            j7.a.e().r("ad_internal_black_brands", TextUtils.join(",", configTotalDTO.getAdInternalBlackBrands()));
        }
        j7.a.e().o("polygamma_init_enable", configTotalDTO.isInitPolyGammaEnable());
        j7.a.e().o("default_is_open", configTotalDTO.getAdInternalRequestEnable());
        Z.f21623a.s(configTotalDTO.getAdInternalRequestEnable());
        k5.b(configTotalDTO.getShowDataSyncTimeInterval(), configTotalDTO.getClickDataSyncTimeInterval());
        String extInfo = configTotalDTO.getExtInfo();
        j7.a.e().r("cloudConfigExtInfo", extInfo);
        j(extInfo);
        CustomConfigManager.saveCustomConfigs(configTotalDTO.getCustomConfigs());
        if (configTotalDTO.getCodeSeats() == null || configTotalDTO.getCodeSeats().isEmpty()) {
            return;
        }
        if (configTotalDTO.getCdnVersionAddressRequestTimeInterval().intValue() > 0) {
            j7.a.e().q("default_interval", configTotalDTO.getCdnVersionAddressRequestTimeInterval().intValue() * 60000);
        }
        if (P.g().f(configTotalDTO.getCodeSeats())) {
            this.f22667c = configTotalDTO.getCloudControlVersion();
            this.f22670f = configTotalDTO.getSspUrl();
            j7.a.e().r("hisavanaCurrentCloudControlVersion", this.f22667c);
            j7.a.e().r("new_hisavana_ver", this.f22667c);
            j7.a.e().r("hisavanaRequestUrl", this.f22670f);
            Boolean preConnectEnable = configTotalDTO.getPreConnectEnable();
            if (preConnectEnable != null) {
                j7.a.e().o("preLoadNet", preConnectEnable.booleanValue());
            }
            CommonConfigDTO commonConfigData = CustomConfigManager.getCommonConfigData();
            if (commonConfigData != null) {
                bool = commonConfigData.getAntifraudPowerEnable();
                str = commonConfigData.getAntifraudSubfunctionControl();
            } else {
                bool = null;
                str = null;
            }
            if (bool != null) {
                i7.a.u0(bool.booleanValue());
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    Integer.parseInt(str, 2);
                    String substring = str.substring(str.indexOf("1"));
                    if (!TextUtils.isEmpty(substring)) {
                        i7.a.t0(substring);
                    }
                } catch (Exception e11) {
                    e4.b().w(com.cloud.sdk.commonutil.util.c.LOAD_TAG, "parsing AntifraudSubfunctionControl failed:" + Log.getStackTraceString(e11));
                }
            }
            if (z10) {
                k(configTotalDTO.getCodeSeats(), i11);
            }
        }
    }

    private void j(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f22674j = null;
        } else {
            try {
                this.f22674j = (ConfigTotalDTO.ExtInfo) GsonUtil.a(str, ConfigTotalDTO.ExtInfo.class);
            } catch (Exception unused) {
            }
        }
    }

    private void k(Collection collection, int i11) {
        c0.F().z(collection, i11);
    }

    public static k1 o() {
        return c.f22681a;
    }

    public ConfigTotalDTO.ExtInfo m() {
        return this.f22674j;
    }

    public void n(final int i11) {
        e4.b().d(ConfigManager.TAG, "requestCloudControl type:" + i11);
        final String o11 = DeviceUtil.o();
        HSScopeHelper.f23249a.i(new Runnable() { // from class: com.cloud.hisavana.sdk.j1
            @Override // java.lang.Runnable
            public final void run() {
                k1.this.f(i11, o11);
            }
        });
    }

    public String q() {
        if (v1.f23105a.b() == 1) {
            return c();
        }
        if (TextUtils.isEmpty(this.f22670f)) {
            this.f22670f = j7.a.e().j("hisavanaRequestUrl");
        }
        if (TextUtils.isEmpty(this.f22670f)) {
            this.f22670f = g7.a.j() + g7.a.i();
        }
        return this.f22670f;
    }

    public boolean r() {
        return this.f22673i.booleanValue();
    }

    public boolean s() {
        return this.f22672h;
    }
}
