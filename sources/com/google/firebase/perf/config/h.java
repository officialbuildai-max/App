package com.google.firebase.perf.config;

/* loaded from: classes4.dex */
public final class h extends u {

    /* renamed from: a, reason: collision with root package name */
    private static h f32292a;

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized h f() {
        h hVar;
        synchronized (h.class) {
            try {
                if (f32292a == null) {
                    f32292a = new h();
                }
                hVar = f32292a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String a() {
        return "com.google.firebase.perf.NetworkRequestSamplingRate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String c() {
        return "fpr_vc_network_request_sampling_rate";
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
