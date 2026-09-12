package com.google.android.exoplayer2.upstream;

import java.io.InputStream;

/* loaded from: classes3.dex */
public final class l extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private final k f27485a;

    /* renamed from: b, reason: collision with root package name */
    private final n f27486b;

    /* renamed from: f, reason: collision with root package name */
    private long f27490f;

    /* renamed from: d, reason: collision with root package name */
    private boolean f27488d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f27489e = false;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f27487c = new byte[1];

    public l(k kVar, n nVar) {
        this.f27485a = kVar;
        this.f27486b = nVar;
    }

    private void d() {
        if (this.f27488d) {
            return;
        }
        this.f27485a.a(this.f27486b);
        this.f27488d = true;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f27489e) {
            return;
        }
        this.f27485a.close();
        this.f27489e = true;
    }

    public void h() {
        d();
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.f27487c) == -1) {
            return -1;
        }
        return this.f27487c[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) {
        com.google.android.exoplayer2.util.a.g(!this.f27489e);
        d();
        int read = this.f27485a.read(bArr, i11, i12);
        if (read == -1) {
            return -1;
        }
        this.f27490f += read;
        return read;
    }
}
