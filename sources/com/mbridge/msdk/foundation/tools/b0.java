package com.mbridge.msdk.foundation.tools;

import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class b0 {
    public static String a(int i11, int i12, int i13, int i14, int i15) {
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                jSONObject.put("code", 0);
                jSONObject.put("message", "Success");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("rotateAngle", i11);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(TtmlNode.LEFT, i12);
                jSONObject3.put(TtmlNode.RIGHT, i13);
                jSONObject3.put(IntegrationConstants.TAB_BAR_POSITION_TOP, i14);
                jSONObject3.put(IntegrationConstants.TAB_BAR_POSITION_DEFAULT, i15);
                jSONObject2.put("cutoutInfo", jSONObject3);
                jSONObject.put("data", jSONObject2);
            } catch (Exception e11) {
                o0.b("JSONUtils", e11.getMessage());
            }
        } catch (Throwable th2) {
            o0.b("JSONUtils", th2.getMessage());
            try {
                jSONObject.put("code", 1);
                jSONObject.put("message", "Fail");
            } catch (JSONException e12) {
                o0.b("JSONUtils", e12.getMessage());
            }
        }
        return jSONObject.toString();
    }

    public static ArrayList<String> a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        ArrayList<String> arrayList = new ArrayList<>(length);
        for (int i11 = 0; i11 < length; i11++) {
            arrayList.add(jSONArray.optString(i11));
        }
        return arrayList;
    }
}
