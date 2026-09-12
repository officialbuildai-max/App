package com.vungle.ads.internal.ui;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import com.aliyun.player.BuildConfig;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.ads.EvaluateJsError;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.ui.view.b;
import com.vungle.ads.internal.util.o;
import java.util.concurrent.ExecutorService;
import kotlin.Deprecated;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.s;

/* loaded from: classes7.dex */
public final class i extends WebViewClient implements com.vungle.ads.internal.ui.view.b {
    public static final a Companion = new a(null);
    private static final String TAG = "VungleWebClient";
    private final AdPayload advertisement;
    private boolean collectConsent;
    private b.InterfaceC0742b errorHandler;
    private String gdprAccept;
    private String gdprBody;
    private String gdprDeny;
    private String gdprTitle;
    private Boolean isViewable;
    private WebView loadedWebView;
    private b.a mraidDelegate;
    private final ExecutorService offloadExecutor;
    private final com.vungle.ads.internal.model.g placement;
    private final com.vungle.ads.internal.platform.d platform;
    private boolean ready;
    private final SignalManager signalManager;
    private com.vungle.ads.internal.omsdk.d webViewObserver;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends WebViewRenderProcessClient {
        private b.InterfaceC0742b errorHandler;

        public b(b.InterfaceC0742b interfaceC0742b) {
            this.errorHandler = interfaceC0742b;
        }

        public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            Intrinsics.h(webView, "webView");
        }

        public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            Intrinsics.h(webView, "webView");
            o.a aVar = o.Companion;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onRenderProcessUnresponsive(Title = ");
            sb2.append(webView.getTitle());
            sb2.append(", URL = ");
            sb2.append(webView.getOriginalUrl());
            sb2.append(", (webViewRenderProcess != null) = ");
            sb2.append(webViewRenderProcess != null);
            aVar.w(i.TAG, sb2.toString());
            b.InterfaceC0742b interfaceC0742b = this.errorHandler;
            if (interfaceC0742b != null) {
                interfaceC0742b.onRenderProcessUnresponsive(webView, webViewRenderProcess);
            }
        }
    }

    public i(AdPayload advertisement, com.vungle.ads.internal.model.g placement, ExecutorService offloadExecutor, SignalManager signalManager, com.vungle.ads.internal.platform.d dVar) {
        Intrinsics.h(advertisement, "advertisement");
        Intrinsics.h(placement, "placement");
        Intrinsics.h(offloadExecutor, "offloadExecutor");
        this.advertisement = advertisement;
        this.placement = placement;
        this.offloadExecutor = offloadExecutor;
        this.signalManager = signalManager;
        this.platform = dVar;
    }

    public /* synthetic */ i(AdPayload adPayload, com.vungle.ads.internal.model.g gVar, ExecutorService executorService, SignalManager signalManager, com.vungle.ads.internal.platform.d dVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(adPayload, gVar, executorService, (i11 & 8) != 0 ? null : signalManager, (i11 & 16) != 0 ? null : dVar);
    }

    public static /* synthetic */ void getCollectConsent$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getErrorHandler$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getGdprAccept$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getGdprBody$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getGdprDeny$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getGdprTitle$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getLoadedWebView$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getMraidDelegate$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getReady$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getWebViewObserver$vungle_ads_release$annotations() {
    }

    private final void handleWebViewError(String str, String str2, boolean z10) {
        String str3 = str2 + ' ' + str;
        b.InterfaceC0742b interfaceC0742b = this.errorHandler;
        if (interfaceC0742b != null) {
            interfaceC0742b.onReceivedError(str3, z10);
        }
    }

    private final boolean isCriticalAsset(String str) {
        if (str.length() > 0) {
            return this.advertisement.isCriticalAsset(str);
        }
        return false;
    }

    public static /* synthetic */ void isViewable$vungle_ads_release$annotations() {
    }

    private final void runJavascriptOnWebView(WebView webView, String str) {
        try {
            o.Companion.w(TAG, "mraid Injecting JS " + str);
            if (webView != null) {
                webView.evaluateJavascript(str, null);
            }
        } catch (Throwable th2) {
            new EvaluateJsError("Evaluate js failed " + th2.getLocalizedMessage()).setLogEntry$vungle_ads_release(this.advertisement.getLogEntry$vungle_ads_release()).logErrorNoReturnValue$vungle_ads_release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: shouldOverrideUrlLoading$lambda-6$lambda-1, reason: not valid java name */
    public static final void m1093shouldOverrideUrlLoading$lambda6$lambda1(final i this$0, Handler handler, final WebView webView) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(handler, "$handler");
        final String str = "window.vungle.mraidBridge.notifyReadyEvent(" + this$0.advertisement.createMRAIDArgs() + ')';
        handler.post(new Runnable() { // from class: com.vungle.ads.internal.ui.f
            @Override // java.lang.Runnable
            public final void run() {
                i.m1094shouldOverrideUrlLoading$lambda6$lambda1$lambda0(i.this, webView, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: shouldOverrideUrlLoading$lambda-6$lambda-1$lambda-0, reason: not valid java name */
    public static final void m1094shouldOverrideUrlLoading$lambda6$lambda1$lambda0(i this$0, WebView webView, String injectJs) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(injectJs, "$injectJs");
        this$0.runJavascriptOnWebView(webView, injectJs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: shouldOverrideUrlLoading$lambda-6$lambda-5$lambda-4, reason: not valid java name */
    public static final void m1095shouldOverrideUrlLoading$lambda6$lambda5$lambda4(b.a it, String command, JsonObject args, Handler handler, final i this$0, final WebView webView) {
        Intrinsics.h(it, "$it");
        Intrinsics.h(command, "$command");
        Intrinsics.h(args, "$args");
        Intrinsics.h(handler, "$handler");
        Intrinsics.h(this$0, "this$0");
        if (it.processCommand(command, args)) {
            handler.post(new Runnable() { // from class: com.vungle.ads.internal.ui.e
                @Override // java.lang.Runnable
                public final void run() {
                    i.m1096shouldOverrideUrlLoading$lambda6$lambda5$lambda4$lambda3(i.this, webView);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: shouldOverrideUrlLoading$lambda-6$lambda-5$lambda-4$lambda-3, reason: not valid java name */
    public static final void m1096shouldOverrideUrlLoading$lambda6$lambda5$lambda4$lambda3(i this$0, WebView webView) {
        Intrinsics.h(this$0, "this$0");
        this$0.runJavascriptOnWebView(webView, "window.vungle.mraidBridge.notifyCommandComplete()");
    }

    public final boolean getCollectConsent$vungle_ads_release() {
        return this.collectConsent;
    }

    public final b.InterfaceC0742b getErrorHandler$vungle_ads_release() {
        return this.errorHandler;
    }

    public final String getGdprAccept$vungle_ads_release() {
        return this.gdprAccept;
    }

    public final String getGdprBody$vungle_ads_release() {
        return this.gdprBody;
    }

    public final String getGdprDeny$vungle_ads_release() {
        return this.gdprDeny;
    }

    public final String getGdprTitle$vungle_ads_release() {
        return this.gdprTitle;
    }

    public final WebView getLoadedWebView$vungle_ads_release() {
        return this.loadedWebView;
    }

    public final b.a getMraidDelegate$vungle_ads_release() {
        return this.mraidDelegate;
    }

    public final boolean getReady$vungle_ads_release() {
        return this.ready;
    }

    public final com.vungle.ads.internal.omsdk.d getWebViewObserver$vungle_ads_release() {
        return this.webViewObserver;
    }

    public final Boolean isViewable$vungle_ads_release() {
        return this.isViewable;
    }

    public final void notifyDiskAvailableSize(long j11) {
        WebView webView = this.loadedWebView;
        if (webView != null) {
            runJavascriptOnWebView(webView, "window.vungle.mraidBridgeExt.notifyAvailableDiskSpace(" + j11 + ')');
        }
    }

    @Override // com.vungle.ads.internal.ui.view.b
    public void notifyPropertiesChange(boolean z10) {
        WebView webView = this.loadedWebView;
        if (webView != null) {
            s sVar = new s();
            s sVar2 = new s();
            kotlinx.serialization.json.i.b(sVar2, "width", Integer.valueOf(webView.getWidth()));
            kotlinx.serialization.json.i.b(sVar2, "height", Integer.valueOf(webView.getHeight()));
            JsonObject a11 = sVar2.a();
            s sVar3 = new s();
            kotlinx.serialization.json.i.b(sVar3, "x", 0);
            kotlinx.serialization.json.i.b(sVar3, "y", 0);
            kotlinx.serialization.json.i.b(sVar3, "width", Integer.valueOf(webView.getWidth()));
            kotlinx.serialization.json.i.b(sVar3, "height", Integer.valueOf(webView.getHeight()));
            JsonObject a12 = sVar3.a();
            s sVar4 = new s();
            Boolean bool = Boolean.FALSE;
            kotlinx.serialization.json.i.a(sVar4, "sms", bool);
            kotlinx.serialization.json.i.a(sVar4, "tel", bool);
            kotlinx.serialization.json.i.a(sVar4, "calendar", bool);
            kotlinx.serialization.json.i.a(sVar4, "storePicture", bool);
            kotlinx.serialization.json.i.a(sVar4, "inlineVideo", bool);
            JsonObject a13 = sVar4.a();
            sVar.b("maxSize", a11);
            sVar.b("screenSize", a11);
            sVar.b("defaultPosition", a12);
            sVar.b("currentPosition", a12);
            sVar.b("supports", a13);
            kotlinx.serialization.json.i.c(sVar, "placementType", this.advertisement.templateType());
            Boolean bool2 = this.isViewable;
            if (bool2 != null) {
                kotlinx.serialization.json.i.a(sVar, "isViewable", bool2);
            }
            kotlinx.serialization.json.i.c(sVar, "os", "android");
            kotlinx.serialization.json.i.c(sVar, "osVersion", String.valueOf(Build.VERSION.SDK_INT));
            kotlinx.serialization.json.i.a(sVar, "incentivized", Boolean.valueOf(this.placement.isRewardedVideo()));
            kotlinx.serialization.json.i.c(sVar, "version", BuildConfig.VERSION_NAME);
            com.vungle.ads.internal.platform.d dVar = this.platform;
            if (dVar != null) {
                kotlinx.serialization.json.i.a(sVar, "isSilent", Boolean.valueOf(dVar.isSilentModeEnabled()));
            }
            if (this.collectConsent) {
                kotlinx.serialization.json.i.a(sVar, "consentRequired", Boolean.TRUE);
                kotlinx.serialization.json.i.c(sVar, "consentTitleText", this.gdprTitle);
                kotlinx.serialization.json.i.c(sVar, "consentBodyText", this.gdprBody);
                kotlinx.serialization.json.i.c(sVar, "consentAcceptButtonText", this.gdprAccept);
                kotlinx.serialization.json.i.c(sVar, "consentDenyButtonText", this.gdprDeny);
            } else {
                kotlinx.serialization.json.i.a(sVar, "consentRequired", bool);
            }
            if (!ConfigManager.INSTANCE.signalsDisabled()) {
                SignalManager signalManager = this.signalManager;
                String uuid = signalManager != null ? signalManager.getUuid() : null;
                if (uuid != null && uuid.length() != 0) {
                    SignalManager signalManager2 = this.signalManager;
                    kotlinx.serialization.json.i.c(sVar, "sessionId", signalManager2 != null ? signalManager2.getUuid() : null);
                }
            }
            kotlinx.serialization.json.i.c(sVar, "sdkVersion", "7.5.0");
            runJavascriptOnWebView(webView, "window.vungle.mraidBridge.notifyPropertiesChange(" + sVar.a() + ',' + z10 + ')');
        }
    }

    public final void notifySilentModeChange(boolean z10) {
        WebView webView = this.loadedWebView;
        if (webView != null) {
            s sVar = new s();
            kotlinx.serialization.json.i.a(sVar, "isSilent", Boolean.valueOf(z10));
            runJavascriptOnWebView(webView, "window.vungle.mraidBridge.notifyPropertiesChange(" + sVar.a() + ')');
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (webView == null) {
            return;
        }
        this.loadedWebView = webView;
        webView.setVisibility(0);
        notifyPropertiesChange(true);
        if (Build.VERSION.SDK_INT >= 29) {
            webView.setWebViewRenderProcessClient(c.a(new b(this.errorHandler)));
        }
        com.vungle.ads.internal.omsdk.d dVar = this.webViewObserver;
        if (dVar != null) {
            dVar.onPageFinished(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    @Deprecated
    public void onReceivedError(WebView webView, int i11, String description, String failingUrl) {
        Intrinsics.h(description, "description");
        Intrinsics.h(failingUrl, "failingUrl");
        super.onReceivedError(webView, i11, description, failingUrl);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        String valueOf = String.valueOf(webResourceError != null ? webResourceError.getDescription() : null);
        String valueOf2 = String.valueOf(webResourceRequest != null ? webResourceRequest.getUrl() : null);
        boolean z10 = false;
        boolean z11 = webResourceRequest != null && webResourceRequest.isForMainFrame();
        o.Companion.e(TAG, "Error desc " + valueOf + ' ' + z11 + " for URL " + valueOf2);
        if (isCriticalAsset(valueOf2) && z11) {
            z10 = true;
        }
        handleWebViewError(valueOf, valueOf2, z10);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        String valueOf = String.valueOf(webResourceResponse != null ? Integer.valueOf(webResourceResponse.getStatusCode()) : null);
        String valueOf2 = String.valueOf(webResourceRequest != null ? webResourceRequest.getUrl() : null);
        boolean z10 = false;
        boolean z11 = webResourceRequest != null && webResourceRequest.isForMainFrame();
        o.Companion.e(TAG, "Http Error desc " + valueOf + ' ' + z11 + " for URL " + valueOf2);
        if (isCriticalAsset(valueOf2) && z11) {
            z10 = true;
        }
        handleWebViewError(valueOf, valueOf2, z10);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        Boolean bool;
        boolean didCrash;
        boolean didCrash2;
        Boolean bool2 = null;
        this.loadedWebView = null;
        if (Build.VERSION.SDK_INT < 26) {
            o.a aVar = o.Companion;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onRenderProcessGone url: ");
            sb2.append(webView != null ? webView.getUrl() : null);
            aVar.w(TAG, sb2.toString());
            b.InterfaceC0742b interfaceC0742b = this.errorHandler;
            if (interfaceC0742b != null) {
                return interfaceC0742b.onWebRenderingProcessGone(webView, Boolean.TRUE);
            }
            return true;
        }
        o.a aVar2 = o.Companion;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("onRenderProcessGone url: ");
        sb3.append(webView != null ? webView.getUrl() : null);
        sb3.append(", did crash: ");
        if (renderProcessGoneDetail != null) {
            didCrash2 = renderProcessGoneDetail.didCrash();
            bool = Boolean.valueOf(didCrash2);
        } else {
            bool = null;
        }
        sb3.append(bool);
        aVar2.w(TAG, sb3.toString());
        b.InterfaceC0742b interfaceC0742b2 = this.errorHandler;
        if (interfaceC0742b2 == null) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        if (renderProcessGoneDetail != null) {
            didCrash = renderProcessGoneDetail.didCrash();
            bool2 = Boolean.valueOf(didCrash);
        }
        return interfaceC0742b2.onWebRenderingProcessGone(webView, bool2);
    }

    @Override // com.vungle.ads.internal.ui.view.b
    public void setAdVisibility(boolean z10) {
        this.isViewable = Boolean.valueOf(z10);
        notifyPropertiesChange(false);
    }

    public final void setCollectConsent$vungle_ads_release(boolean z10) {
        this.collectConsent = z10;
    }

    @Override // com.vungle.ads.internal.ui.view.b
    public void setConsentStatus(boolean z10, String str, String str2, String str3, String str4) {
        this.collectConsent = z10;
        this.gdprTitle = str;
        this.gdprBody = str2;
        this.gdprAccept = str3;
        this.gdprDeny = str4;
    }

    @Override // com.vungle.ads.internal.ui.view.b
    public void setErrorHandler(b.InterfaceC0742b errorHandler) {
        Intrinsics.h(errorHandler, "errorHandler");
        this.errorHandler = errorHandler;
    }

    public final void setErrorHandler$vungle_ads_release(b.InterfaceC0742b interfaceC0742b) {
        this.errorHandler = interfaceC0742b;
    }

    public final void setGdprAccept$vungle_ads_release(String str) {
        this.gdprAccept = str;
    }

    public final void setGdprBody$vungle_ads_release(String str) {
        this.gdprBody = str;
    }

    public final void setGdprDeny$vungle_ads_release(String str) {
        this.gdprDeny = str;
    }

    public final void setGdprTitle$vungle_ads_release(String str) {
        this.gdprTitle = str;
    }

    public final void setLoadedWebView$vungle_ads_release(WebView webView) {
        this.loadedWebView = webView;
    }

    @Override // com.vungle.ads.internal.ui.view.b
    public void setMraidDelegate(b.a aVar) {
        this.mraidDelegate = aVar;
    }

    public final void setMraidDelegate$vungle_ads_release(b.a aVar) {
        this.mraidDelegate = aVar;
    }

    public final void setReady$vungle_ads_release(boolean z10) {
        this.ready = z10;
    }

    public final void setViewable$vungle_ads_release(Boolean bool) {
        this.isViewable = bool;
    }

    @Override // com.vungle.ads.internal.ui.view.b
    public void setWebViewObserver(com.vungle.ads.internal.omsdk.d dVar) {
        this.webViewObserver = dVar;
    }

    public final void setWebViewObserver$vungle_ads_release(com.vungle.ads.internal.omsdk.d dVar) {
        this.webViewObserver = dVar;
    }

    @Override // android.webkit.WebViewClient
    @Deprecated
    public boolean shouldOverrideUrlLoading(final WebView webView, String str) {
        o.a aVar = o.Companion;
        aVar.d(TAG, "MRAID Command " + str);
        if (str == null || str.length() == 0) {
            aVar.e(TAG, "Invalid URL ");
            return false;
        }
        Uri parse = Uri.parse(str);
        if (parse == null || parse.getScheme() == null) {
            return false;
        }
        String scheme = parse.getScheme();
        if (Intrinsics.c(scheme, CampaignEx.JSON_KEY_MRAID)) {
            final String host = parse.getHost();
            if (host != null) {
                if (!Intrinsics.c("propertiesChangeCompleted", host)) {
                    final b.a aVar2 = this.mraidDelegate;
                    if (aVar2 != null) {
                        s sVar = new s();
                        for (String param : parse.getQueryParameterNames()) {
                            Intrinsics.g(param, "param");
                            kotlinx.serialization.json.i.c(sVar, param, parse.getQueryParameter(param));
                        }
                        final JsonObject a11 = sVar.a();
                        final Handler handler = new Handler(Looper.getMainLooper());
                        this.offloadExecutor.submit(new Runnable() { // from class: com.vungle.ads.internal.ui.h
                            @Override // java.lang.Runnable
                            public final void run() {
                                i.m1095shouldOverrideUrlLoading$lambda6$lambda5$lambda4(b.a.this, host, a11, handler, this, webView);
                            }
                        });
                    }
                } else if (!this.ready) {
                    this.ready = true;
                    final Handler handler2 = new Handler(Looper.getMainLooper());
                    this.offloadExecutor.submit(new Runnable() { // from class: com.vungle.ads.internal.ui.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            i.m1093shouldOverrideUrlLoading$lambda6$lambda1(i.this, handler2, webView);
                        }
                    });
                }
                return true;
            }
        } else if (StringsKt.H("http", scheme, true) || StringsKt.H("https", scheme, true)) {
            aVar.d(TAG, "Open URL" + str);
            b.a aVar3 = this.mraidDelegate;
            if (aVar3 != null) {
                s sVar2 = new s();
                kotlinx.serialization.json.i.c(sVar2, "url", str);
                aVar3.processCommand("openNonMraid", sVar2.a());
            }
            return true;
        }
        return false;
    }
}
