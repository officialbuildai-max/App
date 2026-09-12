package com.google.firebase.perf.config;

/* loaded from: classes4.dex */
public final class p extends u {

    /* renamed from: a, reason: collision with root package name */
    private static p f32300a;

    private p() {
    }

    public static synchronized p f() {
        p pVar;
        synchronized (p.class) {
            try {
                if (f32300a == null) {
                    f32300a = new p();
                }
                pVar = f32300a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return pVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String a() {
        return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyForegroundMs";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String b() {
        return "sessions_memory_capture_frequency_fg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String c() {
        return "fpr_session_gauge_memory_capture_frequency_fg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long d() {
        return 100L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long e() {
        return Long.valueOf(d().longValue() * 3);
    }
}
