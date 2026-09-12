package o00;

import java.io.InputStream;

/* loaded from: classes7.dex */
public abstract class b extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f70763a = new byte[1];

    /* renamed from: b, reason: collision with root package name */
    private long f70764b = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i11) {
        h(i11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(long j11) {
        if (j11 != -1) {
            this.f70764b += j11;
        }
    }

    public long k() {
        return this.f70764b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(long j11) {
        this.f70764b -= j11;
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.f70763a, 0, 1) == -1) {
            return -1;
        }
        return this.f70763a[0] & 255;
    }
}
