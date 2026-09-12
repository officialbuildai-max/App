package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class ExecutorDelivery implements j {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f19299a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ResponseDeliveryRunnable implements Runnable {
        private final Request mRequest;
        private final i mResponse;
        private final Runnable mRunnable;

        public ResponseDeliveryRunnable(Request request, i iVar, Runnable runnable) {
            this.mRequest = request;
            this.mResponse = iVar;
            this.mRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mRequest.isCanceled()) {
                this.mRequest.finish("canceled-at-delivery");
                return;
            }
            if (this.mResponse.b()) {
                this.mRequest.deliverResponse(this.mResponse.f19333a);
            } else {
                this.mRequest.deliverError(this.mResponse.f19335c);
            }
            if (this.mResponse.f19336d) {
                this.mRequest.addMarker("intermediate-response");
            } else {
                this.mRequest.finish("done");
            }
            Runnable runnable = this.mRunnable;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* loaded from: classes2.dex */
    class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Handler f19300a;

        a(Handler handler) {
            this.f19300a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f19300a.post(runnable);
        }
    }

    public ExecutorDelivery(Handler handler) {
        this.f19299a = new a(handler);
    }

    @Override // com.android.volley.j
    public void a(Request request, i iVar) {
        b(request, iVar, null);
    }

    @Override // com.android.volley.j
    public void b(Request request, i iVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        this.f19299a.execute(new ResponseDeliveryRunnable(request, iVar, runnable));
    }

    @Override // com.android.volley.j
    public void c(Request request, VolleyError volleyError) {
        request.addMarker("post-error");
        this.f19299a.execute(new ResponseDeliveryRunnable(request, i.a(volleyError), null));
    }
}
