package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.source.rtsp.u;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
final class i0 extends com.google.android.exoplayer2.upstream.f implements c, u.b {

    /* renamed from: e, reason: collision with root package name */
    private final LinkedBlockingQueue f26479e;

    /* renamed from: f, reason: collision with root package name */
    private final long f26480f;

    /* renamed from: g, reason: collision with root package name */
    private byte[] f26481g;

    /* renamed from: h, reason: collision with root package name */
    private int f26482h;

    public i0(long j11) {
        super(true);
        this.f26480f = j11;
        this.f26479e = new LinkedBlockingQueue();
        this.f26481g = new byte[0];
        this.f26482h = -1;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(com.google.android.exoplayer2.upstream.n nVar) {
        this.f26482h = nVar.f27491a.getPort();
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.c
    public String c() {
        com.google.android.exoplayer2.util.a.g(this.f26482h != -1);
        return p0.C("RTP/AVP/TCP;unicast;interleaved=%d-%d", Integer.valueOf(this.f26482h), Integer.valueOf(this.f26482h + 1));
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
    }

    @Override // com.google.android.exoplayer2.source.rtsp.c
    public int d() {
        return this.f26482h;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.u.b
    public void f(byte[] bArr) {
        this.f26479e.add(bArr);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.c
    public u.b g() {
        return this;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Uri getUri() {
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        int min = Math.min(i12, this.f26481g.length);
        System.arraycopy(this.f26481g, 0, bArr, i11, min);
        byte[] bArr2 = this.f26481g;
        this.f26481g = Arrays.copyOfRange(bArr2, min, bArr2.length);
        if (min == i12) {
            return min;
        }
        try {
            byte[] bArr3 = (byte[]) this.f26479e.poll(this.f26480f, TimeUnit.MILLISECONDS);
            if (bArr3 == null) {
                return -1;
            }
            int min2 = Math.min(i12 - min, bArr3.length);
            System.arraycopy(bArr3, 0, bArr, i11 + min, min2);
            if (min2 < bArr3.length) {
                this.f26481g = Arrays.copyOfRange(bArr3, min2, bArr3.length);
            }
            return min + min2;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return -1;
        }
    }
}
