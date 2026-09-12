package w1;

import android.net.Uri;
import java.util.Map;

/* loaded from: classes2.dex */
public final class m implements androidx.media3.datasource.a {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.media3.datasource.a f77664a;

    /* renamed from: b, reason: collision with root package name */
    private final d f77665b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f77666c;

    /* renamed from: d, reason: collision with root package name */
    private long f77667d;

    public m(androidx.media3.datasource.a aVar, d dVar) {
        this.f77664a = (androidx.media3.datasource.a) androidx.media3.common.util.a.e(aVar);
        this.f77665b = (d) androidx.media3.common.util.a.e(dVar);
    }

    @Override // androidx.media3.datasource.a
    public long a(h hVar) {
        long a11 = this.f77664a.a(hVar);
        this.f77667d = a11;
        if (a11 == 0) {
            return 0L;
        }
        if (hVar.f77641h == -1 && a11 != -1) {
            hVar = hVar.f(0L, a11);
        }
        this.f77666c = true;
        this.f77665b.a(hVar);
        return this.f77667d;
    }

    @Override // androidx.media3.datasource.a
    public void c(n nVar) {
        androidx.media3.common.util.a.e(nVar);
        this.f77664a.c(nVar);
    }

    @Override // androidx.media3.datasource.a
    public void close() {
        try {
            this.f77664a.close();
        } finally {
            if (this.f77666c) {
                this.f77666c = false;
                this.f77665b.close();
            }
        }
    }

    @Override // androidx.media3.datasource.a
    public Map getResponseHeaders() {
        return this.f77664a.getResponseHeaders();
    }

    @Override // androidx.media3.datasource.a
    public Uri getUri() {
        return this.f77664a.getUri();
    }

    @Override // androidx.media3.common.j
    public int read(byte[] bArr, int i11, int i12) {
        if (this.f77667d == 0) {
            return -1;
        }
        int read = this.f77664a.read(bArr, i11, i12);
        if (read > 0) {
            this.f77665b.write(bArr, i11, read);
            long j11 = this.f77667d;
            if (j11 != -1) {
                this.f77667d = j11 - read;
            }
        }
        return read;
    }
}
