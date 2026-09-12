package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

/* loaded from: classes7.dex */
public abstract class a implements t {

    /* renamed from: a, reason: collision with root package name */
    private long f71246a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f71247b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f71248c;

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) {
        parseFromLocalFileData(bArr, i11, i12);
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) {
        if (i12 < 5) {
            throw new ZipException("UniCode path extra data must have at least 5 bytes.");
        }
        byte b11 = bArr[i11];
        if (b11 != 1) {
            throw new ZipException("Unsupported version [" + ((int) b11) + "] for UniCode path extra data.");
        }
        this.f71246a = ZipLong.getValue(bArr, i11 + 1);
        int i13 = i12 - 5;
        byte[] bArr2 = new byte[i13];
        this.f71247b = bArr2;
        System.arraycopy(bArr, i11 + 5, bArr2, 0, i13);
        this.f71248c = null;
    }
}
