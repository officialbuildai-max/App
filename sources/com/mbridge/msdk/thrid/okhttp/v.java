package com.mbridge.msdk.thrid.okhttp;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class v implements d {

    /* renamed from: a, reason: collision with root package name */
    final t f38421a;

    /* renamed from: b, reason: collision with root package name */
    final com.mbridge.msdk.thrid.okhttp.internal.http.j f38422b;

    /* renamed from: c, reason: collision with root package name */
    final com.mbridge.msdk.thrid.okio.a f38423c;

    /* renamed from: d, reason: collision with root package name */
    private n f38424d;

    /* renamed from: e, reason: collision with root package name */
    final w f38425e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f38426f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f38427g;

    /* loaded from: classes5.dex */
    class a extends com.mbridge.msdk.thrid.okio.a {
        a() {
        }

        @Override // com.mbridge.msdk.thrid.okio.a
        protected void j() {
            v.this.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public final class b extends com.mbridge.msdk.thrid.okhttp.internal.b {

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ boolean f38429c = true;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ v f38430b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(ExecutorService executorService) {
            if (!f38429c && Thread.holdsLock(this.f38430b.f38421a.j())) {
                throw new AssertionError();
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e11) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e11);
                    this.f38430b.f38424d.callFailed(this.f38430b, interruptedIOException);
                    throw null;
                }
            } catch (Throwable th2) {
                this.f38430b.f38421a.j().a(this);
                throw th2;
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        protected void b() {
            boolean z10;
            Throwable th2;
            this.f38430b.f38423c.h();
            try {
                try {
                    this.f38430b.c();
                    try {
                        throw null;
                    } catch (Throwable th3) {
                        th2 = th3;
                        z10 = true;
                        this.f38430b.cancel();
                        if (z10) {
                            throw th2;
                        }
                        new IOException("canceled due to " + th2);
                        throw null;
                    }
                } catch (Throwable th4) {
                    this.f38430b.f38421a.j().a(this);
                    throw th4;
                }
            } catch (IOException e11) {
                this.f38430b.f38424d.callFailed(this.f38430b, this.f38430b.a(e11));
                throw null;
            } catch (Throwable th5) {
                z10 = false;
                th2 = th5;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public v c() {
            return this.f38430b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String d() {
            return this.f38430b.f38425e.g().g();
        }
    }

    private v(t tVar, w wVar, boolean z10) {
        this.f38421a = tVar;
        this.f38425e = wVar;
        this.f38426f = z10;
        this.f38422b = new com.mbridge.msdk.thrid.okhttp.internal.http.j(tVar, z10);
        a aVar = new a();
        this.f38423c = aVar;
        aVar.a(tVar.b(), TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static v a(t tVar, w wVar, boolean z10) {
        v vVar = new v(tVar, wVar, z10);
        vVar.f38424d = tVar.l().a(vVar);
        return vVar;
    }

    private void a() {
        this.f38422b.a(com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().a("response.body().close()"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IOException a(IOException iOException) {
        if (!this.f38423c.i()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public v clone() {
        return a(this.f38421a, this.f38425e, this.f38426f);
    }

    y c() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f38421a.p());
        arrayList.add(this.f38422b);
        arrayList.add(new com.mbridge.msdk.thrid.okhttp.internal.http.a(this.f38421a.i()));
        this.f38421a.q();
        arrayList.add(new com.mbridge.msdk.thrid.okhttp.internal.cache.a(null));
        arrayList.add(new com.mbridge.msdk.thrid.okhttp.internal.connection.a(this.f38421a));
        if (!this.f38426f) {
            arrayList.addAll(this.f38421a.r());
        }
        arrayList.add(new com.mbridge.msdk.thrid.okhttp.internal.http.b(this.f38426f));
        y a11 = new com.mbridge.msdk.thrid.okhttp.internal.http.g(arrayList, null, null, null, 0, this.f38425e, this, this.f38424d, this.f38421a.e(), this.f38421a.y(), this.f38421a.C()).a(this.f38425e);
        if (!this.f38422b.b()) {
            return a11;
        }
        com.mbridge.msdk.thrid.okhttp.internal.c.a(a11);
        throw new IOException("Canceled");
    }

    @Override // com.mbridge.msdk.thrid.okhttp.d
    public void cancel() {
        this.f38422b.a();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.d
    public y d() throws IOException {
        synchronized (this) {
            if (this.f38427g) {
                throw new IllegalStateException("Already Executed");
            }
            this.f38427g = true;
        }
        a();
        this.f38423c.h();
        this.f38424d.callStart(this);
        try {
            try {
                this.f38421a.j().a(this);
                y c11 = c();
                if (c11 != null) {
                    return c11;
                }
                throw new IOException("Canceled");
            } catch (IOException e11) {
                IOException a11 = a(e11);
                this.f38424d.callFailed(this, a11);
                throw a11;
            }
        } finally {
            this.f38421a.j().b(this);
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.d
    public boolean h() {
        return this.f38422b.b();
    }
}
