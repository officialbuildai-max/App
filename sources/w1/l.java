package w1;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class l implements androidx.media3.datasource.a {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.media3.datasource.a f77660a;

    /* renamed from: b, reason: collision with root package name */
    private long f77661b;

    /* renamed from: c, reason: collision with root package name */
    private Uri f77662c = Uri.EMPTY;

    /* renamed from: d, reason: collision with root package name */
    private Map f77663d = Collections.emptyMap();

    public l(androidx.media3.datasource.a aVar) {
        this.f77660a = (androidx.media3.datasource.a) androidx.media3.common.util.a.e(aVar);
    }

    @Override // androidx.media3.datasource.a
    public long a(h hVar) {
        this.f77662c = hVar.f77634a;
        this.f77663d = Collections.emptyMap();
        try {
            return this.f77660a.a(hVar);
        } finally {
            Uri uri = getUri();
            if (uri != null) {
                this.f77662c = uri;
            }
            this.f77663d = getResponseHeaders();
        }
    }

    @Override // androidx.media3.datasource.a
    public void c(n nVar) {
        androidx.media3.common.util.a.e(nVar);
        this.f77660a.c(nVar);
    }

    @Override // androidx.media3.datasource.a
    public void close() {
        this.f77660a.close();
    }

    public long d() {
        return this.f77661b;
    }

    public Uri e() {
        return this.f77662c;
    }

    public Map f() {
        return this.f77663d;
    }

    public void g() {
        this.f77661b = 0L;
    }

    @Override // androidx.media3.datasource.a
    public Map getResponseHeaders() {
        return this.f77660a.getResponseHeaders();
    }

    @Override // androidx.media3.datasource.a
    public Uri getUri() {
        return this.f77660a.getUri();
    }

    @Override // androidx.media3.common.j
    public int read(byte[] bArr, int i11, int i12) {
        int read = this.f77660a.read(bArr, i11, i12);
        if (read != -1) {
            this.f77661b += read;
        }
        return read;
    }
}
