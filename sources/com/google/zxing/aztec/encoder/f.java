package com.google.zxing.aztec.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class f {

    /* renamed from: b, reason: collision with root package name */
    static final f f32902b = new d(null, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    private final f f32903a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(f fVar) {
        this.f32903a = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final f a(int i11, int i12) {
        return new d(this, i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final f b(int i11, int i12) {
        return new b(this, i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(id.a aVar, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final f d() {
        return this.f32903a;
    }
}
