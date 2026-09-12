package com.cloud.hisavana.net;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import bi.g;
import com.cloud.hisavana.net.disklrucache.ImageCacheURL;
import com.cloud.hisavana.net.disklrucache.impl.IDiskCache;
import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import com.cloud.hisavana.net.impl.IHttpCallback;
import com.cloud.hisavana.net.ssl.HttpsTrustManager;
import com.cloud.hisavana.net.utils.ByteBufferUtil;
import com.cloud.sdk.commonutil.util.c;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.chromium.net.NetworkException;
import org.chromium.net.QuicException;

/* loaded from: classes.dex */
public class CommonOkHttpClient {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f21400a;

    /* renamed from: b, reason: collision with root package name */
    private static Dispatcher f21401b;

    /* renamed from: c, reason: collision with root package name */
    private static EventListener.Factory f21402c;

    /* renamed from: d, reason: collision with root package name */
    private static Exception f21403d = new Exception("http response body is empty");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class GeneralOkHttpClient {

        /* renamed from: a, reason: collision with root package name */
        private static final OkHttpClient f21409a = b().build();

        private GeneralOkHttpClient() {
        }

        private static OkHttpClient.Builder b() {
            OkHttpClient.Builder eventListenerFactory;
            g gVar = new g(CommonOkHttpClient.f21402c, 0, CommonOkHttpClient.f21400a);
            if (CommonOkHttpClient.f21400a) {
                OkHttpClient.Builder hostnameVerifier = new OkHttpClient.Builder().sslSocketFactory(HttpsTrustManager.a(), new HttpsTrustManager()).hostnameVerifier(new HttpsTrustManager.TrustAllHostnameVerifier());
                TimeUnit timeUnit = TimeUnit.SECONDS;
                eventListenerFactory = hostnameVerifier.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).dispatcher(CommonOkHttpClient.f21401b != null ? CommonOkHttpClient.f21401b : new Dispatcher()).eventListenerFactory(gVar);
            } else {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit2 = TimeUnit.SECONDS;
                eventListenerFactory = builder.connectTimeout(30L, timeUnit2).readTimeout(30L, timeUnit2).writeTimeout(30L, timeUnit2).dispatcher(CommonOkHttpClient.f21401b != null ? CommonOkHttpClient.f21401b : new Dispatcher()).eventListenerFactory(gVar);
            }
            c.netLog("getBuilder: isTestRequest = " + CommonOkHttpClient.f21400a);
            return NetGroup.f(eventListenerFactory, gVar, NetGroup.e());
        }
    }

    private CommonOkHttpClient() {
        throw new IllegalStateException("Utility class");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h(RequestParams requestParams, String str, Response response, byte[] bArr) {
        String str2 = "";
        try {
            IDiskCache g11 = DiskLruCacheUtil.g(requestParams.getCacheMode());
            if (requestParams.getIsUseCache() && g11 != null && response.code() < 300) {
                ImageCacheURL imageCacheURL = new ImageCacheURL(str);
                str2 = requestParams.getIsDownloadVideo() ? g11.d(imageCacheURL, response) : g11.b(imageCacheURL, bArr);
                if (Log.isLoggable("ADSDK", 3)) {
                    c.netLog("url :" + str + " , write cache finish.  filePath = " + str2);
                }
            }
        } catch (Exception e11) {
            c.netLog("cacheToDisk is failure, " + Log.getStackTraceString(e11));
        }
        return str2;
    }

    public static Call i(RequestParams requestParams, Request request, IHttpCallback iHttpCallback) {
        IDiskCache g11;
        if (Log.isLoggable("ADSDK", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("downLoadImg okhttp------> run Current Looper:");
            sb2.append(Looper.myLooper() == Looper.getMainLooper() ? "Main Looper" : "thread Looper");
            c.netLog(sb2.toString());
        }
        try {
            if (requestParams.getIsUseCache() && (g11 = DiskLruCacheUtil.g(requestParams.getCacheMode())) != null) {
                File c11 = g11.c(new ImageCacheURL(request.url().getUrl()));
                if (c11 == null || !c11.exists() || c11.length() <= 0) {
                    return p(requestParams, request, iHttpCallback);
                }
                if (Log.isLoggable("ADSDK", 3)) {
                    c.netLog("image url:" + request.url());
                    c.netLog("image path:" + c11.getPath());
                }
                if (iHttpCallback != null) {
                    if (requestParams.getIsFetchFilePath()) {
                        iHttpCallback.e(250, ByteBufferUtil.c(ByteBufferUtil.a(c11)), c11.getPath());
                    } else {
                        iHttpCallback.c(250, ByteBufferUtil.c(ByteBufferUtil.a(c11)));
                    }
                    return null;
                }
            }
        } catch (IOException e11) {
            c.netLog("downLoadImg: --> " + Log.getStackTraceString(e11));
            if (iHttpCallback != null && 0 != 0) {
                iHttpCallback.d(256, null, e11);
            }
        }
        return p(requestParams, request, iHttpCallback);
    }

    public static Call j(Request request, final IHttpCallback iHttpCallback) {
        try {
            Call newCall = l().newCall(request);
            FirebasePerfOkHttpClient.enqueue(newCall, new Callback() { // from class: com.cloud.hisavana.net.CommonOkHttpClient.1
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    try {
                        IHttpCallback iHttpCallback2 = IHttpCallback.this;
                        if (iHttpCallback2 == null) {
                            return;
                        }
                        if (iOException instanceof SocketTimeoutException) {
                            iHttpCallback2.d(481, null, iOException);
                        } else if (iOException instanceof UnknownHostException) {
                            iHttpCallback2.d(484, null, iOException);
                        } else if (iOException instanceof NoRouteToHostException) {
                            iHttpCallback2.d(485, null, iOException);
                        } else if (iOException instanceof ProtocolException) {
                            iHttpCallback2.d(486, null, iOException);
                        } else if (iOException instanceof ConnectException) {
                            iHttpCallback2.d(483, null, iOException);
                        } else if (iOException instanceof QuicException) {
                            iHttpCallback2.d(487, null, iOException);
                        } else if (iOException instanceof NetworkException) {
                            IHttpCallback.this.d(CommonOkHttpClient.k(((NetworkException) iOException).getErrorCode()), null, iOException);
                        } else {
                            iHttpCallback2.d(480, null, iOException);
                        }
                    } catch (Throwable th2) {
                        IHttpCallback iHttpCallback3 = IHttpCallback.this;
                        if (iHttpCallback3 != null) {
                            iHttpCallback3.d(480, null, iOException);
                        }
                        CommonOkHttpClient.o(th2);
                    }
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    try {
                        IHttpCallback iHttpCallback2 = IHttpCallback.this;
                        if (iHttpCallback2 == null) {
                            return;
                        }
                        if (response == null) {
                            iHttpCallback2.d(1027, null, CommonOkHttpClient.f21403d);
                        } else {
                            ResponseBody body = response.body();
                            IHttpCallback.this.f(response.code(), body == null ? new byte[0] : body.bytes(), response.headers());
                        }
                    } catch (Exception e11) {
                        if (response != null) {
                            IHttpCallback.this.d(response.code(), null, e11);
                        }
                    }
                }
            });
            return newCall;
        } catch (Throwable th2) {
            if (iHttpCallback != null) {
                iHttpCallback.d(480, null, th2);
            }
            o(th2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(int i11) {
        if (i11 == 1) {
            return 1101;
        }
        if (i11 == 2) {
            return 1102;
        }
        if (i11 == 3) {
            return 1103;
        }
        if (i11 == 4) {
            return 1104;
        }
        if (i11 == 5) {
            return 1105;
        }
        if (i11 == 6) {
            return 1106;
        }
        if (i11 == 7) {
            return 1107;
        }
        if (i11 == 8) {
            return 1108;
        }
        if (i11 == 9) {
            return 1109;
        }
        if (i11 == 10) {
            return 1110;
        }
        return i11 == 11 ? 1111 : 480;
    }

    public static OkHttpClient l() {
        return GeneralOkHttpClient.f21409a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.length() > 0;
    }

    public static Call n(Request request, final IHttpCallback iHttpCallback) {
        if (iHttpCallback != null) {
            iHttpCallback.a();
        }
        try {
            Call newCall = l().newCall(request);
            FirebasePerfOkHttpClient.enqueue(newCall, new Callback() { // from class: com.cloud.hisavana.net.CommonOkHttpClient.2
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    try {
                        IHttpCallback iHttpCallback2 = IHttpCallback.this;
                        if (iHttpCallback2 == null) {
                            return;
                        }
                        if (iOException instanceof SocketTimeoutException) {
                            iHttpCallback2.d(481, null, iOException);
                        } else if (iOException instanceof UnknownHostException) {
                            iHttpCallback2.d(484, null, iOException);
                        } else if (iOException instanceof NoRouteToHostException) {
                            iHttpCallback2.d(485, null, iOException);
                        } else if (iOException instanceof ProtocolException) {
                            iHttpCallback2.d(486, null, iOException);
                        } else if (iOException instanceof ConnectException) {
                            iHttpCallback2.d(483, null, iOException);
                        } else if (iOException instanceof QuicException) {
                            iHttpCallback2.d(487, null, iOException);
                        } else if (iOException instanceof NetworkException) {
                            IHttpCallback.this.d(CommonOkHttpClient.k(((NetworkException) iOException).getErrorCode()), null, iOException);
                        } else {
                            iHttpCallback2.d(480, null, iOException);
                        }
                    } catch (Throwable th2) {
                        IHttpCallback iHttpCallback3 = IHttpCallback.this;
                        if (iHttpCallback3 != null) {
                            iHttpCallback3.d(480, null, iOException);
                        }
                        CommonOkHttpClient.o(th2);
                    }
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    try {
                        IHttpCallback iHttpCallback2 = IHttpCallback.this;
                        if (iHttpCallback2 == null) {
                            return;
                        }
                        if (response == null) {
                            iHttpCallback2.d(1027, null, CommonOkHttpClient.f21403d);
                        } else {
                            ResponseBody body = response.body();
                            IHttpCallback.this.f(response.code(), body == null ? new byte[0] : body.bytes(), response.headers());
                        }
                    } catch (Exception e11) {
                        if (response != null) {
                            IHttpCallback.this.d(response.code(), null, e11);
                        }
                    }
                }
            });
            return newCall;
        } catch (Throwable th2) {
            if (iHttpCallback != null) {
                iHttpCallback.d(480, null, th2);
            }
            o(th2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(Throwable th2) {
        if (!Log.isLoggable("ADSDK", 3) || th2 == null) {
            return;
        }
        c.netLog("onFailure:  " + Log.getStackTraceString(th2));
    }

    private static Call p(final RequestParams requestParams, final Request request, final IHttpCallback iHttpCallback) {
        try {
            Call newCall = l().newCall(request);
            FirebasePerfOkHttpClient.enqueue(newCall, new Callback() { // from class: com.cloud.hisavana.net.CommonOkHttpClient.3
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    try {
                        IHttpCallback iHttpCallback2 = IHttpCallback.this;
                        if (iHttpCallback2 == null) {
                            return;
                        }
                        if (iOException instanceof SocketTimeoutException) {
                            iHttpCallback2.d(481, null, iOException);
                        } else if (iOException instanceof UnknownHostException) {
                            iHttpCallback2.d(484, null, iOException);
                        } else if (iOException instanceof NoRouteToHostException) {
                            iHttpCallback2.d(485, null, iOException);
                        } else if (iOException instanceof ProtocolException) {
                            iHttpCallback2.d(486, null, iOException);
                        } else if (iOException instanceof ConnectException) {
                            iHttpCallback2.d(483, null, iOException);
                        } else if (iOException instanceof QuicException) {
                            iHttpCallback2.d(487, null, iOException);
                        } else if (iOException instanceof NetworkException) {
                            IHttpCallback.this.d(CommonOkHttpClient.k(((NetworkException) iOException).getErrorCode()), null, iOException);
                        } else {
                            iHttpCallback2.d(480, null, iOException);
                        }
                    } catch (Throwable th2) {
                        IHttpCallback iHttpCallback3 = IHttpCallback.this;
                        if (iHttpCallback3 != null) {
                            iHttpCallback3.d(480, null, iOException);
                        }
                        CommonOkHttpClient.o(th2);
                    }
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    try {
                    } catch (Exception e11) {
                        IHttpCallback iHttpCallback2 = IHttpCallback.this;
                        if (iHttpCallback2 != null && response != null) {
                            iHttpCallback2.d(response.code(), null, e11);
                        }
                    }
                    if (IHttpCallback.this == null) {
                        return;
                    }
                    if (response == null || !response.isSuccessful()) {
                        IHttpCallback.this.d(1027, null, CommonOkHttpClient.f21403d);
                    } else {
                        byte[] bytes = requestParams.getIsDownloadVideo() ? new byte[0] : response.body().bytes();
                        if (!requestParams.getIsFetchFilePath()) {
                            IHttpCallback.this.f(response.code(), bytes, response.headers());
                        }
                        String h11 = CommonOkHttpClient.h(requestParams, request.url().getUrl(), response, bytes);
                        if (Log.isLoggable("ADSDK", 3)) {
                            c.netLog("real download on response, code = " + response.code() + ", adId = " + requestParams.getAdCreativeId() + ", \nurl = " + request.url() + " , \nfilePath = " + h11);
                        }
                        if (requestParams.getIsFetchFilePath()) {
                            if (CommonOkHttpClient.m(h11)) {
                                IHttpCallback.this.e(response.code(), bytes, h11);
                            } else {
                                IHttpCallback.this.d(1026, null, new Exception("fail to cache file to disk"));
                            }
                        }
                    }
                    IHttpCallback iHttpCallback3 = IHttpCallback.this;
                    if (iHttpCallback3 != null) {
                        iHttpCallback3.b();
                    }
                }
            });
            return newCall;
        } catch (Throwable th2) {
            if (iHttpCallback != null) {
                iHttpCallback.d(480, null, th2);
            }
            o(th2);
            return null;
        }
    }

    public static void q(Dispatcher dispatcher, EventListener.Factory factory) {
        f21401b = dispatcher;
        f21402c = factory;
    }

    public static void r(Dispatcher dispatcher) {
        q(dispatcher, null);
    }
}
