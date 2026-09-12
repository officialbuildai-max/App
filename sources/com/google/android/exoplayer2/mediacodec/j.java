package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.b;
import com.google.android.exoplayer2.mediacodec.l;
import com.google.android.exoplayer2.mediacodec.u;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.w;

/* loaded from: classes3.dex */
public final class j implements l.b {

    /* renamed from: a, reason: collision with root package name */
    private int f25439a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f25440b;

    @Override // com.google.android.exoplayer2.mediacodec.l.b
    public l a(l.a aVar) {
        int i11;
        int i12 = p0.f27680a;
        if (i12 < 23 || ((i11 = this.f25439a) != 1 && (i11 != 0 || i12 < 31))) {
            return new u.b().a(aVar);
        }
        int l11 = w.l(aVar.f25448c.f25550l);
        com.google.android.exoplayer2.util.s.f("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + p0.m0(l11));
        return new b.C0368b(l11, this.f25440b).a(aVar);
    }
}
