package xf;

import com.cloud.tmc.kernel.constants.TmcConstants;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.zip.ZipException;

/* loaded from: classes5.dex */
public class h implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    String f78389a;

    /* renamed from: b, reason: collision with root package name */
    String f78390b;

    /* renamed from: c, reason: collision with root package name */
    long f78391c;

    /* renamed from: d, reason: collision with root package name */
    long f78392d;

    /* renamed from: e, reason: collision with root package name */
    long f78393e;

    /* renamed from: f, reason: collision with root package name */
    int f78394f;

    /* renamed from: g, reason: collision with root package name */
    int f78395g;

    /* renamed from: h, reason: collision with root package name */
    int f78396h;

    /* renamed from: i, reason: collision with root package name */
    byte[] f78397i;

    /* renamed from: j, reason: collision with root package name */
    long f78398j;

    /* renamed from: k, reason: collision with root package name */
    long f78399k;

    public h(h hVar) {
        this.f78391c = -1L;
        this.f78392d = -1L;
        this.f78393e = -1L;
        this.f78394f = -1;
        this.f78395g = -1;
        this.f78396h = -1;
        this.f78398j = -1L;
        this.f78399k = -1L;
        this.f78389a = hVar.f78389a;
        this.f78390b = hVar.f78390b;
        this.f78395g = hVar.f78395g;
        this.f78393e = hVar.f78393e;
        this.f78392d = hVar.f78392d;
        this.f78391c = hVar.f78391c;
        this.f78394f = hVar.f78394f;
        this.f78396h = hVar.f78396h;
        this.f78397i = hVar.f78397i;
        this.f78398j = hVar.f78398j;
        this.f78399k = hVar.f78399k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(byte[] bArr, InputStream inputStream, Charset charset, boolean z10) {
        this.f78391c = -1L;
        this.f78392d = -1L;
        this.f78393e = -1L;
        this.f78394f = -1;
        this.f78395g = -1;
        this.f78396h = -1;
        this.f78398j = -1L;
        this.f78399k = -1L;
        g.a(inputStream, bArr, 0, bArr.length);
        c e11 = d.e(bArr, 0, bArr.length, ByteOrder.LITTLE_ENDIAN);
        int a11 = e11.a();
        if (a11 != 33639248) {
            i.o(TmcConstants.ROUTE_UNKNOWN, inputStream.available(), TmcConstants.ROUTE_UNKNOWN, 0L, "Central Directory Entry", a11);
        }
        e11.c(8);
        short b11 = e11.b();
        int i11 = b11 & 65535;
        if ((b11 & 1) != 0) {
            throw new ZipException("Invalid General Purpose Bit Flag: " + i11);
        }
        charset = (b11 & 2048) != 0 ? Charset.forName("UTF-8") : charset;
        this.f78394f = e11.b() & 65535;
        this.f78395g = e11.b() & 65535;
        this.f78396h = e11.b() & 65535;
        this.f78391c = e11.a() & 4294967295L;
        this.f78392d = e11.a() & 4294967295L;
        this.f78393e = e11.a() & 4294967295L;
        int b12 = e11.b() & 65535;
        int b13 = e11.b() & 65535;
        int b14 = 65535 & e11.b();
        e11.c(42);
        this.f78398j = e11.a() & 4294967295L;
        byte[] bArr2 = new byte[b12];
        g.a(inputStream, bArr2, 0, b12);
        if (a(bArr2)) {
            throw new ZipException("Filename contains NUL byte: " + Arrays.toString(bArr2));
        }
        this.f78389a = new String(bArr2, 0, b12, charset);
        if (b13 > 0) {
            byte[] bArr3 = new byte[b13];
            this.f78397i = bArr3;
            g.a(inputStream, bArr3, 0, b13);
        }
        if (b14 > 0) {
            byte[] bArr4 = new byte[b14];
            g.a(inputStream, bArr4, 0, b14);
            this.f78390b = new String(bArr4, 0, b14, charset);
        }
    }

    private static boolean a(byte[] bArr) {
        for (byte b11 : bArr) {
            if (b11 == 0) {
                return true;
            }
        }
        return false;
    }

    public long b() {
        return this.f78392d;
    }

    public long c() {
        return this.f78391c;
    }

    public Object clone() {
        try {
            h hVar = (h) super.clone();
            byte[] bArr = this.f78397i;
            hVar.f78397i = bArr != null ? (byte[]) bArr.clone() : null;
            return hVar;
        } catch (CloneNotSupportedException e11) {
            throw new AssertionError(e11);
        }
    }

    public byte[] e() {
        return this.f78397i;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.f78389a.equals(((h) obj).f78389a);
        }
        return false;
    }

    public int f() {
        return this.f78394f;
    }

    public String g() {
        return this.f78389a;
    }

    public int hashCode() {
        return this.f78389a.hashCode();
    }

    public long i() {
        return this.f78393e;
    }

    public void j(long j11) {
        this.f78392d = j11;
    }

    public void k(long j11) {
        if (j11 >= 0 && j11 <= 4294967295L) {
            this.f78391c = j11;
            return;
        }
        throw new IllegalArgumentException("Bad CRC32: " + j11);
    }

    public void l(int i11) {
        if (i11 == 0 || i11 == 8) {
            this.f78394f = i11;
            return;
        }
        throw new IllegalArgumentException("Bad method: " + i11);
    }

    public void m(long j11) {
        if (j11 >= 0) {
            this.f78393e = j11;
            return;
        }
        throw new IllegalArgumentException("Bad size: " + j11);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("name:" + this.f78389a);
        stringBuffer.append("\ncomment:" + this.f78390b);
        stringBuffer.append("\ntime:" + this.f78395g);
        stringBuffer.append("\nsize:" + this.f78393e);
        stringBuffer.append("\ncompressedSize:" + this.f78392d);
        stringBuffer.append("\ncrc:" + this.f78391c);
        stringBuffer.append("\ncompressionMethod:" + this.f78394f);
        stringBuffer.append("\nmodDate:" + this.f78396h);
        stringBuffer.append("\nextra length:" + this.f78397i.length);
        stringBuffer.append("\nlocalHeaderRelOffset:" + this.f78398j);
        stringBuffer.append("\ndataOffset:" + this.f78399k);
        return stringBuffer.toString();
    }
}
