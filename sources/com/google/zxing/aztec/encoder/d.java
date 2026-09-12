package com.google.zxing.aztec.encoder;

/* loaded from: classes4.dex */
final class d extends f {

    /* renamed from: c, reason: collision with root package name */
    private final short f32894c;

    /* renamed from: d, reason: collision with root package name */
    private final short f32895d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(f fVar, int i11, int i12) {
        super(fVar);
        this.f32894c = (short) i11;
        this.f32895d = (short) i12;
    }

    @Override // com.google.zxing.aztec.encoder.f
    void c(id.a aVar, byte[] bArr) {
        aVar.c(this.f32894c, this.f32895d);
    }

    public String toString() {
        short s11 = this.f32894c;
        short s12 = this.f32895d;
        return '<' + Integer.toBinaryString((s11 & ((1 << s12) - 1)) | (1 << s12) | (1 << this.f32895d)).substring(1) + '>';
    }
}
