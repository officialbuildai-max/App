package com.mbridge.msdk.foundation.same;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f35409b;

    /* renamed from: a, reason: collision with root package name */
    private Boolean f35410a = null;

    private b() {
    }

    public static b b() {
        if (f35409b == null) {
            synchronized (b.class) {
                try {
                    if (f35409b == null) {
                        f35409b = new b();
                    }
                } finally {
                }
            }
        }
        return f35409b;
    }

    public Boolean a() {
        return this.f35410a;
    }
}
