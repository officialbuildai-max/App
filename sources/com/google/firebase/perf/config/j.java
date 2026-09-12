package com.google.firebase.perf.config;

/* loaded from: classes4.dex */
public final class j extends u {

    /* renamed from: a, reason: collision with root package name */
    private static j f32294a;

    protected j() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized j e() {
        j jVar;
        synchronized (j.class) {
            try {
                if (f32294a == null) {
                    f32294a = new j();
                }
                jVar = f32294a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String a() {
        return "com.google.firebase.perf.SdkDisabledVersions";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String c() {
        return "fpr_disabled_android_versions";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d() {
        return "";
    }
}
