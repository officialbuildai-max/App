package pb;

import android.os.Bundle;
import ob.g;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class d implements b, qb.b {

    /* renamed from: a, reason: collision with root package name */
    private qb.a f72528a;

    private static String b(String str, Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put("name", str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    @Override // qb.b
    public void a(qb.a aVar) {
        this.f72528a = aVar;
        g.f().b("Registered Firebase Analytics event receiver for breadcrumbs");
    }

    @Override // pb.b
    public void c(String str, Bundle bundle) {
        qb.a aVar = this.f72528a;
        if (aVar != null) {
            try {
                aVar.a("$A$:" + b(str, bundle));
            } catch (JSONException unused) {
                g.f().k("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }
}
