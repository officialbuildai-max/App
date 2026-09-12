package com.google.firebase.perf.config;

/* loaded from: classes4.dex */
public final class k extends u {

    /* renamed from: a, reason: collision with root package name */
    private static k f32295a;

    protected k() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized k e() {
        k kVar;
        synchronized (k.class) {
            try {
                if (f32295a == null) {
                    f32295a = new k();
                }
                kVar = f32295a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return kVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String a() {
        return "com.google.firebase.perf.SdkEnabled";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String c() {
        return "fpr_enabled";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Boolean d() {
        return Boolean.TRUE;
    }
}
