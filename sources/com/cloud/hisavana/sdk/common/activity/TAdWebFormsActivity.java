package com.cloud.hisavana.sdk.common.activity;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.cloud.hisavana.sdk.N0;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.R$style;
import com.cloud.hisavana.sdk.c1;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.common.util.p0;
import com.cloud.hisavana.sdk.common.util.r0;
import com.cloud.hisavana.sdk.data.bean.request.FormBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.google.logging.type.LogSeverity;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class TAdWebFormsActivity extends Activity {

    /* renamed from: b, reason: collision with root package name */
    private AdsDTO f21937b;

    /* renamed from: c, reason: collision with root package name */
    private DownUpPointBean f21938c;

    /* renamed from: d, reason: collision with root package name */
    private String f21939d;

    /* renamed from: e, reason: collision with root package name */
    private String f21940e;

    /* renamed from: f, reason: collision with root package name */
    private int f21941f;

    /* renamed from: g, reason: collision with root package name */
    private WebView f21942g;

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f21943h;

    /* renamed from: i, reason: collision with root package name */
    private long f21944i;

    /* renamed from: a, reason: collision with root package name */
    private final int f21936a = LogSeverity.EMERGENCY_VALUE;

    /* renamed from: j, reason: collision with root package name */
    private final c f21945j = new c(this, Looper.getMainLooper());

    /* renamed from: k, reason: collision with root package name */
    private WebViewClient f21946k = new a();

    /* renamed from: l, reason: collision with root package name */
    private WebChromeClient f21947l = new WebChromeClient();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends e7.j {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // e7.j, android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (webView != TAdWebFormsActivity.this.f21942g || TAdWebFormsActivity.this.f21942g == null) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            ViewGroup viewGroup = (ViewGroup) TAdWebFormsActivity.this.f21942g.getParent();
            if (viewGroup == null) {
                return true;
            }
            viewGroup.removeView(TAdWebFormsActivity.this.f21942g);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            e4.b().d("TAdWebFormsActivity", "shouldInterceptRequest URL== " + str);
            WebResourceResponse a11 = r0.a(str);
            if (a11 == null || TAdWebFormsActivity.this.f21937b == null || !TAdWebFormsActivity.this.f21937b.isOfflineAd()) {
                return super.shouldInterceptRequest(webView, str);
            }
            AthenaTracker.w(TAdWebFormsActivity.this.f21937b, System.currentTimeMillis() - TAdWebFormsActivity.this.f21944i);
            return a11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<TAdWebFormsActivity> f21949a;

        /* renamed from: b, reason: collision with root package name */
        private final WeakReference<AdsDTO> f21950b;

        /* renamed from: c, reason: collision with root package name */
        private final WeakReference<Handler> f21951c;

        private b(TAdWebFormsActivity tAdWebFormsActivity, AdsDTO adsDTO, Handler handler) {
            this.f21949a = new WeakReference<>(tAdWebFormsActivity);
            this.f21950b = new WeakReference<>(adsDTO);
            this.f21951c = new WeakReference<>(handler);
        }

        /* synthetic */ b(TAdWebFormsActivity tAdWebFormsActivity, AdsDTO adsDTO, Handler handler, a aVar) {
            this(tAdWebFormsActivity, adsDTO, handler);
        }

        @Override // java.lang.Runnable
        public void run() {
            TAdWebFormsActivity tAdWebFormsActivity = this.f21949a.get();
            AdsDTO adsDTO = this.f21950b.get();
            if (adsDTO == null || tAdWebFormsActivity == null) {
                return;
            }
            try {
                if (adsDTO.isOfflineAd()) {
                    tAdWebFormsActivity.f21940e = N0.i(tAdWebFormsActivity.f21939d, 1);
                }
                if (TextUtils.isEmpty(tAdWebFormsActivity.f21940e)) {
                    tAdWebFormsActivity.d();
                    return;
                }
                String d11 = com.cloud.hisavana.sdk.common.util.m.d(tAdWebFormsActivity.f21940e);
                if (TextUtils.isEmpty(d11)) {
                    tAdWebFormsActivity.d();
                    return;
                }
                Handler handler = this.f21951c.get();
                if (handler == null) {
                    return;
                }
                Message obtain = Message.obtain();
                obtain.what = 1;
                Bundle bundle = new Bundle();
                bundle.putString("load_runnable_data", d11);
                obtain.setData(bundle);
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
        private final WeakReference f21952a;

        public c(TAdWebFormsActivity tAdWebFormsActivity, Looper looper) {
            super(looper);
            this.f21952a = new WeakReference(tAdWebFormsActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            TAdWebFormsActivity tAdWebFormsActivity;
            if (message.what != 1 || (tAdWebFormsActivity = (TAdWebFormsActivity) this.f21952a.get()) == null) {
                return;
            }
            try {
                WebView webView = tAdWebFormsActivity.f21942g;
                if (webView == null || message.getData() == null) {
                    tAdWebFormsActivity.d();
                } else {
                    webView.loadDataWithBaseURL(tAdWebFormsActivity.f21939d, message.getData().getString("load_runnable_data"), "text/html; charset=utf-8", "utf-8", null);
                }
            } catch (Exception e11) {
                e4.b().e(Log.getStackTraceString(e11));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference f21953a;

        public d(TAdWebFormsActivity tAdWebFormsActivity) {
            this.f21953a = new WeakReference(tAdWebFormsActivity);
        }

        @JavascriptInterface
        public void close() {
            e4.b().d("ssp", "SspWebWindow-----> close");
            WeakReference weakReference = this.f21953a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            ((TAdWebFormsActivity) this.f21953a.get()).d();
        }

        @JavascriptInterface
        public void submitForm(String str) {
            e4.b().d("ssp", "SspWebWindow-----> submitForm");
            TAdWebFormsActivity tAdWebFormsActivity = (TAdWebFormsActivity) this.f21953a.get();
            if (tAdWebFormsActivity != null) {
                tAdWebFormsActivity.e(str);
            }
        }
    }

    private int a(float f11) {
        return (int) ((f11 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (m()) {
            finishAndRemoveTask();
        } else {
            finish();
        }
    }

    private void g() {
        if (this.f21942g == null) {
            d();
            return;
        }
        this.f21939d = getIntent().getStringExtra("ad_web_form_url");
        this.f21940e = getIntent().getStringExtra("ad_web_form_file_path");
        this.f21937b = (AdsDTO) getIntent().getParcelableExtra("ad_web_form_dto");
        this.f21938c = (DownUpPointBean) getIntent().getParcelableExtra("ad_web_form_point");
        if (TextUtils.isEmpty(this.f21939d)) {
            d();
            return;
        }
        AdsDTO adsDTO = this.f21937b;
        if (adsDTO != null && !adsDTO.isOfflineAd() && TextUtils.isEmpty(this.f21940e)) {
            d();
            return;
        }
        h();
        try {
            o();
        } catch (Exception e11) {
            e4.b().e(Log.getStackTraceString(e11));
        }
    }

    private void h() {
        String c11 = p0.c("height", this.f21939d);
        int i11 = LogSeverity.EMERGENCY_VALUE;
        try {
            this.f21941f = Integer.parseInt(p0.c("formId", this.f21939d));
            int parseInt = Integer.parseInt(c11);
            i11 = Math.min(parseInt == 0 ? 800 : a(parseInt), (com.cloud.sdk.commonutil.util.e.a().getResources().getDisplayMetrics().heightPixels * 4) / 5);
        } catch (NumberFormatException unused) {
        }
        try {
            FrameLayout frameLayout = this.f21943h;
            if (frameLayout == null || this.f21942g == null) {
                d();
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.width = (com.cloud.sdk.commonutil.util.e.a().getResources().getDisplayMetrics().widthPixels * 4) / 5;
            layoutParams.height = i11;
            layoutParams.gravity = 17;
            this.f21943h.setLayoutParams(layoutParams);
            this.f21943h.removeAllViews();
            this.f21943h.addView(this.f21942g);
        } catch (Exception unused2) {
            d();
        }
    }

    private void k() {
        try {
            WebView webView = new WebView(this);
            this.f21942g = webView;
            webView.setVisibility(0);
            this.f21942g.setBackgroundColor(0);
            WebSettings settings = this.f21942g.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setMixedContentMode(0);
            settings.setLoadsImagesAutomatically(true);
            settings.setSupportMultipleWindows(false);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDefaultTextEncodingName("UTF-8");
            settings.setNeedInitialFocus(true);
            settings.setDisplayZoomControls(false);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            this.f21942g.addJavascriptInterface(new d(this), "sspWebView");
            this.f21942g.setWebViewClient(this.f21946k);
            this.f21942g.setWebChromeClient(this.f21947l);
            this.f21942g.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        } catch (Throwable th2) {
            e4.b().e("TAdWebFormsActivity", "create webview error: " + Log.getStackTraceString(th2));
            this.f21942g = null;
            d();
        }
    }

    private boolean m() {
        return com.cloud.sdk.commonutil.util.l.a();
    }

    private void o() {
        c1.h(this.f21938c, this.f21937b, Boolean.FALSE);
        HSScopeHelper.f23249a.g(new b(this, this.f21937b, this.f21945j, null));
    }

    private void p() {
        getWindow().setLayout(-1, -1);
        setFinishOnTouchOutside(false);
        this.f21943h = (FrameLayout) findViewById(R$id.fl_content);
        this.f21944i = System.currentTimeMillis();
        k();
    }

    public void e(String str) {
        e4.b().d("ssp", "SspWebWindow-----> submitForm    " + str);
        try {
            FormBean formBean = (FormBean) GsonUtil.a(str, FormBean.class);
            formBean.setGaid(DeviceUtil.e());
            formBean.setFormId(this.f21941f);
            formBean.setIpAddress(DeviceUtil.h());
            if (NetStateManager.checkNetworkState(false)) {
                N0.Q(GsonUtil.d(formBean), 0);
            } else {
                AthenaTracker.O(this.f21937b, formBean);
            }
        } catch (GsonUtil.GsonParseException e11) {
            e4.b().d("ssp", "SspWebWindow-----> submitForm    " + e11.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTitle((CharSequence) null);
        if (a7.c.n() == 1) {
            setRequestedOrientation(1);
        } else if (a7.c.n() == 0) {
            setRequestedOrientation(0);
        }
        super.onCreate(bundle);
        if (com.cloud.sdk.commonutil.util.h.e() == 2) {
            setTheme(R$style.AppCompatTranscutes);
        } else {
            setTheme(R$style.TranslucentStyle);
        }
        setContentView(R$layout.activity_t_ad_web_forms);
        View childAt = ((ViewGroup) findViewById(R.id.content)).getChildAt(0);
        if (childAt != null) {
            childAt.setFitsSystemWindows(true);
        }
        e4.b().d("TAdWebFormsActivity", "展示form表单页面");
        p();
        g();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        FrameLayout frameLayout = this.f21943h;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        WebView webView = this.f21942g;
        if (webView != null) {
            webView.stopLoading();
            this.f21942g.removeJavascriptInterface("");
            this.f21942g.getSettings().setJavaScriptEnabled(false);
            this.f21942g.setWebChromeClient(null);
            this.f21942g.setWebViewClient(null);
            this.f21942g.clearHistory();
            try {
                this.f21942g.freeMemory();
                this.f21942g.destroy();
            } catch (Exception e11) {
                e4.b().d("TAdWebFormsActivity", Log.getStackTraceString(e11));
            }
            this.f21942g = null;
        }
        this.f21945j.removeCallbacksAndMessages(null);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        g();
    }
}
