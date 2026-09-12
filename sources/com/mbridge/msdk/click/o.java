package com.mbridge.msdk.click;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class o {

    /* renamed from: r, reason: collision with root package name */
    private static final String f34413r = "o";

    /* renamed from: a, reason: collision with root package name */
    private int f34414a;

    /* renamed from: b, reason: collision with root package name */
    private int f34415b;

    /* renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.setting.g f34417d;

    /* renamed from: e, reason: collision with root package name */
    private f f34418e;

    /* renamed from: f, reason: collision with root package name */
    private String f34419f;

    /* renamed from: g, reason: collision with root package name */
    private String f34420g;

    /* renamed from: h, reason: collision with root package name */
    private WebView f34421h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f34422i;

    /* renamed from: j, reason: collision with root package name */
    private String f34423j;

    /* renamed from: k, reason: collision with root package name */
    private int f34424k;

    /* renamed from: m, reason: collision with root package name */
    private boolean f34426m;

    /* renamed from: n, reason: collision with root package name */
    boolean f34427n;

    /* renamed from: o, reason: collision with root package name */
    boolean f34428o;

    /* renamed from: l, reason: collision with root package name */
    private boolean f34425l = false;

    /* renamed from: p, reason: collision with root package name */
    private final Runnable f34429p = new d();

    /* renamed from: q, reason: collision with root package name */
    private final Runnable f34430q = new e();

    /* renamed from: c, reason: collision with root package name */
    private Handler f34416c = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f34431a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f34432b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f34433c;

        a(String str, String str2, Context context) {
            this.f34431a = str;
            this.f34432b = str2;
            this.f34433c = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            o oVar = o.this;
            oVar.a(this.f34431a, this.f34432b, this.f34433c, oVar.f34419f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b extends WebViewClient {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f34435a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f34436b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f34437c;

        b(String str, String str2, Context context) {
            this.f34435a = str;
            this.f34436b = str2;
            this.f34437c = context;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            try {
                webView.loadUrl("javascript:window.navigator.vibrate([]);");
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            try {
                webView.loadUrl("javascript:window.navigator.vibrate([]);");
                if (o.this.f34426m) {
                    o.this.f34424k = 0;
                    o.this.f();
                    return;
                }
                o.this.f34428o = false;
                if (webView.getTag() == null) {
                    webView.setTag("has_first_started");
                } else {
                    o.this.f34427n = true;
                }
                synchronized (o.f34413r) {
                    try {
                        o.this.f34419f = str;
                        if (o.this.f34418e == null || !o.this.f34418e.a(str)) {
                            o.this.h();
                        } else {
                            o.this.f34426m = true;
                            o.this.f();
                        }
                    } finally {
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            synchronized (o.f34413r) {
                o.this.f34426m = true;
                o.this.b();
                o.this.f();
            }
            if (o.this.f34418e != null) {
                o.this.f34418e.a(i11, webView.getUrl(), str, o.this.f34423j);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            try {
                if (MBridgeConstans.IS_SP_CBT_CF && sslErrorHandler != null) {
                    sslErrorHandler.cancel();
                }
                if (TextUtils.isEmpty(this.f34435a) || TextUtils.isEmpty(this.f34436b)) {
                    return;
                }
                new com.mbridge.msdk.foundation.same.report.h(this.f34437c).a(this.f34436b, this.f34435a, webView.getUrl());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            try {
                synchronized (o.f34413r) {
                    o.this.f34426m = true;
                    o.this.b();
                    o.this.f();
                }
                if (o.this.f34418e != null) {
                    o.this.f34418e.a(-1, webView.getUrl(), "WebView render process crash.", o.this.f34423j);
                }
                if (webView != null) {
                    webView.destroy();
                }
                return true;
            } catch (Throwable th2) {
                o0.b(o.f34413r, th2.getMessage());
                return true;
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            synchronized (o.f34413r) {
                try {
                    o oVar = o.this;
                    oVar.f34428o = true;
                    oVar.c();
                    if (o.this.f34426m) {
                        o.this.d();
                        o.this.f();
                        return true;
                    }
                    o.this.f34419f = str;
                    if (o.this.f34418e != null && o.this.f34418e.c(str)) {
                        o.this.f34426m = true;
                        o.this.d();
                        o.this.f();
                        return true;
                    }
                    if (o.this.f34422i) {
                        HashMap hashMap = new HashMap();
                        if (o.this.f34421h.getUrl() != null) {
                            hashMap.put("Referer", o.this.f34421h.getUrl());
                        }
                        o.this.f34421h.loadUrl(str, hashMap);
                    } else {
                        o.this.f34421h.loadUrl(str);
                    }
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c extends WebChromeClient {
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
                try {
                    webView.loadUrl("javascript:window.navigator.vibrate([]);");
                    if (!o.this.f34426m) {
                        o oVar = o.this;
                        if (!oVar.f34428o) {
                            oVar.g();
                        }
                    }
                    if (o.this.f34418e != null) {
                        o.this.f34418e.b(webView.getUrl());
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.f34425l = true;
            o.this.f34424k = 1;
            o.this.e();
        }
    }

    /* loaded from: classes5.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.f34425l = true;
            o.this.f34424k = 2;
            o.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface f {
        void a(int i11, String str, String str2, String str3);

        void a(String str, boolean z10, String str2);

        boolean a(String str);

        boolean b(String str);

        boolean c(String str);
    }

    public o() {
        this.f34414a = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
        this.f34415b = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
        com.mbridge.msdk.setting.g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        this.f34417d = d11;
        if (d11 == null) {
            this.f34417d = com.mbridge.msdk.setting.h.b().a();
        }
        this.f34422i = this.f34417d.I0();
        this.f34414a = (int) this.f34417d.o0();
        this.f34415b = (int) this.f34417d.o0();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void a(Context context, String str, String str2) {
        WebView webView = new WebView(context);
        this.f34421h = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f34421h.getSettings().setCacheMode(2);
        this.f34421h.getSettings().setLoadsImagesAutomatically(false);
        this.f34421h.setWebViewClient(new b(str2, str, context));
        this.f34421h.setWebChromeClient(new c());
    }

    private void a(String str, String str2, Context context) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            a(str, str2, context, this.f34419f);
        } else {
            this.f34416c.post(new a(str, str2, context));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, Context context, String str3) {
        try {
            a(context, str, str2);
            if (!TextUtils.isEmpty(this.f34420g)) {
                this.f34421h.getSettings().setDefaultTextEncodingName("utf-8");
                this.f34415b = 2000;
                this.f34414a = 2000;
                o0.c(f34413r, this.f34420g);
                this.f34421h.loadDataWithBaseURL(str3, this.f34420g, "*/*", "utf-8", str3);
                return;
            }
            if (!this.f34422i) {
                this.f34421h.loadUrl(str3);
                return;
            }
            HashMap hashMap = new HashMap();
            if (this.f34421h.getUrl() != null) {
                hashMap.put("Referer", this.f34421h.getUrl());
            }
            this.f34421h.loadUrl(str3, hashMap);
        } catch (Throwable th2) {
            try {
                f fVar = this.f34418e;
                if (fVar != null) {
                    fVar.a(0, this.f34419f, th2.getMessage(), this.f34423j);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        c();
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f34416c.removeCallbacks(this.f34429p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f34416c.removeCallbacks(this.f34430q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        synchronized (f34413r) {
            try {
                try {
                    b();
                    this.f34421h.destroy();
                    f fVar = this.f34418e;
                    if (fVar != null) {
                        fVar.a(this.f34419f, this.f34425l, this.f34423j);
                    }
                } catch (Exception e11) {
                    o0.b(f34413r, e11.getMessage());
                } catch (Throwable th2) {
                    o0.b(f34413r, th2.getMessage());
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        synchronized (f34413r) {
            try {
                try {
                    try {
                        b();
                        f fVar = this.f34418e;
                        if (fVar != null) {
                            fVar.a(this.f34419f, this.f34425l, this.f34423j);
                        }
                    } catch (Throwable th2) {
                        o0.b(f34413r, th2.getMessage());
                    }
                } catch (Exception e11) {
                    o0.b(f34413r, e11.getMessage());
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        c();
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        d();
        j();
    }

    private void i() {
        this.f34416c.postDelayed(this.f34429p, this.f34415b);
    }

    private void j() {
        this.f34416c.postDelayed(this.f34430q, this.f34414a);
    }

    public void a(String str, String str2, Context context, String str3, f fVar) {
        if (fVar == null) {
            throw new NullPointerException("OverrideUrlLoadingListener can not be null");
        }
        this.f34419f = str3;
        this.f34418e = fVar;
        a(str, str2, context);
    }

    public void a(String str, String str2, Context context, String str3, String str4, f fVar) {
        if (fVar == null) {
            throw new NullPointerException("OverrideUrlLoadingListener can not be null");
        }
        this.f34420g = str4;
        this.f34419f = str3;
        this.f34418e = fVar;
        a(str, str2, context);
    }
}
