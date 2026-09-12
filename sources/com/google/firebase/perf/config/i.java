package com.google.firebase.perf.config;

/* loaded from: classes4.dex */
public final class i extends u {

    /* renamed from: a, reason: collision with root package name */
    private static i f32293a;

    private i() {
    }

    public static synchronized i e() {
        i iVar;
        synchronized (i.class) {
            try {
                if (f32293a == null) {
                    f32293a = new i();
                }
                iVar = f32293a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String a() {
        return "com.google.firebase.perf.TimeLimitSec";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String c() {
        return "fpr_rl_time_limit_sec";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long d() {
        return 600L;
    }
}
