package x1;

import android.net.Uri;
import androidx.media3.common.u;
import androidx.media3.common.util.a1;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.HttpDataSource;
import com.google.common.base.n;
import com.google.common.util.concurrent.y;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import w1.h;
import w1.i;

/* loaded from: classes2.dex */
public class a extends w1.a implements HttpDataSource {

    /* renamed from: e, reason: collision with root package name */
    private final Call.Factory f78132e;

    /* renamed from: f, reason: collision with root package name */
    private final HttpDataSource.b f78133f;

    /* renamed from: g, reason: collision with root package name */
    private final String f78134g;

    /* renamed from: h, reason: collision with root package name */
    private final CacheControl f78135h;

    /* renamed from: i, reason: collision with root package name */
    private final HttpDataSource.b f78136i;

    /* renamed from: j, reason: collision with root package name */
    private final n f78137j;

    /* renamed from: k, reason: collision with root package name */
    private h f78138k;

    /* renamed from: l, reason: collision with root package name */
    private Response f78139l;

    /* renamed from: m, reason: collision with root package name */
    private InputStream f78140m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f78141n;

    /* renamed from: o, reason: collision with root package name */
    private long f78142o;

    /* renamed from: p, reason: collision with root package name */
    private long f78143p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: x1.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0987a implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ y f78144a;

        C0987a(y yVar) {
            this.f78144a = yVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            this.f78144a.setException(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            this.f78144a.set(response);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements HttpDataSource.a {

        /* renamed from: a, reason: collision with root package name */
        private final HttpDataSource.b f78146a = new HttpDataSource.b();

        /* renamed from: b, reason: collision with root package name */
        private final Call.Factory f78147b;

        /* renamed from: c, reason: collision with root package name */
        private String f78148c;

        /* renamed from: d, reason: collision with root package name */
        private w1.n f78149d;

        /* renamed from: e, reason: collision with root package name */
        private CacheControl f78150e;

        /* renamed from: f, reason: collision with root package name */
        private n f78151f;

        public b(Call.Factory factory) {
            this.f78147b = factory;
        }

        @Override // androidx.media3.datasource.a.InterfaceC0099a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a createDataSource() {
            a aVar = new a(this.f78147b, this.f78148c, this.f78150e, this.f78146a, this.f78151f, null);
            w1.n nVar = this.f78149d;
            if (nVar != null) {
                aVar.c(nVar);
            }
            return aVar;
        }

        @Override // androidx.media3.datasource.HttpDataSource.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final b a(Map map) {
            this.f78146a.a(map);
            return this;
        }
    }

    static {
        u.a("media3.datasource.okhttp");
    }

    private a(Call.Factory factory, String str, CacheControl cacheControl, HttpDataSource.b bVar, n nVar) {
        super(true);
        this.f78132e = (Call.Factory) androidx.media3.common.util.a.e(factory);
        this.f78134g = str;
        this.f78135h = cacheControl;
        this.f78136i = bVar;
        this.f78137j = nVar;
        this.f78133f = new HttpDataSource.b();
    }

    /* synthetic */ a(Call.Factory factory, String str, CacheControl cacheControl, HttpDataSource.b bVar, n nVar, C0987a c0987a) {
        this(factory, str, cacheControl, bVar, nVar);
    }

    private void h() {
        Response response = this.f78139l;
        if (response != null) {
            ((ResponseBody) androidx.media3.common.util.a.e(response.body())).close();
        }
        this.f78140m = null;
    }

    private Response i(Call call) {
        y s11 = y.s();
        FirebasePerfOkHttpClient.enqueue(call, new C0987a(s11));
        try {
            return (Response) s11.get();
        } catch (InterruptedException unused) {
            call.cancel();
            throw new InterruptedIOException();
        } catch (ExecutionException e11) {
            throw new IOException(e11);
        }
    }

    private Request j(h hVar) {
        long j11 = hVar.f77640g;
        long j12 = hVar.f77641h;
        HttpUrl parse = HttpUrl.parse(hVar.f77634a.toString());
        if (parse == null) {
            throw new HttpDataSource.HttpDataSourceException("Malformed URL", hVar, 1004, 1);
        }
        Request.Builder url = new Request.Builder().url(parse);
        CacheControl cacheControl = this.f78135h;
        if (cacheControl != null) {
            url.cacheControl(cacheControl);
        }
        HashMap hashMap = new HashMap();
        HttpDataSource.b bVar = this.f78136i;
        if (bVar != null) {
            hashMap.putAll(bVar.b());
        }
        hashMap.putAll(this.f78133f.b());
        hashMap.putAll(hVar.f77638e);
        for (Map.Entry entry : hashMap.entrySet()) {
            url.header((String) entry.getKey(), (String) entry.getValue());
        }
        String a11 = i.a(j11, j12);
        if (a11 != null) {
            url.addHeader("Range", a11);
        }
        String str = this.f78134g;
        if (str != null) {
            url.addHeader("User-Agent", str);
        }
        if (!hVar.d(1)) {
            url.addHeader("Accept-Encoding", "identity");
        }
        byte[] bArr = hVar.f77637d;
        url.method(hVar.b(), bArr != null ? RequestBody.create(bArr) : hVar.f77636c == 2 ? RequestBody.create(a1.f10437f) : null);
        return url.build();
    }

    private int k(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.f78142o;
        if (j11 != -1) {
            long j12 = j11 - this.f78143p;
            if (j12 == 0) {
                return -1;
            }
            i12 = (int) Math.min(i12, j12);
        }
        int read = ((InputStream) a1.i(this.f78140m)).read(bArr, i11, i12);
        if (read == -1) {
            return -1;
        }
        this.f78143p += read;
        d(read);
        return read;
    }

    private void l(long j11, h hVar) {
        if (j11 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j11 > 0) {
            try {
                int read = ((InputStream) a1.i(this.f78140m)).read(bArr, 0, (int) Math.min(j11, 4096));
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedIOException();
                }
                if (read == -1) {
                    throw new HttpDataSource.HttpDataSourceException(hVar, 2008, 1);
                }
                j11 -= read;
                d(read);
            } catch (IOException e11) {
                if (!(e11 instanceof HttpDataSource.HttpDataSourceException)) {
                    throw new HttpDataSource.HttpDataSourceException(hVar, 2000, 1);
                }
                throw ((HttpDataSource.HttpDataSourceException) e11);
            }
        }
    }

    @Override // androidx.media3.datasource.a
    public long a(h hVar) {
        byte[] bArr;
        this.f78138k = hVar;
        long j11 = 0;
        this.f78143p = 0L;
        this.f78142o = 0L;
        f(hVar);
        try {
            Response i11 = i(this.f78132e.newCall(j(hVar)));
            this.f78139l = i11;
            ResponseBody responseBody = (ResponseBody) androidx.media3.common.util.a.e(i11.body());
            this.f78140m = responseBody.byteStream();
            int code = i11.code();
            if (!i11.isSuccessful()) {
                if (code == 416) {
                    if (hVar.f77640g == i.c(i11.headers().get("Content-Range"))) {
                        this.f78141n = true;
                        g(hVar);
                        long j12 = hVar.f77641h;
                        if (j12 != -1) {
                            return j12;
                        }
                        return 0L;
                    }
                }
                try {
                    bArr = com.google.common.io.a.b((InputStream) androidx.media3.common.util.a.e(this.f78140m));
                } catch (IOException unused) {
                    bArr = a1.f10437f;
                }
                byte[] bArr2 = bArr;
                Map<String, List<String>> multimap = i11.headers().toMultimap();
                h();
                throw new HttpDataSource.InvalidResponseCodeException(code, i11.message(), code == 416 ? new DataSourceException(2008) : null, multimap, hVar, bArr2);
            }
            MediaType mediaType = responseBody.get$contentType();
            String mediaType2 = mediaType != null ? mediaType.getMediaType() : "";
            n nVar = this.f78137j;
            if (nVar != null && !nVar.apply(mediaType2)) {
                h();
                throw new HttpDataSource.InvalidContentTypeException(mediaType2, hVar);
            }
            if (code == 200) {
                long j13 = hVar.f77640g;
                if (j13 != 0) {
                    j11 = j13;
                }
            }
            long j14 = hVar.f77641h;
            if (j14 != -1) {
                this.f78142o = j14;
            } else {
                long contentLength = responseBody.getContentLength();
                this.f78142o = contentLength != -1 ? contentLength - j11 : -1L;
            }
            this.f78141n = true;
            g(hVar);
            try {
                l(j11, hVar);
                return this.f78142o;
            } catch (HttpDataSource.HttpDataSourceException e11) {
                h();
                throw e11;
            }
        } catch (IOException e12) {
            throw HttpDataSource.HttpDataSourceException.createForIOException(e12, hVar, 1);
        }
    }

    @Override // androidx.media3.datasource.a
    public void close() {
        if (this.f78141n) {
            this.f78141n = false;
            e();
            h();
        }
        this.f78139l = null;
        this.f78138k = null;
    }

    @Override // w1.a, androidx.media3.datasource.a
    public Map getResponseHeaders() {
        Response response = this.f78139l;
        return response == null ? Collections.emptyMap() : response.headers().toMultimap();
    }

    @Override // androidx.media3.datasource.a
    public Uri getUri() {
        Response response = this.f78139l;
        if (response != null) {
            return Uri.parse(response.request().url().getUrl());
        }
        h hVar = this.f78138k;
        if (hVar != null) {
            return hVar.f77634a;
        }
        return null;
    }

    @Override // androidx.media3.common.j
    public int read(byte[] bArr, int i11, int i12) {
        try {
            return k(bArr, i11, i12);
        } catch (IOException e11) {
            throw HttpDataSource.HttpDataSourceException.createForIOException(e11, (h) a1.i(this.f78138k), 2);
        }
    }
}
