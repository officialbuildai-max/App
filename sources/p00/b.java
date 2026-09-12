package p00;

import com.google.android.gms.gcm.Task;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.archivers.zip.r;
import org.apache.commons.compress.archivers.zip.s;

/* loaded from: classes7.dex */
public class b extends o00.b {

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f72377c;

    /* renamed from: d, reason: collision with root package name */
    private final int f72378d;

    /* renamed from: e, reason: collision with root package name */
    private final int f72379e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f72380f;

    /* renamed from: g, reason: collision with root package name */
    private long f72381g;

    /* renamed from: h, reason: collision with root package name */
    private long f72382h;

    /* renamed from: i, reason: collision with root package name */
    private final InputStream f72383i;

    /* renamed from: j, reason: collision with root package name */
    private a f72384j;

    /* renamed from: k, reason: collision with root package name */
    private final r f72385k;

    /* renamed from: l, reason: collision with root package name */
    final String f72386l;

    /* renamed from: m, reason: collision with root package name */
    private Map f72387m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f72388n;

    public b(InputStream inputStream) {
        this(inputStream, Task.EXTRAS_LIMIT_BYTES, 512);
    }

    public b(InputStream inputStream, int i11, int i12) {
        this(inputStream, i11, i12, null);
    }

    public b(InputStream inputStream, int i11, int i12, String str) {
        this(inputStream, i11, i12, str, false);
    }

    public b(InputStream inputStream, int i11, int i12, String str, boolean z10) {
        this.f72377c = new byte[256];
        this.f72387m = new HashMap();
        this.f72383i = inputStream;
        this.f72380f = false;
        this.f72386l = str;
        this.f72385k = s.a(str);
        this.f72378d = i12;
        this.f72379e = i11;
        this.f72388n = z10;
    }

    private void T() {
        byte[] r11;
        if (!this.f72384j.i()) {
            return;
        }
        do {
            r11 = r();
            if (r11 == null) {
                this.f72384j = null;
                return;
            }
        } while (new c(r11).a());
    }

    private void Z() {
        if (t()) {
            return;
        }
        long j11 = this.f72381g;
        if (j11 > 0) {
            int i11 = this.f72378d;
            if (j11 % i11 != 0) {
                h(q00.c.c(this.f72383i, (((j11 / i11) + 1) * i11) - j11));
            }
        }
    }

    private void a0() {
        boolean markSupported = this.f72383i.markSupported();
        if (markSupported) {
            this.f72383i.mark(this.f72378d);
        }
        try {
            if (u(U()) || !markSupported) {
            }
        } finally {
            if (markSupported) {
                l(this.f72378d);
                this.f72383i.reset();
            }
        }
    }

    private void m(Map map) {
        this.f72384j.C(map);
    }

    private void n() {
        long k11 = k();
        int i11 = this.f72379e;
        long j11 = k11 % i11;
        if (j11 > 0) {
            h(q00.c.c(this.f72383i, i11 - j11));
        }
    }

    private byte[] r() {
        byte[] U = U();
        V(u(U));
        if (!s() || U == null) {
            return U;
        }
        a0();
        n();
        return null;
    }

    private boolean t() {
        a aVar = this.f72384j;
        return aVar != null && aVar.h();
    }

    private void w() {
        Map v11 = v(this);
        p();
        m(v11);
    }

    private void x() {
        this.f72387m = v(this);
        p();
    }

    protected byte[] U() {
        byte[] bArr = new byte[this.f72378d];
        int a11 = q00.c.a(this.f72383i, bArr);
        b(a11);
        if (a11 != this.f72378d) {
            return null;
        }
        return bArr;
    }

    protected final void V(boolean z10) {
        this.f72380f = z10;
    }

    @Override // java.io.InputStream
    public int available() {
        if (t()) {
            return 0;
        }
        long j11 = this.f72381g;
        long j12 = this.f72382h;
        if (j11 - j12 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) (j11 - j12);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f72383i.close();
    }

    @Override // java.io.InputStream
    public void mark(int i11) {
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    protected byte[] o() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = read(this.f72377c);
            if (read < 0) {
                break;
            }
            byteArrayOutputStream.write(this.f72377c, 0, read);
        }
        p();
        if (this.f72384j == null) {
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        while (length > 0 && byteArray[length - 1] == 0) {
            length--;
        }
        if (length == byteArray.length) {
            return byteArray;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 0, bArr, 0, length);
        return bArr;
    }

    public o00.a p() {
        return q();
    }

    public a q() {
        if (s()) {
            return null;
        }
        if (this.f72384j != null) {
            q00.c.c(this, Long.MAX_VALUE);
            Z();
        }
        byte[] r11 = r();
        if (r11 == null) {
            this.f72384j = null;
            return null;
        }
        try {
            a aVar = new a(r11, this.f72385k, this.f72388n);
            this.f72384j = aVar;
            this.f72382h = 0L;
            this.f72381g = aVar.g();
            if (this.f72384j.j()) {
                byte[] o11 = o();
                if (o11 == null) {
                    return null;
                }
                this.f72384j.w(this.f72385k.a(o11));
            }
            if (this.f72384j.k()) {
                byte[] o12 = o();
                if (o12 == null) {
                    return null;
                }
                this.f72384j.y(this.f72385k.a(o12));
            }
            if (this.f72384j.l()) {
                x();
            }
            if (this.f72384j.n()) {
                w();
            } else if (!this.f72387m.isEmpty()) {
                m(this.f72387m);
            }
            if (this.f72384j.m()) {
                T();
            }
            this.f72381g = this.f72384j.g();
            return this.f72384j;
        } catch (IllegalArgumentException e11) {
            throw new IOException("Error detected parsing the header", e11);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) {
        if (s() || t() || this.f72382h >= this.f72381g) {
            return -1;
        }
        if (this.f72384j == null) {
            throw new IllegalStateException("No current tar entry");
        }
        int min = Math.min(i12, available());
        int read = this.f72383i.read(bArr, i11, min);
        if (read != -1) {
            b(read);
            this.f72382h += read;
        } else {
            if (min > 0) {
                throw new IOException("Truncated TAR archive");
            }
            V(true);
        }
        return read;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
    }

    protected final boolean s() {
        return this.f72380f;
    }

    @Override // java.io.InputStream
    public long skip(long j11) {
        if (j11 <= 0 || t()) {
            return 0L;
        }
        long c11 = q00.c.c(this.f72383i, Math.min(j11, this.f72381g - this.f72382h));
        h(c11);
        this.f72382h += c11;
        return c11;
    }

    protected boolean u(byte[] bArr) {
        return bArr == null || q00.a.a(bArr, this.f72378d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
    
        r4 = r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.util.Map v(java.io.InputStream r10) {
        /*
            r9 = this;
            java.util.HashMap r0 = new java.util.HashMap
            java.util.Map r1 = r9.f72387m
            r0.<init>(r1)
        L7:
            r1 = 0
            r2 = r1
            r3 = r2
        La:
            int r4 = r10.read()
            r5 = -1
            if (r4 == r5) goto L78
            r6 = 1
            int r2 = r2 + r6
            r7 = 10
            if (r4 != r7) goto L18
            goto L78
        L18:
            r7 = 32
            if (r4 != r7) goto L72
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream
            r4.<init>()
        L21:
            int r7 = r10.read()
            if (r7 == r5) goto L70
            int r2 = r2 + r6
            r8 = 61
            if (r7 != r8) goto L6b
            java.lang.String r8 = "UTF-8"
            java.lang.String r4 = r4.toString(r8)
            int r3 = r3 - r2
            if (r3 != r6) goto L39
            r0.remove(r4)
            goto L70
        L39:
            byte[] r2 = new byte[r3]
            int r6 = q00.c.a(r10, r2)
            if (r6 != r3) goto L4c
            java.lang.String r6 = new java.lang.String
            int r3 = r3 + (-1)
            r6.<init>(r2, r1, r3, r8)
            r0.put(r4, r6)
            goto L70
        L4c:
            java.io.IOException r10 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to read Paxheader. Expected "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r1 = " bytes, read "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L6b:
            byte r7 = (byte) r7
            r4.write(r7)
            goto L21
        L70:
            r4 = r7
            goto L78
        L72:
            int r3 = r3 * 10
            int r4 = r4 + (-48)
            int r3 = r3 + r4
            goto La
        L78:
            if (r4 != r5) goto L7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p00.b.v(java.io.InputStream):java.util.Map");
    }
}
