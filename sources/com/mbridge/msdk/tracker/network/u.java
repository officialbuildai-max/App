package com.mbridge.msdk.tracker.network;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private volatile ThreadPoolExecutor f38733a;

    /* renamed from: e, reason: collision with root package name */
    private final int f38737e;

    /* renamed from: f, reason: collision with root package name */
    private final com.mbridge.msdk.tracker.network.b f38738f;

    /* renamed from: g, reason: collision with root package name */
    private final m f38739g;

    /* renamed from: h, reason: collision with root package name */
    private final w f38740h;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f38734b = new AtomicInteger();

    /* renamed from: c, reason: collision with root package name */
    private final Set<t<?>> f38735c = new HashSet();

    /* renamed from: d, reason: collision with root package name */
    private final PriorityBlockingQueue<t<?>> f38736d = new PriorityBlockingQueue<>();

    /* renamed from: i, reason: collision with root package name */
    private final List<c> f38741i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private boolean f38742j = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "NetworkDispatcher");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                new n(u.this.f38736d, u.this.f38739g, u.this.f38738f, u.this.f38740h).run();
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(t<?> tVar, int i11);
    }

    public u(m mVar, w wVar, int i11, com.mbridge.msdk.tracker.network.b bVar) {
        this.f38737e = i11;
        this.f38738f = bVar;
        this.f38739g = mVar;
        this.f38740h = wVar;
    }

    private void a(int i11) {
        if (this.f38733a != null) {
            return;
        }
        try {
            b(i11);
        } catch (Throwable unused) {
            try {
                b(5);
            } catch (Exception unused2) {
                this.f38733a = null;
            }
        }
    }

    private void b(int i11) {
        this.f38733a = new ThreadPoolExecutor(i11, i11, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a(), new ThreadPoolExecutor.DiscardPolicy());
    }

    public int a() {
        return this.f38734b.incrementAndGet();
    }

    public <T> t<T> a(t<T> tVar) {
        tVar.a(this);
        synchronized (this.f38735c) {
            this.f38735c.add(tVar);
        }
        tVar.b(a());
        tVar.a("add-to-queue");
        a(tVar, 0);
        b(tVar);
        if (this.f38733a == null) {
            a(this.f38737e);
        }
        if (!this.f38733a.isShutdown()) {
            this.f38733a.execute(new b());
        }
        return tVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(t<?> tVar, int i11) {
        synchronized (this.f38741i) {
            try {
                Iterator<c> it = this.f38741i.iterator();
                while (it.hasNext()) {
                    it.next().a(tVar, i11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b() {
        if (!this.f38742j || this.f38733a == null) {
            a(this.f38737e);
            this.f38742j = true;
        }
    }

    <T> void b(t<T> tVar) {
        d(tVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> void c(t<T> tVar) {
        synchronized (this.f38735c) {
            this.f38735c.remove(tVar);
        }
        a(tVar, 5);
    }

    <T> void d(t<T> tVar) {
        this.f38736d.add(tVar);
    }
}
