package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.b;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import org.apache.tools.zip.UnixStat;

/* loaded from: classes.dex */
public class a {
    private static SimpleDateFormat T;
    private static SimpleDateFormat U;
    private static final d[] Y;
    private static final d[] Z;

    /* renamed from: a0, reason: collision with root package name */
    private static final d[] f9230a0;

    /* renamed from: b0, reason: collision with root package name */
    private static final d[] f9231b0;

    /* renamed from: c0, reason: collision with root package name */
    private static final d[] f9232c0;

    /* renamed from: d0, reason: collision with root package name */
    private static final d f9233d0;

    /* renamed from: e0, reason: collision with root package name */
    private static final d[] f9234e0;

    /* renamed from: f0, reason: collision with root package name */
    private static final d[] f9235f0;

    /* renamed from: g0, reason: collision with root package name */
    private static final d[] f9236g0;

    /* renamed from: h0, reason: collision with root package name */
    private static final d[] f9237h0;

    /* renamed from: i0, reason: collision with root package name */
    static final d[][] f9238i0;

    /* renamed from: j0, reason: collision with root package name */
    private static final d[] f9239j0;

    /* renamed from: k0, reason: collision with root package name */
    private static final HashMap[] f9240k0;

    /* renamed from: l0, reason: collision with root package name */
    private static final HashMap[] f9241l0;

    /* renamed from: m0, reason: collision with root package name */
    private static final HashSet f9242m0;

    /* renamed from: n0, reason: collision with root package name */
    private static final HashMap f9243n0;

    /* renamed from: o0, reason: collision with root package name */
    static final Charset f9244o0;

    /* renamed from: p0, reason: collision with root package name */
    static final byte[] f9245p0;

    /* renamed from: q0, reason: collision with root package name */
    private static final byte[] f9246q0;

    /* renamed from: r0, reason: collision with root package name */
    private static final Pattern f9247r0;

    /* renamed from: s0, reason: collision with root package name */
    private static final Pattern f9248s0;

    /* renamed from: t0, reason: collision with root package name */
    private static final Pattern f9249t0;

    /* renamed from: u0, reason: collision with root package name */
    private static final Pattern f9251u0;

    /* renamed from: a, reason: collision with root package name */
    private String f9257a;

    /* renamed from: b, reason: collision with root package name */
    private FileDescriptor f9258b;

    /* renamed from: c, reason: collision with root package name */
    private AssetManager.AssetInputStream f9259c;

    /* renamed from: d, reason: collision with root package name */
    private int f9260d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f9261e;

    /* renamed from: f, reason: collision with root package name */
    private final HashMap[] f9262f;

    /* renamed from: g, reason: collision with root package name */
    private Set f9263g;

    /* renamed from: h, reason: collision with root package name */
    private ByteOrder f9264h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f9265i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f9266j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f9267k;

    /* renamed from: l, reason: collision with root package name */
    private int f9268l;

    /* renamed from: m, reason: collision with root package name */
    private int f9269m;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f9270n;

    /* renamed from: o, reason: collision with root package name */
    private int f9271o;

    /* renamed from: p, reason: collision with root package name */
    private int f9272p;

    /* renamed from: q, reason: collision with root package name */
    private int f9273q;

    /* renamed from: r, reason: collision with root package name */
    private int f9274r;

    /* renamed from: s, reason: collision with root package name */
    private int f9275s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f9276t;

    /* renamed from: u, reason: collision with root package name */
    private static final boolean f9250u = Log.isLoggable("ExifInterface", 3);

    /* renamed from: v, reason: collision with root package name */
    private static final List f9252v = Arrays.asList(1, 6, 3, 8);

    /* renamed from: w, reason: collision with root package name */
    private static final List f9253w = Arrays.asList(2, 7, 4, 5);

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f9254x = {8, 8, 8};

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f9255y = {4};

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f9256z = {8};
    static final byte[] A = {-1, -40, -1};
    private static final byte[] B = {102, 116, 121, 112};
    private static final byte[] C = {109, 105, 102, 49};
    private static final byte[] D = {104, 101, 105, 99};
    private static final byte[] E = {79, 76, 89, 77, 80, 0};
    private static final byte[] F = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final byte[] G = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] H = {101, 88, 73, 102};
    private static final byte[] I = {73, 72, 68, 82};
    private static final byte[] J = {73, 69, 78, 68};
    private static final byte[] K = {82, 73, 70, 70};
    private static final byte[] L = {87, 69, 66, 80};
    private static final byte[] M = {69, 88, 73, 70};
    private static final byte[] N = {-99, 1, 42};
    private static final byte[] O = "VP8X".getBytes(Charset.defaultCharset());
    private static final byte[] P = "VP8L".getBytes(Charset.defaultCharset());
    private static final byte[] Q = "VP8 ".getBytes(Charset.defaultCharset());
    private static final byte[] R = "ANIM".getBytes(Charset.defaultCharset());
    private static final byte[] S = "ANMF".getBytes(Charset.defaultCharset());
    static final String[] V = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] W = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] X = {65, 83, 67, 73, 73, 0, 0, 0};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.exifinterface.media.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0088a extends MediaDataSource {

        /* renamed from: a, reason: collision with root package name */
        long f9277a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f9278b;

        C0088a(f fVar) {
            this.f9278b = fVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // android.media.MediaDataSource
        public long getSize() {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j11, byte[] bArr, int i11, int i12) {
            if (i12 == 0) {
                return 0;
            }
            if (j11 < 0) {
                return -1;
            }
            try {
                long j12 = this.f9277a;
                if (j12 != j11) {
                    if (j12 >= 0 && j11 >= j12 + this.f9278b.available()) {
                        return -1;
                    }
                    this.f9278b.l(j11);
                    this.f9277a = j11;
                }
                if (i12 > this.f9278b.available()) {
                    i12 = this.f9278b.available();
                }
                int read = this.f9278b.read(bArr, i11, i12);
                if (read >= 0) {
                    this.f9277a += read;
                    return read;
                }
            } catch (IOException unused) {
            }
            this.f9277a = -1L;
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends InputStream implements DataInput {

        /* renamed from: e, reason: collision with root package name */
        private static final ByteOrder f9280e = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: f, reason: collision with root package name */
        private static final ByteOrder f9281f = ByteOrder.BIG_ENDIAN;

        /* renamed from: a, reason: collision with root package name */
        final DataInputStream f9282a;

        /* renamed from: b, reason: collision with root package name */
        private ByteOrder f9283b;

        /* renamed from: c, reason: collision with root package name */
        int f9284c;

        /* renamed from: d, reason: collision with root package name */
        private byte[] f9285d;

        b(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        b(InputStream inputStream, ByteOrder byteOrder) {
            this.f9283b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f9282a = dataInputStream;
            dataInputStream.mark(0);
            this.f9284c = 0;
            this.f9283b = byteOrder;
        }

        b(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f9282a.available();
        }

        public int d() {
            return this.f9284c;
        }

        public long h() {
            return readInt() & 4294967295L;
        }

        public void i(ByteOrder byteOrder) {
            this.f9283b = byteOrder;
        }

        public void k(int i11) {
            int i12 = 0;
            while (i12 < i11) {
                int i13 = i11 - i12;
                int skip = (int) this.f9282a.skip(i13);
                if (skip <= 0) {
                    if (this.f9285d == null) {
                        this.f9285d = new byte[8192];
                    }
                    skip = this.f9282a.read(this.f9285d, 0, Math.min(8192, i13));
                    if (skip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i11 + " bytes.");
                    }
                }
                i12 += skip;
            }
            this.f9284c += i12;
        }

        @Override // java.io.InputStream
        public void mark(int i11) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public int read() {
            this.f9284c++;
            return this.f9282a.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i11, int i12) {
            int read = this.f9282a.read(bArr, i11, i12);
            this.f9284c += read;
            return read;
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.f9284c++;
            return this.f9282a.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() {
            this.f9284c++;
            int read = this.f9282a.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.f9284c += 2;
            return this.f9282a.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) {
            this.f9284c += bArr.length;
            this.f9282a.readFully(bArr);
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i11, int i12) {
            this.f9284c += i12;
            this.f9282a.readFully(bArr, i11, i12);
        }

        @Override // java.io.DataInput
        public int readInt() {
            this.f9284c += 4;
            int read = this.f9282a.read();
            int read2 = this.f9282a.read();
            int read3 = this.f9282a.read();
            int read4 = this.f9282a.read();
            if ((read | read2 | read3 | read4) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f9283b;
            if (byteOrder == f9280e) {
                return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == f9281f) {
                return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
            }
            throw new IOException("Invalid byte order: " + this.f9283b);
        }

        @Override // java.io.DataInput
        public String readLine() {
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() {
            this.f9284c += 8;
            int read = this.f9282a.read();
            int read2 = this.f9282a.read();
            int read3 = this.f9282a.read();
            int read4 = this.f9282a.read();
            int read5 = this.f9282a.read();
            int read6 = this.f9282a.read();
            int read7 = this.f9282a.read();
            int read8 = this.f9282a.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f9283b;
            if (byteOrder == f9280e) {
                return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == f9281f) {
                return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
            }
            throw new IOException("Invalid byte order: " + this.f9283b);
        }

        @Override // java.io.DataInput
        public short readShort() {
            this.f9284c += 2;
            int read = this.f9282a.read();
            int read2 = this.f9282a.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f9283b;
            if (byteOrder == f9280e) {
                return (short) ((read2 << 8) + read);
            }
            if (byteOrder == f9281f) {
                return (short) ((read << 8) + read2);
            }
            throw new IOException("Invalid byte order: " + this.f9283b);
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.f9284c += 2;
            return this.f9282a.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.f9284c++;
            return this.f9282a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() {
            this.f9284c += 2;
            int read = this.f9282a.read();
            int read2 = this.f9282a.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f9283b;
            if (byteOrder == f9280e) {
                return (read2 << 8) + read;
            }
            if (byteOrder == f9281f) {
                return (read << 8) + read2;
            }
            throw new IOException("Invalid byte order: " + this.f9283b);
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public int skipBytes(int i11) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f9286a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9287b;

        /* renamed from: c, reason: collision with root package name */
        public final long f9288c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f9289d;

        c(int i11, int i12, long j11, byte[] bArr) {
            this.f9286a = i11;
            this.f9287b = i12;
            this.f9288c = j11;
            this.f9289d = bArr;
        }

        c(int i11, int i12, byte[] bArr) {
            this(i11, i12, -1L, bArr);
        }

        public static c a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(a.f9244o0);
            return new c(2, bytes.length, bytes);
        }

        public static c b(long j11, ByteOrder byteOrder) {
            return c(new long[]{j11}, byteOrder);
        }

        public static c c(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.W[4] * jArr.length]);
            wrap.order(byteOrder);
            for (long j11 : jArr) {
                wrap.putInt((int) j11);
            }
            return new c(4, jArr.length, wrap.array());
        }

        public static c d(e eVar, ByteOrder byteOrder) {
            return e(new e[]{eVar}, byteOrder);
        }

        public static c e(e[] eVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.W[5] * eVarArr.length]);
            wrap.order(byteOrder);
            for (e eVar : eVarArr) {
                wrap.putInt((int) eVar.f9294a);
                wrap.putInt((int) eVar.f9295b);
            }
            return new c(5, eVarArr.length, wrap.array());
        }

        public static c f(int i11, ByteOrder byteOrder) {
            return g(new int[]{i11}, byteOrder);
        }

        public static c g(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.W[3] * iArr.length]);
            wrap.order(byteOrder);
            for (int i11 : iArr) {
                wrap.putShort((short) i11);
            }
            return new c(3, iArr.length, wrap.array());
        }

        public double h(ByteOrder byteOrder) {
            Object k11 = k(byteOrder);
            if (k11 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (k11 instanceof String) {
                return Double.parseDouble((String) k11);
            }
            if (k11 instanceof long[]) {
                if (((long[]) k11).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (k11 instanceof int[]) {
                if (((int[]) k11).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (k11 instanceof double[]) {
                double[] dArr = (double[]) k11;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(k11 instanceof e[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            e[] eVarArr = (e[]) k11;
            if (eVarArr.length == 1) {
                return eVarArr[0].a();
            }
            throw new NumberFormatException("There are more than one component");
        }

        public int i(ByteOrder byteOrder) {
            Object k11 = k(byteOrder);
            if (k11 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (k11 instanceof String) {
                return Integer.parseInt((String) k11);
            }
            if (k11 instanceof long[]) {
                long[] jArr = (long[]) k11;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(k11 instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) k11;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public String j(ByteOrder byteOrder) {
            Object k11 = k(byteOrder);
            if (k11 == null) {
                return null;
            }
            if (k11 instanceof String) {
                return (String) k11;
            }
            StringBuilder sb2 = new StringBuilder();
            int i11 = 0;
            if (k11 instanceof long[]) {
                long[] jArr = (long[]) k11;
                while (i11 < jArr.length) {
                    sb2.append(jArr[i11]);
                    i11++;
                    if (i11 != jArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            }
            if (k11 instanceof int[]) {
                int[] iArr = (int[]) k11;
                while (i11 < iArr.length) {
                    sb2.append(iArr[i11]);
                    i11++;
                    if (i11 != iArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            }
            if (k11 instanceof double[]) {
                double[] dArr = (double[]) k11;
                while (i11 < dArr.length) {
                    sb2.append(dArr[i11]);
                    i11++;
                    if (i11 != dArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            }
            if (!(k11 instanceof e[])) {
                return null;
            }
            e[] eVarArr = (e[]) k11;
            while (i11 < eVarArr.length) {
                sb2.append(eVarArr[i11].f9294a);
                sb2.append('/');
                sb2.append(eVarArr[i11].f9295b);
                i11++;
                if (i11 != eVarArr.length) {
                    sb2.append(",");
                }
            }
            return sb2.toString();
        }

        /* JADX WARN: Not initialized variable reg: 5, insn: 0x0030: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:166:0x0030 */
        /* JADX WARN: Removed duplicated region for block: B:169:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        java.lang.Object k(java.nio.ByteOrder r12) {
            /*
                Method dump skipped, instructions count: 436
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.c.k(java.nio.ByteOrder):java.lang.Object");
        }

        public String toString() {
            return "(" + a.V[this.f9286a] + ", data length:" + this.f9289d.length + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f9290a;

        /* renamed from: b, reason: collision with root package name */
        public final String f9291b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9292c;

        /* renamed from: d, reason: collision with root package name */
        public final int f9293d;

        d(String str, int i11, int i12) {
            this.f9291b = str;
            this.f9290a = i11;
            this.f9292c = i12;
            this.f9293d = -1;
        }

        d(String str, int i11, int i12, int i13) {
            this.f9291b = str;
            this.f9290a = i11;
            this.f9292c = i12;
            this.f9293d = i13;
        }

        boolean a(int i11) {
            int i12;
            int i13 = this.f9292c;
            if (i13 == 7 || i11 == 7 || i13 == i11 || (i12 = this.f9293d) == i11) {
                return true;
            }
            if ((i13 == 4 || i12 == 4) && i11 == 3) {
                return true;
            }
            if ((i13 == 9 || i12 == 9) && i11 == 8) {
                return true;
            }
            return (i13 == 12 || i12 == 12) && i11 == 11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final long f9294a;

        /* renamed from: b, reason: collision with root package name */
        public final long f9295b;

        e(long j11, long j12) {
            if (j12 == 0) {
                this.f9294a = 0L;
                this.f9295b = 1L;
            } else {
                this.f9294a = j11;
                this.f9295b = j12;
            }
        }

        public double a() {
            return this.f9294a / this.f9295b;
        }

        public String toString() {
            return this.f9294a + "/" + this.f9295b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f extends b {
        f(InputStream inputStream) {
            super(inputStream);
            if (!inputStream.markSupported()) {
                throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
            }
            this.f9282a.mark(Integer.MAX_VALUE);
        }

        f(byte[] bArr) {
            super(bArr);
            this.f9282a.mark(Integer.MAX_VALUE);
        }

        public void l(long j11) {
            int i11 = this.f9284c;
            if (i11 > j11) {
                this.f9284c = 0;
                this.f9282a.reset();
            } else {
                j11 -= i11;
            }
            k((int) j11);
        }
    }

    static {
        d[] dVarArr = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ImageWidth", 256, 3, 4), new d("ImageLength", InputDeviceCompat.SOURCE_KEYBOARD, 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("Orientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", Sdk$SDKError.Reason.MRAID_ERROR_VALUE, 3), new d("Software", Sdk$SDKError.Reason.MRAID_BRIDGE_ERROR_VALUE, 2), new d("DateTime", 306, 2), new d("Artist", Sdk$SDKError.Reason.JSON_PARAMS_ENCODE_ERROR_VALUE, 2), new d("WhitePoint", Sdk$SDKError.Reason.AD_CLOSED_MISSING_HEARTBEAT_VALUE, 5), new d("PrimaryChromaticities", Sdk$SDKError.Reason.SILENT_MODE_MONITOR_ERROR_VALUE, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("SensorTopBorder", 4, 4), new d("SensorLeftBorder", 5, 4), new d("SensorBottomBorder", 6, 4), new d("SensorRightBorder", 7, 4), new d("ISO", 23, 3), new d("JpgFromRaw", 46, 7), new d("Xmp", LogSeverity.ALERT_VALUE, 1)};
        Y = dVarArr;
        d[] dVarArr2 = {new d("ExposureTime", 33434, 5), new d("FNumber", 33437, 5), new d("ExposureProgram", 34850, 3), new d("SpectralSensitivity", 34852, 2), new d("PhotographicSensitivity", 34855, 3), new d("OECF", 34856, 7), new d("SensitivityType", 34864, 3), new d("StandardOutputSensitivity", 34865, 4), new d("RecommendedExposureIndex", 34866, 4), new d("ISOSpeed", 34867, 4), new d("ISOSpeedLatitudeyyy", 34868, 4), new d("ISOSpeedLatitudezzz", 34869, 4), new d("ExifVersion", 36864, 2), new d("DateTimeOriginal", 36867, 2), new d("DateTimeDigitized", 36868, 2), new d("OffsetTime", 36880, 2), new d("OffsetTimeOriginal", 36881, 2), new d("OffsetTimeDigitized", 36882, 2), new d("ComponentsConfiguration", 37121, 7), new d("CompressedBitsPerPixel", 37122, 5), new d("ShutterSpeedValue", 37377, 10), new d("ApertureValue", 37378, 5), new d("BrightnessValue", 37379, 10), new d("ExposureBiasValue", 37380, 10), new d("MaxApertureValue", 37381, 5), new d("SubjectDistance", 37382, 5), new d("MeteringMode", 37383, 3), new d("LightSource", 37384, 3), new d("Flash", 37385, 3), new d("FocalLength", 37386, 5), new d("SubjectArea", 37396, 3), new d("MakerNote", 37500, 7), new d("UserComment", 37510, 7), new d("SubSecTime", 37520, 2), new d("SubSecTimeOriginal", 37521, 2), new d("SubSecTimeDigitized", 37522, 2), new d("FlashpixVersion", UnixStat.LINK_FLAG, 7), new d("ColorSpace", 40961, 3), new d("PixelXDimension", 40962, 3, 4), new d("PixelYDimension", 40963, 3, 4), new d("RelatedSoundFile", 40964, 2), new d("InteroperabilityIFDPointer", 40965, 4), new d("FlashEnergy", 41483, 5), new d("SpatialFrequencyResponse", 41484, 7), new d("FocalPlaneXResolution", 41486, 5), new d("FocalPlaneYResolution", 41487, 5), new d("FocalPlaneResolutionUnit", 41488, 3), new d("SubjectLocation", 41492, 3), new d("ExposureIndex", 41493, 5), new d("SensingMethod", 41495, 3), new d("FileSource", 41728, 7), new d("SceneType", 41729, 7), new d("CFAPattern", 41730, 7), new d("CustomRendered", 41985, 3), new d("ExposureMode", 41986, 3), new d("WhiteBalance", 41987, 3), new d("DigitalZoomRatio", 41988, 5), new d("FocalLengthIn35mmFilm", 41989, 3), new d("SceneCaptureType", 41990, 3), new d("GainControl", 41991, 3), new d("Contrast", 41992, 3), new d("Saturation", 41993, 3), new d("Sharpness", 41994, 3), new d("DeviceSettingDescription", 41995, 7), new d("SubjectDistanceRange", 41996, 3), new d("ImageUniqueID", 42016, 2), new d("CameraOwnerName", 42032, 2), new d("BodySerialNumber", 42033, 2), new d("LensSpecification", 42034, 5), new d("LensMake", 42035, 2), new d("LensModel", 42036, 2), new d("Gamma", 42240, 5), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        Z = dVarArr2;
        d[] dVarArr3 = {new d("GPSVersionID", 0, 1), new d("GPSLatitudeRef", 1, 2), new d("GPSLatitude", 2, 5, 10), new d("GPSLongitudeRef", 3, 2), new d("GPSLongitude", 4, 5, 10), new d("GPSAltitudeRef", 5, 1), new d("GPSAltitude", 6, 5), new d("GPSTimeStamp", 7, 5), new d("GPSSatellites", 8, 2), new d("GPSStatus", 9, 2), new d("GPSMeasureMode", 10, 2), new d("GPSDOP", 11, 5), new d("GPSSpeedRef", 12, 2), new d("GPSSpeed", 13, 5), new d("GPSTrackRef", 14, 2), new d("GPSTrack", 15, 5), new d("GPSImgDirectionRef", 16, 2), new d("GPSImgDirection", 17, 5), new d("GPSMapDatum", 18, 2), new d("GPSDestLatitudeRef", 19, 2), new d("GPSDestLatitude", 20, 5), new d("GPSDestLongitudeRef", 21, 2), new d("GPSDestLongitude", 22, 5), new d("GPSDestBearingRef", 23, 2), new d("GPSDestBearing", 24, 5), new d("GPSDestDistanceRef", 25, 2), new d("GPSDestDistance", 26, 5), new d("GPSProcessingMethod", 27, 7), new d("GPSAreaInformation", 28, 7), new d("GPSDateStamp", 29, 2), new d("GPSDifferential", 30, 3), new d("GPSHPositioningError", 31, 5)};
        f9230a0 = dVarArr3;
        d[] dVarArr4 = {new d("InteroperabilityIndex", 1, 2)};
        f9231b0 = dVarArr4;
        d[] dVarArr5 = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ThumbnailImageWidth", 256, 3, 4), new d("ThumbnailImageLength", InputDeviceCompat.SOURCE_KEYBOARD, 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("ThumbnailOrientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", Sdk$SDKError.Reason.MRAID_ERROR_VALUE, 3), new d("Software", Sdk$SDKError.Reason.MRAID_BRIDGE_ERROR_VALUE, 2), new d("DateTime", 306, 2), new d("Artist", Sdk$SDKError.Reason.JSON_PARAMS_ENCODE_ERROR_VALUE, 2), new d("WhitePoint", Sdk$SDKError.Reason.AD_CLOSED_MISSING_HEARTBEAT_VALUE, 5), new d("PrimaryChromaticities", Sdk$SDKError.Reason.SILENT_MODE_MONITOR_ERROR_VALUE, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        f9232c0 = dVarArr5;
        f9233d0 = new d("StripOffsets", 273, 3);
        d[] dVarArr6 = {new d("ThumbnailImage", 256, 7), new d("CameraSettingsIFDPointer", 8224, 4), new d("ImageProcessingIFDPointer", 8256, 4)};
        f9234e0 = dVarArr6;
        d[] dVarArr7 = {new d("PreviewImageStart", InputDeviceCompat.SOURCE_KEYBOARD, 4), new d("PreviewImageLength", 258, 4)};
        f9235f0 = dVarArr7;
        d[] dVarArr8 = {new d("AspectFrame", 4371, 3)};
        f9236g0 = dVarArr8;
        d[] dVarArr9 = {new d("ColorSpace", 55, 3)};
        f9237h0 = dVarArr9;
        d[][] dVarArr10 = {dVarArr, dVarArr2, dVarArr3, dVarArr4, dVarArr5, dVarArr, dVarArr6, dVarArr7, dVarArr8, dVarArr9};
        f9238i0 = dVarArr10;
        f9239j0 = new d[]{new d("SubIFDPointer", 330, 4), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("InteroperabilityIFDPointer", 40965, 4), new d("CameraSettingsIFDPointer", 8224, 1), new d("ImageProcessingIFDPointer", 8256, 1)};
        f9240k0 = new HashMap[dVarArr10.length];
        f9241l0 = new HashMap[dVarArr10.length];
        f9242m0 = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f9243n0 = new HashMap();
        Charset forName = Charset.forName(C.ASCII_NAME);
        f9244o0 = forName;
        f9245p0 = "Exif\u0000\u0000".getBytes(forName);
        f9246q0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        T = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        U = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i11 = 0;
        while (true) {
            d[][] dVarArr11 = f9238i0;
            if (i11 >= dVarArr11.length) {
                HashMap hashMap = f9243n0;
                d[] dVarArr12 = f9239j0;
                hashMap.put(Integer.valueOf(dVarArr12[0].f9290a), 5);
                hashMap.put(Integer.valueOf(dVarArr12[1].f9290a), 1);
                hashMap.put(Integer.valueOf(dVarArr12[2].f9290a), 2);
                hashMap.put(Integer.valueOf(dVarArr12[3].f9290a), 3);
                hashMap.put(Integer.valueOf(dVarArr12[4].f9290a), 7);
                hashMap.put(Integer.valueOf(dVarArr12[5].f9290a), 8);
                f9247r0 = Pattern.compile(".*[1-9].*");
                f9248s0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                f9249t0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                f9251u0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            f9240k0[i11] = new HashMap();
            f9241l0[i11] = new HashMap();
            for (d dVar : dVarArr11[i11]) {
                f9240k0[i11].put(Integer.valueOf(dVar.f9290a), dVar);
                f9241l0[i11].put(dVar.f9291b, dVar);
            }
            i11++;
        }
    }

    public a(InputStream inputStream) {
        this(inputStream, 0);
    }

    public a(InputStream inputStream, int i11) {
        d[][] dVarArr = f9238i0;
        this.f9262f = new HashMap[dVarArr.length];
        this.f9263g = new HashSet(dVarArr.length);
        this.f9264h = ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            throw new NullPointerException("inputStream cannot be null");
        }
        this.f9257a = null;
        if (i11 == 1) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, f9245p0.length);
            if (!r(bufferedInputStream)) {
                Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                return;
            }
            this.f9261e = true;
            this.f9259c = null;
            this.f9258b = null;
            inputStream = bufferedInputStream;
        } else if (inputStream instanceof AssetManager.AssetInputStream) {
            this.f9259c = (AssetManager.AssetInputStream) inputStream;
            this.f9258b = null;
        } else {
            if (inputStream instanceof FileInputStream) {
                FileInputStream fileInputStream = (FileInputStream) inputStream;
                if (y(fileInputStream.getFD())) {
                    this.f9259c = null;
                    this.f9258b = fileInputStream.getFD();
                }
            }
            this.f9259c = null;
            this.f9258b = null;
        }
        C(inputStream);
    }

    private boolean A(HashMap hashMap) {
        c cVar = (c) hashMap.get("ImageLength");
        c cVar2 = (c) hashMap.get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            return false;
        }
        return cVar.i(this.f9264h) <= 512 && cVar2.i(this.f9264h) <= 512;
    }

    private boolean B(byte[] bArr) {
        int i11 = 0;
        while (true) {
            byte[] bArr2 = K;
            if (i11 >= bArr2.length) {
                int i12 = 0;
                while (true) {
                    byte[] bArr3 = L;
                    if (i12 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[K.length + i12 + 4] != bArr3[i12]) {
                        return false;
                    }
                    i12++;
                }
            } else {
                if (bArr[i11] != bArr2[i11]) {
                    return false;
                }
                i11++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x009f A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #0 {all -> 0x0015, blocks: (B:4:0x0004, B:6:0x0009, B:8:0x001e, B:10:0x0022, B:11:0x0030, B:13:0x0038, B:15:0x0041, B:16:0x0061, B:23:0x0045, B:25:0x004b, B:28:0x0052, B:31:0x005a, B:32:0x005e, B:33:0x006b, B:35:0x0075, B:38:0x007d, B:41:0x0085, B:44:0x008d, B:53:0x009b, B:55:0x009f), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void C(java.io.InputStream r5) {
        /*
            r4 = this;
            if (r5 == 0) goto Lb8
            r0 = 0
            r1 = r0
        L4:
            androidx.exifinterface.media.a$d[][] r2 = androidx.exifinterface.media.a.f9238i0     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r2 = r2.length     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r1 >= r2) goto L1e
            java.util.HashMap[] r2 = r4.f9262f     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            java.util.HashMap r3 = new java.util.HashMap     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r3.<init>()     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2[r1] = r3     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r1 = r1 + 1
            goto L4
        L15:
            r5 = move-exception
            goto Lad
        L18:
            r5 = move-exception
            goto L9b
        L1b:
            r5 = move-exception
            goto L9b
        L1e:
            boolean r1 = r4.f9261e     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r1 != 0) goto L30
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2 = 5000(0x1388, float:7.006E-42)
            r1.<init>(r5, r2)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r5 = r4.g(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r4.f9260d = r5     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r5 = r1
        L30:
            int r1 = r4.f9260d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            boolean r1 = L(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r1 == 0) goto L6b
            androidx.exifinterface.media.a$f r0 = new androidx.exifinterface.media.a$f     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            boolean r5 = r4.f9261e     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r5 == 0) goto L45
            r4.n(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L45:
            int r5 = r4.f9260d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r1 = 12
            if (r5 != r1) goto L4f
            r4.e(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L4f:
            r1 = 7
            if (r5 != r1) goto L56
            r4.h(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L56:
            r1 = 10
            if (r5 != r1) goto L5e
            r4.m(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L5e:
            r4.k(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
        L61:
            int r5 = r4.f9272p     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            long r1 = (long) r5     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r0.l(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r4.K(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L6b:
            androidx.exifinterface.media.a$b r1 = new androidx.exifinterface.media.a$b     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r5 = r4.f9260d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2 = 4
            if (r5 != r2) goto L79
            r4.f(r1, r0, r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L79:
            r0 = 13
            if (r5 != r0) goto L81
            r4.i(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L81:
            r0 = 9
            if (r5 != r0) goto L89
            r4.j(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L89:
            r0 = 14
            if (r5 != r0) goto L90
            r4.o(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
        L90:
            r4.a()
            boolean r5 = androidx.exifinterface.media.a.f9250u
            if (r5 == 0) goto Lac
        L97:
            r4.E()
            goto Lac
        L9b:
            boolean r0 = androidx.exifinterface.media.a.f9250u     // Catch: java.lang.Throwable -> L15
            if (r0 == 0) goto La6
            java.lang.String r1 = "ExifInterface"
            java.lang.String r2 = "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface."
            android.util.Log.w(r1, r2, r5)     // Catch: java.lang.Throwable -> L15
        La6:
            r4.a()
            if (r0 == 0) goto Lac
            goto L97
        Lac:
            return
        Lad:
            r4.a()
            boolean r0 = androidx.exifinterface.media.a.f9250u
            if (r0 == 0) goto Lb7
            r4.E()
        Lb7:
            throw r5
        Lb8:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "inputstream shouldn't be null"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.C(java.io.InputStream):void");
    }

    private void D(b bVar) {
        ByteOrder F2 = F(bVar);
        this.f9264h = F2;
        bVar.i(F2);
        int readUnsignedShort = bVar.readUnsignedShort();
        int i11 = this.f9260d;
        if (i11 != 7 && i11 != 10 && readUnsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
        }
        int readInt = bVar.readInt();
        if (readInt < 8) {
            throw new IOException("Invalid first Ifd offset: " + readInt);
        }
        int i12 = readInt - 8;
        if (i12 > 0) {
            bVar.k(i12);
        }
    }

    private void E() {
        for (int i11 = 0; i11 < this.f9262f.length; i11++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The size of tag group[");
            sb2.append(i11);
            sb2.append("]: ");
            sb2.append(this.f9262f[i11].size());
            for (Map.Entry entry : this.f9262f[i11].entrySet()) {
                c cVar = (c) entry.getValue();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("tagName: ");
                sb3.append((String) entry.getKey());
                sb3.append(", tagType: ");
                sb3.append(cVar.toString());
                sb3.append(", tagValue: '");
                sb3.append(cVar.j(this.f9264h));
                sb3.append("'");
            }
        }
    }

    private ByteOrder F(b bVar) {
        short readShort = bVar.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
    }

    private void G(byte[] bArr, int i11) {
        f fVar = new f(bArr);
        D(fVar);
        H(fVar, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void H(androidx.exifinterface.media.a.f r29, int r30) {
        /*
            Method dump skipped, instructions count: 835
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.H(androidx.exifinterface.media.a$f, int):void");
    }

    private void I(int i11, String str, String str2) {
        if (this.f9262f[i11].isEmpty() || this.f9262f[i11].get(str) == null) {
            return;
        }
        HashMap hashMap = this.f9262f[i11];
        hashMap.put(str2, hashMap.get(str));
        this.f9262f[i11].remove(str);
    }

    private void J(f fVar, int i11) {
        c cVar = (c) this.f9262f[i11].get("ImageLength");
        c cVar2 = (c) this.f9262f[i11].get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            c cVar3 = (c) this.f9262f[i11].get("JPEGInterchangeFormat");
            c cVar4 = (c) this.f9262f[i11].get("JPEGInterchangeFormatLength");
            if (cVar3 == null || cVar4 == null) {
                return;
            }
            int i12 = cVar3.i(this.f9264h);
            int i13 = cVar3.i(this.f9264h);
            fVar.l(i12);
            byte[] bArr = new byte[i13];
            fVar.read(bArr);
            f(new b(bArr), i12, i11);
        }
    }

    private void K(b bVar) {
        HashMap hashMap = this.f9262f[4];
        c cVar = (c) hashMap.get("Compression");
        if (cVar == null) {
            this.f9271o = 6;
            p(bVar, hashMap);
            return;
        }
        int i11 = cVar.i(this.f9264h);
        this.f9271o = i11;
        if (i11 != 1) {
            if (i11 == 6) {
                p(bVar, hashMap);
                return;
            } else if (i11 != 7) {
                return;
            }
        }
        if (z(hashMap)) {
            q(bVar, hashMap);
        }
    }

    private static boolean L(int i11) {
        return (i11 == 4 || i11 == 9 || i11 == 13 || i11 == 14) ? false : true;
    }

    private void M(int i11, int i12) {
        if (this.f9262f[i11].isEmpty() || this.f9262f[i12].isEmpty()) {
            return;
        }
        c cVar = (c) this.f9262f[i11].get("ImageLength");
        c cVar2 = (c) this.f9262f[i11].get("ImageWidth");
        c cVar3 = (c) this.f9262f[i12].get("ImageLength");
        c cVar4 = (c) this.f9262f[i12].get("ImageWidth");
        if (cVar == null || cVar2 == null || cVar3 == null || cVar4 == null) {
            return;
        }
        int i13 = cVar.i(this.f9264h);
        int i14 = cVar2.i(this.f9264h);
        int i15 = cVar3.i(this.f9264h);
        int i16 = cVar4.i(this.f9264h);
        if (i13 >= i15 || i14 >= i16) {
            return;
        }
        HashMap[] hashMapArr = this.f9262f;
        HashMap hashMap = hashMapArr[i11];
        hashMapArr[i11] = hashMapArr[i12];
        hashMapArr[i12] = hashMap;
    }

    private void N(f fVar, int i11) {
        c f11;
        c f12;
        c cVar = (c) this.f9262f[i11].get("DefaultCropSize");
        c cVar2 = (c) this.f9262f[i11].get("SensorTopBorder");
        c cVar3 = (c) this.f9262f[i11].get("SensorLeftBorder");
        c cVar4 = (c) this.f9262f[i11].get("SensorBottomBorder");
        c cVar5 = (c) this.f9262f[i11].get("SensorRightBorder");
        if (cVar == null) {
            if (cVar2 == null || cVar3 == null || cVar4 == null || cVar5 == null) {
                J(fVar, i11);
                return;
            }
            int i12 = cVar2.i(this.f9264h);
            int i13 = cVar4.i(this.f9264h);
            int i14 = cVar5.i(this.f9264h);
            int i15 = cVar3.i(this.f9264h);
            if (i13 <= i12 || i14 <= i15) {
                return;
            }
            c f13 = c.f(i13 - i12, this.f9264h);
            c f14 = c.f(i14 - i15, this.f9264h);
            this.f9262f[i11].put("ImageLength", f13);
            this.f9262f[i11].put("ImageWidth", f14);
            return;
        }
        if (cVar.f9286a == 5) {
            e[] eVarArr = (e[]) cVar.k(this.f9264h);
            if (eVarArr == null || eVarArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(eVarArr));
                return;
            }
            f11 = c.d(eVarArr[0], this.f9264h);
            f12 = c.d(eVarArr[1], this.f9264h);
        } else {
            int[] iArr = (int[]) cVar.k(this.f9264h);
            if (iArr == null || iArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                return;
            }
            f11 = c.f(iArr[0], this.f9264h);
            f12 = c.f(iArr[1], this.f9264h);
        }
        this.f9262f[i11].put("ImageWidth", f11);
        this.f9262f[i11].put("ImageLength", f12);
    }

    private void O() {
        M(0, 5);
        M(0, 4);
        M(5, 4);
        c cVar = (c) this.f9262f[1].get("PixelXDimension");
        c cVar2 = (c) this.f9262f[1].get("PixelYDimension");
        if (cVar != null && cVar2 != null) {
            this.f9262f[0].put("ImageWidth", cVar);
            this.f9262f[0].put("ImageLength", cVar2);
        }
        if (this.f9262f[4].isEmpty() && A(this.f9262f[5])) {
            HashMap[] hashMapArr = this.f9262f;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap();
        }
        A(this.f9262f[4]);
        I(0, "ThumbnailOrientation", "Orientation");
        I(0, "ThumbnailImageLength", "ImageLength");
        I(0, "ThumbnailImageWidth", "ImageWidth");
        I(5, "ThumbnailOrientation", "Orientation");
        I(5, "ThumbnailImageLength", "ImageLength");
        I(5, "ThumbnailImageWidth", "ImageWidth");
        I(4, "Orientation", "ThumbnailOrientation");
        I(4, "ImageLength", "ThumbnailImageLength");
        I(4, "ImageWidth", "ThumbnailImageWidth");
    }

    private void a() {
        String b11 = b("DateTimeOriginal");
        if (b11 != null && b("DateTime") == null) {
            this.f9262f[0].put("DateTime", c.a(b11));
        }
        if (b("ImageWidth") == null) {
            this.f9262f[0].put("ImageWidth", c.b(0L, this.f9264h));
        }
        if (b("ImageLength") == null) {
            this.f9262f[0].put("ImageLength", c.b(0L, this.f9264h));
        }
        if (b("Orientation") == null) {
            this.f9262f[0].put("Orientation", c.b(0L, this.f9264h));
        }
        if (b("LightSource") == null) {
            this.f9262f[1].put("LightSource", c.b(0L, this.f9264h));
        }
    }

    private c d(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i11 = 0; i11 < f9238i0.length; i11++) {
            c cVar = (c) this.f9262f[i11].get(str);
            if (cVar != null) {
                return cVar;
            }
        }
        return null;
    }

    private void e(f fVar) {
        String str;
        String str2;
        String str3;
        if (Build.VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                b.C0089b.a(mediaMetadataRetriever, new C0088a(fVar));
                String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
                String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(extractMetadata3)) {
                    str = mediaMetadataRetriever.extractMetadata(29);
                    str2 = mediaMetadataRetriever.extractMetadata(30);
                    str3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(extractMetadata4)) {
                    str = mediaMetadataRetriever.extractMetadata(18);
                    str2 = mediaMetadataRetriever.extractMetadata(19);
                    str3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    str = null;
                    str2 = null;
                    str3 = null;
                }
                if (str != null) {
                    this.f9262f[0].put("ImageWidth", c.f(Integer.parseInt(str), this.f9264h));
                }
                if (str2 != null) {
                    this.f9262f[0].put("ImageLength", c.f(Integer.parseInt(str2), this.f9264h));
                }
                if (str3 != null) {
                    int parseInt = Integer.parseInt(str3);
                    this.f9262f[0].put("Orientation", c.f(parseInt != 90 ? parseInt != 180 ? parseInt != 270 ? 1 : 8 : 3 : 6, this.f9264h));
                }
                if (extractMetadata != null && extractMetadata2 != null) {
                    int parseInt2 = Integer.parseInt(extractMetadata);
                    int parseInt3 = Integer.parseInt(extractMetadata2);
                    if (parseInt3 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    fVar.l(parseInt2);
                    byte[] bArr = new byte[6];
                    if (fVar.read(bArr) != 6) {
                        throw new IOException("Can't read identifier");
                    }
                    int i11 = parseInt2 + 6;
                    int i12 = parseInt3 - 6;
                    if (!Arrays.equals(bArr, f9245p0)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i12];
                    if (fVar.read(bArr2) != i12) {
                        throw new IOException("Can't read exif");
                    }
                    this.f9272p = i11;
                    G(bArr2, 0);
                }
                if (f9250u) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Heif meta: ");
                    sb2.append(str);
                    sb2.append("x");
                    sb2.append(str2);
                    sb2.append(", rotation ");
                    sb2.append(str3);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (Throwable th2) {
            mediaMetadataRetriever.release();
            throw th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x016d, code lost:
    
        r20.i(r19.f9264h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0172, code lost:
    
        return;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x0099. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:32:0x015b A[LOOP:0: B:9:0x002e->B:32:0x015b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0161 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void f(androidx.exifinterface.media.a.b r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.f(androidx.exifinterface.media.a$b, int, int):void");
    }

    private int g(BufferedInputStream bufferedInputStream) {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (t(bArr)) {
            return 4;
        }
        if (w(bArr)) {
            return 9;
        }
        if (s(bArr)) {
            return 12;
        }
        if (u(bArr)) {
            return 7;
        }
        if (x(bArr)) {
            return 10;
        }
        if (v(bArr)) {
            return 13;
        }
        return B(bArr) ? 14 : 0;
    }

    private void h(f fVar) {
        int i11;
        int i12;
        k(fVar);
        c cVar = (c) this.f9262f[1].get("MakerNote");
        if (cVar != null) {
            f fVar2 = new f(cVar.f9289d);
            fVar2.i(this.f9264h);
            byte[] bArr = E;
            byte[] bArr2 = new byte[bArr.length];
            fVar2.readFully(bArr2);
            fVar2.l(0L);
            byte[] bArr3 = F;
            byte[] bArr4 = new byte[bArr3.length];
            fVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                fVar2.l(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                fVar2.l(12L);
            }
            H(fVar2, 6);
            c cVar2 = (c) this.f9262f[7].get("PreviewImageStart");
            c cVar3 = (c) this.f9262f[7].get("PreviewImageLength");
            if (cVar2 != null && cVar3 != null) {
                this.f9262f[5].put("JPEGInterchangeFormat", cVar2);
                this.f9262f[5].put("JPEGInterchangeFormatLength", cVar3);
            }
            c cVar4 = (c) this.f9262f[8].get("AspectFrame");
            if (cVar4 != null) {
                int[] iArr = (int[]) cVar4.k(this.f9264h);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i13 = iArr[2];
                int i14 = iArr[0];
                if (i13 <= i14 || (i11 = iArr[3]) <= (i12 = iArr[1])) {
                    return;
                }
                int i15 = (i13 - i14) + 1;
                int i16 = (i11 - i12) + 1;
                if (i15 < i16) {
                    int i17 = i15 + i16;
                    i16 = i17 - i16;
                    i15 = i17 - i16;
                }
                c f11 = c.f(i15, this.f9264h);
                c f12 = c.f(i16, this.f9264h);
                this.f9262f[0].put("ImageWidth", f11);
                this.f9262f[0].put("ImageLength", f12);
            }
        }
    }

    private void i(b bVar) {
        if (f9250u) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getPngAttributes starting with: ");
            sb2.append(bVar);
        }
        bVar.i(ByteOrder.BIG_ENDIAN);
        byte[] bArr = G;
        bVar.k(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int readInt = bVar.readInt();
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i11 = length + 8;
                if (i11 == 16 && !Arrays.equals(bArr2, I)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, J)) {
                    return;
                }
                if (Arrays.equals(bArr2, H)) {
                    byte[] bArr3 = new byte[readInt];
                    if (bVar.read(bArr3) != readInt) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + androidx.exifinterface.media.b.a(bArr2));
                    }
                    int readInt2 = bVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == readInt2) {
                        this.f9272p = i11;
                        G(bArr3, 0);
                        O();
                        K(new b(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                }
                int i12 = readInt + 4;
                bVar.k(i12);
                length = i11 + i12;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void j(b bVar) {
        boolean z10 = f9250u;
        if (z10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getRafAttributes starting with: ");
            sb2.append(bVar);
        }
        bVar.k(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i11 = ByteBuffer.wrap(bArr).getInt();
        int i12 = ByteBuffer.wrap(bArr2).getInt();
        int i13 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i12];
        bVar.k(i11 - bVar.d());
        bVar.read(bArr4);
        f(new b(bArr4), i11, 5);
        bVar.k(i13 - bVar.d());
        bVar.i(ByteOrder.BIG_ENDIAN);
        int readInt = bVar.readInt();
        if (z10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("numberOfDirectoryEntry: ");
            sb3.append(readInt);
        }
        for (int i14 = 0; i14 < readInt; i14++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == f9233d0.f9290a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                c f11 = c.f(readShort, this.f9264h);
                c f12 = c.f(readShort2, this.f9264h);
                this.f9262f[0].put("ImageLength", f11);
                this.f9262f[0].put("ImageWidth", f12);
                if (f9250u) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Updated to length: ");
                    sb4.append((int) readShort);
                    sb4.append(", width: ");
                    sb4.append((int) readShort2);
                    return;
                }
                return;
            }
            bVar.k(readUnsignedShort2);
        }
    }

    private void k(f fVar) {
        c cVar;
        D(fVar);
        H(fVar, 0);
        N(fVar, 0);
        N(fVar, 5);
        N(fVar, 4);
        O();
        if (this.f9260d != 8 || (cVar = (c) this.f9262f[1].get("MakerNote")) == null) {
            return;
        }
        f fVar2 = new f(cVar.f9289d);
        fVar2.i(this.f9264h);
        fVar2.k(6);
        H(fVar2, 9);
        c cVar2 = (c) this.f9262f[9].get("ColorSpace");
        if (cVar2 != null) {
            this.f9262f[1].put("ColorSpace", cVar2);
        }
    }

    private void m(f fVar) {
        if (f9250u) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getRw2Attributes starting with: ");
            sb2.append(fVar);
        }
        k(fVar);
        c cVar = (c) this.f9262f[0].get("JpgFromRaw");
        if (cVar != null) {
            f(new b(cVar.f9289d), (int) cVar.f9288c, 5);
        }
        c cVar2 = (c) this.f9262f[0].get("ISO");
        c cVar3 = (c) this.f9262f[1].get("PhotographicSensitivity");
        if (cVar2 == null || cVar3 != null) {
            return;
        }
        this.f9262f[1].put("PhotographicSensitivity", cVar2);
    }

    private void n(f fVar) {
        byte[] bArr = f9245p0;
        fVar.k(bArr.length);
        byte[] bArr2 = new byte[fVar.available()];
        fVar.readFully(bArr2);
        this.f9272p = bArr.length;
        G(bArr2, 0);
    }

    private void o(b bVar) {
        if (f9250u) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getWebpAttributes starting with: ");
            sb2.append(bVar);
        }
        bVar.i(ByteOrder.LITTLE_ENDIAN);
        bVar.k(K.length);
        int readInt = bVar.readInt() + 8;
        byte[] bArr = L;
        bVar.k(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int readInt2 = bVar.readInt();
                int i11 = length + 8;
                if (Arrays.equals(M, bArr2)) {
                    byte[] bArr3 = new byte[readInt2];
                    if (bVar.read(bArr3) == readInt2) {
                        this.f9272p = i11;
                        G(bArr3, 0);
                        K(new b(bArr3));
                        return;
                    } else {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + androidx.exifinterface.media.b.a(bArr2));
                    }
                }
                if (readInt2 % 2 == 1) {
                    readInt2++;
                }
                length = i11 + readInt2;
                if (length == readInt) {
                    return;
                }
                if (length > readInt) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                bVar.k(readInt2);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    private void p(b bVar, HashMap hashMap) {
        c cVar = (c) hashMap.get("JPEGInterchangeFormat");
        c cVar2 = (c) hashMap.get("JPEGInterchangeFormatLength");
        if (cVar == null || cVar2 == null) {
            return;
        }
        int i11 = cVar.i(this.f9264h);
        int i12 = cVar2.i(this.f9264h);
        if (this.f9260d == 7) {
            i11 += this.f9273q;
        }
        if (i11 > 0 && i12 > 0) {
            this.f9265i = true;
            if (this.f9257a == null && this.f9259c == null && this.f9258b == null) {
                byte[] bArr = new byte[i12];
                bVar.skip(i11);
                bVar.read(bArr);
                this.f9270n = bArr;
            }
            this.f9268l = i11;
            this.f9269m = i12;
        }
        if (f9250u) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Setting thumbnail attributes with offset: ");
            sb2.append(i11);
            sb2.append(", length: ");
            sb2.append(i12);
        }
    }

    private void q(b bVar, HashMap hashMap) {
        c cVar = (c) hashMap.get("StripOffsets");
        c cVar2 = (c) hashMap.get("StripByteCounts");
        if (cVar == null || cVar2 == null) {
            return;
        }
        long[] b11 = androidx.exifinterface.media.b.b(cVar.k(this.f9264h));
        long[] b12 = androidx.exifinterface.media.b.b(cVar2.k(this.f9264h));
        if (b11 == null || b11.length == 0) {
            Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
            return;
        }
        if (b12 == null || b12.length == 0) {
            Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
            return;
        }
        if (b11.length != b12.length) {
            Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
            return;
        }
        long j11 = 0;
        for (long j12 : b12) {
            j11 += j12;
        }
        int i11 = (int) j11;
        byte[] bArr = new byte[i11];
        this.f9267k = true;
        this.f9266j = true;
        this.f9265i = true;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < b11.length; i14++) {
            int i15 = (int) b11[i14];
            int i16 = (int) b12[i14];
            if (i14 < b11.length - 1 && i15 + i16 != b11[i14 + 1]) {
                this.f9267k = false;
            }
            int i17 = i15 - i12;
            if (i17 < 0) {
                return;
            }
            long j13 = i17;
            if (bVar.skip(j13) != j13) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to skip ");
                sb2.append(i17);
                sb2.append(" bytes.");
                return;
            }
            int i18 = i12 + i17;
            byte[] bArr2 = new byte[i16];
            if (bVar.read(bArr2) != i16) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Failed to read ");
                sb3.append(i16);
                sb3.append(" bytes.");
                return;
            }
            i12 = i18 + i16;
            System.arraycopy(bArr2, 0, bArr, i13, i16);
            i13 += i16;
        }
        this.f9270n = bArr;
        if (this.f9267k) {
            this.f9268l = (int) b11[0];
            this.f9269m = i11;
        }
    }

    private static boolean r(BufferedInputStream bufferedInputStream) {
        byte[] bArr = f9245p0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i11 = 0;
        while (true) {
            byte[] bArr3 = f9245p0;
            if (i11 >= bArr3.length) {
                return true;
            }
            if (bArr2[i11] != bArr3[i11]) {
                return false;
            }
            i11++;
        }
    }

    private boolean s(byte[] bArr) {
        b bVar;
        long readInt;
        byte[] bArr2;
        long j11;
        b bVar2 = null;
        try {
            bVar = new b(bArr);
            try {
                readInt = bVar.readInt();
                bArr2 = new byte[4];
                bVar.read(bArr2);
            } catch (Exception unused) {
                bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.close();
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            th = th3;
        }
        if (!Arrays.equals(bArr2, B)) {
            bVar.close();
            return false;
        }
        if (readInt == 1) {
            readInt = bVar.readLong();
            j11 = 16;
            if (readInt < 16) {
                bVar.close();
                return false;
            }
        } else {
            j11 = 8;
        }
        if (readInt > bArr.length) {
            readInt = bArr.length;
        }
        long j12 = readInt - j11;
        if (j12 < 8) {
            bVar.close();
            return false;
        }
        byte[] bArr3 = new byte[4];
        boolean z10 = false;
        boolean z11 = false;
        for (long j13 = 0; j13 < j12 / 4; j13++) {
            if (bVar.read(bArr3) != 4) {
                bVar.close();
                return false;
            }
            if (j13 != 1) {
                if (Arrays.equals(bArr3, C)) {
                    z10 = true;
                } else if (Arrays.equals(bArr3, D)) {
                    z11 = true;
                }
                if (z10 && z11) {
                    bVar.close();
                    return true;
                }
            }
        }
        bVar.close();
        return false;
    }

    private static boolean t(byte[] bArr) {
        int i11 = 0;
        while (true) {
            byte[] bArr2 = A;
            if (i11 >= bArr2.length) {
                return true;
            }
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
            i11++;
        }
    }

    private boolean u(byte[] bArr) {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder F2 = F(bVar2);
                this.f9264h = F2;
                bVar2.i(F2);
                short readShort = bVar2.readShort();
                boolean z10 = readShort == 20306 || readShort == 21330;
                bVar2.close();
                return z10;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private boolean v(byte[] bArr) {
        int i11 = 0;
        while (true) {
            byte[] bArr2 = G;
            if (i11 >= bArr2.length) {
                return true;
            }
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
            i11++;
        }
    }

    private boolean w(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i11 = 0; i11 < bytes.length; i11++) {
            if (bArr[i11] != bytes[i11]) {
                return false;
            }
        }
        return true;
    }

    private boolean x(byte[] bArr) {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder F2 = F(bVar2);
                this.f9264h = F2;
                bVar2.i(F2);
                boolean z10 = bVar2.readShort() == 85;
                bVar2.close();
                return z10;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static boolean y(FileDescriptor fileDescriptor) {
        try {
            b.a.c(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean z(HashMap hashMap) {
        c cVar;
        c cVar2 = (c) hashMap.get("BitsPerSample");
        if (cVar2 == null) {
            return false;
        }
        int[] iArr = (int[]) cVar2.k(this.f9264h);
        int[] iArr2 = f9254x;
        if (Arrays.equals(iArr2, iArr)) {
            return true;
        }
        if (this.f9260d != 3 || (cVar = (c) hashMap.get("PhotometricInterpretation")) == null) {
            return false;
        }
        int i11 = cVar.i(this.f9264h);
        return (i11 == 1 && Arrays.equals(iArr, f9256z)) || (i11 == 6 && Arrays.equals(iArr, iArr2));
    }

    public String b(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        c d11 = d(str);
        if (d11 != null) {
            if (!f9242m0.contains(str)) {
                return d11.j(this.f9264h);
            }
            if (str.equals("GPSTimeStamp")) {
                int i11 = d11.f9286a;
                if (i11 != 5 && i11 != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + d11.f9286a);
                    return null;
                }
                e[] eVarArr = (e[]) d11.k(this.f9264h);
                if (eVarArr == null || eVarArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(eVarArr));
                    return null;
                }
                e eVar = eVarArr[0];
                Integer valueOf = Integer.valueOf((int) (((float) eVar.f9294a) / ((float) eVar.f9295b)));
                e eVar2 = eVarArr[1];
                Integer valueOf2 = Integer.valueOf((int) (((float) eVar2.f9294a) / ((float) eVar2.f9295b)));
                e eVar3 = eVarArr[2];
                return String.format("%02d:%02d:%02d", valueOf, valueOf2, Integer.valueOf((int) (((float) eVar3.f9294a) / ((float) eVar3.f9295b))));
            }
            try {
                return Double.toString(d11.h(this.f9264h));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public int c(String str, int i11) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        c d11 = d(str);
        if (d11 == null) {
            return i11;
        }
        try {
            return d11.i(this.f9264h);
        } catch (NumberFormatException unused) {
            return i11;
        }
    }

    public int l() {
        switch (c("Orientation", 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }
}
