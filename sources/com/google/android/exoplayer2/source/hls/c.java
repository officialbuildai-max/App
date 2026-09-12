package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.upstream.k;

/* loaded from: classes3.dex */
public final class c implements f {

    /* renamed from: a, reason: collision with root package name */
    private final k.a f25997a;

    public c(k.a aVar) {
        this.f25997a = aVar;
    }

    @Override // com.google.android.exoplayer2.source.hls.f
    public com.google.android.exoplayer2.upstream.k a(int i11) {
        return this.f25997a.createDataSource();
    }
}
