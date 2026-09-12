package com.iab.omid.library.mmadbridge.publisher;

import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.iab.omid.library.mmadbridge.adsession.d;
import com.iab.omid.library.mmadbridge.internal.g;
import com.iab.omid.library.mmadbridge.internal.h;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import oe.c;
import oe.f;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b extends AdSessionStatePublisher {

    /* renamed from: g, reason: collision with root package name */
    private WebView f33784g;

    /* renamed from: h, reason: collision with root package name */
    private Long f33785h;

    /* renamed from: i, reason: collision with root package name */
    private final Map f33786i;

    /* renamed from: j, reason: collision with root package name */
    private final String f33787j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Log.w("NativeBridge", "WebView renderer gone: " + renderProcessGoneDetail.toString() + "for WebView: " + webView);
            if (b.this.w() == webView) {
                Log.w("NativeBridge", "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
                b.this.c(null);
            }
            webView.destroy();
            return true;
        }
    }

    /* renamed from: com.iab.omid.library.mmadbridge.publisher.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class RunnableC0462b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final WebView f33789a;

        RunnableC0462b() {
            this.f33789a = b.this.f33784g;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f33789a.destroy();
        }
    }

    public b(String str, Map map, String str2) {
        super(str);
        this.f33785h = null;
        this.f33786i = map;
        this.f33787j = str2;
    }

    void A() {
        WebView webView = new WebView(g.c().a());
        this.f33784g = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f33784g.getSettings().setAllowContentAccess(false);
        this.f33784g.getSettings().setAllowFileAccess(false);
        this.f33784g.setWebViewClient(new a());
        c(this.f33784g);
        h.a().p(this.f33784g, this.f33787j);
        for (String str : this.f33786i.keySet()) {
            h.a().q(this.f33784g, ((com.iab.omid.library.mmadbridge.adsession.g) this.f33786i.get(str)).c().toExternalForm(), str);
        }
        this.f33785h = Long.valueOf(f.b());
    }

    @Override // com.iab.omid.library.mmadbridge.publisher.AdSessionStatePublisher
    public void f(com.iab.omid.library.mmadbridge.adsession.h hVar, d dVar) {
        JSONObject jSONObject = new JSONObject();
        Map f11 = dVar.f();
        for (String str : f11.keySet()) {
            c.i(jSONObject, str, ((com.iab.omid.library.mmadbridge.adsession.g) f11.get(str)).f());
        }
        g(hVar, dVar, jSONObject);
    }

    @Override // com.iab.omid.library.mmadbridge.publisher.AdSessionStatePublisher
    public void o() {
        super.o();
        new Handler().postDelayed(new RunnableC0462b(), Math.max(4000 - (this.f33785h == null ? 4000L : TimeUnit.MILLISECONDS.convert(f.b() - this.f33785h.longValue(), TimeUnit.NANOSECONDS)), 2000L));
        this.f33784g = null;
    }

    @Override // com.iab.omid.library.mmadbridge.publisher.AdSessionStatePublisher
    public void y() {
        super.y();
        A();
    }
}
