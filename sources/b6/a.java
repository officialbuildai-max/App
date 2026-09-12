package b6;

import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import org.json.JSONObject;
import x5.b;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static b f16313a = null;

    /* renamed from: b, reason: collision with root package name */
    public static int f16314b = 10;

    /* renamed from: c, reason: collision with root package name */
    public static int f16315c = 10;

    /* renamed from: d, reason: collision with root package name */
    public static int f16316d = 10;

    /* renamed from: e, reason: collision with root package name */
    public static int f16317e = 10;

    public static int a() {
        return f16316d;
    }

    public static int b() {
        return f16317e;
    }

    public static void c() {
        b bVar = f16313a;
        if (bVar != null) {
            bVar.EjP();
        }
    }

    public static void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            f16314b = jSONObject.optInt("splash", 10);
            f16315c = jSONObject.optInt("reward", 10);
            f16316d = jSONObject.optInt("brand", 10);
            int optInt = jSONObject.optInt(OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, 10);
            f16317e = optInt;
            if (f16314b < 0) {
                f16314b = 10;
            }
            if (f16315c < 0) {
                f16315c = 10;
            }
            if (f16316d < 0) {
                f16316d = 10;
            }
            if (optInt < 0) {
                f16317e = 10;
            }
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    public static void e(b bVar) {
        f16313a = bVar;
    }

    public static int f() {
        return f16315c;
    }

    public static int g() {
        return f16314b;
    }
}
