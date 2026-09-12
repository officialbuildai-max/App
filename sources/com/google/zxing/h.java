package com.google.zxing;

/* loaded from: classes4.dex */
public final class h extends e {

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f32959c;

    /* renamed from: d, reason: collision with root package name */
    private final int f32960d;

    /* renamed from: e, reason: collision with root package name */
    private final int f32961e;

    /* renamed from: f, reason: collision with root package name */
    private final int f32962f;

    /* renamed from: g, reason: collision with root package name */
    private final int f32963g;

    public h(byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, boolean z10) {
        super(i15, i16);
        if (i13 + i15 > i11 || i14 + i16 > i12) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f32959c = bArr;
        this.f32960d = i11;
        this.f32961e = i12;
        this.f32962f = i13;
        this.f32963g = i14;
        if (z10) {
            h(i15, i16);
        }
    }

    private void h(int i11, int i12) {
        byte[] bArr = this.f32959c;
        int i13 = (this.f32963g * this.f32960d) + this.f32962f;
        int i14 = 0;
        while (i14 < i12) {
            int i15 = (i11 / 2) + i13;
            int i16 = (i13 + i11) - 1;
            int i17 = i13;
            while (i17 < i15) {
                byte b11 = bArr[i17];
                bArr[i17] = bArr[i16];
                bArr[i16] = b11;
                i17++;
                i16--;
            }
            i14++;
            i13 += this.f32960d;
        }
    }

    @Override // com.google.zxing.e
    public byte[] b() {
        int d11 = d();
        int a11 = a();
        int i11 = this.f32960d;
        if (d11 == i11 && a11 == this.f32961e) {
            return this.f32959c;
        }
        int i12 = d11 * a11;
        byte[] bArr = new byte[i12];
        int i13 = (this.f32963g * i11) + this.f32962f;
        if (d11 == i11) {
            System.arraycopy(this.f32959c, i13, bArr, 0, i12);
            return bArr;
        }
        for (int i14 = 0; i14 < a11; i14++) {
            System.arraycopy(this.f32959c, i13, bArr, i14 * d11, d11);
            i13 += this.f32960d;
        }
        return bArr;
    }

    @Override // com.google.zxing.e
    public byte[] c(int i11, byte[] bArr) {
        if (i11 < 0 || i11 >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i11);
        }
        int d11 = d();
        if (bArr == null || bArr.length < d11) {
            bArr = new byte[d11];
        }
        System.arraycopy(this.f32959c, ((i11 + this.f32963g) * this.f32960d) + this.f32962f, bArr, 0, d11);
        return bArr;
    }
}
