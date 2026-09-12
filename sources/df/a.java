package df;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.e;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.g;
import com.squareup.okhttp.internal.h;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.d;
import ef.b;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/* loaded from: classes5.dex */
public final class a implements Connection {

    /* renamed from: a, reason: collision with root package name */
    private final Route f61462a;

    /* renamed from: b, reason: collision with root package name */
    private Socket f61463b;

    /* renamed from: c, reason: collision with root package name */
    public Socket f61464c;

    /* renamed from: d, reason: collision with root package name */
    private Handshake f61465d;

    /* renamed from: e, reason: collision with root package name */
    private Protocol f61466e;

    /* renamed from: f, reason: collision with root package name */
    public volatile FramedConnection f61467f;

    /* renamed from: g, reason: collision with root package name */
    public int f61468g;

    /* renamed from: h, reason: collision with root package name */
    public BufferedSource f61469h;

    /* renamed from: i, reason: collision with root package name */
    public BufferedSink f61470i;

    /* renamed from: k, reason: collision with root package name */
    public boolean f61472k;

    /* renamed from: j, reason: collision with root package name */
    public final List f61471j = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public long f61473l = Long.MAX_VALUE;

    public a(Route route) {
        this.f61462a = route;
    }

    private void d(int i11, int i12, int i13, com.squareup.okhttp.internal.a aVar) {
        this.f61463b.setSoTimeout(i12);
        try {
            e.f().d(this.f61463b, this.f61462a.getSocketAddress(), i11);
            this.f61469h = Okio.buffer(Okio.source(this.f61463b));
            this.f61470i = Okio.buffer(Okio.sink(this.f61463b));
            if (this.f61462a.getAddress().getSslSocketFactory() != null) {
                e(i12, i13, aVar);
            } else {
                this.f61466e = Protocol.HTTP_1_1;
                this.f61464c = this.f61463b;
            }
            Protocol protocol = this.f61466e;
            if (protocol == Protocol.SPDY_3 || protocol == Protocol.HTTP_2) {
                this.f61464c.setSoTimeout(0);
                FramedConnection i14 = new FramedConnection.a(true).k(this.f61464c, this.f61462a.getAddress().url().host(), this.f61469h, this.f61470i).j(this.f61466e).i();
                i14.x0();
                this.f61467f = i14;
            }
        } catch (ConnectException unused) {
            throw new ConnectException("Failed to connect to " + this.f61462a.getSocketAddress());
        }
    }

    private void e(int i11, int i12, com.squareup.okhttp.internal.a aVar) {
        SSLSocket sSLSocket;
        if (this.f61462a.requiresTunnel()) {
            f(i11, i12);
        }
        Address address = this.f61462a.getAddress();
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) address.getSslSocketFactory().createSocket(this.f61463b, address.getUriHost(), address.getUriPort(), true);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (AssertionError e11) {
            e = e11;
        }
        try {
            ConnectionSpec a11 = aVar.a(sSLSocket);
            if (a11.supportsTlsExtensions()) {
                e.f().c(sSLSocket, address.getUriHost(), address.getProtocols());
            }
            sSLSocket.startHandshake();
            Handshake handshake = Handshake.get(sSLSocket.getSession());
            if (address.getHostnameVerifier().verify(address.getUriHost(), sSLSocket.getSession())) {
                address.getCertificatePinner().check(address.getUriHost(), handshake.peerCertificates());
                String h11 = a11.supportsTlsExtensions() ? e.f().h(sSLSocket) : null;
                this.f61464c = sSLSocket;
                this.f61469h = Okio.buffer(Okio.source(sSLSocket));
                this.f61470i = Okio.buffer(Okio.sink(this.f61464c));
                this.f61465d = handshake;
                this.f61466e = h11 != null ? Protocol.get(h11) : Protocol.HTTP_1_1;
                e.f().a(sSLSocket);
                return;
            }
            X509Certificate x509Certificate = (X509Certificate) handshake.peerCertificates().get(0);
            throw new SSLPeerUnverifiedException("Hostname " + address.getUriHost() + " not verified:\n    certificate: " + CertificatePinner.pin(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + b.a(x509Certificate));
        } catch (AssertionError e12) {
            e = e12;
            if (!g.o(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th3) {
            th = th3;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                e.f().a(sSLSocket2);
            }
            g.d(sSLSocket2);
            throw th;
        }
    }

    private void f(int i11, int i12) {
        Request g11 = g();
        HttpUrl httpUrl = g11.httpUrl();
        String str = "CONNECT " + httpUrl.host() + ":" + httpUrl.port() + " HTTP/1.1";
        do {
            d dVar = new d(null, this.f61469h, this.f61470i);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f61469h.getTimeout().timeout(i11, timeUnit);
            this.f61470i.getTimeout().timeout(i12, timeUnit);
            dVar.p(g11.headers(), str);
            dVar.finishRequest();
            Response build = dVar.o().request(g11).build();
            long e11 = OkHeaders.e(build);
            if (e11 == -1) {
                e11 = 0;
            }
            Source l11 = dVar.l(e11);
            g.r(l11, Integer.MAX_VALUE, timeUnit);
            l11.close();
            int code = build.code();
            if (code == 200) {
                if (!this.f61469h.getBufferField().exhausted() || !this.f61470i.getBufferField().exhausted()) {
                    throw new IOException("TLS tunnel buffered too many bytes!");
                }
                return;
            } else {
                if (code != 407) {
                    throw new IOException("Unexpected response code for CONNECT: " + build.code());
                }
                g11 = OkHeaders.j(this.f61462a.getAddress().getAuthenticator(), build, this.f61462a.getProxy());
            }
        } while (g11 != null);
        throw new IOException("Failed to authenticate with proxy");
    }

    private Request g() {
        return new Request.Builder().url(this.f61462a.getAddress().url()).header(HttpHeaders.HOST, g.i(this.f61462a.getAddress().url())).header("Proxy-Connection", "Keep-Alive").header("User-Agent", h.a()).build();
    }

    public int a() {
        FramedConnection framedConnection = this.f61467f;
        if (framedConnection != null) {
            return framedConnection.h0();
        }
        return 1;
    }

    public void b() {
        g.d(this.f61463b);
    }

    public void c(int i11, int i12, int i13, List list, boolean z10) {
        Socket createSocket;
        if (this.f61466e != null) {
            throw new IllegalStateException("already connected");
        }
        com.squareup.okhttp.internal.a aVar = new com.squareup.okhttp.internal.a(list);
        Proxy proxy = this.f61462a.getProxy();
        Address address = this.f61462a.getAddress();
        if (this.f61462a.getAddress().getSslSocketFactory() == null && !list.contains(ConnectionSpec.CLEARTEXT)) {
            throw new RouteException(new UnknownServiceException("CLEARTEXT communication not supported: " + list));
        }
        RouteException routeException = null;
        while (this.f61466e == null) {
            try {
            } catch (IOException e11) {
                g.d(this.f61464c);
                g.d(this.f61463b);
                this.f61464c = null;
                this.f61463b = null;
                this.f61469h = null;
                this.f61470i = null;
                this.f61465d = null;
                this.f61466e = null;
                if (routeException == null) {
                    routeException = new RouteException(e11);
                } else {
                    routeException.addConnectException(e11);
                }
                if (!z10) {
                    throw routeException;
                }
                if (!aVar.b(e11)) {
                    throw routeException;
                }
            }
            if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.HTTP) {
                createSocket = new Socket(proxy);
                this.f61463b = createSocket;
                d(i11, i12, i13, aVar);
            }
            createSocket = address.getSocketFactory().createSocket();
            this.f61463b = createSocket;
            d(i11, i12, i13, aVar);
        }
    }

    @Override // com.squareup.okhttp.Connection
    public Handshake getHandshake() {
        return this.f61465d;
    }

    @Override // com.squareup.okhttp.Connection
    public Protocol getProtocol() {
        Protocol protocol = this.f61466e;
        return protocol != null ? protocol : Protocol.HTTP_1_1;
    }

    @Override // com.squareup.okhttp.Connection
    public Route getRoute() {
        return this.f61462a;
    }

    @Override // com.squareup.okhttp.Connection
    public Socket getSocket() {
        return this.f61464c;
    }

    public boolean h(boolean z10) {
        if (this.f61464c.isClosed() || this.f61464c.isInputShutdown() || this.f61464c.isOutputShutdown()) {
            return false;
        }
        if (this.f61467f == null && z10) {
            try {
                int soTimeout = this.f61464c.getSoTimeout();
                try {
                    this.f61464c.setSoTimeout(1);
                    return !this.f61469h.exhausted();
                } finally {
                    this.f61464c.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public boolean i() {
        return this.f61467f != null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connection{");
        sb2.append(this.f61462a.getAddress().url().host());
        sb2.append(":");
        sb2.append(this.f61462a.getAddress().url().port());
        sb2.append(", proxy=");
        sb2.append(this.f61462a.getProxy());
        sb2.append(" hostAddress=");
        sb2.append(this.f61462a.getSocketAddress());
        sb2.append(" cipherSuite=");
        Handshake handshake = this.f61465d;
        sb2.append(handshake != null ? handshake.cipherSuite() : "none");
        sb2.append(" protocol=");
        sb2.append(this.f61466e);
        sb2.append('}');
        return sb2.toString();
    }
}
