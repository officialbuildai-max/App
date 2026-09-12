package com.amazonaws.services.s3.internal.crypto;

@Deprecated
/* loaded from: classes2.dex */
class AesCtr extends ContentCryptoScheme {
    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    int a() {
        return ContentCryptoScheme.f18758b.a();
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    String b() {
        return "AES/CTR/NoPadding";
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    int c() {
        return 16;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    String d() {
        return ContentCryptoScheme.f18758b.d();
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    int e() {
        return ContentCryptoScheme.f18758b.e();
    }
}
