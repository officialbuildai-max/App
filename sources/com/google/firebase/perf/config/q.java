package com.google.firebase.perf.config;

/* loaded from: classes4.dex */
public final class q extends u {

    /* renamed from: a, reason: collision with root package name */
    private static q f32301a;

    private q() {
    }

    public static synchronized q f() {
        q qVar;
        synchronized (q.class) {
            try {
                if (f32301a == null) {
                    f32301a = new q();
                }
                qVar = f32301a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return qVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String a() {
        return "com.google.firebase.perf.SessionSamplingRate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String b() {
        return "sessions_sampling_percentage";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String c() {
        return "fpr_vc_session_sampling_rate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Double d() {
        return Double.valueOf(0.01d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Double e() {
        return Double.valueOf(d().doubleValue() / 1000.0d);
    }
}
