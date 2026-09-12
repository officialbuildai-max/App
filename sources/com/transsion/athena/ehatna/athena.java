package com.transsion.athena.ehatna;

import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class athena implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public long f42767a;

    /* renamed from: b, reason: collision with root package name */
    public long f42768b;

    /* renamed from: c, reason: collision with root package name */
    public String f42769c;

    public athena(long j11, long j12, String str) {
        this.f42767a = j11;
        this.f42768b = j12;
        this.f42769c = str;
    }

    public athena(String str) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        this.f42767a = jSONObject.getLong("serverTime");
        this.f42768b = jSONObject.getLong("elapsedRealtime");
        this.f42769c = jSONObject.getString("bootId");
    }
}
