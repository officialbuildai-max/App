package zc;

import android.util.Log;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.internal.f;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    com.google.firebase.remoteconfig.internal.e f79522a;

    /* renamed from: b, reason: collision with root package name */
    com.google.firebase.remoteconfig.internal.e f79523b;

    a(com.google.firebase.remoteconfig.internal.e eVar, com.google.firebase.remoteconfig.internal.e eVar2) {
        this.f79522a = eVar;
        this.f79523b = eVar2;
    }

    public static a a(com.google.firebase.remoteconfig.internal.e eVar, com.google.firebase.remoteconfig.internal.e eVar2) {
        return new a(eVar, eVar2);
    }

    private String c(String str) {
        String d11 = d(this.f79522a, str);
        if (d11 != null) {
            return d11;
        }
        String d12 = d(this.f79523b, str);
        return d12 != null ? d12 : "";
    }

    private static String d(com.google.firebase.remoteconfig.internal.e eVar, String str) {
        f f11 = eVar.f();
        if (f11 == null) {
            return null;
        }
        try {
            return f11.g().getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd.e b(f fVar) {
        JSONArray j11 = fVar.j();
        long k11 = fVar.k();
        HashSet hashSet = new HashSet();
        for (int i11 = 0; i11 < j11.length(); i11++) {
            try {
                JSONObject jSONObject = j11.getJSONObject(i11);
                String string = jSONObject.getString("rolloutId");
                JSONArray jSONArray = jSONObject.getJSONArray("affectedParameterKeys");
                if (jSONArray.length() > 1) {
                    Log.w("FirebaseRemoteConfig", String.format("Rollout has multiple affected parameter keys.Only the first key will be included in RolloutsState. rolloutId: %s, affectedParameterKeys: %s", string, jSONArray));
                }
                String optString = jSONArray.optString(0, "");
                hashSet.add(bd.d.a().d(string).f(jSONObject.getString("variantId")).b(optString).c(c(optString)).e(k11).a());
            } catch (JSONException e11) {
                throw new FirebaseRemoteConfigClientException("Exception parsing rollouts metadata to create RolloutsState.", e11);
            }
        }
        return bd.e.a(hashSet);
    }
}
