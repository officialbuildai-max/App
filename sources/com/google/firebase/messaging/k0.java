package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes4.dex */
public class k0 {

    /* renamed from: a, reason: collision with root package name */
    private final Bundle f32165a;

    public k0(Bundle bundle) {
        if (bundle == null) {
            throw new NullPointerException("data");
        }
        this.f32165a = new Bundle(bundle);
    }

    private static int d(String str) {
        int parseColor = Color.parseColor(str);
        if (parseColor != -16777216) {
            return parseColor;
        }
        throw new IllegalArgumentException("Transparent color is invalid");
    }

    private static boolean s(String str) {
        return str.startsWith("google.c.a.") || str.equals("from");
    }

    public static boolean t(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString(v("gcm.n.e")));
    }

    private static boolean u(String str) {
        return str.startsWith("google.c.") || str.startsWith("gcm.n.") || str.startsWith("gcm.notification.");
    }

    private static String v(String str) {
        return !str.startsWith("gcm.n.") ? str : str.replace("gcm.n.", "gcm.notification.");
    }

    private String w(String str) {
        if (!this.f32165a.containsKey(str) && str.startsWith("gcm.n.")) {
            String v11 = v(str);
            if (this.f32165a.containsKey(v11)) {
                return v11;
            }
        }
        return str;
    }

    private static String z(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    public boolean a(String str) {
        String p11 = p(str);
        return "1".equals(p11) || Boolean.parseBoolean(p11);
    }

    public Integer b(String str) {
        String p11 = p(str);
        if (TextUtils.isEmpty(p11)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(p11));
        } catch (NumberFormatException unused) {
            Log.w("NotificationParams", "Couldn't parse value of " + z(str) + "(" + p11 + ") into an int");
            return null;
        }
    }

    public JSONArray c(String str) {
        String p11 = p(str);
        if (TextUtils.isEmpty(p11)) {
            return null;
        }
        try {
            return new JSONArray(p11);
        } catch (JSONException unused) {
            Log.w("NotificationParams", "Malformed JSON for key " + z(str) + ": " + p11 + ", falling back to default");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] e() {
        JSONArray c11 = c("gcm.n.light_settings");
        if (c11 == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (c11.length() != 3) {
                throw new JSONException("lightSettings don't have all three fields");
            }
            iArr[0] = d(c11.optString(0));
            iArr[1] = c11.optInt(1);
            iArr[2] = c11.optInt(2);
            return iArr;
        } catch (IllegalArgumentException e11) {
            Log.w("NotificationParams", "LightSettings is invalid: " + c11 + ". " + e11.getMessage() + ". Skipping setting LightSettings");
            return null;
        } catch (JSONException unused) {
            Log.w("NotificationParams", "LightSettings is invalid: " + c11 + ". Skipping setting LightSettings");
            return null;
        }
    }

    public Uri f() {
        String p11 = p("gcm.n.link_android");
        if (TextUtils.isEmpty(p11)) {
            p11 = p("gcm.n.link");
        }
        if (TextUtils.isEmpty(p11)) {
            return null;
        }
        return Uri.parse(p11);
    }

    public Object[] g(String str) {
        JSONArray c11 = c(str + "_loc_args");
        if (c11 == null) {
            return null;
        }
        int length = c11.length();
        String[] strArr = new String[length];
        for (int i11 = 0; i11 < length; i11++) {
            strArr[i11] = c11.optString(i11);
        }
        return strArr;
    }

    public String h(String str) {
        return p(str + "_loc_key");
    }

    public String i(Resources resources, String str, String str2) {
        String h11 = h(str2);
        if (TextUtils.isEmpty(h11)) {
            return null;
        }
        int identifier = resources.getIdentifier(h11, "string", str);
        if (identifier == 0) {
            Log.w("NotificationParams", z(str2 + "_loc_key") + " resource not found: " + str2 + " Default value will be used.");
            return null;
        }
        Object[] g11 = g(str2);
        if (g11 == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, g11);
        } catch (MissingFormatArgumentException e11) {
            Log.w("NotificationParams", "Missing format argument for " + z(str2) + ": " + Arrays.toString(g11) + " Default value will be used.", e11);
            return null;
        }
    }

    public Long j(String str) {
        String p11 = p(str);
        if (TextUtils.isEmpty(p11)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(p11));
        } catch (NumberFormatException unused) {
            Log.w("NotificationParams", "Couldn't parse value of " + z(str) + "(" + p11 + ") into a long");
            return null;
        }
    }

    public String k() {
        return p("gcm.n.android_channel_id");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Integer l() {
        Integer b11 = b("gcm.n.notification_count");
        if (b11 == null) {
            return null;
        }
        if (b11.intValue() >= 0) {
            return b11;
        }
        Log.w("FirebaseMessaging", "notificationCount is invalid: " + b11 + ". Skipping setting notificationCount.");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Integer m() {
        Integer b11 = b("gcm.n.notification_priority");
        if (b11 == null) {
            return null;
        }
        if (b11.intValue() >= -2 && b11.intValue() <= 2) {
            return b11;
        }
        Log.w("FirebaseMessaging", "notificationPriority is invalid " + b11 + ". Skipping setting notificationPriority.");
        return null;
    }

    public String n(Resources resources, String str, String str2) {
        String p11 = p(str2);
        return !TextUtils.isEmpty(p11) ? p11 : i(resources, str, str2);
    }

    public String o() {
        String p11 = p("gcm.n.sound2");
        return TextUtils.isEmpty(p11) ? p("gcm.n.sound") : p11;
    }

    public String p(String str) {
        return this.f32165a.getString(w(str));
    }

    public long[] q() {
        JSONArray c11 = c("gcm.n.vibrate_timings");
        if (c11 == null) {
            return null;
        }
        try {
            if (c11.length() <= 1) {
                throw new JSONException("vibrateTimings have invalid length");
            }
            int length = c11.length();
            long[] jArr = new long[length];
            for (int i11 = 0; i11 < length; i11++) {
                jArr[i11] = c11.optLong(i11);
            }
            return jArr;
        } catch (NumberFormatException | JSONException unused) {
            Log.w("NotificationParams", "User defined vibrateTimings is invalid: " + c11 + ". Skipping setting vibrateTimings.");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Integer r() {
        Integer b11 = b("gcm.n.visibility");
        if (b11 == null) {
            return null;
        }
        if (b11.intValue() >= -1 && b11.intValue() <= 1) {
            return b11;
        }
        Log.w("NotificationParams", "visibility is invalid: " + b11 + ". Skipping setting visibility.");
        return null;
    }

    public Bundle x() {
        Bundle bundle = new Bundle(this.f32165a);
        for (String str : this.f32165a.keySet()) {
            if (!s(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    public Bundle y() {
        Bundle bundle = new Bundle(this.f32165a);
        for (String str : this.f32165a.keySet()) {
            if (u(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }
}
