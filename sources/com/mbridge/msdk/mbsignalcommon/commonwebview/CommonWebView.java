package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.s0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.webview.ProgressBar;
import com.mbridge.msdk.mbsignalcommon.base.BaseWebView;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import java.util.ArrayList;
import org.mvel2.ast.ASTNode;

/* loaded from: classes5.dex */
public class CommonWebView extends LinearLayout {
    public static int DEFAULT_JUMP_TIMEOUT = 10000;

    /* renamed from: a, reason: collision with root package name */
    private int f36508a;

    /* renamed from: b, reason: collision with root package name */
    private int f36509b;

    /* renamed from: c, reason: collision with root package name */
    protected ToolBar f36510c;

    /* renamed from: d, reason: collision with root package name */
    protected ToolBar f36511d;

    /* renamed from: e, reason: collision with root package name */
    protected ProgressBar f36512e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f36513f;

    /* renamed from: g, reason: collision with root package name */
    private View.OnClickListener f36514g;

    /* renamed from: h, reason: collision with root package name */
    private com.mbridge.msdk.mbsignalcommon.commonwebview.b f36515h;

    /* renamed from: i, reason: collision with root package name */
    private com.mbridge.msdk.mbsignalcommon.commonwebview.a f36516i;

    /* renamed from: j, reason: collision with root package name */
    protected BaseWebView f36517j;

    /* renamed from: k, reason: collision with root package name */
    private View.OnClickListener f36518k;

    /* renamed from: l, reason: collision with root package name */
    private View.OnClickListener f36519l;

    /* renamed from: m, reason: collision with root package name */
    private View.OnClickListener f36520m;

    /* renamed from: n, reason: collision with root package name */
    private View.OnClickListener f36521n;

    /* renamed from: o, reason: collision with root package name */
    private Handler f36522o;

    /* renamed from: p, reason: collision with root package name */
    private int f36523p;

    /* renamed from: q, reason: collision with root package name */
    private WebViewClient f36524q;

    /* renamed from: r, reason: collision with root package name */
    private String f36525r;

    /* renamed from: s, reason: collision with root package name */
    private i f36526s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f36527t;

    /* renamed from: u, reason: collision with root package name */
    private final Runnable f36528u;

    /* loaded from: classes5.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o0.b("CommonWebView", "webview js!！超时上限：" + CommonWebView.this.f36523p + "ms");
            if (CommonWebView.this.f36526s != null) {
                CommonWebView.this.f36527t = false;
                CommonWebView.this.f36526s.a(CommonWebView.this.f36525r);
            }
        }
    }

    /* loaded from: classes5.dex */
    class b extends WebViewClient {
        b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            o0.c("CommonWebView", "newProgress! 开始! = " + str);
            CommonWebView.this.f36512e.setVisible(true);
            CommonWebView.this.f36512e.setProgressState(5);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (webView != null) {
                try {
                    ViewGroup viewGroup = (ViewGroup) webView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(webView);
                    }
                    if (webView instanceof WindVaneWebView) {
                        ((WindVaneWebView) webView).release();
                    } else {
                        webView.destroy();
                    }
                } catch (Throwable th2) {
                    o0.b("CommonWebView", th2.getMessage());
                }
            }
            return true;
        }
    }

    /* loaded from: classes5.dex */
    class c extends WebChromeClient {

        /* loaded from: classes5.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CommonWebView.this.f36512e.setVisible(false);
            }
        }

        c() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i11) {
            o0.c("CommonWebView", "newProgress! = " + i11);
            if (i11 == 100) {
                CommonWebView.this.f36512e.setProgressState(7);
                new Handler().postDelayed(new a(), 200L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseWebView baseWebView = CommonWebView.this.f36517j;
            if (baseWebView != null) {
                baseWebView.stopLoading();
                String str = (String) view.getTag();
                if (TextUtils.equals(str, ToolBar.BACKWARD)) {
                    CommonWebView.this.f36511d.getItem(ToolBar.FORWARD).setEnabled(true);
                    if (CommonWebView.this.f36517j.canGoBack()) {
                        CommonWebView.this.f36517j.goBack();
                    }
                    CommonWebView.this.f36511d.getItem(ToolBar.BACKWARD).setEnabled(CommonWebView.this.f36517j.canGoBack());
                    if (CommonWebView.this.f36518k != null) {
                        CommonWebView.this.f36518k.onClick(view);
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(str, ToolBar.FORWARD)) {
                    CommonWebView.this.f36511d.getItem(ToolBar.BACKWARD).setEnabled(true);
                    if (CommonWebView.this.f36517j.canGoForward()) {
                        CommonWebView.this.f36517j.goForward();
                    }
                    CommonWebView.this.f36511d.getItem(ToolBar.FORWARD).setEnabled(CommonWebView.this.f36517j.canGoForward());
                    if (CommonWebView.this.f36519l != null) {
                        CommonWebView.this.f36519l.onClick(view);
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(str, ToolBar.REFRESH)) {
                    CommonWebView.this.f36511d.getItem(ToolBar.BACKWARD).setEnabled(CommonWebView.this.f36517j.canGoBack());
                    CommonWebView.this.f36511d.getItem(ToolBar.FORWARD).setEnabled(CommonWebView.this.f36517j.canGoForward());
                    CommonWebView.this.f36517j.reload();
                    if (CommonWebView.this.f36520m != null) {
                        CommonWebView.this.f36520m.onClick(view);
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(str, ToolBar.EXITS)) {
                    if (CommonWebView.this.f36514g != null) {
                        CommonWebView.this.f36514g.onClick(view);
                    }
                } else if (TextUtils.equals(str, ToolBar.OPEN_BY_BROWSER)) {
                    if (CommonWebView.this.f36521n != null) {
                        CommonWebView.this.f36521n.onClick(view);
                    }
                    com.mbridge.msdk.click.c.c(CommonWebView.this.getContext(), CommonWebView.this.f36517j.getUrl());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e extends WebViewClient {
        e() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            CommonWebView.this.f36511d.getItem(ToolBar.BACKWARD).setEnabled(true);
            CommonWebView.this.f36511d.getItem(ToolBar.FORWARD).setEnabled(false);
            return false;
        }
    }

    /* loaded from: classes5.dex */
    class f extends WebViewClient {
        f() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (s0.a.b(str)) {
                s0.a.a(CommonWebView.this.getContext(), str, null);
            }
            return CommonWebView.this.a(webView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class g extends WebViewClient {
        g() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            CommonWebView.this.f36527t = false;
            CommonWebView.this.a();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            CommonWebView.this.f36525r = str;
            if (CommonWebView.this.f36527t) {
                return;
            }
            CommonWebView.this.f36527t = true;
            CommonWebView.this.c();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            CommonWebView.this.f36527t = false;
            CommonWebView.this.a();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            CommonWebView.this.f36525r = str;
            if (CommonWebView.this.f36527t) {
                CommonWebView.this.a();
            }
            CommonWebView.this.f36527t = true;
            CommonWebView.this.c();
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public interface h {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface i {
        void a(String str);
    }

    public CommonWebView(Context context) {
        super(context);
        this.f36528u = new a();
        init();
    }

    public CommonWebView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36528u = new a();
        init();
    }

    public CommonWebView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f36528u = new a();
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f36522o.removeCallbacks(this.f36528u);
    }

    private void a(ArrayList<ToolBar.b> arrayList, boolean z10) {
        if (this.f36510c != null) {
            return;
        }
        ToolBar.a aVar = new ToolBar.a();
        aVar.a(40);
        aVar.b(80);
        ToolBar toolBar = new ToolBar(getContext(), aVar, arrayList);
        this.f36510c = toolBar;
        toolBar.setBackgroundColor(Color.argb(153, 255, 255, 255));
        if (!z10) {
            this.f36510c.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f36508a));
            addView(this.f36510c, 0);
        } else {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f36508a);
            layoutParams.addRule(10);
            this.f36510c.setLayoutParams(layoutParams);
            this.f36513f.addView(this.f36510c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(WebView webView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            if (!parse.getScheme().equals("http") && !parse.getScheme().equals("https")) {
                if (parse.getScheme().equals("intent")) {
                    Intent parseUri = Intent.parseUri(str, 1);
                    try {
                        String str2 = parseUri.getPackage();
                        if (!TextUtils.isEmpty(str2) && getContext().getPackageManager().getLaunchIntentForPackage(str2) != null) {
                            parseUri.setComponent(null);
                            parseUri.setSelector(null);
                            parseUri.setFlags(ASTNode.DEOP);
                            getContext().startActivity(parseUri);
                            return true;
                        }
                    } catch (Throwable th2) {
                        o0.b("CommonWebView", th2.getMessage());
                    }
                    try {
                        String stringExtra = parseUri.getStringExtra("browser_fallback_url");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            Uri parse2 = Uri.parse(str);
                            if (!parse2.getScheme().equals("http") && !parse2.getScheme().equals("https")) {
                                str = stringExtra;
                            }
                            webView.loadUrl(stringExtra);
                            return false;
                        }
                    } catch (Throwable th3) {
                        o0.b("CommonWebView", th3.getMessage());
                    }
                }
                if (com.mbridge.msdk.click.c.d(getContext(), str)) {
                    o0.b("CommonWebView", "openDeepLink");
                    return true;
                }
                if (!TextUtils.isEmpty(str)) {
                    return !(str.startsWith("http") || str.startsWith("https"));
                }
            }
            return false;
        } catch (Throwable th4) {
            o0.b("CommonWebView", th4.getMessage());
            return false;
        }
    }

    private void b() {
        if (this.f36511d != null) {
            return;
        }
        this.f36511d = new ToolBar(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f36509b);
        layoutParams.bottomMargin = 0;
        this.f36511d.setLayoutParams(layoutParams);
        this.f36511d.setBackgroundColor(-1);
        this.f36511d.setOnItemClickListener(new d());
        addWebViewClient(new e());
        addView(this.f36511d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f36522o.postDelayed(this.f36528u, this.f36523p);
    }

    public void addWebChromeClient(WebChromeClient webChromeClient) {
        this.f36516i.a(webChromeClient);
    }

    public void addWebViewClient(WebViewClient webViewClient) {
        this.f36515h.a(webViewClient);
    }

    public View findToolBarButton(String str) {
        ToolBar toolBar;
        ToolBar toolBar2 = this.f36510c;
        View item = toolBar2 != null ? toolBar2.getItem(str) : null;
        return (item != null || (toolBar = this.f36511d) == null) ? item : toolBar.getItem(str);
    }

    public String getUrl() {
        BaseWebView baseWebView = this.f36517j;
        return baseWebView == null ? "" : baseWebView.getUrl();
    }

    public WebView getWebView() {
        return this.f36517j;
    }

    public void hideCustomizedToolBar() {
        ToolBar toolBar = this.f36510c;
        if (toolBar != null) {
            toolBar.setVisibility(8);
        }
    }

    public void hideDefaultToolBar() {
        ToolBar toolBar = this.f36511d;
        if (toolBar != null) {
            toolBar.setVisibility(8);
        }
    }

    public void hideToolBarButton(String str) {
        View findToolBarButton = findToolBarButton(str);
        if (findToolBarButton != null) {
            findToolBarButton.setVisibility(8);
        }
    }

    public void hideToolBarTitle() {
        this.f36510c.hideTitle();
    }

    public void init() {
        setOrientation(1);
        setGravity(17);
        this.f36513f = new RelativeLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        addView(this.f36513f, layoutParams);
        this.f36508a = t0.a(getContext(), 40.0f);
        this.f36509b = t0.a(getContext(), 40.0f);
        this.f36515h = new com.mbridge.msdk.mbsignalcommon.commonwebview.b();
        this.f36516i = new com.mbridge.msdk.mbsignalcommon.commonwebview.a();
        initWebview();
    }

    public void initWebview() {
        try {
            if (this.f36517j == null) {
                this.f36517j = new BaseWebView(getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(10);
            this.f36517j.setLayoutParams(layoutParams);
            BaseWebView baseWebView = this.f36517j;
            com.mbridge.msdk.mbsignalcommon.base.b bVar = baseWebView.mWebViewClient;
            baseWebView.setWebViewClient(this.f36515h);
            this.f36517j.setWebChromeClient(this.f36516i);
            addWebViewClient(bVar);
        } catch (Throwable th2) {
            o0.b("CommonWebView", "webview is error", th2);
        }
        this.f36513f.addView(this.f36517j);
    }

    public void loadUrl(String str) {
        this.f36517j.loadUrl(str);
        if (this.f36524q != null) {
            c();
        }
    }

    public void onBackwardClicked(View.OnClickListener onClickListener) {
        this.f36518k = onClickListener;
    }

    public void onForwardClicked(View.OnClickListener onClickListener) {
        this.f36519l = onClickListener;
    }

    public void onOpenByBrowserClicked(View.OnClickListener onClickListener) {
        this.f36521n = onClickListener;
    }

    public void onRefreshClicked(View.OnClickListener onClickListener) {
        this.f36520m = onClickListener;
    }

    public void removeWebChromeClient(WebChromeClient webChromeClient) {
        this.f36516i.b(webChromeClient);
    }

    public void removeWebViewClient(WebViewClient webViewClient) {
        this.f36515h.b(webViewClient);
    }

    public void setCustomizedToolBarFloating() {
        ((ViewGroup) this.f36510c.getParent()).removeView(this.f36510c);
        this.f36513f.addView(this.f36510c);
    }

    public void setCustomizedToolBarUnfloating() {
        ((ViewGroup) this.f36510c.getParent()).removeView(this.f36510c);
        addView(this.f36510c, 0);
    }

    public void setExitsClickListener(View.OnClickListener onClickListener) {
        this.f36514g = onClickListener;
    }

    public void setPageLoadTimtout(int i11) {
        this.f36523p = i11;
        if (this.f36522o == null) {
            this.f36522o = new Handler(Looper.getMainLooper());
        }
        if (this.f36524q == null) {
            g gVar = new g();
            this.f36524q = gVar;
            addWebViewClient(gVar);
        }
    }

    public void setPageLoadTimtoutListener(i iVar) {
        this.f36526s = iVar;
    }

    public void setToolBarTitle(String str) {
        this.f36510c.setTitle(str);
    }

    public void setToolBarTitle(String str, int i11) {
        this.f36510c.setTitle(str, i11);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        addWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        addWebViewClient(webViewClient);
    }

    public void showCustomizedToolBar() {
        ToolBar toolBar = this.f36510c;
        if (toolBar != null) {
            toolBar.setVisibility(0);
        }
    }

    public void showDefaultToolBar() {
        ToolBar toolBar = this.f36511d;
        if (toolBar != null) {
            toolBar.setVisibility(0);
        }
    }

    public void showToolBarButton(String str) {
        View findToolBarButton = findToolBarButton(str);
        if (findToolBarButton != null) {
            findToolBarButton.setVisibility(0);
        }
    }

    public void showToolBarTitle() {
        this.f36510c.showTitle();
    }

    public void useCustomizedToolBar(ArrayList<ToolBar.b> arrayList) {
        a(arrayList, false);
    }

    public void useCustomizedToolBar(ArrayList<ToolBar.b> arrayList, boolean z10) {
        a(arrayList, z10);
    }

    public void useDeeplink() {
        addWebViewClient(new f());
    }

    public void useDefaultToolBar() {
        b();
    }

    public void useProgressBar() {
        ProgressBar progressBar = new ProgressBar(getContext());
        this.f36512e = progressBar;
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-1, 4));
        addWebViewClient(new b());
        addWebChromeClient(new c());
        addView(this.f36512e);
        this.f36512e.initResource(true);
    }
}
