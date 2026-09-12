package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Purchase {

    /* renamed from: a, reason: collision with root package name */
    private final String f19116a;

    /* renamed from: b, reason: collision with root package name */
    private final String f19117b;

    /* renamed from: c, reason: collision with root package name */
    private final JSONObject f19118c;

    public Purchase(String str, String str2) {
        this.f19116a = str;
        this.f19117b = str2;
        this.f19118c = new JSONObject(str);
    }

    private final ArrayList i() {
        ArrayList arrayList = new ArrayList();
        if (this.f19118c.has("productIds")) {
            JSONArray optJSONArray = this.f19118c.optJSONArray("productIds");
            if (optJSONArray != null) {
                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                    arrayList.add(optJSONArray.optString(i11));
                }
            }
        } else if (this.f19118c.has("productId")) {
            arrayList.add(this.f19118c.optString("productId"));
        }
        return arrayList;
    }

    public a a() {
        JSONObject jSONObject = this.f19118c;
        String optString = jSONObject.optString("obfuscatedAccountId");
        String optString2 = jSONObject.optString("obfuscatedProfileId");
        if (optString == null && optString2 == null) {
            return null;
        }
        return new a(optString, optString2);
    }

    public String b() {
        String optString = this.f19118c.optString("orderId");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return optString;
    }

    public String c() {
        return this.f19116a;
    }

    public List d() {
        return i();
    }

    public int e() {
        return this.f19118c.optInt("purchaseState", 1) != 4 ? 1 : 2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return TextUtils.equals(this.f19116a, purchase.c()) && TextUtils.equals(this.f19117b, purchase.h());
    }

    public long f() {
        return this.f19118c.optLong("purchaseTime");
    }

    public String g() {
        JSONObject jSONObject = this.f19118c;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    public String h() {
        return this.f19117b;
    }

    public int hashCode() {
        return this.f19116a.hashCode();
    }

    public String toString() {
        return "Purchase. Json: ".concat(String.valueOf(this.f19116a));
    }
}
