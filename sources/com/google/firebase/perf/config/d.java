package com.google.firebase.perf.config;

/* loaded from: classes4.dex */
public final class d extends u {

    /* renamed from: a, reason: collision with root package name */
    private static d f32288a;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized d e() {
        d dVar;
        synchronized (d.class) {
            try {
                if (f32288a == null) {
                    f32288a = new d();
                }
                dVar = f32288a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String a() {
        return "com.google.firebase.perf.ExperimentTTID";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String b() {
        return "experiment_app_start_ttid";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String c() {
        return "fpr_experiment_app_start_ttid";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Boolean d() {
        return Boolean.FALSE;
    }
}
