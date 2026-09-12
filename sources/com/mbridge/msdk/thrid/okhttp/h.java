package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.thrid.okhttp.internal.connection.g;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class h {

    /* renamed from: g, reason: collision with root package name */
    private static final Executor f37930g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.mbridge.msdk.thrid.okhttp.internal.c.a("OkHttp ConnectionPool", true));

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ boolean f37931h = true;

    /* renamed from: a, reason: collision with root package name */
    private final int f37932a;

    /* renamed from: b, reason: collision with root package name */
    private final long f37933b;

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f37934c;

    /* renamed from: d, reason: collision with root package name */
    private final Deque<com.mbridge.msdk.thrid.okhttp.internal.connection.c> f37935d;

    /* renamed from: e, reason: collision with root package name */
    final com.mbridge.msdk.thrid.okhttp.internal.connection.d f37936e;

    /* renamed from: f, reason: collision with root package name */
    boolean f37937f;

    /* loaded from: classes5.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                long a11 = h.this.a(System.nanoTime());
                if (a11 == -1) {
                    return;
                }
                if (a11 > 0) {
                    long j11 = a11 / 1000000;
                    long j12 = a11 - (1000000 * j11);
                    synchronized (h.this) {
                        try {
                            h.this.wait(j11, (int) j12);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    public h() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public h(int i11, long j11, TimeUnit timeUnit) {
        this.f37934c = new a();
        this.f37935d = new ArrayDeque();
        this.f37936e = new com.mbridge.msdk.thrid.okhttp.internal.connection.d();
        this.f37932a = i11;
        this.f37933b = timeUnit.toNanos(j11);
        if (j11 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j11);
    }

    private int a(com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar, long j11) {
        List<Reference<com.mbridge.msdk.thrid.okhttp.internal.connection.g>> list = cVar.f38007n;
        int i11 = 0;
        while (i11 < list.size()) {
            Reference<com.mbridge.msdk.thrid.okhttp.internal.connection.g> reference = list.get(i11);
            if (reference.get() != null) {
                i11++;
            } else {
                com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().a("A connection to " + cVar.c().a().k() + " was leaked. Did you forget to close a response body?", ((g.a) reference).f38037a);
                list.remove(i11);
                cVar.f38004k = true;
                if (list.isEmpty()) {
                    cVar.f38008o = j11 - this.f37933b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    long a(long j11) {
        synchronized (this) {
            try {
                com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar = null;
                long j12 = Long.MIN_VALUE;
                int i11 = 0;
                int i12 = 0;
                for (com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar2 : this.f37935d) {
                    if (a(cVar2, j11) > 0) {
                        i12++;
                    } else {
                        i11++;
                        long j13 = j11 - cVar2.f38008o;
                        if (j13 > j12) {
                            cVar = cVar2;
                            j12 = j13;
                        }
                    }
                }
                long j14 = this.f37933b;
                if (j12 < j14 && i11 <= this.f37932a) {
                    if (i11 > 0) {
                        return j14 - j12;
                    }
                    if (i12 > 0) {
                        return j14;
                    }
                    this.f37937f = false;
                    return -1L;
                }
                this.f37935d.remove(cVar);
                com.mbridge.msdk.thrid.okhttp.internal.c.a(cVar.g());
                return 0L;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.mbridge.msdk.thrid.okhttp.internal.connection.c a(com.mbridge.msdk.thrid.okhttp.a aVar, com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar, a0 a0Var) {
        if (!f37931h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar : this.f37935d) {
            if (cVar.a(aVar, a0Var)) {
                gVar.a(cVar, true);
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Socket a(com.mbridge.msdk.thrid.okhttp.a aVar, com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar) {
        if (!f37931h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar : this.f37935d) {
            if (cVar.a(aVar, null) && cVar.f() && cVar != gVar.c()) {
                return gVar.b(cVar);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar) {
        if (!f37931h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (cVar.f38004k || this.f37932a == 0) {
            this.f37935d.remove(cVar);
            return true;
        }
        notifyAll();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar) {
        if (!f37931h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.f37937f) {
            this.f37937f = true;
            f37930g.execute(this.f37934c);
        }
        this.f37935d.add(cVar);
    }
}
