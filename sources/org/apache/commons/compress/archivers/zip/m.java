package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.PKWareExtraHeader;

/* loaded from: classes7.dex */
public class m extends PKWareExtraHeader {

    /* renamed from: d, reason: collision with root package name */
    private int f71288d;

    /* renamed from: e, reason: collision with root package name */
    private PKWareExtraHeader.HashAlgorithm f71289e;

    public m() {
        super(new ZipShort(21));
    }

    @Override // org.apache.commons.compress.archivers.zip.PKWareExtraHeader, org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) {
        a(4, i12);
        super.parseFromCentralDirectoryData(bArr, i11, i12);
        this.f71288d = ZipShort.getValue(bArr, i11);
        this.f71289e = PKWareExtraHeader.HashAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i11 + 2));
    }
}
