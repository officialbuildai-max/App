package com.mbridge.msdk.tracker.network;

/* loaded from: classes5.dex */
public class l {

    /* renamed from: b, reason: collision with root package name */
    private static volatile l f38636b;

    /* renamed from: a, reason: collision with root package name */
    private u f38637a;

    private l() {
    }

    public static l a() {
        if (f38636b == null) {
            synchronized (l.class) {
                try {
                    if (f38636b == null) {
                        f38636b = new l();
                    }
                } finally {
                }
            }
        }
        return f38636b;
    }

    public u b() {
        if (this.f38637a == null) {
            u a11 = com.mbridge.msdk.tracker.network.toolbox.o.a(new com.mbridge.msdk.tracker.network.toolbox.b(new com.mbridge.msdk.tracker.network.toolbox.m()), null, 10, new com.mbridge.msdk.tracker.network.toolbox.l());
            this.f38637a = a11;
            a11.b();
        }
        return this.f38637a;
    }
}
