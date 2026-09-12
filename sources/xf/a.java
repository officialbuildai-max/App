package xf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

/* loaded from: classes5.dex */
public class a extends DeflaterOutputStream {

    /* renamed from: p, reason: collision with root package name */
    private static final byte[] f78365p = new byte[0];

    /* renamed from: q, reason: collision with root package name */
    private static final byte[] f78366q = {0};

    /* renamed from: a, reason: collision with root package name */
    private byte[] f78367a;

    /* renamed from: b, reason: collision with root package name */
    private final HashSet f78368b;

    /* renamed from: c, reason: collision with root package name */
    private int f78369c;

    /* renamed from: d, reason: collision with root package name */
    private int f78370d;

    /* renamed from: e, reason: collision with root package name */
    private ByteArrayOutputStream f78371e;

    /* renamed from: f, reason: collision with root package name */
    private ZipEntry f78372f;

    /* renamed from: g, reason: collision with root package name */
    private final CRC32 f78373g;

    /* renamed from: h, reason: collision with root package name */
    private long f78374h;

    /* renamed from: i, reason: collision with root package name */
    private int f78375i;

    /* renamed from: j, reason: collision with root package name */
    private int f78376j;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f78377k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f78378l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f78379m;

    /* renamed from: n, reason: collision with root package name */
    private final int f78380n;

    /* renamed from: o, reason: collision with root package name */
    private int f78381o;

    public a(OutputStream outputStream) {
        this(outputStream, 4);
    }

    public a(OutputStream outputStream, int i11) {
        super(outputStream, new Deflater(-1, true));
        this.f78367a = f78365p;
        this.f78368b = new HashSet();
        this.f78369c = 8;
        this.f78370d = -1;
        this.f78371e = new ByteArrayOutputStream();
        this.f78373g = new CRC32();
        this.f78374h = 0L;
        this.f78375i = 0;
        this.f78378l = false;
        this.f78379m = false;
        this.f78381o = 0;
        this.f78380n = i11;
    }

    private void b(int i11, int i12, int i13) {
        if ((i12 | i13) < 0 || i12 > i11 || i11 - i12 < i13) {
            throw new ArrayIndexOutOfBoundsException("length=" + i11 + "; regionStart=" + i12 + "; regionLength=" + i13);
        }
    }

    private void d() {
        if (this.f78379m) {
            throw new IOException("Stream is closed");
        }
    }

    private int i(ZipEntry zipEntry, int i11) {
        int i12;
        if (zipEntry.getMethod() != 0 || (i12 = this.f78380n) == 0) {
            return 0;
        }
        return (i12 - (i11 % i12)) % i12;
    }

    private void k(OutputStream outputStream, int i11) {
        if (i11 <= 0) {
            return;
        }
        while (true) {
            int i12 = i11 - 1;
            if (i11 <= 0) {
                return;
            }
            outputStream.write(0);
            i11 = i12;
        }
    }

    private long m(OutputStream outputStream, long j11) {
        outputStream.write((int) (255 & j11));
        outputStream.write(((int) (j11 >> 8)) & 255);
        outputStream.write(((int) (j11 >> 16)) & 255);
        outputStream.write(((int) (j11 >> 24)) & 255);
        return j11;
    }

    private int n(OutputStream outputStream, int i11) {
        if (i11 <= 65535) {
            outputStream.write(i11 & 255);
            outputStream.write((i11 >> 8) & 255);
            return i11;
        }
        throw new IllegalArgumentException("value " + i11 + " is too large for type 'short'.");
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f78379m) {
            return;
        }
        finish();
        ((DeflaterOutputStream) this).def.end();
        ((DeflaterOutputStream) this).out.close();
        ((DeflaterOutputStream) this).out = null;
        this.f78379m = true;
    }

    @Override // java.util.zip.DeflaterOutputStream
    public void finish() {
        d();
        if (this.f78378l) {
            return;
        }
        if (this.f78368b.isEmpty()) {
            throw new ZipException("No entries");
        }
        if (this.f78372f != null) {
            h();
        }
        int size = this.f78371e.size();
        m(this.f78371e, 101010256L);
        n(this.f78371e, 0);
        n(this.f78371e, 0);
        n(this.f78371e, this.f78368b.size());
        n(this.f78371e, this.f78368b.size());
        m(this.f78371e, size);
        m(this.f78371e, this.f78375i + this.f78381o);
        n(this.f78371e, this.f78367a.length);
        byte[] bArr = this.f78367a;
        if (bArr.length > 0) {
            this.f78371e.write(bArr);
        }
        this.f78371e.writeTo(((DeflaterOutputStream) this).out);
        this.f78371e = null;
        this.f78378l = true;
    }

    public void h() {
        int i11;
        int m11;
        d();
        ZipEntry zipEntry = this.f78372f;
        if (zipEntry == null) {
            return;
        }
        if (zipEntry.getMethod() == 8) {
            super.finish();
        }
        if (this.f78372f.getMethod() == 0) {
            if (this.f78373g.getValue() != this.f78372f.getCrc()) {
                throw new ZipException("CRC mismatch");
            }
            if (this.f78372f.getSize() != this.f78374h) {
                throw new ZipException("Size mismatch");
            }
        }
        if (this.f78372f.getMethod() != 0) {
            m(((DeflaterOutputStream) this).out, 134695760L);
            this.f78372f.setCrc(this.f78373g.getValue());
            m(((DeflaterOutputStream) this).out, this.f78372f.getCrc());
            this.f78372f.setCompressedSize(((DeflaterOutputStream) this).def.getTotalOut());
            m(((DeflaterOutputStream) this).out, this.f78372f.getCompressedSize());
            this.f78372f.setSize(((DeflaterOutputStream) this).def.getTotalIn());
            m(((DeflaterOutputStream) this).out, this.f78372f.getSize());
            i11 = 46;
        } else {
            i11 = 30;
        }
        int i12 = this.f78372f.getMethod() == 0 ? 0 : 8;
        m(this.f78371e, 33639248L);
        n(this.f78371e, 20);
        n(this.f78371e, 20);
        n(this.f78371e, i12 | 2048);
        n(this.f78371e, this.f78372f.getMethod());
        n(this.f78371e, 0);
        n(this.f78371e, 33);
        m(this.f78371e, this.f78373g.getValue());
        if (this.f78372f.getMethod() == 8) {
            m11 = (int) (i11 + m(this.f78371e, ((DeflaterOutputStream) this).def.getTotalOut()));
            m(this.f78371e, ((DeflaterOutputStream) this).def.getTotalIn());
        } else {
            m11 = (int) (i11 + m(this.f78371e, this.f78374h));
            m(this.f78371e, this.f78374h);
        }
        int n11 = m11 + n(this.f78371e, this.f78376j);
        if (this.f78372f.getExtra() != null) {
            n11 += n(this.f78371e, this.f78372f.getExtra().length);
        } else {
            n(this.f78371e, 0);
        }
        String comment = this.f78372f.getComment();
        byte[] bArr = f78365p;
        if (comment != null) {
            bArr = comment.getBytes(Charset.forName("UTF-8"));
        }
        n(this.f78371e, bArr.length);
        n(this.f78371e, 0);
        n(this.f78371e, 0);
        m(this.f78371e, 0L);
        m(this.f78371e, this.f78375i);
        this.f78371e.write(this.f78377k);
        this.f78377k = null;
        if (this.f78372f.getExtra() != null) {
            this.f78371e.write(this.f78372f.getExtra());
        }
        this.f78375i += n11 + this.f78381o;
        this.f78381o = 0;
        if (bArr.length > 0) {
            this.f78371e.write(bArr);
        }
        this.f78372f = null;
        this.f78373g.reset();
        this.f78374h = 0L;
        ((DeflaterOutputStream) this).def.reset();
    }

    public void l(ZipEntry zipEntry) {
        if (this.f78372f != null) {
            h();
        }
        int method = zipEntry.getMethod();
        if (method == -1) {
            method = this.f78369c;
        }
        if (method == 0) {
            if (zipEntry.getCompressedSize() == -1) {
                zipEntry.setCompressedSize(zipEntry.getSize());
            } else if (zipEntry.getSize() == -1) {
                zipEntry.setSize(zipEntry.getCompressedSize());
            }
            if (zipEntry.getCrc() == -1) {
                throw new ZipException("STORED entry missing CRC");
            }
            if (zipEntry.getSize() == -1) {
                throw new ZipException("STORED entry missing size");
            }
            if (zipEntry.getSize() != zipEntry.getCompressedSize()) {
                throw new ZipException("STORED entry size/compressed size mismatch");
            }
        }
        d();
        if (this.f78368b.contains(zipEntry.getName())) {
            throw new ZipException("Entry already exists: " + zipEntry.getName());
        }
        if (this.f78368b.size() == 65535) {
            throw new ZipException("Too many entries for the zip file format's 16-bit entry count");
        }
        byte[] bytes = zipEntry.getName().getBytes(Charset.forName("UTF-8"));
        this.f78377k = bytes;
        int length = bytes.length;
        this.f78376j = length;
        if (length > 65535) {
            throw new IllegalArgumentException("Name too long: " + this.f78376j + " UTF-8 bytes");
        }
        ((DeflaterOutputStream) this).def.setLevel(this.f78370d);
        zipEntry.setMethod(method);
        this.f78372f = zipEntry;
        this.f78368b.add(zipEntry.getName());
        int i11 = method == 0 ? 0 : 8;
        m(((DeflaterOutputStream) this).out, 67324752L);
        n(((DeflaterOutputStream) this).out, 20);
        n(((DeflaterOutputStream) this).out, i11 | 2048);
        n(((DeflaterOutputStream) this).out, method);
        if (this.f78372f.getTime() == -1) {
            this.f78372f.setTime(System.currentTimeMillis());
        }
        n(((DeflaterOutputStream) this).out, 0);
        n(((DeflaterOutputStream) this).out, 33);
        if (method == 0) {
            m(((DeflaterOutputStream) this).out, this.f78372f.getCrc());
            m(((DeflaterOutputStream) this).out, this.f78372f.getSize());
            m(((DeflaterOutputStream) this).out, this.f78372f.getSize());
        } else {
            m(((DeflaterOutputStream) this).out, 0L);
            m(((DeflaterOutputStream) this).out, 0L);
            m(((DeflaterOutputStream) this).out, 0L);
        }
        n(((DeflaterOutputStream) this).out, this.f78376j);
        this.f78381o = i(this.f78372f, this.f78375i + 30 + this.f78376j + (this.f78372f.getExtra() != null ? this.f78372f.getExtra().length : 0));
        if (this.f78372f.getExtra() != null) {
            n(((DeflaterOutputStream) this).out, this.f78372f.getExtra().length + this.f78381o);
        } else {
            n(((DeflaterOutputStream) this).out, this.f78381o);
        }
        ((DeflaterOutputStream) this).out.write(this.f78377k);
        if (this.f78372f.getExtra() != null) {
            ((DeflaterOutputStream) this).out.write(this.f78372f.getExtra());
        }
        k(((DeflaterOutputStream) this).out, this.f78381o);
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i11) {
        byte[] bArr = f78366q;
        bArr[0] = (byte) (i11 & 255);
        write(bArr, 0, 1);
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i11, int i12) {
        b(bArr.length, i11, i12);
        ZipEntry zipEntry = this.f78372f;
        if (zipEntry == null) {
            throw new ZipException("No active entry");
        }
        if (zipEntry.getMethod() == 0) {
            ((DeflaterOutputStream) this).out.write(bArr, i11, i12);
        } else {
            super.write(bArr, i11, i12);
        }
        this.f78373g.update(bArr, i11, i12);
        this.f78374h += i12;
    }
}
