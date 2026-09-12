package com.mbridge.msdk.foundation.same.report.campaignreport;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.tmc.integration.event.EventConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.h;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.tracker.e;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected Context f35576a;

    /* renamed from: b, reason: collision with root package name */
    protected h f35577b;

    public a(h hVar) {
        this.f35577b = hVar;
        Context d11 = c.m().d();
        this.f35576a = d11;
        if (this.f35577b == null || d11 == null) {
            return;
        }
        int s11 = k0.s(d11);
        this.f35577b.c(s11);
        this.f35577b.a(k0.a(this.f35576a, s11));
    }

    public void a() {
        if (this.f35577b != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(EventConstants.KEY_TIME, this.f35577b.f());
                jSONObject.put(CampaignEx.JSON_KEY_HB, this.f35577b.i());
                jSONObject.put("fb", this.f35577b.b());
                jSONObject.put("num", this.f35577b.e());
                jSONObject.put(CampaignEx.JSON_KEY_AD_SOURCE_ID, this.f35577b.a());
                jSONObject.put("timeout", this.f35577b.g());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.f35577b.h());
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    jSONObject.put("network_type", this.f35577b.d());
                    jSONObject.put("network_str", this.f35577b.c());
                }
                e eVar = new e("2000006");
                eVar.a(0);
                eVar.b(0);
                eVar.a(jSONObject);
                eVar.a(com.mbridge.msdk.foundation.same.report.c.d());
                d.b().d().d(eVar);
            } catch (Throwable unused) {
            }
        }
    }

    public void a(int i11) {
        h hVar = this.f35577b;
        if (hVar != null) {
            hVar.d(i11);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f35577b.b(str);
    }

    public void b(int i11) {
        h hVar = this.f35577b;
        if (hVar != null) {
            hVar.a(i11);
        }
    }

    public void b(String str) {
        h hVar = this.f35577b;
        if (hVar != null) {
            hVar.c(str);
        }
    }

    public void c(int i11) {
        h hVar = this.f35577b;
        if (hVar != null) {
            hVar.b(i11);
        }
    }
}
