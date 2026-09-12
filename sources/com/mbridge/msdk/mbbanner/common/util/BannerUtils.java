package com.mbridge.msdk.mbbanner.common.util;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.buffer.b;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.y0;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class BannerUtils {
    private static final String TAG = "BannerUtils";

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f36202a = 0;

    private static synchronized List<com.mbridge.msdk.foundation.same.metadata.a> fillIdInList(List<com.mbridge.msdk.foundation.same.metadata.a> list, List<CampaignEx> list2) {
        synchronized (BannerUtils.class) {
            if (list2 != null) {
                try {
                    if (list2.size() > 0) {
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        for (CampaignEx campaignEx : list2) {
                            if (campaignEx != null) {
                                com.mbridge.msdk.foundation.same.metadata.a aVar = new com.mbridge.msdk.foundation.same.metadata.a(campaignEx.getId(), campaignEx.getCreativeId());
                                if (list.size() >= 20) {
                                    list.remove(0);
                                }
                                list.add(aVar);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return list;
    }

    public static String getCloseIds(String str) {
        List<com.mbridge.msdk.foundation.same.metadata.a> list;
        try {
            Map<String, List<com.mbridge.msdk.foundation.same.metadata.a>> map = b.f35415b;
            if (map != null && y0.b(str) && map.containsKey(str) && (list = map.get(str)) != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i11 = 0; i11 < list.size(); i11++) {
                    JSONObject jSONObject = new JSONObject();
                    com.mbridge.msdk.foundation.same.metadata.a aVar = list.get(i11);
                    jSONObject.put(BidResponsedEx.KEY_CID, aVar.a());
                    jSONObject.put("crid", aVar.b());
                    jSONArray.put(jSONObject);
                }
                return jSONArray.toString();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return "";
    }

    public static void inserCloseId(String str, List<CampaignEx> list) {
        Map<String, List<com.mbridge.msdk.foundation.same.metadata.a>> map = b.f35415b;
        if (map == null || list == null || list.size() <= 0) {
            return;
        }
        if (y0.b(str)) {
            if (map.containsKey(str)) {
                map.put(str, fillIdInList(map.get(str), list));
            } else {
                map.put(str, fillIdInList(new ArrayList(), list));
            }
        }
        b.f35415b = map;
    }

    public static CampaignEx managerCampaignEX(String str, CampaignEx campaignEx) {
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
                Iterator<String> keys = jSONObject.keys();
                try {
                    if (!jSONObject.has(CampaignEx.JSON_KEY_DEEP_LINK_URL)) {
                        campaignToJsonObject.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, "");
                    }
                } catch (Exception unused) {
                }
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
            } catch (JSONException e11) {
                e11.printStackTrace();
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
                    str2 = String.valueOf(t0.a(c.m().d(), Integer.valueOf(optJSONObject.getString(com.mbridge.msdk.foundation.same.a.f35390h)).intValue()));
                    str3 = String.valueOf(t0.a(c.m().d(), Integer.valueOf(optJSONObject.getString(com.mbridge.msdk.foundation.same.a.f35391i)).intValue()));
                } else {
                    str2 = "-999";
                    str3 = "-999";
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
                            optString3 = String.valueOf(t0.a(c.m().d(), Integer.valueOf(optString3).intValue()));
                        }
                        sb2.append(next2);
                        sb2.append(UrlUtils.EQUAL_MARK);
                        sb2.append(optString3);
                    }
                    parseCampaignWithBackData2.setNoticeUrl(noticeUrl + ((Object) sb2));
                }
            }
            return parseCampaignWithBackData2;
        } catch (Throwable unused2) {
            return campaignEx;
        }
    }

    public static void uisList(Context context, List<CampaignEx> list) {
        if (context == null || list == null || list.size() == 0) {
            return;
        }
        j a11 = j.a(g.a(context));
        for (int i11 = 0; i11 < list.size(); i11++) {
            CampaignEx campaignEx = list.get(i11);
            if (a11 != null && !a11.a(campaignEx.getId())) {
                com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                gVar.a(campaignEx.getId());
                gVar.b(campaignEx.getFca());
                gVar.c(campaignEx.getFcb());
                gVar.a(0);
                gVar.d(0);
                gVar.a(System.currentTimeMillis());
                a11.b(gVar);
            }
        }
    }
}
