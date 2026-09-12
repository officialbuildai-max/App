package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public int f35753a;

    /* renamed from: b, reason: collision with root package name */
    public int f35754b;

    /* renamed from: c, reason: collision with root package name */
    public String f35755c;

    /* renamed from: d, reason: collision with root package name */
    public String f35756d;

    /* renamed from: e, reason: collision with root package name */
    public String f35757e;

    /* renamed from: f, reason: collision with root package name */
    public String f35758f;

    /* renamed from: g, reason: collision with root package name */
    public String f35759g;

    /* renamed from: h, reason: collision with root package name */
    public String f35760h;

    /* renamed from: j, reason: collision with root package name */
    public String f35762j;

    /* renamed from: k, reason: collision with root package name */
    public String f35763k;

    /* renamed from: m, reason: collision with root package name */
    public int f35765m;

    /* renamed from: n, reason: collision with root package name */
    public String f35766n;

    /* renamed from: o, reason: collision with root package name */
    public String f35767o;

    /* renamed from: p, reason: collision with root package name */
    public String f35768p;

    /* renamed from: r, reason: collision with root package name */
    public String f35770r;

    /* renamed from: s, reason: collision with root package name */
    public String f35771s;

    /* renamed from: t, reason: collision with root package name */
    public String f35772t;

    /* renamed from: v, reason: collision with root package name */
    public String f35774v;

    /* renamed from: q, reason: collision with root package name */
    public String f35769q = "android";

    /* renamed from: i, reason: collision with root package name */
    public String f35761i = k0.t();

    /* renamed from: u, reason: collision with root package name */
    public String f35773u = k0.q();

    /* renamed from: l, reason: collision with root package name */
    public String f35764l = f.d();

    public d(Context context) {
        int s11 = k0.s(context);
        this.f35766n = String.valueOf(s11);
        this.f35767o = k0.a(context, s11);
        this.f35762j = k0.l(context);
        this.f35757e = com.mbridge.msdk.foundation.controller.c.m().c();
        this.f35756d = com.mbridge.msdk.foundation.controller.c.m().b();
        this.f35772t = String.valueOf(t0.g(context));
        this.f35771s = String.valueOf(t0.f(context));
        this.f35770r = String.valueOf(t0.d(context));
        this.f35774v = com.mbridge.msdk.foundation.controller.c.m().j().toString();
        this.f35759g = k0.s();
        this.f35765m = t0.a();
        if (context.getResources().getConfiguration().orientation == 2) {
            this.f35768p = TmcStartParams.KEY_LANDSCAPE;
        } else {
            this.f35768p = "portrait";
        }
        this.f35758f = com.mbridge.msdk.foundation.same.a.V;
        this.f35760h = com.mbridge.msdk.foundation.same.a.f35389g;
        this.f35763k = k0.u();
        this.f35755c = f.e();
        this.f35753a = f.a();
        this.f35754b = com.mbridge.msdk.foundation.controller.authoritycontroller.b.j() ? 1 : 0;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("device", this.f35761i);
                jSONObject.put("system_version", this.f35773u);
                jSONObject.put("network_type", this.f35766n);
                jSONObject.put("network_type_str", this.f35767o);
                jSONObject.put("device_ua", this.f35762j);
                jSONObject.put("has_wx", k0.D(com.mbridge.msdk.foundation.controller.c.m().d()));
                jSONObject.put("integrated_wx", k0.D());
                jSONObject.put("opensdk_ver", k0.B() + "");
                jSONObject.put("wx_api_ver", k0.e(com.mbridge.msdk.foundation.controller.c.m().i()) + "");
                jSONObject.put("brand", this.f35759g);
                jSONObject.put("mnc", k0.r(com.mbridge.msdk.foundation.controller.c.m().d()));
                jSONObject.put("mcc", k0.q(com.mbridge.msdk.foundation.controller.c.m().d()));
                jSONObject.put("adid_limit", this.f35753a);
                jSONObject.put("adid_limit_dev", this.f35754b);
            }
            jSONObject.put("plantform", this.f35769q);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("google_ad_id", this.f35764l);
                jSONObject.put("az_aid_info", this.f35755c);
            }
            jSONObject.put("appkey", this.f35757e);
            jSONObject.put("appId", this.f35756d);
            jSONObject.put("screen_width", this.f35772t);
            jSONObject.put("screen_height", this.f35771s);
            jSONObject.put("orientation", this.f35768p);
            jSONObject.put("scale", this.f35770r);
            jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, this.f35758f);
            jSONObject.put("c", this.f35760h);
            jSONObject.put("web_env", this.f35774v);
            jSONObject.put("f", this.f35763k);
            jSONObject.put("misk_spt", this.f35765m);
            if (k0.y() != 0) {
                jSONObject.put("tun", k0.y());
            }
            jSONObject.put(com.mbridge.msdk.foundation.same.net.wrapper.e.f35553f, com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c() + "");
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("adid_limit", this.f35753a);
                jSONObject2.put("adid_limit_dev", this.f35754b);
                jSONObject.put("dvi", i0.b(jSONObject2.toString()));
            }
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.i()) {
                jSONObject.put("dev_source", "2");
            }
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                jSONObject.put("re_domain", "1");
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }
}
