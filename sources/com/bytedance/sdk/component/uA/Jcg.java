package com.bytedance.sdk.component.uA;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebBackForwardList;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.component.uA.Sj;
import java.util.List;

/* loaded from: classes2.dex */
public class Jcg extends WebViewClient {
    private final WebViewClient Sj;
    private final List<String> TKC;
    private final Sj.InterfaceC0235Sj sP;

    public Jcg(Sj.InterfaceC0235Sj interfaceC0235Sj, WebViewClient webViewClient, List<String> list) {
        this.sP = interfaceC0235Sj;
        this.Sj = webViewClient;
        this.TKC = list;
    }

    private int Sj(WebView webView) {
        try {
            WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
            if (copyBackForwardList != null) {
                return copyBackForwardList.getCurrentIndex() + 1;
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.Sj.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Sj.InterfaceC0235Sj interfaceC0235Sj = this.sP;
        if (interfaceC0235Sj != null) {
            interfaceC0235Sj.Sj(Sj(webView));
        }
        this.Sj.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i11, String str, String str2) {
        this.Sj.onReceivedError(webView, i11, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.Sj.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        this.Sj.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.Sj.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        boolean onRenderProcessGone;
        if (Build.VERSION.SDK_INT < 26) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        onRenderProcessGone = this.Sj.onRenderProcessGone(webView, renderProcessGoneDetail);
        return onRenderProcessGone;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Sj.InterfaceC0235Sj interfaceC0235Sj;
        if (sP.Sj(this.TKC, webResourceRequest.getUrl().toString()) && (interfaceC0235Sj = this.sP) != null) {
            interfaceC0235Sj.Sj();
        }
        return this.Sj.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return this.Sj.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Sj.InterfaceC0235Sj interfaceC0235Sj = this.sP;
        if (interfaceC0235Sj != null) {
            interfaceC0235Sj.Sj();
        }
        return this.Sj.shouldOverrideUrlLoading(webView, str);
    }
}
