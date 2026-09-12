package com.iab.omid.library.hisavana.adsession;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final Owner f33590a;

    /* renamed from: b, reason: collision with root package name */
    private final Owner f33591b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f33592c;

    /* renamed from: d, reason: collision with root package name */
    private final CreativeType f33593d;

    /* renamed from: e, reason: collision with root package name */
    private final ImpressionType f33594e;

    private c(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z10) {
        this.f33593d = creativeType;
        this.f33594e = impressionType;
        this.f33590a = owner;
        if (owner2 == null) {
            this.f33591b = Owner.NONE;
        } else {
            this.f33591b = owner2;
        }
        this.f33592c = z10;
    }

    public static c a(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z10) {
        ie.g.d(creativeType, "CreativeType is null");
        ie.g.d(impressionType, "ImpressionType is null");
        ie.g.d(owner, "Impression owner is null");
        ie.g.b(owner, creativeType, impressionType);
        return new c(creativeType, impressionType, owner, owner2, z10);
    }

    public boolean b() {
        return Owner.NATIVE == this.f33590a;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        ie.c.i(jSONObject, "impressionOwner", this.f33590a);
        ie.c.i(jSONObject, "mediaEventsOwner", this.f33591b);
        ie.c.i(jSONObject, "creativeType", this.f33593d);
        ie.c.i(jSONObject, "impressionType", this.f33594e);
        ie.c.i(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.f33592c));
        return jSONObject;
    }
}
