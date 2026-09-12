package com.google.firebase.perf.config;

/* loaded from: classes4.dex */
public final class g extends u {

    /* renamed from: a, reason: collision with root package name */
    private static g f32291a;

    private g() {
    }

    public static synchronized g e() {
        g gVar;
        synchronized (g.class) {
            try {
                if (f32291a == null) {
                    f32291a = new g();
                }
                gVar = f32291a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String a() {
        return "com.google.firebase.perf.NetworkEventCountForeground";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String c() {
        return "fpr_rl_network_event_count_fg";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long d() {
        return 700L;
    }
}
