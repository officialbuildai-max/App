package com.mbridge.msdk.tracker.network;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class f implements w {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f38624a;

    /* loaded from: classes5.dex */
    class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Handler f38625a;

        a(Handler handler) {
            this.f38625a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f38625a.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final t f38627a;

        /* renamed from: b, reason: collision with root package name */
        private final v f38628b;

        /* renamed from: c, reason: collision with root package name */
        private final Runnable f38629c;

        public b(t tVar, v vVar, Runnable runnable) {
            this.f38627a = tVar;
            this.f38628b = vVar;
            this.f38629c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f38627a.v()) {
                this.f38627a.c("canceled-at-delivery");
                return;
            }
            if (this.f38628b.a()) {
                this.f38627a.a((t) this.f38628b.f38745a);
            } else {
                this.f38627a.b(this.f38628b.f38747c);
            }
            if (this.f38628b.f38748d) {
                this.f38627a.a("intermediate-response");
            } else {
                this.f38627a.c("done");
            }
            Runnable runnable = this.f38629c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public f(Handler handler) {
        this.f38624a = new a(handler);
    }

    public f(Executor executor) {
        this.f38624a = executor;
    }

    @Override // com.mbridge.msdk.tracker.network.w
    public void a(t<?> tVar, b0 b0Var) {
        tVar.a("post-error");
        this.f38624a.execute(new b(tVar, v.a(b0Var), null));
    }

    @Override // com.mbridge.msdk.tracker.network.w
    public void a(t<?> tVar, v<?> vVar) {
        a(tVar, vVar, null);
    }

    public void a(t<?> tVar, v<?> vVar, Runnable runnable) {
        tVar.w();
        tVar.a("post-response");
        this.f38624a.execute(new b(tVar, vVar, runnable));
    }
}
