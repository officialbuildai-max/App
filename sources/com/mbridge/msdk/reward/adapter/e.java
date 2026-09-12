package com.mbridge.msdk.reward.adapter;

import android.text.TextUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.out.MBSupportMuteAdType;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f37111a;

    /* renamed from: b, reason: collision with root package name */
    private final String f37112b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f37113c;

    /* renamed from: d, reason: collision with root package name */
    private final com.mbridge.msdk.videocommon.setting.c f37114d;

    /* renamed from: e, reason: collision with root package name */
    private final String f37115e;

    public e(String str, String str2, boolean z10, com.mbridge.msdk.videocommon.setting.c cVar, String str3) {
        this.f37111a = str;
        this.f37112b = str2;
        this.f37113c = z10;
        this.f37114d = cVar;
        this.f37115e = str3;
    }

    public com.mbridge.msdk.foundation.same.net.wrapper.e a(boolean z10, String str, int i11, String str2, String str3, String str4, String str5, boolean z11, int i12) {
        int i13;
        int i14;
        String b11 = com.mbridge.msdk.foundation.controller.c.m().b();
        String md5 = SameMD5.getMD5(com.mbridge.msdk.foundation.controller.c.m().b() + com.mbridge.msdk.foundation.controller.c.m().c());
        int i15 = z10 ? 2 : 3;
        com.mbridge.msdk.videocommon.setting.c cVar = this.f37114d;
        if (cVar != null) {
            i13 = cVar.e();
            i14 = this.f37114d.b();
        } else {
            i13 = 0;
            i14 = 0;
        }
        String a11 = com.mbridge.msdk.foundation.same.buffer.b.a(this.f37112b, "reward");
        int i16 = this.f37113c ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94;
        com.mbridge.msdk.foundation.same.net.wrapper.e eVar = new com.mbridge.msdk.foundation.same.net.wrapper.e();
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "app_id", b11);
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, MBridgeConstans.PROPERTIES_UNIT_ID, this.f37112b);
        if (!TextUtils.isEmpty(this.f37111a)) {
            com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, MBridgeConstans.PLACEMENT_ID, this.f37111a);
        }
        if (com.mbridge.msdk.util.b.a()) {
            com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "ttc_ids", str4 == null ? "" : str4);
            com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "install_ids", str3 == null ? "" : str3);
        }
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, TmcConstants.EXTRA_APP_DEV_TOKEN, md5);
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "req_type", String.valueOf(i15));
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "ad_num", String.valueOf(i13));
        if (this.f37113c) {
            i14 = 1;
        }
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "tnum", String.valueOf(i14));
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "only_impression", "1");
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "ping_mode", "1");
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, com.mbridge.msdk.foundation.same.net.wrapper.e.f35554g, a11);
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, com.mbridge.msdk.foundation.same.net.wrapper.e.f35555h, str == null ? "" : str);
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, CampaignEx.JSON_KEY_AD_SOURCE_ID, String.valueOf(1));
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, com.mbridge.msdk.foundation.same.net.wrapper.e.f35556i, str2 == null ? "" : str2);
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "ad_type", String.valueOf(i16));
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "offset", String.valueOf(i11));
        if (!TextUtils.isEmpty(str5)) {
            com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "token", str5);
        }
        if (this.f37113c) {
            if (i12 == com.mbridge.msdk.foundation.same.a.I || i12 == com.mbridge.msdk.foundation.same.a.H) {
                com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "ivrwd", "1");
            } else {
                com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "ivrwd", "0");
            }
        }
        com.mbridge.msdk.videocommon.setting.c cVar2 = this.f37114d;
        if (cVar2 != null && !TextUtils.isEmpty(cVar2.a())) {
            com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "u_stid", this.f37114d.a());
        }
        com.mbridge.msdk.videocommon.setting.a c11 = com.mbridge.msdk.videocommon.setting.b.b().c();
        if (c11 != null && !TextUtils.isEmpty(c11.a())) {
            com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "r_stid", c11.a());
        }
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "rw_plus", z11 ? "1" : "0");
        String d11 = t0.d(this.f37112b);
        if (!TextUtils.isEmpty(d11)) {
            com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, j.f35620b, d11);
        }
        String str6 = this.f37115e;
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, str6 != null ? str6 : "");
        return eVar;
    }
}
