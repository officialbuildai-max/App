package com.iab.omid.library.bytedance2.adsession.media;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.iab.omid.library.bytedance2.utils.d;
import com.iab.omid.library.bytedance2.utils.g;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class VastProperties {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f33472a;

    /* renamed from: b, reason: collision with root package name */
    private final Float f33473b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f33474c;

    /* renamed from: d, reason: collision with root package name */
    private final Position f33475d;

    private VastProperties(boolean z10, Float f11, boolean z11, Position position) {
        this.f33472a = z10;
        this.f33473b = f11;
        this.f33474c = z11;
        this.f33475d = position;
    }

    public static VastProperties createVastPropertiesForNonSkippableMedia(boolean z10, Position position) {
        g.a(position, "Position is null");
        return new VastProperties(false, null, z10, position);
    }

    public static VastProperties createVastPropertiesForSkippableMedia(float f11, boolean z10, Position position) {
        g.a(position, "Position is null");
        return new VastProperties(true, Float.valueOf(f11), z10, position);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f33472a);
            if (this.f33472a) {
                jSONObject.put("skipOffset", this.f33473b);
            }
            jSONObject.put("autoPlay", this.f33474c);
            jSONObject.put(RequestParameters.POSITION, this.f33475d);
        } catch (JSONException e11) {
            d.a("VastProperties: JSON error", e11);
        }
        return jSONObject;
    }

    public Position getPosition() {
        return this.f33475d;
    }

    public Float getSkipOffset() {
        return this.f33473b;
    }

    public boolean isAutoPlay() {
        return this.f33474c;
    }

    public boolean isSkippable() {
        return this.f33472a;
    }
}
