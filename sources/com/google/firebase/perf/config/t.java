package com.google.firebase.perf.config;

/* loaded from: classes4.dex */
public final class t extends u {

    /* renamed from: a, reason: collision with root package name */
    private static t f32304a;

    private t() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized t f() {
        t tVar;
        synchronized (t.class) {
            try {
                if (f32304a == null) {
                    f32304a = new t();
                }
                tVar = f32304a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return tVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String a() {
        return "com.google.firebase.perf.TraceSamplingRate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String c() {
        return "fpr_vc_trace_sampling_rate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Double d() {
        return Double.valueOf(1.0d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Double e() {
        return Double.valueOf(d().doubleValue() / 1000.0d);
    }
}
