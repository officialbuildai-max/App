package com.google.firebase.remoteconfig.internal;

import android.os.Bundle;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private final ic.b f32627a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f32628b = Collections.synchronizedMap(new HashMap());

    public u(ic.b bVar) {
        this.f32627a = bVar;
    }

    public void a(String str, f fVar) {
        JSONObject optJSONObject;
        kb.a aVar = (kb.a) this.f32627a.get();
        if (aVar == null) {
            return;
        }
        JSONObject i11 = fVar.i();
        if (i11.length() < 1) {
            return;
        }
        JSONObject g11 = fVar.g();
        if (g11.length() >= 1 && (optJSONObject = i11.optJSONObject(str)) != null) {
            String optString = optJSONObject.optString("choiceId");
            if (optString.isEmpty()) {
                return;
            }
            synchronized (this.f32628b) {
                try {
                    if (optString.equals(this.f32628b.get(str))) {
                        return;
                    }
                    this.f32628b.put(str, optString);
                    Bundle bundle = new Bundle();
                    bundle.putString("arm_key", str);
                    bundle.putString("arm_value", g11.optString(str));
                    bundle.putString("personalization_id", optJSONObject.optString("personalizationId"));
                    bundle.putInt("arm_index", optJSONObject.optInt("armIndex", -1));
                    bundle.putString("group", optJSONObject.optString("group"));
                    aVar.b("fp", "personalization_assignment", bundle);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_fpid", optString);
                    aVar.b("fp", "_fpc", bundle2);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }
}
