package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;

/* loaded from: classes7.dex */
public final class i implements t {

    /* renamed from: c, reason: collision with root package name */
    private static final ZipShort f71276c = new ZipShort(44225);

    /* renamed from: a, reason: collision with root package name */
    private byte[] f71277a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f71278b;

    @Override // org.apache.commons.compress.archivers.zip.t
    public ZipShort getHeaderId() {
        return f71276c;
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) {
        this.f71278b = Arrays.copyOfRange(bArr, i11, i11 + i12);
        if (this.f71277a == null) {
            parseFromLocalFileData(bArr, i11, i12);
        }
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) {
        this.f71277a = Arrays.copyOfRange(bArr, i11, i12 + i11);
    }
}
