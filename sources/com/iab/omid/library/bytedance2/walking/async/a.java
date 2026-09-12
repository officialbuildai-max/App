package com.iab.omid.library.bytedance2.walking.async;

import com.iab.omid.library.bytedance2.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class a extends b {

    /* renamed from: c, reason: collision with root package name */
    protected final HashSet<String> f33574c;

    /* renamed from: d, reason: collision with root package name */
    protected final JSONObject f33575d;

    /* renamed from: e, reason: collision with root package name */
    protected final long f33576e;

    public a(b.InterfaceC0459b interfaceC0459b, HashSet<String> hashSet, JSONObject jSONObject, long j11) {
        super(interfaceC0459b);
        this.f33574c = new HashSet<>(hashSet);
        this.f33575d = jSONObject;
        this.f33576e = j11;
    }
}
