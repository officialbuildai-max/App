package com.iab.omid.library.vungle.adsession;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final Owner f33824a;

    /* renamed from: b, reason: collision with root package name */
    private final Owner f33825b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f33826c;

    /* renamed from: d, reason: collision with root package name */
    private final CreativeType f33827d;

    /* renamed from: e, reason: collision with root package name */
    private final ImpressionType f33828e;

    private c(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z10) {
        this.f33827d = creativeType;
        this.f33828e = impressionType;
        this.f33824a = owner;
        if (owner2 == null) {
            this.f33825b = Owner.NONE;
        } else {
            this.f33825b = owner2;
        }
        this.f33826c = z10;
    }

    public static c a(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z10) {
        ue.g.d(creativeType, "CreativeType is null");
        ue.g.d(impressionType, "ImpressionType is null");
        ue.g.d(owner, "Impression owner is null");
        ue.g.b(owner, creativeType, impressionType);
        return new c(creativeType, impressionType, owner, owner2, z10);
    }

    public boolean b() {
        return Owner.NATIVE == this.f33824a;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        ue.c.i(jSONObject, "impressionOwner", this.f33824a);
        ue.c.i(jSONObject, "mediaEventsOwner", this.f33825b);
        ue.c.i(jSONObject, "creativeType", this.f33827d);
        ue.c.i(jSONObject, "impressionType", this.f33828e);
        ue.c.i(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.f33826c));
        return jSONObject;
    }
}
