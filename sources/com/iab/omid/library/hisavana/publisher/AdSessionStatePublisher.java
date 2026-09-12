package com.iab.omid.library.hisavana.publisher;

import android.webkit.WebView;
import com.iab.omid.library.hisavana.adsession.c;
import com.iab.omid.library.hisavana.adsession.d;
import com.iab.omid.library.hisavana.internal.g;
import com.iab.omid.library.hisavana.internal.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import ie.f;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class AdSessionStatePublisher {

    /* renamed from: a, reason: collision with root package name */
    private String f33655a;

    /* renamed from: b, reason: collision with root package name */
    private ke.b f33656b;

    /* renamed from: c, reason: collision with root package name */
    private com.iab.omid.library.hisavana.adsession.a f33657c;

    /* renamed from: d, reason: collision with root package name */
    private a f33658d;

    /* renamed from: e, reason: collision with root package name */
    private long f33659e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher(String str) {
        a();
        this.f33655a = str;
        this.f33656b = new ke.b(null);
    }

    public void a() {
        this.f33659e = f.b();
        this.f33658d = a.AD_STATE_IDLE;
    }

    public void b(float f11) {
        h.a().c(s(), this.f33655a, f11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(WebView webView) {
        this.f33656b = new ke.b(webView);
    }

    public void d(com.iab.omid.library.hisavana.adsession.a aVar) {
        this.f33657c = aVar;
    }

    public void e(c cVar) {
        h.a().e(s(), this.f33655a, cVar.c());
    }

    public void f(com.iab.omid.library.hisavana.adsession.h hVar, d dVar) {
        g(hVar, dVar, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(com.iab.omid.library.hisavana.adsession.h hVar, d dVar, JSONObject jSONObject) {
        String k11 = hVar.k();
        JSONObject jSONObject2 = new JSONObject();
        ie.c.i(jSONObject2, "environment", "app");
        ie.c.i(jSONObject2, "adSessionType", dVar.b());
        ie.c.i(jSONObject2, "deviceInfo", ie.b.d());
        ie.c.i(jSONObject2, "deviceCategory", ie.a.a().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        ie.c.i(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        ie.c.i(jSONObject3, "partnerName", dVar.g().b());
        ie.c.i(jSONObject3, "partnerVersion", dVar.g().c());
        ie.c.i(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        ie.c.i(jSONObject4, "libraryVersion", "1.5.4-Hisavana");
        ie.c.i(jSONObject4, "appId", g.c().a().getApplicationContext().getPackageName());
        ie.c.i(jSONObject2, "app", jSONObject4);
        if (dVar.c() != null) {
            ie.c.i(jSONObject2, "contentUrl", dVar.c());
        }
        if (dVar.d() != null) {
            ie.c.i(jSONObject2, "customReferenceData", dVar.d());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (com.iab.omid.library.hisavana.adsession.g gVar : dVar.h()) {
            ie.c.i(jSONObject5, gVar.d(), gVar.e());
        }
        h.a().f(s(), k11, jSONObject2, jSONObject5, jSONObject);
    }

    public void h(String str, long j11) {
        if (j11 >= this.f33659e) {
            a aVar = this.f33658d;
            a aVar2 = a.AD_STATE_NOTVISIBLE;
            if (aVar != aVar2) {
                this.f33658d = aVar2;
                h.a().l(s(), this.f33655a, str);
            }
        }
    }

    public void i(Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        ie.c.i(jSONObject, CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(date.getTime()));
        h.a().i(s(), jSONObject);
    }

    public void j(JSONObject jSONObject) {
        h.a().m(s(), this.f33655a, jSONObject);
    }

    public void k(boolean z10) {
        if (p()) {
            h.a().n(s(), this.f33655a, z10 ? "foregrounded" : "backgrounded");
        }
    }

    public void l() {
        this.f33656b.clear();
    }

    public void m(String str, long j11) {
        if (j11 >= this.f33659e) {
            this.f33658d = a.AD_STATE_VISIBLE;
            h.a().l(s(), this.f33655a, str);
        }
    }

    public void n(boolean z10) {
        if (p()) {
            h.a().d(s(), this.f33655a, z10 ? "locked" : "unlocked");
        }
    }

    public com.iab.omid.library.hisavana.adsession.a o() {
        return this.f33657c;
    }

    public boolean p() {
        return this.f33656b.get() != 0;
    }

    public void q() {
        h.a().b(s(), this.f33655a);
    }

    public void r() {
        h.a().k(s(), this.f33655a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WebView s() {
        return (WebView) this.f33656b.get();
    }

    public void t() {
        j(null);
    }

    public void u() {
    }
}
