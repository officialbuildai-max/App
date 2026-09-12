package com.mbridge.msdk.foundation.error;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.out.MBridgeIds;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class b implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private int f35325a;

    /* renamed from: b, reason: collision with root package name */
    private int f35326b;

    /* renamed from: c, reason: collision with root package name */
    private String f35327c;

    /* renamed from: d, reason: collision with root package name */
    private Throwable f35328d;

    /* renamed from: e, reason: collision with root package name */
    private CampaignEx f35329e;

    /* renamed from: f, reason: collision with root package name */
    private MBridgeIds f35330f;

    /* renamed from: g, reason: collision with root package name */
    private String f35331g;

    /* renamed from: h, reason: collision with root package name */
    private String f35332h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f35333i;

    /* renamed from: j, reason: collision with root package name */
    private int f35334j = -1;

    /* renamed from: k, reason: collision with root package name */
    private String f35335k;

    /* renamed from: l, reason: collision with root package name */
    private HashMap<Object, Object> f35336l;

    /* renamed from: m, reason: collision with root package name */
    private int f35337m;

    /* renamed from: n, reason: collision with root package name */
    private String f35338n;

    /* renamed from: o, reason: collision with root package name */
    private String f35339o;

    /* renamed from: p, reason: collision with root package name */
    private String f35340p;

    public b(int i11) {
        this.f35325a = i11;
        this.f35326b = a.b(i11);
    }

    public b(int i11, String str) {
        this.f35325a = i11;
        if (!TextUtils.isEmpty(str)) {
            a("his_reason", str);
        }
        this.f35327c = str;
        this.f35326b = a.b(i11);
    }

    public CampaignEx a() {
        return this.f35329e;
    }

    public Object a(Object obj) {
        HashMap<Object, Object> hashMap = this.f35336l;
        if (hashMap != null && hashMap.containsKey(obj)) {
            return this.f35336l.get(obj);
        }
        return null;
    }

    public void a(int i11) {
        this.f35334j = i11;
    }

    public void a(CampaignEx campaignEx) {
        this.f35329e = campaignEx;
    }

    public void a(MBridgeIds mBridgeIds) {
        this.f35330f = mBridgeIds;
    }

    public void a(Object obj, Object obj2) {
        if (this.f35336l == null) {
            this.f35336l = new HashMap<>();
        }
        this.f35336l.put(obj, obj2);
    }

    public void a(String str) {
        this.f35340p = str;
    }

    public void a(Throwable th2) {
        this.f35328d = th2;
    }

    public void a(boolean z10) {
        this.f35333i = z10;
    }

    public int b() {
        return this.f35325a;
    }

    public void b(String str) {
        this.f35332h = str;
    }

    public int c() {
        return this.f35326b;
    }

    public void c(String str) {
        this.f35327c = str;
    }

    public String d() {
        return this.f35340p;
    }

    public void d(String str) {
        this.f35335k = str;
    }

    public MBridgeIds e() {
        if (this.f35330f == null) {
            this.f35330f = new MBridgeIds();
        }
        return this.f35330f;
    }

    public String f() {
        return this.f35332h;
    }

    public String g() {
        int i11;
        String str = !TextUtils.isEmpty(this.f35327c) ? this.f35327c : "";
        if (TextUtils.isEmpty(str) && (i11 = this.f35325a) != -1) {
            str = a.a(i11);
        }
        Throwable th2 = this.f35328d;
        if (th2 == null) {
            return str;
        }
        String message = th2.getMessage();
        if (TextUtils.isEmpty(message)) {
            return str;
        }
        return str + " # " + message;
    }

    public String h() {
        return this.f35335k;
    }

    public int i() {
        return this.f35334j;
    }

    public String toString() {
        return "MBFailureReason{errorCode=" + this.f35325a + ", errorSubType=" + this.f35326b + ", message='" + this.f35327c + "', cause=" + this.f35328d + ", campaign=" + this.f35329e + ", ids=" + this.f35330f + ", requestId='" + this.f35331g + "', localRequestId='" + this.f35332h + "', isHeaderBidding=" + this.f35333i + ", typeD=" + this.f35334j + ", reasonD='" + this.f35335k + "', extraMap=" + this.f35336l + ", serverErrorCode=" + this.f35337m + ", errorUrl='" + this.f35338n + "', serverErrorResponse='" + this.f35339o + "'}";
    }
}
