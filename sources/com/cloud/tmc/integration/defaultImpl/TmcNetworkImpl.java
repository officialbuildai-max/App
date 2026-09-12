package com.cloud.tmc.integration.defaultImpl;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.bridge.NativeRequestBridge;
import com.cloud.tmc.integration.net.ProgressRequestBody;
import com.cloud.tmc.integration.net.ProgressRequestListener;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.integration.utils.RegexUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.network.IAbortCallback;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.network.IResponseCallback;
import com.cloud.tmc.kernel.proxy.network.IUploadCallback;
import com.cloud.tmc.kernel.proxy.network.PackageDownloadCallback;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.kernel.utils.ProcessUtils;
import com.cloud.tmc.launcherlib.LauncherFrameworkConstants;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.tmc.network.HttpClient;
import com.tmc.network.HttpClientConfig;
import com.tmc.network.HttpRequestor;
import com.tmc.network.INetworkCallback;
import com.tmc.network.NetworkConfig;
import com.tmc.network.ProgressListener;
import com.transsion.api.gateway.config.WorkMode;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Timeout;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 R2\u00020\u0001:\u0001RB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001c\u0010$\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010%\u001a\u00020\u001fH\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002Jb\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00062\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0006\u00100\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0016J@\u00101\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00062\b\u00104\u001a\u0004\u0018\u0001052\b\u0010(\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u00010\u0006H\u0002J@\u00108\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00062\b\u00104\u001a\u0004\u0018\u0001052\b\u0010(\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u00010\u0006H\u0002JP\u00109\u001a\u00020\u001f2\b\u0010:\u001a\u0004\u0018\u00010\u00062\b\u0010;\u001a\u0004\u0018\u00010\u00062\b\u0010<\u001a\u0004\u0018\u00010\u00062\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010=2\b\u00107\u001a\u0004\u0018\u00010\u00062\b\u0010(\u001a\u0004\u0018\u000106H\u0016JM\u0010>\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00062\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0006\u00100\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0096\u0002J \u0010?\u001a\u0004\u0018\u00010\u00062\u0014\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010=H\u0002J\u0014\u0010?\u001a\u0004\u0018\u00010\u00062\b\u0010A\u001a\u0004\u0018\u00010\u000fH\u0002Jb\u0010B\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00062\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0006\u00100\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0016JV\u0010C\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00062\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u00100\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0016Jb\u0010F\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00062\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0014\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0006\u00100\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0016Jb\u0010H\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00062\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0006\u00100\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0016Jb\u0010I\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00062\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0006\u00100\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0016J\"\u0010J\u001a\u00020K2\u0006\u0010+\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u00010\u00062\u0006\u0010(\u001a\u00020LH\u0002J*\u0010M\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010N\u001a\u00020\u001fH\u0016J6\u0010O\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010L2\b\u00107\u001a\u0004\u0018\u00010\u0006H\u0002Jt\u0010P\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u00010\u00062\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\u0006\u00100\u001a\u00020\u00142\u0006\u0010(\u001a\u00020LH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR1\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000ej\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR1\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000ej\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u0006S"}, d2 = {"Lcom/cloud/tmc/integration/defaultImpl/TmcNetworkImpl;", "Lcom/cloud/tmc/kernel/proxy/network/INetWorkProxy;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "downloadMap", "Ljava/util/HashMap;", "Lokhttp3/Call;", "Lkotlin/collections/HashMap;", "getDownloadMap", "()Ljava/util/HashMap;", "isNetworkImprove", "", "()Z", "setNetworkImprove", "(Z)V", "requestMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getRequestMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "uploadMap", "getUploadMap", "cancelDownloadCall", "", "id", "abortCallback", "Lcom/cloud/tmc/kernel/proxy/network/IAbortCallback;", "cancelHttpRequest", "cancelUploadCall", "clearDownloadCall", "convertHttpCallback", "Lcom/tmc/network/INetworkCallback;", "callback", "Lcom/cloud/tmc/kernel/proxy/network/IResponseCallback;", RequestParameters.SUBRESOURCE_DELETE, "url", "headers", "", "params", "formData", "useCommonHeader", "downloadCancel", "errorCode", "errorMsg", "e", "Ljava/io/IOException;", "Lcom/cloud/tmc/kernel/proxy/network/PackageDownloadCallback;", "callbackId", "downloadFail", "downloadPackage", "appId", "downloadUrl", "downloadPath", "", "get", "getCallId", "header", "call", "post", "postJson", "json", "", "postMultipart", "multipartData", "postV2", "put", "registerUploadIntercept", "Lokhttp3/Interceptor;", "Lcom/cloud/tmc/kernel/proxy/network/IUploadCallback;", "requestFail", "startPreConnect", "uploadFail", "uploadFile", NativeRequestBridge.KEY_FILE_PATH, "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TmcNetworkImpl implements INetWorkProxy {
    public static final int TIME_OUT_VALUE = 60000;
    private String TAG;
    private final Context context;
    private final HashMap<String, Call> downloadMap;
    private boolean isNetworkImprove;
    private final ConcurrentHashMap<String, Call> requestMap;
    private final HashMap<String, Call> uploadMap;

    public TmcNetworkImpl(Context context) {
        Intrinsics.h(context, "context");
        this.context = context;
        this.TAG = "TmcNetworkImpl";
        this.downloadMap = new HashMap<>();
        this.uploadMap = new HashMap<>();
        this.requestMap = new ConcurrentHashMap<>();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(AppDynamicBuildConfig.getMINI_APP_BASE_URL());
            arrayList.add(AppDynamicBuildConfig.getBASE_OSS_URL());
            ProcessUtils.isMiniProcess();
            if (ProcessUtils.isMiniProcess()) {
                NetworkConfig networkConfig = NetworkConfig.INSTANCE;
                networkConfig.setPreHostList(arrayList);
                if (System.currentTimeMillis() % 10 < ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getInt(context, LauncherFrameworkConstants.LAUNCHER_GLOBAL_KEYS, TmcConstants.KEY_NETWORK_IMPROVE)) {
                    this.isNetworkImprove = true;
                }
                networkConfig.setNetworkImproveEnable(this.isNetworkImprove);
            }
            HttpRequestor.Companion companion = HttpRequestor.INSTANCE;
            companion.setLoggable(false);
            HttpRequestor companion2 = companion.getInstance();
            if (companion2 != null) {
                companion2.init(context, "Lp84tK50u1uwuN3zNQ", Intrinsics.c(AppDynamicBuildConfig.getMINI_API_WORK_MODE(), OfflineConstantsKt.OFFLINE_DOWNLOAD_MODE_TEST) ? WorkMode.MODE_TEST : WorkMode.MODE_ONLINE, new ProgressListener() { // from class: com.cloud.tmc.integration.defaultImpl.TmcNetworkImpl.1
                    @Override // com.tmc.network.ProgressListener
                    public void onProgress(long currentBytes, long contentLength, boolean done) {
                        TmcLogger.e(TmcNetworkImpl.this.getTAG(), "currentBytes=" + currentBytes + ", contentLength=" + contentLength + ", done=" + done);
                    }
                }, true);
            }
            try {
                companion.setPostMode(MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_REQUEST_POST_MODE, true));
            } catch (Throwable th2) {
                TmcLogger.e(this.TAG, "setPostMode error: " + th2);
            }
        } catch (Throwable th3) {
            TmcLogger.e(this.TAG, th3);
        }
    }

    private final INetworkCallback convertHttpCallback(final IResponseCallback callback) {
        return new INetworkCallback() { // from class: com.cloud.tmc.integration.defaultImpl.TmcNetworkImpl$convertHttpCallback$1
            @Override // com.tmc.network.INetworkCallback
            public void onFailure(Call call, Exception e11) {
                String callId;
                Intrinsics.h(e11, "e");
                IResponseCallback iResponseCallback = callback;
                callId = TmcNetworkImpl.this.getCallId(call);
                TmcNetworkImpl.this.requestFail("R004", "Http Request Fail,onFailure_" + e11 + ":R004", iResponseCallback, callId);
            }

            @Override // com.tmc.network.INetworkCallback
            public void onResponse(Call call, Response response) {
                String callId;
                String callId2;
                String callId3;
                Intrinsics.h(call, "call");
                Intrinsics.h(response, "response");
                try {
                    if (response.code() != 200) {
                        TmcNetworkImpl tmcNetworkImpl = TmcNetworkImpl.this;
                        String valueOf = String.valueOf(response.code());
                        String str = "Http Request Fail,response.code=" + response.code() + ":" + response.code();
                        IResponseCallback iResponseCallback = callback;
                        callId2 = TmcNetworkImpl.this.getCallId(call);
                        tmcNetworkImpl.requestFail(valueOf, str, iResponseCallback, callId2);
                        return;
                    }
                    ResponseBody body = response.body();
                    if (body != null) {
                        TmcNetworkImpl tmcNetworkImpl2 = TmcNetworkImpl.this;
                        IResponseCallback iResponseCallback2 = callback;
                        String string = body.string();
                        List<Cookie> parseAll = Cookie.INSTANCE.parseAll(response.request().url(), response.headers());
                        Headers headers = response.headers();
                        Set<String> names = headers.names();
                        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.e(CollectionsKt.v(names, 10)), 16));
                        for (Object obj : names) {
                            linkedHashMap.put(obj, headers.get((String) obj));
                        }
                        callId3 = tmcNetworkImpl2.getCallId(call);
                        if (!TextUtils.isEmpty(callId3) && tmcNetworkImpl2.getRequestMap().containsKey(callId3)) {
                            TypeIntrinsics.d(tmcNetworkImpl2.getRequestMap()).remove(callId3);
                        }
                        iResponseCallback2.onSuccess(response.code(), string, linkedHashMap, parseAll, callId3);
                    }
                } catch (Throwable th2) {
                    IResponseCallback iResponseCallback3 = callback;
                    callId = TmcNetworkImpl.this.getCallId(call);
                    TmcNetworkImpl.this.requestFail("R005", "Http Request Fail,onResponse_" + th2 + ":R005", iResponseCallback3, callId);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadCancel(String url, String errorCode, String errorMsg, IOException e11, PackageDownloadCallback callback, String callbackId) {
        if (callback != null) {
            try {
                callback.onCancel(url, callbackId);
            } catch (Throwable unused) {
                return;
            }
        }
        TmcLogger.e(this.TAG, "errorCode: " + errorCode + " errorMsg: " + errorMsg);
        if (TextUtils.isEmpty(callbackId) || !this.downloadMap.containsKey(callbackId)) {
            return;
        }
        TypeIntrinsics.d(this.downloadMap).remove(callbackId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadFail(String url, String errorCode, String errorMsg, IOException e11, PackageDownloadCallback callback, String callbackId) {
        if (callback != null) {
            try {
                callback.onFailed(url, errorCode, errorMsg, e11, callbackId);
            } catch (Throwable unused) {
                return;
            }
        }
        TmcLogger.e(this.TAG, errorMsg);
        if (TextUtils.isEmpty(callbackId) || !this.downloadMap.containsKey(callbackId)) {
            return;
        }
        TypeIntrinsics.d(this.downloadMap).remove(callbackId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCallId(Map<String, String> header) {
        if (header == null || !header.containsKey("callbackId")) {
            return null;
        }
        return header.get("callbackId");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCallId(Call call) {
        if (call == null || !call.request().headers().names().contains("callbackId")) {
            return null;
        }
        return call.request().header("callbackId");
    }

    private final Interceptor registerUploadIntercept(final String url, final String callbackId, final IUploadCallback callback) {
        return new Interceptor() { // from class: com.cloud.tmc.integration.defaultImpl.TmcNetworkImpl$registerUploadIntercept$1
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) {
                MediaType mediaType;
                String str;
                Intrinsics.h(chain, "chain");
                Request request = chain.request();
                Request.Builder newBuilder = request.newBuilder();
                if (request.header("upload") != null) {
                    String method = request.method();
                    RequestBody body = request.body();
                    final IUploadCallback iUploadCallback = IUploadCallback.this;
                    final String str2 = url;
                    final String str3 = callbackId;
                    newBuilder.method(method, new ProgressRequestBody(body, new ProgressRequestListener() { // from class: com.cloud.tmc.integration.defaultImpl.TmcNetworkImpl$registerUploadIntercept$1$intercept$1
                        @Override // com.cloud.tmc.integration.net.ProgressRequestListener
                        public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                            IUploadCallback.this.progressUpdate(str2, (int) (((((float) bytesWritten) * 1.0f) / ((float) contentLength)) * 100), str3, bytesWritten, contentLength);
                        }
                    }));
                }
                Response proceed = chain.proceed(newBuilder.build());
                ResponseBody body2 = proceed.body();
                if (body2 == null || (mediaType = body2.get$contentType()) == null) {
                    mediaType = MediaType.INSTANCE.get("multipart/form-data");
                }
                ResponseBody body3 = proceed.body();
                if (body3 == null || (str = body3.string()) == null) {
                    str = "";
                }
                return proceed.newBuilder().body(ResponseBody.INSTANCE.create(mediaType, str)).build();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestFail(String errorCode, String errorMsg, IResponseCallback callback, String callbackId) {
        try {
            callback.onFailure(errorCode, errorMsg, callbackId);
            TmcLogger.e(this.TAG, errorMsg);
            if (TextUtils.isEmpty(callbackId) || !this.requestMap.containsKey(callbackId)) {
                return;
            }
            TypeIntrinsics.d(this.requestMap).remove(callbackId);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uploadFail(String url, String errorCode, String errorMsg, IUploadCallback callback, String callbackId) {
        if (callback != null) {
            try {
                callback.onFailed(url, errorCode, errorMsg, callbackId);
            } catch (Throwable unused) {
                return;
            }
        }
        TmcLogger.e(this.TAG, errorMsg);
        if (TextUtils.isEmpty(callbackId) || !this.uploadMap.containsKey(callbackId)) {
            return;
        }
        TypeIntrinsics.d(this.uploadMap).remove(callbackId);
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public void cancelDownloadCall(String id2, IAbortCallback abortCallback) {
        boolean isEmpty;
        TmcLogger.d(this.TAG, "cancelDownloadCall, id: " + id2);
        try {
            Call call = this.downloadMap.get(id2);
            if (call != null && !call.getCanceled()) {
                Call call2 = this.downloadMap.get(id2);
                if (call2 != null) {
                    call2.cancel();
                }
                if (abortCallback != null) {
                    abortCallback.success();
                }
            } else if (abortCallback != null) {
                abortCallback.fail("download task un exist");
            }
        } catch (Throwable th2) {
            if (abortCallback != null) {
                try {
                    abortCallback.fail(th2.toString());
                } finally {
                    if (!TextUtils.isEmpty(id2) && this.downloadMap.containsKey(id2)) {
                        TypeIntrinsics.d(this.downloadMap).remove(id2);
                    }
                }
            }
            TmcLogger.e("cancel downloadCall error");
            if (TextUtils.isEmpty(id2) || !this.downloadMap.containsKey(id2)) {
                return;
            }
        }
        if (isEmpty) {
            return;
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public void cancelHttpRequest(String id2, IAbortCallback abortCallback) {
        boolean isEmpty;
        Intrinsics.h(id2, "id");
        TmcLogger.d(this.TAG, "cancelHttpRequest, id: " + id2);
        try {
            Call call = this.requestMap.get(id2);
            if (call != null && !call.getCanceled()) {
                Call call2 = this.requestMap.get(id2);
                if (call2 != null) {
                    call2.cancel();
                }
                if (abortCallback != null) {
                    abortCallback.success();
                }
            } else if (abortCallback != null) {
                abortCallback.fail("request task un exist");
            }
        } catch (Throwable th2) {
            if (abortCallback != null) {
                try {
                    abortCallback.fail(th2.toString());
                } finally {
                    if (!TextUtils.isEmpty(id2) && this.requestMap.containsKey(id2)) {
                        this.requestMap.remove(id2);
                    }
                }
            }
            TmcLogger.e("cancel requestCall error:" + th2);
            if (TextUtils.isEmpty(id2) || !this.requestMap.containsKey(id2)) {
                return;
            }
        }
        if (isEmpty) {
            return;
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public void cancelUploadCall(String id2, IAbortCallback abortCallback) {
        boolean isEmpty;
        TmcLogger.d(this.TAG, "cancelUploadCall, id: " + id2);
        try {
            Call call = this.uploadMap.get(id2);
            if (call != null && !call.getCanceled()) {
                Call call2 = this.uploadMap.get(id2);
                if (call2 != null) {
                    call2.cancel();
                }
                if (abortCallback != null) {
                    abortCallback.success();
                }
            } else if (abortCallback != null) {
                abortCallback.fail("upload task un exist");
            }
        } catch (Throwable th2) {
            if (abortCallback != null) {
                try {
                    abortCallback.fail(th2.toString());
                } finally {
                    if (!TextUtils.isEmpty(id2) && this.uploadMap.containsKey(id2)) {
                        TypeIntrinsics.d(this.uploadMap).remove(id2);
                    }
                }
            }
            TmcLogger.e("cancel uploadCall error");
            if (TextUtils.isEmpty(id2) || !this.uploadMap.containsKey(id2)) {
                return;
            }
        }
        if (isEmpty) {
            return;
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public void clearDownloadCall() {
        TmcLogger.d(this.TAG, "clearDownloadCall");
        try {
            Iterator<Map.Entry<String, Call>> it = this.downloadMap.entrySet().iterator();
            while (it.hasNext()) {
                Call value = it.next().getValue();
                if (value != null && !value.getCanceled()) {
                    value.cancel();
                }
            }
        } catch (Throwable unused) {
            TmcLogger.e("clear downloadMap error");
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public /* bridge */ /* synthetic */ void delete(String str, Map map, Map map2, Map map3, Boolean bool, IResponseCallback iResponseCallback) {
        delete(str, (Map<String, String>) map, (Map<String, String>) map2, (Map<String, String>) map3, bool.booleanValue(), iResponseCallback);
    }

    public void delete(String url, Map<String, String> headers, Map<String, String> params, Map<String, String> formData, boolean useCommonHeader, IResponseCallback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(callback, "callback");
        try {
            TmcLogger.d(this.TAG, "delete, url: " + url);
            HttpRequestor companion = HttpRequestor.INSTANCE.getInstance();
            Call delete = companion != null ? companion.delete(url, AppPrepareUtils.INSTANCE.getCommonHeader(headers, useCommonHeader), params, formData, convertHttpCallback(callback)) : null;
            String callId = getCallId(headers);
            if (callId != null) {
                this.requestMap.put(callId, delete);
            }
        } catch (Throwable th2) {
            requestFail("R002", "Http Request Fail,Exception_" + th2 + ":R002", callback, getCallId(headers));
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public void downloadPackage(String appId, final String downloadUrl, final String downloadPath, final Map<String, String> headers, final String callbackId, final PackageDownloadCallback callback) {
        String str;
        Timeout timeout;
        HttpClient httpClient;
        if (appId != null) {
            try {
                if (appId.length() != 0) {
                    if (downloadUrl != null && downloadUrl.length() != 0 && RegexUtils.isURL(downloadUrl)) {
                        if (downloadPath != null && downloadPath.length() != 0) {
                            TmcLogger.d(this.TAG, "downloadPackage, downloadUrl: " + downloadUrl);
                            Request.Builder url = new Request.Builder().url(downloadUrl);
                            if (headers != null) {
                                url.headers(Headers.INSTANCE.of(headers));
                            }
                            if (callbackId != null) {
                                url.addHeader("callbackId", callbackId);
                            }
                            Request build = url.build();
                            HttpRequestor companion = HttpRequestor.INSTANCE.getInstance();
                            Call newCall = (companion == null || (httpClient = companion.getHttpClient()) == null) ? null : httpClient.newCall(build);
                            if (headers != null && (str = headers.get(NativeRequestBridge.KEY_TIME_OUT)) != null) {
                                long parseLong = Long.parseLong(str);
                                if (newCall != null && (timeout = newCall.timeout()) != null) {
                                    timeout.timeout(parseLong, TimeUnit.MILLISECONDS);
                                }
                            }
                            this.downloadMap.put(appId, newCall);
                            if (newCall != null) {
                                FirebasePerfOkHttpClient.enqueue(newCall, new Callback() { // from class: com.cloud.tmc.integration.defaultImpl.TmcNetworkImpl$downloadPackage$2
                                    @Override // okhttp3.Callback
                                    public void onFailure(Call call, IOException e11) {
                                        String callId;
                                        String callId2;
                                        Intrinsics.h(call, "call");
                                        Intrinsics.h(e11, "e");
                                        if (call.getCanceled() || Intrinsics.c("Canceled", e11.getMessage())) {
                                            PackageDownloadCallback packageDownloadCallback = callback;
                                            callId = TmcNetworkImpl.this.getCallId((Map<String, String>) headers);
                                            TmcNetworkImpl.this.downloadCancel(downloadUrl, "D006", "Download Fail,onFailure_" + e11 + ":D006", e11, packageDownloadCallback, callId);
                                            return;
                                        }
                                        PackageDownloadCallback packageDownloadCallback2 = callback;
                                        callId2 = TmcNetworkImpl.this.getCallId((Map<String, String>) headers);
                                        TmcNetworkImpl.this.downloadFail(downloadUrl, "D006", "Download Fail,onFailure_" + e11 + ":D006", e11, packageDownloadCallback2, callId2);
                                    }

                                    /* JADX WARN: Removed duplicated region for block: B:76:0x0231 A[Catch: IOException -> 0x01c2, TRY_ENTER, TryCatch #3 {IOException -> 0x01c2, blocks: (B:106:0x01be, B:107:0x01c4, B:76:0x0231, B:78:0x0236), top: B:2:0x0015 }] */
                                    /* JADX WARN: Removed duplicated region for block: B:78:0x0236 A[Catch: IOException -> 0x01c2, TRY_LEAVE, TryCatch #3 {IOException -> 0x01c2, blocks: (B:106:0x01be, B:107:0x01c4, B:76:0x0231, B:78:0x0236), top: B:2:0x0015 }] */
                                    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
                                    @Override // okhttp3.Callback
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                        To view partially-correct add '--show-bad-code' argument
                                    */
                                    public void onResponse(okhttp3.Call r19, okhttp3.Response r20) {
                                        /*
                                            Method dump skipped, instructions count: 640
                                            To view this dump add '--comments-level debug' option
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.defaultImpl.TmcNetworkImpl$downloadPackage$2.onResponse(okhttp3.Call, okhttp3.Response):void");
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        downloadFail(downloadUrl, "D005", "Download Fail,downloadPath is empty:D005", new IOException("Download Fail,downloadPath is empty:D005"), callback, getCallId(headers));
                        return;
                    }
                    downloadFail(downloadUrl, "D004", "Download Fail,downloadUrl is error:D004", new IOException("Download Fail,downloadUrl is error:D004"), callback, getCallId(headers));
                    return;
                }
            } catch (Throwable th2) {
                downloadFail(downloadUrl, "D002", "Download Fail,Exception_" + th2 + ":D002", new IOException(th2), callback, getCallId(headers));
                return;
            }
        }
        downloadFail(downloadUrl, "D003", "Download Fail,appId is empty:D003", new IOException("Download Fail,appId is empty:D003"), callback, getCallId(headers));
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public /* bridge */ /* synthetic */ void get(String str, Map map, Map map2, Boolean bool, IResponseCallback iResponseCallback) {
        get(str, (Map<String, String>) map, (Map<String, String>) map2, bool.booleanValue(), iResponseCallback);
    }

    public void get(String url, Map<String, String> headers, Map<String, String> params, boolean useCommonHeader, IResponseCallback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(callback, "callback");
        try {
            TmcLogger.d(this.TAG, "get, url: " + url);
            HttpRequestor companion = HttpRequestor.INSTANCE.getInstance();
            Call call = companion != null ? companion.get(url, AppPrepareUtils.INSTANCE.getCommonHeader(headers, useCommonHeader), params, convertHttpCallback(callback)) : null;
            String callId = getCallId(headers);
            if (callId != null) {
                this.requestMap.put(callId, call);
            }
        } catch (Throwable th2) {
            requestFail("R002", "Http Request Fail,Exception_" + th2 + ":R002", callback, getCallId(headers));
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final HashMap<String, Call> getDownloadMap() {
        return this.downloadMap;
    }

    public final ConcurrentHashMap<String, Call> getRequestMap() {
        return this.requestMap;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final HashMap<String, Call> getUploadMap() {
        return this.uploadMap;
    }

    /* renamed from: isNetworkImprove, reason: from getter */
    public final boolean getIsNetworkImprove() {
        return this.isNetworkImprove;
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public /* bridge */ /* synthetic */ void post(String str, Map map, Map map2, Map map3, Boolean bool, IResponseCallback iResponseCallback) {
        post(str, (Map<String, String>) map, (Map<String, String>) map2, (Map<String, String>) map3, bool.booleanValue(), iResponseCallback);
    }

    public void post(String url, Map<String, String> headers, Map<String, String> params, Map<String, String> formData, boolean useCommonHeader, IResponseCallback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(callback, "callback");
        try {
            TmcLogger.d(this.TAG, "post, url: " + url);
            HttpRequestor companion = HttpRequestor.INSTANCE.getInstance();
            Call post = companion != null ? companion.post(url, AppPrepareUtils.INSTANCE.getCommonHeader(headers, useCommonHeader), params, formData, convertHttpCallback(callback)) : null;
            String callId = getCallId(headers);
            if (callId != null) {
                this.requestMap.put(callId, post);
            }
        } catch (Throwable th2) {
            requestFail("R002", "Http Request Fail,Exception_" + th2 + ":R002", callback, getCallId(headers));
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public /* bridge */ /* synthetic */ void postJson(String str, Map map, Map map2, Object obj, Boolean bool, IResponseCallback iResponseCallback) {
        postJson(str, (Map<String, String>) map, (Map<String, String>) map2, obj, bool.booleanValue(), iResponseCallback);
    }

    public void postJson(String url, Map<String, String> headers, Map<String, String> params, Object json, boolean useCommonHeader, IResponseCallback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(callback, "callback");
        try {
            TmcLogger.d(this.TAG, "postJson, url: " + url);
            HttpRequestor companion = HttpRequestor.INSTANCE.getInstance();
            Call postJSON = companion != null ? companion.postJSON(url, AppPrepareUtils.INSTANCE.getCommonHeader(headers, useCommonHeader), params, json, convertHttpCallback(callback)) : null;
            String callId = getCallId(headers);
            if (callId != null) {
                this.requestMap.put(callId, postJSON);
            }
        } catch (Throwable th2) {
            requestFail("R002", "Http Request Fail,Exception_" + th2 + ":R002", callback, getCallId(headers));
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public /* bridge */ /* synthetic */ void postMultipart(String str, Map map, Map map2, Map map3, Boolean bool, IResponseCallback iResponseCallback) {
        postMultipart(str, (Map<String, String>) map, (Map<String, String>) map2, (Map<String, String>) map3, bool.booleanValue(), iResponseCallback);
    }

    public void postMultipart(String url, Map<String, String> headers, Map<String, String> params, Map<String, String> multipartData, boolean useCommonHeader, IResponseCallback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(callback, "callback");
        try {
            HttpRequestor companion = HttpRequestor.INSTANCE.getInstance();
            Call postMultipart = companion != null ? companion.postMultipart(url, AppPrepareUtils.INSTANCE.getCommonHeader(headers, useCommonHeader), params, multipartData, convertHttpCallback(callback)) : null;
            String callId = getCallId(headers);
            if (callId != null) {
                this.requestMap.put(callId, postMultipart);
            }
        } catch (Throwable th2) {
            requestFail("R002", "Http Request Fail,Exception_" + th2 + ":R002", callback, getCallId(headers));
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public /* bridge */ /* synthetic */ void postV2(String str, Map map, Map map2, Map map3, Boolean bool, IResponseCallback iResponseCallback) {
        postV2(str, (Map<String, String>) map, (Map<String, String>) map2, (Map<String, String>) map3, bool.booleanValue(), iResponseCallback);
    }

    public void postV2(String url, Map<String, String> headers, Map<String, String> params, Map<String, String> formData, boolean useCommonHeader, IResponseCallback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(callback, "callback");
        try {
            TmcLogger.d(this.TAG, "post, url: " + url);
            HttpRequestor companion = HttpRequestor.INSTANCE.getInstance();
            Call postV2 = companion != null ? companion.postV2(url, AppPrepareUtils.INSTANCE.getCommonHeader(headers, useCommonHeader), params, formData, convertHttpCallback(callback)) : null;
            String callId = getCallId(headers);
            if (callId != null) {
                this.requestMap.put(callId, postV2);
            }
        } catch (Throwable th2) {
            requestFail("R002", "Http Request Fail,Exception_" + th2 + ":R002", callback, getCallId(headers));
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public /* bridge */ /* synthetic */ void put(String str, Map map, Map map2, Map map3, Boolean bool, IResponseCallback iResponseCallback) {
        put(str, (Map<String, String>) map, (Map<String, String>) map2, (Map<String, String>) map3, bool.booleanValue(), iResponseCallback);
    }

    public void put(String url, Map<String, String> headers, Map<String, String> params, Map<String, String> formData, boolean useCommonHeader, IResponseCallback callback) {
        Intrinsics.h(url, "url");
        Intrinsics.h(callback, "callback");
        try {
            TmcLogger.d(this.TAG, "put, url: " + url);
            HttpRequestor companion = HttpRequestor.INSTANCE.getInstance();
            Call put = companion != null ? companion.put(url, AppPrepareUtils.INSTANCE.getCommonHeader(headers, useCommonHeader), params, formData, convertHttpCallback(callback)) : null;
            String callId = getCallId(headers);
            if (callId != null) {
                this.requestMap.put(callId, put);
            }
        } catch (Throwable th2) {
            requestFail("R002", "Http Request Fail,Exception_" + th2 + ":R002", callback, getCallId(headers));
        }
    }

    public final void setNetworkImprove(boolean z10) {
        this.isNetworkImprove = z10;
    }

    public final void setTAG(String str) {
        Intrinsics.h(str, "<set-?>");
        this.TAG = str;
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public void startPreConnect() {
        if (NetworkConfig.INSTANCE.isNetworkImproveEnable()) {
            com.tmc.network.strategy.c cVar = new com.tmc.network.strategy.c(AppDynamicBuildConfig.getMINI_APP_BASE_URL());
            com.tmc.network.strategy.c cVar2 = new com.tmc.network.strategy.c(AppDynamicBuildConfig.getBASE_OSS_URL());
            cVar.a();
            cVar2.a();
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.network.INetWorkProxy
    public /* bridge */ /* synthetic */ void uploadFile(String str, String str2, String str3, Map map, Map map2, Map map3, Boolean bool, IUploadCallback iUploadCallback) {
        uploadFile(str, str2, str3, (Map<String, String>) map, (Map<String, String>) map2, (Map<String, String>) map3, bool.booleanValue(), iUploadCallback);
    }

    public void uploadFile(final String url, String filePath, String callbackId, Map<String, String> headers, Map<String, String> params, Map<String, String> formData, boolean useCommonHeader, final IUploadCallback callback) {
        String str;
        Timeout timeout;
        HttpClientConfig config;
        Intrinsics.h(url, "url");
        Intrinsics.h(filePath, "filePath");
        Intrinsics.h(callback, "callback");
        TmcLogger.d(this.TAG, "uploadFile, url: " + url);
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("callbackId", callbackId == null ? "" : callbackId);
            linkedHashMap.put("upload", "true");
            if (headers != null) {
                linkedHashMap.putAll(headers);
            }
            File file = new File(filePath);
            String str2 = "multipart/form-data";
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    if (StringsKt.H("content-type", entry.getKey(), true)) {
                        str2 = entry.getValue();
                    }
                }
            }
            RequestBody create = RequestBody.INSTANCE.create(MediaType.INSTANCE.parse(str2), file);
            MultipartBody.Builder type = new MultipartBody.Builder(null, 1, null).setType(MultipartBody.FORM);
            if (formData != null) {
                for (Map.Entry<String, String> entry2 : formData.entrySet()) {
                    type.addFormDataPart(entry2.getKey(), entry2.getValue());
                }
            }
            type.addFormDataPart(OfflineConstantsKt.OFFLINE_DOWNLOAD_SEARCH_MODE_FILE, file.getName(), create);
            Request build = new Request.Builder().url(url).post(type.build()).headers(Headers.INSTANCE.of(linkedHashMap)).build();
            HttpRequestor companion = HttpRequestor.INSTANCE.getInstance();
            final HttpClient httpClient = companion != null ? companion.getHttpClient() : null;
            final Interceptor registerUploadIntercept = registerUploadIntercept(url, callbackId, callback);
            if (httpClient != null && (config = httpClient.getConfig()) != null) {
                config.addInterceptor(registerUploadIntercept);
            }
            if (httpClient != null) {
                httpClient.resetHttpClient();
            }
            Call newCall = httpClient != null ? httpClient.newCall(build) : null;
            if (headers != null && (str = headers.get(NativeRequestBridge.KEY_TIME_OUT)) != null) {
                long parseLong = Long.parseLong(str);
                if (newCall != null && (timeout = newCall.timeout()) != null) {
                    timeout.timeout(parseLong, TimeUnit.MILLISECONDS);
                }
            }
            if (callbackId != null) {
                this.uploadMap.put(callbackId, newCall);
            }
            if (newCall != null) {
                FirebasePerfOkHttpClient.enqueue(newCall, new Callback() { // from class: com.cloud.tmc.integration.defaultImpl.TmcNetworkImpl$uploadFile$6
                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException e11) {
                        String callId;
                        List<Interceptor> interceptors;
                        Intrinsics.h(call, "call");
                        Intrinsics.h(e11, "e");
                        HttpClientConfig config2 = HttpClient.this.getConfig();
                        if (config2 != null && (interceptors = config2.getInterceptors()) != null) {
                            interceptors.remove(registerUploadIntercept);
                        }
                        HttpClient.this.resetHttpClient();
                        IUploadCallback iUploadCallback = callback;
                        callId = this.getCallId(call);
                        this.uploadFail(url, "U005", "UploadFile fail,onFailure_" + e11 + ":U005", iUploadCallback, callId);
                    }

                    @Override // okhttp3.Callback
                    public void onResponse(Call call, Response response) {
                        String callId;
                        List<Interceptor> interceptors;
                        Intrinsics.h(call, "call");
                        Intrinsics.h(response, "response");
                        HttpClientConfig config2 = HttpClient.this.getConfig();
                        if (config2 != null && (interceptors = config2.getInterceptors()) != null) {
                            interceptors.remove(registerUploadIntercept);
                        }
                        HttpClient.this.resetHttpClient();
                        callId = this.getCallId(call);
                        if (!TextUtils.isEmpty(callId) && this.getUploadMap().containsKey(callId)) {
                            TypeIntrinsics.d(this.getUploadMap()).remove(callId);
                        }
                        try {
                            if (response.code() != 200 && response.code() != 204) {
                                this.uploadFail(url, String.valueOf(response.code()), "UploadFile fail,response.code=" + response.code() + ":" + response.code(), callback, callId);
                                return;
                            }
                            ResponseBody body = response.body();
                            if (body != null) {
                                callback.onFinish(url, body.string(), callId);
                            }
                        } catch (Throwable th2) {
                            this.uploadFail(url, "U006", "UploadFile fail,onResponse_" + th2 + ":U006", callback, callId);
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            uploadFail(url, "U002", "UploadFile fail,Exception_" + th2 + ":U002", callback, getCallId(headers));
        }
    }
}
