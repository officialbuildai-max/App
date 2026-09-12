package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

/* loaded from: classes7.dex */
public class f implements t {

    /* renamed from: d, reason: collision with root package name */
    public static final ZipShort f71270d = new ZipShort(41246);

    /* renamed from: a, reason: collision with root package name */
    private short f71271a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f71272b;

    /* renamed from: c, reason: collision with root package name */
    private int f71273c = 0;

    @Override // org.apache.commons.compress.archivers.zip.t
    public ZipShort getHeaderId() {
        return f71270d;
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) {
        if (i12 >= 2) {
            int value = ZipShort.getValue(bArr, i11);
            this.f71271a = (short) (value & 32767);
            this.f71272b = (value & 32768) != 0;
        } else {
            throw new ZipException("Too short content for ResourceAlignmentExtraField (0xa11e): " + i12);
        }
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) {
        parseFromCentralDirectoryData(bArr, i11, i12);
        this.f71273c = i12 - 2;
    }
}
