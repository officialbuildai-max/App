package com.google.firebase.perf.config;

/* loaded from: classes4.dex */
public final class c extends u {

    /* renamed from: a, reason: collision with root package name */
    private static c f32287a;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized c d() {
        c cVar;
        synchronized (c.class) {
            try {
                if (f32287a == null) {
                    f32287a = new c();
                }
                cVar = f32287a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String a() {
        return "isEnabled";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String b() {
        return "firebase_performance_collection_enabled";
    }
}
