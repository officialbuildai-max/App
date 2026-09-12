package com.google.firebase.perf.config;

/* loaded from: classes4.dex */
public final class e extends u {

    /* renamed from: a, reason: collision with root package name */
    private static e f32289a;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized e e() {
        e eVar;
        synchronized (e.class) {
            try {
                if (f32289a == null) {
                    f32289a = new e();
                }
                eVar = f32289a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String a() {
        return "com.google.firebase.perf.FragmentSamplingRate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String b() {
        return "fragment_sampling_percentage";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String c() {
        return "fpr_vc_fragment_sampling_rate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Double d() {
        return Double.valueOf(0.0d);
    }
}
