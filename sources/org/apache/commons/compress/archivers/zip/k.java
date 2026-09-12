package org.apache.commons.compress.archivers.zip;

import java.util.Date;

/* loaded from: classes7.dex */
public class k implements t {

    /* renamed from: d, reason: collision with root package name */
    private static final ZipShort f71282d = new ZipShort(10);

    /* renamed from: e, reason: collision with root package name */
    private static final ZipShort f71283e = new ZipShort(1);

    /* renamed from: f, reason: collision with root package name */
    private static final ZipShort f71284f = new ZipShort(24);

    /* renamed from: a, reason: collision with root package name */
    private ZipEightByteInteger f71285a;

    /* renamed from: b, reason: collision with root package name */
    private ZipEightByteInteger f71286b;

    /* renamed from: c, reason: collision with root package name */
    private ZipEightByteInteger f71287c;

    public k() {
        ZipEightByteInteger zipEightByteInteger = ZipEightByteInteger.ZERO;
        this.f71285a = zipEightByteInteger;
        this.f71286b = zipEightByteInteger;
        this.f71287c = zipEightByteInteger;
    }

    private void d(byte[] bArr, int i11, int i12) {
        if (i12 >= 26) {
            if (f71284f.equals(new ZipShort(bArr, i11))) {
                this.f71285a = new ZipEightByteInteger(bArr, i11 + 2);
                this.f71286b = new ZipEightByteInteger(bArr, i11 + 10);
                this.f71287c = new ZipEightByteInteger(bArr, i11 + 18);
            }
        }
    }

    private void e() {
        ZipEightByteInteger zipEightByteInteger = ZipEightByteInteger.ZERO;
        this.f71285a = zipEightByteInteger;
        this.f71286b = zipEightByteInteger;
        this.f71287c = zipEightByteInteger;
    }

    private static Date f(ZipEightByteInteger zipEightByteInteger) {
        if (zipEightByteInteger == null || ZipEightByteInteger.ZERO.equals(zipEightByteInteger)) {
            return null;
        }
        return new Date((zipEightByteInteger.getLongValue() - 116444736000000000L) / 10000);
    }

    public Date a() {
        return f(this.f71286b);
    }

    public Date b() {
        return f(this.f71287c);
    }

    public Date c() {
        return f(this.f71285a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        ZipEightByteInteger zipEightByteInteger = this.f71285a;
        ZipEightByteInteger zipEightByteInteger2 = kVar.f71285a;
        if (zipEightByteInteger != zipEightByteInteger2 && (zipEightByteInteger == null || !zipEightByteInteger.equals(zipEightByteInteger2))) {
            return false;
        }
        ZipEightByteInteger zipEightByteInteger3 = this.f71286b;
        ZipEightByteInteger zipEightByteInteger4 = kVar.f71286b;
        if (zipEightByteInteger3 != zipEightByteInteger4 && (zipEightByteInteger3 == null || !zipEightByteInteger3.equals(zipEightByteInteger4))) {
            return false;
        }
        ZipEightByteInteger zipEightByteInteger5 = this.f71287c;
        ZipEightByteInteger zipEightByteInteger6 = kVar.f71287c;
        return zipEightByteInteger5 == zipEightByteInteger6 || (zipEightByteInteger5 != null && zipEightByteInteger5.equals(zipEightByteInteger6));
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public ZipShort getHeaderId() {
        return f71282d;
    }

    public int hashCode() {
        ZipEightByteInteger zipEightByteInteger = this.f71285a;
        int hashCode = zipEightByteInteger != null ? (-123) ^ zipEightByteInteger.hashCode() : -123;
        ZipEightByteInteger zipEightByteInteger2 = this.f71286b;
        if (zipEightByteInteger2 != null) {
            hashCode ^= Integer.rotateLeft(zipEightByteInteger2.hashCode(), 11);
        }
        ZipEightByteInteger zipEightByteInteger3 = this.f71287c;
        return zipEightByteInteger3 != null ? hashCode ^ Integer.rotateLeft(zipEightByteInteger3.hashCode(), 22) : hashCode;
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) {
        e();
        parseFromLocalFileData(bArr, i11, i12);
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) {
        int i13 = i12 + i11;
        int i14 = i11 + 4;
        while (i14 + 4 <= i13) {
            ZipShort zipShort = new ZipShort(bArr, i14);
            int i15 = i14 + 2;
            if (zipShort.equals(f71283e)) {
                d(bArr, i15, i13 - i15);
                return;
            }
            i14 = i15 + new ZipShort(bArr, i15).getValue() + 2;
        }
    }

    public String toString() {
        return "0x000A Zip Extra Field: Modify:[" + c() + "]  Access:[" + a() + "]  Create:[" + b() + "] ";
    }
}
