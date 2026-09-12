package com.google.firebase.perf.config;

/* loaded from: classes4.dex */
public final class n extends u {

    /* renamed from: a, reason: collision with root package name */
    private static n f32298a;

    private n() {
    }

    public static synchronized n e() {
        n nVar;
        synchronized (n.class) {
            try {
                if (f32298a == null) {
                    f32298a = new n();
                }
                nVar = f32298a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String a() {
        return "com.google.firebase.perf.SessionsMaxDurationMinutes";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String b() {
        return "sessions_max_length_minutes";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String c() {
        return "fpr_session_max_duration_min";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long d() {
        return 240L;
    }
}
