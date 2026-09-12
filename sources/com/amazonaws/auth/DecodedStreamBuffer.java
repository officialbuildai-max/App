package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;

/* loaded from: classes2.dex */
class DecodedStreamBuffer {

    /* renamed from: f, reason: collision with root package name */
    private static final Log f18441f = LogFactory.b(DecodedStreamBuffer.class);

    /* renamed from: a, reason: collision with root package name */
    private byte[] f18442a;

    /* renamed from: b, reason: collision with root package name */
    private int f18443b;

    /* renamed from: c, reason: collision with root package name */
    private int f18444c;

    /* renamed from: d, reason: collision with root package name */
    private int f18445d = -1;

    /* renamed from: e, reason: collision with root package name */
    private boolean f18446e;

    public DecodedStreamBuffer(int i11) {
        this.f18442a = new byte[i11];
        this.f18443b = i11;
    }

    public void a(byte[] bArr, int i11, int i12) {
        this.f18445d = -1;
        int i13 = this.f18444c;
        if (i13 + i12 <= this.f18443b) {
            System.arraycopy(bArr, i11, this.f18442a, i13, i12);
            this.f18444c += i12;
            return;
        }
        Log log = f18441f;
        if (log.b()) {
            log.a("Buffer size " + this.f18443b + " has been exceeded and the input stream will not be repeatable. Freeing buffer memory");
        }
        this.f18446e = true;
    }

    public boolean b() {
        int i11 = this.f18445d;
        return i11 != -1 && i11 < this.f18444c;
    }

    public byte c() {
        byte[] bArr = this.f18442a;
        int i11 = this.f18445d;
        this.f18445d = i11 + 1;
        return bArr[i11];
    }

    public void d() {
        if (!this.f18446e) {
            this.f18445d = 0;
            return;
        }
        throw new AmazonClientException("The input stream is not repeatable since the buffer size " + this.f18443b + " has been exceeded.");
    }
}
