package com.android.volley.toolbox;

import com.android.volley.ParseError;
import com.android.volley.i;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class j extends k {
    public j(int i11, String str, JSONObject jSONObject, i.b bVar, i.a aVar) {
        super(i11, str, jSONObject != null ? jSONObject.toString() : null, bVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public com.android.volley.i parseNetworkResponse(com.android.volley.g gVar) {
        try {
            return com.android.volley.i.c(new JSONObject(new String(gVar.f19317b, d.f(gVar.f19318c, "utf-8"))), d.e(gVar));
        } catch (UnsupportedEncodingException e11) {
            return com.android.volley.i.a(new ParseError(e11));
        } catch (JSONException e12) {
            return com.android.volley.i.a(new ParseError(e12));
        }
    }
}
