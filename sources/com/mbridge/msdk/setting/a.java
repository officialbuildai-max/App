package com.mbridge.msdk.setting;

import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private String f37263e;

    /* renamed from: f, reason: collision with root package name */
    private String f37264f;

    /* renamed from: g, reason: collision with root package name */
    private int f37265g;

    /* renamed from: a, reason: collision with root package name */
    private int f37259a = 1;

    /* renamed from: b, reason: collision with root package name */
    private int f37260b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f37261c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f37262d = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f37266h = 0;

    public static a a(String str) {
        Exception e11;
        a aVar;
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
            aVar = new a();
        } catch (Exception e12) {
            e11 = e12;
            aVar = null;
        }
        try {
            aVar.b(jSONObject.optString("http_domain", com.mbridge.msdk.foundation.same.net.utils.d.h().f35529h));
            aVar.c(jSONObject.optString("tcp_domain", com.mbridge.msdk.foundation.same.net.utils.d.h().f35533l));
            aVar.e(jSONObject.optInt("tcp_port", com.mbridge.msdk.foundation.same.net.utils.d.h().f35537p));
            aVar.f(jSONObject.optInt(NativeComponentConstants.KEY_COMPONENT_TYPE, 0));
            aVar.a(jSONObject.optInt("batch_size", 1));
            aVar.c(jSONObject.optInt("duration", 0));
            aVar.b(jSONObject.optInt("disable", 0));
            aVar.d(jSONObject.optInt("e_t_l", 0));
        } catch (Exception e13) {
            e11 = e13;
            e11.printStackTrace();
            return aVar;
        }
        return aVar;
    }

    public int a() {
        return this.f37259a;
    }

    public void a(int i11) {
        if (i11 < 1) {
            i11 = 1;
        }
        this.f37259a = i11;
    }

    public int b() {
        return this.f37260b;
    }

    public void b(int i11) {
        this.f37260b = i11;
    }

    public void b(String str) {
        this.f37263e = str;
    }

    public int c() {
        return this.f37261c;
    }

    public void c(int i11) {
        this.f37261c = i11;
    }

    public void c(String str) {
        this.f37264f = str;
    }

    public int d() {
        return this.f37262d;
    }

    public void d(int i11) {
        this.f37262d = i11;
    }

    public String e() {
        return this.f37263e;
    }

    public void e(int i11) {
        this.f37265g = i11;
    }

    public String f() {
        return this.f37264f;
    }

    public void f(int i11) {
        this.f37266h = i11;
    }

    public int g() {
        return this.f37265g;
    }

    public int h() {
        return this.f37266h;
    }
}
