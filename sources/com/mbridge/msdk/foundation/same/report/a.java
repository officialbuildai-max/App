package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.tools.i0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.meituan.android.walle.ChannelReader;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {
    public static JSONObject a() {
        JSONObject jSONObject;
        Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
        try {
            jSONObject = j.a(d11).c();
        } catch (Exception e11) {
            o0.b("CommonDeviceInfo", "getCommonProperty error", e11);
            jSONObject = null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V)) {
                com.mbridge.msdk.foundation.same.a.V = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
            }
            if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V)) {
                jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
            }
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f35389g)) {
                com.mbridge.msdk.foundation.same.a.f35389g = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("c");
            }
            if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f35389g)) {
                jSONObject.put("c", com.mbridge.msdk.foundation.same.a.f35389g);
            }
            jSONObject.put(MRAIDPresenter.OPEN, com.mbridge.msdk.foundation.same.a.S);
            String a11 = Aa.a();
            if (a11 == null) {
                a11 = "";
            }
            jSONObject.put(ChannelReader.CHANNEL_KEY, a11);
            jSONObject.put("band_width", com.mbridge.msdk.foundation.same.net.a.b().a());
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.i()) {
                jSONObject.put("dev_source", "2");
            }
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                jSONObject.put("re_domain", "1");
            }
            com.mbridge.msdk.setting.g d12 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d12 == null) {
                d12 = com.mbridge.msdk.setting.h.b().a();
            }
            JSONObject a12 = a(d12);
            if (a12 != null) {
                String jSONObject2 = a12.toString();
                if (!TextUtils.isEmpty(jSONObject2)) {
                    String b11 = i0.b(jSONObject2);
                    if (!TextUtils.isEmpty(b11)) {
                        jSONObject.put("dvi", b11);
                    }
                }
            }
            jSONObject.put("app_id", com.mbridge.msdk.foundation.controller.c.m().b());
            jSONObject.put("m_sdk", "msdk");
            jSONObject.put("lqswt", String.valueOf(1));
            jSONObject.put("network_available", String.valueOf(t0.m(d11)));
            String str = NetworkUtil.NETWORK_TYPE_UNKNOWN;
            if (d12 != null) {
                str = d12.k();
                jSONObject.put("a_stid", d12.a());
            }
            jSONObject.put("country_code", str);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static JSONObject a(com.mbridge.msdk.setting.g gVar) {
        try {
            return j.a(com.mbridge.msdk.foundation.controller.c.m().d(), gVar);
        } catch (Exception unused) {
            return null;
        }
    }
}
