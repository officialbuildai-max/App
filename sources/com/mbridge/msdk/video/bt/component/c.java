package com.mbridge.msdk.video.bt.component;

import android.text.TextUtils;
import android.util.Base64;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f38858a;

    /* renamed from: b, reason: collision with root package name */
    int f38859b;

    /* renamed from: c, reason: collision with root package name */
    int f38860c;

    /* loaded from: classes5.dex */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static c f38861a = new c();
    }

    private c() {
        this.f38858a = "handlerNativeResult";
        this.f38859b = 0;
        this.f38860c = 1;
    }

    public static c a() {
        return b.f38861a;
    }

    public void a(int i11, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i11);
            jSONObject.put("message", str);
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e11) {
            o0.a("HandlerH5MessageManager", e11.getMessage());
        } catch (Throwable th2) {
            o0.a("HandlerH5MessageManager", th2.getMessage());
        }
    }

    public void a(Object obj, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    String optString = jSONObject.optString("uniqueIdentifier");
                    String optString2 = jSONObject.optString("name");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("parameters");
                        JSONObject optJSONObject = jSONObject.optJSONObject("result");
                        int i11 = 0;
                        if (optJSONObject != null && !TextUtils.isEmpty(optJSONObject.toString())) {
                            i11 = optJSONObject.optInt(NativeComponentConstants.KEY_COMPONENT_TYPE, 0);
                        }
                        a(this.f38859b, "receivedMessage", obj);
                        if (optString.equalsIgnoreCase("reporter")) {
                            com.mbridge.msdk.mbsignalcommon.Report.a.a().a(obj, optString2, optJSONArray, i11);
                            return;
                        } else {
                            if (optString.equalsIgnoreCase("MediaPlayer")) {
                                com.mbridge.msdk.video.bt.component.b.a().a(obj, optString2, optJSONArray, i11);
                                return;
                            }
                            return;
                        }
                    }
                    a(this.f38860c, "module or method is null", obj);
                    return;
                }
            } catch (Exception e11) {
                o0.a("HandlerH5MessageManager", e11.getMessage());
                a(this.f38860c, e11.getMessage(), obj);
                return;
            } catch (Throwable th2) {
                o0.a("HandlerH5MessageManager", th2.getMessage());
                a(this.f38860c, th2.getMessage(), obj);
                return;
            }
        }
        a(this.f38860c, "params is null", obj);
    }
}
