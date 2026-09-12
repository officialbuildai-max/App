package com.google.firebase.perf.config;

/* loaded from: classes4.dex */
public final class f extends u {

    /* renamed from: a, reason: collision with root package name */
    private static f f32290a;

    private f() {
    }

    public static synchronized f e() {
        f fVar;
        synchronized (f.class) {
            try {
                if (f32290a == null) {
                    f32290a = new f();
                }
                fVar = f32290a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String a() {
        return "com.google.firebase.perf.NetworkEventCountBackground";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String c() {
        return "fpr_rl_network_event_count_bg";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long d() {
        return 70L;
    }
}
