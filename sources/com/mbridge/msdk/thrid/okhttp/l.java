package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.thrid.okhttp.v;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class l {

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ boolean f38327h = true;

    /* renamed from: c, reason: collision with root package name */
    private Runnable f38330c;

    /* renamed from: d, reason: collision with root package name */
    private ExecutorService f38331d;

    /* renamed from: a, reason: collision with root package name */
    private int f38328a = 64;

    /* renamed from: b, reason: collision with root package name */
    private int f38329b = 5;

    /* renamed from: e, reason: collision with root package name */
    private final Deque<v.b> f38332e = new ArrayDeque();

    /* renamed from: f, reason: collision with root package name */
    private final Deque<v.b> f38333f = new ArrayDeque();

    /* renamed from: g, reason: collision with root package name */
    private final Deque<v> f38334g = new ArrayDeque();

    public l() {
    }

    public l(ExecutorService executorService) {
        this.f38331d = executorService;
    }

    private <T> void a(Deque<T> deque, T t11) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t11)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.f38330c;
        }
        if (b() || runnable == null) {
            return;
        }
        runnable.run();
    }

    private int b(v.b bVar) {
        int i11 = 0;
        for (v.b bVar2 : this.f38333f) {
            if (!bVar2.c().f38426f && bVar2.d().equals(bVar.d())) {
                i11++;
            }
        }
        return i11;
    }

    private boolean b() {
        int i11;
        boolean z10;
        if (!f38327h && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator<v.b> it = this.f38332e.iterator();
                while (it.hasNext()) {
                    v.b next = it.next();
                    if (this.f38333f.size() >= this.f38328a) {
                        break;
                    }
                    if (b(next) < this.f38329b) {
                        it.remove();
                        arrayList.add(next);
                        this.f38333f.add(next);
                    }
                }
                z10 = c() > 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        int size = arrayList.size();
        for (i11 = 0; i11 < size; i11++) {
            ((v.b) arrayList.get(i11)).a(a());
        }
        return z10;
    }

    public synchronized ExecutorService a() {
        try {
            if (this.f38331d == null) {
                this.f38331d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), com.mbridge.msdk.thrid.okhttp.internal.c.a("OkHttp Dispatcher", false));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f38331d;
    }

    public void a(int i11) {
        if (i11 >= 1) {
            synchronized (this) {
                this.f38328a = i11;
            }
            b();
        } else {
            throw new IllegalArgumentException("max < 1: " + i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v.b bVar) {
        a(this.f38333f, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(v vVar) {
        this.f38334g.add(vVar);
    }

    public void b(int i11) {
        if (i11 >= 1) {
            synchronized (this) {
                this.f38329b = i11;
            }
            b();
        } else {
            throw new IllegalArgumentException("max < 1: " + i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(v vVar) {
        a(this.f38334g, vVar);
    }

    public synchronized int c() {
        return this.f38333f.size() + this.f38334g.size();
    }
}
