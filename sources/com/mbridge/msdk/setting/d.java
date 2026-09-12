package com.mbridge.msdk.setting;

import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: f, reason: collision with root package name */
    private String f37363f;

    /* renamed from: g, reason: collision with root package name */
    private String f37364g;

    /* renamed from: h, reason: collision with root package name */
    private int f37365h;

    /* renamed from: a, reason: collision with root package name */
    private int f37358a = 1;

    /* renamed from: b, reason: collision with root package name */
    private int f37359b = 1;

    /* renamed from: c, reason: collision with root package name */
    private int f37360c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f37361d = 30;

    /* renamed from: e, reason: collision with root package name */
    private int f37362e = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f37366i = 0;

    public static d a(String str) {
        Exception e11;
        d dVar;
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
            dVar = new d();
        } catch (Exception e12) {
            e11 = e12;
            dVar = null;
        }
        try {
            dVar.b(jSONObject.optString("h_d", com.mbridge.msdk.foundation.same.net.utils.d.h().f35526f));
            dVar.c(jSONObject.optString("t_d", com.mbridge.msdk.foundation.same.net.utils.d.h().f35532k));
            dVar.c(jSONObject.optInt("t_p", com.mbridge.msdk.foundation.same.net.utils.d.h().f35536o));
            dVar.d(jSONObject.optInt(NativeComponentConstants.KEY_COMPONENT_TYPE, 1));
            dVar.b(jSONObject.optInt("d_t", 30));
            dVar.a(jSONObject.optInt("d_a", 0));
        } catch (Exception e13) {
            e11 = e13;
            e11.printStackTrace();
            return dVar;
        }
        return dVar;
    }

    public int a() {
        return this.f37360c;
    }

    public void a(int i11) {
        this.f37360c = i11;
    }

    public int b() {
        return this.f37361d;
    }

    public void b(int i11) {
        this.f37361d = i11;
    }

    public void b(String str) {
        this.f37363f = str;
    }

    public String c() {
        return this.f37363f;
    }

    public void c(int i11) {
        this.f37365h = i11;
    }

    public void c(String str) {
        this.f37364g = str;
    }

    public String d() {
        return this.f37364g;
    }

    public void d(int i11) {
        this.f37366i = i11;
    }

    public int e() {
        return this.f37365h;
    }
}
