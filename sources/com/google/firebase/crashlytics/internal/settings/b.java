package com.google.firebase.crashlytics.internal.settings;

import android.text.TextUtils;
import com.cloud.tmc.integration.event.EventConstants;
import com.google.firebase.crashlytics.internal.common.x;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b implements i {

    /* renamed from: a, reason: collision with root package name */
    private final String f31788a;

    /* renamed from: b, reason: collision with root package name */
    private final ub.b f31789b;

    /* renamed from: c, reason: collision with root package name */
    private final ob.g f31790c;

    public b(String str, ub.b bVar) {
        this(str, bVar, ob.g.f());
    }

    b(String str, ub.b bVar, ob.g gVar) {
        if (str == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        this.f31790c = gVar;
        this.f31789b = bVar;
        this.f31788a = str;
    }

    private ub.a b(ub.a aVar, h hVar) {
        c(aVar, "X-CRASHLYTICS-GOOGLE-APP-ID", hVar.f31817a);
        c(aVar, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        c(aVar, "X-CRASHLYTICS-API-CLIENT-VERSION", x.q());
        c(aVar, "Accept", "application/json");
        c(aVar, "X-CRASHLYTICS-DEVICE-MODEL", hVar.f31818b);
        c(aVar, "X-CRASHLYTICS-OS-BUILD-VERSION", hVar.f31819c);
        c(aVar, "X-CRASHLYTICS-OS-DISPLAY-VERSION", hVar.f31820d);
        c(aVar, "X-CRASHLYTICS-INSTALLATION-ID", hVar.f31821e.a().c());
        return aVar;
    }

    private void c(ub.a aVar, String str, String str2) {
        if (str2 != null) {
            aVar.d(str, str2);
        }
    }

    private JSONObject e(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e11) {
            this.f31790c.l("Failed to parse settings JSON from " + this.f31788a, e11);
            this.f31790c.k("Settings response " + str);
            return null;
        }
    }

    private Map f(h hVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", hVar.f31824h);
        hashMap.put("display_version", hVar.f31823g);
        hashMap.put(EventConstants.KEY_SOURCE, Integer.toString(hVar.f31825i));
        String str = hVar.f31822f;
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.i
    public JSONObject a(h hVar, boolean z10) {
        CrashlyticsWorkers.d();
        if (!z10) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        try {
            Map f11 = f(hVar);
            ub.a b11 = b(d(f11), hVar);
            this.f31790c.b("Requesting settings from " + this.f31788a);
            this.f31790c.i("Settings query params were: " + f11);
            return g(b11.c());
        } catch (IOException e11) {
            this.f31790c.e("Settings request failed.", e11);
            return null;
        }
    }

    protected ub.a d(Map map) {
        return this.f31789b.a(this.f31788a, map).d("User-Agent", "Crashlytics Android SDK/" + x.q()).d("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    JSONObject g(ub.c cVar) {
        int b11 = cVar.b();
        this.f31790c.i("Settings response code was: " + b11);
        if (h(b11)) {
            return e(cVar.a());
        }
        this.f31790c.d("Settings request failed; (status: " + b11 + ") from " + this.f31788a);
        return null;
    }

    boolean h(int i11) {
        return i11 == 200 || i11 == 201 || i11 == 202 || i11 == 203;
    }
}
