package xf;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.zip.ZipException;
import okhttp3.internal.http2.Settings;

/* loaded from: classes5.dex */
public class j extends FilterOutputStream {

    /* renamed from: m, reason: collision with root package name */
    public static final byte[] f78410m = new byte[0];

    /* renamed from: n, reason: collision with root package name */
    private static final byte[] f78411n = {-1, -1, -1, -1};

    /* renamed from: a, reason: collision with root package name */
    private final HashSet f78412a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f78413b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f78414c;

    /* renamed from: d, reason: collision with root package name */
    private int f78415d;

    /* renamed from: e, reason: collision with root package name */
    private ByteArrayOutputStream f78416e;

    /* renamed from: f, reason: collision with root package name */
    private h f78417f;

    /* renamed from: g, reason: collision with root package name */
    private long f78418g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f78419h;

    /* renamed from: i, reason: collision with root package name */
    private byte[] f78420i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f78421j;

    /* renamed from: k, reason: collision with root package name */
    private final int f78422k;

    /* renamed from: l, reason: collision with root package name */
    private int f78423l;

    public j(OutputStream outputStream) {
        this(outputStream, false);
    }

    public j(OutputStream outputStream, boolean z10) {
        this(outputStream, z10, 4);
    }

    public j(OutputStream outputStream, boolean z10, int i11) {
        super(outputStream);
        this.f78412a = new HashSet();
        this.f78414c = f78410m;
        this.f78415d = 8;
        this.f78416e = new ByteArrayOutputStream();
        this.f78418g = 0L;
        this.f78423l = 0;
        this.f78413b = z10;
        this.f78422k = i11;
    }

    private void d() {
        if (this.f78416e == null) {
            throw new IOException("Stream is closed");
        }
    }

    private void h(String str, byte[] bArr) {
        if (bArr.length <= 65535) {
            return;
        }
        throw new IllegalArgumentException(str + " too long in UTF-8:" + bArr.length + " bytes");
    }

    private int m(h hVar, long j11) {
        int i11;
        if (hVar.f() != 0 || (i11 = this.f78422k) == 0) {
            return 0;
        }
        return (int) ((i11 - (j11 % i11)) % i11);
    }

    private void n(OutputStream outputStream, long j11) {
        if (j11 <= 0) {
            return;
        }
        while (true) {
            long j12 = j11 - 1;
            if (j11 <= 0) {
                return;
            }
            outputStream.write(0);
            j11 = j12;
        }
    }

    static int q(OutputStream outputStream, int i11) {
        outputStream.write(i11 & 255);
        outputStream.write((i11 >> 8) & 255);
        return i11;
    }

    static long r(OutputStream outputStream, long j11) {
        outputStream.write((int) (255 & j11));
        outputStream.write(((int) (j11 >> 8)) & 255);
        outputStream.write(((int) (j11 >> 16)) & 255);
        outputStream.write(((int) (j11 >> 24)) & 255);
        return j11;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (((FilterOutputStream) this).out != null) {
            l();
            ((FilterOutputStream) this).out.close();
            ((FilterOutputStream) this).out = null;
        }
    }

    public void k() {
        long j11;
        d();
        h hVar = this.f78417f;
        if (hVar == null) {
            return;
        }
        if (hVar.f() != 0) {
            r(((FilterOutputStream) this).out, 134695760L);
            r(((FilterOutputStream) this).out, this.f78417f.f78391c);
            r(((FilterOutputStream) this).out, this.f78417f.f78392d);
            r(((FilterOutputStream) this).out, this.f78417f.f78393e);
            j11 = 46;
        } else {
            j11 = 30;
        }
        int i11 = this.f78417f.f() == 0 ? 0 : 8;
        r(this.f78416e, 33639248L);
        q(this.f78416e, 20);
        q(this.f78416e, 20);
        q(this.f78416e, i11 | 2048);
        q(this.f78416e, this.f78417f.f());
        q(this.f78416e, this.f78417f.f78395g);
        q(this.f78416e, this.f78417f.f78396h);
        r(this.f78416e, this.f78417f.f78391c);
        long b11 = j11 + (this.f78417f.f() == 8 ? this.f78417f.b() : this.f78417f.i());
        r(this.f78416e, this.f78417f.b());
        r(this.f78416e, this.f78417f.i());
        long q11 = b11 + q(this.f78416e, this.f78419h.length);
        if (this.f78417f.f78397i != null) {
            q11 += q(this.f78416e, r2.length);
        } else {
            q(this.f78416e, 0);
        }
        q(this.f78416e, this.f78420i.length);
        q(this.f78416e, 0);
        q(this.f78416e, 0);
        r(this.f78416e, 0L);
        r(this.f78416e, this.f78417f.f78398j);
        this.f78416e.write(this.f78419h);
        this.f78419h = null;
        byte[] bArr = this.f78417f.f78397i;
        if (bArr != null) {
            this.f78416e.write(bArr);
        }
        this.f78418g += q11 + this.f78423l;
        this.f78423l = 0;
        byte[] bArr2 = this.f78420i;
        if (bArr2.length > 0) {
            this.f78416e.write(bArr2);
            this.f78420i = f78410m;
        }
        this.f78417f = null;
    }

    public void l() {
        if (((FilterOutputStream) this).out == null) {
            throw new IOException("Stream is closed");
        }
        if (this.f78416e == null) {
            return;
        }
        if (this.f78412a.isEmpty()) {
            throw new ZipException("No entries");
        }
        if (this.f78417f != null) {
            k();
        }
        int size = this.f78416e.size();
        r(this.f78416e, 101010256L);
        q(this.f78416e, 0);
        q(this.f78416e, 0);
        if (this.f78421j) {
            q(this.f78416e, Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            q(this.f78416e, Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            r(this.f78416e, -1L);
            r(this.f78416e, -1L);
        } else {
            q(this.f78416e, this.f78412a.size());
            q(this.f78416e, this.f78412a.size());
            r(this.f78416e, size);
            r(this.f78416e, this.f78418g + this.f78423l);
        }
        q(this.f78416e, this.f78414c.length);
        byte[] bArr = this.f78414c;
        if (bArr.length > 0) {
            this.f78416e.write(bArr);
        }
        this.f78416e.writeTo(((FilterOutputStream) this).out);
        this.f78416e = null;
    }

    public void o(h hVar) {
        if (this.f78417f != null) {
            k();
        }
        int f11 = hVar.f();
        if (f11 == -1) {
            f11 = this.f78415d;
        }
        if (f11 == 0) {
            if (hVar.b() == -1) {
                hVar.j(hVar.i());
            } else if (hVar.i() == -1) {
                hVar.m(hVar.b());
            }
            if (hVar.c() == -1) {
                throw new ZipException("STORED entry missing CRC");
            }
            if (hVar.i() == -1) {
                throw new ZipException("STORED entry missing size");
            }
            if (hVar.f78393e != hVar.f78392d) {
                throw new ZipException("STORED entry size/compressed size mismatch");
            }
        }
        d();
        hVar.f78390b = null;
        hVar.f78397i = null;
        hVar.f78395g = 40691;
        hVar.f78396h = 18698;
        String str = hVar.f78389a;
        Charset charset = f.f78387a;
        byte[] bytes = str.getBytes(charset);
        this.f78419h = bytes;
        h("Name", bytes);
        this.f78420i = f78410m;
        String str2 = hVar.f78390b;
        if (str2 != null) {
            byte[] bytes2 = str2.getBytes(charset);
            this.f78420i = bytes2;
            h("Comment", bytes2);
        }
        hVar.l(f11);
        this.f78417f = hVar;
        hVar.f78398j = this.f78418g;
        this.f78412a.add(hVar.f78389a);
        int i11 = f11 == 0 ? 0 : 8;
        r(((FilterOutputStream) this).out, 67324752L);
        q(((FilterOutputStream) this).out, 20);
        q(((FilterOutputStream) this).out, i11 | 2048);
        q(((FilterOutputStream) this).out, f11);
        q(((FilterOutputStream) this).out, this.f78417f.f78395g);
        q(((FilterOutputStream) this).out, this.f78417f.f78396h);
        if (f11 == 0) {
            r(((FilterOutputStream) this).out, this.f78417f.f78391c);
            r(((FilterOutputStream) this).out, this.f78417f.f78393e);
            r(((FilterOutputStream) this).out, this.f78417f.f78393e);
        } else {
            r(((FilterOutputStream) this).out, 0L);
            r(((FilterOutputStream) this).out, 0L);
            r(((FilterOutputStream) this).out, 0L);
        }
        int length = this.f78419h.length;
        q(((FilterOutputStream) this).out, length);
        int m11 = m(this.f78417f, this.f78418g + 30 + length + (this.f78417f.e() != null ? this.f78417f.e().length : 0));
        this.f78423l = m11;
        byte[] bArr = this.f78417f.f78397i;
        if (bArr != null) {
            q(((FilterOutputStream) this).out, bArr.length + m11);
        } else {
            q(((FilterOutputStream) this).out, m11);
        }
        ((FilterOutputStream) this).out.write(this.f78419h);
        byte[] bArr2 = this.f78417f.f78397i;
        if (bArr2 != null) {
            ((FilterOutputStream) this).out.write(bArr2);
        }
        n(((FilterOutputStream) this).out, this.f78423l);
    }

    public void p(String str) {
        if (str == null) {
            this.f78414c = f78410m;
            return;
        }
        byte[] bytes = str.getBytes(f.f78387a);
        h("Comment", bytes);
        this.f78414c = bytes;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i11, int i12) {
        b.a(bArr.length, i11, i12);
        h hVar = this.f78417f;
        if (hVar == null) {
            throw new ZipException("No active entry");
        }
        if (hVar.f() == 0) {
            ((FilterOutputStream) this).out.write(bArr, i11, i12);
        } else {
            ((FilterOutputStream) this).out.write(bArr, i11, i12);
        }
    }
}
