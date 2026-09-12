package com.cloud.hisavana.sdk.common.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.cloud.hisavana.sdk.N0;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.WebPageBean;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.common.util.r0;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.ViewJson;
import com.cloud.hisavana.sdk.e4;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import java.io.File;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class OfflineLandingActivity extends com.cloud.hisavana.sdk.common.activity.b {

    /* renamed from: x, reason: collision with root package name */
    c f21866x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends e7.j {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            AdsDTO adsDTO;
            e4.b().d("OfflineLandingActivity", "shouldInterceptRequest URL== " + str);
            WebResourceResponse a11 = r0.a(str);
            if (a11 == null || (adsDTO = OfflineLandingActivity.this.f21964h) == null || !adsDTO.isOfflineAd()) {
                return super.shouldInterceptRequest(webView, str);
            }
            long currentTimeMillis = System.currentTimeMillis();
            OfflineLandingActivity offlineLandingActivity = OfflineLandingActivity.this;
            AthenaTracker.w(offlineLandingActivity.f21964h, currentTimeMillis - offlineLandingActivity.f21968l);
            return a11;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest == null || webResourceRequest.getUrl() == null || TextUtils.isEmpty(webResourceRequest.getUrl().toString())) {
                return false;
            }
            e4.b().d("OfflineLandingActivity", "shouldOverrideUrlLoading url=" + webResourceRequest.getUrl().toString());
            return OfflineLandingActivity.this.g(webResourceRequest.getUrl().toString(), webResourceRequest.hasGesture());
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            e4.b().d("OfflineLandingActivity", "shouldOverrideUrlLoading url=" + str);
            return OfflineLandingActivity.this.g(str, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<Handler> f21868a;

        /* renamed from: b, reason: collision with root package name */
        private final String f21869b;

        private b(Handler handler, String str) {
            this.f21868a = new WeakReference<>(handler);
            this.f21869b = str;
        }

        /* synthetic */ b(Handler handler, String str, a aVar) {
            this(handler, str);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String d11 = com.cloud.hisavana.sdk.common.util.m.d(N0.i(this.f21869b, 1));
                Message obtain = Message.obtain();
                obtain.what = 1;
                Bundle bundle = new Bundle();
                bundle.putString(String.valueOf(1), d11);
                bundle.putString("load_offline_H5_res", this.f21869b);
                obtain.setData(bundle);
                Handler handler = this.f21868a.get();
                if (handler == null) {
                    return;
                }
                handler.sendMessage(obtain);
            } catch (Exception e11) {
                e4.b().e(Log.getStackTraceString(e11));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference f21870a;

        c(OfflineLandingActivity offlineLandingActivity, Looper looper) {
            super(looper);
            this.f21870a = new WeakReference(offlineLandingActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            OfflineLandingActivity offlineLandingActivity = (OfflineLandingActivity) this.f21870a.get();
            if (offlineLandingActivity == null) {
                return;
            }
            if (message.what == 1) {
                offlineLandingActivity.x(message);
            } else {
                e4.b().e("OfflineLandingActivity", "handleMessage,wrong msg.what");
            }
        }
    }

    private void A(String str, String str2) {
        WebView webView;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(com.cloud.hisavana.sdk.common.util.m.b(com.cloud.sdk.commonutil.util.e.a()));
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append("offline_zip");
        sb2.append(str3);
        sb2.append(com.cloud.hisavana.sdk.common.util.a0.c(str));
        sb2.append(str3);
        sb2.append(com.vungle.ads.internal.b.AD_INDEX_FILE_NAME);
        String sb3 = sb2.toString();
        if (new File(sb3).exists() && (webView = this.f21963g) != null) {
            webView.loadUrl(sb3);
        } else {
            e4.b().e("OfflineLandingActivity", "loadOfflineZip file.exists() is false,or webview is null");
            finish();
        }
    }

    private void B(String str) {
        HSScopeHelper.f23249a.g(new b(this.f21866x, str, null));
    }

    private void C() {
        try {
            AdsDTO adsDTO = this.f21964h;
            String clickUrl = adsDTO != null ? adsDTO.getClickUrl() : null;
            if (m(clickUrl)) {
                return;
            }
            q(clickUrl);
            z(this.f21965i);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Message message) {
        Bundle data = message.getData();
        if (data == null || this.f21963g == null) {
            return;
        }
        String string = data.getString(String.valueOf(message.what));
        String string2 = data.getString("load_offline_H5_res");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            e4.b().e("OfflineLandingActivity", "postLoadOfflineH5,dataString or resString is empty");
            this.f21963g.loadUrl(this.f21964h.getOfflineH5Url());
            return;
        }
        WebView webView = this.f21963g;
        if (webView != null) {
            webView.loadDataWithBaseURL(string2, string, "text/html; charset=UTF-8", "UTF-8", null);
        } else {
            e4.b().e("OfflineLandingActivity", "postLoadOfflineH5,webview is null");
            finish();
        }
    }

    private void z(DownUpPointBean downUpPointBean) {
        AdsDTO adsDTO = this.f21964h;
        if (adsDTO == null) {
            e4.b().e("OfflineLandingActivity", "loadOfflineWeb,adsDto is null");
            finish();
            return;
        }
        ViewJson viewJsonData = adsDTO.getViewJsonData();
        if (viewJsonData == null || viewJsonData.getOffline() == null) {
            e4.b().e("OfflineLandingActivity", "loadOfflineWeb,viewJsonData or viewJsonData.getOffline() is null");
            finish();
        } else if (!TextUtils.isEmpty(viewJsonData.getOffline().getRes())) {
            B(viewJsonData.getOffline().getRes());
            AthenaTracker.G(com.cloud.hisavana.sdk.common.activity.b.i(downUpPointBean, this.f21964h), this.f21964h, Boolean.FALSE);
        } else if (TextUtils.isEmpty(viewJsonData.getOffline().getZipRes())) {
            e4.b().e("OfflineLandingActivity", "loadOfflineWeb,can not open landingPage");
            finish();
        } else {
            A(viewJsonData.getOffline().getZipRes(), this.f21964h.getAdCreativeId());
            AthenaTracker.G(com.cloud.hisavana.sdk.common.activity.b.i(downUpPointBean, this.f21964h), this.f21964h, Boolean.FALSE);
        }
    }

    @Override // com.cloud.hisavana.sdk.common.activity.b
    protected WebViewClient h() {
        return new a();
    }

    @Override // com.cloud.hisavana.sdk.common.activity.b, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WebPageBean webPageBean = this.f21974r;
        if (webPageBean != null) {
            webPageBean.setUrl("");
        }
        this.f21866x = new c(this, getMainLooper());
        C();
    }

    @Override // com.cloud.hisavana.sdk.common.activity.b, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        c cVar = this.f21866x;
        if (cVar != null) {
            cVar.removeCallbacksAndMessages(null);
        }
    }
}
