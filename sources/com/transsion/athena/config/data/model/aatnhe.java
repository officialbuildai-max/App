package com.transsion.athena.config.data.model;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.transsion.ga.AthenaAnalytics;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class aatnhe {

    /* renamed from: a, reason: collision with root package name */
    private int f42624a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f42625b = 100;

    /* renamed from: c, reason: collision with root package name */
    private int f42626c = 1;

    /* renamed from: d, reason: collision with root package name */
    private long f42627d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f42628e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f42629f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f42630g = 100;

    /* renamed from: h, reason: collision with root package name */
    private int f42631h = 1;

    /* renamed from: i, reason: collision with root package name */
    private long f42632i = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f42633j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f42634k = 0;

    /* renamed from: l, reason: collision with root package name */
    private long f42635l = 30000;

    /* renamed from: m, reason: collision with root package name */
    private long f42636m;

    /* renamed from: n, reason: collision with root package name */
    private int f42637n;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static aatnhe a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            aatnhe aatnheVar = new aatnhe();
            aatnheVar.f42634k = jSONObject.getInt("ci");
            aatnheVar.f42630g = jSONObject.getInt("gmax");
            aatnheVar.f42629f = jSONObject.getInt("gmin");
            aatnheVar.f42633j = jSONObject.getInt("mi");
            aatnheVar.f42628e = jSONObject.getInt("nf");
            aatnheVar.f42627d = jSONObject.getLong("pd");
            aatnheVar.f42632i = jSONObject.getLong("pt");
            aatnheVar.f42635l = jSONObject.getLong("se");
            aatnheVar.f42625b = jSONObject.getInt("urhash");
            aatnheVar.f42637n = jSONObject.optInt("pr");
            aatnheVar.f42626c = jSONObject.optInt("upct");
            aatnheVar.f42631h = jSONObject.optInt("gpct");
            return aatnheVar;
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            return null;
        }
    }

    public int a() {
        return this.f42634k;
    }

    public void a(int i11) {
        this.f42634k = i11;
    }

    public void a(long j11) {
        this.f42636m = j11;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f42630g = jSONObject.getInt("gmax");
            this.f42629f = jSONObject.getInt("gmin");
            this.f42633j = jSONObject.getInt("mi");
            this.f42628e = jSONObject.getInt("nf");
            this.f42627d = jSONObject.getLong("pd");
            this.f42635l = jSONObject.getLong("se");
            this.f42625b = jSONObject.getInt("urhash");
            this.f42636m = jSONObject.getInt("frq");
            this.f42624a = jSONObject.optInt("ct", 0);
            this.f42637n = jSONObject.optInt("pr", 0);
            this.f42626c = jSONObject.optInt("upct", 1);
            this.f42631h = jSONObject.optInt("gpct", 1);
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
        }
    }

    public long b() {
        return this.f42636m;
    }

    public void b(int i11) {
        this.f42630g = i11;
    }

    public void b(long j11) {
        this.f42627d = j11;
    }

    public int c() {
        return this.f42630g;
    }

    public void c(int i11) {
        this.f42629f = i11;
    }

    public void c(long j11) {
        this.f42632i = j11;
    }

    public int d() {
        return this.f42629f;
    }

    public void d(int i11) {
        this.f42631h = i11;
    }

    public void d(long j11) {
        this.f42635l = j11;
    }

    public int e() {
        return this.f42631h;
    }

    public void e(int i11) {
        this.f42633j = i11;
    }

    public int f() {
        return this.f42633j;
    }

    public void f(int i11) {
        this.f42628e = i11;
    }

    public int g() {
        return this.f42628e;
    }

    public void g(int i11) {
        this.f42637n = i11;
    }

    public int h() {
        return this.f42637n;
    }

    public void h(int i11) {
        this.f42624a = i11;
    }

    public long i() {
        long j11 = this.f42627d;
        try {
            if (!ehanat.v()) {
                return j11;
            }
            return anehat.a(AthenaAnalytics.J(), "debug.athena.push_during", this.f42627d).longValue();
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b("SystemPropertiesProxy.getLong " + e11.getMessage());
            return j11;
        }
    }

    public void i(int i11) {
        this.f42626c = i11;
    }

    public long j() {
        return this.f42632i;
    }

    public void j(int i11) {
        this.f42625b = i11;
    }

    public long k() {
        return this.f42635l;
    }

    public int l() {
        return this.f42626c;
    }

    public int m() {
        return this.f42625b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject n() {
        try {
            return new JSONObject().put("ci", this.f42634k).put("gmax", this.f42630g).put("gmin", this.f42629f).put("mi", this.f42633j).put("nf", this.f42628e).put("pd", i()).put("pt", this.f42632i).put("se", this.f42635l).put("urhash", this.f42625b).put("frq", this.f42636m).put("ct", this.f42624a).put("pr", this.f42637n).put("upct", this.f42626c).put("gpct", this.f42631h);
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            return null;
        }
    }

    public String o() {
        try {
            return new JSONObject().put("gmax", this.f42630g).put("gmin", this.f42629f).put("mi", this.f42633j).put("nf", this.f42628e).put("pd", i()).put("se", this.f42635l).put("urhash", this.f42625b).put("frq", this.f42636m).put("ct", this.f42624a).put("pr", this.f42637n).put("upct", this.f42626c).put("gpct", this.f42631h).toString();
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            return null;
        }
    }

    @NonNull
    public String toString() {
        return "TidConfig { pushTime=" + this.f42632i + ", pushDuration=" + this.f42627d + ", maxCachedItems=" + this.f42633j + ", cachedItems=" + this.f42634k + ", netWorkFlag=" + this.f42628e + '}';
    }
}
