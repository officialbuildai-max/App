package com.cloud.hisavana.sdk.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.widget.InteractiveWebView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e4;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.cloud.tmc.kernel.constants.TmcConstants;
import e7.j;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class InteractiveWebView extends WebView {

    /* renamed from: a, reason: collision with root package name */
    private b f22311a;

    /* renamed from: b, reason: collision with root package name */
    private c f22312b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdsDTO f22313a;

        a(AdsDTO adsDTO) {
            this.f22313a = adsDTO;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            AthenaTracker.S(this.f22313a, 5);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            super.onReceivedError(webView, i11, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            AthenaTracker.S(this.f22313a, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference f22315a;

        public b(InteractiveWebView interactiveWebView) {
            this.f22315a = new WeakReference(interactiveWebView);
        }

        @JavascriptInterface
        public void handleClick() {
            e4.b().d("InteractiveWebView", "handleClick");
            InteractiveWebView interactiveWebView = (InteractiveWebView) this.f22315a.get();
            if (interactiveWebView != null) {
                interactiveWebView.g();
            }
        }

        @JavascriptInterface
        public void interactiveEvent(String str) {
            e4.b().d("InteractiveWebView", "interactiveEvent");
            InteractiveWebView interactiveWebView = (InteractiveWebView) this.f22315a.get();
            if (interactiveWebView != null) {
                interactiveWebView.i(str);
            }
        }

        @JavascriptInterface
        public void timeoutShutdown() {
            e4.b().d("InteractiveWebView", "timeoutShutdown");
            InteractiveWebView interactiveWebView = (InteractiveWebView) this.f22315a.get();
            if (interactiveWebView != null) {
                interactiveWebView.m();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(String str);

        void b();

        void c();
    }

    public InteractiveWebView(@NonNull Context context) {
        super(context);
        h();
    }

    public InteractiveWebView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        h();
    }

    public InteractiveWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        HSScopeHelper.f23249a.h(new Runnable() { // from class: e7.m
            @Override // java.lang.Runnable
            public final void run() {
                InteractiveWebView.this.j();
            }
        });
    }

    private void h() {
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSupportZoom(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDisplayZoomControls(true);
        settings.setCacheMode(-1);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        setWebViewClient(new j());
        setWebChromeClient(new WebChromeClient());
        b bVar = new b(this);
        this.f22311a = bVar;
        addJavascriptInterface(bVar, "InteractiveWebView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str) {
        HSScopeHelper.f23249a.h(new Runnable() { // from class: e7.k
            @Override // java.lang.Runnable
            public final void run() {
                InteractiveWebView.this.k(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        c cVar = this.f22312b;
        if (cVar != null) {
            cVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(String str) {
        c cVar = this.f22312b;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        c cVar = this.f22312b;
        if (cVar != null) {
            cVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        HSScopeHelper.f23249a.h(new Runnable() { // from class: e7.l
            @Override // java.lang.Runnable
            public final void run() {
                InteractiveWebView.this.l();
            }
        });
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            getSettings().setJavaScriptEnabled(false);
            setWebChromeClient(null);
            clearHistory();
            clearCache(true);
            loadUrl(TmcConstants.LOAD_BASE_DATA_URL);
            freeMemory();
            this.f22312b = null;
            super.destroy();
        } catch (Exception e11) {
            e4.b().e("InteractiveWebView", "destroy " + Log.getStackTraceString(e11));
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setInteractiveListener(c cVar) {
        this.f22312b = cVar;
    }

    public void setWebClientCallback(AdsDTO adsDTO) {
        if (adsDTO == null) {
            return;
        }
        setWebViewClient(new a(adsDTO));
    }
}
