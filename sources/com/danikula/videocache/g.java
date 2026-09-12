package com.danikula.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
final class g {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f24089a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    private final String f24090b;

    /* renamed from: c, reason: collision with root package name */
    private volatile e f24091c;

    /* renamed from: d, reason: collision with root package name */
    private final List f24092d;

    /* renamed from: e, reason: collision with root package name */
    private final b f24093e;

    /* renamed from: f, reason: collision with root package name */
    private final c f24094f;

    /* loaded from: classes3.dex */
    private static final class a extends Handler implements b {

        /* renamed from: a, reason: collision with root package name */
        private final String f24095a;

        /* renamed from: b, reason: collision with root package name */
        private final List f24096b;

        public a(String str, List list) {
            super(Looper.getMainLooper());
            this.f24095a = str;
            this.f24096b = list;
        }

        @Override // com.danikula.videocache.b
        public void a(String str, int i11) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i11;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Iterator it = this.f24096b.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(this.f24095a, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f24092d = copyOnWriteArrayList;
        this.f24090b = (String) l.c(str);
        this.f24094f = (c) l.c(cVar);
        this.f24093e = new a(str, copyOnWriteArrayList);
    }

    private e c() {
        e eVar = new e(this.f24094f.f24081c);
        this.f24094f.f24081c.B();
        eVar.l(this.f24093e);
        return eVar;
    }

    private synchronized void e() {
        try {
            this.f24091c = this.f24091c == null ? c() : this.f24091c;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void a() {
        try {
            if (this.f24089a.decrementAndGet() <= 0) {
                if (this.f24091c != null) {
                    this.f24091c.e();
                }
                this.f24091c = null;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public int b() {
        return this.f24089a.get();
    }

    public void d(d dVar, Socket socket) {
        e();
        try {
            this.f24089a.incrementAndGet();
            this.f24091c.f();
            this.f24091c.k(dVar, socket);
        } finally {
            q.f("processRequest， shutdown, threadName = " + Thread.currentThread().getName());
            a();
        }
    }

    public void f() {
        if (this.f24091c != null) {
            this.f24091c.g();
        }
    }
}
