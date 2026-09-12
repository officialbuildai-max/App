package com.iab.omid.library.vungle.publisher;

import android.webkit.WebView;
import com.iab.omid.library.vungle.adsession.c;
import com.iab.omid.library.vungle.adsession.d;
import com.iab.omid.library.vungle.internal.g;
import com.iab.omid.library.vungle.internal.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
import ue.f;

/* loaded from: classes4.dex */
public abstract class AdSessionStatePublisher {

    /* renamed from: a, reason: collision with root package name */
    private String f33885a;

    /* renamed from: b, reason: collision with root package name */
    private we.b f33886b;

    /* renamed from: c, reason: collision with root package name */
    private com.iab.omid.library.vungle.adsession.a f33887c;

    /* renamed from: d, reason: collision with root package name */
    private a f33888d;

    /* renamed from: e, reason: collision with root package name */
    private long f33889e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher(String str) {
        a();
        this.f33885a = str;
        this.f33886b = new we.b(null);
    }

    public void a() {
        this.f33889e = f.b();
        this.f33888d = a.AD_STATE_IDLE;
    }

    public void b(float f11) {
        h.a().c(s(), this.f33885a, f11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(WebView webView) {
        this.f33886b = new we.b(webView);
    }

    public void d(com.iab.omid.library.vungle.adsession.a aVar) {
        this.f33887c = aVar;
    }

    public void e(c cVar) {
        h.a().e(s(), this.f33885a, cVar.c());
    }

    public void f(com.iab.omid.library.vungle.adsession.h hVar, d dVar) {
        g(hVar, dVar, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(com.iab.omid.library.vungle.adsession.h hVar, d dVar, JSONObject jSONObject) {
        String j11 = hVar.j();
        JSONObject jSONObject2 = new JSONObject();
        ue.c.i(jSONObject2, "environment", "app");
        ue.c.i(jSONObject2, "adSessionType", dVar.c());
        ue.c.i(jSONObject2, "deviceInfo", ue.b.d());
        ue.c.i(jSONObject2, "deviceCategory", ue.a.a().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        ue.c.i(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        ue.c.i(jSONObject3, "partnerName", dVar.h().b());
        ue.c.i(jSONObject3, "partnerVersion", dVar.h().c());
        ue.c.i(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        ue.c.i(jSONObject4, "libraryVersion", "1.5.3-Vungle");
        ue.c.i(jSONObject4, "appId", g.c().a().getApplicationContext().getPackageName());
        ue.c.i(jSONObject2, "app", jSONObject4);
        if (dVar.d() != null) {
            ue.c.i(jSONObject2, "contentUrl", dVar.d());
        }
        if (dVar.e() != null) {
            ue.c.i(jSONObject2, "customReferenceData", dVar.e());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (com.iab.omid.library.vungle.adsession.g gVar : dVar.i()) {
            ue.c.i(jSONObject5, gVar.c(), gVar.d());
        }
        h.a().f(s(), j11, jSONObject2, jSONObject5, jSONObject);
    }

    public void h(String str, long j11) {
        if (j11 >= this.f33889e) {
            a aVar = this.f33888d;
            a aVar2 = a.AD_STATE_NOTVISIBLE;
            if (aVar != aVar2) {
                this.f33888d = aVar2;
                h.a().l(s(), this.f33885a, str);
            }
        }
    }

    public void i(Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        ue.c.i(jSONObject, CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(date.getTime()));
        h.a().i(s(), jSONObject);
    }

    public void j(JSONObject jSONObject) {
        h.a().m(s(), this.f33885a, jSONObject);
    }

    public void k(boolean z10) {
        if (p()) {
            h.a().n(s(), this.f33885a, z10 ? "foregrounded" : "backgrounded");
        }
    }

    public void l() {
        this.f33886b.clear();
    }

    public void m(String str, long j11) {
        if (j11 >= this.f33889e) {
            this.f33888d = a.AD_STATE_VISIBLE;
            h.a().l(s(), this.f33885a, str);
        }
    }

    public void n(boolean z10) {
        if (p()) {
            h.a().d(s(), this.f33885a, z10 ? "locked" : "unlocked");
        }
    }

    public com.iab.omid.library.vungle.adsession.a o() {
        return this.f33887c;
    }

    public boolean p() {
        return this.f33886b.get() != 0;
    }

    public void q() {
        h.a().b(s(), this.f33885a);
    }

    public void r() {
        h.a().k(s(), this.f33885a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WebView s() {
        return (WebView) this.f33886b.get();
    }

    public void t() {
        j(null);
    }

    public void u() {
    }
}
