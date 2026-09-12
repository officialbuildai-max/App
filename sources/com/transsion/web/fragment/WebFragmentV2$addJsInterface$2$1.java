package com.transsion.web.fragment;

import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.view.v;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.web.api.WebJavascriptInterface;
import com.transsion.web.bean.ApiRequestData;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.y0;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class WebFragmentV2$addJsInterface$2$1 extends WebJavascriptInterface {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebFragmentV2 f58192a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebFragmentV2$addJsInterface$2$1(BridgeWebView bridgeWebView, WebFragmentV2 webFragmentV2) {
        super(bridgeWebView);
        this.f58192a = webFragmentV2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(WebFragmentV2 webFragmentV2) {
        BridgeWebView o02 = webFragmentV2.o0();
        if (o02 == null || !o02.canGoBack()) {
            return;
        }
        o02.goBack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        r0 = r1.mWebShareUtil;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void B(com.transsion.web.fragment.WebFragmentV2 r1, java.lang.String r2, java.lang.String r3) {
        /*
            androidx.fragment.app.FragmentActivity r0 = r1.getActivity()
            if (r0 == 0) goto L16
            com.transsion.web.share.k r0 = com.transsion.web.fragment.WebFragmentV2.h1(r1)
            if (r0 == 0) goto L16
            androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
            kotlin.jvm.internal.Intrinsics.e(r1)
            r0.h(r1, r2, r3)
        L16:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.web.fragment.WebFragmentV2$addJsInterface$2$1.B(com.transsion.web.fragment.WebFragmentV2, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(WebFragmentV2 webFragmentV2, String str, String str2) {
        com.transsion.web.share.k kVar;
        kVar = webFragmentV2.mWebShareUtil;
        if (kVar != null) {
            FragmentManager childFragmentManager = webFragmentV2.getChildFragmentManager();
            Intrinsics.g(childFragmentManager, "getChildFragmentManager(...)");
            kVar.k(str, str2, childFragmentManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(WebFragmentV2 webFragmentV2, final String str) {
        final BridgeWebView o02 = webFragmentV2.o0();
        if (o02 != null) {
            o02.post(new Runnable() { // from class: com.transsion.web.fragment.p
                @Override // java.lang.Runnable
                public final void run() {
                    WebFragmentV2$addJsInterface$2$1.E(BridgeWebView.this, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(BridgeWebView bridgeWebView, String str) {
        try {
            bridgeWebView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(WebFragmentV2 webFragmentV2) {
        webFragmentV2.h0().f64657f.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(String str) {
        com.tn.lib.widget.toast.core.h.f41533a.l(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(WebFragmentV2 webFragmentV2) {
        FragmentActivity activity = webFragmentV2.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(WebFragmentV2 webFragmentV2) {
        webFragmentV2.h0().f64657f.setVisibility(8);
    }

    @Override // com.transsion.web.api.WebJavascriptInterface
    @JavascriptInterface
    public void close(String str, String callbackId) {
        Intrinsics.h(callbackId, "callbackId");
        super.close(str, callbackId);
        FragmentActivity activity = this.f58192a.getActivity();
        if (activity != null) {
            final WebFragmentV2 webFragmentV2 = this.f58192a;
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.web.fragment.o
                @Override // java.lang.Runnable
                public final void run() {
                    WebFragmentV2$addJsInterface$2$1.y(WebFragmentV2.this);
                }
            });
        }
    }

    @Override // com.transsion.web.api.WebJavascriptInterface
    @JavascriptInterface
    public void closeLoading(String str, String callbackId) {
        Intrinsics.h(callbackId, "callbackId");
        super.closeLoading(str, callbackId);
        FragmentActivity activity = this.f58192a.getActivity();
        if (activity != null) {
            final WebFragmentV2 webFragmentV2 = this.f58192a;
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.web.fragment.j
                @Override // java.lang.Runnable
                public final void run() {
                    WebFragmentV2$addJsInterface$2$1.z(WebFragmentV2.this);
                }
            });
        }
    }

    @Override // com.transsion.web.api.WebJavascriptInterface
    @JavascriptInterface
    public void goBack(String str, String callbackId) {
        Intrinsics.h(callbackId, "callbackId");
        super.goBack(str, callbackId);
        FragmentActivity activity = this.f58192a.getActivity();
        if (activity != null) {
            final WebFragmentV2 webFragmentV2 = this.f58192a;
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.web.fragment.n
                @Override // java.lang.Runnable
                public final void run() {
                    WebFragmentV2$addJsInterface$2$1.A(WebFragmentV2.this);
                }
            });
        }
    }

    @Override // com.transsion.web.api.WebJavascriptInterface
    @JavascriptInterface
    public void h5ShareNative(final String data, final String callbackId) {
        Intrinsics.h(data, "data");
        Intrinsics.h(callbackId, "callbackId");
        super.h5ShareNative(data, callbackId);
        FragmentActivity activity = this.f58192a.getActivity();
        if (activity != null) {
            final WebFragmentV2 webFragmentV2 = this.f58192a;
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.web.fragment.k
                @Override // java.lang.Runnable
                public final void run() {
                    WebFragmentV2$addJsInterface$2$1.B(WebFragmentV2.this, data, callbackId);
                }
            });
        }
    }

    @Override // com.transsion.web.api.WebJavascriptInterface
    @JavascriptInterface
    public void nativeShare(final String data, final String callbackId) {
        Intrinsics.h(data, "data");
        Intrinsics.h(callbackId, "callbackId");
        super.nativeShare(data, callbackId);
        FragmentActivity activity = this.f58192a.getActivity();
        if (activity != null) {
            final WebFragmentV2 webFragmentV2 = this.f58192a;
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.web.fragment.l
                @Override // java.lang.Runnable
                public final void run() {
                    WebFragmentV2$addJsInterface$2$1.C(WebFragmentV2.this, data, callbackId);
                }
            });
        }
    }

    @Override // com.transsion.web.api.WebJavascriptInterface
    @JavascriptInterface
    public void openApp(final String data, String callbackId) {
        Intrinsics.h(data, "data");
        Intrinsics.h(callbackId, "callbackId");
        super.openApp(data, callbackId);
        FragmentActivity activity = this.f58192a.getActivity();
        if (activity != null) {
            final WebFragmentV2 webFragmentV2 = this.f58192a;
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.web.fragment.i
                @Override // java.lang.Runnable
                public final void run() {
                    WebFragmentV2$addJsInterface$2$1.D(WebFragmentV2.this, data);
                }
            });
        }
    }

    @Override // com.transsion.web.api.WebJavascriptInterface
    @JavascriptInterface
    public void openLoading(String str, String callbackId) {
        Intrinsics.h(callbackId, "callbackId");
        super.openLoading(str, callbackId);
        FragmentActivity activity = this.f58192a.getActivity();
        if (activity != null) {
            final WebFragmentV2 webFragmentV2 = this.f58192a;
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.web.fragment.h
                @Override // java.lang.Runnable
                public final void run() {
                    WebFragmentV2$addJsInterface$2$1.F(WebFragmentV2.this);
                }
            });
        }
    }

    @Override // com.transsion.web.api.WebJavascriptInterface
    @JavascriptInterface
    public void openToast(final String str, String callbackId) {
        FragmentActivity activity;
        Intrinsics.h(callbackId, "callbackId");
        super.openToast(str, callbackId);
        if (str == null || (activity = this.f58192a.getActivity()) == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.transsion.web.fragment.m
            @Override // java.lang.Runnable
            public final void run() {
                WebFragmentV2$addJsInterface$2$1.G(str);
            }
        });
    }

    @Override // com.transsion.web.api.WebJavascriptInterface
    @JavascriptInterface
    public void request(String str, String callbackId) {
        String api;
        String methods;
        Intrinsics.h(callbackId, "callbackId");
        super.request(str, callbackId);
        try {
            lg.a.f68962a.c(getTAG(), "request :" + str + ", callbackId:" + callbackId, true);
            ApiRequestData c11 = xx.a.f78579a.c(str);
            if (c11 != null && (api = c11.getApi()) != null && api.length() != 0 && (methods = c11.getMethods()) != null && methods.length() != 0) {
                String host = c11.getHost();
                if (host == null) {
                    host = vg.a.f77447a.a();
                }
                kotlinx.coroutines.k.d(v.a(this.f58192a), y0.b(), null, new WebFragmentV2$addJsInterface$2$1$request$1(c11, this.f58192a, host + c11.getApi(), this, callbackId, null), 2, null);
                return;
            }
            BridgeWebView o02 = this.f58192a.o0();
            if (o02 != null) {
                o02.sendResponse("", callbackId);
            }
        } catch (Throwable th2) {
            lg.a.f68962a.c(getTAG(), "requestm error :" + th2, true);
            BridgeWebView o03 = this.f58192a.o0();
            if (o03 != null) {
                o03.sendResponse("", callbackId);
            }
        }
    }

    @Override // com.transsion.web.api.WebJavascriptInterface
    @JavascriptInterface
    public void startPage(String str, String callbackId) {
        Intrinsics.h(callbackId, "callbackId");
        super.startPage(str, callbackId);
        try {
            lg.a.f68962a.c(getTAG(), "startPage :" + str, true);
            if (str == null) {
                str = "{}";
            }
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("pageName");
            JSONObject optJSONObject = jSONObject.optJSONObject("extra");
            Navigator c11 = TheRouter.c(optString);
            xx.a aVar = xx.a.f78579a;
            aVar.b(c11, aVar.a(optJSONObject));
            ak.k.p(c11);
        } catch (Exception unused) {
        }
    }
}
