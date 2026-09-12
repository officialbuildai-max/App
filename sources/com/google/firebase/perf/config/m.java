package com.google.firebase.perf.config;

/* loaded from: classes4.dex */
public final class m extends u {

    /* renamed from: a, reason: collision with root package name */
    private static m f32297a;

    private m() {
    }

    public static synchronized m f() {
        m mVar;
        synchronized (m.class) {
            try {
                if (f32297a == null) {
                    f32297a = new m();
                }
                mVar = f32297a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return mVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String a() {
        return "com.google.firebase.perf.SessionsCpuCaptureFrequencyForegroundMs";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String b() {
        return "sessions_cpu_capture_frequency_fg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String c() {
        return "fpr_session_gauge_cpu_capture_frequency_fg_ms";
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
