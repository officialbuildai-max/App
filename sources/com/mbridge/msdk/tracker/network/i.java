package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.tracker.network.v;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class i extends h<JSONObject> implements v.a {
    private final j<JSONObject> C;

    public i(int i11, String str, String str2, long j11, j<JSONObject> jVar) {
        super(i11, str, 0, str2, j11);
        this.C = jVar;
        a((v.a) this);
    }

    private void a(v<JSONObject> vVar, q qVar) {
        j<JSONObject> jVar = this.C;
        if (jVar != null) {
            try {
                jVar.a(this, vVar, qVar);
            } catch (Exception e11) {
                o0.b(h.B, e11.getMessage());
            }
        }
    }

    private void b(v<JSONObject> vVar) {
        j<JSONObject> jVar = this.C;
        if (jVar != null) {
            try {
                jVar.b(this, vVar, vVar.f38747c.f38614a);
            } catch (Exception e11) {
                o0.b(h.B, e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.tracker.network.t
    public v<JSONObject> a(q qVar) {
        try {
            String str = new String(qVar.f38670b, StandardCharsets.UTF_8);
            if (qVar.f38669a == 204) {
                v<JSONObject> a11 = v.a(new JSONObject(), com.mbridge.msdk.tracker.network.toolbox.f.a(qVar));
                a(a11, qVar);
                return a11;
            }
            v<JSONObject> a12 = v.a(new JSONObject(str), com.mbridge.msdk.tracker.network.toolbox.f.a(qVar));
            a(a12, qVar);
            return a12;
        } catch (JSONException e11) {
            o0.b(h.B, e11.getMessage());
            v<JSONObject> a13 = v.a(new s(e11));
            b(a13);
            return a13;
        } catch (Throwable th2) {
            v<JSONObject> a14 = v.a(new a0(th2));
            b(a14);
            return a14;
        }
    }

    @Override // com.mbridge.msdk.tracker.network.v.a
    public void a(b0 b0Var) {
        b(v.a(b0Var));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.tracker.network.t
    public void a(JSONObject jSONObject) {
    }
}
