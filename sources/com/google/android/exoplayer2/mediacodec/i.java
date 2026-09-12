package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.audio.b0;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.o1;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
final class i {

    /* renamed from: a, reason: collision with root package name */
    private long f25436a;

    /* renamed from: b, reason: collision with root package name */
    private long f25437b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f25438c;

    private long a(long j11) {
        return this.f25436a + Math.max(0L, ((this.f25437b - 529) * 1000000) / j11);
    }

    public long b(o1 o1Var) {
        return a(o1Var.f25564z);
    }

    public void c() {
        this.f25436a = 0L;
        this.f25437b = 0L;
        this.f25438c = false;
    }

    public long d(o1 o1Var, DecoderInputBuffer decoderInputBuffer) {
        if (this.f25437b == 0) {
            this.f25436a = decoderInputBuffer.f24899e;
        }
        if (this.f25438c) {
            return decoderInputBuffer.f24899e;
        }
        ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(decoderInputBuffer.f24897c);
        int i11 = 0;
        for (int i12 = 0; i12 < 4; i12++) {
            i11 = (i11 << 8) | (byteBuffer.get(i12) & 255);
        }
        int m11 = b0.m(i11);
        if (m11 != -1) {
            long a11 = a(o1Var.f25564z);
            this.f25437b += m11;
            return a11;
        }
        this.f25438c = true;
        this.f25437b = 0L;
        this.f25436a = decoderInputBuffer.f24899e;
        com.google.android.exoplayer2.util.s.i("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
        return decoderInputBuffer.f24899e;
    }
}
