package com.google.firebase.perf.config;

/* loaded from: classes4.dex */
public final class l extends u {

    /* renamed from: a, reason: collision with root package name */
    private static l f32296a;

    private l() {
    }

    public static synchronized l e() {
        l lVar;
        synchronized (l.class) {
            try {
                if (f32296a == null) {
                    f32296a = new l();
                }
                lVar = f32296a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String a() {
        return "com.google.firebase.perf.SessionsCpuCaptureFrequencyBackgroundMs";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String b() {
        return "sessions_cpu_capture_frequency_bg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String c() {
        return "fpr_session_gauge_cpu_capture_frequency_bg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long d() {
        return 0L;
    }
}
