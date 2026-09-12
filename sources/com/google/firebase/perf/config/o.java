package com.google.firebase.perf.config;

/* loaded from: classes4.dex */
public final class o extends u {

    /* renamed from: a, reason: collision with root package name */
    private static o f32299a;

    private o() {
    }

    public static synchronized o e() {
        o oVar;
        synchronized (o.class) {
            try {
                if (f32299a == null) {
                    f32299a = new o();
                }
                oVar = f32299a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String a() {
        return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyBackgroundMs";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String b() {
        return "sessions_memory_capture_frequency_bg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String c() {
        return "fpr_session_gauge_memory_capture_frequency_bg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long d() {
        return 0L;
    }
}
