package rb;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class g implements Closeable {

    /* renamed from: g, reason: collision with root package name */
    private static final Logger f74375g = Logger.getLogger(g.class.getName());

    /* renamed from: a, reason: collision with root package name */
    private final RandomAccessFile f74376a;

    /* renamed from: b, reason: collision with root package name */
    int f74377b;

    /* renamed from: c, reason: collision with root package name */
    private int f74378c;

    /* renamed from: d, reason: collision with root package name */
    private b f74379d;

    /* renamed from: e, reason: collision with root package name */
    private b f74380e;

    /* renamed from: f, reason: collision with root package name */
    private final byte[] f74381f = new byte[16];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements d {

        /* renamed from: a, reason: collision with root package name */
        boolean f74382a = true;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ StringBuilder f74383b;

        a(StringBuilder sb2) {
            this.f74383b = sb2;
        }

        @Override // rb.g.d
        public void read(InputStream inputStream, int i11) {
            if (this.f74382a) {
                this.f74382a = false;
            } else {
                this.f74383b.append(", ");
            }
            this.f74383b.append(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: c, reason: collision with root package name */
        static final b f74385c = new b(0, 0);

        /* renamed from: a, reason: collision with root package name */
        final int f74386a;

        /* renamed from: b, reason: collision with root package name */
        final int f74387b;

        b(int i11, int i12) {
            this.f74386a = i11;
            this.f74387b = i12;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f74386a + ", length = " + this.f74387b + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class c extends InputStream {

        /* renamed from: a, reason: collision with root package name */
        private int f74388a;

        /* renamed from: b, reason: collision with root package name */
        private int f74389b;

        private c(b bVar) {
            this.f74388a = g.this.a0(bVar.f74386a + 4);
            this.f74389b = bVar.f74387b;
        }

        /* synthetic */ c(g gVar, b bVar, a aVar) {
            this(bVar);
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f74389b == 0) {
                return -1;
            }
            g.this.f74376a.seek(this.f74388a);
            int read = g.this.f74376a.read();
            this.f74388a = g.this.a0(this.f74388a + 1);
            this.f74389b--;
            return read;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i11, int i12) {
            g.r(bArr, "buffer");
            if ((i11 | i12) < 0 || i12 > bArr.length - i11) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i13 = this.f74389b;
            if (i13 <= 0) {
                return -1;
            }
            if (i12 > i13) {
                i12 = i13;
            }
            g.this.T(this.f74388a, bArr, i11, i12);
            this.f74388a = g.this.a0(this.f74388a + i12);
            this.f74389b -= i12;
            return i12;
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void read(InputStream inputStream, int i11);
    }

    public g(File file) {
        if (!file.exists()) {
            p(file);
        }
        this.f74376a = s(file);
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i11, byte[] bArr, int i12, int i13) {
        int a02 = a0(i11);
        int i14 = a02 + i13;
        int i15 = this.f74377b;
        if (i14 <= i15) {
            this.f74376a.seek(a02);
            this.f74376a.readFully(bArr, i12, i13);
            return;
        }
        int i16 = i15 - a02;
        this.f74376a.seek(a02);
        this.f74376a.readFully(bArr, i12, i16);
        this.f74376a.seek(16L);
        this.f74376a.readFully(bArr, i12 + i16, i13 - i16);
    }

    private void U(int i11, byte[] bArr, int i12, int i13) {
        int a02 = a0(i11);
        int i14 = a02 + i13;
        int i15 = this.f74377b;
        if (i14 <= i15) {
            this.f74376a.seek(a02);
            this.f74376a.write(bArr, i12, i13);
            return;
        }
        int i16 = i15 - a02;
        this.f74376a.seek(a02);
        this.f74376a.write(bArr, i12, i16);
        this.f74376a.seek(16L);
        this.f74376a.write(bArr, i12 + i16, i13 - i16);
    }

    private void V(int i11) {
        this.f74376a.setLength(i11);
        this.f74376a.getChannel().force(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a0(int i11) {
        int i12 = this.f74377b;
        return i11 < i12 ? i11 : (i11 + 16) - i12;
    }

    private void c0(int i11, int i12, int i13, int i14) {
        g0(this.f74381f, i11, i12, i13, i14);
        this.f74376a.seek(0L);
        this.f74376a.write(this.f74381f);
    }

    private static void d0(byte[] bArr, int i11, int i12) {
        bArr[i11] = (byte) (i12 >> 24);
        bArr[i11 + 1] = (byte) (i12 >> 16);
        bArr[i11 + 2] = (byte) (i12 >> 8);
        bArr[i11 + 3] = (byte) i12;
    }

    private static void g0(byte[] bArr, int... iArr) {
        int i11 = 0;
        for (int i12 : iArr) {
            d0(bArr, i11, i12);
            i11 += 4;
        }
    }

    private void n(int i11) {
        int i12 = i11 + 4;
        int w11 = w();
        if (w11 >= i12) {
            return;
        }
        int i13 = this.f74377b;
        do {
            w11 += i13;
            i13 <<= 1;
        } while (w11 < i12);
        V(i13);
        b bVar = this.f74380e;
        int a02 = a0(bVar.f74386a + 4 + bVar.f74387b);
        if (a02 < this.f74379d.f74386a) {
            FileChannel channel = this.f74376a.getChannel();
            channel.position(this.f74377b);
            long j11 = a02 - 4;
            if (channel.transferTo(16L, j11, channel) != j11) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i14 = this.f74380e.f74386a;
        int i15 = this.f74379d.f74386a;
        if (i14 < i15) {
            int i16 = (this.f74377b + i14) - 16;
            c0(i13, this.f74378c, i15, i16);
            this.f74380e = new b(i16, this.f74380e.f74387b);
        } else {
            c0(i13, this.f74378c, i15, i14);
        }
        this.f74377b = i13;
    }

    private static void p(File file) {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile s11 = s(file2);
        try {
            s11.setLength(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
            s11.seek(0L);
            byte[] bArr = new byte[16];
            g0(bArr, 4096, 0, 0, 0);
            s11.write(bArr);
            s11.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th2) {
            s11.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object r(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    private static RandomAccessFile s(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    private b t(int i11) {
        if (i11 == 0) {
            return b.f74385c;
        }
        this.f74376a.seek(i11);
        return new b(i11, this.f74376a.readInt());
    }

    private void u() {
        this.f74376a.seek(0L);
        this.f74376a.readFully(this.f74381f);
        int v11 = v(this.f74381f, 0);
        this.f74377b = v11;
        if (v11 <= this.f74376a.length()) {
            this.f74378c = v(this.f74381f, 4);
            int v12 = v(this.f74381f, 8);
            int v13 = v(this.f74381f, 12);
            this.f74379d = t(v12);
            this.f74380e = t(v13);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f74377b + ", Actual length: " + this.f74376a.length());
    }

    private static int v(byte[] bArr, int i11) {
        return ((bArr[i11] & 255) << 24) + ((bArr[i11 + 1] & 255) << 16) + ((bArr[i11 + 2] & 255) << 8) + (bArr[i11 + 3] & 255);
    }

    private int w() {
        return this.f74377b - Z();
    }

    public int Z() {
        if (this.f74378c == 0) {
            return 16;
        }
        b bVar = this.f74380e;
        int i11 = bVar.f74386a;
        int i12 = this.f74379d.f74386a;
        return i11 >= i12 ? (i11 - i12) + 4 + bVar.f74387b + 16 : (((i11 + 4) + bVar.f74387b) + this.f74377b) - i12;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f74376a.close();
    }

    public void k(byte[] bArr) {
        l(bArr, 0, bArr.length);
    }

    public synchronized void l(byte[] bArr, int i11, int i12) {
        int a02;
        try {
            r(bArr, "buffer");
            if ((i11 | i12) < 0 || i12 > bArr.length - i11) {
                throw new IndexOutOfBoundsException();
            }
            n(i12);
            boolean q11 = q();
            if (q11) {
                a02 = 16;
            } else {
                b bVar = this.f74380e;
                a02 = a0(bVar.f74386a + 4 + bVar.f74387b);
            }
            b bVar2 = new b(a02, i12);
            d0(this.f74381f, 0, i12);
            U(bVar2.f74386a, this.f74381f, 0, 4);
            U(bVar2.f74386a + 4, bArr, i11, i12);
            c0(this.f74377b, this.f74378c + 1, q11 ? bVar2.f74386a : this.f74379d.f74386a, bVar2.f74386a);
            this.f74380e = bVar2;
            this.f74378c++;
            if (q11) {
                this.f74379d = bVar2;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void m() {
        try {
            c0(4096, 0, 0, 0);
            this.f74378c = 0;
            b bVar = b.f74385c;
            this.f74379d = bVar;
            this.f74380e = bVar;
            if (this.f74377b > 4096) {
                V(4096);
            }
            this.f74377b = 4096;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void o(d dVar) {
        int i11 = this.f74379d.f74386a;
        for (int i12 = 0; i12 < this.f74378c; i12++) {
            b t11 = t(i11);
            dVar.read(new c(this, t11, null), t11.f74387b);
            i11 = a0(t11.f74386a + 4 + t11.f74387b);
        }
    }

    public synchronized boolean q() {
        return this.f74378c == 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append('[');
        sb2.append("fileLength=");
        sb2.append(this.f74377b);
        sb2.append(", size=");
        sb2.append(this.f74378c);
        sb2.append(", first=");
        sb2.append(this.f74379d);
        sb2.append(", last=");
        sb2.append(this.f74380e);
        sb2.append(", element lengths=[");
        try {
            o(new a(sb2));
        } catch (IOException e11) {
            f74375g.log(Level.WARNING, "read error", (Throwable) e11);
        }
        sb2.append("]]");
        return sb2.toString();
    }

    public synchronized void x() {
        try {
            if (q()) {
                throw new NoSuchElementException();
            }
            if (this.f74378c == 1) {
                m();
            } else {
                b bVar = this.f74379d;
                int a02 = a0(bVar.f74386a + 4 + bVar.f74387b);
                T(a02, this.f74381f, 0, 4);
                int v11 = v(this.f74381f, 0);
                c0(this.f74377b, this.f74378c - 1, a02, this.f74380e.f74386a);
                this.f74378c--;
                this.f74379d = new b(a02, v11);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
