package com.iab.omid.library.mmadbridge.adsession;

import java.net.URL;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final String f33720a;

    /* renamed from: b, reason: collision with root package name */
    private final URL f33721b;

    /* renamed from: c, reason: collision with root package name */
    private final String f33722c;

    private g(String str, URL url, String str2) {
        this.f33720a = str;
        this.f33721b = url;
        this.f33722c = str2;
    }

    public static g a(String str, URL url, String str2) {
        oe.g.f(str, "VendorKey is null or empty");
        oe.g.d(url, "ResourceURL is null");
        oe.g.f(str2, "VerificationParameters is null or empty");
        return new g(str, url, str2);
    }

    public static g b(URL url) {
        oe.g.d(url, "ResourceURL is null");
        return new g(null, url, null);
    }

    public URL c() {
        return this.f33721b;
    }

    public String d() {
        return this.f33720a;
    }

    public String e() {
        return this.f33722c;
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        oe.c.i(jSONObject, "vendorKey", this.f33720a);
        oe.c.i(jSONObject, "resourceUrl", this.f33721b.toString());
        oe.c.i(jSONObject, "verificationParameters", this.f33722c);
        return jSONObject;
    }
}
