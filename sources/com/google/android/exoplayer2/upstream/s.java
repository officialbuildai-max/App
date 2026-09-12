package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.s;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.google.common.collect.n2;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

/* loaded from: classes3.dex */
public class s extends f implements k {

    /* renamed from: e, reason: collision with root package name */
    private final boolean f27561e;

    /* renamed from: f, reason: collision with root package name */
    private final int f27562f;

    /* renamed from: g, reason: collision with root package name */
    private final int f27563g;

    /* renamed from: h, reason: collision with root package name */
    private final String f27564h;

    /* renamed from: i, reason: collision with root package name */
    private final w f27565i;

    /* renamed from: j, reason: collision with root package name */
    private final w f27566j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f27567k;

    /* renamed from: l, reason: collision with root package name */
    private com.google.common.base.n f27568l;

    /* renamed from: m, reason: collision with root package name */
    private n f27569m;

    /* renamed from: n, reason: collision with root package name */
    private HttpURLConnection f27570n;

    /* renamed from: o, reason: collision with root package name */
    private InputStream f27571o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f27572p;

    /* renamed from: q, reason: collision with root package name */
    private int f27573q;

    /* renamed from: r, reason: collision with root package name */
    private long f27574r;

    /* renamed from: s, reason: collision with root package name */
    private long f27575s;

    /* loaded from: classes3.dex */
    public static final class b implements k.a {

        /* renamed from: b, reason: collision with root package name */
        private k0 f27577b;

        /* renamed from: c, reason: collision with root package name */
        private com.google.common.base.n f27578c;

        /* renamed from: d, reason: collision with root package name */
        private String f27579d;

        /* renamed from: g, reason: collision with root package name */
        private boolean f27582g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f27583h;

        /* renamed from: a, reason: collision with root package name */
        private final w f27576a = new w();

        /* renamed from: e, reason: collision with root package name */
        private int f27580e = 8000;

        /* renamed from: f, reason: collision with root package name */
        private int f27581f = 8000;

        @Override // com.google.android.exoplayer2.upstream.k.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public s createDataSource() {
            s sVar = new s(this.f27579d, this.f27580e, this.f27581f, this.f27582g, this.f27576a, this.f27578c, this.f27583h);
            k0 k0Var = this.f27577b;
            if (k0Var != null) {
                sVar.e(k0Var);
            }
            return sVar;
        }

        public b b(String str) {
            this.f27579d = str;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends n2 {

        /* renamed from: a, reason: collision with root package name */
        private final Map f27584a;

        public c(Map map) {
            this.f27584a = map;
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
            return this.f27584a;
        }

        @Override // com.google.common.collect.n2, java.util.Map
        public Set entrySet() {
            return Sets.b(super.entrySet(), new com.google.common.base.n() { // from class: com.google.android.exoplayer2.upstream.u
                @Override // com.google.common.base.n
                public final boolean apply(Object obj) {
                    boolean o11;
                    o11 = s.c.o((Map.Entry) obj);
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
            return Sets.b(super.keySet(), new com.google.common.base.n() { // from class: com.google.android.exoplayer2.upstream.t
                @Override // com.google.common.base.n
                public final boolean apply(Object obj) {
                    boolean p11;
                    p11 = s.c.p((String) obj);
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

    @Deprecated
    public s() {
        this(null, 8000, 8000);
    }

    public s(String str, int i11, int i12) {
        this(str, i11, i12, false, null);
    }

    public s(String str, int i11, int i12, boolean z10, w wVar) {
        this(str, i11, i12, z10, wVar, null, false);
    }

    private s(String str, int i11, int i12, boolean z10, w wVar, com.google.common.base.n nVar, boolean z11) {
        super(true);
        this.f27564h = str;
        this.f27562f = i11;
        this.f27563g = i12;
        this.f27561e = z10;
        this.f27565i = wVar;
        this.f27568l = nVar;
        this.f27566j = new w();
        this.f27567k = z11;
    }

    private void l() {
        HttpURLConnection httpURLConnection = this.f27570n;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e11) {
                com.google.android.exoplayer2.util.s.d("DefaultHttpDataSource", "Unexpected error while disconnecting", e11);
            }
            this.f27570n = null;
        }
    }

    private URL m(URL url, String str, n nVar) {
        if (str == null) {
            throw new HttpDataSource$HttpDataSourceException("Null location redirect", nVar, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new HttpDataSource$HttpDataSourceException("Unsupported protocol redirect: " + protocol, nVar, 2001, 1);
            }
            if (this.f27561e || protocol.equals(url.getProtocol())) {
                return url2;
            }
            throw new HttpDataSource$HttpDataSourceException("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", nVar, 2001, 1);
        } catch (MalformedURLException e11) {
            throw new HttpDataSource$HttpDataSourceException(e11, nVar, 2001, 1);
        }
    }

    private static boolean n(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField(HttpHeaders.CONTENT_ENCODING));
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ab, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.net.HttpURLConnection o(com.google.android.exoplayer2.upstream.n r26) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.s.o(com.google.android.exoplayer2.upstream.n):java.net.HttpURLConnection");
    }

    private HttpURLConnection p(URL url, int i11, byte[] bArr, long j11, long j12, boolean z10, boolean z11, Map map) {
        HttpURLConnection r11 = r(url);
        r11.setConnectTimeout(this.f27562f);
        r11.setReadTimeout(this.f27563g);
        HashMap hashMap = new HashMap();
        w wVar = this.f27565i;
        if (wVar != null) {
            hashMap.putAll(wVar.a());
        }
        hashMap.putAll(this.f27566j.a());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            r11.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String a11 = x.a(j11, j12);
        if (a11 != null) {
            r11.setRequestProperty("Range", a11);
        }
        String str = this.f27564h;
        if (str != null) {
            r11.setRequestProperty("User-Agent", str);
        }
        r11.setRequestProperty("Accept-Encoding", z10 ? "gzip" : "identity");
        r11.setInstanceFollowRedirects(z11);
        r11.setDoOutput(bArr != null);
        r11.setRequestMethod(n.c(i11));
        if (bArr != null) {
            r11.setFixedLengthStreamingMode(bArr.length);
            r11.connect();
            OutputStream outputStream = r11.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            r11.connect();
        }
        return r11;
    }

    private static void q(HttpURLConnection httpURLConnection, long j11) {
        int i11;
        if (httpURLConnection != null && (i11 = p0.f27680a) >= 19 && i11 <= 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j11 == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j11 <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (!"com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) && !"com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    return;
                }
                Method declaredMethod = ((Class) com.google.android.exoplayer2.util.a.e(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", null);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, null);
            } catch (Exception unused) {
            }
        }
    }

    private int s(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f27574r;
        if (j11 != -1) {
            long j12 = j11 - this.f27575s;
            if (j12 == 0) {
                return -1;
            }
            i12 = (int) Math.min(i12, j12);
        }
        int read = ((InputStream) p0.j(this.f27571o)).read(bArr, i11, i12);
        if (read == -1) {
            return -1;
        }
        this.f27575s += read;
        h(read);
        return read;
    }

    private void t(long j11, n nVar) {
        if (j11 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j11 > 0) {
            int read = ((InputStream) p0.j(this.f27571o)).read(bArr, 0, (int) Math.min(j11, 4096));
            if (Thread.currentThread().isInterrupted()) {
                throw new HttpDataSource$HttpDataSourceException(new InterruptedIOException(), nVar, 2000, 1);
            }
            if (read == -1) {
                throw new HttpDataSource$HttpDataSourceException(nVar, 2008, 1);
            }
            j11 -= read;
            h(read);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(final n nVar) {
        byte[] bArr;
        this.f27569m = nVar;
        long j11 = 0;
        this.f27575s = 0L;
        this.f27574r = 0L;
        j(nVar);
        try {
            HttpURLConnection o11 = o(nVar);
            this.f27570n = o11;
            this.f27573q = o11.getResponseCode();
            String responseMessage = o11.getResponseMessage();
            int i11 = this.f27573q;
            if (i11 < 200 || i11 > 299) {
                Map<String, List<String>> headerFields = o11.getHeaderFields();
                if (this.f27573q == 416) {
                    if (nVar.f27497g == x.c(o11.getHeaderField("Content-Range"))) {
                        this.f27572p = true;
                        k(nVar);
                        long j12 = nVar.f27498h;
                        if (j12 != -1) {
                            return j12;
                        }
                        return 0L;
                    }
                }
                InputStream errorStream = o11.getErrorStream();
                try {
                    bArr = errorStream != null ? p0.Y0(errorStream) : p0.f27685f;
                } catch (IOException unused) {
                    bArr = p0.f27685f;
                }
                byte[] bArr2 = bArr;
                l();
                throw new HttpDataSource$InvalidResponseCodeException(this.f27573q, responseMessage, this.f27573q == 416 ? new DataSourceException(2008) : null, headerFields, nVar, bArr2);
            }
            final String contentType = o11.getContentType();
            com.google.common.base.n nVar2 = this.f27568l;
            if (nVar2 != null && !nVar2.apply(contentType)) {
                l();
                throw new HttpDataSource$HttpDataSourceException(contentType, nVar) { // from class: com.google.android.exoplayer2.upstream.HttpDataSource$InvalidContentTypeException
                    public final String contentType;

                    {
                        super("Invalid content type: " + contentType, nVar, 2003, 1);
                        this.contentType = contentType;
                    }
                };
            }
            if (this.f27573q == 200) {
                long j13 = nVar.f27497g;
                if (j13 != 0) {
                    j11 = j13;
                }
            }
            boolean n11 = n(o11);
            if (n11) {
                this.f27574r = nVar.f27498h;
            } else {
                long j14 = nVar.f27498h;
                if (j14 != -1) {
                    this.f27574r = j14;
                } else {
                    long b11 = x.b(o11.getHeaderField(HttpHeaders.CONTENT_LENGTH), o11.getHeaderField("Content-Range"));
                    this.f27574r = b11 != -1 ? b11 - j11 : -1L;
                }
            }
            try {
                this.f27571o = o11.getInputStream();
                if (n11) {
                    this.f27571o = new GZIPInputStream(this.f27571o);
                }
                this.f27572p = true;
                k(nVar);
                try {
                    t(j11, nVar);
                    return this.f27574r;
                } catch (IOException e11) {
                    l();
                    if (e11 instanceof HttpDataSource$HttpDataSourceException) {
                        throw ((HttpDataSource$HttpDataSourceException) e11);
                    }
                    throw new HttpDataSource$HttpDataSourceException(e11, nVar, 2000, 1);
                }
            } catch (IOException e12) {
                l();
                throw new HttpDataSource$HttpDataSourceException(e12, nVar, 2000, 1);
            }
        } catch (IOException e13) {
            l();
            throw HttpDataSource$HttpDataSourceException.createForIOException(e13, nVar, 1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
        try {
            InputStream inputStream = this.f27571o;
            if (inputStream != null) {
                long j11 = this.f27574r;
                long j12 = -1;
                if (j11 != -1) {
                    j12 = j11 - this.f27575s;
                }
                q(this.f27570n, j12);
                try {
                    inputStream.close();
                } catch (IOException e11) {
                    throw new HttpDataSource$HttpDataSourceException(e11, (n) p0.j(this.f27569m), 2000, 3);
                }
            }
        } finally {
            this.f27571o = null;
            l();
            if (this.f27572p) {
                this.f27572p = false;
                i();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.f, com.google.android.exoplayer2.upstream.k
    public Map getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.f27570n;
        return httpURLConnection == null ? ImmutableMap.of() : new c(httpURLConnection.getHeaderFields());
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.f27570n;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    HttpURLConnection r(URL url) {
        return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) {
        try {
            return s(bArr, i11, i12);
        } catch (IOException e11) {
            throw HttpDataSource$HttpDataSourceException.createForIOException(e11, (n) p0.j(this.f27569m), 2);
        }
    }
}
