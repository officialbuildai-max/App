package org.brotli.dec;

/* loaded from: classes7.dex */
final class h {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f71760a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f71761b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            int[] iArr = hVar.f71761b;
            byte[] bArr = hVar.f71760a;
            int i13 = i12 * 4;
            iArr[i12] = ((bArr[i13 + 3] & 255) << 24) | (bArr[i13] & 255) | ((bArr[i13 + 1] & 255) << 8) | ((bArr[i13 + 2] & 255) << 16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(h hVar, byte[] bArr, int[] iArr) {
        hVar.f71760a = bArr;
        hVar.f71761b = iArr;
    }
}
