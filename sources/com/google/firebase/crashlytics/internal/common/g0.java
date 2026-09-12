package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.firebase.crashlytics.internal.common.h0;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class g0 implements h0 {

    /* renamed from: g, reason: collision with root package name */
    private static final Pattern f31234g = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: h, reason: collision with root package name */
    private static final String f31235h = Pattern.quote("/");

    /* renamed from: a, reason: collision with root package name */
    private final i0 f31236a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f31237b;

    /* renamed from: c, reason: collision with root package name */
    private final String f31238c;

    /* renamed from: d, reason: collision with root package name */
    private final jc.e f31239d;

    /* renamed from: e, reason: collision with root package name */
    private final d0 f31240e;

    /* renamed from: f, reason: collision with root package name */
    private h0.a f31241f;

    public g0(Context context, String str, jc.e eVar, d0 d0Var) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.f31237b = context;
        this.f31238c = str;
        this.f31239d = eVar;
        this.f31240e = d0Var;
        this.f31236a = new i0();
    }

    private synchronized String b(String str, SharedPreferences sharedPreferences) {
        String e11;
        e11 = e(UUID.randomUUID().toString());
        ob.g.f().i("Created new Crashlytics installation ID: " + e11 + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", e11).putString("firebase.installation.id", str).apply();
        return e11;
    }

    static String c() {
        return "SYN_" + UUID.randomUUID().toString();
    }

    private static String e(String str) {
        return f31234g.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    static boolean k(String str) {
        return str != null && str.startsWith("SYN_");
    }

    private String l(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("crashlytics.installation.id", null);
    }

    private String m(String str) {
        return str.replaceAll(f31235h, "");
    }

    private boolean n() {
        h0.a aVar = this.f31241f;
        return aVar == null || (aVar.e() == null && this.f31240e.d());
    }

    @Override // com.google.firebase.crashlytics.internal.common.h0
    public synchronized h0.a a() {
        if (!n()) {
            return this.f31241f;
        }
        ob.g.f().i("Determining Crashlytics installation ID...");
        SharedPreferences q11 = CommonUtils.q(this.f31237b);
        String string = q11.getString("firebase.installation.id", null);
        ob.g.f().i("Cached Firebase Installation ID: " + string);
        if (this.f31240e.d()) {
            f0 d11 = d(false);
            ob.g.f().i("Fetched Firebase Installation ID: " + d11.b());
            if (d11.b() == null) {
                d11 = new f0(string == null ? c() : string, null);
            }
            if (Objects.equals(d11.b(), string)) {
                this.f31241f = h0.a.a(l(q11), d11);
            } else {
                this.f31241f = h0.a.a(b(d11.b(), q11), d11);
            }
        } else if (k(string)) {
            this.f31241f = h0.a.b(l(q11));
        } else {
            this.f31241f = h0.a.b(b(c(), q11));
        }
        ob.g.f().i("Install IDs: " + this.f31241f);
        return this.f31241f;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(7:13|14|4|5|6|7|8)|3|4|5|6|7|8) */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
    
        ob.g.f().l("Error getting Firebase installation id.", r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.firebase.crashlytics.internal.common.f0 d(boolean r6) {
        /*
            r5 = this;
            com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers.e()
            r0 = 10000(0x2710, double:4.9407E-320)
            r2 = 0
            if (r6 == 0) goto L26
            jc.e r6 = r5.f31239d     // Catch: java.lang.Exception -> L1c
            r3 = 0
            com.google.android.gms.tasks.Task r6 = r6.a(r3)     // Catch: java.lang.Exception -> L1c
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Exception -> L1c
            java.lang.Object r6 = com.google.android.gms.tasks.Tasks.await(r6, r0, r3)     // Catch: java.lang.Exception -> L1c
            com.google.firebase.installations.f r6 = (com.google.firebase.installations.f) r6     // Catch: java.lang.Exception -> L1c
            java.lang.String r6 = r6.b()     // Catch: java.lang.Exception -> L1c
            goto L27
        L1c:
            r6 = move-exception
            ob.g r3 = ob.g.f()
            java.lang.String r4 = "Error getting Firebase authentication token."
            r3.l(r4, r6)
        L26:
            r6 = r2
        L27:
            jc.e r3 = r5.f31239d     // Catch: java.lang.Exception -> L37
            com.google.android.gms.tasks.Task r3 = r3.getId()     // Catch: java.lang.Exception -> L37
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Exception -> L37
            java.lang.Object r0 = com.google.android.gms.tasks.Tasks.await(r3, r0, r4)     // Catch: java.lang.Exception -> L37
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L37
            r2 = r0
            goto L41
        L37:
            r0 = move-exception
            ob.g r1 = ob.g.f()
            java.lang.String r3 = "Error getting Firebase installation id."
            r1.l(r3, r0)
        L41:
            com.google.firebase.crashlytics.internal.common.f0 r0 = new com.google.firebase.crashlytics.internal.common.f0
            r0.<init>(r2, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.common.g0.d(boolean):com.google.firebase.crashlytics.internal.common.f0");
    }

    public String f() {
        return this.f31238c;
    }

    public String g() {
        return this.f31236a.a(this.f31237b);
    }

    public String h() {
        return String.format(Locale.US, "%s/%s", m(Build.MANUFACTURER), m(Build.MODEL));
    }

    public String i() {
        return m(Build.VERSION.INCREMENTAL);
    }

    public String j() {
        return m(Build.VERSION.RELEASE);
    }
}
