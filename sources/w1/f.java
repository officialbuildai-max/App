package w1;

import java.io.InputStream;

/* loaded from: classes2.dex */
public final class f extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.media3.datasource.a f77628a;

    /* renamed from: b, reason: collision with root package name */
    private final h f77629b;

    /* renamed from: f, reason: collision with root package name */
    private long f77633f;

    /* renamed from: d, reason: collision with root package name */
    private boolean f77631d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f77632e = false;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f77630c = new byte[1];

    public f(androidx.media3.datasource.a aVar, h hVar) {
        this.f77628a = aVar;
        this.f77629b = hVar;
    }

    private void d() {
        if (this.f77631d) {
            return;
        }
        this.f77628a.a(this.f77629b);
        this.f77631d = true;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f77632e) {
            return;
        }
        this.f77628a.close();
        this.f77632e = true;
    }

    public void h() {
        d();
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.f77630c) == -1) {
            return -1;
        }
        return this.f77630c[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) {
        androidx.media3.common.util.a.g(!this.f77632e);
        d();
        int read = this.f77628a.read(bArr, i11, i12);
        if (read == -1) {
            return -1;
        }
        this.f77633f += read;
        return read;
    }
}
