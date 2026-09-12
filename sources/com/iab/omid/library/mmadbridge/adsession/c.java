package com.iab.omid.library.mmadbridge.adsession;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final Owner f33704a;

    /* renamed from: b, reason: collision with root package name */
    private final Owner f33705b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f33706c;

    /* renamed from: d, reason: collision with root package name */
    private final CreativeType f33707d;

    /* renamed from: e, reason: collision with root package name */
    private final ImpressionType f33708e;

    private c(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z10) {
        this.f33707d = creativeType;
        this.f33708e = impressionType;
        this.f33704a = owner;
        if (owner2 == null) {
            this.f33705b = Owner.NONE;
        } else {
            this.f33705b = owner2;
        }
        this.f33706c = z10;
    }

    public static c a(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z10) {
        oe.g.d(creativeType, "CreativeType is null");
        oe.g.d(impressionType, "ImpressionType is null");
        oe.g.d(owner, "Impression owner is null");
        oe.g.b(owner, creativeType, impressionType);
        return new c(creativeType, impressionType, owner, owner2, z10);
    }

    public boolean b() {
        return Owner.NATIVE == this.f33704a;
    }

    public boolean c() {
        return Owner.NATIVE == this.f33705b;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        oe.c.i(jSONObject, "impressionOwner", this.f33704a);
        oe.c.i(jSONObject, "mediaEventsOwner", this.f33705b);
        oe.c.i(jSONObject, "creativeType", this.f33707d);
        oe.c.i(jSONObject, "impressionType", this.f33708e);
        oe.c.i(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.f33706c));
        return jSONObject;
    }
}
