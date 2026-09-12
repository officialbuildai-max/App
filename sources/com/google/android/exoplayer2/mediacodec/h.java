package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
final class h extends DecoderInputBuffer {

    /* renamed from: i, reason: collision with root package name */
    private long f25433i;

    /* renamed from: j, reason: collision with root package name */
    private int f25434j;

    /* renamed from: k, reason: collision with root package name */
    private int f25435k;

    public h() {
        super(2);
        this.f25435k = 32;
    }

    private boolean s(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (!w()) {
            return true;
        }
        if (this.f25434j >= this.f25435k || decoderInputBuffer.g() != g()) {
            return false;
        }
        ByteBuffer byteBuffer2 = decoderInputBuffer.f24897c;
        return byteBuffer2 == null || (byteBuffer = this.f24897c) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer, com.google.android.exoplayer2.decoder.a
    public void b() {
        super.b();
        this.f25434j = 0;
    }

    public boolean r(DecoderInputBuffer decoderInputBuffer) {
        com.google.android.exoplayer2.util.a.a(!decoderInputBuffer.o());
        com.google.android.exoplayer2.util.a.a(!decoderInputBuffer.f());
        com.google.android.exoplayer2.util.a.a(!decoderInputBuffer.h());
        if (!s(decoderInputBuffer)) {
            return false;
        }
        int i11 = this.f25434j;
        this.f25434j = i11 + 1;
        if (i11 == 0) {
            this.f24899e = decoderInputBuffer.f24899e;
            if (decoderInputBuffer.j()) {
                k(1);
            }
        }
        if (decoderInputBuffer.g()) {
            k(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer = decoderInputBuffer.f24897c;
        if (byteBuffer != null) {
            m(byteBuffer.remaining());
            this.f24897c.put(byteBuffer);
        }
        this.f25433i = decoderInputBuffer.f24899e;
        return true;
    }

    public long t() {
        return this.f24899e;
    }

    public long u() {
        return this.f25433i;
    }

    public int v() {
        return this.f25434j;
    }

    public boolean w() {
        return this.f25434j > 0;
    }

    public void x(int i11) {
        com.google.android.exoplayer2.util.a.a(i11 > 0);
        this.f25435k = i11;
    }
}
