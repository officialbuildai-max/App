package com.mbridge.msdk.foundation.entity;

import android.text.TextUtils;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private String f35228a;

    /* renamed from: b, reason: collision with root package name */
    private String f35229b;

    /* renamed from: c, reason: collision with root package name */
    private String f35230c;

    /* renamed from: d, reason: collision with root package name */
    private int f35231d;

    /* renamed from: e, reason: collision with root package name */
    private int f35232e;

    /* renamed from: f, reason: collision with root package name */
    private String f35233f;

    /* renamed from: g, reason: collision with root package name */
    private String f35234g;

    /* renamed from: h, reason: collision with root package name */
    private String f35235h;

    /* renamed from: i, reason: collision with root package name */
    private int f35236i;

    /* renamed from: j, reason: collision with root package name */
    private String f35237j;

    /* renamed from: k, reason: collision with root package name */
    private int f35238k;

    /* renamed from: l, reason: collision with root package name */
    private String f35239l;

    /* renamed from: m, reason: collision with root package name */
    private int f35240m;

    /* renamed from: n, reason: collision with root package name */
    private String f35241n;

    /* renamed from: o, reason: collision with root package name */
    private String f35242o;

    /* renamed from: p, reason: collision with root package name */
    private int f35243p;

    /* renamed from: q, reason: collision with root package name */
    private String f35244q;

    public static ArrayList<JSONObject> a(List<e> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList<JSONObject> arrayList = new ArrayList<>();
        for (e eVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("rid", eVar.n());
                jSONObject.put("rid_n", eVar.o());
                jSONObject.put(BidResponsedEx.KEY_CID, eVar.a());
                jSONObject.put("click_type", eVar.c());
                jSONObject.put(NativeComponentConstants.KEY_COMPONENT_TYPE, eVar.p());
                jSONObject.put("click_duration", eVar.d());
                jSONObject.put("key", "2000013");
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, eVar.q());
                jSONObject.put("last_url", eVar.j());
                jSONObject.put("content", eVar.f());
                jSONObject.put("code", eVar.e());
                jSONObject.put("exception", eVar.g());
                jSONObject.put("header", eVar.h());
                jSONObject.put(CampaignEx.JSON_KEY_LANDING_TYPE, eVar.i());
                jSONObject.put(CampaignEx.JSON_KEY_LINK_TYPE, eVar.k());
                jSONObject.put(TrackingKey.CLICK_TIME, eVar.b());
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    jSONObject.put("network_type", eVar.m());
                    jSONObject.put("network_str", eVar.l());
                }
                String q11 = eVar.q();
                if (!TextUtils.isEmpty(q11)) {
                    String str = com.mbridge.msdk.foundation.controller.a.f35048r.get(q11);
                    if (str == null) {
                        str = "";
                    }
                    jSONObject.put("u_stid", str);
                }
                arrayList.add(jSONObject);
            } catch (Throwable th2) {
                o0.b("ClickTime", th2.getMessage());
            }
        }
        return arrayList;
    }

    public static JSONObject a(e eVar) {
        if (eVar == null) {
            return null;
        }
        String j11 = eVar.j();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rid", eVar.n());
            jSONObject.put("rid_n", eVar.o());
            jSONObject.put("click_type", eVar.c());
            jSONObject.put(NativeComponentConstants.KEY_COMPONENT_TYPE, eVar.p());
            jSONObject.put(BidResponsedEx.KEY_CID, eVar.a());
            jSONObject.put("click_duration", eVar.d());
            jSONObject.put("key", "2000012");
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, eVar.q());
            jSONObject.put("last_url", j11);
            jSONObject.put("code", eVar.e());
            jSONObject.put("exception", eVar.g());
            jSONObject.put(CampaignEx.JSON_KEY_LANDING_TYPE, eVar.i());
            jSONObject.put(CampaignEx.JSON_KEY_LINK_TYPE, eVar.k());
            jSONObject.put(TrackingKey.CLICK_TIME, eVar.b());
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("network_type", eVar.m());
                jSONObject.put("network_str", eVar.l());
            }
            return jSONObject;
        } catch (Throwable th2) {
            o0.b("ClickTime", th2.getMessage());
            return null;
        }
    }

    public String a() {
        return this.f35228a;
    }

    public void a(int i11) {
        this.f35231d = i11;
    }

    public void a(String str) {
        this.f35228a = str;
    }

    public String b() {
        return this.f35230c;
    }

    public void b(int i11) {
        this.f35232e = i11;
    }

    public void b(String str) {
        this.f35230c = str;
    }

    public int c() {
        return this.f35231d;
    }

    public void c(int i11) {
        this.f35236i = i11;
    }

    public void c(String str) {
        this.f35229b = str;
    }

    public String d() {
        return this.f35229b;
    }

    public void d(int i11) {
        this.f35238k = i11;
    }

    public void d(String str) {
        this.f35233f = str;
    }

    public int e() {
        return this.f35232e;
    }

    public void e(int i11) {
        this.f35240m = i11;
    }

    public void e(String str) {
        this.f35234g = str;
    }

    public String f() {
        return this.f35233f;
    }

    public void f(int i11) {
        this.f35243p = i11;
    }

    public void f(String str) {
        this.f35235h = str;
    }

    public String g() {
        return this.f35234g;
    }

    public void g(String str) {
        this.f35237j = str;
    }

    public String h() {
        return this.f35235h;
    }

    public void h(String str) {
        this.f35239l = str;
    }

    public int i() {
        return this.f35236i;
    }

    public void i(String str) {
        this.f35241n = str;
    }

    public String j() {
        return this.f35237j;
    }

    public void j(String str) {
        this.f35242o = str;
    }

    public int k() {
        return this.f35238k;
    }

    public void k(String str) {
        this.f35244q = str;
    }

    public String l() {
        return this.f35239l;
    }

    public int m() {
        return this.f35240m;
    }

    public String n() {
        return this.f35241n;
    }

    public String o() {
        return this.f35242o;
    }

    public int p() {
        return this.f35243p;
    }

    public String q() {
        return this.f35244q;
    }

    public String toString() {
        return "ClickTime [campaignId=" + this.f35228a + ", click_duration=" + this.f35229b + ", lastUrl=" + this.f35237j + ", code=" + this.f35232e + ", excepiton=" + this.f35234g + ", header=" + this.f35235h + ", content=" + this.f35233f + ", type=" + this.f35243p + ", click_type=" + this.f35231d + "]";
    }
}
