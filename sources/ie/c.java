package ie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import com.iab.omid.library.hisavana.adsession.OutputDeviceStatus;
import com.iab.omid.library.hisavana.walking.a;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static WindowManager f65329a;

    /* renamed from: b, reason: collision with root package name */
    private static String[] f65330b = {"x", "y", "width", "height"};

    /* renamed from: c, reason: collision with root package name */
    static float f65331c = Resources.getSystem().getDisplayMetrics().density;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f65332a;

        static {
            int[] iArr = new int[OutputDeviceStatus.values().length];
            f65332a = iArr;
            try {
                iArr[OutputDeviceStatus.NOT_DETECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final float f65333a;

        /* renamed from: b, reason: collision with root package name */
        final float f65334b;

        b(float f11, float f12) {
            this.f65333a = f11;
            this.f65334b = f12;
        }
    }

    static float a(int i11) {
        return i11 / f65331c;
    }

    private static b b(JSONObject jSONObject) {
        float f11;
        float f12;
        if (f65329a != null) {
            Point point = new Point(0, 0);
            f65329a.getDefaultDisplay().getRealSize(point);
            f11 = a(point.x);
            f12 = a(point.y);
        } else {
            f11 = 0.0f;
            f12 = 0.0f;
        }
        return new b(f11, f12);
    }

    public static JSONObject c(int i11, int i12, int i13, int i14) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", a(i11));
            jSONObject.put("y", a(i12));
            jSONObject.put("width", a(i13));
            jSONObject.put("height", a(i14));
        } catch (JSONException e11) {
            d.b("Error with creating viewStateObject", e11);
        }
        return jSONObject;
    }

    public static void d(Context context) {
        if (context != null) {
            f65331c = context.getResources().getDisplayMetrics().density;
            f65329a = (WindowManager) context.getSystemService("window");
        }
    }

    public static void e(JSONObject jSONObject, OutputDeviceStatus outputDeviceStatus) {
        try {
            jSONObject.put("noOutputDevice", k(outputDeviceStatus));
        } catch (JSONException e11) {
            d.b("Error with setting output device status", e11);
        }
    }

    public static void f(JSONObject jSONObject, a.C0461a c0461a) {
        com.iab.omid.library.hisavana.internal.e a11 = c0461a.a();
        JSONArray jSONArray = new JSONArray();
        Iterator it = c0461a.c().iterator();
        while (it.hasNext()) {
            jSONArray.put((String) it.next());
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", a11.d());
            jSONObject.put("friendlyObstructionPurpose", a11.b());
            jSONObject.put("friendlyObstructionReason", a11.a());
        } catch (JSONException e11) {
            d.b("Error with setting friendly obstruction", e11);
        }
    }

    public static void g(JSONObject jSONObject, Boolean bool) {
        try {
            jSONObject.put("hasWindowFocus", bool);
        } catch (JSONException e11) {
            d.b("Error with setting has window focus", e11);
        }
    }

    public static void h(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e11) {
            d.b("Error with setting ad session id", e11);
        }
    }

    public static void i(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (NullPointerException | JSONException e11) {
            d.b("JSONException during JSONObject.put for name [" + str + "]", e11);
        }
    }

    public static void j(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put("childViews", optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    private static boolean k(OutputDeviceStatus outputDeviceStatus) {
        return a.f65332a[outputDeviceStatus.ordinal()] == 1;
    }

    private static boolean l(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    public static void m(JSONObject jSONObject) {
        b b11 = b(jSONObject);
        try {
            jSONObject.put("width", b11.f65333a);
            jSONObject.put("height", b11.f65334b);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public static void n(JSONObject jSONObject, Boolean bool) {
        if (bool.booleanValue()) {
            try {
                jSONObject.put("isPipActive", bool);
            } catch (JSONException e11) {
                d.b("Error with setting is picture-in-picture active", e11);
            }
        }
    }

    public static void o(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e11) {
            d.b("Error with setting not visible reason", e11);
        }
    }

    private static boolean p(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("childViews");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!l(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
            if (!v(optJSONArray.optJSONObject(i11), optJSONArray2.optJSONObject(i11))) {
                return false;
            }
        }
        return true;
    }

    private static boolean q(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!l(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
            if (!optJSONArray.optString(i11, "").equals(optJSONArray2.optString(i11, ""))) {
                return false;
            }
        }
        return true;
    }

    private static boolean r(JSONObject jSONObject, JSONObject jSONObject2) {
        return Boolean.valueOf(jSONObject.optBoolean("hasWindowFocus")).equals(Boolean.valueOf(jSONObject2.optBoolean("hasWindowFocus")));
    }

    private static boolean s(JSONObject jSONObject, JSONObject jSONObject2) {
        return Boolean.valueOf(jSONObject.optBoolean("noOutputDevice")).equals(Boolean.valueOf(jSONObject2.optBoolean("noOutputDevice")));
    }

    private static boolean t(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String str : f65330b) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean u(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""));
    }

    public static boolean v(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject == null || jSONObject2 == null) {
            return false;
        }
        return t(jSONObject, jSONObject2) && u(jSONObject, jSONObject2) && s(jSONObject, jSONObject2) && r(jSONObject, jSONObject2) && q(jSONObject, jSONObject2) && p(jSONObject, jSONObject2);
    }
}
