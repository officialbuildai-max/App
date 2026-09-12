package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.internal.SdkDigestInputStream;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class DigestValidationInputStream extends SdkDigestInputStream {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f18706a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f18707b;

    public DigestValidationInputStream(InputStream inputStream, MessageDigest messageDigest, byte[] bArr) {
        super(inputStream, messageDigest);
        this.f18707b = false;
        this.f18706a = bArr;
    }

    private void h() {
        if (this.f18706a == null || this.f18707b) {
            return;
        }
        this.f18707b = true;
        if (!Arrays.equals(((DigestInputStream) this).digest.digest(), this.f18706a)) {
            throw new AmazonClientException("Unable to verify integrity of data download.  Client calculated content hash didn't match hash calculated by Amazon S3.  The data may be corrupt.");
        }
    }

    @Override // java.security.DigestInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = super.read();
        if (read == -1) {
            h();
        }
        return read;
    }

    @Override // java.security.DigestInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) {
        int read = super.read(bArr, i11, i12);
        if (read == -1) {
            h();
        }
        return read;
    }
}
