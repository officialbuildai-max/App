package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class BrowserView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private CampaignEx f35888a;

    /* renamed from: b, reason: collision with root package name */
    private String f35889b;

    /* renamed from: c, reason: collision with root package name */
    private e f35890c;

    /* renamed from: d, reason: collision with root package name */
    private WebView f35891d;

    /* renamed from: e, reason: collision with root package name */
    private ProgressBar f35892e;

    /* renamed from: f, reason: collision with root package name */
    private ToolBar f35893f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BrowserView.this.f35891d != null) {
                BrowserView.this.f35891d.stopLoading();
            }
            String str = (String) view.getTag();
            boolean z10 = false;
            if (TextUtils.equals(str, com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD)) {
                BrowserView.this.f35893f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD).setEnabled(true);
                if (BrowserView.this.f35891d != null && BrowserView.this.f35891d.canGoBack()) {
                    BrowserView.this.f35891d.goBack();
                }
                View item = BrowserView.this.f35893f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD);
                if (BrowserView.this.f35891d != null && BrowserView.this.f35891d.canGoBack()) {
                    z10 = true;
                }
                item.setEnabled(z10);
                return;
            }
            if (TextUtils.equals(str, com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD)) {
                BrowserView.this.f35893f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD).setEnabled(true);
                if (BrowserView.this.f35891d != null && BrowserView.this.f35891d.canGoForward()) {
                    BrowserView.this.f35891d.goForward();
                }
                View item2 = BrowserView.this.f35893f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD);
                if (BrowserView.this.f35891d != null && BrowserView.this.f35891d.canGoForward()) {
                    z10 = true;
                }
                item2.setEnabled(z10);
                return;
            }
            if (!TextUtils.equals(str, com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.REFRESH)) {
                if (!TextUtils.equals(str, com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.EXITS) || BrowserView.this.f35890c == null) {
                    return;
                }
                BrowserView.this.f35890c.a();
                return;
            }
            BrowserView.this.f35893f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD).setEnabled(BrowserView.this.f35891d != null && BrowserView.this.f35891d.canGoBack());
            View item3 = BrowserView.this.f35893f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD);
            if (BrowserView.this.f35891d != null && BrowserView.this.f35891d.canGoForward()) {
                z10 = true;
            }
            item3.setEnabled(z10);
            if (BrowserView.this.f35891d != null) {
                BrowserView.this.f35891d.loadUrl(BrowserView.this.f35889b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b extends WebViewClient {
        b() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
            o0.c("BrowserView", "onLoadResource 开始! = " + str);
            if (BrowserView.this.f35890c != null) {
                BrowserView.this.f35890c.c(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (BrowserView.this.f35890c != null) {
                BrowserView.this.f35890c.a(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            o0.c("BrowserView", "开始! = " + str);
            BrowserView.this.f35889b = str;
            if (BrowserView.this.f35890c != null) {
                BrowserView.this.f35890c.a(webView, str, bitmap);
            }
            BrowserView.this.f35892e.setVisible(true);
            BrowserView.this.f35892e.setProgressState(5);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            if (BrowserView.this.f35890c != null) {
                BrowserView.this.f35890c.a(webView, i11, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (webView != null) {
                try {
                    ViewGroup viewGroup = (ViewGroup) webView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(webView);
                    }
                    webView.destroy();
                } catch (Throwable th2) {
                    o0.b("BrowserView", th2.getMessage());
                    return true;
                }
            }
            if (BrowserView.this.f35890c != null) {
                BrowserView.this.f35890c.a();
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            o0.c("BrowserView", "js大跳! = " + str);
            BrowserView.this.f35893f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD).setEnabled(true);
            BrowserView.this.f35893f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD).setEnabled(false);
            if (BrowserView.this.f35890c != null) {
                return BrowserView.this.f35890c.b(webView, str);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c extends WebChromeClient {

        /* loaded from: classes5.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BrowserView.this.f35892e.setVisible(false);
            }
        }

        c() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i11) {
            if (i11 == 100) {
                BrowserView.this.f35892e.setProgressState(7);
                new Handler().postDelayed(new a(), 200L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d extends WebChromeClient {

        /* loaded from: classes5.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BrowserView.this.f35892e.setVisible(false);
            }
        }

        d() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i11) {
            if (i11 == 100) {
                BrowserView.this.f35892e.setProgressState(7);
                new Handler().postDelayed(new a(), 200L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();

        void a(WebView webView, int i11, String str, String str2);

        void a(WebView webView, String str);

        void a(WebView webView, String str, Bitmap bitmap);

        boolean b(WebView webView, String str);

        void c(WebView webView, String str);
    }

    public BrowserView(Context context) {
        super(context);
        init();
    }

    public BrowserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public BrowserView(Context context, CampaignEx campaignEx) {
        super(context);
        this.f35888a = campaignEx;
        init();
    }

    private void a() {
        ProgressBar progressBar = new ProgressBar(getContext());
        this.f35892e = progressBar;
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-1, 4));
        try {
            if (this.f35891d == null) {
                this.f35891d = getWebView();
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.f35891d.setLayoutParams(layoutParams);
        } catch (Throwable th2) {
            o0.b("BrowserView", "webview is error", th2);
        }
        this.f35893f = new ToolBar(getContext());
        this.f35893f.setLayoutParams(new LinearLayout.LayoutParams(-1, t0.a(getContext(), 40.0f)));
        this.f35893f.setBackgroundColor(-1);
        addView(this.f35892e);
        WebView webView = this.f35891d;
        if (webView != null) {
            addView(webView);
        }
        addView(this.f35893f);
    }

    private WebView getWebView() {
        WebView webView = new WebView(getContext());
        try {
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setCacheMode(-1);
            settings.setAllowFileAccess(true);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    settings.setSafeBrowsingEnabled(false);
                } catch (Throwable th2) {
                    o0.b("BrowserView", th2.getMessage());
                }
            }
            settings.setMediaPlaybackRequiresUserGesture(false);
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
            try {
                settings.setMixedContentMode(0);
            } catch (Exception e11) {
                o0.b("BrowserView", e11.getMessage());
            }
            settings.setDatabaseEnabled(true);
            String path = getContext().getDir("database", 0).getPath();
            settings.setDatabasePath(path);
            settings.setGeolocationEnabled(true);
            settings.setGeolocationDatabasePath(path);
            try {
                Method declaredMethod = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(settings, Boolean.FALSE);
            } catch (Exception e12) {
                o0.b("BrowserView", e12.getMessage());
            }
        } catch (Throwable th3) {
            o0.b("BrowserView", th3.getMessage());
        }
        webView.setDownloadListener(new com.mbridge.msdk.foundation.same.webview.a(this.f35888a));
        webView.setWebViewClient(new b());
        webView.setWebChromeClient(k0.r() <= 10 ? new c() : new d());
        return webView;
    }

    public void destroy() {
        try {
            WebView webView = this.f35891d;
            if (webView != null) {
                webView.setWebViewClient(null);
                this.f35891d.destroy();
                this.f35891d = null;
                removeAllViews();
            }
        } catch (Throwable th2) {
            o0.b("BrowserView", th2.getMessage());
        }
    }

    public void init() {
        setOrientation(1);
        setGravity(17);
        a();
        this.f35892e.initResource(true);
        this.f35893f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD).setEnabled(false);
        this.f35893f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD).setEnabled(false);
        this.f35893f.setOnItemClickListener(new a());
    }

    public void loadUrl(String str) {
        WebView webView = this.f35891d;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    public void setListener(e eVar) {
        this.f35890c = eVar;
    }

    public void setWebView(WebView webView) {
        this.f35891d = webView;
    }
}
