package com.google.firebase.perf.config;

/* loaded from: classes4.dex */
public final class s extends u {

    /* renamed from: a, reason: collision with root package name */
    private static s f32303a;

    private s() {
    }

    public static synchronized s e() {
        s sVar;
        synchronized (s.class) {
            try {
                if (f32303a == null) {
                    f32303a = new s();
                }
                sVar = f32303a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return sVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String a() {
        return "com.google.firebase.perf.TraceEventCountForeground";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String c() {
        return "fpr_rl_trace_event_count_fg";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long d() {
        return 300L;
    }
}
