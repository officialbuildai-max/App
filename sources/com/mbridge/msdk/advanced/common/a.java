package com.mbridge.msdk.advanced.common;

import android.content.Context;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    public String f34099e;

    /* renamed from: f, reason: collision with root package name */
    public String f34100f;

    /* renamed from: g, reason: collision with root package name */
    public String f34101g;

    /* renamed from: h, reason: collision with root package name */
    public String f34102h;

    /* renamed from: i, reason: collision with root package name */
    public String f34103i;

    /* renamed from: j, reason: collision with root package name */
    public String f34104j;

    /* renamed from: k, reason: collision with root package name */
    public String f34105k;

    /* renamed from: l, reason: collision with root package name */
    public String f34106l;

    /* renamed from: m, reason: collision with root package name */
    public String f34107m;

    /* renamed from: n, reason: collision with root package name */
    public String f34108n;

    /* renamed from: o, reason: collision with root package name */
    public String f34109o;

    /* renamed from: p, reason: collision with root package name */
    public int f34110p;

    /* renamed from: q, reason: collision with root package name */
    public int f34111q;

    /* renamed from: c, reason: collision with root package name */
    public String f34097c = "android";

    /* renamed from: a, reason: collision with root package name */
    public String f34095a = k0.t();

    /* renamed from: b, reason: collision with root package name */
    public String f34096b = k0.q();

    /* renamed from: d, reason: collision with root package name */
    public String f34098d = f.d();

    public a(Context context) {
        int s11 = k0.s(context);
        this.f34099e = String.valueOf(s11);
        this.f34100f = k0.a(context, s11);
        this.f34101g = k0.l(context);
        this.f34102h = com.mbridge.msdk.foundation.controller.c.m().c();
        this.f34103i = com.mbridge.msdk.foundation.controller.c.m().b();
        this.f34104j = String.valueOf(t0.g(context));
        this.f34105k = String.valueOf(t0.f(context));
        this.f34107m = String.valueOf(t0.d(context));
        if (context.getResources().getConfiguration().orientation == 2) {
            this.f34106l = TmcStartParams.KEY_LANDSCAPE;
        } else {
            this.f34106l = "portrait";
        }
        this.f34108n = k0.u();
        this.f34109o = f.e();
        this.f34110p = f.a();
        this.f34111q = com.mbridge.msdk.foundation.controller.authoritycontroller.b.j() ? 1 : 0;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("device", this.f34095a);
                jSONObject.put("system_version", this.f34096b);
                jSONObject.put("network_type", this.f34099e);
                jSONObject.put("network_type_str", this.f34100f);
                jSONObject.put("device_ua", this.f34101g);
                jSONObject.put("has_wx", k0.D(com.mbridge.msdk.foundation.controller.c.m().d()));
                jSONObject.put("integrated_wx", k0.D());
                jSONObject.put("opensdk_ver", k0.B() + "");
                jSONObject.put("wx_api_ver", k0.e(com.mbridge.msdk.foundation.controller.c.m().i()) + "");
                jSONObject.put("mnc", k0.r(com.mbridge.msdk.foundation.controller.c.m().d()));
                jSONObject.put("mcc", k0.q(com.mbridge.msdk.foundation.controller.c.m().d()));
                jSONObject.put("adid_limit", this.f34110p);
                jSONObject.put("adid_limit_dev", this.f34111q);
            }
            jSONObject.put("plantform", this.f34097c);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("google_ad_id", this.f34098d);
                jSONObject.put("az_aid_info", this.f34109o);
            }
            jSONObject.put("appkey", this.f34102h);
            jSONObject.put("appId", this.f34103i);
            jSONObject.put("screen_width", this.f34104j);
            jSONObject.put("screen_height", this.f34105k);
            jSONObject.put("orientation", this.f34106l);
            jSONObject.put("scale", this.f34107m);
            if (k0.y() != 0) {
                jSONObject.put("tun", k0.y());
            }
            jSONObject.put("f", this.f34108n);
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                jSONObject.put("re_domain", "1");
            }
        } catch (JSONException e11) {
            o0.b("BaseDeviceInfo", e11.getMessage());
        }
        return jSONObject;
    }
}
