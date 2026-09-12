package com.mbridge.msdk.click.utils;

import android.content.Context;
import android.webkit.URLUtil;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.m0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f34498a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static int f34499b = 2;

    /* renamed from: c, reason: collision with root package name */
    public static int f34500c = 1500;

    public static boolean a(CampaignEx campaignEx, String str, int i11) {
        if (campaignEx != null && campaignEx.getTpOffer() == 1) {
            r0 = campaignEx.getFac() != 0;
            b(campaignEx, str, i11);
        }
        return r0;
    }

    private static void b(CampaignEx campaignEx, String str, int i11) {
        try {
            Context d11 = c.m().d();
            if (d11 == null || campaignEx == null) {
                return;
            }
            if (URLUtil.isFileUrl(str)) {
                File file = new File(str.replace("file:////", "").replace("file:///", "").replace(AdPayload.FILE_SCHEME, ""));
                if (file.exists()) {
                    str = m0.e(file);
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "2000109");
            jSONObject.put(NativeComponentConstants.KEY_COMPONENT_TYPE, i11);
            jSONObject.put("html", str);
            jSONObject.put("network_type", k0.s(d11));
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, campaignEx.getCampaignUnitId());
            jSONObject.put("rid", campaignEx.getRequestId());
            jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
            jSONObject.put(BidResponsedEx.KEY_CID, campaignEx.getId());
            if (campaignEx.isBidCampaign()) {
                jSONObject.put(CampaignEx.JSON_KEY_HB, 1);
            }
            d.b().a(jSONObject);
        } catch (Throwable th2) {
            o0.b("DspFilterUtils", th2.getMessage());
        }
    }
}
