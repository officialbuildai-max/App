package com.iab.omid.library.hisavana.adsession;

import java.net.URL;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final String f33606a;

    /* renamed from: b, reason: collision with root package name */
    private final URL f33607b;

    /* renamed from: c, reason: collision with root package name */
    private final String f33608c;

    private g(String str, URL url, String str2) {
        this.f33606a = str;
        this.f33607b = url;
        this.f33608c = str2;
    }

    public static g a(String str, URL url, String str2) {
        ie.g.f(str, "VendorKey is null or empty");
        ie.g.d(url, "ResourceURL is null");
        ie.g.f(str2, "VerificationParameters is null or empty");
        return new g(str, url, str2);
    }

    public static g b(URL url) {
        ie.g.d(url, "ResourceURL is null");
        return new g(null, url, null);
    }

    public URL c() {
        return this.f33607b;
    }

    public String d() {
        return this.f33606a;
    }

    public String e() {
        return this.f33608c;
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        ie.c.i(jSONObject, "vendorKey", this.f33606a);
        ie.c.i(jSONObject, "resourceUrl", this.f33607b.toString());
        ie.c.i(jSONObject, "verificationParameters", this.f33608c);
        return jSONObject;
    }
}
