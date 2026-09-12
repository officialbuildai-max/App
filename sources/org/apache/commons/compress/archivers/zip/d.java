package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

/* loaded from: classes7.dex */
public final class d implements t {

    /* renamed from: a, reason: collision with root package name */
    private static final ZipShort f71261a = new ZipShort(51966);

    /* renamed from: b, reason: collision with root package name */
    private static final ZipShort f71262b = new ZipShort(0);

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f71263c = new byte[0];

    /* renamed from: d, reason: collision with root package name */
    private static final d f71264d = new d();

    @Override // org.apache.commons.compress.archivers.zip.t
    public ZipShort getHeaderId() {
        return f71261a;
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) {
        parseFromLocalFileData(bArr, i11, i12);
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) {
        if (i12 != 0) {
            throw new ZipException("JarMarker doesn't expect any data");
        }
    }
}
