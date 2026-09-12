package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;

/* loaded from: classes7.dex */
public class j implements t {

    /* renamed from: a, reason: collision with root package name */
    private ZipShort f71279a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f71280b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f71281c;

    public void a(byte[] bArr) {
        this.f71281c = u.c(bArr);
    }

    public void b(ZipShort zipShort) {
        this.f71279a = zipShort;
    }

    public void c(byte[] bArr) {
        this.f71280b = u.c(bArr);
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public ZipShort getHeaderId() {
        return this.f71279a;
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) {
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i11, i12 + i11);
        a(copyOfRange);
        if (this.f71280b == null) {
            c(copyOfRange);
        }
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) {
        c(Arrays.copyOfRange(bArr, i11, i12 + i11));
    }
}
