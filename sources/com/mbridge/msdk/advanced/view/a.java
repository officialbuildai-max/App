package com.mbridge.msdk.advanced.view;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.mbridge.msdk.advanced.middle.c;
import com.mbridge.msdk.foundation.same.directory.e;
import com.mbridge.msdk.foundation.tools.i0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.base.b;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.ads.internal.model.AdPayload;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class a extends b {

    /* renamed from: c, reason: collision with root package name */
    private final String f34313c = "NativeAdvancedWebViewClient";

    /* renamed from: d, reason: collision with root package name */
    private final String f34314d;

    /* renamed from: e, reason: collision with root package name */
    private final String f34315e;

    /* renamed from: f, reason: collision with root package name */
    String f34316f;

    /* renamed from: g, reason: collision with root package name */
    com.mbridge.msdk.advanced.middle.a f34317g;

    /* renamed from: h, reason: collision with root package name */
    private c f34318h;

    /* renamed from: com.mbridge.msdk.advanced.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0473a implements ValueCallback<String> {
        C0473a() {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
        }
    }

    public a(String str, com.mbridge.msdk.advanced.middle.a aVar, c cVar) {
        com.mbridge.msdk.foundation.same.directory.c cVar2 = com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_VC;
        this.f34314d = e.b(cVar2) != null ? e.b(cVar2) : i0.a("YkRXhr5AWBPfNgzuH7JQ+2Ha");
        this.f34315e = i0.a("Y+xgWkl2");
        this.f34316f = str;
        this.f34317g = aVar;
        this.f34318h = cVar;
    }

    private WebResourceResponse a(WebView webView, String str) {
        if (!TextUtils.isEmpty(str) && this.f34318h != null) {
            try {
                String str2 = "";
                if (str.startsWith(OfflineConstantsKt.OFFLINE_DOWNLOAD_SEARCH_MODE_FILE) && str.startsWith(this.f34314d)) {
                    str2 = str.replace(AdPayload.FILE_SCHEME, "");
                }
                if (a(str)) {
                    str2 = this.f34318h.a(URLDecoder.decode(Uri.parse(str).getQueryParameter("uri")));
                }
                if (!TextUtils.isEmpty(str2) && a(str2, this.f34314d)) {
                    o0.a("NativeAdvancedWebViewClient", "replace url : " + str2);
                    if (!str2.contains("127.0.0.1") && !str2.startsWith("http")) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(OSSHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
                        WebResourceResponse webResourceResponse = new WebResourceResponse(MimeTypes.VIDEO_MP4, "utf-8", new FileInputStream(str2));
                        webResourceResponse.setResponseHeaders(hashMap);
                        return webResourceResponse;
                    }
                    return null;
                }
            } catch (Throwable th2) {
                o0.b("NativeAdvancedWebViewClient", th2.getMessage());
            }
        }
        return null;
    }

    private boolean a(String str) {
        Uri parse;
        String scheme;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (scheme = parse.getScheme()) == null || TextUtils.isEmpty(scheme)) {
            return false;
        }
        return scheme.equals(this.f34315e) || scheme.equals("mb-h5");
    }

    public void b() {
        if (this.f34318h != null) {
            this.f34318h = null;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        try {
            webView.evaluateJavascript("javascript:" + com.mbridge.msdk.setting.util.a.a().b(), new C0473a());
        } catch (Throwable th2) {
            o0.b("NativeAdvancedWebViewClient", "onPageStarted", th2);
        }
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return a(webView, webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return a(webView, str);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            try {
                WindVaneWebView windVaneWebView = (WindVaneWebView) webView;
                if (System.currentTimeMillis() - windVaneWebView.lastTouchTime > com.mbridge.msdk.click.utils.a.f34500c) {
                    if (com.mbridge.msdk.click.utils.a.a(((com.mbridge.msdk.advanced.signal.b) windVaneWebView.getObject()).a().get(0), windVaneWebView.getUrl(), com.mbridge.msdk.click.utils.a.f34499b)) {
                        return false;
                    }
                }
            } catch (Exception e11) {
                o0.b("NativeAdvancedWebViewClient", e11.getMessage());
            }
            o0.b("NativeAdvancedWebViewClient", "Use html to open url.");
            com.mbridge.msdk.advanced.middle.a aVar = this.f34317g;
            if (aVar == null) {
                return true;
            }
            aVar.a(false, str);
            return true;
        } catch (Throwable th2) {
            o0.b("NativeAdvancedWebViewClient", "shouldOverrideUrlLoading", th2);
            return false;
        }
    }
}
