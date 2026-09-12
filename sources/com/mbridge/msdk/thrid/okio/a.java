package com.mbridge.msdk.thrid.okio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class a extends t {

    /* renamed from: h, reason: collision with root package name */
    private static final long f38472h;

    /* renamed from: i, reason: collision with root package name */
    private static final long f38473i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    static a f38474j;

    /* renamed from: e, reason: collision with root package name */
    private boolean f38475e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private a f38476f;

    /* renamed from: g, reason: collision with root package name */
    private long f38477g;

    /* renamed from: com.mbridge.msdk.thrid.okio.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0553a implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f38478a;

        C0553a(r rVar) {
            this.f38478a = rVar;
        }

        @Override // com.mbridge.msdk.thrid.okio.r
        public void a(com.mbridge.msdk.thrid.okio.c cVar, long j11) throws IOException {
            u.a(cVar.f38486b, 0L, j11);
            while (true) {
                long j12 = 0;
                if (j11 <= 0) {
                    return;
                }
                o oVar = cVar.f38485a;
                while (true) {
                    if (j12 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                        break;
                    }
                    j12 += oVar.f38520c - oVar.f38519b;
                    if (j12 >= j11) {
                        j12 = j11;
                        break;
                    }
                    oVar = oVar.f38523f;
                }
                a.this.h();
                try {
                    try {
                        this.f38478a.a(cVar, j12);
                        j11 -= j12;
                        a.this.a(true);
                    } catch (IOException e11) {
                        throw a.this.a(e11);
                    }
                } catch (Throwable th2) {
                    a.this.a(false);
                    throw th2;
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.r
        public t b() {
            return a.this;
        }

        @Override // com.mbridge.msdk.thrid.okio.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a.this.h();
            try {
                try {
                    this.f38478a.close();
                    a.this.a(true);
                } catch (IOException e11) {
                    throw a.this.a(e11);
                }
            } catch (Throwable th2) {
                a.this.a(false);
                throw th2;
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.r, java.io.Flushable
        public void flush() throws IOException {
            a.this.h();
            try {
                try {
                    this.f38478a.flush();
                    a.this.a(true);
                } catch (IOException e11) {
                    throw a.this.a(e11);
                }
            } catch (Throwable th2) {
                a.this.a(false);
                throw th2;
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f38478a + ")";
        }
    }

    /* loaded from: classes5.dex */
    class b implements s {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f38480a;

        b(s sVar) {
            this.f38480a = sVar;
        }

        @Override // com.mbridge.msdk.thrid.okio.s
        public long b(com.mbridge.msdk.thrid.okio.c cVar, long j11) throws IOException {
            a.this.h();
            try {
                try {
                    long b11 = this.f38480a.b(cVar, j11);
                    a.this.a(true);
                    return b11;
                } catch (IOException e11) {
                    throw a.this.a(e11);
                }
            } catch (Throwable th2) {
                a.this.a(false);
                throw th2;
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.s
        public t b() {
            return a.this;
        }

        @Override // com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                try {
                    this.f38480a.close();
                    a.this.a(true);
                } catch (IOException e11) {
                    throw a.this.a(e11);
                }
            } catch (Throwable th2) {
                a.this.a(false);
                throw th2;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f38480a + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class c extends Thread {
        c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0017, code lost:
        
            r1.j();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<com.mbridge.msdk.thrid.okio.a> r0 = com.mbridge.msdk.thrid.okio.a.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                com.mbridge.msdk.thrid.okio.a r1 = com.mbridge.msdk.thrid.okio.a.g()     // Catch: java.lang.Throwable -> Lb
                if (r1 != 0) goto Ld
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                goto L0
            Lb:
                r1 = move-exception
                goto L1b
            Ld:
                com.mbridge.msdk.thrid.okio.a r2 = com.mbridge.msdk.thrid.okio.a.f38474j     // Catch: java.lang.Throwable -> Lb
                if (r1 != r2) goto L16
                r1 = 0
                com.mbridge.msdk.thrid.okio.a.f38474j = r1     // Catch: java.lang.Throwable -> Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                return
            L16:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                r1.j()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L1b:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
                throw r1     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okio.a.c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f38472h = millis;
        f38473i = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    private static synchronized void a(a aVar, long j11, boolean z10) {
        synchronized (a.class) {
            try {
                if (f38474j == null) {
                    f38474j = new a();
                    new c().start();
                }
                long nanoTime = System.nanoTime();
                if (j11 != 0 && z10) {
                    aVar.f38477g = Math.min(j11, aVar.c() - nanoTime) + nanoTime;
                } else if (j11 != 0) {
                    aVar.f38477g = j11 + nanoTime;
                } else {
                    if (!z10) {
                        throw new AssertionError();
                    }
                    aVar.f38477g = aVar.c();
                }
                long b11 = aVar.b(nanoTime);
                a aVar2 = f38474j;
                while (true) {
                    a aVar3 = aVar2.f38476f;
                    if (aVar3 == null || b11 < aVar3.b(nanoTime)) {
                        break;
                    } else {
                        aVar2 = aVar2.f38476f;
                    }
                }
                aVar.f38476f = aVar2.f38476f;
                aVar2.f38476f = aVar;
                if (aVar2 == f38474j) {
                    a.class.notify();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static synchronized boolean a(a aVar) {
        synchronized (a.class) {
            a aVar2 = f38474j;
            while (aVar2 != null) {
                a aVar3 = aVar2.f38476f;
                if (aVar3 == aVar) {
                    aVar2.f38476f = aVar.f38476f;
                    aVar.f38476f = null;
                    return false;
                }
                aVar2 = aVar3;
            }
            return true;
        }
    }

    private long b(long j11) {
        return this.f38477g - j11;
    }

    @Nullable
    static a g() throws InterruptedException {
        a aVar = f38474j.f38476f;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            a.class.wait(f38472h);
            if (f38474j.f38476f != null || System.nanoTime() - nanoTime < f38473i) {
                return null;
            }
            return f38474j;
        }
        long b11 = aVar.b(System.nanoTime());
        if (b11 > 0) {
            long j11 = b11 / 1000000;
            a.class.wait(j11, (int) (b11 - (1000000 * j11)));
            return null;
        }
        f38474j.f38476f = aVar.f38476f;
        aVar.f38476f = null;
        return aVar;
    }

    public final r a(r rVar) {
        return new C0553a(rVar);
    }

    public final s a(s sVar) {
        return new b(sVar);
    }

    final IOException a(IOException iOException) throws IOException {
        return !i() ? iOException : b(iOException);
    }

    final void a(boolean z10) throws IOException {
        if (i() && z10) {
            throw b((IOException) null);
        }
    }

    protected IOException b(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final void h() {
        if (this.f38475e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long f11 = f();
        boolean d11 = d();
        if (f11 != 0 || d11) {
            this.f38475e = true;
            a(this, f11, d11);
        }
    }

    public final boolean i() {
        if (!this.f38475e) {
            return false;
        }
        this.f38475e = false;
        return a(this);
    }

    protected void j() {
    }
}
