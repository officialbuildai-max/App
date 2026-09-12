package com.mbridge.msdk.foundation.same.net.wrapper;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.tools.o0;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public abstract class d extends com.mbridge.msdk.foundation.same.net.c<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35549a = "d";

    private void a(com.mbridge.msdk.foundation.same.net.e<JSONObject> eVar) {
        if (eVar.f35481b.f35506d == 204) {
            a(new JSONObject());
        } else {
            b(eVar);
        }
    }

    private void b(com.mbridge.msdk.foundation.same.net.e<JSONObject> eVar) {
        JSONObject jSONObject = eVar.f35482c;
        if (jSONObject == null) {
            a("response result is null");
            return;
        }
        int optInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, -9999);
        if (optInt == -9999) {
            a(eVar.f35482c);
            return;
        }
        if (optInt == 1 || optInt == 200) {
            a(eVar.f35482c.optJSONObject("data"));
            return;
        }
        String optString = eVar.f35482c.optString(NotificationCompat.CATEGORY_MESSAGE);
        if (TextUtils.isEmpty(optString)) {
            optString = "error message is null";
        }
        a(optString);
    }

    public abstract void a(String str);

    public abstract void a(JSONObject jSONObject);

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onError(com.mbridge.msdk.foundation.same.net.exception.a aVar) {
        o0.b(f35549a, "errorCode = " + aVar.f35483a);
        a(com.mbridge.msdk.foundation.same.net.utils.a.a(aVar));
    }

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onSuccess(com.mbridge.msdk.foundation.same.net.e<JSONObject> eVar) {
        if (eVar == null) {
            a("response is null");
            return;
        }
        super.onSuccess(eVar);
        if (eVar.f35481b == null) {
            b(eVar);
        } else {
            a(eVar);
        }
    }
}
