package com.cloud.hisavana.sdk;

import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.cloud.hisavana.sdk.common.widget.TadmWebView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.tmc.kernel.constants.TmcConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class r {

    /* renamed from: f, reason: collision with root package name */
    private int f22995f;

    /* renamed from: h, reason: collision with root package name */
    private WebView f22997h;

    /* renamed from: i, reason: collision with root package name */
    private AdsDTO f22998i;

    /* renamed from: j, reason: collision with root package name */
    private s4 f22999j;

    /* renamed from: l, reason: collision with root package name */
    private long f23001l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f23002m;

    /* renamed from: a, reason: collision with root package name */
    private final String f22990a = "AdmHandler";

    /* renamed from: b, reason: collision with root package name */
    private float f22991b = -1.0f;

    /* renamed from: c, reason: collision with root package name */
    private float f22992c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f22993d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f22994e = -1.0f;

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f22996g = LazyKt.b(c.f23005a);

    /* renamed from: k, reason: collision with root package name */
    private final b f23000k = new b();

    /* renamed from: n, reason: collision with root package name */
    private long f23003n = System.currentTimeMillis();

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, int i11);

        boolean a(String str);
    }

    /* loaded from: classes3.dex */
    public static final class b implements a {
        b() {
        }

        @Override // com.cloud.hisavana.sdk.r.a
        public void a(String str, int i11) {
            s4 s4Var = r.this.f22999j;
            if (s4Var != null) {
                s4Var.a(str, i11);
            }
        }

        @Override // com.cloud.hisavana.sdk.r.a
        public boolean a(String url) {
            Intrinsics.h(url, "url");
            return r.this.k(url);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Le7/n;", "a", "()Le7/n;"}, k = 3, mv = {1, 9, 0})
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function0<e7.n> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f23005a = new c();

        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e7.n invoke() {
            return new e7.n(com.cloud.sdk.commonutil.util.e.a());
        }
    }

    private final void e(String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    com.cloud.hisavana.sdk.common.util.e.f22235a.g(this.f23003n, str);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        s4 s4Var = this.f22999j;
        if (s4Var != null) {
            s4Var.a();
        }
    }

    private final void f(boolean z10) {
        s4 s4Var = this.f22999j;
        this.f22995f = s4Var != null ? s4Var.b(this.f22991b, this.f22992c, this.f22993d, this.f22994e, z10) : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(r this$0, AdsDTO mAdBean, TadmWebView admWebView, View view, MotionEvent motionEvent) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(mAdBean, "$mAdBean");
        Intrinsics.h(admWebView, "$admWebView");
        if (motionEvent != null) {
            this$0.i().onTouchEvent(motionEvent);
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 && (!this$0.f23002m || this$0.f23001l == 0 || System.currentTimeMillis() - this$0.f23001l > 200)) {
                    this$0.f22993d = motionEvent.getX();
                    this$0.f22994e = motionEvent.getY();
                    this$0.f23001l = System.currentTimeMillis();
                    e4.b().d(this$0.f22990a, "simulateClickByCoordinate,isADXI01Style->" + this$0.f23002m + ",mAdBean.isAdmNormalClick() ->" + mAdBean.isAdmNormalClick() + ",mGestureDetector.isClicked -> " + this$0.i().a());
                    if (this$0.f23002m) {
                        com.cloud.hisavana.sdk.common.util.r.f22275a.s(admWebView);
                    }
                    if (this$0.i().a() && !mAdBean.isAdmNormalClick()) {
                        this$0.f(false);
                    }
                }
            } else if (!this$0.f23002m || this$0.f23001l == 0 || System.currentTimeMillis() - this$0.f23001l > 200) {
                this$0.f22991b = motionEvent.getX();
                this$0.f22992c = motionEvent.getY();
            }
        }
        return false;
    }

    private final e7.n i() {
        return (e7.n) this.f22996g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k(String str) {
        AdsDTO adsDTO;
        if (!i().a()) {
            return false;
        }
        int i11 = this.f22995f;
        if (i11 == 0) {
            AdsDTO adsDTO2 = this.f22998i;
            if (adsDTO2 != null) {
                adsDTO2.setClickUrl(str);
            }
            AdsDTO adsDTO3 = this.f22998i;
            if (adsDTO3 != null) {
                adsDTO3.setUpdateClickUrl(true);
            }
            f(true);
        } else if (i11 == -1 || (i11 == 5 && (adsDTO = this.f22998i) != null && adsDTO.isJumpToHalfscreen())) {
            if (this.f23002m) {
                e(str);
            } else {
                if (this.f22997h == null) {
                    try {
                        WebView webView = new WebView(com.cloud.sdk.commonutil.util.e.a());
                        this.f22997h = webView;
                        webView.setWebViewClient(new WebViewClient());
                        WebView webView2 = this.f22997h;
                        WebSettings settings = webView2 != null ? webView2.getSettings() : null;
                        if (settings != null) {
                            settings.setJavaScriptEnabled(true);
                        }
                    } catch (Exception unused) {
                        e4.b().w(this.f22990a, "create web view error");
                    }
                }
                WebView webView3 = this.f22997h;
                if (webView3 != null) {
                    webView3.loadUrl(str);
                }
            }
        }
        return true;
    }

    public final void c() {
        WebView webView = this.f22997h;
        if (webView != null) {
            try {
                webView.clearHistory();
                webView.clearCache(true);
                webView.loadUrl(TmcConstants.LOAD_BASE_DATA_URL);
                webView.freeMemory();
                webView.destroy();
            } catch (Exception unused) {
            }
        }
        this.f22997h = null;
        if (this.f23002m) {
            com.cloud.hisavana.sdk.common.util.e.f22235a.d(this.f23003n);
        }
        this.f22999j = null;
    }

    public final void d(final TadmWebView admWebView, final AdsDTO mAdBean, s4 loadAdmListener) {
        Intrinsics.h(admWebView, "admWebView");
        Intrinsics.h(mAdBean, "mAdBean");
        Intrinsics.h(loadAdmListener, "loadAdmListener");
        admWebView.addJavascriptInterface(new w4(this.f23000k), "loadError");
        admWebView.setWebViewClient(new b5(this.f23000k));
        admWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.cloud.hisavana.sdk.x4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean g11;
                g11 = r.g(r.this, mAdBean, admWebView, view, motionEvent);
                return g11;
            }
        });
        this.f22998i = mAdBean;
        this.f22999j = loadAdmListener;
        this.f22995f = 0;
    }

    public final void j(boolean z10) {
        this.f23002m = z10;
    }
}
