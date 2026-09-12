package e10;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import org.jsoup.helper.d;

/* loaded from: classes7.dex */
public final class a extends BufferedInputStream {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f61605a;

    /* renamed from: b, reason: collision with root package name */
    private final int f61606b;

    /* renamed from: c, reason: collision with root package name */
    private long f61607c;

    /* renamed from: d, reason: collision with root package name */
    private long f61608d;

    /* renamed from: e, reason: collision with root package name */
    private int f61609e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f61610f;

    private a(InputStream inputStream, int i11, int i12) {
        super(inputStream, i11);
        this.f61608d = 0L;
        d.d(i12 >= 0);
        this.f61606b = i12;
        this.f61609e = i12;
        this.f61605a = i12 != 0;
        this.f61607c = System.nanoTime();
    }

    private boolean d() {
        return this.f61608d != 0 && System.nanoTime() - this.f61607c > this.f61608d;
    }

    public static a k(InputStream inputStream, int i11, int i12) {
        return inputStream instanceof a ? (a) inputStream : new a(inputStream, i11, i12);
    }

    public ByteBuffer h(int i11) {
        d.e(i11 >= 0, "maxSize must be 0 (unlimited) or larger");
        boolean z10 = i11 > 0;
        int i12 = 32768;
        if (z10 && i11 < 32768) {
            i12 = i11;
        }
        byte[] bArr = new byte[i12];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i12);
        while (true) {
            int read = read(bArr);
            if (read == -1) {
                break;
            }
            if (z10) {
                if (read >= i11) {
                    byteArrayOutputStream.write(bArr, 0, i11);
                    break;
                }
                i11 -= read;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
    }

    public a i(long j11, long j12) {
        this.f61607c = j11;
        this.f61608d = j12 * 1000000;
        return this;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) {
        int i13;
        if (this.f61610f || (this.f61605a && this.f61609e <= 0)) {
            return -1;
        }
        if (Thread.interrupted()) {
            this.f61610f = true;
            return -1;
        }
        if (d()) {
            throw new SocketTimeoutException("Read timeout");
        }
        if (this.f61605a && i12 > (i13 = this.f61609e)) {
            i12 = i13;
        }
        try {
            int read = super.read(bArr, i11, i12);
            this.f61609e -= read;
            return read;
        } catch (SocketTimeoutException unused) {
            return 0;
        }
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        super.reset();
        this.f61609e = this.f61606b - ((BufferedInputStream) this).markpos;
    }
}
