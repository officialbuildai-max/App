package androidx.media3.exoplayer.source;

import android.net.Uri;
import java.util.Map;

/* loaded from: classes2.dex */
final class n implements androidx.media3.datasource.a {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.media3.datasource.a f12939a;

    /* renamed from: b, reason: collision with root package name */
    private final int f12940b;

    /* renamed from: c, reason: collision with root package name */
    private final a f12941c;

    /* renamed from: d, reason: collision with root package name */
    private final byte[] f12942d;

    /* renamed from: e, reason: collision with root package name */
    private int f12943e;

    /* loaded from: classes2.dex */
    public interface a {
        void a(androidx.media3.common.util.j0 j0Var);
    }

    public n(androidx.media3.datasource.a aVar, int i11, a aVar2) {
        androidx.media3.common.util.a.a(i11 > 0);
        this.f12939a = aVar;
        this.f12940b = i11;
        this.f12941c = aVar2;
        this.f12942d = new byte[1];
        this.f12943e = i11;
    }

    private boolean d() {
        if (this.f12939a.read(this.f12942d, 0, 1) == -1) {
            return false;
        }
        int i11 = (this.f12942d[0] & 255) << 4;
        if (i11 == 0) {
            return true;
        }
        byte[] bArr = new byte[i11];
        int i12 = i11;
        int i13 = 0;
        while (i12 > 0) {
            int read = this.f12939a.read(bArr, i13, i12);
            if (read == -1) {
                return false;
            }
            i13 += read;
            i12 -= read;
        }
        while (i11 > 0 && bArr[i11 - 1] == 0) {
            i11--;
        }
        if (i11 > 0) {
            this.f12941c.a(new androidx.media3.common.util.j0(bArr, i11));
        }
        return true;
    }

    @Override // androidx.media3.datasource.a
    public long a(w1.h hVar) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.datasource.a
    public void c(w1.n nVar) {
        androidx.media3.common.util.a.e(nVar);
        this.f12939a.c(nVar);
    }

    @Override // androidx.media3.datasource.a
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.datasource.a
    public Map getResponseHeaders() {
        return this.f12939a.getResponseHeaders();
    }

    @Override // androidx.media3.datasource.a
    public Uri getUri() {
        return this.f12939a.getUri();
    }

    @Override // androidx.media3.common.j
    public int read(byte[] bArr, int i11, int i12) {
        if (this.f12943e == 0) {
            if (!d()) {
                return -1;
            }
            this.f12943e = this.f12940b;
        }
        int read = this.f12939a.read(bArr, i11, Math.min(this.f12943e, i12));
        if (read != -1) {
            this.f12943e -= read;
        }
        return read;
    }
}
