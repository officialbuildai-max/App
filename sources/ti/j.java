package ti;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f76384a = new j();

    private j() {
    }

    private final void a(JSONArray jSONArray) {
        int length = jSONArray.length();
        for (int i11 = 0; i11 < length; i11++) {
            Object opt = jSONArray.opt(i11);
            if (opt instanceof String) {
                String str = (String) opt;
                if (e(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    b(jSONObject);
                    jSONArray.put(i11, jSONObject);
                } else if (d(str)) {
                    JSONArray jSONArray2 = new JSONArray(str);
                    a(jSONArray2);
                    jSONArray.put(i11, jSONArray2);
                }
            } else if (opt instanceof JSONObject) {
                b((JSONObject) opt);
            } else if (opt instanceof JSONArray) {
                a((JSONArray) opt);
            }
        }
    }

    private final void b(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt instanceof String) {
                String str = (String) opt;
                if (e(str)) {
                    JSONObject jSONObject2 = new JSONObject(str);
                    b(jSONObject2);
                    jSONObject.put(next, jSONObject2);
                } else if (d(str)) {
                    JSONArray jSONArray = new JSONArray(str);
                    a(jSONArray);
                    jSONObject.put(next, jSONArray);
                }
            } else if (opt instanceof JSONObject) {
                b((JSONObject) opt);
            } else if (opt instanceof JSONArray) {
                a((JSONArray) opt);
            }
        }
    }

    private final boolean d(String str) {
        try {
            new JSONArray(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private final boolean e(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final String c(String jsonString, int i11) {
        String str;
        Intrinsics.h(jsonString, "jsonString");
        try {
            if (StringsKt.W(StringsKt.n1(jsonString).toString(), "{", false, 2, null)) {
                JSONObject jSONObject = new JSONObject(jsonString);
                b(jSONObject);
                str = jSONObject.toString(i11);
            } else if (StringsKt.W(StringsKt.n1(jsonString).toString(), "[", false, 2, null)) {
                JSONArray jSONArray = new JSONArray(jsonString);
                a(jSONArray);
                str = jSONArray.toString(i11);
            } else {
                str = jsonString;
            }
            Intrinsics.e(str);
            return str;
        } catch (JSONException unused) {
            return jsonString;
        }
    }
}
