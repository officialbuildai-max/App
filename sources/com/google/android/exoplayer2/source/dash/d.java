package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import t9.s;
import x9.f;

/* loaded from: classes3.dex */
final class d implements s {

    /* renamed from: a, reason: collision with root package name */
    private final o1 f25927a;

    /* renamed from: c, reason: collision with root package name */
    private long[] f25929c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f25930d;

    /* renamed from: e, reason: collision with root package name */
    private f f25931e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f25932f;

    /* renamed from: g, reason: collision with root package name */
    private int f25933g;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.exoplayer2.metadata.emsg.b f25928b = new com.google.android.exoplayer2.metadata.emsg.b();

    /* renamed from: h, reason: collision with root package name */
    private long f25934h = C.TIME_UNSET;

    public d(f fVar, o1 o1Var, boolean z10) {
        this.f25927a = o1Var;
        this.f25931e = fVar;
        this.f25929c = fVar.f78215b;
        d(fVar, z10);
    }

    public String a() {
        return this.f25931e.a();
    }

    public void b(long j11) {
        int e11 = p0.e(this.f25929c, j11, true, false);
        this.f25933g = e11;
        if (!this.f25930d || e11 != this.f25929c.length) {
            j11 = C.TIME_UNSET;
        }
        this.f25934h = j11;
    }

    @Override // t9.s
    public int c(p1 p1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        int i12 = this.f25933g;
        boolean z10 = i12 == this.f25929c.length;
        if (z10 && !this.f25930d) {
            decoderInputBuffer.k(4);
            return -4;
        }
        if ((i11 & 2) != 0 || !this.f25932f) {
            p1Var.f25652b = this.f25927a;
            this.f25932f = true;
            return -5;
        }
        if (z10) {
            return -3;
        }
        if ((i11 & 1) == 0) {
            this.f25933g = i12 + 1;
        }
        if ((i11 & 4) == 0) {
            byte[] a11 = this.f25928b.a(this.f25931e.f78214a[i12]);
            decoderInputBuffer.m(a11.length);
            decoderInputBuffer.f24897c.put(a11);
        }
        decoderInputBuffer.f24899e = this.f25929c[i12];
        decoderInputBuffer.k(1);
        return -4;
    }

    public void d(f fVar, boolean z10) {
        int i11 = this.f25933g;
        long j11 = i11 == 0 ? -9223372036854775807L : this.f25929c[i11 - 1];
        this.f25930d = z10;
        this.f25931e = fVar;
        long[] jArr = fVar.f78215b;
        this.f25929c = jArr;
        long j12 = this.f25934h;
        if (j12 != C.TIME_UNSET) {
            b(j12);
        } else if (j11 != C.TIME_UNSET) {
            this.f25933g = p0.e(jArr, j11, false, false);
        }
    }

    @Override // t9.s
    public boolean isReady() {
        return true;
    }

    @Override // t9.s
    public void maybeThrowError() {
    }

    @Override // t9.s
    public int skipData(long j11) {
        int max = Math.max(this.f25933g, p0.e(this.f25929c, j11, true, false));
        int i11 = max - this.f25933g;
        this.f25933g = max;
        return i11;
    }
}
