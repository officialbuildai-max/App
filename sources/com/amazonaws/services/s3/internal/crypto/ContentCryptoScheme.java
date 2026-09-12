package com.amazonaws.services.s3.internal.crypto;

/* JADX INFO: Access modifiers changed from: package-private */
@Deprecated
/* loaded from: classes2.dex */
public abstract class ContentCryptoScheme {

    /* renamed from: a, reason: collision with root package name */
    static final ContentCryptoScheme f18757a = new AesCbc();

    /* renamed from: b, reason: collision with root package name */
    static final ContentCryptoScheme f18758b = new AesGcm();

    /* renamed from: c, reason: collision with root package name */
    static final ContentCryptoScheme f18759c = new AesCtr();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String b();

    abstract int c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int e();

    String f() {
        return null;
    }

    int g() {
        return 0;
    }

    public String toString() {
        return "cipherAlgo=" + b() + ", blockSizeInBytes=" + a() + ", ivLengthInBytes=" + c() + ", keyGenAlgo=" + d() + ", keyLengthInBits=" + e() + ", specificProvider=" + f() + ", tagLengthInBits=" + g();
    }
}
