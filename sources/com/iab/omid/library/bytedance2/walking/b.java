package com.iab.omid.library.bytedance2.walking;

import com.iab.omid.library.bytedance2.walking.async.b;
import com.iab.omid.library.bytedance2.walking.async.d;
import com.iab.omid.library.bytedance2.walking.async.e;
import com.iab.omid.library.bytedance2.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b implements b.InterfaceC0459b {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f33583a;

    /* renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.bytedance2.walking.async.c f33584b;

    public b(com.iab.omid.library.bytedance2.walking.async.c cVar) {
        this.f33584b = cVar;
    }

    @Override // com.iab.omid.library.bytedance2.walking.async.b.InterfaceC0459b
    public JSONObject a() {
        return this.f33583a;
    }

    @Override // com.iab.omid.library.bytedance2.walking.async.b.InterfaceC0459b
    public void a(JSONObject jSONObject) {
        this.f33583a = jSONObject;
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j11) {
        this.f33584b.b(new e(this, hashSet, jSONObject, j11));
    }

    public void b() {
        this.f33584b.b(new d(this));
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j11) {
        this.f33584b.b(new f(this, hashSet, jSONObject, j11));
    }
}
