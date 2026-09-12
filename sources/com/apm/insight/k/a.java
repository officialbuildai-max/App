package com.apm.insight.k;

import android.util.Log;
import androidx.annotation.Nullable;
import com.apm.insight.runtime.m;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static Runnable f19654a = new Runnable() { // from class: com.apm.insight.k.a.1
        @Override // java.lang.Runnable
        public final void run() {
            if (com.apm.insight.l.k.b(com.apm.insight.e.g())) {
                a.i();
            }
            if (a.f19655b > 0) {
                if (com.apm.insight.l.a.b(com.apm.insight.e.g())) {
                    m.a().a(a.f19654a, MBInterstitialActivity.WEB_LOAD_TIME);
                } else {
                    m.a().a(a.f19654a, 60000L);
                }
            }
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private static int f19655b = 0;

    public static void a() {
        f19655b = 40;
        m.a().a(f19654a);
    }

    public static void b() {
        if (!j.b()) {
            j.c();
        }
        if (com.apm.insight.l.k.b(com.apm.insight.e.g()) && j.g()) {
            i();
        }
    }

    public static boolean c() {
        return false;
    }

    public static void d() {
    }

    @Nullable
    private static byte[] h() {
        try {
            return e.a(com.apm.insight.e.i().getConfigUrl(), com.apm.insight.entity.b.a().toString().getBytes());
        } catch (Throwable th2) {
            com.apm.insight.a.a(th2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void i() {
        synchronized (a.class) {
            try {
                int i11 = f19655b;
                if (i11 > 0) {
                    f19655b = i11 - 1;
                }
                com.apm.insight.a.a((Object) "try fetchApmConfig");
                if (!com.apm.insight.l.a.b(com.apm.insight.e.g())) {
                    j.c();
                    if (j.a()) {
                        f19655b = 0;
                    }
                    return;
                }
                JSONArray jSONArray = null;
                try {
                    byte[] h11 = h();
                    if (h11 != null) {
                        jSONArray = new JSONObject(new String(h11)).optJSONArray("data");
                    }
                } catch (Throwable th2) {
                    if (com.apm.insight.e.i().isDebugMode()) {
                        Log.e("npth", "npth NPTH Catch Error", th2);
                    }
                }
                com.apm.insight.a.a((Object) "after fetchApmConfig net ".concat(String.valueOf(jSONArray)));
                if (jSONArray == null) {
                    f19655b -= 10;
                } else {
                    com.apm.insight.runtime.a.a(jSONArray, true);
                    f19655b = 0;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
