package com.mbridge.msdk.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.c1;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.s0;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.foundation.webview.b;

/* loaded from: classes4.dex */
public class DomainMBCommonActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    String f34079a = "";

    /* renamed from: b, reason: collision with root package name */
    private final BrowserView.e f34080b = new a();
    protected BrowserView browserView;

    /* renamed from: c, reason: collision with root package name */
    private CampaignEx f34081c;

    /* loaded from: classes4.dex */
    class a implements BrowserView.e {
        a() {
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
        public void a() {
            DomainMBCommonActivity.this.finish();
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
        public void a(WebView webView, int i11, String str, String str2) {
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
        public void a(WebView webView, String str) {
            o0.b("MBCommonActivity", "onPageFinished  " + str);
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
        public void a(WebView webView, String str, Bitmap bitmap) {
            o0.b("MBCommonActivity", "onPageStarted  " + str);
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
        public boolean b(WebView webView, String str) {
            o0.b("MBCommonActivity", "shouldOverrideUrlLoading  " + str);
            if (s0.a.b(str) && s0.a.a(DomainMBCommonActivity.this, str, null)) {
                DomainMBCommonActivity.this.finish();
            }
            return DomainMBCommonActivity.this.a(webView, str);
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
        public void c(WebView webView, String str) {
        }
    }

    private void a() {
        String stringExtra = getIntent().getStringExtra("url");
        this.f34079a = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            Toast.makeText(this, "Error: no data", 0).show();
            return;
        }
        this.f34081c = (CampaignEx) getIntent().getSerializableExtra("mvcommon");
        if (b.f35949a.containsKey(this.f34079a)) {
            BrowserView browserView = b.f35949a.get(this.f34079a);
            this.browserView = browserView;
            if (browserView != null) {
                browserView.setListener(this.f34080b);
            }
        } else {
            BrowserView browserView2 = new BrowserView(this, this.f34081c);
            this.browserView = browserView2;
            browserView2.setListener(this.f34080b);
            this.browserView.loadUrl(this.f34079a);
        }
        BrowserView browserView3 = this.browserView;
        if (browserView3 != null) {
            c1.a(browserView3);
            setContentView(this.browserView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00db A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:3:0x0009, B:7:0x0010, B:9:0x001e, B:12:0x002a, B:15:0x0037, B:18:0x00d5, B:20:0x00db, B:22:0x00e4, B:24:0x00ea, B:26:0x00f0, B:31:0x0045, B:33:0x0050, B:35:0x0068, B:64:0x00ce, B:49:0x0097, B:69:0x0055, B:71:0x005f, B:38:0x0079, B:40:0x007f, B:43:0x008b, B:44:0x0090, B:68:0x0075, B:66:0x00a0, B:51:0x00a9, B:53:0x00af, B:55:0x00bd, B:59:0x00ca), top: B:2:0x0009, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e4 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:3:0x0009, B:7:0x0010, B:9:0x001e, B:12:0x002a, B:15:0x0037, B:18:0x00d5, B:20:0x00db, B:22:0x00e4, B:24:0x00ea, B:26:0x00f0, B:31:0x0045, B:33:0x0050, B:35:0x0068, B:64:0x00ce, B:49:0x0097, B:69:0x0055, B:71:0x005f, B:38:0x0079, B:40:0x007f, B:43:0x008b, B:44:0x0090, B:68:0x0075, B:66:0x00a0, B:51:0x00a9, B:53:0x00af, B:55:0x00bd, B:59:0x00ca), top: B:2:0x0009, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(android.webkit.WebView r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.activity.DomainMBCommonActivity.a(android.webkit.WebView, java.lang.String):boolean");
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
        } catch (Throwable th2) {
            o0.b("MBCommonActivity", th2.getMessage());
        }
        if (c.m().d() == null) {
            c.m().b(getApplicationContext());
        }
        c.m().a(this);
        a();
    }
}
