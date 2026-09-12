package com.iab.omid.library.mmadbridge.adsession.media;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import oe.d;
import oe.g;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f33734a;

    /* renamed from: b, reason: collision with root package name */
    private final Float f33735b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f33736c;

    /* renamed from: d, reason: collision with root package name */
    private final Position f33737d;

    private b(boolean z10, Float f11, boolean z11, Position position) {
        this.f33734a = z10;
        this.f33735b = f11;
        this.f33736c = z11;
        this.f33737d = position;
    }

    public static b b(boolean z10, Position position) {
        g.d(position, "Position is null");
        return new b(false, null, z10, position);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f33734a);
            if (this.f33734a) {
                jSONObject.put("skipOffset", this.f33735b);
            }
            jSONObject.put("autoPlay", this.f33736c);
            jSONObject.put(RequestParameters.POSITION, this.f33737d);
        } catch (JSONException e11) {
            d.b("VastProperties: JSON error", e11);
        }
        return jSONObject;
    }
}
