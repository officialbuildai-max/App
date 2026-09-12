package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Dq {
    private String Sj;
    private List<String> sP;

    public Dq(String str) {
        this.Sj = "";
        this.sP = new ArrayList();
        HashMap<String, Object> hashMap = TextUtils.isEmpty(str) ? new HashMap<>() : Sj(str);
        try {
            this.Sj = (String) hashMap.get("auto_test_param");
            JSONArray jSONArray = new JSONArray((String) hashMap.get("auto_test_hosts"));
            this.sP = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                this.sP.add(jSONArray.optString(i11));
            }
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.sU.sP("AutoTestModel", e11.getMessage());
        }
    }

    private static final HashMap<String, Object> Sj(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap<>();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i11);
                hashMap.put(optJSONObject.optString("name"), optJSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE));
            }
            return hashMap;
        } catch (Exception unused) {
            return new HashMap<>();
        }
    }

    public String Sj() {
        return this.Sj;
    }

    public List<String> sP() {
        return this.sP;
    }
}
