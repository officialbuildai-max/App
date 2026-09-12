package com.mbridge.msdk.splash.common.util;

import android.text.TextUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37465a = "a";

    public static CampaignEx a(String str, CampaignEx campaignEx) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return campaignEx;
        }
        if (TextUtils.isEmpty(str) && campaignEx == null) {
            return null;
        }
        if (str.contains("notice")) {
            try {
                JSONObject campaignToJsonObject = CampaignEx.campaignToJsonObject(campaignEx);
                JSONObject jSONObject = new JSONObject(str);
                try {
                    if (!jSONObject.has(CampaignEx.JSON_KEY_DEEP_LINK_URL)) {
                        campaignToJsonObject.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, "");
                    }
                } catch (Exception e11) {
                    o0.b(f37465a, e11.getMessage());
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    campaignToJsonObject.put(next, jSONObject.getString(next));
                }
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(campaignToJsonObject);
                String optString = campaignToJsonObject.optString("unitId");
                if (!TextUtils.isEmpty(optString)) {
                    parseCampaignWithBackData.setCampaignUnitId(optString);
                }
                return parseCampaignWithBackData;
            } catch (JSONException e12) {
                o0.b(f37465a, e12.getMessage());
                return campaignEx;
            }
        }
        try {
            JSONObject campaignToJsonObject2 = CampaignEx.campaignToJsonObject(campaignEx);
            CampaignEx parseCampaignWithBackData2 = CampaignEx.parseCampaignWithBackData(campaignToJsonObject2);
            if (parseCampaignWithBackData2 == null) {
                parseCampaignWithBackData2 = campaignEx;
            }
            if (!TextUtils.isEmpty(str)) {
                String optString2 = campaignToJsonObject2.optString("unitId");
                if (!TextUtils.isEmpty(optString2)) {
                    parseCampaignWithBackData2.setCampaignUnitId(optString2);
                }
                JSONObject optJSONObject = new JSONObject(str).optJSONObject(com.mbridge.msdk.foundation.same.a.f35392j);
                if (optJSONObject != null) {
                    String string = optJSONObject.getString(com.mbridge.msdk.foundation.same.a.f35390h);
                    String string2 = optJSONObject.getString(com.mbridge.msdk.foundation.same.a.f35391i);
                    if (TextUtils.isEmpty(string)) {
                        string = "-999";
                    }
                    int parseInt = Integer.parseInt(string);
                    if (TextUtils.isEmpty(string2)) {
                        string2 = "-999";
                    }
                    int parseInt2 = Integer.parseInt(string2);
                    str2 = parseInt != -999 ? String.valueOf(t0.a(c.m().d(), parseInt)) : "-999";
                    str3 = parseInt2 != -999 ? String.valueOf(t0.a(c.m().d(), parseInt2)) : "-999";
                } else {
                    str2 = "-999";
                    str3 = str2;
                }
                parseCampaignWithBackData2.setClickURL(com.mbridge.msdk.click.c.a(parseCampaignWithBackData2.getClickURL(), str2, str3));
                String noticeUrl = parseCampaignWithBackData2.getNoticeUrl();
                if (optJSONObject != null) {
                    Iterator<String> keys2 = optJSONObject.keys();
                    StringBuilder sb2 = new StringBuilder();
                    while (keys2.hasNext()) {
                        sb2.append(UrlUtils.AND_MARK);
                        String next2 = keys2.next();
                        String optString3 = optJSONObject.optString(next2);
                        if (com.mbridge.msdk.foundation.same.a.f35390h.equals(next2) || com.mbridge.msdk.foundation.same.a.f35391i.equals(next2)) {
                            if (TextUtils.isEmpty(optString3)) {
                                optString3 = "-999";
                            }
                            int parseInt3 = Integer.parseInt(optString3);
                            optString3 = parseInt3 != -999 ? String.valueOf(t0.a(c.m().d(), parseInt3)) : "-999";
                        }
                        sb2.append(next2);
                        sb2.append(UrlUtils.EQUAL_MARK);
                        sb2.append(optString3);
                    }
                    parseCampaignWithBackData2.setNoticeUrl(noticeUrl + ((Object) sb2));
                }
            }
            return parseCampaignWithBackData2;
        } catch (Throwable unused) {
            return campaignEx;
        }
    }

    public static String a(int i11, float f11, float f12) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (i11 == 4) {
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f35390h, -999);
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f35391i, -999);
            } else {
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f35390h, t0.b(c.m().d(), f11));
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f35391i, t0.b(c.m().d(), f12));
            }
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f35395m, i11);
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f35393k, c.m().d().getResources().getConfiguration().orientation);
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f35394l, t0.d(c.m().d()));
            jSONObject.put(com.mbridge.msdk.foundation.same.a.f35392j, jSONObject2);
        } catch (Exception e11) {
            o0.b(f37465a, e11.getMessage());
        }
        return jSONObject.toString();
    }
}
