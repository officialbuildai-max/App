package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class s extends d {

    /* renamed from: w, reason: collision with root package name */
    public int f35861w;

    /* renamed from: x, reason: collision with root package name */
    public int f35862x;

    public s(Context context) {
        super(context);
        this.f35862x = k0.v();
        this.f35861w = k0.h();
    }

    @Override // com.mbridge.msdk.foundation.tools.d
    public JSONObject a() {
        JSONObject a11 = super.a();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dmt", this.f35862x + "");
                jSONObject.put("dmf", this.f35861w);
            }
        } catch (JSONException e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("DomainDeviceInfo", e11.getMessage());
            }
        }
        return a11;
    }
}
