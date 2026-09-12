package com.iab.omid.library.hisavana.publisher;

import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.iab.omid.library.hisavana.adsession.d;
import com.iab.omid.library.hisavana.adsession.g;
import com.iab.omid.library.hisavana.adsession.h;
import ie.c;
import ie.f;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b extends AdSessionStatePublisher {

    /* renamed from: f, reason: collision with root package name */
    private WebView f33664f;

    /* renamed from: g, reason: collision with root package name */
    private Long f33665g;

    /* renamed from: h, reason: collision with root package name */
    private final Map f33666h;

    /* renamed from: i, reason: collision with root package name */
    private final String f33667i;

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

    /* renamed from: com.iab.omid.library.hisavana.publisher.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class RunnableC0460b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final WebView f33669a;

        RunnableC0460b() {
            this.f33669a = b.this.f33664f;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f33669a.destroy();
        }
    }

    public b(String str, Map map, String str2) {
        super(str);
        this.f33665g = null;
        this.f33666h = map;
        this.f33667i = str2;
    }

    @Override // com.iab.omid.library.hisavana.publisher.AdSessionStatePublisher
    public void f(h hVar, d dVar) {
        JSONObject jSONObject = new JSONObject();
        Map e11 = dVar.e();
        for (String str : e11.keySet()) {
            c.i(jSONObject, str, ((g) e11.get(str)).f());
        }
        g(hVar, dVar, jSONObject);
    }

    @Override // com.iab.omid.library.hisavana.publisher.AdSessionStatePublisher
    public void l() {
        super.l();
        new Handler().postDelayed(new RunnableC0460b(), Math.max(4000 - (this.f33665g == null ? 4000L : TimeUnit.MILLISECONDS.convert(f.b() - this.f33665g.longValue(), TimeUnit.NANOSECONDS)), 2000L));
        this.f33664f = null;
    }

    @Override // com.iab.omid.library.hisavana.publisher.AdSessionStatePublisher
    public void u() {
        super.u();
        w();
    }

    void w() {
        WebView webView = new WebView(com.iab.omid.library.hisavana.internal.g.c().a());
        this.f33664f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f33664f.getSettings().setAllowContentAccess(false);
        this.f33664f.getSettings().setAllowFileAccess(false);
        this.f33664f.setWebViewClient(new a());
        c(this.f33664f);
        com.iab.omid.library.hisavana.internal.h.a().o(this.f33664f, this.f33667i);
        for (String str : this.f33666h.keySet()) {
            com.iab.omid.library.hisavana.internal.h.a().p(this.f33664f, ((g) this.f33666h.get(str)).c().toExternalForm(), str);
        }
        this.f33665g = Long.valueOf(f.b());
    }
}
