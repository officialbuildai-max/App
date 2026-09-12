package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

/* loaded from: classes7.dex */
public class q implements t {

    /* renamed from: f, reason: collision with root package name */
    static final ZipShort f71305f = new ZipShort(1);

    /* renamed from: g, reason: collision with root package name */
    private static final byte[] f71306g = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    private ZipEightByteInteger f71307a;

    /* renamed from: b, reason: collision with root package name */
    private ZipEightByteInteger f71308b;

    /* renamed from: c, reason: collision with root package name */
    private ZipEightByteInteger f71309c;

    /* renamed from: d, reason: collision with root package name */
    private ZipLong f71310d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f71311e;

    @Override // org.apache.commons.compress.archivers.zip.t
    public ZipShort getHeaderId() {
        return f71305f;
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = new byte[i12];
        this.f71311e = bArr2;
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        if (i12 >= 28) {
            parseFromLocalFileData(bArr, i11, i12);
            return;
        }
        if (i12 == 24) {
            this.f71307a = new ZipEightByteInteger(bArr, i11);
            this.f71308b = new ZipEightByteInteger(bArr, i11 + 8);
            this.f71309c = new ZipEightByteInteger(bArr, i11 + 16);
        } else if (i12 % 8 == 4) {
            this.f71310d = new ZipLong(bArr, (i11 + i12) - 4);
        }
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return;
        }
        if (i12 < 16) {
            throw new ZipException("Zip64 extended information must contain both size values in the local file header.");
        }
        this.f71307a = new ZipEightByteInteger(bArr, i11);
        this.f71308b = new ZipEightByteInteger(bArr, i11 + 8);
        int i13 = i11 + 16;
        int i14 = i12 - 16;
        if (i14 >= 8) {
            this.f71309c = new ZipEightByteInteger(bArr, i13);
            i13 = i11 + 24;
            i14 = i12 - 24;
        }
        if (i14 >= 4) {
            this.f71310d = new ZipLong(bArr, i13);
        }
    }
}
