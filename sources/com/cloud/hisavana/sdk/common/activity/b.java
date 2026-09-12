package com.cloud.hisavana.sdk.common.activity;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cloud.hisavana.sdk.N0;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.c1;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.athena.SSPTrackingHelper;
import com.cloud.hisavana.sdk.common.bean.SSPParamSplicedResult;
import com.cloud.hisavana.sdk.common.bean.WebPageBean;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.common.widget.webview.ActionWebView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e4;
import com.cloud.tmc.ad.Constants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.utils.UrlUtils;
import java.util.ArrayList;
import org.mvel2.ast.ASTNode;

/* loaded from: classes3.dex */
public class b extends Activity {

    /* renamed from: a, reason: collision with root package name */
    protected ProgressBar f21957a;

    /* renamed from: b, reason: collision with root package name */
    protected LinearLayout f21958b;

    /* renamed from: c, reason: collision with root package name */
    protected FrameLayout f21959c;

    /* renamed from: d, reason: collision with root package name */
    protected FrameLayout f21960d;

    /* renamed from: e, reason: collision with root package name */
    protected ImageView f21961e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f21962f;

    /* renamed from: g, reason: collision with root package name */
    protected WebView f21963g;

    /* renamed from: h, reason: collision with root package name */
    protected AdsDTO f21964h;

    /* renamed from: i, reason: collision with root package name */
    protected DownUpPointBean f21965i;

    /* renamed from: j, reason: collision with root package name */
    protected Bundle f21966j;

    /* renamed from: l, reason: collision with root package name */
    protected long f21968l;

    /* renamed from: r, reason: collision with root package name */
    protected WebPageBean f21974r;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f21967k = true;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f21969m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f21970n = false;

    /* renamed from: o, reason: collision with root package name */
    protected boolean f21971o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f21972p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f21973q = false;

    /* renamed from: s, reason: collision with root package name */
    protected boolean f21975s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f21976t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f21977u = false;

    /* renamed from: v, reason: collision with root package name */
    private ArrayList f21978v = new ArrayList();

    /* renamed from: w, reason: collision with root package name */
    private ArrayList f21979w = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends WebChromeClient {
        a() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i11) {
            ProgressBar progressBar = b.this.f21957a;
            if (progressBar == null) {
                return;
            }
            if (i11 == 100) {
                progressBar.setVisibility(8);
            } else if (8 == progressBar.getVisibility()) {
                b.this.f21957a.setVisibility(0);
            }
            b bVar = b.this;
            if (bVar.f21974r == null || bVar.f21973q) {
                return;
            }
            if (b.this.f21970n || i11 != 100) {
                if (b.this.f21972p || b.this.f21970n || i11 < 50 || i11 >= 100) {
                    return;
                }
                b.this.f21974r.setSpendEndTime(System.currentTimeMillis());
                b.this.f21972p = true;
                AthenaTracker.o0(b.this.f21974r.getWebId(), b.this.f21974r.getUrl(), b.this.f21974r.getTargetUrl(), 50, b.this.f21974r.getRedirectType(), b.this.f21974r.getSpendTime());
                return;
            }
            b.this.f21974r.setSpendEndTime(System.currentTimeMillis());
            b.this.f21970n = true;
            AthenaTracker.o0(b.this.f21974r.getWebId(), b.this.f21974r.getUrl(), b.this.f21974r.getTargetUrl(), 100, b.this.f21974r.getRedirectType(), b.this.f21974r.getSpendTime());
            String webId = b.this.f21974r.getWebId();
            String url = b.this.f21974r.getUrl();
            String targetUrl = b.this.f21974r.getTargetUrl();
            int redirectType = b.this.f21974r.getRedirectType();
            b bVar2 = b.this;
            boolean z10 = bVar2.f21969m;
            String str = z10 ? "fail" : NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS;
            String errorType = z10 ? bVar2.f21974r.getErrorType() : "succeed";
            b bVar3 = b.this;
            AthenaTracker.n0(webId, url, targetUrl, redirectType, str, errorType, bVar3.f21969m ? bVar3.f21974r.getErrorCode() : 8000, -1L);
            b.this.j(0);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            e4.b().d("TBaseLandingActivity", "onReceivedTitle " + str);
            if (str == null || str.isEmpty() || webView.getUrl() == null || webView.getUrl().contains(str) || b.this.f21962f == null || TextUtils.isEmpty(str)) {
                return;
            }
            b.this.f21962f.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cloud.hisavana.sdk.common.activity.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class ViewOnClickListenerC0308b implements View.OnClickListener {
        ViewOnClickListenerC0308b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.isFinishing() || b.this.isDestroyed()) {
                return;
            }
            b.this.finish();
            e4.b().e("TBaseLandingActivity", "goToNext ,post finish");
        }
    }

    public static SSPParamSplicedResult a(DownUpPointBean downUpPointBean, AdsDTO adsDTO) {
        SSPParamSplicedResult sSPParamSplicedResult = new SSPParamSplicedResult();
        if (adsDTO == null || TextUtils.isEmpty(adsDTO.getClickUrl())) {
            e4.b().d("TBaseLandingActivity", "processServerClickUrl --> null == url || null == pointBean");
            sSPParamSplicedResult.setOriginalUrl("");
            sSPParamSplicedResult.setSplicedURL("");
            return sSPParamSplicedResult;
        }
        if (downUpPointBean == null || adsDTO.getDspType().intValue() == 2 || adsDTO.getSource() == 4) {
            sSPParamSplicedResult.setOriginalUrl(adsDTO.getClickUrl());
            sSPParamSplicedResult.setSplicedURL(adsDTO.getClickUrl());
            return sSPParamSplicedResult;
        }
        String d11 = c1.d(downUpPointBean, adsDTO, true, Boolean.FALSE);
        if (TextUtils.isEmpty(d11)) {
            sSPParamSplicedResult.setOriginalUrl("");
            sSPParamSplicedResult.setSplicedURL("");
            return sSPParamSplicedResult;
        }
        if (d11.contains(UrlUtils.QUESTION_MARK)) {
            String str = d11 + c1.e(adsDTO);
            sSPParamSplicedResult.setOriginalUrl(str);
            sSPParamSplicedResult.setSplicedURL(com.cloud.hisavana.sdk.common.util.r.f22275a.m(str));
        } else {
            sSPParamSplicedResult.setOriginalUrl(d11);
            sSPParamSplicedResult.setSplicedURL(d11);
        }
        return sSPParamSplicedResult;
    }

    private void b() {
        new Handler(getMainLooper()).postDelayed(new c(), 1000L);
    }

    private void c(int i11) {
        WebPageBean webPageBean;
        if (this.f21971o || (webPageBean = this.f21974r) == null) {
            return;
        }
        webPageBean.setRedirectType(i11);
        AthenaTracker.o0(this.f21974r.getWebId(), this.f21974r.getUrl(), this.f21974r.getTargetUrl(), 0, i11, this.f21974r.getLoadTime());
    }

    public static String i(DownUpPointBean downUpPointBean, AdsDTO adsDTO) {
        if (adsDTO == null || TextUtils.isEmpty(adsDTO.getClickUrl())) {
            e4.b().d("TBaseLandingActivity", "processServerClickUrl --> null == url || null == pointBean");
            return "";
        }
        if (downUpPointBean == null || adsDTO.getDspType().intValue() == 2 || adsDTO.getSource() == 4) {
            return adsDTO.getClickUrl();
        }
        String d11 = c1.d(downUpPointBean, adsDTO, true, Boolean.FALSE);
        if (TextUtils.isEmpty(d11)) {
            return "";
        }
        if (!d11.contains(UrlUtils.QUESTION_MARK)) {
            return d11;
        }
        return d11 + c1.e(adsDTO);
    }

    private void o(String str) {
        try {
            String stringExtra = Intent.parseUri(str, 1).getStringExtra("browser_fallback_url");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            v(SSPTrackingHelper.f22035a.s(stringExtra));
            if (N0.I(this, stringExtra)) {
                u();
                finish();
            } else if (stringExtra.startsWith("https://") || stringExtra.startsWith("http://")) {
                q(stringExtra);
                this.f21963g.loadUrl(stringExtra);
            }
        } catch (Exception unused) {
        }
    }

    private boolean r() {
        if (getIntent() == null) {
            j(TaErrorCode.WEBVIEW_INTENT_NULL);
            e4.b().e("TBaseLandingActivity", "initWebView intent is null");
            finish();
            return false;
        }
        try {
            Parcelable parcelableExtra = getIntent().getParcelableExtra("tag_ad_bean");
            this.f21964h = parcelableExtra instanceof AdsDTO ? (AdsDTO) parcelableExtra : null;
            this.f21965i = (DownUpPointBean) getIntent().getParcelableExtra("pointBean");
            this.f21966j = (Bundle) getIntent().getParcelableExtra("ab_Test_Data");
        } catch (Exception unused) {
        }
        if (this.f21964h != null) {
            return true;
        }
        j(TaErrorCode.WEBVIEW_ADSDTO_NULL);
        e4.b().e("TBaseLandingActivity", "initWebView,adsDto is null");
        finish();
        return false;
    }

    private void t(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setPackage("com.android.vending");
            intent.setFlags(ASTNode.DEOP);
            com.cloud.sdk.commonutil.util.e.a().startActivity(intent);
            finish();
            e4.b().d("TBaseLandingActivity", "open gp link " + str);
        } catch (Throwable th2) {
            e4.b().e("TBaseLandingActivity", "startGp " + Log.getStackTraceString(th2));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(String str) {
        if (!TextUtils.isEmpty(str) && !str.startsWith("http://") && !str.startsWith("https://")) {
            try {
                Intent intent = new Intent();
                intent.setData(Uri.parse(str));
                intent.setAction("android.intent.action.VIEW");
                intent.setFlags(ASTNode.DEOP);
                startActivity(intent);
                e4.b().d("TBaseLandingActivity", "open deeplink");
                return true;
            } catch (Exception e11) {
                e4.b().e("TBaseLandingActivity", "checkDeepLink finish," + Log.getStackTraceString(e11));
                finish();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g(String str, boolean z10) {
        WebPageBean webPageBean;
        this.f21976t = z10;
        e4.b().d("TBaseLandingActivity", "webview get redirect url is:" + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!this.f21971o && (webPageBean = this.f21974r) != null) {
            webPageBean.setTargetUrl(str);
            this.f21974r.setLoadStartTime(System.currentTimeMillis());
        }
        v(SSPTrackingHelper.f22035a.s(str));
        if (str.startsWith("intent://")) {
            c(2);
            if (N0.S(this, str)) {
                u();
                if (!isFinishing() && !isDestroyed()) {
                    finish();
                }
            } else {
                o(str);
            }
            return true;
        }
        if ((str.contains(Constants.GP_DEEPLINK) || str.startsWith("market://")) && N0.J(this, str, "com.android.vending")) {
            AthenaTracker.q0(this.f21964h);
            q(str);
            u();
            c(1);
            if (!isFinishing() && !isDestroyed()) {
                finish();
            }
            return true;
        }
        if (N0.I(this, str)) {
            u();
            c(2);
            b();
            return true;
        }
        if (!str.startsWith("https://") && !str.startsWith("http://")) {
            return true;
        }
        this.f21974r.setRedirectType(0);
        AthenaTracker.q0(this.f21964h);
        q(str);
        return false;
    }

    protected WebViewClient h() {
        return new e7.j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i11) {
        try {
            if (this.f21975s) {
                if (i11 == 8005) {
                    SSPTrackingHelper.f22035a.W(Integer.valueOf(i11), this.f21978v, this.f21979w, this.f21964h, this.f21974r, this.f21977u, true, Long.valueOf(this.f21968l != 0 ? System.currentTimeMillis() - this.f21968l : 0L), Boolean.valueOf(this.f21970n), this.f21966j);
                }
            } else {
                w();
                if (i11 == 8005 && this.f21968l != 0) {
                    r4 = System.currentTimeMillis() - this.f21968l;
                }
                SSPTrackingHelper.f22035a.W(Integer.valueOf(i11), this.f21978v, this.f21979w, this.f21964h, this.f21974r, this.f21977u, false, Long.valueOf(r4), Boolean.valueOf(this.f21970n), this.f21966j);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m(String str) {
        if (str == null) {
            return false;
        }
        if (str.contains("play.google.com/store/apps/")) {
            t(str.replaceAll("https://play.google.com/store/apps/", "market://").replaceAll("http://play.google.com/store/apps/", "market://"));
            return true;
        }
        if (!str.startsWith("market://")) {
            return false;
        }
        t(str);
        return true;
    }

    public WebPageBean n() {
        return this.f21974r;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        WebPageBean webPageBean;
        WebView webView;
        if (this.f21967k && (webView = this.f21963g) != null && webView.canGoBack()) {
            this.f21963g.goBack();
            return;
        }
        if (!this.f21970n && (webPageBean = this.f21974r) != null) {
            this.f21973q = true;
            webPageBean.setJumpTime(System.currentTimeMillis());
            AthenaTracker.n0(this.f21974r.getWebId(), this.f21974r.getUrl(), this.f21974r.getTargetUrl(), -1, "fail", "jump", 9000, this.f21974r.getWaitTime());
        }
        try {
            super.onBackPressed();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        if (a7.c.n() == 1) {
            setRequestedOrientation(1);
        } else if (a7.c.n() == 0) {
            setRequestedOrientation(0);
        }
        super.onCreate(bundle);
        this.f21968l = System.currentTimeMillis();
        setContentView(R$layout.tad_exposure_activity);
        View childAt = ((ViewGroup) findViewById(R.id.content)).getChildAt(0);
        if (childAt != null) {
            childAt.setFitsSystemWindows(true);
        }
        this.f21974r = new WebPageBean();
        this.f21957a = (ProgressBar) findViewById(R$id.pb_progress);
        this.f21958b = (LinearLayout) findViewById(R$id.main_content);
        this.f21959c = (FrameLayout) findViewById(R$id.layout_title);
        this.f21960d = (FrameLayout) findViewById(R$id.layout_content);
        FrameLayout frameLayout = this.f21959c;
        if (frameLayout != null) {
            this.f21961e = (ImageView) frameLayout.findViewById(R$id.im_back);
            this.f21962f = (TextView) this.f21959c.findViewById(R$id.tv_title);
        }
        if (r()) {
            s();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        try {
            WebView webView = this.f21963g;
            if (webView != null) {
                ViewParent parent = webView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f21963g);
                }
                this.f21963g.stopLoading();
                this.f21963g.getSettings().setJavaScriptEnabled(false);
                this.f21963g.setWebChromeClient(null);
                this.f21963g.clearHistory();
                this.f21963g.removeAllViews();
                this.f21963g.destroy();
            }
            j(TaErrorCode.WEBVIEW_ON_DESTORY);
        } catch (Throwable th2) {
            e4.b().d("TBaseLandingActivity", Log.getStackTraceString(th2));
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        WebView webView;
        if (i11 != 4 || (webView = this.f21963g) == null || !webView.canGoBack()) {
            return super.onKeyDown(i11, keyEvent);
        }
        this.f21963g.goBack();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (this.f21959c != null) {
            if (str.contains("isNativeHeader=false")) {
                this.f21959c.setVisibility(8);
            } else {
                this.f21959c.setVisibility(0);
            }
        }
        if (str.contains("isBackPage=false")) {
            this.f21967k = false;
        }
        if (this.f21957a != null) {
            if (str.contains("isNativeLoading=false")) {
                this.f21957a.setVisibility(8);
            } else {
                this.f21957a.setVisibility(0);
            }
        }
        ImageView imageView = this.f21961e;
        if (imageView != null) {
            imageView.setOnClickListener(new ViewOnClickListenerC0308b());
        }
    }

    protected void s() {
        try {
            this.f21963g = new ActionWebView(this);
            ((FrameLayout) findViewById(R$id.fl_webview)).addView(this.f21963g);
            WebView webView = this.f21963g;
            if (webView != null) {
                webView.getSettings().setJavaScriptEnabled(true);
                this.f21963g.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                this.f21963g.getSettings().setSupportZoom(true);
                this.f21963g.getSettings().setUseWideViewPort(true);
                this.f21963g.getSettings().setLoadWithOverviewMode(true);
                this.f21963g.getSettings().setDisplayZoomControls(true);
                this.f21963g.getSettings().setCacheMode(-1);
                this.f21963g.getSettings().setDomStorageEnabled(true);
                this.f21963g.setWebChromeClient(new a());
                this.f21963g.setWebViewClient(h());
            }
            if (a7.c.p()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            WebPageBean webPageBean = this.f21974r;
            if (webPageBean != null) {
                webPageBean.setPageClickTime(this.f21968l);
            }
            WebPageBean webPageBean2 = this.f21974r;
            if (webPageBean2 != null) {
                webPageBean2.setInitEndTime(System.currentTimeMillis());
                AthenaTracker.o0(this.f21974r.getWebId(), this.f21974r.getUrl(), this.f21974r.getTargetUrl(), -1, -1, this.f21974r.getInitTime());
            }
        } catch (Throwable th2) {
            e4.b().e("TBaseLandingActivity", "create webview error: " + Log.getStackTraceString(th2));
            j(TaErrorCode.WEBVIEW_CREAT_ERROR);
            this.f21963g = null;
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
        this.f21977u = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(String str) {
        if (this.f21976t) {
            this.f21979w.add(str);
        } else {
            this.f21978v.add(str);
        }
    }

    protected void w() {
        this.f21975s = true;
    }
}
