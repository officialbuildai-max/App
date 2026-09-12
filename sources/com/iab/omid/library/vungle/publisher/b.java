package com.iab.omid.library.vungle.publisher;

import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.iab.omid.library.vungle.adsession.d;
import com.iab.omid.library.vungle.adsession.g;
import com.iab.omid.library.vungle.adsession.h;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import ue.c;
import ue.f;

/* loaded from: classes4.dex */
public class b extends AdSessionStatePublisher {

    /* renamed from: f, reason: collision with root package name */
    private WebView f33894f;

    /* renamed from: g, reason: collision with root package name */
    private Long f33895g;

    /* renamed from: h, reason: collision with root package name */
    private final Map f33896h;

    /* renamed from: i, reason: collision with root package name */
    private final String f33897i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Log.w("NativeBridge", "WebView renderer gone: " + renderProcessGoneDetail.toString() + "for WebView: " + webView);
            if (b.this.s() == webView) {
                Log.w("NativeBridge", "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
                b.this.c(null);
            }
            webView.destroy();
            return true;
        }
    }

    /* renamed from: com.iab.omid.library.vungle.publisher.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class RunnableC0464b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final WebView f33899a;

        RunnableC0464b() {
            this.f33899a = b.this.f33894f;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f33899a.destroy();
        }
    }

    public b(String str, Map map, String str2) {
        super(str);
        this.f33895g = null;
        this.f33896h = map;
        this.f33897i = str2;
    }

    @Override // com.iab.omid.library.vungle.publisher.AdSessionStatePublisher
    public void f(h hVar, d dVar) {
        JSONObject jSONObject = new JSONObject();
        Map f11 = dVar.f();
        for (String str : f11.keySet()) {
            c.i(jSONObject, str, ((g) f11.get(str)).e());
        }
        g(hVar, dVar, jSONObject);
    }

    @Override // com.iab.omid.library.vungle.publisher.AdSessionStatePublisher
    public void l() {
        super.l();
        new Handler().postDelayed(new RunnableC0464b(), Math.max(4000 - (this.f33895g == null ? 4000L : TimeUnit.MILLISECONDS.convert(f.b() - this.f33895g.longValue(), TimeUnit.NANOSECONDS)), 2000L));
        this.f33894f = null;
    }

    @Override // com.iab.omid.library.vungle.publisher.AdSessionStatePublisher
    public void u() {
        super.u();
        w();
    }

    void w() {
        WebView webView = new WebView(com.iab.omid.library.vungle.internal.g.c().a());
        this.f33894f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f33894f.getSettings().setAllowContentAccess(false);
        this.f33894f.getSettings().setAllowFileAccess(false);
        this.f33894f.setWebViewClient(new a());
        c(this.f33894f);
        com.iab.omid.library.vungle.internal.h.a().o(this.f33894f, this.f33897i);
        for (String str : this.f33896h.keySet()) {
            com.iab.omid.library.vungle.internal.h.a().p(this.f33894f, ((g) this.f33896h.get(str)).b().toExternalForm(), str);
        }
        this.f33895g = Long.valueOf(f.b());
    }
}
