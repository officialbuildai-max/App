package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.c;

/* loaded from: classes3.dex */
final class j0 implements c.a {

    /* renamed from: a, reason: collision with root package name */
    private final long f26487a;

    public j0(long j11) {
        this.f26487a = j11;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.c.a
    public c a(int i11) {
        i0 i0Var = new i0(this.f26487a);
        i0Var.a(k.a(i11 * 2));
        return i0Var;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.c.a
    public /* synthetic */ c.a b() {
        return b.a(this);
    }
}
