package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public class MD5DigestCalculatingInputStream extends SdkFilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private MessageDigest f18713a;

    /* renamed from: b, reason: collision with root package name */
    private MessageDigest f18714b;

    public MD5DigestCalculatingInputStream(InputStream inputStream) {
        super(inputStream);
        this.f18713a = n();
    }

    private MessageDigest l(MessageDigest messageDigest) {
        try {
            return (MessageDigest) messageDigest.clone();
        } catch (CloneNotSupportedException e11) {
            throw new IllegalStateException("unexpected", e11);
        }
    }

    private MessageDigest n() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e11) {
            throw new IllegalStateException("unexpected", e11);
        }
    }

    public byte[] m() {
        return this.f18713a.digest();
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void mark(int i11) {
        if (markSupported()) {
            super.mark(i11);
            this.f18714b = l(this.f18713a);
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = super.read();
        if (read != -1) {
            this.f18713a.update((byte) read);
        }
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) {
        int read = super.read(bArr, i11, i12);
        if (read != -1) {
            this.f18713a.update(bArr, i11, read);
        }
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        if (!markSupported()) {
            throw new IOException("mark/reset not supported");
        }
        super.reset();
        MessageDigest messageDigest = this.f18714b;
        this.f18713a = messageDigest == null ? n() : l(messageDigest);
    }
}
