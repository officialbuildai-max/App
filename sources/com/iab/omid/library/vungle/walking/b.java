package com.iab.omid.library.vungle.walking;

import java.util.HashSet;
import org.json.JSONObject;
import ve.b;
import ve.d;
import ve.e;
import ve.f;

/* loaded from: classes4.dex */
public class b implements b.InterfaceC0975b {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f33925a;

    /* renamed from: b, reason: collision with root package name */
    private final ve.c f33926b;

    public b(ve.c cVar) {
        this.f33926b = cVar;
    }

    @Override // ve.b.InterfaceC0975b
    public JSONObject a() {
        return this.f33925a;
    }

    @Override // ve.b.InterfaceC0975b
    public void a(JSONObject jSONObject) {
        this.f33925a = jSONObject;
    }

    public void b(JSONObject jSONObject, HashSet hashSet, long j11) {
        this.f33926b.c(new e(this, hashSet, jSONObject, j11));
    }

    public void c() {
        this.f33926b.c(new d(this));
    }

    public void d(JSONObject jSONObject, HashSet hashSet, long j11) {
        this.f33926b.c(new f(this, hashSet, jSONObject, j11));
    }
}
