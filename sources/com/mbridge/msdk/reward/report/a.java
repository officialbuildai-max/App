package com.mbridge.msdk.reward.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.same.d;
import com.mbridge.msdk.foundation.same.report.o;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {
    public static void a(Context context, CampaignEx campaignEx, String str) {
        int a11;
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "2000048");
            jSONObject.put("st", System.currentTimeMillis());
            jSONObject.put(BidResponsedEx.KEY_CID, campaignEx.getId());
            jSONObject.put("network_type", k0.s(context));
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            if (t0.c(campaignEx)) {
                jSONObject.put(CampaignEx.JSON_KEY_RETARGET_TYPE, campaignEx.getRtinsType());
            }
            jSONObject.put(CampaignEx.JSON_KEY_HB, campaignEx.isBidCampaign() ? 1 : 0);
            jSONObject.put("rid", campaignEx.getRequestId());
            jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
            jSONObject.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
            if (campaignEx.getRewardTemplateMode() != null && (a11 = d.a(campaignEx, campaignEx.getRewardTemplateMode().e())) != -1) {
                jSONObject.put(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW, a11);
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a(jSONObject);
        } catch (Throwable th2) {
            o0.b("RewardReport", th2.getMessage());
        }
    }

    public static void a(Context context, String str) {
        if (context != null) {
            try {
                n a11 = n.a(g.a(context));
                if (TextUtils.isEmpty(str) || a11 == null || a11.a() <= 0) {
                    return;
                }
                List<m> a12 = a11.a("m_download_end");
                List<m> a13 = a11.a("2000021");
                List<m> a14 = a11.a("2000039");
                List<m> a15 = a11.a("m_download_end");
                List<m> a16 = a11.a("m_download_end");
                List<m> a17 = a11.a("2000044");
                o.e(a13);
                o.a(a12);
                o.c(a14);
                o.b(a15);
                o.f(a16);
                o.d(a17);
            } catch (Exception e11) {
                o0.b("RewardReport", e11.getMessage());
            }
        }
    }
}
