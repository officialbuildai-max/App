package androidx.media3.common.util;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static Executor f10453a;

    public static synchronized Executor a() {
        Executor executor;
        synchronized (c.class) {
            try {
                if (f10453a == null) {
                    f10453a = a1.S0("ExoPlayer:BackgroundExecutor");
                }
                executor = f10453a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return executor;
    }
}
