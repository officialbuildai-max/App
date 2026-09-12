package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.u;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.c;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.common.base.n;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.google.common.collect.n2;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import w1.h;
import w1.i;

/* loaded from: classes2.dex */
public class c extends w1.a implements HttpDataSource {

    /* renamed from: e, reason: collision with root package name */
    private final boolean f10814e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f10815f;

    /* renamed from: g, reason: collision with root package name */
    private final int f10816g;

    /* renamed from: h, reason: collision with root package name */
    private final int f10817h;

    /* renamed from: i, reason: collision with root package name */
    private final String f10818i;

    /* renamed from: j, reason: collision with root package name */
    private final HttpDataSource.b f10819j;

    /* renamed from: k, reason: collision with root package name */
    private final HttpDataSource.b f10820k;

    /* renamed from: l, reason: collision with root package name */
    private final n f10821l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f10822m;

    /* renamed from: n, reason: collision with root package name */
    private h f10823n;

    /* renamed from: o, reason: collision with root package name */
    private HttpURLConnection f10824o;

    /* renamed from: p, reason: collision with root package name */
    private InputStream f10825p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f10826q;

    /* renamed from: r, reason: collision with root package name */
    private int f10827r;

    /* renamed from: s, reason: collision with root package name */
    private long f10828s;

    /* renamed from: t, reason: collision with root package name */
    private long f10829t;

    /* loaded from: classes2.dex */
    public static final class b implements HttpDataSource.a {

        /* renamed from: b, reason: collision with root package name */
        private w1.n f10831b;

        /* renamed from: c, reason: collision with root package name */
        private n f10832c;

        /* renamed from: d, reason: collision with root package name */
        private String f10833d;

        /* renamed from: g, reason: collision with root package name */
        private boolean f10836g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f10837h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f10838i;

        /* renamed from: a, reason: collision with root package name */
        private final HttpDataSource.b f10830a = new HttpDataSource.b();

        /* renamed from: e, reason: collision with root package name */
        private int f10834e = 8000;

        /* renamed from: f, reason: collision with root package name */
        private int f10835f = 8000;

        @Override // androidx.media3.datasource.a.InterfaceC0099a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c createDataSource() {
            c cVar = new c(this.f10833d, this.f10834e, this.f10835f, this.f10836g, this.f10837h, this.f10830a, this.f10832c, this.f10838i);
            w1.n nVar = this.f10831b;
            if (nVar != null) {
                cVar.c(nVar);
            }
            return cVar;
        }

        @Override // androidx.media3.datasource.HttpDataSource.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public b a(Map map) {
            this.f10830a.a(map);
            return this;
        }

        public b d(String str) {
            this.f10833d = str;
            return this;
        }
    }

    /* renamed from: androidx.media3.datasource.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0100c extends n2 {

        /* renamed from: a, reason: collision with root package name */
        private final Map f10839a;

        public C0100c(Map map) {
            this.f10839a = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean o(Map.Entry entry) {
            return entry.getKey() != null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean p(String str) {
            return str != null;
        }

        @Override // com.google.common.collect.n2, java.util.Map
        public boolean containsKey(Object obj) {
            return obj != null && super.containsKey(obj);
        }

        @Override // com.google.common.collect.n2, java.util.Map
        public boolean containsValue(Object obj) {
            return super.standardContainsValue(obj);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.q2
        /* renamed from: delegate */
        public Map l() {
            return this.f10839a;
        }

        @Override // com.google.common.collect.n2, java.util.Map
        public Set entrySet() {
            return Sets.b(super.entrySet(), new n() { // from class: androidx.media3.datasource.d
                @Override // com.google.common.base.n
                public final boolean apply(Object obj) {
                    boolean o11;
                    o11 = c.C0100c.o((Map.Entry) obj);
                    return o11;
                }
            });
        }

        @Override // com.google.common.collect.n2, java.util.Map
        public boolean equals(Object obj) {
            return obj != null && super.standardEquals(obj);
        }

        @Override // com.google.common.collect.n2, java.util.Map
        public int hashCode() {
            return super.standardHashCode();
        }

        @Override // com.google.common.collect.n2, java.util.Map
        public boolean isEmpty() {
            if (super.isEmpty()) {
                return true;
            }
            return super.size() == 1 && super.containsKey(null);
        }

        @Override // com.google.common.collect.n2, java.util.Map
        public Set keySet() {
            return Sets.b(super.keySet(), new n() { // from class: androidx.media3.datasource.e
                @Override // com.google.common.base.n
                public final boolean apply(Object obj) {
                    boolean p11;
                    p11 = c.C0100c.p((String) obj);
                    return p11;
                }
            });
        }

        @Override // com.google.common.collect.n2, java.util.Map
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public List get(Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) super.get(obj);
        }

        @Override // com.google.common.collect.n2, java.util.Map
        public int size() {
            return super.size() - (super.containsKey(null) ? 1 : 0);
        }
    }

    private c(String str, int i11, int i12, boolean z10, boolean z11, HttpDataSource.b bVar, n nVar, boolean z12) {
        super(true);
        this.f10818i = str;
        this.f10816g = i11;
        this.f10817h = i12;
        this.f10814e = z10;
        this.f10815f = z11;
        if (z10 && z11) {
            throw new IllegalArgumentException("crossProtocolRedirectsForceOriginal should not be set if allowCrossProtocolRedirects is true");
        }
        this.f10819j = bVar;
        this.f10821l = nVar;
        this.f10820k = new HttpDataSource.b();
        this.f10822m = z12;
    }

    private void h() {
        HttpURLConnection httpURLConnection = this.f10824o;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e11) {
                u.d("DefaultHttpDataSource", "Unexpected error while disconnecting", e11);
            }
        }
    }

    private URL i(URL url, String str, h hVar) {
        if (str == null) {
            throw new HttpDataSource.HttpDataSourceException("Null location redirect", hVar, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new HttpDataSource.HttpDataSourceException("Unsupported protocol redirect: " + protocol, hVar, 2001, 1);
            }
            if (this.f10814e || protocol.equals(url.getProtocol())) {
                return url2;
            }
            if (this.f10815f) {
                try {
                    return new URL(url2.toString().replaceFirst(protocol, url.getProtocol()));
                } catch (MalformedURLException e11) {
                    throw new HttpDataSource.HttpDataSourceException(e11, hVar, 2001, 1);
                }
            }
            throw new HttpDataSource.HttpDataSourceException("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", hVar, 2001, 1);
        } catch (MalformedURLException e12) {
            throw new HttpDataSource.HttpDataSourceException(e12, hVar, 2001, 1);
        }
    }

    private static boolean j(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField(HttpHeaders.CONTENT_ENCODING));
    }

    private HttpURLConnection k(URL url, int i11, byte[] bArr, long j11, long j12, boolean z10, boolean z11, Map map) {
        HttpURLConnection m11 = m(url);
        m11.setConnectTimeout(this.f10816g);
        m11.setReadTimeout(this.f10817h);
        HashMap hashMap = new HashMap();
        HttpDataSource.b bVar = this.f10819j;
        if (bVar != null) {
            hashMap.putAll(bVar.b());
        }
        hashMap.putAll(this.f10820k.b());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            m11.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String a11 = i.a(j11, j12);
        if (a11 != null) {
            m11.setRequestProperty("Range", a11);
        }
        String str = this.f10818i;
        if (str != null) {
            m11.setRequestProperty("User-Agent", str);
        }
        m11.setRequestProperty("Accept-Encoding", z10 ? "gzip" : "identity");
        m11.setInstanceFollowRedirects(z11);
        m11.setDoOutput(bArr != null);
        m11.setRequestMethod(h.c(i11));
        if (bArr != null) {
            m11.setFixedLengthStreamingMode(bArr.length);
            m11.connect();
            OutputStream outputStream = m11.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            m11.connect();
        }
        return m11;
    }

    private HttpURLConnection l(h hVar) {
        HttpURLConnection k11;
        URL url = new URL(hVar.f77634a.toString());
        int i11 = hVar.f77636c;
        byte[] bArr = hVar.f77637d;
        long j11 = hVar.f77640g;
        long j12 = hVar.f77641h;
        boolean d11 = hVar.d(1);
        if (!this.f10814e && !this.f10815f && !this.f10822m) {
            return k(url, i11, bArr, j11, j12, d11, true, hVar.f77638e);
        }
        int i12 = 0;
        URL url2 = url;
        int i13 = i11;
        byte[] bArr2 = bArr;
        while (true) {
            int i14 = i12 + 1;
            if (i12 > 20) {
                throw new HttpDataSource.HttpDataSourceException(new NoRouteToHostException("Too many redirects: " + i14), hVar, 2001, 1);
            }
            long j13 = j11;
            long j14 = j11;
            int i15 = i13;
            URL url3 = url2;
            long j15 = j12;
            k11 = k(url2, i13, bArr2, j13, j12, d11, false, hVar.f77638e);
            int responseCode = k11.getResponseCode();
            String headerField = k11.getHeaderField(HttpHeaders.LOCATION);
            if ((i15 == 1 || i15 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                k11.disconnect();
                url2 = i(url3, headerField, hVar);
                i13 = i15;
            } else {
                if (i15 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    break;
                }
                k11.disconnect();
                if (this.f10822m && responseCode == 302) {
                    i13 = i15;
                } else {
                    bArr2 = null;
                    i13 = 1;
                }
                url2 = i(url3, headerField, hVar);
            }
            i12 = i14;
            j11 = j14;
            j12 = j15;
        }
        return k11;
    }

    private int n(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f10828s;
        if (j11 != -1) {
            long j12 = j11 - this.f10829t;
            if (j12 == 0) {
                return -1;
            }
            i12 = (int) Math.min(i12, j12);
        }
        int read = ((InputStream) a1.i(this.f10825p)).read(bArr, i11, i12);
        if (read == -1) {
            return -1;
        }
        this.f10829t += read;
        d(read);
        return read;
    }

    private void o(long j11, h hVar) {
        if (j11 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j11 > 0) {
            int read = ((InputStream) a1.i(this.f10825p)).read(bArr, 0, (int) Math.min(j11, 4096));
            if (Thread.currentThread().isInterrupted()) {
                throw new HttpDataSource.HttpDataSourceException(new InterruptedIOException(), hVar, 2000, 1);
            }
            if (read == -1) {
                throw new HttpDataSource.HttpDataSourceException(hVar, 2008, 1);
            }
            j11 -= read;
            d(read);
        }
    }

    @Override // androidx.media3.datasource.a
    public long a(h hVar) {
        byte[] bArr;
        this.f10823n = hVar;
        long j11 = 0;
        this.f10829t = 0L;
        this.f10828s = 0L;
        f(hVar);
        try {
            HttpURLConnection l11 = l(hVar);
            this.f10824o = l11;
            this.f10827r = l11.getResponseCode();
            String responseMessage = l11.getResponseMessage();
            int i11 = this.f10827r;
            if (i11 < 200 || i11 > 299) {
                Map<String, List<String>> headerFields = l11.getHeaderFields();
                if (this.f10827r == 416) {
                    if (hVar.f77640g == i.c(l11.getHeaderField("Content-Range"))) {
                        this.f10826q = true;
                        g(hVar);
                        long j12 = hVar.f77641h;
                        if (j12 != -1) {
                            return j12;
                        }
                        return 0L;
                    }
                }
                InputStream errorStream = l11.getErrorStream();
                try {
                    bArr = errorStream != null ? com.google.common.io.a.b(errorStream) : a1.f10437f;
                } catch (IOException unused) {
                    bArr = a1.f10437f;
                }
                byte[] bArr2 = bArr;
                h();
                throw new HttpDataSource.InvalidResponseCodeException(this.f10827r, responseMessage, this.f10827r == 416 ? new DataSourceException(2008) : null, headerFields, hVar, bArr2);
            }
            String contentType = l11.getContentType();
            n nVar = this.f10821l;
            if (nVar != null && !nVar.apply(contentType)) {
                h();
                throw new HttpDataSource.InvalidContentTypeException(contentType, hVar);
            }
            if (this.f10827r == 200) {
                long j13 = hVar.f77640g;
                if (j13 != 0) {
                    j11 = j13;
                }
            }
            boolean j14 = j(l11);
            if (j14) {
                this.f10828s = hVar.f77641h;
            } else {
                long j15 = hVar.f77641h;
                if (j15 != -1) {
                    this.f10828s = j15;
                } else {
                    long b11 = i.b(l11.getHeaderField(HttpHeaders.CONTENT_LENGTH), l11.getHeaderField("Content-Range"));
                    this.f10828s = b11 != -1 ? b11 - j11 : -1L;
                }
            }
            try {
                this.f10825p = l11.getInputStream();
                if (j14) {
                    this.f10825p = new GZIPInputStream(this.f10825p);
                }
                this.f10826q = true;
                g(hVar);
                try {
                    o(j11, hVar);
                    return this.f10828s;
                } catch (IOException e11) {
                    h();
                    if (e11 instanceof HttpDataSource.HttpDataSourceException) {
                        throw ((HttpDataSource.HttpDataSourceException) e11);
                    }
                    throw new HttpDataSource.HttpDataSourceException(e11, hVar, 2000, 1);
                }
            } catch (IOException e12) {
                h();
                throw new HttpDataSource.HttpDataSourceException(e12, hVar, 2000, 1);
            }
        } catch (IOException e13) {
            h();
            throw HttpDataSource.HttpDataSourceException.createForIOException(e13, hVar, 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.datasource.a
    public void close() {
        try {
            InputStream inputStream = this.f10825p;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e11) {
                    throw new HttpDataSource.HttpDataSourceException(e11, (h) a1.i(this.f10823n), 2000, 3);
                }
            }
        } finally {
            this.f10825p = null;
            h();
            if (this.f10826q) {
                this.f10826q = false;
                e();
            }
            this.f10824o = null;
            this.f10823n = null;
        }
    }

    @Override // w1.a, androidx.media3.datasource.a
    public Map getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.f10824o;
        return httpURLConnection == null ? ImmutableMap.of() : new C0100c(httpURLConnection.getHeaderFields());
    }

    @Override // androidx.media3.datasource.a
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.f10824o;
        if (httpURLConnection != null) {
            return Uri.parse(httpURLConnection.getURL().toString());
        }
        h hVar = this.f10823n;
        if (hVar != null) {
            return hVar.f77634a;
        }
        return null;
    }

    HttpURLConnection m(URL url) {
        return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
    }

    @Override // androidx.media3.common.j
    public int read(byte[] bArr, int i11, int i12) {
        try {
            return n(bArr, i11, i12);
        } catch (IOException e11) {
            throw HttpDataSource.HttpDataSourceException.createForIOException(e11, (h) a1.i(this.f10823n), 2);
        }
    }
}
