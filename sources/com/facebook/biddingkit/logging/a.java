package com.facebook.biddingkit.logging;

import android.content.Context;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReference f24175a = new AtomicReference();

    /* JADX INFO: Access modifiers changed from: protected */
    public static JSONObject a() {
        Map map = (Map) f24175a.get();
        JSONObject jSONObject = new JSONObject();
        if (map == null) {
            return jSONObject;
        }
        try {
            for (Map.Entry entry : map.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        } catch (JSONException e11) {
            b.d("BiddingStaticEnvironmentData", "Failed to create json data", e11);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("bundle", context.getPackageName());
        hashMap.put("idfa", str);
        hashMap.put("device_make", Build.MANUFACTURER);
        hashMap.put("device_model", Build.MODEL);
        hashMap.put("os", "Android");
        hashMap.put("os_version", Build.VERSION.RELEASE);
        hashMap.put("bidding_kit_version", str2);
        f24175a.set(hashMap);
    }
}
