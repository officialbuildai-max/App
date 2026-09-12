package com.cloud.hisavana.sdk;

import android.net.Uri;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.r;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class b5 extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    private final r.a f21772a;

    /* renamed from: b, reason: collision with root package name */
    private final String f21773b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f21774c;

    public b5(r.a admHandlerListener) {
        Intrinsics.h(admHandlerListener, "admHandlerListener");
        this.f21772a = admHandlerListener;
        this.f21773b = "AdmWebClient";
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        e4.b().d(this.f21773b, "onPageFinished");
        if ((webView != null ? webView.getProgress() : 0) == 100) {
            this.f21774c = true;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        String str;
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.f21774c || webResourceRequest == null || !webResourceRequest.isForMainFrame()) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        if (url == null || (str = url.toString()) == null) {
            str = "";
        }
        this.f21772a.a(str, webResourceError != null ? webResourceError.getErrorCode() : TaErrorCode.CODE_ADM_LOAD_FAILED);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url;
        String uri = (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? null : url.toString();
        return uri != null ? this.f21772a.a(uri) : super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }
}
