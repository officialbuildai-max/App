package com.mbridge.msdk.tracker;

import android.util.Log;
import com.mbridge.msdk.tracker.network.b0;
import com.mbridge.msdk.tracker.network.t;
import com.mbridge.msdk.tracker.network.v;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private r f38749a;

    /* renamed from: b, reason: collision with root package name */
    private final int f38750b;

    /* renamed from: c, reason: collision with root package name */
    private final p f38751c;

    /* renamed from: d, reason: collision with root package name */
    private final w f38752d;

    /* renamed from: e, reason: collision with root package name */
    private final int f38753e;

    /* renamed from: f, reason: collision with root package name */
    private com.mbridge.msdk.tracker.network.u f38754f;

    /* renamed from: g, reason: collision with root package name */
    private final Executor f38755g;

    /* loaded from: classes5.dex */
    class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "MBridgeReportResponseThread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements v.a {

        /* renamed from: a, reason: collision with root package name */
        private final r f38757a;

        /* renamed from: b, reason: collision with root package name */
        private final t f38758b;

        public b(r rVar, t tVar) {
            this.f38757a = rVar;
            this.f38758b = tVar;
        }

        @Override // com.mbridge.msdk.tracker.network.v.a
        public void a(b0 b0Var) {
            int a11;
            int b11;
            String message;
            if (y.a(this.f38757a)) {
                if (b0Var != null) {
                    try {
                        a11 = b0Var.a();
                        b11 = b0Var.b();
                        message = b0Var.getMessage();
                    } catch (Exception e11) {
                        if (com.mbridge.msdk.tracker.a.f38550a) {
                            Log.e("TrackManager", "onErrorResponse error", e11);
                            return;
                        }
                        return;
                    }
                } else {
                    b11 = 0;
                    message = "";
                    a11 = 0;
                }
                this.f38757a.a(this.f38758b, 0, String.format("volleyError:%s,responseCode:%s,errorMessage:%s", Integer.valueOf(a11), Integer.valueOf(b11), message));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class c implements v.b {

        /* renamed from: a, reason: collision with root package name */
        private final r f38759a;

        /* renamed from: b, reason: collision with root package name */
        private final t f38760b;

        public c(r rVar, t tVar) {
            this.f38759a = rVar;
            this.f38760b = tVar;
        }

        @Override // com.mbridge.msdk.tracker.network.v.b
        public void a(Object obj) {
            if (y.a(this.f38759a)) {
                try {
                    this.f38759a.a(this.f38760b);
                } catch (Exception e11) {
                    if (com.mbridge.msdk.tracker.a.f38550a) {
                        Log.e("TrackManager", "onResponse error", e11);
                    }
                }
            }
        }
    }

    public o(int i11, p pVar, w wVar, int i12) {
        this.f38750b = i11;
        this.f38751c = pVar;
        this.f38752d = wVar;
        this.f38753e = i12;
        this.f38755g = new ThreadPoolExecutor(i11, i11, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(), new ThreadPoolExecutor.DiscardPolicy());
    }

    private v<Object> a(t tVar, Map<String, String> map, boolean z10) {
        v<Object> vVar = this.f38753e == 1 ? new v<>(this.f38751c.c(), 1, this.f38751c.a()) : new v<>(this.f38751c.c(), 1);
        vVar.a(map);
        vVar.a(false);
        vVar.c(true);
        vVar.b(true);
        vVar.a(this.f38752d);
        vVar.a(z10 ? t.a.HIGH : t.a.NORMAL);
        vVar.a((v.b<Object>) new c(this.f38749a, tVar));
        vVar.a((v.a) new b(this.f38749a, tVar));
        return vVar;
    }

    private void a() {
        if (y.a(this.f38754f)) {
            return;
        }
        com.mbridge.msdk.tracker.network.u a11 = com.mbridge.msdk.tracker.network.toolbox.o.a(new com.mbridge.msdk.tracker.network.toolbox.b(this.f38751c.b()), new com.mbridge.msdk.tracker.network.f(this.f38755g), this.f38750b, null);
        this.f38754f = a11;
        a11.b();
    }

    public void a(r rVar) {
        this.f38749a = rVar;
    }

    public void b(t tVar, Map<String, String> map, boolean z10) {
        if (y.b(map)) {
            r rVar = this.f38749a;
            if (rVar != null) {
                try {
                    rVar.a(tVar, 0, "params is null");
                    return;
                } catch (Exception e11) {
                    if (com.mbridge.msdk.tracker.a.f38550a) {
                        Log.e("TrackManager", "send error", e11);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        try {
            a();
            this.f38754f.a(a(tVar, map, z10));
        } catch (Exception e12) {
            if (com.mbridge.msdk.tracker.a.f38550a) {
                Log.e("TrackManager", "send error", e12);
            }
            if (y.a(this.f38749a)) {
                this.f38749a.a(tVar, 0, e12.getMessage());
            }
        }
    }
}
