package com.elvishew.xlog.printer.file;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public class FilePrinter implements e8.c {

    /* renamed from: a, reason: collision with root package name */
    private final String f24121a;

    /* renamed from: b, reason: collision with root package name */
    private final h8.b f24122b;

    /* renamed from: c, reason: collision with root package name */
    private final f8.a f24123c;

    /* renamed from: d, reason: collision with root package name */
    private final g8.a f24124d;

    /* renamed from: e, reason: collision with root package name */
    private r7.c f24125e;

    /* renamed from: f, reason: collision with root package name */
    private i8.b f24126f;

    /* renamed from: g, reason: collision with root package name */
    private volatile Worker f24127g = new Worker();

    /* loaded from: classes.dex */
    private class Worker implements Runnable {
        private BlockingQueue<c> logs;
        private volatile boolean started;

        private Worker() {
            this.logs = new LinkedBlockingQueue();
        }

        void enqueue(c cVar) {
            try {
                this.logs.put(cVar);
            } catch (InterruptedException e11) {
                e11.printStackTrace();
            }
        }

        boolean isStarted() {
            boolean z10;
            synchronized (this) {
                z10 = this.started;
            }
            return z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    c take = this.logs.take();
                    if (take == null) {
                        return;
                    } else {
                        FilePrinter.this.e(take.f24134a, take.f24135b, take.f24136c, take.f24137d);
                    }
                } catch (InterruptedException e11) {
                    e11.printStackTrace();
                    synchronized (this) {
                        this.started = false;
                        return;
                    }
                }
            }
        }

        void start() {
            synchronized (this) {
                try {
                    if (this.started) {
                        return;
                    }
                    new Thread(this).start();
                    this.started = true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        String f24128a;

        /* renamed from: b, reason: collision with root package name */
        h8.b f24129b;

        /* renamed from: c, reason: collision with root package name */
        f8.a f24130c;

        /* renamed from: d, reason: collision with root package name */
        g8.a f24131d;

        /* renamed from: e, reason: collision with root package name */
        r7.c f24132e;

        /* renamed from: f, reason: collision with root package name */
        i8.b f24133f;

        public b(String str) {
            this.f24128a = str;
        }

        private void e() {
            if (this.f24129b == null) {
                this.f24129b = b8.a.e();
            }
            if (this.f24130c == null) {
                this.f24130c = b8.a.b();
            }
            if (this.f24131d == null) {
                this.f24131d = b8.a.d();
            }
            if (this.f24132e == null) {
                this.f24132e = b8.a.g();
            }
            if (this.f24133f == null) {
                this.f24133f = b8.a.m();
            }
        }

        public b a(f8.b bVar) {
            if (!(bVar instanceof f8.a)) {
                bVar = new c8.a(bVar);
            }
            f8.a aVar = (f8.a) bVar;
            this.f24130c = aVar;
            c8.b.b(aVar);
            return this;
        }

        public FilePrinter b() {
            e();
            return new FilePrinter(this);
        }

        public b c(g8.a aVar) {
            this.f24131d = aVar;
            return this;
        }

        public b d(h8.b bVar) {
            this.f24129b = bVar;
            return this;
        }

        public b f(r7.c cVar) {
            this.f24132e = cVar;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        long f24134a;

        /* renamed from: b, reason: collision with root package name */
        int f24135b;

        /* renamed from: c, reason: collision with root package name */
        String f24136c;

        /* renamed from: d, reason: collision with root package name */
        String f24137d;

        c(long j11, int i11, String str, String str2) {
            this.f24134a = j11;
            this.f24135b = i11;
            this.f24136c = str;
            this.f24137d = str2;
        }
    }

    FilePrinter(b bVar) {
        this.f24121a = bVar.f24128a;
        this.f24122b = bVar.f24129b;
        this.f24123c = bVar.f24130c;
        this.f24124d = bVar.f24131d;
        this.f24125e = bVar.f24132e;
        this.f24126f = bVar.f24133f;
        c();
    }

    private void c() {
        File file = new File(this.f24121a);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    private void d() {
        File[] listFiles = new File(this.f24121a).listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (this.f24124d.a(file)) {
                file.delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(long j11, int i11, String str, String str2) {
        String d11 = this.f24126f.d();
        boolean e11 = this.f24126f.e();
        if (d11 == null || !e11 || this.f24122b.b()) {
            String a11 = this.f24122b.a(i11, System.currentTimeMillis());
            if (a11 == null || a11.trim().length() == 0) {
                b8.b.e().c("File name should not be empty, ignore log: " + str2);
                return;
            }
            if (!a11.equals(d11) || !e11) {
                this.f24126f.b();
                d();
                if (!this.f24126f.f(new File(this.f24121a, a11))) {
                    return;
                } else {
                    d11 = a11;
                }
            }
        }
        File c11 = this.f24126f.c();
        if (this.f24123c.b(c11)) {
            this.f24126f.b();
            c8.b.a(c11, this.f24123c);
            if (!this.f24126f.f(new File(this.f24121a, d11))) {
                return;
            }
        }
        this.f24126f.a(this.f24125e.a(j11, i11, str, str2).toString());
    }

    @Override // e8.c
    public void a(int i11, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f24127g.isStarted()) {
            this.f24127g.start();
        }
        this.f24127g.enqueue(new c(currentTimeMillis, i11, str, str2));
    }
}
