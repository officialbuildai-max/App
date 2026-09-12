package org.jsoup.helper;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.parser.e;
import org.jsoup.parser.g;

/* loaded from: classes7.dex */
public class b implements Connection {

    /* renamed from: a, reason: collision with root package name */
    private Connection.b f71814a = new c();

    /* renamed from: b, reason: collision with root package name */
    private Connection.c f71815b = new d();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: org.jsoup.helper.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static abstract class AbstractC0896b implements Connection.a {

        /* renamed from: a, reason: collision with root package name */
        URL f71816a;

        /* renamed from: b, reason: collision with root package name */
        Connection.Method f71817b;

        /* renamed from: c, reason: collision with root package name */
        Map f71818c;

        /* renamed from: d, reason: collision with root package name */
        Map f71819d;

        private AbstractC0896b() {
            this.f71818c = new LinkedHashMap();
            this.f71819d = new LinkedHashMap();
        }

        private List A(String str) {
            org.jsoup.helper.d.j(str);
            for (Map.Entry entry : this.f71818c.entrySet()) {
                if (str.equalsIgnoreCase((String) entry.getKey())) {
                    return (List) entry.getValue();
                }
            }
            return Collections.emptyList();
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
        
            if ((((r8[1] & 255) == 187) & ((r8[2] & 255) == 191)) != false) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static boolean F(byte[] r8) {
            /*
                int r0 = r8.length
                r1 = 1
                r2 = 0
                r3 = 3
                if (r0 < r3) goto L29
                r0 = r8[r2]
                r0 = r0 & 255(0xff, float:3.57E-43)
                r4 = 239(0xef, float:3.35E-43)
                if (r0 != r4) goto L29
                r0 = r8[r1]
                r0 = r0 & 255(0xff, float:3.57E-43)
                r4 = 187(0xbb, float:2.62E-43)
                if (r0 != r4) goto L18
                r0 = r1
                goto L19
            L18:
                r0 = r2
            L19:
                r4 = 2
                r4 = r8[r4]
                r4 = r4 & 255(0xff, float:3.57E-43)
                r5 = 191(0xbf, float:2.68E-43)
                if (r4 != r5) goto L24
                r4 = r1
                goto L25
            L24:
                r4 = r2
            L25:
                r0 = r0 & r4
                if (r0 == 0) goto L29
                goto L2a
            L29:
                r3 = r2
            L2a:
                int r0 = r8.length
            L2b:
                if (r3 >= r0) goto L5d
                r4 = r8[r3]
                r5 = r4 & 128(0x80, float:1.794E-43)
                if (r5 != 0) goto L34
                goto L5a
            L34:
                r5 = r4 & 224(0xe0, float:3.14E-43)
                r6 = 192(0xc0, float:2.69E-43)
                if (r5 != r6) goto L3d
                int r4 = r3 + 1
                goto L4e
            L3d:
                r5 = r4 & 240(0xf0, float:3.36E-43)
                r7 = 224(0xe0, float:3.14E-43)
                if (r5 != r7) goto L46
                int r4 = r3 + 2
                goto L4e
            L46:
                r4 = r4 & 248(0xf8, float:3.48E-43)
                r5 = 240(0xf0, float:3.36E-43)
                if (r4 != r5) goto L5c
                int r4 = r3 + 3
            L4e:
                if (r3 >= r4) goto L5a
                int r3 = r3 + 1
                r5 = r8[r3]
                r5 = r5 & r6
                r7 = 128(0x80, float:1.794E-43)
                if (r5 == r7) goto L4e
                return r2
            L5a:
                int r3 = r3 + r1
                goto L2b
            L5c:
                return r2
            L5d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.b.AbstractC0896b.F(byte[]):boolean");
        }

        private Map.Entry G(String str) {
            String a11 = e10.b.a(str);
            for (Map.Entry entry : this.f71818c.entrySet()) {
                if (e10.b.a((String) entry.getKey()).equals(a11)) {
                    return entry;
                }
            }
            return null;
        }

        private static String z(String str) {
            try {
                byte[] bytes = str.getBytes("ISO-8859-1");
                return !F(bytes) ? str : new String(bytes, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return str;
            }
        }

        public boolean B(String str) {
            org.jsoup.helper.d.i(str, "Cookie name must not be empty");
            return this.f71819d.containsKey(str);
        }

        public boolean C(String str, String str2) {
            org.jsoup.helper.d.h(str);
            org.jsoup.helper.d.h(str2);
            Iterator it = E(str).iterator();
            while (it.hasNext()) {
                if (str2.equalsIgnoreCase((String) it.next())) {
                    return true;
                }
            }
            return false;
        }

        public String D(String str) {
            org.jsoup.helper.d.k(str, "Header name must not be null");
            List A = A(str);
            if (A.size() > 0) {
                return org.jsoup.helper.c.i(A, ", ");
            }
            return null;
        }

        public List E(String str) {
            org.jsoup.helper.d.h(str);
            return A(str);
        }

        @Override // org.jsoup.Connection.a
        public URL f() {
            return this.f71816a;
        }

        @Override // org.jsoup.Connection.a
        public Connection.a h(String str, String str2) {
            org.jsoup.helper.d.i(str, "Cookie name must not be empty");
            org.jsoup.helper.d.k(str2, "Cookie value must not be null");
            this.f71819d.put(str, str2);
            return this;
        }

        @Override // org.jsoup.Connection.a
        public Map k() {
            return this.f71819d;
        }

        @Override // org.jsoup.Connection.a
        public Connection.Method method() {
            return this.f71817b;
        }

        @Override // org.jsoup.Connection.a
        public Connection.a n(String str) {
            org.jsoup.helper.d.i(str, "Header name must not be empty");
            Map.Entry G = G(str);
            if (G != null) {
                this.f71818c.remove(G.getKey());
            }
            return this;
        }

        @Override // org.jsoup.Connection.a
        public Connection.a p(URL url) {
            org.jsoup.helper.d.k(url, "URL must not be null");
            this.f71816a = url;
            return this;
        }

        @Override // org.jsoup.Connection.a
        public Connection.a q(String str, String str2) {
            org.jsoup.helper.d.i(str, "Header name must not be empty");
            n(str);
            y(str, str2);
            return this;
        }

        @Override // org.jsoup.Connection.a
        public Connection.a r(Connection.Method method) {
            org.jsoup.helper.d.k(method, "Method must not be null");
            this.f71817b = method;
            return this;
        }

        @Override // org.jsoup.Connection.a
        public boolean s(String str) {
            org.jsoup.helper.d.i(str, "Header name must not be empty");
            return A(str).size() != 0;
        }

        @Override // org.jsoup.Connection.a
        public Map u() {
            return this.f71818c;
        }

        public Connection.a y(String str, String str2) {
            org.jsoup.helper.d.h(str);
            if (str2 == null) {
                str2 = "";
            }
            List E = E(str);
            if (E.isEmpty()) {
                E = new ArrayList();
                this.f71818c.put(str, E);
            }
            E.add(z(str2));
            return this;
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends AbstractC0896b implements Connection.b {

        /* renamed from: e, reason: collision with root package name */
        private Proxy f71820e;

        /* renamed from: f, reason: collision with root package name */
        private int f71821f;

        /* renamed from: g, reason: collision with root package name */
        private int f71822g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f71823h;

        /* renamed from: i, reason: collision with root package name */
        private Collection f71824i;

        /* renamed from: j, reason: collision with root package name */
        private String f71825j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f71826k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f71827l;

        /* renamed from: m, reason: collision with root package name */
        private e f71828m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f71829n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f71830o;

        /* renamed from: p, reason: collision with root package name */
        private String f71831p;

        /* renamed from: q, reason: collision with root package name */
        private SSLSocketFactory f71832q;

        c() {
            super();
            this.f71825j = null;
            this.f71826k = false;
            this.f71827l = false;
            this.f71829n = false;
            this.f71830o = true;
            this.f71831p = "UTF-8";
            this.f71821f = 30000;
            this.f71822g = 1048576;
            this.f71823h = true;
            this.f71824i = new ArrayList();
            this.f71817b = Connection.Method.GET;
            y("Accept-Encoding", "gzip");
            y("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");
            this.f71828m = e.a();
        }

        @Override // org.jsoup.helper.b.AbstractC0896b
        public /* bridge */ /* synthetic */ List E(String str) {
            return super.E(str);
        }

        @Override // org.jsoup.Connection.b
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public c o(e eVar) {
            this.f71828m = eVar;
            this.f71829n = true;
            return this;
        }

        @Override // org.jsoup.Connection.b
        public Connection.b a(boolean z10) {
            this.f71827l = z10;
            return this;
        }

        @Override // org.jsoup.Connection.b
        public boolean b() {
            return this.f71826k;
        }

        @Override // org.jsoup.Connection.b
        public String c() {
            return this.f71831p;
        }

        @Override // org.jsoup.Connection.b
        public Connection.b d(String str) {
            this.f71825j = str;
            return this;
        }

        @Override // org.jsoup.Connection.b
        public boolean e() {
            return this.f71830o;
        }

        @Override // org.jsoup.helper.b.AbstractC0896b, org.jsoup.Connection.a
        public /* bridge */ /* synthetic */ URL f() {
            return super.f();
        }

        @Override // org.jsoup.Connection.b
        public SSLSocketFactory g() {
            return this.f71832q;
        }

        @Override // org.jsoup.Connection.b
        public Proxy i() {
            return this.f71820e;
        }

        @Override // org.jsoup.Connection.b
        public Collection j() {
            return this.f71824i;
        }

        @Override // org.jsoup.helper.b.AbstractC0896b, org.jsoup.Connection.a
        public /* bridge */ /* synthetic */ Map k() {
            return super.k();
        }

        @Override // org.jsoup.Connection.b
        public boolean l() {
            return this.f71823h;
        }

        @Override // org.jsoup.helper.b.AbstractC0896b, org.jsoup.Connection.a
        public /* bridge */ /* synthetic */ Connection.Method method() {
            return super.method();
        }

        @Override // org.jsoup.helper.b.AbstractC0896b, org.jsoup.Connection.a
        public /* bridge */ /* synthetic */ boolean s(String str) {
            return super.s(str);
        }

        @Override // org.jsoup.Connection.b
        public boolean t() {
            return this.f71827l;
        }

        @Override // org.jsoup.Connection.b
        public int timeout() {
            return this.f71821f;
        }

        @Override // org.jsoup.helper.b.AbstractC0896b, org.jsoup.Connection.a
        public /* bridge */ /* synthetic */ Map u() {
            return super.u();
        }

        @Override // org.jsoup.Connection.b
        public String v() {
            return this.f71825j;
        }

        @Override // org.jsoup.Connection.b
        public int w() {
            return this.f71822g;
        }

        @Override // org.jsoup.Connection.b
        public e x() {
            return this.f71828m;
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends AbstractC0896b implements Connection.c {

        /* renamed from: o, reason: collision with root package name */
        private static SSLSocketFactory f71833o;

        /* renamed from: p, reason: collision with root package name */
        private static final Pattern f71834p = Pattern.compile("(application|text)/\\w*\\+?xml.*");

        /* renamed from: e, reason: collision with root package name */
        private int f71835e;

        /* renamed from: f, reason: collision with root package name */
        private String f71836f;

        /* renamed from: g, reason: collision with root package name */
        private ByteBuffer f71837g;

        /* renamed from: h, reason: collision with root package name */
        private InputStream f71838h;

        /* renamed from: i, reason: collision with root package name */
        private String f71839i;

        /* renamed from: j, reason: collision with root package name */
        private String f71840j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f71841k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f71842l;

        /* renamed from: m, reason: collision with root package name */
        private int f71843m;

        /* renamed from: n, reason: collision with root package name */
        private Connection.b f71844n;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes7.dex */
        public class a implements HostnameVerifier {
            a() {
            }

            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: org.jsoup.helper.b$d$b, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0897b implements X509TrustManager {
            C0897b() {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }

        d() {
            super();
            this.f71841k = false;
            this.f71842l = false;
            this.f71843m = 0;
        }

        private d(d dVar) {
            super();
            this.f71841k = false;
            this.f71842l = false;
            this.f71843m = 0;
            if (dVar != null) {
                int i11 = dVar.f71843m + 1;
                this.f71843m = i11;
                if (i11 >= 20) {
                    throw new IOException(String.format("Too many redirects occurred trying to load URL %s", dVar.f()));
                }
            }
        }

        private static HttpURLConnection I(Connection.b bVar) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) (bVar.i() == null ? (URLConnection) FirebasePerfUrlConnection.instrument(bVar.f().openConnection()) : (URLConnection) FirebasePerfUrlConnection.instrument(bVar.f().openConnection(bVar.i())));
            httpURLConnection.setRequestMethod(bVar.method().name());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setConnectTimeout(bVar.timeout());
            httpURLConnection.setReadTimeout(bVar.timeout() / 2);
            if (httpURLConnection instanceof HttpsURLConnection) {
                SSLSocketFactory g11 = bVar.g();
                if (g11 != null) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(g11);
                } else if (!bVar.e()) {
                    O();
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                    httpsURLConnection.setSSLSocketFactory(f71833o);
                    httpsURLConnection.setHostnameVerifier(M());
                }
            }
            if (bVar.method().hasBody()) {
                httpURLConnection.setDoOutput(true);
            }
            if (bVar.k().size() > 0) {
                httpURLConnection.addRequestProperty("Cookie", N(bVar));
            }
            for (Map.Entry entry : bVar.u().entrySet()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    httpURLConnection.addRequestProperty((String) entry.getKey(), (String) it.next());
                }
            }
            return httpURLConnection;
        }

        private static LinkedHashMap J(HttpURLConnection httpURLConnection) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i11 = 0;
            while (true) {
                String headerFieldKey = httpURLConnection.getHeaderFieldKey(i11);
                String headerField = httpURLConnection.getHeaderField(i11);
                if (headerFieldKey == null && headerField == null) {
                    return linkedHashMap;
                }
                i11++;
                if (headerFieldKey != null && headerField != null) {
                    if (linkedHashMap.containsKey(headerFieldKey)) {
                        ((List) linkedHashMap.get(headerFieldKey)).add(headerField);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(headerField);
                        linkedHashMap.put(headerFieldKey, arrayList);
                    }
                }
            }
        }

        static d K(Connection.b bVar) {
            return L(bVar, null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:62:0x015f, code lost:
        
            if (org.jsoup.helper.b.d.f71834p.matcher(r10).matches() == false) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0163, code lost:
        
            if ((r9 instanceof org.jsoup.helper.b.c) == false) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x016c, code lost:
        
            if (((org.jsoup.helper.b.c) r9).f71829n != false) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x016e, code lost:
        
            r9.o(org.jsoup.parser.e.g());
         */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0082 A[Catch: IOException -> 0x008a, TryCatch #0 {IOException -> 0x008a, blocks: (B:21:0x0079, B:23:0x0082, B:24:0x008d, B:26:0x00a1, B:30:0x00ab, B:31:0x00bf, B:33:0x00c5, B:35:0x00cd, B:37:0x00d6, B:38:0x00da, B:39:0x00f3, B:41:0x00f9, B:43:0x010f, B:49:0x0122, B:51:0x0128, B:53:0x012e, B:55:0x0136, B:58:0x0143, B:59:0x0152, B:61:0x0155, B:63:0x0161, B:65:0x0165, B:67:0x016e, B:68:0x0175, B:70:0x0183, B:72:0x018b, B:74:0x0193, B:75:0x019c, B:77:0x01a6, B:78:0x01c6, B:81:0x01b0, B:83:0x01b8, B:84:0x0198, B:85:0x01df, B:86:0x011c, B:88:0x01e8, B:89:0x01f7), top: B:20:0x0079 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        static org.jsoup.helper.b.d L(org.jsoup.Connection.b r9, org.jsoup.helper.b.d r10) {
            /*
                Method dump skipped, instructions count: 508
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.b.d.L(org.jsoup.Connection$b, org.jsoup.helper.b$d):org.jsoup.helper.b$d");
        }

        private static HostnameVerifier M() {
            return new a();
        }

        private static String N(Connection.b bVar) {
            StringBuilder o11 = org.jsoup.helper.c.o();
            boolean z10 = true;
            for (Map.Entry entry : bVar.k().entrySet()) {
                if (z10) {
                    z10 = false;
                } else {
                    o11.append("; ");
                }
                o11.append((String) entry.getKey());
                o11.append('=');
                o11.append((String) entry.getValue());
            }
            return o11.toString();
        }

        private static synchronized void O() {
            synchronized (d.class) {
                if (f71833o == null) {
                    TrustManager[] trustManagerArr = {new C0897b()};
                    try {
                        SSLContext sSLContext = SSLContext.getInstance("SSL");
                        sSLContext.init(null, trustManagerArr, new SecureRandom());
                        f71833o = sSLContext.getSocketFactory();
                    } catch (KeyManagementException | NoSuchAlgorithmException unused) {
                        throw new IOException("Can't create unsecure trust manager");
                    }
                }
            }
        }

        private void Q() {
            InputStream inputStream = this.f71838h;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f71838h = null;
                    throw th2;
                }
                this.f71838h = null;
            }
        }

        private static void R(Connection.b bVar) {
            URL f11 = bVar.f();
            StringBuilder o11 = org.jsoup.helper.c.o();
            o11.append(f11.getProtocol());
            o11.append("://");
            o11.append(f11.getAuthority());
            o11.append(f11.getPath());
            o11.append(UrlUtils.QUESTION_MARK);
            if (f11.getQuery() != null) {
                o11.append(f11.getQuery());
            }
            Iterator it = bVar.j().iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.c.a(it.next());
                throw null;
            }
            bVar.p(new URL(o11.toString()));
            bVar.j().clear();
        }

        private static String S(Connection.b bVar) {
            if (!bVar.s(HttpHeaders.CONTENT_TYPE)) {
                if (b.h(bVar)) {
                    String d11 = org.jsoup.helper.a.d();
                    bVar.q(HttpHeaders.CONTENT_TYPE, "multipart/form-data; boundary=" + d11);
                    return d11;
                }
                bVar.q(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=" + bVar.c());
            }
            return null;
        }

        private void T(HttpURLConnection httpURLConnection, Connection.c cVar) {
            this.f71817b = Connection.Method.valueOf(httpURLConnection.getRequestMethod());
            this.f71816a = httpURLConnection.getURL();
            this.f71835e = httpURLConnection.getResponseCode();
            this.f71836f = httpURLConnection.getResponseMessage();
            this.f71840j = httpURLConnection.getContentType();
            P(J(httpURLConnection));
            if (cVar != null) {
                for (Map.Entry entry : cVar.k().entrySet()) {
                    if (!B((String) entry.getKey())) {
                        h((String) entry.getKey(), (String) entry.getValue());
                    }
                }
            }
        }

        private static void U(Connection.b bVar, OutputStream outputStream, String str) {
            Collection j11 = bVar.j();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, bVar.c()));
            if (str != null) {
                Iterator it = j11.iterator();
                if (it.hasNext()) {
                    android.support.v4.media.session.c.a(it.next());
                    bufferedWriter.write("--");
                    bufferedWriter.write(str);
                    bufferedWriter.write("\r\n");
                    bufferedWriter.write("Content-Disposition: form-data; name=\"");
                    throw null;
                }
                bufferedWriter.write("--");
                bufferedWriter.write(str);
                bufferedWriter.write("--");
            } else if (bVar.v() != null) {
                bufferedWriter.write(bVar.v());
            } else {
                Iterator it2 = j11.iterator();
                if (it2.hasNext()) {
                    android.support.v4.media.session.c.a(it2.next());
                    throw null;
                }
            }
            bufferedWriter.close();
        }

        @Override // org.jsoup.helper.b.AbstractC0896b
        public /* bridge */ /* synthetic */ boolean B(String str) {
            return super.B(str);
        }

        @Override // org.jsoup.helper.b.AbstractC0896b
        public /* bridge */ /* synthetic */ boolean C(String str, String str2) {
            return super.C(str, str2);
        }

        @Override // org.jsoup.helper.b.AbstractC0896b
        public /* bridge */ /* synthetic */ String D(String str) {
            return super.D(str);
        }

        @Override // org.jsoup.helper.b.AbstractC0896b
        public /* bridge */ /* synthetic */ List E(String str) {
            return super.E(str);
        }

        public String H() {
            return this.f71840j;
        }

        void P(Map map) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str != null) {
                    List<String> list = (List) entry.getValue();
                    if (str.equalsIgnoreCase("Set-Cookie")) {
                        for (String str2 : list) {
                            if (str2 != null) {
                                g gVar = new g(str2);
                                String trim = gVar.b(UrlUtils.EQUAL_MARK).trim();
                                String trim2 = gVar.g(";").trim();
                                if (trim.length() > 0) {
                                    h(trim, trim2);
                                }
                            }
                        }
                    }
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        y(str, (String) it.next());
                    }
                }
            }
        }

        @Override // org.jsoup.helper.b.AbstractC0896b, org.jsoup.Connection.a
        public /* bridge */ /* synthetic */ URL f() {
            return super.f();
        }

        @Override // org.jsoup.helper.b.AbstractC0896b, org.jsoup.Connection.a
        public /* bridge */ /* synthetic */ Map k() {
            return super.k();
        }

        @Override // org.jsoup.Connection.c
        public Document m() {
            org.jsoup.helper.d.e(this.f71841k, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
            if (this.f71837g != null) {
                this.f71838h = new ByteArrayInputStream(this.f71837g.array());
                this.f71842l = false;
            }
            org.jsoup.helper.d.c(this.f71842l, "Input stream already read and parsed, cannot re-read.");
            Document e11 = org.jsoup.helper.a.e(this.f71838h, this.f71839i, this.f71816a.toExternalForm(), this.f71844n.x());
            this.f71839i = e11.g1().a().name();
            this.f71842l = true;
            Q();
            return e11;
        }

        @Override // org.jsoup.helper.b.AbstractC0896b, org.jsoup.Connection.a
        public /* bridge */ /* synthetic */ boolean s(String str) {
            return super.s(str);
        }
    }

    private b() {
    }

    public static Connection d(String str) {
        b bVar = new b();
        bVar.b(str);
        return bVar;
    }

    private static String e(String str) {
        try {
            return f(new URL(str)).toExternalForm();
        } catch (Exception unused) {
            return str;
        }
    }

    static URL f(URL url) {
        try {
            return new URL(new URI(url.toExternalForm().replaceAll(" ", "%20")).toASCIIString());
        } catch (Exception unused) {
            return url;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean h(Connection.b bVar) {
        Iterator it = bVar.j().iterator();
        if (!it.hasNext()) {
            return false;
        }
        android.support.v4.media.session.c.a(it.next());
        throw null;
    }

    @Override // org.jsoup.Connection
    public Connection a(boolean z10) {
        this.f71814a.a(z10);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection b(String str) {
        org.jsoup.helper.d.i(str, "Must supply a valid URL");
        try {
            this.f71814a.p(new URL(e(str)));
            return this;
        } catch (MalformedURLException e11) {
            throw new IllegalArgumentException("Malformed URL: " + str, e11);
        }
    }

    public Connection.c g() {
        d K = d.K(this.f71814a);
        this.f71815b = K;
        return K;
    }

    @Override // org.jsoup.Connection
    public Document get() {
        this.f71814a.r(Connection.Method.GET);
        g();
        return this.f71815b.m();
    }
}
