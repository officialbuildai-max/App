package com.mbridge.msdk.foundation.same.net.wrapper;

import android.text.TextUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.foundation.tools.o0;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    private static final String f35550c = "e";

    /* renamed from: d, reason: collision with root package name */
    public static String f35551d = "h";

    /* renamed from: e, reason: collision with root package name */
    public static String f35552e = "i";

    /* renamed from: f, reason: collision with root package name */
    public static String f35553f = "coppa";

    /* renamed from: g, reason: collision with root package name */
    public static String f35554g = "d";

    /* renamed from: h, reason: collision with root package name */
    public static String f35555h = "e";

    /* renamed from: i, reason: collision with root package name */
    public static String f35556i = "a";

    /* renamed from: j, reason: collision with root package name */
    public static String f35557j = "f";

    /* renamed from: k, reason: collision with root package name */
    public static String f35558k = "g";

    /* renamed from: a, reason: collision with root package name */
    private Map<String, com.mbridge.msdk.foundation.same.net.model.a> f35559a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f35560b = new LinkedHashMap();

    public Map<String, String> a() {
        return this.f35560b;
    }

    public void a(String str) {
        this.f35560b.remove(str);
        this.f35559a.remove(str);
    }

    public void a(String str, String str2) {
        if (str2 == null) {
            o0.b(f35550c, "add() value is null!");
        }
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.f35560b.put(str, str2);
    }

    public String b() {
        StringBuilder sb2 = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : this.f35560b.entrySet()) {
                if (sb2.length() > 0) {
                    sb2.append('&');
                }
                sb2.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb2.append(UrlUtils.EQUAL_MARK);
                sb2.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return sb2.toString();
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.f35560b.entrySet()) {
                jSONObject.put(URLEncoder.encode(entry.getKey(), "UTF-8"), URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
            for (Map.Entry<String, com.mbridge.msdk.foundation.same.net.model.a> entry2 : this.f35559a.entrySet()) {
                jSONObject.put(URLEncoder.encode(entry2.getKey(), "UTF-8"), URLEncoder.encode("FILE_NAME_" + entry2.getValue().a().getName(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException unused) {
        } catch (JSONException e11) {
            o0.b(f35550c, e11.getMessage());
        }
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(28);
        try {
            for (Map.Entry<String, String> entry : this.f35560b.entrySet()) {
                if (sb2.length() > 0) {
                    sb2.append('&');
                }
                sb2.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb2.append('=');
                sb2.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
            for (Map.Entry<String, com.mbridge.msdk.foundation.same.net.model.a> entry2 : this.f35559a.entrySet()) {
                if (sb2.length() > 0) {
                    sb2.append('&');
                }
                sb2.append(URLEncoder.encode(entry2.getKey(), "UTF-8"));
                sb2.append('=');
                sb2.append(URLEncoder.encode("FILE_NAME_" + entry2.getValue().a().getName(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e11) {
            o0.b(f35550c, e11.getMessage());
        }
        return sb2.toString();
    }
}
