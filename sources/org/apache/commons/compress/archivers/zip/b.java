package org.apache.commons.compress.archivers.zip;

import java.util.zip.CRC32;
import java.util.zip.ZipException;
import org.apache.tools.zip.UnixStat;

/* loaded from: classes7.dex */
public class b implements t, Cloneable {

    /* renamed from: g, reason: collision with root package name */
    private static final ZipShort f71249g = new ZipShort(30062);

    /* renamed from: a, reason: collision with root package name */
    private int f71250a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f71251b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f71252c = 0;

    /* renamed from: d, reason: collision with root package name */
    private String f71253d = "";

    /* renamed from: e, reason: collision with root package name */
    private boolean f71254e = false;

    /* renamed from: f, reason: collision with root package name */
    private CRC32 f71255f = new CRC32();

    public String a() {
        return this.f71253d;
    }

    protected int b(int i11) {
        return (i11 & UnixStat.PERM_MASK) | (e() ? UnixStat.LINK_FLAG : c() ? 16384 : 32768);
    }

    public boolean c() {
        return this.f71254e && !e();
    }

    public Object clone() {
        try {
            b bVar = (b) super.clone();
            bVar.f71255f = new CRC32();
            return bVar;
        } catch (CloneNotSupportedException e11) {
            throw new RuntimeException(e11);
        }
    }

    public boolean e() {
        return a().length() != 0;
    }

    public void f(boolean z10) {
        this.f71254e = z10;
        this.f71250a = b(this.f71250a);
    }

    public void g(int i11) {
        this.f71250a = b(i11);
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public ZipShort getHeaderId() {
        return f71249g;
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) {
        parseFromLocalFileData(bArr, i11, i12);
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) {
        long value = ZipLong.getValue(bArr, i11);
        int i13 = i12 - 4;
        byte[] bArr2 = new byte[i13];
        System.arraycopy(bArr, i11 + 4, bArr2, 0, i13);
        this.f71255f.reset();
        this.f71255f.update(bArr2);
        long value2 = this.f71255f.getValue();
        if (value != value2) {
            throw new ZipException("Bad CRC checksum, expected " + Long.toHexString(value) + " instead of " + Long.toHexString(value2));
        }
        int value3 = ZipShort.getValue(bArr2, 0);
        int value4 = (int) ZipLong.getValue(bArr2, 2);
        byte[] bArr3 = new byte[value4];
        this.f71251b = ZipShort.getValue(bArr2, 6);
        this.f71252c = ZipShort.getValue(bArr2, 8);
        if (value4 == 0) {
            this.f71253d = "";
        } else {
            if (value4 > i12 - 14) {
                throw new ZipException("Bad symbolic link name length " + value4 + " in ASI extra field");
            }
            System.arraycopy(bArr2, 10, bArr3, 0, value4);
            this.f71253d = new String(bArr3);
        }
        f((value3 & 16384) != 0);
        g(value3);
    }
}
