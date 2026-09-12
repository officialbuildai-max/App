package com.iab.omid.library.mmadbridge.publisher;

import android.webkit.WebView;
import com.iab.omid.library.mmadbridge.adsession.c;
import com.iab.omid.library.mmadbridge.adsession.d;
import com.iab.omid.library.mmadbridge.internal.g;
import com.iab.omid.library.mmadbridge.internal.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Date;
import oe.f;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class AdSessionStatePublisher {

    /* renamed from: a, reason: collision with root package name */
    private String f33774a;

    /* renamed from: b, reason: collision with root package name */
    private qe.b f33775b;

    /* renamed from: c, reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.adsession.a f33776c;

    /* renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.adsession.media.a f33777d;

    /* renamed from: e, reason: collision with root package name */
    private a f33778e;

    /* renamed from: f, reason: collision with root package name */
    private long f33779f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher(String str) {
        a();
        this.f33774a = str;
        this.f33775b = new qe.b(null);
    }

    public void a() {
        this.f33779f = f.b();
        this.f33778e = a.AD_STATE_IDLE;
    }

    public void b(float f11) {
        h.a().c(w(), this.f33774a, f11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(WebView webView) {
        this.f33775b = new qe.b(webView);
    }

    public void d(com.iab.omid.library.mmadbridge.adsession.a aVar) {
        this.f33776c = aVar;
    }

    public void e(c cVar) {
        h.a().f(w(), this.f33774a, cVar.d());
    }

    public void f(com.iab.omid.library.mmadbridge.adsession.h hVar, d dVar) {
        g(hVar, dVar, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(com.iab.omid.library.mmadbridge.adsession.h hVar, d dVar, JSONObject jSONObject) {
        String s11 = hVar.s();
        JSONObject jSONObject2 = new JSONObject();
        oe.c.i(jSONObject2, "environment", "app");
        oe.c.i(jSONObject2, "adSessionType", dVar.c());
        oe.c.i(jSONObject2, "deviceInfo", oe.b.d());
        oe.c.i(jSONObject2, "deviceCategory", oe.a.a().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        oe.c.i(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        oe.c.i(jSONObject3, "partnerName", dVar.h().b());
        oe.c.i(jSONObject3, "partnerVersion", dVar.h().c());
        oe.c.i(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        oe.c.i(jSONObject4, "libraryVersion", "1.4.13-Mmadbridge");
        oe.c.i(jSONObject4, "appId", g.c().a().getApplicationContext().getPackageName());
        oe.c.i(jSONObject2, "app", jSONObject4);
        if (dVar.d() != null) {
            oe.c.i(jSONObject2, "contentUrl", dVar.d());
        }
        if (dVar.e() != null) {
            oe.c.i(jSONObject2, "customReferenceData", dVar.e());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (com.iab.omid.library.mmadbridge.adsession.g gVar : dVar.i()) {
            oe.c.i(jSONObject5, gVar.d(), gVar.e());
        }
        h.a().g(w(), s11, jSONObject2, jSONObject5, jSONObject);
    }

    public void h(com.iab.omid.library.mmadbridge.adsession.media.a aVar) {
        this.f33777d = aVar;
    }

    public void i(String str) {
        k(str, null);
    }

    public void j(String str, long j11) {
        if (j11 >= this.f33779f) {
            a aVar = this.f33778e;
            a aVar2 = a.AD_STATE_NOTVISIBLE;
            if (aVar != aVar2) {
                this.f33778e = aVar2;
                h.a().m(w(), this.f33774a, str);
            }
        }
    }

    public void k(String str, JSONObject jSONObject) {
        h.a().e(w(), this.f33774a, str, jSONObject);
    }

    public void l(Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        oe.c.i(jSONObject, CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(date.getTime()));
        h.a().j(w(), jSONObject);
    }

    public void m(JSONObject jSONObject) {
        h.a().n(w(), this.f33774a, jSONObject);
    }

    public void n(boolean z10) {
        if (t()) {
            h.a().o(w(), this.f33774a, z10 ? "foregrounded" : "backgrounded");
        }
    }

    public void o() {
        this.f33775b.clear();
    }

    public void p(String str, long j11) {
        if (j11 >= this.f33779f) {
            this.f33778e = a.AD_STATE_VISIBLE;
            h.a().m(w(), this.f33774a, str);
        }
    }

    public void q(boolean z10) {
        if (t()) {
            h.a().d(w(), this.f33774a, z10 ? "locked" : "unlocked");
        }
    }

    public com.iab.omid.library.mmadbridge.adsession.a r() {
        return this.f33776c;
    }

    public com.iab.omid.library.mmadbridge.adsession.media.a s() {
        return this.f33777d;
    }

    public boolean t() {
        return this.f33775b.get() != 0;
    }

    public void u() {
        h.a().b(w(), this.f33774a);
    }

    public void v() {
        h.a().l(w(), this.f33774a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WebView w() {
        return (WebView) this.f33775b.get();
    }

    public void x() {
        m(null);
    }

    public void y() {
    }
}
