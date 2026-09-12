package com.iab.omid.library.hisavana.walking;

import java.util.HashSet;
import je.b;
import je.d;
import je.e;
import je.f;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b implements b.InterfaceC0828b {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f33697a;

    /* renamed from: b, reason: collision with root package name */
    private final je.c f33698b;

    public b(je.c cVar) {
        this.f33698b = cVar;
    }

    @Override // je.b.InterfaceC0828b
    public JSONObject a() {
        return this.f33697a;
    }

    @Override // je.b.InterfaceC0828b
    public void a(JSONObject jSONObject) {
        this.f33697a = jSONObject;
    }

    public void b(JSONObject jSONObject, HashSet hashSet, long j11) {
        this.f33698b.c(new e(this, hashSet, jSONObject, j11));
    }

    public void c() {
        this.f33698b.c(new d(this));
    }

    public void d(JSONObject jSONObject, HashSet hashSet, long j11) {
        this.f33698b.c(new f(this, hashSet, jSONObject, j11));
    }
}
