package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.ConnectionPool;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.Sink;
import okio.Timeout;

/* loaded from: classes5.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final Address f40598a;

    /* renamed from: b, reason: collision with root package name */
    private final ConnectionPool f40599b;

    /* renamed from: c, reason: collision with root package name */
    private l f40600c;

    /* renamed from: d, reason: collision with root package name */
    private df.a f40601d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f40602e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f40603f;

    /* renamed from: g, reason: collision with root package name */
    private HttpStream f40604g;

    public n(ConnectionPool connectionPool, Address address) {
        this.f40599b = connectionPool;
        this.f40598a = address;
    }

    private void e(IOException iOException) {
        synchronized (this.f40599b) {
            try {
                if (this.f40600c != null) {
                    df.a aVar = this.f40601d;
                    if (aVar.f61468g == 0) {
                        this.f40600c.a(aVar.getRoute(), iOException);
                    } else {
                        this.f40600c = null;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        d();
    }

    private void f(boolean z10, boolean z11, boolean z12) {
        df.a aVar;
        df.a aVar2;
        synchronized (this.f40599b) {
            aVar = null;
            if (z12) {
                try {
                    this.f40604g = null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (z11) {
                this.f40602e = true;
            }
            df.a aVar3 = this.f40601d;
            if (aVar3 != null) {
                if (z10) {
                    aVar3.f61472k = true;
                }
                if (this.f40604g == null && (this.f40602e || aVar3.f61472k)) {
                    p(aVar3);
                    df.a aVar4 = this.f40601d;
                    if (aVar4.f61468g > 0) {
                        this.f40600c = null;
                    }
                    if (aVar4.f61471j.isEmpty()) {
                        this.f40601d.f61473l = System.nanoTime();
                        if (com.squareup.okhttp.internal.c.instance.connectionBecameIdle(this.f40599b, this.f40601d)) {
                            aVar2 = this.f40601d;
                            this.f40601d = null;
                            aVar = aVar2;
                        }
                    }
                    aVar2 = null;
                    this.f40601d = null;
                    aVar = aVar2;
                }
            }
        }
        if (aVar != null) {
            com.squareup.okhttp.internal.g.d(aVar.getSocket());
        }
    }

    private df.a g(int i11, int i12, int i13, boolean z10) {
        synchronized (this.f40599b) {
            try {
                if (this.f40602e) {
                    throw new IllegalStateException("released");
                }
                if (this.f40604g != null) {
                    throw new IllegalStateException("stream != null");
                }
                if (this.f40603f) {
                    throw new IOException("Canceled");
                }
                df.a aVar = this.f40601d;
                if (aVar != null && !aVar.f61472k) {
                    return aVar;
                }
                df.a aVar2 = com.squareup.okhttp.internal.c.instance.get(this.f40599b, this.f40598a, this);
                if (aVar2 != null) {
                    this.f40601d = aVar2;
                    return aVar2;
                }
                if (this.f40600c == null) {
                    this.f40600c = new l(this.f40598a, q());
                }
                df.a aVar3 = new df.a(this.f40600c.g());
                a(aVar3);
                synchronized (this.f40599b) {
                    com.squareup.okhttp.internal.c.instance.put(this.f40599b, aVar3);
                    this.f40601d = aVar3;
                    if (this.f40603f) {
                        throw new IOException("Canceled");
                    }
                }
                aVar3.c(i11, i12, i13, this.f40598a.getConnectionSpecs(), z10);
                q().a(aVar3.getRoute());
                return aVar3;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private df.a h(int i11, int i12, int i13, boolean z10, boolean z11) {
        while (true) {
            df.a g11 = g(i11, i12, i13, z10);
            synchronized (this.f40599b) {
                try {
                    if (g11.f61468g == 0) {
                        return g11;
                    }
                    if (g11.h(z11)) {
                        return g11;
                    }
                    d();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private boolean i(RouteException routeException) {
        IOException lastConnectException = routeException.getLastConnectException();
        if (lastConnectException instanceof ProtocolException) {
            return false;
        }
        return lastConnectException instanceof InterruptedIOException ? lastConnectException instanceof SocketTimeoutException : (((lastConnectException instanceof SSLHandshakeException) && (lastConnectException.getCause() instanceof CertificateException)) || (lastConnectException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private boolean j(IOException iOException) {
        return ((iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) ? false : true;
    }

    private void p(df.a aVar) {
        int size = aVar.f61471j.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((Reference) aVar.f61471j.get(i11)).get() == this) {
                aVar.f61471j.remove(i11);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private com.squareup.okhttp.internal.f q() {
        return com.squareup.okhttp.internal.c.instance.routeDatabase(this.f40599b);
    }

    public void a(df.a aVar) {
        aVar.f61471j.add(new WeakReference(this));
    }

    public void b() {
        HttpStream httpStream;
        df.a aVar;
        synchronized (this.f40599b) {
            this.f40603f = true;
            httpStream = this.f40604g;
            aVar = this.f40601d;
        }
        if (httpStream != null) {
            httpStream.cancel();
        } else if (aVar != null) {
            aVar.b();
        }
    }

    public synchronized df.a c() {
        return this.f40601d;
    }

    public void d() {
        f(true, false, true);
    }

    public HttpStream k(int i11, int i12, int i13, boolean z10, boolean z11) {
        HttpStream dVar;
        try {
            df.a h11 = h(i11, i12, i13, z10, z11);
            if (h11.f61467f != null) {
                dVar = new e(this, h11.f61467f);
            } else {
                h11.getSocket().setSoTimeout(i12);
                Timeout timeout = h11.f61469h.getTimeout();
                long j11 = i12;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                timeout.timeout(j11, timeUnit);
                h11.f61470i.getTimeout().timeout(i13, timeUnit);
                dVar = new d(this, h11.f61469h, h11.f61470i);
            }
            synchronized (this.f40599b) {
                h11.f61468g++;
                this.f40604g = dVar;
            }
            return dVar;
        } catch (IOException e11) {
            throw new RouteException(e11);
        }
    }

    public void l() {
        f(true, false, false);
    }

    public boolean m(RouteException routeException) {
        if (this.f40601d != null) {
            e(routeException.getLastConnectException());
        }
        l lVar = this.f40600c;
        return (lVar == null || lVar.c()) && i(routeException);
    }

    public boolean n(IOException iOException, Sink sink) {
        df.a aVar = this.f40601d;
        if (aVar != null) {
            int i11 = aVar.f61468g;
            e(iOException);
            if (i11 == 1) {
                return false;
            }
        }
        boolean z10 = sink == null || (sink instanceof k);
        l lVar = this.f40600c;
        return (lVar == null || lVar.c()) && j(iOException) && z10;
    }

    public void o() {
        f(false, true, false);
    }

    public void r(HttpStream httpStream) {
        synchronized (this.f40599b) {
            if (httpStream != null) {
                if (httpStream == this.f40604g) {
                }
            }
            throw new IllegalStateException("expected " + this.f40604g + " but was " + httpStream);
        }
        f(false, false, true);
    }

    public String toString() {
        return this.f40598a.toString();
    }
}
