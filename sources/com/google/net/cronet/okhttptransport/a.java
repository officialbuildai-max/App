package com.google.net.cronet.okhttptransport;

import android.util.Log;
import com.google.common.base.m;
import com.google.net.cronet.okhttptransport.g;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.chromium.net.CronetEngine;
import org.chromium.net.UrlRequest;

/* loaded from: classes4.dex */
public final class a implements Interceptor, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    private final g f32823a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f32824b;

    /* renamed from: c, reason: collision with root package name */
    private final ScheduledExecutorService f32825c;

    /* loaded from: classes4.dex */
    public static final class b extends h {
        b(CronetEngine cronetEngine) {
            super(cronetEngine, b.class);
        }

        @Override // com.google.net.cronet.okhttptransport.h
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a b(g gVar) {
            return new a(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c extends com.google.net.cronet.okhttptransport.b {

        /* renamed from: b, reason: collision with root package name */
        private final Call f32826b;

        private c(ResponseBody responseBody, Call call) {
            super(responseBody);
            this.f32826b = call;
        }

        @Override // com.google.net.cronet.okhttptransport.b
        void d() {
            a.this.f32824b.remove(this.f32826b);
        }
    }

    private a(g gVar) {
        this.f32824b = new ConcurrentHashMap();
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        this.f32825c = scheduledThreadPoolExecutor;
        this.f32823a = (g) m.o(gVar);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() { // from class: dd.a
            @Override // java.lang.Runnable
            public final void run() {
                com.google.net.cronet.okhttptransport.a.this.h();
            }
        }, 500L, 500L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        Iterator it = this.f32824b.entrySet().iterator();
        while (it.hasNext()) {
            try {
                Map.Entry entry = (Map.Entry) it.next();
                if (((Call) entry.getKey()).getCanceled()) {
                    it.remove();
                    ((UrlRequest) entry.getValue()).cancel();
                }
            } catch (RuntimeException e11) {
                Log.w("CronetInterceptor", "Unable to propagate cancellation status", e11);
            }
        }
    }

    public static b i(CronetEngine cronetEngine) {
        return new b(cronetEngine);
    }

    private Response k(Response response, Call call) {
        m.o(response.body());
        return response.body() instanceof c ? response : response.newBuilder().body(new c(response.body(), call)).build();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.f32825c.shutdown();
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        if (chain.call().getCanceled()) {
            throw new IOException("Canceled");
        }
        g.b b11 = this.f32823a.b(chain.request(), chain.readTimeoutMillis(), chain.writeTimeoutMillis());
        this.f32824b.put(chain.call(), b11.a());
        try {
            b11.a().start();
            return k(b11.b(), chain.call());
        } catch (IOException | RuntimeException e11) {
            this.f32824b.remove(chain.call());
            throw e11;
        }
    }
}
