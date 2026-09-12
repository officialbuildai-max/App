package com.google.firebase.perf.config;

/* loaded from: classes4.dex */
public final class b extends u {

    /* renamed from: a, reason: collision with root package name */
    private static b f32286a;

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized b e() {
        b bVar;
        synchronized (b.class) {
            try {
                if (f32286a == null) {
                    f32286a = new b();
                }
                bVar = f32286a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String b() {
        return "firebase_performance_collection_deactivated";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Boolean d() {
        return Boolean.FALSE;
    }
}
