package com.mbridge.msdk.videocommon.entity;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f40013a;

    /* renamed from: b, reason: collision with root package name */
    private int f40014b;

    public c(String str, int i11) {
        this.f40013a = str;
        this.f40014b = i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c A[Catch: Exception -> 0x0015, TRY_LEAVE, TryCatch #0 {Exception -> 0x0015, blocks: (B:3:0x0001, B:5:0x000f, B:8:0x002c, B:14:0x0019, B:16:0x001f), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.mbridge.msdk.videocommon.entity.c a(java.lang.String r3) {
        /*
            r0 = 0
            com.mbridge.msdk.videocommon.setting.b r1 = com.mbridge.msdk.videocommon.setting.b.b()     // Catch: java.lang.Exception -> L15
            com.mbridge.msdk.videocommon.setting.a r1 = r1.c()     // Catch: java.lang.Exception -> L15
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L15
            if (r2 == 0) goto L17
            com.mbridge.msdk.videocommon.entity.c r3 = b()     // Catch: java.lang.Exception -> L15
        L13:
            r0 = r3
            goto L2a
        L15:
            r3 = move-exception
            goto L31
        L17:
            if (r1 == 0) goto L2a
            java.util.Map r2 = r1.g()     // Catch: java.lang.Exception -> L15
            if (r2 == 0) goto L2a
            java.util.Map r1 = r1.g()     // Catch: java.lang.Exception -> L15
            java.lang.Object r3 = r1.get(r3)     // Catch: java.lang.Exception -> L15
            com.mbridge.msdk.videocommon.entity.c r3 = (com.mbridge.msdk.videocommon.entity.c) r3     // Catch: java.lang.Exception -> L15
            goto L13
        L2a:
            if (r0 != 0) goto L34
            com.mbridge.msdk.videocommon.entity.c r0 = b()     // Catch: java.lang.Exception -> L15
            goto L34
        L31:
            r3.printStackTrace()
        L34:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.entity.c.a(java.lang.String):com.mbridge.msdk.videocommon.entity.c");
    }

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String optString = jSONObject.optString("name");
            int optInt = jSONObject.optInt(RewardPlus.AMOUNT);
            jSONObject.optString("id");
            return new c(optString, optInt);
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static Map<String, c> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i11);
                hashMap.put(optJSONObject.optString("id"), new c(optJSONObject.optString("name"), optJSONObject.optInt(RewardPlus.AMOUNT)));
            }
            return hashMap;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static c b() {
        return new c("Virtual Item", 1);
    }

    public int a() {
        return this.f40014b;
    }

    public void a(int i11) {
        this.f40014b = i11;
    }

    public void b(String str) {
        this.f40013a = str;
    }

    public String c() {
        return this.f40013a;
    }

    public String toString() {
        return "Reward{name='" + this.f40013a + "', amount=" + this.f40014b + '}';
    }
}
