package wd;

/* loaded from: classes5.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f77766a;

    /* renamed from: b, reason: collision with root package name */
    private int f77767b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i11) {
        this.f77766a = new byte[i11];
    }

    private void c(int i11, boolean z10) {
        this.f77766a[i11] = z10 ? (byte) 1 : (byte) 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = this.f77767b;
            this.f77767b = i13 + 1;
            c(i13, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] b(int i11) {
        int length = this.f77766a.length * i11;
        byte[] bArr = new byte[length];
        for (int i12 = 0; i12 < length; i12++) {
            bArr[i12] = this.f77766a[i12 / i11];
        }
        return bArr;
    }
}
