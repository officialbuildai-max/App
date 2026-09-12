package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.c;
import java.io.IOException;

/* loaded from: classes3.dex */
final class l0 implements c.a {

    /* renamed from: a, reason: collision with root package name */
    private final long f26494a;

    public l0(long j11) {
        this.f26494a = j11;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.c.a
    public c a(int i11) {
        k0 k0Var = new k0(this.f26494a);
        k0 k0Var2 = new k0(this.f26494a);
        try {
            k0Var.a(k.a(0));
            int d11 = k0Var.d();
            boolean z10 = d11 % 2 == 0;
            k0Var2.a(k.a(z10 ? d11 + 1 : d11 - 1));
            if (z10) {
                k0Var.f(k0Var2);
                return k0Var;
            }
            k0Var2.f(k0Var);
            return k0Var2;
        } catch (IOException e11) {
            com.google.android.exoplayer2.upstream.m.a(k0Var);
            com.google.android.exoplayer2.upstream.m.a(k0Var2);
            throw e11;
        }
    }

    @Override // com.google.android.exoplayer2.source.rtsp.c.a
    public c.a b() {
        return new j0(this.f26494a);
    }
}
