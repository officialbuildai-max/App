package com.mbridge.msdk.splash.common;

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

/* loaded from: classes5.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    public String f37424e;

    /* renamed from: f, reason: collision with root package name */
    public String f37425f;

    /* renamed from: g, reason: collision with root package name */
    public String f37426g;

    /* renamed from: h, reason: collision with root package name */
    public String f37427h;

    /* renamed from: i, reason: collision with root package name */
    public String f37428i;

    /* renamed from: j, reason: collision with root package name */
    public String f37429j;

    /* renamed from: k, reason: collision with root package name */
    public String f37430k;

    /* renamed from: l, reason: collision with root package name */
    public String f37431l;

    /* renamed from: m, reason: collision with root package name */
    public String f37432m;

    /* renamed from: n, reason: collision with root package name */
    public String f37433n;

    /* renamed from: o, reason: collision with root package name */
    public String f37434o;

    /* renamed from: p, reason: collision with root package name */
    public int f37435p;

    /* renamed from: q, reason: collision with root package name */
    public int f37436q;

    /* renamed from: c, reason: collision with root package name */
    public String f37422c = "android";

    /* renamed from: a, reason: collision with root package name */
    public String f37420a = k0.t();

    /* renamed from: b, reason: collision with root package name */
    public String f37421b = k0.q();

    /* renamed from: d, reason: collision with root package name */
    public String f37423d = f.d();

    public a(Context context) {
        int s11 = k0.s(context);
        this.f37424e = String.valueOf(s11);
        this.f37425f = k0.a(context, s11);
        this.f37426g = k0.l(context);
        this.f37427h = com.mbridge.msdk.foundation.controller.c.m().c();
        this.f37428i = com.mbridge.msdk.foundation.controller.c.m().b();
        this.f37429j = String.valueOf(t0.g(context));
        this.f37430k = String.valueOf(t0.f(context));
        this.f37432m = String.valueOf(t0.d(context));
        if (context.getResources().getConfiguration().orientation == 2) {
            this.f37431l = TmcStartParams.KEY_LANDSCAPE;
        } else {
            this.f37431l = "portrait";
        }
        this.f37433n = k0.u();
        this.f37434o = f.e();
        this.f37435p = f.a();
        this.f37436q = com.mbridge.msdk.foundation.controller.authoritycontroller.b.j() ? 1 : 0;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("device", this.f37420a);
                jSONObject.put("system_version", this.f37421b);
                jSONObject.put("network_type", this.f37424e);
                jSONObject.put("network_type_str", this.f37425f);
                jSONObject.put("device_ua", this.f37426g);
                jSONObject.put("has_wx", k0.D(com.mbridge.msdk.foundation.controller.c.m().d()));
                jSONObject.put("integrated_wx", k0.D());
                jSONObject.put("mnc", k0.r(com.mbridge.msdk.foundation.controller.c.m().d()));
                jSONObject.put("mcc", k0.q(com.mbridge.msdk.foundation.controller.c.m().d()));
                jSONObject.put("adid_limit", this.f37435p);
                jSONObject.put("adid_limit_dev", this.f37436q);
            }
            jSONObject.put("plantform", this.f37422c);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("google_ad_id", this.f37423d);
                jSONObject.put("az_aid_info", this.f37434o);
            }
            jSONObject.put("appkey", this.f37427h);
            jSONObject.put("appId", this.f37428i);
            jSONObject.put("screen_width", this.f37429j);
            jSONObject.put("screen_height", this.f37430k);
            jSONObject.put("orientation", this.f37431l);
            jSONObject.put("scale", this.f37432m);
            if (k0.y() != 0) {
                jSONObject.put("tun", k0.y());
            }
            jSONObject.put("f", this.f37433n);
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                jSONObject.put("re_domain", "1");
            }
        } catch (JSONException e11) {
            o0.b("BaseDeviceInfo", e11.getMessage());
        }
        return jSONObject;
    }
}
