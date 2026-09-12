package kc;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.f;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f66881c = {"*", "FCM", "GCM", ""};

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f66882a;

    /* renamed from: b, reason: collision with root package name */
    private final String f66883b;

    public a(f fVar) {
        this.f66882a = fVar.k().getSharedPreferences("com.google.android.gms.appid", 0);
        this.f66883b = b(fVar);
    }

    private String a(String str, String str2) {
        return "|T|" + str + "|" + str2;
    }

    private static String b(f fVar) {
        String d11 = fVar.n().d();
        if (d11 != null) {
            return d11;
        }
        String c11 = fVar.n().c();
        if (!c11.startsWith("1:") && !c11.startsWith("2:")) {
            return c11;
        }
        String[] split = c11.split(":");
        if (split.length != 4) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private static String c(PublicKey publicKey) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("ContentValues", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    private String d(String str) {
        try {
            return new JSONObject(str).getString("token");
        } catch (JSONException unused) {
            return null;
        }
    }

    private PublicKey e(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 8)));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e11) {
            Log.w("ContentValues", "Invalid key stored " + e11);
            return null;
        }
    }

    private String g() {
        String string;
        synchronized (this.f66882a) {
            string = this.f66882a.getString("|S|id", null);
        }
        return string;
    }

    private String h() {
        synchronized (this.f66882a) {
            try {
                String string = this.f66882a.getString("|S||P|", null);
                if (string == null) {
                    return null;
                }
                PublicKey e11 = e(string);
                if (e11 == null) {
                    return null;
                }
                return c(e11);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public String f() {
        synchronized (this.f66882a) {
            try {
                String g11 = g();
                if (g11 != null) {
                    return g11;
                }
                return h();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public String i() {
        synchronized (this.f66882a) {
            try {
                for (String str : f66881c) {
                    String string = this.f66882a.getString(a(this.f66883b, str), null);
                    if (string != null && !string.isEmpty()) {
                        if (string.startsWith("{")) {
                            string = d(string);
                        }
                        return string;
                    }
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
