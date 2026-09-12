package com.mbridge.msdk.tracker;

import java.io.Serializable;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class e implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private String f38555a;

    /* renamed from: d, reason: collision with root package name */
    private JSONObject f38558d;

    /* renamed from: i, reason: collision with root package name */
    private h f38563i;

    /* renamed from: b, reason: collision with root package name */
    private int f38556b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f38557c = 0;

    /* renamed from: g, reason: collision with root package name */
    private long f38561g = 0;

    /* renamed from: h, reason: collision with root package name */
    private long f38562h = 604800000;

    /* renamed from: j, reason: collision with root package name */
    private boolean f38564j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f38565k = false;

    /* renamed from: f, reason: collision with root package name */
    private long f38560f = System.currentTimeMillis();

    /* renamed from: e, reason: collision with root package name */
    private String f38559e = UUID.randomUUID().toString();

    public e(String str) {
        this.f38555a = str;
    }

    public long a() {
        return this.f38561g;
    }

    public void a(int i11) {
        this.f38557c = i11;
    }

    public void a(long j11) {
        this.f38561g = j11;
    }

    public void a(h hVar) {
        this.f38563i = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        this.f38559e = str;
    }

    public void a(JSONObject jSONObject) {
        this.f38558d = jSONObject;
    }

    public void a(boolean z10) {
        this.f38565k = z10;
    }

    public String b() {
        return this.f38555a;
    }

    public void b(int i11) {
        this.f38556b = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(long j11) {
        this.f38562h = j11;
    }

    public int c() {
        return this.f38557c;
    }

    public void c(long j11) {
        this.f38560f = j11;
    }

    public JSONObject d() {
        JSONObject jSONObject = this.f38558d;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        this.f38558d = jSONObject2;
        return jSONObject2;
    }

    public h e() {
        return this.f38563i;
    }

    public long f() {
        return this.f38562h;
    }

    public long g() {
        return this.f38560f;
    }

    public int h() {
        return this.f38556b;
    }

    public String i() {
        return this.f38559e;
    }

    public boolean j() {
        return this.f38565k;
    }

    public boolean k() {
        return this.f38564j;
    }
}
