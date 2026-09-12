package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.MBridgeConstans;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class c0 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private Runnable f35748a;

    /* renamed from: b, reason: collision with root package name */
    private Runnable f35749b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f35750a;

        a(Runnable runnable) {
            this.f35750a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f35750a.run();
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("LimitExecutor", e11.getMessage());
                }
            } finally {
                c0.this.a();
            }
        }
    }

    private Runnable a(Runnable runnable) {
        return new a(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        Runnable runnable = this.f35749b;
        this.f35748a = runnable;
        this.f35749b = null;
        if (runnable != null) {
            a0.a().execute(this.f35748a);
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        try {
            if (this.f35748a == null) {
                this.f35748a = a(runnable);
                a0.a().execute(this.f35748a);
            } else if (this.f35749b == null) {
                this.f35749b = a(runnable);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
