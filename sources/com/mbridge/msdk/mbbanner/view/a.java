package com.mbridge.msdk.mbbanner.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.base.BaseWebView;
import com.mbridge.msdk.mbsignalcommon.base.b;
import java.util.List;

/* loaded from: classes5.dex */
public class a extends b {

    /* renamed from: c, reason: collision with root package name */
    private final String f36246c = "BannerWebViewClient";

    /* renamed from: d, reason: collision with root package name */
    String f36247d;

    /* renamed from: e, reason: collision with root package name */
    List<CampaignEx> f36248e;

    /* renamed from: f, reason: collision with root package name */
    com.mbridge.msdk.mbbanner.common.listener.a f36249f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.mbbanner.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0507a implements ValueCallback<String> {
        C0507a() {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
        }
    }

    public a(String str, List<CampaignEx> list, com.mbridge.msdk.mbbanner.common.listener.a aVar) {
        this.f36247d = str;
        this.f36248e = list;
        this.f36249f = aVar;
    }

    private void a(WebView webView, String str) {
        webView.evaluateJavascript(str, new C0507a());
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        CampaignEx campaignEx;
        super.onPageStarted(webView, str, bitmap);
        try {
            a(webView, "javascript:" + com.mbridge.msdk.setting.util.a.a().b());
            List<CampaignEx> list = this.f36248e;
            if (list == null || list.isEmpty() || (campaignEx = this.f36248e.get(0)) == null || !campaignEx.isActiveOm()) {
                return;
            }
            a(webView, "javascript:" + MBridgeConstans.OMID_JS_SERVICE_CONTENT);
        } catch (Throwable th2) {
            o0.b("BannerWebViewClient", "onPageStarted", th2);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            o0.b("BannerWebViewClient", "Use html to open url.");
            BaseWebView baseWebView = (BaseWebView) webView;
            if (System.currentTimeMillis() - baseWebView.lastTouchTime > com.mbridge.msdk.click.utils.a.f34500c && com.mbridge.msdk.click.utils.a.a(this.f36248e.get(0), baseWebView.getUrl(), com.mbridge.msdk.click.utils.a.f34499b)) {
                return false;
            }
            if (this.f36248e.size() > 1) {
                c.m().d().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                str = null;
            }
            com.mbridge.msdk.mbbanner.common.listener.a aVar = this.f36249f;
            if (aVar != null) {
                aVar.a(false, str);
            }
            return true;
        } catch (Throwable th2) {
            o0.b("BannerWebViewClient", "shouldOverrideUrlLoading", th2);
            return false;
        }
    }
}
