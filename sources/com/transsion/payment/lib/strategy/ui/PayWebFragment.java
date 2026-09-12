package com.transsion.payment.lib.strategy.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import be.g;
import com.blankj.utilcode.util.u;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.payment.lib.d;
import com.transsion.payment.lib.strategy.ui.PayWebActivity;
import com.transsion.payment.lib.strategy.ui.PayWebFragment;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import nh.m;
import nh.n;
import th.h;
import uy.e;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 V2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00013B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u0005J\u001f\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010!\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\bH\u0002¢\u0006\u0004\b&\u0010\u0005J\u0017\u0010'\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0003¢\u0006\u0004\b'\u0010(J\u0019\u0010+\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0004\b+\u0010,J\u001f\u0010/\u001a\u00020 2\u0006\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020#H\u0002¢\u0006\u0004\b/\u00100J\u0019\u00101\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00104R\u0016\u0010A\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010@R4\u0010I\u001a\"\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010E0Dj\u0010\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010E`F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010@R\u0016\u0010M\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010@R\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010T¨\u0006W"}, d2 = {"Lcom/transsion/payment/lib/strategy/ui/PayWebFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lrn/b;", "Lnh/n;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "r0", "(Landroid/view/LayoutInflater;)Lrn/b;", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "lazyLoadData", "onDestroyView", "onDestroy", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "onDisconnected", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "onConnected", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "", "w0", "()Z", "", "getClassTag", "()Ljava/lang/String;", "initViewModel", "v0", "(Landroid/view/View;)V", "Landroid/webkit/WebView;", "webView", "q0", "(Landroid/webkit/WebView;)V", "url", "from", "p0", "(Ljava/lang/String;Ljava/lang/String;)Z", "x0", "(Ljava/lang/String;)V", "a", "Ljava/lang/String;", "strTitle", "Landroid/view/ViewGroup;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/view/ViewGroup;", "webLoading", "c", "Landroid/webkit/WebView;", "mCustomWebView", "d", "mUrl", "e", "Z", "isError", "f", "isPayCancel", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", g.f16474b, "Ljava/util/HashMap;", "timer", "h", "isTriggerFinishPage", "i", "isRenderProcessGone", "Landroid/webkit/WebChromeClient;", j.f35620b, "Landroid/webkit/WebChromeClient;", "mWebChromeClient", "Landroid/webkit/WebViewClient;", CampaignEx.JSON_KEY_AD_K, "Landroid/webkit/WebViewClient;", "mWebViewClient", "l", "LibPayment_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class PayWebFragment extends BaseFragment<rn.b> implements n {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    private static final String f47893m = "https://api.paynicorn.com/sp-gateway/redirect/mock";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ViewGroup webLoading;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private WebView mCustomWebView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String mUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isError;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isPayCancel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isTriggerFinishPage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isRenderProcessGone;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String strTitle = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final HashMap timer = new HashMap();

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private WebChromeClient mWebChromeClient = new b();

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private WebViewClient mWebViewClient = new c();

    /* renamed from: com.transsion.payment.lib.strategy.ui.PayWebFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PayWebFragment a() {
            return new PayWebFragment();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends WebChromeClient {
        b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView view, int i11) {
            Intrinsics.h(view, "view");
            super.onProgressChanged(view, i11);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView view, String title) {
            rn.b mViewBinding;
            AppCompatTextView appCompatTextView;
            Intrinsics.h(view, "view");
            Intrinsics.h(title, "title");
            super.onReceivedTitle(view, title);
            PayWebFragment.this.strTitle = title;
            String str = PayWebFragment.this.strTitle;
            if (str == null || (mViewBinding = PayWebFragment.this.getMViewBinding()) == null || (appCompatTextView = mViewBinding.f74711i) == null) {
                return;
            }
            appCompatTextView.setText(str);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends WebViewClient {
        c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Intrinsics.h(view, "view");
            Intrinsics.h(url, "url");
            super.onPageFinished(view, url);
            if (PayWebFragment.this.isError) {
                return;
            }
            PayWebFragment.this.x0(url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap bitmap) {
            HashMap g11;
            ProgressBar progressBar;
            Intrinsics.h(view, "view");
            Intrinsics.h(url, "url");
            super.onPageStarted(view, url, bitmap);
            if (PayWebFragment.this.p0(url, "onPageStarted()")) {
                return;
            }
            ViewGroup viewGroup = PayWebFragment.this.webLoading;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            rn.b mViewBinding = PayWebFragment.this.getMViewBinding();
            if (mViewBinding != null && (progressBar = mViewBinding.f74708f) != null) {
                progressBar.setVisibility(8);
            }
            if (PayWebFragment.this.timer.get(url) == null) {
                PayWebFragment.this.timer.put(url, Long.valueOf(System.currentTimeMillis()));
            }
            hj.b logViewConfig = PayWebFragment.this.getLogViewConfig();
            if (logViewConfig != null && (g11 = logViewConfig.g()) != null) {
                g11.put("url", url);
            }
            PayWebFragment.this.isError = false;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            Intrinsics.h(view, "view");
            Intrinsics.h(request, "request");
            Intrinsics.h(error, "error");
            super.onReceivedError(view, request, error);
            d.f47833a.b(PayWebFragment.this.getClassTag() + " --> mWebViewClient --> onReceivedError() --> url = " + request.getUrl() + " --> error = " + error);
            PayWebFragment.this.isError = true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            Intrinsics.h(view, "view");
            Intrinsics.h(request, "request");
            Intrinsics.h(errorResponse, "errorResponse");
            super.onReceivedHttpError(view, request, errorResponse);
            d.f47833a.b(PayWebFragment.this.getClassTag() + " --> mWebViewClient --> onReceivedHttpError() --> url = " + request.getUrl() + " --> errorResponse = " + errorResponse);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
            boolean didCrash;
            Intrinsics.h(view, "view");
            Intrinsics.h(detail, "detail");
            PayWebFragment.this.isRenderProcessGone = true;
            FragmentActivity fragmentActivity = null;
            if (PayWebFragment.this.mCustomWebView == view) {
                PayWebFragment.this.mCustomWebView = null;
            }
            d dVar = d.f47833a;
            String classTag = PayWebFragment.this.getClassTag();
            didCrash = detail.didCrash();
            dVar.b(classTag + " --> renderer gone, didCrash = " + didCrash + ", close cashier");
            boolean c11 = gm.n.f64010a.c(view, detail, "payment");
            FragmentActivity activity = PayWebFragment.this.getActivity();
            if (activity != null) {
                if (!activity.isDestroyed() && !activity.isFinishing()) {
                    fragmentActivity = activity;
                }
                if (fragmentActivity != null) {
                    fragmentActivity.finish();
                }
            }
            return c11;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            Intrinsics.h(view, "view");
            Intrinsics.h(request, "request");
            PayWebFragment payWebFragment = PayWebFragment.this;
            String uri = request.getUrl().toString();
            Intrinsics.g(uri, "toString(...)");
            payWebFragment.p0(uri, "shouldInterceptRequest()");
            return super.shouldInterceptRequest(view, request);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Uri url;
            String uri;
            Context context;
            if (webResourceRequest != null && (url = webResourceRequest.getUrl()) != null && (uri = url.toString()) != null) {
                PayWebFragment payWebFragment = PayWebFragment.this;
                if (StringsKt.W(uri, "tel:", false, 2, null)) {
                    d.f47833a.b(payWebFragment.getClassTag() + " --> mWebViewClient --> shouldOverrideUrlLoading() --> 使用Intent来处理拨号请求 --> url = " + uri);
                    Intent intent = new Intent("android.intent.action.DIAL");
                    intent.setData(Uri.parse(uri));
                    if (webView != null && (context = webView.getContext()) != null) {
                        context.startActivity(intent);
                    }
                    return true;
                }
                if (payWebFragment.p0(uri, "shouldOverrideUrlLoading()")) {
                    return true;
                }
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = PayWebFragment.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final void initViewModel() {
        String str;
        rn.b mViewBinding;
        AppCompatTextView appCompatTextView;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString(PayWebActivity.INSTANCE.a())) == null) {
            str = "";
        }
        this.mUrl = str;
        String[] a11 = u.a(str, "\\/");
        if (a11 != null) {
            if (a11.length == 0) {
                return;
            }
            String str2 = a11[a11.length - 1];
            this.strTitle = str2;
            if (str2 == null || (mViewBinding = getMViewBinding()) == null || (appCompatTextView = mViewBinding.f74711i) == null) {
                return;
            }
            appCompatTextView.setText(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p0(String url, String from) {
        if (this.isTriggerFinishPage) {
            return true;
        }
        if (!StringsKt.c0(url, f47893m, false, 2, null)) {
            if (!StringsKt.c0(url, "https://cashier-serverweb.paynicorn.com/api/cancelPay", false, 2, null)) {
                return false;
            }
            this.isTriggerFinishPage = true;
            d.f47833a.b(getClassTag() + " --> mWebViewClient --> checkUrl() --> from = " + from + " --> url = " + url);
            this.isPayCancel = true;
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return true;
            }
            activity.finish();
            return true;
        }
        this.isTriggerFinishPage = true;
        d.f47833a.b(getClassTag() + " --> mWebViewClient --> checkUrl() --> from = " + from + " --> url = " + url);
        e eVar = new e(0);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = e.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.postEvent(name, eVar, 0L);
        FragmentActivity activity2 = getActivity();
        if (activity2 == null) {
            return true;
        }
        activity2.finish();
        return true;
    }

    private final void q0(WebView webView) {
        Object m1185constructorimpl;
        if (webView == null || gm.n.f64010a.f(webView)) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            ViewParent parent = webView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(webView);
            }
            webView.stopLoading();
            webView.removeAllViews();
            webView.destroy();
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            d.f47833a.b(getClassTag() + " --> destroy WebView failed: " + m1188exceptionOrNullimpl.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(PayWebFragment payWebFragment, View view) {
        WebView webView;
        if (payWebFragment.isRenderProcessGone || (webView = payWebFragment.mCustomWebView) == null) {
            return;
        }
        webView.reload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(PayWebFragment payWebFragment, View view) {
        FragmentActivity activity = payWebFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(PayWebFragment payWebFragment, View view) {
        FragmentActivity activity = payWebFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void v0(View view) {
        ProgressBar progressBar;
        HashMap g11;
        HashMap g12;
        FrameLayout frameLayout;
        Context context = view.getContext();
        WebView webView = new WebView(context);
        rn.b mViewBinding = getMViewBinding();
        if (mViewBinding != null && (frameLayout = mViewBinding.f74704b) != null) {
            frameLayout.addView(webView, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        webView.setLayerType(2, null);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(false);
        settings.setSavePassword(false);
        m mVar = m.f70597a;
        Intrinsics.e(context);
        settings.setCacheMode(mVar.j(context) ? -1 : 1);
        settings.setMixedContentMode(0);
        settings.setTextZoom(100);
        settings.setDatabaseEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setSupportMultipleWindows(false);
        settings.setBlockNetworkImage(false);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(false);
        settings.setUseWideViewPort(false);
        settings.setDomStorageEnabled(true);
        settings.setNeedInitialFocus(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setDefaultFontSize(16);
        settings.setMinimumFontSize(12);
        settings.setGeolocationEnabled(true);
        webView.setWebChromeClient(this.mWebChromeClient);
        webView.setWebViewClient(this.mWebViewClient);
        webView.setOverScrollMode(2);
        this.mCustomWebView = webView;
        String str = this.mUrl;
        if (str != null) {
            this.timer.put(str, Long.valueOf(System.currentTimeMillis()));
            hj.b logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (g12 = logViewConfig.g()) != null) {
                g12.put("url", this.mUrl);
            }
            hj.b logViewConfig2 = getLogViewConfig();
            if (logViewConfig2 != null && (g11 = logViewConfig2.g()) != null) {
                g11.put("loading", "1");
            }
            rn.b mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (progressBar = mViewBinding2.f74708f) != null) {
                progressBar.setVisibility(0);
            }
            d.f47833a.a(getClassTag() + " --> initWeb() --> WebView初始化完成 --> mCustomWebView?.loadUrl(it) 开始加载收银台 -- url = " + this.mUrl);
            WebView webView2 = this.mCustomWebView;
            if (webView2 != null) {
                webView2.loadUrl(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(String url) {
        HashMap g11;
        HashMap g12;
        HashMap g13;
        HashMap g14;
        if (this.timer.get(url) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Long l11 = (Long) this.timer.get(url);
            long longValue = currentTimeMillis - (l11 != null ? l11.longValue() : currentTimeMillis);
            d.f47833a.a(getClassTag() + " --> pageFinish() --> mUrl = " + this.mUrl + " -- used time = " + longValue);
            hj.b logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (g14 = logViewConfig.g()) != null) {
                g14.put("load_h5_time", String.valueOf(longValue));
            }
            if (this.timer.get("on_create") != null) {
                Object obj = this.timer.get("on_create");
                Intrinsics.e(obj);
                long longValue2 = currentTimeMillis - ((Number) obj).longValue();
                hj.b logViewConfig2 = getLogViewConfig();
                if (logViewConfig2 != null && (g13 = logViewConfig2.g()) != null) {
                    g13.put("load_time", String.valueOf(longValue2));
                }
                this.timer.put("on_create", null);
            }
            hj.b logViewConfig3 = getLogViewConfig();
            if (logViewConfig3 != null && (g12 = logViewConfig3.g()) != null) {
                g12.put("load_h5_time", String.valueOf(longValue));
            }
        }
        hj.b logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (g11 = logViewConfig4.g()) != null) {
            PayWebActivity.Companion companion = PayWebActivity.INSTANCE;
            String b11 = companion.b();
            Bundle arguments = getArguments();
            g11.put(b11, arguments != null ? arguments.getString(companion.b()) : null);
        }
        hj.b logViewConfig5 = getLogViewConfig();
        if (logViewConfig5 != null) {
            logViewConfig5.k(true);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        h hVar;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        AppCompatImageView appCompatImageView3;
        Intrinsics.h(view, "view");
        rn.b mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            ConstraintLayout toolBar = mViewBinding.f74710h;
            Intrinsics.g(toolBar, "toolBar");
            jg.c.k(toolBar);
        }
        this.timer.put("on_create", Long.valueOf(System.currentTimeMillis()));
        rn.b mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (appCompatImageView3 = mViewBinding2.f74707e) != null) {
            appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: sn.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PayWebFragment.s0(PayWebFragment.this, view2);
                }
            });
        }
        rn.b mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (appCompatImageView2 = mViewBinding3.f74705c) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: sn.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PayWebFragment.t0(PayWebFragment.this, view2);
                }
            });
        }
        rn.b mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (appCompatImageView = mViewBinding4.f74706d) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: sn.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PayWebFragment.u0(PayWebFragment.this, view2);
                }
            });
        }
        rn.b mViewBinding5 = getMViewBinding();
        this.webLoading = (mViewBinding5 == null || (hVar = mViewBinding5.f74712j) == null) ? null : hVar.f76371b;
        initViewModel();
        v0(view);
        m.f70597a.l(this);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public hj.b newLogViewConfig() {
        return new hj.b("snifferh5page", false, 2, null);
    }

    @Override // nh.n
    public void onConnected() {
        n.a.a(this);
    }

    @Override // nh.n
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        WebView webView;
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        if (this.isRenderProcessGone) {
            return;
        }
        hj.b logViewConfig = getLogViewConfig();
        if ((logViewConfig == null || !logViewConfig.i()) && this.isError && (webView = this.mCustomWebView) != null) {
            webView.reload();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d.f47833a.a(getClassTag() + " --> onCreate() --> 聚合支付收银台容器初始化");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        m.f70597a.m(this);
        if (this.isPayCancel) {
            e eVar = new e(-1);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = e.class.getName();
            Intrinsics.g(name, "getName(...)");
            flowEventBus.postEvent(name, eVar, 0L);
            return;
        }
        e eVar2 = new e(0);
        FlowEventBus flowEventBus2 = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = e.class.getName();
        Intrinsics.g(name2, "getName(...)");
        flowEventBus2.postEvent(name2, eVar2, 0L);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        q0(this.mCustomWebView);
        this.mCustomWebView = null;
        super.onDestroyView();
    }

    @Override // nh.n
    public void onDisconnected() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public rn.b getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        rn.b c11 = rn.b.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    public final boolean w0() {
        WebView webView = this.mCustomWebView;
        if (webView == null || !webView.canGoBack()) {
            return false;
        }
        WebView webView2 = this.mCustomWebView;
        if (webView2 == null) {
            return true;
        }
        webView2.goBack();
        return true;
    }
}
