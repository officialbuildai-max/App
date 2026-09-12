package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.p1;
import t9.s;

/* loaded from: classes3.dex */
final class l implements s {

    /* renamed from: a, reason: collision with root package name */
    private final int f26076a;

    /* renamed from: b, reason: collision with root package name */
    private final p f26077b;

    /* renamed from: c, reason: collision with root package name */
    private int f26078c = -1;

    public l(p pVar, int i11) {
        this.f26077b = pVar;
        this.f26076a = i11;
    }

    private boolean b() {
        int i11 = this.f26078c;
        return (i11 == -1 || i11 == -3 || i11 == -2) ? false : true;
    }

    public void a() {
        com.google.android.exoplayer2.util.a.a(this.f26078c == -1);
        this.f26078c = this.f26077b.i(this.f26076a);
    }

    @Override // t9.s
    public int c(p1 p1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        if (this.f26078c == -3) {
            decoderInputBuffer.a(4);
            return -4;
        }
        if (b()) {
            return this.f26077b.R(this.f26078c, p1Var, decoderInputBuffer, i11);
        }
        return -3;
    }

    public void d() {
        if (this.f26078c != -1) {
            this.f26077b.c0(this.f26076a);
            this.f26078c = -1;
        }
    }

    @Override // t9.s
    public boolean isReady() {
        return this.f26078c == -3 || (b() && this.f26077b.D(this.f26078c));
    }

    @Override // t9.s
    public void maybeThrowError() {
        int i11 = this.f26078c;
        if (i11 == -2) {
            throw new SampleQueueMappingException(this.f26077b.getTrackGroups().b(this.f26076a).c(0).f25550l);
        }
        if (i11 == -1) {
            this.f26077b.H();
        } else if (i11 != -3) {
            this.f26077b.I(i11);
        }
    }

    @Override // t9.s
    public int skipData(long j11) {
        if (b()) {
            return this.f26077b.b0(this.f26078c, j11);
        }
        return 0;
    }
}
