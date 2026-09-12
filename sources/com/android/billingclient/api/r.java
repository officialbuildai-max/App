package com.android.billingclient.api;

import android.text.TextUtils;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.android.gms.internal.play_billing.zzaf;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private final String f19235a;

    /* renamed from: b, reason: collision with root package name */
    private final JSONObject f19236b;

    /* renamed from: c, reason: collision with root package name */
    private final String f19237c;

    /* renamed from: d, reason: collision with root package name */
    private final String f19238d;

    /* renamed from: e, reason: collision with root package name */
    private final String f19239e;

    /* renamed from: f, reason: collision with root package name */
    private final String f19240f;

    /* renamed from: g, reason: collision with root package name */
    private final String f19241g;

    /* renamed from: h, reason: collision with root package name */
    private final String f19242h;

    /* renamed from: i, reason: collision with root package name */
    private final String f19243i;

    /* renamed from: j, reason: collision with root package name */
    private final String f19244j;

    /* renamed from: k, reason: collision with root package name */
    private final String f19245k;

    /* renamed from: l, reason: collision with root package name */
    private final List f19246l;

    /* renamed from: m, reason: collision with root package name */
    private final List f19247m;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f19248a;

        /* renamed from: b, reason: collision with root package name */
        private final long f19249b;

        /* renamed from: c, reason: collision with root package name */
        private final String f19250c;

        /* renamed from: d, reason: collision with root package name */
        private final String f19251d;

        /* renamed from: e, reason: collision with root package name */
        private final String f19252e;

        /* renamed from: f, reason: collision with root package name */
        private final zzaf f19253f;

        /* renamed from: g, reason: collision with root package name */
        private final Long f19254g;

        /* renamed from: h, reason: collision with root package name */
        private final z0 f19255h;

        /* renamed from: i, reason: collision with root package name */
        private final c1 f19256i;

        /* renamed from: j, reason: collision with root package name */
        private final a1 f19257j;

        /* renamed from: k, reason: collision with root package name */
        private final b1 f19258k;

        a(JSONObject jSONObject) {
            this.f19248a = jSONObject.optString("formattedPrice");
            this.f19249b = jSONObject.optLong("priceAmountMicros");
            this.f19250c = jSONObject.optString("priceCurrencyCode");
            this.f19251d = jSONObject.optString("offerIdToken");
            this.f19252e = jSONObject.optString("offerId");
            jSONObject.optInt("offerType");
            JSONArray optJSONArray = jSONObject.optJSONArray("offerTags");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                    arrayList.add(optJSONArray.getString(i11));
                }
            }
            this.f19253f = zzaf.zzj(arrayList);
            this.f19254g = jSONObject.has("fullPriceMicros") ? Long.valueOf(jSONObject.optLong("fullPriceMicros")) : null;
            JSONObject optJSONObject = jSONObject.optJSONObject("discountDisplayInfo");
            this.f19255h = optJSONObject == null ? null : new z0(optJSONObject);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("validTimeWindow");
            this.f19256i = optJSONObject2 == null ? null : new c1(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("limitedQuantityInfo");
            this.f19257j = optJSONObject3 == null ? null : new a1(optJSONObject3);
            JSONObject optJSONObject4 = jSONObject.optJSONObject("preorderDetails");
            this.f19258k = optJSONObject4 != null ? new b1(optJSONObject4) : null;
        }

        public final String a() {
            return this.f19251d;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f19259a;

        /* renamed from: b, reason: collision with root package name */
        private final long f19260b;

        /* renamed from: c, reason: collision with root package name */
        private final String f19261c;

        /* renamed from: d, reason: collision with root package name */
        private final String f19262d;

        /* renamed from: e, reason: collision with root package name */
        private final int f19263e;

        /* renamed from: f, reason: collision with root package name */
        private final int f19264f;

        b(JSONObject jSONObject) {
            this.f19262d = jSONObject.optString("billingPeriod");
            this.f19261c = jSONObject.optString("priceCurrencyCode");
            this.f19259a = jSONObject.optString("formattedPrice");
            this.f19260b = jSONObject.optLong("priceAmountMicros");
            this.f19264f = jSONObject.optInt("recurrenceMode");
            this.f19263e = jSONObject.optInt("billingCycleCount");
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final List f19265a;

        c(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i11);
                    if (optJSONObject != null) {
                        arrayList.add(new b(optJSONObject));
                    }
                }
            }
            this.f19265a = arrayList;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f19266a;

        /* renamed from: b, reason: collision with root package name */
        private final String f19267b;

        /* renamed from: c, reason: collision with root package name */
        private final String f19268c;

        /* renamed from: d, reason: collision with root package name */
        private final c f19269d;

        /* renamed from: e, reason: collision with root package name */
        private final List f19270e;

        /* renamed from: f, reason: collision with root package name */
        private final y0 f19271f;

        d(JSONObject jSONObject) {
            this.f19266a = jSONObject.optString("basePlanId");
            String optString = jSONObject.optString("offerId");
            this.f19267b = true == optString.isEmpty() ? null : optString;
            this.f19268c = jSONObject.getString("offerIdToken");
            this.f19269d = new c(jSONObject.getJSONArray("pricingPhases"));
            JSONObject optJSONObject = jSONObject.optJSONObject("installmentPlanDetails");
            this.f19271f = optJSONObject != null ? new y0(optJSONObject) : null;
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("offerTags");
            if (optJSONArray != null) {
                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                    arrayList.add(optJSONArray.getString(i11));
                }
            }
            this.f19270e = arrayList;
        }

        public String a() {
            return this.f19268c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(String str) {
        this.f19235a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.f19236b = jSONObject;
        String optString = jSONObject.optString("productId");
        this.f19237c = optString;
        String optString2 = jSONObject.optString(NativeComponentConstants.KEY_COMPONENT_TYPE);
        this.f19238d = optString2;
        if (TextUtils.isEmpty(optString)) {
            throw new IllegalArgumentException("Product id cannot be empty.");
        }
        if (TextUtils.isEmpty(optString2)) {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
        this.f19239e = jSONObject.optString(CampaignEx.JSON_KEY_TITLE);
        this.f19240f = jSONObject.optString("name");
        this.f19241g = jSONObject.optString(TrackingKey.DESCRIPTION);
        this.f19243i = jSONObject.optString("packageDisplayName");
        this.f19244j = jSONObject.optString("iconUrl");
        this.f19242h = jSONObject.optString("skuDetailsToken");
        this.f19245k = jSONObject.optString("serializedDocid");
        JSONArray optJSONArray = jSONObject.optJSONArray("subscriptionOfferDetails");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                arrayList.add(new d(optJSONArray.getJSONObject(i11)));
            }
            this.f19246l = arrayList;
        } else {
            this.f19246l = (optString2.equals("subs") || optString2.equals("play_pass_subs")) ? new ArrayList() : null;
        }
        JSONObject optJSONObject = this.f19236b.optJSONObject("oneTimePurchaseOfferDetails");
        JSONArray optJSONArray2 = this.f19236b.optJSONArray("oneTimePurchaseOfferDetailsList");
        ArrayList arrayList2 = new ArrayList();
        if (optJSONArray2 != null) {
            for (int i12 = 0; i12 < optJSONArray2.length(); i12++) {
                arrayList2.add(new a(optJSONArray2.getJSONObject(i12)));
            }
            this.f19247m = arrayList2;
            return;
        }
        if (optJSONObject == null) {
            this.f19247m = null;
        } else {
            arrayList2.add(new a(optJSONObject));
            this.f19247m = arrayList2;
        }
    }

    public a a() {
        List list = this.f19247m;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (a) this.f19247m.get(0);
    }

    public String b() {
        return this.f19237c;
    }

    public String c() {
        return this.f19238d;
    }

    public List d() {
        return this.f19246l;
    }

    public final String e() {
        return this.f19236b.optString("packageName");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            return TextUtils.equals(this.f19235a, ((r) obj).f19235a);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String f() {
        return this.f19242h;
    }

    public String g() {
        return this.f19245k;
    }

    public int hashCode() {
        return this.f19235a.hashCode();
    }

    public String toString() {
        List list = this.f19246l;
        return "ProductDetails{jsonString='" + this.f19235a + "', parsedJson=" + this.f19236b.toString() + ", productId='" + this.f19237c + "', productType='" + this.f19238d + "', title='" + this.f19239e + "', productDetailsToken='" + this.f19242h + "', subscriptionOfferDetails=" + String.valueOf(list) + "}";
    }
}
