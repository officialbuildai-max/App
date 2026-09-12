package com.google.firebase.perf.config;

/* loaded from: classes4.dex */
public final class r extends u {

    /* renamed from: a, reason: collision with root package name */
    private static r f32302a;

    private r() {
    }

    public static synchronized r e() {
        r rVar;
        synchronized (r.class) {
            try {
                if (f32302a == null) {
                    f32302a = new r();
                }
                rVar = f32302a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String a() {
        return "com.google.firebase.perf.TraceEventCountBackground";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String c() {
        return "fpr_rl_trace_event_count_bg";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long d() {
        return 30L;
    }
}
