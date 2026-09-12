package com.pgl.ssdk;

import android.os.HandlerThread;
import com.pgl.ssdk.b1;

/* loaded from: classes5.dex */
public class x0 {

    /* renamed from: a, reason: collision with root package name */
    private final a1<y0> f40282a;

    /* renamed from: b, reason: collision with root package name */
    private b1 f40283b;

    /* loaded from: classes5.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final x0 f40284a = new x0();
    }

    private x0() {
        this.f40282a = a1.a(2);
    }

    public static x0 a() {
        return b.f40284a;
    }

    private y0 a(b1.a aVar, String str) {
        try {
            HandlerThread handlerThread = new HandlerThread(str);
            handlerThread.start();
            return new y0(handlerThread, aVar);
        } catch (Throwable unused) {
            return null;
        }
    }

    public b1 a(String str) {
        return b(null, str);
    }

    public b1 b() {
        if (this.f40283b == null) {
            synchronized (x0.class) {
                try {
                    if (this.f40283b == null) {
                        this.f40283b = a("ssdk_net_handler");
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f40283b;
    }

    public b1 b(b1.a aVar, String str) {
        y0 a11 = this.f40282a.a();
        if (a11 == null) {
            return a(aVar, str);
        }
        a11.a(aVar);
        a11.a(str);
        return a11;
    }

    public b1 c() {
        if (this.f40283b == null) {
            synchronized (x0.class) {
                try {
                    if (this.f40283b == null) {
                        this.f40283b = a("ssdk_handler");
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f40283b;
    }
}
