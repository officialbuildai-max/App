package xl;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class l implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f78489a;

    /* renamed from: b, reason: collision with root package name */
    private final Charset f78490b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f78491c;

    /* renamed from: d, reason: collision with root package name */
    private int f78492d;

    /* renamed from: e, reason: collision with root package name */
    private int f78493e;

    /* loaded from: classes6.dex */
    class a extends ByteArrayOutputStream {
        a(int i11) {
            super(i11);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i11 = ((ByteArrayOutputStream) this).count;
            if (i11 > 0) {
                int i12 = i11 - 1;
                if (((ByteArrayOutputStream) this).buf[i12] == 13) {
                    i11 = i12;
                }
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i11, l.this.f78490b.name());
            } catch (UnsupportedEncodingException e11) {
                throw new AssertionError(e11);
            }
        }
    }

    public l(InputStream inputStream, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (!charset.equals(d.f78443a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f78489a = inputStream;
        this.f78490b = charset;
        this.f78491c = new byte[8192];
    }

    private void k() {
        InputStream inputStream = this.f78489a;
        byte[] bArr = this.f78491c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f78492d = 0;
        this.f78493e = read;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f78489a) {
            try {
                if (this.f78491c != null) {
                    this.f78491c = null;
                    this.f78489a.close();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean d() {
        return this.f78493e == -1;
    }

    public String h() {
        int i11;
        byte[] bArr;
        int i12;
        synchronized (this.f78489a) {
            try {
                if (this.f78491c == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.f78492d >= this.f78493e) {
                    k();
                }
                for (int i13 = this.f78492d; i13 != this.f78493e; i13++) {
                    byte[] bArr2 = this.f78491c;
                    if (bArr2[i13] == 10) {
                        int i14 = this.f78492d;
                        if (i13 != i14) {
                            i12 = i13 - 1;
                            if (bArr2[i12] == 13) {
                                String str = new String(bArr2, i14, i12 - i14, this.f78490b.name());
                                this.f78492d = i13 + 1;
                                return str;
                            }
                        }
                        i12 = i13;
                        String str2 = new String(bArr2, i14, i12 - i14, this.f78490b.name());
                        this.f78492d = i13 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f78493e - this.f78492d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f78491c;
                    int i15 = this.f78492d;
                    aVar.write(bArr3, i15, this.f78493e - i15);
                    this.f78493e = -1;
                    k();
                    i11 = this.f78492d;
                    while (i11 != this.f78493e) {
                        bArr = this.f78491c;
                        if (bArr[i11] == 10) {
                            break loop1;
                        }
                        i11++;
                    }
                }
                int i16 = this.f78492d;
                if (i11 != i16) {
                    aVar.write(bArr, i16, i11 - i16);
                }
                this.f78492d = i11 + 1;
                return aVar.toString();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
