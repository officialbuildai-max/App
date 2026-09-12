package com.iab.omid.library.mmadbridge.walking;

import java.util.HashSet;
import org.json.JSONObject;
import pe.b;
import pe.d;
import pe.e;
import pe.f;

/* loaded from: classes4.dex */
public class b implements b.InterfaceC0911b {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f33817a;

    /* renamed from: b, reason: collision with root package name */
    private final pe.c f33818b;

    public b(pe.c cVar) {
        this.f33818b = cVar;
    }

    @Override // pe.b.InterfaceC0911b
    public JSONObject a() {
        return this.f33817a;
    }

    @Override // pe.b.InterfaceC0911b
    public void a(JSONObject jSONObject) {
        this.f33817a = jSONObject;
    }

    public void b(JSONObject jSONObject, HashSet hashSet, long j11) {
        this.f33818b.c(new e(this, hashSet, jSONObject, j11));
    }

    public void c() {
        this.f33818b.c(new d(this));
    }

    public void d(JSONObject jSONObject, HashSet hashSet, long j11) {
        this.f33818b.c(new f(this, hashSet, jSONObject, j11));
    }
}
