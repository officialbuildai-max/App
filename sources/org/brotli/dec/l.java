package org.brotli.dec;

/* loaded from: classes7.dex */
abstract class l {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f71800a = new byte[1024];

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f71801b = new int[1024];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte[] bArr, int i11, int i12) {
        int i13 = 0;
        while (i13 < i12) {
            int min = Math.min(i13 + 1024, i12) - i13;
            System.arraycopy(f71800a, 0, bArr, i11 + i13, min);
            i13 += min;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(int[] iArr, int i11, int i12) {
        int i13 = 0;
        while (i13 < i12) {
            int min = Math.min(i13 + 1024, i12) - i13;
            System.arraycopy(f71801b, 0, iArr, i11 + i13, min);
            i13 += min;
        }
    }
}
