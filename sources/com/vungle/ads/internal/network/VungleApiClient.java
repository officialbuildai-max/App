package com.vungle.ads.internal.network;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.app.NotificationCompat;
import com.aliyun.player.BuildConfig;
import com.cloud.config.utils.XLogUtil;
import com.cloud.tmc.integration.permission.PermissionConstant;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.UserAgentError;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.model.c;
import com.vungle.ads.internal.model.d;
import com.vungle.ads.internal.privacy.COPPA;
import com.vungle.ads.internal.privacy.PrivacyManager;
import com.vungle.ads.internal.protos.Sdk$MetricBatch;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKErrorBatch;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.util.o;
import com.vungle.ads.x;
import com.vungle.ads.y;
import com.vungle.ads.z;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.n;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/* loaded from: classes7.dex */
public final class VungleApiClient {
    private static final String TAG = "VungleApiClient";
    private com.vungle.ads.internal.model.a advertisingInfo;
    private VungleApi api;
    private com.vungle.ads.internal.model.b appBody;
    private final Context applicationContext;
    private com.vungle.ads.internal.model.d baseDeviceInfo;
    private final com.vungle.ads.internal.persistence.b filePreferences;
    private VungleApi gzipApi;
    private Boolean isGooglePlayServicesAvailable;
    private final com.vungle.ads.internal.platform.d platform;
    private Interceptor responseInterceptor;
    private Map<String, Long> retryAfterDataMap;
    private final Lazy signalManager$delegate;
    private String uaString;
    public static final a Companion = new a(null);
    private static final String BASE_URL = "https://config.ads.vungle.com/";
    private static final Set<Interceptor> networkInterceptors = new HashSet();
    private static final Set<Interceptor> logInterceptors = new HashSet();
    private static final kotlinx.serialization.json.a json = n.b(null, new Function1<kotlinx.serialization.json.d, Unit>() { // from class: com.vungle.ads.internal.network.VungleApiClient$Companion$json$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((kotlinx.serialization.json.d) obj);
            return Unit.f67184a;
        }

        public final void invoke(kotlinx.serialization.json.d Json) {
            Intrinsics.h(Json, "$this$Json");
            Json.f(true);
            Json.d(true);
            Json.e(false);
        }
    }, 1, null);

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getBASE_URL$vungle_ads_release() {
            return VungleApiClient.BASE_URL;
        }

        public final void reset$vungle_ads_release() {
            k.INSTANCE.reset();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements Interceptor {
        private static final String CONTENT_ENCODING = "Content-Encoding";
        public static final a Companion = new a(null);
        private static final String GZIP = "gzip";

        /* loaded from: classes7.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* renamed from: com.vungle.ads.internal.network.VungleApiClient$b$b, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0737b extends RequestBody {
            final /* synthetic */ Buffer $output;
            final /* synthetic */ RequestBody $requestBody;

            C0737b(RequestBody requestBody, Buffer buffer) {
                this.$requestBody = requestBody;
                this.$output = buffer;
            }

            @Override // okhttp3.RequestBody
            public long contentLength() {
                return this.$output.size();
            }

            @Override // okhttp3.RequestBody
            /* renamed from: contentType */
            public MediaType getContentType() {
                return this.$requestBody.getContentType();
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink sink) throws IOException {
                Intrinsics.h(sink, "sink");
                sink.write(this.$output.snapshot());
            }
        }

        private final RequestBody gzip(RequestBody requestBody) throws IOException {
            Buffer buffer = new Buffer();
            BufferedSink buffer2 = Okio.buffer(new GzipSink(buffer));
            requestBody.writeTo(buffer2);
            buffer2.close();
            return new C0737b(requestBody, buffer);
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Intrinsics.h(chain, "chain");
            Request request = chain.request();
            RequestBody body = request.body();
            return (body == null || request.header("Content-Encoding") != null) ? chain.proceed(request) : chain.proceed(request.newBuilder().header("Content-Encoding", GZIP).method(request.method(), gzip(body)).build());
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends ProxySelector {
        c() {
        }

        @Override // java.net.ProxySelector
        public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
            try {
                ProxySelector.getDefault().connectFailed(uri, socketAddress, iOException);
            } catch (Exception unused) {
            }
        }

        @Override // java.net.ProxySelector
        public List<Proxy> select(URI uri) {
            try {
                List<Proxy> select = ProxySelector.getDefault().select(uri);
                Intrinsics.g(select, "{\n                      …ri)\n                    }");
                return select;
            } catch (Exception unused) {
                return CollectionsKt.e(Proxy.NO_PROXY);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements androidx.core.util.a {
        final /* synthetic */ x $uaMetric;
        final /* synthetic */ VungleApiClient this$0;

        d(x xVar, VungleApiClient vungleApiClient) {
            this.$uaMetric = xVar;
            this.this$0 = vungleApiClient;
        }

        @Override // androidx.core.util.a
        public void accept(String str) {
            if (str == null) {
                o.Companion.e(VungleApiClient.TAG, "Cannot Get UserAgent. Setting Default Device UserAgent");
                new UserAgentError().logErrorNoReturnValue$vungle_ads_release();
            } else {
                this.$uaMetric.markEnd();
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.$uaMetric, (com.vungle.ads.internal.util.n) null, (String) null, 6, (Object) null);
                this.this$0.uaString = str;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements com.vungle.ads.internal.network.b {
        final /* synthetic */ AnalyticsClient.a $requestListener;

        e(AnalyticsClient.a aVar) {
            this.$requestListener = aVar;
        }

        @Override // com.vungle.ads.internal.network.b
        public void onFailure(com.vungle.ads.internal.network.a aVar, Throwable th2) {
            this.$requestListener.onFailure();
        }

        @Override // com.vungle.ads.internal.network.b
        public void onResponse(com.vungle.ads.internal.network.a aVar, com.vungle.ads.internal.network.e eVar) {
            this.$requestListener.onSuccess();
        }
    }

    /* loaded from: classes7.dex */
    public static final class f implements com.vungle.ads.internal.network.b {
        final /* synthetic */ AnalyticsClient.a $requestListener;

        f(AnalyticsClient.a aVar) {
            this.$requestListener = aVar;
        }

        @Override // com.vungle.ads.internal.network.b
        public void onFailure(com.vungle.ads.internal.network.a aVar, Throwable th2) {
            this.$requestListener.onFailure();
        }

        @Override // com.vungle.ads.internal.network.b
        public void onResponse(com.vungle.ads.internal.network.a aVar, com.vungle.ads.internal.network.e eVar) {
            this.$requestListener.onSuccess();
        }
    }

    /* loaded from: classes7.dex */
    public static final class g implements com.vungle.ads.internal.network.b {
        g() {
        }

        @Override // com.vungle.ads.internal.network.b
        public void onFailure(com.vungle.ads.internal.network.a aVar, Throwable th2) {
        }

        @Override // com.vungle.ads.internal.network.b
        public void onResponse(com.vungle.ads.internal.network.a aVar, com.vungle.ads.internal.network.e eVar) {
        }
    }

    public VungleApiClient(final Context applicationContext, com.vungle.ads.internal.platform.d platform, com.vungle.ads.internal.persistence.b filePreferences) {
        Intrinsics.h(applicationContext, "applicationContext");
        Intrinsics.h(platform, "platform");
        Intrinsics.h(filePreferences, "filePreferences");
        this.applicationContext = applicationContext;
        this.platform = platform;
        this.filePreferences = filePreferences;
        this.uaString = System.getProperty("http.agent");
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        this.signalManager$delegate = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<SignalManager>() { // from class: com.vungle.ads.internal.network.VungleApiClient$special$$inlined$inject$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.signals.SignalManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SignalManager invoke() {
                return ServiceLocator.Companion.getInstance(applicationContext).getService(SignalManager.class);
            }
        });
        this.retryAfterDataMap = new ConcurrentHashMap();
        this.responseInterceptor = new Interceptor() { // from class: com.vungle.ads.internal.network.j
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                Response m1063responseInterceptor$lambda0;
                m1063responseInterceptor$lambda0 = VungleApiClient.m1063responseInterceptor$lambda0(VungleApiClient.this, chain);
                return m1063responseInterceptor$lambda0;
            }
        };
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder proxySelector = builder.readTimeout(60L, timeUnit).connectTimeout(60L, timeUnit).addInterceptor(this.responseInterceptor).proxySelector(new c());
        OkHttpClient build = proxySelector.build();
        OkHttpClient build2 = proxySelector.addInterceptor(new b()).build();
        this.api = new VungleApiImpl(build);
        this.gzipApi = new VungleApiImpl(build2);
    }

    private final String bodyToString(RequestBody requestBody) {
        try {
            Buffer buffer = new Buffer();
            if (requestBody == null) {
                return "";
            }
            requestBody.writeTo(buffer);
            return buffer.readUtf8();
        } catch (Exception unused) {
            return "";
        }
    }

    private final Response defaultErrorResponse(Request request) {
        return new Response.Builder().request(request).code(500).protocol(Protocol.HTTP_1_1).message("Server is busy").body(ResponseBody.INSTANCE.create("{\"Error\":\"Server is busy\"}", MediaType.INSTANCE.parse("application/json"))).build();
    }

    public static /* synthetic */ void getAppBody$vungle_ads_release$annotations() {
    }

    private final com.vungle.ads.internal.model.d getBasicDeviceBody(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = context.getSystemService("window");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        if (defaultDisplay != null) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.g(MANUFACTURER, "MANUFACTURER");
        String MODEL = Build.MODEL;
        Intrinsics.g(MODEL, "MODEL");
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.g(RELEASE, "RELEASE");
        com.vungle.ads.internal.model.d dVar = new com.vungle.ads.internal.model.d(MANUFACTURER, MODEL, RELEASE, com.vungle.ads.internal.platform.c.Companion.getCarrierName$vungle_ads_release(context), Intrinsics.c("Amazon", MANUFACTURER) ? "amazon" : "android", displayMetrics.widthPixels, displayMetrics.heightPixels, this.uaString, (String) null, (Integer) null, (d.c) null, 1792, (DefaultConstructorMarker) null);
        try {
            String userAgent = this.platform.getUserAgent();
            this.uaString = userAgent;
            dVar.setUa(userAgent);
            initUserAgentLazy();
            com.vungle.ads.internal.model.a aVar = this.advertisingInfo;
            if (aVar == null) {
                aVar = this.platform.getAdvertisingInfo();
            }
            this.advertisingInfo = aVar;
        } catch (Exception e11) {
            o.Companion.e(TAG, "Cannot Get UserAgent. Setting Default Device UserAgent." + e11.getLocalizedMessage());
        }
        return dVar;
    }

    private final String getConnectionType() {
        if (androidx.core.content.b.checkSelfPermission(this.applicationContext, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            return null;
        }
        Object systemService = this.applicationContext.getSystemService("connectivity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "NONE";
        }
        int type = activeNetworkInfo.getType();
        return type != 0 ? (type == 1 || type == 6) ? NetworkUtil.NETWORK_TYPE_WIFI : type != 7 ? type != 9 ? NetworkUtil.NETWORK_TYPE_UNKNOWN : "ETHERNET" : "BLUETOOTH" : "MOBILE";
    }

    private final com.vungle.ads.internal.model.d getDeviceBody() throws IllegalStateException {
        return getDeviceBody$vungle_ads_release(false);
    }

    private final c.h getExtBody(boolean z10) {
        String generateSignals;
        String configExtension = ConfigManager.INSTANCE.getConfigExtension();
        if (configExtension != null && configExtension.length() == 0) {
            configExtension = this.filePreferences.getString("config_extension");
        }
        if (z10) {
            try {
                generateSignals = getSignalManager().generateSignals();
            } catch (Exception e11) {
                o.Companion.e(TAG, "Couldn't convert signals for sending. Error: " + e11.getMessage());
            }
            if ((configExtension != null || configExtension.length() == 0) && (generateSignals == null || generateSignals.length() == 0)) {
                return null;
            }
            return new c.h(configExtension, generateSignals, Long.valueOf(ConfigManager.INSTANCE.configLastValidatedTimestamp()));
        }
        generateSignals = null;
        if (configExtension != null) {
        }
        return null;
    }

    static /* synthetic */ c.h getExtBody$default(VungleApiClient vungleApiClient, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        return vungleApiClient.getExtBody(z10);
    }

    public static /* synthetic */ void getGzipApi$vungle_ads_release$annotations() {
    }

    private final String getPlacementID(RequestBody requestBody) {
        List<String> placements;
        try {
            kotlinx.serialization.json.a aVar = json;
            String bodyToString = bodyToString(requestBody);
            kotlinx.serialization.b b11 = kotlinx.serialization.h.b(aVar.a(), Reflection.m(com.vungle.ads.internal.model.c.class));
            Intrinsics.f(b11, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            c.i request = ((com.vungle.ads.internal.model.c) aVar.b(b11, bodyToString)).getRequest();
            if (request == null || (placements = request.getPlacements()) == null) {
                return "";
            }
            String str = placements.get(0);
            return str == null ? "" : str;
        } catch (Exception unused) {
            return "";
        }
    }

    public static /* synthetic */ void getResponseInterceptor$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getRetryAfterDataMap$vungle_ads_release$annotations() {
    }

    private final SignalManager getSignalManager() {
        return (SignalManager) this.signalManager$delegate.getValue();
    }

    private final c.j getUserBody(boolean z10) {
        c.j jVar = new c.j((c.f) null, (c.C0736c) null, (c.d) null, (ez.b) null, (c.g) null, 31, (DefaultConstructorMarker) null);
        PrivacyManager privacyManager = PrivacyManager.INSTANCE;
        jVar.setGdpr(new c.f(privacyManager.getConsentStatus(), privacyManager.getConsentSource(), privacyManager.getConsentTimestamp(), privacyManager.getConsentMessageVersion()));
        jVar.setCcpa(new c.C0736c(privacyManager.getCcpaStatus()));
        if (privacyManager.getCoppaStatus() != COPPA.COPPA_NOTSET) {
            jVar.setCoppa(new c.d(privacyManager.getCoppaStatus().getValue()));
        }
        if (privacyManager.shouldSendTCFString()) {
            jVar.setIab(new c.g(privacyManager.getIABTCFString()));
        }
        if (z10) {
            jVar.setFpd(z.firstPartyData);
        }
        return jVar;
    }

    static /* synthetic */ c.j getUserBody$default(VungleApiClient vungleApiClient, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        return vungleApiClient.getUserBody(z10);
    }

    private final void initUserAgentLazy() {
        x xVar = new x(Sdk$SDKMetric.SDKMetricType.USER_AGENT_LOAD_DURATION_MS);
        xVar.markStart();
        this.platform.getUserAgentLazy(new d(xVar, this));
    }

    public static /* synthetic */ com.vungle.ads.internal.model.e pingTPAT$default(VungleApiClient vungleApiClient, String str, Map map, String str2, HttpMethod httpMethod, com.vungle.ads.internal.util.n nVar, int i11, Object obj) {
        Map map2 = (i11 & 2) != 0 ? null : map;
        String str3 = (i11 & 4) != 0 ? null : str2;
        if ((i11 & 8) != 0) {
            httpMethod = HttpMethod.GET;
        }
        return vungleApiClient.pingTPAT(str, map2, str3, httpMethod, (i11 & 16) != 0 ? null : nVar);
    }

    public static /* synthetic */ com.vungle.ads.internal.model.c requestBody$default(VungleApiClient vungleApiClient, boolean z10, boolean z11, int i11, Object obj) throws IllegalStateException {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return vungleApiClient.requestBody(z10, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: responseInterceptor$lambda-0, reason: not valid java name */
    public static final Response m1063responseInterceptor$lambda0(VungleApiClient this$0, Interceptor.Chain chain) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(chain, "chain");
        Request request = chain.request();
        try {
            try {
                Response proceed = chain.proceed(request);
                String str = proceed.headers().get("Retry-After");
                if (str != null && str.length() != 0) {
                    try {
                        long parseLong = Long.parseLong(str);
                        if (parseLong > 0) {
                            String encodedPath = request.url().encodedPath();
                            long currentTimeMillis = (parseLong * 1000) + System.currentTimeMillis();
                            if (StringsKt.G(encodedPath, com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, false, 2, null)) {
                                String placementID = this$0.getPlacementID(request.body());
                                if (placementID.length() > 0) {
                                    this$0.retryAfterDataMap.put(placementID, Long.valueOf(currentTimeMillis));
                                }
                            }
                        }
                    } catch (Exception unused) {
                        o.Companion.d(TAG, "Retry-After value is not an valid value");
                    }
                }
                return proceed;
            } catch (Exception e11) {
                o.Companion.e(TAG, "Exception: " + e11.getMessage() + " for " + request.url());
                return this$0.defaultErrorResponse(request);
            }
        } catch (OutOfMemoryError unused2) {
            o.Companion.e(TAG, "OOM for " + request.url());
            return this$0.defaultErrorResponse(request);
        }
    }

    public final void addPlaySvcAvailabilityInCookie(boolean z10) {
        this.filePreferences.put("isPlaySvcAvailable", z10).apply();
    }

    public final boolean checkIsRetryAfterActive(String placementID) {
        Intrinsics.h(placementID, "placementID");
        Long l11 = this.retryAfterDataMap.get(placementID);
        if ((l11 != null ? l11.longValue() : 0L) > System.currentTimeMillis()) {
            return true;
        }
        this.retryAfterDataMap.remove(placementID);
        return false;
    }

    public final com.vungle.ads.internal.network.a config() throws IOException {
        com.vungle.ads.internal.model.b bVar = this.appBody;
        if (bVar == null) {
            return null;
        }
        com.vungle.ads.internal.model.c cVar = new com.vungle.ads.internal.model.c(getDeviceBody$vungle_ads_release(true), bVar, getUserBody$default(this, false, 1, null), (c.h) null, (c.i) null, 24, (DefaultConstructorMarker) null);
        c.h extBody$default = getExtBody$default(this, false, 1, null);
        if (extBody$default != null) {
            cVar.setExt(extBody$default);
        }
        com.vungle.ads.internal.util.g gVar = com.vungle.ads.internal.util.g.INSTANCE;
        String str = BASE_URL;
        if (!gVar.isValidUrl(str)) {
            str = "https://config.ads.vungle.com/";
        }
        if (!StringsKt.G(str, "/", false, 2, null)) {
            str = str + '/';
        }
        return this.api.config(k.INSTANCE.getHeaderUa(), str + XLogUtil.TAG, cVar);
    }

    public final com.vungle.ads.internal.model.b getAppBody$vungle_ads_release() {
        return this.appBody;
    }

    public final String getConnectionTypeDetail(int i11) {
        if (i11 == 1) {
            return "gprs";
        }
        if (i11 == 2) {
            return "edge";
        }
        if (i11 == 20) {
            return "5g";
        }
        switch (i11) {
            case 4:
                return "wcdma";
            case 5:
                return "cdma_evdo_0";
            case 6:
                return "cdma_evdo_a";
            case 7:
                return "cdma_1xrtt";
            case 8:
                return "hsdpa";
            case 9:
                return "hsupa";
            default:
                switch (i11) {
                    case 12:
                        return "cdma_evdo_b";
                    case 13:
                        return "lte";
                    case 14:
                        return "hrpd";
                    default:
                        return TmcConstants.ROUTE_UNKNOWN;
                }
        }
    }

    public final String getConnectionTypeDetail$vungle_ads_release() {
        if (androidx.core.content.b.checkSelfPermission(this.applicationContext, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            return null;
        }
        Object systemService = this.applicationContext.getSystemService("connectivity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        return activeNetworkInfo != null ? getConnectionTypeDetail(activeNetworkInfo.getSubtype()) : TmcConstants.ROUTE_UNKNOWN;
    }

    public final synchronized com.vungle.ads.internal.model.d getDeviceBody$vungle_ads_release(boolean z10) throws IllegalStateException {
        com.vungle.ads.internal.model.d copy;
        d.c cVar;
        String str;
        try {
            com.vungle.ads.internal.model.d dVar = this.baseDeviceInfo;
            if (dVar == null) {
                dVar = getBasicDeviceBody(this.applicationContext);
                this.baseDeviceInfo = dVar;
            }
            copy = r2.copy((r24 & 1) != 0 ? r2.make : null, (r24 & 2) != 0 ? r2.model : null, (r24 & 4) != 0 ? r2.osv : null, (r24 & 8) != 0 ? r2.carrier : null, (r24 & 16) != 0 ? r2.f60760os : null, (r24 & 32) != 0 ? r2.f60762w : 0, (r24 & 64) != 0 ? r2.f60759h : 0, (r24 & 128) != 0 ? r2.f60761ua : null, (r24 & 256) != 0 ? r2.ifa : null, (r24 & 512) != 0 ? r2.lmt : null, (r24 & 1024) != 0 ? dVar.ext : null);
            d.c cVar2 = new d.c(false, (String) null, (Integer) null, 0.0f, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 0.0f, 0, false, 0, false, (String) null, (String) null, (Long) null, (Long) null, (Long) null, 2097151, (DefaultConstructorMarker) null);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Object systemService = this.applicationContext.getSystemService("window");
            Intrinsics.f(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            if (defaultDisplay != null) {
                defaultDisplay.getMetrics(displayMetrics);
            }
            copy.setH(displayMetrics.heightPixels);
            copy.setW(displayMetrics.widthPixels);
            com.vungle.ads.internal.model.a aVar = this.advertisingInfo;
            if (aVar == null) {
                aVar = this.platform.getAdvertisingInfo();
            }
            this.advertisingInfo = aVar;
            String advertisingId = aVar != null ? aVar.getAdvertisingId() : null;
            com.vungle.ads.internal.model.a aVar2 = this.advertisingInfo;
            Boolean valueOf = aVar2 != null ? Boolean.valueOf(aVar2.getLimitAdTracking()) : null;
            PrivacyManager privacyManager = PrivacyManager.INSTANCE;
            if (!privacyManager.shouldSendAdIds()) {
                cVar = cVar2;
            } else if (advertisingId != null) {
                if (Intrinsics.c("Amazon", Build.MANUFACTURER)) {
                    cVar = cVar2;
                    cVar.setAmazonAdvertisingId(advertisingId);
                } else {
                    cVar = cVar2;
                    cVar.setGaid(advertisingId);
                }
                copy.setIfa(advertisingId);
            } else {
                cVar = cVar2;
                copy.setIfa("");
            }
            if (z10 || !privacyManager.shouldSendAdIds()) {
                copy.setIfa(null);
                cVar.setGaid(null);
                cVar.setAmazonAdvertisingId(null);
            }
            Boolean bool = Boolean.TRUE;
            boolean z11 = false;
            copy.setLmt(Intrinsics.c(valueOf, bool) ? 1 : 0);
            cVar.setGooglePlayServicesAvailable(Intrinsics.c(bool, isGooglePlayServicesAvailable()));
            if (privacyManager.allowDeviceIDFromTCF() != PrivacyManager.DeviceIdAllowed.DISABLE_ID) {
                String appSetId = this.platform.getAppSetId();
                if (appSetId != null) {
                    cVar.setAppSetId(appSetId);
                }
                Integer appSetIdScope = this.platform.getAppSetIdScope();
                if (appSetIdScope != null) {
                    cVar.setAppSetIdScope(Integer.valueOf(appSetIdScope.intValue()));
                }
            }
            Intent registerReceiver = this.applicationContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                int intExtra = registerReceiver.getIntExtra(PermissionConstant.level, -1);
                int intExtra2 = registerReceiver.getIntExtra("scale", -1);
                if (intExtra > 0 && intExtra2 > 0) {
                    cVar.setBatteryLevel(intExtra / intExtra2);
                }
                int intExtra3 = registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
                if (intExtra3 == -1) {
                    str = NetworkUtil.NETWORK_TYPE_UNKNOWN;
                } else if (intExtra3 == 2 || intExtra3 == 5) {
                    int intExtra4 = registerReceiver.getIntExtra("plugged", -1);
                    str = intExtra4 != 1 ? intExtra4 != 2 ? intExtra4 != 4 ? "BATTERY_PLUGGED_OTHERS" : "BATTERY_PLUGGED_WIRELESS" : "BATTERY_PLUGGED_USB" : "BATTERY_PLUGGED_AC";
                } else {
                    str = "NOT_CHARGING";
                }
            } else {
                str = NetworkUtil.NETWORK_TYPE_UNKNOWN;
            }
            cVar.setBatteryState(str);
            Object systemService2 = this.applicationContext.getSystemService("power");
            Intrinsics.f(systemService2, "null cannot be cast to non-null type android.os.PowerManager");
            cVar.setBatterySaverEnabled(((PowerManager) systemService2).isPowerSaveMode() ? 1 : 0);
            String connectionType = getConnectionType();
            if (connectionType != null) {
                cVar.setConnectionType(connectionType);
            }
            String connectionTypeDetail$vungle_ads_release = getConnectionTypeDetail$vungle_ads_release();
            if (connectionTypeDetail$vungle_ads_release != null) {
                cVar.setConnectionTypeDetail(connectionTypeDetail$vungle_ads_release);
            }
            cVar.setLocale(Locale.getDefault().toString());
            cVar.setLanguage(Locale.getDefault().getLanguage());
            cVar.setTimeZone(TimeZone.getDefault().getID());
            cVar.setVolumeLevel(this.platform.getVolumeLevel());
            cVar.setSoundEnabled(this.platform.isSoundEnabled() ? 1 : 0);
            if (Intrinsics.c("Amazon", Build.MANUFACTURER)) {
                z11 = this.applicationContext.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv");
            } else {
                Object systemService3 = this.applicationContext.getSystemService("uimode");
                Intrinsics.f(systemService3, "null cannot be cast to non-null type android.app.UiModeManager");
                if (((UiModeManager) systemService3).getCurrentModeType() == 4) {
                    z11 = true;
                }
            }
            cVar.setTv(z11);
            cVar.setSideloadEnabled(this.platform.isSideLoaded());
            cVar.setSdCardAvailable(this.platform.isSdCardPresent() ? 1 : 0);
            if (ConfigManager.INSTANCE.otEnabled()) {
                cVar.setOit(Long.valueOf(this.platform.getOSInstallationTime()));
                cVar.setOrt(Long.valueOf(this.platform.getLastBootTime()));
                cVar.setObt(Long.valueOf(this.platform.getBuildTime()));
            }
            copy.setUa(this.uaString);
            copy.setExt(cVar);
        } catch (Throwable th2) {
            throw th2;
        }
        return copy;
    }

    public final VungleApi getGzipApi$vungle_ads_release() {
        return this.gzipApi;
    }

    public final Boolean getPlayServicesAvailabilityFromAPI() {
        Boolean bool = null;
        try {
            GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
            Intrinsics.g(googleApiAvailabilityLight, "getInstance()");
            boolean z10 = googleApiAvailabilityLight.isGooglePlayServicesAvailable(this.applicationContext) == 0;
            bool = Boolean.valueOf(z10);
            addPlaySvcAvailabilityInCookie(z10);
            return bool;
        } catch (Exception unused) {
            o.Companion.w(TAG, "Unexpected exception from Play services lib.");
            return bool;
        } catch (NoClassDefFoundError unused2) {
            o.Companion.w(TAG, "Play services Not available");
            Boolean bool2 = Boolean.FALSE;
            try {
                addPlaySvcAvailabilityInCookie(false);
                return bool2;
            } catch (Exception unused3) {
                o.Companion.w(TAG, "Failure to write GPS availability to DB");
                return bool2;
            }
        }
    }

    public final Boolean getPlayServicesAvailabilityFromCookie() {
        return this.filePreferences.getBoolean("isPlaySvcAvailable");
    }

    public final Interceptor getResponseInterceptor$vungle_ads_release() {
        return this.responseInterceptor;
    }

    public final Map<String, Long> getRetryAfterDataMap$vungle_ads_release() {
        return this.retryAfterDataMap;
    }

    public final long getRetryAfterHeaderValue(String placementID) {
        Intrinsics.h(placementID, "placementID");
        Long l11 = this.retryAfterDataMap.get(placementID);
        if (l11 != null) {
            return l11.longValue();
        }
        return 0L;
    }

    public final synchronized void initialize(String appId) {
        PackageInfo packageInfo;
        PackageManager.PackageInfoFlags of2;
        try {
            Intrinsics.h(appId, "appId");
            k.INSTANCE.setAppId(appId);
            String str = BuildConfig.VERSION_NAME;
            try {
                if (Build.VERSION.SDK_INT >= 33) {
                    PackageManager packageManager = this.applicationContext.getPackageManager();
                    String packageName = this.applicationContext.getPackageName();
                    of2 = PackageManager.PackageInfoFlags.of(0L);
                    packageInfo = packageManager.getPackageInfo(packageName, of2);
                    Intrinsics.g(packageInfo, "{\n                    ap…      )\n                }");
                } else {
                    packageInfo = this.applicationContext.getPackageManager().getPackageInfo(this.applicationContext.getPackageName(), 0);
                    Intrinsics.g(packageInfo, "{\n                    ap…      )\n                }");
                }
                String str2 = packageInfo.versionName;
                Intrinsics.g(str2, "packageInfo.versionName");
                str = str2;
            } catch (Exception unused) {
            }
            k.INSTANCE.setAppVersion(str);
            this.baseDeviceInfo = getBasicDeviceBody(this.applicationContext);
            String packageName2 = this.applicationContext.getPackageName();
            Intrinsics.g(packageName2, "applicationContext.packageName");
            this.appBody = new com.vungle.ads.internal.model.b(packageName2, str, appId);
            this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromAPI();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final Boolean isGooglePlayServicesAvailable() {
        if (this.isGooglePlayServicesAvailable == null) {
            this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromCookie();
        }
        if (this.isGooglePlayServicesAvailable == null) {
            this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromAPI();
        }
        return this.isGooglePlayServicesAvailable;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
    
        r3 = r2.raw();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a3, code lost:
    
        if (r3 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a5, code lost:
    
        r3 = java.lang.Integer.valueOf(r3.code());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.vungle.ads.internal.model.e pingTPAT(java.lang.String r18, java.util.Map<java.lang.String, java.lang.String> r19, java.lang.String r20, com.vungle.ads.internal.network.HttpMethod r21, com.vungle.ads.internal.util.n r22) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.network.VungleApiClient.pingTPAT(java.lang.String, java.util.Map, java.lang.String, com.vungle.ads.internal.network.HttpMethod, com.vungle.ads.internal.util.n):com.vungle.ads.internal.model.e");
    }

    public final void reportErrors(BlockingQueue<Sdk$SDKError.a> errors, AnalyticsClient.a requestListener) {
        Intrinsics.h(errors, "errors");
        Intrinsics.h(requestListener, "requestListener");
        String errorLoggingEndpoint = ConfigManager.INSTANCE.getErrorLoggingEndpoint();
        if (errorLoggingEndpoint.length() == 0) {
            requestListener.onFailure();
            return;
        }
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        for (Sdk$SDKError.a aVar : errors) {
            aVar.setSessionId(getSignalManager().getUuid());
            com.vungle.ads.internal.model.g placement = ConfigManager.INSTANCE.getPlacement(aVar.getPlacementReferenceId());
            if (placement != null) {
                aVar.setIsHbPlacement(placement.getHeaderBidding() ? 1L : 0L);
                String type = placement.getType();
                if (type == null) {
                    type = "";
                }
                aVar.setPlacementType(type);
            }
            String connectionType = getConnectionType();
            if (connectionType != null) {
                aVar.setConnectionType(connectionType);
            }
            String connectionTypeDetail$vungle_ads_release = getConnectionTypeDetail$vungle_ads_release();
            if (connectionTypeDetail$vungle_ads_release != null) {
                aVar.setConnectionTypeDetail(connectionTypeDetail$vungle_ads_release);
            }
            Sdk$SDKError sdk$SDKError = (Sdk$SDKError) aVar.build();
            o.Companion.e(TAG, "Sending Error: " + sdk$SDKError.getReason());
            linkedBlockingQueue.add(sdk$SDKError);
        }
        Sdk$SDKErrorBatch sdk$SDKErrorBatch = (Sdk$SDKErrorBatch) Sdk$SDKErrorBatch.newBuilder().addAllErrors(linkedBlockingQueue).build();
        RequestBody.Companion companion = RequestBody.INSTANCE;
        byte[] byteArray = sdk$SDKErrorBatch.toByteArray();
        Intrinsics.g(byteArray, "batch.toByteArray()");
        this.api.sendErrors(k.INSTANCE.getHeaderUa(), errorLoggingEndpoint, companion.create(byteArray, MediaType.INSTANCE.parse("application/x-protobuf"), 0, sdk$SDKErrorBatch.toByteArray().length)).enqueue(new e(requestListener));
    }

    public final void reportMetrics(BlockingQueue<Sdk$SDKMetric.a> metrics, AnalyticsClient.a requestListener) {
        Intrinsics.h(metrics, "metrics");
        Intrinsics.h(requestListener, "requestListener");
        String metricsEndpoint = ConfigManager.INSTANCE.getMetricsEndpoint();
        if (metricsEndpoint.length() == 0) {
            requestListener.onFailure();
            return;
        }
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        for (Sdk$SDKMetric.a aVar : metrics) {
            aVar.setSessionId(getSignalManager().getUuid());
            com.vungle.ads.internal.model.g placement = ConfigManager.INSTANCE.getPlacement(aVar.getPlacementReferenceId());
            if (placement != null) {
                aVar.setIsHbPlacement(placement.getHeaderBidding() ? 1L : 0L);
                String type = placement.getType();
                if (type == null) {
                    type = "";
                }
                aVar.setPlacementType(type);
            }
            String connectionType = getConnectionType();
            if (connectionType != null) {
                aVar.setConnectionType(connectionType);
            }
            String connectionTypeDetail$vungle_ads_release = getConnectionTypeDetail$vungle_ads_release();
            if (connectionTypeDetail$vungle_ads_release != null) {
                aVar.setConnectionTypeDetail(connectionTypeDetail$vungle_ads_release);
            }
            Sdk$SDKMetric sdk$SDKMetric = (Sdk$SDKMetric) aVar.build();
            o.Companion.e(TAG, "Sending Metric: " + sdk$SDKMetric.getType());
            linkedBlockingQueue.add(sdk$SDKMetric);
        }
        Sdk$MetricBatch sdk$MetricBatch = (Sdk$MetricBatch) Sdk$MetricBatch.newBuilder().addAllMetrics(linkedBlockingQueue).build();
        RequestBody.Companion companion = RequestBody.INSTANCE;
        MediaType parse = MediaType.INSTANCE.parse("application/x-protobuf");
        byte[] byteArray = sdk$MetricBatch.toByteArray();
        Intrinsics.g(byteArray, "batch.toByteArray()");
        this.api.sendMetrics(k.INSTANCE.getHeaderUa(), metricsEndpoint, RequestBody.Companion.create$default(companion, parse, byteArray, 0, 0, 12, (Object) null)).enqueue(new f(requestListener));
    }

    public final com.vungle.ads.internal.network.a requestAd(String placement, y yVar) throws IllegalStateException {
        Intrinsics.h(placement, "placement");
        ConfigManager configManager = ConfigManager.INSTANCE;
        String adsEndpoint = configManager.getAdsEndpoint();
        com.vungle.ads.internal.model.c requestBody = requestBody(!configManager.signalsDisabled(), configManager.fpdEnabled());
        c.i iVar = new c.i(CollectionsKt.e(placement), (c.b) null, (Long) null, (String) null, (String) null, (String) null, 62, (DefaultConstructorMarker) null);
        if (yVar != null) {
            iVar.setAdSize(new c.b(yVar.getWidth(), yVar.getHeight()));
        }
        requestBody.setRequest(iVar);
        return this.gzipApi.ads(k.INSTANCE.getHeaderUa(), adsEndpoint, requestBody);
    }

    public final com.vungle.ads.internal.model.c requestBody(boolean z10, boolean z11) throws IllegalStateException {
        com.vungle.ads.internal.model.c cVar = new com.vungle.ads.internal.model.c(getDeviceBody(), this.appBody, getUserBody(z11), (c.h) null, (c.i) null, 24, (DefaultConstructorMarker) null);
        c.h extBody = getExtBody(z10);
        if (extBody != null) {
            cVar.setExt(extBody);
        }
        return cVar;
    }

    public final com.vungle.ads.internal.network.a ri(c.i request) {
        com.vungle.ads.internal.model.b bVar;
        Intrinsics.h(request, "request");
        String riEndpoint = ConfigManager.INSTANCE.getRiEndpoint();
        if (riEndpoint == null || riEndpoint.length() == 0 || (bVar = this.appBody) == null) {
            return null;
        }
        com.vungle.ads.internal.model.c cVar = new com.vungle.ads.internal.model.c(getDeviceBody(), bVar, getUserBody$default(this, false, 1, null), (c.h) null, (c.i) null, 24, (DefaultConstructorMarker) null);
        cVar.setRequest(request);
        c.h extBody$default = getExtBody$default(this, false, 1, null);
        if (extBody$default != null) {
            cVar.setExt(extBody$default);
        }
        return this.api.ri(k.INSTANCE.getHeaderUa(), riEndpoint, cVar);
    }

    public final void sendAdMarkup(String adMarkup, String endpoint) {
        Intrinsics.h(adMarkup, "adMarkup");
        Intrinsics.h(endpoint, "endpoint");
        this.api.sendAdMarkup(endpoint, RequestBody.INSTANCE.create(adMarkup, MediaType.INSTANCE.parse("application/json"))).enqueue(new g());
    }

    public final void setAppBody$vungle_ads_release(com.vungle.ads.internal.model.b bVar) {
        this.appBody = bVar;
    }

    public final void setGzipApi$vungle_ads_release(VungleApi vungleApi) {
        Intrinsics.h(vungleApi, "<set-?>");
        this.gzipApi = vungleApi;
    }

    public final void setResponseInterceptor$vungle_ads_release(Interceptor interceptor) {
        Intrinsics.h(interceptor, "<set-?>");
        this.responseInterceptor = interceptor;
    }

    public final void setRetryAfterDataMap$vungle_ads_release(Map<String, Long> map) {
        Intrinsics.h(map, "<set-?>");
        this.retryAfterDataMap = map;
    }
}
