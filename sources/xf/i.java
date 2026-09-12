package xf;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.zip.ZipException;

/* loaded from: classes5.dex */
public class i implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final String f78400a;

    /* renamed from: b, reason: collision with root package name */
    private final LinkedHashMap f78401b;

    /* renamed from: c, reason: collision with root package name */
    private File f78402c;

    /* renamed from: d, reason: collision with root package name */
    private RandomAccessFile f78403d;

    /* renamed from: e, reason: collision with root package name */
    private String f78404e;

    /* loaded from: classes5.dex */
    class a implements Enumeration {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f78405a;

        a(Iterator it) {
            this.f78405a = it;
        }

        @Override // java.util.Enumeration
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public h nextElement() {
            i.this.d();
            return (h) this.f78405a.next();
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            i.this.d();
            return this.f78405a.hasNext();
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends InputStream {

        /* renamed from: a, reason: collision with root package name */
        private final RandomAccessFile f78407a;

        /* renamed from: b, reason: collision with root package name */
        private long f78408b;

        /* renamed from: c, reason: collision with root package name */
        private long f78409c;

        public b(RandomAccessFile randomAccessFile, long j11) {
            this(randomAccessFile, j11, randomAccessFile.length());
        }

        public b(RandomAccessFile randomAccessFile, long j11, long j12) {
            this.f78407a = randomAccessFile;
            this.f78409c = j11;
            this.f78408b = j12;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f78409c < this.f78408b ? 1 : 0;
        }

        @Override // java.io.InputStream
        public int read() {
            return g.b(this);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i11, int i12) {
            synchronized (this.f78407a) {
                try {
                    long j11 = this.f78408b;
                    long j12 = this.f78409c;
                    long j13 = j11 - j12;
                    if (i12 > j13) {
                        i12 = (int) j13;
                    }
                    this.f78407a.seek(j12);
                    int read = this.f78407a.read(bArr, i11, i12);
                    if (read <= 0) {
                        return -1;
                    }
                    this.f78409c += read;
                    return read;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.io.InputStream
        public long skip(long j11) {
            long j12 = this.f78408b;
            long j13 = this.f78409c;
            if (j11 > j12 - j13) {
                j11 = j12 - j13;
            }
            this.f78409c = j13 + j11;
            return j11;
        }
    }

    public i(File file) {
        this(file, 1);
    }

    public i(File file, int i11) {
        this.f78401b = new LinkedHashMap();
        String path = file.getPath();
        this.f78400a = path;
        if (i11 != 1 && i11 != 5) {
            throw new IllegalArgumentException("Bad mode: " + i11);
        }
        if ((i11 & 4) != 0) {
            this.f78402c = file;
            file.deleteOnExit();
        } else {
            this.f78402c = null;
        }
        this.f78403d = new RandomAccessFile(path, CampaignEx.JSON_KEY_AD_R);
        n();
    }

    public i(String str) {
        this(new File(str), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f78403d == null) {
            throw new IllegalStateException("Zip file closed");
        }
    }

    private void n() {
        long length = this.f78403d.length();
        long j11 = length - 22;
        if (j11 < 0) {
            throw new ZipException("File too short to be a zip file: " + this.f78403d.length());
        }
        this.f78403d.seek(0L);
        if (Integer.reverseBytes(this.f78403d.readInt()) != 67324752) {
            throw new ZipException("Not a zip archive");
        }
        long j12 = length - 65558;
        long j13 = j12 >= 0 ? j12 : 0L;
        do {
            this.f78403d.seek(j11);
            if (Integer.reverseBytes(this.f78403d.readInt()) == 101010256) {
                byte[] bArr = new byte[18];
                this.f78403d.readFully(bArr);
                c e11 = d.e(bArr, 0, 18, ByteOrder.LITTLE_ENDIAN);
                int b11 = e11.b() & 65535;
                int b12 = e11.b() & 65535;
                int b13 = e11.b() & 65535;
                int b14 = e11.b() & 65535;
                e11.d(4);
                long a11 = e11.a() & 4294967295L;
                int b15 = e11.b() & 65535;
                if (b13 != b14 || b11 != 0 || b12 != 0) {
                    throw new ZipException("Spanned archives not supported");
                }
                if (b15 > 0) {
                    byte[] bArr2 = new byte[b15];
                    this.f78403d.readFully(bArr2);
                    this.f78404e = new String(bArr2, 0, b15, f.f78387a);
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new b(this.f78403d, a11), 4096);
                byte[] bArr3 = new byte[46];
                for (int i11 = 0; i11 < b13; i11++) {
                    h hVar = new h(bArr3, bufferedInputStream, f.f78387a, false);
                    if (hVar.f78398j >= a11) {
                        throw new ZipException("Local file header offset is after central directory");
                    }
                    String g11 = hVar.g();
                    if (this.f78401b.put(g11, hVar) != null) {
                        throw new ZipException("Duplicate entry name: " + g11);
                    }
                }
                return;
            }
            j11--;
        } while (j11 >= j13);
        throw new ZipException("End Of Central Directory signature not found");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void o(String str, long j11, String str2, long j12, String str3, int i11) {
        throw new ZipException("file name:" + str + ", file size" + j11 + ", entry name:" + str2 + ", entry localHeaderRelOffset:" + j12 + ", " + str3 + " signature not found; was " + Integer.toHexString(i11));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        RandomAccessFile randomAccessFile = this.f78403d;
        if (randomAccessFile != null) {
            synchronized (randomAccessFile) {
                this.f78403d = null;
                randomAccessFile.close();
            }
            File file = this.f78402c;
            if (file != null) {
                file.delete();
                this.f78402c = null;
            }
        }
    }

    public Enumeration h() {
        d();
        return new a(this.f78401b.values().iterator());
    }

    public String k() {
        d();
        return this.f78404e;
    }

    public h l(String str) {
        d();
        if (str == null) {
            throw new NullPointerException("entryName == null");
        }
        h hVar = (h) this.f78401b.get(str);
        if (hVar != null) {
            return hVar;
        }
        return (h) this.f78401b.get(str + "/");
    }

    public InputStream m(h hVar) {
        b bVar;
        h l11 = l(hVar.g());
        if (l11 == null) {
            return null;
        }
        RandomAccessFile randomAccessFile = this.f78403d;
        synchronized (randomAccessFile) {
            try {
                bVar = new b(randomAccessFile, l11.f78398j);
                DataInputStream dataInputStream = new DataInputStream(bVar);
                int reverseBytes = Integer.reverseBytes(dataInputStream.readInt());
                if (reverseBytes != 67324752) {
                    o(this.f78400a, randomAccessFile.length(), l11.g(), l11.f78398j, "Local File Header", reverseBytes);
                }
                dataInputStream.skipBytes(2);
                short reverseBytes2 = Short.reverseBytes(dataInputStream.readShort());
                int i11 = reverseBytes2 & 65535;
                if ((reverseBytes2 & 1) != 0) {
                    throw new ZipException("Invalid General Purpose Bit Flag: " + i11);
                }
                dataInputStream.skipBytes(18);
                int reverseBytes3 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
                int reverseBytes4 = 65535 & Short.reverseBytes(dataInputStream.readShort());
                dataInputStream.close();
                bVar.skip(reverseBytes3 + reverseBytes4);
                if (l11.f78394f == 0) {
                    bVar.f78408b = bVar.f78409c + l11.f78393e;
                } else {
                    bVar.f78408b = bVar.f78409c + l11.f78392d;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }
}
