package com.transsion.ad.web;

import android.webkit.JavascriptInterface;
import androidx.core.app.NotificationCompat;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class e extends BridgeWebView.BaseJavascriptInterface {

    /* renamed from: c, reason: collision with root package name */
    public static final a f42515c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final BridgeWebView f42516a;

    /* renamed from: b, reason: collision with root package name */
    private d f42517b;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements com.transsion.ad.web.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f42519b;

        b(String str) {
            this.f42519b = str;
        }

        @Override // com.transsion.ad.web.b
        public void onAdStateCallback(String stateEnum, String str) {
            Intrinsics.h(stateEnum, "stateEnum");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", stateEnum);
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
            e.this.f42516a.sendResponse(jSONObject.toString(), this.f42519b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(BridgeWebView customWebView) {
        super(customWebView.getCallbacks());
        Intrinsics.h(customWebView, "customWebView");
        this.f42516a = customWebView;
    }

    public final void b(d dVar) {
        this.f42517b = dVar;
    }

    @JavascriptInterface
    public void onAdClick() {
        d dVar = this.f42517b;
        if (dVar != null) {
            dVar.h();
        }
    }

    @JavascriptInterface
    public void onAdError() {
        d dVar = this.f42517b;
        if (dVar != null) {
            dVar.n();
        }
    }

    @JavascriptInterface
    public void onAdShown(String data) {
        Intrinsics.h(data, "data");
        d dVar = this.f42517b;
        if (dVar != null) {
            dVar.f();
        }
    }

    @JavascriptInterface
    public void openMbAd(String str, String callbackId) {
        Intrinsics.h(callbackId, "callbackId");
        c.f42511a.a(str, new b(callbackId));
    }

    @Override // com.github.lzyzsd.jsbridge.BridgeWebView.BaseJavascriptInterface
    public String send(String str) {
        return "send";
    }
}
