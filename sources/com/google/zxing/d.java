package com.google.zxing;

/* loaded from: classes4.dex */
public final class d extends e {

    /* renamed from: c, reason: collision with root package name */
    private final e f32906c;

    public d(e eVar) {
        super(eVar.d(), eVar.a());
        this.f32906c = eVar;
    }

    @Override // com.google.zxing.e
    public byte[] b() {
        byte[] b11 = this.f32906c.b();
        int d11 = d() * a();
        byte[] bArr = new byte[d11];
        for (int i11 = 0; i11 < d11; i11++) {
            bArr[i11] = (byte) (255 - (b11[i11] & 255));
        }
        return bArr;
    }

    @Override // com.google.zxing.e
    public byte[] c(int i11, byte[] bArr) {
        byte[] c11 = this.f32906c.c(i11, bArr);
        int d11 = d();
        for (int i12 = 0; i12 < d11; i12++) {
            c11[i12] = (byte) (255 - (c11[i12] & 255));
        }
        return c11;
    }

    @Override // com.google.zxing.e
    public e e() {
        return this.f32906c;
    }

    @Override // com.google.zxing.e
    public boolean f() {
        return this.f32906c.f();
    }

    @Override // com.google.zxing.e
    public e g() {
        return new d(this.f32906c.g());
    }
}
