package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.a0;
import com.mbridge.msdk.thrid.okhttp.n;
import com.mbridge.msdk.thrid.okhttp.q;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.t;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.x;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okhttp.z;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes5.dex */
public final class j implements r {

    /* renamed from: a, reason: collision with root package name */
    private final t f38061a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f38062b;

    /* renamed from: c, reason: collision with root package name */
    private volatile com.mbridge.msdk.thrid.okhttp.internal.connection.g f38063c;

    /* renamed from: d, reason: collision with root package name */
    private Object f38064d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f38065e;

    public j(t tVar, boolean z10) {
        this.f38061a = tVar;
        this.f38062b = z10;
    }

    private int a(y yVar, int i11) {
        String b11 = yVar.b("Retry-After");
        if (b11 == null) {
            return i11;
        }
        if (b11.matches("\\d+")) {
            return Integer.valueOf(b11).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private com.mbridge.msdk.thrid.okhttp.a a(q qVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        com.mbridge.msdk.thrid.okhttp.e eVar;
        if (qVar.h()) {
            sSLSocketFactory = this.f38061a.B();
            hostnameVerifier = this.f38061a.o();
            eVar = this.f38061a.c();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            eVar = null;
        }
        return new com.mbridge.msdk.thrid.okhttp.a(qVar.g(), qVar.j(), this.f38061a.k(), this.f38061a.A(), sSLSocketFactory, hostnameVerifier, eVar, this.f38061a.w(), this.f38061a.v(), this.f38061a.u(), this.f38061a.g(), this.f38061a.x());
    }

    private w a(y yVar, a0 a0Var) throws IOException {
        String b11;
        q e11;
        if (yVar == null) {
            throw new IllegalStateException();
        }
        int k11 = yVar.k();
        String e12 = yVar.r().e();
        if (k11 == 307 || k11 == 308) {
            if (!e12.equals("GET") && !e12.equals("HEAD")) {
                return null;
            }
        } else {
            if (k11 == 401) {
                return this.f38061a.a().a(a0Var, yVar);
            }
            if (k11 == 503) {
                if ((yVar.p() == null || yVar.p().k() != 503) && a(yVar, Integer.MAX_VALUE) == 0) {
                    return yVar.r();
                }
                return null;
            }
            if (k11 == 407) {
                if (a0Var.b().type() == Proxy.Type.HTTP) {
                    return this.f38061a.w().a(a0Var, yVar);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (k11 == 408) {
                if (!this.f38061a.z()) {
                    return null;
                }
                yVar.r().a();
                if ((yVar.p() == null || yVar.p().k() != 408) && a(yVar, 0) <= 0) {
                    return yVar.r();
                }
                return null;
            }
            switch (k11) {
                case 300:
                case MRAID_ERROR_VALUE:
                case INVALID_IFA_STATUS_VALUE:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.f38061a.m() || (b11 = yVar.b(HttpHeaders.LOCATION)) == null || (e11 = yVar.r().g().e(b11)) == null) {
            return null;
        }
        if (!e11.l().equals(yVar.r().g().l()) && !this.f38061a.n()) {
            return null;
        }
        w.a f11 = yVar.r().f();
        if (f.a(e12)) {
            boolean c11 = f.c(e12);
            if (f.b(e12)) {
                f11.a("GET", (x) null);
            } else {
                f11.a(e12, c11 ? yVar.r().a() : null);
            }
            if (!c11) {
                f11.a("Transfer-Encoding");
                f11.a(HttpHeaders.CONTENT_LENGTH);
                f11.a(HttpHeaders.CONTENT_TYPE);
            }
        }
        if (!a(yVar, e11)) {
            f11.a(HttpHeaders.AUTHORIZATION);
        }
        return f11.a(e11).a();
    }

    private boolean a(y yVar, q qVar) {
        q g11 = yVar.r().g();
        return g11.g().equals(qVar.g()) && g11.j() == qVar.j() && g11.l().equals(qVar.l());
    }

    private boolean a(IOException iOException, com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar, boolean z10, w wVar) {
        gVar.a(iOException);
        if (this.f38061a.z()) {
            return !(z10 && a(iOException, wVar)) && a(iOException, z10) && gVar.d();
        }
        return false;
    }

    private boolean a(IOException iOException, w wVar) {
        wVar.a();
        return iOException instanceof FileNotFoundException;
    }

    private boolean a(IOException iOException, boolean z10) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z10 : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r
    public y a(r.a aVar) throws IOException {
        y a11;
        w a12;
        w d11 = aVar.d();
        g gVar = (g) aVar;
        com.mbridge.msdk.thrid.okhttp.d e11 = gVar.e();
        n g11 = gVar.g();
        com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar2 = new com.mbridge.msdk.thrid.okhttp.internal.connection.g(this.f38061a.f(), a(d11.g()), e11, g11, this.f38064d);
        this.f38063c = gVar2;
        int i11 = 0;
        y yVar = null;
        while (!this.f38065e) {
            try {
                try {
                    a11 = gVar.a(d11, gVar2, null, null);
                    if (yVar != null) {
                        a11 = a11.o().d(yVar.o().a((z) null).a()).a();
                    }
                    try {
                        a12 = a(a11, gVar2.h());
                    } catch (IOException e12) {
                        gVar2.f();
                        throw e12;
                    }
                } catch (com.mbridge.msdk.thrid.okhttp.internal.connection.e e13) {
                    if (!a(e13.b(), gVar2, false, d11)) {
                        throw e13.a();
                    }
                } catch (IOException e14) {
                    if (!a(e14, gVar2, !(e14 instanceof com.mbridge.msdk.thrid.okhttp.internal.http2.a), d11)) {
                        throw e14;
                    }
                }
                if (a12 == null) {
                    gVar2.f();
                    return a11;
                }
                com.mbridge.msdk.thrid.okhttp.internal.c.a(a11.d());
                int i12 = i11 + 1;
                if (i12 > 20) {
                    gVar2.f();
                    throw new ProtocolException("Too many follow-up requests: " + i12);
                }
                a12.a();
                if (!a(a11, a12.g())) {
                    gVar2.f();
                    gVar2 = new com.mbridge.msdk.thrid.okhttp.internal.connection.g(this.f38061a.f(), a(a12.g()), e11, g11, this.f38064d);
                    this.f38063c = gVar2;
                } else if (gVar2.b() != null) {
                    throw new IllegalStateException("Closing the body of " + a11 + " didn't close its backing stream. Bad interceptor?");
                }
                yVar = a11;
                d11 = a12;
                i11 = i12;
            } catch (Throwable th2) {
                gVar2.a((IOException) null);
                gVar2.f();
                throw th2;
            }
        }
        gVar2.f();
        throw new IOException("Canceled");
    }

    public void a() {
        this.f38065e = true;
        com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar = this.f38063c;
        if (gVar != null) {
            gVar.a();
        }
    }

    public void a(Object obj) {
        this.f38064d = obj;
    }

    public boolean b() {
        return this.f38065e;
    }
}
