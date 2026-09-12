package com.bytedance.sdk.component.adexpress.dynamic.EjP;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TKC {
    private HashMap<String, Object> Sj = new HashMap<>();
    private JSONObject sP;

    public TKC(JSONObject jSONObject) {
        this.sP = jSONObject;
    }

    private void Sj(String str, String str2, Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if ((opt instanceof JSONArray) && TextUtils.equals(next, "product_infos")) {
                int i11 = 0;
                while (true) {
                    JSONArray jSONArray = (JSONArray) opt;
                    if (i11 < jSONArray.length()) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i11);
                        Iterator<String> keys2 = optJSONObject.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            Object opt2 = optJSONObject.opt(next2);
                            this.Sj.put(str + "." + str2 + "." + next + "." + i11 + "." + next2, opt2);
                        }
                        i11++;
                    }
                }
            } else {
                this.Sj.put(str + "." + str2 + "." + next, opt);
            }
        }
    }

    public Object Sj(String str) {
        if (this.Sj.containsKey(str)) {
            return this.Sj.get(str);
        }
        return null;
    }

    public void Sj() {
        Iterator<String> keys = this.sP.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = this.sP.opt(next);
            int i11 = 0;
            if (TextUtils.equals("image", next)) {
                if (opt instanceof JSONArray) {
                    while (true) {
                        JSONArray jSONArray = (JSONArray) opt;
                        if (i11 < jSONArray.length()) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i11);
                            if (optJSONObject != null) {
                                Iterator<String> keys2 = optJSONObject.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    Object opt2 = optJSONObject.opt(next2);
                                    this.Sj.put(next + "." + i11 + "." + next2, opt2);
                                }
                            }
                            i11++;
                        }
                    }
                }
            } else if (TextUtils.equals("dynamic_creative", next)) {
                if (opt instanceof String) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) opt);
                        Iterator<String> keys3 = jSONObject.keys();
                        while (keys3.hasNext()) {
                            String next3 = keys3.next();
                            Object opt3 = jSONObject.opt(next3);
                            if ((opt3 instanceof JSONArray) && !TextUtils.equals(next3, "short_phrase") && !TextUtils.equals(next3, "long_phrase")) {
                                for (int i12 = 0; i12 < ((JSONArray) opt3).length(); i12++) {
                                    this.Sj.put(next + "." + next3 + "." + i12, ((JSONArray) opt3).opt(i12));
                                }
                            } else if ((opt3 instanceof JSONObject) && TextUtils.equals(next3, "coupon")) {
                                Iterator<String> keys4 = ((JSONObject) opt3).keys();
                                while (keys4.hasNext()) {
                                    String next4 = keys4.next();
                                    Object opt4 = ((JSONObject) opt3).opt(next4);
                                    this.Sj.put(next + "." + next3 + "." + next4, opt4);
                                }
                            } else if ((opt3 instanceof JSONObject) && TextUtils.equals(next3, "live_room_data")) {
                                Sj(next, next3, opt3);
                            } else {
                                this.Sj.put(next + "." + next3, opt3);
                            }
                        }
                    } catch (JSONException unused) {
                    }
                }
            } else if (!(opt instanceof JSONObject)) {
                this.Sj.put(next, opt);
                if (opt instanceof String) {
                    this.Sj.put(next, opt);
                }
            } else if (opt != null) {
                JSONObject jSONObject2 = (JSONObject) opt;
                Iterator<String> keys5 = jSONObject2.keys();
                while (keys5.hasNext()) {
                    String next5 = keys5.next();
                    Object opt5 = jSONObject2.opt(next5);
                    this.Sj.put(next + "." + next5, opt5);
                }
            }
        }
    }

    public boolean sP(String str) {
        return this.Sj.containsKey(str);
    }
}
