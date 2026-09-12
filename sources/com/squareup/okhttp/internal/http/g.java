package com.squareup.okhttp.internal.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.http.b;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: classes5.dex */
public final class g {

    /* renamed from: r, reason: collision with root package name */
    private static final ResponseBody f40554r = new a();

    /* renamed from: a, reason: collision with root package name */
    final OkHttpClient f40555a;

    /* renamed from: b, reason: collision with root package name */
    public final n f40556b;

    /* renamed from: c, reason: collision with root package name */
    private final Response f40557c;

    /* renamed from: d, reason: collision with root package name */
    private HttpStream f40558d;

    /* renamed from: e, reason: collision with root package name */
    long f40559e = -1;

    /* renamed from: f, reason: collision with root package name */
    private boolean f40560f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f40561g;

    /* renamed from: h, reason: collision with root package name */
    private final Request f40562h;

    /* renamed from: i, reason: collision with root package name */
    private Request f40563i;

    /* renamed from: j, reason: collision with root package name */
    private Response f40564j;

    /* renamed from: k, reason: collision with root package name */
    private Response f40565k;

    /* renamed from: l, reason: collision with root package name */
    private Sink f40566l;

    /* renamed from: m, reason: collision with root package name */
    private BufferedSink f40567m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f40568n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f40569o;

    /* renamed from: p, reason: collision with root package name */
    private CacheRequest f40570p;

    /* renamed from: q, reason: collision with root package name */
    private com.squareup.okhttp.internal.http.b f40571q;

    /* loaded from: classes5.dex */
    static class a extends ResponseBody {
        a() {
        }

        @Override // com.squareup.okhttp.ResponseBody
        public long contentLength() {
            return 0L;
        }

        @Override // com.squareup.okhttp.ResponseBody
        public MediaType contentType() {
            return null;
        }

        @Override // com.squareup.okhttp.ResponseBody
        public BufferedSource source() {
            return new Buffer();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Source {

        /* renamed from: a, reason: collision with root package name */
        boolean f40572a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BufferedSource f40573b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CacheRequest f40574c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BufferedSink f40575d;

        b(BufferedSource bufferedSource, CacheRequest cacheRequest, BufferedSink bufferedSink) {
            this.f40573b = bufferedSource;
            this.f40574c = cacheRequest;
            this.f40575d = bufferedSink;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.f40572a && !com.squareup.okhttp.internal.g.g(this, 100, TimeUnit.MILLISECONDS)) {
                this.f40572a = true;
                this.f40574c.abort();
            }
            this.f40573b.close();
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j11) {
            try {
                long read = this.f40573b.read(buffer, j11);
                if (read != -1) {
                    buffer.copyTo(this.f40575d.getBufferField(), buffer.size() - read, read);
                    this.f40575d.emitCompleteSegments();
                    return read;
                }
                if (!this.f40572a) {
                    this.f40572a = true;
                    this.f40575d.close();
                }
                return -1L;
            } catch (IOException e11) {
                if (!this.f40572a) {
                    this.f40572a = true;
                    this.f40574c.abort();
                }
                throw e11;
            }
        }

        @Override // okio.Source
        /* renamed from: timeout */
        public Timeout getTimeout() {
            return this.f40573b.getTimeout();
        }
    }

    /* loaded from: classes5.dex */
    class c implements Interceptor.Chain {

        /* renamed from: a, reason: collision with root package name */
        private final int f40577a;

        /* renamed from: b, reason: collision with root package name */
        private final Request f40578b;

        /* renamed from: c, reason: collision with root package name */
        private int f40579c;

        c(int i11, Request request) {
            this.f40577a = i11;
            this.f40578b = request;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Connection connection() {
            return g.this.f40556b.c();
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Response proceed(Request request) {
            this.f40579c++;
            if (this.f40577a > 0) {
                Interceptor interceptor = g.this.f40555a.networkInterceptors().get(this.f40577a - 1);
                Address address = connection().getRoute().getAddress();
                if (!request.httpUrl().host().equals(address.getUriHost()) || request.httpUrl().port() != address.getUriPort()) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must retain the same host and port");
                }
                if (this.f40579c > 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                }
            }
            if (this.f40577a < g.this.f40555a.networkInterceptors().size()) {
                c cVar = new c(this.f40577a + 1, request);
                Interceptor interceptor2 = g.this.f40555a.networkInterceptors().get(this.f40577a);
                Response intercept = interceptor2.intercept(cVar);
                if (cVar.f40579c != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor2 + " must call proceed() exactly once");
                }
                if (intercept != null) {
                    return intercept;
                }
                throw new NullPointerException("network interceptor " + interceptor2 + " returned null");
            }
            g.this.f40558d.writeRequestHeaders(request);
            g.this.f40563i = request;
            if (g.this.q(request) && request.body() != null) {
                BufferedSink buffer = Okio.buffer(g.this.f40558d.createRequestBody(request, request.body().contentLength()));
                request.body().writeTo(buffer);
                buffer.close();
            }
            Response r11 = g.this.r();
            int code = r11.code();
            if ((code != 204 && code != 205) || r11.body().contentLength() <= 0) {
                return r11;
            }
            throw new ProtocolException("HTTP " + code + " had non-zero Content-Length: " + r11.body().contentLength());
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Request request() {
            return this.f40578b;
        }
    }

    public g(OkHttpClient okHttpClient, Request request, boolean z10, boolean z11, boolean z12, n nVar, k kVar, Response response) {
        this.f40555a = okHttpClient;
        this.f40562h = request;
        this.f40561g = z10;
        this.f40568n = z11;
        this.f40569o = z12;
        this.f40556b = nVar == null ? new n(okHttpClient.getConnectionPool(), i(okHttpClient, request)) : nVar;
        this.f40566l = kVar;
        this.f40557c = response;
    }

    private Response A(Response response) {
        if (!this.f40560f || !"gzip".equalsIgnoreCase(this.f40565k.header(HttpHeaders.CONTENT_ENCODING)) || response.body() == null) {
            return response;
        }
        GzipSource gzipSource = new GzipSource(response.body().source());
        Headers build = response.headers().newBuilder().removeAll(HttpHeaders.CONTENT_ENCODING).removeAll(HttpHeaders.CONTENT_LENGTH).build();
        return response.newBuilder().headers(build).body(new i(build, Okio.buffer(gzipSource))).build();
    }

    private static boolean B(Response response, Response response2) {
        Date date;
        if (response2.code() == 304) {
            return true;
        }
        Date date2 = response.headers().getDate("Last-Modified");
        return (date2 == null || (date = response2.headers().getDate("Last-Modified")) == null || date.getTime() >= date2.getTime()) ? false : true;
    }

    private Response d(CacheRequest cacheRequest, Response response) {
        Sink body;
        return (cacheRequest == null || (body = cacheRequest.body()) == null) ? response : response.newBuilder().body(new i(response.headers(), Okio.buffer(new b(response.body().source(), cacheRequest, Okio.buffer(body))))).build();
    }

    private static Headers g(Headers headers, Headers headers2) {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            String name = headers.name(i11);
            String value = headers.value(i11);
            if ((!"Warning".equalsIgnoreCase(name) || !value.startsWith("1")) && (!OkHeaders.h(name) || headers2.get(name) == null)) {
                builder.add(name, value);
            }
        }
        int size2 = headers2.size();
        for (int i12 = 0; i12 < size2; i12++) {
            String name2 = headers2.name(i12);
            if (!HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(name2) && OkHeaders.h(name2)) {
                builder.add(name2, headers2.value(i12));
            }
        }
        return builder.build();
    }

    private HttpStream h() {
        return this.f40556b.k(this.f40555a.getConnectTimeout(), this.f40555a.getReadTimeout(), this.f40555a.getWriteTimeout(), this.f40555a.getRetryOnConnectionFailure(), !this.f40563i.method().equals("GET"));
    }

    private static Address i(OkHttpClient okHttpClient, Request request) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        if (request.isHttps()) {
            sSLSocketFactory = okHttpClient.getSslSocketFactory();
            hostnameVerifier = okHttpClient.getHostnameVerifier();
            certificatePinner = okHttpClient.getCertificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(request.httpUrl().host(), request.httpUrl().port(), okHttpClient.getDns(), okHttpClient.getSocketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, okHttpClient.getAuthenticator(), okHttpClient.getProxy(), okHttpClient.getProtocols(), okHttpClient.getConnectionSpecs(), okHttpClient.getProxySelector());
    }

    public static boolean n(Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int code = response.code();
        return (((code >= 100 && code < 200) || code == 204 || code == 304) && OkHeaders.e(response) == -1 && !"chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) ? false : true;
    }

    private void o() {
        InternalCache internalCache = com.squareup.okhttp.internal.c.instance.internalCache(this.f40555a);
        if (internalCache == null) {
            return;
        }
        if (com.squareup.okhttp.internal.http.b.a(this.f40565k, this.f40563i)) {
            this.f40570p = internalCache.put(z(this.f40565k));
        } else if (h.a(this.f40563i.method())) {
            try {
                internalCache.remove(this.f40563i);
            } catch (IOException unused) {
            }
        }
    }

    private Request p(Request request) {
        Request.Builder newBuilder = request.newBuilder();
        if (request.header(HttpHeaders.HOST) == null) {
            newBuilder.header(HttpHeaders.HOST, com.squareup.okhttp.internal.g.i(request.httpUrl()));
        }
        if (request.header("Connection") == null) {
            newBuilder.header("Connection", "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null) {
            this.f40560f = true;
            newBuilder.header("Accept-Encoding", "gzip");
        }
        CookieHandler cookieHandler = this.f40555a.getCookieHandler();
        if (cookieHandler != null) {
            OkHeaders.a(newBuilder, cookieHandler.get(request.uri(), OkHeaders.l(newBuilder.build().headers(), null)));
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", com.squareup.okhttp.internal.h.a());
        }
        return newBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Response r() {
        this.f40558d.finishRequest();
        Response build = this.f40558d.readResponseHeaders().request(this.f40563i).handshake(this.f40556b.c().getHandshake()).header(OkHeaders.f40491c, Long.toString(this.f40559e)).header(OkHeaders.f40492d, Long.toString(System.currentTimeMillis())).build();
        if (!this.f40569o) {
            build = build.newBuilder().body(this.f40558d.openResponseBody(build)).build();
        }
        if ("close".equalsIgnoreCase(build.request().header("Connection")) || "close".equalsIgnoreCase(build.header("Connection"))) {
            this.f40556b.l();
        }
        return build;
    }

    private static Response z(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body(null).build();
    }

    public void C() {
        if (this.f40559e != -1) {
            throw new IllegalStateException();
        }
        this.f40559e = System.currentTimeMillis();
    }

    public void e() {
        this.f40556b.b();
    }

    public n f() {
        BufferedSink bufferedSink = this.f40567m;
        if (bufferedSink != null) {
            com.squareup.okhttp.internal.g.c(bufferedSink);
        } else {
            Sink sink = this.f40566l;
            if (sink != null) {
                com.squareup.okhttp.internal.g.c(sink);
            }
        }
        Response response = this.f40565k;
        if (response != null) {
            com.squareup.okhttp.internal.g.c(response.body());
        } else {
            this.f40556b.d();
        }
        return this.f40556b;
    }

    public Request j() {
        String header;
        HttpUrl resolve;
        if (this.f40565k == null) {
            throw new IllegalStateException();
        }
        df.a c11 = this.f40556b.c();
        Route route = c11 != null ? c11.getRoute() : null;
        Proxy proxy = route != null ? route.getProxy() : this.f40555a.getProxy();
        int code = this.f40565k.code();
        String method = this.f40562h.method();
        if (code != 307 && code != 308) {
            if (code != 401) {
                if (code != 407) {
                    switch (code) {
                        case 300:
                        case MRAID_ERROR_VALUE:
                        case INVALID_IFA_STATUS_VALUE:
                        case 303:
                            break;
                        default:
                            return null;
                    }
                } else if (proxy.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
            }
            return OkHeaders.j(this.f40555a.getAuthenticator(), this.f40565k, proxy);
        }
        if (!method.equals("GET") && !method.equals("HEAD")) {
            return null;
        }
        if (!this.f40555a.getFollowRedirects() || (header = this.f40565k.header(HttpHeaders.LOCATION)) == null || (resolve = this.f40562h.httpUrl().resolve(header)) == null) {
            return null;
        }
        if (!resolve.scheme().equals(this.f40562h.httpUrl().scheme()) && !this.f40555a.getFollowSslRedirects()) {
            return null;
        }
        Request.Builder newBuilder = this.f40562h.newBuilder();
        if (h.b(method)) {
            if (h.c(method)) {
                newBuilder.method("GET", null);
            } else {
                newBuilder.method(method, null);
            }
            newBuilder.removeHeader("Transfer-Encoding");
            newBuilder.removeHeader(HttpHeaders.CONTENT_LENGTH);
            newBuilder.removeHeader(HttpHeaders.CONTENT_TYPE);
        }
        if (!x(resolve)) {
            newBuilder.removeHeader(HttpHeaders.AUTHORIZATION);
        }
        return newBuilder.url(resolve).build();
    }

    public Connection k() {
        return this.f40556b.c();
    }

    public Request l() {
        return this.f40562h;
    }

    public Response m() {
        Response response = this.f40565k;
        if (response != null) {
            return response;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q(Request request) {
        return h.b(request.method());
    }

    public void s() {
        Response r11;
        if (this.f40565k != null) {
            return;
        }
        Request request = this.f40563i;
        if (request == null && this.f40564j == null) {
            throw new IllegalStateException("call sendRequest() first!");
        }
        if (request == null) {
            return;
        }
        if (this.f40569o) {
            this.f40558d.writeRequestHeaders(request);
            r11 = r();
        } else if (this.f40568n) {
            BufferedSink bufferedSink = this.f40567m;
            if (bufferedSink != null && bufferedSink.getBufferField().size() > 0) {
                this.f40567m.emit();
            }
            if (this.f40559e == -1) {
                if (OkHeaders.d(this.f40563i) == -1) {
                    Sink sink = this.f40566l;
                    if (sink instanceof k) {
                        this.f40563i = this.f40563i.newBuilder().header(HttpHeaders.CONTENT_LENGTH, Long.toString(((k) sink).d())).build();
                    }
                }
                this.f40558d.writeRequestHeaders(this.f40563i);
            }
            Sink sink2 = this.f40566l;
            if (sink2 != null) {
                BufferedSink bufferedSink2 = this.f40567m;
                if (bufferedSink2 != null) {
                    bufferedSink2.close();
                } else {
                    sink2.close();
                }
                Sink sink3 = this.f40566l;
                if (sink3 instanceof k) {
                    this.f40558d.writeRequestBody((k) sink3);
                }
            }
            r11 = r();
        } else {
            r11 = new c(0, request).proceed(this.f40563i);
        }
        t(r11.headers());
        Response response = this.f40564j;
        if (response != null) {
            if (B(response, r11)) {
                this.f40565k = this.f40564j.newBuilder().request(this.f40562h).priorResponse(z(this.f40557c)).headers(g(this.f40564j.headers(), r11.headers())).cacheResponse(z(this.f40564j)).networkResponse(z(r11)).build();
                r11.body().close();
                w();
                InternalCache internalCache = com.squareup.okhttp.internal.c.instance.internalCache(this.f40555a);
                internalCache.trackConditionalCacheHit();
                internalCache.update(this.f40564j, z(this.f40565k));
                this.f40565k = A(this.f40565k);
                return;
            }
            com.squareup.okhttp.internal.g.c(this.f40564j.body());
        }
        Response build = r11.newBuilder().request(this.f40562h).priorResponse(z(this.f40557c)).cacheResponse(z(this.f40564j)).networkResponse(z(r11)).build();
        this.f40565k = build;
        if (n(build)) {
            o();
            this.f40565k = A(d(this.f40570p, this.f40565k));
        }
    }

    public void t(Headers headers) {
        CookieHandler cookieHandler = this.f40555a.getCookieHandler();
        if (cookieHandler != null) {
            cookieHandler.put(this.f40562h.uri(), OkHeaders.l(headers, null));
        }
    }

    public g u(RouteException routeException) {
        if (!this.f40556b.m(routeException) || !this.f40555a.getRetryOnConnectionFailure()) {
            return null;
        }
        return new g(this.f40555a, this.f40562h, this.f40561g, this.f40568n, this.f40569o, f(), (k) this.f40566l, this.f40557c);
    }

    public g v(IOException iOException, Sink sink) {
        if (!this.f40556b.n(iOException, sink) || !this.f40555a.getRetryOnConnectionFailure()) {
            return null;
        }
        return new g(this.f40555a, this.f40562h, this.f40561g, this.f40568n, this.f40569o, f(), (k) sink, this.f40557c);
    }

    public void w() {
        this.f40556b.o();
    }

    public boolean x(HttpUrl httpUrl) {
        HttpUrl httpUrl2 = this.f40562h.httpUrl();
        return httpUrl2.host().equals(httpUrl.host()) && httpUrl2.port() == httpUrl.port() && httpUrl2.scheme().equals(httpUrl.scheme());
    }

    public void y() {
        if (this.f40571q != null) {
            return;
        }
        if (this.f40558d != null) {
            throw new IllegalStateException();
        }
        Request p11 = p(this.f40562h);
        InternalCache internalCache = com.squareup.okhttp.internal.c.instance.internalCache(this.f40555a);
        Response response = internalCache != null ? internalCache.get(p11) : null;
        com.squareup.okhttp.internal.http.b c11 = new b.C0581b(System.currentTimeMillis(), p11, response).c();
        this.f40571q = c11;
        this.f40563i = c11.f40496a;
        this.f40564j = c11.f40497b;
        if (internalCache != null) {
            internalCache.trackResponse(c11);
        }
        if (response != null && this.f40564j == null) {
            com.squareup.okhttp.internal.g.c(response.body());
        }
        if (this.f40563i == null) {
            Response response2 = this.f40564j;
            if (response2 != null) {
                this.f40565k = response2.newBuilder().request(this.f40562h).priorResponse(z(this.f40557c)).cacheResponse(z(this.f40564j)).build();
            } else {
                this.f40565k = new Response.Builder().request(this.f40562h).priorResponse(z(this.f40557c)).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(f40554r).build();
            }
            this.f40565k = A(this.f40565k);
            return;
        }
        HttpStream h11 = h();
        this.f40558d = h11;
        h11.setHttpEngine(this);
        if (this.f40568n && q(this.f40563i) && this.f40566l == null) {
            long d11 = OkHeaders.d(p11);
            if (!this.f40561g) {
                this.f40558d.writeRequestHeaders(this.f40563i);
                this.f40566l = this.f40558d.createRequestBody(this.f40563i, d11);
            } else {
                if (d11 > 2147483647L) {
                    throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                }
                if (d11 == -1) {
                    this.f40566l = new k();
                } else {
                    this.f40558d.writeRequestHeaders(this.f40563i);
                    this.f40566l = new k((int) d11);
                }
            }
        }
    }
}
