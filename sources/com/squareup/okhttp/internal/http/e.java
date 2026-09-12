package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.framed.ErrorCode;
import com.squareup.okhttp.internal.framed.FramedConnection;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: classes5.dex */
public final class e implements HttpStream {

    /* renamed from: e, reason: collision with root package name */
    private static final ByteString f40533e;

    /* renamed from: f, reason: collision with root package name */
    private static final ByteString f40534f;

    /* renamed from: g, reason: collision with root package name */
    private static final ByteString f40535g;

    /* renamed from: h, reason: collision with root package name */
    private static final ByteString f40536h;

    /* renamed from: i, reason: collision with root package name */
    private static final ByteString f40537i;

    /* renamed from: j, reason: collision with root package name */
    private static final ByteString f40538j;

    /* renamed from: k, reason: collision with root package name */
    private static final ByteString f40539k;

    /* renamed from: l, reason: collision with root package name */
    private static final ByteString f40540l;

    /* renamed from: m, reason: collision with root package name */
    private static final List f40541m;

    /* renamed from: n, reason: collision with root package name */
    private static final List f40542n;

    /* renamed from: o, reason: collision with root package name */
    private static final List f40543o;

    /* renamed from: p, reason: collision with root package name */
    private static final List f40544p;

    /* renamed from: a, reason: collision with root package name */
    private final n f40545a;

    /* renamed from: b, reason: collision with root package name */
    private final FramedConnection f40546b;

    /* renamed from: c, reason: collision with root package name */
    private g f40547c;

    /* renamed from: d, reason: collision with root package name */
    private com.squareup.okhttp.internal.framed.a f40548d;

    /* loaded from: classes5.dex */
    class a extends ForwardingSource {
        public a(Source source) {
            super(source);
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            e.this.f40545a.r(e.this);
            super.close();
        }
    }

    static {
        ByteString encodeUtf8 = ByteString.encodeUtf8("connection");
        f40533e = encodeUtf8;
        ByteString encodeUtf82 = ByteString.encodeUtf8("host");
        f40534f = encodeUtf82;
        ByteString encodeUtf83 = ByteString.encodeUtf8("keep-alive");
        f40535g = encodeUtf83;
        ByteString encodeUtf84 = ByteString.encodeUtf8("proxy-connection");
        f40536h = encodeUtf84;
        ByteString encodeUtf85 = ByteString.encodeUtf8("transfer-encoding");
        f40537i = encodeUtf85;
        ByteString encodeUtf86 = ByteString.encodeUtf8("te");
        f40538j = encodeUtf86;
        ByteString encodeUtf87 = ByteString.encodeUtf8("encoding");
        f40539k = encodeUtf87;
        ByteString encodeUtf88 = ByteString.encodeUtf8("upgrade");
        f40540l = encodeUtf88;
        ByteString byteString = com.squareup.okhttp.internal.framed.b.f40418e;
        ByteString byteString2 = com.squareup.okhttp.internal.framed.b.f40419f;
        ByteString byteString3 = com.squareup.okhttp.internal.framed.b.f40420g;
        ByteString byteString4 = com.squareup.okhttp.internal.framed.b.f40421h;
        ByteString byteString5 = com.squareup.okhttp.internal.framed.b.f40422i;
        ByteString byteString6 = com.squareup.okhttp.internal.framed.b.f40423j;
        f40541m = com.squareup.okhttp.internal.g.k(encodeUtf8, encodeUtf82, encodeUtf83, encodeUtf84, encodeUtf85, byteString, byteString2, byteString3, byteString4, byteString5, byteString6);
        f40542n = com.squareup.okhttp.internal.g.k(encodeUtf8, encodeUtf82, encodeUtf83, encodeUtf84, encodeUtf85);
        f40543o = com.squareup.okhttp.internal.g.k(encodeUtf8, encodeUtf82, encodeUtf83, encodeUtf84, encodeUtf86, encodeUtf85, encodeUtf87, encodeUtf88, byteString, byteString2, byteString3, byteString4, byteString5, byteString6);
        f40544p = com.squareup.okhttp.internal.g.k(encodeUtf8, encodeUtf82, encodeUtf83, encodeUtf84, encodeUtf86, encodeUtf85, encodeUtf87, encodeUtf88);
    }

    public e(n nVar, FramedConnection framedConnection) {
        this.f40545a = nVar;
        this.f40546b = framedConnection;
    }

    public static List b(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.f40418e, request.method()));
        arrayList.add(new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.f40419f, j.c(request.httpUrl())));
        arrayList.add(new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.f40421h, com.squareup.okhttp.internal.g.i(request.httpUrl())));
        arrayList.add(new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.f40420g, request.httpUrl().scheme()));
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i11).toLowerCase(Locale.US));
            if (!f40543o.contains(encodeUtf8)) {
                arrayList.add(new com.squareup.okhttp.internal.framed.b(encodeUtf8, headers.value(i11)));
            }
        }
        return arrayList;
    }

    private static String c(String str, String str2) {
        return str + (char) 0 + str2;
    }

    public static Response.Builder d(List list) {
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        String str = null;
        for (int i11 = 0; i11 < size; i11++) {
            ByteString byteString = ((com.squareup.okhttp.internal.framed.b) list.get(i11)).f40424a;
            String utf8 = ((com.squareup.okhttp.internal.framed.b) list.get(i11)).f40425b.utf8();
            if (byteString.equals(com.squareup.okhttp.internal.framed.b.f40417d)) {
                str = utf8;
            } else if (!f40544p.contains(byteString)) {
                builder.add(byteString.utf8(), utf8);
            }
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        m a11 = m.a("HTTP/1.1 " + str);
        return new Response.Builder().protocol(Protocol.HTTP_2).code(a11.f40596b).message(a11.f40597c).headers(builder.build());
    }

    public static Response.Builder e(List list) {
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        String str = null;
        String str2 = "HTTP/1.1";
        for (int i11 = 0; i11 < size; i11++) {
            ByteString byteString = ((com.squareup.okhttp.internal.framed.b) list.get(i11)).f40424a;
            String utf8 = ((com.squareup.okhttp.internal.framed.b) list.get(i11)).f40425b.utf8();
            int i12 = 0;
            while (i12 < utf8.length()) {
                int indexOf = utf8.indexOf(0, i12);
                if (indexOf == -1) {
                    indexOf = utf8.length();
                }
                String substring = utf8.substring(i12, indexOf);
                if (byteString.equals(com.squareup.okhttp.internal.framed.b.f40417d)) {
                    str = substring;
                } else if (byteString.equals(com.squareup.okhttp.internal.framed.b.f40423j)) {
                    str2 = substring;
                } else if (!f40542n.contains(byteString)) {
                    builder.add(byteString.utf8(), substring);
                }
                i12 = indexOf + 1;
            }
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        m a11 = m.a(str2 + " " + str);
        return new Response.Builder().protocol(Protocol.SPDY_3).code(a11.f40596b).message(a11.f40597c).headers(builder.build());
    }

    public static List f(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 5);
        arrayList.add(new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.f40418e, request.method()));
        arrayList.add(new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.f40419f, j.c(request.httpUrl())));
        arrayList.add(new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.f40423j, "HTTP/1.1"));
        arrayList.add(new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.f40422i, com.squareup.okhttp.internal.g.i(request.httpUrl())));
        arrayList.add(new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.f40420g, request.httpUrl().scheme()));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i11).toLowerCase(Locale.US));
            if (!f40541m.contains(encodeUtf8)) {
                String value = headers.value(i11);
                if (linkedHashSet.add(encodeUtf8)) {
                    arrayList.add(new com.squareup.okhttp.internal.framed.b(encodeUtf8, value));
                } else {
                    int i12 = 0;
                    while (true) {
                        if (i12 >= arrayList.size()) {
                            break;
                        }
                        if (((com.squareup.okhttp.internal.framed.b) arrayList.get(i12)).f40424a.equals(encodeUtf8)) {
                            arrayList.set(i12, new com.squareup.okhttp.internal.framed.b(encodeUtf8, c(((com.squareup.okhttp.internal.framed.b) arrayList.get(i12)).f40425b.utf8(), value)));
                            break;
                        }
                        i12++;
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void cancel() {
        com.squareup.okhttp.internal.framed.a aVar = this.f40548d;
        if (aVar != null) {
            aVar.n(ErrorCode.CANCEL);
        }
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public Sink createRequestBody(Request request, long j11) {
        return this.f40548d.q();
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void finishRequest() {
        this.f40548d.q().close();
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public ResponseBody openResponseBody(Response response) {
        return new i(response.headers(), Okio.buffer(new a(this.f40548d.r())));
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public Response.Builder readResponseHeaders() {
        return this.f40546b.d0() == Protocol.HTTP_2 ? d(this.f40548d.p()) : e(this.f40548d.p());
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void setHttpEngine(g gVar) {
        this.f40547c = gVar;
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void writeRequestBody(k kVar) {
        kVar.h(this.f40548d.q());
    }

    @Override // com.squareup.okhttp.internal.http.HttpStream
    public void writeRequestHeaders(Request request) {
        if (this.f40548d != null) {
            return;
        }
        this.f40547c.C();
        com.squareup.okhttp.internal.framed.a l02 = this.f40546b.l0(this.f40546b.d0() == Protocol.HTTP_2 ? b(request) : f(request), this.f40547c.q(request), true);
        this.f40548d = l02;
        Timeout u11 = l02.u();
        long readTimeout = this.f40547c.f40555a.getReadTimeout();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        u11.timeout(readTimeout, timeUnit);
        this.f40548d.A().timeout(this.f40547c.f40555a.getWriteTimeout(), timeUnit);
    }
}
