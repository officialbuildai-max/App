package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f19322a;

    /* renamed from: b, reason: collision with root package name */
    private final Set f19323b;

    /* renamed from: c, reason: collision with root package name */
    private final PriorityBlockingQueue f19324c;

    /* renamed from: d, reason: collision with root package name */
    private final PriorityBlockingQueue f19325d;

    /* renamed from: e, reason: collision with root package name */
    private final c f19326e;

    /* renamed from: f, reason: collision with root package name */
    private final f f19327f;

    /* renamed from: g, reason: collision with root package name */
    private final j f19328g;

    /* renamed from: h, reason: collision with root package name */
    private final NetworkDispatcher[] f19329h;

    /* renamed from: i, reason: collision with root package name */
    private CacheDispatcher f19330i;

    /* renamed from: j, reason: collision with root package name */
    private final List f19331j;

    /* renamed from: k, reason: collision with root package name */
    private final List f19332k;

    public h(c cVar, f fVar) {
        this(cVar, fVar, 4);
    }

    public h(c cVar, f fVar, int i11) {
        this(cVar, fVar, i11, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
    }

    public h(c cVar, f fVar, int i11, j jVar) {
        this.f19322a = new AtomicInteger();
        this.f19323b = new HashSet();
        this.f19324c = new PriorityBlockingQueue();
        this.f19325d = new PriorityBlockingQueue();
        this.f19331j = new ArrayList();
        this.f19332k = new ArrayList();
        this.f19326e = cVar;
        this.f19327f = fVar;
        this.f19329h = new NetworkDispatcher[i11];
        this.f19328g = jVar;
    }

    public Request a(Request request) {
        request.setRequestQueue(this);
        synchronized (this.f19323b) {
            this.f19323b.add(request);
        }
        request.setSequence(d());
        request.addMarker("add-to-queue");
        e(request, 0);
        b(request);
        return request;
    }

    void b(Request request) {
        if (request.shouldCache()) {
            this.f19324c.add(request);
        } else {
            f(request);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Request request) {
        synchronized (this.f19323b) {
            this.f19323b.remove(request);
        }
        synchronized (this.f19331j) {
            Iterator it = this.f19331j.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.c.a(it.next());
                throw null;
            }
        }
        e(request, 5);
    }

    public int d() {
        return this.f19322a.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Request request, int i11) {
        synchronized (this.f19332k) {
            try {
                Iterator it = this.f19332k.iterator();
                if (it.hasNext()) {
                    android.support.v4.media.session.c.a(it.next());
                    throw null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Request request) {
        this.f19325d.add(request);
    }

    public void g() {
        h();
        CacheDispatcher cacheDispatcher = new CacheDispatcher(this.f19324c, this.f19325d, this.f19326e, this.f19328g);
        this.f19330i = cacheDispatcher;
        cacheDispatcher.start();
        for (int i11 = 0; i11 < this.f19329h.length; i11++) {
            NetworkDispatcher networkDispatcher = new NetworkDispatcher(this.f19325d, this.f19327f, this.f19326e, this.f19328g);
            this.f19329h[i11] = networkDispatcher;
            networkDispatcher.start();
        }
    }

    public void h() {
        CacheDispatcher cacheDispatcher = this.f19330i;
        if (cacheDispatcher != null) {
            cacheDispatcher.quit();
        }
        for (NetworkDispatcher networkDispatcher : this.f19329h) {
            if (networkDispatcher != null) {
                networkDispatcher.quit();
            }
        }
    }
}
