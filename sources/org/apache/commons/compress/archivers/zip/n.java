package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.PKWareExtraHeader;

/* loaded from: classes7.dex */
public class n extends PKWareExtraHeader {

    /* renamed from: d, reason: collision with root package name */
    private int f71290d;

    /* renamed from: e, reason: collision with root package name */
    private PKWareExtraHeader.HashAlgorithm f71291e;

    public n() {
        super(new ZipShort(22));
    }

    @Override // org.apache.commons.compress.archivers.zip.PKWareExtraHeader, org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) {
        a(4, i12);
        this.f71290d = ZipShort.getValue(bArr, i11);
        this.f71291e = PKWareExtraHeader.HashAlgorithm.getAlgorithmByCode(ZipShort.getValue(bArr, i11 + 2));
    }
}
