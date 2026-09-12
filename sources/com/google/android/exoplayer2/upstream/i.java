package com.google.android.exoplayer2.upstream;

/* loaded from: classes3.dex */
public interface i {

    /* loaded from: classes3.dex */
    public interface a {
        i createDataSink();
    }

    void a(n nVar);

    void close();

    void write(byte[] bArr, int i11, int i12);
}
