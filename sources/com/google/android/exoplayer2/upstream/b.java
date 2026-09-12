package com.google.android.exoplayer2.upstream;

/* loaded from: classes3.dex */
public interface b {

    /* loaded from: classes3.dex */
    public interface a {
        com.google.android.exoplayer2.upstream.a a();

        a next();
    }

    void a(a aVar);

    com.google.android.exoplayer2.upstream.a allocate();

    void b(com.google.android.exoplayer2.upstream.a aVar);

    int getIndividualAllocationLength();

    void trim();
}
