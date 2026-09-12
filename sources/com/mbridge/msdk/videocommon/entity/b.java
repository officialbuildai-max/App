package com.mbridge.msdk.videocommon.entity;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f40010a;

    /* renamed from: b, reason: collision with root package name */
    private int f40011b;

    /* renamed from: c, reason: collision with root package name */
    private a f40012c;

    public b(int i11, int i12, a aVar) {
        this.f40010a = i11;
        this.f40011b = i12;
        this.f40012c = aVar;
    }

    public static List<b> a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i11);
                    int optInt = optJSONObject.optInt("id");
                    int optInt2 = optJSONObject.optInt("timeout");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("params");
                    arrayList.add(new b(optInt, optInt2, optJSONObject2 != null ? a.a(optJSONObject2) : null));
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            return arrayList;
        }
        return null;
    }

    public int a() {
        return this.f40010a;
    }

    public int b() {
        return this.f40011b;
    }
}
